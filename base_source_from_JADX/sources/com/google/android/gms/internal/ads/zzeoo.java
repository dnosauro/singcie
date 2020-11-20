package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzeoo implements zzbp {
    private static zzeox zzcz = zzeox.zzn(zzeoo.class);
    private String type;
    private long zzawl;
    private zzbs zzixv;
    boolean zzixx;
    private boolean zzixy;
    private ByteBuffer zzixz;
    private long zziya;
    private long zziyb = -1;
    private zzeor zziyc;
    private ByteBuffer zziyd = null;

    protected zzeoo(String str) {
        this.type = str;
        this.zzixy = true;
        this.zzixx = true;
    }

    private final synchronized void zzblp() {
        if (!this.zzixy) {
            try {
                zzeox zzeox = zzcz;
                String valueOf = String.valueOf(this.type);
                zzeox.zzii(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zzixz = this.zziyc.zzh(this.zziya, this.zziyb);
                this.zzixy = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbs zzbs) {
        this.zzixv = zzbs;
    }

    public final void zza(zzeor zzeor, ByteBuffer byteBuffer, long j, zzbo zzbo) {
        this.zziya = zzeor.position();
        this.zzawl = this.zziya - ((long) byteBuffer.remaining());
        this.zziyb = j;
        this.zziyc = zzeor;
        zzeor.zzfc(zzeor.position() + j);
        this.zzixy = false;
        this.zzixx = false;
        zzblq();
    }

    public final synchronized void zzblq() {
        zzblp();
        zzeox zzeox = zzcz;
        String valueOf = String.valueOf(this.type);
        zzeox.zzii(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zzixz != null) {
            ByteBuffer byteBuffer = this.zzixz;
            this.zzixx = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zziyd = byteBuffer.slice();
            }
            this.zzixz = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzl(ByteBuffer byteBuffer);
}
