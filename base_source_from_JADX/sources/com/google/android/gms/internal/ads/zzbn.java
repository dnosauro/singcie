package com.google.android.gms.internal.ads;

import java.io.Closeable;

public class zzbn extends zzeop implements Closeable {
    private static zzeox zzcz = zzeox.zzn(zzbn.class);

    public zzbn(zzeor zzeor, zzbo zzbo) {
        zza(zzeor, zzeor.size(), zzbo);
    }

    public void close() {
        this.zziyc.close();
    }

    public String toString() {
        String obj = this.zziyc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
