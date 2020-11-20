package com.google.android.gms.ads.mediation;

public final class VersionInfo {
    private final int zzeug;
    private final int zzeuh;
    private final int zzeui;

    public VersionInfo(int i, int i2, int i3) {
        this.zzeug = i;
        this.zzeuh = i2;
        this.zzeui = i3;
    }

    public final int getMajorVersion() {
        return this.zzeug;
    }

    public final int getMicroVersion() {
        return this.zzeui;
    }

    public final int getMinorVersion() {
        return this.zzeuh;
    }
}
