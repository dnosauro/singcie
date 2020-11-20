package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcft extends zzajm implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzads {
    private boolean zzerq = false;
    private zzys zzgct;
    private View zzgcy;
    private zzcbt zzgdx;
    private boolean zzghc = false;

    public zzcft(zzcbt zzcbt, zzcce zzcce) {
        this.zzgcy = zzcce.zzang();
        this.zzgct = zzcce.getVideoController();
        this.zzgdx = zzcbt;
        if (zzcce.zzanh() != null) {
            zzcce.zzanh().zza((zzads) this);
        }
    }

    private static void zza(zzajo zzajo, int i) {
        try {
            zzajo.zzdb(i);
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    private final void zzaor() {
        View view = this.zzgcy;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzgcy);
            }
        }
    }

    private final void zzaos() {
        View view;
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt != null && (view = this.zzgcy) != null) {
            zzcbt.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcbt.zzz(this.zzgcy));
        }
    }

    public final void destroy() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaor();
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt != null) {
            zzcbt.destroy();
        }
        this.zzgdx = null;
        this.zzgcy = null;
        this.zzgct = null;
        this.zzerq = true;
    }

    public final zzys getVideoController() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzerq) {
            return this.zzgct;
        }
        zzd.zzey("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void onGlobalLayout() {
        zzaos();
    }

    public final void onScrollChanged() {
        zzaos();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajo) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzerq) {
            zzd.zzey("Instream ad can not be shown after destroy().");
            zza(zzajo, 2);
        } else if (this.zzgcy == null || this.zzgct == null) {
            String valueOf = String.valueOf(this.zzgcy == null ? "can not get video view." : "can not get video controller.");
            zzd.zzey(valueOf.length() != 0 ? "Instream internal error: ".concat(valueOf) : new String("Instream internal error: "));
            zza(zzajo, 0);
        } else if (this.zzghc) {
            zzd.zzey("Instream ad should not be used again.");
            zza(zzajo, 1);
        } else {
            this.zzghc = true;
            zzaor();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzgcy, new ViewGroup.LayoutParams(-1, -1));
            zzp.zzln();
            zzazy.zza(this.zzgcy, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzp.zzln();
            zzazy.zza(this.zzgcy, (ViewTreeObserver.OnScrollChangedListener) this);
            zzaos();
            try {
                zzajo.zztn();
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaot() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, (zzajo) new zzcfv(this));
    }

    public final void zzsq() {
        zzm.zzedd.post(new zzcfw(this));
    }

    public final zzaee zzth() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzerq) {
            zzd.zzey("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt == null || zzcbt.zzamz() == null) {
            return null;
        }
        return this.zzgdx.zzamz().zzth();
    }
}
