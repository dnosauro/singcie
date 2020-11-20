package com.p137e.p138a;

import com.p137e.p139b.C2138b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.eac.CertificateBody;

/* renamed from: com.e.a.c */
public class C2135c {

    /* renamed from: a */
    private byte[] f6596a;

    /* renamed from: b */
    private byte[] f6597b;

    public C2135c(byte[] bArr) {
        try {
            mo8745a(new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    /* renamed from: a */
    public final int mo8744a() {
        return this.f6597b.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8745a(InputStream inputStream) {
        int i;
        byte read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte read2 = (byte) inputStream.read();
        if (read2 != -1) {
            byteArrayOutputStream.write(read2);
            if ((read2 & 31) >= 31) {
                do {
                    read = (byte) inputStream.read();
                    if (read != -1) {
                        byteArrayOutputStream.write(read);
                    } else {
                        throw new C2133a();
                    }
                } while ((read & 128) >= 128);
            }
            this.f6596a = byteArrayOutputStream.toByteArray();
            int read3 = inputStream.read();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            int i2 = 0;
            if (read3 == 128) {
                loop1:
                while (true) {
                    int read4 = inputStream.read();
                    while (i2 == 0 && read4 != -1) {
                        if (read4 == 0) {
                            int read5 = inputStream.read();
                            if (read5 == 0) {
                                i2 = 1;
                            } else if (read5 == -1) {
                                read4 = read5;
                            } else {
                                byteArrayOutputStream2.write(read4);
                                byteArrayOutputStream2.write(read5);
                            }
                        } else {
                            byteArrayOutputStream2.write(read4);
                        }
                    }
                }
            } else {
                if ((read3 & 128) == 128) {
                    int i3 = read3 & CertificateBody.profileType;
                    byte[] bArr = new byte[i3];
                    if (inputStream.read(bArr) == i3) {
                        i = 0;
                        for (int i4 = 0; i4 < i3; i4++) {
                            i = (i << 8) + (bArr[i4] & 255);
                        }
                    } else {
                        throw new C2133a();
                    }
                } else {
                    i = read3 & 255;
                }
                while (i2 < i) {
                    int read6 = inputStream.read();
                    if (read6 != -1) {
                        byteArrayOutputStream2.write(read6);
                        i2++;
                    } else {
                        throw new C2133a();
                    }
                }
            }
            this.f6597b = byteArrayOutputStream2.toByteArray();
            return;
        }
        throw new C2133a();
    }

    /* renamed from: b */
    public final byte[] mo8746b() {
        return this.f6597b;
    }

    /* renamed from: c */
    public byte[] mo8747c() {
        int a = mo8744a();
        if (a < 128) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(this.f6596a);
                byteArrayOutputStream.write((byte) a);
                byteArrayOutputStream.write(mo8746b());
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            int i = a;
            int i2 = 0;
            while (i != 0) {
                i /= 256;
                i2++;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write(this.f6596a);
            byteArrayOutputStream2.write((byte) (i2 + 128));
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[(i2 - i3) - 1] = (byte) (a >> (i3 * 256));
                a /= 256;
            }
            byteArrayOutputStream2.write(bArr);
            byteArrayOutputStream2.write(mo8746b());
            return byteArrayOutputStream2.toByteArray();
        }
    }

    public String toString() {
        return C2138b.m8399b(mo8747c());
    }
}
