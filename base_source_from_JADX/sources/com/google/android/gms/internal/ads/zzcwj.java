package com.google.android.gms.internal.ads;

public final class zzcwj<AdT> implements zzcqz<AdT> {
    private final zzdro zzfvm;
    private final zzdzc zzguc;
    private final zzacb zzguk;
    /* access modifiers changed from: private */
    public final zzcwo<AdT> zzguo;

    public zzcwj(zzdro zzdro, zzdzc zzdzc, zzacb zzacb, zzcwo<AdT> zzcwo) {
        this.zzfvm = zzdro;
        this.zzguc = zzdzc;
        this.zzguk = zzacb;
        this.zzguo = zzcwo;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (this.zzguk == null || zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    public final zzdyz<AdT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzazq zzazq = new zzazq();
        zzcwr zzcwr = new zzcwr();
        zzcwr.zza(new zzcwl(this, zzazq, zzdnj, zzdmu, zzcwr));
        return this.zzfvm.zzu(zzdrl.CUSTOM_RENDER_SYN).zza((zzdqy) new zzcwm(this, new zzabu(zzcwr, zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp)), this.zzguc).zzw(zzdrl.CUSTOM_RENDER_ACK).zze(zzazq).zzaww();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzabu zzabu) {
        this.zzguk.zza(zzabu);
    }
}
