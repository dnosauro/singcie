package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.util.InternalUseOnly;
import java.io.Serializable;

@InternalUseOnly
public interface ProtocolOp extends Serializable {
    byte getProtocolOpType();

    void toString(StringBuilder sb);

    void writeTo(ASN1Buffer aSN1Buffer);
}
