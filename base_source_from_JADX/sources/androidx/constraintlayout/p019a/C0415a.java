package androidx.constraintlayout.p019a;

import androidx.constraintlayout.p019a.C0450h;
import java.util.Arrays;

/* renamed from: androidx.constraintlayout.a.a */
public class C0415a {

    /* renamed from: a */
    int f1410a = 0;

    /* renamed from: b */
    private final C0441b f1411b;

    /* renamed from: c */
    private final C0442c f1412c;

    /* renamed from: d */
    private int f1413d = 8;

    /* renamed from: e */
    private C0450h f1414e = null;

    /* renamed from: f */
    private int[] f1415f;

    /* renamed from: g */
    private int[] f1416g;

    /* renamed from: h */
    private float[] f1417h;

    /* renamed from: i */
    private int f1418i;

    /* renamed from: j */
    private int f1419j;

    /* renamed from: k */
    private boolean f1420k;

    C0415a(C0441b bVar, C0442c cVar) {
        int i = this.f1413d;
        this.f1415f = new int[i];
        this.f1416g = new int[i];
        this.f1417h = new float[i];
        this.f1418i = -1;
        this.f1419j = -1;
        this.f1420k = false;
        this.f1411b = bVar;
        this.f1412c = cVar;
    }

    /* renamed from: a */
    private boolean m1560a(C0450h hVar, C0444e eVar) {
        return hVar.f1693i <= 1;
    }

    /* renamed from: a */
    public final float mo2981a(C0450h hVar, boolean z) {
        if (this.f1414e == hVar) {
            this.f1414e = null;
        }
        int i = this.f1418i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f1410a) {
            if (this.f1415f[i] == hVar.f1685a) {
                if (i == this.f1418i) {
                    this.f1418i = this.f1416g[i];
                } else {
                    int[] iArr = this.f1416g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    hVar.mo3206b(this.f1411b);
                }
                hVar.f1693i--;
                this.f1410a--;
                this.f1415f[i] = -1;
                if (this.f1420k) {
                    this.f1419j = i;
                }
                return this.f1417h[i];
            }
            i2++;
            i3 = i;
            i = this.f1416g[i];
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0450h mo2982a(int i) {
        int i2 = this.f1418i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1410a) {
            if (i3 == i) {
                return this.f1412c.f1629c[this.f1415f[i2]];
            }
            i2 = this.f1416g[i2];
            i3++;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.p019a.C0450h mo2983a(androidx.constraintlayout.p019a.C0444e r15) {
        /*
            r14 = this;
            int r0 = r14.f1418i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000a:
            r9 = -1
            if (r0 == r9) goto L_0x008e
            int r9 = r14.f1410a
            if (r2 >= r9) goto L_0x008e
            float[] r9 = r14.f1417h
            r9 = r9[r0]
            r10 = 981668463(0x3a83126f, float:0.001)
            androidx.constraintlayout.a.c r11 = r14.f1412c
            androidx.constraintlayout.a.h[] r11 = r11.f1629c
            int[] r12 = r14.f1415f
            r12 = r12[r0]
            r11 = r11[r12]
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0032
            r10 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0040
            float[] r9 = r14.f1417h
            r9[r0] = r3
            goto L_0x003a
        L_0x0032:
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0040
            float[] r9 = r14.f1417h
            r9[r0] = r3
        L_0x003a:
            androidx.constraintlayout.a.b r9 = r14.f1411b
            r11.mo3206b(r9)
            r9 = 0
        L_0x0040:
            r10 = 1
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x0086
            androidx.constraintlayout.a.h$a r12 = r11.f1690f
            androidx.constraintlayout.a.h$a r13 = androidx.constraintlayout.p019a.C0450h.C0451a.UNRESTRICTED
            if (r12 != r13) goto L_0x0066
            if (r4 != 0) goto L_0x0055
        L_0x004d:
            boolean r4 = r14.m1560a((androidx.constraintlayout.p019a.C0450h) r11, (androidx.constraintlayout.p019a.C0444e) r15)
            r6 = r4
            r5 = r9
            r4 = r11
            goto L_0x0086
        L_0x0055:
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x005a
            goto L_0x004d
        L_0x005a:
            if (r6 != 0) goto L_0x0086
            boolean r12 = r14.m1560a((androidx.constraintlayout.p019a.C0450h) r11, (androidx.constraintlayout.p019a.C0444e) r15)
            if (r12 == 0) goto L_0x0086
            r5 = r9
            r4 = r11
            r6 = 1
            goto L_0x0086
        L_0x0066:
            if (r4 != 0) goto L_0x0086
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0086
            if (r1 != 0) goto L_0x0076
        L_0x006e:
            boolean r1 = r14.m1560a((androidx.constraintlayout.p019a.C0450h) r11, (androidx.constraintlayout.p019a.C0444e) r15)
            r8 = r1
            r7 = r9
            r1 = r11
            goto L_0x0086
        L_0x0076:
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x007b
            goto L_0x006e
        L_0x007b:
            if (r8 != 0) goto L_0x0086
            boolean r12 = r14.m1560a((androidx.constraintlayout.p019a.C0450h) r11, (androidx.constraintlayout.p019a.C0444e) r15)
            if (r12 == 0) goto L_0x0086
            r7 = r9
            r1 = r11
            r8 = 1
        L_0x0086:
            int[] r9 = r14.f1416g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto L_0x000a
        L_0x008e:
            if (r4 == 0) goto L_0x0091
            return r4
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.C0415a.mo2983a(androidx.constraintlayout.a.e):androidx.constraintlayout.a.h");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0450h mo2984a(boolean[] zArr, C0450h hVar) {
        int i = this.f1418i;
        int i2 = 0;
        C0450h hVar2 = null;
        float f = 0.0f;
        while (i != -1 && i2 < this.f1410a) {
            if (this.f1417h[i] < 0.0f) {
                C0450h hVar3 = this.f1412c.f1629c[this.f1415f[i]];
                if ((zArr == null || !zArr[hVar3.f1685a]) && hVar3 != hVar && (hVar3.f1690f == C0450h.C0451a.SLACK || hVar3.f1690f == C0450h.C0451a.ERROR)) {
                    float f2 = this.f1417h[i];
                    if (f2 < f) {
                        hVar2 = hVar3;
                        f = f2;
                    }
                }
            }
            i = this.f1416g[i];
            i2++;
        }
        return hVar2;
    }

    /* renamed from: a */
    public final void mo2985a() {
        int i = this.f1418i;
        int i2 = 0;
        while (i != -1 && i2 < this.f1410a) {
            C0450h hVar = this.f1412c.f1629c[this.f1415f[i]];
            if (hVar != null) {
                hVar.mo3206b(this.f1411b);
            }
            i = this.f1416g[i];
            i2++;
        }
        this.f1418i = -1;
        this.f1419j = -1;
        this.f1420k = false;
        this.f1410a = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2986a(float f) {
        int i = this.f1418i;
        int i2 = 0;
        while (i != -1 && i2 < this.f1410a) {
            float[] fArr = this.f1417h;
            fArr[i] = fArr[i] / f;
            i = this.f1416g[i];
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo2987a(C0441b bVar, C0441b bVar2, boolean z) {
        int i = this.f1418i;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.f1410a) {
                if (this.f1415f[i] == bVar2.f1622a.f1685a) {
                    float f = this.f1417h[i];
                    mo2981a(bVar2.f1622a, z);
                    C0415a aVar = bVar2.f1625d;
                    int i3 = aVar.f1418i;
                    int i4 = 0;
                    while (i3 != -1 && i4 < aVar.f1410a) {
                        mo2990a(this.f1412c.f1629c[aVar.f1415f[i3]], aVar.f1417h[i3] * f, z);
                        i3 = aVar.f1416g[i3];
                        i4++;
                    }
                    bVar.f1623b += bVar2.f1623b * f;
                    if (z) {
                        bVar2.f1622a.mo3206b(bVar);
                    }
                    i = this.f1418i;
                } else {
                    i = this.f1416g[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2988a(C0441b bVar, C0441b[] bVarArr) {
        int i = this.f1418i;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.f1410a) {
                C0450h hVar = this.f1412c.f1629c[this.f1415f[i]];
                if (hVar.f1686b != -1) {
                    float f = this.f1417h[i];
                    mo2981a(hVar, true);
                    C0441b bVar2 = bVarArr[hVar.f1686b];
                    if (!bVar2.f1626e) {
                        C0415a aVar = bVar2.f1625d;
                        int i3 = aVar.f1418i;
                        int i4 = 0;
                        while (i3 != -1 && i4 < aVar.f1410a) {
                            mo2990a(this.f1412c.f1629c[aVar.f1415f[i3]], aVar.f1417h[i3] * f, true);
                            i3 = aVar.f1416g[i3];
                            i4++;
                        }
                    }
                    bVar.f1623b += bVar2.f1623b * f;
                    bVar2.f1622a.mo3206b(bVar);
                    i = this.f1418i;
                } else {
                    i = this.f1416g[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* renamed from: a */
    public final void mo2989a(C0450h hVar, float f) {
        if (f == 0.0f) {
            mo2981a(hVar, true);
            return;
        }
        int i = this.f1418i;
        if (i == -1) {
            this.f1418i = 0;
            float[] fArr = this.f1417h;
            int i2 = this.f1418i;
            fArr[i2] = f;
            this.f1415f[i2] = hVar.f1685a;
            this.f1416g[this.f1418i] = -1;
            hVar.f1693i++;
            hVar.mo3203a(this.f1411b);
            this.f1410a++;
            if (!this.f1420k) {
                this.f1419j++;
                int i3 = this.f1419j;
                int[] iArr = this.f1415f;
                if (i3 >= iArr.length) {
                    this.f1420k = true;
                    this.f1419j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i != -1 && i4 < this.f1410a) {
            if (this.f1415f[i] == hVar.f1685a) {
                this.f1417h[i] = f;
                return;
            }
            if (this.f1415f[i] < hVar.f1685a) {
                i5 = i;
            }
            i = this.f1416g[i];
            i4++;
        }
        int i6 = this.f1419j;
        int i7 = i6 + 1;
        if (this.f1420k) {
            int[] iArr2 = this.f1415f;
            if (iArr2[i6] != -1) {
                i6 = iArr2.length;
            }
        } else {
            i6 = i7;
        }
        int[] iArr3 = this.f1415f;
        if (i6 >= iArr3.length && this.f1410a < iArr3.length) {
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.f1415f;
                if (i8 >= iArr4.length) {
                    break;
                } else if (iArr4[i8] == -1) {
                    i6 = i8;
                    break;
                } else {
                    i8++;
                }
            }
        }
        int[] iArr5 = this.f1415f;
        if (i6 >= iArr5.length) {
            i6 = iArr5.length;
            this.f1413d *= 2;
            this.f1420k = false;
            this.f1419j = i6 - 1;
            this.f1417h = Arrays.copyOf(this.f1417h, this.f1413d);
            this.f1415f = Arrays.copyOf(this.f1415f, this.f1413d);
            this.f1416g = Arrays.copyOf(this.f1416g, this.f1413d);
        }
        this.f1415f[i6] = hVar.f1685a;
        this.f1417h[i6] = f;
        if (i5 != -1) {
            int[] iArr6 = this.f1416g;
            iArr6[i6] = iArr6[i5];
            iArr6[i5] = i6;
        } else {
            this.f1416g[i6] = this.f1418i;
            this.f1418i = i6;
        }
        hVar.f1693i++;
        hVar.mo3203a(this.f1411b);
        this.f1410a++;
        if (!this.f1420k) {
            this.f1419j++;
        }
        if (this.f1410a >= this.f1415f.length) {
            this.f1420k = true;
        }
        int i9 = this.f1419j;
        int[] iArr7 = this.f1415f;
        if (i9 >= iArr7.length) {
            this.f1420k = true;
            this.f1419j = iArr7.length - 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo2990a(C0450h hVar, float f, boolean z) {
        if (f != 0.0f) {
            int i = this.f1418i;
            if (i == -1) {
                this.f1418i = 0;
                float[] fArr = this.f1417h;
                int i2 = this.f1418i;
                fArr[i2] = f;
                this.f1415f[i2] = hVar.f1685a;
                this.f1416g[this.f1418i] = -1;
                hVar.f1693i++;
                hVar.mo3203a(this.f1411b);
                this.f1410a++;
                if (!this.f1420k) {
                    this.f1419j++;
                    int i3 = this.f1419j;
                    int[] iArr = this.f1415f;
                    if (i3 >= iArr.length) {
                        this.f1420k = true;
                        this.f1419j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i != -1 && i4 < this.f1410a) {
                if (this.f1415f[i] == hVar.f1685a) {
                    float[] fArr2 = this.f1417h;
                    fArr2[i] = fArr2[i] + f;
                    if (fArr2[i] == 0.0f) {
                        if (i == this.f1418i) {
                            this.f1418i = this.f1416g[i];
                        } else {
                            int[] iArr2 = this.f1416g;
                            iArr2[i5] = iArr2[i];
                        }
                        if (z) {
                            hVar.mo3206b(this.f1411b);
                        }
                        if (this.f1420k) {
                            this.f1419j = i;
                        }
                        hVar.f1693i--;
                        this.f1410a--;
                        return;
                    }
                    return;
                }
                if (this.f1415f[i] < hVar.f1685a) {
                    i5 = i;
                }
                i = this.f1416g[i];
                i4++;
            }
            int i6 = this.f1419j;
            int i7 = i6 + 1;
            if (this.f1420k) {
                int[] iArr3 = this.f1415f;
                if (iArr3[i6] != -1) {
                    i6 = iArr3.length;
                }
            } else {
                i6 = i7;
            }
            int[] iArr4 = this.f1415f;
            if (i6 >= iArr4.length && this.f1410a < iArr4.length) {
                int i8 = 0;
                while (true) {
                    int[] iArr5 = this.f1415f;
                    if (i8 >= iArr5.length) {
                        break;
                    } else if (iArr5[i8] == -1) {
                        i6 = i8;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            int[] iArr6 = this.f1415f;
            if (i6 >= iArr6.length) {
                i6 = iArr6.length;
                this.f1413d *= 2;
                this.f1420k = false;
                this.f1419j = i6 - 1;
                this.f1417h = Arrays.copyOf(this.f1417h, this.f1413d);
                this.f1415f = Arrays.copyOf(this.f1415f, this.f1413d);
                this.f1416g = Arrays.copyOf(this.f1416g, this.f1413d);
            }
            this.f1415f[i6] = hVar.f1685a;
            this.f1417h[i6] = f;
            if (i5 != -1) {
                int[] iArr7 = this.f1416g;
                iArr7[i6] = iArr7[i5];
                iArr7[i5] = i6;
            } else {
                this.f1416g[i6] = this.f1418i;
                this.f1418i = i6;
            }
            hVar.f1693i++;
            hVar.mo3203a(this.f1411b);
            this.f1410a++;
            if (!this.f1420k) {
                this.f1419j++;
            }
            int i9 = this.f1419j;
            int[] iArr8 = this.f1415f;
            if (i9 >= iArr8.length) {
                this.f1420k = true;
                this.f1419j = iArr8.length - 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo2991a(C0450h hVar) {
        int i = this.f1418i;
        if (i == -1) {
            return false;
        }
        int i2 = 0;
        while (i != -1 && i2 < this.f1410a) {
            if (this.f1415f[i] == hVar.f1685a) {
                return true;
            }
            i = this.f1416g[i];
            i2++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final float mo2992b(int i) {
        int i2 = this.f1418i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1410a) {
            if (i3 == i) {
                return this.f1417h[i2];
            }
            i2 = this.f1416g[i2];
            i3++;
        }
        return 0.0f;
    }

    /* renamed from: b */
    public final float mo2993b(C0450h hVar) {
        int i = this.f1418i;
        int i2 = 0;
        while (i != -1 && i2 < this.f1410a) {
            if (this.f1415f[i] == hVar.f1685a) {
                return this.f1417h[i];
            }
            i = this.f1416g[i];
            i2++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2994b() {
        int i = this.f1418i;
        int i2 = 0;
        while (i != -1 && i2 < this.f1410a) {
            float[] fArr = this.f1417h;
            fArr[i] = fArr[i] * -1.0f;
            i = this.f1416g[i];
            i2++;
        }
    }

    public String toString() {
        String str = "";
        int i = this.f1418i;
        int i2 = 0;
        while (i != -1 && i2 < this.f1410a) {
            str = ((str + " -> ") + this.f1417h[i] + " : ") + this.f1412c.f1629c[this.f1415f[i]];
            i = this.f1416g[i];
            i2++;
        }
        return str;
    }
}
