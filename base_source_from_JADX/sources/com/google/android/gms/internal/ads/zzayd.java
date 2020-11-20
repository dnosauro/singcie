package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzayd implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzazq zzeaf;

    zzayd(zzaya zzaya, Context context, zzazq zzazq) {
        this.val$context = context;
        this.zzeaf = zzazq;
    }

    public final void run() {
        try {
            this.zzeaf.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzeaf.setException(e);
            zzaza.zzc("Exception while getting advertising Id info", e);
        }
    }
}
