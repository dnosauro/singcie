package p066b.p067a.p068a.p072d;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3266f;
import p157d.p158a.C3191g;
import p157d.p161d.p163b.C3250h;

/* renamed from: b.a.a.d.c */
public final class C1363c {

    /* renamed from: a */
    public static final C1364a f4159a = new C1364a((C3247e) null);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static int f4160j;

    /* renamed from: b */
    private byte f4161b;
    @NotNull

    /* renamed from: c */
    private byte[] f4162c = new byte[0];
    @NotNull

    /* renamed from: d */
    private byte[] f4163d = new byte[0];
    @NotNull

    /* renamed from: e */
    private List<C1363c> f4164e = C3191g.m8984a();

    /* renamed from: f */
    private long f4165f;

    /* renamed from: g */
    private long f4166g;

    /* renamed from: h */
    private long f4167h;

    /* renamed from: i */
    private long f4168i;

    /* renamed from: b.a.a.d.c$a */
    public static final class C1364a {
        private C1364a() {
        }

        public /* synthetic */ C1364a(C3247e eVar) {
            this();
        }

        /* renamed from: a */
        public final int mo6746a(byte b) {
            return b & 255;
        }

        /* renamed from: a */
        public final long mo6747a(int i) {
            return i > 0 ? (long) i : ((long) Math.pow(2.0d, 32.0d)) + ((long) i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x0122  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0165  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0174  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0178  */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p066b.p067a.p068a.p072d.C1363c mo6748a(@org.jetbrains.annotations.NotNull java.io.ByteArrayInputStream r24, long r25, long r27, boolean r29) {
            /*
                r23 = this;
                r0 = r24
                r1 = r25
                java.lang.String r3 = "asn"
                p157d.p161d.p163b.C3250h.m9056b(r0, r3)
                int r3 = p066b.p067a.p068a.p072d.C1363c.f4160j
                r4 = 1
                int r3 = r3 + r4
                p066b.p067a.p068a.p072d.C1363c.f4160j = r3
                r10 = r23
                b.a.a.d.c$a r10 = (p066b.p067a.p068a.p072d.C1363c.C1364a) r10
                int r3 = r24.read()
                byte r3 = (byte) r3
                int r3 = r10.mo6746a((byte) r3)
                r5 = 0
                long r6 = (long) r5
                int r8 = (r6 > r27 ? 1 : (r6 == r27 ? 0 : -1))
                if (r8 == 0) goto L_0x019b
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                byte r7 = (byte) r3
                java.lang.Byte r7 = java.lang.Byte.valueOf(r7)
                r6.add(r7)
                r7 = 31
                r3 = r3 & r7
                r8 = 128(0x80, float:1.794E-43)
                if (r3 != r7) goto L_0x005b
                r3 = 1
            L_0x003a:
                long r11 = (long) r3
                int r7 = (r11 > r27 ? 1 : (r11 == r27 ? 0 : -1))
                if (r7 == 0) goto L_0x0051
                int r7 = r24.read()
                int r3 = r3 + 1
                byte r9 = (byte) r7
                java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
                r6.add(r9)
                r7 = r7 & r8
                if (r7 == r8) goto L_0x003a
                goto L_0x005c
            L_0x0051:
                b.a.a.d.d r0 = new b.a.a.d.d
                java.lang.String r1 = "Lunghezza non corretta"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x005b:
                r3 = 1
            L_0x005c:
                long r11 = (long) r3
                int r7 = (r11 > r27 ? 1 : (r11 == r27 ? 0 : -1))
                if (r7 == 0) goto L_0x0191
                int r7 = r24.read()
                byte r7 = (byte) r7
                int r7 = r10.mo6746a((byte) r7)
                long r11 = (long) r7
                int r3 = r3 + r4
                byte r7 = (byte) r8
                int r7 = r10.mo6746a((byte) r7)
                long r13 = (long) r7
                r15 = 0
                int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r7 <= 0) goto L_0x00ad
                long r7 = (long) r8
                long r11 = r11 - r7
                int r7 = (int) r11
                byte r7 = (byte) r7
                int r7 = r10.mo6746a((byte) r7)
                r8 = r3
                r11 = r15
                r3 = 0
            L_0x0083:
                if (r3 >= r7) goto L_0x00ac
                long r13 = (long) r8
                int r9 = (r13 > r27 ? 1 : (r13 == r27 ? 0 : -1))
                if (r9 == 0) goto L_0x00a2
                int r9 = r24.read()
                byte r9 = (byte) r9
                int r9 = r10.mo6746a((byte) r9)
                r13 = 8
                long r11 = r11 << r13
                long r13 = (long) r9
                long r11 = r11 | r13
                int r9 = (int) r11
                long r11 = r10.mo6747a((int) r9)
                int r8 = r8 + 1
                int r3 = r3 + 1
                goto L_0x0083
            L_0x00a2:
                b.a.a.d.d r0 = new b.a.a.d.d
                java.lang.String r1 = "Lunghezza non corretta"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x00ac:
                r3 = r8
            L_0x00ad:
                long r13 = (long) r3
                long r7 = r13 + r11
                int r3 = (r7 > r27 ? 1 : (r7 == r27 ? 0 : -1))
                if (r3 > 0) goto L_0x0187
                int r3 = r6.size()
                r9 = 0
                if (r3 != r4) goto L_0x00cc
                java.lang.Object r3 = r6.get(r5)
                java.lang.Number r3 = (java.lang.Number) r3
                byte r3 = r3.byteValue()
                if (r3 != 0) goto L_0x00cc
                int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
                if (r3 != 0) goto L_0x00cc
                return r9
            L_0x00cc:
                int r3 = (int) r11
                byte[] r15 = new byte[r3]
                r0.read(r15, r5, r3)
                java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
                r0.<init>(r15)
                java.util.Collection r6 = (java.util.Collection) r6
                java.lang.Object[] r3 = new java.lang.Object[r5]
                java.lang.Object[] r3 = r6.toArray(r3)
                if (r3 == 0) goto L_0x017f
                b.a.a.d.c r6 = new b.a.a.d.c
                r6.<init>(r3)
                r6.mo6744d(r7)
                r16 = r9
                java.util.List r16 = (java.util.List) r16
                boolean r3 = r6.mo6745d()
                if (r3 == 0) goto L_0x00f6
            L_0x00f3:
                r17 = 0
                goto L_0x0120
            L_0x00f6:
                if (r29 == 0) goto L_0x0105
                byte[] r3 = r6.mo6738a()
                java.lang.String r3 = r10.mo6750a((byte[]) r3)
                java.lang.String r9 = "OCTET STRING"
                if (r3 != r9) goto L_0x0105
                goto L_0x00f3
            L_0x0105:
                if (r29 == 0) goto L_0x011e
                byte[] r3 = r6.mo6738a()
                java.lang.String r3 = r10.mo6750a((byte[]) r3)
                java.lang.String r9 = "BIT STRING"
                if (r3 != r9) goto L_0x011e
                int r3 = r0.read()
                byte r3 = (byte) r3
                r6.mo6734a((byte) r3)
                r17 = 1
                goto L_0x0120
            L_0x011e:
                r4 = 0
                goto L_0x00f3
            L_0x0120:
                if (r4 == 0) goto L_0x0165
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r9 = r3
                java.util.List r9 = (java.util.List) r9
            L_0x012a:
                long r3 = r1 + r13
                long r19 = r3 + r17
                long r21 = r11 - r17
                r3 = r10
                r4 = r0
                r24 = r0
                r0 = r6
                r5 = r19
                r19 = r7
                r7 = r21
                r21 = r10
                r10 = r9
                r9 = r29
                b.a.a.d.c r3 = r3.mo6748a(r4, r5, r7, r9)
                if (r3 == 0) goto L_0x0149
                r10.add(r3)
            L_0x0149:
                if (r3 != 0) goto L_0x014e
                p157d.p161d.p163b.C3250h.m9052a()
            L_0x014e:
                long r3 = r3.mo6742c()
                long r17 = r17 + r3
                int r3 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
                if (r3 <= 0) goto L_0x0159
                goto L_0x0168
            L_0x0159:
                if (r3 != 0) goto L_0x015c
                goto L_0x016a
            L_0x015c:
                r6 = r0
                r9 = r10
                r7 = r19
                r10 = r21
                r0 = r24
                goto L_0x012a
            L_0x0165:
                r0 = r6
                r19 = r7
            L_0x0168:
                r10 = r16
            L_0x016a:
                r0.mo6735a((long) r1)
                long r1 = r1 + r19
                r0.mo6740b((long) r1)
                if (r10 != 0) goto L_0x0178
                r0.mo6737a((byte[]) r15)
                goto L_0x017e
            L_0x0178:
                r0.mo6736a((java.util.List<p066b.p067a.p068a.p072d.C1363c>) r10)
                r0.mo6743c(r11)
            L_0x017e:
                return r0
            L_0x017f:
                d.f r0 = new d.f
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                r0.<init>(r1)
                throw r0
            L_0x0187:
                b.a.a.d.d r0 = new b.a.a.d.d
                java.lang.String r1 = "ASN1 non valido"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x0191:
                b.a.a.d.d r0 = new b.a.a.d.d
                java.lang.String r1 = "Lunghezza non corretta"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x019b:
                b.a.a.d.d r0 = new b.a.a.d.d
                java.lang.String r1 = "Lunghezza non corretta"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p066b.p067a.p068a.p072d.C1363c.C1364a.mo6748a(java.io.ByteArrayInputStream, long, long, boolean):b.a.a.d.c");
        }

        @Nullable
        /* renamed from: a */
        public final C1363c mo6749a(@NotNull byte[] bArr, boolean z) {
            C3250h.m9056b(bArr, "efCom");
            return mo6748a(new ByteArrayInputStream(bArr), 0, (long) bArr.length, z);
        }

        @Nullable
        /* renamed from: a */
        public final String mo6750a(@NotNull byte[] bArr) {
            C3250h.m9056b(bArr, "tag");
            if (bArr.length != 1) {
                return null;
            }
            switch (bArr[0]) {
                case 2:
                    return "INTEGER";
                case 3:
                    return "BIT STRING";
                case 4:
                    return "OCTET STRING";
                case 5:
                    return "NULL";
                case 6:
                    return "OBJECT IDENTIFIER";
                case 12:
                    return "UTF8 String";
                case 19:
                    return "PrintableString";
                case 20:
                    return "T61String";
                case 22:
                    return "IA5String";
                case 23:
                    return "UTCTime";
                case 48:
                    return "SEQUENCE";
                case 49:
                    return "SET";
                default:
                    return null;
            }
        }
    }

    public C1363c(@NotNull Object[] objArr) {
        C3250h.m9056b(objArr, "objects");
        int i = 0;
        this.f4162c = new byte[objArr.length];
        int length = objArr.length;
        while (i < length) {
            byte[] bArr = this.f4162c;
            Byte b = objArr[i];
            if (b != null) {
                bArr[i] = b.byteValue();
                i++;
            } else {
                throw new C3266f("null cannot be cast to non-null type kotlin.Byte");
            }
        }
    }

    /* renamed from: f */
    private final int m5250f() {
        byte[] bArr = this.f4162c;
        byte b = bArr[0];
        int length = bArr.length;
        for (int i = 1; i < length; i++) {
            b = (b << 8) | this.f4162c[i];
        }
        return b;
    }

    @NotNull
    /* renamed from: a */
    public final C1363c mo6732a(int i) {
        return this.f4164e.get(i);
    }

    @NotNull
    /* renamed from: a */
    public final C1363c mo6733a(int i, byte b) {
        C1363c cVar = this.f4164e.get(i);
        if (cVar.m5250f() == b) {
            return cVar;
        }
        throw new C1365d("Check del tag fallito");
    }

    /* renamed from: a */
    public final void mo6734a(byte b) {
        this.f4161b = b;
    }

    /* renamed from: a */
    public final void mo6735a(long j) {
        this.f4165f = j;
    }

    /* renamed from: a */
    public final void mo6736a(@NotNull List<C1363c> list) {
        C3250h.m9056b(list, "<set-?>");
        this.f4164e = list;
    }

    /* renamed from: a */
    public final void mo6737a(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "<set-?>");
        this.f4163d = bArr;
    }

    @NotNull
    /* renamed from: a */
    public final byte[] mo6738a() {
        return this.f4162c;
    }

    @Nullable
    /* renamed from: b */
    public final C1363c mo6739b(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "tag");
        for (C1363c next : this.f4164e) {
            if (Arrays.equals(next.f4162c, bArr)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final void mo6740b(long j) {
        this.f4166g = j;
    }

    @NotNull
    /* renamed from: b */
    public final byte[] mo6741b() {
        return this.f4163d;
    }

    /* renamed from: c */
    public final long mo6742c() {
        return this.f4168i;
    }

    /* renamed from: c */
    public final void mo6743c(long j) {
        this.f4167h = j;
    }

    /* renamed from: d */
    public final void mo6744d(long j) {
        this.f4168i = j;
    }

    /* renamed from: d */
    public final boolean mo6745d() {
        return (this.f4162c[0] & 32) != 0;
    }
}
