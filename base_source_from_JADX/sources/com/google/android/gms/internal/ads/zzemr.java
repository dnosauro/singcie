package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzemr extends zzems<FieldDescriptorType, Object> {
    zzemr(int i) {
        super(i, (zzemr) null);
    }

    public final void zzbfl() {
        if (!isImmutable()) {
            for (int i = 0; i < zzbjx(); i++) {
                Map.Entry zzht = zzht(i);
                if (((zzejz) zzht.getKey()).zzbhn()) {
                    zzht.setValue(Collections.unmodifiableList((List) zzht.getValue()));
                }
            }
            for (Map.Entry entry : zzbjy()) {
                if (((zzejz) entry.getKey()).zzbhn()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbfl();
    }
}
