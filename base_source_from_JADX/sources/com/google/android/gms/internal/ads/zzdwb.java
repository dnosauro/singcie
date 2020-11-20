package com.google.android.gms.internal.ads;

abstract class zzdwb extends zzduz<String> {
    private int limit;
    private int offset = 0;
    private final zzdvd zzhtf;
    private final boolean zzhtg;
    final CharSequence zzhtl;

    protected zzdwb(zzdvx zzdvx, CharSequence charSequence) {
        this.zzhtf = zzdvx.zzhtf;
        this.zzhtg = false;
        this.limit = zzdvx.limit;
        this.zzhtl = charSequence;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzayj() {
        int i;
        int i2 = this.offset;
        while (true) {
            int i3 = this.offset;
            if (i3 != -1) {
                int zzem = zzem(i3);
                if (zzem == -1) {
                    zzem = this.zzhtl.length();
                    this.offset = -1;
                } else {
                    this.offset = zzen(zzem);
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    this.offset = i4 + 1;
                    if (this.offset > this.zzhtl.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i2 < zzem && this.zzhtf.zzc(this.zzhtl.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzhtf.zzc(this.zzhtl.charAt(i - 1))) {
                        zzem = i - 1;
                    }
                    int i5 = this.limit;
                    if (i5 == 1) {
                        i = this.zzhtl.length();
                        this.offset = -1;
                        while (i > i2 && this.zzhtf.zzc(this.zzhtl.charAt(i - 1))) {
                            i--;
                        }
                    } else {
                        this.limit = i5 - 1;
                    }
                    return this.zzhtl.subSequence(i2, i).toString();
                }
            } else {
                zzayk();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int zzem(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzen(int i);
}
