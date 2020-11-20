package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbtc;
import java.util.Iterator;

public final class zzcvy<AdT, AdapterT, ListenerT extends zzbtc> implements zzcqz<AdT> {
    private final zzcre<AdapterT, ListenerT> zzfoy;
    private final zzdro zzfvm;
    private final zzcrh<AdT, AdapterT, ListenerT> zzgub;
    private final zzdzc zzguc;

    public zzcvy(zzdro zzdro, zzdzc zzdzc, zzcre<AdapterT, ListenerT> zzcre, zzcrh<AdT, AdapterT, ListenerT> zzcrh) {
        this.zzfvm = zzdro;
        this.zzguc = zzdzc;
        this.zzgub = zzcrh;
        this.zzfoy = zzcre;
    }

    @VisibleForTesting
    static String zza(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb, Void voidR) {
        return this.zzgub.zzb(zzdnj, zzdmu, zzcrb);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return !zzdmu.zzhgy.isEmpty();
    }

    public final zzdyz<AdT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcrb<AdapterT, ListenerT> zzcrb;
        Iterator<String> it = zzdmu.zzhgy.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcrb = null;
                break;
            }
            try {
                zzcrb = this.zzfoy.zzf(it.next(), zzdmu.zzhha);
                break;
            } catch (zzdnr unused) {
            }
        }
        if (zzcrb == null) {
            return zzdyr.immediateFailedFuture(new zzcuc("unable to instantiate mediation adapter class"));
        }
        zzazq zzazq = new zzazq();
        zzcrb.zzgqp.zza(new zzcvz(this, zzcrb, zzazq));
        if (zzdmu.zzdxi) {
            Bundle bundle = zzdnj.zzhij.zzfvl.zzhio.zzchf;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfvm.zzu(zzdrl.ADAPTER_LOAD_AD_SYN).zza((zzdqy) new zzcvx(this, zzdnj, zzdmu, zzcrb), this.zzguc).zzw(zzdrl.ADAPTER_LOAD_AD_ACK).zze(zzazq).zzw(zzdrl.ADAPTER_WRAP_ADAPTER).zzb(new zzcwa(this, zzdnj, zzdmu, zzcrb)).zzaww();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        this.zzgub.zza(zzdnj, zzdmu, zzcrb);
    }
}
