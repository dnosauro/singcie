package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import javax.annotation.Nullable;

final class zzcma implements zzdyo<String> {
    final /* synthetic */ zzclp zzgls;

    zzcma(zzclp zzclp) {
        this.zzgls = zzclp;
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            boolean unused = this.zzgls.zzglc = true;
            this.zzgls.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (zzp.zzkx().elapsedRealtime() - this.zzgls.zzgld));
            this.zzgls.executor.execute(new zzclz(this, str));
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this) {
            boolean unused = this.zzgls.zzglc = true;
            this.zzgls.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzp.zzkx().elapsedRealtime() - this.zzgls.zzgld));
            this.zzgls.zzgle.setException(new Exception());
        }
    }
}
