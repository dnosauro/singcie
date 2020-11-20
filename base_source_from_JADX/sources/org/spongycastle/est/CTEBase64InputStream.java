package org.spongycastle.est;

import java.io.InputStream;
import java.io.OutputStream;

class CTEBase64InputStream extends InputStream {
    protected final byte[] data = new byte[768];
    protected final OutputStream dataOutputStream;
    protected boolean end;
    protected final Long max;
    protected final byte[] rawBuf = new byte[1024];
    protected long read;

    /* renamed from: rp */
    protected int f7917rp;
    protected final InputStream src;

    /* renamed from: wp */
    protected int f7918wp;

    public CTEBase64InputStream(InputStream inputStream, Long l) {
        this.src = inputStream;
        this.dataOutputStream = new OutputStream() {
            public void write(int i) {
                byte[] bArr = CTEBase64InputStream.this.data;
                CTEBase64InputStream cTEBase64InputStream = CTEBase64InputStream.this;
                int i2 = cTEBase64InputStream.f7918wp;
                cTEBase64InputStream.f7918wp = i2 + 1;
                bArr[i2] = (byte) i;
            }
        };
        this.max = l;
    }

    public void close() {
        this.src.close();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A[SYNTHETIC, Splitter:B:21:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int pullFromSrc() {
        /*
            r11 = this;
            long r0 = r11.read
            java.lang.Long r2 = r11.max
            long r2 = r2.longValue()
            r4 = -1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x000e
            return r4
        L_0x000e:
            r0 = 0
            r1 = 0
        L_0x0010:
            java.io.InputStream r2 = r11.src
            int r2 = r2.read()
            r3 = 33
            r5 = 10
            r6 = 1
            if (r2 >= r3) goto L_0x002d
            r3 = 13
            if (r2 == r3) goto L_0x002d
            if (r2 != r5) goto L_0x0025
            goto L_0x002d
        L_0x0025:
            if (r2 < 0) goto L_0x003d
            long r8 = r11.read
            long r8 = r8 + r6
            r11.read = r8
            goto L_0x003d
        L_0x002d:
            byte[] r3 = r11.rawBuf
            int r8 = r3.length
            if (r1 >= r8) goto L_0x007a
            int r8 = r1 + 1
            byte r9 = (byte) r2
            r3[r1] = r9
            long r9 = r11.read
            long r9 = r9 + r6
            r11.read = r9
            r1 = r8
        L_0x003d:
            if (r2 <= r4) goto L_0x0052
            byte[] r3 = r11.rawBuf
            int r3 = r3.length
            if (r1 >= r3) goto L_0x0052
            if (r2 == r5) goto L_0x0052
            long r5 = r11.read
            java.lang.Long r3 = r11.max
            long r7 = r3.longValue()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0010
        L_0x0052:
            if (r1 <= 0) goto L_0x0074
            byte[] r2 = r11.rawBuf     // Catch:{ Exception -> 0x005c }
            java.io.OutputStream r3 = r11.dataOutputStream     // Catch:{ Exception -> 0x005c }
            org.spongycastle.util.encoders.Base64.decode(r2, r0, r1, r3)     // Catch:{ Exception -> 0x005c }
            goto L_0x0077
        L_0x005c:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Decode Base64 Content-Transfer-Encoding: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0074:
            if (r2 != r4) goto L_0x0077
            return r4
        L_0x0077:
            int r0 = r11.f7918wp
            return r0
        L_0x007a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Content Transfer Encoding, base64 line length > 1024"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.est.CTEBase64InputStream.pullFromSrc():int");
    }

    public int read() {
        if (this.f7917rp == this.f7918wp) {
            this.f7917rp = 0;
            this.f7918wp = 0;
            int pullFromSrc = pullFromSrc();
            if (pullFromSrc == -1) {
                return pullFromSrc;
            }
        }
        byte[] bArr = this.data;
        int i = this.f7917rp;
        this.f7917rp = i + 1;
        return bArr[i] & 255;
    }
}
