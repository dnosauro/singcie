package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.p018c.C0400a;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzue;

public final class zzcah implements zzp, zzbtj {
    private final Context context;
    private final zzazh zzbpd;
    private final zzbdv zzdii;
    private final zzdmu zzeri;
    @VisibleForTesting
    private IObjectWrapper zzfue;
    private final zzue.zza.C3719zza zzgac;

    public zzcah(Context context2, zzbdv zzbdv, zzdmu zzdmu, zzazh zzazh, zzue.zza.C3719zza zza) {
        this.context = context2;
        this.zzdii = zzbdv;
        this.zzeri = zzdmu;
        this.zzbpd = zzazh;
        this.zzgac = zza;
    }

    public final void onAdLoaded() {
        IObjectWrapper iObjectWrapper;
        zzare zzare;
        zzarg zzarg;
        if ((this.zzgac == zzue.zza.C3719zza.REWARD_BASED_VIDEO_AD || this.zzgac == zzue.zza.C3719zza.INTERSTITIAL || this.zzgac == zzue.zza.C3719zza.APP_OPEN) && this.zzeri.zzdvl && this.zzdii != null && com.google.android.gms.ads.internal.zzp.zzlf().zzm(this.context)) {
            int i = this.zzbpd.zzegl;
            int i2 = this.zzbpd.zzegm;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            String sb2 = sb.toString();
            String videoEventsOwner = this.zzeri.zzhhi.getVideoEventsOwner();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcul)).booleanValue()) {
                if (this.zzeri.zzhhi.getMediaType() == OmidMediaType.VIDEO) {
                    zzare = zzare.VIDEO;
                    zzarg = zzarg.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzarg = this.zzeri.zzhhj == 2 ? zzarg.UNSPECIFIED : zzarg.BEGIN_TO_RENDER;
                    zzare = zzare.HTML_DISPLAY;
                }
                iObjectWrapper = com.google.android.gms.ads.internal.zzp.zzlf().zza(sb2, this.zzdii.getWebView(), "", "javascript", videoEventsOwner, zzarg, zzare, this.zzeri.zzche);
            } else {
                iObjectWrapper = com.google.android.gms.ads.internal.zzp.zzlf().zza(sb2, this.zzdii.getWebView(), "", "javascript", videoEventsOwner);
            }
            this.zzfue = iObjectWrapper;
            if (this.zzfue != null && this.zzdii.getView() != null) {
                com.google.android.gms.ads.internal.zzp.zzlf().zza(this.zzfue, this.zzdii.getView());
                this.zzdii.zzaq(this.zzfue);
                com.google.android.gms.ads.internal.zzp.zzlf().zzab(this.zzfue);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuo)).booleanValue()) {
                    this.zzdii.zza("onSdkLoaded", new C0400a());
                }
            }
        }
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        this.zzfue = null;
    }

    public final void zzux() {
        zzbdv zzbdv;
        if (this.zzfue != null && (zzbdv = this.zzdii) != null) {
            zzbdv.zza("onSdkImpression", new C0400a());
        }
    }
}
