package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzdg extends zzdc<Boolean> {
    zzdg(zzdl zzdl, String str, Boolean bool, boolean z) {
        super(zzdl, str, bool, true, (zzdh) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzck.zzb.matcher(str).matches()) {
                return true;
            }
            if (zzck.zzc.matcher(str).matches()) {
                return false;
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(zzb);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
