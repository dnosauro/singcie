package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzea {
    public static <T> zzeb<T> zza(zzeb<T> zzeb) {
        return ((zzeb instanceof zzec) || (zzeb instanceof zzed)) ? zzeb : zzeb instanceof Serializable ? new zzed(zzeb) : new zzec(zzeb);
    }

    public static <T> zzeb<T> zza(@NullableDecl T t) {
        return new zzef(t);
    }
}
