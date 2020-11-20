package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbdo implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzepc;

    zzbdo(JsResult jsResult) {
        this.zzepc = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzepc.confirm();
    }
}
