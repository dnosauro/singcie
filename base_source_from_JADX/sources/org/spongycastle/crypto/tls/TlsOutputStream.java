package org.spongycastle.crypto.tls;

import java.io.OutputStream;

class TlsOutputStream extends OutputStream {
    private byte[] buf = new byte[1];
    private TlsProtocol handler;

    TlsOutputStream(TlsProtocol tlsProtocol) {
        this.handler = tlsProtocol;
    }

    public void close() {
        this.handler.close();
    }

    public void flush() {
        this.handler.flush();
    }

    public void write(int i) {
        byte[] bArr = this.buf;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.handler.writeData(bArr, i, i2);
    }
}
