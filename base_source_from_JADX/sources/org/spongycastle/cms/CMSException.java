package org.spongycastle.cms;

public class CMSException extends Exception {

    /* renamed from: e */
    Exception f7455e;

    public CMSException(String str) {
        super(str);
    }

    public CMSException(String str, Exception exc) {
        super(str);
        this.f7455e = exc;
    }

    public Throwable getCause() {
        return this.f7455e;
    }

    public Exception getUnderlyingException() {
        return this.f7455e;
    }
}
