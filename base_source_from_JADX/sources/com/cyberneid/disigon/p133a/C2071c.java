package com.cyberneid.disigon.p133a;

import android.content.Context;
import android.nfc.TagLostException;
import com.cyberneid.p087a.C1458g;
import com.cyberneid.p087a.C1465m;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p137e.p139b.C2138b;
import com.parse.ParseException;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.Certificate;
import p066b.p067a.p068a.p071c.C1351c;
import p066b.p067a.p068a.p072d.C1366e;

/* renamed from: com.cyberneid.disigon.a.c */
public class C2071c implements C1465m {

    /* renamed from: a */
    private Context f6485a;

    /* renamed from: b */
    private C1366e f6486b;

    /* renamed from: c */
    private String f6487c;

    /* renamed from: d */
    private byte[] f6488d;

    public C2071c(Context context) {
        this.f6485a = context;
    }

    /* renamed from: a */
    public int mo8681a() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0076, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        r5.printStackTrace();
        com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().recordException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0083, code lost:
        return 104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0084, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0085, code lost:
        r5.printStackTrace();
        com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().recordException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
        return 102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0092, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
        r5.printStackTrace();
        com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().recordException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009f, code lost:
        return 101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a0, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a1, code lost:
        r5.printStackTrace();
        com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().recordException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ad, code lost:
        return 103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ae, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00af, code lost:
        r5.printStackTrace();
        com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().recordException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c1, code lost:
        return com.p137e.p139b.C2138b.m8398b(r5.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0076 A[ExcHandler: c (r5v10 'e' b.a.a.d.e$c A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084 A[ExcHandler: b (r5v8 'e' b.a.a.d.e$b A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092 A[ExcHandler: c (r5v6 'e' b.a.a.c.c A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0 A[ExcHandler: TagLostException (r5v4 'e' android.nfc.TagLostException A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae A[ExcHandler: f (r5v1 'e' b.a.a.d.e$f A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo8682a(java.lang.String r5) {
        /*
            r4 = this;
            r4.f6487c = r5
            b.a.a.d.e r0 = r4.f6486b     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r0.mo6756b()     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            b.a.a.d.e r0 = r4.f6486b     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r0.mo6752a()     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            b.a.a.d.e r0 = r4.f6486b     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            int r5 = r0.mo6755b((java.lang.String) r5)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            if (r5 == 0) goto L_0x0015
            return r5
        L_0x0015:
            b.a.a.d.e r5 = r4.f6486b     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            byte[] r5 = r5.mo6758c()     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r4.f6488d = r5     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            java.lang.String r0 = "cert: %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            byte[] r2 = r4.f6488d     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            java.lang.String r2 = com.p137e.p139b.C2138b.m8399b((byte[]) r2)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r3 = 0
            r1[r3] = r2     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r5.log(r0)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            byte[] r0 = r4.f6488d     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            java.lang.String r0 = com.p137e.p139b.C2138b.m8399b((byte[]) r0)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r5.println(r0)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            org.spongycastle.cert.X509CertificateHolder r5 = new org.spongycastle.cert.X509CertificateHolder     // Catch:{ Exception -> 0x004f, f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076 }
            byte[] r0 = r4.f6488d     // Catch:{ Exception -> 0x004f, f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076 }
            r5.<init>((byte[]) r0)     // Catch:{ Exception -> 0x004f, f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076 }
            byte[] r5 = r5.getEncoded()     // Catch:{ Exception -> 0x004f, f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076 }
            r4.f6488d = r5     // Catch:{ Exception -> 0x004f, f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076 }
            goto L_0x005c
        L_0x004f:
            com.e.a.c r5 = new com.e.a.c     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            byte[] r0 = r4.f6488d     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r5.<init>(r0)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            byte[] r5 = r5.mo8747c()     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r4.f6488d = r5     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
        L_0x005c:
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            byte[] r0 = r4.f6488d     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            java.lang.String r0 = com.p137e.p139b.C2138b.m8399b((byte[]) r0)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            r5.println(r0)     // Catch:{ f -> 0x00ae, TagLostException -> 0x00a0, c -> 0x0092, b -> 0x0084, c -> 0x0076, Exception -> 0x0068 }
            return r3
        L_0x0068:
            r5 = move-exception
            r5.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r0.recordException(r5)
            r5 = 100
            return r5
        L_0x0076:
            r5 = move-exception
            r5.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r0.recordException(r5)
            r5 = 104(0x68, float:1.46E-43)
            return r5
        L_0x0084:
            r5 = move-exception
            r5.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r0.recordException(r5)
            r5 = 102(0x66, float:1.43E-43)
            return r5
        L_0x0092:
            r5 = move-exception
            r5.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r0.recordException(r5)
            r5 = 101(0x65, float:1.42E-43)
            return r5
        L_0x00a0:
            r5 = move-exception
            r5.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r0.recordException(r5)
            r5 = 103(0x67, float:1.44E-43)
            return r5
        L_0x00ae:
            r5 = move-exception
            r5.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r0.recordException(r5)
            java.lang.String r5 = r5.getMessage()
            int r5 = com.p137e.p139b.C2138b.m8398b((java.lang.String) r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.p133a.C2071c.mo8682a(java.lang.String):int");
    }

    /* renamed from: a */
    public int mo8683a(String str, String str2) {
        try {
            this.f6486b.mo6756b();
            this.f6486b.mo6752a();
            int b = this.f6486b.mo6755b(str);
            if (b != 0) {
                return b;
            }
            int a = this.f6486b.mo6751a(str, str2);
            return a != 0 ? a : ParseException.PASSWORD_MISSING;
        } catch (C1366e.C1372f e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            return C2138b.m8398b(e.getMessage());
        } catch (C1351c e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            return 101;
        } catch (C1366e.C1368b e3) {
            e3.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e3);
            return 102;
        } catch (C1366e.C1369c e4) {
            e4.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e4);
            return 104;
        } catch (Exception e5) {
            e5.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e5);
            return 100;
        }
    }

    /* renamed from: a */
    public void mo8684a(C1366e eVar) {
        this.f6486b = eVar;
    }

    /* renamed from: a */
    public byte[] mo6942a(byte[] bArr) {
        try {
            return this.f6486b.mo6754a(bArr);
        } catch (C1366e.C1372f e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            throw new C1458g((long) C2138b.m8398b(e.getMessage()));
        } catch (TagLostException e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            throw new C1458g(103);
        } catch (C1351c e3) {
            e3.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e3);
            throw new C1458g(101);
        } catch (C1366e.C1368b e4) {
            e4.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e4);
            throw new C1458g(102);
        } catch (C1366e.C1369c e5) {
            e5.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e5);
            throw new C1458g(104);
        } catch (Exception e6) {
            e6.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e6);
            throw new C1458g(100);
        }
    }

    /* renamed from: b */
    public int mo8685b(String str, String str2) {
        try {
            this.f6486b.mo6756b();
            this.f6486b.mo6752a();
            int c = this.f6486b.mo6757c(str);
            if (c != 0) {
                return c;
            }
            int d = this.f6486b.mo6759d(str2);
            return d != 0 ? d : ParseException.USERNAME_TAKEN;
        } catch (C1366e.C1372f e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            return C2138b.m8398b(e.getMessage());
        } catch (TagLostException e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            return 103;
        } catch (C1351c e3) {
            e3.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e3);
            return 101;
        } catch (C1366e.C1368b e4) {
            e4.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e4);
            return 102;
        } catch (C1366e.C1369c e5) {
            e5.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e5);
            return 104;
        } catch (Exception e6) {
            e6.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e6);
            return 100;
        }
    }

    /* renamed from: b */
    public void mo8686b() {
    }

    /* renamed from: c */
    public byte[] mo6943c() {
        return this.f6488d;
    }

    /* renamed from: d */
    public Certificate mo6944d() {
        byte[] bArr = this.f6488d;
        if (bArr != null) {
            try {
                return Certificate.getInstance(ASN1Primitive.fromByteArray(bArr));
            } catch (IOException e) {
                e.printStackTrace();
                throw new C1458g(-2130706268);
            }
        } else {
            throw new C1458g(-2130706268);
        }
    }

    /* renamed from: e */
    public boolean mo6945e() {
        return true;
    }
}
