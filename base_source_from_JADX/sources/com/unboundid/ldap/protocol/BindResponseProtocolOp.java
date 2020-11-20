package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1OctetString;
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
public final class BindResponseProtocolOp implements ProtocolOp {
    public static final byte TYPE_SERVER_SASL_CREDENTIALS = -121;
    private static final long serialVersionUID = -7757619031268544913L;
    private final String diagnosticMessage;
    private final String matchedDN;
    private final List<String> referralURLs;
    private final int resultCode;
    private final ASN1OctetString serverSASLCredentials;

    public BindResponseProtocolOp(int i, String str, String str2, List<String> list, ASN1OctetString aSN1OctetString) {
        this.resultCode = i;
        this.matchedDN = str;
        this.diagnosticMessage = str2;
        this.referralURLs = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.serverSASLCredentials = aSN1OctetString == null ? null : new ASN1OctetString((byte) -121, aSN1OctetString.getValue());
    }

    BindResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            this.resultCode = aSN1StreamReader.readEnumerated().intValue();
            String readString = aSN1StreamReader.readString();
            Validator.ensureNotNull(readString);
            ASN1OctetString aSN1OctetString = null;
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
            ArrayList arrayList = new ArrayList(1);
            while (beginSequence.hasMoreElements()) {
                byte peek = (byte) aSN1StreamReader.peek();
                if (peek == -93) {
                    ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                    while (beginSequence2.hasMoreElements()) {
                        arrayList.add(aSN1StreamReader.readString());
                    }
                } else if (peek == -121) {
                    aSN1OctetString = new ASN1OctetString(peek, aSN1StreamReader.readBytes());
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_BIND_RESPONSE_INVALID_ELEMENT.get(StaticUtils.toHex(peek)));
                }
            }
            this.referralURLs = Collections.unmodifiableList(arrayList);
            this.serverSASLCredentials = aSN1OctetString;
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_BIND_RESPONSE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public String getDiagnosticMessage() {
        return this.diagnosticMessage;
    }

    public String getMatchedDN() {
        return this.matchedDN;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE;
    }

    public List<String> getReferralURLs() {
        return this.referralURLs;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public ASN1OctetString getServerSASLCredentials() {
        return this.serverSASLCredentials;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("BindResponseProtocolOp(resultCode=");
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

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE);
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
        ASN1OctetString aSN1OctetString = this.serverSASLCredentials;
        if (aSN1OctetString != null) {
            aSN1Buffer.addElement(aSN1OctetString);
        }
        beginSequence.end();
    }
}
