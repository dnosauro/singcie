package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@InternalUseOnly
public abstract class GenericResponseProtocolOp implements ProtocolOp {
    public static final byte TYPE_REFERRALS = -93;
    private static final long serialVersionUID = 3837308973105414874L;
    private final String diagnosticMessage;
    private final String matchedDN;
    private final List<String> referralURLs;
    private final int resultCode;
    private final byte type;

    protected GenericResponseProtocolOp(byte b, int i, String str, String str2, List<String> list) {
        this.type = b;
        this.resultCode = i;
        this.matchedDN = str;
        this.diagnosticMessage = str2;
        this.referralURLs = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    protected GenericResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        List<String> emptyList;
        try {
            this.type = (byte) aSN1StreamReader.peek();
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            this.resultCode = aSN1StreamReader.readEnumerated().intValue();
            String readString = aSN1StreamReader.readString();
            Validator.ensureNotNull(readString);
            if (readString.length() == 0) {
                this.matchedDN = null;
            } else {
                this.matchedDN = readString;
            }
            String readString2 = aSN1StreamReader.readString();
            Validator.ensureNotNull(readString2);
            if (readString2.length() == 0) {
                this.diagnosticMessage = null;
            } else {
                this.diagnosticMessage = readString2;
            }
            if (beginSequence.hasMoreElements()) {
                ArrayList arrayList = new ArrayList(1);
                ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                while (beginSequence2.hasMoreElements()) {
                    arrayList.add(aSN1StreamReader.readString());
                }
                emptyList = Collections.unmodifiableList(arrayList);
            } else {
                emptyList = Collections.emptyList();
            }
            this.referralURLs = emptyList;
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_RESPONSE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public final String getDiagnosticMessage() {
        return this.diagnosticMessage;
    }

    public final String getMatchedDN() {
        return this.matchedDN;
    }

    public byte getProtocolOpType() {
        return this.type;
    }

    public final List<String> getReferralURLs() {
        return this.referralURLs;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public final void toString(StringBuilder sb) {
        sb.append("ResponseProtocolOp(type=");
        StaticUtils.toHex(this.type, sb);
        sb.append(", resultCode=");
        sb.append(this.resultCode);
        if (this.matchedDN != null) {
            sb.append(", matchedDN='");
            sb.append(this.matchedDN);
            sb.append('\'');
        }
        if (this.diagnosticMessage != null) {
            sb.append(", diagnosticMessage='");
            sb.append(this.diagnosticMessage);
            sb.append('\'');
        }
        if (!this.referralURLs.isEmpty()) {
            sb.append(", referralURLs={");
            Iterator<String> it = this.referralURLs.iterator();
            while (it.hasNext()) {
                sb.append('\'');
                sb.append(it.next());
                sb.append('\'');
                if (it.hasNext()) {
                    sb.append(',');
                }
            }
            sb.append('}');
        }
        sb.append(')');
    }

    public final void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(this.type);
        aSN1Buffer.addEnumerated(this.resultCode);
        aSN1Buffer.addOctetString(this.matchedDN);
        aSN1Buffer.addOctetString(this.diagnosticMessage);
        if (!this.referralURLs.isEmpty()) {
            ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence((byte) -93);
            for (String addOctetString : this.referralURLs) {
                aSN1Buffer.addOctetString(addOctetString);
            }
            beginSequence2.end();
        }
        beginSequence.end();
    }
}
