package org.spongycastle.eac.operator.jcajce;

import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.eac.operator.EACSigner;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.OperatorStreamException;
import org.spongycastle.operator.RuntimeOperatorException;

public class JcaEACSignerBuilder {
    private static final Hashtable sigNames = new Hashtable();
    private EACHelper helper = new DefaultEACHelper();

    private class SignatureOutputStream extends OutputStream {
        private Signature sig;

        SignatureOutputStream(Signature signature) {
            this.sig = signature;
        }

        /* access modifiers changed from: package-private */
        public byte[] getSignature() {
            return this.sig.sign();
        }

        public void write(int i) {
            try {
                this.sig.update((byte) i);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        public void write(byte[] bArr) {
            try {
                this.sig.update(bArr);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        public void write(byte[] bArr, int i, int i2) {
            try {
                this.sig.update(bArr, i, i2);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }
    }

    static {
        sigNames.put("SHA1withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1);
        sigNames.put("SHA256withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256);
        sigNames.put("SHA1withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1);
        sigNames.put("SHA256withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256);
        sigNames.put("SHA512withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_512);
        sigNames.put("SHA512withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_512);
        sigNames.put("SHA1withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1);
        sigNames.put("SHA224withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_224);
        sigNames.put("SHA256withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_256);
        sigNames.put("SHA384withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_384);
        sigNames.put("SHA512withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_512);
    }

    private static void copyUnsignedInt(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        int i2 = 0;
        if (bArr[0] == 0) {
            length--;
            i2 = 1;
        }
        System.arraycopy(bArr, i2, bArr2, i, length);
    }

    public static int max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    /* access modifiers changed from: private */
    public static byte[] reencode(byte[] bArr) {
        ASN1Sequence instance = ASN1Sequence.getInstance(bArr);
        BigInteger value = ASN1Integer.getInstance(instance.getObjectAt(0)).getValue();
        BigInteger value2 = ASN1Integer.getInstance(instance.getObjectAt(1)).getValue();
        byte[] byteArray = value.toByteArray();
        byte[] byteArray2 = value2.toByteArray();
        int unsignedIntLength = unsignedIntLength(byteArray);
        int unsignedIntLength2 = unsignedIntLength(byteArray2);
        int max = max(unsignedIntLength, unsignedIntLength2);
        int i = max * 2;
        byte[] bArr2 = new byte[i];
        Arrays.fill(bArr2, (byte) 0);
        copyUnsignedInt(byteArray, bArr2, max - unsignedIntLength);
        copyUnsignedInt(byteArray2, bArr2, i - unsignedIntLength2);
        return bArr2;
    }

    private static int unsignedIntLength(byte[] bArr) {
        int length = bArr.length;
        return bArr[0] == 0 ? length - 1 : length;
    }

    public EACSigner build(String str, PrivateKey privateKey) {
        return build((ASN1ObjectIdentifier) sigNames.get(str), privateKey);
    }

    public EACSigner build(final ASN1ObjectIdentifier aSN1ObjectIdentifier, PrivateKey privateKey) {
        try {
            Signature signature = this.helper.getSignature(aSN1ObjectIdentifier);
            signature.initSign(privateKey);
            final SignatureOutputStream signatureOutputStream = new SignatureOutputStream(signature);
            return new EACSigner() {
                public OutputStream getOutputStream() {
                    return signatureOutputStream;
                }

                public byte[] getSignature() {
                    try {
                        byte[] signature = signatureOutputStream.getSignature();
                        return aSN1ObjectIdentifier.mo27879on(EACObjectIdentifiers.id_TA_ECDSA) ? JcaEACSignerBuilder.reencode(signature) : signature;
                    } catch (SignatureException e) {
                        throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                    }
                }

                public ASN1ObjectIdentifier getUsageIdentifier() {
                    return aSN1ObjectIdentifier;
                }
            };
        } catch (NoSuchAlgorithmException e) {
            throw new OperatorCreationException("unable to find algorithm: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new OperatorCreationException("unable to find provider: " + e2.getMessage(), e2);
        } catch (InvalidKeyException e3) {
            throw new OperatorCreationException("invalid key: " + e3.getMessage(), e3);
        }
    }

    public JcaEACSignerBuilder setProvider(String str) {
        this.helper = new NamedEACHelper(str);
        return this;
    }

    public JcaEACSignerBuilder setProvider(Provider provider) {
        this.helper = new ProviderEACHelper(provider);
        return this;
    }
}
