package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzcf;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzdtt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtt> CREATOR = new zzdtw();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", mo11699id = 2, type = "byte[]")
    private zzcf.zza zzhrg = null;
    private byte[] zzhrh;

    @SafeParcelable.Constructor
    zzdtt(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzhrh = bArr;
        zzaxs();
    }

    private final void zzaxs() {
        if (this.zzhrg == null && this.zzhrh != null) {
            return;
        }
        if (this.zzhrg != null && this.zzhrh == null) {
            return;
        }
        if (this.zzhrg != null && this.zzhrh != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzhrg == null && this.zzhrh == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] bArr = this.zzhrh;
        if (bArr == null) {
            bArr = this.zzhrg.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzcf.zza zzaxr() {
        if (!(this.zzhrg != null)) {
            try {
                this.zzhrg = zzcf.zza.zza(this.zzhrh, zzeju.zzbhf());
                this.zzhrh = null;
            } catch (zzeks e) {
                throw new IllegalStateException(e);
            }
        }
        zzaxs();
        return this.zzhrg;
    }
}
