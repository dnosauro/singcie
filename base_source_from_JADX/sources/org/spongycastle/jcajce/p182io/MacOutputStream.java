package org.spongycastle.jcajce.p182io;

import java.io.OutputStream;
import javax.crypto.Mac;

/* renamed from: org.spongycastle.jcajce.io.MacOutputStream */
public final class MacOutputStream extends OutputStream {
    private Mac mac;

    public MacOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public byte[] getMac() {
        return this.mac.doFinal();
    }

    public void write(int i) {
        this.mac.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
    }
}
