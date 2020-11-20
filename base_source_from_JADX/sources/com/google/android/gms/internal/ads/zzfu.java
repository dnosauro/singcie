package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;

public final class zzfu extends zzgl {
    public zzfu(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 24);
    }

    private final void zzcz() {
        AdvertisingIdClient zzcs = this.zzwb.zzcs();
        if (zzcs != null) {
            try {
                AdvertisingIdClient.Info info = zzcs.getInfo();
                String zzaq = zzff.zzaq(info.getId());
                if (zzaq != null) {
                    synchronized (this.zzaay) {
                        this.zzaay.zzab(zzaq);
                        this.zzaay.zza(info.isLimitAdTrackingEnabled());
                        this.zzaay.zza(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* synthetic */ Object call() {
        return call();
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.zzwb.zzck()) {
            zzcz();
            return;
        }
        synchronized (this.zzaay) {
            this.zzaay.zzab((String) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()}));
        }
    }

    public final Void zzcy() {
        if (this.zzwb.isInitialized()) {
            return super.call();
        }
        if (!this.zzwb.zzck()) {
            return null;
        }
        zzcz();
        return null;
    }
}
