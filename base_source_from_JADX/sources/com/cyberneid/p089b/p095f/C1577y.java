package com.cyberneid.p089b.p095f;

import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.f.y */
public final class C1577y {

    /* renamed from: a */
    private static final byte[] f4748a = {0, 0, 0};

    /* renamed from: b */
    private final C1544ab f4749b;

    /* renamed from: c */
    private final C1549b f4750c;

    /* renamed from: d */
    private final SortedMap<Integer, Integer> f4751d = new TreeMap();

    /* renamed from: e */
    private final List<String> f4752e;

    /* renamed from: f */
    private final SortedSet<Integer> f4753f = new TreeSet();

    /* renamed from: g */
    private String f4754g;

    /* renamed from: h */
    private boolean f4755h;

    public C1577y(C1544ab abVar, List<String> list) {
        this.f4749b = abVar;
        this.f4752e = list;
        this.f4750c = abVar.mo7203w();
        this.f4753f.add(0);
    }

    /* renamed from: a */
    private int m6180a(Integer num) {
        return this.f4753f.headSet(num).size();
    }

    /* renamed from: a */
    private long m6181a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 16);
    }

    /* renamed from: a */
    private long m6182a(DataOutputStream dataOutputStream, int i) {
        dataOutputStream.writeInt(PKIFailureInfo.notAuthorized);
        dataOutputStream.writeShort(i);
        int highestOneBit = Integer.highestOneBit(i);
        int i2 = highestOneBit * 16;
        dataOutputStream.writeShort(i2);
        int b = m6192b(highestOneBit);
        dataOutputStream.writeShort(b);
        int i3 = (i * 16) - i2;
        dataOutputStream.writeShort(i3);
        return m6181a(i, i2) + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH + m6181a(b, i3);
    }

    /* renamed from: a */
    private long m6183a(DataOutputStream dataOutputStream, String str, long j, byte[] bArr) {
        int length = bArr.length;
        long j2 = 0;
        for (int i = 0; i < length; i++) {
            j2 += (((long) bArr[i]) & 255) << (24 - ((i % 4) * 8));
        }
        long j3 = j2 & BodyPartID.bodyIdMax;
        byte[] bytes = str.getBytes("US-ASCII");
        dataOutputStream.write(bytes, 0, 4);
        dataOutputStream.writeInt((int) j3);
        dataOutputStream.writeInt((int) j);
        dataOutputStream.writeInt(bArr.length);
        return m6184a(bytes) + j3 + j3 + j + ((long) bArr.length);
    }

    /* renamed from: a */
    private long m6184a(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16) | ((((long) bArr[2]) & 255) << 8) | (255 & ((long) bArr[3]));
    }

    /* renamed from: a */
    private void m6185a(DataOutputStream dataOutputStream, double d) {
        double floor = Math.floor(d);
        dataOutputStream.writeShort((int) floor);
        dataOutputStream.writeShort((int) ((d - floor) * 65536.0d));
    }

    /* renamed from: a */
    private void m6186a(DataOutputStream dataOutputStream, long j) {
        dataOutputStream.writeInt((int) j);
    }

    /* renamed from: a */
    private void m6187a(DataOutputStream dataOutputStream, Calendar calendar) {
        dataOutputStream.writeLong((calendar.getTimeInMillis() - new GregorianCalendar(1904, 0, 1).getTimeInMillis()) / 1000);
    }

    /* renamed from: a */
    private void m6188a(DataOutputStream dataOutputStream, short s) {
        dataOutputStream.writeShort(s);
    }

    /* renamed from: a */
    private void m6189a(OutputStream outputStream, byte[] bArr) {
        int length = bArr.length;
        outputStream.write(bArr);
        int i = length % 4;
        if (i != 0) {
            outputStream.write(f4748a, 0, 4 - i);
        }
    }

    /* renamed from: a */
    private boolean m6190a(C1566n nVar) {
        return nVar.mo7292f() == 3 && nVar.mo7291e() == 1 && nVar.mo7289c() == 1033 && nVar.mo7290d() >= 0 && nVar.mo7290d() < 7;
    }

    /* renamed from: a */
    private byte[] m6191a(long[] jArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (long a : jArr) {
            m6186a(dataOutputStream, a);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private int m6192b(int i) {
        return (int) Math.round(Math.log((double) i) / Math.log(2.0d));
    }

    /* renamed from: b */
    private void m6193b(DataOutputStream dataOutputStream, int i) {
        dataOutputStream.writeShort(i);
    }

    /* renamed from: b */
    private byte[] m6194b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        C1555f n = this.f4749b.mo7193n();
        m6185a(dataOutputStream, (double) n.mo7233l());
        m6185a(dataOutputStream, (double) n.mo7225d());
        m6186a(dataOutputStream, 0);
        m6186a(dataOutputStream, n.mo7230i());
        m6193b(dataOutputStream, n.mo7223b());
        m6193b(dataOutputStream, n.mo7232k());
        m6187a(dataOutputStream, n.mo7222a());
        m6187a(dataOutputStream, n.mo7231j());
        m6188a(dataOutputStream, n.mo7235n());
        m6188a(dataOutputStream, n.mo7237p());
        m6188a(dataOutputStream, n.mo7234m());
        m6188a(dataOutputStream, n.mo7236o());
        m6193b(dataOutputStream, n.mo7229h());
        m6193b(dataOutputStream, n.mo7228g());
        m6188a(dataOutputStream, n.mo7224c());
        m6188a(dataOutputStream, 1);
        m6188a(dataOutputStream, n.mo7226e());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0110 A[Catch:{ all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011e A[Catch:{ all -> 0x0133 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m6195b(long[] r21) {
        /*
            r20 = this;
            r1 = r20
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            com.cyberneid.b.f.ab r2 = r1.f4749b
            com.cyberneid.b.f.e r2 = r2.mo7186e()
            com.cyberneid.b.f.ab r3 = r1.f4749b
            com.cyberneid.b.f.i r3 = r3.mo7196q()
            long[] r3 = r3.mo7256a()
            com.cyberneid.b.f.ab r4 = r1.f4749b
            java.io.InputStream r4 = r4.mo7199t()
            long r5 = r2.mo7368D()     // Catch:{ all -> 0x0133 }
            r4.skip(r5)     // Catch:{ all -> 0x0133 }
            java.util.SortedSet<java.lang.Integer> r2 = r1.f4753f     // Catch:{ all -> 0x0133 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0133 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
        L_0x0030:
            boolean r13 = r2.hasNext()     // Catch:{ all -> 0x0133 }
            if (r13 == 0) goto L_0x0129
            java.lang.Object r13 = r2.next()     // Catch:{ all -> 0x0133 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0133 }
            int r14 = r13.intValue()     // Catch:{ all -> 0x0133 }
            r14 = r3[r14]     // Catch:{ all -> 0x0133 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0133 }
            r16 = 1
            int r13 = r13 + 1
            r17 = r3[r13]     // Catch:{ all -> 0x0133 }
            long r5 = r17 - r14
            int r13 = r8 + 1
            r21[r8] = r9     // Catch:{ all -> 0x0133 }
            long r11 = r14 - r11
            r4.skip(r11)     // Catch:{ all -> 0x0133 }
            int r8 = (int) r5     // Catch:{ all -> 0x0133 }
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x0133 }
            r4.read(r8)     // Catch:{ all -> 0x0133 }
            int r11 = r8.length     // Catch:{ all -> 0x0133 }
            r12 = 2
            if (r11 < r12) goto L_0x00f7
            byte r11 = r8[r7]     // Catch:{ all -> 0x0133 }
            r12 = -1
            if (r11 != r12) goto L_0x00f7
            byte r11 = r8[r16]     // Catch:{ all -> 0x0133 }
            if (r11 != r12) goto L_0x00f7
            r11 = 10
        L_0x006c:
            byte r12 = r8[r11]     // Catch:{ all -> 0x0133 }
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            int r16 = r11 + 1
            byte r7 = r8[r16]     // Catch:{ all -> 0x0133 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r7 | r12
            int r11 = r11 + 2
            byte r12 = r8[r11]     // Catch:{ all -> 0x0133 }
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            int r16 = r11 + 1
            r18 = r2
            byte r2 = r8[r16]     // Catch:{ all -> 0x0133 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r2 = r2 | r12
            java.util.SortedSet<java.lang.Integer> r12 = r1.f4753f     // Catch:{ all -> 0x0133 }
            r19 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0133 }
            boolean r3 = r12.contains(r3)     // Catch:{ all -> 0x0133 }
            if (r3 != 0) goto L_0x00a1
            java.util.SortedSet<java.lang.Integer> r3 = r1.f4753f     // Catch:{ all -> 0x0133 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0133 }
            r3.add(r12)     // Catch:{ all -> 0x0133 }
        L_0x00a1:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0133 }
            int r2 = r1.m6180a((java.lang.Integer) r2)     // Catch:{ all -> 0x0133 }
            int r3 = r2 >>> 8
            byte r3 = (byte) r3     // Catch:{ all -> 0x0133 }
            r8[r11] = r3     // Catch:{ all -> 0x0133 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0133 }
            r8[r16] = r2     // Catch:{ all -> 0x0133 }
            int r11 = r11 + 2
            r2 = r7 & 1
            if (r2 == 0) goto L_0x00ba
            int r11 = r11 + 4
            goto L_0x00bc
        L_0x00ba:
            int r11 = r11 + 2
        L_0x00bc:
            r2 = r7 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00c3
            int r11 = r11 + 8
            goto L_0x00d0
        L_0x00c3:
            r2 = r7 & 64
            if (r2 == 0) goto L_0x00ca
            int r11 = r11 + 4
            goto L_0x00d0
        L_0x00ca:
            r2 = r7 & 8
            if (r2 == 0) goto L_0x00d0
            int r11 = r11 + 2
        L_0x00d0:
            r2 = r7 & 32
            if (r2 != 0) goto L_0x00f0
            r2 = r7 & 256(0x100, float:3.59E-43)
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != r3) goto L_0x00ea
            byte r2 = r8[r11]     // Catch:{ all -> 0x0133 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            int r3 = r11 + 1
            byte r3 = r8[r3]     // Catch:{ all -> 0x0133 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            int r11 = r11 + 2
            int r11 = r11 + r2
        L_0x00ea:
            r2 = 0
            r0.write(r8, r2, r11)     // Catch:{ all -> 0x0133 }
            long r2 = (long) r11     // Catch:{ all -> 0x0133 }
            goto L_0x0105
        L_0x00f0:
            r2 = r18
            r3 = r19
            r7 = 0
            goto L_0x006c
        L_0x00f7:
            r18 = r2
            r19 = r3
            int r2 = r8.length     // Catch:{ all -> 0x0133 }
            if (r2 <= 0) goto L_0x0106
            int r2 = r8.length     // Catch:{ all -> 0x0133 }
            r3 = 0
            r0.write(r8, r3, r2)     // Catch:{ all -> 0x0133 }
            int r2 = r8.length     // Catch:{ all -> 0x0133 }
            long r2 = (long) r2     // Catch:{ all -> 0x0133 }
        L_0x0105:
            long r9 = r9 + r2
        L_0x0106:
            r2 = 4
            long r7 = r9 % r2
            r11 = 0
            int r16 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r16 == 0) goto L_0x011e
            long r2 = r9 % r2
            int r3 = (int) r2     // Catch:{ all -> 0x0133 }
            int r2 = 4 - r3
            byte[] r3 = f4748a     // Catch:{ all -> 0x0133 }
            r7 = 0
            r0.write(r3, r7, r2)     // Catch:{ all -> 0x0133 }
            long r2 = (long) r2     // Catch:{ all -> 0x0133 }
            long r9 = r9 + r2
            goto L_0x011f
        L_0x011e:
            r7 = 0
        L_0x011f:
            long r2 = r14 + r5
            r11 = r2
            r8 = r13
            r2 = r18
            r3 = r19
            goto L_0x0030
        L_0x0129:
            r21[r8] = r9     // Catch:{ all -> 0x0133 }
            r4.close()
            byte[] r0 = r0.toByteArray()
            return r0
        L_0x0133:
            r0 = move-exception
            r4.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p095f.C1577y.m6195b(long[]):byte[]");
    }

    /* renamed from: c */
    private void m6196c(DataOutputStream dataOutputStream, int i) {
        dataOutputStream.writeByte(i);
    }

    /* renamed from: c */
    private byte[] m6197c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        C1556g o = this.f4749b.mo7194o();
        m6185a(dataOutputStream, (double) o.mo7253p());
        m6188a(dataOutputStream, o.mo7239b());
        m6188a(dataOutputStream, o.mo7242e());
        m6188a(dataOutputStream, o.mo7243f());
        m6193b(dataOutputStream, o.mo7238a());
        m6188a(dataOutputStream, o.mo7245h());
        m6188a(dataOutputStream, o.mo7246i());
        m6188a(dataOutputStream, o.mo7254q());
        m6188a(dataOutputStream, o.mo7240c());
        m6188a(dataOutputStream, o.mo7241d());
        m6188a(dataOutputStream, o.mo7248k());
        m6188a(dataOutputStream, o.mo7249l());
        m6188a(dataOutputStream, o.mo7250m());
        m6188a(dataOutputStream, o.mo7251n());
        m6188a(dataOutputStream, o.mo7252o());
        m6188a(dataOutputStream, o.mo7244g());
        m6193b(dataOutputStream, this.f4753f.subSet(0, Integer.valueOf(o.mo7247j())).size());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: d */
    private byte[] m6198d() {
        List<String> list;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        C1567o j = this.f4749b.mo7189j();
        if (j == null || ((list = this.f4752e) != null && !list.contains(AppMeasurementSdk.ConditionalUserProperty.NAME))) {
            return null;
        }
        List<C1566n> a = j.mo7296a();
        int i = 0;
        for (C1566n a2 : a) {
            if (m6190a(a2)) {
                i++;
            }
        }
        m6193b(dataOutputStream, 0);
        m6193b(dataOutputStream, i);
        m6193b(dataOutputStream, (i * 12) + 6);
        if (i == 0) {
            return null;
        }
        byte[][] bArr = new byte[i][];
        int i2 = 0;
        for (C1566n next : a) {
            if (m6190a(next)) {
                int f = next.mo7292f();
                int e = next.mo7291e();
                String str = LocalizedMessage.DEFAULT_ENCODING;
                if (f == 3 && e == 1) {
                    str = "UTF-16BE";
                } else if (f == 2) {
                    if (e == 0) {
                        str = "US-ASCII";
                    } else if (e == 1) {
                        str = "UTF16-BE";
                    } else if (e == 2) {
                        str = LocalizedMessage.DEFAULT_ENCODING;
                    }
                }
                String g = next.mo7293g();
                if (next.mo7290d() == 6 && this.f4754g != null) {
                    g = this.f4754g + g;
                }
                bArr[i2] = g.getBytes(str);
                i2++;
            }
        }
        int i3 = 0;
        int i4 = 0;
        for (C1566n next2 : a) {
            if (m6190a(next2)) {
                m6193b(dataOutputStream, next2.mo7292f());
                m6193b(dataOutputStream, next2.mo7291e());
                m6193b(dataOutputStream, next2.mo7289c());
                m6193b(dataOutputStream, next2.mo7290d());
                m6193b(dataOutputStream, bArr[i3].length);
                m6193b(dataOutputStream, i4);
                i4 += bArr[i3].length;
                i3++;
            }
        }
        for (int i5 = 0; i5 < i; i5++) {
            dataOutputStream.write(bArr[i5]);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: e */
    private byte[] m6199e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        C1564l m = this.f4749b.mo7192m();
        m6185a(dataOutputStream, 1.0d);
        m6193b(dataOutputStream, this.f4753f.size());
        m6193b(dataOutputStream, m.mo7268h());
        m6193b(dataOutputStream, m.mo7265e());
        m6193b(dataOutputStream, m.mo7264d());
        m6193b(dataOutputStream, m.mo7263c());
        m6193b(dataOutputStream, m.mo7273m());
        m6193b(dataOutputStream, m.mo7272l());
        m6193b(dataOutputStream, m.mo7271k());
        m6193b(dataOutputStream, m.mo7266f());
        m6193b(dataOutputStream, m.mo7267g());
        m6193b(dataOutputStream, m.mo7270j());
        m6193b(dataOutputStream, m.mo7269i());
        m6193b(dataOutputStream, m.mo7262b());
        m6193b(dataOutputStream, m.mo7261a());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: f */
    private byte[] m6200f() {
        C1568p l = this.f4749b.mo7191l();
        if (l == null) {
            return null;
        }
        List<String> list = this.f4752e;
        if (list != null && !list.contains("OS/2")) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        m6193b(dataOutputStream, l.mo7323v());
        m6188a(dataOutputStream, l.mo7303b());
        m6193b(dataOutputStream, l.mo7324w());
        m6193b(dataOutputStream, l.mo7325x());
        m6188a(dataOutputStream, l.mo7308g());
        m6188a(dataOutputStream, l.mo7313l());
        m6188a(dataOutputStream, l.mo7315n());
        m6188a(dataOutputStream, l.mo7312k());
        m6188a(dataOutputStream, l.mo7314m());
        m6188a(dataOutputStream, l.mo7317p());
        m6188a(dataOutputStream, l.mo7319r());
        m6188a(dataOutputStream, l.mo7316o());
        m6188a(dataOutputStream, l.mo7318q());
        m6188a(dataOutputStream, l.mo7311j());
        m6188a(dataOutputStream, l.mo7310i());
        m6188a(dataOutputStream, (short) l.mo7306e());
        dataOutputStream.write(l.mo7309h());
        m6186a(dataOutputStream, 0);
        m6186a(dataOutputStream, 0);
        m6186a(dataOutputStream, 0);
        m6186a(dataOutputStream, 0);
        dataOutputStream.write(l.mo7302a().getBytes("US-ASCII"));
        Iterator<Map.Entry<Integer, Integer>> it = this.f4751d.entrySet().iterator();
        it.next();
        m6193b(dataOutputStream, l.mo7307f());
        m6193b(dataOutputStream, ((Integer) it.next().getKey()).intValue());
        m6193b(dataOutputStream, this.f4751d.lastKey().intValue());
        m6193b(dataOutputStream, l.mo7321t());
        m6193b(dataOutputStream, l.mo7322u());
        m6193b(dataOutputStream, l.mo7320s());
        m6193b(dataOutputStream, l.mo7326y());
        m6193b(dataOutputStream, l.mo7327z());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: g */
    private void m6201g() {
        boolean z;
        byte b;
        if (!this.f4755h) {
            this.f4755h = true;
            do {
                C1554e e = this.f4749b.mo7186e();
                long[] a = this.f4749b.mo7196q().mo7256a();
                InputStream t = this.f4749b.mo7199t();
                TreeSet treeSet = null;
                try {
                    t.skip(e.mo7368D());
                    long j = 0;
                    Iterator it = this.f4753f.iterator();
                    while (true) {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        Integer num = (Integer) it.next();
                        long j2 = a[num.intValue()];
                        long j3 = a[num.intValue() + 1] - j2;
                        t.skip(j2 - j);
                        byte[] bArr = new byte[((int) j3)];
                        t.read(bArr);
                        if (bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -1) {
                            int i = 10;
                            do {
                                b = ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
                                int i2 = i + 2;
                                byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255);
                                if (!this.f4753f.contains(Integer.valueOf(b2))) {
                                    if (treeSet == null) {
                                        treeSet = new TreeSet();
                                    }
                                    treeSet.add(Integer.valueOf(b2));
                                }
                                int i3 = i2 + 2;
                                i = (b & 1) != 0 ? i3 + 4 : i3 + 2;
                                if ((b & 128) != 0) {
                                    i += 8;
                                } else if ((b & 64) != 0) {
                                    i += 4;
                                } else if ((b & 8) != 0) {
                                    i += 2;
                                }
                            } while ((b & 32) != 0);
                            j = a[num.intValue() + 1];
                        } else {
                            j = a[num.intValue() + 1];
                        }
                    }
                    if (treeSet != null) {
                        this.f4753f.addAll(treeSet);
                    }
                    if (treeSet != null) {
                        z = true;
                        continue;
                    }
                } finally {
                    t.close();
                }
            } while (z);
        }
    }

    /* renamed from: h */
    private byte[] m6202h() {
        if (this.f4749b.mo7197r() == null) {
            return null;
        }
        List<String> list = this.f4752e;
        if (list != null && !list.contains("cmap")) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        m6193b(dataOutputStream, 0);
        m6193b(dataOutputStream, 1);
        m6193b(dataOutputStream, 3);
        m6193b(dataOutputStream, 1);
        m6186a(dataOutputStream, 12);
        Iterator<Map.Entry<Integer, Integer>> it = this.f4751d.entrySet().iterator();
        it.next();
        Map.Entry next = it.next();
        int a = m6180a((Integer) next.getValue());
        int[] iArr = new int[this.f4751d.size()];
        int[] iArr2 = new int[this.f4751d.size()];
        int[] iArr3 = new int[this.f4751d.size()];
        Map.Entry entry = next;
        int i = a;
        Map.Entry entry2 = entry;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry next2 = it.next();
            int a2 = m6180a((Integer) next2.getValue());
            if (((Integer) next2.getKey()).intValue() <= 65535) {
                if (((Integer) next2.getKey()).intValue() != ((Integer) entry.getKey()).intValue() + 1 || a2 - i != ((Integer) next2.getKey()).intValue() - ((Integer) entry2.getKey()).intValue()) {
                    if (i != 0) {
                        iArr[i2] = ((Integer) entry2.getKey()).intValue();
                        iArr2[i2] = ((Integer) entry.getKey()).intValue();
                        iArr3[i2] = i - ((Integer) entry2.getKey()).intValue();
                    } else {
                        if (!((Integer) entry2.getKey()).equals(entry.getKey())) {
                            iArr[i2] = ((Integer) entry2.getKey()).intValue() + 1;
                            iArr2[i2] = ((Integer) entry.getKey()).intValue();
                            iArr3[i2] = i - ((Integer) entry2.getKey()).intValue();
                        }
                        entry2 = next2;
                        i = a2;
                    }
                    i2++;
                    entry2 = next2;
                    i = a2;
                }
                entry = next2;
            } else {
                throw new UnsupportedOperationException("non-BMP Unicode character");
            }
        }
        iArr[i2] = ((Integer) entry2.getKey()).intValue();
        iArr2[i2] = ((Integer) entry.getKey()).intValue();
        iArr3[i2] = i - ((Integer) entry2.getKey()).intValue();
        int i3 = i2 + 1;
        iArr[i3] = 65535;
        iArr2[i3] = 65535;
        iArr3[i3] = 1;
        int i4 = i3 + 1;
        int pow = ((int) Math.pow(2.0d, Math.floor((double) m6192b(i4)))) * 2;
        m6193b(dataOutputStream, 4);
        m6193b(dataOutputStream, (i4 * 4 * 2) + 16);
        m6193b(dataOutputStream, 0);
        int i5 = i4 * 2;
        m6193b(dataOutputStream, i5);
        m6193b(dataOutputStream, pow);
        m6193b(dataOutputStream, m6192b(pow / 2));
        m6193b(dataOutputStream, i5 - pow);
        for (int i6 = 0; i6 < i4; i6++) {
            m6193b(dataOutputStream, iArr2[i6]);
        }
        m6193b(dataOutputStream, 0);
        for (int i7 = 0; i7 < i4; i7++) {
            m6193b(dataOutputStream, iArr[i7]);
        }
        for (int i8 = 0; i8 < i4; i8++) {
            m6193b(dataOutputStream, iArr3[i8]);
        }
        for (int i9 = 0; i9 < i4; i9++) {
            m6193b(dataOutputStream, 0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: i */
    private byte[] m6203i() {
        int intValue;
        C1572t k = this.f4749b.mo7190k();
        if (k == null) {
            return null;
        }
        List<String> list = this.f4752e;
        if (list != null && !list.contains("post")) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        m6185a(dataOutputStream, 2.0d);
        m6185a(dataOutputStream, (double) k.mo7342b());
        m6188a(dataOutputStream, k.mo7347g());
        m6188a(dataOutputStream, k.mo7348h());
        m6186a(dataOutputStream, k.mo7340a());
        m6186a(dataOutputStream, k.mo7346f());
        m6186a(dataOutputStream, k.mo7344d());
        m6186a(dataOutputStream, k.mo7345e());
        m6186a(dataOutputStream, k.mo7343c());
        m6193b(dataOutputStream, this.f4753f.size());
        TreeMap treeMap = new TreeMap();
        for (Integer intValue2 : this.f4753f) {
            String a = k.mo7341a(intValue2.intValue());
            Integer num = C1548af.f4603b.get(a);
            if (num != null) {
                intValue = num.intValue();
            } else {
                Integer num2 = (Integer) treeMap.get(a);
                if (num2 == null) {
                    num2 = Integer.valueOf(treeMap.size());
                    treeMap.put(a, num2);
                }
                intValue = num2.intValue() + 258;
            }
            m6193b(dataOutputStream, intValue);
        }
        for (String bytes : treeMap.keySet()) {
            byte[] bytes2 = bytes.getBytes(Charset.forName("US-ASCII"));
            m6196c(dataOutputStream, bytes2.length);
            dataOutputStream.write(bytes2);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: j */
    private byte[] m6204j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1556g o = this.f4749b.mo7194o();
        C1557h p = this.f4749b.mo7195p();
        byte[] bArr = new byte[4];
        InputStream t = this.f4749b.mo7199t();
        try {
            t.skip(p.mo7368D());
            long j = 0;
            for (Integer num : this.f4753f) {
                int i = 2;
                long intValue = (long) (num.intValue() < o.mo7247j() ? num.intValue() * 4 : (o.mo7247j() * 4) + ((num.intValue() - o.mo7247j()) * 2));
                if (intValue != j) {
                    long j2 = intValue - j;
                    if (j2 != t.skip(j2)) {
                        throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
                    }
                }
                if (num.intValue() < o.mo7247j()) {
                    i = 4;
                }
                if (i == t.read(bArr, 0, i)) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    j = ((long) i) + intValue;
                } else {
                    throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            t.close();
        }
    }

    /* renamed from: a */
    public Map<Integer, Integer> mo7362a() {
        m6201g();
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Integer intValue : this.f4753f) {
            hashMap.put(Integer.valueOf(i), Integer.valueOf(intValue.intValue()));
            i++;
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo7363a(int i) {
        int a = this.f4750c.mo7206a(i);
        if (a != 0) {
            this.f4751d.put(Integer.valueOf(i), Integer.valueOf(a));
            this.f4753f.add(Integer.valueOf(a));
        }
    }

    /* renamed from: a */
    public void mo7364a(OutputStream outputStream) {
        if (this.f4753f.isEmpty() || this.f4751d.isEmpty()) {
            throw new IllegalStateException("subset is empty");
        }
        m6201g();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try {
            long[] jArr = new long[(this.f4753f.size() + 1)];
            byte[] b = m6194b();
            byte[] c = m6197c();
            byte[] e = m6199e();
            byte[] d = m6198d();
            byte[] f = m6200f();
            byte[] b2 = m6195b(jArr);
            byte[] a = m6191a(jArr);
            byte[] h = m6202h();
            byte[] j = m6204j();
            byte[] i = m6203i();
            TreeMap treeMap = new TreeMap();
            if (f != null) {
                treeMap.put("OS/2", f);
            }
            if (h != null) {
                treeMap.put("cmap", h);
            }
            if (b2 != null) {
                treeMap.put("glyf", b2);
            }
            treeMap.put("head", b);
            treeMap.put("hhea", c);
            treeMap.put("hmtx", j);
            if (a != null) {
                treeMap.put("loca", a);
            }
            treeMap.put("maxp", e);
            if (d != null) {
                treeMap.put(AppMeasurementSdk.ConditionalUserProperty.NAME, d);
            }
            if (i != null) {
                treeMap.put("post", i);
            }
            for (Map.Entry next : this.f4749b.mo7188i().entrySet()) {
                String str = (String) next.getKey();
                C1578z zVar = (C1578z) next.getValue();
                if (!treeMap.containsKey(str) && (this.f4752e == null || this.f4752e.contains(str))) {
                    treeMap.put(str, this.f4749b.mo7182b(zVar));
                }
            }
            long a2 = m6182a(dataOutputStream, treeMap.size());
            long size = (((long) treeMap.size()) * 16) + 12;
            long j2 = a2;
            for (Map.Entry entry : treeMap.entrySet()) {
                j2 += m6183a(dataOutputStream, (String) entry.getKey(), size, (byte[]) entry.getValue());
                size += (long) (((((byte[]) entry.getValue()).length + 3) / 4) * 4);
            }
            long j3 = 2981146554L - (BodyPartID.bodyIdMax & j2);
            b[8] = (byte) ((int) (j3 >>> 24));
            b[9] = (byte) ((int) (j3 >>> 16));
            b[10] = (byte) ((int) (j3 >>> 8));
            b[11] = (byte) ((int) j3);
            for (byte[] a3 : treeMap.values()) {
                m6189a((OutputStream) dataOutputStream, a3);
            }
        } finally {
            dataOutputStream.close();
        }
    }

    /* renamed from: a */
    public void mo7365a(String str) {
        this.f4754g = str;
    }

    /* renamed from: a */
    public void mo7366a(Set<Integer> set) {
        for (Integer intValue : set) {
            mo7363a(intValue.intValue());
        }
    }
}
