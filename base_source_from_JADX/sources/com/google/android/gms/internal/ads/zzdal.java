package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.concurrent.Executor;

public final class zzdal implements zzdfi<zzdai> {
    private final Context context;
    private final zzayg zzbpt;
    private final zzdnn zzfvl;
    private final zzdfi<zzdfp> zzgym;

    public zzdal(zzdbw<zzdfp> zzdbw, zzdnn zzdnn, Context context2, zzayg zzayg) {
        this.zzgym = zzdbw;
        this.zzfvl = zzdnn;
        this.context = context2;
        this.zzbpt = zzayg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdai zza(zzdfp zzdfp) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        zzvn[] zzvnArr;
        DisplayMetrics displayMetrics;
        zzvn zzvn = this.zzfvl.zzbpe;
        if (zzvn.zzchq != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvn zzvn2 : zzvn.zzchq) {
                if (!zzvn2.zzchr && !z2) {
                    str = zzvn2.zzacv;
                    z2 = true;
                }
                if (zzvn2.zzchr && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzvn.zzacv;
            z = zzvn.zzchr;
        }
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzbpt.zzwz().zzyb();
            i2 = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzvn.zzchq != null) {
            zzvn[] zzvnArr2 = zzvn.zzchq;
            int length = zzvnArr2.length;
            int i5 = 0;
            boolean z4 = false;
            while (i5 < length) {
                zzvn zzvn3 = zzvnArr2[i5];
                if (zzvn3.zzchr) {
                    zzvnArr = zzvnArr2;
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    zzvnArr = zzvnArr2;
                    sb.append((zzvn3.width != -1 || f == 0.0f) ? zzvn3.width : (int) (((float) zzvn3.widthPixels) / f));
                    sb.append("x");
                    sb.append((zzvn3.height != -2 || f == 0.0f) ? zzvn3.height : (int) (((float) zzvn3.heightPixels) / f));
                }
                i5++;
                zzvnArr2 = zzvnArr;
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdai(zzvn, str, z, sb.toString(), f, i2, i, str2, this.zzfvl.zzgyj);
    }

    public final zzdyz<zzdai> zzasm() {
        return zzdyr.zzb(this.zzgym.zzasm(), new zzdak(this), (Executor) zzazj.zzegu);
    }
}
