package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzaye {
    private long zzeag = -1;
    private long zzeah = -1;
    private final /* synthetic */ zzayf zzeai;

    public zzaye(zzayf zzayf) {
        this.zzeai = zzayf;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzeag);
        bundle.putLong("tclose", this.zzeah);
        return bundle;
    }

    public final long zzwm() {
        return this.zzeah;
    }

    public final void zzwn() {
        this.zzeah = this.zzeai.zzbpw.elapsedRealtime();
    }

    public final void zzwo() {
        this.zzeag = this.zzeai.zzbpw.elapsedRealtime();
    }
}
