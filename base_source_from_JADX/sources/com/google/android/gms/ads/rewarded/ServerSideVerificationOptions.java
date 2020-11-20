package com.google.android.gms.ads.rewarded;

public class ServerSideVerificationOptions {
    private final String zzdxy;
    private final String zzdxz;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String zzdxy = "";
        /* access modifiers changed from: private */
        public String zzdxz = "";

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public final Builder setCustomData(String str) {
            this.zzdxz = str;
            return this;
        }

        public final Builder setUserId(String str) {
            this.zzdxy = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.zzdxy = builder.zzdxy;
        this.zzdxz = builder.zzdxz;
    }

    public String getCustomData() {
        return this.zzdxz;
    }

    public String getUserId() {
        return this.zzdxy;
    }
}
