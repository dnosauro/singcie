package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class zzepe {
    public static <T> List<T> zzic(int i) {
        return i == 0 ? Collections.emptyList() : new ArrayList(i);
    }

    static <T> HashSet<T> zzid(int i) {
        return new HashSet<>(zzif(i));
    }

    public static <K, V> LinkedHashMap<K, V> zzie(int i) {
        return new LinkedHashMap<>(zzif(i));
    }

    private static int zzif(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
