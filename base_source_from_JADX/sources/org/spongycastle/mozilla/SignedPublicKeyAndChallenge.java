package org.spongycastle.mozilla;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.operator.ContentVerifier;
import org.spongycastle.operator.ContentVerifierProvider;
import org.spongycastle.util.Encodable;

public class SignedPublicKeyAndChallenge implements Encodable {
    protected final org.spongycastle.asn1.mozilla.SignedPublicKeyAndChallenge spkacSeq;

    protected SignedPublicKeyAndChallenge(org.spongycastle.asn1.mozilla.SignedPublicKeyAndChallenge signedPublicKeyAndChallenge) {
        this.spkacSeq = signedPublicKeyAndChallenge;
    }

    public SignedPublicKeyAndChallenge(byte[] bArr) {
        this.spkacSeq = org.spongycastle.asn1.mozilla.SignedPublicKeyAndChallenge.getInstance(bArr);
    }

    public String getChallenge() {
        return this.spkacSeq.getPublicKeyAndChallenge().getChallenge().getString();
    }

    public byte[] getEncoded() {
        return toASN1Structure().getEncoded();
    }

    public PublicKey getPublicKey(String str) {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
        try {
            return KeyFactory.getInstance(subjectPublicKeyInfo.getAlgorithm().getAlgorithm().getId(), str).generatePublic(new X509EncodedKeySpec(new DERBitString((ASN1Encodable) subjectPublicKeyInfo).getOctets()));
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }

    public PublicKeyAndChallenge getPublicKeyAndChallenge() {
        return this.spkacSeq.getPublicKeyAndChallenge();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) {
        ContentVerifier contentVerifier = contentVerifierProvider.get(this.spkacSeq.getSignatureAlgorithm());
        OutputStream outputStream = contentVerifier.getOutputStream();
        new DEROutputStream(outputStream).writeObject(this.spkacSeq.getPublicKeyAndChallenge());
        outputStream.close();
        return contentVerifier.verify(this.spkacSeq.getSignature().getOctets());
    }

    public ASN1Primitive toASN1Primitive() {
        return this.spkacSeq.toASN1Primitive();
    }

    public org.spongycastle.asn1.mozilla.SignedPublicKeyAndChallenge toASN1Structure() {
        return this.spkacSeq;
    }

    public boolean verify() {
        return verify((String) null);
    }

    public boolean verify(String str) {
        Signature instance = str == null ? Signature.getInstance(this.spkacSeq.getSignatureAlgorithm().getAlgorithm().getId()) : Signature.getInstance(this.spkacSeq.getSignatureAlgorithm().getAlgorithm().getId(), str);
        instance.initVerify(getPublicKey(str));
        try {
            instance.update(this.spkacSeq.getPublicKeyAndChallenge().getEncoded());
            return instance.verify(this.spkacSeq.getSignature().getBytes());
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }
}
