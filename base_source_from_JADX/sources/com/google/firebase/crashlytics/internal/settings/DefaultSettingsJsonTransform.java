package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    private static AppSettingsData buildAppDataFrom(JSONObject jSONObject) {
        return new AppSettingsData(jSONObject.getString("status"), jSONObject.getString(ImagesContract.URL), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false));
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true));
    }

    private static SessionSettingsData buildSessionDataFrom(JSONObject jSONObject) {
        return new SessionSettingsData(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        JSONObject jSONObject = new JSONObject();
        return new SettingsData(getExpiresAtFrom(currentTimeProvider, 3600, jSONObject), (AppSettingsData) null, buildSessionDataFrom(jSONObject), buildFeaturesSessionDataFrom(jSONObject), 0, 3600);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : currentTimeProvider.getCurrentTimeMillis() + (j * 1000);
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) {
        return new JSONObject().put("status", appSettingsData.status).put(ImagesContract.URL, appSettingsData.url).put("reports_url", appSettingsData.reportsUrl).put("ndk_reports_url", appSettingsData.ndkReportsUrl).put("update_required", appSettingsData.updateRequired);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        return new JSONObject().put("collect_reports", featuresSettingsData.collectReports);
    }

    private JSONObject toSessionJson(SessionSettingsData sessionSettingsData) {
        return new JSONObject().put("max_custom_exception_events", sessionSettingsData.maxCustomExceptionEvents).put("max_complete_sessions_count", sessionSettingsData.maxCompleteSessionsCount);
    }

    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(getExpiresAtFrom(currentTimeProvider, (long) optInt2, jSONObject), buildAppDataFrom(jSONObject.getJSONObject("app")), buildSessionDataFrom(jSONObject.getJSONObject("session")), buildFeaturesSessionDataFrom(jSONObject.getJSONObject("features")), optInt, optInt2);
    }

    public JSONObject toJson(SettingsData settingsData) {
        return new JSONObject().put("expires_at", settingsData.expiresAtMillis).put("cache_duration", settingsData.cacheDuration).put("settings_version", settingsData.settingsVersion).put("features", toFeaturesJson(settingsData.featuresData)).put("app", toAppJson(settingsData.appData)).put("session", toSessionJson(settingsData.sessionData));
    }
}
