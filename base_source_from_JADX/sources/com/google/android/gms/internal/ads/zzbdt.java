package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzbdt implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzepd;
    private final /* synthetic */ EditText zzepf;

    zzbdt(JsPromptResult jsPromptResult, EditText editText) {
        this.zzepd = jsPromptResult;
        this.zzepf = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzepd.confirm(this.zzepf.getText().toString());
    }
}
