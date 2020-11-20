package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzasp implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzasn zzdso;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdsp;

    zzasp(zzasn zzasn, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdso = zzasn;
        this.zzdsp = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdso.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdsp;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdsp;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
