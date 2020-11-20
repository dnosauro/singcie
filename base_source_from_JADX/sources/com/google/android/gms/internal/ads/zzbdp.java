package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbdp implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzepc;

    zzbdp(JsResult jsResult) {
        this.zzepc = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzepc.cancel();
    }
}
