package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class zzabg {
    private static void zza(List<String> list, zzacn<String> zzacn) {
        String str = zzacn.get();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }

    static List<String> zzrp() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzacn.zzi("gad:dynamite_module:experiment_id", ""));
        zza(arrayList, zzacz.zzdch);
        zza(arrayList, zzacz.zzdci);
        zza(arrayList, zzacz.zzdcj);
        zza(arrayList, zzacz.zzdck);
        zza(arrayList, zzacz.zzdcl);
        zza(arrayList, zzacz.zzdcr);
        zza(arrayList, zzacz.zzdcm);
        zza(arrayList, zzacz.zzdcn);
        zza(arrayList, zzacz.zzdco);
        zza(arrayList, zzacz.zzdcp);
        zza(arrayList, zzacz.zzdcq);
        return arrayList;
    }

    static List<String> zzrq() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzadi.zzddm);
        return arrayList;
    }
}
