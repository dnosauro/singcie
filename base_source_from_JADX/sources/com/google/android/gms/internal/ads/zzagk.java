package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzagk extends UnifiedNativeAd {
    private final VideoController zzcjv = new VideoController();
    private final List<NativeAd.Image> zzdev = new ArrayList();
    private final zzaek zzdew;
    private final NativeAd.AdChoicesInfo zzdex;
    private final zzagj zzdfd;
    private final List<MuteThisAdReason> zzdfe = new ArrayList();

    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6 A[Catch:{ RemoteException -> 0x00c3 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagk(com.google.android.gms.internal.ads.zzagj r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzdev = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.zzcjv = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzdfe = r0
            r4.zzdfd = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzagj r0 = r4.zzdfd     // Catch:{ RemoteException -> 0x005c }
            java.util.List r0 = r0.getImages()     // Catch:{ RemoteException -> 0x005c }
            if (r0 == 0) goto L_0x0062
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x005c }
        L_0x0027:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x005c }
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x005c }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005c }
            if (r2 == 0) goto L_0x004e
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x005c }
            if (r1 == 0) goto L_0x004e
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x005c }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaej     // Catch:{ RemoteException -> 0x005c }
            if (r3 == 0) goto L_0x0047
            r1 = r2
            com.google.android.gms.internal.ads.zzaej r1 = (com.google.android.gms.internal.ads.zzaej) r1     // Catch:{ RemoteException -> 0x005c }
            goto L_0x004f
        L_0x0047:
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x005c }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x005c }
            r1 = r2
            goto L_0x004f
        L_0x004e:
            r1 = r5
        L_0x004f:
            if (r1 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.zzdev     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.internal.ads.zzaek r3 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x005c }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x005c }
            r2.add(r3)     // Catch:{ RemoteException -> 0x005c }
            goto L_0x0027
        L_0x005c:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x0062:
            com.google.android.gms.internal.ads.zzagj r0 = r4.zzdfd     // Catch:{ RemoteException -> 0x0091 }
            java.util.List r0 = r0.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x0091 }
            if (r0 == 0) goto L_0x0097
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x0091 }
        L_0x006e:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x0091 }
            if (r1 == 0) goto L_0x0097
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x0091 }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0091 }
            if (r2 == 0) goto L_0x0083
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x0091 }
            com.google.android.gms.internal.ads.zzyd r1 = com.google.android.gms.internal.ads.zzyg.zzg(r1)     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x0084
        L_0x0083:
            r1 = r5
        L_0x0084:
            if (r1 == 0) goto L_0x006e
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r2 = r4.zzdfe     // Catch:{ RemoteException -> 0x0091 }
            com.google.android.gms.internal.ads.zzyi r3 = new com.google.android.gms.internal.ads.zzyi     // Catch:{ RemoteException -> 0x0091 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0091 }
            r2.add(r3)     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x006e
        L_0x0091:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x0097:
            com.google.android.gms.internal.ads.zzagj r0 = r4.zzdfd     // Catch:{ RemoteException -> 0x00a5 }
            com.google.android.gms.internal.ads.zzaej r0 = r0.zzsw()     // Catch:{ RemoteException -> 0x00a5 }
            if (r0 == 0) goto L_0x00ab
            com.google.android.gms.internal.ads.zzaek r1 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x00a5 }
            r1.<init>(r0)     // Catch:{ RemoteException -> 0x00a5 }
            goto L_0x00ac
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x00ab:
            r1 = r5
        L_0x00ac:
            r4.zzdew = r1
            com.google.android.gms.internal.ads.zzagj r0 = r4.zzdfd     // Catch:{ RemoteException -> 0x00c3 }
            com.google.android.gms.internal.ads.zzaeb r0 = r0.zzsx()     // Catch:{ RemoteException -> 0x00c3 }
            if (r0 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzaec r0 = new com.google.android.gms.internal.ads.zzaec     // Catch:{ RemoteException -> 0x00c3 }
            com.google.android.gms.internal.ads.zzagj r1 = r4.zzdfd     // Catch:{ RemoteException -> 0x00c3 }
            com.google.android.gms.internal.ads.zzaeb r1 = r1.zzsx()     // Catch:{ RemoteException -> 0x00c3 }
            r0.<init>(r1)     // Catch:{ RemoteException -> 0x00c3 }
            r5 = r0
            goto L_0x00c9
        L_0x00c3:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x00c9:
            r4.zzdex = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.<init>(com.google.android.gms.internal.ads.zzagj):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzsv */
    public final IObjectWrapper zzjr() {
        try {
            return this.zzdfd.zzsv();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zzdfd.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzaza.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.zzdfd.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zzdfd.zztg();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdex;
    }

    public final String getAdvertiser() {
        try {
            return this.zzdfd.getAdvertiser();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zzdfd.getBody();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zzdfd.getCallToAction();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdfd.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            return this.zzdfd.getHeadline();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzdew;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzdev;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zzdfd.zzth() != null) {
                return new zzzm(this.zzdfd.zzth());
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdfd.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdfe;
    }

    public final String getPrice() {
        try {
            return this.zzdfd.getPrice();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.zzdfd.zzkh();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzdfd.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zzdfd.getStore();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzdfd.getVideoController() != null) {
                this.zzcjv.zza(this.zzdfd.getVideoController());
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjv;
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdfd.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdfd.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzaza.zzey("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzdfd.zza((zzyd) null);
            } else if (muteThisAdReason instanceof zzyi) {
                this.zzdfd.zza(((zzyi) muteThisAdReason).zzqp());
            } else {
                zzaza.zzey("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzdfd.performClick(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zzdfd.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdfd.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdfd.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdfd.zza((zzxz) new zzye(muteThisAdListener));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdfd.zza((zzym) new zzaaf(onPaidEventListener));
        } catch (RemoteException e) {
            zzaza.zzc("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdfd.zza((zzage) new zzagw(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzaza.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final Object zzjw() {
        try {
            IObjectWrapper zzsy = this.zzdfd.zzsy();
            if (zzsy != null) {
                return ObjectWrapper.unwrap(zzsy);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }
}
