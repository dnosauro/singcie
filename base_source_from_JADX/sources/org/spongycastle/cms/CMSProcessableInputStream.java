package org.spongycastle.cms;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.util.p191io.Streams;

class CMSProcessableInputStream implements CMSProcessable, CMSReadable {
    private InputStream input;
    private boolean used = false;

    public CMSProcessableInputStream(InputStream inputStream) {
        this.input = inputStream;
    }

    private synchronized void checkSingleUsage() {
        if (!this.used) {
            this.used = true;
        } else {
            throw new IllegalStateException("CMSProcessableInputStream can only be used once");
        }
    }

    public Object getContent() {
        return getInputStream();
    }

    public InputStream getInputStream() {
        checkSingleUsage();
        return this.input;
    }

    public void write(OutputStream outputStream) {
        checkSingleUsage();
        Streams.pipeAll(this.input, outputStream);
        this.input.close();
    }
}
