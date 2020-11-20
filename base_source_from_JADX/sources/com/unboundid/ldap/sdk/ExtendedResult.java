package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.util.ArrayList;

public class ExtendedResult extends LDAPResult {
    private static final byte TYPE_EXTENDED_RESPONSE_OID = -118;
    private static final byte TYPE_EXTENDED_RESPONSE_VALUE = -117;
    private static final long serialVersionUID = -6885923482396647963L;
    private final String oid;
    private final ASN1OctetString value;

    public ExtendedResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, String str3, ASN1OctetString aSN1OctetString, Control[] controlArr) {
        super(i, resultCode, str, str2, strArr, controlArr);
        this.oid = str3;
        this.value = aSN1OctetString;
    }

    protected ExtendedResult(ExtendedResult extendedResult) {
        this(extendedResult.getMessageID(), extendedResult.getResultCode(), extendedResult.getDiagnosticMessage(), extendedResult.getMatchedDN(), extendedResult.getReferralURLs(), extendedResult.getOID(), extendedResult.getValue(), extendedResult.getResponseControls());
    }

    public ExtendedResult(LDAPResult lDAPResult) {
        super(lDAPResult);
        this.oid = null;
        this.value = null;
    }

    static ExtendedResult readExtendedResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        Control[] controlArr;
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            ResultCode valueOf = ResultCode.valueOf(aSN1StreamReader.readEnumerated().intValue());
            String readString = aSN1StreamReader.readString();
            String str = readString.length() == 0 ? null : readString;
            String readString2 = aSN1StreamReader.readString();
            String str2 = readString2.length() == 0 ? null : readString2;
            String[] strArr = null;
            String str3 = null;
            ASN1OctetString aSN1OctetString = null;
            while (beginSequence.hasMoreElements()) {
                byte peek = (byte) aSN1StreamReader.peek();
                if (peek != -93) {
                    switch (peek) {
                        case -118:
                            str3 = aSN1StreamReader.readString();
                            break;
                        case -117:
                            aSN1OctetString = new ASN1OctetString(peek, aSN1StreamReader.readBytes());
                            break;
                        default:
                            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_EXTENDED_RESULT_INVALID_ELEMENT.get(StaticUtils.toHex(peek)));
                    }
                } else {
                    ArrayList arrayList = new ArrayList(1);
                    ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                    while (beginSequence2.hasMoreElements()) {
                        arrayList.add(aSN1StreamReader.readString());
                    }
                    strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
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
            return new ExtendedResult(i, valueOf, str2, str, strArr, str3, aSN1OctetString, controlArr);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_EXTENDED_RESULT_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public String getExtendedResultName() {
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ExtendedResult(resultCode=");
        sb.append(getResultCode());
        int messageID = getMessageID();
        if (messageID >= 0) {
            sb.append(", messageID=");
            sb.append(messageID);
        }
        String diagnosticMessage = getDiagnosticMessage();
        if (diagnosticMessage != null) {
            sb.append(", diagnosticMessage='");
            sb.append(diagnosticMessage);
            sb.append('\'');
        }
        String matchedDN = getMatchedDN();
        if (matchedDN != null) {
            sb.append(", matchedDN='");
            sb.append(matchedDN);
            sb.append('\'');
        }
        String[] referralURLs = getReferralURLs();
        if (referralURLs.length > 0) {
            sb.append(", referralURLs={");
            for (int i = 0; i < referralURLs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(referralURLs[i]);
            }
            sb.append('}');
        }
        if (this.oid != null) {
            sb.append(", oid=");
            sb.append(this.oid);
        }
        Control[] responseControls = getResponseControls();
        if (responseControls.length > 0) {
            sb.append(", responseControls={");
            for (int i2 = 0; i2 < responseControls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(responseControls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }
}
