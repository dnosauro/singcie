package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhv;
import java.util.ArrayList;
import java.util.List;

final class zzt {
    private zzcd.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzo zzd;

    private zzt(zzo zzo) {
        this.zzd = zzo;
    }

    /* access modifiers changed from: package-private */
    public final zzcd.zzc zza(String str, zzcd.zzc zzc2) {
        zzez zzf;
        String str2;
        String zzc3 = zzc2.zzc();
        List<zzcd.zze> zza2 = zzc2.zza();
        Long l = (Long) this.zzd.mo18590f_().zzb(zzc2, "_eid");
        boolean z = l != null;
        if (z && zzc3.equals("_ep")) {
            zzc3 = (String) this.zzd.mo18590f_().zzb(zzc2, "_en");
            if (TextUtils.isEmpty(zzc3)) {
                this.zzd.zzq().zzf().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzcd.zzc, Long> zza3 = this.zzd.zzi().zza(str, l);
                if (zza3 == null || zza3.first == null) {
                    this.zzd.zzq().zzf().zza("Extra parameter without existing main event. eventName, eventId", zzc3, l);
                    return null;
                }
                this.zza = (zzcd.zzc) zza3.first;
                this.zzc = ((Long) zza3.second).longValue();
                this.zzb = (Long) this.zzd.mo18590f_().zzb(this.zza, "_eid");
            }
            this.zzc--;
            if (this.zzc <= 0) {
                zzac zzi = this.zzd.zzi();
                zzi.zzc();
                zzi.zzq().zzw().zza("Clearing complex main event info. appId", str);
                try {
                    zzi.mo18354c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzi.zzq().zze().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzcd.zze next : this.zza.zza()) {
                this.zzd.mo18590f_();
                if (zzkt.zza(zzc2, next.zzb()) == null) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zza2);
                zza2 = arrayList;
                return (zzcd.zzc) ((zzhv) ((zzcd.zzc.zza) zzc2.zzbo()).zza(zzc3).zzc().zza((Iterable<? extends zzcd.zze>) zza2).zzy());
            }
            zzf = this.zzd.zzq().zzf();
            str2 = "No unique parameters in main event. eventName";
        } else {
            if (z) {
                this.zzb = l;
                this.zza = zzc2;
                Object zzb2 = this.zzd.mo18590f_().zzb(zzc2, "_epc");
                if (zzb2 == null) {
                    zzb2 = 0L;
                }
                this.zzc = ((Long) zzb2).longValue();
                if (this.zzc <= 0) {
                    zzf = this.zzd.zzq().zzf();
                    str2 = "Complex event with zero extra param count. eventName";
                } else {
                    this.zzd.zzi().zza(str, l, this.zzc, zzc2);
                }
            }
            return (zzcd.zzc) ((zzhv) ((zzcd.zzc.zza) zzc2.zzbo()).zza(zzc3).zzc().zza((Iterable<? extends zzcd.zze>) zza2).zzy());
        }
        zzf.zza(str2, zzc3);
        return (zzcd.zzc) ((zzhv) ((zzcd.zzc.zza) zzc2.zzbo()).zza(zzc3).zzc().zza((Iterable<? extends zzcd.zze>) zza2).zzy());
    }
}
