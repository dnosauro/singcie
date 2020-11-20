package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

final /* synthetic */ class zzai implements DialogInterface.OnClickListener {
    private final zzag zzedn;
    private final int zzeds;
    private final int zzedt;
    private final int zzedu;

    zzai(zzag zzag, int i, int i2, int i3) {
        this.zzedn = zzag;
        this.zzeds = i;
        this.zzedt = i2;
        this.zzedu = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzedn.zza(this.zzeds, this.zzedt, this.zzedu, dialogInterface, i);
    }
}
