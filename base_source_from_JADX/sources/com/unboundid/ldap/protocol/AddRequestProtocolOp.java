package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.sdk.Attribute;
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
public final class AddRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = -1195296296055518601L;
    private final List<Attribute> attributes;

    /* renamed from: dn */
    private final String f7260dn;

    AddRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            aSN1StreamReader.beginSequence();
            this.f7260dn = aSN1StreamReader.readString();
            Validator.ensureNotNull(this.f7260dn);
            ArrayList arrayList = new ArrayList(10);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            while (beginSequence.hasMoreElements()) {
                arrayList.add(Attribute.readFrom(aSN1StreamReader));
            }
            this.attributes = Collections.unmodifiableList(arrayList);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_ADD_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public AddRequestProtocolOp(String str, List<Attribute> list) {
        this.f7260dn = str;
        this.attributes = Collections.unmodifiableList(list);
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    public String getDN() {
        return this.f7260dn;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("AddRequestProtocolOp(dn='");
        sb.append(this.f7260dn);
        sb.append("', attrs={");
        Iterator<Attribute> it = this.attributes.iterator();
        while (it.hasNext()) {
            it.next().toString(sb);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append("})");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST);
        aSN1Buffer.addOctetString(this.f7260dn);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        for (Attribute writeTo : this.attributes) {
            writeTo.writeTo(aSN1Buffer);
        }
        beginSequence2.end();
        beginSequence.end();
    }
}
