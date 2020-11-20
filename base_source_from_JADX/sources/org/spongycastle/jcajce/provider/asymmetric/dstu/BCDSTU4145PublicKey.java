package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.p175ua.DSTU4145Params;
import org.spongycastle.asn1.p175ua.DSTU4145PointEncoder;
import org.spongycastle.asn1.p175ua.UAObjectIdentifiers;
import org.spongycastle.asn1.p176x9.X962Parameters;
import org.spongycastle.asn1.p176x9.X9ECParameters;
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
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.p186ec.ECCurve;

public class BCDSTU4145PublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm = "DSTU4145";
    private transient DSTU4145Params dstuParams;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private boolean withCompression;

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        this.ecPublicKey = eCPublicKeyParameters;
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.ecSpec = eCPublicKeySpec.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, eCPublicKeySpec.getW(), false), EC5Util.getDomainParameters((ProviderConfiguration) null, this.ecSpec));
    }

    BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        this.ecPublicKey = bCDSTU4145PublicKey.ecPublicKey;
        this.ecSpec = bCDSTU4145PublicKey.ecSpec;
        this.withCompression = bCDSTU4145PublicKey.withCompression;
        this.dstuParams = bCDSTU4145PublicKey.dstuParams;
    }

    public BCDSTU4145PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
            return;
        }
        this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, (ECParameterSpec) null));
        this.ecSpec = null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: org.spongycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: org.spongycastle.jce.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: org.spongycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: org.spongycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r13) {
        /*
            r12 = this;
            org.spongycastle.asn1.DERBitString r0 = r13.getPublicKeyData()
            java.lang.String r1 = "DSTU4145"
            r12.algorithm = r1
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x015c }
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r0)     // Catch:{ IOException -> 0x015c }
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x015c }
            byte[] r0 = r0.getOctets()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r13.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.p175ua.UAObjectIdentifiers.dstu4145le
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0029
            r12.reverseBytes(r0)
        L_0x0029:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r13.getAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r1 = r1.getParameters()
            org.spongycastle.asn1.ASN1Sequence r1 = (org.spongycastle.asn1.ASN1Sequence) r1
            org.spongycastle.asn1.ua.DSTU4145Params r1 = org.spongycastle.asn1.p175ua.DSTU4145Params.getInstance(r1)
            r12.dstuParams = r1
            org.spongycastle.asn1.ua.DSTU4145Params r1 = r12.dstuParams
            boolean r1 = r1.isNamedCurve()
            if (r1 == 0) goto L_0x006a
            org.spongycastle.asn1.ua.DSTU4145Params r13 = r12.dstuParams
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = r13.getNamedCurve()
            org.spongycastle.crypto.params.ECDomainParameters r1 = org.spongycastle.asn1.p175ua.DSTU4145NamedCurves.getByOID(r13)
            org.spongycastle.jce.spec.ECNamedCurveParameterSpec r9 = new org.spongycastle.jce.spec.ECNamedCurveParameterSpec
            java.lang.String r3 = r13.getId()
            org.spongycastle.math.ec.ECCurve r4 = r1.getCurve()
            org.spongycastle.math.ec.ECPoint r5 = r1.getG()
            java.math.BigInteger r6 = r1.getN()
            java.math.BigInteger r7 = r1.getH()
            byte[] r8 = r1.getSeed()
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x00cf
        L_0x006a:
            org.spongycastle.asn1.ua.DSTU4145Params r1 = r12.dstuParams
            org.spongycastle.asn1.ua.DSTU4145ECBinary r1 = r1.getECBinary()
            byte[] r2 = r1.getB()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = r13.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r3.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.p175ua.UAObjectIdentifiers.dstu4145le
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0087
            r12.reverseBytes(r2)
        L_0x0087:
            org.spongycastle.asn1.ua.DSTU4145BinaryField r3 = r1.getField()
            org.spongycastle.math.ec.ECCurve$F2m r11 = new org.spongycastle.math.ec.ECCurve$F2m
            int r5 = r3.getM()
            int r6 = r3.getK1()
            int r7 = r3.getK2()
            int r8 = r3.getK3()
            java.math.BigInteger r9 = r1.getA()
            java.math.BigInteger r10 = new java.math.BigInteger
            r3 = 1
            r10.<init>(r3, r2)
            r4 = r11
            r4.<init>((int) r5, (int) r6, (int) r7, (int) r8, (java.math.BigInteger) r9, (java.math.BigInteger) r10)
            byte[] r2 = r1.getG()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r13 = r13.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = r13.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.p175ua.UAObjectIdentifiers.dstu4145le
            boolean r13 = r13.equals(r3)
            if (r13 == 0) goto L_0x00c2
            r12.reverseBytes(r2)
        L_0x00c2:
            org.spongycastle.jce.spec.ECParameterSpec r9 = new org.spongycastle.jce.spec.ECParameterSpec
            org.spongycastle.math.ec.ECPoint r13 = org.spongycastle.asn1.p175ua.DSTU4145PointEncoder.decodePoint(r11, r2)
            java.math.BigInteger r1 = r1.getN()
            r9.<init>(r11, r13, r1)
        L_0x00cf:
            org.spongycastle.math.ec.ECCurve r13 = r9.getCurve()
            byte[] r1 = r9.getSeed()
            java.security.spec.EllipticCurve r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r13, r1)
            org.spongycastle.asn1.ua.DSTU4145Params r1 = r12.dstuParams
            boolean r1 = r1.isNamedCurve()
            if (r1 == 0) goto L_0x0119
            org.spongycastle.jce.spec.ECNamedCurveSpec r1 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            org.spongycastle.asn1.ua.DSTU4145Params r2 = r12.dstuParams
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r2.getNamedCurve()
            java.lang.String r3 = r2.getId()
            java.security.spec.ECPoint r5 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r2 = r9.getG()
            org.spongycastle.math.ec.ECFieldElement r2 = r2.getAffineXCoord()
            java.math.BigInteger r2 = r2.toBigInteger()
            org.spongycastle.math.ec.ECPoint r6 = r9.getG()
            org.spongycastle.math.ec.ECFieldElement r6 = r6.getAffineYCoord()
            java.math.BigInteger r6 = r6.toBigInteger()
            r5.<init>(r2, r6)
            java.math.BigInteger r6 = r9.getN()
            java.math.BigInteger r7 = r9.getH()
            r2 = r1
            r2.<init>((java.lang.String) r3, (java.security.spec.EllipticCurve) r4, (java.security.spec.ECPoint) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7)
            goto L_0x0147
        L_0x0119:
            java.security.spec.ECParameterSpec r1 = new java.security.spec.ECParameterSpec
            java.security.spec.ECPoint r2 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r3 = r9.getG()
            org.spongycastle.math.ec.ECFieldElement r3 = r3.getAffineXCoord()
            java.math.BigInteger r3 = r3.toBigInteger()
            org.spongycastle.math.ec.ECPoint r5 = r9.getG()
            org.spongycastle.math.ec.ECFieldElement r5 = r5.getAffineYCoord()
            java.math.BigInteger r5 = r5.toBigInteger()
            r2.<init>(r3, r5)
            java.math.BigInteger r3 = r9.getN()
            java.math.BigInteger r5 = r9.getH()
            int r5 = r5.intValue()
            r1.<init>(r4, r2, r3, r5)
        L_0x0147:
            r12.ecSpec = r1
            org.spongycastle.crypto.params.ECPublicKeyParameters r1 = new org.spongycastle.crypto.params.ECPublicKeyParameters
            org.spongycastle.math.ec.ECPoint r13 = org.spongycastle.asn1.p175ua.DSTU4145PointEncoder.decodePoint(r13, r0)
            r0 = 0
            java.security.spec.ECParameterSpec r2 = r12.ecSpec
            org.spongycastle.crypto.params.ECDomainParameters r0 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.getDomainParameters(r0, r2)
            r1.<init>(r13, r0)
            r12.ecPublicKey = r1
            return
        L_0x015c:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey.populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void reverseBytes(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
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
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        return this.ecPublicKey.getQ().equals(bCDSTU4145PublicKey.ecPublicKey.getQ()) && engineGetSpec().equals(bCDSTU4145PublicKey.engineGetSpec());
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        ASN1Encodable aSN1Encodable;
        DSTU4145Params dSTU4145Params = this.dstuParams;
        if (dSTU4145Params != null) {
            aSN1Encodable = dSTU4145Params;
        } else {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                aSN1Encodable = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) eCParameterSpec).getName()));
            } else {
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                aSN1Encodable = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
        }
        try {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, aSN1Encodable), (ASN1Encodable) new DEROctetString(DSTU4145PointEncoder.encodePoint(this.ecPublicKey.getQ()))));
        } catch (IOException unused) {
            return null;
        }
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

    public byte[] getSbox() {
        DSTU4145Params dSTU4145Params = this.dstuParams;
        return dSTU4145Params != null ? dSTU4145Params.getDKE() : DSTU4145Params.getDefaultDKE();
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
        return ECUtil.publicKeyToString(this.algorithm, this.ecPublicKey.getQ(), engineGetSpec());
    }
}
