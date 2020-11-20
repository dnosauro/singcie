package com.google.android.gms.internal.ads;

import java.io.OutputStream;

final /* synthetic */ class zzatj implements Runnable {
    private final OutputStream zzdvv;
    private final byte[] zzdvw;

    zzatj(OutputStream outputStream, byte[] bArr) {
        this.zzdvv = outputStream;
        this.zzdvw = bArr;
    }

    public final void run() {
        zzatg.zza(this.zzdvv, this.zzdvw);
    }
}
