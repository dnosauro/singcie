package com.parse;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import bolts.Continuation;
import bolts.Task;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.parse.ParseObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@ParseClassName("_Installation")
public class ParseInstallation extends ParseObject {
    private static final String KEY_APP_IDENTIFIER = "appIdentifier";
    private static final String KEY_APP_NAME = "appName";
    private static final String KEY_APP_VERSION = "appVersion";
    static final String KEY_CHANNELS = "channels";
    private static final String KEY_DEVICE_TOKEN = "deviceToken";
    private static final String KEY_DEVICE_TYPE = "deviceType";
    private static final String KEY_INSTALLATION_ID = "installationId";
    private static final String KEY_LOCALE = "localeIdentifier";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_PARSE_VERSION = "parseVersion";
    private static final String KEY_PUSH_TYPE = "pushType";
    private static final String KEY_TIME_ZONE = "timeZone";
    private static final List<String> READ_ONLY_FIELDS = Collections.unmodifiableList(Arrays.asList(new String[]{KEY_DEVICE_TYPE, KEY_INSTALLATION_ID, KEY_DEVICE_TOKEN, KEY_PUSH_TYPE, KEY_TIME_ZONE, KEY_LOCALE, KEY_APP_VERSION, KEY_APP_NAME, KEY_PARSE_VERSION, KEY_APP_IDENTIFIER, "objectId"}));
    private static final String TAG = "com.parse.ParseInstallation";

    public static ParseInstallation getCurrentInstallation() {
        try {
            return (ParseInstallation) ParseTaskUtils.wait(getCurrentInstallationController().getAsync());
        } catch (ParseException unused) {
            return null;
        }
    }

    static ParseCurrentInstallationController getCurrentInstallationController() {
        return ParseCorePlugins.getInstance().getCurrentInstallationController();
    }

    public static ParseQuery<ParseInstallation> getQuery() {
        return ParseQuery.getQuery(ParseInstallation.class);
    }

    private void updateLocaleIdentifier() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(language)) {
            if (language.equals("iw")) {
                language = "he";
            }
            if (language.equals("in")) {
                language = "id";
            }
            if (language.equals("ji")) {
                language = "yi";
            }
            if (!TextUtils.isEmpty(country)) {
                language = String.format(Locale.US, "%s-%s", new Object[]{language, country});
            }
            if (!language.equals(get(KEY_LOCALE))) {
                performPut(KEY_LOCALE, language);
            }
        }
    }

    private void updateTimezone() {
        String id = TimeZone.getDefault().getID();
        if ((id.indexOf(47) > 0 || id.equals("GMT")) && !id.equals(get(KEY_TIME_ZONE))) {
            performPut(KEY_TIME_ZONE, id);
        }
    }

    private void updateVersionInfo() {
        synchronized (this.mutex) {
            try {
                Context applicationContext = Parse.getApplicationContext();
                String packageName = applicationContext.getPackageName();
                PackageManager packageManager = applicationContext.getPackageManager();
                String str = packageManager.getPackageInfo(packageName, 0).versionName;
                String charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0)).toString();
                if (packageName != null && !packageName.equals(get(KEY_APP_IDENTIFIER))) {
                    performPut(KEY_APP_IDENTIFIER, packageName);
                }
                if (charSequence != null && !charSequence.equals(get(KEY_APP_NAME))) {
                    performPut(KEY_APP_NAME, charSequence);
                }
                if (str != null && !str.equals(get(KEY_APP_VERSION))) {
                    performPut(KEY_APP_VERSION, str);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                PLog.m8822w(TAG, "Cannot load package info; will not be saved to installation");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchAsync(final String str, final Task<Void> task) {
        Task<TContinuationResult> onSuccessTask;
        synchronized (this.mutex) {
            onSuccessTask = (getObjectId() == null ? saveAsync(str, task) : Task.forResult(null)).onSuccessTask(new Continuation<Void, Task<T>>() {
                public Task<T> then(Task<Void> task) {
                    return ParseInstallation.super.fetchAsync(str, task);
                }
            });
        }
        return onSuccessTask;
    }

    public String getDeviceToken() {
        return super.getString(KEY_DEVICE_TOKEN);
    }

    public String getInstallationId() {
        return getString(KEY_INSTALLATION_ID);
    }

    public String getPushType() {
        return super.getString(KEY_PUSH_TYPE);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleFetchResultAsync(ParseObject.State state) {
        return super.handleFetchResultAsync(state).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleSaveResultAsync(ParseObject.State state, ParseOperationSet parseOperationSet) {
        Task<Void> handleSaveResultAsync = super.handleSaveResultAsync(state, parseOperationSet);
        return state == null ? handleSaveResultAsync : handleSaveResultAsync.onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean isKeyMutable(String str) {
        return !READ_ONLY_FIELDS.contains(str);
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void removeDeviceToken() {
        performRemove(KEY_DEVICE_TOKEN);
    }

    /* access modifiers changed from: package-private */
    public void removePushType() {
        performRemove(KEY_PUSH_TYPE);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(final String str, final Task<Void> task) {
        return super.saveAsync(str, task).continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                int code;
                Task<Void> access$101;
                if (task.getError() == null || !(task.getError() instanceof ParseException) || ((code = ((ParseException) task.getError()).getCode()) != 101 && (code != 135 || ParseInstallation.this.getObjectId() != null))) {
                    return task;
                }
                synchronized (ParseInstallation.this.mutex) {
                    ParseInstallation.this.setState(((ParseObject.State.Builder) new ParseObject.State.Builder(ParseInstallation.this.getState()).objectId((String) null)).build());
                    ParseInstallation.this.markAllFieldsDirty();
                    access$101 = ParseInstallation.super.saveAsync(str, task);
                }
                return access$101;
            }
        });
    }

    public void setDeviceToken(String str) {
        if (str != null && str.length() > 0) {
            performPut(KEY_DEVICE_TOKEN, str);
        }
    }

    public void setObjectId(String str) {
        throw new RuntimeException("Installation's objectId cannot be changed");
    }

    public void setPushType(String str) {
        if (str != null) {
            performPut(KEY_PUSH_TYPE, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateBeforeSave() {
        super.updateBeforeSave();
        if (getCurrentInstallationController().isCurrent(this)) {
            updateTimezone();
            updateVersionInfo();
            updateDeviceInfo();
            updateLocaleIdentifier();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateDeviceInfo() {
        updateDeviceInfo(ParsePlugins.get().installationId());
    }

    /* access modifiers changed from: package-private */
    public void updateDeviceInfo(InstallationId installationId) {
        if (!has(KEY_INSTALLATION_ID)) {
            performPut(KEY_INSTALLATION_ID, installationId.get());
        }
        if (!AbstractSpiCall.ANDROID_CLIENT_TYPE.equals(get(KEY_DEVICE_TYPE))) {
            performPut(KEY_DEVICE_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        }
    }
}
