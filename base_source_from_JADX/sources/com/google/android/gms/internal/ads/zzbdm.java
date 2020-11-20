package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbdm implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzepc;

    zzbdm(JsResult jsResult) {
        this.zzepc = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzepc.cancel();
    }
}
