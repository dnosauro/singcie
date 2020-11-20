package com.cyberneid.p089b.p095f;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.f.w */
abstract class C1575w implements Closeable {
    C1575w() {
    }

    /* renamed from: a */
    public abstract int mo7275a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public abstract long mo7276a();

    /* renamed from: a */
    public String mo7350a(int i) {
        return mo7351a(i, LocalizedMessage.DEFAULT_ENCODING);
    }

    /* renamed from: a */
    public String mo7351a(int i, String str) {
        return new String(mo7354d(i), str);
    }

    /* renamed from: a */
    public abstract void mo7277a(long j);

    /* renamed from: b */
    public int[] mo7352b(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = mo7279c();
        }
        return iArr;
    }

    /* renamed from: c */
    public abstract int mo7279c();

    /* renamed from: c */
    public int[] mo7353c(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = mo7281d();
        }
        return iArr;
    }

    public abstract void close();

    /* renamed from: d */
    public abstract int mo7281d();

    /* renamed from: d */
    public byte[] mo7354d(int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int a = mo7275a(bArr, i2, i - i2);
            if (a == -1) {
                break;
            }
            i2 += a;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Unexpected end of TTF stream reached");
    }

    /* renamed from: e */
    public abstract short mo7282e();

    /* renamed from: f */
    public abstract long mo7283f();

    /* renamed from: g */
    public abstract InputStream mo7284g();

    /* renamed from: h */
    public float mo7355h() {
        return (float) (((double) ((float) mo7282e())) + (((double) mo7281d()) / 65536.0d));
    }

    /* renamed from: i */
    public int mo7356i() {
        int c = mo7279c();
        return c < 127 ? c : c - 256;
    }

    /* renamed from: j */
    public int mo7357j() {
        int c = mo7279c();
        if (c != -1) {
            return c;
        }
        throw new EOFException("premature EOF");
    }

    /* renamed from: k */
    public long mo7358k() {
        long c = (long) mo7279c();
        long c2 = (long) mo7279c();
        long c3 = (long) mo7279c();
        long c4 = (long) mo7279c();
        if (c4 >= 0) {
            return (c << 24) + (c2 << 16) + (c3 << 8) + (c4 << 0);
        }
        throw new EOFException();
    }

    /* renamed from: l */
    public Calendar mo7359l() {
        long a = mo7276a();
        Calendar instance = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.set(1904, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        instance.setTimeInMillis(instance.getTimeInMillis() + (a * 1000));
        return instance;
    }

    /* renamed from: m */
    public String mo7360m() {
        return new String(mo7354d(4), "US-ASCII");
    }
}
