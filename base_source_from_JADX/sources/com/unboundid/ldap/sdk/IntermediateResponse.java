package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class IntermediateResponse implements LDAPResponse, Serializable {
    private static final Control[] NO_CONTROLS = new Control[0];
    protected static final byte TYPE_INTERMEDIATE_RESPONSE_OID = Byte.MIN_VALUE;
    protected static final byte TYPE_INTERMEDIATE_RESPONSE_VALUE = -127;
    private static final long serialVersionUID = 218434694212935869L;
    private final Control[] controls;
    private final int messageID;
    private final String oid;
    private final ASN1OctetString value;

    public IntermediateResponse(int i, String str, ASN1OctetString aSN1OctetString) {
        this(i, str, aSN1OctetString, NO_CONTROLS);
    }

    public IntermediateResponse(int i, String str, ASN1OctetString aSN1OctetString, Control[] controlArr) {
        this.messageID = i;
        this.oid = str;
        this.value = aSN1OctetString;
        if (controlArr == null) {
            this.controls = NO_CONTROLS;
        } else {
            this.controls = controlArr;
        }
    }

    protected IntermediateResponse(IntermediateResponse intermediateResponse) {
        this.messageID = intermediateResponse.messageID;
        this.oid = intermediateResponse.oid;
        this.value = intermediateResponse.value;
        this.controls = intermediateResponse.controls;
    }

    public IntermediateResponse(String str, ASN1OctetString aSN1OctetString) {
        this(-1, str, aSN1OctetString, NO_CONTROLS);
    }

    public IntermediateResponse(String str, ASN1OctetString aSN1OctetString, Control[] controlArr) {
        this(-1, str, aSN1OctetString, controlArr);
    }

    static IntermediateResponse readFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        Control[] controlArr;
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            String str = null;
            ASN1OctetString aSN1OctetString = null;
            while (beginSequence.hasMoreElements()) {
                byte peek = (byte) aSN1StreamReader.peek();
                switch (peek) {
                    case Byte.MIN_VALUE:
                        str = aSN1StreamReader.readString();
                        break;
                    case -127:
                        aSN1OctetString = new ASN1OctetString(peek, aSN1StreamReader.readBytes());
                        break;
                }
            }
            if (aSN1StreamReaderSequence.hasMoreElements()) {
                ArrayList arrayList = new ArrayList(1);
                ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                while (beginSequence2.hasMoreElements()) {
                    arrayList.add(Control.readFrom(aSN1StreamReader));
                }
                controlArr = new Control[arrayList.size()];
                arrayList.toArray(controlArr);
            } else {
                controlArr = NO_CONTROLS;
            }
            return new IntermediateResponse(i, str, aSN1OctetString, controlArr);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_INTERMEDIATE_RESPONSE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public final Control getControl(String str) {
        for (Control control : this.controls) {
            if (control.getOID().equals(str)) {
                return control;
            }
        }
        return null;
    }

    public final Control[] getControls() {
        return this.controls;
    }

    public String getIntermediateResponseName() {
        return this.oid;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public final String getOID() {
        return this.oid;
    }

    public final ASN1OctetString getValue() {
        return this.value;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        boolean z;
        sb.append("IntermediateResponse(");
        if (this.messageID >= 0) {
            sb.append("messageID=");
            sb.append(this.messageID);
            z = true;
        } else {
            z = false;
        }
        if (this.oid != null) {
            if (z) {
                sb.append(", ");
            }
            sb.append("oid='");
            sb.append(this.oid);
            sb.append('\'');
            z = true;
        }
        if (this.controls.length > 0) {
            if (z) {
                sb.append(", ");
            }
            sb.append("controls={");
            for (int i = 0; i < this.controls.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(this.controls[i]);
            }
            sb.append('}');
        }
        sb.append(')');
    }

    public String valueToString() {
        return null;
    }
}
