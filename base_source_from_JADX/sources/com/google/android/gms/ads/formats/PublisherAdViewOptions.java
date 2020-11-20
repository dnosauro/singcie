package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaai;
import com.google.android.gms.internal.ads.zzagc;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxo;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo11699id = 1)
    private final boolean zzbnx;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", mo11699id = 2, type = "android.os.IBinder")
    private final zzxo zzbny;
    private AppEventListener zzbnz;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", mo11699id = 3)
    private final IBinder zzboa;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbnx = false;
        /* access modifiers changed from: private */
        public AppEventListener zzbnz;
        /* access modifiers changed from: private */
        public ShouldDelayBannerRenderingListener zzbob;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbnz = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbnx = z;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbob = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbnx = builder.zzbnx;
        this.zzbnz = builder.zzbnz;
        AppEventListener appEventListener = this.zzbnz;
        zzaai zzaai = null;
        this.zzbny = appEventListener != null ? new zzvt(appEventListener) : null;
        this.zzboa = builder.zzbob != null ? new zzaai(builder.zzbob) : zzaai;
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(mo11702id = 1) boolean z, @SafeParcelable.Param(mo11702id = 2) IBinder iBinder, @SafeParcelable.Param(mo11702id = 3) IBinder iBinder2) {
        this.zzbnx = z;
        this.zzbny = iBinder != null ? zzxn.zze(iBinder) : null;
        this.zzboa = iBinder2;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnz;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbnx;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzxo zzxo = this.zzbny;
        SafeParcelWriter.writeIBinder(parcel, 2, zzxo == null ? null : zzxo.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzboa, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzxo zzju() {
        return this.zzbny;
    }

    public final zzagd zzjv() {
        return zzagc.zzy(this.zzboa);
    }
}
