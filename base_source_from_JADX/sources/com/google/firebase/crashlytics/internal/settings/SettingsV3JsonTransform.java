package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONObject;

class SettingsV3JsonTransform implements SettingsJsonTransform {
    private static final String CRASHLYTICS_APP_URL = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
    private static final String CRASHLYTICS_APP_URL_FORMAT = "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s";
    private static final String NDK_REPORTS_URL_FORMAT = "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps";
    private static final String REPORTS_URL_FORMAT = "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports";

    SettingsV3JsonTransform() {
    }

    private static AppSettingsData buildAppDataFrom(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String string = jSONObject2.getString("status");
        boolean equals = AppSettingsData.STATUS_NEW.equals(string);
        String string2 = jSONObject.getString("bundle_id");
        String string3 = jSONObject.getString(AbstractAppSpiCall.ORGANIZATION_ID_PARAM);
        if (equals) {
            str = CRASHLYTICS_APP_URL;
        } else {
            str = String.format(Locale.US, CRASHLYTICS_APP_URL_FORMAT, new Object[]{string2});
        }
        return new AppSettingsData(string, str, String.format(Locale.US, REPORTS_URL_FORMAT, new Object[]{string2}), String.format(Locale.US, NDK_REPORTS_URL_FORMAT, new Object[]{string2}), string2, string3, jSONObject2.optBoolean("update_required", false), jSONObject2.optInt("report_upload_variant", 0), jSONObject2.optInt("native_report_upload_variant", 0));
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true));
    }

    private static SessionSettingsData defaultSessionData() {
        return new SessionSettingsData(8, 4);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : currentTimeProvider.getCurrentTimeMillis() + (j * 1000);
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) {
        return new JSONObject().put("status", appSettingsData.status).put("update_required", appSettingsData.updateRequired).put("report_upload_variant", appSettingsData.reportUploadVariant).put("native_report_upload_variant", appSettingsData.nativeReportUploadVariant);
    }

    private JSONObject toFabricJson(AppSettingsData appSettingsData) {
        return new JSONObject().put("bundle_id", appSettingsData.bundleId).put(AbstractAppSpiCall.ORGANIZATION_ID_PARAM, appSettingsData.organizationId);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        return new JSONObject().put("collect_reports", featuresSettingsData.collectReports);
    }

    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(getExpiresAtFrom(currentTimeProvider, (long) optInt2, jSONObject), buildAppDataFrom(jSONObject.getJSONObject("fabric"), jSONObject.getJSONObject("app")), defaultSessionData(), buildFeaturesSessionDataFrom(jSONObject.getJSONObject("features")), optInt, optInt2);
    }

    public JSONObject toJson(SettingsData settingsData) {
        return new JSONObject().put("expires_at", settingsData.expiresAtMillis).put("cache_duration", settingsData.cacheDuration).put("settings_version", settingsData.settingsVersion).put("features", toFeaturesJson(settingsData.featuresData)).put("app", toAppJson(settingsData.appData)).put("fabric", toFabricJson(settingsData.appData));
    }
}
