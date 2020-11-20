package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzdex implements zzdfi<zzdeu> {
    private final Context context;
    private final zzazh zzbpd;
    private final zzdzc zzggb;

    public zzdex(zzdzc zzdzc, Context context2, zzazh zzazh) {
        this.zzggb = zzdzc;
        this.context = context2;
        this.zzbpd = zzazh;
    }

    public final zzdyz<zzdeu> zzasm() {
        return this.zzggb.zze(new zzdew(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdeu zzatc() {
        boolean isCallerInstantApp = Wrappers.packageManager(this.context).isCallerInstantApp();
        zzp.zzkq();
        boolean zzaw = zzm.zzaw(this.context);
        String str = this.zzbpd.zzbrf;
        zzp.zzks();
        boolean zzyl = zzu.zzyl();
        zzp.zzkq();
        return new zzdeu(isCallerInstantApp, zzaw, str, zzyl, zzm.zzat(this.context), DynamiteModule.getRemoteVersion(this.context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.context, ModuleDescriptor.MODULE_ID));
    }
}
