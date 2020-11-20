package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzdfp implements zzdfj<Bundle> {
    private final boolean zzdwe;
    private final boolean zzdwf;
    private final String zzdwh;
    private final boolean zzdwi;
    private final boolean zzdwj;
    private final boolean zzdwk;
    private final String zzdwn;
    private final String zzdwo;
    private final String zzdwp;
    private final boolean zzdxc;
    private final ArrayList<String> zzhbq;
    private final String zzhbr;
    private final String zzhbs;
    private final long zzhbt;

    public zzdfp(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.zzdwe = z;
        this.zzdwf = z2;
        this.zzdwh = str;
        this.zzdwi = z3;
        this.zzdwj = z4;
        this.zzdwk = z5;
        this.zzdwn = str2;
        this.zzhbq = arrayList;
        this.zzdwo = str3;
        this.zzdwp = str4;
        this.zzhbr = str5;
        this.zzdxc = z6;
        this.zzhbs = str6;
        this.zzhbt = j;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zzdwe);
        bundle.putBoolean("coh", this.zzdwf);
        bundle.putString("gl", this.zzdwh);
        bundle.putBoolean("simulator", this.zzdwi);
        bundle.putBoolean("is_latchsky", this.zzdwj);
        bundle.putBoolean("is_sidewinder", this.zzdwk);
        bundle.putString("hl", this.zzdwn);
        if (!this.zzhbq.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzhbq);
        }
        bundle.putString("mv", this.zzdwo);
        bundle.putString("submodel", this.zzhbs);
        Bundle zza = zzdnx.zza(bundle, "device");
        bundle.putBundle("device", zza);
        zza.putString("build", this.zzhbr);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrr)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.zzhbt);
        }
        Bundle zza2 = zzdnx.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdxc);
        if (!TextUtils.isEmpty(this.zzdwp)) {
            Bundle zza3 = zzdnx.zza(zza, "play_store");
            zza.putBundle("play_store", zza3);
            zza3.putString("package_version", this.zzdwp);
        }
    }
}
