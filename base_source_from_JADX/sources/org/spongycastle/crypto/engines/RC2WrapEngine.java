package org.spongycastle.crypto.engines;

import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;

public class RC2WrapEngine implements Wrapper {
    private static final byte[] IV2 = {LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -35, Filter.FILTER_TYPE_NOT, 44, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -24, 33, 5};
    byte[] digest = new byte[20];
    private CBCBlockCipher engine;
    private boolean forWrapping;

    /* renamed from: iv */
    private byte[] f7700iv;
    private CipherParameters param;
    private ParametersWithIV paramPlusIV;
    Digest sha1 = DigestFactory.createSHA1();

    /* renamed from: sr */
    private SecureRandom f7701sr;

    private byte[] calculateCMSKeyChecksum(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.sha1.update(bArr, 0, bArr.length);
        this.sha1.doFinal(this.digest, 0);
        System.arraycopy(this.digest, 0, bArr2, 0, 8);
        return bArr2;
    }

    private boolean checkCMSKeyChecksum(byte[] bArr, byte[] bArr2) {
        return Arrays.constantTimeAreEqual(calculateCMSKeyChecksum(bArr), bArr2);
    }

    public String getAlgorithmName() {
        return "RC2";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        this.engine = new CBCBlockCipher(new RC2Engine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f7701sr = parametersWithRandom.getRandom();
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.f7701sr = new SecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            this.paramPlusIV = (ParametersWithIV) cipherParameters;
            this.f7700iv = this.paramPlusIV.getIV();
            this.param = this.paramPlusIV.getParameters();
            if (this.forWrapping) {
                byte[] bArr = this.f7700iv;
                if (bArr == null || bArr.length != 8) {
                    throw new IllegalArgumentException("IV is not 8 octets");
                }
                return;
            }
            throw new IllegalArgumentException("You should not supply an IV for unwrapping");
        }
        this.param = cipherParameters;
        if (this.forWrapping) {
            this.f7700iv = new byte[8];
            this.f7701sr.nextBytes(this.f7700iv);
            this.paramPlusIV = new ParametersWithIV(this.param, this.f7700iv);
        }
    }

    public byte[] unwrap(byte[] bArr, int i, int i2) {
        if (this.forWrapping) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        } else if (i2 % this.engine.getBlockSize() == 0) {
            this.engine.init(false, new ParametersWithIV(this.param, IV2));
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            for (int i3 = 0; i3 < bArr2.length / this.engine.getBlockSize(); i3++) {
                int blockSize = this.engine.getBlockSize() * i3;
                this.engine.processBlock(bArr2, blockSize, bArr2, blockSize);
            }
            byte[] bArr3 = new byte[bArr2.length];
            int i4 = 0;
            while (i4 < bArr2.length) {
                int i5 = i4 + 1;
                bArr3[i4] = bArr2[bArr2.length - i5];
                i4 = i5;
            }
            this.f7700iv = new byte[8];
            byte[] bArr4 = new byte[(bArr3.length - 8)];
            System.arraycopy(bArr3, 0, this.f7700iv, 0, 8);
            System.arraycopy(bArr3, 8, bArr4, 0, bArr3.length - 8);
            this.paramPlusIV = new ParametersWithIV(this.param, this.f7700iv);
            this.engine.init(false, this.paramPlusIV);
            byte[] bArr5 = new byte[bArr4.length];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
            for (int i6 = 0; i6 < bArr5.length / this.engine.getBlockSize(); i6++) {
                int blockSize2 = this.engine.getBlockSize() * i6;
                this.engine.processBlock(bArr5, blockSize2, bArr5, blockSize2);
            }
            byte[] bArr6 = new byte[(bArr5.length - 8)];
            byte[] bArr7 = new byte[8];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length - 8);
            System.arraycopy(bArr5, bArr5.length - 8, bArr7, 0, 8);
            if (!checkCMSKeyChecksum(bArr6, bArr7)) {
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            } else if (bArr6.length - ((bArr6[0] & 255) + 1) <= 7) {
                byte[] bArr8 = new byte[bArr6[0]];
                System.arraycopy(bArr6, 1, bArr8, 0, bArr8.length);
                return bArr8;
            } else {
                throw new InvalidCipherTextException("too many pad bytes (" + (bArr6.length - ((bArr6[0] & 255) + 1)) + ")");
            }
        } else {
            throw new InvalidCipherTextException("Ciphertext not multiple of " + this.engine.getBlockSize());
        }
    }

    public byte[] wrap(byte[] bArr, int i, int i2) {
        if (this.forWrapping) {
            int i3 = i2 + 1;
            int i4 = i3 % 8;
            byte[] bArr2 = new byte[(i4 != 0 ? (8 - i4) + i3 : i3)];
            bArr2[0] = (byte) i2;
            System.arraycopy(bArr, i, bArr2, 1, i2);
            byte[] bArr3 = new byte[((bArr2.length - i2) - 1)];
            if (bArr3.length > 0) {
                this.f7701sr.nextBytes(bArr3);
                System.arraycopy(bArr3, 0, bArr2, i3, bArr3.length);
            }
            byte[] calculateCMSKeyChecksum = calculateCMSKeyChecksum(bArr2);
            byte[] bArr4 = new byte[(bArr2.length + calculateCMSKeyChecksum.length)];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            System.arraycopy(calculateCMSKeyChecksum, 0, bArr4, bArr2.length, calculateCMSKeyChecksum.length);
            byte[] bArr5 = new byte[bArr4.length];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
            int length = bArr4.length / this.engine.getBlockSize();
            if (bArr4.length % this.engine.getBlockSize() == 0) {
                this.engine.init(true, this.paramPlusIV);
                for (int i5 = 0; i5 < length; i5++) {
                    int blockSize = this.engine.getBlockSize() * i5;
                    this.engine.processBlock(bArr5, blockSize, bArr5, blockSize);
                }
                byte[] bArr6 = this.f7700iv;
                byte[] bArr7 = new byte[(bArr6.length + bArr5.length)];
                System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
                System.arraycopy(bArr5, 0, bArr7, this.f7700iv.length, bArr5.length);
                byte[] bArr8 = new byte[bArr7.length];
                int i6 = 0;
                while (i6 < bArr7.length) {
                    int i7 = i6 + 1;
                    bArr8[i6] = bArr7[bArr7.length - i7];
                    i6 = i7;
                }
                this.engine.init(true, new ParametersWithIV(this.param, IV2));
                for (int i8 = 0; i8 < length + 1; i8++) {
                    int blockSize2 = this.engine.getBlockSize() * i8;
                    this.engine.processBlock(bArr8, blockSize2, bArr8, blockSize2);
                }
                return bArr8;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
