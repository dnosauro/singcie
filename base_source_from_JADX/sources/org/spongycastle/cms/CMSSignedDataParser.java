package org.spongycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Generator;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetStringParser;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1SetParser;
import org.spongycastle.asn1.ASN1StreamParser;
import org.spongycastle.asn1.BERSequenceGenerator;
import org.spongycastle.asn1.BERSetParser;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.CMSObjectIdentifiers;
import org.spongycastle.asn1.cms.ContentInfoParser;
import org.spongycastle.asn1.cms.SignedDataParser;
import org.spongycastle.asn1.cms.SignerInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.operator.DigestCalculatorProvider;
import org.spongycastle.util.Store;
import org.spongycastle.util.p191io.Streams;

public class CMSSignedDataParser extends CMSContentInfoParser {
    private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
    private ASN1Set _certSet;
    private ASN1Set _crlSet;
    private boolean _isCertCrlParsed;
    private CMSTypedStream _signedContent;
    private ASN1ObjectIdentifier _signedContentType;
    private SignedDataParser _signedData;
    private SignerInformationStore _signerInfoStore;
    private Set<AlgorithmIdentifier> digestAlgorithms;
    private Map digests;

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, InputStream inputStream) {
        this(digestCalculatorProvider, (CMSTypedStream) null, inputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A[Catch:{ IOException -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d A[Catch:{ IOException -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CMSSignedDataParser(org.spongycastle.operator.DigestCalculatorProvider r5, org.spongycastle.cms.CMSTypedStream r6, java.io.InputStream r7) {
        /*
            r4 = this;
            r4.<init>(r7)
            r4._signedContent = r6     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.cms.ContentInfoParser r7 = r4._contentInfo     // Catch:{ IOException -> 0x0095 }
            r0 = 16
            org.spongycastle.asn1.ASN1Encodable r7 = r7.getContent(r0)     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.cms.SignedDataParser r7 = org.spongycastle.asn1.cms.SignedDataParser.getInstance(r7)     // Catch:{ IOException -> 0x0095 }
            r4._signedData = r7     // Catch:{ IOException -> 0x0095 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ IOException -> 0x0095 }
            r7.<init>()     // Catch:{ IOException -> 0x0095 }
            r4.digests = r7     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.cms.SignedDataParser r7 = r4._signedData     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.ASN1SetParser r7 = r7.getDigestAlgorithms()     // Catch:{ IOException -> 0x0095 }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ IOException -> 0x0095 }
            r0.<init>()     // Catch:{ IOException -> 0x0095 }
        L_0x0025:
            org.spongycastle.asn1.ASN1Encodable r1 = r7.readObject()     // Catch:{ IOException -> 0x0095 }
            if (r1 == 0) goto L_0x0042
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = org.spongycastle.asn1.x509.AlgorithmIdentifier.getInstance(r1)     // Catch:{ IOException -> 0x0095 }
            r0.add(r1)     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.operator.DigestCalculator r2 = r5.get(r1)     // Catch:{ OperatorCreationException -> 0x0025 }
            if (r2 == 0) goto L_0x0025
            java.util.Map r3 = r4.digests     // Catch:{ OperatorCreationException -> 0x0025 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.getAlgorithm()     // Catch:{ OperatorCreationException -> 0x0025 }
            r3.put(r1, r2)     // Catch:{ OperatorCreationException -> 0x0025 }
            goto L_0x0025
        L_0x0042:
            java.util.Set r5 = java.util.Collections.unmodifiableSet(r0)     // Catch:{ IOException -> 0x0095 }
            r4.digestAlgorithms = r5     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.cms.SignedDataParser r5 = r4._signedData     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.cms.ContentInfoParser r5 = r5.getEncapContentInfo()     // Catch:{ IOException -> 0x0095 }
            r7 = 4
            org.spongycastle.asn1.ASN1Encodable r7 = r5.getContent(r7)     // Catch:{ IOException -> 0x0095 }
            boolean r0 = r7 instanceof org.spongycastle.asn1.ASN1OctetStringParser     // Catch:{ IOException -> 0x0095 }
            if (r0 == 0) goto L_0x0071
            org.spongycastle.asn1.ASN1OctetStringParser r7 = (org.spongycastle.asn1.ASN1OctetStringParser) r7     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.cms.CMSTypedStream r0 = new org.spongycastle.cms.CMSTypedStream     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r5.getContentType()     // Catch:{ IOException -> 0x0095 }
            java.io.InputStream r7 = r7.getOctetStream()     // Catch:{ IOException -> 0x0095 }
            r0.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r1, (java.io.InputStream) r7)     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.cms.CMSTypedStream r7 = r4._signedContent     // Catch:{ IOException -> 0x0095 }
            if (r7 != 0) goto L_0x006d
        L_0x006a:
            r4._signedContent = r0     // Catch:{ IOException -> 0x0095 }
            goto L_0x0084
        L_0x006d:
            r0.drain()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0084
        L_0x0071:
            if (r7 == 0) goto L_0x0084
            org.spongycastle.cms.PKCS7TypedStream r0 = new org.spongycastle.cms.PKCS7TypedStream     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r5.getContentType()     // Catch:{ IOException -> 0x0095 }
            r0.<init>(r1, r7)     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.cms.CMSTypedStream r7 = r4._signedContent     // Catch:{ IOException -> 0x0095 }
            if (r7 != 0) goto L_0x0081
            goto L_0x006a
        L_0x0081:
            r0.drain()     // Catch:{ IOException -> 0x0095 }
        L_0x0084:
            if (r6 != 0) goto L_0x008d
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = r5.getContentType()     // Catch:{ IOException -> 0x0095 }
        L_0x008a:
            r4._signedContentType = r5     // Catch:{ IOException -> 0x0095 }
            goto L_0x0094
        L_0x008d:
            org.spongycastle.cms.CMSTypedStream r5 = r4._signedContent     // Catch:{ IOException -> 0x0095 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = r5.getContentType()     // Catch:{ IOException -> 0x0095 }
            goto L_0x008a
        L_0x0094:
            return
        L_0x0095:
            r5 = move-exception
            org.spongycastle.cms.CMSException r6 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "io exception: "
            r7.append(r0)
            java.lang.String r0 = r5.getMessage()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.CMSSignedDataParser.<init>(org.spongycastle.operator.DigestCalculatorProvider, org.spongycastle.cms.CMSTypedStream, java.io.InputStream):void");
    }

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, CMSTypedStream cMSTypedStream, byte[] bArr) {
        this(digestCalculatorProvider, cMSTypedStream, (InputStream) new ByteArrayInputStream(bArr));
    }

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, byte[] bArr) {
        this(digestCalculatorProvider, (InputStream) new ByteArrayInputStream(bArr));
    }

    private static ASN1Set getASN1Set(ASN1SetParser aSN1SetParser) {
        if (aSN1SetParser == null) {
            return null;
        }
        return ASN1Set.getInstance(aSN1SetParser.toASN1Primitive());
    }

    private static void pipeEncapsulatedOctetString(ContentInfoParser contentInfoParser, OutputStream outputStream) {
        ASN1OctetStringParser aSN1OctetStringParser = (ASN1OctetStringParser) contentInfoParser.getContent(4);
        if (aSN1OctetStringParser != null) {
            pipeOctetString(aSN1OctetStringParser, outputStream);
        }
    }

    private static void pipeOctetString(ASN1OctetStringParser aSN1OctetStringParser, OutputStream outputStream) {
        OutputStream createBEROctetOutputStream = CMSUtils.createBEROctetOutputStream(outputStream, 0, true, 0);
        Streams.pipeAll(aSN1OctetStringParser.getOctetStream(), createBEROctetOutputStream);
        createBEROctetOutputStream.close();
    }

    private void populateCertCrlSets() {
        if (!this._isCertCrlParsed) {
            this._isCertCrlParsed = true;
            try {
                this._certSet = getASN1Set(this._signedData.getCertificates());
                this._crlSet = getASN1Set(this._signedData.getCrls());
            } catch (IOException e) {
                throw new CMSException("problem parsing cert/crl sets", e);
            }
        }
    }

    public static OutputStream replaceCertificatesAndCRLs(InputStream inputStream, Store store, Store store2, Store store3, OutputStream outputStream) {
        SignedDataParser instance = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(instance.getVersion());
        bERSequenceGenerator2.getRawOutputStream().write(instance.getDigestAlgorithms().toASN1Primitive().getEncoded());
        ContentInfoParser encapContentInfo = instance.getEncapContentInfo();
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(encapContentInfo.getContentType());
        pipeEncapsulatedOctetString(encapContentInfo, bERSequenceGenerator3.getRawOutputStream());
        bERSequenceGenerator3.close();
        getASN1Set(instance.getCertificates());
        getASN1Set(instance.getCrls());
        if (!(store == null && store3 == null)) {
            ArrayList arrayList = new ArrayList();
            if (store != null) {
                arrayList.addAll(CMSUtils.getCertificatesFromStore(store));
            }
            if (store3 != null) {
                arrayList.addAll(CMSUtils.getAttributeCertificatesFromStore(store3));
            }
            ASN1Set createBerSetFromList = CMSUtils.createBerSetFromList(arrayList);
            if (createBerSetFromList.size() > 0) {
                bERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 0, createBerSetFromList).getEncoded());
            }
        }
        if (store2 != null) {
            ASN1Set createBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(store2));
            if (createBerSetFromList2.size() > 0) {
                bERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 1, createBerSetFromList2).getEncoded());
            }
        }
        bERSequenceGenerator2.getRawOutputStream().write(instance.getSignerInfos().toASN1Primitive().getEncoded());
        bERSequenceGenerator2.close();
        bERSequenceGenerator.close();
        return outputStream;
    }

    public static OutputStream replaceSigners(InputStream inputStream, SignerInformationStore signerInformationStore, OutputStream outputStream) {
        SignedDataParser instance = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(instance.getVersion());
        instance.getDigestAlgorithms().toASN1Primitive();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SignerInformation digestAlgorithmID : signerInformationStore.getSigners()) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(digestAlgorithmID.getDigestAlgorithmID()));
        }
        bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
        ContentInfoParser encapContentInfo = instance.getEncapContentInfo();
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(encapContentInfo.getContentType());
        pipeEncapsulatedOctetString(encapContentInfo, bERSequenceGenerator3.getRawOutputStream());
        bERSequenceGenerator3.close();
        writeSetToGeneratorTagged(bERSequenceGenerator2, instance.getCertificates(), 0);
        writeSetToGeneratorTagged(bERSequenceGenerator2, instance.getCrls(), 1);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation aSN1Structure : signerInformationStore.getSigners()) {
            aSN1EncodableVector2.add(aSN1Structure.toASN1Structure());
        }
        bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector2).getEncoded());
        bERSequenceGenerator2.close();
        bERSequenceGenerator.close();
        return outputStream;
    }

    private static void writeSetToGeneratorTagged(ASN1Generator aSN1Generator, ASN1SetParser aSN1SetParser, int i) {
        byte[] bArr;
        OutputStream outputStream;
        ASN1Set aSN1Set = getASN1Set(aSN1SetParser);
        if (aSN1Set != null) {
            if (aSN1SetParser instanceof BERSetParser) {
                outputStream = aSN1Generator.getRawOutputStream();
                bArr = new BERTaggedObject(false, i, aSN1Set).getEncoded();
            } else {
                outputStream = aSN1Generator.getRawOutputStream();
                bArr = new DERTaggedObject(false, i, aSN1Set).getEncoded();
            }
            outputStream.write(bArr);
        }
    }

    public Store getAttributeCertificates() {
        populateCertCrlSets();
        return HELPER.getAttributeCertificates(this._certSet);
    }

    public Store getCRLs() {
        populateCertCrlSets();
        return HELPER.getCRLs(this._crlSet);
    }

    public Store getCertificates() {
        populateCertCrlSets();
        return HELPER.getCertificates(this._certSet);
    }

    public Set<AlgorithmIdentifier> getDigestAlgorithmIDs() {
        return this.digestAlgorithms;
    }

    public Store getOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        populateCertCrlSets();
        return HELPER.getOtherRevocationInfo(aSN1ObjectIdentifier, this._crlSet);
    }

    public CMSTypedStream getSignedContent() {
        if (this._signedContent == null) {
            return null;
        }
        return new CMSTypedStream(this._signedContent.getContentType(), CMSUtils.attachDigestsToInputStream(this.digests.values(), this._signedContent.getContentStream()));
    }

    public String getSignedContentTypeOID() {
        return this._signedContentType.getId();
    }

    public SignerInformationStore getSignerInfos() {
        if (this._signerInfoStore == null) {
            populateCertCrlSets();
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (Object next : this.digests.keySet()) {
                hashMap.put(next, ((DigestCalculator) this.digests.get(next)).getDigest());
            }
            try {
                ASN1SetParser signerInfos = this._signedData.getSignerInfos();
                while (true) {
                    ASN1Encodable readObject = signerInfos.readObject();
                    if (readObject == null) {
                        break;
                    }
                    SignerInfo instance = SignerInfo.getInstance(readObject.toASN1Primitive());
                    arrayList.add(new SignerInformation(instance, this._signedContentType, (CMSProcessable) null, (byte[]) hashMap.get(instance.getDigestAlgorithm().getAlgorithm())));
                }
                this._signerInfoStore = new SignerInformationStore((Collection<SignerInformation>) arrayList);
            } catch (IOException e) {
                throw new CMSException("io exception: " + e.getMessage(), e);
            }
        }
        return this._signerInfoStore;
    }

    public int getVersion() {
        return this._signedData.getVersion().getValue().intValue();
    }
}
