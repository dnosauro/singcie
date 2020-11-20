package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final class zzdzl extends TimeoutException {
    private zzdzl(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
