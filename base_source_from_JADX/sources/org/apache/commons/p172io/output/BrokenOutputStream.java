package org.apache.commons.p172io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.BrokenOutputStream */
public class BrokenOutputStream extends OutputStream {
    private final IOException exception;

    public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }

    public BrokenOutputStream(IOException iOException) {
        this.exception = iOException;
    }

    public void close() {
        throw this.exception;
    }

    public void flush() {
        throw this.exception;
    }

    public void write(int i) {
        throw this.exception;
    }
}
