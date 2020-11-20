package org.spongycastle.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f8257_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f8257_e = th;
    }

    public Throwable getCause() {
        return this.f8257_e;
    }
}
