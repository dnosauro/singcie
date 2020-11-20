package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzafc extends NativeContentAd {
    private final VideoController zzcjv = new VideoController();
    private final List<NativeAd.Image> zzdev = new ArrayList();
    private final NativeAd.AdChoicesInfo zzdex;
    private final zzafb zzdey;
    private final zzaek zzdez;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a A[Catch:{ RemoteException -> 0x0087 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzafc(com.google.android.gms.internal.ads.zzafb r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzdev = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.zzcjv = r0
            r4.zzdey = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzafb r0 = r4.zzdey     // Catch:{ RemoteException -> 0x0055 }
            java.util.List r0 = r0.getImages()     // Catch:{ RemoteException -> 0x0055 }
            if (r0 == 0) goto L_0x005b
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x0055 }
        L_0x0020:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x0055 }
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x0055 }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0055 }
            if (r2 == 0) goto L_0x0047
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x0055 }
            if (r1 == 0) goto L_0x0047
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x0055 }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaej     // Catch:{ RemoteException -> 0x0055 }
            if (r3 == 0) goto L_0x0040
            r1 = r2
            com.google.android.gms.internal.ads.zzaej r1 = (com.google.android.gms.internal.ads.zzaej) r1     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x0048
        L_0x0040:
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x0055 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x0055 }
            r1 = r2
            goto L_0x0048
        L_0x0047:
            r1 = r5
        L_0x0048:
            if (r1 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.zzdev     // Catch:{ RemoteException -> 0x0055 }
            com.google.android.gms.internal.ads.zzaek r3 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x0055 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0055 }
            r2.add(r3)     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x0020
        L_0x0055:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x005b:
            com.google.android.gms.internal.ads.zzafb r0 = r4.zzdey     // Catch:{ RemoteException -> 0x0069 }
            com.google.android.gms.internal.ads.zzaej r0 = r0.zzsz()     // Catch:{ RemoteException -> 0x0069 }
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzaek r1 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x0069 }
            r1.<init>(r0)     // Catch:{ RemoteException -> 0x0069 }
            goto L_0x0070
        L_0x0069:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x006f:
            r1 = r5
        L_0x0070:
            r4.zzdez = r1
            com.google.android.gms.internal.ads.zzafb r0 = r4.zzdey     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzaeb r0 = r0.zzsx()     // Catch:{ RemoteException -> 0x0087 }
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzaec r0 = new com.google.android.gms.internal.ads.zzaec     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzafb r1 = r4.zzdey     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzaeb r1 = r1.zzsx()     // Catch:{ RemoteException -> 0x0087 }
            r0.<init>(r1)     // Catch:{ RemoteException -> 0x0087 }
            r5 = r0
            goto L_0x008d
        L_0x0087:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x008d:
            r4.zzdex = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafc.<init>(com.google.android.gms.internal.ads.zzafb):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzsv */
    public final IObjectWrapper zzjr() {
        try {
            return this.zzdey.zzsv();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzdey.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdex;
    }

    public final CharSequence getAdvertiser() {
        try {
            return this.zzdey.getAdvertiser();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getBody() {
        try {
            return this.zzdey.getBody();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzdey.getCallToAction();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzdey.getExtras();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzdey.getHeadline();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzdev;
    }

    public final NativeAd.Image getLogo() {
        return this.zzdez;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdey.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzdey.getVideoController() != null) {
                this.zzcjv.zza(this.zzdey.getVideoController());
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjv;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzdey.performClick(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdey.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdey.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
