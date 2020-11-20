package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

public final class zzaud extends zzaue {
    private final String type;
    private final int zzdxu;

    public zzaud(String str, int i) {
        this.type = str;
        this.zzdxu = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaud)) {
            zzaud zzaud = (zzaud) obj;
            return Objects.equal(this.type, zzaud.type) && Objects.equal(Integer.valueOf(this.zzdxu), Integer.valueOf(zzaud.zzdxu));
        }
    }

    public final int getAmount() {
        return this.zzdxu;
    }

    public final String getType() {
        return this.type;
    }
}
