package org.spongycastle.jcajce.provider.asymmetric.ecgost12;

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
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
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

public class BCECGOST3410_2012PrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm = "ECGOST3410-2012";
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: d */
    private transient BigInteger f7932d;
    private transient ECParameterSpec ecSpec;
    private transient GOST3410PublicKeyAlgParameters gostParams;
    private transient DERBitString publicKey;
    private boolean withCompression;

    protected BCECGOST3410_2012PrivateKey() {
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = str;
        this.f7932d = eCPrivateKeyParameters.getD();
        this.ecSpec = null;
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f7932d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(parameters.getG().getAffineXCoord().toBigInteger(), parameters.getG().getAffineYCoord().toBigInteger()), parameters.getN(), parameters.getH().intValue());
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.gostParams = bCECGOST3410_2012PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410_2012PublicKey);
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f7932d = eCPrivateKeyParameters.getD();
        this.ecSpec = eCParameterSpec == null ? new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(parameters.getG().getAffineXCoord().toBigInteger(), parameters.getG().getAffineYCoord().toBigInteger()), parameters.getN(), parameters.getH().intValue()) : new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        this.gostParams = bCECGOST3410_2012PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410_2012PublicKey);
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKey eCPrivateKey) {
        this.f7932d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.f7932d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    BCECGOST3410_2012PrivateKey(PrivateKeyInfo privateKeyInfo) {
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCECGOST3410_2012PrivateKey(BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey) {
        this.f7932d = bCECGOST3410_2012PrivateKey.f7932d;
        this.ecSpec = bCECGOST3410_2012PrivateKey.ecSpec;
        this.withCompression = bCECGOST3410_2012PrivateKey.withCompression;
        this.attrCarrier = bCECGOST3410_2012PrivateKey.attrCarrier;
        this.publicKey = bCECGOST3410_2012PrivateKey.publicKey;
        this.gostParams = bCECGOST3410_2012PrivateKey.gostParams;
    }

    public BCECGOST3410_2012PrivateKey(org.spongycastle.jce.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.f7932d = eCPrivateKeySpec.getD();
        this.ecSpec = eCPrivateKeySpec.getParams() != null ? EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams()) : null;
    }

    private void extractBytes(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, bArr2.length - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    private DERBitString getPublicKeyDetails(BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCECGOST3410_2012PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPrivKeyInfo(org.spongycastle.asn1.pkcs.PrivateKeyInfo r11) {
        /*
            r10 = this;
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()
            boolean r1 = r0 instanceof org.spongycastle.asn1.ASN1Sequence
            if (r1 == 0) goto L_0x00b8
            org.spongycastle.asn1.ASN1Sequence r1 = org.spongycastle.asn1.ASN1Sequence.getInstance(r0)
            int r1 = r1.size()
            r2 = 2
            if (r1 == r2) goto L_0x0026
            org.spongycastle.asn1.ASN1Sequence r0 = org.spongycastle.asn1.ASN1Sequence.getInstance(r0)
            int r0 = r0.size()
            r1 = 3
            if (r0 != r1) goto L_0x00b8
        L_0x0026:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r0 = org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.getInstance(r0)
            r10.gostParams = r0
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r0 = r10.gostParams
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r0.getPublicKeyParamSet()
            java.lang.String r0 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r0)
            org.spongycastle.jce.spec.ECNamedCurveParameterSpec r0 = org.spongycastle.jce.ECGOST3410NamedCurveTable.getParameterSpec(r0)
            org.spongycastle.math.ec.ECCurve r1 = r0.getCurve()
            byte[] r2 = r0.getSeed()
            java.security.spec.EllipticCurve r5 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r1, r2)
            org.spongycastle.jce.spec.ECNamedCurveSpec r1 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r2 = r10.gostParams
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r2.getPublicKeyParamSet()
            java.lang.String r4 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r2)
            java.security.spec.ECPoint r6 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r2 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r2 = r2.getAffineXCoord()
            java.math.BigInteger r2 = r2.toBigInteger()
            org.spongycastle.math.ec.ECPoint r3 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r3 = r3.getAffineYCoord()
            java.math.BigInteger r3 = r3.toBigInteger()
            r6.<init>(r2, r3)
            java.math.BigInteger r7 = r0.getN()
            java.math.BigInteger r8 = r0.getH()
            r3 = r1
            r3.<init>((java.lang.String) r4, (java.security.spec.EllipticCurve) r5, (java.security.spec.ECPoint) r6, (java.math.BigInteger) r7, (java.math.BigInteger) r8)
            r10.ecSpec = r1
            org.spongycastle.asn1.ASN1Encodable r11 = r11.parsePrivateKey()
            boolean r0 = r11 instanceof org.spongycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x0097
            org.spongycastle.asn1.ASN1Integer r11 = org.spongycastle.asn1.ASN1Integer.getInstance(r11)
            java.math.BigInteger r11 = r11.getPositiveValue()
            goto L_0x01b3
        L_0x0097:
            org.spongycastle.asn1.ASN1OctetString r11 = org.spongycastle.asn1.ASN1OctetString.getInstance(r11)
            byte[] r11 = r11.getOctets()
            int r0 = r11.length
            byte[] r0 = new byte[r0]
            r1 = 0
        L_0x00a3:
            int r2 = r11.length
            r3 = 1
            if (r1 == r2) goto L_0x00b1
            int r2 = r11.length
            int r2 = r2 - r3
            int r2 = r2 - r1
            byte r2 = r11[r2]
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x00a3
        L_0x00b1:
            java.math.BigInteger r11 = new java.math.BigInteger
            r11.<init>(r3, r0)
            goto L_0x01b3
        L_0x00b8:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.getPrivateKeyAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X962Parameters r0 = org.spongycastle.asn1.p176x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x0155
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            org.spongycastle.asn1.x9.X9ECParameters r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            if (r1 != 0) goto L_0x0119
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
            goto L_0x01a1
        L_0x0119:
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
            goto L_0x01a1
        L_0x0155:
            boolean r1 = r0.isImplicitlyCA()
            if (r1 == 0) goto L_0x015f
            r0 = 0
            r10.ecSpec = r0
            goto L_0x01a3
        L_0x015f:
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
        L_0x01a1:
            r10.ecSpec = r2
        L_0x01a3:
            org.spongycastle.asn1.ASN1Encodable r11 = r11.parsePrivateKey()
            boolean r0 = r11 instanceof org.spongycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x01b6
            org.spongycastle.asn1.ASN1Integer r11 = org.spongycastle.asn1.ASN1Integer.getInstance(r11)
            java.math.BigInteger r11 = r11.getValue()
        L_0x01b3:
            r10.f7932d = r11
            goto L_0x01c6
        L_0x01b6:
            org.spongycastle.asn1.sec.ECPrivateKey r11 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(r11)
            java.math.BigInteger r0 = r11.getKey()
            r10.f7932d = r0
            org.spongycastle.asn1.DERBitString r11 = r11.getPublicKey()
            r10.publicKey = r11
        L_0x01c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost12.BCECGOST3410_2012PrivateKey.populateFromPrivKeyInfo(org.spongycastle.asn1.pkcs.PrivateKeyInfo):void");
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
        if (!(obj instanceof BCECGOST3410_2012PrivateKey)) {
            return false;
        }
        BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey = (BCECGOST3410_2012PrivateKey) obj;
        return getD().equals(bCECGOST3410_2012PrivateKey.getD()) && engineGetSpec().equals(bCECGOST3410_2012PrivateKey.engineGetSpec());
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
        return this.f7932d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r11 = this;
            java.math.BigInteger r0 = r11.f7932d
            int r0 = r0.bitLength()
            r1 = 0
            r2 = 256(0x100, float:3.59E-43)
            if (r0 <= r2) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0013
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512
            goto L_0x0015
        L_0x0013:
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0 = 64
            goto L_0x001c
        L_0x001a:
            r0 = 32
        L_0x001c:
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r3 = r11.gostParams
            r4 = 0
            if (r3 == 0) goto L_0x0043
            byte[] r3 = new byte[r0]
            java.math.BigInteger r5 = r11.getS()
            r11.extractBytes(r3, r0, r1, r5)
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0042 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x0042 }
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r5 = r11.gostParams     // Catch:{ IOException -> 0x0042 }
            r1.<init>(r2, r5)     // Catch:{ IOException -> 0x0042 }
            org.spongycastle.asn1.DEROctetString r2 = new org.spongycastle.asn1.DEROctetString     // Catch:{ IOException -> 0x0042 }
            r2.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0042 }
            r0.<init>(r1, r2)     // Catch:{ IOException -> 0x0042 }
            java.lang.String r1 = "DER"
            byte[] r0 = r0.getEncoded(r1)     // Catch:{ IOException -> 0x0042 }
            return r0
        L_0x0042:
            return r4
        L_0x0043:
            java.security.spec.ECParameterSpec r0 = r11.ecSpec
            boolean r1 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec
            if (r1 == 0) goto L_0x0068
            org.spongycastle.jce.spec.ECNamedCurveSpec r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0
            java.lang.String r0 = r0.getName()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveOid((java.lang.String) r0)
            if (r0 != 0) goto L_0x0062
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier
            java.security.spec.ECParameterSpec r1 = r11.ecSpec
            org.spongycastle.jce.spec.ECNamedCurveSpec r1 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r1
            java.lang.String r1 = r1.getName()
            r0.<init>((java.lang.String) r1)
        L_0x0062:
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            r1.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r0)
            goto L_0x00b6
        L_0x0068:
            if (r0 != 0) goto L_0x007c
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.DERNull r0 = org.spongycastle.asn1.DERNull.INSTANCE
            r1.<init>((org.spongycastle.asn1.ASN1Null) r0)
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.math.BigInteger r3 = r11.getS()
            int r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getOrderBitLength(r0, r4, r3)
            goto L_0x00c6
        L_0x007c:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            org.spongycastle.math.ec.ECCurve r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r0)
            org.spongycastle.asn1.x9.X9ECParameters r0 = new org.spongycastle.asn1.x9.X9ECParameters
            java.security.spec.ECParameterSpec r1 = r11.ecSpec
            java.security.spec.ECPoint r1 = r1.getGenerator()
            boolean r3 = r11.withCompression
            org.spongycastle.math.ec.ECPoint r7 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint((org.spongycastle.math.p186ec.ECCurve) r6, (java.security.spec.ECPoint) r1, (boolean) r3)
            java.security.spec.ECParameterSpec r1 = r11.ecSpec
            java.math.BigInteger r8 = r1.getOrder()
            java.security.spec.ECParameterSpec r1 = r11.ecSpec
            int r1 = r1.getCofactor()
            long r9 = (long) r1
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            java.security.spec.ECParameterSpec r1 = r11.ecSpec
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            byte[] r10 = r1.getSeed()
            r5 = r0
            r5.<init>((org.spongycastle.math.p186ec.ECCurve) r6, (org.spongycastle.math.p186ec.ECPoint) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9, (byte[]) r10)
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            r1.<init>((org.spongycastle.asn1.p176x9.X9ECParameters) r0)
        L_0x00b6:
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.security.spec.ECParameterSpec r3 = r11.ecSpec
            java.math.BigInteger r3 = r3.getOrder()
            java.math.BigInteger r5 = r11.getS()
            int r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getOrderBitLength(r0, r3, r5)
        L_0x00c6:
            org.spongycastle.asn1.DERBitString r3 = r11.publicKey
            if (r3 == 0) goto L_0x00d6
            org.spongycastle.asn1.sec.ECPrivateKey r3 = new org.spongycastle.asn1.sec.ECPrivateKey
            java.math.BigInteger r5 = r11.getS()
            org.spongycastle.asn1.DERBitString r6 = r11.publicKey
            r3.<init>(r0, r5, r6, r1)
            goto L_0x00df
        L_0x00d6:
            org.spongycastle.asn1.sec.ECPrivateKey r3 = new org.spongycastle.asn1.sec.ECPrivateKey
            java.math.BigInteger r5 = r11.getS()
            r3.<init>((int) r0, (java.math.BigInteger) r5, (org.spongycastle.asn1.ASN1Encodable) r1)
        L_0x00df:
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00f8 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r5 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x00f8 }
            org.spongycastle.asn1.ASN1Primitive r1 = r1.toASN1Primitive()     // Catch:{ IOException -> 0x00f8 }
            r5.<init>(r2, r1)     // Catch:{ IOException -> 0x00f8 }
            org.spongycastle.asn1.ASN1Primitive r1 = r3.toASN1Primitive()     // Catch:{ IOException -> 0x00f8 }
            r0.<init>(r5, r1)     // Catch:{ IOException -> 0x00f8 }
            java.lang.String r1 = "DER"
            byte[] r0 = r0.getEncoded(r1)     // Catch:{ IOException -> 0x00f8 }
            return r0
        L_0x00f8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost12.BCECGOST3410_2012PrivateKey.getEncoded():byte[]");
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
        return this.f7932d;
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
        return ECUtil.privateKeyToString(this.algorithm, this.f7932d, engineGetSpec());
    }
}
