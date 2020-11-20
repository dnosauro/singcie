package org.spongycastle.util;

public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f8256_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f8256_e = th;
    }

    public Throwable getCause() {
        return this.f8256_e;
    }
}
