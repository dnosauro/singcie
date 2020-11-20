package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
@ParametersAreNonnullByDefault
public final class zzdpk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdpk> CREATOR = new zzdpo();
    @Nullable
    public final Context context;
    private final zzdpj[] zzhli;
    private final int[] zzhlj;
    private final int[] zzhlk;
    @SafeParcelable.Field(getter = "getFormatInt", mo11699id = 1)
    private final int zzhll;
    public final zzdpj zzhlm;
    @SafeParcelable.Field(mo11699id = 2)
    public final int zzhln;
    @SafeParcelable.Field(mo11699id = 3)
    public final int zzhlo;
    @SafeParcelable.Field(mo11699id = 4)
    public final int zzhlp;
    @SafeParcelable.Field(mo11699id = 5)
    public final String zzhlq;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", mo11699id = 6)
    private final int zzhlr;
    public final int zzhls;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", mo11699id = 7)
    private final int zzhlt;
    private final int zzhlu;

    @SafeParcelable.Constructor
    public zzdpk(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) int i2, @SafeParcelable.Param(mo11702id = 3) int i3, @SafeParcelable.Param(mo11702id = 4) int i4, @SafeParcelable.Param(mo11702id = 5) String str, @SafeParcelable.Param(mo11702id = 6) int i5, @SafeParcelable.Param(mo11702id = 7) int i6) {
        this.zzhli = zzdpj.values();
        this.zzhlj = zzdpm.zzavt();
        this.zzhlk = zzdpl.zzavs();
        this.context = null;
        this.zzhll = i;
        this.zzhlm = this.zzhli[i];
        this.zzhln = i2;
        this.zzhlo = i3;
        this.zzhlp = i4;
        this.zzhlq = str;
        this.zzhlr = i5;
        this.zzhls = this.zzhlj[i5];
        this.zzhlt = i6;
        this.zzhlu = this.zzhlk[i6];
    }

    private zzdpk(@Nullable Context context2, zzdpj zzdpj, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzhli = zzdpj.values();
        this.zzhlj = zzdpm.zzavt();
        this.zzhlk = zzdpl.zzavs();
        this.context = context2;
        this.zzhll = zzdpj.ordinal();
        this.zzhlm = zzdpj;
        this.zzhln = i;
        this.zzhlo = i2;
        this.zzhlp = i3;
        this.zzhlq = str;
        this.zzhls = "oldest".equals(str2) ? zzdpm.zzhlx : ("lru".equals(str2) || !"lfu".equals(str2)) ? zzdpm.zzhly : zzdpm.zzhlz;
        this.zzhlr = this.zzhls - 1;
        "onAdClosed".equals(str3);
        this.zzhlu = zzdpl.zzhlv;
        this.zzhlt = this.zzhlu - 1;
    }

    public static zzdpk zza(zzdpj zzdpj, Context context2) {
        if (zzdpj == zzdpj.Rewarded) {
            return new zzdpk(context2, zzdpj, ((Integer) zzwq.zzqe().zzd(zzabf.zzcxb)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxh)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxj)).intValue(), (String) zzwq.zzqe().zzd(zzabf.zzcxl), (String) zzwq.zzqe().zzd(zzabf.zzcxd), (String) zzwq.zzqe().zzd(zzabf.zzcxf));
        } else if (zzdpj == zzdpj.Interstitial) {
            return new zzdpk(context2, zzdpj, ((Integer) zzwq.zzqe().zzd(zzabf.zzcxc)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxi)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxk)).intValue(), (String) zzwq.zzqe().zzd(zzabf.zzcxm), (String) zzwq.zzqe().zzd(zzabf.zzcxe), (String) zzwq.zzqe().zzd(zzabf.zzcxg));
        } else if (zzdpj != zzdpj.AppOpen) {
            return null;
        } else {
            return new zzdpk(context2, zzdpj, ((Integer) zzwq.zzqe().zzd(zzabf.zzcxp)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxr)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxs)).intValue(), (String) zzwq.zzqe().zzd(zzabf.zzcxn), (String) zzwq.zzqe().zzd(zzabf.zzcxo), (String) zzwq.zzqe().zzd(zzabf.zzcxq));
        }
    }

    public static boolean zzavr() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcxa)).booleanValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzhll);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhln);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhlo);
        SafeParcelWriter.writeInt(parcel, 4, this.zzhlp);
        SafeParcelWriter.writeString(parcel, 5, this.zzhlq, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhlr);
        SafeParcelWriter.writeInt(parcel, 7, this.zzhlt);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
