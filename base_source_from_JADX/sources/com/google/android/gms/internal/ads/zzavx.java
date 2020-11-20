package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzavx {
    public static zzavh zzd(Context context, String str, zzani zzani) {
        try {
            IBinder zzd = ((zzavn) zzazd.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzavw.zzbxv)).zzd(ObjectWrapper.wrap(context), str, zzani, 203404000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return queryLocalInterface instanceof zzavh ? (zzavh) queryLocalInterface : new zzavj(zzd);
        } catch (RemoteException | zzazf e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
