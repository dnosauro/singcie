package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.util.ArrayList;

public class BindResult extends LDAPResult {
    private static final byte TYPE_SERVER_SASL_CREDENTIALS = -121;
    private static final long serialVersionUID = 2211625049303605730L;
    private final ASN1OctetString serverSASLCredentials;

    public BindResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, Control[] controlArr) {
        this(i, resultCode, str, str2, strArr, controlArr, (ASN1OctetString) null);
    }

    public BindResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, Control[] controlArr, ASN1OctetString aSN1OctetString) {
        super(i, resultCode, str, str2, strArr, controlArr);
        this.serverSASLCredentials = aSN1OctetString;
    }

    protected BindResult(BindResult bindResult) {
        super(bindResult);
        this.serverSASLCredentials = bindResult.serverSASLCredentials;
    }

    public BindResult(LDAPResult lDAPResult) {
        super(lDAPResult);
        this.serverSASLCredentials = null;
    }

    static BindResult readBindResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        Control[] controlArr;
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            ResultCode valueOf = ResultCode.valueOf(aSN1StreamReader.readEnumerated().intValue());
            String readString = aSN1StreamReader.readString();
            String str = readString.length() == 0 ? null : readString;
            String readString2 = aSN1StreamReader.readString();
            String str2 = readString2.length() == 0 ? null : readString2;
            String[] strArr = null;
            ASN1OctetString aSN1OctetString = null;
            while (beginSequence.hasMoreElements()) {
                byte peek = (byte) aSN1StreamReader.peek();
                if (peek == -121) {
                    aSN1OctetString = new ASN1OctetString(peek, aSN1StreamReader.readBytes());
                } else if (peek == -93) {
                    ArrayList arrayList = new ArrayList(1);
                    ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                    while (beginSequence2.hasMoreElements()) {
                        arrayList.add(aSN1StreamReader.readString());
                    }
                    strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_BIND_RESULT_INVALID_ELEMENT.get(StaticUtils.toHex(peek)));
                }
            }
            Control[] controlArr2 = NO_CONTROLS;
            if (aSN1StreamReaderSequence.hasMoreElements()) {
                ArrayList arrayList2 = new ArrayList(1);
                ASN1StreamReaderSequence beginSequence3 = aSN1StreamReader.beginSequence();
                while (beginSequence3.hasMoreElements()) {
                    arrayList2.add(Control.readFrom(aSN1StreamReader));
                }
                Control[] controlArr3 = new Control[arrayList2.size()];
                arrayList2.toArray(controlArr3);
                controlArr = controlArr3;
            } else {
                controlArr = controlArr2;
            }
            return new BindResult(i, valueOf, str2, str, strArr, controlArr, aSN1OctetString);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_BIND_RESULT_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public ASN1OctetString getServerSASLCredentials() {
        return this.serverSASLCredentials;
    }
}
