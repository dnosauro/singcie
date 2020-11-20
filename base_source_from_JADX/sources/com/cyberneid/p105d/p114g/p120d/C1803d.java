package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p095f.C1543aa;
import com.cyberneid.p089b.p095f.C1544ab;
import com.cyberneid.p089b.p095f.C1569q;
import com.cyberneid.p089b.p095f.C1571s;
import com.cyberneid.p089b.p095f.C1576x;
import com.cyberneid.p089b.p096g.C1583d;
import com.cyberneid.p089b.p097h.p098a.C1589c;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p131h.C1941e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

/* renamed from: com.cyberneid.d.g.d.d */
final class C1803d extends C1814j {

    /* renamed from: a */
    private final List<C1805a> f5825a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1807e f5826b;

    /* renamed from: com.cyberneid.d.g.d.d$a */
    private static class C1805a extends C1809g implements Serializable {

        /* renamed from: a */
        private final String f5828a;

        /* renamed from: b */
        private final C1808f f5829b;

        /* renamed from: c */
        private final C1801b f5830c;

        /* renamed from: d */
        private final int f5831d;

        /* renamed from: e */
        private final int f5832e;

        /* renamed from: f */
        private final int f5833f;

        /* renamed from: g */
        private final int f5834g;

        /* renamed from: h */
        private final int f5835h;

        /* renamed from: i */
        private final C1825u f5836i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public final File f5837j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public transient C1803d f5838k;

        private C1805a(File file, C1808f fVar, String str, C1801b bVar, int i, int i2, int i3, int i4, int i5, byte[] bArr, C1803d dVar) {
            this.f5837j = file;
            this.f5829b = fVar;
            this.f5828a = str;
            this.f5830c = bVar;
            this.f5831d = i;
            this.f5832e = i2;
            this.f5833f = i3;
            this.f5834g = i4;
            this.f5835h = i5;
            this.f5836i = bArr != null ? new C1825u(bArr) : null;
            this.f5838k = dVar;
        }

        /* renamed from: a */
        public String mo8120a() {
            return this.f5828a;
        }

        /* renamed from: b */
        public C1808f mo8121b() {
            return this.f5829b;
        }

        /* renamed from: c */
        public C1801b mo8122c() {
            return this.f5830c;
        }

        /* renamed from: d */
        public C1479b mo8123d() {
            C1479b bVar;
            C1479b a = this.f5838k.f5826b.mo8131a(this);
            if (a != null) {
                return a;
            }
            switch (this.f5829b) {
                case PFB:
                    bVar = this.f5838k.m7317d(this.f5828a, this.f5837j);
                    break;
                case TTF:
                    bVar = this.f5838k.m7303a(this.f5828a, this.f5837j);
                    break;
                case OTF:
                    bVar = this.f5838k.m7315c(this.f5828a, this.f5837j);
                    break;
                default:
                    throw new RuntimeException("can't happen");
            }
            this.f5838k.f5826b.mo8132a(this, bVar);
            return bVar;
        }

        /* renamed from: e */
        public int mo8124e() {
            return this.f5832e;
        }

        /* renamed from: f */
        public int mo8125f() {
            return this.f5831d;
        }

        /* renamed from: g */
        public int mo8126g() {
            return this.f5833f;
        }

        /* renamed from: h */
        public int mo8127h() {
            return this.f5834g;
        }

        /* renamed from: i */
        public int mo8128i() {
            return this.f5835h;
        }

        /* renamed from: j */
        public C1825u mo8129j() {
            return this.f5836i;
        }

        public String toString() {
            return super.toString() + " " + this.f5837j;
        }
    }

    /* renamed from: com.cyberneid.d.g.d.d$b */
    private static final class C1806b extends C1805a implements Serializable {
        private C1806b(File file, C1808f fVar, String str) {
            super(file, fVar, str, (C1801b) null, 0, 0, 0, 0, 0, (byte[]) null, (C1803d) null);
        }
    }

    C1803d(C1807e eVar) {
        this.f5826b = eVar;
        if (C1941e.f6142a != C1941e.C1942a.NONE) {
            if (C1941e.f6142a == C1941e.C1942a.MINIMUM) {
                try {
                    m7313b(new File("/system/fonts/DroidSans.ttf"));
                    m7313b(new File("/system/fonts/DroidSans-Bold.ttf"));
                    m7313b(new File("/system/fonts/DroidSansMono.ttf"));
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.v("PdfBox-Android", "Will search the local system for fonts");
            ArrayList arrayList = new ArrayList();
            for (URI file : new C1589c().mo7400a()) {
                arrayList.add(new File(file));
            }
            Log.v("PdfBox-Android", "Found " + arrayList.size() + " fonts on the local system");
            List<C1805a> b = m7311b((List<File>) arrayList);
            if (b == null || b.size() <= 0) {
                Log.w("PdfBox-Android", "Building font cache, this may take a while");
                m7308a((List<File>) arrayList);
                m7312b();
                return;
            }
            this.f5825a.addAll(b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C1544ab m7303a(String str, File file) {
        StringBuilder sb;
        String str2;
        try {
            C1544ab b = m7310b(str, file);
            Log.d("PdfBox-Android", "Loaded " + str + " from " + file);
            return b;
        } catch (NullPointerException e) {
            e = e;
            str2 = "PdfBox-Android";
            sb = new StringBuilder();
            sb.append("Could not load font file: ");
            sb.append(file);
            Log.d(str2, sb.toString(), e);
            return null;
        } catch (IOException e2) {
            e = e2;
            str2 = "PdfBox-Android";
            sb = new StringBuilder();
            sb.append("Could not load font file: ");
            sb.append(file);
            Log.d(str2, sb.toString(), e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7306a(com.cyberneid.p089b.p095f.C1544ab r20, java.io.File r21) {
        /*
            r19 = this;
            r14 = r19
            r15 = r20
            r13 = r21
            java.lang.String r0 = r20.mo7033b()     // Catch:{ IOException -> 0x0195 }
            if (r0 == 0) goto L_0x0172
            com.cyberneid.b.f.p r0 = r20.mo7191l()     // Catch:{ IOException -> 0x018f }
            r1 = 0
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L_0x0045
            com.cyberneid.b.f.p r0 = r20.mo7191l()     // Catch:{ IOException -> 0x0195 }
            int r0 = r0.mo7306e()     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.b.f.p r1 = r20.mo7191l()     // Catch:{ IOException -> 0x0195 }
            int r1 = r1.mo7324w()     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.b.f.p r2 = r20.mo7191l()     // Catch:{ IOException -> 0x0195 }
            long r4 = r2.mo7304c()     // Catch:{ IOException -> 0x0195 }
            int r2 = (int) r4     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.b.f.p r4 = r20.mo7191l()     // Catch:{ IOException -> 0x0195 }
            long r4 = r4.mo7305d()     // Catch:{ IOException -> 0x0195 }
            int r5 = (int) r4     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.b.f.p r4 = r20.mo7191l()     // Catch:{ IOException -> 0x0195 }
            byte[] r4 = r4.mo7309h()     // Catch:{ IOException -> 0x0195 }
            r7 = r0
            r6 = r1
            r8 = r2
            r11 = r4
            r9 = r5
            goto L_0x004a
        L_0x0045:
            r11 = r3
            r6 = -1
            r7 = -1
            r8 = 0
            r9 = 0
        L_0x004a:
            com.cyberneid.b.f.f r0 = r20.mo7193n()     // Catch:{ IOException -> 0x018f }
            if (r0 != 0) goto L_0x0066
            java.util.List<com.cyberneid.d.g.d.d$a> r0 = r14.f5825a     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.d.g.d.d$b r1 = new com.cyberneid.d.g.d.d$b     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.d.g.d.f r2 = com.cyberneid.p105d.p114g.p120d.C1808f.TTF     // Catch:{ IOException -> 0x0195 }
            java.lang.String r4 = r20.mo7033b()     // Catch:{ IOException -> 0x0195 }
            r1.<init>(r13, r2, r4)     // Catch:{ IOException -> 0x0195 }
            r0.add(r1)     // Catch:{ IOException -> 0x0195 }
            if (r15 == 0) goto L_0x0065
            r20.close()
        L_0x0065:
            return
        L_0x0066:
            com.cyberneid.b.f.f r0 = r20.mo7193n()     // Catch:{ IOException -> 0x018f }
            int r10 = r0.mo7229h()     // Catch:{ IOException -> 0x018f }
            boolean r0 = r15 instanceof com.cyberneid.p089b.p095f.C1571s     // Catch:{ IOException -> 0x018f }
            if (r0 == 0) goto L_0x00c7
            r0 = r15
            com.cyberneid.b.f.s r0 = (com.cyberneid.p089b.p095f.C1571s) r0     // Catch:{ IOException -> 0x018f }
            boolean r0 = r0.mo7338f()     // Catch:{ IOException -> 0x018f }
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = "OTF"
            r1 = r15
            com.cyberneid.b.f.s r1 = (com.cyberneid.p089b.p095f.C1571s) r1     // Catch:{ IOException -> 0x018f }
            com.cyberneid.b.f.a r1 = r1.mo7337a()     // Catch:{ IOException -> 0x018f }
            com.cyberneid.b.b.h r1 = r1.mo7174a()     // Catch:{ IOException -> 0x018f }
            boolean r2 = r1 instanceof com.cyberneid.p089b.p091b.C1480a     // Catch:{ IOException -> 0x018f }
            if (r2 == 0) goto L_0x00a1
            com.cyberneid.b.b.a r1 = (com.cyberneid.p089b.p091b.C1480a) r1     // Catch:{ IOException -> 0x0195 }
            java.lang.String r2 = r1.mo7037a()     // Catch:{ IOException -> 0x0195 }
            java.lang.String r3 = r1.mo7045e()     // Catch:{ IOException -> 0x0195 }
            int r1 = r1.mo7046f()     // Catch:{ IOException -> 0x0195 }
            com.cyberneid.d.g.d.b r4 = new com.cyberneid.d.g.d.b     // Catch:{ IOException -> 0x0195 }
            r4.<init>(r2, r3, r1)     // Catch:{ IOException -> 0x0195 }
            r5 = r4
            goto L_0x00a2
        L_0x00a1:
            r5 = r3
        L_0x00a2:
            java.util.List<com.cyberneid.d.g.d.d$a> r12 = r14.f5825a     // Catch:{ IOException -> 0x018f }
            com.cyberneid.d.g.d.d$a r4 = new com.cyberneid.d.g.d.d$a     // Catch:{ IOException -> 0x018f }
            com.cyberneid.d.g.d.f r3 = com.cyberneid.p105d.p114g.p120d.C1808f.OTF     // Catch:{ IOException -> 0x018f }
            java.lang.String r16 = r20.mo7033b()     // Catch:{ IOException -> 0x018f }
            r17 = 0
            r1 = r4
            r2 = r21
            r18 = r4
            r4 = r16
            r16 = r0
            r0 = r12
            r12 = r19
            r13 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x018f }
            r1 = r18
            r0.add(r1)     // Catch:{ IOException -> 0x018f }
            r0 = r16
            goto L_0x0131
        L_0x00c7:
            java.util.Map r0 = r20.mo7188i()     // Catch:{ IOException -> 0x018f }
            java.lang.String r1 = "gcid"
            boolean r0 = r0.containsKey(r1)     // Catch:{ IOException -> 0x018f }
            if (r0 == 0) goto L_0x010f
            java.util.Map r0 = r20.mo7188i()     // Catch:{ IOException -> 0x018f }
            java.lang.String r1 = "gcid"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ IOException -> 0x018f }
            com.cyberneid.b.f.z r0 = (com.cyberneid.p089b.p095f.C1578z) r0     // Catch:{ IOException -> 0x018f }
            byte[] r0 = r15.mo7182b((com.cyberneid.p089b.p095f.C1578z) r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x018f }
            r2 = 10
            java.nio.charset.Charset r3 = com.cyberneid.p105d.p131h.C1933a.f6108a     // Catch:{ IOException -> 0x018f }
            r4 = 64
            r1.<init>(r0, r2, r4, r3)     // Catch:{ IOException -> 0x018f }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException -> 0x018f }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x018f }
            r3 = 76
            java.nio.charset.Charset r5 = com.cyberneid.p105d.p131h.C1933a.f6108a     // Catch:{ IOException -> 0x018f }
            r2.<init>(r0, r3, r4, r5)     // Catch:{ IOException -> 0x018f }
            java.lang.String r2 = r2.trim()     // Catch:{ IOException -> 0x018f }
            r3 = 140(0x8c, float:1.96E-43)
            byte r3 = r0[r3]     // Catch:{ IOException -> 0x018f }
            int r3 = r3 << 8
            r4 = 141(0x8d, float:1.98E-43)
            byte r0 = r0[r4]     // Catch:{ IOException -> 0x018f }
            r0 = r0 & r3
            com.cyberneid.d.g.d.b r3 = new com.cyberneid.d.g.d.b     // Catch:{ IOException -> 0x018f }
            r3.<init>(r1, r2, r0)     // Catch:{ IOException -> 0x018f }
        L_0x010f:
            r5 = r3
            java.lang.String r0 = "TTF"
            java.util.List<com.cyberneid.d.g.d.d$a> r13 = r14.f5825a     // Catch:{ IOException -> 0x018f }
            com.cyberneid.d.g.d.d$a r12 = new com.cyberneid.d.g.d.d$a     // Catch:{ IOException -> 0x018f }
            com.cyberneid.d.g.d.f r3 = com.cyberneid.p105d.p114g.p120d.C1808f.TTF     // Catch:{ IOException -> 0x018f }
            java.lang.String r4 = r20.mo7033b()     // Catch:{ IOException -> 0x018f }
            r16 = 0
            r1 = r12
            r2 = r21
            r17 = r0
            r0 = r12
            r12 = r19
            r14 = r13
            r13 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x018f }
            r14.add(r0)     // Catch:{ IOException -> 0x018f }
            r0 = r17
        L_0x0131:
            com.cyberneid.b.f.o r1 = r20.mo7189j()     // Catch:{ IOException -> 0x018f }
            if (r1 == 0) goto L_0x018a
            java.lang.String r2 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018f }
            r3.<init>()     // Catch:{ IOException -> 0x018f }
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = ": '"
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = r1.mo7299d()     // Catch:{ IOException -> 0x018f }
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = "' / '"
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = r1.mo7297b()     // Catch:{ IOException -> 0x018f }
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = "' / '"
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = r1.mo7298c()     // Catch:{ IOException -> 0x018f }
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = "'"
            r3.append(r0)     // Catch:{ IOException -> 0x018f }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x018f }
            android.util.Log.d(r2, r0)     // Catch:{ IOException -> 0x018f }
            goto L_0x018a
        L_0x0172:
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018f }
            r1.<init>()     // Catch:{ IOException -> 0x018f }
            java.lang.String r2 = "Missing 'name' entry for PostScript name in font "
            r1.append(r2)     // Catch:{ IOException -> 0x018f }
            r2 = r21
            r1.append(r2)     // Catch:{ IOException -> 0x018d }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x018d }
            android.util.Log.w(r0, r1)     // Catch:{ IOException -> 0x018d }
        L_0x018a:
            if (r15 == 0) goto L_0x01b2
            goto L_0x01af
        L_0x018d:
            r0 = move-exception
            goto L_0x0197
        L_0x018f:
            r0 = move-exception
            r2 = r21
            goto L_0x0197
        L_0x0193:
            r0 = move-exception
            goto L_0x01b3
        L_0x0195:
            r0 = move-exception
            r2 = r13
        L_0x0197:
            java.lang.String r1 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0193 }
            r3.<init>()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = "Could not load font file: "
            r3.append(r4)     // Catch:{ all -> 0x0193 }
            r3.append(r2)     // Catch:{ all -> 0x0193 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0193 }
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0193 }
            if (r15 == 0) goto L_0x01b2
        L_0x01af:
            r20.close()
        L_0x01b2:
            return
        L_0x01b3:
            if (r15 == 0) goto L_0x01b8
            r20.close()
        L_0x01b8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1803d.m7306a(com.cyberneid.b.f.ab, java.io.File):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045 A[Catch:{ NullPointerException -> 0x0046, IOException -> 0x0029, all -> 0x0026, all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7307a(java.io.File r7) {
        /*
            r6 = this;
            r0 = 0
            com.cyberneid.b.f.aa r1 = new com.cyberneid.b.f.aa     // Catch:{ NullPointerException -> 0x0046, IOException -> 0x0029, all -> 0x0026 }
            r1.<init>((java.io.File) r7)     // Catch:{ NullPointerException -> 0x0046, IOException -> 0x0029, all -> 0x0026 }
            java.util.List r0 = r1.mo7176a()     // Catch:{ NullPointerException -> 0x0024, IOException -> 0x0022 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ NullPointerException -> 0x0024, IOException -> 0x0022 }
        L_0x000e:
            boolean r2 = r0.hasNext()     // Catch:{ NullPointerException -> 0x0024, IOException -> 0x0022 }
            if (r2 == 0) goto L_0x001e
            java.lang.Object r2 = r0.next()     // Catch:{ NullPointerException -> 0x0024, IOException -> 0x0022 }
            com.cyberneid.b.f.ab r2 = (com.cyberneid.p089b.p095f.C1544ab) r2     // Catch:{ NullPointerException -> 0x0024, IOException -> 0x0022 }
            r6.m7306a((com.cyberneid.p089b.p095f.C1544ab) r2, (java.io.File) r7)     // Catch:{ NullPointerException -> 0x0024, IOException -> 0x0022 }
            goto L_0x000e
        L_0x001e:
            r1.close()
            goto L_0x0063
        L_0x0022:
            r0 = move-exception
            goto L_0x002d
        L_0x0024:
            r0 = move-exception
            goto L_0x004a
        L_0x0026:
            r7 = move-exception
            r1 = r0
            goto L_0x0065
        L_0x0029:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x002d:
            java.lang.String r2 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "Could not load font file: "
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            r3.append(r7)     // Catch:{ all -> 0x0064 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0064 }
            android.util.Log.e(r2, r7, r0)     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0063
            goto L_0x001e
        L_0x0046:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x004a:
            java.lang.String r2 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "Could not load font file: "
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            r3.append(r7)     // Catch:{ all -> 0x0064 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0064 }
            android.util.Log.e(r2, r7, r0)     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0063
            goto L_0x001e
        L_0x0063:
            return
        L_0x0064:
            r7 = move-exception
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r1.close()
        L_0x006a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1803d.m7307a(java.io.File):void");
    }

    /* renamed from: a */
    private void m7308a(List<File> list) {
        for (File next : list) {
            try {
                if (!next.getPath().toLowerCase().endsWith(".ttf")) {
                    if (!next.getPath().toLowerCase().endsWith(".otf")) {
                        if (!next.getPath().toLowerCase().endsWith(".ttc")) {
                            if (!next.getPath().toLowerCase().endsWith(".otc")) {
                                if (next.getPath().toLowerCase().endsWith(".pfb")) {
                                    m7316c(next);
                                }
                            }
                        }
                        m7307a(next);
                    }
                }
                m7313b(next);
            } catch (IOException e) {
                Log.e("PdfBox-Android", "Error parsing font " + next.getPath(), e);
            }
        }
    }

    /* renamed from: b */
    private C1544ab m7310b(String str, File file) {
        if (!file.getName().toLowerCase().endsWith(".ttc")) {
            return new C1576x(false, true).mo7332b(file);
        }
        for (C1544ab next : new C1543aa(file).mo7176a()) {
            if (next.mo7033b().equals(str)) {
                return next;
            }
        }
        throw new IOException("Font " + str + " not found in " + file);
    }

    /* renamed from: b */
    private List<C1805a> m7311b(List<File> list) {
        Preferences userNodeForPackage = Preferences.userNodeForPackage(C1803d.class);
        ArrayList arrayList = new ArrayList();
        for (File absolutePath : list) {
            byte[] byteArray = userNodeForPackage.getByteArray(absolutePath.getAbsolutePath(), (byte[]) null);
            if (byteArray != null) {
                try {
                    Object readObject = new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
                    if (readObject instanceof C1805a) {
                        C1805a aVar = (C1805a) readObject;
                        C1803d unused = aVar.f5838k = this;
                        arrayList.add(aVar);
                    }
                } catch (ClassNotFoundException e) {
                    Log.e("PdfBox-Android", "Error loading font cache, will be re-built", e);
                    return null;
                } catch (IOException e2) {
                    Log.e("PdfBox-Android", "Error loading font cache, will be re-built", e2);
                    return null;
                }
            } else {
                Log.w("PdfBox-Android", "New fonts found, font cache will be re-built");
                return null;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m7312b() {
        Preferences userNodeForPackage = Preferences.userNodeForPackage(C1803d.class);
        try {
            for (C1805a next : this.f5825a) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(next);
                userNodeForPackage.putByteArray(next.f5837j.getAbsolutePath(), byteArrayOutputStream.toByteArray());
            }
        } catch (IOException e) {
            Log.e("PdfBox-Android", "Could not write to font cache", e);
        }
        Log.w("PdfBox-Android", "Finished building font cache, found " + this.f5825a.size() + " fonts");
    }

    /* renamed from: b */
    private void m7313b(File file) {
        StringBuilder sb;
        String str;
        try {
            m7306a(file.getPath().endsWith(".otf") ? new C1569q(false, true).mo7332b(file) : new C1576x(false, true).mo7332b(file), file);
        } catch (NullPointerException e) {
            e = e;
            str = "PdfBox-Android";
            sb = new StringBuilder();
            sb.append("Could not load font file: ");
            sb.append(file);
            Log.e(str, sb.toString(), e);
        } catch (IOException e2) {
            e = e2;
            str = "PdfBox-Android";
            sb = new StringBuilder();
            sb.append("Could not load font file: ");
            sb.append(file);
            Log.e(str, sb.toString(), e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C1571s m7315c(String str, File file) {
        try {
            C1571s a = new C1569q(false, true).mo7332b(file);
            Log.d("PdfBox-Android", "Loaded " + str + " from " + file);
            return a;
        } catch (IOException e) {
            Log.e("PdfBox-Android", "Could not load font file: " + file, e);
            return null;
        }
    }

    /* renamed from: c */
    private void m7316c(File file) {
        File file2 = file;
        FileInputStream fileInputStream = new FileInputStream(file2);
        try {
            C1583d a = C1583d.m6226a((InputStream) fileInputStream);
            C1805a aVar = r1;
            C1805a aVar2 = new C1805a(file, C1808f.PFB, a.mo7033b(), (C1801b) null, -1, -1, 0, 0, -1, (byte[]) null, this);
            this.f5825a.add(aVar);
            Log.v("PdfBox-Android", "PFB: '" + a.mo7033b() + "' / '" + a.mo7382e() + "' / '" + a.mo7383f() + "'");
        } catch (IOException e) {
            Log.e("PdfBox-Android", "Could not load font file: " + file2, e);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        fileInputStream.close();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1583d m7317d(String str, File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                C1583d a = C1583d.m6226a((InputStream) fileInputStream);
                Log.d("PdfBox-Android", "Loaded " + str + " from " + file);
                C1654a.m6619a((Closeable) fileInputStream);
                return a;
            } catch (IOException e) {
                e = e;
                try {
                    Log.e("PdfBox-Android", "Could not load font file: " + file, e);
                    C1654a.m6619a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    C1654a.m6619a((Closeable) fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
            Log.e("PdfBox-Android", "Could not load font file: " + file, e);
            C1654a.m6619a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            C1654a.m6619a((Closeable) fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public List<? extends C1809g> mo8119a() {
        return this.f5825a;
    }
}
