package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzcy {
    private final Map<String, Map<String, String>> zza;

    zzcy(Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        Map map;
        if (uri == null || (map = this.zza.get(uri.toString())) == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str2);
            String valueOf2 = String.valueOf(str3);
            str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return (String) map.get(str3);
    }
}
