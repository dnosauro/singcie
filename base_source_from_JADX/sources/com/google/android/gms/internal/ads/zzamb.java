package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzamb implements zzakj, zzaly {
    private final zzalz zzdjs;
    private final HashSet<AbstractMap.SimpleEntry<String, zzahv<? super zzalz>>> zzdjt = new HashSet<>();

    public zzamb(zzalz zzalz) {
        this.zzdjs = zzalz;
    }

    public final void zza(String str, zzahv<? super zzalz> zzahv) {
        this.zzdjs.zza(str, zzahv);
        this.zzdjt.add(new AbstractMap.SimpleEntry(str, zzahv));
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zzb(String str, zzahv<? super zzalz> zzahv) {
        this.zzdjs.zzb(str, zzahv);
        this.zzdjt.remove(new AbstractMap.SimpleEntry(str, zzahv));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final void zzcy(String str) {
        this.zzdjs.zzcy(str);
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final void zztz() {
        Iterator<AbstractMap.SimpleEntry<String, zzahv<? super zzalz>>> it = this.zzdjt.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzahv) next.getValue()).toString());
            zzd.zzee(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdjs.zzb((String) next.getKey(), (zzahv) next.getValue());
        }
        this.zzdjt.clear();
    }
}
