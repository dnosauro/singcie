package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzeg extends zzdx {
    private zzeg(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    public static zzeg zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcw.zzng);
    }

    public static zzeg zzb(String str, Context context, boolean z, int i) {
        zza(context, z);
        zza(str, context, z, i);
        return new zzeg(context, str, z, i);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zza(zzfa zzfa, Context context, zzcf.zza.C3704zza zza, zzby.zza zza2) {
        if (zzfa.zzcg() == null || !this.zzwn) {
            return super.zza(zzfa, context, zza, zza2);
        }
        int zzbu = zzfa.zzbu();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzfa, context, zza, zza2));
        arrayList.add(new zzfu(zzfa, "nzsGgLmkYoH07JBds4475Hi1VD4Q7uBNBbOuNVMIAgaPK31s5yXBWpEE3pcrsbq6", "YtmG0d5ZvAZhPKacOdj22mtx44uyqECBIblkm9VYJ9w=", zza, zzbu, 24));
        return arrayList;
    }
}
