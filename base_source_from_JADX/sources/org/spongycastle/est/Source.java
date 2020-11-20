package org.spongycastle.est;

import java.io.InputStream;
import java.io.OutputStream;

public interface Source<T> {
    void close();

    InputStream getInputStream();

    OutputStream getOutputStream();

    T getSession();
}
