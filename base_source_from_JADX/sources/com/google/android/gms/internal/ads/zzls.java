package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;

@TargetApi(16)
public final class zzls {
    private final String mimeType;
    public final String name;
    public final boolean zzalk;
    public final boolean zzbbc;
    public final boolean zzbbd;
    private final MediaCodecInfo.CodecCapabilities zzbbe;

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        if ((com.google.android.gms.internal.ads.zzpt.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzls(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzpc.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzbbe = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L_0x002a
            if (r4 == 0) goto L_0x002a
            int r5 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r0 = 19
            if (r5 < r0) goto L_0x0025
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            if (r5 == 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            r1.zzbbc = r5
            r5 = 21
            if (r4 == 0) goto L_0x0044
            int r0 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r0 < r5) goto L_0x003f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            r1.zzalk = r0
            if (r6 != 0) goto L_0x005e
            if (r4 == 0) goto L_0x005d
            int r6 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r6 < r5) goto L_0x0059
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x0059
            r4 = 1
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            r1.zzbbd = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzls.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static zzls zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzls(str, str2, codecCapabilities, z, z2);
    }

    @TargetApi(21)
    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    public static zzls zzay(String str) {
        return new zzls(str, (String) null, (MediaCodecInfo.CodecCapabilities) null, false, false);
    }

    private final void zzba(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzpt.zzbkl;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbe;
        if (codecCapabilities == null) {
            sb = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                sb = "sizeAndRate.vCaps";
            } else if (zza(videoCapabilities, i, i2, d)) {
                return true;
            } else {
                if (i >= i2 || !zza(videoCapabilities, i2, i, d)) {
                    StringBuilder sb2 = new StringBuilder(69);
                    sb2.append("sizeAndRate.support, ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                    sb2.append("x");
                    sb2.append(d);
                    sb = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder(69);
                    sb3.append("sizeAndRate.rotated, ");
                    sb3.append(i);
                    sb3.append("x");
                    sb3.append(i2);
                    sb3.append("x");
                    sb3.append(d);
                    String sb4 = sb3.toString();
                    String str = this.name;
                    String str2 = this.mimeType;
                    String str3 = zzpt.zzbkl;
                    StringBuilder sb5 = new StringBuilder(String.valueOf(sb4).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
                    sb5.append("AssumedSupport [");
                    sb5.append(sb4);
                    sb5.append("] [");
                    sb5.append(str);
                    sb5.append(", ");
                    sb5.append(str2);
                    sb5.append("] [");
                    sb5.append(str3);
                    sb5.append("]");
                    Log.d("MediaCodecInfo", sb5.toString());
                    return true;
                }
            }
        }
        zzba(sb);
        return false;
    }

    @TargetApi(21)
    public final boolean zzaw(int i) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbe;
        if (codecCapabilities == null) {
            sb = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                sb = "sampleRate.aCaps";
            } else if (audioCapabilities.isSampleRateSupported(i)) {
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("sampleRate.support, ");
                sb2.append(i);
                sb = sb2.toString();
            }
        }
        zzba(sb);
        return false;
    }

    @TargetApi(21)
    public final boolean zzax(int i) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbe;
        if (codecCapabilities == null) {
            sb = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                sb = "channelCount.aCaps";
            } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("channelCount.support, ");
                sb2.append(i);
                sb = sb2.toString();
            }
        }
        zzba(sb);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzaz(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            if (r11 == 0) goto L_0x0148
            java.lang.String r1 = r10.mimeType
            if (r1 != 0) goto L_0x0009
            goto L_0x0148
        L_0x0009:
            if (r11 == 0) goto L_0x00c3
            java.lang.String r1 = r11.trim()
            java.lang.String r2 = "avc1"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c0
            java.lang.String r2 = "avc3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0021
            goto L_0x00c0
        L_0x0021:
            java.lang.String r2 = "hev1"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00bd
            java.lang.String r2 = "hvc1"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0033
            goto L_0x00bd
        L_0x0033:
            java.lang.String r2 = "vp9"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x003f
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x00c4
        L_0x003f:
            java.lang.String r2 = "vp8"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x004b
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x00c4
        L_0x004b:
            java.lang.String r2 = "mp4a"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0057
            java.lang.String r1 = "audio/mp4a-latm"
            goto L_0x00c4
        L_0x0057:
            java.lang.String r2 = "ac-3"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00ba
            java.lang.String r2 = "dac3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0068
            goto L_0x00ba
        L_0x0068:
            java.lang.String r2 = "ec-3"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b7
            java.lang.String r2 = "dec3"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0079
            goto L_0x00b7
        L_0x0079:
            java.lang.String r2 = "dtsc"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b4
            java.lang.String r2 = "dtse"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x008a
            goto L_0x00b4
        L_0x008a:
            java.lang.String r2 = "dtsh"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00b1
            java.lang.String r2 = "dtsl"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x009b
            goto L_0x00b1
        L_0x009b:
            java.lang.String r2 = "opus"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x00a6
            java.lang.String r1 = "audio/opus"
            goto L_0x00c4
        L_0x00a6:
            java.lang.String r2 = "vorbis"
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = "audio/vorbis"
            goto L_0x00c4
        L_0x00b1:
            java.lang.String r1 = "audio/vnd.dts.hd"
            goto L_0x00c4
        L_0x00b4:
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x00c4
        L_0x00b7:
            java.lang.String r1 = "audio/eac3"
            goto L_0x00c4
        L_0x00ba:
            java.lang.String r1 = "audio/ac3"
            goto L_0x00c4
        L_0x00bd:
            java.lang.String r1 = "video/hevc"
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r1 = "video/avc"
            goto L_0x00c4
        L_0x00c3:
            r1 = 0
        L_0x00c4:
            if (r1 != 0) goto L_0x00c7
            return r0
        L_0x00c7:
            java.lang.String r2 = r10.mimeType
            boolean r2 = r2.equals(r1)
            r3 = 0
            if (r2 != 0) goto L_0x0100
            java.lang.String r0 = java.lang.String.valueOf(r11)
            int r0 = r0.length()
            int r0 = r0 + 13
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "codec.mime "
        L_0x00ea:
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = ", "
            r2.append(r11)
            r2.append(r1)
            java.lang.String r11 = r2.toString()
            r10.zzba(r11)
            return r3
        L_0x0100:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzlz.zzbb(r11)
            if (r2 != 0) goto L_0x0107
            return r0
        L_0x0107:
            android.media.MediaCodecInfo$CodecProfileLevel[] r4 = r10.zzhc()
            int r5 = r4.length
            r6 = 0
        L_0x010d:
            if (r6 >= r5) goto L_0x012d
            r7 = r4[r6]
            int r8 = r7.profile
            java.lang.Object r9 = r2.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r8 != r9) goto L_0x012a
            int r7 = r7.level
            java.lang.Object r8 = r2.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r7 < r8) goto L_0x012a
            return r0
        L_0x012a:
            int r6 = r6 + 1
            goto L_0x010d
        L_0x012d:
            java.lang.String r0 = java.lang.String.valueOf(r11)
            int r0 = r0.length()
            int r0 = r0 + 22
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "codec.profileLevel, "
            goto L_0x00ea
        L_0x0148:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzls.zzaz(java.lang.String):boolean");
    }

    @TargetApi(21)
    public final Point zzd(int i, int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbe;
        if (codecCapabilities == null) {
            str = "align.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "align.vCaps";
            } else {
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                return new Point(zzpt.zzf(i, widthAlignment) * widthAlignment, zzpt.zzf(i2, heightAlignment) * heightAlignment);
            }
        }
        zzba(str);
        return null;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzhc() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbe;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.zzbbe.profileLevels;
    }
}
