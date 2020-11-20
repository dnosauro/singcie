package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.util.Pack;

public class DHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;

    /* renamed from: z */
    private byte[] f7469z;

    public DHKEKGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        int i4 = i;
        if (bArr2.length - i3 >= i4) {
            long j = (long) i3;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i5 = (int) (((j + j2) - 1) / j2);
                byte[] bArr3 = new byte[this.digest.getDigestSize()];
                int i6 = 0;
                int i7 = i3;
                int i8 = i4;
                int i9 = 0;
                int i10 = 1;
                while (i9 < i5) {
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.f7469z;
                    digest2.update(bArr4, i6, bArr4.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.algorithm);
                    aSN1EncodableVector2.add(new DEROctetString(Pack.intToBigEndian(i10)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr5 = this.partyAInfo;
                    if (bArr5 != null) {
                        aSN1EncodableVector.add(new DERTaggedObject(true, i6, new DEROctetString(bArr5)));
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
                    try {
                        byte[] encoded = new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
                        this.digest.update(encoded, 0, encoded.length);
                        this.digest.doFinal(bArr3, 0);
                        if (i7 > digestSize) {
                            System.arraycopy(bArr3, 0, bArr2, i8, digestSize);
                            i8 += digestSize;
                            i7 -= digestSize;
                        } else {
                            System.arraycopy(bArr3, 0, bArr2, i8, i7);
                        }
                        i10++;
                        i9++;
                        i6 = 0;
                    } catch (IOException e) {
                        throw new IllegalArgumentException("unable to encode parameter info: " + e.getMessage());
                    }
                }
                this.digest.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f7469z = dHKDFParameters.getZ();
        this.partyAInfo = dHKDFParameters.getExtraInfo();
    }
}
