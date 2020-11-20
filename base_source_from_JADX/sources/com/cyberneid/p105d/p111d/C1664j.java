package com.cyberneid.p105d.p111d;

import android.support.p002v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.BitSet;

/* renamed from: com.cyberneid.d.d.j */
public class C1664j implements Closeable {

    /* renamed from: a */
    private final Object f5488a;

    /* renamed from: b */
    private final File f5489b;

    /* renamed from: c */
    private File f5490c;

    /* renamed from: d */
    private RandomAccessFile f5491d;

    /* renamed from: e */
    private volatile int f5492e;

    /* renamed from: f */
    private final BitSet f5493f;

    /* renamed from: g */
    private volatile byte[][] f5494g;

    /* renamed from: h */
    private final int f5495h;

    /* renamed from: i */
    private final int f5496i;

    /* renamed from: j */
    private final boolean f5497j;

    /* renamed from: k */
    private final boolean f5498k;

    /* renamed from: l */
    private volatile boolean f5499l;

    public C1664j(C1655b bVar) {
        this.f5488a = new Object();
        this.f5492e = 0;
        this.f5493f = new BitSet();
        this.f5499l = false;
        this.f5498k = !bVar.mo7696c() || bVar.mo7698e();
        this.f5497j = this.f5498k ? bVar.mo7697d() : false;
        this.f5489b = this.f5497j ? bVar.mo7702i() : null;
        File file = this.f5489b;
        if (file == null || file.isDirectory()) {
            this.f5496i = bVar.mo7699f() ? (int) Math.min(2147483647L, bVar.mo7701h() / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) : Integer.MAX_VALUE;
            this.f5495h = bVar.mo7696c() ? bVar.mo7698e() ? (int) Math.min(2147483647L, bVar.mo7700g() / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) : Integer.MAX_VALUE : 0;
            this.f5494g = new byte[(this.f5498k ? this.f5495h : 100000)][];
            this.f5493f.set(0, this.f5494g.length);
            return;
        }
        throw new IOException("Scratch file directory does not exist: " + this.f5489b);
    }

    public C1664j(File file) {
        this(C1655b.m6623b().mo7695a(file));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cb, code lost:
        return;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6675e() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f5488a
            monitor-enter(r0)
            r8.mo7739c()     // Catch:{ all -> 0x00cc }
            int r1 = r8.f5492e     // Catch:{ all -> 0x00cc }
            int r2 = r8.f5496i     // Catch:{ all -> 0x00cc }
            if (r1 < r2) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            return
        L_0x000e:
            boolean r1 = r8.f5497j     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00a5
            java.io.RandomAccessFile r1 = r8.f5491d     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x0054
            java.lang.String r1 = "PDFBox"
            java.lang.String r2 = ".tmp"
            java.io.File r3 = r8.f5489b     // Catch:{ all -> 0x00cc }
            java.io.File r1 = java.io.File.createTempFile(r1, r2, r3)     // Catch:{ all -> 0x00cc }
            r8.f5490c = r1     // Catch:{ all -> 0x00cc }
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x002e }
            java.io.File r2 = r8.f5490c     // Catch:{ IOException -> 0x002e }
            java.lang.String r3 = "rw"
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x002e }
            r8.f5491d = r1     // Catch:{ IOException -> 0x002e }
            goto L_0x0054
        L_0x002e:
            r1 = move-exception
            java.io.File r2 = r8.f5490c     // Catch:{ all -> 0x00cc }
            boolean r2 = r2.delete()     // Catch:{ all -> 0x00cc }
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r3.<init>()     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = "Error deleting scratch file: "
            r3.append(r4)     // Catch:{ all -> 0x00cc }
            java.io.File r4 = r8.f5490c     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x00cc }
            r3.append(r4)     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cc }
            android.util.Log.w(r2, r3)     // Catch:{ all -> 0x00cc }
        L_0x0053:
            throw r1     // Catch:{ all -> 0x00cc }
        L_0x0054:
            java.io.RandomAccessFile r1 = r8.f5491d     // Catch:{ all -> 0x00cc }
            long r1 = r1.length()     // Catch:{ all -> 0x00cc }
            int r3 = r8.f5492e     // Catch:{ all -> 0x00cc }
            long r3 = (long) r3     // Catch:{ all -> 0x00cc }
            int r5 = r8.f5495h     // Catch:{ all -> 0x00cc }
            long r5 = (long) r5     // Catch:{ all -> 0x00cc }
            long r3 = r3 - r5
            r5 = 4096(0x1000, double:2.0237E-320)
            long r3 = r3 * r5
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0086
            int r3 = r8.f5492e     // Catch:{ all -> 0x00cc }
            int r3 = r3 + 16
            int r4 = r8.f5492e     // Catch:{ all -> 0x00cc }
            if (r3 <= r4) goto L_0x00ca
            r3 = 65536(0x10000, double:3.2379E-319)
            long r1 = r1 + r3
            java.io.RandomAccessFile r3 = r8.f5491d     // Catch:{ all -> 0x00cc }
            r3.setLength(r1)     // Catch:{ all -> 0x00cc }
            java.util.BitSet r1 = r8.f5493f     // Catch:{ all -> 0x00cc }
            int r2 = r8.f5492e     // Catch:{ all -> 0x00cc }
            int r3 = r8.f5492e     // Catch:{ all -> 0x00cc }
            int r3 = r3 + 16
            r1.set(r2, r3)     // Catch:{ all -> 0x00cc }
            goto L_0x00ca
        L_0x0086:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r6.<init>()     // Catch:{ all -> 0x00cc }
            java.lang.String r7 = "Expected scratch file size of "
            r6.append(r7)     // Catch:{ all -> 0x00cc }
            r6.append(r3)     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = " but found "
            r6.append(r3)     // Catch:{ all -> 0x00cc }
            r6.append(r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00cc }
            r5.<init>(r1)     // Catch:{ all -> 0x00cc }
            throw r5     // Catch:{ all -> 0x00cc }
        L_0x00a5:
            boolean r1 = r8.f5498k     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x00ca
            byte[][] r1 = r8.f5494g     // Catch:{ all -> 0x00cc }
            int r1 = r1.length     // Catch:{ all -> 0x00cc }
            long r2 = (long) r1     // Catch:{ all -> 0x00cc }
            r4 = 2
            long r2 = r2 * r4
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x00cc }
            int r3 = (int) r2     // Catch:{ all -> 0x00cc }
            if (r3 <= r1) goto L_0x00ca
            byte[][] r2 = new byte[r3][]     // Catch:{ all -> 0x00cc }
            byte[][] r4 = r8.f5494g     // Catch:{ all -> 0x00cc }
            r5 = 0
            java.lang.System.arraycopy(r4, r5, r2, r5, r1)     // Catch:{ all -> 0x00cc }
            r8.f5494g = r2     // Catch:{ all -> 0x00cc }
            java.util.BitSet r2 = r8.f5493f     // Catch:{ all -> 0x00cc }
            r2.set(r1, r3)     // Catch:{ all -> 0x00cc }
        L_0x00ca:
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            return
        L_0x00cc:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p111d.C1664j.m6675e():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7734a() {
        int nextSetBit;
        synchronized (this.f5493f) {
            nextSetBit = this.f5493f.nextSetBit(0);
            if (nextSetBit < 0) {
                m6675e();
                nextSetBit = this.f5493f.nextSetBit(0);
                if (nextSetBit < 0) {
                    throw new IOException("Maximum allowed scratch file memory exceeded.");
                }
            }
            this.f5493f.clear(nextSetBit);
            if (nextSetBit >= this.f5492e) {
                this.f5492e = nextSetBit + 1;
            }
        }
        return nextSetBit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7735a(int i, byte[] bArr) {
        if (i < 0 || i >= this.f5492e) {
            mo7739c();
            StringBuilder sb = new StringBuilder();
            sb.append("Page index out of range: ");
            sb.append(i);
            sb.append(". Max value: ");
            sb.append(this.f5492e - 1);
            throw new IOException(sb.toString());
        } else if (bArr.length != 4096) {
            throw new IOException("Wrong page size to write: " + bArr.length + ". Expected: " + 4096);
        } else if (i < this.f5495h) {
            if (this.f5498k) {
                this.f5494g[i] = bArr;
            } else {
                synchronized (this.f5488a) {
                    this.f5494g[i] = bArr;
                }
            }
            mo7739c();
        } else {
            synchronized (this.f5488a) {
                mo7739c();
                this.f5491d.seek((((long) i) - ((long) this.f5495h)) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                this.f5491d.write(bArr);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7736a(int[] iArr, int i, int i2) {
        synchronized (this.f5493f) {
            while (i < i2) {
                int i3 = iArr[i];
                if (i3 >= 0 && i3 < this.f5492e && !this.f5493f.get(i3)) {
                    this.f5493f.set(i3);
                    if (i3 < this.f5495h) {
                        this.f5494g[i3] = null;
                    }
                }
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo7737a(int i) {
        byte[] bArr;
        if (i < 0 || i >= this.f5492e) {
            mo7739c();
            StringBuilder sb = new StringBuilder();
            sb.append("Page index out of range: ");
            sb.append(i);
            sb.append(". Max value: ");
            sb.append(this.f5492e - 1);
            throw new IOException(sb.toString());
        } else if (i < this.f5495h) {
            byte[] bArr2 = this.f5494g[i];
            if (bArr2 != null) {
                return bArr2;
            }
            mo7739c();
            throw new IOException("Requested page with index " + i + " was not written before.");
        } else {
            synchronized (this.f5488a) {
                if (this.f5491d != null) {
                    bArr = new byte[4096];
                    this.f5491d.seek((((long) i) - ((long) this.f5495h)) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                    this.f5491d.readFully(bArr);
                } else {
                    mo7739c();
                    throw new IOException("Missing scratch file to read page with index " + i + " from.");
                }
            }
            return bArr;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo7738b() {
        return 4096;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7739c() {
        if (this.f5499l) {
            throw new IOException("Scratch file already closed");
        }
    }

    public void close() {
        if (!this.f5499l) {
            this.f5499l = true;
            IOException e = null;
            synchronized (this.f5488a) {
                if (this.f5491d != null) {
                    try {
                        this.f5491d.close();
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (this.f5490c != null && !this.f5490c.delete() && this.f5490c.exists() && e == null) {
                    e = new IOException("Error deleting scratch file: " + this.f5490c.getAbsolutePath());
                }
                synchronized (this.f5493f) {
                    this.f5493f.clear();
                    this.f5492e = 0;
                }
                if (e != null) {
                    throw e;
                }
            }
        }
    }

    /* renamed from: d */
    public C1656c mo7741d() {
        return new C1665k(this);
    }
}
