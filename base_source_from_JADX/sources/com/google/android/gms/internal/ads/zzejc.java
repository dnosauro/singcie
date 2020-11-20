package com.google.android.gms.internal.ads;

final class zzejc {
    private final byte[] buffer;
    private final zzejo zzije;

    private zzejc(int i) {
        this.buffer = new byte[i];
        this.zzije = zzejo.zzv(this.buffer);
    }

    /* synthetic */ zzejc(int i, zzeix zzeix) {
        this(i);
    }

    public final zzeiu zzbfy() {
        this.zzije.zzbhb();
        return new zzeje(this.buffer);
    }

    public final zzejo zzbfz() {
        return this.zzije;
    }
}
