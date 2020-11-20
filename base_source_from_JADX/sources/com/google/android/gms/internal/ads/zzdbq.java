package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class zzdbq implements zzdfi<zzdbr> {
    private final Context context;
    private final zzdzc zzggb;

    public zzdbq(zzdzc zzdzc, Context context2) {
        this.zzggb = zzdzc;
        this.context = context2;
    }

    public final zzdyz<zzdbr> zzasm() {
        return this.zzggb.zze(new zzdbt(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdbr zzasr() {
        double d;
        Intent registerReceiver = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            d = ((double) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) registerReceiver.getIntExtra("scale", -1));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzdbr(d, z);
    }
}
