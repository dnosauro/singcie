package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Attribute;
import org.spongycastle.asn1.x509.AttributeCertificate;

public class SignerAttribute extends ASN1Object {
    private Object[] values;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SignerAttribute(org.spongycastle.asn1.ASN1Sequence r7) {
        /*
            r6 = this;
            r6.<init>()
            int r0 = r7.size()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r6.values = r0
            java.util.Enumeration r7 = r7.getObjects()
            r0 = 0
            r1 = 0
        L_0x0011:
            boolean r2 = r7.hasMoreElements()
            if (r2 == 0) goto L_0x0076
            java.lang.Object r2 = r7.nextElement()
            org.spongycastle.asn1.ASN1TaggedObject r2 = org.spongycastle.asn1.ASN1TaggedObject.getInstance(r2)
            int r3 = r2.getTagNo()
            r4 = 1
            if (r3 != 0) goto L_0x0046
            org.spongycastle.asn1.ASN1Sequence r2 = org.spongycastle.asn1.ASN1Sequence.getInstance(r2, r4)
            int r3 = r2.size()
            org.spongycastle.asn1.x509.Attribute[] r3 = new org.spongycastle.asn1.x509.Attribute[r3]
            r4 = 0
        L_0x0031:
            int r5 = r3.length
            if (r4 == r5) goto L_0x0041
            org.spongycastle.asn1.ASN1Encodable r5 = r2.getObjectAt(r4)
            org.spongycastle.asn1.x509.Attribute r5 = org.spongycastle.asn1.x509.Attribute.getInstance(r5)
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0031
        L_0x0041:
            java.lang.Object[] r2 = r6.values
            r2[r1] = r3
            goto L_0x0058
        L_0x0046:
            int r3 = r2.getTagNo()
            if (r3 != r4) goto L_0x005b
            java.lang.Object[] r3 = r6.values
            org.spongycastle.asn1.ASN1Sequence r2 = org.spongycastle.asn1.ASN1Sequence.getInstance(r2, r4)
            org.spongycastle.asn1.x509.AttributeCertificate r2 = org.spongycastle.asn1.x509.AttributeCertificate.getInstance(r2)
            r3[r1] = r2
        L_0x0058:
            int r1 = r1 + 1
            goto L_0x0011
        L_0x005b:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "illegal tag: "
            r0.append(r1)
            int r1 = r2.getTagNo()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.esf.SignerAttribute.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    public SignerAttribute(AttributeCertificate attributeCertificate) {
        this.values = new Object[1];
        this.values[0] = attributeCertificate;
    }

    public SignerAttribute(Attribute[] attributeArr) {
        this.values = new Object[1];
        this.values[0] = attributeArr;
    }

    public static SignerAttribute getInstance(Object obj) {
        if (obj instanceof SignerAttribute) {
            return (SignerAttribute) obj;
        }
        if (obj != null) {
            return new SignerAttribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Object[] getValues() {
        Object[] objArr = this.values;
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr2.length);
        return objArr2;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            Object[] objArr = this.values;
            if (i == objArr.length) {
                return new DERSequence(aSN1EncodableVector);
            }
            aSN1EncodableVector.add(objArr[i] instanceof Attribute[] ? new DERTaggedObject(0, new DERSequence((ASN1Encodable[]) (Attribute[]) objArr[i])) : new DERTaggedObject(1, (AttributeCertificate) objArr[i]));
            i++;
        }
    }
}
