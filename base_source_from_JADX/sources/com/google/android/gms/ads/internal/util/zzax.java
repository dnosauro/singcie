package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzae;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzl;
import com.google.android.gms.internal.ads.zzy;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzax {
    private static zzae zzeem;
    private static final Object zzeen = new Object();
    @Deprecated
    private static final zzbb<Void> zzeeo = new zzba();

    public zzax(Context context) {
        zzbl(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzae zzbl(android.content.Context r3) {
        /*
            java.lang.Object r0 = zzeen
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzae r1 = zzeem     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzabf.initialize(r3)     // Catch:{ all -> 0x0036 }
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzctk     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0036 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.ads.internal.util.zzaq.zzbk(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x0030
        L_0x002c:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzbk.zza(r3)     // Catch:{ all -> 0x0036 }
        L_0x0030:
            zzeem = r3     // Catch:{ all -> 0x0036 }
        L_0x0032:
            com.google.android.gms.internal.ads.zzae r3 = zzeem     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzax.zzbl(android.content.Context):com.google.android.gms.internal.ads.zzae");
    }

    public static zzdyz<zzy> zzer(String str) {
        zzazq zzazq = new zzazq();
        zzeem.zze(new zzbd(str, zzazq));
        return zzazq;
    }

    public final zzdyz<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        String str2 = str;
        zzbe zzbe = new zzbe((zzba) null);
        zzaz zzaz = new zzaz(this, str2, zzbe);
        zzayu zzayu = new zzayu((String) null);
        zzbc zzbc = new zzbc(this, i, str, zzbe, zzaz, bArr, map, zzayu);
        if (zzayu.isEnabled()) {
            try {
                zzayu.zza(str2, "GET", zzbc.getHeaders(), zzbc.zzg());
            } catch (zzl e) {
                zzd.zzfa(e.getMessage());
            }
        }
        zzeem.zze(zzbc);
        return zzbe;
    }

    public final zzdyz<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, (byte[]) null);
    }
}
