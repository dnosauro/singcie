package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzaqr implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqp zzdpd;

    zzaqr(zzaqp zzaqp) {
        this.zzdpd = zzaqp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdpd.zzdt("User canceled the download.");
    }
}
