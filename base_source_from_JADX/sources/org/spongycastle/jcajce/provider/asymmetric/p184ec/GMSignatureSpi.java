package org.spongycastle.jcajce.provider.asymmetric.p184ec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.SM2Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.DSABase;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.util.Arrays;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi */
public class GMSignatureSpi extends DSABase {

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$StdDSAEncoder */
    private static class StdDSAEncoder implements DSAEncoder {
        private StdDSAEncoder() {
        }

        public BigInteger[] decode(byte[] bArr) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.fromByteArray(bArr);
            if (aSN1Sequence.size() != 2) {
                throw new IOException("malformed signature");
            } else if (Arrays.areEqual(bArr, aSN1Sequence.getEncoded(ASN1Encoding.DER))) {
                return new BigInteger[]{ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue(), ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue()};
            } else {
                throw new IOException("malformed signature");
            }
        }

        public byte[] encode(BigInteger bigInteger, BigInteger bigInteger2) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
            aSN1EncodableVector.add(new ASN1Integer(bigInteger2));
            return new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sm3WithSM2 */
    public static class sm3WithSM2 extends GMSignatureSpi {
        public sm3WithSM2() {
            super(new SM3Digest(), new SM2Signer(), new StdDSAEncoder());
        }
    }

    GMSignatureSpi(Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        super(digest, dsa, dSAEncoder);
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) {
        AsymmetricKeyParameter generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
        this.digest.reset();
        if (this.appRandom != null) {
            this.signer.init(true, new ParametersWithRandom(generatePrivateKeyParameter, this.appRandom));
        } else {
            this.signer.init(true, generatePrivateKeyParameter);
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) {
        AsymmetricKeyParameter generatePublicKeyParameter = ECUtils.generatePublicKeyParameter(publicKey);
        this.digest.reset();
        this.signer.init(false, generatePublicKeyParameter);
    }
}
