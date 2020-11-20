package org.spongycastle.pqc.jcajce.provider.xmss;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHAKEDigest;
import org.spongycastle.pqc.crypto.xmss.XMSSKeyGenerationParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSKeyPairGenerator;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.XMSSParameterSpec;

public class XMSSKeyPairGeneratorSpi extends KeyPairGenerator {
    private XMSSKeyPairGenerator engine = new XMSSKeyPairGenerator();
    private boolean initialised = false;
    private XMSSKeyGenerationParameters param;
    private SecureRandom random = new SecureRandom();
    private ASN1ObjectIdentifier treeDigest;

    public XMSSKeyPairGeneratorSpi() {
        super("XMSS");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            this.param = new XMSSKeyGenerationParameters(new XMSSParameters(10, new SHA512Digest()), this.random);
            this.engine.init(this.param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCXMSSPublicKey(this.treeDigest, (XMSSPublicKeyParameters) generateKeyPair.getPublic()), new BCXMSSPrivateKey(this.treeDigest, (XMSSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        XMSSKeyGenerationParameters xMSSKeyGenerationParameters;
        if (algorithmParameterSpec instanceof XMSSParameterSpec) {
            XMSSParameterSpec xMSSParameterSpec = (XMSSParameterSpec) algorithmParameterSpec;
            if (xMSSParameterSpec.getTreeDigest().equals("SHA256")) {
                this.treeDigest = NISTObjectIdentifiers.id_sha256;
                xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHA256Digest()), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHA512")) {
                this.treeDigest = NISTObjectIdentifiers.id_sha512;
                xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHA512Digest()), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHAKE128")) {
                this.treeDigest = NISTObjectIdentifiers.id_shake128;
                xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHAKEDigest(128)), secureRandom);
            } else {
                if (xMSSParameterSpec.getTreeDigest().equals("SHAKE256")) {
                    this.treeDigest = NISTObjectIdentifiers.id_shake256;
                    xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHAKEDigest(256)), secureRandom);
                }
                this.engine.init(this.param);
                this.initialised = true;
                return;
            }
            this.param = xMSSKeyGenerationParameters;
            this.engine.init(this.param);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a XMSSParameterSpec");
    }
}
