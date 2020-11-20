package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbcy implements Runnable {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeob;
    private final /* synthetic */ int zzeoc;
    private final /* synthetic */ int zzeod;
    private final /* synthetic */ boolean zzeoe;
    private final /* synthetic */ zzbcx zzeof;
    private final /* synthetic */ long zzeoh;
    private final /* synthetic */ long zzeoi;
    private final /* synthetic */ int zzeoj;
    private final /* synthetic */ int zzeok;

    zzbcy(zzbcx zzbcx, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzeof = zzbcx;
        this.zzees = str;
        this.zzeob = str2;
        this.zzeoc = i;
        this.zzeod = i2;
        this.zzeoh = j;
        this.zzeoi = j2;
        this.zzeoe = z;
        this.zzeoj = i3;
        this.zzeok = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzees);
        hashMap.put("cachedSrc", this.zzeob);
        hashMap.put("bytesLoaded", Integer.toString(this.zzeoc));
        hashMap.put("totalBytes", Integer.toString(this.zzeod));
        hashMap.put("bufferedDuration", Long.toString(this.zzeoh));
        hashMap.put("totalDuration", Long.toString(this.zzeoi));
        hashMap.put("cacheReady", this.zzeoe ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzeoj));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzeok));
        this.zzeof.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
