package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzbv implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzefl;

    zzbv(zzbt zzbt, Context context, Context context2) {
        this.zzefl = context;
        this.val$context = context2;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzefl != null) {
            zzd.zzee("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzefl.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzd.zzee("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzd.zzee("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzd.zzee("Persisting user agent.");
            }
        }
        return string;
    }
}
