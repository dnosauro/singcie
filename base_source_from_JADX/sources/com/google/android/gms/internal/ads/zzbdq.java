package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzbdq implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzepd;

    zzbdq(JsPromptResult jsPromptResult) {
        this.zzepd = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzepd.cancel();
    }
}
