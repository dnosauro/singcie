package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

public final class zzczw implements zzdfj<Bundle> {
    private final Context context;
    private final zzvn zzbpe;
    private final List<Parcelable> zzgxy;

    public zzczw(Context context2, zzvn zzvn, List<Parcelable> list) {
        this.context = context2;
        this.zzbpe = zzvn;
        this.zzgxy = list;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (zzadd.zzdcy.get().booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzp.zzkq();
            bundle2.putString("activity", zzm.zzar(this.context));
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzbpe.width);
            bundle3.putInt("height", this.zzbpe.height);
            bundle2.putBundle("size", bundle3);
            if (this.zzgxy.size() > 0) {
                List<Parcelable> list = this.zzgxy;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
