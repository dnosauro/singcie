package org.spongycastle.operator;

import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bsi.BSIObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.p176x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class DefaultAlgorithmNameFinder implements AlgorithmNameFinder {
    private static final Map algorithms = new HashMap();

    static {
        algorithms.put(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
        algorithms.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
        algorithms.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
        algorithms.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
        algorithms.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
        algorithms.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
        algorithms.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        algorithms.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410-2001");
        algorithms.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHGOST3410-2001");
        algorithms.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        algorithms.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410-94");
        algorithms.put(CryptoProObjectIdentifiers.gostR3411, "GOST3411");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411WITHGOST3410-2012-256");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411WITHGOST3410-2012-512");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411WITHECGOST3410-2012-256");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411WITHECGOST3410-2012-512");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411-2012-256WITHGOST3410-2012-256");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411-2012-512WITHGOST3410-2012-512");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411-2012-256WITHECGOST3410-2012-256");
        algorithms.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411-2012-512WITHECGOST3410-2012-512");
        algorithms.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
        algorithms.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
        algorithms.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
        algorithms.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
        algorithms.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
        algorithms.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        algorithms.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        algorithms.put(NISTObjectIdentifiers.dsa_with_sha384, "SHA384WITHDSA");
        algorithms.put(NISTObjectIdentifiers.dsa_with_sha512, "SHA512WITHDSA");
        algorithms.put(NISTObjectIdentifiers.id_sha224, "SHA224");
        algorithms.put(NISTObjectIdentifiers.id_sha256, "SHA256");
        algorithms.put(NISTObjectIdentifiers.id_sha384, "SHA384");
        algorithms.put(NISTObjectIdentifiers.id_sha512, "SHA512");
        algorithms.put(OIWObjectIdentifiers.elGamalAlgorithm, "ELGAMAL");
        algorithms.put(OIWObjectIdentifiers.idSHA1, "SHA1");
        algorithms.put(OIWObjectIdentifiers.md5WithRSA, "MD5WITHRSA");
        algorithms.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.id_RSAES_OAEP, "RSAOAEP");
        algorithms.put(PKCSObjectIdentifiers.id_RSASSA_PSS, "RSAPSS");
        algorithms.put(PKCSObjectIdentifiers.md2WithRSAEncryption, "MD2WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.md5, "MD5");
        algorithms.put(PKCSObjectIdentifiers.md5WithRSAEncryption, "MD5WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        algorithms.put(PKCSObjectIdentifiers.sha1WithRSAEncryption, "SHA1WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        algorithms.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        algorithms.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
        algorithms.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
        algorithms.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
        algorithms.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128, "RIPEMD128WITHRSA");
        algorithms.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160, "RIPEMD160WITHRSA");
        algorithms.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256, "RIPEMD256WITHRSA");
        algorithms.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "ECDSAWITHSHA1");
        algorithms.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        algorithms.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        algorithms.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        algorithms.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        algorithms.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        algorithms.put(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1WITHDSA");
        algorithms.put(GNUObjectIdentifiers.Tiger_192, "Tiger");
        algorithms.put(PKCSObjectIdentifiers.RC2_CBC, "RC2/CBC");
        algorithms.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESEDE-3KEY/CBC");
        algorithms.put(NISTObjectIdentifiers.id_aes128_ECB, "AES-128/ECB");
        algorithms.put(NISTObjectIdentifiers.id_aes192_ECB, "AES-192/ECB");
        algorithms.put(NISTObjectIdentifiers.id_aes256_ECB, "AES-256/ECB");
        algorithms.put(NISTObjectIdentifiers.id_aes128_CBC, "AES-128/CBC");
        algorithms.put(NISTObjectIdentifiers.id_aes192_CBC, "AES-192/CBC");
        algorithms.put(NISTObjectIdentifiers.id_aes256_CBC, "AES-256/CBC");
        algorithms.put(NISTObjectIdentifiers.id_aes128_CFB, "AES-128/CFB");
        algorithms.put(NISTObjectIdentifiers.id_aes192_CFB, "AES-192/CFB");
        algorithms.put(NISTObjectIdentifiers.id_aes256_CFB, "AES-256/CFB");
        algorithms.put(NISTObjectIdentifiers.id_aes128_OFB, "AES-128/OFB");
        algorithms.put(NISTObjectIdentifiers.id_aes192_OFB, "AES-192/OFB");
        algorithms.put(NISTObjectIdentifiers.id_aes256_OFB, "AES-256/OFB");
        algorithms.put(NTTObjectIdentifiers.id_camellia128_cbc, "CAMELLIA-128/CBC");
        algorithms.put(NTTObjectIdentifiers.id_camellia192_cbc, "CAMELLIA-192/CBC");
        algorithms.put(NTTObjectIdentifiers.id_camellia256_cbc, "CAMELLIA-256/CBC");
        algorithms.put(KISAObjectIdentifiers.id_seedCBC, "SEED/CBC");
        algorithms.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC, "IDEA/CBC");
        algorithms.put(MiscObjectIdentifiers.cast5CBC, "CAST5/CBC");
        algorithms.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB, "Blowfish/ECB");
        algorithms.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC, "Blowfish/CBC");
        algorithms.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB, "Blowfish/CFB");
        algorithms.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB, "Blowfish/OFB");
        algorithms.put(GNUObjectIdentifiers.Serpent_128_ECB, "Serpent-128/ECB");
        algorithms.put(GNUObjectIdentifiers.Serpent_128_CBC, "Serpent-128/CBC");
        algorithms.put(GNUObjectIdentifiers.Serpent_128_CFB, "Serpent-128/CFB");
        algorithms.put(GNUObjectIdentifiers.Serpent_128_OFB, "Serpent-128/OFB");
        algorithms.put(GNUObjectIdentifiers.Serpent_192_ECB, "Serpent-192/ECB");
        algorithms.put(GNUObjectIdentifiers.Serpent_192_CBC, "Serpent-192/CBC");
        algorithms.put(GNUObjectIdentifiers.Serpent_192_CFB, "Serpent-192/CFB");
        algorithms.put(GNUObjectIdentifiers.Serpent_192_OFB, "Serpent-192/OFB");
        algorithms.put(GNUObjectIdentifiers.Serpent_256_ECB, "Serpent-256/ECB");
        algorithms.put(GNUObjectIdentifiers.Serpent_256_CBC, "Serpent-256/CBC");
        algorithms.put(GNUObjectIdentifiers.Serpent_256_CFB, "Serpent-256/CFB");
        algorithms.put(GNUObjectIdentifiers.Serpent_256_OFB, "Serpent-256/OFB");
    }

    public String getAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) algorithms.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.getId();
    }

    public String getAlgorithmName(AlgorithmIdentifier algorithmIdentifier) {
        return getAlgorithmName(algorithmIdentifier.getAlgorithm());
    }

    public boolean hasAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return algorithms.containsKey(aSN1ObjectIdentifier);
    }
}
