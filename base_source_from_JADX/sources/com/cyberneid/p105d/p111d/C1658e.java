package com.cyberneid.p105d.p111d;

import com.parse.ParseQuery;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.d.e */
public class C1658e extends InputStream implements C1662h {

    /* renamed from: a */
    private int f5470a = 12;

    /* renamed from: b */
    private int f5471b;

    /* renamed from: c */
    private long f5472c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f5473d;

    /* renamed from: e */
    private File f5474e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public byte[] f5475f;

    /* renamed from: g */
    private final Map<Long, byte[]> f5476g;

    /* renamed from: h */
    private long f5477h;

    /* renamed from: i */
    private byte[] f5478i;

    /* renamed from: j */
    private int f5479j;

    /* renamed from: k */
    private final RandomAccessFile f5480k;

    /* renamed from: l */
    private final long f5481l;

    /* renamed from: m */
    private long f5482m;

    /* renamed from: n */
    private boolean f5483n;

    public C1658e(InputStream inputStream) {
        int i = this.f5470a;
        this.f5471b = 1 << i;
        this.f5472c = -1 << i;
        this.f5473d = ParseQuery.MAX_LIMIT;
        this.f5475f = null;
        this.f5476g = new LinkedHashMap<Long, byte[]>(this.f5473d, 0.75f, true) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Long, byte[]> entry) {
                boolean z = size() > C1658e.this.f5473d;
                if (z) {
                    byte[] unused = C1658e.this.f5475f = entry.getValue();
                }
                return z;
            }
        };
        this.f5477h = -1;
        this.f5478i = new byte[this.f5471b];
        this.f5479j = 0;
        this.f5482m = 0;
        this.f5474e = m6651a(inputStream);
        this.f5481l = this.f5474e.length();
        this.f5480k = new RandomAccessFile(this.f5474e, "r");
        mo7706a(0);
    }

    /* renamed from: a */
    private File m6651a(InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            File createTempFile = File.createTempFile("tmpPDFBox", ".pdf");
            FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile);
            try {
                C1654a.m6618a(inputStream, fileOutputStream2);
                C1654a.m6619a((Closeable) inputStream);
                C1654a.m6619a((Closeable) fileOutputStream2);
                return createTempFile;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                C1654a.m6619a((Closeable) inputStream);
                C1654a.m6619a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C1654a.m6619a((Closeable) inputStream);
            C1654a.m6619a((Closeable) fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private void m6652a() {
        File file = this.f5474e;
        if (file != null) {
            file.delete();
        }
    }

    /* renamed from: f */
    private byte[] m6654f() {
        int read;
        byte[] bArr = this.f5475f;
        if (bArr != null) {
            this.f5475f = null;
        } else {
            bArr = new byte[this.f5471b];
        }
        int i = 0;
        while (true) {
            int i2 = this.f5471b;
            if (i >= i2 || (read = this.f5480k.read(bArr, i, i2 - i)) < 0) {
                return bArr;
            }
            i += read;
        }
        return bArr;
    }

    /* renamed from: a */
    public void mo7706a(long j) {
        long j2 = this.f5472c & j;
        if (j2 != this.f5477h) {
            byte[] bArr = this.f5476g.get(Long.valueOf(j2));
            if (bArr == null) {
                this.f5480k.seek(j2);
                bArr = m6654f();
                this.f5476g.put(Long.valueOf(j2), bArr);
            }
            this.f5477h = j2;
            this.f5478i = bArr;
        }
        this.f5479j = (int) (j - this.f5477h);
        this.f5482m = j;
    }

    public int available() {
        return (int) Math.min(this.f5481l - this.f5482m, 2147483647L);
    }

    /* renamed from: b */
    public long mo7709b() {
        return this.f5482m;
    }

    /* renamed from: b */
    public void mo7710b(int i) {
        mo7706a(mo7709b() - ((long) i));
    }

    /* renamed from: c */
    public long mo7711c() {
        return this.f5481l;
    }

    /* renamed from: c */
    public byte[] mo7712c(int i) {
        byte[] bArr = new byte[i];
        int read = read(bArr);
        while (read < i) {
            read += read(bArr, read, i - read);
        }
        return bArr;
    }

    public void close() {
        this.f5480k.close();
        m6652a();
        this.f5476g.clear();
        this.f5483n = true;
    }

    /* renamed from: d */
    public boolean mo7715d() {
        return this.f5483n;
    }

    /* renamed from: e */
    public boolean mo7716e() {
        return mo7718g() == -1;
    }

    /* renamed from: g */
    public int mo7718g() {
        int read = read();
        if (read != -1) {
            mo7710b(1);
        }
        return read;
    }

    public int read() {
        long j = this.f5482m;
        if (j >= this.f5481l) {
            return -1;
        }
        if (this.f5479j == this.f5471b) {
            mo7706a(j);
        }
        this.f5482m++;
        byte[] bArr = this.f5478i;
        int i = this.f5479j;
        this.f5479j = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = this.f5482m;
        if (j >= this.f5481l) {
            return -1;
        }
        if (this.f5479j == this.f5471b) {
            mo7706a(j);
        }
        int min = Math.min(this.f5471b - this.f5479j, i2);
        long j2 = this.f5481l;
        long j3 = this.f5482m;
        if (j2 - j3 < ((long) this.f5471b)) {
            min = Math.min(min, (int) (j2 - j3));
        }
        System.arraycopy(this.f5478i, this.f5479j, bArr, i, min);
        this.f5479j += min;
        this.f5482m += (long) min;
        return min;
    }

    public long skip(long j) {
        long j2 = this.f5481l;
        long j3 = this.f5482m;
        if (j2 - j3 < j) {
            j = j2 - j3;
        }
        int i = this.f5471b;
        if (j < ((long) i)) {
            int i2 = this.f5479j;
            if (((long) i2) + j <= ((long) i)) {
                this.f5479j = (int) (((long) i2) + j);
                this.f5482m += j;
                return j;
            }
        }
        mo7706a(this.f5482m + j);
        return j;
    }
}
