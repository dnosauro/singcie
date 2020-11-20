package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.jce.spec.IESParameterSpec;

public class IESUtil {
    public static IESParameterSpec guessParameterSpec(BufferedBlockCipher bufferedBlockCipher, byte[] bArr) {
        if (bufferedBlockCipher == null) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 128);
        }
        BlockCipher underlyingCipher = bufferedBlockCipher.getUnderlyingCipher();
        return (underlyingCipher.getAlgorithmName().equals("DES") || underlyingCipher.getAlgorithmName().equals("RC2") || underlyingCipher.getAlgorithmName().equals("RC5-32") || underlyingCipher.getAlgorithmName().equals("RC5-64")) ? new IESParameterSpec((byte[]) null, (byte[]) null, 64, 64, bArr) : underlyingCipher.getAlgorithmName().equals("SKIPJACK") ? new IESParameterSpec((byte[]) null, (byte[]) null, 80, 80, bArr) : underlyingCipher.getAlgorithmName().equals("GOST28147") ? new IESParameterSpec((byte[]) null, (byte[]) null, 256, 256, bArr) : new IESParameterSpec((byte[]) null, (byte[]) null, 128, 128, bArr);
    }
}