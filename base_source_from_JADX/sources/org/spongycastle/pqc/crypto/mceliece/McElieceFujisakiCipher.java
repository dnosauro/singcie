package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.prng.DigestRandomGenerator;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.ByteUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;

public class McElieceFujisakiCipher implements MessageEncryptor {
    private static final String DEFAULT_PRNG_NAME = "SHA1PRNG";
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.1";
    private boolean forEncryption;

    /* renamed from: k */
    private int f8140k;
    McElieceCCA2KeyParameters key;
    private Digest messDigest;

    /* renamed from: n */
    private int f8141n;

    /* renamed from: sr */
    private SecureRandom f8142sr;

    /* renamed from: t */
    private int f8143t;

    private void initCipherDecrypt(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.messDigest = Utils.getDigest(mcElieceCCA2PrivateKeyParameters.getDigest());
        this.f8141n = mcElieceCCA2PrivateKeyParameters.getN();
        this.f8143t = mcElieceCCA2PrivateKeyParameters.getT();
    }

    private void initCipherEncrypt(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        SecureRandom secureRandom = this.f8142sr;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        this.f8142sr = secureRandom;
        this.messDigest = Utils.getDigest(mcElieceCCA2PublicKeyParameters.getDigest());
        this.f8141n = mcElieceCCA2PublicKeyParameters.getN();
        this.f8140k = mcElieceCCA2PublicKeyParameters.getK();
        this.f8143t = mcElieceCCA2PublicKeyParameters.getT();
    }

    public int getKeySize(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f8142sr = parametersWithRandom.getRandom();
                this.key = (McElieceCCA2PublicKeyParameters) parametersWithRandom.getParameters();
            } else {
                this.f8142sr = new SecureRandom();
                this.key = (McElieceCCA2PublicKeyParameters) cipherParameters;
            }
            initCipherEncrypt((McElieceCCA2PublicKeyParameters) this.key);
            return;
        }
        this.key = (McElieceCCA2PrivateKeyParameters) cipherParameters;
        initCipherDecrypt((McElieceCCA2PrivateKeyParameters) this.key);
    }

    public byte[] messageDecrypt(byte[] bArr) {
        if (!this.forEncryption) {
            int i = (this.f8141n + 7) >> 3;
            int length = bArr.length - i;
            byte[][] split = ByteUtils.split(bArr, i);
            byte[] bArr2 = split[0];
            byte[] bArr3 = split[1];
            GF2Vector[] decryptionPrimitive = McElieceCCA2Primitives.decryptionPrimitive((McElieceCCA2PrivateKeyParameters) this.key, GF2Vector.OS2VP(this.f8141n, bArr2));
            byte[] encoded = decryptionPrimitive[0].getEncoded();
            GF2Vector gF2Vector = decryptionPrimitive[1];
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.addSeedMaterial(encoded);
            byte[] bArr4 = new byte[length];
            digestRandomGenerator.nextBytes(bArr4);
            for (int i2 = 0; i2 < length; i2++) {
                bArr4[i2] = (byte) (bArr4[i2] ^ bArr3[i2]);
            }
            byte[] concatenate = ByteUtils.concatenate(encoded, bArr4);
            byte[] bArr5 = new byte[this.messDigest.getDigestSize()];
            this.messDigest.update(concatenate, 0, concatenate.length);
            this.messDigest.doFinal(bArr5, 0);
            if (Conversions.encode(this.f8141n, this.f8143t, bArr5).equals(gF2Vector)) {
                return bArr4;
            }
            throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public byte[] messageEncrypt(byte[] bArr) {
        if (this.forEncryption) {
            GF2Vector gF2Vector = new GF2Vector(this.f8140k, this.f8142sr);
            byte[] encoded = gF2Vector.getEncoded();
            byte[] concatenate = ByteUtils.concatenate(encoded, bArr);
            this.messDigest.update(concatenate, 0, concatenate.length);
            byte[] bArr2 = new byte[this.messDigest.getDigestSize()];
            this.messDigest.doFinal(bArr2, 0);
            byte[] encoded2 = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters) this.key, gF2Vector, Conversions.encode(this.f8141n, this.f8143t, bArr2)).getEncoded();
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.addSeedMaterial(encoded);
            byte[] bArr3 = new byte[bArr.length];
            digestRandomGenerator.nextBytes(bArr3);
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr[i]);
            }
            return ByteUtils.concatenate(encoded2, bArr3);
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
