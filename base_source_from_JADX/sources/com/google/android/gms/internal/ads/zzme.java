package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
final class zzme implements zzmc {
    private final int zzbdd;
    private MediaCodecInfo[] zzbde;

    public zzme(boolean z) {
        this.zzbdd = z ? 1 : 0;
    }

    private final void zzhm() {
        if (this.zzbde == null) {
            this.zzbde = new MediaCodecList(this.zzbdd).getCodecInfos();
        }
    }

    public final int getCodecCount() {
        zzhm();
        return this.zzbde.length;
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzhm();
        return this.zzbde[i];
    }

    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public final boolean zzhl() {
        return true;
    }
}
