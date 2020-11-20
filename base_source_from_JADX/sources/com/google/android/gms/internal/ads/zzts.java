package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzts {
    private final zztx zzbvs;
    @GuardedBy("this")
    private final zzue.zzi.zza zzbvt;
    private final boolean zzbvu;

    private zzts() {
        this.zzbvt = zzue.zzi.zzoe();
        this.zzbvu = false;
        this.zzbvs = new zztx();
    }

    public zzts(zztx zztx) {
        this.zzbvt = zzue.zzi.zzoe();
        this.zzbvs = zztx;
        this.zzbvu = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue();
    }

    private final synchronized void zzb(zztu.zza.C3718zza zza) {
        this.zzbvt.zzoh().zzb((Iterable<? extends Long>) zznf());
        this.zzbvs.zzf(((zzue.zzi) ((zzekh) this.zzbvt.zzbhv())).toByteArray()).zzbv(zza.zzv()).log();
        String valueOf = String.valueOf(Integer.toString(zza.zzv(), 10));
        zzd.zzee(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zztu.zza.C3718zza zza) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zza).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzd.zzee("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzd.zzee("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzd.zzee("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zzd.zzee("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zzd.zzee("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzd(zztu.zza.C3718zza zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzbvt.zzoa(), Long.valueOf(zzp.zzkx().elapsedRealtime()), Integer.valueOf(zza.zzv()), Base64.encodeToString(((zzue.zzi) ((zzekh) this.zzbvt.zzbhv())).toByteArray(), 3)});
    }

    public static zzts zzne() {
        return new zzts();
    }

    private static List<Long> zznf() {
        List<String> zzrm = zzabf.zzrm();
        ArrayList arrayList = new ArrayList();
        for (String split : zzrm) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zzd.zzee("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public final synchronized void zza(zztu.zza.C3718zza zza) {
        if (this.zzbvu) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcud)).booleanValue()) {
                zzc(zza);
            } else {
                zzb(zza);
            }
        }
    }

    public final synchronized void zza(zztv zztv) {
        if (this.zzbvu) {
            try {
                zztv.zza(this.zzbvt);
            } catch (NullPointerException e) {
                zzp.zzku().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }
}
