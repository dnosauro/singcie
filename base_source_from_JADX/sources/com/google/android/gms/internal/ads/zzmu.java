package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;

final class zzmu {
    private final zzjy zzarh;
    private final zzjw[] zzbel;
    private zzjw zzbem;

    public zzmu(zzjw[] zzjwArr, zzjy zzjy) {
        this.zzbel = zzjwArr;
        this.zzarh = zzjy;
    }

    public final void release() {
        zzjw zzjw = this.zzbem;
        if (zzjw != null) {
            zzjw.release();
            this.zzbem = null;
        }
    }

    public final zzjw zza(zzjz zzjz, Uri uri) {
        zzjw zzjw = this.zzbem;
        if (zzjw != null) {
            return zzjw;
        }
        zzjw[] zzjwArr = this.zzbel;
        int length = zzjwArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjw zzjw2 = zzjwArr[i];
            try {
                if (zzjw2.zza(zzjz)) {
                    this.zzbem = zzjw2;
                    zzjz.zzgq();
                    break;
                }
                zzjz.zzgq();
                i++;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                zzjz.zzgq();
                throw th;
            }
        }
        zzjw zzjw3 = this.zzbem;
        if (zzjw3 != null) {
            zzjw3.zza(this.zzarh);
            return this.zzbem;
        }
        String zza = zzpt.zza((Object[]) this.zzbel);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zznt(sb.toString(), uri);
    }
}
