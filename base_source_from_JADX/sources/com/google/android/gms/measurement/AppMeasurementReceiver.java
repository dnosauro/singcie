package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.p041g.p042a.C0794a;
import com.google.android.gms.measurement.internal.zzfs;
import com.google.android.gms.measurement.internal.zzft;

public final class AppMeasurementReceiver extends C0794a implements zzfs {
    private zzft zza;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzft(this);
        }
        this.zza.zza(context, intent);
    }
}
