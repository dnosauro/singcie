package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;

@InternalUseOnly
public final class CompareRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = -562642367801440060L;
    private final ASN1OctetString assertionValue;
    private final String attributeName;

    /* renamed from: dn */
    private final String f7261dn;

    CompareRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            aSN1StreamReader.beginSequence();
            this.f7261dn = aSN1StreamReader.readString();
            aSN1StreamReader.beginSequence();
            this.attributeName = aSN1StreamReader.readString();
            this.assertionValue = new ASN1OctetString(aSN1StreamReader.readBytes());
            Validator.ensureNotNull(this.f7261dn, this.attributeName, this.assertionValue);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_COMPARE_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public CompareRequestProtocolOp(String str, String str2, ASN1OctetString aSN1OctetString) {
        this.f7261dn = str;
        this.attributeName = str2;
        this.assertionValue = aSN1OctetString;
    }

    public ASN1OctetString getAssertionValue() {
        return this.assertionValue;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getDN() {
        return this.f7261dn;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("CompareRequestProtocolOp(dn='");
        sb.append(this.f7261dn);
        sb.append("', attributeName='");
        sb.append(this.attributeName);
        sb.append("', assertionValue='");
        sb.append(this.assertionValue.stringValue());
        sb.append("')");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST);
        aSN1Buffer.addOctetString(this.f7261dn);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        aSN1Buffer.addOctetString(this.attributeName);
        aSN1Buffer.addElement(this.assertionValue);
        beginSequence2.end();
        beginSequence.end();
    }
}
