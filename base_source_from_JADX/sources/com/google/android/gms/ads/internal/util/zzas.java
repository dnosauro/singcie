package com.google.android.gms.ads.internal.util;

public final class zzas extends Exception {
    private final int errorCode;

    public zzas(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
