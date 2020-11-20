package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzazd {
    public static <T> T zza(Context context, String str, zzazc<IBinder, T> zzazc) {
        try {
            return zzazc.apply(zzbw(context).instantiate(str));
        } catch (Exception e) {
            throw new zzazf(e);
        }
    }

    public static Context zzbv(Context context) {
        return zzbw(context).getModuleContext();
    }

    private static DynamiteModule zzbw(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzazf(e);
        }
    }
}
