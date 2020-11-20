package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class ASN1EncodableVector {

    /* renamed from: v */
    private final Vector f7341v = new Vector();

    public void add(ASN1Encodable aSN1Encodable) {
        this.f7341v.addElement(aSN1Encodable);
    }

    public void addAll(ASN1EncodableVector aSN1EncodableVector) {
        Enumeration elements = aSN1EncodableVector.f7341v.elements();
        while (elements.hasMoreElements()) {
            this.f7341v.addElement(elements.nextElement());
        }
    }

    public ASN1Encodable get(int i) {
        return (ASN1Encodable) this.f7341v.elementAt(i);
    }

    public int size() {
        return this.f7341v.size();
    }
}
