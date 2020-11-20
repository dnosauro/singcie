package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.ap */
class C0287ap {

    /* renamed from: a */
    private int f1026a = 0;

    /* renamed from: b */
    private int f1027b = 0;

    /* renamed from: c */
    private int f1028c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f1029d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f1030e = 0;

    /* renamed from: f */
    private int f1031f = 0;

    /* renamed from: g */
    private boolean f1032g = false;

    /* renamed from: h */
    private boolean f1033h = false;

    C0287ap() {
    }

    /* renamed from: a */
    public int mo2300a() {
        return this.f1026a;
    }

    /* renamed from: a */
    public void mo2301a(int i, int i2) {
        this.f1028c = i;
        this.f1029d = i2;
        this.f1033h = true;
        if (this.f1032g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1026a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1027b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1026a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1027b = i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2302a(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f1032g
            if (r2 != r0) goto L_0x0005
            return
        L_0x0005:
            r1.f1032g = r2
            boolean r0 = r1.f1033h
            if (r0 == 0) goto L_0x002b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x001d
            int r2 = r1.f1029d
            if (r2 == r0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            int r2 = r1.f1030e
        L_0x0016:
            r1.f1026a = r2
            int r2 = r1.f1028c
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x001d:
            int r2 = r1.f1028c
            if (r2 == r0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            int r2 = r1.f1030e
        L_0x0024:
            r1.f1026a = r2
            int r2 = r1.f1029d
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x002b:
            int r2 = r1.f1030e
            r1.f1026a = r2
        L_0x002f:
            int r2 = r1.f1031f
        L_0x0031:
            r1.f1027b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0287ap.mo2302a(boolean):void");
    }

    /* renamed from: b */
    public int mo2303b() {
        return this.f1027b;
    }

    /* renamed from: b */
    public void mo2304b(int i, int i2) {
        this.f1033h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1030e = i;
            this.f1026a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1031f = i2;
            this.f1027b = i2;
        }
    }

    /* renamed from: c */
    public int mo2305c() {
        return this.f1032g ? this.f1027b : this.f1026a;
    }

    /* renamed from: d */
    public int mo2306d() {
        return this.f1032g ? this.f1026a : this.f1027b;
    }
}
