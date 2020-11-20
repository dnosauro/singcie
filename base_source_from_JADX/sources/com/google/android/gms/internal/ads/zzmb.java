package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

final class zzmb implements zzmc {
    private zzmb() {
    }

    public final int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }

    public final boolean zzhl() {
        return false;
    }
}
