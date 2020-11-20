package com.shockwave.pdfium.util;

public class SizeF {

    /* renamed from: a */
    private final float f7249a;

    /* renamed from: b */
    private final float f7250b;

    public SizeF(float f, float f2) {
        this.f7249a = f;
        this.f7250b = f2;
    }

    /* renamed from: a */
    public float mo24006a() {
        return this.f7249a;
    }

    /* renamed from: b */
    public float mo24007b() {
        return this.f7250b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeF)) {
            return false;
        }
        SizeF sizeF = (SizeF) obj;
        return this.f7249a == sizeF.f7249a && this.f7250b == sizeF.f7250b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f7249a) ^ Float.floatToIntBits(this.f7250b);
    }

    public String toString() {
        return this.f7249a + "x" + this.f7250b;
    }
}
