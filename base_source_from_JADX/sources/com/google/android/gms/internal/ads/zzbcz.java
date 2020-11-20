package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;

final class zzbcz implements Runnable {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeob;
    private final /* synthetic */ boolean zzeoe;
    private final /* synthetic */ zzbcx zzeof;
    private final /* synthetic */ long zzeoh;
    private final /* synthetic */ long zzeoi;
    private final /* synthetic */ int zzeoj;
    private final /* synthetic */ int zzeok;
    private final /* synthetic */ long zzeol;
    private final /* synthetic */ long zzeom;
    private final /* synthetic */ long zzeon;

    zzbcz(zzbcx zzbcx, String str, String str2, long j, long j2, long j3, long j4, long j5, boolean z, int i, int i2) {
        this.zzeof = zzbcx;
        this.zzees = str;
        this.zzeob = str2;
        this.zzeoh = j;
        this.zzeoi = j2;
        this.zzeol = j3;
        this.zzeom = j4;
        this.zzeon = j5;
        this.zzeoe = z;
        this.zzeoj = i;
        this.zzeok = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzees);
        hashMap.put("cachedSrc", this.zzeob);
        hashMap.put("bufferedDuration", Long.toString(this.zzeoh));
        hashMap.put("totalDuration", Long.toString(this.zzeoi));
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.zzeol));
            hashMap.put("qoeCachedBytes", Long.toString(this.zzeom));
            hashMap.put("totalBytes", Long.toString(this.zzeon));
            hashMap.put("reportTime", Long.toString(zzp.zzkx().currentTimeMillis()));
        }
        hashMap.put("cacheReady", this.zzeoe ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzeoj));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzeok));
        this.zzeof.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
