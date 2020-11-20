package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.p176x9.X962Parameters;
import org.spongycastle.asn1.p176x9.X9ECParameters;
import org.spongycastle.asn1.p176x9.X9ECPoint;
import org.spongycastle.asn1.p176x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.p186ec.ECCurve;
import org.spongycastle.math.p186ec.ECPoint;
import org.spongycastle.util.Strings;

public class JCEECPublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    private String algorithm = "EC";
    private ECParameterSpec ecSpec;
    private GOST3410PublicKeyAlgParameters gostParams;

    /* renamed from: q */
    private ECPoint f7956q;
    private boolean withCompression;

    public JCEECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = str;
        this.ecSpec = eCPublicKeySpec.getParams();
        this.f7956q = EC5Util.convertPoint(this.ecSpec, eCPublicKeySpec.getW(), false);
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.f7956q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f7956q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f7956q = eCPublicKeyParameters.getQ();
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
    }

    public JCEECPublicKey(String str, JCEECPublicKey jCEECPublicKey) {
        this.algorithm = str;
        this.f7956q = jCEECPublicKey.f7956q;
        this.ecSpec = jCEECPublicKey.ecSpec;
        this.withCompression = jCEECPublicKey.withCompression;
        this.gostParams = jCEECPublicKey.gostParams;
    }

    public JCEECPublicKey(String str, org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec eCParameterSpec;
        this.algorithm = str;
        this.f7956q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            eCParameterSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed()), eCPublicKeySpec.getParams());
        } else {
            if (this.f7956q.getCurve() == null) {
                this.f7956q = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve().createPoint(this.f7956q.getAffineXCoord().toBigInteger(), this.f7956q.getAffineYCoord().toBigInteger(), false);
            }
            eCParameterSpec = null;
        }
        this.ecSpec = eCParameterSpec;
    }

    public JCEECPublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = eCPublicKey.getAlgorithm();
        this.ecSpec = eCPublicKey.getParams();
        this.f7956q = EC5Util.convertPoint(this.ecSpec, eCPublicKey.getW(), false);
    }

    JCEECPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: org.spongycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX WARNING: type inference failed for: r13v6, types: [org.spongycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r13) {
        /*
            r12 = this;
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r13.getAlgorithmId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001
            boolean r0 = r0.equals(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00c4
            org.spongycastle.asn1.DERBitString r0 = r13.getPublicKeyData()
            java.lang.String r3 = "ECGOST3410"
            r12.algorithm = r3
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00bc }
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r0)     // Catch:{ IOException -> 0x00bc }
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x00bc }
            byte[] r0 = r0.getOctets()
            r3 = 32
            byte[] r4 = new byte[r3]
            byte[] r3 = new byte[r3]
            r5 = 0
        L_0x002f:
            int r6 = r4.length
            if (r5 == r6) goto L_0x003b
            int r6 = 31 - r5
            byte r6 = r0[r6]
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x002f
        L_0x003b:
            r5 = 0
        L_0x003c:
            int r6 = r3.length
            if (r5 == r6) goto L_0x0048
            int r6 = 63 - r5
            byte r6 = r0[r6]
            r3[r5] = r6
            int r5 = r5 + 1
            goto L_0x003c
        L_0x0048:
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters
            org.spongycastle.asn1.x509.AlgorithmIdentifier r13 = r13.getAlgorithmId()
            org.spongycastle.asn1.ASN1Encodable r13 = r13.getParameters()
            org.spongycastle.asn1.ASN1Sequence r13 = (org.spongycastle.asn1.ASN1Sequence) r13
            r0.<init>(r13)
            r12.gostParams = r0
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r13 = r12.gostParams
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = r13.getPublicKeyParamSet()
            java.lang.String r13 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r13)
            org.spongycastle.jce.spec.ECNamedCurveParameterSpec r13 = org.spongycastle.jce.ECGOST3410NamedCurveTable.getParameterSpec(r13)
            org.spongycastle.math.ec.ECCurve r0 = r13.getCurve()
            byte[] r5 = r13.getSeed()
            java.security.spec.EllipticCurve r8 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r0, r5)
            java.math.BigInteger r5 = new java.math.BigInteger
            r5.<init>(r2, r4)
            java.math.BigInteger r4 = new java.math.BigInteger
            r4.<init>(r2, r3)
            org.spongycastle.math.ec.ECPoint r0 = r0.createPoint(r5, r4, r1)
            r12.f7956q = r0
            org.spongycastle.jce.spec.ECNamedCurveSpec r0 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r1 = r12.gostParams
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.getPublicKeyParamSet()
            java.lang.String r7 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r1)
            java.security.spec.ECPoint r9 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r1 = r13.getG()
            org.spongycastle.math.ec.ECFieldElement r1 = r1.getAffineXCoord()
            java.math.BigInteger r1 = r1.toBigInteger()
            org.spongycastle.math.ec.ECPoint r2 = r13.getG()
            org.spongycastle.math.ec.ECFieldElement r2 = r2.getAffineYCoord()
            java.math.BigInteger r2 = r2.toBigInteger()
            r9.<init>(r1, r2)
            java.math.BigInteger r10 = r13.getN()
            java.math.BigInteger r11 = r13.getH()
            r6 = r0
            r6.<init>((java.lang.String) r7, (java.security.spec.EllipticCurve) r8, (java.security.spec.ECPoint) r9, (java.math.BigInteger) r10, (java.math.BigInteger) r11)
            r12.ecSpec = r0
            goto L_0x01c2
        L_0x00bc:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r13.<init>(r0)
            throw r13
        L_0x00c4:
            org.spongycastle.asn1.x9.X962Parameters r0 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = r13.getAlgorithmId()
            org.spongycastle.asn1.ASN1Encodable r3 = r3.getParameters()
            org.spongycastle.asn1.ASN1Primitive r3 = (org.spongycastle.asn1.ASN1Primitive) r3
            r0.<init>((org.spongycastle.asn1.ASN1Primitive) r3)
            boolean r3 = r0.isNamedCurve()
            if (r3 == 0) goto L_0x0121
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r0
            org.spongycastle.asn1.x9.X9ECParameters r3 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            org.spongycastle.math.ec.ECCurve r4 = r3.getCurve()
            byte[] r5 = r3.getSeed()
            java.security.spec.EllipticCurve r8 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r4, r5)
            org.spongycastle.jce.spec.ECNamedCurveSpec r5 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r7 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getCurveName(r0)
            java.security.spec.ECPoint r9 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r0 = r3.getG()
            org.spongycastle.math.ec.ECFieldElement r0 = r0.getAffineXCoord()
            java.math.BigInteger r0 = r0.toBigInteger()
            org.spongycastle.math.ec.ECPoint r6 = r3.getG()
            org.spongycastle.math.ec.ECFieldElement r6 = r6.getAffineYCoord()
            java.math.BigInteger r6 = r6.toBigInteger()
            r9.<init>(r0, r6)
            java.math.BigInteger r10 = r3.getN()
            java.math.BigInteger r11 = r3.getH()
            r6 = r5
            r6.<init>((java.lang.String) r7, (java.security.spec.EllipticCurve) r8, (java.security.spec.ECPoint) r9, (java.math.BigInteger) r10, (java.math.BigInteger) r11)
        L_0x011e:
            r12.ecSpec = r5
            goto L_0x0178
        L_0x0121:
            boolean r3 = r0.isImplicitlyCA()
            if (r3 == 0) goto L_0x0135
            r0 = 0
            r12.ecSpec = r0
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            org.spongycastle.jce.spec.ECParameterSpec r0 = r0.getEcImplicitlyCa()
            org.spongycastle.math.ec.ECCurve r4 = r0.getCurve()
            goto L_0x0178
        L_0x0135:
            org.spongycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.p176x9.X9ECParameters.getInstance(r0)
            org.spongycastle.math.ec.ECCurve r4 = r0.getCurve()
            byte[] r3 = r0.getSeed()
            java.security.spec.EllipticCurve r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r4, r3)
            java.security.spec.ECParameterSpec r5 = new java.security.spec.ECParameterSpec
            java.security.spec.ECPoint r6 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r7 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r7 = r7.getAffineXCoord()
            java.math.BigInteger r7 = r7.toBigInteger()
            org.spongycastle.math.ec.ECPoint r8 = r0.getG()
            org.spongycastle.math.ec.ECFieldElement r8 = r8.getAffineYCoord()
            java.math.BigInteger r8 = r8.toBigInteger()
            r6.<init>(r7, r8)
            java.math.BigInteger r7 = r0.getN()
            java.math.BigInteger r0 = r0.getH()
            int r0 = r0.intValue()
            r5.<init>(r3, r6, r7, r0)
            goto L_0x011e
        L_0x0178:
            org.spongycastle.asn1.DERBitString r13 = r13.getPublicKeyData()
            byte[] r13 = r13.getBytes()
            org.spongycastle.asn1.DEROctetString r0 = new org.spongycastle.asn1.DEROctetString
            r0.<init>((byte[]) r13)
            byte r1 = r13[r1]
            r3 = 4
            if (r1 != r3) goto L_0x01b7
            byte r1 = r13[r2]
            int r2 = r13.length
            r3 = 2
            int r2 = r2 - r3
            if (r1 != r2) goto L_0x01b7
            byte r1 = r13[r3]
            r2 = 3
            if (r1 == r3) goto L_0x019a
            byte r1 = r13[r3]
            if (r1 != r2) goto L_0x01b7
        L_0x019a:
            org.spongycastle.asn1.x9.X9IntegerConverter r1 = new org.spongycastle.asn1.x9.X9IntegerConverter
            r1.<init>()
            int r1 = r1.getByteLength((org.spongycastle.math.p186ec.ECCurve) r4)
            int r3 = r13.length
            int r3 = r3 - r2
            if (r1 < r3) goto L_0x01b7
            org.spongycastle.asn1.ASN1Primitive r13 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r13)     // Catch:{ IOException -> 0x01af }
            r0 = r13
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x01af }
            goto L_0x01b7
        L_0x01af:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r13.<init>(r0)
            throw r13
        L_0x01b7:
            org.spongycastle.asn1.x9.X9ECPoint r13 = new org.spongycastle.asn1.x9.X9ECPoint
            r13.<init>((org.spongycastle.math.p186ec.ECCurve) r4, (org.spongycastle.asn1.ASN1OctetString) r0)
            org.spongycastle.math.ec.ECPoint r13 = r13.getPoint()
            r12.f7956q = r13
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JCEECPublicKey.populateFromPubKeyInfo(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
    }

    public ECPoint engineGetQ() {
        return this.f7956q;
    }

    /* access modifiers changed from: package-private */
    public org.spongycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        return engineGetQ().equals(jCEECPublicKey.engineGetQ()) && engineGetSpec().equals(jCEECPublicKey.engineGetSpec());
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        X962Parameters x962Parameters;
        ASN1Encodable aSN1Encodable;
        if (this.algorithm.equals("ECGOST3410")) {
            GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = this.gostParams;
            if (gOST3410PublicKeyAlgParameters != null) {
                aSN1Encodable = gOST3410PublicKeyAlgParameters;
            } else {
                ECParameterSpec eCParameterSpec = this.ecSpec;
                if (eCParameterSpec instanceof ECNamedCurveSpec) {
                    aSN1Encodable = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) eCParameterSpec).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
                } else {
                    ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                    aSN1Encodable = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
                }
            }
            BigInteger bigInteger = this.f7956q.getAffineXCoord().toBigInteger();
            BigInteger bigInteger2 = this.f7956q.getAffineYCoord().toBigInteger();
            byte[] bArr = new byte[64];
            extractBytes(bArr, 0, bigInteger);
            extractBytes(bArr, 32, bigInteger2);
            try {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, aSN1Encodable), (ASN1Encodable) new DEROctetString(bArr));
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec2 = this.ecSpec;
            if (eCParameterSpec2 instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec2).getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else if (eCParameterSpec2 == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            } else {
                ECCurve convertCurve2 = EC5Util.convertCurve(eCParameterSpec2.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(convertCurve2, EC5Util.convertPoint(convertCurve2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), ((ASN1OctetString) new X9ECPoint(engineGetQ().getCurve().createPoint(getQ().getAffineXCoord().toBigInteger(), getQ().getAffineYCoord().toBigInteger(), this.withCompression)).toASN1Primitive()).getOctets());
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
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

    public ECPoint getQ() {
        return this.ecSpec == null ? this.f7956q.getDetachedPoint() : this.f7956q;
    }

    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.f7956q.getAffineXCoord().toBigInteger(), this.f7956q.getAffineYCoord().toBigInteger());
    }

    public int hashCode() {
        return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f7956q.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f7956q.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }
}
