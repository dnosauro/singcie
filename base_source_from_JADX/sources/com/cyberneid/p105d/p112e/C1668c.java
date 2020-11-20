package com.cyberneid.p105d.p112e;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.e.c */
class C1668c extends BufferedOutputStream {

    /* renamed from: a */
    private boolean f5533a = false;

    /* renamed from: b */
    private boolean f5534b = false;

    /* renamed from: c */
    private int f5535c = 0;

    /* renamed from: d */
    private boolean f5536d = true;

    C1668c(OutputStream outputStream) {
        super(outputStream);
    }

    public void flush() {
        if (this.f5533a && !this.f5534b) {
            super.write(13);
            this.f5535c++;
        }
        this.f5533a = false;
        this.f5534b = false;
        super.flush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
        if (r8[(r9 + r10) - 1] == 13) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(byte[] r8, int r9, int r10) {
        /*
            r7 = this;
            int r0 = r7.f5535c
            r1 = 13
            r2 = 0
            r3 = 10
            r4 = 1
            if (r0 != 0) goto L_0x002b
            if (r10 <= r3) goto L_0x002b
            r7.f5536d = r2
            r0 = 0
        L_0x000f:
            if (r0 >= r3) goto L_0x002b
            byte r5 = r8[r0]
            r6 = 9
            if (r5 < r6) goto L_0x0029
            byte r5 = r8[r0]
            if (r5 <= r3) goto L_0x0026
            byte r5 = r8[r0]
            r6 = 32
            if (r5 >= r6) goto L_0x0026
            byte r5 = r8[r0]
            if (r5 == r1) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            int r0 = r0 + 1
            goto L_0x000f
        L_0x0029:
            r7.f5536d = r4
        L_0x002b:
            boolean r0 = r7.f5536d
            if (r0 == 0) goto L_0x006c
            boolean r0 = r7.f5533a
            if (r0 == 0) goto L_0x0043
            r7.f5533a = r2
            boolean r0 = r7.f5534b
            if (r0 != 0) goto L_0x0040
            if (r10 != r4) goto L_0x0040
            byte r0 = r8[r9]
            if (r0 != r3) goto L_0x0040
            return
        L_0x0040:
            super.write(r1)
        L_0x0043:
            boolean r0 = r7.f5534b
            if (r0 == 0) goto L_0x004c
            super.write(r3)
            r7.f5534b = r2
        L_0x004c:
            if (r10 <= 0) goto L_0x006c
            int r0 = r9 + r10
            int r0 = r0 - r4
            byte r2 = r8[r0]
            if (r2 != r1) goto L_0x005a
        L_0x0055:
            r7.f5533a = r4
            int r10 = r10 + -1
            goto L_0x006c
        L_0x005a:
            byte r0 = r8[r0]
            if (r0 != r3) goto L_0x006c
            r7.f5534b = r4
            int r10 = r10 + -1
            if (r10 <= 0) goto L_0x006c
            int r0 = r9 + r10
            int r0 = r0 - r4
            byte r0 = r8[r0]
            if (r0 != r1) goto L_0x006c
            goto L_0x0055
        L_0x006c:
            super.write(r8, r9, r10)
            int r8 = r7.f5535c
            int r8 = r8 + r10
            r7.f5535c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1668c.write(byte[], int, int):void");
    }
}
