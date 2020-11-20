package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbim;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzbgm implements zzbjl {
    @GuardedBy("AppComponent.class")
    private static zzbgm zzevb;

    public static zzbgm zza(Context context, zzani zzani, int i) {
        zzbgm zzf = zzf(context, i);
        zzf.zzaep().zzb(zzani);
        return zzf;
    }

    @Deprecated
    private static zzbgm zza(zzazh zzazh, Context context, zzbim.zza zza) {
        zzbgm zzbgm;
        synchronized (zzbgm.class) {
            if (zzevb == null) {
                zzevb = new zzbib().zzc(new zzbgl(new zzbgl.zza().zza(zzazh).zzby(context))).zza(new zzbim(zza)).zzahg();
                zzabf.initialize(context);
                zzp.zzku().zzd(context, zzazh);
                zzp.zzkw().initialize(context);
                zzp.zzkq().zzam(context);
                zzp.zzkq().zzan(context);
                zzp.zzkq();
                zzm.zzbd(context);
                zzb.zzal(context);
                zzp.zzkt().initialize(context);
                zzp.zzll().initialize(context);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
                    new zzcqh(context, zzazh, new zzts(new zztx(context)), new zzcpr(new zzcpp(context), zzevb.zzaen())).zzari();
                }
            }
            zzbgm = zzevb;
        }
        return zzbgm;
    }

    @Deprecated
    public static zzbgm zzf(Context context, int i) {
        synchronized (zzbgm.class) {
            if (zzevb == null) {
                return zza(new zzazh(203404000, i, true, false), context, (zzbim.zza) new zzbhh());
            }
            zzbgm zzbgm = zzevb;
            return zzbgm;
        }
    }

    public final zzdga zza(zzatl zzatl, int i) {
        return zza(new zzdhn(zzatl, i));
    }

    /* access modifiers changed from: protected */
    public abstract zzdga zza(zzdhn zzdhn);

    public abstract Executor zzaek();

    public abstract ScheduledExecutorService zzael();

    public abstract Executor zzaem();

    public abstract zzdzc zzaen();

    public abstract zzbua zzaeo();

    public abstract zzciq zzaep();

    public abstract zzbiu zzaeq();

    public abstract zzbmz zzaer();

    public abstract zzblf zzaes();

    public abstract zzbls zzaet();

    public abstract zzdii zzaeu();

    public abstract zzcaa zzaev();

    public abstract zzdlc zzaew();

    public abstract zzcaw zzaex();

    public abstract zzchi zzaey();

    public abstract zzdmp zzaez();

    public abstract zzcyy zzafa();

    public abstract zzcyx zzafb();

    public abstract zzcqy zzafc();

    public abstract zzdod<zzcgh> zzafd();
}
