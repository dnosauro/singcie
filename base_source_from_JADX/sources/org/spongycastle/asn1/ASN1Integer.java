package org.spongycastle.asn1;

import java.math.BigInteger;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Properties;

public class ASN1Integer extends ASN1Primitive {
    private final byte[] bytes;

    public ASN1Integer(long j) {
        this.bytes = BigInteger.valueOf(j).toByteArray();
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public ASN1Integer(byte[] bArr) {
        this(bArr, true);
    }

    ASN1Integer(byte[] bArr, boolean z) {
        if (Properties.isOverrideSet("org.spongycastle.asn1.allow_unsafe_integer") || !isMalformed(bArr)) {
            this.bytes = z ? Arrays.clone(bArr) : bArr;
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }

    public static ASN1Integer getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Integer) fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1Integer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof ASN1Integer)) ? getInstance(object) : new ASN1Integer(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    static boolean isMalformed(byte[] bArr) {
        if (bArr.length > 1) {
            if (bArr[0] == 0 && (bArr[1] & 128) == 0) {
                return true;
            }
            return bArr[0] == -1 && (bArr[1] & 128) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return false;
        }
        return Arrays.areEqual(this.bytes, ((ASN1Integer) aSN1Primitive).bytes);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(2, this.bytes);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getValue().toString();
    }
}
