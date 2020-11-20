package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzdsv {
    private final Context context;
    private final Executor executor;
    private final zzdtb zzhqe;
    private final zzdtb zzhqf;
    private Task<zzcf.zza> zzhqg;
    private Task<zzcf.zza> zzhqh;
    private final zzdsi zzvs;
    private final zzdsj zzyk;

    @VisibleForTesting
    private zzdsv(Context context2, Executor executor2, zzdsi zzdsi, zzdsj zzdsj, zzdsz zzdsz, zzdtc zzdtc) {
        this.context = context2;
        this.executor = executor2;
        this.zzvs = zzdsi;
        this.zzyk = zzdsj;
        this.zzhqe = zzdsz;
        this.zzhqf = zzdtc;
    }

    private static zzcf.zza zza(Task<zzcf.zza> task, zzcf.zza zza) {
        return !task.isSuccessful() ? zza : task.getResult();
    }

    public static zzdsv zza(Context context2, Executor executor2, zzdsi zzdsi, zzdsj zzdsj) {
        zzdsv zzdsv = new zzdsv(context2, executor2, zzdsi, zzdsj, new zzdsz(), new zzdtc());
        zzdsv.zzhqg = zzdsv.zzyk.zzawy() ? zzdsv.zzd(new zzdsy(zzdsv)) : Tasks.forResult(zzdsv.zzhqe.zzaxi());
        zzdsv.zzhqh = zzdsv.zzd(new zzdsx(zzdsv));
        return zzdsv;
    }

    private final Task<zzcf.zza> zzd(Callable<zzcf.zza> callable) {
        return Tasks.call(this.executor, callable).addOnFailureListener(this.executor, (OnFailureListener) new zzdta(this));
    }

    public final zzcf.zza zzaxe() {
        return zza(this.zzhqg, this.zzhqe.zzaxi());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzaxf() {
        return this.zzhqf.zzcm(this.context);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzaxg() {
        return this.zzhqe.zzcm(this.context);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvs.zza(2025, -1, exc);
    }

    public final zzcf.zza zzco() {
        return zza(this.zzhqh, this.zzhqf.zzaxi());
    }
}
