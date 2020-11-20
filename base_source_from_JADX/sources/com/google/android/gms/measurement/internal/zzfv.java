package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.p018c.C0400a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzlj;
import com.google.android.gms.internal.measurement.zzmh;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzfv extends zzkm implements zzaa {
    @VisibleForTesting
    private static int zzb = 65535;
    @VisibleForTesting
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd = new C0400a();
    private final Map<String, Map<String, Boolean>> zze = new C0400a();
    private final Map<String, Map<String, Boolean>> zzf = new C0400a();
    private final Map<String, zzca.zzb> zzg = new C0400a();
    private final Map<String, Map<String, Integer>> zzh = new C0400a();
    private final Map<String, String> zzi = new C0400a();

    zzfv(zzkp zzkp) {
        super(zzkp);
    }

    private final zzca.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzca.zzb.zzj();
        }
        try {
            zzca.zzb zzb2 = (zzca.zzb) ((zzhv) ((zzca.zzb.zza) zzkt.zza(zzca.zzb.zzi(), bArr)).zzy());
            zzez zzw = zzq().zzw();
            String str2 = null;
            Long valueOf = zzb2.zza() ? Long.valueOf(zzb2.zzb()) : null;
            if (zzb2.zzc()) {
                str2 = zzb2.zzd();
            }
            zzw.zza("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzb2;
        } catch (zzig | RuntimeException e) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzex.zza(str), e);
            return zzca.zzb.zzj();
        }
    }

    private static Map<String, String> zza(zzca.zzb zzb2) {
        C0400a aVar = new C0400a();
        if (zzb2 != null) {
            for (zzca.zzc next : zzb2.zze()) {
                aVar.put(next.zza(), next.zzb());
            }
        }
        return aVar;
    }

    private final void zza(String str, zzca.zzb.zza zza) {
        C0400a aVar = new C0400a();
        C0400a aVar2 = new C0400a();
        C0400a aVar3 = new C0400a();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzca.zza.C3724zza zza2 = (zzca.zza.C3724zza) zza.zza(i).zzbo();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzq().zzh().zza("EventConfig contained null event name");
                } else {
                    String zza3 = zza2.zza();
                    String zzb2 = zzgy.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zza2 = zza2.zza(zzb2);
                        zza.zza(i, zza2);
                    }
                    if (!zzlj.zzb() || !zzs().zza(zzat.zzct)) {
                        zza3 = zza2.zza();
                    }
                    aVar.put(zza3, Boolean.valueOf(zza2.zzb()));
                    aVar2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < zzc || zza2.zze() > zzb) {
                            zzq().zzh().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            aVar3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, aVar);
        this.zzf.put(str, aVar2);
        this.zzh.put(str, aVar3);
    }

    private final void zzi(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd2 = zzi().zzd(str);
            if (zzd2 == null) {
                this.zzd.put(str, (Object) null);
                this.zze.put(str, (Object) null);
                this.zzf.put(str, (Object) null);
                this.zzg.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                this.zzh.put(str, (Object) null);
                return;
            }
            zzca.zzb.zza zza = (zzca.zzb.zza) zza(str, zzd2).zzbo();
            zza(str, zza);
            this.zzd.put(str, zza((zzca.zzb) ((zzhv) zza.zzy())));
            this.zzg.put(str, (zzca.zzb) ((zzhv) zza.zzy()));
            this.zzi.put(str, (Object) null);
        }
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzkt mo18590f_() {
        return super.mo18590f_();
    }

    /* access modifiers changed from: protected */
    public final zzca.zzb zza(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    public final String zza(String str, String str2) {
        zzc();
        zzi(str);
        Map map = this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzca.zzb.zza zza = (zzca.zzb.zza) zza(str, bArr).zzbo();
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzg.put(str, (zzca.zzb) ((zzhv) zza.zzy()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzca.zzb) ((zzhv) zza.zzy())));
        zzi().zza(str, (List<zzbv.zza>) new ArrayList(zza.zzb()));
        try {
            zza.zzc();
            bArr = ((zzca.zzb) ((zzhv) zza.zzy())).zzbk();
        } catch (RuntimeException e) {
            zzq().zzh().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzex.zza(str), e);
        }
        zzac zzi2 = zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzc();
        zzi2.zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi2.mo18354c_().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi2.zzq().zze().zza("Failed to update remote config (got 0). appId", zzex.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi2.zzq().zze().zza("Error storing remote config. appId", zzex.zza(str), e2);
        }
        this.zzg.put(str, (zzca.zzb) ((zzhv) zza.zzy()));
        return true;
    }

    /* access modifiers changed from: protected */
    public final String zzb(String str) {
        zzc();
        return this.zzi.get(str);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        Boolean bool;
        zzc();
        zzi(str);
        if (zzg(str) && zzkx.zzd(str2)) {
            return true;
        }
        if (zzh(str) && zzkx.zza(str2)) {
            return true;
        }
        Map map = this.zze.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str) {
        zzc();
        this.zzi.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzc();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        if (zzmh.zzb() && zzs().zza(zzat.zzcc) && (FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2))) {
            return true;
        }
        Map map = this.zzf.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final int zzd(String str, String str2) {
        Integer num;
        zzc();
        zzi(str);
        Map map = this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzc();
        this.zzg.remove(str);
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(String str) {
        zzc();
        zzca.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    /* access modifiers changed from: package-private */
    public final long zzf(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzq().zzh().zza("Unable to parse timezone offset. appId", zzex.zza(str), e);
            return 0;
        }
    }

    public final /* bridge */ /* synthetic */ zzjv zzf() {
        return super.zzf();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    public final /* bridge */ /* synthetic */ zzo zzh() {
        return super.zzh();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfv zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}
