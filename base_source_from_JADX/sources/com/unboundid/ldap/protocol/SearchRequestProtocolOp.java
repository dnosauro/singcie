package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.sdk.DereferencePolicy;
import com.unboundid.ldap.sdk.Filter;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@InternalUseOnly
public final class SearchRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = -8521750809606744181L;
    private final List<String> attributes;
    private final String baseDN;
    private final DereferencePolicy derefPolicy;
    private final Filter filter;
    private final SearchScope scope;
    private final int sizeLimit;
    private final int timeLimit;
    private final boolean typesOnly;

    SearchRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            aSN1StreamReader.beginSequence();
            this.baseDN = aSN1StreamReader.readString();
            this.scope = SearchScope.valueOf(aSN1StreamReader.readEnumerated().intValue());
            this.derefPolicy = DereferencePolicy.valueOf(aSN1StreamReader.readEnumerated().intValue());
            this.sizeLimit = aSN1StreamReader.readInteger().intValue();
            this.timeLimit = aSN1StreamReader.readInteger().intValue();
            this.typesOnly = aSN1StreamReader.readBoolean().booleanValue();
            this.filter = Filter.readFrom(aSN1StreamReader);
            ArrayList arrayList = new ArrayList(5);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            while (beginSequence.hasMoreElements()) {
                arrayList.add(aSN1StreamReader.readString());
            }
            this.attributes = Collections.unmodifiableList(arrayList);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_SEARCH_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public SearchRequestProtocolOp(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter2, List<String> list) {
        this.scope = searchScope;
        this.derefPolicy = dereferencePolicy;
        this.typesOnly = z;
        this.filter = filter2;
        this.baseDN = str == null ? "" : str;
        if (i > 0) {
            this.sizeLimit = i;
        } else {
            this.sizeLimit = 0;
        }
        if (i2 > 0) {
            this.timeLimit = i2;
        } else {
            this.timeLimit = 0;
        }
        this.attributes = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public List<String> getAttributes() {
        return this.attributes;
    }

    public String getBaseDN() {
        return this.baseDN;
    }

    public DereferencePolicy getDerefPolicy() {
        return this.derefPolicy;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST;
    }

    public SearchScope getScope() {
        return this.scope;
    }

    public int getSizeLimit() {
        return this.sizeLimit;
    }

    public int getTimeLimit() {
        return this.timeLimit;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("SearchRequestProtocolOp(baseDN='");
        sb.append(this.baseDN);
        sb.append("', scope='");
        sb.append(this.scope.toString());
        sb.append("', derefPolicy='");
        sb.append(this.derefPolicy.toString());
        sb.append("', sizeLimit=");
        sb.append(this.sizeLimit);
        sb.append(", timeLimit=");
        sb.append(this.timeLimit);
        sb.append(", typesOnly=");
        sb.append(this.typesOnly);
        sb.append(", filter='");
        this.filter.toString(sb);
        sb.append("', attributes={");
        Iterator<String> it = this.attributes.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append("})");
    }

    public boolean typesOnly() {
        return this.typesOnly;
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST);
        aSN1Buffer.addOctetString(this.baseDN);
        aSN1Buffer.addEnumerated(this.scope.intValue());
        aSN1Buffer.addEnumerated(this.derefPolicy.intValue());
        aSN1Buffer.addInteger(this.sizeLimit);
        aSN1Buffer.addInteger(this.timeLimit);
        aSN1Buffer.addBoolean(this.typesOnly);
        this.filter.writeTo(aSN1Buffer);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        for (String addOctetString : this.attributes) {
            aSN1Buffer.addOctetString(addOctetString);
        }
        beginSequence2.end();
        beginSequence.end();
    }
}
