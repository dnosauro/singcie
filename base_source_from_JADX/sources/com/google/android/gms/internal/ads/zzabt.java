package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzabt {
    private final Map<String, zzabq> zzczy = new HashMap();
    private final zzabs zzczz;

    public zzabt(zzabs zzabs) {
        this.zzczz = zzabs;
    }

    public final void zza(String str, zzabq zzabq) {
        this.zzczy.put(str, zzabq);
    }

    public final void zzb(String str, String str2, long j) {
        zzabs zzabs = this.zzczz;
        zzabq zzabq = this.zzczy.get(str2);
        String[] strArr = {str};
        if (!(zzabs == null || zzabq == null)) {
            zzabs.zza(zzabq, j, strArr);
        }
        Map<String, zzabq> map = this.zzczy;
        zzabs zzabs2 = this.zzczz;
        map.put(str, zzabs2 == null ? null : zzabs2.zzex(j));
    }

    public final zzabs zzry() {
        return this.zzczz;
    }
}
