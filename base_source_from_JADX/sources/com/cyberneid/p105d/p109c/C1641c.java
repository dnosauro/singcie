package com.cyberneid.p105d.p109c;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.cmc.BodyPartID;

/* renamed from: com.cyberneid.d.c.c */
final class C1641c extends FilterOutputStream {

    /* renamed from: a */
    private int f5445a = 72;

    /* renamed from: b */
    private int f5446b = 0;

    /* renamed from: c */
    private byte[] f5447c = new byte[4];

    /* renamed from: d */
    private byte[] f5448d = new byte[5];

    /* renamed from: e */
    private int f5449e = 72;

    /* renamed from: f */
    private boolean f5450f = true;

    /* renamed from: g */
    private char f5451g = '~';

    C1641c(OutputStream outputStream) {
        super(outputStream);
    }

    /* renamed from: a */
    private void m6586a() {
        byte[] bArr = this.f5447c;
        long j = ((long) ((bArr[3] & 255) | (((bArr[0] << 8) | (bArr[1] & 255)) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8))) & BodyPartID.bodyIdMax;
        if (j == 0) {
            byte[] bArr2 = this.f5448d;
            bArr2[0] = 122;
            bArr2[1] = 0;
            return;
        }
        long j2 = j / 52200625;
        byte[] bArr3 = this.f5448d;
        bArr3[0] = (byte) ((int) (j2 + 33));
        long j3 = j - ((((j2 * 85) * 85) * 85) * 85);
        long j4 = j3 / 614125;
        bArr3[1] = (byte) ((int) (j4 + 33));
        long j5 = j3 - (((j4 * 85) * 85) * 85);
        long j6 = j5 / 7225;
        bArr3[2] = (byte) ((int) (j6 + 33));
        long j7 = j5 - ((j6 * 85) * 85);
        bArr3[3] = (byte) ((int) ((j7 / 85) + 33));
        bArr3[4] = (byte) ((int) ((j7 % 85) + 33));
    }

    public void close() {
        try {
            flush();
            super.close();
        } finally {
            this.f5448d = null;
            this.f5447c = null;
        }
    }

    public void flush() {
        if (!this.f5450f) {
            int i = this.f5446b;
            if (i > 0) {
                while (i < 4) {
                    this.f5447c[i] = 0;
                    i++;
                }
                m6586a();
                if (this.f5448d[0] == 122) {
                    for (int i2 = 0; i2 < 5; i2++) {
                        this.f5448d[i2] = 33;
                    }
                }
                for (int i3 = 0; i3 < this.f5446b + 1; i3++) {
                    this.out.write(this.f5448d[i3]);
                    int i4 = this.f5445a - 1;
                    this.f5445a = i4;
                    if (i4 == 0) {
                        this.out.write(10);
                        this.f5445a = this.f5449e;
                    }
                }
            }
            int i5 = this.f5445a - 1;
            this.f5445a = i5;
            if (i5 == 0) {
                this.out.write(10);
            }
            this.out.write(this.f5451g);
            this.out.write(10);
            this.f5446b = 0;
            this.f5445a = this.f5449e;
            this.f5450f = true;
            super.flush();
        }
    }

    public void write(int i) {
        this.f5450f = false;
        byte[] bArr = this.f5447c;
        int i2 = this.f5446b;
        this.f5446b = i2 + 1;
        bArr[i2] = (byte) i;
        if (this.f5446b >= 4) {
            m6586a();
            int i3 = 0;
            while (i3 < 5 && this.f5448d[i3] != 0) {
                this.out.write(this.f5448d[i3]);
                int i4 = this.f5445a - 1;
                this.f5445a = i4;
                if (i4 == 0) {
                    this.out.write(10);
                    this.f5445a = this.f5449e;
                }
                i3++;
            }
            this.f5446b = 0;
        }
    }
}
