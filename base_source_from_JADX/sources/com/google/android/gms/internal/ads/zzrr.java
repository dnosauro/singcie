package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzrr {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbtr;

    @VisibleForTesting
    public zzrr(float f, float f2, float f3, float f4, int i) {
        this.left = f;
        this.top = f2;
        this.right = f + f3;
        this.bottom = f2 + f4;
        this.zzbtr = i;
    }

    /* access modifiers changed from: package-private */
    public final float zzmn() {
        return this.left;
    }

    /* access modifiers changed from: package-private */
    public final float zzmo() {
        return this.top;
    }

    /* access modifiers changed from: package-private */
    public final float zzmp() {
        return this.right;
    }

    /* access modifiers changed from: package-private */
    public final float zzmq() {
        return this.bottom;
    }

    /* access modifiers changed from: package-private */
    public final int zzmr() {
        return this.zzbtr;
    }
}
