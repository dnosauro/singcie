package com.cyberneid.p089b.p095f;

import android.support.p002v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: com.cyberneid.b.f.b */
public class C1549b {

    /* renamed from: a */
    private int f4604a;

    /* renamed from: b */
    private int f4605b;

    /* renamed from: c */
    private long f4606c;

    /* renamed from: d */
    private int[] f4607d;

    /* renamed from: e */
    private final Map<Integer, Integer> f4608e = new HashMap();

    /* renamed from: com.cyberneid.b.f.b$a */
    private class C1551a {

        /* renamed from: b */
        private final int f4610b;

        /* renamed from: c */
        private final int f4611c;

        /* renamed from: d */
        private final short f4612d;

        /* renamed from: e */
        private final int f4613e;

        private C1551a(int i, int i2, short s, int i3) {
            this.f4610b = i;
            this.f4611c = i2;
            this.f4612d = s;
            this.f4613e = i3;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int m5981a() {
            return this.f4610b;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public int m5983b() {
            return this.f4611c;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public short m5985c() {
            return this.f4612d;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public int m5987d() {
            return this.f4613e;
        }
    }

    /* renamed from: b */
    private int[] m5966b(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* renamed from: a */
    public int mo7205a() {
        return this.f4605b;
    }

    /* renamed from: a */
    public int mo7206a(int i) {
        Integer num = this.f4608e.get(Integer.valueOf(i));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public void mo7207a(C1552c cVar, int i, C1575w wVar) {
        wVar.mo7277a(cVar.mo7368D() + this.f4606c);
        int d = wVar.mo7281d();
        if (d < 8) {
            wVar.mo7281d();
            wVar.mo7281d();
        } else {
            wVar.mo7281d();
            wVar.mo7358k();
            wVar.mo7358k();
        }
        if (d == 0) {
            mo7211b(wVar);
        } else if (d == 2) {
            mo7218h(wVar, i);
        } else if (d == 4) {
            mo7217g(wVar, i);
        } else if (d == 6) {
            mo7216f(wVar, i);
        } else if (d == 8) {
            mo7209a(wVar, i);
        } else if (d != 10) {
            switch (d) {
                case 12:
                    mo7213c(wVar, i);
                    return;
                case 13:
                    mo7214d(wVar, i);
                    return;
                case 14:
                    mo7215e(wVar, i);
                    return;
                default:
                    throw new IOException("Unknown cmap format:" + d);
            }
        } else {
            mo7212b(wVar, i);
        }
    }

    /* renamed from: a */
    public void mo7208a(C1575w wVar) {
        this.f4604a = wVar.mo7281d();
        this.f4605b = wVar.mo7281d();
        this.f4606c = wVar.mo7358k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7209a(C1575w wVar, int i) {
        int[] iArr;
        int i2 = i;
        int[] b = wVar.mo7352b(PKIFailureInfo.certRevoked);
        long k = wVar.mo7358k();
        if (k <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            this.f4607d = m5966b(i2);
            long j = 0;
            long j2 = 0;
            while (j2 < k) {
                long k2 = wVar.mo7358k();
                long k3 = wVar.mo7358k();
                long k4 = wVar.mo7358k();
                if (k2 > k3 || j > k2) {
                    throw new IOException("Range invalid");
                }
                long j3 = k2;
                while (j3 <= k3) {
                    if (j3 <= 2147483647L) {
                        int i3 = (int) j3;
                        if ((b[i3 / 8] & (1 << (i3 % 8))) == 0) {
                            iArr = b;
                        } else {
                            iArr = b;
                            long j4 = ((((j3 >> 10) + 55232) << 10) + ((j3 & 1023) + 56320)) - 56613888;
                            if (j4 <= 2147483647L) {
                                i3 = (int) j4;
                            } else {
                                throw new IOException("[Sub Format 8] Invalid Character code");
                            }
                        }
                        long j5 = k;
                        long j6 = k4 + (j3 - k2);
                        long j7 = k2;
                        if (j6 > ((long) i2) || j6 > 2147483647L) {
                            throw new IOException("CMap contains an invalid glyph index");
                        }
                        int i4 = (int) j6;
                        this.f4607d[i4] = i3;
                        this.f4608e.put(Integer.valueOf(i3), Integer.valueOf(i4));
                        j3++;
                        k2 = j7;
                        k = j5;
                        b = iArr;
                        C1575w wVar2 = wVar;
                    } else {
                        throw new IOException("[Sub Format 8] Invalid Character code");
                    }
                }
                int[] iArr2 = b;
                long j8 = k;
                j2++;
                C1575w wVar3 = wVar;
                j = 0;
            }
            return;
        }
        throw new IOException("CMap ( Subtype8 ) is invalid");
    }

    /* renamed from: b */
    public int mo7210b() {
        return this.f4604a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7211b(C1575w wVar) {
        byte[] d = wVar.mo7354d(256);
        this.f4607d = m5966b(256);
        for (int i = 0; i < d.length; i++) {
            int i2 = (d[i] + 256) % 256;
            this.f4607d[i2] = i;
            this.f4608e.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7212b(C1575w wVar, int i) {
        long k = wVar.mo7358k();
        long k2 = wVar.mo7358k();
        if (k2 <= 2147483647L) {
            if (k >= 0 && k <= 1114111) {
                long j = k + k2;
                if (j <= 1114111 && (j < 55296 || j > 57343)) {
                    return;
                }
            }
            throw new IOException("Invalid Characters codes");
        }
        throw new IOException("Invalid number of Characters");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7213c(C1575w wVar, int i) {
        long j;
        int i2 = i;
        long k = wVar.mo7358k();
        this.f4607d = m5966b(i2);
        long j2 = 0;
        long j3 = 0;
        while (j3 < k) {
            long k2 = wVar.mo7358k();
            long k3 = wVar.mo7358k();
            long k4 = wVar.mo7358k();
            if (k2 < j2 || k2 > 1114111 || (k2 >= 55296 && k2 <= 57343)) {
                throw new IOException("Invalid characters codes");
            } else if ((k3 <= j2 || k3 >= k2) && k3 <= 1114111 && (k3 < 55296 || k3 > 57343)) {
                long j4 = j2;
                while (j4 <= k3 - k2) {
                    long j5 = k4 + j4;
                    if (j5 < ((long) i2)) {
                        long j6 = k2 + j4;
                        if (j6 > 1114111) {
                            j = k;
                            Log.w("PdfBox-Android", "Format 12 cmap contains character beyond UCS-4");
                        } else {
                            j = k;
                        }
                        int i3 = (int) j5;
                        int i4 = (int) j6;
                        this.f4607d[i3] = i4;
                        this.f4608e.put(Integer.valueOf(i4), Integer.valueOf(i3));
                        j4++;
                        k = j;
                        i2 = i;
                    } else {
                        throw new IOException("Character Code greater than Integer.MAX_VALUE");
                    }
                }
                long j7 = k;
                j3++;
                i2 = i;
                j2 = 0;
            } else {
                throw new IOException("Invalid characters codes");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo7214d(C1575w wVar, int i) {
        long k = wVar.mo7358k();
        long j = 0;
        long j2 = 0;
        while (j2 < k) {
            long k2 = wVar.mo7358k();
            long k3 = wVar.mo7358k();
            long k4 = wVar.mo7358k();
            if (k4 > ((long) i)) {
                Log.w("PdfBox-Android", "Format 13 cmap contains an invalid glyph index");
                return;
            }
            if (k2 >= j) {
                long j3 = 1114111;
                if (k2 <= 1114111 && (k2 < 55296 || k2 > 57343)) {
                    if ((k3 <= j || k3 >= k2) && k3 <= 1114111 && (k3 < 55296 || k3 > 57343)) {
                        long j4 = j;
                        while (j4 <= k3 - k2) {
                            long j5 = k2 + j4;
                            if (j5 <= 2147483647L) {
                                if (j5 > j3) {
                                    Log.w("PdfBox-Android", "Format 13 cmap contains character beyond UCS-4");
                                }
                                int i2 = (int) k4;
                                int i3 = (int) j5;
                                this.f4607d[i2] = i3;
                                this.f4608e.put(Integer.valueOf(i3), Integer.valueOf(i2));
                                j4++;
                                j3 = 1114111;
                            } else {
                                throw new IOException("Character Code greater than Integer.MAX_VALUE");
                            }
                        }
                        j2++;
                        j = 0;
                    } else {
                        throw new IOException("Invalid Characters codes");
                    }
                }
            }
            throw new IOException("Invalid Characters codes");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo7215e(C1575w wVar, int i) {
        Log.w("PdfBox-Android", "Format 14 cmap table is not supported and will be ignored");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo7216f(C1575w wVar, int i) {
        int d = wVar.mo7281d();
        int d2 = wVar.mo7281d();
        HashMap hashMap = new HashMap();
        int[] c = wVar.mo7353c(d2);
        for (int i2 = 0; i2 < d2; i2++) {
            int i3 = d + i2;
            hashMap.put(Integer.valueOf(c[i2]), Integer.valueOf(i3));
            this.f4608e.put(Integer.valueOf(i3), Integer.valueOf(c[i2]));
        }
        this.f4607d = m5966b(((Integer) Collections.max(hashMap.keySet())).intValue() + 1);
        for (Map.Entry entry : hashMap.entrySet()) {
            this.f4607d[((Integer) entry.getKey()).intValue()] = ((Integer) entry.getValue()).intValue();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo7217g(C1575w wVar, int i) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        C1575w wVar2 = wVar;
        int d = wVar.mo7281d() / 2;
        wVar.mo7281d();
        wVar.mo7281d();
        wVar.mo7281d();
        int[] c = wVar2.mo7353c(d);
        wVar.mo7281d();
        int[] c2 = wVar2.mo7353c(d);
        int[] c3 = wVar2.mo7353c(d);
        int[] c4 = wVar2.mo7353c(d);
        HashMap hashMap = new HashMap();
        long f = wVar.mo7283f();
        int i2 = 0;
        while (i2 < d) {
            int i3 = c2[i2];
            int i4 = c[i2];
            int i5 = c3[i2];
            int i6 = c4[i2];
            if (!(i3 == 65535 || i4 == 65535)) {
                int i7 = i3;
                while (i7 <= i4) {
                    if (i6 == 0) {
                        int i8 = (i7 + i5) % PKIFailureInfo.notAuthorized;
                        iArr = c;
                        iArr3 = c2;
                        hashMap.put(Integer.valueOf(i8), Integer.valueOf(i7));
                        iArr2 = c3;
                        this.f4608e.put(Integer.valueOf(i7), Integer.valueOf(i8));
                    } else {
                        iArr = c;
                        iArr3 = c2;
                        iArr2 = c3;
                        wVar2.mo7277a(((long) (((i6 / 2) + (i7 - i3) + (i2 - d)) * 2)) + f);
                        int d2 = wVar.mo7281d();
                        if (d2 != 0) {
                            int i9 = (d2 + i5) % PKIFailureInfo.notAuthorized;
                            if (!hashMap.containsKey(Integer.valueOf(i9))) {
                                hashMap.put(Integer.valueOf(i9), Integer.valueOf(i7));
                                this.f4608e.put(Integer.valueOf(i7), Integer.valueOf(i9));
                            }
                        }
                    }
                    i7++;
                    c = iArr;
                    c2 = iArr3;
                    c3 = iArr2;
                }
            }
            i2++;
            c = c;
            c2 = c2;
            c3 = c3;
        }
        if (hashMap.isEmpty()) {
            Log.w("PdfBox-Android", "cmap format 4 subtable is empty");
            return;
        }
        this.f4607d = m5966b(((Integer) Collections.max(hashMap.keySet())).intValue() + 1);
        for (Map.Entry entry : hashMap.entrySet()) {
            this.f4607d[((Integer) entry.getKey()).intValue()] = ((Integer) entry.getValue()).intValue();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo7218h(C1575w wVar, int i) {
        int[] iArr = new int[256];
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            iArr[i3] = wVar.mo7281d();
            i2 = Math.max(i2, iArr[i3] / 8);
        }
        int i4 = i2 + 1;
        C1551a[] aVarArr = new C1551a[i4];
        for (int i5 = 0; i5 <= i2; i5++) {
            aVarArr[i5] = new C1551a(wVar.mo7281d(), wVar.mo7281d(), wVar.mo7282e(), (wVar.mo7281d() - (((i4 - i5) - 1) * 8)) - 2);
        }
        long f = wVar.mo7283f();
        this.f4607d = m5966b(i);
        for (int i6 = 0; i6 <= i2; i6++) {
            C1551a aVar = aVarArr[i6];
            int a = aVar.m5981a();
            int b = aVar.m5987d();
            short c = aVar.m5985c();
            int d = aVar.m5983b();
            wVar.mo7277a(((long) b) + f);
            for (int i7 = 0; i7 < d; i7++) {
                int i8 = (i6 << 8) + a + i7;
                int d2 = wVar.mo7281d();
                if (d2 > 0) {
                    d2 = (d2 + c) % PKIFailureInfo.notAuthorized;
                }
                this.f4607d[d2] = i8;
                this.f4608e.put(Integer.valueOf(i8), Integer.valueOf(d2));
            }
        }
    }

    public String toString() {
        return "{" + mo7210b() + " " + mo7205a() + "}";
    }
}
