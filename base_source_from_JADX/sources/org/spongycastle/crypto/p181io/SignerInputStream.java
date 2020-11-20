package org.spongycastle.crypto.p181io;

import java.io.FilterInputStream;
import java.io.InputStream;
import org.spongycastle.crypto.Signer;

/* renamed from: org.spongycastle.crypto.io.SignerInputStream */
public class SignerInputStream extends FilterInputStream {
    protected Signer signer;

    public SignerInputStream(InputStream inputStream, Signer signer2) {
        super(inputStream);
        this.signer = signer2;
    }

    public Signer getSigner() {
        return this.signer;
    }

    public int read() {
        int read = this.in.read();
        if (read >= 0) {
            this.signer.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read > 0) {
            this.signer.update(bArr, i, read);
        }
        return read;
    }
}
