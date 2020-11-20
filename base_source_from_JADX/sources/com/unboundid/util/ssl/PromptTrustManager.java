package com.unboundid.util.ssl;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.X509TrustManager;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class PromptTrustManager implements X509TrustManager {
    private static final MessageDigest MD5 = MessageDigest.getInstance("MD5");
    private static final MessageDigest SHA1 = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1);
    private final ConcurrentHashMap<String, Boolean> acceptedCerts;
    private final String acceptedCertsFile;
    private final boolean examineValidityDates;

    /* renamed from: in */
    private final InputStream f7275in;
    private final PrintStream out;

    static {
        try {
            try {
            } catch (Exception e) {
                Debug.debugException(e);
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new RuntimeException(e2);
        }
    }

    public PromptTrustManager() {
        this((String) null, true, (InputStream) null, (PrintStream) null);
    }

    public PromptTrustManager(String str) {
        this(str, true, (InputStream) null, (PrintStream) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068 A[SYNTHETIC, Splitter:B:34:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006e A[SYNTHETIC, Splitter:B:37:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PromptTrustManager(java.lang.String r2, boolean r3, java.io.InputStream r4, java.io.PrintStream r5) {
        /*
            r1 = this;
            r1.<init>()
            r1.acceptedCertsFile = r2
            r1.examineValidityDates = r3
            if (r4 != 0) goto L_0x000e
            java.io.InputStream r3 = java.lang.System.in
            r1.f7275in = r3
            goto L_0x0010
        L_0x000e:
            r1.f7275in = r4
        L_0x0010:
            if (r5 != 0) goto L_0x0017
            java.io.PrintStream r3 = java.lang.System.out
            r1.out = r3
            goto L_0x0019
        L_0x0017:
            r1.out = r5
        L_0x0019:
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap
            r3.<init>()
            r1.acceptedCerts = r3
            if (r2 == 0) goto L_0x0077
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0062 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0062 }
            boolean r2 = r4.exists()     // Catch:{ Exception -> 0x0062 }
            if (r2 == 0) goto L_0x0054
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0062 }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x0062 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0062 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0062 }
        L_0x0038:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x004f, all -> 0x004a }
            if (r3 != 0) goto L_0x003f
            goto L_0x0055
        L_0x003f:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r4 = r1.acceptedCerts     // Catch:{ Exception -> 0x004f, all -> 0x004a }
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x004f, all -> 0x004a }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x004f, all -> 0x004a }
            goto L_0x0038
        L_0x004a:
            r3 = move-exception
            r0 = r3
            r3 = r2
            r2 = r0
            goto L_0x006c
        L_0x004f:
            r3 = move-exception
            r0 = r3
            r3 = r2
            r2 = r0
            goto L_0x0063
        L_0x0054:
            r2 = r3
        L_0x0055:
            if (r2 == 0) goto L_0x0077
            r2.close()     // Catch:{ Exception -> 0x005b }
            goto L_0x0077
        L_0x005b:
            r2 = move-exception
            com.unboundid.util.Debug.debugException(r2)
            goto L_0x0077
        L_0x0060:
            r2 = move-exception
            goto L_0x006c
        L_0x0062:
            r2 = move-exception
        L_0x0063:
            com.unboundid.util.Debug.debugException(r2)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ Exception -> 0x005b }
            goto L_0x0077
        L_0x006c:
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r3 = move-exception
            com.unboundid.util.Debug.debugException(r3)
        L_0x0076:
            throw r2
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.ssl.PromptTrustManager.<init>(java.lang.String, boolean, java.io.InputStream, java.io.PrintStream):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r12 = com.unboundid.util.StaticUtils.toLowerCase(com.unboundid.util.StaticUtils.toHex(r3.getSignature()));
        r13 = r11.acceptedCerts;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0210, code lost:
        if (r0 == null) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0212, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0213, code lost:
        r13.put(r12, java.lang.Boolean.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x021c, code lost:
        if (r11.acceptedCertsFile == null) goto L_0x0226;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        writeCacheFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0222, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        com.unboundid.util.Debug.debugException(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0228, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        com.unboundid.util.Debug.debugException(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x022d, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x022e, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void checkCertificateChain(java.security.cert.X509Certificate[] r12, boolean r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x022f }
            r1.<init>()     // Catch:{ all -> 0x022f }
            r2 = 0
            r3 = r12[r2]     // Catch:{ all -> 0x022f }
            boolean r4 = r11.examineValidityDates     // Catch:{ all -> 0x022f }
            if (r4 == 0) goto L_0x002c
            java.util.Date r4 = r3.getNotBefore()     // Catch:{ all -> 0x022f }
            boolean r4 = r1.before(r4)     // Catch:{ all -> 0x022f }
            if (r4 == 0) goto L_0x001f
            com.unboundid.util.ssl.SSLMessages r0 = com.unboundid.util.ssl.SSLMessages.WARN_PROMPT_NOT_YET_VALID     // Catch:{ all -> 0x022f }
        L_0x001a:
            java.lang.String r0 = r0.get()     // Catch:{ all -> 0x022f }
            goto L_0x002c
        L_0x001f:
            java.util.Date r4 = r3.getNotAfter()     // Catch:{ all -> 0x022f }
            boolean r1 = r1.after(r4)     // Catch:{ all -> 0x022f }
            if (r1 == 0) goto L_0x002c
            com.unboundid.util.ssl.SSLMessages r0 = com.unboundid.util.ssl.SSLMessages.WARN_PROMPT_EXPIRED     // Catch:{ all -> 0x022f }
            goto L_0x001a
        L_0x002c:
            boolean r1 = r11.examineValidityDates     // Catch:{ all -> 0x022f }
            if (r1 == 0) goto L_0x0032
            if (r0 != 0) goto L_0x0058
        L_0x0032:
            byte[] r1 = r3.getSignature()     // Catch:{ all -> 0x022f }
            java.lang.String r1 = com.unboundid.util.StaticUtils.toHex((byte[]) r1)     // Catch:{ all -> 0x022f }
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)     // Catch:{ all -> 0x022f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r4 = r11.acceptedCerts     // Catch:{ all -> 0x022f }
            java.lang.Object r1 = r4.get(r1)     // Catch:{ all -> 0x022f }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x022f }
            if (r1 == 0) goto L_0x0058
            if (r0 == 0) goto L_0x0056
            boolean r4 = r11.examineValidityDates     // Catch:{ all -> 0x022f }
            if (r4 == 0) goto L_0x0056
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x022f }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x022f }
            if (r1 == 0) goto L_0x0058
        L_0x0056:
            monitor-exit(r11)
            return
        L_0x0058:
            if (r13 == 0) goto L_0x0066
            java.io.PrintStream r13 = r11.out     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_SERVER_HEADING     // Catch:{ all -> 0x022f }
            java.lang.String r1 = r1.get()     // Catch:{ all -> 0x022f }
        L_0x0062:
            r13.println(r1)     // Catch:{ all -> 0x022f }
            goto L_0x006f
        L_0x0066:
            java.io.PrintStream r13 = r11.out     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_CLIENT_HEADING     // Catch:{ all -> 0x022f }
            java.lang.String r1 = r1.get()     // Catch:{ all -> 0x022f }
            goto L_0x0062
        L_0x006f:
            java.io.PrintStream r13 = r11.out     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r1.<init>()     // Catch:{ all -> 0x022f }
            r4 = 9
            r1.append(r4)     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r5 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_SUBJECT     // Catch:{ all -> 0x022f }
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x022f }
            javax.security.auth.x500.X500Principal r8 = r3.getSubjectX500Principal()     // Catch:{ all -> 0x022f }
            java.lang.String r9 = "CANONICAL"
            java.lang.String r8 = r8.getName(r9)     // Catch:{ all -> 0x022f }
            r7[r2] = r8     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r5.get(r7)     // Catch:{ all -> 0x022f }
            r1.append(r5)     // Catch:{ all -> 0x022f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x022f }
            r13.println(r1)     // Catch:{ all -> 0x022f }
            java.io.PrintStream r13 = r11.out     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r1.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r5 = "\t\t"
            r1.append(r5)     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r5 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_MD5_FINGERPRINT     // Catch:{ all -> 0x022f }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x022f }
            java.security.MessageDigest r8 = MD5     // Catch:{ all -> 0x022f }
            java.lang.String r8 = getFingerprint(r3, r8)     // Catch:{ all -> 0x022f }
            r7[r2] = r8     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r5.get(r7)     // Catch:{ all -> 0x022f }
            r1.append(r5)     // Catch:{ all -> 0x022f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x022f }
            r13.println(r1)     // Catch:{ all -> 0x022f }
            java.io.PrintStream r13 = r11.out     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r1.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r5 = "\t\t"
            r1.append(r5)     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r5 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_SHA1_FINGERPRINT     // Catch:{ all -> 0x022f }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x022f }
            java.security.MessageDigest r8 = SHA1     // Catch:{ all -> 0x022f }
            java.lang.String r8 = getFingerprint(r3, r8)     // Catch:{ all -> 0x022f }
            r7[r2] = r8     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r5.get(r7)     // Catch:{ all -> 0x022f }
            r1.append(r5)     // Catch:{ all -> 0x022f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x022f }
            r13.println(r1)     // Catch:{ all -> 0x022f }
            r13 = 1
        L_0x00e7:
            int r1 = r12.length     // Catch:{ all -> 0x022f }
            r5 = 2
            if (r13 >= r1) goto L_0x016f
            java.io.PrintStream r1 = r11.out     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r7.<init>()     // Catch:{ all -> 0x022f }
            r7.append(r4)     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r8 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_ISSUER_SUBJECT     // Catch:{ all -> 0x022f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x022f }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x022f }
            r5[r2] = r9     // Catch:{ all -> 0x022f }
            r9 = r12[r13]     // Catch:{ all -> 0x022f }
            javax.security.auth.x500.X500Principal r9 = r9.getSubjectX500Principal()     // Catch:{ all -> 0x022f }
            java.lang.String r10 = "CANONICAL"
            java.lang.String r9 = r9.getName(r10)     // Catch:{ all -> 0x022f }
            r5[r6] = r9     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r8.get(r5)     // Catch:{ all -> 0x022f }
            r7.append(r5)     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x022f }
            r1.println(r5)     // Catch:{ all -> 0x022f }
            java.io.PrintStream r1 = r11.out     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r5.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r7 = "\t\t"
            r5.append(r7)     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r7 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_MD5_FINGERPRINT     // Catch:{ all -> 0x022f }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x022f }
            r9 = r12[r13]     // Catch:{ all -> 0x022f }
            java.security.MessageDigest r10 = MD5     // Catch:{ all -> 0x022f }
            java.lang.String r9 = getFingerprint(r9, r10)     // Catch:{ all -> 0x022f }
            r8[r2] = r9     // Catch:{ all -> 0x022f }
            java.lang.String r7 = r7.get(r8)     // Catch:{ all -> 0x022f }
            r5.append(r7)     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x022f }
            r1.println(r5)     // Catch:{ all -> 0x022f }
            java.io.PrintStream r1 = r11.out     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r5.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r7 = "\t\t"
            r5.append(r7)     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r7 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_SHA1_FINGERPRINT     // Catch:{ all -> 0x022f }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x022f }
            r9 = r12[r13]     // Catch:{ all -> 0x022f }
            java.security.MessageDigest r10 = SHA1     // Catch:{ all -> 0x022f }
            java.lang.String r9 = getFingerprint(r9, r10)     // Catch:{ all -> 0x022f }
            r8[r2] = r9     // Catch:{ all -> 0x022f }
            java.lang.String r7 = r7.get(r8)     // Catch:{ all -> 0x022f }
            r5.append(r7)     // Catch:{ all -> 0x022f }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x022f }
            r1.println(r5)     // Catch:{ all -> 0x022f }
            int r13 = r13 + 1
            goto L_0x00e7
        L_0x016f:
            java.io.PrintStream r13 = r11.out     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_VALIDITY     // Catch:{ all -> 0x022f }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ all -> 0x022f }
            java.util.Date r5 = r3.getNotBefore()     // Catch:{ all -> 0x022f }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x022f }
            r4[r2] = r5     // Catch:{ all -> 0x022f }
            java.util.Date r5 = r3.getNotAfter()     // Catch:{ all -> 0x022f }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x022f }
            r4[r6] = r5     // Catch:{ all -> 0x022f }
            java.lang.String r1 = r1.get(r4)     // Catch:{ all -> 0x022f }
            r13.println(r1)     // Catch:{ all -> 0x022f }
            int r12 = r12.length     // Catch:{ all -> 0x022f }
            if (r12 != r6) goto L_0x01a3
            java.io.PrintStream r12 = r11.out     // Catch:{ all -> 0x022f }
            r12.println()     // Catch:{ all -> 0x022f }
            java.io.PrintStream r12 = r11.out     // Catch:{ all -> 0x022f }
            com.unboundid.util.ssl.SSLMessages r13 = com.unboundid.util.ssl.SSLMessages.WARN_PROMPT_SELF_SIGNED     // Catch:{ all -> 0x022f }
            java.lang.String r13 = r13.get()     // Catch:{ all -> 0x022f }
            r12.println(r13)     // Catch:{ all -> 0x022f }
        L_0x01a3:
            if (r0 == 0) goto L_0x01af
            java.io.PrintStream r12 = r11.out     // Catch:{ all -> 0x022f }
            r12.println()     // Catch:{ all -> 0x022f }
            java.io.PrintStream r12 = r11.out     // Catch:{ all -> 0x022f }
            r12.println(r0)     // Catch:{ all -> 0x022f }
        L_0x01af:
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ all -> 0x022f }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ all -> 0x022f }
            java.io.InputStream r1 = r11.f7275in     // Catch:{ all -> 0x022f }
            r13.<init>(r1)     // Catch:{ all -> 0x022f }
            r12.<init>(r13)     // Catch:{ all -> 0x022f }
        L_0x01bb:
            java.io.PrintStream r13 = r11.out     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            r13.println()     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            java.io.PrintStream r13 = r11.out     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.INFO_PROMPT_MESSAGE     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            java.lang.String r1 = r1.get()     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            r13.println(r1)     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            java.io.PrintStream r13 = r11.out     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            r13.flush()     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            java.lang.String r13 = r12.readLine()     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            java.lang.String r1 = "y"
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            if (r1 != 0) goto L_0x0202
            java.lang.String r1 = "yes"
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            if (r1 == 0) goto L_0x01e5
            goto L_0x0202
        L_0x01e5:
            java.lang.String r1 = "n"
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            if (r1 != 0) goto L_0x01f6
            java.lang.String r1 = "no"
            boolean r13 = r13.equalsIgnoreCase(r1)     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            if (r13 != 0) goto L_0x01f6
            goto L_0x01bb
        L_0x01f6:
            java.security.cert.CertificateException r13 = new java.security.cert.CertificateException     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.ERR_CERTIFICATE_REJECTED_BY_USER     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            java.lang.String r1 = r1.get()     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            r13.<init>(r1)     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
            throw r13     // Catch:{ CertificateException -> 0x022d, Exception -> 0x0228 }
        L_0x0202:
            byte[] r12 = r3.getSignature()     // Catch:{ all -> 0x022f }
            java.lang.String r12 = com.unboundid.util.StaticUtils.toHex((byte[]) r12)     // Catch:{ all -> 0x022f }
            java.lang.String r12 = com.unboundid.util.StaticUtils.toLowerCase(r12)     // Catch:{ all -> 0x022f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r13 = r11.acceptedCerts     // Catch:{ all -> 0x022f }
            if (r0 == 0) goto L_0x0213
            r2 = 1
        L_0x0213:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x022f }
            r13.put(r12, r0)     // Catch:{ all -> 0x022f }
            java.lang.String r12 = r11.acceptedCertsFile     // Catch:{ all -> 0x022f }
            if (r12 == 0) goto L_0x0226
            r11.writeCacheFile()     // Catch:{ Exception -> 0x0222 }
            goto L_0x0226
        L_0x0222:
            r12 = move-exception
            com.unboundid.util.Debug.debugException(r12)     // Catch:{ all -> 0x022f }
        L_0x0226:
            monitor-exit(r11)
            return
        L_0x0228:
            r13 = move-exception
            com.unboundid.util.Debug.debugException(r13)     // Catch:{ all -> 0x022f }
            goto L_0x01bb
        L_0x022d:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x022f }
        L_0x022f:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.ssl.PromptTrustManager.checkCertificateChain(java.security.cert.X509Certificate[], boolean):void");
    }

    private static String getFingerprint(X509Certificate x509Certificate, MessageDigest messageDigest) {
        byte[] digest;
        byte[] encoded = x509Certificate.getEncoded();
        synchronized (messageDigest) {
            digest = messageDigest.digest(encoded);
        }
        StringBuilder sb = new StringBuilder(encoded.length * 3);
        StaticUtils.toHex(digest, ":", sb);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeCacheFile() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.acceptedCertsFile
            r1.append(r2)
            java.lang.String r2 = ".new"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 0
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ all -> 0x007a }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ all -> 0x007a }
            r3.<init>(r0)     // Catch:{ all -> 0x007a }
            r2.<init>(r3)     // Catch:{ all -> 0x007a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r1 = r5.acceptedCerts     // Catch:{ all -> 0x0078 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0078 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0078 }
        L_0x002d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0040
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0078 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0078 }
            r2.write(r3)     // Catch:{ all -> 0x0078 }
            r2.newLine()     // Catch:{ all -> 0x0078 }
            goto L_0x002d
        L_0x0040:
            r2.close()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r5.acceptedCertsFile
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x0074
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r5.acceptedCertsFile
            r3.append(r4)
            java.lang.String r4 = ".previous"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            boolean r3 = r2.exists()
            if (r3 == 0) goto L_0x0071
            r2.delete()
        L_0x0071:
            r1.renameTo(r2)
        L_0x0074:
            r0.renameTo(r1)
            return
        L_0x0078:
            r0 = move-exception
            goto L_0x007c
        L_0x007a:
            r0 = move-exception
            r2 = r1
        L_0x007c:
            if (r2 == 0) goto L_0x0081
            r2.close()
        L_0x0081:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.ssl.PromptTrustManager.writeCacheFile():void");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        checkCertificateChain(x509CertificateArr, false);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        checkCertificateChain(x509CertificateArr, true);
    }

    public boolean examineValidityDates() {
        return this.examineValidityDates;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
