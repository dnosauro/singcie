package org.spongycastle.crypto.util;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.p176x9.X962Parameters;
import org.spongycastle.asn1.p176x9.X9ECParameters;
import org.spongycastle.asn1.p176x9.X9ECPoint;
import org.spongycastle.asn1.p176x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECNamedDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class SubjectPublicKeyInfoFactory {
    private SubjectPublicKeyInfoFactory() {
    }

    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) {
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), (ASN1Encodable) new RSAPublicKey(rSAKeyParameters.getModulus(), rSAKeyParameters.getExponent()));
        } else if (asymmetricKeyParameter instanceof DSAPublicKeyParameters) {
            DSAPublicKeyParameters dSAPublicKeyParameters = (DSAPublicKeyParameters) asymmetricKeyParameter;
            DSAParameter dSAParameter = null;
            DSAParameters parameters = dSAPublicKeyParameters.getParameters();
            if (parameters != null) {
                dSAParameter = new DSAParameter(parameters.getP(), parameters.getQ(), parameters.getG());
            }
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, dSAParameter), (ASN1Encodable) new ASN1Integer(dSAPublicKeyParameters.getY()));
        } else if (asymmetricKeyParameter instanceof ECPublicKeyParameters) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
            ECDomainParameters parameters2 = eCPublicKeyParameters.getParameters();
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, parameters2 == null ? new X962Parameters((ASN1Null) DERNull.INSTANCE) : parameters2 instanceof ECNamedDomainParameters ? new X962Parameters(((ECNamedDomainParameters) parameters2).getName()) : new X962Parameters(new X9ECParameters(parameters2.getCurve(), parameters2.getG(), parameters2.getN(), parameters2.getH(), parameters2.getSeed()))), ((ASN1OctetString) new X9ECPoint(eCPublicKeyParameters.getQ()).toASN1Primitive()).getOctets());
        } else {
            throw new IOException("key parameters not recognised.");
        }
    }
}
