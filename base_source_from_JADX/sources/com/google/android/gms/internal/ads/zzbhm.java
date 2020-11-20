package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

final class zzbhm extends zzdga {
    private final /* synthetic */ zzbhg zzexw;
    private zzeps<String> zzfcg;
    private zzeps<zzckc> zzfcw;
    private zzeps<Map<zzdrl, zzckc>> zzfcy;
    private zzeps<Set<zzbxy<zzdru>>> zzfda;
    private zzeps<Set<zzbxy<zzdru>>> zzfdh;
    private zzeps zzfdi;
    private zzeps<zzdro> zzfdj;
    private zzeps<ApplicationInfo> zzfdu;
    private zzeps<zzdhe> zzffb;
    private final zzdhn zzfig;
    private zzeps<zzdfw> zzfih;
    private zzeps<String> zzfii;
    private zzeps<zzdgg> zzfij;
    private zzeps<Integer> zzfik;
    private zzeps<zzdgk> zzfil;
    private zzeps<zzdgq> zzfim;
    private zzeps<zzdgz> zzfin;
    private zzeps<Boolean> zzfio;
    private zzeps<zzdhi> zzfip;
    private zzeps<zzdhw> zzfiq;
    private zzeps<zzckc> zzfir;
    private zzeps<zzckc> zzfis;
    private zzeps<zzckc> zzfit;

    private zzbhm(zzbhg zzbhg, zzdhn zzdhn) {
        this.zzexw = zzbhg;
        this.zzfig = zzdhn;
        this.zzfih = new zzdgb(zzbjj.zzfpl, this.zzexw.zzevu, this.zzexw.zzevp, zzdqo.zzawk());
        this.zzfii = new zzdhm(zzdhn);
        this.zzfij = new zzdgi(zzbhb.zzevh, this.zzexw.zzevu, this.zzfii, zzdqo.zzawk());
        this.zzfik = new zzdhr(zzdhn);
        this.zzfil = new zzdgo(zzbjj.zzfpl, this.zzfik, this.zzexw.zzevu, this.zzexw.zzewr, this.zzexw.zzevp, zzdqo.zzawk());
        this.zzfim = new zzdgs(zzbjd.zzfpi, zzdqo.zzawk(), this.zzexw.zzevu);
        this.zzfin = new zzdhb(zzbjf.zzfpj, zzdqo.zzawk(), this.zzfii);
        this.zzfio = new zzdho(zzdhn);
        this.zzfdu = new zzdhp(zzdhn);
        this.zzffb = new zzdhg(this.zzexw.zzewt, this.zzexw.zzevp, this.zzfio, this.zzfdu);
        this.zzfip = new zzdhk(zzbjh.zzfpk, this.zzexw.zzevp, this.zzexw.zzevu);
        this.zzfiq = new zzdhy(zzdqo.zzawk());
        this.zzfcg = new zzdhq(zzdhn);
        this.zzfcw = zzepg.zzas(zzcjr.zzaps());
        this.zzfir = zzepg.zzas(zzcjp.zzapr());
        this.zzfis = zzepg.zzas(zzcjt.zzapu());
        this.zzfit = zzepg.zzas(zzcjv.zzapw());
        this.zzfcy = ((zzepj) ((zzepj) ((zzepj) ((zzepj) zzeph.zzig(4).zza(zzdrl.GMS_SIGNALS, this.zzfcw)).zza(zzdrl.BUILD_URL, this.zzfir)).zza(zzdrl.HTTP, this.zzfis)).zza(zzdrl.PRE_PROCESS, this.zzfit)).zzblu();
        this.zzfda = zzepg.zzas(new zzcjx(this.zzfcg, this.zzexw.zzevu, zzdqo.zzawk(), this.zzfcy));
        this.zzfdh = zzepo.zzas(0, 1).zzav(this.zzfda).zzblv();
        this.zzfdi = zzdrw.zzar(this.zzfdh);
        this.zzfdj = zzepg.zzas(zzdrt.zzx(zzdqo.zzawk(), this.zzexw.zzevp, this.zzfdi));
    }

    private final zzdhd zzagj() {
        return new zzdhd((zzaao) zzepl.zza(new zzaao(), "Cannot return null from a non-@Nullable @Provides method"), zzdqo.zzawl(), (List) zzepl.zza(this.zzfig.zzatn(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzdgc zzagk() {
        return new zzdgc(zzbjk.zzaie(), zzdqo.zzawl(), (String) zzepl.zza(this.zzfig.zzatk(), "Cannot return null from a non-@Nullable @Provides method"), this.zzfig.zzatl());
    }

    public final zzdfl<JSONObject> zzagl() {
        zzdzc zzawl = zzdqo.zzawl();
        long longValue = ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue();
        long longValue2 = ((Long) zzwq.zzqe().zzd(zzabf.zzcsv)).longValue();
        return zzdfm.zza(zzawl, zzdwt.zza((zzdfi) zzepl.zza(new zzddx(new zzdgz(zzbjg.zzaia(), zzdqo.zzawl(), zzdhm.zzb(this.zzfig)), 0, (ScheduledExecutorService) this.zzexw.zzevp.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdhe(zzbip.zzb(this.zzexw.zzevl), (ScheduledExecutorService) this.zzexw.zzevp.get(), this.zzfig.zzatm(), zzdhp.zzc(this.zzfig)), longValue, (ScheduledExecutorService) this.zzexw.zzevp.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdhi(zzbji.zzaic(), (ScheduledExecutorService) this.zzexw.zzevp.get(), zzbgo.zza(this.zzexw.zzevm)), longValue2, (ScheduledExecutorService) this.zzexw.zzevp.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdfw(zzbjk.zzaie(), zzbgo.zza(this.zzexw.zzevm), (ScheduledExecutorService) this.zzexw.zzevp.get(), zzdqo.zzawl()), 0, (ScheduledExecutorService) this.zzexw.zzevp.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdhw(zzdqo.zzawl()), 0, (ScheduledExecutorService) this.zzexw.zzevp.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(zzdht.zzatr(), "Cannot return null from a non-@Nullable @Provides method"), new zzdgg((zzato) null, zzbgo.zza(this.zzexw.zzevm), zzdhm.zzb(this.zzfig), zzdqo.zzawl()), new zzdgq(zzbje.zzahy(), zzdqo.zzawl(), zzbgo.zza(this.zzexw.zzevm)), zzagj(), zzagk(), new zzdgk(zzbjk.zzaie(), this.zzfig.zzatq(), zzbgo.zza(this.zzexw.zzevm), (zzayg) this.zzexw.zzewr.get(), (ScheduledExecutorService) this.zzexw.zzevp.get(), zzdqo.zzawl()), (zzdfi) this.zzexw.zzews.get()));
    }

    public final zzdfl<JSONObject> zzagm() {
        return zzdhu.zza(zzbjg.zzaia(), this.zzexw.zzews.get(), zzagk(), zzagj(), zzepg.zzat(this.zzfih), zzepg.zzat(this.zzfij), zzepg.zzat(this.zzfil), zzepg.zzat(this.zzfim), zzepg.zzat(this.zzfin), zzepg.zzat(this.zzffb), zzepg.zzat(this.zzfip), zzepg.zzat(this.zzfiq), zzdqo.zzawl(), (ScheduledExecutorService) this.zzexw.zzevp.get());
    }

    public final zzdro zzagn() {
        return this.zzfdj.get();
    }
}
