package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzani;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzaui;
import com.google.android.gms.internal.ads.zzavh;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccy;
import com.google.android.gms.internal.ads.zzcxk;
import com.google.android.gms.internal.ads.zzcxm;
import com.google.android.gms.internal.ads.zzdij;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzxs;
import com.google.android.gms.internal.ads.zzxw;
import java.util.HashMap;

public class ClientApi extends zzxs {
    public final zzaen zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzccy((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 203404000);
    }

    public final zzaeq zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzccv((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaui zza(IObjectWrapper iObjectWrapper, zzani zzani, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbgm.zza(context, zzani, i).zzaez().zzcb(context).zzahn().zzahl();
    }

    public final zzwz zza(IObjectWrapper iObjectWrapper, String str, zzani zzani, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcxk(zzbgm.zza(context, zzani, i), context, str);
    }

    public final zzxg zza(IObjectWrapper iObjectWrapper, zzvn zzvn, String str, int i) {
        return new zzj((Context) ObjectWrapper.unwrap(iObjectWrapper), zzvn, str, new zzazh(203404000, i, true, false));
    }

    public final zzxg zza(IObjectWrapper iObjectWrapper, zzvn zzvn, String str, zzani zzani, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcxm(zzbgm.zza(context, zzani, i), context, zzvn, str);
    }

    public final zzxw zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbgm.zzf((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzaeq();
    }

    public final zzarj zzb(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(activity.getIntent());
        if (zzd == null) {
            return new zzs(activity);
        }
        switch (zzd.zzdrr) {
            case 1:
                return new zzt(activity);
            case 2:
                return new zzy(activity);
            case 3:
                return new zzaa(activity);
            case 4:
                return new zzv(activity, zzd);
            default:
                return new zzs(activity);
        }
    }

    public final zzavh zzb(IObjectWrapper iObjectWrapper, String str, zzani zzani, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbgm.zza(context, zzani, i).zzaez().zzcb(context).zzft(str).zzahn().zzahm();
    }

    public final zzaxq zzb(IObjectWrapper iObjectWrapper, zzani zzani, int i) {
        return zzbgm.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzani, i).zzafb();
    }

    public final zzxg zzb(IObjectWrapper iObjectWrapper, zzvn zzvn, String str, zzani zzani, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbgm.zza(context, zzani, i);
        return zzbgm.zza(context, zzani, i).zzaew().zzca(context).zzc(zzvn).zzfs(str).zzahk().zzahj();
    }

    public final zzaqw zzc(IObjectWrapper iObjectWrapper, zzani zzani, int i) {
        return zzbgm.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzani, i).zzafc();
    }

    public final zzxg zzc(IObjectWrapper iObjectWrapper, zzvn zzvn, String str, zzani zzani, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdij zzagw = zzbgm.zza(context, zzani, i).zzaeu().zzfr(str).zzbz(context).zzagw();
        return i >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcut)).intValue() ? zzagw.zzagv() : zzagw.zzagu();
    }

    public final zzxw zzc(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzaru zzd(IObjectWrapper iObjectWrapper) {
        return null;
    }
}
