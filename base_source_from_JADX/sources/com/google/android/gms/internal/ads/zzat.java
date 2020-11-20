package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class zzat {
    private static final Comparator<byte[]> zzcb = new zzaw();
    private final List<byte[]> zzbx = new ArrayList();
    private final List<byte[]> zzby = new ArrayList(64);
    private int zzbz = 0;
    private final int zzca = 4096;

    public zzat(int i) {
    }

    private final synchronized void zzn() {
        while (this.zzbz > this.zzca) {
            byte[] remove = this.zzbx.remove(0);
            this.zzby.remove(remove);
            this.zzbz -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.zzca     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.zzbx     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.zzby     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = zzcb     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.zzby     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.zzbz     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.zzbz = r0     // Catch:{ all -> 0x002b }
            r2.zzn()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzat.zza(byte[]):void");
    }

    public final synchronized byte[] zzf(int i) {
        for (int i2 = 0; i2 < this.zzby.size(); i2++) {
            byte[] bArr = this.zzby.get(i2);
            if (bArr.length >= i) {
                this.zzbz -= bArr.length;
                this.zzby.remove(i2);
                this.zzbx.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
