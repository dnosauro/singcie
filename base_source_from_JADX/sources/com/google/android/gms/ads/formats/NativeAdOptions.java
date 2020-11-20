package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbnl;
    private final int zzbnm;
    private final int zzbnn;
    private final boolean zzbno;
    private final int zzbnp;
    private final VideoOptions zzbnq;
    private final boolean zzbnr;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbnl = false;
        /* access modifiers changed from: private */
        public int zzbnm = -1;
        /* access modifiers changed from: private */
        public int zzbnn = 0;
        /* access modifiers changed from: private */
        public boolean zzbno = false;
        /* access modifiers changed from: private */
        public int zzbnp = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzbnq;
        /* access modifiers changed from: private */
        public boolean zzbnr = false;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzbnp = i;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzbnm = i;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzbnn = i;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzbnr = z;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzbno = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbnl = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbnq = videoOptions;
            return this;
        }
    }

    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbnl = builder.zzbnl;
        this.zzbnm = builder.zzbnm;
        this.zzbnn = builder.zzbnn;
        this.zzbno = builder.zzbno;
        this.zzbnp = builder.zzbnp;
        this.zzbnq = builder.zzbnq;
        this.zzbnr = builder.zzbnr;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbnp;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzbnm;
    }

    public final int getMediaAspectRatio() {
        return this.zzbnn;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnq;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzbno;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbnl;
    }

    public final boolean zzjs() {
        return this.zzbnr;
    }
}
