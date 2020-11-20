package org.spongycastle.est;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.operator.ContentSigner;
import org.spongycastle.pkcs.PKCS10CertificationRequest;
import org.spongycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;
import org.spongycastle.util.encoders.Base64;

public class ESTService {
    protected static final String CACERTS = "/cacerts";
    protected static final String CSRATTRS = "/csrattrs";
    protected static final String FULLCMC = "/fullcmc";
    protected static final String SERVERGEN = "/serverkeygen";
    protected static final String SIMPLE_ENROLL = "/simpleenroll";
    protected static final String SIMPLE_REENROLL = "/simplereenroll";
    protected static final Set<String> illegalParts = new HashSet();
    private static final Pattern pathInvalid = Pattern.compile("^[0-9a-zA-Z_\\-.~!$&'()*+,;=]+");
    private final ESTClientProvider clientProvider;
    private final String server;

    static {
        illegalParts.add(CACERTS.substring(1));
        illegalParts.add(SIMPLE_ENROLL.substring(1));
        illegalParts.add(SIMPLE_REENROLL.substring(1));
        illegalParts.add(FULLCMC.substring(1));
        illegalParts.add(SERVERGEN.substring(1));
        illegalParts.add(CSRATTRS.substring(1));
    }

    ESTService(String str, String str2, ESTClientProvider eSTClientProvider) {
        String str3;
        String verifyServer = verifyServer(str);
        if (str2 != null) {
            str3 = "https://" + verifyServer + "/.well-known/est/" + verifyLabel(str2);
        } else {
            str3 = "https://" + verifyServer + "/.well-known/est";
        }
        this.server = str3;
        this.clientProvider = eSTClientProvider;
    }

    /* access modifiers changed from: private */
    public String annotateRequest(byte[] bArr) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        int i = 0;
        do {
            int i2 = i + 48;
            if (i2 < bArr.length) {
                printWriter.print(Base64.toBase64String(bArr, i, 48));
                i = i2;
            } else {
                printWriter.print(Base64.toBase64String(bArr, i, bArr.length - i));
                i = bArr.length;
            }
            printWriter.print(10);
        } while (i < bArr.length);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static X509CertificateHolder[] storeToArray(Store<X509CertificateHolder> store) {
        return storeToArray(store, (Selector<X509CertificateHolder>) null);
    }

    public static X509CertificateHolder[] storeToArray(Store<X509CertificateHolder> store, Selector<X509CertificateHolder> selector) {
        Collection<X509CertificateHolder> matches = store.getMatches(selector);
        return (X509CertificateHolder[]) matches.toArray(new X509CertificateHolder[matches.size()]);
    }

    private String verifyLabel(String str) {
        while (str.endsWith("/") && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        while (str.startsWith("/") && str.length() > 0) {
            str = str.substring(1);
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Label set but after trimming '/' is not zero length string.");
        } else if (!pathInvalid.matcher(str).matches()) {
            throw new IllegalArgumentException("Server path " + str + " contains invalid characters");
        } else if (!illegalParts.contains(str)) {
            return str;
        } else {
            throw new IllegalArgumentException("Label " + str + " is a reserved path segment.");
        }
    }

    private String verifyServer(String str) {
        while (str.endsWith("/") && str.length() > 0) {
            try {
                str = str.substring(0, str.length() - 1);
            } catch (Exception e) {
                if (e instanceof IllegalArgumentException) {
                    throw ((IllegalArgumentException) e);
                }
                throw new IllegalArgumentException("Scheme and host is invalid: " + e.getMessage(), e);
            }
        }
        if (!str.contains("://")) {
            URL url = new URL("https://" + str);
            if (url.getPath().length() != 0) {
                if (!url.getPath().equals("/")) {
                    throw new IllegalArgumentException("Server contains path, must only be <dnsname/ipaddress>:port, a path of '/.well-known/est/<label>' will be added arbitrarily.");
                }
            }
            return str;
        }
        throw new IllegalArgumentException("Server contains scheme, must only be <dnsname/ipaddress>:port, https:// will be added arbitrarily.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0186 A[Catch:{ all -> 0x0193 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0189 A[Catch:{ all -> 0x0193 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0196 A[SYNTHETIC, Splitter:B:59:0x0196] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.est.CACertsResponse getCACerts() {
        /*
            r10 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            r2.<init>()     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            java.lang.String r3 = r10.server     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            r2.append(r3)     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            java.lang.String r3 = "/cacerts"
            r2.append(r3)     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            org.spongycastle.est.ESTClientProvider r2 = r10.clientProvider     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            org.spongycastle.est.ESTClient r2 = r2.makeClient()     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            org.spongycastle.est.ESTRequestBuilder r3 = new org.spongycastle.est.ESTRequestBuilder     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            java.lang.String r4 = "GET"
            r3.<init>(r4, r1)     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            org.spongycastle.est.ESTRequestBuilder r3 = r3.withClient(r2)     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            org.spongycastle.est.ESTRequest r7 = r3.build()     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            org.spongycastle.est.ESTResponse r2 = r2.doRequest(r7)     // Catch:{ Throwable -> 0x017e, all -> 0x017a }
            int r3 = r2.getStatusCode()     // Catch:{ Throwable -> 0x0178 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x010b
            java.lang.String r3 = "application/pkcs7-mime"
            org.spongycastle.est.HttpUtil$Headers r4 = r2.getHeaders()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r4 = r4.getFirstValue(r5)     // Catch:{ Throwable -> 0x0178 }
            boolean r3 = r3.equals(r4)     // Catch:{ Throwable -> 0x0178 }
            if (r3 != 0) goto L_0x00a1
            org.spongycastle.est.HttpUtil$Headers r3 = r2.getHeaders()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r4 = "Content-Type"
            java.lang.String r3 = r3.getFirstValue(r4)     // Catch:{ Throwable -> 0x0178 }
            if (r3 == 0) goto L_0x0074
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0178 }
            r3.<init>()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r4 = " got "
            r3.append(r4)     // Catch:{ Throwable -> 0x0178 }
            org.spongycastle.est.HttpUtil$Headers r4 = r2.getHeaders()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r4 = r4.getFirstValue(r5)     // Catch:{ Throwable -> 0x0178 }
            r3.append(r4)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0178 }
            goto L_0x0076
        L_0x0074:
            java.lang.String r3 = " but was not present."
        L_0x0076:
            org.spongycastle.est.ESTException r4 = new org.spongycastle.est.ESTException     // Catch:{ Throwable -> 0x0178 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0178 }
            r5.<init>()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r6 = "Response : "
            r5.append(r6)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0178 }
            r5.append(r1)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = "Expecting application/pkcs7-mime "
            r5.append(r1)     // Catch:{ Throwable -> 0x0178 }
            r5.append(r3)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r5.toString()     // Catch:{ Throwable -> 0x0178 }
            int r3 = r2.getStatusCode()     // Catch:{ Throwable -> 0x0178 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x0178 }
            r4.<init>(r1, r0, r3, r5)     // Catch:{ Throwable -> 0x0178 }
            throw r4     // Catch:{ Throwable -> 0x0178 }
        L_0x00a1:
            java.lang.Long r3 = r2.getContentLength()     // Catch:{ Throwable -> 0x00db }
            if (r3 == 0) goto L_0x00d6
            java.lang.Long r3 = r2.getContentLength()     // Catch:{ Throwable -> 0x00db }
            long r3 = r3.longValue()     // Catch:{ Throwable -> 0x00db }
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d6
            org.spongycastle.asn1.ASN1InputStream r3 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ Throwable -> 0x00db }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ Throwable -> 0x00db }
            r3.<init>((java.io.InputStream) r4)     // Catch:{ Throwable -> 0x00db }
            org.spongycastle.cmc.SimplePKIResponse r4 = new org.spongycastle.cmc.SimplePKIResponse     // Catch:{ Throwable -> 0x00db }
            org.spongycastle.asn1.ASN1Primitive r3 = r3.readObject()     // Catch:{ Throwable -> 0x00db }
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3     // Catch:{ Throwable -> 0x00db }
            org.spongycastle.asn1.cms.ContentInfo r3 = org.spongycastle.asn1.cms.ContentInfo.getInstance(r3)     // Catch:{ Throwable -> 0x00db }
            r4.<init>((org.spongycastle.asn1.cms.ContentInfo) r3)     // Catch:{ Throwable -> 0x00db }
            org.spongycastle.util.Store r3 = r4.getCertificates()     // Catch:{ Throwable -> 0x00db }
            org.spongycastle.util.Store r4 = r4.getCRLs()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00d8
        L_0x00d6:
            r3 = r0
            r4 = r3
        L_0x00d8:
            r5 = r3
            r6 = r4
            goto L_0x0115
        L_0x00db:
            r0 = move-exception
            org.spongycastle.est.ESTException r3 = new org.spongycastle.est.ESTException     // Catch:{ Throwable -> 0x0178 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0178 }
            r4.<init>()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r5 = "Decoding CACerts: "
            r4.append(r5)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0178 }
            r4.append(r1)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = " "
            r4.append(r1)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r0.getMessage()     // Catch:{ Throwable -> 0x0178 }
            r4.append(r1)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r4.toString()     // Catch:{ Throwable -> 0x0178 }
            int r4 = r2.getStatusCode()     // Catch:{ Throwable -> 0x0178 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x0178 }
            r3.<init>(r1, r0, r4, r5)     // Catch:{ Throwable -> 0x0178 }
            throw r3     // Catch:{ Throwable -> 0x0178 }
        L_0x010b:
            int r3 = r2.getStatusCode()     // Catch:{ Throwable -> 0x0178 }
            r4 = 204(0xcc, float:2.86E-43)
            if (r3 != r4) goto L_0x0155
            r5 = r0
            r6 = r5
        L_0x0115:
            org.spongycastle.est.CACertsResponse r3 = new org.spongycastle.est.CACertsResponse     // Catch:{ Throwable -> 0x0178 }
            org.spongycastle.est.Source r8 = r2.getSource()     // Catch:{ Throwable -> 0x0178 }
            org.spongycastle.est.ESTClientProvider r4 = r10.clientProvider     // Catch:{ Throwable -> 0x0178 }
            boolean r9 = r4.isTrusted()     // Catch:{ Throwable -> 0x0178 }
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0178 }
            if (r2 == 0) goto L_0x012d
            r2.close()     // Catch:{ Exception -> 0x012b }
            goto L_0x012d
        L_0x012b:
            r4 = move-exception
            goto L_0x012e
        L_0x012d:
            r4 = r0
        L_0x012e:
            if (r4 == 0) goto L_0x0154
            boolean r3 = r4 instanceof org.spongycastle.est.ESTException
            if (r3 == 0) goto L_0x0135
            throw r4
        L_0x0135:
            org.spongycastle.est.ESTException r3 = new org.spongycastle.est.ESTException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Get CACerts: "
            r5.append(r6)
            java.lang.String r1 = r1.toString()
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            int r2 = r2.getStatusCode()
            r3.<init>(r1, r4, r2, r0)
            throw r3
        L_0x0154:
            return r3
        L_0x0155:
            org.spongycastle.est.ESTException r3 = new org.spongycastle.est.ESTException     // Catch:{ Throwable -> 0x0178 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0178 }
            r4.<init>()     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r5 = "Get CACerts: "
            r4.append(r5)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0178 }
            r4.append(r1)     // Catch:{ Throwable -> 0x0178 }
            java.lang.String r1 = r4.toString()     // Catch:{ Throwable -> 0x0178 }
            int r4 = r2.getStatusCode()     // Catch:{ Throwable -> 0x0178 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x0178 }
            r3.<init>(r1, r0, r4, r5)     // Catch:{ Throwable -> 0x0178 }
            throw r3     // Catch:{ Throwable -> 0x0178 }
        L_0x0178:
            r0 = move-exception
            goto L_0x0181
        L_0x017a:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0194
        L_0x017e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0181:
            boolean r1 = r0 instanceof org.spongycastle.est.ESTException     // Catch:{ all -> 0x0193 }
            if (r1 == 0) goto L_0x0189
            org.spongycastle.est.ESTException r0 = (org.spongycastle.est.ESTException) r0     // Catch:{ all -> 0x0193 }
            throw r0     // Catch:{ all -> 0x0193 }
        L_0x0189:
            org.spongycastle.est.ESTException r1 = new org.spongycastle.est.ESTException     // Catch:{ all -> 0x0193 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0193 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0193 }
            throw r1     // Catch:{ all -> 0x0193 }
        L_0x0193:
            r0 = move-exception
        L_0x0194:
            if (r2 == 0) goto L_0x0199
            r2.close()     // Catch:{ Exception -> 0x0199 }
        L_0x0199:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.est.ESTService.getCACerts():org.spongycastle.est.CACertsResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2 A[SYNTHETIC, Splitter:B:23:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0108 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010b A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118 A[SYNTHETIC, Splitter:B:54:0x0118] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.est.CSRRequestResponse getCSRAttributes() {
        /*
            r8 = this;
            org.spongycastle.est.ESTClientProvider r0 = r8.clientProvider
            boolean r0 = r0.isTrusted()
            if (r0 == 0) goto L_0x011c
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            r2.<init>()     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            java.lang.String r3 = r8.server     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            r2.append(r3)     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            java.lang.String r3 = "/csrattrs"
            r2.append(r3)     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            org.spongycastle.est.ESTClientProvider r2 = r8.clientProvider     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            org.spongycastle.est.ESTClient r2 = r2.makeClient()     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            org.spongycastle.est.ESTRequestBuilder r3 = new org.spongycastle.est.ESTRequestBuilder     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            java.lang.String r4 = "GET"
            r3.<init>(r4, r1)     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            org.spongycastle.est.ESTRequestBuilder r3 = r3.withClient(r2)     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            org.spongycastle.est.ESTRequest r3 = r3.build()     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            org.spongycastle.est.ESTResponse r2 = r2.doRequest(r3)     // Catch:{ Throwable -> 0x0100, all -> 0x00fc }
            int r4 = r2.getStatusCode()     // Catch:{ Throwable -> 0x00fa }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x0074
            r1 = 204(0xcc, float:2.86E-43)
            if (r4 == r1) goto L_0x0072
            r1 = 404(0x194, float:5.66E-43)
            if (r4 != r1) goto L_0x004b
            goto L_0x0072
        L_0x004b:
            org.spongycastle.est.ESTException r1 = new org.spongycastle.est.ESTException     // Catch:{ Throwable -> 0x00fa }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fa }
            r4.<init>()     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r5 = "CSR Attribute request: "
            r4.append(r5)     // Catch:{ Throwable -> 0x00fa }
            java.net.URL r3 = r3.getURL()     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x00fa }
            r4.append(r3)     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x00fa }
            int r4 = r2.getStatusCode()     // Catch:{ Throwable -> 0x00fa }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x00fa }
            r1.<init>(r3, r0, r4, r5)     // Catch:{ Throwable -> 0x00fa }
            throw r1     // Catch:{ Throwable -> 0x00fa }
        L_0x0072:
            r4 = r0
            goto L_0x00a0
        L_0x0074:
            java.lang.Long r3 = r2.getContentLength()     // Catch:{ Throwable -> 0x00ca }
            if (r3 == 0) goto L_0x0072
            java.lang.Long r3 = r2.getContentLength()     // Catch:{ Throwable -> 0x00ca }
            long r3 = r3.longValue()     // Catch:{ Throwable -> 0x00ca }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0072
            org.spongycastle.asn1.ASN1InputStream r3 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ Throwable -> 0x00ca }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ Throwable -> 0x00ca }
            r3.<init>((java.io.InputStream) r4)     // Catch:{ Throwable -> 0x00ca }
            org.spongycastle.asn1.ASN1Primitive r3 = r3.readObject()     // Catch:{ Throwable -> 0x00ca }
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3     // Catch:{ Throwable -> 0x00ca }
            org.spongycastle.est.CSRAttributesResponse r4 = new org.spongycastle.est.CSRAttributesResponse     // Catch:{ Throwable -> 0x00ca }
            org.spongycastle.asn1.est.CsrAttrs r3 = org.spongycastle.asn1.est.CsrAttrs.getInstance(r3)     // Catch:{ Throwable -> 0x00ca }
            r4.<init>((org.spongycastle.asn1.est.CsrAttrs) r3)     // Catch:{ Throwable -> 0x00ca }
        L_0x00a0:
            if (r2 == 0) goto L_0x00a8
            r2.close()     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00a8
        L_0x00a6:
            r1 = move-exception
            goto L_0x00a9
        L_0x00a8:
            r1 = r0
        L_0x00a9:
            if (r1 == 0) goto L_0x00c0
            boolean r3 = r1 instanceof org.spongycastle.est.ESTException
            if (r3 == 0) goto L_0x00b2
            org.spongycastle.est.ESTException r1 = (org.spongycastle.est.ESTException) r1
            throw r1
        L_0x00b2:
            org.spongycastle.est.ESTException r3 = new org.spongycastle.est.ESTException
            java.lang.String r4 = r1.getMessage()
            int r2 = r2.getStatusCode()
            r3.<init>(r4, r1, r2, r0)
            throw r3
        L_0x00c0:
            org.spongycastle.est.CSRRequestResponse r0 = new org.spongycastle.est.CSRRequestResponse
            org.spongycastle.est.Source r1 = r2.getSource()
            r0.<init>(r4, r1)
            return r0
        L_0x00ca:
            r0 = move-exception
            org.spongycastle.est.ESTException r3 = new org.spongycastle.est.ESTException     // Catch:{ Throwable -> 0x00fa }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fa }
            r4.<init>()     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r5 = "Decoding CACerts: "
            r4.append(r5)     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x00fa }
            r4.append(r1)     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r1 = " "
            r4.append(r1)     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r1 = r0.getMessage()     // Catch:{ Throwable -> 0x00fa }
            r4.append(r1)     // Catch:{ Throwable -> 0x00fa }
            java.lang.String r1 = r4.toString()     // Catch:{ Throwable -> 0x00fa }
            int r4 = r2.getStatusCode()     // Catch:{ Throwable -> 0x00fa }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x00fa }
            r3.<init>(r1, r0, r4, r5)     // Catch:{ Throwable -> 0x00fa }
            throw r3     // Catch:{ Throwable -> 0x00fa }
        L_0x00fa:
            r0 = move-exception
            goto L_0x0103
        L_0x00fc:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0116
        L_0x0100:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0103:
            boolean r1 = r0 instanceof org.spongycastle.est.ESTException     // Catch:{ all -> 0x0115 }
            if (r1 == 0) goto L_0x010b
            org.spongycastle.est.ESTException r0 = (org.spongycastle.est.ESTException) r0     // Catch:{ all -> 0x0115 }
            throw r0     // Catch:{ all -> 0x0115 }
        L_0x010b:
            org.spongycastle.est.ESTException r1 = new org.spongycastle.est.ESTException     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0115 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0115 }
            throw r1     // Catch:{ all -> 0x0115 }
        L_0x0115:
            r0 = move-exception
        L_0x0116:
            if (r2 == 0) goto L_0x011b
            r2.close()     // Catch:{ Exception -> 0x011b }
        L_0x011b:
            throw r0
        L_0x011c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No trust anchors."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.est.ESTService.getCSRAttributes():org.spongycastle.est.CSRRequestResponse");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007d, code lost:
        throw new org.spongycastle.est.ESTException("Unable to parse Retry-After header:" + r4.getURL().toString() + " " + r0.getMessage(), (java.lang.Throwable) null, r9.getStatusCode(), r9.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r2 = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", java.util.Locale.US);
        r2.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        r2 = r2.parse(r0).getTime();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.est.EnrollmentResponse handleEnrollResponse(org.spongycastle.est.ESTResponse r9) {
        /*
            r8 = this;
            org.spongycastle.est.ESTRequest r4 = r9.getOriginalRequest()
            int r0 = r9.getStatusCode()
            r1 = 0
            r2 = 202(0xca, float:2.83E-43)
            if (r0 != r2) goto L_0x009d
            java.lang.String r0 = "Retry-After"
            java.lang.String r0 = r9.getHeader(r0)
            if (r0 == 0) goto L_0x007e
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x0023 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0023 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r5
            long r2 = r2 + r0
            goto L_0x003e
        L_0x0023:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = "EEE, dd MMM yyyy HH:mm:ss z"
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ Exception -> 0x004a }
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = "GMT"
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r3)     // Catch:{ Exception -> 0x004a }
            r2.setTimeZone(r3)     // Catch:{ Exception -> 0x004a }
            java.util.Date r0 = r2.parse(r0)     // Catch:{ Exception -> 0x004a }
            long r0 = r0.getTime()     // Catch:{ Exception -> 0x004a }
            r2 = r0
        L_0x003e:
            org.spongycastle.est.EnrollmentResponse r6 = new org.spongycastle.est.EnrollmentResponse
            r1 = 0
            org.spongycastle.est.Source r5 = r9.getSource()
            r0 = r6
            r0.<init>(r1, r2, r4, r5)
            return r6
        L_0x004a:
            r0 = move-exception
            org.spongycastle.est.ESTException r2 = new org.spongycastle.est.ESTException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unable to parse Retry-After header:"
            r3.append(r5)
            java.net.URL r4 = r4.getURL()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r4 = " "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            int r3 = r9.getStatusCode()
            java.io.InputStream r9 = r9.getInputStream()
            r2.<init>(r0, r1, r3, r9)
            throw r2
        L_0x007e:
            org.spongycastle.est.ESTException r9 = new org.spongycastle.est.ESTException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Got Status 202 but not Retry-After header from: "
            r0.append(r1)
            java.net.URL r1 = r4.getURL()
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x009d:
            int r0 = r9.getStatusCode()
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x00dc
            org.spongycastle.asn1.ASN1InputStream r0 = new org.spongycastle.asn1.ASN1InputStream
            java.io.InputStream r1 = r9.getInputStream()
            r0.<init>((java.io.InputStream) r1)
            org.spongycastle.cmc.SimplePKIResponse r1 = new org.spongycastle.cmc.SimplePKIResponse     // Catch:{ CMCException -> 0x00cd }
            org.spongycastle.asn1.ASN1Primitive r0 = r0.readObject()     // Catch:{ CMCException -> 0x00cd }
            org.spongycastle.asn1.cms.ContentInfo r0 = org.spongycastle.asn1.cms.ContentInfo.getInstance(r0)     // Catch:{ CMCException -> 0x00cd }
            r1.<init>((org.spongycastle.asn1.cms.ContentInfo) r0)     // Catch:{ CMCException -> 0x00cd }
            org.spongycastle.util.Store r3 = r1.getCertificates()
            org.spongycastle.est.EnrollmentResponse r0 = new org.spongycastle.est.EnrollmentResponse
            r4 = -1
            r6 = 0
            org.spongycastle.est.Source r7 = r9.getSource()
            r2 = r0
            r2.<init>(r3, r4, r6, r7)
            return r0
        L_0x00cd:
            r9 = move-exception
            org.spongycastle.est.ESTException r0 = new org.spongycastle.est.ESTException
            java.lang.String r1 = r9.getMessage()
            java.lang.Throwable r9 = r9.getCause()
            r0.<init>(r1, r9)
            throw r0
        L_0x00dc:
            org.spongycastle.est.ESTException r0 = new org.spongycastle.est.ESTException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Simple Enroll: "
            r2.append(r3)
            java.net.URL r3 = r4.getURL()
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r9.getStatusCode()
            java.io.InputStream r9 = r9.getInputStream()
            r0.<init>(r2, r1, r3, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.est.ESTService.handleEnrollResponse(org.spongycastle.est.ESTResponse):org.spongycastle.est.EnrollmentResponse");
    }

    public EnrollmentResponse simpleEnroll(EnrollmentResponse enrollmentResponse) {
        if (this.clientProvider.isTrusted()) {
            ESTResponse eSTResponse = null;
            try {
                ESTClient makeClient = this.clientProvider.makeClient();
                ESTResponse doRequest = makeClient.doRequest(new ESTRequestBuilder(enrollmentResponse.getRequestToRetry()).withClient(makeClient).build());
                EnrollmentResponse handleEnrollResponse = handleEnrollResponse(doRequest);
                if (doRequest != null) {
                    doRequest.close();
                }
                return handleEnrollResponse;
            } catch (Throwable th) {
                if (eSTResponse != null) {
                    eSTResponse.close();
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("No trust anchors.");
        }
    }

    public EnrollmentResponse simpleEnroll(boolean z, PKCS10CertificationRequest pKCS10CertificationRequest, ESTAuth eSTAuth) {
        if (this.clientProvider.isTrusted()) {
            ESTResponse eSTResponse = null;
            try {
                byte[] bytes = annotateRequest(pKCS10CertificationRequest.getEncoded()).getBytes();
                StringBuilder sb = new StringBuilder();
                sb.append(this.server);
                sb.append(z ? SIMPLE_REENROLL : SIMPLE_ENROLL);
                URL url = new URL(sb.toString());
                ESTClient makeClient = this.clientProvider.makeClient();
                ESTRequestBuilder withClient = new ESTRequestBuilder("POST", url).withData(bytes).withClient(makeClient);
                withClient.addHeader("Content-Type", "application/pkcs10");
                withClient.addHeader("Content-Length", "" + bytes.length);
                withClient.addHeader("Content-Transfer-Encoding", "base64");
                if (eSTAuth != null) {
                    eSTAuth.applyAuth(withClient);
                }
                ESTResponse doRequest = makeClient.doRequest(withClient.build());
                EnrollmentResponse handleEnrollResponse = handleEnrollResponse(doRequest);
                if (doRequest != null) {
                    doRequest.close();
                }
                return handleEnrollResponse;
            } catch (Throwable th) {
                if (eSTResponse != null) {
                    eSTResponse.close();
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("No trust anchors.");
        }
    }

    public EnrollmentResponse simpleEnrollPoP(boolean z, final PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder, final ContentSigner contentSigner, ESTAuth eSTAuth) {
        if (this.clientProvider.isTrusted()) {
            ESTResponse eSTResponse = null;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.server);
                sb.append(z ? SIMPLE_REENROLL : SIMPLE_ENROLL);
                URL url = new URL(sb.toString());
                ESTClient makeClient = this.clientProvider.makeClient();
                ESTRequestBuilder withConnectionListener = new ESTRequestBuilder("POST", url).withClient(makeClient).withConnectionListener(new ESTSourceConnectionListener() {
                    public ESTRequest onConnection(Source source, ESTRequest eSTRequest) {
                        if (source instanceof TLSUniqueProvider) {
                            TLSUniqueProvider tLSUniqueProvider = (TLSUniqueProvider) source;
                            if (tLSUniqueProvider.isTLSUniqueAvailable()) {
                                PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder = new PKCS10CertificationRequestBuilder(pKCS10CertificationRequestBuilder);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                pKCS10CertificationRequestBuilder.setAttribute(PKCSObjectIdentifiers.pkcs_9_at_challengePassword, (ASN1Encodable) new DERPrintableString(Base64.toBase64String(tLSUniqueProvider.getTLSUnique())));
                                byteArrayOutputStream.write(ESTService.this.annotateRequest(pKCS10CertificationRequestBuilder.build(contentSigner).getEncoded()).getBytes());
                                byteArrayOutputStream.flush();
                                ESTRequestBuilder withData = new ESTRequestBuilder(eSTRequest).withData(byteArrayOutputStream.toByteArray());
                                withData.setHeader("Content-Type", "application/pkcs10");
                                withData.setHeader("Content-Transfer-Encoding", "base64");
                                withData.setHeader("Content-Length", Long.toString((long) byteArrayOutputStream.size()));
                                return withData.build();
                            }
                        }
                        throw new IOException("Source does not supply TLS unique.");
                    }
                });
                if (eSTAuth != null) {
                    eSTAuth.applyAuth(withConnectionListener);
                }
                ESTResponse doRequest = makeClient.doRequest(withConnectionListener.build());
                EnrollmentResponse handleEnrollResponse = handleEnrollResponse(doRequest);
                if (doRequest != null) {
                    doRequest.close();
                }
                return handleEnrollResponse;
            } catch (Throwable th) {
                if (eSTResponse != null) {
                    eSTResponse.close();
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("No trust anchors.");
        }
    }
}
