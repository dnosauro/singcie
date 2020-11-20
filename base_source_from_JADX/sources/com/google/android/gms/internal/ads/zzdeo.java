package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

final /* synthetic */ class zzdeo implements Callable {
    private final List zzhat;

    zzdeo(List list) {
        this.zzhat = list;
    }

    public final Object call() {
        List<zzdyz> list = this.zzhat;
        JSONArray jSONArray = new JSONArray();
        for (zzdyz zzdyz : list) {
            if (((JSONObject) zzdyz.get()) != null) {
                jSONArray.put(zzdyz.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzdel(jSONArray.toString());
    }
}
