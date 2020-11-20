package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;

final /* synthetic */ class zzaib implements DialogInterface.OnClickListener {
    private final zzahz zzdgs;
    private final String zzdha;
    private final Context zzdhb;

    zzaib(zzahz zzahz, String str, Context context) {
        this.zzdgs = zzahz;
        this.zzdha = str;
        this.zzdhb = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdgs.zza(this.zzdha, this.zzdhb, dialogInterface, i);
    }
}
