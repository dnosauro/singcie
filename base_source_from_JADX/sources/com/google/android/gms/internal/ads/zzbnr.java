package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.p018c.C0400a;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzbnr implements zzbsm, zzbtj {
    private final Context context;
    private final zzazh zzbpd;
    private final zzbdv zzdii;
    private final zzdmu zzeri;
    @GuardedBy("this")
    private IObjectWrapper zzfue;
    @GuardedBy("this")
    private boolean zzfuf;

    public zzbnr(Context context2, zzbdv zzbdv, zzdmu zzdmu, zzazh zzazh) {
        this.context = context2;
        this.zzdii = zzbdv;
        this.zzeri = zzdmu;
        this.zzbpd = zzazh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzajv() {
        /*
            r13 = this;
            monitor-enter(r13)
            com.google.android.gms.internal.ads.zzdmu r0 = r13.zzeri     // Catch:{ all -> 0x00ea }
            boolean r0 = r0.zzdvl     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r13)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbdv r0 = r13.zzdii     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r13)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzard r0 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00ea }
            android.content.Context r1 = r13.context     // Catch:{ all -> 0x00ea }
            boolean r0 = r0.zzm(r1)     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r13)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzazh r0 = r13.zzbpd     // Catch:{ all -> 0x00ea }
            int r0 = r0.zzegl     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzazh r1 = r13.zzbpd     // Catch:{ all -> 0x00ea }
            int r1 = r1.zzegm     // Catch:{ all -> 0x00ea }
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r3.<init>(r2)     // Catch:{ all -> 0x00ea }
            r3.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x00ea }
            r3.append(r1)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzdmu r0 = r13.zzeri     // Catch:{ all -> 0x00ea }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r0 = r0.zzhhi     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = r0.getVideoEventsOwner()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcul     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00ea }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00ea }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00ea }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ea }
            r1 = 1
            if (r0 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzdmu r0 = r13.zzeri     // Catch:{ all -> 0x00ea }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r0 = r0.zzhhi     // Catch:{ all -> 0x00ea }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType r0 = r0.getMediaType()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType r2 = com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType.VIDEO     // Catch:{ all -> 0x00ea }
            if (r0 != r2) goto L_0x0069
            com.google.android.gms.internal.ads.zzare r0 = com.google.android.gms.internal.ads.zzare.VIDEO     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzarg r2 = com.google.android.gms.internal.ads.zzarg.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00ea }
        L_0x0066:
            r11 = r0
            r10 = r2
            goto L_0x0077
        L_0x0069:
            com.google.android.gms.internal.ads.zzare r0 = com.google.android.gms.internal.ads.zzare.HTML_DISPLAY     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzdmu r2 = r13.zzeri     // Catch:{ all -> 0x00ea }
            int r2 = r2.zzhgq     // Catch:{ all -> 0x00ea }
            if (r2 != r1) goto L_0x0074
            com.google.android.gms.internal.ads.zzarg r2 = com.google.android.gms.internal.ads.zzarg.ONE_PIXEL     // Catch:{ all -> 0x00ea }
            goto L_0x0066
        L_0x0074:
            com.google.android.gms.internal.ads.zzarg r2 = com.google.android.gms.internal.ads.zzarg.BEGIN_TO_RENDER     // Catch:{ all -> 0x00ea }
            goto L_0x0066
        L_0x0077:
            com.google.android.gms.internal.ads.zzard r4 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzbdv r0 = r13.zzdii     // Catch:{ all -> 0x00ea }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.internal.ads.zzdmu r0 = r13.zzeri     // Catch:{ all -> 0x00ea }
            java.lang.String r12 = r0.zzche     // Catch:{ all -> 0x00ea }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00ea }
        L_0x008d:
            r13.zzfue = r0     // Catch:{ all -> 0x00ea }
            goto L_0x00a3
        L_0x0090:
            com.google.android.gms.internal.ads.zzard r4 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzbdv r0 = r13.zzdii     // Catch:{ all -> 0x00ea }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00ea }
            goto L_0x008d
        L_0x00a3:
            com.google.android.gms.internal.ads.zzbdv r0 = r13.zzdii     // Catch:{ all -> 0x00ea }
            android.view.View r0 = r0.getView()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzfue     // Catch:{ all -> 0x00ea }
            if (r2 == 0) goto L_0x00e8
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.ads.zzard r2 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.dynamic.IObjectWrapper r3 = r13.zzfue     // Catch:{ all -> 0x00ea }
            r2.zza(r3, r0)     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzbdv r0 = r13.zzdii     // Catch:{ all -> 0x00ea }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzfue     // Catch:{ all -> 0x00ea }
            r0.zzaq(r2)     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzard r0 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00ea }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzfue     // Catch:{ all -> 0x00ea }
            r0.zzab(r2)     // Catch:{ all -> 0x00ea }
            r13.zzfuf = r1     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcuo     // Catch:{ all -> 0x00ea }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00ea }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00ea }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00ea }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.ads.zzbdv r0 = r13.zzdii     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = "onSdkLoaded"
            androidx.c.a r2 = new androidx.c.a     // Catch:{ all -> 0x00ea }
            r2.<init>()     // Catch:{ all -> 0x00ea }
            r0.zza(r1, r2)     // Catch:{ all -> 0x00ea }
        L_0x00e8:
            monitor-exit(r13)
            return
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnr.zzajv():void");
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfuf) {
            zzajv();
        }
        if (!(!this.zzeri.zzdvl || this.zzfue == null || this.zzdii == null)) {
            this.zzdii.zza("onSdkImpression", new C0400a());
        }
    }

    public final synchronized void onAdLoaded() {
        if (!this.zzfuf) {
            zzajv();
        }
    }
}
