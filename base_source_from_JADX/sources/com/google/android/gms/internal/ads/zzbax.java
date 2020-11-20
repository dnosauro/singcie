package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbax {
    private final Context zzcln;
    private final zzbbe zzehi;
    private final ViewGroup zzeje;
    private zzbar zzejf;

    @VisibleForTesting
    private zzbax(Context context, ViewGroup viewGroup, zzbbe zzbbe, zzbar zzbar) {
        this.zzcln = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzeje = viewGroup;
        this.zzehi = zzbbe;
        this.zzejf = null;
    }

    public zzbax(Context context, ViewGroup viewGroup, zzbdv zzbdv) {
        this(context, viewGroup, zzbdv, (zzbar) null);
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbar zzbar = this.zzejf;
        if (zzbar != null) {
            zzbar.destroy();
            this.zzeje.removeView(this.zzejf);
            this.zzejf = null;
        }
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbar zzbar = this.zzejf;
        if (zzbar != null) {
            zzbar.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbbf zzbbf) {
        if (this.zzejf == null) {
            zzabn.zza(this.zzehi.zzaan().zzry(), this.zzehi.zzaai(), "vpr2");
            Context context = this.zzcln;
            zzbbe zzbbe = this.zzehi;
            this.zzejf = new zzbar(context, zzbbe, i5, z, zzbbe.zzaan().zzry(), zzbbf);
            this.zzeje.addView(this.zzejf, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzejf.zzd(i, i2, i3, i4);
            this.zzehi.zzau(false);
        }
    }

    public final zzbar zzaac() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzejf;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbar zzbar = this.zzejf;
        if (zzbar != null) {
            zzbar.zzd(i, i2, i3, i4);
        }
    }
}
