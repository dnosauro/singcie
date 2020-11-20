package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbdb implements Runnable {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeob;
    private final /* synthetic */ int zzeod;
    private final /* synthetic */ zzbcx zzeof;

    zzbdb(zzbcx zzbcx, String str, String str2, int i) {
        this.zzeof = zzbcx;
        this.zzees = str;
        this.zzeob = str2;
        this.zzeod = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzees);
        hashMap.put("cachedSrc", this.zzeob);
        hashMap.put("totalBytes", Integer.toString(this.zzeod));
        this.zzeof.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
