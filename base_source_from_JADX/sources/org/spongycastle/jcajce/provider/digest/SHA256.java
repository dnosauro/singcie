package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class SHA256 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA256Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.digest = new SHA256Digest((SHA256Digest) this.digest);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA256Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = SHA256.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("MessageDigest.SHA-256", PREFIX + "$Digest");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA256", McElieceCCA2KeyGenParameterSpec.SHA256);
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha256, McElieceCCA2KeyGenParameterSpec.SHA256);
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHHMACSHA256", PREFIX + "$PBEWithMacKeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + NISTObjectIdentifiers.id_sha256, "PBEWITHHMACSHA256");
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA256", PREFIX + "$HashMac");
            addHMACAlgorithm(configurableProvider, "SHA256", PREFIX + "$HashMac", PREFIX + "$KeyGenerator");
            addHMACAlias(configurableProvider, "SHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
            addHMACAlias(configurableProvider, "SHA256", NISTObjectIdentifiers.id_sha256);
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA256", (ASN1ObjectIdentifier) null, false, 2, 4, 256, 0);
        }
    }

    private SHA256() {
    }
}
