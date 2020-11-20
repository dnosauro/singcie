package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaek extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzden;
    private final zzaej zzdes;
    private final Drawable zzdet;

    public zzaek(zzaej zzaej) {
        Drawable drawable;
        int i;
        this.zzdes = zzaej;
        Uri uri2 = null;
        try {
            IObjectWrapper zzsr = this.zzdes.zzsr();
            if (zzsr != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzsr);
                this.zzdet = drawable;
                uri2 = this.zzdes.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzdes.getScale();
                this.zzden = d;
                int i2 = -1;
                i = this.zzdes.getWidth();
                this.width = i;
                i2 = this.zzdes.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        drawable = null;
        this.zzdet = drawable;
        try {
            uri2 = this.zzdes.getUri();
        } catch (RemoteException e2) {
            zzaza.zzc("", e2);
        }
        this.uri = uri2;
        double d2 = 1.0d;
        try {
            d2 = this.zzdes.getScale();
        } catch (RemoteException e3) {
            zzaza.zzc("", e3);
        }
        this.zzden = d2;
        int i22 = -1;
        try {
            i = this.zzdes.getWidth();
        } catch (RemoteException e4) {
            zzaza.zzc("", e4);
            i = -1;
        }
        this.width = i;
        try {
            i22 = this.zzdes.getHeight();
        } catch (RemoteException e5) {
            zzaza.zzc("", e5);
        }
        this.height = i22;
    }

    public final Drawable getDrawable() {
        return this.zzdet;
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
}
