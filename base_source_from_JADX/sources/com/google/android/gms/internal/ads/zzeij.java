package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

final class zzeij extends zzeig {
    zzeij() {
    }

    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }

    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
