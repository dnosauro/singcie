package com.cyberneid.p105d.p108b;

import com.cyberneid.p105d.p109c.C1647i;
import com.cyberneid.p105d.p111d.C1664j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.List;

/* renamed from: com.cyberneid.d.b.n */
public final class C1618n extends FilterOutputStream {

    /* renamed from: a */
    private final List<C1647i> f5377a;

    /* renamed from: b */
    private final C1607d f5378b;

    /* renamed from: c */
    private ByteArrayOutputStream f5379c = new ByteArrayOutputStream();

    C1618n(List<C1647i> list, C1607d dVar, OutputStream outputStream, C1664j jVar) {
        super(outputStream);
        this.f5377a = list;
        this.f5378b = dVar;
    }

    public void close() {
        for (int size = this.f5377a.size() - 1; size >= 0; size--) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f5379c.toByteArray());
            this.f5379c = new ByteArrayOutputStream();
            this.f5377a.get(size).mo7693b(byteArrayInputStream, this.f5379c, this.f5378b, size);
        }
        this.out.write(this.f5379c.toByteArray());
        super.close();
    }

    public void flush() {
    }

    public void write(int i) {
        this.f5379c.write(i);
    }

    public void write(byte[] bArr) {
        this.f5379c.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f5379c.write(bArr, i, i2);
    }
}
