package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzb();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getTimeMillis", mo11699id = 2)
    private final long zzb;
    @SafeParcelable.Field(getter = "getEventType", mo11699id = 11)
    private int zzc;
    @SafeParcelable.Field(getter = "getWakeLockName", mo11699id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", mo11699id = 10)
    private final String zze;
    @SafeParcelable.Field(getter = "getCodePackage", mo11699id = 17)
    private final String zzf;
    @SafeParcelable.Field(getter = "getWakeLockType", mo11699id = 5)
    private final int zzg;
    @SafeParcelable.Field(getter = "getCallingPackages", mo11699id = 6)
    private final List<String> zzh;
    @SafeParcelable.Field(getter = "getEventKey", mo11699id = 12)
    private final String zzi;
    @SafeParcelable.Field(getter = "getElapsedRealtime", mo11699id = 8)
    private final long zzj;
    @SafeParcelable.Field(getter = "getDeviceState", mo11699id = 14)
    private int zzk;
    @SafeParcelable.Field(getter = "getHostPackage", mo11699id = 13)
    private final String zzl;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", mo11699id = 15)
    private final float zzm;
    @SafeParcelable.Field(getter = "getTimeout", mo11699id = 16)
    private final long zzn;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", mo11699id = 18)
    private final boolean zzo;
    private long zzp;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) long j, @SafeParcelable.Param(mo11702id = 11) int i2, @SafeParcelable.Param(mo11702id = 4) String str, @SafeParcelable.Param(mo11702id = 5) int i3, @SafeParcelable.Param(mo11702id = 6) List<String> list, @SafeParcelable.Param(mo11702id = 12) String str2, @SafeParcelable.Param(mo11702id = 8) long j2, @SafeParcelable.Param(mo11702id = 14) int i4, @SafeParcelable.Param(mo11702id = 10) String str3, @SafeParcelable.Param(mo11702id = 13) String str4, @SafeParcelable.Param(mo11702id = 15) float f, @SafeParcelable.Param(mo11702id = 16) long j3, @SafeParcelable.Param(mo11702id = 17) String str5, @SafeParcelable.Param(mo11702id = 18) boolean z) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i3;
        this.zzp = -1;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i4;
        this.zzl = str4;
        this.zzm = f;
        this.zzn = j3;
        this.zzo = z;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5, z);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, zza());
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, zzb());
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzp;
    }

    public final String zzd() {
        String str = this.zzd;
        int i = this.zzg;
        List<String> list = this.zzh;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.zzk;
        String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.zzm;
        String str4 = this.zzf;
        if (str4 == null) {
            str4 = "";
        }
        boolean z = this.zzo;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
