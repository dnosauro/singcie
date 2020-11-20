package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
public final class zzpw extends Surface {
    private static boolean zzbkr;
    private static boolean zzbks;
    private final boolean zzbbd;
    private final zzpy zzbkt;
    private boolean zzbku;

    private zzpw(zzpy zzpy, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbkt = zzpy;
        this.zzbbd = z;
    }

    public static zzpw zzc(Context context, boolean z) {
        if (zzpt.SDK_INT >= 17) {
            zzpc.checkState(!z || zzc(context));
            return new zzpy().zzm(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    public static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzpw.class) {
            if (!zzbks) {
                if (zzpt.SDK_INT >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzpt.SDK_INT == 24 && (zzpt.MODEL.startsWith("SM-G950") || zzpt.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zzbkr = z2;
                }
                zzbks = true;
            }
            z = zzbkr;
        }
        return z;
    }

    public final void release() {
        super.release();
        synchronized (this.zzbkt) {
            if (!this.zzbku) {
                this.zzbkt.release();
                this.zzbku = true;
            }
        }
    }
}
