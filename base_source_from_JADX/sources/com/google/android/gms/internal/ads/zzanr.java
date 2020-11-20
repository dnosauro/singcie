package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzanr extends zzgw implements zzano {
    public zzanr() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzano zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return queryLocalInterface instanceof zzano ? (zzano) queryLocalInterface : new zzanq(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x00dd;
                case 2: goto L_0x00d9;
                case 3: goto L_0x00d1;
                case 4: goto L_0x00cd;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00c5;
                case 7: goto L_0x00a5;
                case 8: goto L_0x00a1;
                case 9: goto L_0x0095;
                case 10: goto L_0x0085;
                case 11: goto L_0x0081;
                case 12: goto L_0x0079;
                case 13: goto L_0x0074;
                case 14: goto L_0x0067;
                case 15: goto L_0x0062;
                case 16: goto L_0x0055;
                case 17: goto L_0x004c;
                case 18: goto L_0x0047;
                case 19: goto L_0x003a;
                case 20: goto L_0x0035;
                case 21: goto L_0x002c;
                case 22: goto L_0x001f;
                case 23: goto L_0x0012;
                case 24: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzve> r1 = com.google.android.gms.internal.ads.zzve.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzve r1 = (com.google.android.gms.internal.ads.zzve) r1
            r0.zze(r1)
            goto L_0x00e0
        L_0x0012:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzve> r1 = com.google.android.gms.internal.ads.zzve.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzve r1 = (com.google.android.gms.internal.ads.zzve) r1
            r0.zzc(r1)
            goto L_0x00e0
        L_0x001f:
            int r1 = r2.readInt()
            java.lang.String r2 = r2.readString()
            r0.zzc(r1, r2)
            goto L_0x00e0
        L_0x002c:
            java.lang.String r1 = r2.readString()
            r0.zzdk(r1)
            goto L_0x00e0
        L_0x0035:
            r0.onVideoPlay()
            goto L_0x00e0
        L_0x003a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            r0.zzb((android.os.Bundle) r1)
            goto L_0x00e0
        L_0x0047:
            r0.zzuo()
            goto L_0x00e0
        L_0x004c:
            int r1 = r2.readInt()
            r0.zzdc(r1)
            goto L_0x00e0
        L_0x0055:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzavc r1 = com.google.android.gms.internal.ads.zzavf.zzaq(r1)
            r0.zza((com.google.android.gms.internal.ads.zzavc) r1)
            goto L_0x00e0
        L_0x0062:
            r0.onVideoPause()
            goto L_0x00e0
        L_0x0067:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzava> r1 = com.google.android.gms.internal.ads.zzava.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzava r1 = (com.google.android.gms.internal.ads.zzava) r1
            r0.zzb((com.google.android.gms.internal.ads.zzava) r1)
            goto L_0x00e0
        L_0x0074:
            r0.zzun()
            goto L_0x00e0
        L_0x0079:
            java.lang.String r1 = r2.readString()
            r0.zzdj(r1)
            goto L_0x00e0
        L_0x0081:
            r0.onVideoEnd()
            goto L_0x00e0
        L_0x0085:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaff r1 = com.google.android.gms.internal.ads.zzafe.zzr(r1)
            java.lang.String r2 = r2.readString()
            r0.zza(r1, r2)
            goto L_0x00e0
        L_0x0095:
            java.lang.String r1 = r2.readString()
            java.lang.String r2 = r2.readString()
            r0.onAppEvent(r1, r2)
            goto L_0x00e0
        L_0x00a1:
            r0.onAdImpression()
            goto L_0x00e0
        L_0x00a5:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00ad
            r1 = 0
            goto L_0x00c1
        L_0x00ad:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzant
            if (r4 == 0) goto L_0x00bb
            r1 = r2
            com.google.android.gms.internal.ads.zzant r1 = (com.google.android.gms.internal.ads.zzant) r1
            goto L_0x00c1
        L_0x00bb:
            com.google.android.gms.internal.ads.zzans r2 = new com.google.android.gms.internal.ads.zzans
            r2.<init>(r1)
            r1 = r2
        L_0x00c1:
            r0.zza((com.google.android.gms.internal.ads.zzant) r1)
            goto L_0x00e0
        L_0x00c5:
            r0.onAdLoaded()
            goto L_0x00e0
        L_0x00c9:
            r0.onAdOpened()
            goto L_0x00e0
        L_0x00cd:
            r0.onAdLeftApplication()
            goto L_0x00e0
        L_0x00d1:
            int r1 = r2.readInt()
            r0.onAdFailedToLoad(r1)
            goto L_0x00e0
        L_0x00d9:
            r0.onAdClosed()
            goto L_0x00e0
        L_0x00dd:
            r0.onAdClicked()
        L_0x00e0:
            r3.writeNoException()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanr.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
