package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

final class zzv {
    private final SharedPreferences zza;

    zzv(Context context) {
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
    }

    /* access modifiers changed from: package-private */
    public final synchronized String zza() {
        return this.zza.getString("topic_operation_queue", "");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str) {
        this.zza.edit().putString("topic_operation_queue", str).apply();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzb(String str) {
        boolean z;
        String zza2 = zza();
        String valueOf = String.valueOf(str);
        String concat = valueOf.length() != 0 ? ",".concat(valueOf) : new String(",");
        if (zza2.startsWith(concat)) {
            zza(zza2.substring(concat.length()));
            z = true;
        } else {
            if (zzu.zzc()) {
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 105);
                sb.append("Illegal topic operation queue: ");
                sb.append(zza2);
                sb.append(". Illegal topic operation queue will lead to any topic operations to fail.");
                Log.d("FirebaseMessaging", sb.toString());
            }
            z = false;
        }
        return z;
    }
}
