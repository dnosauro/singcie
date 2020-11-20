package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzue;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzcal implements zzbru, zzbxn {
    private final Context context;
    private final View view;
    private final zzawx zzbql;
    private final zzawu zzfuo;
    private final zzue.zza.C3719zza zzgac;
    private String zzgae;

    public zzcal(zzawu zzawu, Context context2, zzawx zzawx, View view2, zzue.zza.C3719zza zza) {
        this.zzfuo = zzawu;
        this.context = context2;
        this.zzbql = zzawx;
        this.view = view2;
        this.zzgac = zza;
    }

    public final void onAdClosed() {
        this.zzfuo.zzam(false);
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
        View view2 = this.view;
        if (!(view2 == null || this.zzgae == null)) {
            this.zzbql.zzf(view2.getContext(), this.zzgae);
        }
        this.zzfuo.zzam(true);
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzakl() {
    }

    public final void zzakn() {
        this.zzgae = this.zzbql.zzab(this.context);
        String valueOf = String.valueOf(this.zzgae);
        String valueOf2 = String.valueOf(this.zzgac == zzue.zza.C3719zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        this.zzgae = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzauf zzauf, String str, String str2) {
        if (this.zzbql.zzz(this.context)) {
            try {
                this.zzbql.zza(this.context, this.zzbql.zzae(this.context), this.zzfuo.getAdUnitId(), zzauf.getType(), zzauf.getAmount());
            } catch (RemoteException e) {
                zzd.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
