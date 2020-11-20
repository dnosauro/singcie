package androidx.constraintlayout.p019a;

import java.util.Arrays;

/* renamed from: androidx.constraintlayout.a.h */
public class C0450h {

    /* renamed from: j */
    private static int f1680j = 1;

    /* renamed from: k */
    private static int f1681k = 1;

    /* renamed from: l */
    private static int f1682l = 1;

    /* renamed from: m */
    private static int f1683m = 1;

    /* renamed from: n */
    private static int f1684n = 1;

    /* renamed from: a */
    public int f1685a = -1;

    /* renamed from: b */
    int f1686b = -1;

    /* renamed from: c */
    public int f1687c = 0;

    /* renamed from: d */
    public float f1688d;

    /* renamed from: e */
    float[] f1689e = new float[7];

    /* renamed from: f */
    C0451a f1690f;

    /* renamed from: g */
    C0441b[] f1691g = new C0441b[8];

    /* renamed from: h */
    int f1692h = 0;

    /* renamed from: i */
    public int f1693i = 0;

    /* renamed from: o */
    private String f1694o;

    /* renamed from: androidx.constraintlayout.a.h$a */
    public enum C0451a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public C0450h(C0451a aVar, String str) {
        this.f1690f = aVar;
    }

    /* renamed from: a */
    static void m1851a() {
        f1681k++;
    }

    /* renamed from: a */
    public final void mo3203a(C0441b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.f1692h;
            if (i >= i2) {
                C0441b[] bVarArr = this.f1691g;
                if (i2 >= bVarArr.length) {
                    this.f1691g = (C0441b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                C0441b[] bVarArr2 = this.f1691g;
                int i3 = this.f1692h;
                bVarArr2[i3] = bVar;
                this.f1692h = i3 + 1;
                return;
            } else if (this.f1691g[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo3204a(C0451a aVar, String str) {
        this.f1690f = aVar;
    }

    /* renamed from: b */
    public void mo3205b() {
        this.f1694o = null;
        this.f1690f = C0451a.UNKNOWN;
        this.f1687c = 0;
        this.f1685a = -1;
        this.f1686b = -1;
        this.f1688d = 0.0f;
        this.f1692h = 0;
        this.f1693i = 0;
    }

    /* renamed from: b */
    public final void mo3206b(C0441b bVar) {
        int i = this.f1692h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f1691g[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    C0441b[] bVarArr = this.f1691g;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.f1692h--;
                return;
            }
        }
    }

    /* renamed from: c */
    public final void mo3207c(C0441b bVar) {
        int i = this.f1692h;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1691g[i2].f1625d.mo2987a(this.f1691g[i2], bVar, false);
        }
        this.f1692h = 0;
    }

    public String toString() {
        return "" + this.f1694o;
    }
}
