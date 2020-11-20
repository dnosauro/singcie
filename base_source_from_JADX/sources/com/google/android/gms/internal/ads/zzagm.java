package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

public final class zzagm extends RemoteCreator<zzaev> {
    @VisibleForTesting
    public zzagm() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return queryLocalInterface instanceof zzaev ? (zzaev) queryLocalInterface : new zzaeu(iBinder);
    }

    public final zzaeq zzb(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        try {
            IBinder zzb = ((zzaev) getRemoteCreatorInstance(view.getContext())).zzb(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return queryLocalInterface instanceof zzaeq ? (zzaeq) queryLocalInterface : new zzaes(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.zzd("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        }
    }
}
