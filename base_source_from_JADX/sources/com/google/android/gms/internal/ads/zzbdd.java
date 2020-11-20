package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class zzbdd implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeob;
    private final /* synthetic */ zzbcx zzeof;
    private final /* synthetic */ String zzeoo;

    zzbdd(zzbcx zzbcx, String str, String str2, String str3, String str4) {
        this.zzeof = zzbcx;
        this.zzees = str;
        this.zzeob = str2;
        this.zzeoo = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.zzees);
        if (!TextUtils.isEmpty(this.zzeob)) {
            hashMap.put("cachedSrc", this.zzeob);
        }
        hashMap.put("type", zzbcx.zzfl(this.zzeoo));
        hashMap.put("reason", this.zzeoo);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzeof.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
