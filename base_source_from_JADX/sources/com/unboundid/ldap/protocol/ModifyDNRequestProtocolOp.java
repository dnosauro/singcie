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

@InternalUseOnly
public final class ModifyDNRequestProtocolOp implements ProtocolOp {
    public static final byte TYPE_NEW_SUPERIOR = Byte.MIN_VALUE;
    private static final long serialVersionUID = 7514385089303489375L;
    private final boolean deleteOldRDN;

    /* renamed from: dn */
    private final String f7263dn;
    private final String newRDN;
    private final String newSuperiorDN;

    ModifyDNRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            this.f7263dn = aSN1StreamReader.readString();
            this.newRDN = aSN1StreamReader.readString();
            this.deleteOldRDN = aSN1StreamReader.readBoolean().booleanValue();
            if (beginSequence.hasMoreElements()) {
                this.newSuperiorDN = aSN1StreamReader.readString();
            } else {
                this.newSuperiorDN = null;
            }
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_DELETE_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public ModifyDNRequestProtocolOp(String str, String str2, boolean z, String str3) {
        this.f7263dn = str;
        this.newRDN = str2;
        this.deleteOldRDN = z;
        this.newSuperiorDN = str3;
    }

    public boolean deleteOldRDN() {
        return this.deleteOldRDN;
    }

    public String getDN() {
        return this.f7263dn;
    }

    public String getNewRDN() {
        return this.newRDN;
    }

    public String getNewSuperiorDN() {
        return this.newSuperiorDN;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ModifyDNRequestProtocolOp(dn='");
        sb.append(this.f7263dn);
        sb.append("', newRDN='");
        sb.append(this.newRDN);
        sb.append("', deleteOldRDN=");
        sb.append(this.deleteOldRDN);
        if (this.newSuperiorDN != null) {
            sb.append(", newSuperiorDN='");
            sb.append(this.newSuperiorDN);
            sb.append('\'');
        }
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST);
        aSN1Buffer.addOctetString(this.f7263dn);
        aSN1Buffer.addOctetString(this.newRDN);
        aSN1Buffer.addBoolean(this.deleteOldRDN);
        String str = this.newSuperiorDN;
        if (str != null) {
            aSN1Buffer.addOctetString(Byte.MIN_VALUE, str);
        }
        beginSequence.end();
    }
}
