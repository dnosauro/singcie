package org.spongycastle.jcajce.provider.symmetric.util;

import com.google.android.gms.stats.CodePackage;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.engines.DSTU7624Engine;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.KCCMBlockCipher;
import org.spongycastle.crypto.modes.KCTRBlockCipher;
import org.spongycastle.crypto.modes.KGCMBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.util.Strings;

public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    private static final Class gcmSpecClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.spec.GCMParameterSpec");
    private AEADParameters aeadParams;
    private Class[] availableSpecs = {RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private int digest;
    private BlockCipherProvider engineProvider;
    private boolean fixedIv = true;
    private int ivLength = 0;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String modeName = null;
    private boolean padded;
    private String pbeAlgorithm = null;
    private PBEParameterSpec pbeSpec = null;
    private int scheme = -1;

    private static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor;
        /* access modifiers changed from: private */
        public AEADBlockCipher cipher;

        static {
            Class loadClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            aeadBadTagConstructor = loadClass != null ? findExceptionConstructor(loadClass) : null;
        }

        AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.cipher = aEADBlockCipher;
        }

        private static Constructor findExceptionConstructor(Class cls) {
            try {
                return cls.getConstructor(new Class[]{String.class});
            } catch (Exception unused) {
                return null;
            }
        }

        public int doFinal(byte[] bArr, int i) {
            BadPaddingException badPaddingException;
            try {
                return this.cipher.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                Constructor constructor = aeadBadTagConstructor;
                if (constructor != null) {
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(new Object[]{e.getMessage()});
                    } catch (Exception unused) {
                        badPaddingException = null;
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e.getMessage());
            }
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public void init(boolean z, CipherParameters cipherParameters) {
            this.cipher.init(z, cipherParameters);
        }

        public int processByte(byte b, byte[] bArr, int i) {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public void updateAAD(byte[] bArr, int i, int i2) {
            this.cipher.processAADBytes(bArr, i, i2);
        }

        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    private static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        public int doFinal(byte[] bArr, int i) {
            try {
                return this.cipher.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public void init(boolean z, CipherParameters cipherParameters) {
            this.cipher.init(z, cipherParameters);
        }

        public int processByte(byte b, byte[] bArr, int i) {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public void updateAAD(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }
    }

    private interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i);

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        void init(boolean z, CipherParameters cipherParameters);

        int processByte(byte b, byte[] bArr, int i);

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

        void updateAAD(byte[] bArr, int i, int i2);

        boolean wrapOnNoPadding();
    }

    private static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        InvalidKeyOrParametersException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    protected BaseBlockCipher(BlockCipher blockCipher) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    protected BaseBlockCipher(BlockCipher blockCipher, int i) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i / 8;
    }

    protected BaseBlockCipher(BlockCipher blockCipher, int i, int i2, int i3, int i4) {
        this.baseEngine = blockCipher;
        this.scheme = i;
        this.digest = i2;
        this.keySizeInBits = i3;
        this.ivLength = i4;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    protected BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.ivLength = i / 8;
    }

    protected BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.ivLength = this.baseEngine.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    protected BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z, int i) {
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.fixedIv = z;
        this.ivLength = i;
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    protected BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.baseEngine = blockCipherProvider.get();
        this.engineProvider = blockCipherProvider;
        this.cipher = new BufferedGenericBlockCipher(blockCipherProvider.get());
    }

    private CipherParameters adjustParameters(AlgorithmParameterSpec algorithmParameterSpec, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            CipherParameters parameters = ((ParametersWithIV) cipherParameters).getParameters();
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.ivParam = new ParametersWithIV(parameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
                return cipherParameters;
            } else {
                GOST28147ParameterSpec gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
                ParametersWithSBox parametersWithSBox = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec.getSbox());
                if (gOST28147ParameterSpec.getIV() == null || this.ivLength == 0) {
                    return parametersWithSBox;
                }
                this.ivParam = new ParametersWithIV(parameters, gOST28147ParameterSpec.getIV());
                return this.ivParam;
            }
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.ivParam = new ParametersWithIV(cipherParameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
        } else if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
            return cipherParameters;
        } else {
            GOST28147ParameterSpec gOST28147ParameterSpec2 = (GOST28147ParameterSpec) algorithmParameterSpec;
            ParametersWithSBox parametersWithSBox2 = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec2.getSbox());
            return (gOST28147ParameterSpec2.getIV() == null || this.ivLength == 0) ? parametersWithSBox2 : new ParametersWithIV(parametersWithSBox2, gOST28147ParameterSpec2.getIV());
        }
        return this.ivParam;
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || CodePackage.GCM.equals(str) || "OCB".equals(str);
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (i2 != 0) {
                try {
                    i4 = this.cipher.processBytes(bArr, i, i2, bArr2, i3);
                } catch (OutputLengthException e) {
                    throw new IllegalBlockSizeException(e.getMessage());
                } catch (DataLengthException e2) {
                    throw new IllegalBlockSizeException(e2.getMessage());
                }
            } else {
                i4 = 0;
            }
            return i4 + this.cipher.doFinal(bArr2, i3 + i4);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[engineGetOutputSize(i2)];
        int processBytes = i2 != 0 ? this.cipher.processBytes(bArr, i, i2, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            if (doFinal == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return this.baseEngine.getBlockSize();
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        AEADParameters aEADParameters = this.aeadParams;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    this.engineParams = createParametersInstance(this.pbeAlgorithm);
                    this.engineParams.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.aeadParams != null) {
                try {
                    this.engineParams = createParametersInstance(CodePackage.GCM);
                    this.engineParams.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());
                } catch (Exception e) {
                    throw new RuntimeException(e.toString());
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    this.engineParams = createParametersInstance(algorithmName);
                    this.engineParams.init(new IvParameterSpec(this.ivParam.getIV()));
                } catch (Exception e2) {
                    throw new RuntimeException(e2.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i2 == clsArr.length) {
                    break;
                }
                if (clsArr[i2] != null) {
                    try {
                        algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                        break;
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        engineInit(i, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: org.spongycastle.crypto.params.AEADParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v52, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v54, resolved type: org.spongycastle.crypto.CipherParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: org.spongycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: org.spongycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: org.spongycastle.crypto.params.RC2Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v58, resolved type: org.spongycastle.crypto.params.RC2Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v60, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v61, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v62, resolved type: org.spongycastle.crypto.params.AEADParameters} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [org.spongycastle.crypto.CipherParameters] */
    /* JADX WARNING: type inference failed for: r5v2, types: [org.spongycastle.crypto.CipherParameters] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v63 */
    /* JADX WARNING: type inference failed for: r5v66 */
    /* JADX WARNING: type inference failed for: r5v67 */
    /* JADX WARNING: type inference failed for: r5v68 */
    /* JADX WARNING: type inference failed for: r5v70 */
    /* JADX WARNING: type inference failed for: r5v75 */
    /* JADX WARNING: type inference failed for: r5v76 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a3, code lost:
        if (r6 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (r6 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013a, code lost:
        if (r6 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f3, code lost:
        if (r6 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x047b  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x04c5 A[SYNTHETIC, Splitter:B:227:0x04c5] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x04c8 A[Catch:{ Exception -> 0x051c }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x04ce A[Catch:{ Exception -> 0x051c }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x04dd A[Catch:{ Exception -> 0x051c }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:? A[Catch:{ Exception -> 0x051c }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(int r18, java.security.Key r19, java.security.spec.AlgorithmParameterSpec r20, java.security.SecureRandom r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = 0
            r1.pbeSpec = r5
            r1.pbeAlgorithm = r5
            r1.engineParams = r5
            r1.aeadParams = r5
            boolean r6 = r2 instanceof javax.crypto.SecretKey
            if (r6 != 0) goto L_0x0039
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Key for algorithm "
            r3.append(r4)
            if (r2 == 0) goto L_0x0029
            java.lang.String r5 = r19.getAlgorithm()
        L_0x0029:
            r3.append(r5)
            java.lang.String r2 = " not suitable for symmetric enryption."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0039:
            if (r3 != 0) goto L_0x0052
            org.spongycastle.crypto.BlockCipher r6 = r1.baseEngine
            java.lang.String r6 = r6.getAlgorithmName()
            java.lang.String r7 = "RC5-64"
            boolean r6 = r6.startsWith(r7)
            if (r6 != 0) goto L_0x004a
            goto L_0x0052
        L_0x004a:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 requires an RC5ParametersSpec to be passed in."
            r0.<init>(r2)
            throw r0
        L_0x0052:
            int r6 = r1.scheme
            r7 = 2
            r8 = 1
            if (r6 == r7) goto L_0x015f
            boolean r7 = r2 instanceof org.spongycastle.jcajce.PKCS12Key
            if (r7 == 0) goto L_0x005e
            goto L_0x015f
        L_0x005e:
            boolean r7 = r2 instanceof org.spongycastle.jcajce.PBKDF1Key
            if (r7 == 0) goto L_0x00ac
            r5 = r2
            org.spongycastle.jcajce.PBKDF1Key r5 = (org.spongycastle.jcajce.PBKDF1Key) r5
            boolean r6 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r6 == 0) goto L_0x006e
            r6 = r3
            javax.crypto.spec.PBEParameterSpec r6 = (javax.crypto.spec.PBEParameterSpec) r6
            r1.pbeSpec = r6
        L_0x006e:
            boolean r6 = r5 instanceof org.spongycastle.jcajce.PBKDF1KeyWithParameters
            if (r6 == 0) goto L_0x0088
            javax.crypto.spec.PBEParameterSpec r6 = r1.pbeSpec
            if (r6 != 0) goto L_0x0088
            javax.crypto.spec.PBEParameterSpec r6 = new javax.crypto.spec.PBEParameterSpec
            r7 = r5
            org.spongycastle.jcajce.PBKDF1KeyWithParameters r7 = (org.spongycastle.jcajce.PBKDF1KeyWithParameters) r7
            byte[] r9 = r7.getSalt()
            int r7 = r7.getIterationCount()
            r6.<init>(r9, r7)
            r1.pbeSpec = r6
        L_0x0088:
            byte[] r10 = r5.getEncoded()
            r11 = 0
            int r12 = r1.digest
            int r13 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r14 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r15 = r1.pbeSpec
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r5 = r1.cipher
            java.lang.String r16 = r5.getAlgorithmName()
            org.spongycastle.crypto.CipherParameters r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r10, r11, r12, r13, r14, r15, r16)
            boolean r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r6 == 0) goto L_0x01f7
        L_0x00a5:
            r6 = r5
            org.spongycastle.crypto.params.ParametersWithIV r6 = (org.spongycastle.crypto.params.ParametersWithIV) r6
            r1.ivParam = r6
            goto L_0x01f7
        L_0x00ac:
            boolean r7 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r7 == 0) goto L_0x00fb
            r5 = r2
            org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey r5 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r5
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r5.getOID()
            if (r6 == 0) goto L_0x00c2
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r5.getOID()
            java.lang.String r6 = r6.getId()
            goto L_0x00c6
        L_0x00c2:
            java.lang.String r6 = r5.getAlgorithm()
        L_0x00c6:
            r1.pbeAlgorithm = r6
            org.spongycastle.crypto.CipherParameters r6 = r5.getParam()
            if (r6 == 0) goto L_0x00d7
            org.spongycastle.crypto.CipherParameters r5 = r5.getParam()
            org.spongycastle.crypto.CipherParameters r5 = r1.adjustParameters(r3, r5)
            goto L_0x00ee
        L_0x00d7:
            boolean r6 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r6 == 0) goto L_0x00f3
            r6 = r3
            javax.crypto.spec.PBEParameterSpec r6 = (javax.crypto.spec.PBEParameterSpec) r6
            r1.pbeSpec = r6
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r6 = r1.cipher
            org.spongycastle.crypto.BlockCipher r6 = r6.getUnderlyingCipher()
            java.lang.String r6 = r6.getAlgorithmName()
            org.spongycastle.crypto.CipherParameters r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r5, r3, r6)
        L_0x00ee:
            boolean r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r6 == 0) goto L_0x01f7
            goto L_0x00a5
        L_0x00f3:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBE requires PBE parameters to be set."
            r0.<init>(r2)
            throw r0
        L_0x00fb:
            boolean r7 = r2 instanceof javax.crypto.interfaces.PBEKey
            if (r7 == 0) goto L_0x013e
            r5 = r2
            javax.crypto.interfaces.PBEKey r5 = (javax.crypto.interfaces.PBEKey) r5
            r6 = r3
            javax.crypto.spec.PBEParameterSpec r6 = (javax.crypto.spec.PBEParameterSpec) r6
            r1.pbeSpec = r6
            boolean r6 = r5 instanceof org.spongycastle.jcajce.PKCS12KeyWithParameters
            if (r6 == 0) goto L_0x011e
            javax.crypto.spec.PBEParameterSpec r6 = r1.pbeSpec
            if (r6 != 0) goto L_0x011e
            javax.crypto.spec.PBEParameterSpec r6 = new javax.crypto.spec.PBEParameterSpec
            byte[] r7 = r5.getSalt()
            int r9 = r5.getIterationCount()
            r6.<init>(r7, r9)
            r1.pbeSpec = r6
        L_0x011e:
            byte[] r10 = r5.getEncoded()
            int r11 = r1.scheme
            int r12 = r1.digest
            int r13 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r14 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r15 = r1.pbeSpec
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r5 = r1.cipher
            java.lang.String r16 = r5.getAlgorithmName()
            org.spongycastle.crypto.CipherParameters r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r10, r11, r12, r13, r14, r15, r16)
            boolean r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r6 == 0) goto L_0x01f7
            goto L_0x00a5
        L_0x013e:
            boolean r7 = r2 instanceof org.spongycastle.jcajce.spec.RepeatedSecretKeySpec
            if (r7 != 0) goto L_0x01f7
            if (r6 == 0) goto L_0x0157
            r5 = 4
            if (r6 == r5) goto L_0x0157
            if (r6 == r8) goto L_0x0157
            r5 = 5
            if (r6 == r5) goto L_0x0157
            org.spongycastle.crypto.params.KeyParameter r5 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r6 = r19.getEncoded()
            r5.<init>(r6)
            goto L_0x01f7
        L_0x0157:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "Algorithm requires a PBE key"
            r0.<init>(r2)
            throw r0
        L_0x015f:
            r5 = r2
            javax.crypto.SecretKey r5 = (javax.crypto.SecretKey) r5     // Catch:{ Exception -> 0x0527 }
            boolean r6 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r6 == 0) goto L_0x016b
            r6 = r3
            javax.crypto.spec.PBEParameterSpec r6 = (javax.crypto.spec.PBEParameterSpec) r6
            r1.pbeSpec = r6
        L_0x016b:
            boolean r6 = r5 instanceof javax.crypto.interfaces.PBEKey
            if (r6 == 0) goto L_0x0194
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            if (r7 != 0) goto L_0x0194
            r7 = r5
            javax.crypto.interfaces.PBEKey r7 = (javax.crypto.interfaces.PBEKey) r7
            byte[] r9 = r7.getSalt()
            if (r9 == 0) goto L_0x018c
            javax.crypto.spec.PBEParameterSpec r9 = new javax.crypto.spec.PBEParameterSpec
            byte[] r10 = r7.getSalt()
            int r7 = r7.getIterationCount()
            r9.<init>(r10, r7)
            r1.pbeSpec = r9
            goto L_0x0194
        L_0x018c:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBEKey requires parameters to specify salt"
            r0.<init>(r2)
            throw r0
        L_0x0194:
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            if (r7 != 0) goto L_0x01a3
            if (r6 == 0) goto L_0x019b
            goto L_0x01a3
        L_0x019b:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "Algorithm requires a PBE key"
            r0.<init>(r2)
            throw r0
        L_0x01a3:
            boolean r6 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r6 == 0) goto L_0x01d8
            r6 = r2
            org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey r6 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r6
            org.spongycastle.crypto.CipherParameters r6 = r6.getParam()
            boolean r7 = r6 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x01b3
            goto L_0x01ce
        L_0x01b3:
            if (r6 != 0) goto L_0x01d0
            byte[] r9 = r5.getEncoded()
            r10 = 2
            int r11 = r1.digest
            int r12 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r13 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r14 = r1.pbeSpec
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r5 = r1.cipher
            java.lang.String r15 = r5.getAlgorithmName()
            org.spongycastle.crypto.CipherParameters r6 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r9, r10, r11, r12, r13, r14, r15)
        L_0x01ce:
            r5 = r6
            goto L_0x01f1
        L_0x01d0:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "Algorithm requires a PBE key suitable for PKCS12"
            r0.<init>(r2)
            throw r0
        L_0x01d8:
            byte[] r9 = r5.getEncoded()
            r10 = 2
            int r11 = r1.digest
            int r12 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r13 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r14 = r1.pbeSpec
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r5 = r1.cipher
            java.lang.String r15 = r5.getAlgorithmName()
            org.spongycastle.crypto.CipherParameters r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r9, r10, r11, r12, r13, r14, r15)
        L_0x01f1:
            boolean r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r6 == 0) goto L_0x01f7
            goto L_0x00a5
        L_0x01f7:
            boolean r6 = r3 instanceof org.spongycastle.jcajce.spec.AEADParameterSpec
            r7 = 0
            if (r6 == 0) goto L_0x023b
            java.lang.String r2 = r1.modeName
            boolean r2 = r1.isAEADModeName(r2)
            if (r2 != 0) goto L_0x0213
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            boolean r2 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x020b
            goto L_0x0213
        L_0x020b:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "AEADParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x0213:
            r2 = r3
            org.spongycastle.jcajce.spec.AEADParameterSpec r2 = (org.spongycastle.jcajce.spec.AEADParameterSpec) r2
            boolean r3 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x0223
            org.spongycastle.crypto.params.ParametersWithIV r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5
            org.spongycastle.crypto.CipherParameters r3 = r5.getParameters()
            org.spongycastle.crypto.params.KeyParameter r3 = (org.spongycastle.crypto.params.KeyParameter) r3
            goto L_0x0226
        L_0x0223:
            r3 = r5
            org.spongycastle.crypto.params.KeyParameter r3 = (org.spongycastle.crypto.params.KeyParameter) r3
        L_0x0226:
            org.spongycastle.crypto.params.AEADParameters r5 = new org.spongycastle.crypto.params.AEADParameters
            int r6 = r2.getMacSizeInBits()
            byte[] r9 = r2.getNonce()
            byte[] r2 = r2.getAssociatedData()
            r5.<init>(r3, r6, r9, r2)
            r1.aeadParams = r5
            goto L_0x046d
        L_0x023b:
            boolean r6 = r3 instanceof javax.crypto.spec.IvParameterSpec
            if (r6 == 0) goto L_0x02b3
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x029d
            r2 = r3
            javax.crypto.spec.IvParameterSpec r2 = (javax.crypto.spec.IvParameterSpec) r2
            byte[] r3 = r2.getIV()
            int r3 = r3.length
            int r6 = r1.ivLength
            if (r3 == r6) goto L_0x0278
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r3 = r1.cipher
            boolean r3 = r3 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r3 != 0) goto L_0x0278
            boolean r3 = r1.fixedIv
            if (r3 != 0) goto L_0x025a
            goto L_0x0278
        L_0x025a:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IV must be "
            r2.append(r3)
            int r3 = r1.ivLength
            r2.append(r3)
            java.lang.String r3 = " bytes long."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0278:
            boolean r3 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x028c
            org.spongycastle.crypto.params.ParametersWithIV r3 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5
            org.spongycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r2 = r2.getIV()
            r3.<init>(r5, r2)
            goto L_0x0295
        L_0x028c:
            org.spongycastle.crypto.params.ParametersWithIV r3 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r2 = r2.getIV()
            r3.<init>(r5, r2)
        L_0x0295:
            r5 = r3
            r2 = r5
            org.spongycastle.crypto.params.ParametersWithIV r2 = (org.spongycastle.crypto.params.ParametersWithIV) r2
            r1.ivParam = r2
            goto L_0x046d
        L_0x029d:
            java.lang.String r2 = r1.modeName
            if (r2 == 0) goto L_0x046d
            java.lang.String r3 = "ECB"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x02ab
            goto L_0x046d
        L_0x02ab:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "ECB mode does not use an IV"
            r0.<init>(r2)
            throw r0
        L_0x02b3:
            boolean r6 = r3 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec
            if (r6 == 0) goto L_0x02fa
            org.spongycastle.jcajce.spec.GOST28147ParameterSpec r3 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r3
            org.spongycastle.crypto.params.ParametersWithSBox r5 = new org.spongycastle.crypto.params.ParametersWithSBox
            org.spongycastle.crypto.params.KeyParameter r6 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r2 = r19.getEncoded()
            r6.<init>(r2)
            byte[] r2 = r3.getSbox()
            r5.<init>(r6, r2)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x046d
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x046d
            boolean r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x02e9
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5
            org.spongycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f2
        L_0x02e9:
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
        L_0x02f2:
            r3 = r2
            org.spongycastle.crypto.params.ParametersWithIV r3 = (org.spongycastle.crypto.params.ParametersWithIV) r3
            r1.ivParam = r3
            r5 = r2
            goto L_0x046d
        L_0x02fa:
            boolean r6 = r3 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r6 == 0) goto L_0x0335
            javax.crypto.spec.RC2ParameterSpec r3 = (javax.crypto.spec.RC2ParameterSpec) r3
            org.spongycastle.crypto.params.RC2Parameters r5 = new org.spongycastle.crypto.params.RC2Parameters
            byte[] r2 = r19.getEncoded()
            int r6 = r3.getEffectiveKeyBits()
            r5.<init>(r2, r6)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x046d
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x046d
            boolean r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x032b
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5
            org.spongycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f2
        L_0x032b:
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f2
        L_0x0335:
            boolean r6 = r3 instanceof javax.crypto.spec.RC5ParameterSpec
            if (r6 == 0) goto L_0x03f6
            javax.crypto.spec.RC5ParameterSpec r3 = (javax.crypto.spec.RC5ParameterSpec) r3
            org.spongycastle.crypto.params.RC5Parameters r5 = new org.spongycastle.crypto.params.RC5Parameters
            byte[] r2 = r19.getEncoded()
            int r6 = r3.getRounds()
            r5.<init>(r2, r6)
            org.spongycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r6 = "RC5"
            boolean r2 = r2.startsWith(r6)
            if (r2 == 0) goto L_0x03ee
            org.spongycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r6 = "RC5-32"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x038d
            int r2 = r3.getWordSize()
            r6 = 32
            if (r2 != r6) goto L_0x036d
            goto L_0x03c4
        L_0x036d:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "RC5 already set up for a word size of 32 not "
            r2.append(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            java.lang.String r3 = "."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x038d:
            org.spongycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r6 = "RC5-64"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x03c4
            int r2 = r3.getWordSize()
            r6 = 64
            if (r2 != r6) goto L_0x03a4
            goto L_0x03c4
        L_0x03a4:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "RC5 already set up for a word size of 64 not "
            r2.append(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            java.lang.String r3 = "."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x03c4:
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x046d
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x046d
            boolean r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x03e3
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5
            org.spongycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f2
        L_0x03e3:
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f2
        L_0x03ee:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 parameters passed to a cipher that is not RC5."
            r0.<init>(r2)
            throw r0
        L_0x03f6:
            java.lang.Class r2 = gcmSpecClass
            if (r2 == 0) goto L_0x045e
            boolean r2 = r2.isInstance(r3)
            if (r2 == 0) goto L_0x045e
            java.lang.String r2 = r1.modeName
            boolean r2 = r1.isAEADModeName(r2)
            if (r2 != 0) goto L_0x0417
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            boolean r2 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x040f
            goto L_0x0417
        L_0x040f:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "GCMParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x0417:
            java.lang.Class r2 = gcmSpecClass     // Catch:{ Exception -> 0x0456 }
            java.lang.String r6 = "getTLen"
            java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0456 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r6, r9)     // Catch:{ Exception -> 0x0456 }
            java.lang.Class r6 = gcmSpecClass     // Catch:{ Exception -> 0x0456 }
            java.lang.String r9 = "getIV"
            java.lang.Class[] r10 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0456 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r9, r10)     // Catch:{ Exception -> 0x0456 }
            boolean r9 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV     // Catch:{ Exception -> 0x0456 }
            if (r9 == 0) goto L_0x0435
            org.spongycastle.crypto.params.ParametersWithIV r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5     // Catch:{ Exception -> 0x0456 }
            org.spongycastle.crypto.CipherParameters r5 = r5.getParameters()     // Catch:{ Exception -> 0x0456 }
        L_0x0435:
            org.spongycastle.crypto.params.KeyParameter r5 = (org.spongycastle.crypto.params.KeyParameter) r5     // Catch:{ Exception -> 0x0456 }
            org.spongycastle.crypto.params.AEADParameters r9 = new org.spongycastle.crypto.params.AEADParameters     // Catch:{ Exception -> 0x0456 }
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0456 }
            java.lang.Object r2 = r2.invoke(r3, r10)     // Catch:{ Exception -> 0x0456 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0456 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0456 }
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0456 }
            java.lang.Object r3 = r6.invoke(r3, r10)     // Catch:{ Exception -> 0x0456 }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x0456 }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x0456 }
            r9.<init>(r5, r2, r3)     // Catch:{ Exception -> 0x0456 }
            r1.aeadParams = r9     // Catch:{ Exception -> 0x0456 }
            r5 = r9
            goto L_0x046d
        L_0x0456:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "Cannot process GCMParameterSpec."
            r0.<init>(r2)
            throw r0
        L_0x045e:
            if (r3 == 0) goto L_0x046d
            boolean r2 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r2 == 0) goto L_0x0465
            goto L_0x046d
        L_0x0465:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "unknown parameter type."
            r0.<init>(r2)
            throw r0
        L_0x046d:
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x04b5
            boolean r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 != 0) goto L_0x04b5
            boolean r2 = r5 instanceof org.spongycastle.crypto.params.AEADParameters
            if (r2 != 0) goto L_0x04b5
            if (r4 != 0) goto L_0x0481
            java.security.SecureRandom r2 = new java.security.SecureRandom
            r2.<init>()
            goto L_0x0482
        L_0x0481:
            r2 = r4
        L_0x0482:
            if (r0 == r8) goto L_0x04a3
            r3 = 3
            if (r0 != r3) goto L_0x0488
            goto L_0x04a3
        L_0x0488:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            org.spongycastle.crypto.BlockCipher r2 = r2.getUnderlyingCipher()
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r3 = "PGPCFB"
            int r2 = r2.indexOf(r3)
            if (r2 < 0) goto L_0x049b
            goto L_0x04b5
        L_0x049b:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "no IV set when one expected"
            r0.<init>(r2)
            throw r0
        L_0x04a3:
            int r3 = r1.ivLength
            byte[] r3 = new byte[r3]
            r2.nextBytes(r3)
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            r2.<init>(r5, r3)
            r3 = r2
            org.spongycastle.crypto.params.ParametersWithIV r3 = (org.spongycastle.crypto.params.ParametersWithIV) r3
            r1.ivParam = r3
            goto L_0x04b6
        L_0x04b5:
            r2 = r5
        L_0x04b6:
            if (r4 == 0) goto L_0x04c2
            boolean r3 = r1.padded
            if (r3 == 0) goto L_0x04c2
            org.spongycastle.crypto.params.ParametersWithRandom r3 = new org.spongycastle.crypto.params.ParametersWithRandom
            r3.<init>(r2, r4)
            r2 = r3
        L_0x04c2:
            switch(r0) {
                case 1: goto L_0x04ce;
                case 2: goto L_0x04c8;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04c8;
                default: goto L_0x04c5;
            }
        L_0x04c5:
            java.security.InvalidParameterException r2 = new java.security.InvalidParameterException     // Catch:{ Exception -> 0x051c }
            goto L_0x0502
        L_0x04c8:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ Exception -> 0x051c }
            r0.init(r7, r2)     // Catch:{ Exception -> 0x051c }
            goto L_0x04d3
        L_0x04ce:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ Exception -> 0x051c }
            r0.init(r8, r2)     // Catch:{ Exception -> 0x051c }
        L_0x04d3:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ Exception -> 0x051c }
            boolean r0 = r0 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher     // Catch:{ Exception -> 0x051c }
            if (r0 == 0) goto L_0x0501
            org.spongycastle.crypto.params.AEADParameters r0 = r1.aeadParams     // Catch:{ Exception -> 0x051c }
            if (r0 != 0) goto L_0x0501
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ Exception -> 0x051c }
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$AEADGenericBlockCipher r0 = (org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher) r0     // Catch:{ Exception -> 0x051c }
            org.spongycastle.crypto.modes.AEADBlockCipher r0 = r0.cipher     // Catch:{ Exception -> 0x051c }
            org.spongycastle.crypto.params.AEADParameters r2 = new org.spongycastle.crypto.params.AEADParameters     // Catch:{ Exception -> 0x051c }
            org.spongycastle.crypto.params.ParametersWithIV r3 = r1.ivParam     // Catch:{ Exception -> 0x051c }
            org.spongycastle.crypto.CipherParameters r3 = r3.getParameters()     // Catch:{ Exception -> 0x051c }
            org.spongycastle.crypto.params.KeyParameter r3 = (org.spongycastle.crypto.params.KeyParameter) r3     // Catch:{ Exception -> 0x051c }
            byte[] r0 = r0.getMac()     // Catch:{ Exception -> 0x051c }
            int r0 = r0.length     // Catch:{ Exception -> 0x051c }
            int r0 = r0 * 8
            org.spongycastle.crypto.params.ParametersWithIV r4 = r1.ivParam     // Catch:{ Exception -> 0x051c }
            byte[] r4 = r4.getIV()     // Catch:{ Exception -> 0x051c }
            r2.<init>(r3, r0, r4)     // Catch:{ Exception -> 0x051c }
            r1.aeadParams = r2     // Catch:{ Exception -> 0x051c }
        L_0x0501:
            return
        L_0x0502:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x051c }
            r3.<init>()     // Catch:{ Exception -> 0x051c }
            java.lang.String r4 = "unknown opmode "
            r3.append(r4)     // Catch:{ Exception -> 0x051c }
            r3.append(r0)     // Catch:{ Exception -> 0x051c }
            java.lang.String r0 = " passed"
            r3.append(r0)     // Catch:{ Exception -> 0x051c }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x051c }
            r2.<init>(r0)     // Catch:{ Exception -> 0x051c }
            throw r2     // Catch:{ Exception -> 0x051c }
        L_0x051c:
            r0 = move-exception
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$InvalidKeyOrParametersException r2 = new org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$InvalidKeyOrParametersException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x0527:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "PKCS12 requires a SecretKey/PBEKey"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) {
        GenericBlockCipher aEADGenericBlockCipher;
        GenericBlockCipher aEADGenericBlockCipher2;
        this.modeName = Strings.toUpperCase(str);
        if (this.modeName.equals("ECB")) {
            this.ivLength = 0;
            aEADGenericBlockCipher2 = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            aEADGenericBlockCipher2 = new BufferedGenericBlockCipher((BlockCipher) new CBCBlockCipher(this.baseEngine));
        } else {
            if (this.modeName.startsWith("OFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                if (this.modeName.length() != 3) {
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                } else {
                    BlockCipher blockCipher = this.baseEngine;
                    aEADGenericBlockCipher2 = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
                }
            } else if (this.modeName.startsWith("CFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                if (this.modeName.length() != 3) {
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                } else {
                    BlockCipher blockCipher2 = this.baseEngine;
                    aEADGenericBlockCipher2 = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
                }
            } else if (this.modeName.startsWith("PGP")) {
                boolean equalsIgnoreCase = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new PGPCFBBlockCipher(this.baseEngine, equalsIgnoreCase));
            } else if (this.modeName.equalsIgnoreCase("OpenPGPCFB")) {
                this.ivLength = 0;
                aEADGenericBlockCipher2 = new BufferedGenericBlockCipher((BlockCipher) new OpenPGPCFBBlockCipher(this.baseEngine));
            } else if (this.modeName.startsWith("SIC")) {
                this.ivLength = this.baseEngine.getBlockSize();
                if (this.ivLength >= 16) {
                    this.fixedIv = false;
                    aEADGenericBlockCipher2 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
                } else {
                    throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
                }
            } else if (this.modeName.startsWith("CTR")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.fixedIv = false;
                BlockCipher blockCipher3 = this.baseEngine;
                aEADGenericBlockCipher = blockCipher3 instanceof DSTU7624Engine ? new BufferedGenericBlockCipher(new BufferedBlockCipher(new KCTRBlockCipher(blockCipher3))) : new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(blockCipher3)));
            } else if (this.modeName.startsWith("GOFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher2 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("GCFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher2 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("CTS")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher2 = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("CCM")) {
                this.ivLength = 13;
                BlockCipher blockCipher4 = this.baseEngine;
                aEADGenericBlockCipher = blockCipher4 instanceof DSTU7624Engine ? new AEADGenericBlockCipher(new KCCMBlockCipher(blockCipher4)) : new AEADGenericBlockCipher(new CCMBlockCipher(blockCipher4));
            } else if (this.modeName.startsWith("OCB")) {
                BlockCipherProvider blockCipherProvider = this.engineProvider;
                if (blockCipherProvider != null) {
                    this.ivLength = 15;
                    aEADGenericBlockCipher2 = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, blockCipherProvider.get()));
                } else {
                    throw new NoSuchAlgorithmException("can't support mode " + str);
                }
            } else if (this.modeName.startsWith("EAX")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher2 = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
            } else if (this.modeName.startsWith(CodePackage.GCM)) {
                this.ivLength = this.baseEngine.getBlockSize();
                BlockCipher blockCipher5 = this.baseEngine;
                aEADGenericBlockCipher = blockCipher5 instanceof DSTU7624Engine ? new AEADGenericBlockCipher(new KGCMBlockCipher(blockCipher5)) : new AEADGenericBlockCipher(new GCMBlockCipher(blockCipher5));
            } else {
                throw new NoSuchAlgorithmException("can't support mode " + str);
            }
            this.cipher = aEADGenericBlockCipher;
            return;
        }
        this.cipher = aEADGenericBlockCipher2;
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) {
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (this.cipher.wrapOnNoPadding()) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
            } else {
                return;
            }
        } else if (upperCase.equals("WITHCTS")) {
            bufferedGenericBlockCipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            this.padded = true;
            if (isAEADModeName(this.modeName)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
            } else if (upperCase.equals("ZEROBYTEPADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
            } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            } else if (upperCase.equals("TBCPADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
            } else {
                throw new NoSuchPaddingException("Padding " + str + " unknown.");
            }
        }
        this.cipher = bufferedGenericBlockCipher;
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (this.cipher.getUpdateOutputSize(i2) + i3 <= bArr2.length) {
            try {
                return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
            } catch (DataLengthException e) {
                throw new IllegalStateException(e.toString());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i2);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[processBytes];
            System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
            return bArr3;
        }
        this.cipher.processBytes(bArr, i, i2, (byte[]) null, 0);
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    /* access modifiers changed from: protected */
    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.cipher.updateAAD(bArr, i, i2);
    }
}
