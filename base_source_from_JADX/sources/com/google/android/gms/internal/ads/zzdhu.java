package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

public final class zzdhu implements zzepf<zzdfl<JSONObject>> {
    public static zzdfl<JSONObject> zza(zzaxy zzaxy, Object obj, zzdgc zzdgc, zzdhd zzdhd, zzeoz<zzdfw> zzeoz, zzeoz<zzdgg> zzeoz2, zzeoz<zzdgk> zzeoz3, zzeoz<zzdgq> zzeoz4, zzeoz<zzdgz> zzeoz5, zzeoz<zzdhe> zzeoz6, zzeoz<zzdhi> zzeoz7, zzeoz<zzdhw> zzeoz8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdgv) obj);
        hashSet.add(zzdgc);
        hashSet.add(zzdhd);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvs)).booleanValue()) {
            hashSet.add(zzeoz.get());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvt)).booleanValue()) {
            hashSet.add(zzeoz2.get());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvu)).booleanValue()) {
            hashSet.add(zzeoz3.get());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvv)).booleanValue()) {
            hashSet.add(zzeoz4.get());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvz)).booleanValue()) {
            hashSet.add(new zzddx(zzeoz6.get(), ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue(), scheduledExecutorService));
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwb)).booleanValue()) {
            hashSet.add(zzeoz7.get());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwc)).booleanValue()) {
            hashSet.add(zzeoz8.get());
        }
        return (zzdfl) zzepl.zza(new zzdfl(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
