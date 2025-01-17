package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class BCDSTU4145PrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm = "DSTU4145";
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: d */
    private transient BigInteger f7929d;
    private transient ECParameterSpec ecSpec;
    private transient DERBitString publicKey;
    private boolean withCompression;

    protected BCDSTU4145PrivateKey() {
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = str;
        this.f7929d = eCPrivateKeyParameters.getD();
        this.ecSpec = null;
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f7929d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(parameters.getG().getAffineXCoord().toBigInteger(), parameters.getG().getAffineYCoord().toBigInteger()), parameters.getN(), parameters.getH().intValue());
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.publicKey = getPublicKeyDetails(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f7929d = eCPrivateKeyParameters.getD();
        this.ecSpec = eCParameterSpec == null ? new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(parameters.getG().getAffineXCoord().toBigInteger(), parameters.getG().getAffineYCoord().toBigInteger()), parameters.getN(), parameters.getH().intValue()) : new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        this.publicKey = getPublicKeyDetails(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(ECPrivateKey eCPrivateKey) {
        this.f7929d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.f7929d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    BCDSTU4145PrivateKey(PrivateKeyInfo privateKeyInfo) {
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey bCDSTU4145PrivateKey) {
        this.f7929d = bCDSTU4145PrivateKey.f7929d;
        this.ecSpec = bCDSTU4145PrivateKey.ecSpec;
        this.withCompression = bCDSTU4145PrivateKey.withCompression;
        this.attrCarrier = bCDSTU4145PrivateKey.attrCarrier;
        this.publicKey = bCDSTU4145PrivateKey.publicKey;
    }

    public BCDSTU4145PrivateKey(org.spongycastle.jce.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.f7929d = eCPrivateKeySpec.getD();
        this.ecSpec = eCPrivateKeySpec.getParams() != null ? EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams()) : null;
    }

    private DERBitString getPublicKeyDetails(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCDSTU4145PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPrivKeyInfo(org.spongycastle.asn1.pkcs.PrivateKeyInfo r11) {
        /*
            r10 = this;
            org.spongycastle.asn1.x9.X962Parameters r0 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r1 = r1.getParameters()
            org.spongycastle.asn1.ASN1Primitive r1 = (org.spongycastle.asn1.ASN1Primitive) r1
            r0.<init>((org.spongycastle.asn1.ASN1Primitive) r1)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x00a0
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            org.spongycastle.asn1.x9.X9ECParameters r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            if (r1 != 0) goto L_0x0064
            org.spongycastle.crypto.params.ECDomainParameters r1 = org.spongycastle.asn1.p175ua.DSTU4145NamedCurves.getByOID(r0)
            org.spongycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            org.spongycastle.jce.spec.ECNamedCurveSpec r2 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r5 = r0.getId()
            java.security.spec.ECPoint r7 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r0 = r1.getG()
            org.spongycastle.math.ec.ECFieldElement r0 = r0.getAffineXCoord()
            java.math.BigInteger r0 = r0.toBigInteger()
            org.spongycastle.math.ec.ECPoint r3 = r1.getG()
            org.spongycastle.math.ec.ECFieldElement r3 = r3.getAffineYCoord()
            java.math.BigInteger r3 = r3.toBigInteger()
            r7.<init>(r0, r3)
            java.math.BigInteger r8 = r1.getN()
            java.math.BigInteger r9 = r1.getH()
            r4 = r2
            r4.<init>((java.lang.String) r5, (java.security.spec.EllipticCurve) r6, (java.security.spec.ECPoint) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9)
            goto L_0x00ec
        L_0x0064:
            org.spongycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            org.spongycastle.jce.spec.ECNamedCurveSpec r2 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r5 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getCurveName(r0)
            java.security.spec.ECPoint r7 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r0 = r1.getG()
            org.spongycastle.math.ec.ECFieldElement r0 = r0.getAffineXCoord()
            java.math.BigInteger r0 = r0.toBigInteger()
            org.spongycastle.math.ec.ECPoint r3 = r1.getG()
            org.spongycastle.math.ec.ECFieldElement r3 = r3.getAffineYCoord()
            java.math.BigInteger r3 = r3.toBigInteger()
            r7.<init>(r0, r3)
            java.math.BigInteger r8 = r1.getN()
            java.math.BigInteger r9 = r1.getH()
            r4 = r2
            r4.<init>((java.lang.String) r5, (java.security.spec.EllipticCurve) r6, (java.security.spec.ECPoint) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9)
            goto L_0x00ec
        L_0x00a0:
            boolean r1 = r0.isImplicitlyCA()
            if (r1 == 0) goto L_0x00aa
            r0 = 0
            r10.ecSpec = r0
            goto L_0x00ee
        L_0x00aa:
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p176x9.X9ECParameters.getInstance(r0)
            org.spongycastle.math.ec.ECCurve r1 = r0.getCurve()
            byte[] r2 = r0.getSeed()
            java.security.spec.EllipticCurve r1 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r1, r2)
            java.security.spec.ECParameterSpec r2 = new java.security.spec.ECParameterSpec
            java.security.spec.ECPoint r3 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r4 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r4 = r4.getAffineXCoord()
            java.math.BigInteger r4 = r4.toBigInteger()
            org.spongycastle.math.ec.ECPoint r5 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r5 = r5.getAffineYCoord()
            java.math.BigInteger r5 = r5.toBigInteger()
            r3.<init>(r4, r5)
            java.math.BigInteger r4 = r0.getN()
            java.math.BigInteger r0 = r0.getH()
            int r0 = r0.intValue()
            r2.<init>(r1, r3, r4, r0)
        L_0x00ec:
            r10.ecSpec = r2
        L_0x00ee:
            org.spongycastle.asn1.ASN1Encodable r11 = r11.parsePrivateKey()
            boolean r0 = r11 instanceof org.spongycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x0101
            org.spongycastle.asn1.ASN1Integer r11 = org.spongycastle.asn1.ASN1Integer.getInstance(r11)
            java.math.BigInteger r11 = r11.getValue()
            r10.f7929d = r11
            goto L_0x0111
        L_0x0101:
            org.spongycastle.asn1.sec.ECPrivateKey r11 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(r11)
            java.math.BigInteger r0 = r11.getKey()
            r10.f7929d = r0
            org.spongycastle.asn1.DERBitString r11 = r11.getPublicKey()
            r10.publicKey = r11
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.populateFromPrivKeyInfo(org.spongycastle.asn1.pkcs.PrivateKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* access modifiers changed from: package-private */
    public org.spongycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        return getD().equals(bCDSTU4145PrivateKey.getD()) && engineGetSpec().equals(bCDSTU4145PrivateKey.engineGetSpec());
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    public BigInteger getD() {
        return this.f7929d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a7 A[Catch:{ IOException -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00bc A[Catch:{ IOException -> 0x00d7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r9 = this;
            java.security.spec.ECParameterSpec r0 = r9.ecSpec
            boolean r1 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec
            r2 = 0
            if (r1 == 0) goto L_0x0026
            org.spongycastle.jce.spec.ECNamedCurveSpec r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0
            java.lang.String r0 = r0.getName()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveOid((java.lang.String) r0)
            if (r0 != 0) goto L_0x0020
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier
            java.security.spec.ECParameterSpec r1 = r9.ecSpec
            org.spongycastle.jce.spec.ECNamedCurveSpec r1 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r1
            java.lang.String r1 = r1.getName()
            r0.<init>((java.lang.String) r1)
        L_0x0020:
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            r1.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r0)
            goto L_0x0074
        L_0x0026:
            if (r0 != 0) goto L_0x003a
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.DERNull r0 = org.spongycastle.asn1.DERNull.INSTANCE
            r1.<init>((org.spongycastle.asn1.ASN1Null) r0)
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.math.BigInteger r3 = r9.getS()
            int r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getOrderBitLength(r0, r2, r3)
            goto L_0x0084
        L_0x003a:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            org.spongycastle.math.ec.ECCurve r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r0)
            org.spongycastle.asn1.x9.X9ECParameters r0 = new org.spongycastle.asn1.x9.X9ECParameters
            java.security.spec.ECParameterSpec r1 = r9.ecSpec
            java.security.spec.ECPoint r1 = r1.getGenerator()
            boolean r3 = r9.withCompression
            org.spongycastle.math.ec.ECPoint r5 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint((org.spongycastle.math.p186ec.ECCurve) r4, (java.security.spec.ECPoint) r1, (boolean) r3)
            java.security.spec.ECParameterSpec r1 = r9.ecSpec
            java.math.BigInteger r6 = r1.getOrder()
            java.security.spec.ECParameterSpec r1 = r9.ecSpec
            int r1 = r1.getCofactor()
            long r7 = (long) r1
            java.math.BigInteger r7 = java.math.BigInteger.valueOf(r7)
            java.security.spec.ECParameterSpec r1 = r9.ecSpec
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            byte[] r8 = r1.getSeed()
            r3 = r0
            r3.<init>((org.spongycastle.math.p186ec.ECCurve) r4, (org.spongycastle.math.p186ec.ECPoint) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7, (byte[]) r8)
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            r1.<init>((org.spongycastle.asn1.p176x9.X9ECParameters) r0)
        L_0x0074:
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.security.spec.ECParameterSpec r3 = r9.ecSpec
            java.math.BigInteger r3 = r3.getOrder()
            java.math.BigInteger r4 = r9.getS()
            int r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getOrderBitLength(r0, r3, r4)
        L_0x0084:
            org.spongycastle.asn1.DERBitString r3 = r9.publicKey
            if (r3 == 0) goto L_0x0094
            org.spongycastle.asn1.sec.ECPrivateKey r3 = new org.spongycastle.asn1.sec.ECPrivateKey
            java.math.BigInteger r4 = r9.getS()
            org.spongycastle.asn1.DERBitString r5 = r9.publicKey
            r3.<init>(r0, r4, r5, r1)
            goto L_0x009d
        L_0x0094:
            org.spongycastle.asn1.sec.ECPrivateKey r3 = new org.spongycastle.asn1.sec.ECPrivateKey
            java.math.BigInteger r4 = r9.getS()
            r3.<init>((int) r0, (java.math.BigInteger) r4, (org.spongycastle.asn1.ASN1Encodable) r1)
        L_0x009d:
            java.lang.String r0 = r9.algorithm     // Catch:{ IOException -> 0x00d7 }
            java.lang.String r4 = "DSTU4145"
            boolean r0 = r0.equals(r4)     // Catch:{ IOException -> 0x00d7 }
            if (r0 == 0) goto L_0x00bc
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.p175ua.UAObjectIdentifiers.dstu4145be     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.ASN1Primitive r1 = r1.toASN1Primitive()     // Catch:{ IOException -> 0x00d7 }
            r4.<init>(r5, r1)     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.ASN1Primitive r1 = r3.toASN1Primitive()     // Catch:{ IOException -> 0x00d7 }
            r0.<init>(r4, r1)     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00d0
        L_0x00bc:
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.p176x9.X9ObjectIdentifiers.id_ecPublicKey     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.ASN1Primitive r1 = r1.toASN1Primitive()     // Catch:{ IOException -> 0x00d7 }
            r4.<init>(r5, r1)     // Catch:{ IOException -> 0x00d7 }
            org.spongycastle.asn1.ASN1Primitive r1 = r3.toASN1Primitive()     // Catch:{ IOException -> 0x00d7 }
            r0.<init>(r4, r1)     // Catch:{ IOException -> 0x00d7 }
        L_0x00d0:
            java.lang.String r1 = "DER"
            byte[] r0 = r0.getEncoded(r1)     // Catch:{ IOException -> 0x00d7 }
            return r0
        L_0x00d7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.getEncoded():byte[]");
    }

    public String getFormat() {
        return "PKCS#8";
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

    public BigInteger getS() {
        return this.f7929d;
    }

    public int hashCode() {
        return getD().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return ECUtil.privateKeyToString(this.algorithm, this.f7929d, engineGetSpec());
    }
}
