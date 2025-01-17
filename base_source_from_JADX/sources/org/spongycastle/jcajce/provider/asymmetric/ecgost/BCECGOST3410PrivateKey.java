package org.spongycastle.jcajce.provider.asymmetric.ecgost;

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

public class BCECGOST3410PrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm = "ECGOST3410";
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: d */
    private transient BigInteger f7931d;
    private transient ECParameterSpec ecSpec;
    private transient ASN1Encodable gostParams;
    private transient DERBitString publicKey;
    private boolean withCompression;

    protected BCECGOST3410PrivateKey() {
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = str;
        this.f7931d = eCPrivateKeyParameters.getD();
        this.ecSpec = null;
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f7931d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(parameters.getG().getAffineXCoord().toBigInteger(), parameters.getG().getAffineYCoord().toBigInteger()), parameters.getN(), parameters.getH().intValue());
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.gostParams = bCECGOST3410PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f7931d = eCPrivateKeyParameters.getD();
        this.ecSpec = eCParameterSpec == null ? new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(parameters.getG().getAffineXCoord().toBigInteger(), parameters.getG().getAffineYCoord().toBigInteger()), parameters.getN(), parameters.getH().intValue()) : new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        this.gostParams = bCECGOST3410PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(ECPrivateKey eCPrivateKey) {
        this.f7931d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.f7931d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    BCECGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) {
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey bCECGOST3410PrivateKey) {
        this.f7931d = bCECGOST3410PrivateKey.f7931d;
        this.ecSpec = bCECGOST3410PrivateKey.ecSpec;
        this.withCompression = bCECGOST3410PrivateKey.withCompression;
        this.attrCarrier = bCECGOST3410PrivateKey.attrCarrier;
        this.publicKey = bCECGOST3410PrivateKey.publicKey;
        this.gostParams = bCECGOST3410PrivateKey.gostParams;
    }

    public BCECGOST3410PrivateKey(org.spongycastle.jce.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.f7931d = eCPrivateKeySpec.getD();
        this.ecSpec = eCPrivateKeySpec.getParams() != null ? EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams()) : null;
    }

    private void extractBytes(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, bArr2.length - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    private DERBitString getPublicKeyDetails(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCECGOST3410PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPrivKeyInfo(org.spongycastle.asn1.pkcs.PrivateKeyInfo r11) {
        /*
            r10 = this;
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()
            boolean r1 = r0 instanceof org.spongycastle.asn1.ASN1Sequence
            if (r1 == 0) goto L_0x00b4
            org.spongycastle.asn1.ASN1Sequence r1 = org.spongycastle.asn1.ASN1Sequence.getInstance(r0)
            int r1 = r1.size()
            r2 = 2
            if (r1 == r2) goto L_0x0026
            org.spongycastle.asn1.ASN1Sequence r0 = org.spongycastle.asn1.ASN1Sequence.getInstance(r0)
            int r0 = r0.size()
            r1 = 3
            if (r0 != r1) goto L_0x00b4
        L_0x0026:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r0 = org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.getInstance(r0)
            r10.gostParams = r0
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r0.getPublicKeyParamSet()
            java.lang.String r1 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r1)
            org.spongycastle.jce.spec.ECNamedCurveParameterSpec r1 = org.spongycastle.jce.ECGOST3410NamedCurveTable.getParameterSpec(r1)
            org.spongycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            org.spongycastle.jce.spec.ECNamedCurveSpec r2 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r0.getPublicKeyParamSet()
            java.lang.String r5 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r0)
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
            r10.ecSpec = r2
            org.spongycastle.asn1.ASN1Encodable r11 = r11.parsePrivateKey()
            boolean r0 = r11 instanceof org.spongycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x0093
            org.spongycastle.asn1.ASN1Integer r11 = org.spongycastle.asn1.ASN1Integer.getInstance(r11)
            java.math.BigInteger r11 = r11.getPositiveValue()
            goto L_0x01af
        L_0x0093:
            org.spongycastle.asn1.ASN1OctetString r11 = org.spongycastle.asn1.ASN1OctetString.getInstance(r11)
            byte[] r11 = r11.getOctets()
            int r0 = r11.length
            byte[] r0 = new byte[r0]
            r1 = 0
        L_0x009f:
            int r2 = r11.length
            r3 = 1
            if (r1 == r2) goto L_0x00ad
            int r2 = r11.length
            int r2 = r2 - r3
            int r2 = r2 - r1
            byte r2 = r11[r2]
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x009f
        L_0x00ad:
            java.math.BigInteger r11 = new java.math.BigInteger
            r11.<init>(r3, r0)
            goto L_0x01af
        L_0x00b4:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X962Parameters r0 = org.spongycastle.asn1.p176x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x0151
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            org.spongycastle.asn1.x9.X9ECParameters r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            if (r1 != 0) goto L_0x0115
            org.spongycastle.crypto.params.ECDomainParameters r1 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getByOID(r0)
            org.spongycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            org.spongycastle.jce.spec.ECNamedCurveSpec r2 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r5 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r0)
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
            goto L_0x019d
        L_0x0115:
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
            goto L_0x019d
        L_0x0151:
            boolean r1 = r0.isImplicitlyCA()
            if (r1 == 0) goto L_0x015b
            r0 = 0
            r10.ecSpec = r0
            goto L_0x019f
        L_0x015b:
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
        L_0x019d:
            r10.ecSpec = r2
        L_0x019f:
            org.spongycastle.asn1.ASN1Encodable r11 = r11.parsePrivateKey()
            boolean r0 = r11 instanceof org.spongycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x01b2
            org.spongycastle.asn1.ASN1Integer r11 = org.spongycastle.asn1.ASN1Integer.getInstance(r11)
            java.math.BigInteger r11 = r11.getValue()
        L_0x01af:
            r10.f7931d = r11
            goto L_0x01c2
        L_0x01b2:
            org.spongycastle.asn1.sec.ECPrivateKey r11 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(r11)
            java.math.BigInteger r0 = r11.getKey()
            r10.f7931d = r0
            org.spongycastle.asn1.DERBitString r11 = r11.getPublicKey()
            r10.publicKey = r11
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.populateFromPrivKeyInfo(org.spongycastle.asn1.pkcs.PrivateKeyInfo):void");
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
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        return getD().equals(bCECGOST3410PrivateKey.getD()) && engineGetSpec().equals(bCECGOST3410PrivateKey.engineGetSpec());
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
        return this.f7931d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r8 = this;
            org.spongycastle.asn1.ASN1Encodable r0 = r8.gostParams
            r1 = 0
            if (r0 == 0) goto L_0x002c
            r0 = 32
            byte[] r0 = new byte[r0]
            r2 = 0
            java.math.BigInteger r3 = r8.getS()
            r8.extractBytes(r0, r2, r3)
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r2 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x002b }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x002b }
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001     // Catch:{ IOException -> 0x002b }
            org.spongycastle.asn1.ASN1Encodable r5 = r8.gostParams     // Catch:{ IOException -> 0x002b }
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x002b }
            org.spongycastle.asn1.DEROctetString r4 = new org.spongycastle.asn1.DEROctetString     // Catch:{ IOException -> 0x002b }
            r4.<init>((byte[]) r0)     // Catch:{ IOException -> 0x002b }
            r2.<init>(r3, r4)     // Catch:{ IOException -> 0x002b }
            java.lang.String r0 = "DER"
            byte[] r0 = r2.getEncoded(r0)     // Catch:{ IOException -> 0x002b }
            return r0
        L_0x002b:
            return r1
        L_0x002c:
            java.security.spec.ECParameterSpec r0 = r8.ecSpec
            boolean r2 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec
            if (r2 == 0) goto L_0x0051
            org.spongycastle.jce.spec.ECNamedCurveSpec r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0
            java.lang.String r0 = r0.getName()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveOid((java.lang.String) r0)
            if (r0 != 0) goto L_0x004b
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier
            java.security.spec.ECParameterSpec r2 = r8.ecSpec
            org.spongycastle.jce.spec.ECNamedCurveSpec r2 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r2
            java.lang.String r2 = r2.getName()
            r0.<init>((java.lang.String) r2)
        L_0x004b:
            org.spongycastle.asn1.x9.X962Parameters r2 = new org.spongycastle.asn1.x9.X962Parameters
            r2.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r0)
            goto L_0x009f
        L_0x0051:
            if (r0 != 0) goto L_0x0065
            org.spongycastle.asn1.x9.X962Parameters r2 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.DERNull r0 = org.spongycastle.asn1.DERNull.INSTANCE
            r2.<init>((org.spongycastle.asn1.ASN1Null) r0)
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.math.BigInteger r3 = r8.getS()
            int r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getOrderBitLength(r0, r1, r3)
            goto L_0x00af
        L_0x0065:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            org.spongycastle.math.ec.ECCurve r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r0)
            org.spongycastle.asn1.x9.X9ECParameters r0 = new org.spongycastle.asn1.x9.X9ECParameters
            java.security.spec.ECParameterSpec r2 = r8.ecSpec
            java.security.spec.ECPoint r2 = r2.getGenerator()
            boolean r4 = r8.withCompression
            org.spongycastle.math.ec.ECPoint r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint((org.spongycastle.math.p186ec.ECCurve) r3, (java.security.spec.ECPoint) r2, (boolean) r4)
            java.security.spec.ECParameterSpec r2 = r8.ecSpec
            java.math.BigInteger r5 = r2.getOrder()
            java.security.spec.ECParameterSpec r2 = r8.ecSpec
            int r2 = r2.getCofactor()
            long r6 = (long) r2
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r6)
            java.security.spec.ECParameterSpec r2 = r8.ecSpec
            java.security.spec.EllipticCurve r2 = r2.getCurve()
            byte[] r7 = r2.getSeed()
            r2 = r0
            r2.<init>((org.spongycastle.math.p186ec.ECCurve) r3, (org.spongycastle.math.p186ec.ECPoint) r4, (java.math.BigInteger) r5, (java.math.BigInteger) r6, (byte[]) r7)
            org.spongycastle.asn1.x9.X962Parameters r2 = new org.spongycastle.asn1.x9.X962Parameters
            r2.<init>((org.spongycastle.asn1.p176x9.X9ECParameters) r0)
        L_0x009f:
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.security.spec.ECParameterSpec r3 = r8.ecSpec
            java.math.BigInteger r3 = r3.getOrder()
            java.math.BigInteger r4 = r8.getS()
            int r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getOrderBitLength(r0, r3, r4)
        L_0x00af:
            org.spongycastle.asn1.DERBitString r3 = r8.publicKey
            if (r3 == 0) goto L_0x00bf
            org.spongycastle.asn1.sec.ECPrivateKey r3 = new org.spongycastle.asn1.sec.ECPrivateKey
            java.math.BigInteger r4 = r8.getS()
            org.spongycastle.asn1.DERBitString r5 = r8.publicKey
            r3.<init>(r0, r4, r5, r2)
            goto L_0x00c8
        L_0x00bf:
            org.spongycastle.asn1.sec.ECPrivateKey r3 = new org.spongycastle.asn1.sec.ECPrivateKey
            java.math.BigInteger r4 = r8.getS()
            r3.<init>((int) r0, (java.math.BigInteger) r4, (org.spongycastle.asn1.ASN1Encodable) r2)
        L_0x00c8:
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00e3 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x00e3 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001     // Catch:{ IOException -> 0x00e3 }
            org.spongycastle.asn1.ASN1Primitive r2 = r2.toASN1Primitive()     // Catch:{ IOException -> 0x00e3 }
            r4.<init>(r5, r2)     // Catch:{ IOException -> 0x00e3 }
            org.spongycastle.asn1.ASN1Primitive r2 = r3.toASN1Primitive()     // Catch:{ IOException -> 0x00e3 }
            r0.<init>(r4, r2)     // Catch:{ IOException -> 0x00e3 }
            java.lang.String r2 = "DER"
            byte[] r0 = r0.getEncoded(r2)     // Catch:{ IOException -> 0x00e3 }
            return r0
        L_0x00e3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.getEncoded():byte[]");
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
        return this.f7931d;
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
        return ECUtil.privateKeyToString(this.algorithm, this.f7931d, engineGetSpec());
    }
}
