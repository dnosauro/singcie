package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzzp extends RemoteCreator<zzxx> {
    public zzzp() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof zzxx ? (zzxx) queryLocalInterface : new zzya(iBinder);
    }

    public final zzxw zzh(Context context) {
        try {
            IBinder zzb = ((zzxx) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), 203404000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return queryLocalInterface instanceof zzxw ? (zzxw) queryLocalInterface : new zzxy(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }
}
