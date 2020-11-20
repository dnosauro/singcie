package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbda implements Runnable {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeob;
    private final /* synthetic */ zzbcx zzeof;
    private final /* synthetic */ long zzeoi;

    zzbda(zzbcx zzbcx, String str, String str2, long j) {
        this.zzeof = zzbcx;
        this.zzees = str;
        this.zzeob = str2;
        this.zzeoi = j;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzees);
        hashMap.put("cachedSrc", this.zzeob);
        hashMap.put("totalDuration", Long.toString(this.zzeoi));
        this.zzeof.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
