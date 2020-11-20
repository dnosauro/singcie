package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.C0735d;

final class zad extends DialogRedirect {
    private final /* synthetic */ C0735d val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaoh;

    zad(Intent intent, C0735d dVar, int i) {
        this.zaoh = intent;
        this.val$fragment = dVar;
        this.val$requestCode = i;
    }

    public final void redirect() {
        Intent intent = this.zaoh;
        if (intent != null) {
            this.val$fragment.startActivityForResult(intent, this.val$requestCode);
        }
    }
}
