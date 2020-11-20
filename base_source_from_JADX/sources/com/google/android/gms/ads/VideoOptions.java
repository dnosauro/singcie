package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaak;

public final class VideoOptions {
    private final boolean zzadu;
    private final boolean zzadv;
    private final boolean zzadw;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzadu = true;
        /* access modifiers changed from: private */
        public boolean zzadv = false;
        /* access modifiers changed from: private */
        public boolean zzadw = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzadw = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzadv = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzadu = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzadu = builder.zzadu;
        this.zzadv = builder.zzadv;
        this.zzadw = builder.zzadw;
    }

    public VideoOptions(zzaak zzaak) {
        this.zzadu = zzaak.zzadu;
        this.zzadv = zzaak.zzadv;
        this.zzadw = zzaak.zzadw;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzadw;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzadv;
    }

    public final boolean getStartMuted() {
        return this.zzadu;
    }
}
