package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.asn1.eac.CertificateBody;

public class ASN1OutputStream {

    /* renamed from: os */
    private OutputStream f7343os;

    private class ImplicitOutputStream extends ASN1OutputStream {
        private boolean first = true;

        public ImplicitOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public void write(int i) {
            if (this.first) {
                this.first = false;
            } else {
                ASN1OutputStream.super.write(i);
            }
        }
    }

    public ASN1OutputStream(OutputStream outputStream) {
        this.f7343os = outputStream;
    }

    public void close() {
        this.f7343os.close();
    }

    public void flush() {
        this.f7343os.flush();
    }

    /* access modifiers changed from: package-private */
    public ASN1OutputStream getDERSubStream() {
        return new DEROutputStream(this.f7343os);
    }

    /* access modifiers changed from: package-private */
    public ASN1OutputStream getDLSubStream() {
        return new DLOutputStream(this.f7343os);
    }

    /* access modifiers changed from: package-private */
    public void write(int i) {
        this.f7343os.write(i);
    }

    /* access modifiers changed from: package-private */
    public void write(byte[] bArr) {
        this.f7343os.write(bArr);
    }

    /* access modifiers changed from: package-private */
    public void write(byte[] bArr, int i, int i2) {
        this.f7343os.write(bArr, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void writeEncoded(int i, int i2, byte[] bArr) {
        writeTag(i, i2);
        writeLength(bArr.length);
        write(bArr);
    }

    /* access modifiers changed from: package-private */
    public void writeEncoded(int i, byte[] bArr) {
        write(i);
        writeLength(bArr.length);
        write(bArr);
    }

    /* access modifiers changed from: package-private */
    public void writeImplicitObject(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive != null) {
            aSN1Primitive.encode(new ImplicitOutputStream(this.f7343os));
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public void writeLength(int i) {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            write((int) (byte) (i3 | 128));
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                write((int) (byte) (i >> i4));
            }
            return;
        }
        write((int) (byte) i);
    }

    /* access modifiers changed from: protected */
    public void writeNull() {
        this.f7343os.write(5);
        this.f7343os.write(0);
    }

    public void writeObject(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1Encodable.toASN1Primitive().encode(this);
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public void writeTag(int i, int i2) {
        if (i2 < 31) {
            write(i | i2);
            return;
        }
        write(i | 31);
        if (i2 < 128) {
            write(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int length = bArr.length - 1;
        bArr[length] = (byte) (i2 & CertificateBody.profileType);
        do {
            i2 >>= 7;
            length--;
            bArr[length] = (byte) ((i2 & CertificateBody.profileType) | 128);
        } while (i2 > 127);
        write(bArr, length, bArr.length - length);
    }
}
