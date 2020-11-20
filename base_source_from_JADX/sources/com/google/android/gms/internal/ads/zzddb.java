package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import java.util.Set;

public final class zzddb implements zzdfi<zzdcy> {
    private final Context context;
    private final zzdzc zzgyd;
    private final Set<String> zzgyn;
    private final ViewGroup zzhac;

    public zzddb(zzdzc zzdzc, ViewGroup viewGroup, Context context2, Set<String> set) {
        this.zzgyd = zzdzc;
        this.zzgyn = set;
        this.zzhac = viewGroup;
        this.context = context2;
    }

    private static Boolean zzl(Activity activity) {
        Window window = activity.getWindow();
        boolean z = true;
        if (window != null && (window.getAttributes().flags & 16777216) != 0) {
            return true;
        }
        try {
            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final zzdyz<zzdcy> zzasm() {
        return this.zzgyd.zze(new zzdda(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdcy zzasu() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwe)).booleanValue() && this.zzhac != null && this.zzgyn.contains("banner")) {
            return new zzdcy(Boolean.valueOf(this.zzhac.isHardwareAccelerated()));
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwf)).booleanValue() && this.zzgyn.contains("native")) {
            Context context2 = this.context;
            if (context2 instanceof Activity) {
                return new zzdcy(zzl((Activity) context2));
            }
        }
        return new zzdcy((Boolean) null);
    }
}
