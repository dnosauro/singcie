package com.cyberneid.p089b.p095f;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Comparator;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.b.f.j */
public class C1559j {

    /* renamed from: a */
    private boolean f4658a;

    /* renamed from: b */
    private boolean f4659b;

    /* renamed from: c */
    private boolean f4660c;

    /* renamed from: d */
    private C1561a f4661d;

    /* renamed from: com.cyberneid.b.f.j$a */
    private static abstract class C1561a {
        private C1561a() {
        }

        /* renamed from: a */
        public abstract void mo7258a(C1575w wVar);
    }

    /* renamed from: com.cyberneid.b.f.j$b */
    private static class C1562b extends C1561a implements Comparator<int[]> {

        /* renamed from: a */
        static final /* synthetic */ boolean f4662a = (!C1559j.class.desiredAssertionStatus());

        /* renamed from: b */
        private int f4663b;

        /* renamed from: c */
        private int[][] f4664c;

        private C1562b() {
            super();
        }

        /* renamed from: a */
        public int compare(int[] iArr, int[] iArr2) {
            if (!f4662a && iArr == null) {
                throw new AssertionError();
            } else if (!f4662a && iArr.length < 2) {
                throw new AssertionError();
            } else if (!f4662a && iArr2 == null) {
                throw new AssertionError();
            } else if (f4662a || iArr2.length >= 2) {
                int i = iArr[0];
                int i2 = iArr2[0];
                if (i < i2) {
                    return -1;
                }
                if (i > i2) {
                    return 1;
                }
                int i3 = iArr[1];
                int i4 = iArr2[1];
                if (i3 < i4) {
                    return -1;
                }
                return i3 > i4 ? 1 : 0;
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public void mo7258a(C1575w wVar) {
            int d = wVar.mo7281d();
            this.f4663b = wVar.mo7281d() / 6;
            wVar.mo7281d();
            wVar.mo7281d();
            this.f4664c = (int[][]) Array.newInstance(int.class, new int[]{d, 3});
            for (int i = 0; i < d; i++) {
                int d2 = wVar.mo7281d();
                int d3 = wVar.mo7281d();
                int e = wVar.mo7282e();
                int[][] iArr = this.f4664c;
                iArr[i][0] = d2;
                iArr[i][1] = d3;
                iArr[i][2] = e;
            }
        }
    }

    C1559j() {
    }

    /* renamed from: a */
    private void m6032a(C1575w wVar) {
        int d = wVar.mo7281d();
        if (d == 0) {
            int d2 = wVar.mo7281d();
            if (d2 >= 6) {
                int d3 = wVar.mo7281d();
                if (m6033a(d3, 1, 0)) {
                    this.f4658a = true;
                }
                if (m6033a(d3, 2, 1)) {
                    this.f4659b = true;
                }
                if (m6033a(d3, 4, 2)) {
                    this.f4660c = true;
                }
                int b = m6034b(d3, CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB, 8);
                if (b == 0) {
                    m6035b(wVar);
                } else if (b == 2) {
                    m6036c(wVar);
                } else {
                    Log.d("PdfBox-Android", "Skipped kerning subtable due to an unsupported kerning subtable version: " + b);
                }
            } else {
                throw new IOException("Kerning sub-table too short, got " + d2 + " bytes, expect 6 or more.");
            }
        } else {
            throw new UnsupportedOperationException("Unsupported kerning sub-table version: " + d);
        }
    }

    /* renamed from: a */
    private static boolean m6033a(int i, int i2, int i3) {
        return m6034b(i, i2, i3) != 0;
    }

    /* renamed from: b */
    private static int m6034b(int i, int i2, int i3) {
        return (i & i2) >> i3;
    }

    /* renamed from: b */
    private void m6035b(C1575w wVar) {
        this.f4661d = new C1562b();
        this.f4661d.mo7258a(wVar);
    }

    /* renamed from: c */
    private void m6036c(C1575w wVar) {
        throw new UnsupportedOperationException("Kerning table version 0 format 2 not yet supported.");
    }

    /* renamed from: d */
    private void m6037d(C1575w wVar) {
        throw new UnsupportedOperationException("Kerning table version 1 formats not yet supported.");
    }

    /* renamed from: a */
    public void mo7257a(C1575w wVar, int i) {
        if (i == 0) {
            m6032a(wVar);
        } else if (i == 1) {
            m6037d(wVar);
        } else {
            throw new IllegalStateException();
        }
    }
}
