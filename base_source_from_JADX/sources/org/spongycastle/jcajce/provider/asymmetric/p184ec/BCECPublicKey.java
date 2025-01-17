package org.spongycastle.jcajce.provider.asymmetric.p184ec;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.p176x9.X9ECPoint;
import org.spongycastle.asn1.p176x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey */
public class BCECPublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 2422789860422731812L;
    private String algorithm = "EC";
    private transient ProviderConfiguration configuration;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private boolean withCompression;

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.ecSpec = eCPublicKeySpec.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, eCPublicKeySpec.getW(), false), EC5Util.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
        this.configuration = providerConfiguration;
    }

    BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.configuration = providerConfiguration;
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        this.ecPublicKey = eCPublicKeyParameters;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = str;
        this.ecPublicKey = bCECPublicKey.ecPublicKey;
        this.ecSpec = bCECPublicKey.ecSpec;
        this.withCompression = bCECPublicKey.withCompression;
        this.configuration = bCECPublicKey.configuration;
    }

    public BCECPublicKey(String str, org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
        } else {
            this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, (ECParameterSpec) null));
            this.ecSpec = null;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = eCPublicKey.getAlgorithm();
        this.ecSpec = eCPublicKey.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, eCPublicKey.getW(), false), EC5Util.getDomainParameters(providerConfiguration, eCPublicKey.getParams()));
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX WARNING: type inference failed for: r7v6, types: [org.spongycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r7) {
        /*
            r6 = this;
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r7.getAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X962Parameters r0 = org.spongycastle.asn1.p176x9.X962Parameters.getInstance(r0)
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r1 = r6.configuration
            org.spongycastle.math.ec.ECCurve r1 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.getCurve(r1, r0)
            java.security.spec.ECParameterSpec r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertToSpec(r0, r1)
            r6.ecSpec = r2
            org.spongycastle.asn1.DERBitString r7 = r7.getPublicKeyData()
            byte[] r7 = r7.getBytes()
            org.spongycastle.asn1.DEROctetString r2 = new org.spongycastle.asn1.DEROctetString
            r2.<init>((byte[]) r7)
            r3 = 0
            byte r3 = r7[r3]
            r4 = 4
            if (r3 != r4) goto L_0x0059
            r3 = 1
            byte r3 = r7[r3]
            int r4 = r7.length
            r5 = 2
            int r4 = r4 - r5
            if (r3 != r4) goto L_0x0059
            byte r3 = r7[r5]
            r4 = 3
            if (r3 == r5) goto L_0x003c
            byte r3 = r7[r5]
            if (r3 != r4) goto L_0x0059
        L_0x003c:
            org.spongycastle.asn1.x9.X9IntegerConverter r3 = new org.spongycastle.asn1.x9.X9IntegerConverter
            r3.<init>()
            int r3 = r3.getByteLength((org.spongycastle.math.p186ec.ECCurve) r1)
            int r5 = r7.length
            int r5 = r5 - r4
            if (r3 < r5) goto L_0x0059
            org.spongycastle.asn1.ASN1Primitive r7 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r7)     // Catch:{ IOException -> 0x0051 }
            r2 = r7
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r7.<init>(r0)
            throw r7
        L_0x0059:
            org.spongycastle.asn1.x9.X9ECPoint r7 = new org.spongycastle.asn1.x9.X9ECPoint
            r7.<init>((org.spongycastle.math.p186ec.ECCurve) r1, (org.spongycastle.asn1.ASN1OctetString) r2)
            org.spongycastle.crypto.params.ECPublicKeyParameters r1 = new org.spongycastle.crypto.params.ECPublicKeyParameters
            org.spongycastle.math.ec.ECPoint r7 = r7.getPoint()
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r2 = r6.configuration
            org.spongycastle.crypto.params.ECDomainParameters r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getDomainParameters((org.spongycastle.jcajce.provider.config.ProviderConfiguration) r2, (org.spongycastle.asn1.p176x9.X962Parameters) r0)
            r1.<init>(r7, r0)
            r6.ecPublicKey = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.p184ec.BCECPublicKey.populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.configuration = BouncyCastleProvider.CONFIGURATION;
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* access modifiers changed from: package-private */
    public ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    /* access modifiers changed from: package-private */
    public org.spongycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : this.configuration.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        return this.ecPublicKey.getQ().equals(bCECPublicKey.ecPublicKey.getQ()) && engineGetSpec().equals(bCECPublicKey.engineGetSpec());
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, ECUtils.getDomainParametersFromName(this.ecSpec, this.withCompression)), ASN1OctetString.getInstance(new X9ECPoint(this.ecPublicKey.getQ(), this.withCompression).toASN1Primitive()).getOctets()));
    }

    public String getFormat() {
        return "X.509";
    }

    public org.spongycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.withCompression);
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public org.spongycastle.math.p186ec.ECPoint getQ() {
        org.spongycastle.math.p186ec.ECPoint q = this.ecPublicKey.getQ();
        return this.ecSpec == null ? q.getDetachedPoint() : q;
    }

    public ECPoint getW() {
        org.spongycastle.math.p186ec.ECPoint q = this.ecPublicKey.getQ();
        return new ECPoint(q.getAffineXCoord().toBigInteger(), q.getAffineYCoord().toBigInteger());
    }

    public int hashCode() {
        return this.ecPublicKey.getQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return ECUtil.publicKeyToString("EC", this.ecPublicKey.getQ(), engineGetSpec());
    }
}
