package com.shockwave.pdfium.util;

public class Size {

    /* renamed from: a */
    private final int f7247a;

    /* renamed from: b */
    private final int f7248b;

    public Size(int i, int i2) {
        this.f7247a = i;
        this.f7248b = i2;
    }

    /* renamed from: a */
    public int mo24001a() {
        return this.f7247a;
    }

    /* renamed from: b */
    public int mo24002b() {
        return this.f7248b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f7247a == size.f7247a && this.f7248b == size.f7248b;
    }

    public int hashCode() {
        int i = this.f7248b;
        int i2 = this.f7247a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f7247a + "x" + this.f7248b;
    }
}
