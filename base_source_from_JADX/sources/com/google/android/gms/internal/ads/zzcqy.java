package com.google.android.gms.internal.ads;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.core.app.C0510i;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.C2228R;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;

public final class zzcqy extends zzaqz {
    private final Context context;
    private final zzckq zzdgx;
    private final zzaze zzdgy;
    private final zzcqo zzdgz;

    public zzcqy(Context context2, zzcqo zzcqo, zzaze zzaze, zzckq zzckq) {
        this.context = context2;
        this.zzdgx = zzckq;
        this.zzdgy = zzaze;
        this.zzdgz = zzcqo;
    }

    public static void zza(Context context2, zzckq zzckq, zzcqo zzcqo, String str, String str2) {
        zza(context2, zzckq, zzcqo, str, str2, new HashMap());
    }

    public static void zza(Context context2, zzckq zzckq, zzcqo zzcqo, String str, String str2, Map<String, String> map) {
        zzckp zzaqg = zzckq.zzaqg();
        zzaqg.zzr("gqi", str);
        zzaqg.zzr("action", str2);
        zzp.zzkq();
        zzaqg.zzr("device_connectivity", zzm.zzbc(context2) ? "online" : "offline");
        zzaqg.zzr("event_timestamp", String.valueOf(zzp.zzkx().currentTimeMillis()));
        for (Map.Entry next : map.entrySet()) {
            zzaqg.zzr((String) next.getKey(), (String) next.getValue());
        }
        zzcqo.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), str, zzaqg.zzaqe(), zzcql.zzgqc));
    }

    private final void zza(String str, String str2, Map<String, String> map) {
        zza(this.context, this.zzdgx, this.zzdgz, str, str2, map);
    }

    public final void zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            zzp.zzkq();
            boolean zzbc = zzm.zzbc(this.context);
            int i = zzcqx.zzgqm;
            HashMap hashMap = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (zzbc) {
                    i = zzcqx.zzgql;
                }
                Context context2 = this.context;
                Intent launchIntentForPackage = context2.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                    launchIntentForPackage.setData(Uri.parse(stringExtra3));
                }
                launchIntentForPackage.addFlags(268435456);
                context2.startActivity(launchIntentForPackage);
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zza(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzdgz.getWritableDatabase();
                if (i == zzcqx.zzgql) {
                    this.zzdgz.zza(writableDatabase, this.zzdgy, stringExtra2);
                } else {
                    zzcqo.zza(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzd.zzey(sb.toString());
            }
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        int i = PlatformVersion.isAtLeastM() ? 1140850688 : 1073741824;
        Intent intent = new Intent();
        intent.setClass(context2, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent service = zzduy.getService(context2, 0, intent, i);
        Intent intent2 = new Intent();
        intent2.setClass(context2, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent service2 = zzduy.getService(context2, 0, intent2, i);
        Resources resources = zzp.zzku().getResources();
        ((NotificationManager) context2.getSystemService("notification")).notify(str2, 54321, new C0510i.C0515e(context2, "offline_notification_channel").mo3465a((CharSequence) resources == null ? "View the ad you saved when you were offline" : resources.getString(C2228R.string.offline_notification_title)).mo3472b((CharSequence) resources == null ? "Tap to open ad" : resources.getString(C2228R.string.offline_notification_text)).mo3473b(true).mo3471b(service2).mo3461a(service).mo3457a(context2.getApplicationInfo().icon).mo3469b());
        zza(str2, "offline_notification_impression", new HashMap());
    }

    public final void zzuz() {
        this.zzdgz.zza(this.zzdgy);
    }
}
