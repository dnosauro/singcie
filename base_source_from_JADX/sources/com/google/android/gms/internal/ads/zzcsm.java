package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.p017a.C0395c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

public final class zzcsm implements zzcqz<zzbyx> {
    private final Context context;
    private final zzdms zzfpo;
    private final Executor zzfqx;
    private final zzbzx zzgrt;

    public zzcsm(Context context2, Executor executor, zzbzx zzbzx, zzdms zzdms) {
        this.context = context2;
        this.zzgrt = zzbzx;
        this.zzfqx = executor;
        this.zzfpo = zzdms;
    }

    private static String zze(zzdmu zzdmu) {
        try {
            return zzdmu.zzhha.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(Uri uri, zzdnj zzdnj, zzdmu zzdmu, Object obj) {
        try {
            C0395c a = new C0395c.C0396a().mo2805a();
            a.f1348a.setData(uri);
            zzb zzb = new zzb(a.f1348a);
            zzazq zzazq = new zzazq();
            zzbyz zza = this.zzgrt.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbzc(new zzcso(zzazq)));
            zzazq.set(new AdOverlayInfoParcel(zzb, (zzva) null, zza.zzahi(), (zzu) null, new zzazh(0, 0, false)));
            this.zzfpo.zzwv();
            return zzdyr.zzag(zza.zzahh());
        } catch (Throwable th) {
            zzd.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (this.context instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacf.zzj(this.context) && !TextUtils.isEmpty(zze(zzdmu));
    }

    public final zzdyz<zzbyx> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        String zze = zze(zzdmu);
        return zzdyr.zzb(zzdyr.zzag(null), new zzcsl(this, zze != null ? Uri.parse(zze) : null, zzdnj, zzdmu), this.zzfqx);
    }
}
