package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzcrg {
    private final List<zzvr> zzadt = Collections.synchronizedList(new ArrayList());
    private zzdmu zzeri = null;
    private final Map<String, zzvr> zzgqt = Collections.synchronizedMap(new HashMap());

    public final List<zzvr> getAdapterResponses() {
        return this.zzadt;
    }

    public final void zza(zzdmu zzdmu, long j, zzve zzve) {
        String str = zzdmu.zzdkx;
        if (this.zzgqt.containsKey(str)) {
            if (this.zzeri == null) {
                this.zzeri = zzdmu;
            }
            zzvr zzvr = this.zzgqt.get(str);
            zzvr.zzchz = j;
            zzvr.zzcia = zzve;
        }
    }

    public final zzbrp zzarl() {
        return new zzbrp(this.zzeri, "", this);
    }

    public final void zzd(zzdmu zzdmu) {
        String str = zzdmu.zzdkx;
        if (!this.zzgqt.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzdmu.zzhha.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzdmu.zzhha.getString(next));
                } catch (JSONException unused) {
                }
            }
            zzvr zzvr = new zzvr(zzdmu.zzhhe, 0, (zzve) null, bundle);
            this.zzadt.add(zzvr);
            this.zzgqt.put(str, zzvr);
        }
    }
}
