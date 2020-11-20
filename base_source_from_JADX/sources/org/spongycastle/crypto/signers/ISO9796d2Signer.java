package org.spongycastle.crypto.signers;

import com.unboundid.ldap.protocol.LDAPMessage;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;

public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2) {
        this(asymmetricBlockCipher, digest2, false);
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, boolean z) {
        int intValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest2;
        if (z) {
            intValue = 188;
        } else {
            Integer trailer2 = ISOTrailers.getTrailer(digest2);
            if (trailer2 != null) {
                intValue = trailer2.intValue();
            } else {
                throw new IllegalArgumentException("no valid trailer for digest: " + digest2.getAlgorithmName());
            }
        }
        this.trailer = intValue;
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        int i = this.messageLength;
        byte[] bArr3 = this.mBuf;
        boolean z = true;
        if (i > bArr3.length) {
            if (bArr3.length > bArr2.length) {
                z = false;
            }
            for (int i2 = 0; i2 != this.mBuf.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                }
            }
        } else {
            if (i != bArr2.length) {
                z = false;
            }
            for (int i3 = 0; i3 != bArr2.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                }
            }
        }
        return z;
    }

    private boolean returnFalse(byte[] bArr) {
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    public byte[] generateSignature() {
        int i;
        int i2;
        int i3;
        byte[] bArr;
        byte b;
        int digestSize = this.digest.getDigestSize();
        boolean z = true;
        if (this.trailer == 188) {
            byte[] bArr2 = this.block;
            i = (bArr2.length - digestSize) - 1;
            this.digest.doFinal(bArr2, i);
            byte[] bArr3 = this.block;
            bArr3[bArr3.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i2 = 8;
        } else {
            i2 = 16;
            byte[] bArr4 = this.block;
            int length = (bArr4.length - digestSize) - 2;
            this.digest.doFinal(bArr4, length);
            byte[] bArr5 = this.block;
            int i4 = this.trailer;
            bArr5[bArr5.length - 2] = (byte) (i4 >>> 8);
            bArr5[bArr5.length - 1] = (byte) i4;
            i = length;
        }
        int i5 = this.messageLength;
        int i6 = ((((digestSize + i5) * 8) + i2) + 4) - this.keyBits;
        if (i6 > 0) {
            int i7 = i5 - ((i6 + 7) / 8);
            b = LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST;
            i3 = i - i7;
            System.arraycopy(this.mBuf, 0, this.block, i3, i7);
            bArr = new byte[i7];
        } else {
            b = 64;
            i3 = i - i5;
            System.arraycopy(this.mBuf, 0, this.block, i3, i5);
            bArr = new byte[this.messageLength];
        }
        this.recoveredMessage = bArr;
        int i8 = i3 - 1;
        if (i8 > 0) {
            for (int i9 = i8; i9 != 0; i9--) {
                this.block[i9] = -69;
            }
            byte[] bArr6 = this.block;
            bArr6[i8] = (byte) (bArr6[i8] ^ 1);
            bArr6[0] = 11;
            bArr6[0] = (byte) (bArr6[0] | b);
        } else {
            byte[] bArr7 = this.block;
            bArr7[0] = 10;
            bArr7[0] = (byte) (bArr7[0] | b);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr8 = this.block;
        byte[] processBlock = asymmetricBlockCipher.processBlock(bArr8, 0, bArr8.length);
        if ((b & 32) != 0) {
            z = false;
        }
        this.fullMessage = z;
        byte[] bArr9 = this.mBuf;
        byte[] bArr10 = this.recoveredMessage;
        System.arraycopy(bArr9, 0, bArr10, 0, bArr10.length);
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return processBlock;
    }

    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z, rSAKeyParameters);
        this.keyBits = rSAKeyParameters.getModulus().bitLength();
        this.block = new byte[((this.keyBits + 7) / 8)];
        this.mBuf = new byte[(this.trailer == 188 ? (this.block.length - this.digest.getDigestSize()) - 2 : (this.block.length - this.digest.getDigestSize()) - 3)];
        reset();
    }

    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    public void update(byte b) {
        this.digest.update(b);
        int i = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i < bArr.length) {
            bArr[i] = b;
        }
        this.messageLength++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i]);
            i++;
            i2--;
        }
        this.digest.update(bArr, i, i2);
        this.messageLength += i2;
    }

    public void updateWithRecoveredMessage(byte[] bArr) {
        int i;
        byte[] bArr2;
        byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((processBlock[0] & 192) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        } else if (((processBlock[processBlock.length - 1] & 15) ^ 12) == 0) {
            int i2 = 2;
            if (((processBlock[processBlock.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i2 = 1;
            } else {
                byte b = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                Integer trailer2 = ISOTrailers.getTrailer(this.digest);
                if (trailer2 == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                } else if (b != trailer2.intValue()) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + b);
                }
            }
            int i3 = 0;
            while (i3 != processBlock.length && ((processBlock[i3] & 15) ^ 10) != 0) {
                i3++;
            }
            int i4 = i3 + 1;
            int length = ((processBlock.length - i2) - this.digest.getDigestSize()) - i4;
            if (length > 0) {
                if ((processBlock[0] & 32) == 0) {
                    this.fullMessage = true;
                    this.recoveredMessage = new byte[length];
                    bArr2 = this.recoveredMessage;
                    i = bArr2.length;
                } else {
                    this.fullMessage = false;
                    this.recoveredMessage = new byte[length];
                    bArr2 = this.recoveredMessage;
                    i = bArr2.length;
                }
                System.arraycopy(processBlock, i4, bArr2, 0, i);
                this.preSig = bArr;
                this.preBlock = processBlock;
                Digest digest2 = this.digest;
                byte[] bArr3 = this.recoveredMessage;
                digest2.update(bArr3, 0, bArr3.length);
                byte[] bArr4 = this.recoveredMessage;
                this.messageLength = bArr4.length;
                System.arraycopy(bArr4, 0, this.mBuf, 0, bArr4.length);
                return;
            }
            throw new InvalidCipherTextException("malformed block");
        } else {
            throw new InvalidCipherTextException("malformed signature");
        }
    }

    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        int i;
        byte[] bArr3;
        byte[] bArr4 = this.preSig;
        if (bArr4 == null) {
            try {
                bArr2 = this.cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else if (Arrays.areEqual(bArr4, bArr)) {
            bArr2 = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
        } else {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        if (((bArr2[0] & 192) ^ 64) != 0) {
            return returnFalse(bArr2);
        }
        if (((bArr2[bArr2.length - 1] & 15) ^ 12) != 0) {
            return returnFalse(bArr2);
        }
        int i2 = 2;
        if (((bArr2[bArr2.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
            i2 = 1;
        } else {
            byte b = ((bArr2[bArr2.length - 2] & 255) << 8) | (bArr2[bArr2.length - 1] & 255);
            Integer trailer2 = ISOTrailers.getTrailer(this.digest);
            if (trailer2 == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            } else if (b != trailer2.intValue()) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + b);
            }
        }
        int i3 = 0;
        while (i3 != bArr2.length && ((bArr2[i3] & 15) ^ 10) != 0) {
            i3++;
        }
        int i4 = i3 + 1;
        byte[] bArr5 = new byte[this.digest.getDigestSize()];
        int length = (bArr2.length - i2) - bArr5.length;
        int i5 = length - i4;
        if (i5 <= 0) {
            return returnFalse(bArr2);
        }
        if ((bArr2[0] & 32) == 0) {
            this.fullMessage = true;
            if (this.messageLength > i5) {
                return returnFalse(bArr2);
            }
            this.digest.reset();
            this.digest.update(bArr2, i4, i5);
            this.digest.doFinal(bArr5, 0);
            boolean z = true;
            for (int i6 = 0; i6 != bArr5.length; i6++) {
                int i7 = length + i6;
                bArr2[i7] = (byte) (bArr2[i7] ^ bArr5[i6]);
                if (bArr2[i7] != 0) {
                    z = false;
                }
            }
            if (!z) {
                return returnFalse(bArr2);
            }
            this.recoveredMessage = new byte[i5];
            bArr3 = this.recoveredMessage;
            i = bArr3.length;
        } else {
            this.fullMessage = false;
            this.digest.doFinal(bArr5, 0);
            boolean z2 = true;
            for (int i8 = 0; i8 != bArr5.length; i8++) {
                int i9 = length + i8;
                bArr2[i9] = (byte) (bArr2[i9] ^ bArr5[i8]);
                if (bArr2[i9] != 0) {
                    z2 = false;
                }
            }
            if (!z2) {
                return returnFalse(bArr2);
            }
            this.recoveredMessage = new byte[i5];
            bArr3 = this.recoveredMessage;
            i = bArr3.length;
        }
        System.arraycopy(bArr2, i4, bArr3, 0, i);
        if (this.messageLength != 0 && !isSameAs(this.mBuf, this.recoveredMessage)) {
            return returnFalse(bArr2);
        }
        clearBlock(this.mBuf);
        clearBlock(bArr2);
        this.messageLength = 0;
        return true;
    }
}
