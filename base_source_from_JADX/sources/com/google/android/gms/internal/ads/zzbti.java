package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbti extends zzbwk<AdMetadataListener> implements zzagy {
    private Bundle zzfxy = new Bundle();

    public zzbti(Set<zzbxy<AdMetadataListener>> set) {
        super(set);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfxy);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfxy.putAll(bundle);
        zza(zzbtl.zzfxs);
    }
}
