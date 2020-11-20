package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

final /* synthetic */ class zzah implements DialogInterface.OnClickListener {
    private final String zzdha;
    private final zzag zzedn;

    zzah(zzag zzag, String str) {
        this.zzedn = zzag;
        this.zzdha = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzedn.zza(this.zzdha, dialogInterface, i);
    }
}
