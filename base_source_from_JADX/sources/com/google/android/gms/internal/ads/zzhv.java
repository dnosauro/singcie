package com.google.android.gms.internal.ads;

public final class zzhv {
    public static final zzhv zzahx = new zzhv(1.0f, 1.0f);
    public final float zzahy;
    public final float zzahz;
    private final int zzaia;

    public zzhv(float f, float f2) {
        this.zzahy = f;
        this.zzahz = f2;
        this.zzaia = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzhv zzhv = (zzhv) obj;
            return this.zzahy == zzhv.zzahy && this.zzahz == zzhv.zzahz;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzahy) + 527) * 31) + Float.floatToRawIntBits(this.zzahz);
    }

    public final long zzdu(long j) {
        return j * ((long) this.zzaia);
    }
}
