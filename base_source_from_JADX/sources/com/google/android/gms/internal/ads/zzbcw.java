package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbcw implements Runnable {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeob;
    private final /* synthetic */ int zzeoc;
    private final /* synthetic */ int zzeod;
    private final /* synthetic */ boolean zzeoe = false;
    private final /* synthetic */ zzbcx zzeof;

    zzbcw(zzbcx zzbcx, String str, String str2, int i, int i2, boolean z) {
        this.zzeof = zzbcx;
        this.zzees = str;
        this.zzeob = str2;
        this.zzeoc = i;
        this.zzeod = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzees);
        hashMap.put("cachedSrc", this.zzeob);
        hashMap.put("bytesLoaded", Integer.toString(this.zzeoc));
        hashMap.put("totalBytes", Integer.toString(this.zzeod));
        hashMap.put("cacheReady", "0");
        this.zzeof.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
