package org.spongycastle.cms;

public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* renamed from: e */
    Exception f7454e;

    public CMSAttributeTableGenerationException(String str) {
        super(str);
    }

    public CMSAttributeTableGenerationException(String str, Exception exc) {
        super(str);
        this.f7454e = exc;
    }

    public Throwable getCause() {
        return this.f7454e;
    }

    public Exception getUnderlyingException() {
        return this.f7454e;
    }
}
