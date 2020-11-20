package com.google.android.gms.internal.ads;

public abstract class zzeox {
    public static zzeox zzn(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzeou(cls.getSimpleName()) : new zzeow(cls.getSimpleName());
    }

    public abstract void zzii(String str);
}
