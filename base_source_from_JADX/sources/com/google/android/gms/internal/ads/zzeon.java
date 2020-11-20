package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public class zzeon extends zzeop implements zzbp {
    private String type;
    private long zzawl;
    private zzbs zzixv;
    private boolean zzixw;

    public zzeon(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbs zzbs) {
        this.zzixv = zzbs;
    }

    public final void zza(zzeor zzeor, long j, zzbo zzbo) {
        this.zziyc = zzeor;
        this.zziyh = zzeor.position();
        this.zzbgj = this.zziyh - ((long) ((this.zzixw || 8 + j >= 4294967296L) ? 16 : 8));
        zzeor.zzfc(zzeor.position() + j);
        this.zzawh = zzeor.position();
        this.zziyf = zzbo;
    }

    public final void zza(zzeor zzeor, ByteBuffer byteBuffer, long j, zzbo zzbo) {
        this.zzawl = zzeor.position() - ((long) byteBuffer.remaining());
        this.zzixw = byteBuffer.remaining() == 16;
        zza(zzeor, j, zzbo);
    }
}
