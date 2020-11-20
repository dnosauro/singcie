package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

final /* synthetic */ class zzb implements Executor {
    static final Executor zza = new zzb();

    private zzb() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
