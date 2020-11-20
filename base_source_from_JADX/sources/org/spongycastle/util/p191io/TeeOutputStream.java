package org.spongycastle.util.p191io;

import java.io.OutputStream;

/* renamed from: org.spongycastle.util.io.TeeOutputStream */
public class TeeOutputStream extends OutputStream {
    private OutputStream output1;
    private OutputStream output2;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this.output1 = outputStream;
        this.output2 = outputStream2;
    }

    public void close() {
        this.output1.close();
        this.output2.close();
    }

    public void flush() {
        this.output1.flush();
        this.output2.flush();
    }

    public void write(int i) {
        this.output1.write(i);
        this.output2.write(i);
    }

    public void write(byte[] bArr) {
        this.output1.write(bArr);
        this.output2.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.output1.write(bArr, i, i2);
        this.output2.write(bArr, i, i2);
    }
}
