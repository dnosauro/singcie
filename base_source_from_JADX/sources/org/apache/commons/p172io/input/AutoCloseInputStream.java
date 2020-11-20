package org.apache.commons.p172io.input;

import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.AutoCloseInputStream */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    /* access modifiers changed from: protected */
    public void afterRead(int i) {
        if (i == -1) {
            close();
        }
    }

    public void close() {
        this.in.close();
        this.in = new ClosedInputStream();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        close();
        super.finalize();
    }
}
