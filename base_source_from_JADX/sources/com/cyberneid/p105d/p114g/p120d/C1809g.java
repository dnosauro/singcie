package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.C1479b;
import org.spongycastle.asn1.cmc.BodyPartID;

/* renamed from: com.cyberneid.d.g.d.g */
public abstract class C1809g {
    /* renamed from: a */
    public abstract String mo8120a();

    /* renamed from: b */
    public abstract C1808f mo8121b();

    /* renamed from: c */
    public abstract C1801b mo8122c();

    /* renamed from: d */
    public abstract C1479b mo8123d();

    /* renamed from: e */
    public abstract int mo8124e();

    /* renamed from: f */
    public abstract int mo8125f();

    /* renamed from: g */
    public abstract int mo8126g();

    /* renamed from: h */
    public abstract int mo8127h();

    /* renamed from: i */
    public abstract int mo8128i();

    /* renamed from: j */
    public abstract C1825u mo8129j();

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final int mo8133k() {
        int f = mo8125f();
        if (f == 100) {
            return 2;
        }
        if (f == 200) {
            return 3;
        }
        if (f == 300) {
            return 4;
        }
        if (f == 400) {
            return 5;
        }
        if (f == 500) {
            return 6;
        }
        if (f == 600) {
            return 7;
        }
        if (f == 700) {
            return 8;
        }
        if (f == 800) {
            return 9;
        }
        if (f == 900) {
            return 10;
        }
        switch (f) {
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final long mo8134l() {
        return (((long) mo8126g()) & BodyPartID.bodyIdMax) | ((BodyPartID.bodyIdMax & ((long) mo8127h())) << 32);
    }

    public String toString() {
        return mo8120a() + " (" + mo8121b() + ", mac: 0x" + Integer.toHexString(mo8128i()) + ", os/2: 0x" + Integer.toHexString(mo8124e()) + ", cid: " + mo8122c() + ")";
    }
}
