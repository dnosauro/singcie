package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

final /* synthetic */ class zzn implements Transformer {
    static final Transformer zza = new zzn();

    private zzn() {
    }

    public final Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
