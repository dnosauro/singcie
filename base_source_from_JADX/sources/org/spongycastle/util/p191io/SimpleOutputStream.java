package org.spongycastle.util.p191io;

import java.io.OutputStream;

/* renamed from: org.spongycastle.util.io.SimpleOutputStream */
public abstract class SimpleOutputStream extends OutputStream {
    public void close() {
    }

    public void flush() {
    }

    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
