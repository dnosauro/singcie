package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbn {
    private Map<Integer, Bitmap> zzefb = new ConcurrentHashMap();
    private AtomicInteger zzefc = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzefb.get(num);
    }
}
