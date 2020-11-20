package androidx.media.p055a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p002v4.media.MediaBrowserCompat;
import android.support.p002v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* renamed from: androidx.media.a.a */
public class C0974a extends BroadcastReceiver {

    /* renamed from: androidx.media.a.a$a */
    private static class C0975a extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: a */
        private final Context f3118a;

        /* renamed from: b */
        private final Intent f3119b;

        /* renamed from: c */
        private final BroadcastReceiver.PendingResult f3120c;

        /* renamed from: d */
        private MediaBrowserCompat f3121d;

        C0975a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f3118a = context;
            this.f3119b = intent;
            this.f3120c = pendingResult;
        }

        /* renamed from: a */
        private void m3779a() {
            this.f3121d.disconnect();
            this.f3120c.finish();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5152a(MediaBrowserCompat mediaBrowserCompat) {
            this.f3121d = mediaBrowserCompat;
        }

        public void onConnected() {
            try {
                new MediaControllerCompat(this.f3118a, this.f3121d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f3119b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
            }
            m3779a();
        }

        public void onConnectionFailed() {
            m3779a();
        }

        public void onConnectionSuspended() {
            m3779a();
        }
    }

    /* renamed from: a */
    public static ComponentName m3776a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        } else if (queryBroadcastReceivers.size() <= 1) {
            return null;
        } else {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        }
    }

    /* renamed from: a */
    private static ComponentName m3777a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    /* renamed from: a */
    private static void m3778a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName a = m3777a(context, "android.intent.action.MEDIA_BUTTON");
        if (a != null) {
            intent.setComponent(a);
            m3778a(context, intent);
            return;
        }
        ComponentName a2 = m3777a(context, "android.media.browse.MediaBrowserService");
        if (a2 != null) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            C0975a aVar = new C0975a(applicationContext, intent, goAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a2, aVar, (Bundle) null);
            aVar.mo5152a(mediaBrowserCompat);
            mediaBrowserCompat.connect();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
}
