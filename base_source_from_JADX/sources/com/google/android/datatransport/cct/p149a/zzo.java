package com.google.android.datatransport.cct.p149a;

import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
@Encodable
/* renamed from: com.google.android.datatransport.cct.a.zzo */
public abstract class zzo {
    public static zzo zza(List<zzr> list) {
        return new zze(list);
    }

    @Encodable.Field(name = "logRequest")
    public abstract List<zzr> zza();
}
