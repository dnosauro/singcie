package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.Modification;
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
public final class ModifyRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = -6294739625253826184L;

    /* renamed from: dn */
    private final String f7264dn;
    private final List<Modification> modifications;

    ModifyRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            aSN1StreamReader.beginSequence();
            this.f7264dn = aSN1StreamReader.readString();
            Validator.ensureNotNull(this.f7264dn);
            ArrayList arrayList = new ArrayList(5);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            while (beginSequence.hasMoreElements()) {
                arrayList.add(Modification.readFrom(aSN1StreamReader));
            }
            this.modifications = Collections.unmodifiableList(arrayList);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_MODIFY_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public ModifyRequestProtocolOp(String str, List<Modification> list) {
        this.f7264dn = str;
        this.modifications = Collections.unmodifiableList(list);
    }

    public String getDN() {
        return this.f7264dn;
    }

    public List<Modification> getModifications() {
        return this.modifications;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ModifyRequestProtocolOp(dn='");
        sb.append(this.f7264dn);
        sb.append("', mods={");
        Iterator<Modification> it = this.modifications.iterator();
        while (it.hasNext()) {
            it.next().toString(sb);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append("})");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST);
        aSN1Buffer.addOctetString(this.f7264dn);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        for (Modification writeTo : this.modifications) {
            writeTo.writeTo(aSN1Buffer);
        }
        beginSequence2.end();
        beginSequence.end();
    }
}
