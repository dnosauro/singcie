package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.p018c.C0400a;

public final class zzdd {
    private static final C0400a<String, Uri> zza = new C0400a<>();

    public static synchronized Uri zza(String str) {
        Uri uri;
        synchronized (zzdd.class) {
            uri = zza.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                zza.put(str, uri);
            }
        }
        return uri;
    }
}
