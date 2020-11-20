package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class IESEngine {

    /* renamed from: IV */
    private byte[] f7695IV;

    /* renamed from: V */
    byte[] f7696V;
    BasicAgreement agree;
    BufferedBlockCipher cipher;
    boolean forEncryption;
    DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;
    Mac mac;
    byte[] macBuf;
    IESParameters param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.cipher = null;
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }

    private byte[] decryptBlock(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2;
        byte[] bArr3;
        if (i2 >= this.f7696V.length + this.mac.getMacSize()) {
            if (this.cipher == null) {
                byte[] bArr4 = new byte[((i2 - this.f7696V.length) - this.mac.getMacSize())];
                bArr2 = new byte[(this.param.getMacKeySize() / 8)];
                byte[] bArr5 = new byte[(bArr4.length + bArr2.length)];
                this.kdf.generateBytes(bArr5, 0, bArr5.length);
                if (this.f7696V.length != 0) {
                    System.arraycopy(bArr5, 0, bArr2, 0, bArr2.length);
                    System.arraycopy(bArr5, bArr2.length, bArr4, 0, bArr4.length);
                } else {
                    System.arraycopy(bArr5, 0, bArr4, 0, bArr4.length);
                    System.arraycopy(bArr5, bArr4.length, bArr2, 0, bArr2.length);
                }
                byte[] bArr6 = new byte[bArr4.length];
                for (int i4 = 0; i4 != bArr4.length; i4++) {
                    bArr6[i4] = (byte) (bArr[(this.f7696V.length + i) + i4] ^ bArr4[i4]);
                }
                bArr3 = bArr6;
                i3 = 0;
            } else {
                byte[] bArr7 = new byte[(((IESWithCipherParameters) this.param).getCipherKeySize() / 8)];
                bArr2 = new byte[(this.param.getMacKeySize() / 8)];
                byte[] bArr8 = new byte[(bArr7.length + bArr2.length)];
                this.kdf.generateBytes(bArr8, 0, bArr8.length);
                System.arraycopy(bArr8, 0, bArr7, 0, bArr7.length);
                System.arraycopy(bArr8, bArr7.length, bArr2, 0, bArr2.length);
                CipherParameters keyParameter = new KeyParameter(bArr7);
                byte[] bArr9 = this.f7695IV;
                if (bArr9 != null) {
                    keyParameter = new ParametersWithIV(keyParameter, bArr9);
                }
                this.cipher.init(false, keyParameter);
                bArr3 = new byte[this.cipher.getOutputSize((i2 - this.f7696V.length) - this.mac.getMacSize())];
                BufferedBlockCipher bufferedBlockCipher = this.cipher;
                byte[] bArr10 = this.f7696V;
                i3 = bufferedBlockCipher.processBytes(bArr, bArr10.length + i, (i2 - bArr10.length) - this.mac.getMacSize(), bArr3, 0);
            }
            byte[] encodingV = this.param.getEncodingV();
            byte[] bArr11 = null;
            if (this.f7696V.length != 0) {
                bArr11 = getLengthTag(encodingV);
            }
            int i5 = i + i2;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 - this.mac.getMacSize(), i5);
            byte[] bArr12 = new byte[copyOfRange.length];
            this.mac.init(new KeyParameter(bArr2));
            Mac mac2 = this.mac;
            byte[] bArr13 = this.f7696V;
            mac2.update(bArr, i + bArr13.length, (i2 - bArr13.length) - bArr12.length);
            if (encodingV != null) {
                this.mac.update(encodingV, 0, encodingV.length);
            }
            if (this.f7696V.length != 0) {
                this.mac.update(bArr11, 0, bArr11.length);
            }
            this.mac.doFinal(bArr12, 0);
            if (Arrays.constantTimeAreEqual(copyOfRange, bArr12)) {
                BufferedBlockCipher bufferedBlockCipher2 = this.cipher;
                return bufferedBlockCipher2 == null ? bArr3 : Arrays.copyOfRange(bArr3, 0, i3 + bufferedBlockCipher2.doFinal(bArr3, i3));
            }
            throw new InvalidCipherTextException("invalid MAC");
        }
        throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
    }

    private byte[] encryptBlock(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        byte[] bArr3;
        CipherParameters cipherParameters;
        BufferedBlockCipher bufferedBlockCipher;
        if (this.cipher == null) {
            byte[] bArr4 = new byte[i2];
            bArr2 = new byte[(this.param.getMacKeySize() / 8)];
            byte[] bArr5 = new byte[(bArr4.length + bArr2.length)];
            this.kdf.generateBytes(bArr5, 0, bArr5.length);
            if (this.f7696V.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr5, bArr2.length, bArr4, 0, bArr4.length);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, bArr4.length);
                System.arraycopy(bArr5, i2, bArr2, 0, bArr2.length);
            }
            byte[] bArr6 = new byte[i2];
            for (int i3 = 0; i3 != i2; i3++) {
                bArr6[i3] = (byte) (bArr[i + i3] ^ bArr4[i3]);
            }
            bArr3 = bArr6;
        } else {
            byte[] bArr7 = new byte[(((IESWithCipherParameters) this.param).getCipherKeySize() / 8)];
            bArr2 = new byte[(this.param.getMacKeySize() / 8)];
            byte[] bArr8 = new byte[(bArr7.length + bArr2.length)];
            this.kdf.generateBytes(bArr8, 0, bArr8.length);
            System.arraycopy(bArr8, 0, bArr7, 0, bArr7.length);
            System.arraycopy(bArr8, bArr7.length, bArr2, 0, bArr2.length);
            if (this.f7695IV != null) {
                bufferedBlockCipher = this.cipher;
                cipherParameters = new ParametersWithIV(new KeyParameter(bArr7), this.f7695IV);
            } else {
                bufferedBlockCipher = this.cipher;
                cipherParameters = new KeyParameter(bArr7);
            }
            bufferedBlockCipher.init(true, cipherParameters);
            bArr3 = new byte[this.cipher.getOutputSize(i2)];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr3, 0);
            i2 = processBytes + this.cipher.doFinal(bArr3, processBytes);
        }
        byte[] encodingV = this.param.getEncodingV();
        byte[] bArr9 = null;
        if (this.f7696V.length != 0) {
            bArr9 = getLengthTag(encodingV);
        }
        byte[] bArr10 = new byte[this.mac.getMacSize()];
        this.mac.init(new KeyParameter(bArr2));
        this.mac.update(bArr3, 0, bArr3.length);
        if (encodingV != null) {
            this.mac.update(encodingV, 0, encodingV.length);
        }
        if (this.f7696V.length != 0) {
            this.mac.update(bArr9, 0, bArr9.length);
        }
        this.mac.doFinal(bArr10, 0);
        byte[] bArr11 = this.f7696V;
        byte[] bArr12 = new byte[(bArr11.length + i2 + bArr10.length)];
        System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
        System.arraycopy(bArr3, 0, bArr12, this.f7696V.length, i2);
        System.arraycopy(bArr10, 0, bArr12, this.f7696V.length + i2, bArr10.length);
        return bArr12;
    }

    private void extractParams(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f7695IV = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            this.f7695IV = null;
        }
        this.param = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.cipher;
    }

    /* access modifiers changed from: protected */
    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.longToBigEndian(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public Mac getMac() {
        return this.mac;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser2) {
        this.forEncryption = false;
        this.privParam = asymmetricKeyParameter;
        this.keyParser = keyParser2;
        extractParams(cipherParameters);
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
        extractParams(cipherParameters);
    }

    public void init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.f7696V = new byte[0];
        extractParams(cipherParameters3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ad A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b2 A[Catch:{ all -> 0x00ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] processBlock(byte[] r5, int r6, int r7) {
        /*
            r4 = this;
            boolean r0 = r4.forEncryption
            if (r0 == 0) goto L_0x001d
            org.spongycastle.crypto.generators.EphemeralKeyPairGenerator r0 = r4.keyPairGenerator
            if (r0 == 0) goto L_0x0072
            org.spongycastle.crypto.EphemeralKeyPair r0 = r0.generate()
            org.spongycastle.crypto.AsymmetricCipherKeyPair r1 = r0.getKeyPair()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r1 = r1.getPrivate()
            r4.privParam = r1
            byte[] r0 = r0.getEncodedPublicKey()
        L_0x001a:
            r4.f7696V = r0
            goto L_0x0072
        L_0x001d:
            org.spongycastle.crypto.KeyParser r0 = r4.keyParser
            if (r0 == 0) goto L_0x0072
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r5, r6, r7)
            org.spongycastle.crypto.KeyParser r1 = r4.keyParser     // Catch:{ IOException -> 0x0056, IllegalArgumentException -> 0x003a }
            org.spongycastle.crypto.params.AsymmetricKeyParameter r1 = r1.readKey(r0)     // Catch:{ IOException -> 0x0056, IllegalArgumentException -> 0x003a }
            r4.pubParam = r1     // Catch:{ IOException -> 0x0056, IllegalArgumentException -> 0x003a }
            int r0 = r0.available()
            int r0 = r7 - r0
            int r0 = r0 + r6
            byte[] r0 = org.spongycastle.util.Arrays.copyOfRange((byte[]) r5, (int) r6, (int) r0)
            goto L_0x001a
        L_0x003a:
            r5 = move-exception
            org.spongycastle.crypto.InvalidCipherTextException r6 = new org.spongycastle.crypto.InvalidCipherTextException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "unable to recover ephemeral public key: "
            r7.append(r0)
            java.lang.String r0 = r5.getMessage()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7, r5)
            throw r6
        L_0x0056:
            r5 = move-exception
            org.spongycastle.crypto.InvalidCipherTextException r6 = new org.spongycastle.crypto.InvalidCipherTextException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "unable to recover ephemeral public key: "
            r7.append(r0)
            java.lang.String r0 = r5.getMessage()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7, r5)
            throw r6
        L_0x0072:
            org.spongycastle.crypto.BasicAgreement r0 = r4.agree
            org.spongycastle.crypto.CipherParameters r1 = r4.privParam
            r0.init(r1)
            org.spongycastle.crypto.BasicAgreement r0 = r4.agree
            org.spongycastle.crypto.CipherParameters r1 = r4.pubParam
            java.math.BigInteger r0 = r0.calculateAgreement(r1)
            org.spongycastle.crypto.BasicAgreement r1 = r4.agree
            int r1 = r1.getFieldSize()
            byte[] r0 = org.spongycastle.util.BigIntegers.asUnsignedByteArray(r1, r0)
            byte[] r1 = r4.f7696V
            int r2 = r1.length
            r3 = 0
            if (r2 == 0) goto L_0x0099
            byte[] r1 = org.spongycastle.util.Arrays.concatenate((byte[]) r1, (byte[]) r0)
            org.spongycastle.util.Arrays.fill((byte[]) r0, (byte) r3)
            r0 = r1
        L_0x0099:
            org.spongycastle.crypto.params.KDFParameters r1 = new org.spongycastle.crypto.params.KDFParameters     // Catch:{ all -> 0x00ba }
            org.spongycastle.crypto.params.IESParameters r2 = r4.param     // Catch:{ all -> 0x00ba }
            byte[] r2 = r2.getDerivationV()     // Catch:{ all -> 0x00ba }
            r1.<init>(r0, r2)     // Catch:{ all -> 0x00ba }
            org.spongycastle.crypto.DerivationFunction r2 = r4.kdf     // Catch:{ all -> 0x00ba }
            r2.init(r1)     // Catch:{ all -> 0x00ba }
            boolean r1 = r4.forEncryption     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x00b2
            byte[] r5 = r4.encryptBlock(r5, r6, r7)     // Catch:{ all -> 0x00ba }
            goto L_0x00b6
        L_0x00b2:
            byte[] r5 = r4.decryptBlock(r5, r6, r7)     // Catch:{ all -> 0x00ba }
        L_0x00b6:
            org.spongycastle.util.Arrays.fill((byte[]) r0, (byte) r3)
            return r5
        L_0x00ba:
            r5 = move-exception
            org.spongycastle.util.Arrays.fill((byte[]) r0, (byte) r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.IESEngine.processBlock(byte[], int, int):byte[]");
    }
}
