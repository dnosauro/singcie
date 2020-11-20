package com.cyberneid.p105d.p111d;

import java.io.File;

/* renamed from: com.cyberneid.d.d.b */
public final class C1655b {

    /* renamed from: a */
    private final boolean f5457a;

    /* renamed from: b */
    private final boolean f5458b;

    /* renamed from: c */
    private final long f5459c;

    /* renamed from: d */
    private final long f5460d;

    /* renamed from: e */
    private File f5461e;

    private C1655b(boolean z, boolean z2, long j, long j2) {
        boolean z3 = z2 ? z : true;
        j = !z ? -1 : j;
        j2 = j2 <= 0 ? -1 : j2;
        j = j < -1 ? -1 : j;
        if (z3 && j == 0) {
            if (z2) {
                z3 = false;
            } else {
                j = j2;
            }
        }
        if (z3 && j2 > -1 && (j == -1 || j > j2)) {
            j2 = j;
        }
        this.f5457a = z3;
        this.f5458b = z2;
        this.f5459c = j;
        this.f5460d = j2;
    }

    /* renamed from: a */
    public static C1655b m6621a() {
        return m6622a(-1);
    }

    /* renamed from: a */
    public static C1655b m6622a(long j) {
        return new C1655b(true, false, j, j);
    }

    /* renamed from: b */
    public static C1655b m6623b() {
        return m6624b(-1);
    }

    /* renamed from: b */
    public static C1655b m6624b(long j) {
        return new C1655b(false, true, 0, j);
    }

    /* renamed from: a */
    public C1655b mo7695a(File file) {
        this.f5461e = file;
        return this;
    }

    /* renamed from: c */
    public boolean mo7696c() {
        return this.f5457a;
    }

    /* renamed from: d */
    public boolean mo7697d() {
        return this.f5458b;
    }

    /* renamed from: e */
    public boolean mo7698e() {
        return this.f5459c >= 0;
    }

    /* renamed from: f */
    public boolean mo7699f() {
        return this.f5460d > 0;
    }

    /* renamed from: g */
    public long mo7700g() {
        return this.f5459c;
    }

    /* renamed from: h */
    public long mo7701h() {
        return this.f5460d;
    }

    /* renamed from: i */
    public File mo7702i() {
        return this.f5461e;
    }

    public String toString() {
        String str;
        StringBuilder sb;
        long j;
        if (this.f5457a) {
            if (this.f5458b) {
                sb = new StringBuilder();
                sb.append("Mixed mode with max. of ");
                sb.append(this.f5459c);
                sb.append(" main memory bytes");
                if (mo7699f()) {
                    str = " and max. of " + this.f5460d + " storage bytes";
                } else {
                    str = " and unrestricted scratch file size";
                }
                sb.append(str);
                return sb.toString();
            } else if (!mo7698e()) {
                return "Main memory only with no size restriction";
            } else {
                sb = new StringBuilder();
                sb.append("Main memory only with max. of ");
                j = this.f5459c;
            }
        } else if (!mo7699f()) {
            return "Scratch file only with no size restriction";
        } else {
            sb = new StringBuilder();
            sb.append("Scratch file only with max. of ");
            j = this.f5460d;
        }
        sb.append(j);
        str = " bytes";
        sb.append(str);
        return sb.toString();
    }
}
