package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzbdr implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzepd;

    zzbdr(JsPromptResult jsPromptResult) {
        this.zzepd = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzepd.cancel();
    }
}
