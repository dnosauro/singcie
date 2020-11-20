package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

abstract class zzwn<T> {
    private static final zzxp zzciu = zzpx();

    zzwn() {
    }

    private static zzxp zzpx() {
        try {
            Object newInstance = zzvx.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzaza.zzfa("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return queryLocalInterface instanceof zzxp ? (zzxp) queryLocalInterface : new zzxr(iBinder);
        } catch (Exception unused) {
            zzaza.zzfa("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T zzpy() {
        zzxp zzxp = zzciu;
        if (zzxp == null) {
            zzaza.zzfa("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzxp);
        } catch (RemoteException e) {
            zzaza.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final T zzpz() {
        try {
            return zzpu();
        } catch (RemoteException e) {
            zzaza.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zzxp zzxp);

    public final T zzd(Context context, boolean z) {
        T t;
        boolean z2 = false;
        boolean z3 = z;
        if (!z3) {
            zzwq.zzqa();
            if (!zzayr.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzaza.zzeb("Google Play Services is not available.");
                z3 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = true;
        }
        zzabf.initialize(context);
        if (zzacx.zzdca.get().booleanValue()) {
            z3 = false;
        }
        if (z3) {
            t = zzpy();
            if (t == null) {
                t = zzpz();
            }
        } else {
            T zzpz = zzpz();
            int i = zzpz == null ? 1 : 0;
            if (i != 0) {
                if (zzwq.zzqh().nextInt(zzadg.zzddd.get().intValue()) == 0) {
                    z2 = true;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzwq.zzqa().zza(context, zzwq.zzqg().zzbrf, "gmob-apps", bundle, true);
                }
            }
            t = zzpz == null ? zzpy() : zzpz;
        }
        return t == null ? zzpt() : t;
    }

    /* access modifiers changed from: protected */
    public abstract T zzpt();

    /* access modifiers changed from: protected */
    public abstract T zzpu();
}
