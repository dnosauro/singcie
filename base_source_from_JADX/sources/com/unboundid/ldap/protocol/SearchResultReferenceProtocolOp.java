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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@InternalUseOnly
public final class SearchResultReferenceProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = -1526778443581862609L;
    private final List<String> referralURLs;

    SearchResultReferenceProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            ArrayList arrayList = new ArrayList(5);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            while (beginSequence.hasMoreElements()) {
                arrayList.add(aSN1StreamReader.readString());
            }
            this.referralURLs = Collections.unmodifiableList(arrayList);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_SEARCH_REFERENCE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public SearchResultReferenceProtocolOp(List<String> list) {
        this.referralURLs = Collections.unmodifiableList(list);
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE;
    }

    public List<String> getReferralURLs() {
        return this.referralURLs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("SearchResultReferenceProtocolOp(referralURLs={");
        Iterator<String> it = this.referralURLs.iterator();
        while (it.hasNext()) {
            sb.append('\'');
            sb.append(it.next());
            sb.append('\'');
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append("})");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE);
        for (String addOctetString : this.referralURLs) {
            aSN1Buffer.addOctetString(addOctetString);
        }
        beginSequence.end();
    }
}
