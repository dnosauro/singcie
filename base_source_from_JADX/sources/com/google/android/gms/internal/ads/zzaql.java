package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzaql implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqj zzdof;

    zzaql(zzaqj zzaqj) {
        this.zzdof = zzaqj;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdof.zzdt("Operation denied by user.");
    }
}
