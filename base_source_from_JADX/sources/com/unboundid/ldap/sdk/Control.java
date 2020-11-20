package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Boolean;
import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1Exception;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class Control implements Serializable {
    private static final byte CONTROLS_TYPE = -96;
    private static final ConcurrentHashMap<String, DecodeableControl> decodeableControlMap = new ConcurrentHashMap<>();
    private static final long serialVersionUID = 4440956109070220054L;
    private final boolean isCritical;
    private final String oid;
    private final ASN1OctetString value;

    static {
        try {
            Class.forName("com.unboundid.ldap.sdk.controls.ControlHelper").getMethod("registerDefaultResponseControls", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
        }
        try {
            Class.forName("com.unboundid.ldap.sdk.unboundidds.controls.ControlHelper").getMethod("registerDefaultResponseControls", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused2) {
            try {
                Class.forName("com.unboundid.ldap.sdk.experimental.ControlHelper").getMethod("registerDefaultResponseControls", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused3) {
            }
        }
    }

    protected Control() {
        this.oid = null;
        this.isCritical = true;
        this.value = null;
    }

    protected Control(Control control) {
        this.oid = control.oid;
        this.isCritical = control.isCritical;
        this.value = control.value;
    }

    public Control(String str) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.isCritical = false;
        this.value = null;
    }

    public Control(String str, boolean z) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.isCritical = z;
        this.value = null;
    }

    public Control(String str, boolean z, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.isCritical = z;
        this.value = aSN1OctetString;
    }

    public static Control decode(ASN1Sequence aSN1Sequence) {
        ASN1Element aSN1Element;
        ASN1Element[] elements = aSN1Sequence.elements();
        boolean z = false;
        if (elements.length < 1 || elements.length > 3) {
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROL_DECODE_INVALID_ELEMENT_COUNT.get(Integer.valueOf(elements.length)));
        }
        String stringValue = ASN1OctetString.decodeAsOctetString(elements[0]).stringValue();
        ASN1OctetString aSN1OctetString = null;
        if (elements.length == 2) {
            byte type = elements[1].getType();
            if (type == 1) {
                try {
                    z = ASN1Boolean.decodeAsBoolean(elements[1]).booleanValue();
                    return decode(stringValue, z, aSN1OctetString);
                } catch (ASN1Exception e) {
                    Debug.debugException(e);
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROL_DECODE_CRITICALITY.get(StaticUtils.getExceptionMessage(e)), e);
                }
            } else if (type == 4) {
                aSN1Element = elements[1];
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROL_INVALID_TYPE.get(StaticUtils.toHex(elements[1].getType())));
            }
        } else {
            if (elements.length == 3) {
                try {
                    z = ASN1Boolean.decodeAsBoolean(elements[1]).booleanValue();
                    aSN1Element = elements[2];
                } catch (ASN1Exception e2) {
                    Debug.debugException(e2);
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROL_DECODE_CRITICALITY.get(StaticUtils.getExceptionMessage(e2)), e2);
                }
            }
            return decode(stringValue, z, aSN1OctetString);
        }
        aSN1OctetString = ASN1OctetString.decodeAsOctetString(aSN1Element);
        return decode(stringValue, z, aSN1OctetString);
    }

    public static Control decode(String str, boolean z, ASN1OctetString aSN1OctetString) {
        DecodeableControl decodeableControl = decodeableControlMap.get(str);
        if (decodeableControl == null) {
            return new Control(str, z, aSN1OctetString);
        }
        try {
            return decodeableControl.decodeControl(str, z, aSN1OctetString);
        } catch (Exception e) {
            Debug.debugException(e);
            return new Control(str, z, aSN1OctetString);
        }
    }

    public static Control[] decodeControls(ASN1Sequence aSN1Sequence) {
        ASN1Element[] elements = aSN1Sequence.elements();
        Control[] controlArr = new Control[elements.length];
        int i = 0;
        while (i < elements.length) {
            try {
                controlArr[i] = decode(ASN1Sequence.decodeAsSequence(elements[i]));
                i++;
            } catch (ASN1Exception e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROLS_DECODE_ELEMENT_NOT_SEQUENCE.get(StaticUtils.getExceptionMessage(e)), e);
            }
        }
        return controlArr;
    }

    public static void deregisterDecodeableControl(String str) {
        decodeableControlMap.remove(str);
    }

    public static ASN1Sequence encodeControls(Control[] controlArr) {
        ASN1Sequence[] aSN1SequenceArr = new ASN1Sequence[controlArr.length];
        for (int i = 0; i < controlArr.length; i++) {
            aSN1SequenceArr[i] = controlArr[i].encode();
        }
        return new ASN1Sequence((byte) -96, (ASN1Element[]) aSN1SequenceArr);
    }

    public static Control readFrom(ASN1StreamReader aSN1StreamReader) {
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            String readString = aSN1StreamReader.readString();
            ASN1OctetString aSN1OctetString = null;
            boolean z = false;
            while (beginSequence.hasMoreElements()) {
                byte peek = (byte) aSN1StreamReader.peek();
                if (peek == 1) {
                    z = aSN1StreamReader.readBoolean().booleanValue();
                } else if (peek == 4) {
                    aSN1OctetString = new ASN1OctetString(aSN1StreamReader.readBytes());
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROL_INVALID_TYPE.get(StaticUtils.toHex(peek)));
                }
            }
            return decode(readString, z, aSN1OctetString);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_CONTROL_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public static void registerDecodeableControl(String str, DecodeableControl decodeableControl) {
        decodeableControlMap.put(str, decodeableControl);
    }

    public final ASN1Sequence encode() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new ASN1OctetString(this.oid));
        boolean z = this.isCritical;
        if (z) {
            arrayList.add(new ASN1Boolean(z));
        }
        ASN1OctetString aSN1OctetString = this.value;
        if (aSN1OctetString != null) {
            arrayList.add(new ASN1OctetString(aSN1OctetString.getValue()));
        }
        return new ASN1Sequence((Collection<? extends ASN1Element>) arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Control)) {
            return false;
        }
        Control control = (Control) obj;
        if (!this.oid.equals(control.oid) || this.isCritical != control.isCritical) {
            return false;
        }
        ASN1OctetString aSN1OctetString = this.value;
        if (aSN1OctetString != null) {
            ASN1OctetString aSN1OctetString2 = control.value;
            return aSN1OctetString2 != null && aSN1OctetString.equals(aSN1OctetString2);
        } else if (control.value != null) {
            return false;
        }
    }

    public String getControlName() {
        return this.oid;
    }

    public final String getOID() {
        return this.oid;
    }

    public final ASN1OctetString getValue() {
        return this.value;
    }

    public final boolean hasValue() {
        return this.value != null;
    }

    public final int hashCode() {
        int hashCode = this.oid.hashCode();
        if (this.isCritical) {
            hashCode++;
        }
        ASN1OctetString aSN1OctetString = this.value;
        return aSN1OctetString != null ? hashCode + aSN1OctetString.hashCode() : hashCode;
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        String str;
        sb.append("Control(oid=");
        sb.append(this.oid);
        sb.append(", isCritical=");
        sb.append(this.isCritical);
        sb.append(", value=");
        if (this.value == null) {
            str = "{null}";
        } else {
            sb.append("{byte[");
            sb.append(this.value.getValue().length);
            str = "]}";
        }
        sb.append(str);
        sb.append(')');
    }

    public final void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence();
        aSN1Buffer.addOctetString(this.oid);
        if (this.isCritical) {
            aSN1Buffer.addBoolean(true);
        }
        ASN1OctetString aSN1OctetString = this.value;
        if (aSN1OctetString != null) {
            aSN1Buffer.addOctetString(aSN1OctetString.getValue());
        }
        beginSequence.end();
    }
}
