package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CryptoProWrapEngine;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.engines.GOST28147WrapEngine;
import org.spongycastle.crypto.macs.GOST28147Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;

public final class GOST28147 {
    /* access modifiers changed from: private */
    public static Map<String, ASN1ObjectIdentifier> nameMappings = new HashMap();
    private static Map<ASN1ObjectIdentifier, String> oidMappings = new HashMap();

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {

        /* renamed from: iv */
        byte[] f7944iv = new byte[8];
        byte[] sBox = GOST28147Engine.getSBox("E-A");

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(this.f7944iv);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("GOST28147");
                createParametersInstance.init(new GOST28147ParameterSpec(this.sBox, this.f7944iv));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.sBox = ((GOST28147ParameterSpec) algorithmParameterSpec).getSBox();
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter spec not supported");
        }
    }

    public static class AlgParams extends BaseAlgParams {

        /* renamed from: iv */
        private byte[] f7945iv;
        private ASN1ObjectIdentifier sBox = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet;

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f7945iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.f7945iv = ((GOST28147ParameterSpec) algorithmParameterSpec).getIV();
                try {
                    this.sBox = getSBoxOID(((GOST28147ParameterSpec) algorithmParameterSpec).getSBox());
                } catch (IllegalArgumentException e) {
                    throw new InvalidParameterSpecException(e.getMessage());
                }
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
        }

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "GOST 28147 IV Parameters";
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f7945iv);
            }
            if (cls == GOST28147ParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new GOST28147ParameterSpec(this.sBox, this.f7945iv);
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        /* access modifiers changed from: protected */
        public byte[] localGetEncoded() {
            return new GOST28147Parameters(this.f7945iv, this.sBox).getEncoded();
        }

        /* access modifiers changed from: protected */
        public void localInit(byte[] bArr) {
            byte[] iv;
            ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(bArr);
            if (fromByteArray instanceof ASN1OctetString) {
                iv = ASN1OctetString.getInstance(fromByteArray).getOctets();
            } else if (fromByteArray instanceof ASN1Sequence) {
                GOST28147Parameters instance = GOST28147Parameters.getInstance(fromByteArray);
                this.sBox = instance.getEncryptionParamSet();
                iv = instance.getIV();
            } else {
                throw new IOException("Unable to recognize parameters");
            }
            this.f7945iv = iv;
        }
    }

    public static abstract class BaseAlgParams extends BaseAlgorithmParameters {

        /* renamed from: iv */
        private byte[] f7946iv;
        private ASN1ObjectIdentifier sBox = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet;

        protected static ASN1ObjectIdentifier getSBoxOID(String str) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) GOST28147.nameMappings.get(str);
            if (aSN1ObjectIdentifier != null) {
                return aSN1ObjectIdentifier;
            }
            throw new IllegalArgumentException("Unknown SBOX name: " + str);
        }

        protected static ASN1ObjectIdentifier getSBoxOID(byte[] bArr) {
            return getSBoxOID(GOST28147Engine.getSBoxName(bArr));
        }

        /* access modifiers changed from: protected */
        public final byte[] engineGetEncoded() {
            return engineGetEncoded("ASN.1");
        }

        /* access modifiers changed from: protected */
        public final byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return localGetEncoded();
            }
            throw new IOException("Unknown parameter format: " + str);
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f7946iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.f7946iv = ((GOST28147ParameterSpec) algorithmParameterSpec).getIV();
                try {
                    this.sBox = getSBoxOID(((GOST28147ParameterSpec) algorithmParameterSpec).getSBox());
                } catch (IllegalArgumentException e) {
                    throw new InvalidParameterSpecException(e.getMessage());
                }
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
        }

        /* access modifiers changed from: protected */
        public final void engineInit(byte[] bArr) {
            engineInit(bArr, "ASN.1");
        }

        /* access modifiers changed from: protected */
        public final void engineInit(byte[] bArr, String str) {
            if (bArr == null) {
                throw new NullPointerException("Encoded parameters cannot be null");
            } else if (isASN1FormatString(str)) {
                try {
                    localInit(bArr);
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IOException("Parameter parsing failed: " + e2.getMessage());
                }
            } else {
                throw new IOException("Unknown parameter format: " + str);
            }
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f7946iv);
            }
            if (cls == GOST28147ParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new GOST28147ParameterSpec(this.sBox, this.f7946iv);
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        /* access modifiers changed from: protected */
        public byte[] localGetEncoded() {
            return new GOST28147Parameters(this.f7946iv, this.sBox).getEncoded();
        }

        /* access modifiers changed from: package-private */
        public abstract void localInit(byte[] bArr);
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new GOST28147Engine()), 64);
        }
    }

    public static class CryptoProWrap extends BaseWrapCipher {
        public CryptoProWrap() {
            super(new CryptoProWrapEngine());
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new GOST28147Engine());
        }
    }

    public static class GCFB extends BaseBlockCipher {
        public GCFB() {
            super(new BufferedBlockCipher(new GCFBBlockCipher(new GOST28147Engine())), 64);
        }
    }

    public static class GostWrap extends BaseWrapCipher {
        public GostWrap() {
            super(new GOST28147WrapEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("GOST28147", i, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new GOST28147Mac());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = GOST28147.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("Cipher.GOST28147", PREFIX + "$ECB");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.GOST", "GOST28147");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.GOST-28147", "GOST28147");
            configurableProvider.addAlgorithm("Cipher." + CryptoProObjectIdentifiers.gostR28147_gcfb, PREFIX + "$GCFB");
            configurableProvider.addAlgorithm("KeyGenerator.GOST28147", PREFIX + "$KeyGen");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.GOST", "GOST28147");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator." + CryptoProObjectIdentifiers.gostR28147_gcfb, "GOST28147");
            configurableProvider.addAlgorithm("AlgorithmParameters.GOST28147", PREFIX + "$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.GOST28147", PREFIX + "$AlgParamGen");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + CryptoProObjectIdentifiers.gostR28147_gcfb, "GOST28147");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + CryptoProObjectIdentifiers.gostR28147_gcfb, "GOST28147");
            configurableProvider.addAlgorithm("Cipher." + CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap, PREFIX + "$CryptoProWrap");
            configurableProvider.addAlgorithm("Cipher." + CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap, PREFIX + "$GostWrap");
            configurableProvider.addAlgorithm("Mac.GOST28147MAC", PREFIX + "$Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
        }
    }

    static {
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_TestParamSet, "E-TEST");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
        nameMappings.put("E-A", CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet);
        nameMappings.put("E-B", CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet);
        nameMappings.put("E-C", CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet);
        nameMappings.put("E-D", CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet);
    }

    private GOST28147() {
    }
}
