package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.C0529a;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzb {
    private static final AtomicInteger zza = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private static int zza(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, AppIntroBaseFragmentKt.ARG_DRAWABLE, str);
            if (identifier != 0 && zza(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && zza(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !zza(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i == 0 || !zza(resources, i)) {
            return 17301651;
        }
        return i;
    }

    private static PendingIntent zza(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, zza.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    private static Bundle zza(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                return applicationInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.messaging.zza zza(android.content.Context r9, com.google.firebase.messaging.zzr r10) {
        /*
            android.content.pm.PackageManager r0 = r9.getPackageManager()
            java.lang.String r1 = r9.getPackageName()
            android.os.Bundle r0 = zza((android.content.pm.PackageManager) r0, (java.lang.String) r1)
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "gcm.n.android_channel_id"
            java.lang.String r2 = r10.zza((java.lang.String) r2)
            java.lang.String r2 = zzb(r9, r2, r0)
            android.content.res.Resources r3 = r9.getResources()
            android.content.pm.PackageManager r4 = r9.getPackageManager()
            androidx.core.app.i$e r5 = new androidx.core.app.i$e
            r5.<init>(r9, r2)
            java.lang.String r2 = "gcm.n.title"
            java.lang.String r2 = r10.zza(r3, r1, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0036
            r5.mo3465a((java.lang.CharSequence) r2)
        L_0x0036:
            java.lang.String r2 = "gcm.n.body"
            java.lang.String r2 = r10.zza(r3, r1, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0051
            r5.mo3472b((java.lang.CharSequence) r2)
            androidx.core.app.i$c r6 = new androidx.core.app.i$c
            r6.<init>()
            androidx.core.app.i$c r2 = r6.mo3448a((java.lang.CharSequence) r2)
            r5.mo3464a((androidx.core.app.C0510i.C0516f) r2)
        L_0x0051:
            java.lang.String r2 = "gcm.n.icon"
            java.lang.String r2 = r10.zza((java.lang.String) r2)
            int r2 = zza(r4, r3, r1, r2, r0)
            r5.mo3457a((int) r2)
            java.lang.String r2 = r10.zzb()
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r7 = 2
            r8 = 0
            if (r6 == 0) goto L_0x006c
            r2 = r8
            goto L_0x00b1
        L_0x006c:
            java.lang.String r6 = "default"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x00ad
            java.lang.String r6 = "raw"
            int r3 = r3.getIdentifier(r2, r6, r1)
            if (r3 == 0) goto L_0x00ad
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 24
            java.lang.String r6 = java.lang.String.valueOf(r2)
            int r6 = r6.length()
            int r3 = r3 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            java.lang.String r3 = "android.resource://"
            r6.append(r3)
            r6.append(r1)
            java.lang.String r3 = "/raw/"
            r6.append(r3)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            goto L_0x00b1
        L_0x00ad:
            android.net.Uri r2 = android.media.RingtoneManager.getDefaultUri(r7)
        L_0x00b1:
            if (r2 == 0) goto L_0x00b6
            r5.mo3463a((android.net.Uri) r2)
        L_0x00b6:
            java.lang.String r2 = "gcm.n.click_action"
            java.lang.String r2 = r10.zza((java.lang.String) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x00d0
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r2)
            r3.setPackage(r1)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r3.setFlags(r1)
            goto L_0x00f2
        L_0x00d0:
            android.net.Uri r2 = r10.zza()
            if (r2 == 0) goto L_0x00e4
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)
            r3.setPackage(r1)
            r3.setData(r2)
            goto L_0x00f2
        L_0x00e4:
            android.content.Intent r1 = r4.getLaunchIntentForPackage(r1)
            if (r1 != 0) goto L_0x00f1
            java.lang.String r2 = "FirebaseMessaging"
            java.lang.String r3 = "No activity found to launch app"
            android.util.Log.w(r2, r3)
        L_0x00f1:
            r3 = r1
        L_0x00f2:
            if (r3 != 0) goto L_0x00f6
            r1 = r8
            goto L_0x012f
        L_0x00f6:
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r3.addFlags(r1)
            android.os.Bundle r1 = r10.zze()
            r3.putExtras(r1)
            java.util.concurrent.atomic.AtomicInteger r1 = zza
            int r1 = r1.incrementAndGet()
            r2 = 1073741824(0x40000000, float:2.0)
            android.app.PendingIntent r1 = android.app.PendingIntent.getActivity(r9, r1, r3, r2)
            java.lang.String r2 = "google.c.a.e"
            boolean r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x012f
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "com.google.firebase.messaging.NOTIFICATION_OPEN"
            r2.<init>(r3)
            android.os.Bundle r3 = r10.zzf()
            android.content.Intent r2 = r2.putExtras(r3)
            java.lang.String r3 = "pending_intent"
            android.content.Intent r1 = r2.putExtra(r3, r1)
            android.app.PendingIntent r1 = zza((android.content.Context) r9, (android.content.Intent) r1)
        L_0x012f:
            r5.mo3461a((android.app.PendingIntent) r1)
            java.lang.String r1 = "google.c.a.e"
            boolean r1 = r10.zzb(r1)
            if (r1 != 0) goto L_0x013c
            r1 = r8
            goto L_0x014f
        L_0x013c:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            r1.<init>(r2)
            android.os.Bundle r2 = r10.zzf()
            android.content.Intent r1 = r1.putExtras(r2)
            android.app.PendingIntent r1 = zza((android.content.Context) r9, (android.content.Intent) r1)
        L_0x014f:
            if (r1 == 0) goto L_0x0154
            r5.mo3471b((android.app.PendingIntent) r1)
        L_0x0154:
            java.lang.String r1 = "gcm.n.color"
            java.lang.String r1 = r10.zza((java.lang.String) r1)
            java.lang.Integer r9 = zza(r9, r1, r0)
            if (r9 == 0) goto L_0x0167
            int r9 = r9.intValue()
            r5.mo3478e(r9)
        L_0x0167:
            java.lang.String r9 = "gcm.n.sticky"
            boolean r9 = r10.zzb(r9)
            r0 = 1
            r9 = r9 ^ r0
            r5.mo3473b((boolean) r9)
            java.lang.String r9 = "gcm.n.local_only"
            boolean r9 = r10.zzb(r9)
            r5.mo3476c((boolean) r9)
            java.lang.String r9 = "gcm.n.ticker"
            java.lang.String r9 = r10.zza((java.lang.String) r9)
            if (r9 == 0) goto L_0x0186
            r5.mo3475c((java.lang.CharSequence) r9)
        L_0x0186:
            java.lang.String r9 = "gcm.n.notification_priority"
            java.lang.Integer r9 = r10.zzc(r9)
            if (r9 != 0) goto L_0x0190
        L_0x018e:
            r9 = r8
            goto L_0x01c7
        L_0x0190:
            int r1 = r9.intValue()
            r2 = -2
            if (r1 < r2) goto L_0x019d
            int r1 = r9.intValue()
            if (r1 <= r7) goto L_0x01c7
        L_0x019d:
            java.lang.String r1 = "FirebaseMessaging"
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            int r2 = r2.length()
            int r2 = r2 + 72
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "notificationPriority is invalid "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = ". Skipping setting notificationPriority."
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.w(r1, r9)
            goto L_0x018e
        L_0x01c7:
            if (r9 == 0) goto L_0x01d0
            int r9 = r9.intValue()
            r5.mo3477d((int) r9)
        L_0x01d0:
            java.lang.String r9 = "gcm.n.visibility"
            java.lang.Integer r9 = r10.zzc(r9)
            if (r9 != 0) goto L_0x01da
        L_0x01d8:
            r9 = r8
            goto L_0x0211
        L_0x01da:
            int r1 = r9.intValue()
            r2 = -1
            if (r1 < r2) goto L_0x01e7
            int r1 = r9.intValue()
            if (r1 <= r0) goto L_0x0211
        L_0x01e7:
            java.lang.String r1 = "NotificationParams"
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            int r2 = r2.length()
            int r2 = r2 + 53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "visibility is invalid: "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = ". Skipping setting visibility."
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.w(r1, r9)
            goto L_0x01d8
        L_0x0211:
            if (r9 == 0) goto L_0x021a
            int r9 = r9.intValue()
            r5.mo3479f(r9)
        L_0x021a:
            java.lang.String r9 = "gcm.n.notification_count"
            java.lang.Integer r9 = r10.zzc(r9)
            if (r9 != 0) goto L_0x0223
            goto L_0x0254
        L_0x0223:
            int r1 = r9.intValue()
            if (r1 >= 0) goto L_0x0253
            java.lang.String r1 = "FirebaseMessaging"
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            int r2 = r2.length()
            int r2 = r2 + 67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "notificationCount is invalid: "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = ". Skipping setting notificationCount."
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.w(r1, r9)
            goto L_0x0254
        L_0x0253:
            r8 = r9
        L_0x0254:
            if (r8 == 0) goto L_0x025d
            int r9 = r8.intValue()
            r5.mo3470b((int) r9)
        L_0x025d:
            java.lang.String r9 = "gcm.n.event_time"
            java.lang.Long r9 = r10.zzd(r9)
            if (r9 == 0) goto L_0x026f
            r5.mo3467a((boolean) r0)
            long r1 = r9.longValue()
            r5.mo3460a((long) r1)
        L_0x026f:
            long[] r9 = r10.zzc()
            if (r9 == 0) goto L_0x0278
            r5.mo3468a((long[]) r9)
        L_0x0278:
            int[] r9 = r10.zzd()
            r1 = 0
            if (r9 == 0) goto L_0x0288
            r2 = r9[r1]
            r3 = r9[r0]
            r9 = r9[r7]
            r5.mo3458a((int) r2, (int) r3, (int) r9)
        L_0x0288:
            java.lang.String r9 = "gcm.n.default_sound"
            boolean r9 = r10.zzb(r9)
            if (r9 == 0) goto L_0x0291
            goto L_0x0292
        L_0x0291:
            r0 = 0
        L_0x0292:
            java.lang.String r9 = "gcm.n.default_vibrate_timings"
            boolean r9 = r10.zzb(r9)
            if (r9 == 0) goto L_0x029c
            r0 = r0 | 2
        L_0x029c:
            java.lang.String r9 = "gcm.n.default_light_settings"
            boolean r9 = r10.zzb(r9)
            if (r9 == 0) goto L_0x02a6
            r0 = r0 | 4
        L_0x02a6:
            r5.mo3474c((int) r0)
            com.google.firebase.messaging.zza r9 = new com.google.firebase.messaging.zza
            java.lang.String r0 = "gcm.n.tag"
            java.lang.String r10 = r10.zza((java.lang.String) r0)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x02b8
            goto L_0x02cf
        L_0x02b8:
            long r2 = android.os.SystemClock.uptimeMillis()
            r10 = 37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r10 = "FCM-Notification:"
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
        L_0x02cf:
            r9.<init>(r5, r10, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzb.zza(android.content.Context, com.google.firebase.messaging.zzr):com.google.firebase.messaging.zza");
    }

    private static Integer zza(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(C0529a.m2102c(context, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    @TargetApi(26)
    private static boolean zza(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    @TargetApi(26)
    private static String zzb(Context context, String str, Bundle bundle) {
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb.toString());
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                str3 = "FirebaseMessaging";
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                str3 = "FirebaseMessaging";
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            }
            Log.w(str3, str2);
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") != null) {
                return "fcm_fallback_notification_channel";
            }
            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
