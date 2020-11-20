package com.google.android.gms.internal.ads;

public enum zzenz {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzeiu.zziiy),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzior;

    private zzenz(Object obj) {
        this.zzior = obj;
    }
}
