package com.google.android.gms.internal.ads;

import android.util.Log;

public final class zzeou extends zzeox {
    private String name;

    public zzeou(String str) {
        this.name = str;
    }

    public final void zzii(String str) {
        String str2 = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
