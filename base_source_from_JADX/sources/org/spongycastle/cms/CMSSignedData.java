package org.spongycastle.cms;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.SignedData;
import org.spongycastle.asn1.cms.SignerInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cert.X509AttributeCertificateHolder;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.util.Encodable;
import org.spongycastle.util.Store;

public class CMSSignedData implements Encodable {
    private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
    ContentInfo contentInfo;
    private Map hashes;
    CMSTypedData signedContent;
    SignedData signedData;
    SignerInformationStore signerInfoStore;

    public CMSSignedData(InputStream inputStream) {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSSignedData(Map map, ContentInfo contentInfo2) {
        this.hashes = map;
        this.contentInfo = contentInfo2;
        this.signedData = getSignedData();
    }

    public CMSSignedData(Map map, byte[] bArr) {
        this(map, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(ContentInfo contentInfo2) {
        this.contentInfo = contentInfo2;
        this.signedData = getSignedData();
        ASN1Encodable content = this.signedData.getEncapContentInfo().getContent();
        if (content != null) {
            this.signedContent = content instanceof ASN1OctetString ? new CMSProcessableByteArray(this.signedData.getEncapContentInfo().getContentType(), ((ASN1OctetString) content).getOctets()) : new PKCS7ProcessableObject(this.signedData.getEncapContentInfo().getContentType(), content);
        } else {
            this.signedContent = null;
        }
    }

    public CMSSignedData(CMSProcessable cMSProcessable, InputStream inputStream) {
        this(cMSProcessable, CMSUtils.readContentInfo((InputStream) new ASN1InputStream(inputStream)));
    }

    public CMSSignedData(final CMSProcessable cMSProcessable, ContentInfo contentInfo2) {
        if (cMSProcessable instanceof CMSTypedData) {
            this.signedContent = (CMSTypedData) cMSProcessable;
        } else {
            this.signedContent = new CMSTypedData() {
                public Object getContent() {
                    return cMSProcessable.getContent();
                }

                public ASN1ObjectIdentifier getContentType() {
                    return CMSSignedData.this.signedData.getEncapContentInfo().getContentType();
                }

                public void write(OutputStream outputStream) {
                    cMSProcessable.write(outputStream);
                }
            };
        }
        this.contentInfo = contentInfo2;
        this.signedData = getSignedData();
    }

    public CMSSignedData(CMSProcessable cMSProcessable, byte[] bArr) {
        this(cMSProcessable, CMSUtils.readContentInfo(bArr));
    }

    private CMSSignedData(CMSSignedData cMSSignedData) {
        this.signedData = cMSSignedData.signedData;
        this.contentInfo = cMSSignedData.contentInfo;
        this.signedContent = cMSSignedData.signedContent;
        this.signerInfoStore = cMSSignedData.signerInfoStore;
    }

    public CMSSignedData(byte[] bArr) {
        this(CMSUtils.readContentInfo(bArr));
    }

    private SignedData getSignedData() {
        try {
            return SignedData.getInstance(this.contentInfo.getContent());
        } catch (ClassCastException e) {
            throw new CMSException("Malformed content.", e);
        } catch (IllegalArgumentException e2) {
            throw new CMSException("Malformed content.", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.cms.CMSSignedData replaceCertificatesAndCRLs(org.spongycastle.cms.CMSSignedData r8, org.spongycastle.util.Store r9, org.spongycastle.util.Store r10, org.spongycastle.util.Store r11) {
        /*
            org.spongycastle.cms.CMSSignedData r0 = new org.spongycastle.cms.CMSSignedData
            r0.<init>((org.spongycastle.cms.CMSSignedData) r8)
            r1 = 0
            if (r9 != 0) goto L_0x000a
            if (r10 == 0) goto L_0x002d
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r9 == 0) goto L_0x0018
            java.util.List r9 = org.spongycastle.cms.CMSUtils.getCertificatesFromStore(r9)
            r2.addAll(r9)
        L_0x0018:
            if (r10 == 0) goto L_0x0021
            java.util.List r9 = org.spongycastle.cms.CMSUtils.getAttributeCertificatesFromStore(r10)
            r2.addAll(r9)
        L_0x0021:
            org.spongycastle.asn1.ASN1Set r9 = org.spongycastle.cms.CMSUtils.createBerSetFromList(r2)
            int r10 = r9.size()
            if (r10 == 0) goto L_0x002d
            r5 = r9
            goto L_0x002e
        L_0x002d:
            r5 = r1
        L_0x002e:
            if (r11 == 0) goto L_0x0040
            java.util.List r9 = org.spongycastle.cms.CMSUtils.getCRLsFromStore(r11)
            org.spongycastle.asn1.ASN1Set r9 = org.spongycastle.cms.CMSUtils.createBerSetFromList(r9)
            int r10 = r9.size()
            if (r10 == 0) goto L_0x0040
            r6 = r9
            goto L_0x0041
        L_0x0040:
            r6 = r1
        L_0x0041:
            org.spongycastle.asn1.cms.SignedData r9 = new org.spongycastle.asn1.cms.SignedData
            org.spongycastle.asn1.cms.SignedData r10 = r8.signedData
            org.spongycastle.asn1.ASN1Set r3 = r10.getDigestAlgorithms()
            org.spongycastle.asn1.cms.SignedData r10 = r8.signedData
            org.spongycastle.asn1.cms.ContentInfo r4 = r10.getEncapContentInfo()
            org.spongycastle.asn1.cms.SignedData r8 = r8.signedData
            org.spongycastle.asn1.ASN1Set r7 = r8.getSignerInfos()
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r0.signedData = r9
            org.spongycastle.asn1.cms.ContentInfo r8 = new org.spongycastle.asn1.cms.ContentInfo
            org.spongycastle.asn1.cms.ContentInfo r9 = r0.contentInfo
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = r9.getContentType()
            org.spongycastle.asn1.cms.SignedData r10 = r0.signedData
            r8.<init>(r9, r10)
            r0.contentInfo = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.CMSSignedData.replaceCertificatesAndCRLs(org.spongycastle.cms.CMSSignedData, org.spongycastle.util.Store, org.spongycastle.util.Store, org.spongycastle.util.Store):org.spongycastle.cms.CMSSignedData");
    }

    public static CMSSignedData replaceSigners(CMSSignedData cMSSignedData, SignerInformationStore signerInformationStore) {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        cMSSignedData2.signerInfoStore = signerInformationStore;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation next : signerInformationStore.getSigners()) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(next.getDigestAlgorithmID()));
            aSN1EncodableVector2.add(next.toASN1Structure());
        }
        DERSet dERSet = new DERSet(aSN1EncodableVector);
        DERSet dERSet2 = new DERSet(aSN1EncodableVector2);
        ASN1Sequence aSN1Sequence = (ASN1Sequence) cMSSignedData.signedData.toASN1Primitive();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(0));
        aSN1EncodableVector3.add(dERSet);
        for (int i = 2; i != aSN1Sequence.size() - 1; i++) {
            aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(i));
        }
        aSN1EncodableVector3.add(dERSet2);
        cMSSignedData2.signedData = SignedData.getInstance(new BERSequence(aSN1EncodableVector3));
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    private boolean verifyCounterSignature(SignerInformation signerInformation, SignerInformationVerifierProvider signerInformationVerifierProvider) {
        if (!signerInformation.verify(signerInformationVerifierProvider.get(signerInformation.getSID()))) {
            return false;
        }
        for (SignerInformation verifyCounterSignature : signerInformation.getCounterSignatures().getSigners()) {
            if (!verifyCounterSignature(verifyCounterSignature, signerInformationVerifierProvider)) {
                return false;
            }
        }
        return true;
    }

    public Store<X509AttributeCertificateHolder> getAttributeCertificates() {
        return HELPER.getAttributeCertificates(this.signedData.getCertificates());
    }

    public Store<X509CRLHolder> getCRLs() {
        return HELPER.getCRLs(this.signedData.getCRLs());
    }

    public Store<X509CertificateHolder> getCertificates() {
        return HELPER.getCertificates(this.signedData.getCertificates());
    }

    public Set<AlgorithmIdentifier> getDigestAlgorithmIDs() {
        HashSet hashSet = new HashSet(this.signedData.getDigestAlgorithms().size());
        Enumeration objects = this.signedData.getDigestAlgorithms().getObjects();
        while (objects.hasMoreElements()) {
            hashSet.add(AlgorithmIdentifier.getInstance(objects.nextElement()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public Store getOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return HELPER.getOtherRevocationInfo(aSN1ObjectIdentifier, this.signedData.getCRLs());
    }

    public CMSTypedData getSignedContent() {
        return this.signedContent;
    }

    public String getSignedContentTypeOID() {
        return this.signedData.getEncapContentInfo().getContentType().getId();
    }

    public SignerInformationStore getSignerInfos() {
        Object obj;
        Map map;
        if (this.signerInfoStore == null) {
            ASN1Set signerInfos = this.signedData.getSignerInfos();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != signerInfos.size(); i++) {
                SignerInfo instance = SignerInfo.getInstance(signerInfos.getObjectAt(i));
                ASN1ObjectIdentifier contentType = this.signedData.getEncapContentInfo().getContentType();
                Map map2 = this.hashes;
                if (map2 == null) {
                    arrayList.add(new SignerInformation(instance, contentType, this.signedContent, (byte[]) null));
                } else {
                    if (map2.keySet().iterator().next() instanceof String) {
                        map = this.hashes;
                        obj = instance.getDigestAlgorithm().getAlgorithm().getId();
                    } else {
                        map = this.hashes;
                        obj = instance.getDigestAlgorithm().getAlgorithm();
                    }
                    arrayList.add(new SignerInformation(instance, contentType, (CMSProcessable) null, (byte[]) map.get(obj)));
                }
            }
            this.signerInfoStore = new SignerInformationStore((Collection<SignerInformation>) arrayList);
        }
        return this.signerInfoStore;
    }

    public int getVersion() {
        return this.signedData.getVersion().getValue().intValue();
    }

    public boolean isCertificateManagementMessage() {
        return this.signedData.getEncapContentInfo().getContent() == null && this.signedData.getSignerInfos().size() == 0;
    }

    public boolean isDetachedSignature() {
        return this.signedData.getEncapContentInfo().getContent() == null && this.signedData.getSignerInfos().size() > 0;
    }

    public ContentInfo toASN1Structure() {
        return this.contentInfo;
    }

    public boolean verifySignatures(SignerInformationVerifierProvider signerInformationVerifierProvider) {
        return verifySignatures(signerInformationVerifierProvider, false);
    }

    public boolean verifySignatures(SignerInformationVerifierProvider signerInformationVerifierProvider, boolean z) {
        for (SignerInformation next : getSignerInfos().getSigners()) {
            try {
                if (!next.verify(signerInformationVerifierProvider.get(next.getSID()))) {
                    return false;
                }
                if (!z) {
                    for (SignerInformation verifyCounterSignature : next.getCounterSignatures().getSigners()) {
                        if (!verifyCounterSignature(verifyCounterSignature, signerInformationVerifierProvider)) {
                            return false;
                        }
                    }
                    continue;
                }
            } catch (OperatorCreationException e) {
                throw new CMSException("failure in verifier provider: " + e.getMessage(), e);
            }
        }
        return true;
    }
}
