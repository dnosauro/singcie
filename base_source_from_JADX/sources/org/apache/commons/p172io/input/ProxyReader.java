package org.apache.commons.p172io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* renamed from: org.apache.commons.io.input.ProxyReader */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
    }

    /* access modifiers changed from: protected */
    public void afterRead(int i) {
    }

    /* access modifiers changed from: protected */
    public void beforeRead(int i) {
    }

    public void close() {
        try {
            this.in.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void handleIOException(IOException iOException) {
        throw iOException;
    }

    public synchronized void mark(int i) {
        try {
            this.in.mark(i);
        } catch (IOException e) {
            handleIOException(e);
        }
        return;
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }

    public int read() {
        int i = 1;
        try {
            beforeRead(1);
            int read = this.in.read();
            if (read == -1) {
                i = -1;
            }
            afterRead(i);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    public int read(CharBuffer charBuffer) {
        int i;
        if (charBuffer != null) {
            try {
                i = charBuffer.length();
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        } else {
            i = 0;
        }
        beforeRead(i);
        int read = this.in.read(charBuffer);
        afterRead(read);
        return read;
    }

    public int read(char[] cArr) {
        int i;
        if (cArr != null) {
            try {
                i = cArr.length;
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        } else {
            i = 0;
        }
        beforeRead(i);
        int read = this.in.read(cArr);
        afterRead(read);
        return read;
    }

    public int read(char[] cArr, int i, int i2) {
        try {
            beforeRead(i2);
            int read = this.in.read(cArr, i, i2);
            afterRead(read);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    public boolean ready() {
        try {
            return this.in.ready();
        } catch (IOException e) {
            handleIOException(e);
            return false;
        }
    }

    public synchronized void reset() {
        try {
            this.in.reset();
        } catch (IOException e) {
            handleIOException(e);
        }
        return;
    }

    public long skip(long j) {
        try {
            return this.in.skip(j);
        } catch (IOException e) {
            handleIOException(e);
            return 0;
        }
    }
}
