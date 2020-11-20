package com.parse;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.C0510i;
import java.util.Locale;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePushBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_PUSH_DELETE = "com.parse.push.intent.DELETE";
    public static final String ACTION_PUSH_OPEN = "com.parse.push.intent.OPEN";
    public static final String ACTION_PUSH_RECEIVE = "com.parse.push.intent.RECEIVE";
    public static final String KEY_PUSH_CHANNEL = "com.parse.Channel";
    public static final String KEY_PUSH_DATA = "com.parse.Data";
    public static final String PROPERTY_PUSH_ICON = "com.parse.push.notification_icon";
    protected static final int SMALL_NOTIFICATION_MAX_CHARACTER_LIMIT = 38;
    private static final String TAG = "com.parse.ParsePushReceiver";

    /* access modifiers changed from: protected */
    @TargetApi(26)
    public void createNotificationChannel(Context context, NotificationChannel notificationChannel) {
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
    }

    /* access modifiers changed from: protected */
    public Class<? extends Activity> getActivity(Context context, Intent intent) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        try {
            return Class.forName(launchIntentForPackage.getComponent().getClassName());
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Intent getContentIntent(Bundle bundle, String str) {
        Intent intent = new Intent(ACTION_PUSH_OPEN);
        intent.putExtras(bundle);
        intent.setPackage(str);
        return intent;
    }

    /* access modifiers changed from: protected */
    public Intent getDeleteIntent(Bundle bundle, String str) {
        Intent intent = new Intent(ACTION_PUSH_DELETE);
        intent.putExtras(bundle);
        intent.setPackage(str);
        return intent;
    }

    /* access modifiers changed from: protected */
    public Bitmap getLargeIcon(Context context, Intent intent) {
        return null;
    }

    /* access modifiers changed from: protected */
    public C0510i.C0515e getNotification(Context context, Intent intent) {
        JSONObject pushData = getPushData(intent);
        String str = null;
        if (pushData == null || (!pushData.has("alert") && !pushData.has("title"))) {
            return null;
        }
        String optString = pushData.optString("title", ManifestInfo.getDisplayName(context));
        String optString2 = pushData.optString("alert", "Notification received.");
        String format = String.format(Locale.getDefault(), "%s: %s", new Object[]{optString, optString2});
        Bundle extras = intent.getExtras();
        Random random = new Random();
        int nextInt = random.nextInt();
        int nextInt2 = random.nextInt();
        String packageName = context.getPackageName();
        Intent contentIntent = getContentIntent(extras, packageName);
        Intent deleteIntent = getDeleteIntent(extras, packageName);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, nextInt, contentIntent, 134217728);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, nextInt2, deleteIntent, 134217728);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = getNotificationChannel(context, intent);
            createNotificationChannel(context, notificationChannel);
            str = notificationChannel.getId();
        }
        C0510i.C0515e eVar = new C0510i.C0515e(context, str);
        eVar.mo3465a((CharSequence) optString).mo3472b((CharSequence) optString2).mo3475c((CharSequence) format).mo3457a(getSmallIconId(context, intent)).mo3462a(getLargeIcon(context, intent)).mo3461a(broadcast).mo3471b(broadcast2).mo3473b(true).mo3474c(-1);
        if (optString2 != null && optString2.length() > 38) {
            eVar.mo3464a((C0510i.C0516f) new C0510i.C0513c().mo3448a((CharSequence) optString2));
        }
        return eVar;
    }

    /* access modifiers changed from: protected */
    @TargetApi(26)
    public NotificationChannel getNotificationChannel(Context context, Intent intent) {
        return new NotificationChannel("parse_push", "Push notifications", 3);
    }

    /* access modifiers changed from: protected */
    public JSONObject getPushData(Intent intent) {
        try {
            return new JSONObject(intent.getStringExtra(KEY_PUSH_DATA));
        } catch (JSONException e) {
            PLog.m8817e(TAG, "Unexpected JSONException when receiving push data: ", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public int getSmallIconId(Context context, Intent intent) {
        Bundle applicationMetadata = ManifestInfo.getApplicationMetadata(context);
        int i = applicationMetadata != null ? applicationMetadata.getInt(PROPERTY_PUSH_ICON) : 0;
        return i != 0 ? i : ManifestInfo.getIconId();
    }

    /* access modifiers changed from: protected */
    public void onPushDismiss(Context context, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onPushOpen(Context context, Intent intent) {
        ParseAnalytics.trackAppOpenedInBackground(intent);
        String str = null;
        try {
            str = new JSONObject(intent.getStringExtra(KEY_PUSH_DATA)).optString("uri", (String) null);
        } catch (JSONException e) {
            PLog.m8817e(TAG, "Unexpected JSONException when receiving push data: ", e);
        }
        Class<? extends Activity> activity = getActivity(context, intent);
        Intent intent2 = str != null ? new Intent("android.intent.action.VIEW", Uri.parse(str)) : new Intent(context, activity);
        intent2.putExtras(intent.getExtras());
        if (Build.VERSION.SDK_INT >= 16) {
            TaskStackBuilderHelper.startActivities(context, activity, intent2);
            return;
        }
        intent2.addFlags(268435456);
        intent2.addFlags(67108864);
        context.startActivity(intent2);
    }

    /* access modifiers changed from: protected */
    public void onPushReceive(Context context, Intent intent) {
        JSONObject jSONObject;
        String stringExtra = intent.getStringExtra(KEY_PUSH_DATA);
        if (stringExtra == null) {
            PLog.m8816e(TAG, "Can not get push data from intent.");
            return;
        }
        PLog.m8820v(TAG, "Received push data: " + stringExtra);
        Notification notification = null;
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e) {
            PLog.m8817e(TAG, "Unexpected JSONException when receiving push data: ", e);
            jSONObject = null;
        }
        String optString = jSONObject != null ? jSONObject.optString("action", (String) null) : null;
        if (optString != null) {
            Bundle extras = intent.getExtras();
            Intent intent2 = new Intent();
            intent2.putExtras(extras);
            intent2.setAction(optString);
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2);
        }
        C0510i.C0515e notification2 = getNotification(context, intent);
        if (notification2 != null) {
            notification = notification2.mo3469b();
        }
        if (notification != null) {
            ParseNotificationManager.getInstance().showNotification(context, notification);
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -824874927) {
                if (hashCode != -269490979) {
                    if (hashCode == 374898288 && action.equals(ACTION_PUSH_OPEN)) {
                        c = 2;
                    }
                } else if (action.equals(ACTION_PUSH_RECEIVE)) {
                    c = 0;
                }
            } else if (action.equals(ACTION_PUSH_DELETE)) {
                c = 1;
            }
            switch (c) {
                case 0:
                    onPushReceive(context, intent);
                    return;
                case 1:
                    onPushDismiss(context, intent);
                    return;
                case 2:
                    onPushOpen(context, intent);
                    return;
                default:
                    return;
            }
        }
    }
}
