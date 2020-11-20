package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
public abstract class zzbap extends TextureView implements zzbbi {
    protected final zzbaz zzeih = new zzbaz();
    protected final zzbbj zzeii;

    public zzbap(Context context) {
        super(context);
        this.zzeii = new zzbbj(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract long getTotalBytes();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbam zzbam);

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }

    public void zzdl(int i) {
    }

    public void zzdm(int i) {
    }

    public void zzdn(int i) {
    }

    public void zzdo(int i) {
    }

    public void zzdp(int i) {
    }

    public abstract long zzna();

    public abstract String zzzk();

    public abstract long zzzo();

    public abstract int zzzp();

    public abstract void zzzq();
}
