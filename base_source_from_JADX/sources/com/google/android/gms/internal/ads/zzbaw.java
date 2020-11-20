package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzbaw extends zzbao {
    public final zzbap zza(Context context, zzbbe zzbbe, int i, boolean z, zzabs zzabs, zzbbf zzbbf) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbbh zzbbh = new zzbbh(context, zzbbe.zzaao(), zzbbe.getRequestId(), zzabs, zzbbe.zzaai());
        if (i == 2) {
            return new zzbbl(context, zzbbh, zzbbe, z, zza(zzbbe), zzbbf);
        }
        return new zzbac(context, zzbbe, z, zza(zzbbe), zzbbf, new zzbbh(context, zzbbe.zzaao(), zzbbe.getRequestId(), zzabs, zzbbe.zzaai()));
    }
}
