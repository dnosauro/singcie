package org.spongycastle.cms;

public class CMSRuntimeException extends RuntimeException {

    /* renamed from: e */
    Exception f7456e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f7456e = exc;
    }

    public Throwable getCause() {
        return this.f7456e;
    }

    public Exception getUnderlyingException() {
        return this.f7456e;
    }
}
