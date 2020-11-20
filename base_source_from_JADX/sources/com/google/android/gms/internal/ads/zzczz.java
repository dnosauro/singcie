package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

public final class zzczz implements zzdfi<zzczw> {
    private final Context context;
    private final zzdnn zzfvl;
    private final zzdzc zzgyd;
    private final View zzgye;

    public zzczz(zzdzc zzdzc, Context context2, zzdnn zzdnn, ViewGroup viewGroup) {
        this.zzgyd = zzdzc;
        this.context = context2;
        this.zzfvl = zzdnn;
        this.zzgye = viewGroup;
    }

    public final zzdyz<zzczw> zzasm() {
        return this.zzgyd.zze(new zzczy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczw zzasn() {
        Context context2 = this.context;
        zzvn zzvn = this.zzfvl.zzbpe;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgye;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzczw(context2, zzvn, arrayList);
    }
}
