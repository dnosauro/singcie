package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaef implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzaff zzder;

    public zzaef(zzaff zzaff) {
        this.zzder = zzaff;
        try {
            zzaff.zztd();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zzder.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zzder.zztc();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }
}
