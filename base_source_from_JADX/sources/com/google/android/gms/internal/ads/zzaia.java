package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;

final /* synthetic */ class zzaia implements DialogInterface.OnCancelListener {
    private final zzahz zzdgs;
    private final String zzdha;
    private final Context zzdhb;

    zzaia(zzahz zzahz, String str, Context context) {
        this.zzdgs = zzahz;
        this.zzdha = str;
        this.zzdhb = context;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzdgs.zza(this.zzdha, this.zzdhb, dialogInterface);
    }
}
