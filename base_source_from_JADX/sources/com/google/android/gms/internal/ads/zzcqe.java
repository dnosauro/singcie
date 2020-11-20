package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

public final class zzcqe {
    private static final SparseArray<zzue.zzo.zzc> zzgps;
    private final Context context;
    private final zzbqz zzfvs;
    private final zzcpx zzgmu;
    private final TelephonyManager zzgpp;
    /* access modifiers changed from: private */
    public final zzcpr zzgpq;
    private zzuo zzgpr;

    static {
        SparseArray<zzue.zzo.zzc> sparseArray = new SparseArray<>();
        zzgps = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzue.zzo.zzc.CONNECTED);
        zzgps.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzue.zzo.zzc.CONNECTING);
        zzgps.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzue.zzo.zzc.CONNECTING);
        zzgps.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzue.zzo.zzc.CONNECTING);
        zzgps.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzue.zzo.zzc.DISCONNECTING);
        zzgps.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        zzgps.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        zzgps.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        zzgps.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        zzgps.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        zzgps.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzue.zzo.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzgps.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzue.zzo.zzc.CONNECTING);
        }
        zzgps.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzue.zzo.zzc.CONNECTING);
    }

    zzcqe(Context context2, zzbqz zzbqz, zzcpx zzcpx, zzcpr zzcpr) {
        this.context = context2;
        this.zzfvs = zzbqz;
        this.zzgmu = zzcpx;
        this.zzgpq = zzcpr;
        this.zzgpp = (TelephonyManager) context2.getSystemService("phone");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzue.zzc.zza> arrayList, zzue.zzm zzm, zzue.zzo.zzc zzc) {
        boolean z2 = true;
        zzue.zzo.zza.C3722zza zzeu = zzue.zzo.zza.zzoq().zzf((Iterable<? extends zzue.zzc.zza>) arrayList).zzh(zzbk(zzp.zzks().zzb(this.context.getContentResolver()) != 0)).zzi(zzp.zzks().zza(this.context, this.zzgpp)).zzev(this.zzgmu.zzard()).zzew(this.zzgmu.zzarf()).zzcl(this.zzgmu.getResponseCode()).zzb(zzc).zzb(zzm).zzj(this.zzgpr).zzf(zzbk(z)).zzeu(zzp.zzkx().currentTimeMillis());
        if (zzp.zzks().zza(this.context.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zzue.zzo.zza) ((zzekh) zzeu.zzg(zzbk(z2)).zzbhv())).toByteArray();
    }

    private static zzuo zzbk(boolean z) {
        return z ? zzuo.ENUM_TRUE : zzuo.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zzue.zzm zzj(Bundle bundle) {
        zzue.zzm.zzc zzc;
        zzue.zzm.zza zza;
        zzue.zzm.zzb zzok = zzue.zzm.zzok();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgpr = zzuo.ENUM_TRUE;
        } else {
            this.zzgpr = zzuo.ENUM_FALSE;
            switch (i) {
                case 0:
                    zzc = zzue.zzm.zzc.CELL;
                    break;
                case 1:
                    zzc = zzue.zzm.zzc.WIFI;
                    break;
                default:
                    zzc = zzue.zzm.zzc.NETWORKTYPE_UNSPECIFIED;
                    break;
            }
            zzok.zzb(zzc);
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zza = zzue.zzm.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zza = zzue.zzm.zza.THREE_G;
                    break;
                case 13:
                    zza = zzue.zzm.zza.LTE;
                    break;
                default:
                    zza = zzue.zzm.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzok.zzb(zza);
        }
        return (zzue.zzm) ((zzekh) zzok.zzbhv());
    }

    /* access modifiers changed from: private */
    public static zzue.zzo.zzc zzk(Bundle bundle) {
        return zzgps.get(zzdnx.zza(zzdnx.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzue.zzo.zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzue.zzc.zza> zzl(android.os.Bundle r5) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r5 = r5.get(r0)
            boolean r0 = r5 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r5 = (java.util.List) r5
            goto L_0x0017
        L_0x000d:
            boolean r0 = r5 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.util.List r5 = java.util.Arrays.asList(r5)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L_0x0024:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r5.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r5 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r5 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x004a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x00ac
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            if (r3 == r4) goto L_0x008e
            r4 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r3 == r4) goto L_0x0084
            r4 = -239580146(0xfffffffff1b84c0e, float:-1.82519E30)
            if (r3 == r4) goto L_0x007a
            r4 = 604727084(0x240b672c, float:3.022821E-17)
            if (r3 == r4) goto L_0x0070
            goto L_0x0097
        L_0x0070:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 1
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 3
            goto L_0x0097
        L_0x0084:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 2
            goto L_0x0097
        L_0x008e:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 0
        L_0x0097:
            switch(r2) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x00a3;
                case 2: goto L_0x00a0;
                case 3: goto L_0x009d;
                default: goto L_0x009a;
            }
        L_0x009a:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x00a8
        L_0x009d:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L_0x00a8
        L_0x00a0:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.NATIVE_APP_INSTALL
            goto L_0x00a8
        L_0x00a3:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.INTERSTITIAL
            goto L_0x00a8
        L_0x00a6:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.BANNER
        L_0x00a8:
            r0.add(r1)
            goto L_0x004a
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqe.zzl(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbj(boolean z) {
        zzdyr.zza(this.zzfvs.zzakq(), new zzcqd(this, z), zzazj.zzegu);
    }
}
