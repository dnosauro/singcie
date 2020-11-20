package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzduz<T> implements Iterator<T> {
    private int zzhsp = zzdvb.zzhss;
    @NullableDecl
    private T zzhsq;

    protected zzduz() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasNext() {
        /*
            r4 = this;
            int r0 = r4.zzhsp
            int r1 = com.google.android.gms.internal.ads.zzdvb.zzhsu
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == 0) goto L_0x002d
            int[] r0 = com.google.android.gms.internal.ads.zzdvc.zzhsw
            int r1 = r4.zzhsp
            int r1 = r1 - r3
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x002c;
                case 2: goto L_0x002b;
                default: goto L_0x0017;
            }
        L_0x0017:
            int r0 = com.google.android.gms.internal.ads.zzdvb.zzhsu
            r4.zzhsp = r0
            java.lang.Object r0 = r4.zzayj()
            r4.zzhsq = r0
            int r0 = r4.zzhsp
            int r1 = com.google.android.gms.internal.ads.zzdvb.zzhst
            if (r0 == r1) goto L_0x002c
            int r0 = com.google.android.gms.internal.ads.zzdvb.zzhsr
            r4.zzhsp = r0
        L_0x002b:
            return r3
        L_0x002c:
            return r2
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzduz.hasNext():boolean");
    }

    public final T next() {
        if (hasNext()) {
            this.zzhsp = zzdvb.zzhss;
            T t = this.zzhsq;
            this.zzhsq = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public abstract T zzayj();

    /* access modifiers changed from: protected */
    @NullableDecl
    public final T zzayk() {
        this.zzhsp = zzdvb.zzhst;
        return null;
    }
}
