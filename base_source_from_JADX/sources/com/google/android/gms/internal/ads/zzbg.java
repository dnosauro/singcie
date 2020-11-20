package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.net.HttpURLConnection;

final class zzbg extends FilterInputStream {
    private final HttpURLConnection zzcu;

    zzbg(HttpURLConnection httpURLConnection) {
        super(zzbd.zza(httpURLConnection));
        this.zzcu = httpURLConnection;
    }

    public final void close() {
        super.close();
        this.zzcu.disconnect();
    }
}
