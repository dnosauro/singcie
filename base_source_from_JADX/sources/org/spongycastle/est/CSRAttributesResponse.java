package org.spongycastle.est;

import java.util.Collection;
import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.est.AttrOrOID;
import org.spongycastle.asn1.est.CsrAttrs;
import org.spongycastle.util.Encodable;

public class CSRAttributesResponse implements Encodable {
    private final CsrAttrs csrAttrs;
    private final HashMap<ASN1ObjectIdentifier, AttrOrOID> index;

    public CSRAttributesResponse(CsrAttrs csrAttrs2) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        HashMap<ASN1ObjectIdentifier, AttrOrOID> hashMap;
        this.csrAttrs = csrAttrs2;
        this.index = new HashMap<>(csrAttrs2.size());
        AttrOrOID[] attrOrOIDs = csrAttrs2.getAttrOrOIDs();
        for (int i = 0; i != attrOrOIDs.length; i++) {
            AttrOrOID attrOrOID = attrOrOIDs[i];
            if (attrOrOID.isOid()) {
                hashMap = this.index;
                aSN1ObjectIdentifier = attrOrOID.getOid();
            } else {
                hashMap = this.index;
                aSN1ObjectIdentifier = attrOrOID.getAttribute().getAttrType();
            }
            hashMap.put(aSN1ObjectIdentifier, attrOrOID);
        }
    }

    public CSRAttributesResponse(byte[] bArr) {
        this(parseBytes(bArr));
    }

    private static CsrAttrs parseBytes(byte[] bArr) {
        try {
            return CsrAttrs.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (Exception e) {
            throw new ESTException("malformed data: " + e.getMessage(), e);
        }
    }

    public byte[] getEncoded() {
        return this.csrAttrs.getEncoded();
    }

    public Collection<ASN1ObjectIdentifier> getRequirements() {
        return this.index.keySet();
    }

    public boolean hasRequirement(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.index.containsKey(aSN1ObjectIdentifier);
    }

    public boolean isAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (this.index.containsKey(aSN1ObjectIdentifier)) {
            return !this.index.get(aSN1ObjectIdentifier).isOid();
        }
        return false;
    }

    public boolean isEmpty() {
        return this.csrAttrs.size() == 0;
    }
}
