package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzyu extends zzgu implements zzys {
    zzyu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final float getAspectRatio() {
        Parcel zza = zza(9, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getCurrentTime() {
        Parcel zza = zza(7, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getDuration() {
        Parcel zza = zza(6, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int getPlaybackState() {
        Parcel zza = zza(5, zzdo());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isClickToExpandEnabled() {
        Parcel zza = zza(12, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isCustomControlsEnabled() {
        Parcel zza = zza(10, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isMuted() {
        Parcel zza = zza(4, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void mute(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(3, zzdo);
    }

    public final void pause() {
        zzb(2, zzdo());
    }

    public final void play() {
        zzb(1, zzdo());
    }

    public final void stop() {
        zzb(13, zzdo());
    }

    public final void zza(zzyt zzyt) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzyt);
        zzb(8, zzdo);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzyt zzqq() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 11
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzyt
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzyt r1 = (com.google.android.gms.internal.ads.zzyt) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzyv r2 = new com.google.android.gms.internal.ads.zzyv
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzqq():com.google.android.gms.internal.ads.zzyt");
    }
}
