package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

final /* synthetic */ class zzdof implements Runnable {
    private final InputStream zzhji;
    private final ParcelFileDescriptor zzhjj;

    zzdof(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzhji = inputStream;
        this.zzhjj = parcelFileDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.google.android.gms.internal.ads.zzeid.zza(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0011, B:19:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            java.io.InputStream r0 = r3.zzhji
            android.os.ParcelFileDescriptor r1 = r3.zzhjj
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r2 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ Throwable -> 0x001f }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x001f }
            com.google.android.gms.common.util.IOUtils.copyStream(r0, r2)     // Catch:{ Throwable -> 0x0015 }
            r2.close()     // Catch:{ Throwable -> 0x001f }
            if (r0 == 0) goto L_0x0014
            r0.close()     // Catch:{ IOException -> 0x002b }
        L_0x0014:
            return
        L_0x0015:
            r1 = move-exception
            r2.close()     // Catch:{ Throwable -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzeid.zza((java.lang.Throwable) r1, (java.lang.Throwable) r2)     // Catch:{ Throwable -> 0x001f }
        L_0x001e:
            throw r1     // Catch:{ Throwable -> 0x001f }
        L_0x001f:
            r1 = move-exception
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ Throwable -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzeid.zza((java.lang.Throwable) r1, (java.lang.Throwable) r0)     // Catch:{ IOException -> 0x002b }
        L_0x002a:
            throw r1     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdof.run():void");
    }
}
