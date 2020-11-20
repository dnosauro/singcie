package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzp;

public final class zzdbm implements zzdfi<zzdbn> {
    private final Context context;
    private final zzdzc zzggb;

    public zzdbm(zzdzc zzdzc, Context context2) {
        this.zzggb = zzdzc;
        this.context = context2;
    }

    public final zzdyz<zzdbn> zzasm() {
        return this.zzggb.zze(new zzdbp(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdbn zzasq() {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        return new zzdbn(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzp.zzkv().zzqk(), zzp.zzkv().zzql());
    }
}
