package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdek implements zzdfi<zzdel> {
    private final Context context;
    private final ScheduledExecutorService zzfpq;
    private final zzdnn zzfvl;
    private final zzdzc zzggb;
    private final zzcwx zzgty;
    private String zzgxt;
    private final zzcwz zzhao;

    public zzdek(zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, String str, zzcwz zzcwz, Context context2, zzdnn zzdnn, zzcwx zzcwx) {
        this.zzggb = zzdzc;
        this.zzfpq = scheduledExecutorService;
        this.zzgxt = str;
        this.zzhao = zzcwz;
        this.context = context2;
        this.zzfvl = zzdnn;
        this.zzgty = zzcwx;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(String str, List list, Bundle bundle) {
        zzazq zzazq = new zzazq();
        this.zzgty.zzgl(str);
        zzapo zzgm = this.zzgty.zzgm(str);
        if (zzgm != null) {
            Bundle bundle2 = bundle;
            zzgm.zza(ObjectWrapper.wrap(this.context), this.zzgxt, bundle2, (Bundle) list.get(0), this.zzfvl.zzbpe, (zzapt) new zzcxf(str, zzgm, zzazq));
            return zzazq;
        }
        throw new NullPointerException();
    }

    public final zzdyz<zzdel> zzasm() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqc)).booleanValue() ? zzdyr.zza(new zzden(this), this.zzggb) : zzdyr.zzag(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzasz() {
        Map<String, List<Bundle>> zzt = this.zzhao.zzt(this.zzgxt, this.zzfvl.zzhip);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : zzt.entrySet()) {
            String str = (String) next.getKey();
            arrayList.add(zzdyi.zzg(zzdyr.zza(new zzdem(this, str, (List) next.getValue(), this.zzfvl.zzhio.zzchf != null ? this.zzfvl.zzhio.zzchf.getBundle(str) : null), this.zzggb)).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcqb)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq).zza(Throwable.class, new zzdep(str), (Executor) this.zzggb));
        }
        return zzdyr.zzk(arrayList).zza(new zzdeo(arrayList), this.zzggb);
    }
}
