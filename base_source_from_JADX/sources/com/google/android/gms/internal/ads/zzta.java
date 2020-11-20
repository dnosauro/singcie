package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzta extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzta> CREATOR = new zztd();
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", mo11699id = 2)
    private ParcelFileDescriptor zzbut;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "hasAdditionalMetadataFromReadV2", mo11699id = 3)
    private final boolean zzbuu;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isDownloaded", mo11699id = 4)
    private final boolean zzbuv;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getCachedBytes", mo11699id = 5)
    private final long zzbuw;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isGcacheHit", mo11699id = 6)
    private final boolean zzbux;

    public zzta() {
        this((ParcelFileDescriptor) null, false, false, 0, false);
    }

    @SafeParcelable.Constructor
    public zzta(@SafeParcelable.Param(mo11702id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo11702id = 3) boolean z, @SafeParcelable.Param(mo11702id = 4) boolean z2, @SafeParcelable.Param(mo11702id = 5) long j, @SafeParcelable.Param(mo11702id = 6) boolean z3) {
        this.zzbut = parcelFileDescriptor;
        this.zzbuu = z;
        this.zzbuv = z2;
        this.zzbuw = j;
        this.zzbux = z3;
    }

    private final synchronized ParcelFileDescriptor zzmx() {
        return this.zzbut;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzmx(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, zzmy());
        SafeParcelWriter.writeBoolean(parcel, 4, zzmz());
        SafeParcelWriter.writeLong(parcel, 5, zzna());
        SafeParcelWriter.writeBoolean(parcel, 6, zznb());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final synchronized boolean zzmv() {
        return this.zzbut != null;
    }

    public final synchronized InputStream zzmw() {
        if (this.zzbut == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbut);
        this.zzbut = null;
        return autoCloseInputStream;
    }

    public final synchronized boolean zzmy() {
        return this.zzbuu;
    }

    public final synchronized boolean zzmz() {
        return this.zzbuv;
    }

    public final synchronized long zzna() {
        return this.zzbuw;
    }

    public final synchronized boolean zznb() {
        return this.zzbux;
    }
}
