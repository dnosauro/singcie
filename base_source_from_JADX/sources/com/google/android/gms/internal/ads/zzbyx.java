package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

public final class zzbyx extends zzboc {
    private final Context context;
    private final zzcaf zzfss;
    private boolean zzfst = false;
    private final WeakReference<zzbdv> zzfzq;
    private final zzbxm zzfzr;
    private final zzbov zzfzs;
    private final zzdst zzfzt;
    private final zzbsb zzfzu;

    zzbyx(zzbob zzbob, Context context2, @Nullable zzbdv zzbdv, zzbxm zzbxm, zzcaf zzcaf, zzbov zzbov, zzdst zzdst, zzbsb zzbsb) {
        super(zzbob);
        this.context = context2;
        this.zzfzq = new WeakReference<>(zzbdv);
        this.zzfzr = zzbxm;
        this.zzfss = zzcaf;
        this.zzfzs = zzbov;
        this.zzfzt = zzdst;
        this.zzfzu = zzbsb;
    }

    public final void finalize() {
        try {
            zzbdv zzbdv = (zzbdv) this.zzfzq.get();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxt)).booleanValue()) {
                if (!this.zzfst && zzbdv != null) {
                    zzdzc zzdzc = zzazj.zzegt;
                    zzbdv.getClass();
                    zzdzc.execute(zzbza.zzh(zzbdv));
                }
            } else if (zzbdv != null) {
                zzbdv.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        return this.zzfzs.isClosed();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbh(boolean r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcnz
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.ads.internal.zzp.zzkq()
            android.content.Context r0 = r4.context
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.zzas(r0)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)
            com.google.android.gms.internal.ads.zzbsb r0 = r4.zzfzu
            r0.zzaky()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcoa
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzdst r0 = r4.zzfzt
            com.google.android.gms.internal.ads.zzdnj r3 = r4.zzfpr
            com.google.android.gms.internal.ads.zzdnh r3 = r3.zzhik
            com.google.android.gms.internal.ads.zzdmz r3 = r3.zzerj
            java.lang.String r3 = r3.zzbvf
            r0.zzgz(r3)
            goto L_0x004f
        L_0x0049:
            boolean r0 = r4.zzfst
            if (r0 != 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0053
            return r2
        L_0x0053:
            com.google.android.gms.internal.ads.zzbxm r0 = r4.zzfzr
            r0.zzakn()
            com.google.android.gms.internal.ads.zzcaf r0 = r4.zzfss     // Catch:{ zzcai -> 0x0067 }
            android.content.Context r3 = r4.context     // Catch:{ zzcai -> 0x0067 }
            r0.zza(r5, r3)     // Catch:{ zzcai -> 0x0067 }
            com.google.android.gms.internal.ads.zzbxm r5 = r4.zzfzr     // Catch:{ zzcai -> 0x0067 }
            r5.zzakl()     // Catch:{ zzcai -> 0x0067 }
            r4.zzfst = r1
            return r1
        L_0x0067:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbsb r0 = r4.zzfzu
            r0.zza(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyx.zzbh(boolean):boolean");
    }
}
