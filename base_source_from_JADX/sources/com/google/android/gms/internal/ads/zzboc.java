package com.google.android.gms.internal.ads;

import android.content.Context;

public class zzboc {
    protected final zzdmu zzeri;
    protected final zzdnj zzfpr;
    private final zzbso zzfur;
    private final zzbte zzfus;
    private final zzdki zzfut;
    private final zzbrp zzfuu;
    private final zzbul zzfuv;

    protected zzboc(zzbob zzbob) {
        this.zzfpr = zzbob.zzfpr;
        this.zzeri = zzbob.zzeri;
        this.zzfur = zzbob.zzfur;
        this.zzfus = zzbob.zzfus;
        this.zzfut = zzbob.zzfut;
        this.zzfuu = zzbob.zzfuu;
        this.zzfuv = zzbob.zzfuv;
    }

    public void destroy() {
        this.zzfur.zzce((Context) null);
    }

    public void zzajj() {
        this.zzfus.onAdLoaded();
    }

    public final zzbso zzajy() {
        return this.zzfur;
    }

    public final zzbrp zzajz() {
        return this.zzfuu;
    }

    public final zzdki zzaka() {
        return this.zzfut;
    }

    public final zzbvn zzakb() {
        return this.zzfuv.zzakb();
    }
}
