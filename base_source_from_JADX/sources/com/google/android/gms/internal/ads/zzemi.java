package com.google.android.gms.internal.ads;

final class zzemi implements zzelq {
    private final int flags;
    private final String info;
    private final Object[] zzipr;
    private final zzels zzipu;

    zzemi(zzels zzels, String str, Object[] objArr) {
        this.zzipu = zzels;
        this.info = str;
        this.zzipr = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    public final int zzbjg() {
        return (this.flags & 1) == 1 ? zzemd.zziqj : zzemd.zziqk;
    }

    public final boolean zzbjh() {
        return (this.flags & 2) == 2;
    }

    public final zzels zzbji() {
        return this.zzipu;
    }

    /* access modifiers changed from: package-private */
    public final String zzbjo() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbjp() {
        return this.zzipr;
    }
}
