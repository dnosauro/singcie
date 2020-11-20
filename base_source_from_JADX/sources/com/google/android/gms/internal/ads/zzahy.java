package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zzbf;

final /* synthetic */ class zzahy implements DialogInterface.OnClickListener {
    private final Context zzckm;
    private final zzahz zzdgs;
    private final String zzdgt;
    private final zzbf zzdgu;
    private final String zzdgv;
    private final Resources zzdgw;

    zzahy(zzahz zzahz, Context context, String str, zzbf zzbf, String str2, Resources resources) {
        this.zzdgs = zzahz;
        this.zzckm = context;
        this.zzdgt = str;
        this.zzdgu = zzbf;
        this.zzdgv = str2;
        this.zzdgw = resources;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdgs.zza(this.zzckm, this.zzdgt, this.zzdgu, this.zzdgv, this.zzdgw, dialogInterface, i);
    }
}
