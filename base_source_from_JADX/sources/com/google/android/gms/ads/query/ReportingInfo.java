package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzash;
import com.google.android.gms.internal.ads.zzasi;
import java.util.List;
import java.util.Map;

@KeepForSdk
public final class ReportingInfo {
    private final zzash zzhph;

    @KeepForSdk
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzasi zzhpi = new zzasi();

        @KeepForSdk
        public Builder(View view) {
            this.zzhpi.zzk(view);
        }

        @KeepForSdk
        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }

        @KeepForSdk
        public final Builder setAssetViews(Map<String, View> map) {
            this.zzhpi.zzh(map);
            return this;
        }
    }

    private ReportingInfo(Builder builder) {
        this.zzhph = new zzash(builder.zzhpi);
    }

    @KeepForSdk
    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.zzhph.reportTouchEvent(motionEvent);
    }

    @KeepForSdk
    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzhph.updateClickUrl(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzhph.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }
}
