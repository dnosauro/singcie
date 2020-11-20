package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public class zzasf {
    @GuardedBy("InternalQueryInfoGenerator.class")
    private static zzaxq zzdsc;
    private final Context context;
    private final zzza zzacr;
    private final AdFormat zzdsb;

    public zzasf(Context context2, AdFormat adFormat, zzza zzza) {
        this.context = context2;
        this.zzdsb = adFormat;
        this.zzacr = zzza;
    }

    public static zzaxq zzp(Context context2) {
        zzaxq zzaxq;
        synchronized (zzasf.class) {
            if (zzdsc == null) {
                zzdsc = zzwq.zzqb().zza(context2, (zzani) new zzanj());
            }
            zzaxq = zzdsc;
        }
        return zzaxq;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        String str;
        zzaxq zzp = zzp(this.context);
        if (zzp == null) {
            str = "Internal Error, query info generator is null.";
        } else {
            IObjectWrapper wrap = ObjectWrapper.wrap(this.context);
            zzza zzza = this.zzacr;
            try {
                zzp.zza(wrap, new zzaxw((String) null, this.zzdsb.name(), (zzvn) null, zzza == null ? new zzvj().zzpn() : zzvl.zza(this.context, zzza)), (zzaxp) new zzase(this, queryInfoGenerationCallback));
                return;
            } catch (RemoteException unused) {
                str = "Internal Error.";
            }
        }
        queryInfoGenerationCallback.onFailure(str);
    }
}
