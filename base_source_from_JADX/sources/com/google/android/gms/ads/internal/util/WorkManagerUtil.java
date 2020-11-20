package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.C1185b;
import androidx.work.C1188c;
import androidx.work.C1192e;
import androidx.work.C1198i;
import androidx.work.C1324j;
import androidx.work.C1337o;
import androidx.work.C1338p;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaza;

@KeepForSdk
public class WorkManagerUtil extends zzbi {
    private static void zzbt(Context context) {
        try {
            C1337o.m5189a(context.getApplicationContext(), new C1185b.C1186a().mo6375a());
        } catch (IllegalStateException unused) {
        }
    }

    public final void zzap(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbt(context);
        try {
            C1337o a = C1337o.m5188a(context);
            a.mo6584a("offline_ping_sender_work");
            a.mo6680a((C1338p) (C1324j) ((C1324j.C1325a) ((C1324j.C1325a) new C1324j.C1325a(OfflinePingSender.class).mo6684a(new C1188c.C1189a().mo6396a(C1198i.CONNECTED).mo6397a())).mo6686a("offline_ping_sender_work")).mo6687e());
        } catch (IllegalStateException e) {
            zzaza.zzd("Failed to instantiate WorkManager.", e);
        }
    }

    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbt(context);
        C1188c a = new C1188c.C1189a().mo6396a(C1198i.CONNECTED).mo6397a();
        try {
            C1337o.m5188a(context).mo6680a((C1338p) (C1324j) ((C1324j.C1325a) ((C1324j.C1325a) ((C1324j.C1325a) new C1324j.C1325a(OfflineNotificationPoster.class).mo6684a(a)).mo6685a(new C1192e.C1193a().mo6414a("uri", str).mo6414a("gws_query_id", str2).mo6416a())).mo6686a("offline_notification_work")).mo6687e());
            return true;
        } catch (IllegalStateException e) {
            zzaza.zzd("Failed to instantiate WorkManager.", e);
            return false;
        }
    }
}
