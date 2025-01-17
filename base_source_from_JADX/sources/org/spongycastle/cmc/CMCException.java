package org.spongycastle.cmc;

public class CMCException extends Exception {
    private final Throwable cause;

    public CMCException(String str) {
        this(str, (Throwable) null);
    }

    public CMCException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
