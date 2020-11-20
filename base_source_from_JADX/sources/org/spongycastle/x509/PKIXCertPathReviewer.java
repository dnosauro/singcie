package org.spongycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.AccessDescription;
import org.spongycastle.asn1.x509.AuthorityInformationAccess;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.asn1.x509.NameConstraints;
import org.spongycastle.asn1.x509.qualified.MonetaryValue;
import org.spongycastle.asn1.x509.qualified.QCStatement;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.filter.TrustedInput;
import org.spongycastle.i18n.filter.UntrustedInput;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.PKIXNameConstraintValidator;
import org.spongycastle.jce.provider.PKIXNameConstraintValidatorException;
import org.spongycastle.util.Integers;

public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String AUTH_INFO_ACCESS = Extension.authorityInfoAccess.getId();
    private static final String CRL_DIST_POINTS = Extension.cRLDistributionPoints.getId();
    private static final String QC_STATEMENT = Extension.qCStatements.getId();
    private static final String RESOURCE_NAME = "org.spongycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected List[] errors;
    private boolean initialized;

    /* renamed from: n */
    protected int f8258n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;

    public PKIXCertPathReviewer() {
    }

    public PKIXCertPathReviewer(CertPath certPath2, PKIXParameters pKIXParameters) {
        init(certPath2, pKIXParameters);
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    private void checkCriticalExtensions() {
        int size;
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        for (PKIXCertPathChecker init : certPathCheckers) {
            try {
                init.init(false);
            } catch (CertPathValidatorException e) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
            } catch (CertPathValidatorException e2) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e2.getMessage(), e2, e2.getClass().getName()}), e2.getCause(), this.certPath, size);
            } catch (CertPathReviewerException e3) {
                addError(e3.getErrorMessage(), e3.getIndex());
                return;
            }
        }
        size = this.certs.size() - 1;
        while (size >= 0) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                if (!criticalExtensionOIDs.isEmpty()) {
                    criticalExtensionOIDs.remove(KEY_USAGE);
                    criticalExtensionOIDs.remove(CERTIFICATE_POLICIES);
                    criticalExtensionOIDs.remove(POLICY_MAPPINGS);
                    criticalExtensionOIDs.remove(INHIBIT_ANY_POLICY);
                    criticalExtensionOIDs.remove(ISSUING_DISTRIBUTION_POINT);
                    criticalExtensionOIDs.remove(DELTA_CRL_INDICATOR);
                    criticalExtensionOIDs.remove(POLICY_CONSTRAINTS);
                    criticalExtensionOIDs.remove(BASIC_CONSTRAINTS);
                    criticalExtensionOIDs.remove(SUBJECT_ALTERNATIVE_NAME);
                    criticalExtensionOIDs.remove(NAME_CONSTRAINTS);
                    if (criticalExtensionOIDs.contains(QC_STATEMENT) && processQcStatements(x509Certificate, size)) {
                        criticalExtensionOIDs.remove(QC_STATEMENT);
                    }
                    for (PKIXCertPathChecker check : certPathCheckers) {
                        check.check(x509Certificate, criticalExtensionOIDs);
                    }
                    if (!criticalExtensionOIDs.isEmpty()) {
                        for (String aSN1ObjectIdentifier : criticalExtensionOIDs) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(aSN1ObjectIdentifier)}), size);
                        }
                    }
                }
            }
            size--;
        }
    }

    private void checkNameConstraints() {
        GeneralName instance;
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        for (int size = this.certs.size() - 1; size > 0; size--) {
            int i = this.f8258n;
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!isSelfIssued(x509Certificate)) {
                X500Principal subjectPrincipal = getSubjectPrincipal(x509Certificate);
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                    pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                    pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME);
                    if (aSN1Sequence2 != null) {
                        for (int i2 = 0; i2 < aSN1Sequence2.size(); i2++) {
                            instance = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i2));
                            pKIXNameConstraintValidator.checkPermitted(instance);
                            pKIXNameConstraintValidator.checkExcluded(instance);
                        }
                    }
                } catch (AnnotatedException e) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e, this.certPath, size);
                } catch (IOException e2) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e2, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e3) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e4) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                } catch (AnnotatedException e5) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e5, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(instance)}), e6, this.certPath, size);
                } catch (CertPathReviewerException e7) {
                    addError(e7.getErrorMessage(), e7.getIndex());
                    return;
                }
            }
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) getExtensionValue(x509Certificate, NAME_CONSTRAINTS);
            if (aSN1Sequence3 != null) {
                NameConstraints instance2 = NameConstraints.getInstance(aSN1Sequence3);
                GeneralSubtree[] permittedSubtrees = instance2.getPermittedSubtrees();
                if (permittedSubtrees != null) {
                    pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                }
                GeneralSubtree[] excludedSubtrees = instance2.getExcludedSubtrees();
                if (excludedSubtrees != null) {
                    for (int i3 = 0; i3 != excludedSubtrees.length; i3++) {
                        pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i3]);
                    }
                }
            }
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int intValue;
        int i = this.f8258n;
        int i2 = i;
        int i3 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            int i4 = this.f8258n;
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!isSelfIssued(x509Certificate)) {
                if (i2 <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLengthExtended"));
                }
                i2--;
                i3++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (!(basicConstraints == null || (pathLenConstraint = basicConstraints.getPathLenConstraint()) == null || (intValue = pathLenConstraint.intValue()) >= i2)) {
                i2 = intValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.valueOf(i3)}));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: java.security.cert.X509Certificate} */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x03fb, code lost:
        throw new org.spongycastle.x509.CertPathReviewerException(new org.spongycastle.i18n.ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyInhibitExtError"), r1.certPath, r9);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:199:0x03eb */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0236 A[Catch:{ AnnotatedException -> 0x05e7, AnnotatedException -> 0x042d, AnnotatedException -> 0x040d, AnnotatedException -> 0x03fc, AnnotatedException -> 0x0361, CertPathValidatorException -> 0x034e, CertPathValidatorException -> 0x01f6, CertPathValidatorException -> 0x00d0, CertPathReviewerException -> 0x05f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x011b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0110 A[Catch:{ AnnotatedException -> 0x05e7, AnnotatedException -> 0x042d, AnnotatedException -> 0x040d, AnnotatedException -> 0x03fc, AnnotatedException -> 0x0361, CertPathValidatorException -> 0x034e, CertPathValidatorException -> 0x01f6, CertPathValidatorException -> 0x00d0, CertPathReviewerException -> 0x05f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012b A[Catch:{ AnnotatedException -> 0x05e7, AnnotatedException -> 0x042d, AnnotatedException -> 0x040d, AnnotatedException -> 0x03fc, AnnotatedException -> 0x0361, CertPathValidatorException -> 0x034e, CertPathValidatorException -> 0x01f6, CertPathValidatorException -> 0x00d0, CertPathReviewerException -> 0x05f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x020c A[Catch:{ AnnotatedException -> 0x05e7, AnnotatedException -> 0x042d, AnnotatedException -> 0x040d, AnnotatedException -> 0x03fc, AnnotatedException -> 0x0361, CertPathValidatorException -> 0x034e, CertPathValidatorException -> 0x01f6, CertPathValidatorException -> 0x00d0, CertPathReviewerException -> 0x05f8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkPolicy() {
        /*
            r28 = this;
            r1 = r28
            java.security.cert.PKIXParameters r0 = r1.pkixParams
            java.util.Set r0 = r0.getInitialPolicies()
            int r2 = r1.f8258n
            r3 = 1
            int r2 = r2 + r3
            java.util.ArrayList[] r2 = new java.util.ArrayList[r2]
            r4 = 0
            r5 = 0
        L_0x0010:
            int r6 = r2.length
            if (r5 >= r6) goto L_0x001d
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r2[r5] = r6
            int r5 = r5 + 1
            goto L_0x0010
        L_0x001d:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            java.lang.String r5 = "2.5.29.32.0"
            r9.add(r5)
            org.spongycastle.jce.provider.PKIXPolicyNode r5 = new org.spongycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 0
            r10 = 0
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            java.lang.String r12 = "2.5.29.32.0"
            r13 = 0
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r6 = r2[r4]
            r6.add(r5)
            java.security.cert.PKIXParameters r6 = r1.pkixParams
            boolean r6 = r6.isExplicitPolicyRequired()
            if (r6 == 0) goto L_0x004b
            r6 = 0
            goto L_0x004e
        L_0x004b:
            int r6 = r1.f8258n
            int r6 = r6 + r3
        L_0x004e:
            java.security.cert.PKIXParameters r7 = r1.pkixParams
            boolean r7 = r7.isAnyPolicyInhibited()
            if (r7 == 0) goto L_0x0058
            r7 = 0
            goto L_0x005b
        L_0x0058:
            int r7 = r1.f8258n
            int r7 = r7 + r3
        L_0x005b:
            java.security.cert.PKIXParameters r8 = r1.pkixParams
            boolean r8 = r8.isPolicyMappingInhibited()
            if (r8 == 0) goto L_0x0065
            r8 = 0
            goto L_0x0068
        L_0x0065:
            int r8 = r1.f8258n
            int r8 = r8 + r3
        L_0x0068:
            java.util.List r9 = r1.certs     // Catch:{ CertPathReviewerException -> 0x05f8 }
            int r9 = r9.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            int r9 = r9 - r3
            r11 = r7
            r12 = r8
            r8 = 0
            r7 = r5
            r5 = 0
        L_0x0074:
            if (r9 < 0) goto L_0x043f
            int r5 = r1.f8258n     // Catch:{ CertPathReviewerException -> 0x05f8 }
            int r5 = r5 - r9
            java.util.List r13 = r1.certs     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.Object r13 = r13.get(r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r15 = r13
            java.security.cert.X509Certificate r15 = (java.security.cert.X509Certificate) r15     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r13 = CERTIFICATE_POLICIES     // Catch:{ AnnotatedException -> 0x042d }
            org.spongycastle.asn1.ASN1Primitive r13 = getExtensionValue(r15, r13)     // Catch:{ AnnotatedException -> 0x042d }
            r21 = r13
            org.spongycastle.asn1.ASN1Sequence r21 = (org.spongycastle.asn1.ASN1Sequence) r21     // Catch:{ AnnotatedException -> 0x042d }
            if (r21 == 0) goto L_0x0255
            if (r7 == 0) goto L_0x0255
            java.util.Enumeration r13 = r21.getObjects()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.HashSet r14 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r14.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0099:
            boolean r16 = r13.hasMoreElements()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r16 == 0) goto L_0x00e5
            java.lang.Object r16 = r13.nextElement()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.x509.PolicyInformation r16 = org.spongycastle.asn1.x509.PolicyInformation.getInstance(r16)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = r16.getPolicyIdentifier()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = r10.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r14.add(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "2.5.29.32.0"
            java.lang.String r4 = r10.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r3 = r3.equals(r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 != 0) goto L_0x00e2
            org.spongycastle.asn1.ASN1Sequence r3 = r16.getPolicyQualifiers()     // Catch:{ CertPathValidatorException -> 0x00d0 }
            java.util.Set r3 = getQualifierSet(r3)     // Catch:{ CertPathValidatorException -> 0x00d0 }
            boolean r4 = processCertD1i(r5, r2, r10, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r4 != 0) goto L_0x00e2
            processCertD1ii(r5, r2, r10, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x00e2
        L_0x00d0:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.policyQualifierError"
            r2.<init>(r3, r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>(r2, r0, r4, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x00e2:
            r3 = 1
            r4 = 0
            goto L_0x0099
        L_0x00e5:
            if (r8 == 0) goto L_0x010d
            java.lang.String r3 = "2.5.29.32.0"
            boolean r3 = r8.contains(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 == 0) goto L_0x00f0
            goto L_0x010d
        L_0x00f0:
            java.util.Iterator r3 = r8.iterator()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r4.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x00f9:
            boolean r8 = r3.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 == 0) goto L_0x010e
            java.lang.Object r8 = r3.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r10 = r14.contains(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 == 0) goto L_0x00f9
            r4.add(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x00f9
        L_0x010d:
            r4 = r14
        L_0x010e:
            if (r11 > 0) goto L_0x0121
            int r3 = r1.f8258n     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r5 >= r3) goto L_0x011b
            boolean r3 = isSelfIssued(r15)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 == 0) goto L_0x011b
            goto L_0x0121
        L_0x011b:
            r23 = r4
            r27 = r15
            goto L_0x0208
        L_0x0121:
            java.util.Enumeration r3 = r21.getObjects()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0125:
            boolean r8 = r3.hasMoreElements()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 == 0) goto L_0x011b
            java.lang.Object r8 = r3.nextElement()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.x509.PolicyInformation r8 = org.spongycastle.asn1.x509.PolicyInformation.getInstance(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r10 = "2.5.29.32.0"
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = r8.getPolicyIdentifier()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r13 = r13.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r10 = r10.equals(r13)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 == 0) goto L_0x0125
            org.spongycastle.asn1.ASN1Sequence r3 = r8.getPolicyQualifiers()     // Catch:{ CertPathValidatorException -> 0x01f6 }
            java.util.Set r3 = getQualifierSet(r3)     // Catch:{ CertPathValidatorException -> 0x01f6 }
            int r8 = r5 + -1
            r8 = r2[r8]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r10 = 0
        L_0x0150:
            int r13 = r8.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 >= r13) goto L_0x011b
            java.lang.Object r13 = r8.get(r10)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r14 = r13
            org.spongycastle.jce.provider.PKIXPolicyNode r14 = (org.spongycastle.jce.provider.PKIXPolicyNode) r14     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.Set r13 = r14.getExpectedPolicies()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.Iterator r22 = r13.iterator()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0165:
            boolean r13 = r22.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r13 == 0) goto L_0x01ec
            java.lang.Object r13 = r22.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r23 = r4
            boolean r4 = r13 instanceof java.lang.String     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r4 == 0) goto L_0x0179
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r4 = r13
            goto L_0x0183
        L_0x0179:
            boolean r4 = r13 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r4 == 0) goto L_0x01e8
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r13     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r4 = r13.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0183:
            java.util.Iterator r13 = r14.getChildren()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r16 = 0
        L_0x0189:
            boolean r17 = r13.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r17 == 0) goto L_0x01a6
            java.lang.Object r17 = r13.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r17 = (org.spongycastle.jce.provider.PKIXPolicyNode) r17     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r24 = r8
            java.lang.String r8 = r17.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r8 = r4.equals(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 == 0) goto L_0x01a3
            r16 = 1
        L_0x01a3:
            r8 = r24
            goto L_0x0189
        L_0x01a6:
            r24 = r8
            if (r16 != 0) goto L_0x01dc
            java.util.HashSet r8 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8.add(r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r13 = new org.spongycastle.jce.provider.PKIXPolicyNode     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.ArrayList r16 = new java.util.ArrayList     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r16.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r20 = 0
            r25 = r13
            r26 = r14
            r14 = r16
            r27 = r15
            r15 = r5
            r16 = r8
            r17 = r26
            r18 = r3
            r19 = r4
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r4 = r25
            r13 = r26
            r13.addChild(r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8 = r2[r5]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8.add(r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x01df
        L_0x01dc:
            r13 = r14
            r27 = r15
        L_0x01df:
            r14 = r13
            r4 = r23
            r8 = r24
            r15 = r27
            goto L_0x0165
        L_0x01e8:
            r4 = r23
            goto L_0x0165
        L_0x01ec:
            r23 = r4
            r24 = r8
            r27 = r15
            int r10 = r10 + 1
            goto L_0x0150
        L_0x01f6:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.policyQualifierError"
            r2.<init>(r3, r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>(r2, r0, r4, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0208:
            int r3 = r5 + -1
        L_0x020a:
            if (r3 < 0) goto L_0x0230
            r4 = r2[r3]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8 = r7
            r7 = 0
        L_0x0210:
            int r10 = r4.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r7 >= r10) goto L_0x022c
            java.lang.Object r10 = r4.get(r7)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r10 = (org.spongycastle.jce.provider.PKIXPolicyNode) r10     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r13 = r10.hasChildren()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r13 != 0) goto L_0x0229
            org.spongycastle.jce.provider.PKIXPolicyNode r8 = removePolicyNode(r8, r2, r10)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 != 0) goto L_0x0229
            goto L_0x022c
        L_0x0229:
            int r7 = r7 + 1
            goto L_0x0210
        L_0x022c:
            r7 = r8
            int r3 = r3 + -1
            goto L_0x020a
        L_0x0230:
            java.util.Set r3 = r27.getCriticalExtensionOIDs()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 == 0) goto L_0x0251
            java.lang.String r4 = CERTIFICATE_POLICIES     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r3 = r3.contains(r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r4 = r2[r5]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8 = 0
        L_0x023f:
            int r10 = r4.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 >= r10) goto L_0x0251
            java.lang.Object r10 = r4.get(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r10 = (org.spongycastle.jce.provider.PKIXPolicyNode) r10     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r10.setCritical(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            int r8 = r8 + 1
            goto L_0x023f
        L_0x0251:
            r10 = r7
            r8 = r23
            goto L_0x0258
        L_0x0255:
            r27 = r15
            r10 = r7
        L_0x0258:
            if (r21 != 0) goto L_0x025b
            r10 = 0
        L_0x025b:
            if (r6 > 0) goto L_0x026f
            if (r10 == 0) goto L_0x0260
            goto L_0x026f
        L_0x0260:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.noValidPolicyTree"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x026f:
            int r3 = r1.f8258n     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r5 == r3) goto L_0x041f
            java.lang.String r3 = POLICY_MAPPINGS     // Catch:{ AnnotatedException -> 0x040d }
            r4 = r27
            org.spongycastle.asn1.ASN1Primitive r3 = getExtensionValue(r4, r3)     // Catch:{ AnnotatedException -> 0x040d }
            if (r3 == 0) goto L_0x02dc
            r7 = r3
            org.spongycastle.asn1.ASN1Sequence r7 = (org.spongycastle.asn1.ASN1Sequence) r7     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r13 = 0
        L_0x0281:
            int r14 = r7.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r13 >= r14) goto L_0x02dc
            org.spongycastle.asn1.ASN1Encodable r14 = r7.getObjectAt(r13)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1Sequence r14 = (org.spongycastle.asn1.ASN1Sequence) r14     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r15 = 0
            org.spongycastle.asn1.ASN1Encodable r16 = r14.getObjectAt(r15)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r16 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r16     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r15 = 1
            org.spongycastle.asn1.ASN1Encodable r14 = r14.getObjectAt(r15)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r14 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r14     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r15 = "2.5.29.32.0"
            r17 = r7
            java.lang.String r7 = r16.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r7 = r15.equals(r7)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r7 != 0) goto L_0x02cb
            java.lang.String r7 = "2.5.29.32.0"
            java.lang.String r14 = r14.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r7 = r7.equals(r14)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r7 != 0) goto L_0x02ba
            int r13 = r13 + 1
            r7 = r17
            goto L_0x0281
        L_0x02ba:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.invalidPolicyMapping"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x02cb:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.invalidPolicyMapping"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x02dc:
            if (r3 == 0) goto L_0x037b
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r7.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r13.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r14 = 0
        L_0x02eb:
            int r15 = r3.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r14 >= r15) goto L_0x0336
            org.spongycastle.asn1.ASN1Encodable r15 = r3.getObjectAt(r14)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1Sequence r15 = (org.spongycastle.asn1.ASN1Sequence) r15     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r16 = r3
            r3 = 0
            org.spongycastle.asn1.ASN1Encodable r17 = r15.getObjectAt(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r17 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r17     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = r17.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r17 = r8
            r8 = 1
            org.spongycastle.asn1.ASN1Encodable r15 = r15.getObjectAt(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r15 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r15     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r8 = r15.getId()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r15 = r7.containsKey(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r15 != 0) goto L_0x0326
            java.util.HashSet r15 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r15.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r15.add(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r7.put(r3, r15)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r13.add(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x032f
        L_0x0326:
            java.lang.Object r3 = r7.get(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.util.Set r3 = (java.util.Set) r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.add(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x032f:
            int r14 = r14 + 1
            r3 = r16
            r8 = r17
            goto L_0x02eb
        L_0x0336:
            r17 = r8
            java.util.Iterator r3 = r13.iterator()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x033c:
            boolean r8 = r3.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 == 0) goto L_0x037d
            java.lang.Object r8 = r3.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r12 <= 0) goto L_0x0374
            prepareNextCertB1(r5, r2, r8, r7, r4)     // Catch:{ AnnotatedException -> 0x0361, CertPathValidatorException -> 0x034e }
            goto L_0x033c
        L_0x034e:
            r0 = move-exception
            r2 = r0
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.policyQualifierError"
            r0.<init>(r3, r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>(r0, r2, r4, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0361:
            r0 = move-exception
            r2 = r0
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.policyExtError"
            r0.<init>(r3, r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>(r0, r2, r4, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0374:
            if (r12 > 0) goto L_0x033c
            org.spongycastle.jce.provider.PKIXPolicyNode r10 = prepareNextCertB2(r5, r2, r8, r10)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x033c
        L_0x037b:
            r17 = r8
        L_0x037d:
            boolean r3 = isSelfIssued(r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 != 0) goto L_0x038f
            if (r6 == 0) goto L_0x0387
            int r6 = r6 + -1
        L_0x0387:
            if (r12 == 0) goto L_0x038b
            int r12 = r12 + -1
        L_0x038b:
            if (r11 == 0) goto L_0x038f
            int r11 = r11 + -1
        L_0x038f:
            java.lang.String r3 = POLICY_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x03fc }
            org.spongycastle.asn1.ASN1Primitive r3 = getExtensionValue(r4, r3)     // Catch:{ AnnotatedException -> 0x03fc }
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3     // Catch:{ AnnotatedException -> 0x03fc }
            if (r3 == 0) goto L_0x03d3
            java.util.Enumeration r3 = r3.getObjects()     // Catch:{ AnnotatedException -> 0x03fc }
        L_0x039d:
            boolean r5 = r3.hasMoreElements()     // Catch:{ AnnotatedException -> 0x03fc }
            if (r5 == 0) goto L_0x03d3
            java.lang.Object r5 = r3.nextElement()     // Catch:{ AnnotatedException -> 0x03fc }
            org.spongycastle.asn1.ASN1TaggedObject r5 = (org.spongycastle.asn1.ASN1TaggedObject) r5     // Catch:{ AnnotatedException -> 0x03fc }
            int r7 = r5.getTagNo()     // Catch:{ AnnotatedException -> 0x03fc }
            switch(r7) {
                case 0: goto L_0x03c2;
                case 1: goto L_0x03b1;
                default: goto L_0x03b0;
            }     // Catch:{ AnnotatedException -> 0x03fc }
        L_0x03b0:
            goto L_0x039d
        L_0x03b1:
            r7 = 0
            org.spongycastle.asn1.ASN1Integer r5 = org.spongycastle.asn1.ASN1Integer.getInstance(r5, r7)     // Catch:{ AnnotatedException -> 0x03fc }
            java.math.BigInteger r5 = r5.getValue()     // Catch:{ AnnotatedException -> 0x03fc }
            int r5 = r5.intValue()     // Catch:{ AnnotatedException -> 0x03fc }
            if (r5 >= r12) goto L_0x039d
            r12 = r5
            goto L_0x039d
        L_0x03c2:
            r7 = 0
            org.spongycastle.asn1.ASN1Integer r5 = org.spongycastle.asn1.ASN1Integer.getInstance(r5, r7)     // Catch:{ AnnotatedException -> 0x03fc }
            java.math.BigInteger r5 = r5.getValue()     // Catch:{ AnnotatedException -> 0x03fc }
            int r5 = r5.intValue()     // Catch:{ AnnotatedException -> 0x03fc }
            if (r5 >= r6) goto L_0x039d
            r6 = r5
            goto L_0x039d
        L_0x03d3:
            java.lang.String r3 = INHIBIT_ANY_POLICY     // Catch:{ AnnotatedException -> 0x03eb }
            org.spongycastle.asn1.ASN1Primitive r3 = getExtensionValue(r4, r3)     // Catch:{ AnnotatedException -> 0x03eb }
            org.spongycastle.asn1.ASN1Integer r3 = (org.spongycastle.asn1.ASN1Integer) r3     // Catch:{ AnnotatedException -> 0x03eb }
            if (r3 == 0) goto L_0x03e8
            java.math.BigInteger r3 = r3.getValue()     // Catch:{ AnnotatedException -> 0x03eb }
            int r3 = r3.intValue()     // Catch:{ AnnotatedException -> 0x03eb }
            if (r3 >= r11) goto L_0x03e8
            goto L_0x03e9
        L_0x03e8:
            r3 = r11
        L_0x03e9:
            r11 = r3
            goto L_0x0423
        L_0x03eb:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.policyInhibitExtError"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x03fc:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.policyConstExtError"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x040d:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.policyMapExtError"
            r2.<init>(r3, r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>(r2, r0, r4, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x041f:
            r17 = r8
            r4 = r27
        L_0x0423:
            r7 = r10
            int r9 = r9 + -1
            r5 = r4
            r8 = r17
            r3 = 1
            r4 = 0
            goto L_0x0074
        L_0x042d:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.policyExtError"
            r2.<init>(r3, r4)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>(r2, r0, r4, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x043f:
            boolean r3 = isSelfIssued(r5)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 != 0) goto L_0x0449
            if (r6 <= 0) goto L_0x0449
            int r6 = r6 + -1
        L_0x0449:
            java.lang.String r3 = POLICY_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x05e7 }
            org.spongycastle.asn1.ASN1Primitive r3 = getExtensionValue(r5, r3)     // Catch:{ AnnotatedException -> 0x05e7 }
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3     // Catch:{ AnnotatedException -> 0x05e7 }
            if (r3 == 0) goto L_0x047f
            java.util.Enumeration r3 = r3.getObjects()     // Catch:{ AnnotatedException -> 0x05e7 }
            r4 = r6
        L_0x0458:
            boolean r5 = r3.hasMoreElements()     // Catch:{ AnnotatedException -> 0x05e7 }
            if (r5 == 0) goto L_0x047d
            java.lang.Object r5 = r3.nextElement()     // Catch:{ AnnotatedException -> 0x05e7 }
            org.spongycastle.asn1.ASN1TaggedObject r5 = (org.spongycastle.asn1.ASN1TaggedObject) r5     // Catch:{ AnnotatedException -> 0x05e7 }
            int r6 = r5.getTagNo()     // Catch:{ AnnotatedException -> 0x05e7 }
            if (r6 == 0) goto L_0x046c
            r15 = 0
            goto L_0x0458
        L_0x046c:
            r15 = 0
            org.spongycastle.asn1.ASN1Integer r5 = org.spongycastle.asn1.ASN1Integer.getInstance(r5, r15)     // Catch:{ AnnotatedException -> 0x05e7 }
            java.math.BigInteger r5 = r5.getValue()     // Catch:{ AnnotatedException -> 0x05e7 }
            int r5 = r5.intValue()     // Catch:{ AnnotatedException -> 0x05e7 }
            if (r5 != 0) goto L_0x0458
            r4 = 0
            goto L_0x0458
        L_0x047d:
            r15 = 0
            goto L_0x0481
        L_0x047f:
            r15 = 0
            r4 = r6
        L_0x0481:
            if (r7 != 0) goto L_0x049f
            java.security.cert.PKIXParameters r0 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r0 = r0.isExplicitPolicyRequired()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r0 != 0) goto L_0x048e
            r10 = 0
            goto L_0x05d3
        L_0x048e:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.explicitPolicy"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x049f:
            boolean r3 = isAnyPolicy(r0)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 == 0) goto L_0x0542
            java.security.cert.PKIXParameters r0 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r0 = r0.isExplicitPolicyRequired()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r0 == 0) goto L_0x053f
            boolean r0 = r8.isEmpty()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r0 != 0) goto L_0x052e
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r0.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3 = 0
        L_0x04b9:
            int r5 = r2.length     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 >= r5) goto L_0x04ef
            r5 = r2[r3]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r6 = 0
        L_0x04bf:
            int r9 = r5.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r6 >= r9) goto L_0x04ec
            java.lang.Object r9 = r5.get(r6)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r9 = (org.spongycastle.jce.provider.PKIXPolicyNode) r9     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r10 = "2.5.29.32.0"
            java.lang.String r11 = r9.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r10 = r10.equals(r11)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 == 0) goto L_0x04e9
            java.util.Iterator r9 = r9.getChildren()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x04db:
            boolean r10 = r9.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 == 0) goto L_0x04e9
            java.lang.Object r10 = r9.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r0.add(r10)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x04db
        L_0x04e9:
            int r6 = r6 + 1
            goto L_0x04bf
        L_0x04ec:
            int r3 = r3 + 1
            goto L_0x04b9
        L_0x04ef:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x04f3:
            boolean r3 = r0.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r3 == 0) goto L_0x0507
            java.lang.Object r3 = r0.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r3 = (org.spongycastle.jce.provider.PKIXPolicyNode) r3     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r3 = r3.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8.contains(r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x04f3
        L_0x0507:
            if (r7 == 0) goto L_0x053f
            int r0 = r1.f8258n     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3 = 1
            int r0 = r0 - r3
        L_0x050d:
            if (r0 < 0) goto L_0x053f
            r3 = r2[r0]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r5 = 0
        L_0x0512:
            int r6 = r3.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r5 >= r6) goto L_0x052b
            java.lang.Object r6 = r3.get(r5)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = (org.spongycastle.jce.provider.PKIXPolicyNode) r6     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r8 = r6.hasChildren()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 != 0) goto L_0x0528
            org.spongycastle.jce.provider.PKIXPolicyNode r7 = removePolicyNode(r7, r2, r6)     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0528:
            int r5 = r5 + 1
            goto L_0x0512
        L_0x052b:
            int r0 = r0 + -1
            goto L_0x050d
        L_0x052e:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.explicitPolicy"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x053f:
            r10 = r7
            goto L_0x05d3
        L_0x0542:
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3.<init>()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r5 = 0
        L_0x0548:
            int r6 = r2.length     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r5 >= r6) goto L_0x058c
            r6 = r2[r5]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r8 = 0
        L_0x054e:
            int r9 = r6.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 >= r9) goto L_0x0589
            java.lang.Object r9 = r6.get(r8)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r9 = (org.spongycastle.jce.provider.PKIXPolicyNode) r9     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r10 = "2.5.29.32.0"
            java.lang.String r11 = r9.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r10 = r10.equals(r11)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 == 0) goto L_0x0586
            java.util.Iterator r9 = r9.getChildren()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x056a:
            boolean r10 = r9.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r10 == 0) goto L_0x0586
            java.lang.Object r10 = r9.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r10 = (org.spongycastle.jce.provider.PKIXPolicyNode) r10     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r11 = "2.5.29.32.0"
            java.lang.String r12 = r10.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r11 = r11.equals(r12)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r11 != 0) goto L_0x056a
            r3.add(r10)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            goto L_0x056a
        L_0x0586:
            int r8 = r8 + 1
            goto L_0x054e
        L_0x0589:
            int r5 = r5 + 1
            goto L_0x0548
        L_0x058c:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x0590:
            boolean r5 = r3.hasNext()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r5 == 0) goto L_0x05ac
            java.lang.Object r5 = r3.next()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r5 = (org.spongycastle.jce.provider.PKIXPolicyNode) r5     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r6 = r5.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r6 = r0.contains(r6)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r6 != 0) goto L_0x0590
            org.spongycastle.jce.provider.PKIXPolicyNode r5 = removePolicyNode(r7, r2, r5)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r7 = r5
            goto L_0x0590
        L_0x05ac:
            if (r7 == 0) goto L_0x053f
            int r0 = r1.f8258n     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r3 = 1
            int r0 = r0 - r3
        L_0x05b2:
            if (r0 < 0) goto L_0x053f
            r3 = r2[r0]     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r5 = 0
        L_0x05b7:
            int r6 = r3.size()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r5 >= r6) goto L_0x05d0
            java.lang.Object r6 = r3.get(r5)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = (org.spongycastle.jce.provider.PKIXPolicyNode) r6     // Catch:{ CertPathReviewerException -> 0x05f8 }
            boolean r8 = r6.hasChildren()     // Catch:{ CertPathReviewerException -> 0x05f8 }
            if (r8 != 0) goto L_0x05cd
            org.spongycastle.jce.provider.PKIXPolicyNode r7 = removePolicyNode(r7, r2, r6)     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x05cd:
            int r5 = r5 + 1
            goto L_0x05b7
        L_0x05d0:
            int r0 = r0 + -1
            goto L_0x05b2
        L_0x05d3:
            if (r4 > 0) goto L_0x0604
            if (r10 == 0) goto L_0x05d8
            goto L_0x0604
        L_0x05d8:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.invalidPolicy"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x05e7:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.policyConstExtError"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x05f8 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x05f8 }
            r2.<init>(r0, r3, r9)     // Catch:{ CertPathReviewerException -> 0x05f8 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x05f8 }
        L_0x05f8:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = r0.getErrorMessage()
            int r0 = r0.getIndex()
            r1.addError(r2, r0)
        L_0x0604:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkPolicy():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.security.cert.X509Certificate} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00c3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02f3 A[LOOP:1: B:101:0x02ed->B:103:0x02f3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0320 A[LOOP:2: B:105:0x031a->B:107:0x0320, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03a2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02ab A[SYNTHETIC, Splitter:B:86:0x02ab] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02cf A[Catch:{ AnnotatedException -> 0x02d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkSignatures() {
        /*
            r19 = this;
            r10 = r19
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.certPathValidDate"
            r11 = 2
            java.lang.Object[] r3 = new java.lang.Object[r11]
            org.spongycastle.i18n.filter.TrustedInput r4 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r5 = r10.validDate
            r4.<init>(r5)
            r12 = 0
            r3[r12] = r4
            org.spongycastle.i18n.filter.TrustedInput r4 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            r4.<init>(r5)
            r13 = 1
            r3[r13] = r4
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r3)
            r10.addNotification(r0)
            java.util.List r0 = r10.certs     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.util.List r1 = r10.certs     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            int r1 = r1.size()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            int r1 = r1 - r13
            java.lang.Object r0 = r0.get(r1)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.security.cert.PKIXParameters r1 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.util.Set r1 = r1.getTrustAnchors()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.util.Collection r1 = r10.getTrustAnchors(r0, r1)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            int r2 = r1.size()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            if (r2 <= r13) goto L_0x006b
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.conflictingTrustAnchors"
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            int r1 = r1.size()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.lang.Integer r1 = org.spongycastle.util.Integers.valueOf(r1)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r5[r12] = r1     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            org.spongycastle.i18n.filter.UntrustedInput r1 = new org.spongycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            javax.security.auth.x500.X500Principal r0 = r0.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r1.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r5[r13] = r1     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r10.addError(r2)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            goto L_0x009a
        L_0x006b:
            boolean r2 = r1.isEmpty()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            if (r2 == 0) goto L_0x009c
            org.spongycastle.i18n.ErrorBundle r1 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.noTrustAnchorFound"
            java.lang.Object[] r4 = new java.lang.Object[r11]     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            org.spongycastle.i18n.filter.UntrustedInput r5 = new org.spongycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            javax.security.auth.x500.X500Principal r0 = r0.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r5.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r4[r12] = r5     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.security.cert.PKIXParameters r0 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.util.Set r0 = r0.getTrustAnchors()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            int r0 = r0.size()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.lang.Integer r0 = org.spongycastle.util.Integers.valueOf(r0)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r4[r13] = r0     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            r10.addError(r1)     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
        L_0x009a:
            r1 = 0
            goto L_0x0100
        L_0x009c:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.lang.Object r1 = r1.next()     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.security.cert.TrustAnchor r1 = (java.security.cert.TrustAnchor) r1     // Catch:{ CertPathReviewerException -> 0x00f7, Throwable -> 0x00d4 }
            java.security.cert.X509Certificate r2 = r1.getTrustedCert()     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
            if (r2 == 0) goto L_0x00b5
            java.security.cert.X509Certificate r2 = r1.getTrustedCert()     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
            goto L_0x00b9
        L_0x00b5:
            java.security.PublicKey r2 = r1.getCAPublicKey()     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
        L_0x00b9:
            java.security.cert.PKIXParameters r3 = r10.pkixParams     // Catch:{ SignatureException -> 0x00c3, Exception -> 0x0100 }
            java.lang.String r3 = r3.getSigProvider()     // Catch:{ SignatureException -> 0x00c3, Exception -> 0x0100 }
            org.spongycastle.x509.CertPathValidatorUtilities.verifyX509Certificate(r0, r2, r3)     // Catch:{ SignatureException -> 0x00c3, Exception -> 0x0100 }
            goto L_0x0100
        L_0x00c3:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.trustButInvalidCert"
            r0.<init>(r2, r3)     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
            r10.addError(r0)     // Catch:{ CertPathReviewerException -> 0x00d2, Throwable -> 0x00d0 }
            goto L_0x0100
        L_0x00d0:
            r0 = move-exception
            goto L_0x00d6
        L_0x00d2:
            r0 = move-exception
            goto L_0x00f9
        L_0x00d4:
            r0 = move-exception
            r1 = 0
        L_0x00d6:
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.unknown"
            java.lang.Object[] r5 = new java.lang.Object[r11]
            org.spongycastle.i18n.filter.UntrustedInput r6 = new org.spongycastle.i18n.filter.UntrustedInput
            java.lang.String r7 = r0.getMessage()
            r6.<init>(r7)
            r5[r12] = r6
            org.spongycastle.i18n.filter.UntrustedInput r6 = new org.spongycastle.i18n.filter.UntrustedInput
            r6.<init>(r0)
            r5[r13] = r6
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.Object[]) r5)
            r10.addError(r2)
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            r1 = 0
        L_0x00f9:
            org.spongycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r10.addError(r0)
        L_0x0100:
            r15 = r1
            r16 = 5
            if (r15 == 0) goto L_0x014d
            java.security.cert.X509Certificate r0 = r15.getTrustedCert()
            if (r0 == 0) goto L_0x0110
            javax.security.auth.x500.X500Principal r1 = getSubjectPrincipal(r0)     // Catch:{ IllegalArgumentException -> 0x011a }
            goto L_0x0134
        L_0x0110:
            javax.security.auth.x500.X500Principal r1 = new javax.security.auth.x500.X500Principal     // Catch:{ IllegalArgumentException -> 0x011a }
            java.lang.String r2 = r15.getCAName()     // Catch:{ IllegalArgumentException -> 0x011a }
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x011a }
            goto L_0x0134
        L_0x011a:
            org.spongycastle.i18n.ErrorBundle r1 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.trustDNInvalid"
            java.lang.Object[] r4 = new java.lang.Object[r13]
            org.spongycastle.i18n.filter.UntrustedInput r5 = new org.spongycastle.i18n.filter.UntrustedInput
            java.lang.String r6 = r15.getCAName()
            r5.<init>(r6)
            r4[r12] = r5
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object[]) r4)
            r10.addError(r1)
            r1 = 0
        L_0x0134:
            if (r0 == 0) goto L_0x014e
            boolean[] r0 = r0.getKeyUsage()
            if (r0 == 0) goto L_0x014e
            boolean r0 = r0[r16]
            if (r0 != 0) goto L_0x014e
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.trustKeyUsage"
            r0.<init>(r2, r3)
            r10.addNotification(r0)
            goto L_0x014e
        L_0x014d:
            r1 = 0
        L_0x014e:
            if (r15 == 0) goto L_0x0177
            java.security.cert.X509Certificate r0 = r15.getTrustedCert()
            if (r0 == 0) goto L_0x015b
            java.security.PublicKey r2 = r0.getPublicKey()
            goto L_0x015f
        L_0x015b:
            java.security.PublicKey r2 = r15.getCAPublicKey()
        L_0x015f:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = getAlgorithmIdentifier(r2)     // Catch:{ CertPathValidatorException -> 0x016a }
            r3.getAlgorithm()     // Catch:{ CertPathValidatorException -> 0x016a }
            r3.getParameters()     // Catch:{ CertPathValidatorException -> 0x016a }
            goto L_0x0179
        L_0x016a:
            org.spongycastle.i18n.ErrorBundle r3 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r4 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r5 = "CertPathReviewer.trustPubKeyError"
            r3.<init>(r4, r5)
            r10.addError(r3)
            goto L_0x0179
        L_0x0177:
            r0 = 0
            r2 = 0
        L_0x0179:
            java.util.List r3 = r10.certs
            int r3 = r3.size()
            int r3 = r3 - r13
            r5 = r0
            r7 = r1
            r8 = r2
            r9 = r3
        L_0x0184:
            if (r9 < 0) goto L_0x042d
            int r0 = r10.f8258n
            int r6 = r0 - r9
            java.util.List r0 = r10.certs
            java.lang.Object r0 = r0.get(r9)
            r4 = r0
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4
            r1 = 3
            if (r8 == 0) goto L_0x01c4
            java.security.cert.PKIXParameters r0 = r10.pkixParams     // Catch:{ GeneralSecurityException -> 0x01a1 }
            java.lang.String r0 = r0.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x01a1 }
            org.spongycastle.x509.CertPathValidatorUtilities.verifyX509Certificate(r4, r8, r0)     // Catch:{ GeneralSecurityException -> 0x01a1 }
            goto L_0x026b
        L_0x01a1:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r14 = "CertPathReviewer.signatureNotVerified"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r17 = r0.getMessage()
            r1[r12] = r17
            r1[r13] = r0
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r1[r11] = r0
            r2.<init>((java.lang.String) r3, (java.lang.String) r14, (java.lang.Object[]) r1)
        L_0x01bf:
            r10.addError(r2, r9)
            goto L_0x026b
        L_0x01c4:
            boolean r0 = isSelfIssued(r4)
            if (r0 == 0) goto L_0x0204
            java.security.PublicKey r0 = r4.getPublicKey()     // Catch:{ GeneralSecurityException -> 0x01e5 }
            java.security.cert.PKIXParameters r2 = r10.pkixParams     // Catch:{ GeneralSecurityException -> 0x01e5 }
            java.lang.String r2 = r2.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x01e5 }
            org.spongycastle.x509.CertPathValidatorUtilities.verifyX509Certificate(r4, r0, r2)     // Catch:{ GeneralSecurityException -> 0x01e5 }
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ GeneralSecurityException -> 0x01e5 }
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.rootKeyIsValidButNotATrustAnchor"
            r0.<init>(r2, r3)     // Catch:{ GeneralSecurityException -> 0x01e5 }
            r10.addError(r0, r9)     // Catch:{ GeneralSecurityException -> 0x01e5 }
            goto L_0x026b
        L_0x01e5:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r14 = "CertPathReviewer.signatureNotVerified"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r17 = r0.getMessage()
            r1[r12] = r17
            r1[r13] = r0
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r1[r11] = r0
            r2.<init>((java.lang.String) r3, (java.lang.String) r14, (java.lang.Object[]) r1)
            goto L_0x01bf
        L_0x0204:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.NoIssuerPublicKey"
            r0.<init>(r2, r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.x509.Extension.authorityKeyIdentifier
            java.lang.String r2 = r2.getId()
            byte[] r2 = r4.getExtensionValue(r2)
            if (r2 == 0) goto L_0x0268
            org.spongycastle.asn1.ASN1OctetString r2 = org.spongycastle.asn1.DEROctetString.getInstance(r2)
            byte[] r2 = r2.getOctets()
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r2 = org.spongycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r2)
            org.spongycastle.asn1.x509.GeneralNames r3 = r2.getAuthorityCertIssuer()
            if (r3 == 0) goto L_0x0268
            org.spongycastle.asn1.x509.GeneralName[] r3 = r3.getNames()
            r3 = r3[r12]
            java.math.BigInteger r2 = r2.getAuthorityCertSerialNumber()
            if (r2 == 0) goto L_0x0268
            r14 = 7
            java.lang.Object[] r14 = new java.lang.Object[r14]
            org.spongycastle.i18n.LocaleString r1 = new org.spongycastle.i18n.LocaleString
            java.lang.String r11 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r13 = "missingIssuer"
            r1.<init>(r11, r13)
            r14[r12] = r1
            java.lang.String r1 = " \""
            r11 = 1
            r14[r11] = r1
            r1 = 2
            r14[r1] = r3
            java.lang.String r1 = "\" "
            r3 = 3
            r14[r3] = r1
            r1 = 4
            org.spongycastle.i18n.LocaleString r3 = new org.spongycastle.i18n.LocaleString
            java.lang.String r11 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r13 = "missingSerial"
            r3.<init>(r11, r13)
            r14[r1] = r3
            java.lang.String r1 = " "
            r14[r16] = r1
            r1 = 6
            r14[r1] = r2
            r0.setExtraArguments(r14)
        L_0x0268:
            r10.addError(r0, r9)
        L_0x026b:
            java.util.Date r0 = r10.validDate     // Catch:{ CertificateNotYetValidException -> 0x0289, CertificateExpiredException -> 0x0271 }
            r4.checkValidity(r0)     // Catch:{ CertificateNotYetValidException -> 0x0289, CertificateExpiredException -> 0x0271 }
            goto L_0x02a3
        L_0x0271:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.certificateExpired"
            r3 = 1
            java.lang.Object[] r11 = new java.lang.Object[r3]
            org.spongycastle.i18n.filter.TrustedInput r3 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r13 = r4.getNotAfter()
            r3.<init>(r13)
            r11[r12] = r3
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r11)
            goto L_0x02a0
        L_0x0289:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.certificateNotYetValid"
            r3 = 1
            java.lang.Object[] r11 = new java.lang.Object[r3]
            org.spongycastle.i18n.filter.TrustedInput r3 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r13 = r4.getNotBefore()
            r3.<init>(r13)
            r11[r12] = r3
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r11)
        L_0x02a0:
            r10.addError(r0, r9)
        L_0x02a3:
            java.security.cert.PKIXParameters r0 = r10.pkixParams
            boolean r0 = r0.isRevocationEnabled()
            if (r0 == 0) goto L_0x0368
            java.lang.String r0 = CRL_DIST_POINTS     // Catch:{ AnnotatedException -> 0x02ba }
            org.spongycastle.asn1.ASN1Primitive r0 = getExtensionValue(r4, r0)     // Catch:{ AnnotatedException -> 0x02ba }
            if (r0 == 0) goto L_0x02b8
            org.spongycastle.asn1.x509.CRLDistPoint r14 = org.spongycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ AnnotatedException -> 0x02ba }
            goto L_0x02c7
        L_0x02b8:
            r14 = 0
            goto L_0x02c7
        L_0x02ba:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.crlDistPtExtError"
            r0.<init>(r1, r2)
            r10.addError(r0, r9)
            goto L_0x02b8
        L_0x02c7:
            java.lang.String r0 = AUTH_INFO_ACCESS     // Catch:{ AnnotatedException -> 0x02d4 }
            org.spongycastle.asn1.ASN1Primitive r0 = getExtensionValue(r4, r0)     // Catch:{ AnnotatedException -> 0x02d4 }
            if (r0 == 0) goto L_0x02e0
            org.spongycastle.asn1.x509.AuthorityInformationAccess r0 = org.spongycastle.asn1.x509.AuthorityInformationAccess.getInstance(r0)     // Catch:{ AnnotatedException -> 0x02d4 }
            goto L_0x02e1
        L_0x02d4:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.crlAuthInfoAccError"
            r0.<init>(r1, r2)
            r10.addError(r0, r9)
        L_0x02e0:
            r0 = 0
        L_0x02e1:
            java.util.Vector r11 = r10.getCRLDistUrls(r14)
            java.util.Vector r0 = r10.getOCSPUrls(r0)
            java.util.Iterator r1 = r11.iterator()
        L_0x02ed:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0314
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r13 = "CertPathReviewer.crlDistPoint"
            r14 = 1
            java.lang.Object[] r12 = new java.lang.Object[r14]
            org.spongycastle.i18n.filter.UntrustedUrlInput r14 = new org.spongycastle.i18n.filter.UntrustedUrlInput
            r18 = r6
            java.lang.Object r6 = r1.next()
            r14.<init>(r6)
            r6 = 0
            r12[r6] = r14
            r2.<init>((java.lang.String) r3, (java.lang.String) r13, (java.lang.Object[]) r12)
            r10.addNotification(r2, r9)
            r6 = r18
            r12 = 0
            goto L_0x02ed
        L_0x0314:
            r18 = r6
            java.util.Iterator r1 = r0.iterator()
        L_0x031a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x033c
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r6 = "CertPathReviewer.ocspLocation"
            r12 = 1
            java.lang.Object[] r13 = new java.lang.Object[r12]
            org.spongycastle.i18n.filter.UntrustedUrlInput r12 = new org.spongycastle.i18n.filter.UntrustedUrlInput
            java.lang.Object r14 = r1.next()
            r12.<init>(r14)
            r14 = 0
            r13[r14] = r12
            r2.<init>((java.lang.String) r3, (java.lang.String) r6, (java.lang.Object[]) r13)
            r10.addNotification(r2, r9)
            goto L_0x031a
        L_0x033c:
            java.security.cert.PKIXParameters r2 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x0356 }
            java.util.Date r6 = r10.validDate     // Catch:{ CertPathReviewerException -> 0x0356 }
            r1 = r19
            r3 = r4
            r12 = r4
            r4 = r6
            r13 = r18
            r6 = r8
            r14 = r7
            r7 = r11
            r11 = r8
            r8 = r0
            r18 = r9
            r1.checkRevocation(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ CertPathReviewerException -> 0x0354 }
            r3 = r18
            goto L_0x036d
        L_0x0354:
            r0 = move-exception
            goto L_0x035e
        L_0x0356:
            r0 = move-exception
            r12 = r4
            r14 = r7
            r11 = r8
            r13 = r18
            r18 = r9
        L_0x035e:
            org.spongycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r3 = r18
            r10.addError(r0, r3)
            goto L_0x036d
        L_0x0368:
            r12 = r4
            r13 = r6
            r14 = r7
            r11 = r8
            r3 = r9
        L_0x036d:
            if (r14 == 0) goto L_0x039b
            javax.security.auth.x500.X500Principal r0 = r12.getIssuerX500Principal()
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x039b
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.certWrongIssuer"
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = r14.getName()
            r7 = 0
            r5[r7] = r6
            javax.security.auth.x500.X500Principal r6 = r12.getIssuerX500Principal()
            java.lang.String r6 = r6.getName()
            r8 = 1
            r5[r8] = r6
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r5)
            r10.addError(r0, r3)
            goto L_0x039e
        L_0x039b:
            r4 = 2
            r7 = 0
            r8 = 1
        L_0x039e:
            int r0 = r10.f8258n
            if (r13 == r0) goto L_0x0401
            if (r12 == 0) goto L_0x03b6
            int r0 = r12.getVersion()
            if (r0 != r8) goto L_0x03b6
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.noCACert"
            r0.<init>(r1, r2)
            r10.addError(r0, r3)
        L_0x03b6:
            java.lang.String r0 = BASIC_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x03df }
            org.spongycastle.asn1.ASN1Primitive r0 = getExtensionValue(r12, r0)     // Catch:{ AnnotatedException -> 0x03df }
            org.spongycastle.asn1.x509.BasicConstraints r0 = org.spongycastle.asn1.x509.BasicConstraints.getInstance(r0)     // Catch:{ AnnotatedException -> 0x03df }
            if (r0 == 0) goto L_0x03d5
            boolean r0 = r0.isCA()     // Catch:{ AnnotatedException -> 0x03df }
            if (r0 != 0) goto L_0x03eb
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x03df }
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.noCACert"
            r0.<init>(r1, r2)     // Catch:{ AnnotatedException -> 0x03df }
        L_0x03d1:
            r10.addError(r0, r3)     // Catch:{ AnnotatedException -> 0x03df }
            goto L_0x03eb
        L_0x03d5:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x03df }
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.noBasicConstraints"
            r0.<init>(r1, r2)     // Catch:{ AnnotatedException -> 0x03df }
            goto L_0x03d1
        L_0x03df:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.errorProcesingBC"
            r0.<init>(r1, r2)
            r10.addError(r0, r3)
        L_0x03eb:
            boolean[] r0 = r12.getKeyUsage()
            if (r0 == 0) goto L_0x0401
            boolean r0 = r0[r16]
            if (r0 != 0) goto L_0x0401
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r1 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.noCertSign"
            r0.<init>(r1, r2)
            r10.addError(r0, r3)
        L_0x0401:
            javax.security.auth.x500.X500Principal r0 = r12.getSubjectX500Principal()
            java.util.List r1 = r10.certs     // Catch:{ CertPathValidatorException -> 0x0416 }
            java.security.PublicKey r1 = getNextWorkingKey(r1, r3)     // Catch:{ CertPathValidatorException -> 0x0416 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r2 = getAlgorithmIdentifier(r1)     // Catch:{ CertPathValidatorException -> 0x0417 }
            r2.getAlgorithm()     // Catch:{ CertPathValidatorException -> 0x0417 }
            r2.getParameters()     // Catch:{ CertPathValidatorException -> 0x0417 }
            goto L_0x0423
        L_0x0416:
            r1 = r11
        L_0x0417:
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r5 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r6 = "CertPathReviewer.pubKeyError"
            r2.<init>(r5, r6)
            r10.addError(r2, r3)
        L_0x0423:
            int r9 = r3 + -1
            r7 = r0
            r8 = r1
            r5 = r12
            r11 = 2
            r12 = 0
            r13 = 1
            goto L_0x0184
        L_0x042d:
            r11 = r8
            r10.trustAnchor = r15
            r10.subjectPublicKey = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkSignatures():void");
    }

    private X509CRL getCRL(String str) {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http")) {
                if (!url.getProtocol().equals("https")) {
                    return null;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        ErrorBundle errorBundle2;
        int i2 = i;
        char c = 0;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) getExtensionValue(x509Certificate, QC_STATEMENT);
            int i3 = 0;
            boolean z = false;
            while (i3 < aSN1Sequence.size()) {
                QCStatement instance = QCStatement.getInstance(aSN1Sequence.getObjectAt(i3));
                if (QCStatement.id_etsi_qcs_QcCompliance.equals(instance.getStatementId())) {
                    errorBundle2 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance");
                } else {
                    if (!QCStatement.id_qcs_pkixQCSyntax_v1.equals(instance.getStatementId())) {
                        if (QCStatement.id_etsi_qcs_QcSSCD.equals(instance.getStatementId())) {
                            errorBundle2 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD");
                        } else if (QCStatement.id_etsi_qcs_LimiteValue.equals(instance.getStatementId())) {
                            MonetaryValue instance2 = MonetaryValue.getInstance(instance.getStatementInfo());
                            instance2.getCurrency();
                            double doubleValue = instance2.getAmount().doubleValue() * Math.pow(10.0d, instance2.getExponent().doubleValue());
                            if (instance2.getCurrency().isAlphabetic()) {
                                Object[] objArr = new Object[3];
                                objArr[c] = instance2.getCurrency().getAlphabetic();
                                objArr[1] = new TrustedInput(new Double(doubleValue));
                                objArr[2] = instance2;
                                errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", objArr);
                            } else {
                                errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(instance2.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), instance2});
                            }
                            addNotification(errorBundle, i2);
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{instance.getStatementId(), new UntrustedInput(instance)}), i2);
                            z = true;
                        }
                    }
                    i3++;
                    c = 0;
                }
                addNotification(errorBundle2, i2);
                i3++;
                c = 0;
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f8258n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f8258n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkCRLs(java.security.cert.PKIXParameters r18, java.security.cert.X509Certificate r19, java.util.Date r20, java.security.cert.X509Certificate r21, java.security.PublicKey r22, java.util.Vector r23, int r24) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r22
            r5 = r24
            org.spongycastle.x509.X509CRLStoreSelector r0 = new org.spongycastle.x509.X509CRLStoreSelector
            r0.<init>()
            javax.security.auth.x500.X500Principal r6 = getEncodedIssuerPrincipal(r19)     // Catch:{ IOException -> 0x049a }
            byte[] r6 = r6.getEncoded()     // Catch:{ IOException -> 0x049a }
            r0.addIssuerName(r6)     // Catch:{ IOException -> 0x049a }
            r0.setCertificateChecking(r3)
            r6 = 3
            r8 = 0
            r9 = 1
            org.spongycastle.x509.PKIXCRLUtil r10 = CRL_UTIL     // Catch:{ AnnotatedException -> 0x0084 }
            java.util.Set r10 = r10.findCRLs((org.spongycastle.x509.X509CRLStoreSelector) r0, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x0084 }
            java.util.Iterator r11 = r10.iterator()     // Catch:{ AnnotatedException -> 0x0084 }
            boolean r10 = r10.isEmpty()     // Catch:{ AnnotatedException -> 0x0084 }
            if (r10 == 0) goto L_0x00bc
            org.spongycastle.x509.PKIXCRLUtil r10 = CRL_UTIL     // Catch:{ AnnotatedException -> 0x0084 }
            org.spongycastle.x509.X509CRLStoreSelector r12 = new org.spongycastle.x509.X509CRLStoreSelector     // Catch:{ AnnotatedException -> 0x0084 }
            r12.<init>()     // Catch:{ AnnotatedException -> 0x0084 }
            java.util.Set r10 = r10.findCRLs((org.spongycastle.x509.X509CRLStoreSelector) r12, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x0084 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ AnnotatedException -> 0x0084 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ AnnotatedException -> 0x0084 }
            r12.<init>()     // Catch:{ AnnotatedException -> 0x0084 }
        L_0x0044:
            boolean r13 = r10.hasNext()     // Catch:{ AnnotatedException -> 0x0084 }
            if (r13 == 0) goto L_0x0058
            java.lang.Object r13 = r10.next()     // Catch:{ AnnotatedException -> 0x0084 }
            java.security.cert.X509CRL r13 = (java.security.cert.X509CRL) r13     // Catch:{ AnnotatedException -> 0x0084 }
            javax.security.auth.x500.X500Principal r13 = r13.getIssuerX500Principal()     // Catch:{ AnnotatedException -> 0x0084 }
            r12.add(r13)     // Catch:{ AnnotatedException -> 0x0084 }
            goto L_0x0044
        L_0x0058:
            int r10 = r12.size()     // Catch:{ AnnotatedException -> 0x0084 }
            org.spongycastle.i18n.ErrorBundle r13 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x0084 }
            java.lang.String r14 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r15 = "CertPathReviewer.noCrlInCertstore"
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ AnnotatedException -> 0x0084 }
            org.spongycastle.i18n.filter.UntrustedInput r6 = new org.spongycastle.i18n.filter.UntrustedInput     // Catch:{ AnnotatedException -> 0x0084 }
            java.util.Collection r0 = r0.getIssuerNames()     // Catch:{ AnnotatedException -> 0x0084 }
            r6.<init>(r0)     // Catch:{ AnnotatedException -> 0x0084 }
            r7[r8] = r6     // Catch:{ AnnotatedException -> 0x0084 }
            org.spongycastle.i18n.filter.UntrustedInput r0 = new org.spongycastle.i18n.filter.UntrustedInput     // Catch:{ AnnotatedException -> 0x0084 }
            r0.<init>(r12)     // Catch:{ AnnotatedException -> 0x0084 }
            r7[r9] = r0     // Catch:{ AnnotatedException -> 0x0084 }
            java.lang.Integer r0 = org.spongycastle.util.Integers.valueOf(r10)     // Catch:{ AnnotatedException -> 0x0084 }
            r6 = 2
            r7[r6] = r0     // Catch:{ AnnotatedException -> 0x0084 }
            r13.<init>((java.lang.String) r14, (java.lang.String) r15, (java.lang.Object[]) r7)     // Catch:{ AnnotatedException -> 0x0084 }
            r1.addNotification(r13, r5)     // Catch:{ AnnotatedException -> 0x0084 }
            goto L_0x00bc
        L_0x0084:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r6 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r7 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r10 = "CertPathReviewer.crlExtractionError"
            r11 = 3
            java.lang.Object[] r12 = new java.lang.Object[r11]
            java.lang.Throwable r11 = r0.getCause()
            java.lang.String r11 = r11.getMessage()
            r12[r8] = r11
            java.lang.Throwable r11 = r0.getCause()
            r12[r9] = r11
            java.lang.Throwable r0 = r0.getCause()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r11 = 2
            r12[r11] = r0
            r6.<init>((java.lang.String) r7, (java.lang.String) r10, (java.lang.Object[]) r12)
            r1.addError(r6, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r0.iterator()
        L_0x00bc:
            r0 = 0
        L_0x00bd:
            boolean r7 = r11.hasNext()
            if (r7 == 0) goto L_0x012c
            java.lang.Object r0 = r11.next()
            java.security.cert.X509CRL r0 = (java.security.cert.X509CRL) r0
            java.util.Date r7 = r0.getNextUpdate()
            if (r7 == 0) goto L_0x0104
            java.util.Date r7 = r18.getDate()
            java.util.Date r10 = r0.getNextUpdate()
            boolean r7 = r7.before(r10)
            if (r7 == 0) goto L_0x00de
            goto L_0x0104
        L_0x00de:
            org.spongycastle.i18n.ErrorBundle r7 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r10 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r12 = "CertPathReviewer.localInvalidCRL"
            r13 = 2
            java.lang.Object[] r14 = new java.lang.Object[r13]
            org.spongycastle.i18n.filter.TrustedInput r13 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r15 = r0.getThisUpdate()
            r13.<init>(r15)
            r14[r8] = r13
            org.spongycastle.i18n.filter.TrustedInput r13 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r15 = r0.getNextUpdate()
            r13.<init>(r15)
            r14[r9] = r13
            r7.<init>((java.lang.String) r10, (java.lang.String) r12, (java.lang.Object[]) r14)
            r1.addNotification(r7, r5)
            goto L_0x00bd
        L_0x0104:
            org.spongycastle.i18n.ErrorBundle r7 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r10 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r11 = "CertPathReviewer.localValidCRL"
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]
            org.spongycastle.i18n.filter.TrustedInput r12 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getThisUpdate()
            r12.<init>(r14)
            r13[r8] = r12
            org.spongycastle.i18n.filter.TrustedInput r12 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getNextUpdate()
            r12.<init>(r14)
            r13[r9] = r12
            r7.<init>((java.lang.String) r10, (java.lang.String) r11, (java.lang.Object[]) r13)
            r1.addNotification(r7, r5)
            r7 = r0
            r0 = 1
            goto L_0x012e
        L_0x012c:
            r7 = r0
            r0 = 0
        L_0x012e:
            if (r0 != 0) goto L_0x021a
            java.util.Iterator r10 = r23.iterator()
            r11 = r0
        L_0x0135:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x021b
            java.lang.Object r0 = r10.next()     // Catch:{ CertPathReviewerException -> 0x020d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ CertPathReviewerException -> 0x020d }
            java.security.cert.X509CRL r12 = r1.getCRL(r0)     // Catch:{ CertPathReviewerException -> 0x020d }
            if (r12 == 0) goto L_0x018b
            javax.security.auth.x500.X500Principal r13 = r19.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x020d }
            javax.security.auth.x500.X500Principal r14 = r12.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x020d }
            boolean r13 = r13.equals(r14)     // Catch:{ CertPathReviewerException -> 0x020d }
            if (r13 != 0) goto L_0x018e
            org.spongycastle.i18n.ErrorBundle r13 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x020d }
            java.lang.String r14 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r15 = "CertPathReviewer.onlineCRLWrongCA"
            r6 = 3
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ CertPathReviewerException -> 0x020d }
            org.spongycastle.i18n.filter.UntrustedInput r6 = new org.spongycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x020d }
            javax.security.auth.x500.X500Principal r12 = r12.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x020d }
            java.lang.String r12 = r12.getName()     // Catch:{ CertPathReviewerException -> 0x020d }
            r6.<init>(r12)     // Catch:{ CertPathReviewerException -> 0x020d }
            r9[r8] = r6     // Catch:{ CertPathReviewerException -> 0x020d }
            org.spongycastle.i18n.filter.UntrustedInput r6 = new org.spongycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x020d }
            javax.security.auth.x500.X500Principal r12 = r19.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x020d }
            java.lang.String r12 = r12.getName()     // Catch:{ CertPathReviewerException -> 0x020d }
            r6.<init>(r12)     // Catch:{ CertPathReviewerException -> 0x020d }
            r12 = 1
            r9[r12] = r6     // Catch:{ CertPathReviewerException -> 0x020d }
            org.spongycastle.i18n.filter.UntrustedUrlInput r6 = new org.spongycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x020d }
            r6.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x020d }
            r12 = 2
            r9[r12] = r6     // Catch:{ CertPathReviewerException -> 0x020d }
            r13.<init>((java.lang.String) r14, (java.lang.String) r15, (java.lang.Object[]) r9)     // Catch:{ CertPathReviewerException -> 0x020d }
            r1.addNotification(r13, r5)     // Catch:{ CertPathReviewerException -> 0x020d }
        L_0x018b:
            r13 = 3
            goto L_0x0216
        L_0x018e:
            java.util.Date r6 = r12.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x020d }
            if (r6 == 0) goto L_0x01d5
            java.security.cert.PKIXParameters r6 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x020d }
            java.util.Date r6 = r6.getDate()     // Catch:{ CertPathReviewerException -> 0x020d }
            java.util.Date r9 = r12.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x020d }
            boolean r6 = r6.before(r9)     // Catch:{ CertPathReviewerException -> 0x020d }
            if (r6 == 0) goto L_0x01a5
            goto L_0x01d5
        L_0x01a5:
            org.spongycastle.i18n.ErrorBundle r6 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x020d }
            java.lang.String r9 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r13 = "CertPathReviewer.onlineInvalidCRL"
            r14 = 3
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ CertPathReviewerException -> 0x020d }
            org.spongycastle.i18n.filter.TrustedInput r14 = new org.spongycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x020d }
            java.util.Date r8 = r12.getThisUpdate()     // Catch:{ CertPathReviewerException -> 0x020d }
            r14.<init>(r8)     // Catch:{ CertPathReviewerException -> 0x020d }
            r8 = 0
            r15[r8] = r14     // Catch:{ CertPathReviewerException -> 0x020d }
            org.spongycastle.i18n.filter.TrustedInput r8 = new org.spongycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x020d }
            java.util.Date r12 = r12.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x020d }
            r8.<init>(r12)     // Catch:{ CertPathReviewerException -> 0x020d }
            r12 = 1
            r15[r12] = r8     // Catch:{ CertPathReviewerException -> 0x020d }
            org.spongycastle.i18n.filter.UntrustedUrlInput r8 = new org.spongycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x020d }
            r8.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x020d }
            r12 = 2
            r15[r12] = r8     // Catch:{ CertPathReviewerException -> 0x020d }
            r6.<init>((java.lang.String) r9, (java.lang.String) r13, (java.lang.Object[]) r15)     // Catch:{ CertPathReviewerException -> 0x020d }
            r1.addNotification(r6, r5)     // Catch:{ CertPathReviewerException -> 0x020d }
            goto L_0x018b
        L_0x01d5:
            org.spongycastle.i18n.ErrorBundle r6 = new org.spongycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0209 }
            java.lang.String r8 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r9 = "CertPathReviewer.onlineValidCRL"
            r13 = 3
            java.lang.Object[] r11 = new java.lang.Object[r13]     // Catch:{ CertPathReviewerException -> 0x0207 }
            org.spongycastle.i18n.filter.TrustedInput r14 = new org.spongycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x0207 }
            java.util.Date r15 = r12.getThisUpdate()     // Catch:{ CertPathReviewerException -> 0x0207 }
            r14.<init>(r15)     // Catch:{ CertPathReviewerException -> 0x0207 }
            r15 = 0
            r11[r15] = r14     // Catch:{ CertPathReviewerException -> 0x0207 }
            org.spongycastle.i18n.filter.TrustedInput r14 = new org.spongycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x0207 }
            java.util.Date r15 = r12.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x0207 }
            r14.<init>(r15)     // Catch:{ CertPathReviewerException -> 0x0207 }
            r15 = 1
            r11[r15] = r14     // Catch:{ CertPathReviewerException -> 0x0207 }
            org.spongycastle.i18n.filter.UntrustedUrlInput r14 = new org.spongycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x0207 }
            r14.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0207 }
            r15 = 2
            r11[r15] = r14     // Catch:{ CertPathReviewerException -> 0x0207 }
            r6.<init>((java.lang.String) r8, (java.lang.String) r9, (java.lang.Object[]) r11)     // Catch:{ CertPathReviewerException -> 0x0207 }
            r1.addNotification(r6, r5)     // Catch:{ CertPathReviewerException -> 0x0207 }
            r7 = r12
            r11 = 1
            goto L_0x021b
        L_0x0207:
            r0 = move-exception
            goto L_0x020b
        L_0x0209:
            r0 = move-exception
            r13 = 3
        L_0x020b:
            r11 = 1
            goto L_0x020f
        L_0x020d:
            r0 = move-exception
            r13 = 3
        L_0x020f:
            org.spongycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r1.addNotification(r0, r5)
        L_0x0216:
            r8 = 0
            r9 = 1
            goto L_0x0135
        L_0x021a:
            r11 = r0
        L_0x021b:
            if (r7 == 0) goto L_0x0488
            r0 = 7
            if (r21 == 0) goto L_0x023e
            boolean[] r6 = r21.getKeyUsage()
            if (r6 == 0) goto L_0x023e
            int r8 = r6.length
            if (r8 < r0) goto L_0x022f
            r8 = 6
            boolean r6 = r6[r8]
            if (r6 == 0) goto L_0x022f
            goto L_0x023e
        L_0x022f:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.noCrlSigningPermited"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x023e:
            if (r4 == 0) goto L_0x0479
            java.lang.String r6 = "SC"
            r7.verify(r4, r6)     // Catch:{ Exception -> 0x0469 }
            java.math.BigInteger r4 = r19.getSerialNumber()
            java.security.cert.X509CRLEntry r4 = r7.getRevokedCertificate(r4)
            if (r4 == 0) goto L_0x02de
            boolean r6 = r4.hasExtensions()
            if (r6 == 0) goto L_0x0284
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = org.spongycastle.asn1.x509.Extension.reasonCode     // Catch:{ AnnotatedException -> 0x0274 }
            java.lang.String r6 = r6.getId()     // Catch:{ AnnotatedException -> 0x0274 }
            org.spongycastle.asn1.ASN1Primitive r6 = getExtensionValue(r4, r6)     // Catch:{ AnnotatedException -> 0x0274 }
            org.spongycastle.asn1.ASN1Enumerated r6 = org.spongycastle.asn1.ASN1Enumerated.getInstance(r6)     // Catch:{ AnnotatedException -> 0x0274 }
            if (r6 == 0) goto L_0x0284
            java.lang.String[] r8 = crlReasons
            java.math.BigInteger r6 = r6.getValue()
            int r6 = r6.intValue()
            r6 = r8[r6]
            r16 = r6
            goto L_0x0286
        L_0x0274:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlReasonExtError"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0284:
            r16 = 0
        L_0x0286:
            if (r16 != 0) goto L_0x028c
            java.lang.String[] r6 = crlReasons
            r16 = r6[r0]
        L_0x028c:
            r0 = r16
            org.spongycastle.i18n.LocaleString r6 = new org.spongycastle.i18n.LocaleString
            java.lang.String r8 = "org.spongycastle.x509.CertPathReviewerMessages"
            r6.<init>(r8, r0)
            java.util.Date r0 = r4.getRevocationDate()
            r8 = r20
            boolean r0 = r8.before(r0)
            if (r0 == 0) goto L_0x02bd
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r8 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r9 = "CertPathReviewer.revokedAfterValidation"
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            org.spongycastle.i18n.filter.TrustedInput r12 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r4 = r4.getRevocationDate()
            r12.<init>(r4)
            r13 = 0
            r10[r13] = r12
            r12 = 1
            r10[r12] = r6
            r0.<init>((java.lang.String) r8, (java.lang.String) r9, (java.lang.Object[]) r10)
            goto L_0x02e7
        L_0x02bd:
            r10 = 2
            r12 = 1
            r13 = 0
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.Object[] r2 = new java.lang.Object[r10]
            org.spongycastle.i18n.filter.TrustedInput r3 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r4 = r4.getRevocationDate()
            r3.<init>(r4)
            r2[r13] = r3
            r2[r12] = r6
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.certRevoked"
            r0.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.Object[]) r2)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x02de:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r4 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r6 = "CertPathReviewer.notRevoked"
            r0.<init>(r4, r6)
        L_0x02e7:
            r1.addNotification(r0, r5)
            java.util.Date r0 = r7.getNextUpdate()
            if (r0 == 0) goto L_0x031c
            java.util.Date r0 = r7.getNextUpdate()
            java.security.cert.PKIXParameters r4 = r1.pkixParams
            java.util.Date r4 = r4.getDate()
            boolean r0 = r0.before(r4)
            if (r0 == 0) goto L_0x031c
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r4 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r6 = "CertPathReviewer.crlUpdateAvailable"
            r12 = 1
            java.lang.Object[] r8 = new java.lang.Object[r12]
            org.spongycastle.i18n.filter.TrustedInput r9 = new org.spongycastle.i18n.filter.TrustedInput
            java.util.Date r10 = r7.getNextUpdate()
            r9.<init>(r10)
            r10 = 0
            r8[r10] = r9
            r0.<init>((java.lang.String) r4, (java.lang.String) r6, (java.lang.Object[]) r8)
            r1.addNotification(r0, r5)
            goto L_0x031e
        L_0x031c:
            r10 = 0
            r12 = 1
        L_0x031e:
            java.lang.String r0 = ISSUING_DISTRIBUTION_POINT     // Catch:{ AnnotatedException -> 0x045a }
            org.spongycastle.asn1.ASN1Primitive r0 = getExtensionValue(r7, r0)     // Catch:{ AnnotatedException -> 0x045a }
            java.lang.String r4 = DELTA_CRL_INDICATOR     // Catch:{ AnnotatedException -> 0x044b }
            org.spongycastle.asn1.ASN1Primitive r4 = getExtensionValue(r7, r4)     // Catch:{ AnnotatedException -> 0x044b }
            if (r4 == 0) goto L_0x03d9
            org.spongycastle.x509.X509CRLStoreSelector r5 = new org.spongycastle.x509.X509CRLStoreSelector
            r5.<init>()
            javax.security.auth.x500.X500Principal r6 = getIssuerPrincipal(r7)     // Catch:{ IOException -> 0x03c9 }
            byte[] r6 = r6.getEncoded()     // Catch:{ IOException -> 0x03c9 }
            r5.addIssuerName(r6)     // Catch:{ IOException -> 0x03c9 }
            org.spongycastle.asn1.ASN1Integer r4 = (org.spongycastle.asn1.ASN1Integer) r4
            java.math.BigInteger r4 = r4.getPositiveValue()
            r5.setMinCRLNumber(r4)
            java.lang.String r4 = CRL_NUMBER     // Catch:{ AnnotatedException -> 0x03b9 }
            org.spongycastle.asn1.ASN1Primitive r4 = getExtensionValue(r7, r4)     // Catch:{ AnnotatedException -> 0x03b9 }
            org.spongycastle.asn1.ASN1Integer r4 = (org.spongycastle.asn1.ASN1Integer) r4     // Catch:{ AnnotatedException -> 0x03b9 }
            java.math.BigInteger r4 = r4.getPositiveValue()     // Catch:{ AnnotatedException -> 0x03b9 }
            r6 = 1
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r6)     // Catch:{ AnnotatedException -> 0x03b9 }
            java.math.BigInteger r4 = r4.subtract(r6)     // Catch:{ AnnotatedException -> 0x03b9 }
            r5.setMaxCRLNumber(r4)     // Catch:{ AnnotatedException -> 0x03b9 }
            org.spongycastle.x509.PKIXCRLUtil r4 = CRL_UTIL     // Catch:{ AnnotatedException -> 0x03a9 }
            java.util.Set r2 = r4.findCRLs((org.spongycastle.x509.X509CRLStoreSelector) r5, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x03a9 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ AnnotatedException -> 0x03a9 }
        L_0x0368:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0396
            java.lang.Object r4 = r2.next()
            java.security.cert.X509CRL r4 = (java.security.cert.X509CRL) r4
            java.lang.String r5 = ISSUING_DISTRIBUTION_POINT     // Catch:{ AnnotatedException -> 0x0386 }
            org.spongycastle.asn1.ASN1Primitive r4 = getExtensionValue(r4, r5)     // Catch:{ AnnotatedException -> 0x0386 }
            if (r0 != 0) goto L_0x037f
            if (r4 != 0) goto L_0x0368
            goto L_0x0397
        L_0x037f:
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0368
            goto L_0x0397
        L_0x0386:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.distrPtExtError"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0396:
            r12 = 0
        L_0x0397:
            if (r12 == 0) goto L_0x039a
            goto L_0x03d9
        L_0x039a:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.noBaseCRL"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x03a9:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlExtractionError"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03b9:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlNbrExtError"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03c9:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlIssuerException"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03d9:
            if (r0 == 0) goto L_0x0488
            org.spongycastle.asn1.x509.IssuingDistributionPoint r0 = org.spongycastle.asn1.x509.IssuingDistributionPoint.getInstance(r0)
            java.lang.String r2 = BASIC_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x043b }
            org.spongycastle.asn1.ASN1Primitive r2 = getExtensionValue(r3, r2)     // Catch:{ AnnotatedException -> 0x043b }
            org.spongycastle.asn1.x509.BasicConstraints r2 = org.spongycastle.asn1.x509.BasicConstraints.getInstance(r2)     // Catch:{ AnnotatedException -> 0x043b }
            boolean r3 = r0.onlyContainsUserCerts()
            if (r3 == 0) goto L_0x0407
            if (r2 == 0) goto L_0x0407
            boolean r3 = r2.isCA()
            if (r3 != 0) goto L_0x03f8
            goto L_0x0407
        L_0x03f8:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.crlOnlyUserCert"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0407:
            boolean r3 = r0.onlyContainsCACerts()
            if (r3 == 0) goto L_0x0425
            if (r2 == 0) goto L_0x0416
            boolean r2 = r2.isCA()
            if (r2 == 0) goto L_0x0416
            goto L_0x0425
        L_0x0416:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.crlOnlyCaCert"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0425:
            boolean r0 = r0.onlyContainsAttributeCerts()
            if (r0 != 0) goto L_0x042c
            goto L_0x0488
        L_0x042c:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.crlOnlyAttrCert"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x043b:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlBCExtError"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x044b:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.deltaCrlExtError"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x045a:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.distrPtExtError"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0469:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlVerifyFailed"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0479:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.crlNoIssuerPublicKey"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0488:
            if (r11 == 0) goto L_0x048b
            return
        L_0x048b:
            org.spongycastle.i18n.ErrorBundle r0 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r2 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r3 = "CertPathReviewer.noValidCrlFound"
            r0.<init>(r2, r3)
            org.spongycastle.x509.CertPathReviewerException r2 = new org.spongycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x049a:
            r0 = move-exception
            org.spongycastle.i18n.ErrorBundle r2 = new org.spongycastle.i18n.ErrorBundle
            java.lang.String r3 = "org.spongycastle.x509.CertPathReviewerMessages"
            java.lang.String r4 = "CertPathReviewer.crlIssuerException"
            r2.<init>(r3, r4)
            org.spongycastle.x509.CertPathReviewerException r3 = new org.spongycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    /* access modifiers changed from: protected */
    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    /* access modifiers changed from: protected */
    public void doChecks() {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        } else if (this.notifications == null) {
            int i = this.f8258n;
            this.notifications = new List[(i + 1)];
            this.errors = new List[(i + 1)];
            int i2 = 0;
            while (true) {
                List[] listArr = this.notifications;
                if (i2 < listArr.length) {
                    listArr[i2] = new ArrayList();
                    this.errors[i2] = new ArrayList();
                    i2++;
                } else {
                    checkSignatures();
                    checkNameConstraints();
                    checkPathLength();
                    checkPolicy();
                    checkCriticalExtensions();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            for (DistributionPoint distributionPoint : distributionPoints) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.f8258n;
    }

    public List getErrors(int i) {
        doChecks();
        return this.errors[i + 1];
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List getNotifications(int i) {
        doChecks();
        return this.notifications[i + 1];
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    /* access modifiers changed from: protected */
    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    /* access modifiers changed from: protected */
    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(instance.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = instance.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor2 = (TrustAnchor) it.next();
                if (trustAnchor2.getTrustedCert() != null) {
                    if (!x509CertSelector.match(trustAnchor2.getTrustedCert())) {
                    }
                } else if (trustAnchor2.getCAName() != null) {
                    if (trustAnchor2.getCAPublicKey() != null) {
                        if (!getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor2.getCAName()))) {
                        }
                    }
                }
                arrayList.add(trustAnchor2);
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath2, PKIXParameters pKIXParameters) {
        if (!this.initialized) {
            this.initialized = true;
            if (certPath2 != null) {
                this.certPath = certPath2;
                this.certs = certPath2.getCertificates();
                this.f8258n = this.certs.size();
                if (!this.certs.isEmpty()) {
                    this.pkixParams = (PKIXParameters) pKIXParameters.clone();
                    this.validDate = getValidDate(this.pkixParams);
                    this.notifications = null;
                    this.errors = null;
                    this.trustAnchor = null;
                    this.subjectPublicKey = null;
                    this.policyTree = null;
                    return;
                }
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
            }
            throw new NullPointerException("certPath was null");
        }
        throw new IllegalStateException("object is already initialized!");
    }

    public boolean isValidCertPath() {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }
}
