package com.cyberneid.disigon;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;
import com.cyberneid.disigoncie.R;
import java.io.File;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x500.style.IETFUtils;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;

/* renamed from: com.cyberneid.disigon.f */
public class C2125f {

    /* renamed from: a */
    private static String f6587a = "EIMZAHELPER";

    /* renamed from: a */
    public static File m8360a(String str) {
        return new File(m8365b(), str);
    }

    /* renamed from: a */
    public static String m8361a(Context context, int i) {
        int i2;
        Resources resources;
        switch (i) {
            case 0:
                resources = context.getResources();
                i2 = R.string.pin_locked;
                break;
            case 1:
                resources = context.getResources();
                i2 = R.string.last_Attempt;
                break;
            default:
                return context.getResources().getString(R.string.attempts_remaining) + i;
        }
        return resources.getString(i2);
    }

    /* renamed from: a */
    public static String m8362a(X509Certificate x509Certificate) {
        return x509Certificate != null ? m8363a().format(x509Certificate.getNotBefore()) : "";
    }

    /* renamed from: a */
    public static SimpleDateFormat m8363a() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m8364a(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x008f
            if (r4 != 0) goto L_0x0007
            goto L_0x008f
        L_0x0007:
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r1 = "application/pdf"
            boolean r1 = r1.equals(r5)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            if (r1 != 0) goto L_0x0068
            if (r4 == 0) goto L_0x002a
            java.lang.String r1 = r4.toString()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r2 = "pdf"
            boolean r1 = r1.endsWith(r2)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            if (r1 == 0) goto L_0x002a
            goto L_0x0068
        L_0x002a:
            java.lang.String r1 = "application/pkcs7-mime"
            boolean r1 = r1.equals(r5)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            if (r1 != 0) goto L_0x005f
            java.lang.String r1 = "application/x-pkcs7-mime"
            boolean r5 = r1.equals(r5)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            if (r5 != 0) goto L_0x005f
            if (r4 == 0) goto L_0x005d
            java.lang.String r5 = r4.toString()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r1 = "p7m"
            boolean r5 = r5.endsWith(r1)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            if (r5 != 0) goto L_0x005f
            java.lang.String r4 = r4.toString()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            java.lang.String r5 = "p7s"
            boolean r4 = r4.endsWith(r5)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            if (r4 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r3 = 0
            goto L_0x007d
        L_0x005f:
            com.cyberneid.a.a r3 = com.cyberneid.p087a.C1451a.m5466a((java.io.InputStream) r3)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            int r3 = r3.mo6910a()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            goto L_0x007d
        L_0x0068:
            int r4 = r3.available()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            byte[] r4 = new byte[r4]     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            r3.read(r4)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            com.cyberneid.a.l r3 = new com.cyberneid.a.l     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            r3.<init>()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            r3.mo6940a((byte[]) r4)     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
            int r3 = r3.mo6939a()     // Catch:{ g -> 0x008b, FileNotFoundException -> 0x0086, Exception -> 0x0081 }
        L_0x007d:
            if (r3 <= 0) goto L_0x0080
            r0 = 1
        L_0x0080:
            return r0
        L_0x0081:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x008f
        L_0x0086:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x008f
        L_0x008b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.C2125f.m8364a(android.content.Context, android.net.Uri, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static File m8365b() {
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        StringBuilder sb2;
        String str4;
        File c = MainApplication.m8077c();
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (!c.exists()) {
                String str5 = f6587a;
                Log.e(str5, "Directory not exists: " + c);
                if (!c.mkdirs()) {
                    str2 = f6587a;
                    sb = new StringBuilder();
                    str = "Directory not created: ";
                } else {
                    str4 = f6587a;
                    sb2 = new StringBuilder();
                    str3 = "Directory created: ";
                }
            } else {
                str4 = f6587a;
                sb2 = new StringBuilder();
                str3 = "Directory already exists: ";
            }
            sb2.append(str3);
            sb2.append(c);
            Log.e(str4, sb2.toString());
            return c;
        }
        str2 = f6587a;
        sb = new StringBuilder();
        str = "NOT MOUNTED";
        sb.append(str);
        sb.append(c);
        Log.e(str2, sb.toString());
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r10 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r10 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        r1 = r11.getPath();
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m8366b(android.content.Context r10, android.net.Uri r11, java.lang.String r12) {
        /*
            r0 = -1
            r1 = 0
            if (r11 == 0) goto L_0x0062
            java.lang.String r2 = r11.getScheme()
            java.lang.String r3 = "content"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005e
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ SecurityException -> 0x0042, all -> 0x003f }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r11
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ SecurityException -> 0x0042, all -> 0x003f }
            if (r10 == 0) goto L_0x0039
            boolean r2 = r10.moveToFirst()     // Catch:{ SecurityException -> 0x0037 }
            if (r2 == 0) goto L_0x0039
            java.lang.String r1 = "_display_name"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ SecurityException -> 0x0037 }
            if (r1 <= r0) goto L_0x0032
            java.lang.String r1 = r10.getString(r1)     // Catch:{ SecurityException -> 0x0037 }
            goto L_0x0039
        L_0x0032:
            java.lang.String r1 = r11.getLastPathSegment()     // Catch:{ SecurityException -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            r1 = move-exception
            goto L_0x0046
        L_0x0039:
            if (r10 == 0) goto L_0x0062
        L_0x003b:
            r10.close()
            goto L_0x0062
        L_0x003f:
            r11 = move-exception
            r10 = r1
            goto L_0x0058
        L_0x0042:
            r10 = move-exception
            r9 = r1
            r1 = r10
            r10 = r9
        L_0x0046:
            r1.printStackTrace()     // Catch:{ all -> 0x0057 }
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()     // Catch:{ all -> 0x0057 }
            r2.recordException(r1)     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = r11.getLastPathSegment()     // Catch:{ all -> 0x0057 }
            if (r10 == 0) goto L_0x0062
            goto L_0x003b
        L_0x0057:
            r11 = move-exception
        L_0x0058:
            if (r10 == 0) goto L_0x005d
            r10.close()
        L_0x005d:
            throw r11
        L_0x005e:
            java.lang.String r1 = r11.getLastPathSegment()
        L_0x0062:
            if (r11 == 0) goto L_0x0078
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = r11.getPath()
            r10 = 47
            int r10 = r1.lastIndexOf(r10)
            if (r10 == r0) goto L_0x0078
            int r10 = r10 + 1
            java.lang.String r1 = r1.substring(r10)
        L_0x0078:
            java.lang.String r10 = "application/pdf"
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x00a3
            int r10 = r1.length()
            int r10 = r10 + -4
            java.lang.String r10 = r1.substring(r10)
            java.lang.String r11 = ".pdf"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x00a3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            java.lang.String r11 = ".pdf"
            r10.append(r11)
            java.lang.String r1 = r10.toString()
        L_0x00a3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.C2125f.m8366b(android.content.Context, android.net.Uri, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static String m8367b(String str) {
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        return guessContentTypeFromName == null ? "p7m".equalsIgnoreCase(m8369c(str)) ? "application/pkcs7-mime" : "text/plain" : guessContentTypeFromName;
    }

    /* renamed from: b */
    public static String m8368b(X509Certificate x509Certificate) {
        return x509Certificate != null ? m8363a().format(x509Certificate.getNotAfter()) : "";
    }

    /* renamed from: c */
    public static String m8369c(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    /* renamed from: c */
    public static String m8370c(X509Certificate x509Certificate) {
        return x509Certificate != null ? x509Certificate.getIssuerDN().toString() : "";
    }

    /* renamed from: d */
    public static File m8371d(String str) {
        return new File(m8365b(), str);
    }

    /* renamed from: d */
    public static String m8372d(X509Certificate x509Certificate) {
        return x509Certificate != null ? x509Certificate.getSubjectDN().toString() : "";
    }

    /* renamed from: e */
    public static String m8373e(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            return "";
        }
        try {
            return IETFUtils.valueToString(new JcaX509CertificateHolder(x509Certificate).getSubject().getRDNs(BCStyle.f7390CN)[0].getFirst().getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
