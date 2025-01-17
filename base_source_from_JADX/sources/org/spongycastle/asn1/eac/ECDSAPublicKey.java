package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;

public class ECDSAPublicKey extends PublicKeyDataObject {

    /* renamed from: A */
    private static final int f7361A = 2;

    /* renamed from: B */
    private static final int f7362B = 4;

    /* renamed from: F */
    private static final int f7363F = 64;

    /* renamed from: G */
    private static final int f7364G = 8;

    /* renamed from: P */
    private static final int f7365P = 1;

    /* renamed from: R */
    private static final int f7366R = 16;

    /* renamed from: Y */
    private static final int f7367Y = 32;
    private byte[] basePointG;
    private BigInteger cofactorF;
    private BigInteger firstCoefA;
    private int options;
    private BigInteger orderOfBasePointR;
    private BigInteger primeModulusP;
    private byte[] publicPointY;
    private BigInteger secondCoefB;
    private ASN1ObjectIdentifier usage;

    public ECDSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, BigInteger bigInteger4, byte[] bArr2, int i) {
        this.usage = aSN1ObjectIdentifier;
        setPrimeModulusP(bigInteger);
        setFirstCoefA(bigInteger2);
        setSecondCoefB(bigInteger3);
        setBasePointG(new DEROctetString(bArr));
        setOrderOfBasePointR(bigInteger4);
        setPublicPointY(new DEROctetString(bArr2));
        setCofactorF(BigInteger.valueOf((long) i));
    }

    public ECDSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.usage = aSN1ObjectIdentifier;
        setPublicPointY(new DEROctetString(bArr));
    }

    ECDSAPublicKey(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.usage = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        this.options = 0;
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) nextElement;
                switch (aSN1TaggedObject.getTagNo()) {
                    case 1:
                        setPrimeModulusP(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 2:
                        setFirstCoefA(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 3:
                        setSecondCoefB(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 4:
                        setBasePointG(ASN1OctetString.getInstance(aSN1TaggedObject, false));
                        break;
                    case 5:
                        setOrderOfBasePointR(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    case 6:
                        setPublicPointY(ASN1OctetString.getInstance(aSN1TaggedObject, false));
                        break;
                    case 7:
                        setCofactorF(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                        break;
                    default:
                        this.options = 0;
                        throw new IllegalArgumentException("Unknown Object Identifier!");
                }
            } else {
                throw new IllegalArgumentException("Unknown Object Identifier!");
            }
        }
        int i = this.options;
        if (i != 32 && i != 127) {
            throw new IllegalArgumentException("All options must be either present or absent!");
        }
    }

    private void setBasePointG(ASN1OctetString aSN1OctetString) {
        int i = this.options;
        if ((i & 8) == 0) {
            this.options = i | 8;
            this.basePointG = aSN1OctetString.getOctets();
            return;
        }
        throw new IllegalArgumentException("Base Point G already set");
    }

    private void setCofactorF(BigInteger bigInteger) {
        int i = this.options;
        if ((i & 64) == 0) {
            this.options = i | 64;
            this.cofactorF = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Cofactor F already set");
    }

    private void setFirstCoefA(BigInteger bigInteger) {
        int i = this.options;
        if ((i & 2) == 0) {
            this.options = i | 2;
            this.firstCoefA = bigInteger;
            return;
        }
        throw new IllegalArgumentException("First Coef A already set");
    }

    private void setOrderOfBasePointR(BigInteger bigInteger) {
        int i = this.options;
        if ((i & 16) == 0) {
            this.options = i | 16;
            this.orderOfBasePointR = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Order of base point R already set");
    }

    private void setPrimeModulusP(BigInteger bigInteger) {
        int i = this.options;
        if ((i & 1) == 0) {
            this.options = i | 1;
            this.primeModulusP = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Prime Modulus P already set");
    }

    private void setPublicPointY(ASN1OctetString aSN1OctetString) {
        int i = this.options;
        if ((i & 32) == 0) {
            this.options = i | 32;
            this.publicPointY = aSN1OctetString.getOctets();
            return;
        }
        throw new IllegalArgumentException("Public Point Y already set");
    }

    private void setSecondCoefB(BigInteger bigInteger) {
        int i = this.options;
        if ((i & 4) == 0) {
            this.options = i | 4;
            this.secondCoefB = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Second Coef B already set");
    }

    public ASN1EncodableVector getASN1EncodableVector(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(aSN1ObjectIdentifier);
        if (!z) {
            aSN1EncodableVector.add(new UnsignedInteger(1, getPrimeModulusP()));
            aSN1EncodableVector.add(new UnsignedInteger(2, getFirstCoefA()));
            aSN1EncodableVector.add(new UnsignedInteger(3, getSecondCoefB()));
            aSN1EncodableVector.add(new DERTaggedObject(false, 4, new DEROctetString(getBasePointG())));
            aSN1EncodableVector.add(new UnsignedInteger(5, getOrderOfBasePointR()));
        }
        aSN1EncodableVector.add(new DERTaggedObject(false, 6, new DEROctetString(getPublicPointY())));
        if (!z) {
            aSN1EncodableVector.add(new UnsignedInteger(7, getCofactorF()));
        }
        return aSN1EncodableVector;
    }

    public byte[] getBasePointG() {
        if ((this.options & 8) != 0) {
            return Arrays.clone(this.basePointG);
        }
        return null;
    }

    public BigInteger getCofactorF() {
        if ((this.options & 64) != 0) {
            return this.cofactorF;
        }
        return null;
    }

    public BigInteger getFirstCoefA() {
        if ((this.options & 2) != 0) {
            return this.firstCoefA;
        }
        return null;
    }

    public BigInteger getOrderOfBasePointR() {
        if ((this.options & 16) != 0) {
            return this.orderOfBasePointR;
        }
        return null;
    }

    public BigInteger getPrimeModulusP() {
        if ((this.options & 1) != 0) {
            return this.primeModulusP;
        }
        return null;
    }

    public byte[] getPublicPointY() {
        if ((this.options & 32) != 0) {
            return Arrays.clone(this.publicPointY);
        }
        return null;
    }

    public BigInteger getSecondCoefB() {
        if ((this.options & 4) != 0) {
            return this.secondCoefB;
        }
        return null;
    }

    public ASN1ObjectIdentifier getUsage() {
        return this.usage;
    }

    public boolean hasParameters() {
        return this.primeModulusP != null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(getASN1EncodableVector(this.usage, !hasParameters()));
    }
}
