package org.spongycastle.cms;

import java.util.List;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import org.spongycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.spongycastle.asn1.cms.OriginatorIdentifierOrKey;
import org.spongycastle.asn1.cms.OriginatorPublicKey;
import org.spongycastle.asn1.cms.RecipientEncryptedKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class KeyAgreeRecipientInformation extends RecipientInformation {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientInfo info;

    KeyAgreeRecipientInformation(KeyAgreeRecipientInfo keyAgreeRecipientInfo, RecipientId recipientId, ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        super(keyAgreeRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        this.info = keyAgreeRecipientInfo;
        this.rid = recipientId;
        this.encryptedKey = aSN1OctetString;
    }

    private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorId(OriginatorId originatorId) {
        throw new CMSException("No support for 'originator' as IssuerAndSerialNumber or SubjectKeyIdentifier");
    }

    private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorPublicKey(AlgorithmIdentifier algorithmIdentifier, OriginatorPublicKey originatorPublicKey) {
        return new SubjectPublicKeyInfo(algorithmIdentifier, originatorPublicKey.getPublicKey().getBytes());
    }

    private SubjectPublicKeyInfo getSenderPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, OriginatorIdentifierOrKey originatorIdentifierOrKey) {
        OriginatorPublicKey originatorKey = originatorIdentifierOrKey.getOriginatorKey();
        if (originatorKey != null) {
            return getPublicKeyInfoFromOriginatorPublicKey(algorithmIdentifier, originatorKey);
        }
        IssuerAndSerialNumber issuerAndSerialNumber = originatorIdentifierOrKey.getIssuerAndSerialNumber();
        return getPublicKeyInfoFromOriginatorId(issuerAndSerialNumber != null ? new OriginatorId(issuerAndSerialNumber.getName(), issuerAndSerialNumber.getSerialNumber().getValue()) : new OriginatorId(originatorIdentifierOrKey.getSubjectKeyIdentifier().getKeyIdentifier()));
    }

    static void readRecipientInfo(List list, KeyAgreeRecipientInfo keyAgreeRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        ASN1Sequence recipientEncryptedKeys = keyAgreeRecipientInfo.getRecipientEncryptedKeys();
        for (int i = 0; i < recipientEncryptedKeys.size(); i++) {
            RecipientEncryptedKey instance = RecipientEncryptedKey.getInstance(recipientEncryptedKeys.getObjectAt(i));
            KeyAgreeRecipientIdentifier identifier = instance.getIdentifier();
            IssuerAndSerialNumber issuerAndSerialNumber = identifier.getIssuerAndSerialNumber();
            List list2 = list;
            list.add(new KeyAgreeRecipientInformation(keyAgreeRecipientInfo, issuerAndSerialNumber != null ? new KeyAgreeRecipientId(issuerAndSerialNumber.getName(), issuerAndSerialNumber.getSerialNumber().getValue()) : new KeyAgreeRecipientId(identifier.getRKeyID().getSubjectKeyIdentifier().getOctets()), instance.getEncryptedKey(), algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        }
    }

    /* access modifiers changed from: protected */
    public RecipientOperator getRecipientOperator(Recipient recipient) {
        KeyAgreeRecipient keyAgreeRecipient = (KeyAgreeRecipient) recipient;
        return keyAgreeRecipient.getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, getSenderPublicKeyInfo(keyAgreeRecipient.getPrivateKeyAlgorithmIdentifier(), this.info.getOriginator()), this.info.getUserKeyingMaterial(), this.encryptedKey.getOctets());
    }
}
