package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.p018c.C0400a;
import androidx.p018c.C0413g;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

public final class zzcgb extends zzafe {
    private final Context zzaaa;
    private final zzcce zzgaq;
    /* access modifiers changed from: private */
    public zzcbt zzgdx;
    private zzcda zzghf;

    public zzcgb(Context context, zzcce zzcce, zzcda zzcda, zzcbt zzcbt) {
        this.zzaaa = context;
        this.zzgaq = zzcce;
        this.zzghf = zzcda;
        this.zzgdx = zzcbt;
    }

    public final void destroy() {
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt != null) {
            zzcbt.destroy();
        }
        this.zzgdx = null;
        this.zzghf = null;
    }

    public final List<String> getAvailableAssetNames() {
        C0413g<String, zzadv> zzank = this.zzgaq.zzank();
        C0413g<String, String> zzanm = this.zzgaq.zzanm();
        String[] strArr = new String[(zzank.size() + zzanm.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzank.size()) {
            strArr[i3] = zzank.mo2948b(i2);
            i2++;
            i3++;
        }
        while (i < zzanm.size()) {
            strArr[i3] = zzanm.mo2948b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzgaq.getCustomTemplateId();
    }

    public final zzys getVideoController() {
        return this.zzgaq.getVideoController();
    }

    public final void performClick(String str) {
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt != null) {
            zzcbt.zzfw(str);
        }
    }

    public final void recordImpression() {
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt != null) {
            zzcbt.zzamr();
        }
    }

    public final String zzct(String str) {
        return this.zzgaq.zzanm().get(str);
    }

    public final zzaej zzcu(String str) {
        return this.zzgaq.zzank().get(str);
    }

    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup)) {
            return false;
        }
        zzcda zzcda = this.zzghf;
        if (!(zzcda != null && zzcda.zza((ViewGroup) unwrap))) {
            return false;
        }
        this.zzgaq.zzanh().zza((zzadx) new zzcge(this));
        return true;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzcbt zzcbt;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzgaq.zzanj() != null && (zzcbt = this.zzgdx) != null) {
            zzcbt.zzaa((View) unwrap);
        }
    }

    public final IObjectWrapper zzsv() {
        return null;
    }

    public final IObjectWrapper zzta() {
        return ObjectWrapper.wrap(this.zzaaa);
    }

    public final boolean zztb() {
        zzcbt zzcbt = this.zzgdx;
        return (zzcbt == null || zzcbt.zzamy()) && this.zzgaq.zzani() != null && this.zzgaq.zzanh() == null;
    }

    public final boolean zztc() {
        IObjectWrapper zzanj = this.zzgaq.zzanj();
        if (zzanj != null) {
            zzp.zzlf().zzab(zzanj);
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcuo)).booleanValue() || this.zzgaq.zzani() == null) {
                return true;
            }
            this.zzgaq.zzani().zza("onSdkLoaded", new C0400a());
            return true;
        }
        zzd.zzfa("Trying to start OMID session before creation.");
        return false;
    }

    public final void zztd() {
        String zzanl = this.zzgaq.zzanl();
        if ("Google".equals(zzanl)) {
            zzd.zzfa("Illegal argument specified for omid partner name.");
            return;
        }
        zzcbt zzcbt = this.zzgdx;
        if (zzcbt != null) {
            zzcbt.zzi(zzanl, false);
        }
    }
}
