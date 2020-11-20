package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;

final class zzaqi implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqj zzdof;

    zzaqi(zzaqj zzaqj) {
        this.zzdof = zzaqj;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent createIntent = this.zzdof.createIntent();
        zzp.zzkq();
        zzm.zza(this.zzdof.context, createIntent);
    }
}
