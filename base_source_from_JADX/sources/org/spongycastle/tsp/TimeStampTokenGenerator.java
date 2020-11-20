package org.spongycastle.tsp;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cms.AttributeTable;
import org.spongycastle.asn1.ess.ESSCertID;
import org.spongycastle.asn1.ess.ESSCertIDv2;
import org.spongycastle.asn1.ess.SigningCertificate;
import org.spongycastle.asn1.ess.SigningCertificateV2;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.tsp.Accuracy;
import org.spongycastle.asn1.tsp.MessageImprint;
import org.spongycastle.asn1.tsp.TSTInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.ExtensionsGenerator;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cms.CMSAttributeTableGenerator;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.CMSProcessableByteArray;
import org.spongycastle.cms.CMSSignedDataGenerator;
import org.spongycastle.cms.SignerInfoGenerator;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.util.CollectionStore;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;

public class TimeStampTokenGenerator {
    public static final int R_MICROSECONDS = 2;
    public static final int R_MILLISECONDS = 3;
    public static final int R_SECONDS = 0;
    public static final int R_TENTHS_OF_SECONDS = 1;
    private int accuracyMicros;
    private int accuracyMillis;
    private int accuracySeconds;
    private List attrCerts;
    private List certs;
    private List crls;
    private Locale locale;
    boolean ordering;
    private Map otherRevoc;
    private int resolution;
    private SignerInfoGenerator signerInfoGen;
    GeneralName tsa;
    private ASN1ObjectIdentifier tsaPolicyOID;

    public TimeStampTokenGenerator(SignerInfoGenerator signerInfoGenerator, DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(signerInfoGenerator, digestCalculator, aSN1ObjectIdentifier, false);
    }

    public TimeStampTokenGenerator(final SignerInfoGenerator signerInfoGenerator, DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) {
        SignerInfoGenerator signerInfoGenerator2;
        this.resolution = 0;
        IssuerSerial issuerSerial = null;
        this.locale = null;
        this.accuracySeconds = -1;
        this.accuracyMillis = -1;
        this.accuracyMicros = -1;
        this.ordering = false;
        this.tsa = null;
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this.attrCerts = new ArrayList();
        this.otherRevoc = new HashMap();
        this.signerInfoGen = signerInfoGenerator;
        this.tsaPolicyOID = aSN1ObjectIdentifier;
        if (signerInfoGenerator.hasAssociatedCertificate()) {
            X509CertificateHolder associatedCertificate = signerInfoGenerator.getAssociatedCertificate();
            TSPUtil.validateCertificate(associatedCertificate);
            try {
                OutputStream outputStream = digestCalculator.getOutputStream();
                outputStream.write(associatedCertificate.getEncoded());
                outputStream.close();
                if (digestCalculator.getAlgorithmIdentifier().getAlgorithm().equals(OIWObjectIdentifiers.idSHA1)) {
                    final ESSCertID eSSCertID = new ESSCertID(digestCalculator.getDigest(), z ? new IssuerSerial(new GeneralNames(new GeneralName(associatedCertificate.getIssuer())), associatedCertificate.getSerialNumber()) : issuerSerial);
                    signerInfoGenerator2 = new SignerInfoGenerator(signerInfoGenerator, new CMSAttributeTableGenerator() {
                        public AttributeTable getAttributes(Map map) {
                            AttributeTable attributes = signerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(map);
                            return attributes.get(PKCSObjectIdentifiers.id_aa_signingCertificate) == null ? attributes.add(PKCSObjectIdentifiers.id_aa_signingCertificate, new SigningCertificate(eSSCertID)) : attributes;
                        }
                    }, signerInfoGenerator.getUnsignedAttributeTableGenerator());
                } else {
                    final ESSCertIDv2 eSSCertIDv2 = new ESSCertIDv2(new AlgorithmIdentifier(digestCalculator.getAlgorithmIdentifier().getAlgorithm()), digestCalculator.getDigest(), z ? new IssuerSerial(new GeneralNames(new GeneralName(associatedCertificate.getIssuer())), new ASN1Integer(associatedCertificate.getSerialNumber())) : issuerSerial);
                    signerInfoGenerator2 = new SignerInfoGenerator(signerInfoGenerator, new CMSAttributeTableGenerator() {
                        public AttributeTable getAttributes(Map map) {
                            AttributeTable attributes = signerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(map);
                            return attributes.get(PKCSObjectIdentifiers.id_aa_signingCertificateV2) == null ? attributes.add(PKCSObjectIdentifiers.id_aa_signingCertificateV2, new SigningCertificateV2(eSSCertIDv2)) : attributes;
                        }
                    }, signerInfoGenerator.getUnsignedAttributeTableGenerator());
                }
                this.signerInfoGen = signerInfoGenerator2;
            } catch (IOException e) {
                throw new TSPException("Exception processing certificate.", e);
            }
        } else {
            throw new IllegalArgumentException("SignerInfoGenerator must have an associated certificate");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        if (r0.length() > r2) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (r0.length() > r2) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        r0.delete(r2, r0.length());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.spongycastle.asn1.ASN1GeneralizedTime createGeneralizedTime(java.util.Date r5) {
        /*
            r4 = this;
            java.lang.String r0 = "yyyyMMddHHmmss.SSS"
            java.util.Locale r1 = r4.locale
            if (r1 != 0) goto L_0x000c
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            r1.<init>(r0)
            goto L_0x0012
        L_0x000c:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            r2.<init>(r0, r1)
            r1 = r2
        L_0x0012:
            java.util.SimpleTimeZone r0 = new java.util.SimpleTimeZone
            r2 = 0
            java.lang.String r3 = "Z"
            r0.<init>(r2, r3)
            r1.setTimeZone(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = r1.format(r5)
            r0.<init>(r5)
            java.lang.String r5 = "."
            int r5 = r0.indexOf(r5)
            if (r5 >= 0) goto L_0x003d
            java.lang.String r5 = "Z"
            r0.append(r5)
            org.spongycastle.asn1.ASN1GeneralizedTime r5 = new org.spongycastle.asn1.ASN1GeneralizedTime
            java.lang.String r0 = r0.toString()
            r5.<init>((java.lang.String) r0)
            return r5
        L_0x003d:
            int r1 = r4.resolution
            switch(r1) {
                case 1: goto L_0x0064;
                case 2: goto L_0x005b;
                case 3: goto L_0x0073;
                default: goto L_0x0042;
            }
        L_0x0042:
            org.spongycastle.tsp.TSPException r5 = new org.spongycastle.tsp.TSPException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unknown time-stamp resolution: "
            r0.append(r1)
            int r1 = r4.resolution
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x005b:
            int r1 = r0.length()
            int r2 = r5 + 3
            if (r1 <= r2) goto L_0x0073
            goto L_0x006c
        L_0x0064:
            int r1 = r0.length()
            int r2 = r5 + 2
            if (r1 <= r2) goto L_0x0073
        L_0x006c:
            int r1 = r0.length()
            r0.delete(r2, r1)
        L_0x0073:
            int r1 = r0.length()
            int r1 = r1 + -1
            char r1 = r0.charAt(r1)
            r2 = 48
            if (r1 != r2) goto L_0x008b
            int r1 = r0.length()
            int r1 = r1 + -1
            r0.deleteCharAt(r1)
            goto L_0x0073
        L_0x008b:
            int r1 = r0.length()
            int r1 = r1 + -1
            if (r1 != r5) goto L_0x009c
            int r5 = r0.length()
            int r5 = r5 + -1
            r0.deleteCharAt(r5)
        L_0x009c:
            java.lang.String r5 = "Z"
            r0.append(r5)
            org.spongycastle.asn1.ASN1GeneralizedTime r5 = new org.spongycastle.asn1.ASN1GeneralizedTime
            java.lang.String r0 = r0.toString()
            r5.<init>((java.lang.String) r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.tsp.TimeStampTokenGenerator.createGeneralizedTime(java.util.Date):org.spongycastle.asn1.ASN1GeneralizedTime");
    }

    public void addAttributeCertificates(Store store) {
        this.attrCerts.addAll(store.getMatches((Selector) null));
    }

    public void addCRLs(Store store) {
        this.crls.addAll(store.getMatches((Selector) null));
    }

    public void addCertificates(Store store) {
        this.certs.addAll(store.getMatches((Selector) null));
    }

    public void addOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, Store store) {
        this.otherRevoc.put(aSN1ObjectIdentifier, store.getMatches((Selector) null));
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date) {
        return generate(timeStampRequest, bigInteger, date, (Extensions) null);
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date, Extensions extensions) {
        Accuracy accuracy;
        Extensions extensions2;
        ASN1GeneralizedTime aSN1GeneralizedTime;
        Date date2 = date;
        Extensions extensions3 = extensions;
        MessageImprint messageImprint = new MessageImprint(new AlgorithmIdentifier(timeStampRequest.getMessageImprintAlgOID(), DERNull.INSTANCE), timeStampRequest.getMessageImprintDigest());
        if (this.accuracySeconds > 0 || this.accuracyMillis > 0 || this.accuracyMicros > 0) {
            int i = this.accuracySeconds;
            ASN1Integer aSN1Integer = i > 0 ? new ASN1Integer((long) i) : null;
            int i2 = this.accuracyMillis;
            ASN1Integer aSN1Integer2 = i2 > 0 ? new ASN1Integer((long) i2) : null;
            int i3 = this.accuracyMicros;
            accuracy = new Accuracy(aSN1Integer, aSN1Integer2, i3 > 0 ? new ASN1Integer((long) i3) : null);
        } else {
            accuracy = null;
        }
        boolean z = this.ordering;
        ASN1Boolean instance = z ? ASN1Boolean.getInstance(z) : null;
        ASN1Integer aSN1Integer3 = timeStampRequest.getNonce() != null ? new ASN1Integer(timeStampRequest.getNonce()) : null;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.tsaPolicyOID;
        if (timeStampRequest.getReqPolicy() != null) {
            aSN1ObjectIdentifier = timeStampRequest.getReqPolicy();
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = aSN1ObjectIdentifier;
        Extensions extensions4 = timeStampRequest.getExtensions();
        if (extensions3 != null) {
            ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
            if (extensions4 != null) {
                Enumeration oids = extensions4.oids();
                while (oids.hasMoreElements()) {
                    extensionsGenerator.addExtension(extensions4.getExtension(ASN1ObjectIdentifier.getInstance(oids.nextElement())));
                }
            }
            Enumeration oids2 = extensions.oids();
            while (oids2.hasMoreElements()) {
                extensionsGenerator.addExtension(extensions3.getExtension(ASN1ObjectIdentifier.getInstance(oids2.nextElement())));
            }
            extensions2 = extensionsGenerator.generate();
        } else {
            extensions2 = extensions4;
        }
        if (this.resolution == 0) {
            Locale locale2 = this.locale;
            aSN1GeneralizedTime = locale2 == null ? new ASN1GeneralizedTime(date2) : new ASN1GeneralizedTime(date2, locale2);
        } else {
            aSN1GeneralizedTime = createGeneralizedTime(date2);
        }
        TSTInfo tSTInfo = new TSTInfo(aSN1ObjectIdentifier2, messageImprint, new ASN1Integer(bigInteger), aSN1GeneralizedTime, accuracy, instance, aSN1Integer3, this.tsa, extensions2);
        try {
            CMSSignedDataGenerator cMSSignedDataGenerator = new CMSSignedDataGenerator();
            if (timeStampRequest.getCertReq()) {
                cMSSignedDataGenerator.addCertificates(new CollectionStore(this.certs));
                cMSSignedDataGenerator.addAttributeCertificates(new CollectionStore(this.attrCerts));
            }
            cMSSignedDataGenerator.addCRLs(new CollectionStore(this.crls));
            if (!this.otherRevoc.isEmpty()) {
                for (ASN1ObjectIdentifier aSN1ObjectIdentifier3 : this.otherRevoc.keySet()) {
                    cMSSignedDataGenerator.addOtherRevocationInfo(aSN1ObjectIdentifier3, (Store) new CollectionStore((Collection) this.otherRevoc.get(aSN1ObjectIdentifier3)));
                }
            }
            cMSSignedDataGenerator.addSignerInfoGenerator(this.signerInfoGen);
            return new TimeStampToken(cMSSignedDataGenerator.generate(new CMSProcessableByteArray(PKCSObjectIdentifiers.id_ct_TSTInfo, tSTInfo.getEncoded(ASN1Encoding.DER)), true));
        } catch (CMSException e) {
            throw new TSPException("Error generating time-stamp token", e);
        } catch (IOException e2) {
            throw new TSPException("Exception encoding info", e2);
        }
    }

    public void setAccuracyMicros(int i) {
        this.accuracyMicros = i;
    }

    public void setAccuracyMillis(int i) {
        this.accuracyMillis = i;
    }

    public void setAccuracySeconds(int i) {
        this.accuracySeconds = i;
    }

    public void setLocale(Locale locale2) {
        this.locale = locale2;
    }

    public void setOrdering(boolean z) {
        this.ordering = z;
    }

    public void setResolution(int i) {
        this.resolution = i;
    }

    public void setTSA(GeneralName generalName) {
        this.tsa = generalName;
    }
}
