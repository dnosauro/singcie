package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzepa {
    public static final zzepa zziyq = new zzepa(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzepa zziyr = new zzepa(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzepa zziys = new zzepa(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzepa zziyt = new zzepa(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a */
    private final double f6900a;

    /* renamed from: b */
    private final double f6901b;

    /* renamed from: c */
    private final double f6902c;

    /* renamed from: d */
    private final double f6903d;

    /* renamed from: w */
    private final double f6904w;
    private final double zziym;
    private final double zziyn;
    private final double zziyo;
    private final double zziyp;

    private zzepa(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zziym = d5;
        this.zziyn = d6;
        this.f6904w = d7;
        this.f6900a = d;
        this.f6901b = d2;
        this.f6902c = d3;
        this.f6903d = d4;
        this.zziyo = d8;
        this.zziyp = d9;
    }

    public static zzepa zzs(ByteBuffer byteBuffer) {
        double zzi = zzbq.zzi(byteBuffer);
        double zzi2 = zzbq.zzi(byteBuffer);
        double zzj = zzbq.zzj(byteBuffer);
        return new zzepa(zzi, zzi2, zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer), zzj, zzbq.zzj(byteBuffer), zzbq.zzj(byteBuffer), zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzepa zzepa = (zzepa) obj;
        return Double.compare(zzepa.f6900a, this.f6900a) == 0 && Double.compare(zzepa.f6901b, this.f6901b) == 0 && Double.compare(zzepa.f6902c, this.f6902c) == 0 && Double.compare(zzepa.f6903d, this.f6903d) == 0 && Double.compare(zzepa.zziyo, this.zziyo) == 0 && Double.compare(zzepa.zziyp, this.zziyp) == 0 && Double.compare(zzepa.zziym, this.zziym) == 0 && Double.compare(zzepa.zziyn, this.zziyn) == 0 && Double.compare(zzepa.f6904w, this.f6904w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zziym);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zziyn);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f6904w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f6900a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f6901b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f6902c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f6903d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zziyo);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zziyp);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zziyq)) {
            return "Rotate 0°";
        }
        if (equals(zziyr)) {
            return "Rotate 90°";
        }
        if (equals(zziys)) {
            return "Rotate 180°";
        }
        if (equals(zziyt)) {
            return "Rotate 270°";
        }
        double d = this.zziym;
        double d2 = this.zziyn;
        double d3 = this.f6904w;
        double d4 = this.f6900a;
        double d5 = this.f6901b;
        double d6 = this.f6902c;
        double d7 = this.f6903d;
        double d8 = this.zziyo;
        double d9 = this.zziyp;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }
}
