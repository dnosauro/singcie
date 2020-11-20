package org.apache.commons.p172io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BrokenInputStream */
public class BrokenInputStream extends InputStream {
    private final IOException exception;

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }

    public BrokenInputStream(IOException iOException) {
        this.exception = iOException;
    }

    public int available() {
        throw this.exception;
    }

    public void close() {
        throw this.exception;
    }

    public int read() {
        throw this.exception;
    }

    public void reset() {
        throw this.exception;
    }

    public long skip(long j) {
        throw this.exception;
    }
}
