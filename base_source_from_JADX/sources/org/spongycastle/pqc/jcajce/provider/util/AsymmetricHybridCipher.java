package org.spongycastle.pqc.jcajce.provider.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    protected AlgorithmParameterSpec paramSpec;

    /* access modifiers changed from: protected */
    public abstract int decryptOutputSize(int i);

    public final int doFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr2.length >= getOutputSize(i2)) {
            byte[] doFinal = doFinal(bArr, i, i2);
            System.arraycopy(doFinal, 0, bArr2, i3, doFinal.length);
            return doFinal.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }

    public abstract byte[] doFinal(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract int encryptOutputSize(int i);

    public final int getBlockSize() {
        return 0;
    }

    public final byte[] getIV() {
        return null;
    }

    public final int getOutputSize(int i) {
        return this.opMode == 1 ? encryptOutputSize(i) : decryptOutputSize(i);
    }

    public final AlgorithmParameterSpec getParameters() {
        return this.paramSpec;
    }

    /* access modifiers changed from: protected */
    public abstract void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec);

    /* access modifiers changed from: protected */
    public abstract void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    public final void initDecrypt(Key key) {
        try {
            initDecrypt(key, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.opMode = 2;
        initCipherDecrypt(key, algorithmParameterSpec);
    }

    public final void initEncrypt(Key key) {
        try {
            initEncrypt(key, (AlgorithmParameterSpec) null, new SecureRandom());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key, SecureRandom secureRandom) {
        try {
            initEncrypt(key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        initEncrypt(key, algorithmParameterSpec, new SecureRandom());
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.opMode = 1;
        initCipherEncrypt(key, algorithmParameterSpec, secureRandom);
    }

    /* access modifiers changed from: protected */
    public final void setMode(String str) {
    }

    /* access modifiers changed from: protected */
    public final void setPadding(String str) {
    }

    public final int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr2.length >= getOutputSize(i2)) {
            byte[] update = update(bArr, i, i2);
            System.arraycopy(update, 0, bArr2, i3, update.length);
            return update.length;
        }
        throw new ShortBufferException("output");
    }

    public abstract byte[] update(byte[] bArr, int i, int i2);
}
