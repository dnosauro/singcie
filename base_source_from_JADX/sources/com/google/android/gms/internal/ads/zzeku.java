package com.google.android.gms.internal.ads;

public enum zzeku {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeiu.class, zzeiu.class, zzeiu.zziiy),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zziop;
    private final Class<?> zzioq;
    private final Object zzior;

    private zzeku(Class<?> cls, Class<?> cls2, Object obj) {
        this.zziop = cls;
        this.zzioq = cls2;
        this.zzior = obj;
    }

    public final Class<?> zzbis() {
        return this.zzioq;
    }
}
