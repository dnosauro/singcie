package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzca;
import java.util.HashMap;
import java.util.concurrent.Callable;

final /* synthetic */ class zzdhz implements Callable {
    static final Callable zzgzz = new zzdhz();

    private zzdhz() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzwq.zzqe().zzd(zzabf.zzcmu);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcmv)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzca.zzes(str2));
                }
            }
        }
        return new zzdhx(hashMap);
    }
}
