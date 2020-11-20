package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

public final class zzash {
    @Nonnull
    private final View zzaaq;
    private final Map<String, WeakReference<View>> zzdse;
    private final zzaxq zzdsf;

    public zzash(zzasi zzasi) {
        Map<String, WeakReference<View>> map;
        this.zzaaq = zzasi.zzaaq;
        this.zzdse = zzasi.zzdse;
        this.zzdsf = zzasf.zzp(zzasi.zzaaq.getContext());
        if (this.zzdsf != null && (map = this.zzdse) != null && !map.isEmpty()) {
            try {
                this.zzdsf.zza(new zzasl(ObjectWrapper.wrap(this.zzaaq).asBinder(), ObjectWrapper.wrap(this.zzdse).asBinder()));
            } catch (RemoteException unused) {
                zzaza.zzey("Failed to call remote method.");
            }
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzaxq zzaxq = this.zzdsf;
        if (zzaxq == null) {
            zzaza.zzeb("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzaxq.zzan(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzaza.zzey("Failed to call remote method.");
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdsf == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdsf.zzb(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zzaaq), new zzasj(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdsf == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdsf.zza(list, ObjectWrapper.wrap(this.zzaaq), (zzasa) new zzasg(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }
}
