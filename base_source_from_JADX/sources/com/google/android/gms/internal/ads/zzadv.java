package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzadv extends zzaei {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzdem;
    private final double zzden;

    public zzadv(Drawable drawable, Uri uri2, double d, int i, int i2) {
        this.zzdem = drawable;
        this.uri = uri2;
        this.zzden = d;
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final double getScale() {
        return this.zzden;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final IObjectWrapper zzsr() {
        return ObjectWrapper.wrap(this.zzdem);
    }
}
