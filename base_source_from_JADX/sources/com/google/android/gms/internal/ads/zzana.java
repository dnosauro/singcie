package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

public final class zzana extends zzbge {
    private final AppMeasurementSdk zzdkq;

    zzana(AppMeasurementSdk appMeasurementSdk) {
        this.zzdkq = appMeasurementSdk;
    }

    public final void beginAdUnitExposure(String str) {
        this.zzdkq.beginAdUnitExposure(str);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzdkq.clearConditionalUserProperty(str, str2, bundle);
    }

    public final void endAdUnitExposure(String str) {
        this.zzdkq.endAdUnitExposure(str);
    }

    public final long generateEventId() {
        return this.zzdkq.generateEventId();
    }

    public final String getAppIdOrigin() {
        return this.zzdkq.getAppIdOrigin();
    }

    public final String getAppInstanceId() {
        return this.zzdkq.getAppInstanceId();
    }

    public final List getConditionalUserProperties(String str, String str2) {
        return this.zzdkq.getConditionalUserProperties(str, str2);
    }

    public final String getCurrentScreenClass() {
        return this.zzdkq.getCurrentScreenClass();
    }

    public final String getCurrentScreenName() {
        return this.zzdkq.getCurrentScreenName();
    }

    public final String getGmpAppId() {
        return this.zzdkq.getGmpAppId();
    }

    public final int getMaxUserProperties(String str) {
        return this.zzdkq.getMaxUserProperties(str);
    }

    public final Map getUserProperties(String str, String str2, boolean z) {
        return this.zzdkq.getUserProperties(str, str2, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        this.zzdkq.logEvent(str, str2, bundle);
    }

    public final void performAction(Bundle bundle) {
        this.zzdkq.performAction(bundle);
    }

    public final Bundle performActionWithResponse(Bundle bundle) {
        return this.zzdkq.performActionWithResponse(bundle);
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        this.zzdkq.setConditionalUserProperty(bundle);
    }

    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) {
        this.zzdkq.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) {
        this.zzdkq.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }
}
