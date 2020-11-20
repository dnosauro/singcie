package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.p018c.C0400a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzlj;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zznq;
import com.google.android.gms.internal.measurement.zznr;
import com.parse.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzkp implements zzgw {
    private static volatile zzkp zza;
    private zzfv zzb;
    private zzfa zzc;
    private zzac zzd;
    private zzfh zze;
    private zzkl zzf;
    private zzo zzg;
    private final zzkt zzh;
    private zzil zzi;
    private zzjv zzj;
    private final zzgb zzk;
    private boolean zzl;
    private boolean zzm;
    @VisibleForTesting
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;
    private final Map<String, zzad> zzz;

    class zza implements zzae {
        zzcd.zzg zza;
        List<Long> zzb;
        List<zzcd.zzc> zzc;
        private long zzd;

        private zza() {
        }

        /* synthetic */ zza(zzkp zzkp, zzko zzko) {
            this();
        }

        private static long zza(zzcd.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        public final void zza(zzcd.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzcd.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbp = this.zzd + ((long) zzc2.zzbp());
            if (zzbp >= ((long) Math.max(0, zzat.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbp;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            return this.zzc.size() < Math.max(1, zzat.zzi.zza(null).intValue());
        }
    }

    private zzkp(zzku zzku) {
        this(zzku, (zzgb) null);
    }

    private zzkp(zzku zzku, zzgb zzgb) {
        this.zzl = false;
        Preconditions.checkNotNull(zzku);
        this.zzk = zzgb.zza(zzku.zza, (zzae) null, (Long) null);
        this.zzy = -1;
        zzkt zzkt = new zzkt(this);
        zzkt.zzak();
        this.zzh = zzkt;
        zzfa zzfa = new zzfa(this);
        zzfa.zzak();
        this.zzc = zzfa;
        zzfv zzfv = new zzfv(this);
        zzfv.zzak();
        this.zzb = zzfv;
        this.zzz = new HashMap();
        this.zzk.zzp().zza((Runnable) new zzko(this, zzku));
    }

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzk.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to read from channel", e);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if (r0.zzc() != false) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzad r0 = com.google.android.gms.measurement.internal.zzad.zza
            boolean r1 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.measurement.internal.zzgb r1 = r8.zzk
            com.google.android.gms.measurement.internal.zzy r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r1 == 0) goto L_0x0026
            java.lang.String r0 = r9.zza
            com.google.android.gms.measurement.internal.zzad r0 = r8.zza((java.lang.String) r0)
            java.lang.String r1 = r9.zzw
            com.google.android.gms.measurement.internal.zzad r1 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r1)
            com.google.android.gms.measurement.internal.zzad r0 = r0.zzb((com.google.android.gms.measurement.internal.zzad) r1)
        L_0x0026:
            r1 = 1
            if (r10 != 0) goto L_0x0066
            com.google.android.gms.measurement.internal.zzf r10 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzgb r2 = r8.zzk
            java.lang.String r3 = r9.zza
            r10.<init>(r2, r3)
            boolean r2 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r2 == 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgb r2 = r8.zzk
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x005a
            boolean r2 = r0.zze()
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r8.zza((com.google.android.gms.measurement.internal.zzad) r0)
            r10.zza((java.lang.String) r2)
        L_0x0053:
            boolean r0 = r0.zzc()
            if (r0 == 0) goto L_0x0064
            goto L_0x0061
        L_0x005a:
            java.lang.String r0 = r8.zzz()
            r10.zza((java.lang.String) r0)
        L_0x0061:
            r10.zze((java.lang.String) r11)
        L_0x0064:
            r11 = 1
            goto L_0x00b5
        L_0x0066:
            boolean r2 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r2 == 0) goto L_0x0080
            com.google.android.gms.measurement.internal.zzgb r2 = r8.zzk
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0080
            boolean r2 = r0.zzc()
            if (r2 == 0) goto L_0x00b4
        L_0x0080:
            java.lang.String r2 = r10.zzh()
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x00b4
            r10.zze((java.lang.String) r11)
            boolean r11 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r11 == 0) goto L_0x00ac
            com.google.android.gms.measurement.internal.zzgb r11 = r8.zzk
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r11 == 0) goto L_0x00ac
            boolean r11 = r0.zze()
            if (r11 == 0) goto L_0x0064
            java.lang.String r11 = r8.zza((com.google.android.gms.measurement.internal.zzad) r0)
            goto L_0x00b0
        L_0x00ac:
            java.lang.String r11 = r8.zzz()
        L_0x00b0:
            r10.zza((java.lang.String) r11)
            goto L_0x0064
        L_0x00b4:
            r11 = 0
        L_0x00b5:
            java.lang.String r0 = r9.zzb
            java.lang.String r2 = r10.zze()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x00c7
            java.lang.String r11 = r9.zzb
            r10.zzb((java.lang.String) r11)
            r11 = 1
        L_0x00c7:
            java.lang.String r0 = r9.zzr
            java.lang.String r2 = r10.zzf()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x00d9
            java.lang.String r11 = r9.zzr
            r10.zzc((java.lang.String) r11)
            r11 = 1
        L_0x00d9:
            boolean r0 = com.google.android.gms.internal.measurement.zznq.zzb()
            if (r0 == 0) goto L_0x0103
            com.google.android.gms.measurement.internal.zzgb r0 = r8.zzk
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()
            java.lang.String r2 = r10.zzc()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbj
            boolean r0 = r0.zze(r2, r3)
            if (r0 == 0) goto L_0x0103
            java.lang.String r0 = r9.zzv
            java.lang.String r2 = r10.zzg()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x0103
            java.lang.String r11 = r9.zzv
            r10.zzd((java.lang.String) r11)
            r11 = 1
        L_0x0103:
            java.lang.String r0 = r9.zzk
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x011d
            java.lang.String r0 = r9.zzk
            java.lang.String r2 = r10.zzi()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x011d
            java.lang.String r11 = r9.zzk
            r10.zzf((java.lang.String) r11)
            r11 = 1
        L_0x011d:
            long r2 = r9.zze
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0135
            long r2 = r9.zze
            long r6 = r10.zzo()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0135
            long r2 = r9.zze
            r10.zzd((long) r2)
            r11 = 1
        L_0x0135:
            java.lang.String r0 = r9.zzc
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = r9.zzc
            java.lang.String r2 = r10.zzl()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x014f
            java.lang.String r11 = r9.zzc
            r10.zzg((java.lang.String) r11)
            r11 = 1
        L_0x014f:
            long r2 = r9.zzj
            long r6 = r10.zzm()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x015f
            long r2 = r9.zzj
            r10.zzc((long) r2)
            r11 = 1
        L_0x015f:
            java.lang.String r0 = r9.zzd
            if (r0 == 0) goto L_0x0175
            java.lang.String r0 = r9.zzd
            java.lang.String r2 = r10.zzn()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0175
            java.lang.String r11 = r9.zzd
            r10.zzh((java.lang.String) r11)
            r11 = 1
        L_0x0175:
            long r2 = r9.zzf
            long r6 = r10.zzp()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0185
            long r2 = r9.zzf
            r10.zze((long) r2)
            r11 = 1
        L_0x0185:
            boolean r0 = r9.zzh
            boolean r2 = r10.zzr()
            if (r0 == r2) goto L_0x0193
            boolean r11 = r9.zzh
            r10.zza((boolean) r11)
            r11 = 1
        L_0x0193:
            java.lang.String r0 = r9.zzg
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ad
            java.lang.String r0 = r9.zzg
            java.lang.String r2 = r10.zzac()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01ad
            java.lang.String r11 = r9.zzg
            r10.zzi((java.lang.String) r11)
            r11 = 1
        L_0x01ad:
            com.google.android.gms.measurement.internal.zzgb r0 = r8.zzk
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzcf
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r0 != 0) goto L_0x01cb
            long r2 = r9.zzl
            long r6 = r10.zzae()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01cb
            long r2 = r9.zzl
            r10.zzp(r2)
            r11 = 1
        L_0x01cb:
            boolean r0 = r9.zzo
            boolean r2 = r10.zzaf()
            if (r0 == r2) goto L_0x01d9
            boolean r11 = r9.zzo
            r10.zzb((boolean) r11)
            r11 = 1
        L_0x01d9:
            boolean r0 = r9.zzp
            boolean r2 = r10.zzag()
            if (r0 == r2) goto L_0x01e7
            boolean r11 = r9.zzp
            r10.zzc((boolean) r11)
            r11 = 1
        L_0x01e7:
            java.lang.Boolean r0 = r9.zzs
            java.lang.Boolean r2 = r10.zzah()
            if (r0 == r2) goto L_0x01f5
            java.lang.Boolean r11 = r9.zzs
            r10.zza((java.lang.Boolean) r11)
            r11 = 1
        L_0x01f5:
            long r2 = r9.zzt
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x020b
            long r2 = r9.zzt
            long r4 = r10.zzq()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x020b
            long r2 = r9.zzt
            r10.zzf((long) r2)
            r11 = 1
        L_0x020b:
            if (r11 == 0) goto L_0x0214
            com.google.android.gms.measurement.internal.zzac r9 = r8.zze()
            r9.zza((com.google.android.gms.measurement.internal.zzf) r10)
        L_0x0214:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public static zzkp zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkp.class) {
                if (zza == null) {
                    zza = new zzkp(new zzku(context));
                }
            }
        }
        return zza;
    }

    private final String zza(zzad zzad) {
        if (!zzmb.zzb() || !this.zzk.zza().zza(zzat.zzcp) || zzad.zze()) {
            return zzz();
        }
        return null;
    }

    @VisibleForTesting
    private static void zza(zzcd.zzc.zza zza2, int i, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzcd.zze) ((zzhv) zzcd.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzy())).zza((zzcd.zze) ((zzhv) zzcd.zze.zzm().zza("_ev").zzb(str).zzy()));
    }

    @VisibleForTesting
    private static void zza(zzcd.zzc.zza zza2, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private final void zza(zzcd.zzg.zza zza2, long j, boolean z) {
        zzky zzky;
        String str = "_lte";
        if (z) {
            str = "_se";
        }
        zzky zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzky = new zzky(zza2.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzky = new zzky(zza2.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzcd.zzk zzk2 = (zzcd.zzk) ((zzhv) zzcd.zzk.zzj().zza(str).zza(this.zzk.zzl().currentTimeMillis()).zzb(((Long) zzky.zze).longValue()).zzy());
        boolean z2 = false;
        int zza3 = zzkt.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzky);
            String str2 = "lifetime";
            if (z) {
                str2 = "session-scoped";
            }
            this.zzk.zzq().zzw().zza("Updated engagement user property. scope, value", str2, zzky.zze);
        }
    }

    private final void zza(zzf zzf2) {
        C0400a aVar;
        zzx();
        if (!zznq.zzb() || !this.zzk.zza().zze(zzf2.zzc(), zzat.zzbj)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), ParseException.EMAIL_MISSING, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), ParseException.EMAIL_MISSING, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzk.zza().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzk.zzq().zzw().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                aVar = null;
            } else {
                C0400a aVar2 = new C0400a();
                aVar2.put("If-Modified-Since", zzb2);
                aVar = aVar2;
            }
            this.zzr = true;
            zzfa zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkq zzkq = new zzkq(this);
            zzd2.zzc();
            zzd2.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkq);
            zzd2.zzp().zzc((Runnable) new zzfe(zzd2, zzc2, url, (byte[]) null, aVar, zzkq));
        } catch (MalformedURLException unused) {
            this.zzk.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzex.zza(zzf2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzku zzku) {
        this.zzk.zzp().zzc();
        zzac zzac = new zzac(this);
        zzac.zzak();
        this.zzd = zzac;
        this.zzk.zza().zza((zzaa) this.zzb);
        zzjv zzjv = new zzjv(this);
        zzjv.zzak();
        this.zzj = zzjv;
        zzo zzo2 = new zzo(this);
        zzo2.zzak();
        this.zzg = zzo2;
        zzil zzil = new zzil(this);
        zzil.zzak();
        this.zzi = zzil;
        zzkl zzkl = new zzkl(this);
        zzkl.zzak();
        this.zzf = zzkl;
        this.zze = new zzfh(this);
        if (this.zzp != this.zzq) {
            this.zzk.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzl = true;
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzk.zza().zza(zzat.zzbt) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzk.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to write to channel", e);
            return false;
        }
    }

    private final boolean zza(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkt.zza((zzcd.zzc) ((zzhv) zza2.zzy()), "_sc");
        String str = null;
        String zzd2 = zza4 == null ? null : zza4.zzd();
        zzh();
        zzcd.zze zza5 = zzkt.zza((zzcd.zzc) ((zzhv) zza3.zzy()), "_pc");
        if (zza5 != null) {
            str = zza5.zzd();
        }
        if (str == null || !str.equals(zzd2)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0229, code lost:
        if (r5 != null) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024b, code lost:
        if (r6 == null) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r2 = r0;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0288, code lost:
        if (r6 != null) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r6 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        if (r3 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01d4, code lost:
        if (r5 != null) goto L_0x01d6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (r0v20 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r3 
      PHI: (r3v52 android.database.Cursor) = (r3v46 android.database.Cursor), (r3v55 android.database.Cursor), (r3v55 android.database.Cursor), (r3v55 android.database.Cursor), (r3v55 android.database.Cursor), (r3v1 android.database.Cursor), (r3v1 android.database.Cursor) binds: [B:45:0x00e0, B:23:0x007f, B:29:0x008c, B:31:0x0090, B:32:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x028f A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029d A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x045b A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x045d A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0460 A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0461 A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x065c A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x073b A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x08c8 A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x08e2 A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x0c67 A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x0c7a A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0c7d A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:479:0x0ca1 A[Catch:{ SQLiteException -> 0x0fcb, all -> 0x1008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:585:0x0fee A[SYNTHETIC, Splitter:B:585:0x0fee] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0121 A[SYNTHETIC, Splitter:B:58:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:592:0x1004 A[SYNTHETIC, Splitter:B:592:0x1004] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0144 A[SYNTHETIC, Splitter:B:67:0x0144] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:96:0x01d6=Splitter:B:96:0x01d6, B:27:0x0087=Splitter:B:27:0x0087, B:143:0x028b=Splitter:B:143:0x028b, B:122:0x024d=Splitter:B:122:0x024d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r46, long r47) {
        /*
            r45 = this;
            r1 = r45
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()
            r2.zze()
            com.google.android.gms.measurement.internal.zzkp$zza r2 = new com.google.android.gms.measurement.internal.zzkp$zza     // Catch:{ all -> 0x1008 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzac r4 = r45.zze()     // Catch:{ all -> 0x1008 }
            long r5 = r1.zzy     // Catch:{ all -> 0x1008 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x1008 }
            r4.zzc()     // Catch:{ all -> 0x1008 }
            r4.zzaj()     // Catch:{ all -> 0x1008 }
            r8 = -1
            r10 = 2
            r11 = 0
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.mo18354c_()     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            boolean r13 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            if (r13 == 0) goto L_0x009f
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x004c
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            java.lang.String r16 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            r14[r11] = r16     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            java.lang.String r16 = java.lang.String.valueOf(r47)     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            r14[r12] = r16     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            goto L_0x0054
        L_0x0040:
            r0 = move-exception
            r2 = r0
            r22 = r3
            goto L_0x1002
        L_0x0046:
            r0 = move-exception
            r6 = r3
            r7 = r6
        L_0x0049:
            r3 = r0
            goto L_0x0277
        L_0x004c:
            java.lang.String[] r14 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r16 = java.lang.String.valueOf(r47)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r14[r11] = r16     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
        L_0x0054:
            if (r13 == 0) goto L_0x0059
            java.lang.String r13 = "rowid <= ? and "
            goto L_0x005b
        L_0x0059:
            java.lang.String r13 = ""
        L_0x005b:
            java.lang.String r16 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            int r7 = r16.length()     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            int r7 = r7 + 148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r3.<init>(r7)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r3.append(r7)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r3.append(r13)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r3.append(r7)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            android.database.Cursor r3 = r15.rawQuery(r3, r14)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0268, all -> 0x0040 }
            if (r7 != 0) goto L_0x008c
            if (r3 == 0) goto L_0x028b
        L_0x0087:
            r3.close()     // Catch:{ all -> 0x1008 }
            goto L_0x028b
        L_0x008c:
            java.lang.String r7 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0268, all -> 0x0040 }
            java.lang.String r13 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x009c, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x009c, all -> 0x0040 }
            r23 = r3
            r3 = r7
            r7 = r13
            goto L_0x00f4
        L_0x009c:
            r0 = move-exception
            r6 = r3
            goto L_0x0049
        L_0x009f:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00b0
            java.lang.String[] r7 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r13 = 0
            r7[r11] = r13     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r13 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r7[r12] = r13     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r13 = r7
            goto L_0x00b5
        L_0x00b0:
            r7 = 0
            java.lang.String[] r13 = new java.lang.String[]{r7}     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
        L_0x00b5:
            if (r3 == 0) goto L_0x00ba
            java.lang.String r3 = " and rowid <= ?"
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r3 = ""
        L_0x00bc:
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            int r7 = r7.length()     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            int r7 = r7 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r14.<init>(r7)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r7)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            r14.append(r3)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r3 = " order by rowid limit 1;"
            r14.append(r3)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            java.lang.String r3 = r14.toString()     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            android.database.Cursor r3 = r15.rawQuery(r3, r13)     // Catch:{ SQLiteException -> 0x0273, all -> 0x026d }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0268, all -> 0x0040 }
            if (r7 != 0) goto L_0x00e9
            if (r3 == 0) goto L_0x028b
            goto L_0x0087
        L_0x00e9:
            java.lang.String r13 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0268, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x0268, all -> 0x0040 }
            r23 = r3
            r7 = r13
            r3 = 0
        L_0x00f4:
            java.lang.String r14 = "raw_events_metadata"
            java.lang.String r13 = "metadata"
            java.lang.String[] r16 = new java.lang.String[]{r13}     // Catch:{ SQLiteException -> 0x0262, all -> 0x025c }
            java.lang.String r17 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0262, all -> 0x025c }
            r13[r11] = r3     // Catch:{ SQLiteException -> 0x0262, all -> 0x025c }
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x0262, all -> 0x025c }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "2"
            r24 = r13
            r13 = r15
            r25 = r15
            r15 = r16
            r16 = r17
            r17 = r24
            android.database.Cursor r15 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0262, all -> 0x025c }
            boolean r13 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            if (r13 != 0) goto L_0x0144
            com.google.android.gms.measurement.internal.zzex r5 = r4.zzq()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zze()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            if (r15 == 0) goto L_0x028b
            r15.close()     // Catch:{ all -> 0x1008 }
            goto L_0x028b
        L_0x0139:
            r0 = move-exception
            r2 = r0
            r22 = r15
            goto L_0x1002
        L_0x013f:
            r0 = move-exception
            r7 = r3
            r6 = r15
            goto L_0x0049
        L_0x0144:
            byte[] r13 = r15.getBlob(r11)     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r14 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ IOException -> 0x0237 }
            com.google.android.gms.internal.measurement.zzjf r13 = com.google.android.gms.measurement.internal.zzkt.zza(r14, (byte[]) r13)     // Catch:{ IOException -> 0x0237 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r13     // Catch:{ IOException -> 0x0237 }
            com.google.android.gms.internal.measurement.zzjg r13 = r13.zzy()     // Catch:{ IOException -> 0x0237 }
            com.google.android.gms.internal.measurement.zzhv r13 = (com.google.android.gms.internal.measurement.zzhv) r13     // Catch:{ IOException -> 0x0237 }
            com.google.android.gms.internal.measurement.zzcd$zzg r13 = (com.google.android.gms.internal.measurement.zzcd.zzg) r13     // Catch:{ IOException -> 0x0237 }
            boolean r14 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            if (r14 == 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzex r14 = r4.zzq()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            com.google.android.gms.measurement.internal.zzez r14 = r14.zzh()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            java.lang.String r10 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r14.zza(r10, r12)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        L_0x0171:
            r15.close()     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            r2.zza(r13)     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0191
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r13[r11] = r3     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r12 = 1
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r6 = 2
            r13[r6] = r5     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r16 = r10
            r17 = r13
            goto L_0x019f
        L_0x0191:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            r10[r11] = r3     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            r6 = 1
            r10[r6] = r7     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            r16 = r5
            r17 = r10
        L_0x019f:
            java.lang.String r14 = "raw_events"
            java.lang.String r5 = "rowid"
            java.lang.String r6 = "name"
            java.lang.String r7 = "timestamp"
            java.lang.String r10 = "data"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r10}     // Catch:{ SQLiteException -> 0x0257, all -> 0x0253 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            r21 = 0
            r13 = r25
            r6 = r15
            r15 = r5
            android.database.Cursor r5 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0251 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            if (r6 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.zzex r6 = r4.zzq()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r6.zza(r7, r10)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            if (r5 == 0) goto L_0x028b
        L_0x01d6:
            r5.close()     // Catch:{ all -> 0x1008 }
            goto L_0x028b
        L_0x01db:
            long r6 = r5.getLong(r11)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r10 = 3
            byte[] r12 = r5.getBlob(r10)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r10 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x0210 }
            com.google.android.gms.internal.measurement.zzjf r10 = com.google.android.gms.measurement.internal.zzkt.zza(r10, (byte[]) r12)     // Catch:{ IOException -> 0x0210 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r10 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r10     // Catch:{ IOException -> 0x0210 }
            r12 = 1
            java.lang.String r13 = r5.getString(r12)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r12 = r10.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r13 = 2
            long r14 = r5.getLong(r13)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r12.zza((long) r14)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.internal.measurement.zzjg r10 = r10.zzy()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.internal.measurement.zzhv r10 = (com.google.android.gms.internal.measurement.zzhv) r10     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.internal.measurement.zzcd$zzc r10 = (com.google.android.gms.internal.measurement.zzcd.zzc) r10     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            boolean r6 = r2.zza(r6, r10)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            if (r6 != 0) goto L_0x0223
            if (r5 == 0) goto L_0x028b
            goto L_0x01d6
        L_0x0210:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzex r7 = r4.zzq()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r7.zza(r10, r12, r6)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
        L_0x0223:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            if (r6 != 0) goto L_0x01db
            if (r5 == 0) goto L_0x028b
            goto L_0x01d6
        L_0x022c:
            r0 = move-exception
            r2 = r0
            r22 = r5
            goto L_0x1002
        L_0x0232:
            r0 = move-exception
            r7 = r3
            r6 = r5
            goto L_0x0049
        L_0x0237:
            r0 = move-exception
            r6 = r15
            r5 = r0
            com.google.android.gms.measurement.internal.zzex r7 = r4.zzq()     // Catch:{ SQLiteException -> 0x0251 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()     // Catch:{ SQLiteException -> 0x0251 }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0251 }
            r7.zza(r10, r12, r5)     // Catch:{ SQLiteException -> 0x0251 }
            if (r6 == 0) goto L_0x028b
        L_0x024d:
            r6.close()     // Catch:{ all -> 0x1008 }
            goto L_0x028b
        L_0x0251:
            r0 = move-exception
            goto L_0x0259
        L_0x0253:
            r0 = move-exception
            r6 = r15
            goto L_0x0fff
        L_0x0257:
            r0 = move-exception
            r6 = r15
        L_0x0259:
            r7 = r3
            goto L_0x0049
        L_0x025c:
            r0 = move-exception
            r2 = r0
            r22 = r23
            goto L_0x1002
        L_0x0262:
            r0 = move-exception
            r7 = r3
            r6 = r23
            goto L_0x0049
        L_0x0268:
            r0 = move-exception
            r6 = r3
            r7 = 0
            goto L_0x0049
        L_0x026d:
            r0 = move-exception
            r2 = r0
            r22 = 0
            goto L_0x1002
        L_0x0273:
            r0 = move-exception
            r3 = r0
            r6 = 0
            r7 = 0
        L_0x0277:
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()     // Catch:{ all -> 0x0ffe }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ all -> 0x0ffe }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r7)     // Catch:{ all -> 0x0ffe }
            r4.zza(r5, r7, r3)     // Catch:{ all -> 0x0ffe }
            if (r6 == 0) goto L_0x028b
            goto L_0x024d
        L_0x028b:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r3 = r2.zzc     // Catch:{ all -> 0x1008 }
            if (r3 == 0) goto L_0x029a
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r3 = r2.zzc     // Catch:{ all -> 0x1008 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x1008 }
            if (r3 == 0) goto L_0x0298
            goto L_0x029a
        L_0x0298:
            r3 = 0
            goto L_0x029b
        L_0x029a:
            r3 = 1
        L_0x029b:
            if (r3 != 0) goto L_0x0fee
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r2.zza     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r3 = r3.zzbo()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r3 = (com.google.android.gms.internal.measurement.zzhv.zzb) r3     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r3 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r3     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r3 = r3.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r4 = r4.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r5 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzau     // Catch:{ all -> 0x1008 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x1008 }
            r7 = 0
            r8 = -1
            r9 = -1
            r12 = 0
            r13 = 0
            r15 = 0
            r18 = 0
            r19 = 0
        L_0x02c8:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r11 = r2.zzc     // Catch:{ all -> 0x1008 }
            int r11 = r11.size()     // Catch:{ all -> 0x1008 }
            if (r7 >= r11) goto L_0x0932
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r11 = r2.zzc     // Catch:{ all -> 0x1008 }
            java.lang.Object r11 = r11.get(r7)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r11 = (com.google.android.gms.internal.measurement.zzcd.zzc) r11     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r11 = r11.zzbo()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r11 = (com.google.android.gms.internal.measurement.zzhv.zzb) r11     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r11 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzfv r10 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r5 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r10.zzb(r5, r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0371
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r10)     // Catch:{ all -> 0x1008 }
            r23 = r12
            com.google.android.gms.measurement.internal.zzgb r12 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzi()     // Catch:{ all -> 0x1008 }
            r25 = r15
            java.lang.String r15 = r11.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.String r12 = r12.zza((java.lang.String) r15)     // Catch:{ all -> 0x1008 }
            r5.zza(r6, r10, r12)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzfv r5 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zzg(r6)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x0342
            com.google.android.gms.measurement.internal.zzfv r5 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zzh(r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0340
            goto L_0x0342
        L_0x0340:
            r5 = 0
            goto L_0x0343
        L_0x0342:
            r5 = 1
        L_0x0343:
            if (r5 != 0) goto L_0x036a
            java.lang.String r5 = "_err"
            java.lang.String r6 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x036a
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzkx r26 = r5.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r5 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r27 = r5.zzx()     // Catch:{ all -> 0x1008 }
            r28 = 11
            java.lang.String r29 = "_ev"
            java.lang.String r30 = r11.zzd()     // Catch:{ all -> 0x1008 }
            r31 = 0
            r26.zza((java.lang.String) r27, (int) r28, (java.lang.String) r29, (java.lang.String) r30, (int) r31)     // Catch:{ all -> 0x1008 }
        L_0x036a:
            r10 = r7
            r15 = r25
            r6 = -1
            r12 = 3
            goto L_0x092c
        L_0x0371:
            r23 = r12
            r25 = r15
            boolean r5 = com.google.android.gms.internal.measurement.zzlj.zzb()     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0407
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r5 = r5.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzcs     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zze(r6, r10)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0407
            java.lang.String r5 = r11.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "_ai"
            java.lang.String r6 = com.google.android.gms.measurement.internal.zzgy.zza(r6)     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0407
            java.lang.String r5 = "_ai"
            r11.zza((java.lang.String) r5)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzw()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Renaming ad_impression to _ai"
            r5.zza(r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            r6 = 5
            boolean r5 = r5.zza((int) r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0407
            r5 = 0
        L_0x03c1:
            int r6 = r11.zzb()     // Catch:{ all -> 0x1008 }
            if (r5 >= r6) goto L_0x0407
            java.lang.String r6 = "ad_platform"
            com.google.android.gms.internal.measurement.zzcd$zze r10 = r11.zza((int) r5)     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzb()     // Catch:{ all -> 0x1008 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0404
            com.google.android.gms.internal.measurement.zzcd$zze r6 = r11.zza((int) r5)     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzd()     // Catch:{ all -> 0x1008 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x1008 }
            if (r6 != 0) goto L_0x0404
            java.lang.String r6 = "admob"
            com.google.android.gms.internal.measurement.zzcd$zze r10 = r11.zza((int) r5)     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzd()     // Catch:{ all -> 0x1008 }
            boolean r6 = r6.equalsIgnoreCase(r10)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0404
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "AdMob ad impression logged from app. Potentially duplicative."
            r6.zza(r10)     // Catch:{ all -> 0x1008 }
        L_0x0404:
            int r5 = r5 + 1
            goto L_0x03c1
        L_0x0407:
            com.google.android.gms.measurement.internal.zzfv r5 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zzc(r6, r10)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x0467
            r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r11.zzd()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x1008 }
            int r10 = r6.hashCode()     // Catch:{ all -> 0x1008 }
            r12 = 94660(0x171c4, float:1.32647E-40)
            if (r10 == r12) goto L_0x044d
            r12 = 95025(0x17331, float:1.33158E-40)
            if (r10 == r12) goto L_0x0443
            r12 = 95027(0x17333, float:1.33161E-40)
            if (r10 == r12) goto L_0x0439
            goto L_0x0457
        L_0x0439:
            java.lang.String r10 = "_ui"
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0457
            r6 = 1
            goto L_0x0458
        L_0x0443:
            java.lang.String r10 = "_ug"
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0457
            r6 = 2
            goto L_0x0458
        L_0x044d:
            java.lang.String r10 = "_in"
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0457
            r6 = 0
            goto L_0x0458
        L_0x0457:
            r6 = -1
        L_0x0458:
            switch(r6) {
                case 0: goto L_0x045d;
                case 1: goto L_0x045d;
                case 2: goto L_0x045d;
                default: goto L_0x045b;
            }     // Catch:{ all -> 0x1008 }
        L_0x045b:
            r6 = 0
            goto L_0x045e
        L_0x045d:
            r6 = 1
        L_0x045e:
            if (r6 == 0) goto L_0x0461
            goto L_0x0467
        L_0x0461:
            r29 = r7
            r30 = r13
            goto L_0x065a
        L_0x0467:
            r6 = 0
            r10 = 0
            r12 = 0
        L_0x046a:
            int r15 = r11.zzb()     // Catch:{ all -> 0x1008 }
            if (r6 >= r15) goto L_0x04da
            java.lang.String r15 = "_c"
            com.google.android.gms.internal.measurement.zzcd$zze r28 = r11.zza((int) r6)     // Catch:{ all -> 0x1008 }
            r29 = r7
            java.lang.String r7 = r28.zzb()     // Catch:{ all -> 0x1008 }
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x04a3
            com.google.android.gms.internal.measurement.zzcd$zze r7 = r11.zza((int) r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r7 = r7.zzbo()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r7 = (com.google.android.gms.internal.measurement.zzhv.zzb) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r7 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r7     // Catch:{ all -> 0x1008 }
            r30 = r13
            r13 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r7 = r7.zza((long) r13)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r7 = r7.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r7 = (com.google.android.gms.internal.measurement.zzhv) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = (com.google.android.gms.internal.measurement.zzcd.zze) r7     // Catch:{ all -> 0x1008 }
            r11.zza((int) r6, (com.google.android.gms.internal.measurement.zzcd.zze) r7)     // Catch:{ all -> 0x1008 }
            r10 = 1
            goto L_0x04d3
        L_0x04a3:
            r30 = r13
            java.lang.String r7 = "_r"
            com.google.android.gms.internal.measurement.zzcd$zze r13 = r11.zza((int) r6)     // Catch:{ all -> 0x1008 }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x1008 }
            boolean r7 = r7.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x04d3
            com.google.android.gms.internal.measurement.zzcd$zze r7 = r11.zza((int) r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r7 = r7.zzbo()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r7 = (com.google.android.gms.internal.measurement.zzhv.zzb) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r7 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r7     // Catch:{ all -> 0x1008 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r7 = r7.zza((long) r12)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r7 = r7.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r7 = (com.google.android.gms.internal.measurement.zzhv) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = (com.google.android.gms.internal.measurement.zzcd.zze) r7     // Catch:{ all -> 0x1008 }
            r11.zza((int) r6, (com.google.android.gms.internal.measurement.zzcd.zze) r7)     // Catch:{ all -> 0x1008 }
            r12 = 1
        L_0x04d3:
            int r6 = r6 + 1
            r7 = r29
            r13 = r30
            goto L_0x046a
        L_0x04da:
            r29 = r7
            r30 = r13
            if (r10 != 0) goto L_0x0512
            if (r5 == 0) goto L_0x0512
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzi()     // Catch:{ all -> 0x1008 }
            java.lang.String r13 = r11.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zza((java.lang.String) r13)     // Catch:{ all -> 0x1008 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_c"
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = r6.zza((java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            r13 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = r6.zza((long) r13)     // Catch:{ all -> 0x1008 }
            r11.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r6)     // Catch:{ all -> 0x1008 }
        L_0x0512:
            if (r12 != 0) goto L_0x0544
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzi()     // Catch:{ all -> 0x1008 }
            java.lang.String r12 = r11.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zza((java.lang.String) r12)     // Catch:{ all -> 0x1008 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_r"
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = r6.zza((java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = r6.zza((long) r12)     // Catch:{ all -> 0x1008 }
            r11.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r6)     // Catch:{ all -> 0x1008 }
        L_0x0544:
            com.google.android.gms.measurement.internal.zzac r32 = r45.zze()     // Catch:{ all -> 0x1008 }
            long r33 = r45.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r35 = r6.zzx()     // Catch:{ all -> 0x1008 }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzaf r6 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x1008 }
            long r6 = r6.zze     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1008 }
            int r10 = r10.zzc(r12)     // Catch:{ all -> 0x1008 }
            long r12 = (long) r10     // Catch:{ all -> 0x1008 }
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x057f
            java.lang.String r6 = "_r"
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            r12 = r23
            goto L_0x0580
        L_0x057f:
            r12 = 1
        L_0x0580:
            java.lang.String r6 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r6 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0658
            if (r5 == 0) goto L_0x0658
            com.google.android.gms.measurement.internal.zzac r32 = r45.zze()     // Catch:{ all -> 0x1008 }
            long r33 = r45.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r35 = r6.zzx()     // Catch:{ all -> 0x1008 }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzaf r6 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x1008 }
            long r6 = r6.zzc     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r13 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r13 = r13.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzat.zzm     // Catch:{ all -> 0x1008 }
            int r10 = r10.zzb(r13, r14)     // Catch:{ all -> 0x1008 }
            long r13 = (long) r10     // Catch:{ all -> 0x1008 }
            int r10 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r10 <= 0) goto L_0x0658
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r10)     // Catch:{ all -> 0x1008 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x1008 }
            r6 = 0
            r7 = 0
            r10 = 0
            r13 = -1
        L_0x05de:
            int r14 = r11.zzb()     // Catch:{ all -> 0x1008 }
            if (r6 >= r14) goto L_0x0612
            com.google.android.gms.internal.measurement.zzcd$zze r14 = r11.zza((int) r6)     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = "_c"
            r23 = r12
            java.lang.String r12 = r14.zzb()     // Catch:{ all -> 0x1008 }
            boolean r12 = r15.equals(r12)     // Catch:{ all -> 0x1008 }
            if (r12 == 0) goto L_0x0600
            com.google.android.gms.internal.measurement.zzhv$zzb r10 = r14.zzbo()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r10 = (com.google.android.gms.internal.measurement.zzhv.zzb) r10     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r10 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r10     // Catch:{ all -> 0x1008 }
            r13 = r6
            goto L_0x060d
        L_0x0600:
            java.lang.String r12 = "_err"
            java.lang.String r14 = r14.zzb()     // Catch:{ all -> 0x1008 }
            boolean r12 = r12.equals(r14)     // Catch:{ all -> 0x1008 }
            if (r12 == 0) goto L_0x060d
            r7 = 1
        L_0x060d:
            int r6 = r6 + 1
            r12 = r23
            goto L_0x05de
        L_0x0612:
            r23 = r12
            if (r7 == 0) goto L_0x061c
            if (r10 == 0) goto L_0x061c
            r11.zzb((int) r13)     // Catch:{ all -> 0x1008 }
            goto L_0x065a
        L_0x061c:
            if (r10 == 0) goto L_0x063e
            java.lang.Object r6 = r10.clone()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r6 = (com.google.android.gms.internal.measurement.zzhv.zzb) r6     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r6     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_err"
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = r6.zza((java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            r14 = 10
            com.google.android.gms.internal.measurement.zzcd$zze$zza r6 = r6.zza((long) r14)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r6 = r6.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r6 = (com.google.android.gms.internal.measurement.zzhv) r6     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r6 = (com.google.android.gms.internal.measurement.zzcd.zze) r6     // Catch:{ all -> 0x1008 }
            r11.zza((int) r13, (com.google.android.gms.internal.measurement.zzcd.zze) r6)     // Catch:{ all -> 0x1008 }
            goto L_0x065a
        L_0x063e:
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zze()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r10)     // Catch:{ all -> 0x1008 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x1008 }
            goto L_0x065a
        L_0x0658:
            r23 = r12
        L_0x065a:
            if (r5 == 0) goto L_0x0725
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x1008 }
            java.util.List r6 = r11.zza()     // Catch:{ all -> 0x1008 }
            r5.<init>(r6)     // Catch:{ all -> 0x1008 }
            r6 = 0
            r7 = -1
            r10 = -1
        L_0x0668:
            int r12 = r5.size()     // Catch:{ all -> 0x1008 }
            if (r6 >= r12) goto L_0x0698
            java.lang.String r12 = "value"
            java.lang.Object r13 = r5.get(r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r13 = (com.google.android.gms.internal.measurement.zzcd.zze) r13     // Catch:{ all -> 0x1008 }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x1008 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r12 == 0) goto L_0x0682
            r7 = r6
            goto L_0x0695
        L_0x0682:
            java.lang.String r12 = "currency"
            java.lang.Object r13 = r5.get(r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r13 = (com.google.android.gms.internal.measurement.zzcd.zze) r13     // Catch:{ all -> 0x1008 }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x1008 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r12 == 0) goto L_0x0695
            r10 = r6
        L_0x0695:
            int r6 = r6 + 1
            goto L_0x0668
        L_0x0698:
            r6 = -1
            if (r7 == r6) goto L_0x0726
            java.lang.Object r6 = r5.get(r7)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r6 = (com.google.android.gms.internal.measurement.zzcd.zze) r6     // Catch:{ all -> 0x1008 }
            boolean r6 = r6.zze()     // Catch:{ all -> 0x1008 }
            if (r6 != 0) goto L_0x06d2
            java.lang.Object r6 = r5.get(r7)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r6 = (com.google.android.gms.internal.measurement.zzcd.zze) r6     // Catch:{ all -> 0x1008 }
            boolean r6 = r6.zzi()     // Catch:{ all -> 0x1008 }
            if (r6 != 0) goto L_0x06d2
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Value must be specified with a numeric type."
            r5.zza(r6)     // Catch:{ all -> 0x1008 }
            r11.zzb((int) r7)     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = "_c"
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (java.lang.String) r5)     // Catch:{ all -> 0x1008 }
            r5 = 18
            java.lang.String r6 = "value"
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (int) r5, (java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            goto L_0x0725
        L_0x06d2:
            r6 = -1
            if (r10 != r6) goto L_0x06d8
            r5 = 1
            r12 = 3
            goto L_0x0704
        L_0x06d8:
            java.lang.Object r5 = r5.get(r10)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r5 = (com.google.android.gms.internal.measurement.zzcd.zze) r5     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r5.zzd()     // Catch:{ all -> 0x1008 }
            int r10 = r5.length()     // Catch:{ all -> 0x1008 }
            r12 = 3
            if (r10 == r12) goto L_0x06eb
        L_0x06e9:
            r5 = 1
            goto L_0x0704
        L_0x06eb:
            r10 = 0
        L_0x06ec:
            int r13 = r5.length()     // Catch:{ all -> 0x1008 }
            if (r10 >= r13) goto L_0x0703
            int r13 = r5.codePointAt(r10)     // Catch:{ all -> 0x1008 }
            boolean r14 = java.lang.Character.isLetter(r13)     // Catch:{ all -> 0x1008 }
            if (r14 != 0) goto L_0x06fd
            goto L_0x06e9
        L_0x06fd:
            int r13 = java.lang.Character.charCount(r13)     // Catch:{ all -> 0x1008 }
            int r10 = r10 + r13
            goto L_0x06ec
        L_0x0703:
            r5 = 0
        L_0x0704:
            if (r5 == 0) goto L_0x0727
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r5.zza(r10)     // Catch:{ all -> 0x1008 }
            r11.zzb((int) r7)     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = "_c"
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (java.lang.String) r5)     // Catch:{ all -> 0x1008 }
            r5 = 19
            java.lang.String r7 = "currency"
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (int) r5, (java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            goto L_0x0727
        L_0x0725:
            r6 = -1
        L_0x0726:
            r12 = 3
        L_0x0727:
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r5 = r5.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzat     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zze(r7, r10)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x08b4
            java.lang.String r5 = "_e"
            java.lang.String r7 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x1008 }
            r13 = 1000(0x3e8, double:4.94E-321)
            if (r5 == 0) goto L_0x078d
            r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r5 = r11.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r5 = (com.google.android.gms.internal.measurement.zzhv) r5     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r5 = (com.google.android.gms.internal.measurement.zzcd.zzc) r5     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_fr"
            com.google.android.gms.internal.measurement.zzcd$zze r5 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r5, (java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x08b4
            if (r19 == 0) goto L_0x0787
            long r26 = r19.zzf()     // Catch:{ all -> 0x1008 }
            long r32 = r11.zzf()     // Catch:{ all -> 0x1008 }
            long r26 = r26 - r32
            long r26 = java.lang.Math.abs(r26)     // Catch:{ all -> 0x1008 }
            int r5 = (r26 > r13 ? 1 : (r26 == r13 ? 0 : -1))
            if (r5 > 0) goto L_0x0787
            java.lang.Object r5 = r19.clone()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r5 = (com.google.android.gms.internal.measurement.zzhv.zzb) r5     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r5 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5     // Catch:{ all -> 0x1008 }
            boolean r7 = r1.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x0787
            r3.zza((int) r9, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5)     // Catch:{ all -> 0x1008 }
        L_0x0781:
            r18 = 0
            r19 = 0
            goto L_0x08b4
        L_0x0787:
            r18 = r11
            r8 = r25
            goto L_0x08b4
        L_0x078d:
            java.lang.String r5 = "_vs"
            java.lang.String r7 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x07d8
            r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r5 = r11.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r5 = (com.google.android.gms.internal.measurement.zzhv) r5     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r5 = (com.google.android.gms.internal.measurement.zzcd.zzc) r5     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_et"
            com.google.android.gms.internal.measurement.zzcd$zze r5 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r5, (java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x08b4
            if (r18 == 0) goto L_0x07d2
            long r26 = r18.zzf()     // Catch:{ all -> 0x1008 }
            long r32 = r11.zzf()     // Catch:{ all -> 0x1008 }
            long r26 = r26 - r32
            long r26 = java.lang.Math.abs(r26)     // Catch:{ all -> 0x1008 }
            int r5 = (r26 > r13 ? 1 : (r26 == r13 ? 0 : -1))
            if (r5 > 0) goto L_0x07d2
            java.lang.Object r5 = r18.clone()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r5 = (com.google.android.gms.internal.measurement.zzhv.zzb) r5     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r5 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5     // Catch:{ all -> 0x1008 }
            boolean r7 = r1.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x07d2
            r3.zza((int) r8, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5)     // Catch:{ all -> 0x1008 }
            goto L_0x0781
        L_0x07d2:
            r19 = r11
            r9 = r25
            goto L_0x08b4
        L_0x07d8:
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r5 = r5.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzbn     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zze(r7, r10)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x08b4
            java.lang.String r5 = "_ab"
            java.lang.String r7 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x08b4
            r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r5 = r11.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r5 = (com.google.android.gms.internal.measurement.zzhv) r5     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r5 = (com.google.android.gms.internal.measurement.zzcd.zzc) r5     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_et"
            com.google.android.gms.internal.measurement.zzcd$zze r5 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r5, (java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x08b4
            if (r18 == 0) goto L_0x08b4
            long r13 = r18.zzf()     // Catch:{ all -> 0x1008 }
            long r26 = r11.zzf()     // Catch:{ all -> 0x1008 }
            long r13 = r13 - r26
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x1008 }
            r26 = 4000(0xfa0, double:1.9763E-320)
            int r5 = (r13 > r26 ? 1 : (r13 == r26 ? 0 : -1))
            if (r5 > 0) goto L_0x08b4
            java.lang.Object r5 = r18.clone()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r5 = (com.google.android.gms.internal.measurement.zzhv.zzb) r5     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r5 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5     // Catch:{ all -> 0x1008 }
            r1.zzb((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11)     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_e"
            java.lang.String r10 = r5.zzd()     // Catch:{ all -> 0x1008 }
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ all -> 0x1008 }
            r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r7 = r5.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r7 = (com.google.android.gms.internal.measurement.zzhv) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = (com.google.android.gms.internal.measurement.zzcd.zzc) r7     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "_sn"
            com.google.android.gms.internal.measurement.zzcd$zze r7 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r7, (java.lang.String) r10)     // Catch:{ all -> 0x1008 }
            r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r10 = r5.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r10 = (com.google.android.gms.internal.measurement.zzhv) r10     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r10 = (com.google.android.gms.internal.measurement.zzcd.zzc) r10     // Catch:{ all -> 0x1008 }
            java.lang.String r13 = "_sc"
            com.google.android.gms.internal.measurement.zzcd$zze r10 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r10, (java.lang.String) r13)     // Catch:{ all -> 0x1008 }
            r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r13 = r5.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r13 = (com.google.android.gms.internal.measurement.zzhv) r13     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r13 = (com.google.android.gms.internal.measurement.zzcd.zzc) r13     // Catch:{ all -> 0x1008 }
            java.lang.String r14 = "_si"
            com.google.android.gms.internal.measurement.zzcd$zze r13 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r13, (java.lang.String) r14)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x0873
            java.lang.String r7 = r7.zzd()     // Catch:{ all -> 0x1008 }
            goto L_0x0875
        L_0x0873:
            java.lang.String r7 = ""
        L_0x0875:
            boolean r14 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x1008 }
            if (r14 != 0) goto L_0x0884
            com.google.android.gms.measurement.internal.zzkt r14 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = "_sn"
            r14.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (java.lang.String) r15, (java.lang.Object) r7)     // Catch:{ all -> 0x1008 }
        L_0x0884:
            if (r10 == 0) goto L_0x088b
            java.lang.String r7 = r10.zzd()     // Catch:{ all -> 0x1008 }
            goto L_0x088d
        L_0x088b:
            java.lang.String r7 = ""
        L_0x088d:
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x1008 }
            if (r10 != 0) goto L_0x089c
            com.google.android.gms.measurement.internal.zzkt r10 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r14 = "_sc"
            r10.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (java.lang.String) r14, (java.lang.Object) r7)     // Catch:{ all -> 0x1008 }
        L_0x089c:
            if (r13 == 0) goto L_0x08af
            com.google.android.gms.measurement.internal.zzkt r7 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "_si"
            long r13 = r13.zzf()     // Catch:{ all -> 0x1008 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x1008 }
            r7.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11, (java.lang.String) r10, (java.lang.Object) r13)     // Catch:{ all -> 0x1008 }
        L_0x08af:
            r3.zza((int) r8, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r5)     // Catch:{ all -> 0x1008 }
            r18 = 0
        L_0x08b4:
            if (r4 != 0) goto L_0x0916
            java.lang.String r5 = "_e"
            java.lang.String r7 = r11.zzd()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0916
            int r5 = r11.zzb()     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x08e2
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r10)     // Catch:{ all -> 0x1008 }
        L_0x08de:
            r5.zza(r7, r10)     // Catch:{ all -> 0x1008 }
            goto L_0x0916
        L_0x08e2:
            com.google.android.gms.measurement.internal.zzkt r5 = r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r7 = r11.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r7 = (com.google.android.gms.internal.measurement.zzhv) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = (com.google.android.gms.internal.measurement.zzcd.zzc) r7     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "_et"
            java.lang.Object r5 = r5.zzb(r7, r10)     // Catch:{ all -> 0x1008 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x090f
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r10)     // Catch:{ all -> 0x1008 }
            goto L_0x08de
        L_0x090f:
            long r13 = r5.longValue()     // Catch:{ all -> 0x1008 }
            long r13 = r30 + r13
            goto L_0x0918
        L_0x0916:
            r13 = r30
        L_0x0918:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r5 = r2.zzc     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r7 = r11.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r7 = (com.google.android.gms.internal.measurement.zzhv) r7     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = (com.google.android.gms.internal.measurement.zzcd.zzc) r7     // Catch:{ all -> 0x1008 }
            r10 = r29
            r5.set(r10, r7)     // Catch:{ all -> 0x1008 }
            int r15 = r25 + 1
            r3.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r11)     // Catch:{ all -> 0x1008 }
        L_0x092c:
            int r7 = r10 + 1
            r12 = r23
            goto L_0x02c8
        L_0x0932:
            r23 = r12
            r30 = r13
            r25 = r15
            if (r4 == 0) goto L_0x0993
            r5 = r25
            r13 = r30
            r4 = 0
        L_0x093f:
            if (r4 >= r5) goto L_0x0995
            com.google.android.gms.internal.measurement.zzcd$zzc r6 = r3.zzb((int) r4)     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_e"
            java.lang.String r8 = r6.zzc()     // Catch:{ all -> 0x1008 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x0964
            r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_fr"
            com.google.android.gms.internal.measurement.zzcd$zze r7 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r6, (java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x0964
            r3.zzc((int) r4)     // Catch:{ all -> 0x1008 }
            int r5 = r5 + -1
            int r4 = r4 + -1
            goto L_0x0990
        L_0x0964:
            r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "_et"
            com.google.android.gms.internal.measurement.zzcd$zze r6 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r6, (java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0990
            boolean r7 = r6.zze()     // Catch:{ all -> 0x1008 }
            if (r7 == 0) goto L_0x097e
            long r6 = r6.zzf()     // Catch:{ all -> 0x1008 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x1008 }
            goto L_0x097f
        L_0x097e:
            r6 = 0
        L_0x097f:
            if (r6 == 0) goto L_0x0990
            long r7 = r6.longValue()     // Catch:{ all -> 0x1008 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0990
            long r6 = r6.longValue()     // Catch:{ all -> 0x1008 }
            long r13 = r13 + r6
        L_0x0990:
            r6 = 1
            int r4 = r4 + r6
            goto L_0x093f
        L_0x0993:
            r13 = r30
        L_0x0995:
            r4 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r3, (long) r13, (boolean) r4)     // Catch:{ all -> 0x1008 }
            java.util.List r4 = r3.zza()     // Catch:{ all -> 0x1008 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x1008 }
        L_0x09a1:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x09bb
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r5 = (com.google.android.gms.internal.measurement.zzcd.zzc) r5     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.zzc()     // Catch:{ all -> 0x1008 }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x09a1
            r4 = 1
            goto L_0x09bc
        L_0x09bb:
            r4 = 0
        L_0x09bc:
            if (r4 == 0) goto L_0x09cb
            com.google.android.gms.measurement.internal.zzac r4 = r45.zze()     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r3.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "_se"
            r4.zzb((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x1008 }
        L_0x09cb:
            java.lang.String r4 = "_sid"
            int r4 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r3, (java.lang.String) r4)     // Catch:{ all -> 0x1008 }
            if (r4 < 0) goto L_0x09d5
            r4 = 1
            goto L_0x09d6
        L_0x09d5:
            r4 = 0
        L_0x09d6:
            if (r4 == 0) goto L_0x09dd
            r4 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r3, (long) r13, (boolean) r4)     // Catch:{ all -> 0x1008 }
            goto L_0x0a01
        L_0x09dd:
            java.lang.String r4 = "_se"
            int r4 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r3, (java.lang.String) r4)     // Catch:{ all -> 0x1008 }
            if (r4 < 0) goto L_0x0a01
            r3.zze((int) r4)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x1008 }
        L_0x0a01:
            com.google.android.gms.measurement.internal.zzkt r4 = r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r4.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzw()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r5.zza(r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzfv r5 = r4.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r3.zzj()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zze(r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0a94
            com.google.android.gms.measurement.internal.zzac r5 = r4.zzi()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r3.zzj()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzf r5 = r5.zzb(r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0a94
            boolean r5 = r5.zzaf()     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0a94
            com.google.android.gms.measurement.internal.zzal r5 = r4.zzk()     // Catch:{ all -> 0x1008 }
            boolean r5 = r5.zzi()     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0a94
            com.google.android.gms.measurement.internal.zzex r5 = r4.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzv()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r5.zza(r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r5 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "_npa"
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r5 = r5.zza((java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzal r4 = r4.zzk()     // Catch:{ all -> 0x1008 }
            long r6 = r4.zzg()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r4 = r5.zza((long) r6)     // Catch:{ all -> 0x1008 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r4 = r4.zzb((long) r5)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r4 = r4.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r4 = (com.google.android.gms.internal.measurement.zzhv) r4     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzk r4 = (com.google.android.gms.internal.measurement.zzcd.zzk) r4     // Catch:{ all -> 0x1008 }
            r5 = 0
        L_0x0a70:
            int r6 = r3.zze()     // Catch:{ all -> 0x1008 }
            if (r5 >= r6) goto L_0x0a8e
            java.lang.String r6 = "_npa"
            com.google.android.gms.internal.measurement.zzcd$zzk r7 = r3.zzd((int) r5)     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x1008 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0a8b
            r3.zza((int) r5, (com.google.android.gms.internal.measurement.zzcd.zzk) r4)     // Catch:{ all -> 0x1008 }
            r5 = 1
            goto L_0x0a8f
        L_0x0a8b:
            int r5 = r5 + 1
            goto L_0x0a70
        L_0x0a8e:
            r5 = 0
        L_0x0a8f:
            if (r5 != 0) goto L_0x0a94
            r3.zza((com.google.android.gms.internal.measurement.zzcd.zzk) r4)     // Catch:{ all -> 0x1008 }
        L_0x0a94:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r3.zzb((long) r4)     // Catch:{ all -> 0x1008 }
            r5 = -9223372036854775808
            r4.zzc((long) r5)     // Catch:{ all -> 0x1008 }
            r4 = 0
        L_0x0aa3:
            int r5 = r3.zzb()     // Catch:{ all -> 0x1008 }
            if (r4 >= r5) goto L_0x0ad6
            com.google.android.gms.internal.measurement.zzcd$zzc r5 = r3.zzb((int) r4)     // Catch:{ all -> 0x1008 }
            long r6 = r5.zze()     // Catch:{ all -> 0x1008 }
            long r8 = r3.zzf()     // Catch:{ all -> 0x1008 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0ac0
            long r6 = r5.zze()     // Catch:{ all -> 0x1008 }
            r3.zzb((long) r6)     // Catch:{ all -> 0x1008 }
        L_0x0ac0:
            long r6 = r5.zze()     // Catch:{ all -> 0x1008 }
            long r8 = r3.zzg()     // Catch:{ all -> 0x1008 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0ad3
            long r5 = r5.zze()     // Catch:{ all -> 0x1008 }
            r3.zzc((long) r5)     // Catch:{ all -> 0x1008 }
        L_0x0ad3:
            int r4 = r4 + 1
            goto L_0x0aa3
        L_0x0ad6:
            boolean r4 = com.google.android.gms.internal.measurement.zzov.zzb()     // Catch:{ all -> 0x1008 }
            if (r4 == 0) goto L_0x0af1
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r4 = r4.zza()     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r3.zzj()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzcn     // Catch:{ all -> 0x1008 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x1008 }
            if (r4 == 0) goto L_0x0af1
            r3.zzq()     // Catch:{ all -> 0x1008 }
        L_0x0af1:
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r3.zzp()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzo r5 = r45.zzf()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r3.zzj()     // Catch:{ all -> 0x1008 }
            java.util.List r7 = r3.zza()     // Catch:{ all -> 0x1008 }
            java.util.List r8 = r3.zzd()     // Catch:{ all -> 0x1008 }
            long r9 = r3.zzf()     // Catch:{ all -> 0x1008 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x1008 }
            long r10 = r3.zzg()     // Catch:{ all -> 0x1008 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x1008 }
            java.util.List r5 = r5.zza(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x1008 }
            r4.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zza>) r5)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzy r4 = r4.zza()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r5 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1008 }
            boolean r4 = r4.zzi(r5)     // Catch:{ all -> 0x1008 }
            if (r4 == 0) goto L_0x0e62
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x1008 }
            r4.<init>()     // Catch:{ all -> 0x1008 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x1008 }
            r5.<init>()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()     // Catch:{ all -> 0x1008 }
            java.security.SecureRandom r6 = r6.zzg()     // Catch:{ all -> 0x1008 }
            r7 = 0
        L_0x0b43:
            int r8 = r3.zzb()     // Catch:{ all -> 0x1008 }
            if (r7 >= r8) goto L_0x0e2c
            com.google.android.gms.internal.measurement.zzcd$zzc r8 = r3.zzb((int) r7)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r8 = r8.zzbo()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv$zzb r8 = (com.google.android.gms.internal.measurement.zzhv.zzb) r8     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8     // Catch:{ all -> 0x1008 }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0bd9
            com.google.android.gms.measurement.internal.zzkt r9 = r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r10 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r10 = (com.google.android.gms.internal.measurement.zzhv) r10     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r10 = (com.google.android.gms.internal.measurement.zzcd.zzc) r10     // Catch:{ all -> 0x1008 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = r9.zzb(r10, r11)     // Catch:{ all -> 0x1008 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x1008 }
            java.lang.Object r10 = r4.get(r9)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r10 = (com.google.android.gms.measurement.internal.zzan) r10     // Catch:{ all -> 0x1008 }
            if (r10 != 0) goto L_0x0b8e
            com.google.android.gms.measurement.internal.zzac r10 = r45.zze()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r11 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r10 = r10.zza((java.lang.String) r11, (java.lang.String) r9)     // Catch:{ all -> 0x1008 }
            r4.put(r9, r10)     // Catch:{ all -> 0x1008 }
        L_0x0b8e:
            java.lang.Long r9 = r10.zzi     // Catch:{ all -> 0x1008 }
            if (r9 != 0) goto L_0x0bcf
            java.lang.Long r9 = r10.zzj     // Catch:{ all -> 0x1008 }
            long r11 = r9.longValue()     // Catch:{ all -> 0x1008 }
            r13 = 1
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x0ba9
            com.google.android.gms.measurement.internal.zzkt r9 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r11 = "_sr"
            java.lang.Long r12 = r10.zzj     // Catch:{ all -> 0x1008 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r11, (java.lang.Object) r12)     // Catch:{ all -> 0x1008 }
        L_0x0ba9:
            java.lang.Boolean r9 = r10.zzk     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0bc4
            java.lang.Boolean r9 = r10.zzk     // Catch:{ all -> 0x1008 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0bc4
            com.google.android.gms.measurement.internal.zzkt r9 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1008 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r13)     // Catch:{ all -> 0x1008 }
        L_0x0bc4:
            com.google.android.gms.internal.measurement.zzjg r9 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r9 = (com.google.android.gms.internal.measurement.zzhv) r9     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1008 }
            r5.add(r9)     // Catch:{ all -> 0x1008 }
        L_0x0bcf:
            r3.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1008 }
            r46 = r2
            r2 = r3
            r15 = r6
            r3 = r7
            goto L_0x0e24
        L_0x0bd9:
            com.google.android.gms.measurement.internal.zzfv r9 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1008 }
            long r9 = r9.zzf(r10)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzgb r11 = r1.zzk     // Catch:{ all -> 0x1008 }
            r11.zzh()     // Catch:{ all -> 0x1008 }
            long r11 = r8.zzf()     // Catch:{ all -> 0x1008 }
            long r11 = com.google.android.gms.measurement.internal.zzkx.zza((long) r11, (long) r9)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r13 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r13 = (com.google.android.gms.internal.measurement.zzhv) r13     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r13 = (com.google.android.gms.internal.measurement.zzcd.zzc) r13     // Catch:{ all -> 0x1008 }
            java.lang.String r14 = "_dbg"
            r18 = 1
            java.lang.Long r15 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x1008 }
            boolean r18 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x1008 }
            if (r18 != 0) goto L_0x0c64
            if (r15 != 0) goto L_0x0c0d
            goto L_0x0c64
        L_0x0c0d:
            java.util.List r13 = r13.zza()     // Catch:{ all -> 0x1008 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x1008 }
        L_0x0c15:
            boolean r18 = r13.hasNext()     // Catch:{ all -> 0x1008 }
            if (r18 == 0) goto L_0x0c64
            java.lang.Object r18 = r13.next()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zze r18 = (com.google.android.gms.internal.measurement.zzcd.zze) r18     // Catch:{ all -> 0x1008 }
            r46 = r13
            java.lang.String r13 = r18.zzb()     // Catch:{ all -> 0x1008 }
            boolean r13 = r14.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r13 == 0) goto L_0x0c61
            boolean r13 = r15 instanceof java.lang.Long     // Catch:{ all -> 0x1008 }
            if (r13 == 0) goto L_0x0c3f
            long r13 = r18.zzf()     // Catch:{ all -> 0x1008 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x1008 }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r13 != 0) goto L_0x0c5f
        L_0x0c3f:
            boolean r13 = r15 instanceof java.lang.String     // Catch:{ all -> 0x1008 }
            if (r13 == 0) goto L_0x0c4d
            java.lang.String r13 = r18.zzd()     // Catch:{ all -> 0x1008 }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r13 != 0) goto L_0x0c5f
        L_0x0c4d:
            boolean r13 = r15 instanceof java.lang.Double     // Catch:{ all -> 0x1008 }
            if (r13 == 0) goto L_0x0c64
            double r13 = r18.zzj()     // Catch:{ all -> 0x1008 }
            java.lang.Double r13 = java.lang.Double.valueOf(r13)     // Catch:{ all -> 0x1008 }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x1008 }
            if (r13 == 0) goto L_0x0c64
        L_0x0c5f:
            r13 = 1
            goto L_0x0c65
        L_0x0c61:
            r13 = r46
            goto L_0x0c15
        L_0x0c64:
            r13 = 0
        L_0x0c65:
            if (r13 != 0) goto L_0x0c7a
            com.google.android.gms.measurement.internal.zzfv r13 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r14 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r14 = r14.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x1008 }
            int r13 = r13.zzd(r14, r15)     // Catch:{ all -> 0x1008 }
            goto L_0x0c7b
        L_0x0c7a:
            r13 = 1
        L_0x0c7b:
            if (r13 > 0) goto L_0x0ca1
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r9 = r9.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r11 = r8.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x1008 }
            r9.zza(r10, r11, r12)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r9 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r9 = (com.google.android.gms.internal.measurement.zzhv) r9     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1008 }
            r5.add(r9)     // Catch:{ all -> 0x1008 }
            goto L_0x0bcf
        L_0x0ca1:
            java.lang.String r14 = r8.zzd()     // Catch:{ all -> 0x1008 }
            java.lang.Object r14 = r4.get(r14)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r14 = (com.google.android.gms.measurement.internal.zzan) r14     // Catch:{ all -> 0x1008 }
            if (r14 != 0) goto L_0x0d03
            com.google.android.gms.measurement.internal.zzac r14 = r45.zze()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r15 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x1008 }
            r18 = r9
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r14 = r14.zza((java.lang.String) r15, (java.lang.String) r9)     // Catch:{ all -> 0x1008 }
            if (r14 != 0) goto L_0x0d05
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r9 = r9.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzcd$zzg r14 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r14 = r14.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x1008 }
            r9.zza(r10, r14, r15)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r9 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r2.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r29 = r10.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.String r30 = r8.zzd()     // Catch:{ all -> 0x1008 }
            r31 = 1
            r33 = 1
            r35 = 1
            long r37 = r8.zzf()     // Catch:{ all -> 0x1008 }
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r28 = r9
            r28.<init>(r29, r30, r31, r33, r35, r37, r39, r41, r42, r43, r44)     // Catch:{ all -> 0x1008 }
            r14 = r9
            goto L_0x0d05
        L_0x0d03:
            r18 = r9
        L_0x0d05:
            com.google.android.gms.measurement.internal.zzkt r9 = r45.zzh()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r10 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r10 = (com.google.android.gms.internal.measurement.zzhv) r10     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r10 = (com.google.android.gms.internal.measurement.zzcd.zzc) r10     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = "_eid"
            java.lang.Object r9 = r9.zzb(r10, r15)     // Catch:{ all -> 0x1008 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0d1d
            r10 = 1
            goto L_0x0d1e
        L_0x0d1d:
            r10 = 0
        L_0x0d1e:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x1008 }
            r15 = 1
            if (r13 != r15) goto L_0x0d50
            com.google.android.gms.internal.measurement.zzjg r9 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r9 = (com.google.android.gms.internal.measurement.zzhv) r9     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1008 }
            r5.add(r9)     // Catch:{ all -> 0x1008 }
            boolean r9 = r10.booleanValue()     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0bcf
            java.lang.Long r9 = r14.zzi     // Catch:{ all -> 0x1008 }
            if (r9 != 0) goto L_0x0d42
            java.lang.Long r9 = r14.zzj     // Catch:{ all -> 0x1008 }
            if (r9 != 0) goto L_0x0d42
            java.lang.Boolean r9 = r14.zzk     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0bcf
        L_0x0d42:
            r9 = 0
            com.google.android.gms.measurement.internal.zzan r10 = r14.zza(r9, r9, r9)     // Catch:{ all -> 0x1008 }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x1008 }
            r4.put(r9, r10)     // Catch:{ all -> 0x1008 }
            goto L_0x0bcf
        L_0x0d50:
            int r15 = r6.nextInt(r13)     // Catch:{ all -> 0x1008 }
            if (r15 != 0) goto L_0x0d97
            com.google.android.gms.measurement.internal.zzkt r9 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r15 = "_sr"
            r46 = r2
            r21 = r3
            long r2 = (long) r13     // Catch:{ all -> 0x1008 }
            java.lang.Long r13 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x1008 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r15, (java.lang.Object) r13)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r9 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r9 = (com.google.android.gms.internal.measurement.zzhv) r9     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1008 }
            r5.add(r9)     // Catch:{ all -> 0x1008 }
            boolean r9 = r10.booleanValue()     // Catch:{ all -> 0x1008 }
            if (r9 == 0) goto L_0x0d82
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x1008 }
            r3 = 0
            com.google.android.gms.measurement.internal.zzan r14 = r14.zza(r3, r2, r3)     // Catch:{ all -> 0x1008 }
        L_0x0d82:
            java.lang.String r2 = r8.zzd()     // Catch:{ all -> 0x1008 }
            long r9 = r8.zzf()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r3 = r14.zza(r9, r11)     // Catch:{ all -> 0x1008 }
            r4.put(r2, r3)     // Catch:{ all -> 0x1008 }
            r15 = r6
            r3 = r7
            r2 = r21
            goto L_0x0e21
        L_0x0d97:
            r46 = r2
            r21 = r3
            java.lang.Long r2 = r14.zzh     // Catch:{ all -> 0x1008 }
            if (r2 == 0) goto L_0x0da9
            java.lang.Long r2 = r14.zzh     // Catch:{ all -> 0x1008 }
            long r2 = r2.longValue()     // Catch:{ all -> 0x1008 }
            r15 = r6
            r25 = r7
            goto L_0x0dbb
        L_0x0da9:
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk     // Catch:{ all -> 0x1008 }
            r2.zzh()     // Catch:{ all -> 0x1008 }
            long r2 = r8.zzg()     // Catch:{ all -> 0x1008 }
            r15 = r6
            r25 = r7
            r6 = r18
            long r2 = com.google.android.gms.measurement.internal.zzkx.zza((long) r2, (long) r6)     // Catch:{ all -> 0x1008 }
        L_0x0dbb:
            int r6 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x0e0b
            com.google.android.gms.measurement.internal.zzkt r2 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r3 = "_efs"
            r6 = 1
            java.lang.Long r9 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x1008 }
            r2.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r3, (java.lang.Object) r9)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzkt r2 = r45.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r3 = "_sr"
            long r6 = (long) r13     // Catch:{ all -> 0x1008 }
            java.lang.Long r9 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x1008 }
            r2.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r3, (java.lang.Object) r9)     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r2 = r8.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r2 = (com.google.android.gms.internal.measurement.zzhv) r2     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1008 }
            r5.add(r2)     // Catch:{ all -> 0x1008 }
            boolean r2 = r10.booleanValue()     // Catch:{ all -> 0x1008 }
            if (r2 == 0) goto L_0x0dfb
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x1008 }
            r3 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x1008 }
            r3 = 0
            com.google.android.gms.measurement.internal.zzan r14 = r14.zza(r3, r2, r6)     // Catch:{ all -> 0x1008 }
        L_0x0dfb:
            java.lang.String r2 = r8.zzd()     // Catch:{ all -> 0x1008 }
            long r6 = r8.zzf()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r3 = r14.zza(r6, r11)     // Catch:{ all -> 0x1008 }
            r4.put(r2, r3)     // Catch:{ all -> 0x1008 }
            goto L_0x0e1d
        L_0x0e0b:
            boolean r2 = r10.booleanValue()     // Catch:{ all -> 0x1008 }
            if (r2 == 0) goto L_0x0e1d
            java.lang.String r2 = r8.zzd()     // Catch:{ all -> 0x1008 }
            r3 = 0
            com.google.android.gms.measurement.internal.zzan r6 = r14.zza(r9, r3, r3)     // Catch:{ all -> 0x1008 }
            r4.put(r2, r6)     // Catch:{ all -> 0x1008 }
        L_0x0e1d:
            r2 = r21
            r3 = r25
        L_0x0e21:
            r2.zza((int) r3, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1008 }
        L_0x0e24:
            int r7 = r3 + 1
            r3 = r2
            r6 = r15
            r2 = r46
            goto L_0x0b43
        L_0x0e2c:
            r46 = r2
            r2 = r3
            int r3 = r5.size()     // Catch:{ all -> 0x1008 }
            int r6 = r2.zzb()     // Catch:{ all -> 0x1008 }
            if (r3 >= r6) goto L_0x0e40
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r3 = r2.zzc()     // Catch:{ all -> 0x1008 }
            r3.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zzc>) r5)     // Catch:{ all -> 0x1008 }
        L_0x0e40:
            java.util.Set r3 = r4.entrySet()     // Catch:{ all -> 0x1008 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x1008 }
        L_0x0e48:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x1008 }
            if (r4 == 0) goto L_0x0e65
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x1008 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzac r5 = r45.zze()     // Catch:{ all -> 0x1008 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzan r4 = (com.google.android.gms.measurement.internal.zzan) r4     // Catch:{ all -> 0x1008 }
            r5.zza((com.google.android.gms.measurement.internal.zzan) r4)     // Catch:{ all -> 0x1008 }
            goto L_0x0e48
        L_0x0e62:
            r46 = r2
            r2 = r3
        L_0x0e65:
            r3 = r46
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r3.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzac r5 = r45.zze()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzf r5 = r5.zzb(r4)     // Catch:{ all -> 0x1008 }
            if (r5 != 0) goto L_0x0e91
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zze()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r3.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x1008 }
            goto L_0x0eec
        L_0x0e91:
            int r6 = r2.zzb()     // Catch:{ all -> 0x1008 }
            if (r6 <= 0) goto L_0x0eec
            long r6 = r5.zzk()     // Catch:{ all -> 0x1008 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0ea5
            r2.zze((long) r6)     // Catch:{ all -> 0x1008 }
            goto L_0x0ea8
        L_0x0ea5:
            r2.zzi()     // Catch:{ all -> 0x1008 }
        L_0x0ea8:
            long r8 = r5.zzj()     // Catch:{ all -> 0x1008 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0eb3
            goto L_0x0eb4
        L_0x0eb3:
            r6 = r8
        L_0x0eb4:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0ebc
            r2.zzd((long) r6)     // Catch:{ all -> 0x1008 }
            goto L_0x0ebf
        L_0x0ebc:
            r2.zzh()     // Catch:{ all -> 0x1008 }
        L_0x0ebf:
            r5.zzv()     // Catch:{ all -> 0x1008 }
            long r6 = r5.zzs()     // Catch:{ all -> 0x1008 }
            int r7 = (int) r6     // Catch:{ all -> 0x1008 }
            r2.zzg((int) r7)     // Catch:{ all -> 0x1008 }
            long r6 = r2.zzf()     // Catch:{ all -> 0x1008 }
            r5.zza((long) r6)     // Catch:{ all -> 0x1008 }
            long r6 = r2.zzg()     // Catch:{ all -> 0x1008 }
            r5.zzb((long) r6)     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r5.zzad()     // Catch:{ all -> 0x1008 }
            if (r6 == 0) goto L_0x0ee2
            r2.zzj((java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            goto L_0x0ee5
        L_0x0ee2:
            r2.zzn()     // Catch:{ all -> 0x1008 }
        L_0x0ee5:
            com.google.android.gms.measurement.internal.zzac r6 = r45.zze()     // Catch:{ all -> 0x1008 }
            r6.zza((com.google.android.gms.measurement.internal.zzf) r5)     // Catch:{ all -> 0x1008 }
        L_0x0eec:
            int r5 = r2.zzb()     // Catch:{ all -> 0x1008 }
            if (r5 <= 0) goto L_0x0f4d
            com.google.android.gms.measurement.internal.zzfv r5 = r45.zzc()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r3.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzca$zzb r5 = r5.zza((java.lang.String) r6)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0f11
            boolean r6 = r5.zza()     // Catch:{ all -> 0x1008 }
            if (r6 != 0) goto L_0x0f09
            goto L_0x0f11
        L_0x0f09:
            long r5 = r5.zzb()     // Catch:{ all -> 0x1008 }
            r2.zzi((long) r5)     // Catch:{ all -> 0x1008 }
            goto L_0x0f3c
        L_0x0f11:
            com.google.android.gms.internal.measurement.zzcd$zzg r5 = r3.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = r5.zzam()     // Catch:{ all -> 0x1008 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x1008 }
            if (r5 == 0) goto L_0x0f23
            r5 = -1
            r2.zzi((long) r5)     // Catch:{ all -> 0x1008 }
            goto L_0x0f3c
        L_0x0f23:
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzh()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r3.zza     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1008 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r7)     // Catch:{ all -> 0x1008 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x1008 }
        L_0x0f3c:
            com.google.android.gms.measurement.internal.zzac r5 = r45.zze()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzjg r2 = r2.zzy()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzhv r2 = (com.google.android.gms.internal.measurement.zzhv) r2     // Catch:{ all -> 0x1008 }
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = (com.google.android.gms.internal.measurement.zzcd.zzg) r2     // Catch:{ all -> 0x1008 }
            r11 = r23
            r5.zza((com.google.android.gms.internal.measurement.zzcd.zzg) r2, (boolean) r11)     // Catch:{ all -> 0x1008 }
        L_0x0f4d:
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()     // Catch:{ all -> 0x1008 }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x1008 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x1008 }
            r2.zzc()     // Catch:{ all -> 0x1008 }
            r2.zzaj()     // Catch:{ all -> 0x1008 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x1008 }
            r6 = 0
        L_0x0f64:
            int r7 = r3.size()     // Catch:{ all -> 0x1008 }
            if (r6 >= r7) goto L_0x0f81
            if (r6 == 0) goto L_0x0f71
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x1008 }
        L_0x0f71:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x1008 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x1008 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x1008 }
            r5.append(r7)     // Catch:{ all -> 0x1008 }
            int r6 = r6 + 1
            goto L_0x0f64
        L_0x0f81:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x1008 }
            android.database.sqlite.SQLiteDatabase r6 = r2.mo18354c_()     // Catch:{ all -> 0x1008 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x1008 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x1008 }
            int r6 = r3.size()     // Catch:{ all -> 0x1008 }
            if (r5 == r6) goto L_0x0fb4
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x1008 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x1008 }
            int r3 = r3.size()     // Catch:{ all -> 0x1008 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x1008 }
            r2.zza(r6, r5, r3)     // Catch:{ all -> 0x1008 }
        L_0x0fb4:
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()     // Catch:{ all -> 0x1008 }
            android.database.sqlite.SQLiteDatabase r3 = r2.mo18354c_()     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0fcb }
            r7 = 0
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0fcb }
            r7 = 1
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0fcb }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0fcb }
            goto L_0x0fde
        L_0x0fcb:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x1008 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r4)     // Catch:{ all -> 0x1008 }
            r2.zza(r5, r4, r3)     // Catch:{ all -> 0x1008 }
        L_0x0fde:
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()     // Catch:{ all -> 0x1008 }
            r2.mo18353b_()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()
            r2.zzg()
            r2 = 1
            return r2
        L_0x0fee:
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()     // Catch:{ all -> 0x1008 }
            r2.mo18353b_()     // Catch:{ all -> 0x1008 }
            com.google.android.gms.measurement.internal.zzac r2 = r45.zze()
            r2.zzg()
            r2 = 0
            return r2
        L_0x0ffe:
            r0 = move-exception
        L_0x0fff:
            r2 = r0
            r22 = r6
        L_0x1002:
            if (r22 == 0) goto L_0x1007
            r22.close()     // Catch:{ all -> 0x1008 }
        L_0x1007:
            throw r2     // Catch:{ all -> 0x1008 }
        L_0x1008:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzac r3 = r45.zze()
            r3.zzg()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zza(java.lang.String, long):boolean");
    }

    private final boolean zzaa() {
        zzx();
        zzn();
        return zze().zzx() || !TextUtils.isEmpty(zze().mo18355d_());
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzab() {
        /*
            r21 = this;
            r0 = r21
            r21.zzx()
            r21.zzn()
            long r1 = r0.zzn
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzn
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.zza(r2, r3)
            com.google.android.gms.measurement.internal.zzfh r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkl r1 = r21.zzw()
            r1.zze()
            return
        L_0x004b:
            r0.zzn = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            boolean r1 = r1.zzaf()
            if (r1 == 0) goto L_0x023a
            boolean r1 = r21.zzaa()
            if (r1 != 0) goto L_0x005d
            goto L_0x023a
        L_0x005d:
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzat.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzac r5 = r21.zze()
            boolean r5 = r5.zzy()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzac r5 = r21.zze()
            boolean r5 = r5.mo18356e_()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00b0
            com.google.android.gms.measurement.internal.zzgb r10 = r0.zzk
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()
            java.lang.String r10 = r10.zzu()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00ad
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00ad
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzat.zzu
            goto L_0x00b2
        L_0x00ad:
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzat.zzt
            goto L_0x00b2
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzat.zzs
        L_0x00b2:
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            com.google.android.gms.measurement.internal.zzgb r12 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r12 = r12.zzb()
            com.google.android.gms.measurement.internal.zzfn r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzgb r14 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r14 = r14.zzb()
            com.google.android.gms.measurement.internal.zzfn r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzac r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzv()
            com.google.android.gms.measurement.internal.zzac r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzw()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00f7
        L_0x00f4:
            r8 = r3
            goto L_0x016d
        L_0x00f7:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x011d
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x011d
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x011d:
            com.google.android.gms.measurement.internal.zzkt r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza((long) r8, (long) r12)
            if (r5 != 0) goto L_0x012b
            long r8 = r8 + r12
            goto L_0x012c
        L_0x012b:
            r8 = r10
        L_0x012c:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x016d
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x016d
            r5 = 0
        L_0x0135:
            r6 = 20
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzat.zzab
            r10 = 0
            java.lang.Object r7 = r7.zza(r10)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x00f4
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzat.zzaa
            java.lang.Object r12 = r12.zza(r10)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r8 = r8 + r12
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x016a
            goto L_0x016d
        L_0x016a:
            int r5 = r5 + 1
            goto L_0x0135
        L_0x016d:
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x018f
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfh r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkl r1 = r21.zzw()
            r1.zze()
            return
        L_0x018f:
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzd()
            boolean r1 = r1.zze()
            if (r1 != 0) goto L_0x01b7
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfh r1 = r21.zzv()
            r1.zza()
            com.google.android.gms.measurement.internal.zzkl r1 = r21.zzw()
            r1.zze()
            return
        L_0x01b7:
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzat.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkt r7 = r21.zzh()
            boolean r7 = r7.zza((long) r1, (long) r5)
            if (r7 != 0) goto L_0x01e3
            long r1 = r1 + r5
            long r8 = java.lang.Math.max(r8, r1)
        L_0x01e3:
            com.google.android.gms.measurement.internal.zzfh r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.currentTimeMillis()
            long r8 = r8 - r1
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x021f
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzat.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r8 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzgb r2 = r0.zzk
            com.google.android.gms.common.util.Clock r2 = r2.zzl()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x021f:
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r1.zza(r2, r3)
            com.google.android.gms.measurement.internal.zzkl r1 = r21.zzw()
            r1.zza(r8)
            return
        L_0x023a:
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfh r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkl r1 = r21.zzw()
            r1.zze()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzab():void");
    }

    private final void zzac() {
        zzx();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzk.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzk.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzo.clear();
        }
    }

    @VisibleForTesting
    private final boolean zzad() {
        String str;
        zzez zzez;
        FileLock fileLock;
        zzx();
        if (!this.zzk.zza().zza(zzat.zzbi) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            try {
                this.zzv = new RandomAccessFile(new File(this.zzk.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = this.zzv.tryLock();
                if (this.zzu != null) {
                    this.zzk.zzq().zzw().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzk.zzq().zze().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                e = e;
                zzez = this.zzk.zzq().zze();
                str = "Failed to acquire storage lock";
                zzez.zza(str, e);
                return false;
            } catch (IOException e2) {
                e = e2;
                zzez = this.zzk.zzq().zze();
                str = "Failed to access storage lock file";
                zzez.zza(str, e);
                return false;
            } catch (OverlappingFileLockException e3) {
                e = e3;
                zzez = this.zzk.zzq().zzh();
                str = "Storage lock already acquired";
                zzez.zza(str, e);
                return false;
            }
        } else {
            this.zzk.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final zzn zzb(String str) {
        String str2 = str;
        zzf zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zznq.zzb() || !this.zzk.zza().zze(str2, zzat.zzbj)) ? null : zzb2.zzg(), (!zzmb.zzb() || !this.zzk.zza().zza(zzat.zzcp)) ? "" : zza(str).zza());
        }
        this.zzk.zzq().zze().zza("App version does not match; dropping. appId", zzex.zza(str));
        return null;
    }

    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzb(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkt.zza((zzcd.zzc) ((zzhv) zza2.zzy()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcd.zze zza5 = zzkt.zza((zzcd.zzc) ((zzhv) zza3.zzy()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    private final void zzb(zzar zzar, zzn zzn2) {
        if (zznr.zzb() && this.zzk.zza().zza(zzat.zzch)) {
            zzfb zza2 = zzfb.zza(zzar);
            this.zzk.zzh().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzk.zzh().zza(zza2, this.zzk.zza().zza(zzn2.zza));
            zzar = zza2.zza();
        }
        if (this.zzk.zza().zza(zzat.zzbe) && "_cmp".equals(zzar.zza) && "referrer API v2".equals(zzar.zzb.zzd("_cis"))) {
            String zzd2 = zzar.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zza(new zzkw("_lgclid", zzar.zzd, zzd2, "auto"), zzn2);
            }
        }
        zza(zzar, zzn2);
    }

    private static void zzb(zzkm zzkm) {
        if (zzkm == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkm.zzai()) {
            String valueOf = String.valueOf(zzkm.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x02e6 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x031c A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0353 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0362 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0396 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x06c1 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x06d5 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0716 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0732 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x09ba A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0179 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0181 A[Catch:{ IOException -> 0x09bd, all -> 0x0a09 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzar r26, com.google.android.gms.measurement.internal.zzn r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            java.lang.String r4 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            long r4 = java.lang.System.nanoTime()
            r25.zzx()
            r25.zzn()
            java.lang.String r15 = r3.zza
            r25.zzh()
            boolean r6 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.measurement.internal.zzar) r26, (com.google.android.gms.measurement.internal.zzn) r27)
            if (r6 != 0) goto L_0x0024
            return
        L_0x0024:
            boolean r6 = r3.zzh
            if (r6 != 0) goto L_0x002c
            r1.zzc(r3)
            return
        L_0x002c:
            com.google.android.gms.measurement.internal.zzfv r6 = r25.zzc()
            java.lang.String r7 = r2.zza
            boolean r6 = r6.zzb(r15, r7)
            r14 = 0
            r13 = 0
            if (r6 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk
            com.google.android.gms.measurement.internal.zzex r3 = r3.zzq()
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzh()
            java.lang.String r4 = "Dropping blacklisted event. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzi()
            java.lang.String r7 = r2.zza
            java.lang.String r6 = r6.zza((java.lang.String) r7)
            r3.zza(r4, r5, r6)
            com.google.android.gms.measurement.internal.zzfv r3 = r25.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzfv r3 = r25.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x006e
        L_0x006d:
            r13 = 1
        L_0x006e:
            if (r13 != 0) goto L_0x008b
            java.lang.String r3 = "_err"
            java.lang.String r4 = r2.zza
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x008b
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk
            com.google.android.gms.measurement.internal.zzkx r6 = r3.zzh()
            r8 = 11
            java.lang.String r9 = "_ev"
            java.lang.String r10 = r2.zza
            r11 = 0
            r7 = r15
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)
        L_0x008b:
            if (r13 == 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00d4
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk
            com.google.android.gms.common.util.Clock r5 = r5.zzl()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzat.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk
            com.google.android.gms.measurement.internal.zzex r3 = r3.zzq()
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzv()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzf) r2)
        L_0x00d4:
            return
        L_0x00d5:
            boolean r6 = com.google.android.gms.internal.measurement.zzma.zzb()
            if (r6 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzcd
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r7)
            if (r6 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzfb r2 = com.google.android.gms.measurement.internal.zzfb.zza(r26)
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()
            int r7 = r7.zza((java.lang.String) r15)
            r6.zza((com.google.android.gms.measurement.internal.zzfb) r2, (int) r7)
            com.google.android.gms.measurement.internal.zzar r2 = r2.zza()
        L_0x0104:
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            r7 = 2
            boolean r6 = r6.zza((int) r7)
            if (r6 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()
            java.lang.String r8 = "Logging event"
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzi()
            java.lang.String r9 = r9.zza((com.google.android.gms.measurement.internal.zzar) r2)
            r6.zza(r8, r9)
        L_0x012a:
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()
            r6.zze()
            r1.zzc(r3)     // Catch:{ all -> 0x0a09 }
            boolean r6 = com.google.android.gms.internal.measurement.zzmh.zzb()     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x014a
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzcc     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x014a
            r6 = 1
            goto L_0x014b
        L_0x014a:
            r6 = 0
        L_0x014b:
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0a09 }
            if (r8 != 0) goto L_0x016e
            if (r6 == 0) goto L_0x016c
            java.lang.String r6 = "purchase"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x016e
            java.lang.String r6 = "refund"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x016c
            goto L_0x016e
        L_0x016c:
            r6 = 0
            goto L_0x016f
        L_0x016e:
            r6 = 1
        L_0x016f:
            java.lang.String r8 = "_iap"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0a09 }
            if (r8 != 0) goto L_0x017e
            if (r6 == 0) goto L_0x017c
            goto L_0x017e
        L_0x017c:
            r8 = 0
            goto L_0x017f
        L_0x017e:
            r8 = 1
        L_0x017f:
            if (r8 == 0) goto L_0x032b
            com.google.android.gms.measurement.internal.zzam r8 = r2.zzb     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = "currency"
            java.lang.String r8 = r8.zzd(r9)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.zzam r6 = r2.zzb     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = "value"
            java.lang.Double r6 = r6.zzc(r9)     // Catch:{ all -> 0x0a09 }
            double r9 = r6.doubleValue()     // Catch:{ all -> 0x0a09 }
            r16 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r9 = r9 * r16
            r18 = 0
            int r6 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r6 != 0) goto L_0x01b3
            com.google.android.gms.measurement.internal.zzam r6 = r2.zzb     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = "value"
            java.lang.Long r6 = r6.zzb(r9)     // Catch:{ all -> 0x0a09 }
            long r9 = r6.longValue()     // Catch:{ all -> 0x0a09 }
            double r9 = (double) r9     // Catch:{ all -> 0x0a09 }
            double r9 = r9 * r16
        L_0x01b3:
            r16 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r6 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r6 > 0) goto L_0x01e3
            r16 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r6 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x01e3
            long r9 = java.lang.Math.round(r9)     // Catch:{ all -> 0x0a09 }
            boolean r6 = com.google.android.gms.internal.measurement.zzmh.zzb()     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x020b
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzcc     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x020b
            java.lang.String r6 = "refund"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x020b
            long r9 = -r9
            goto L_0x020b
        L_0x01e3:
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = "Data lost. Currency value is too big. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r15)     // Catch:{ all -> 0x0a09 }
            java.lang.Double r9 = java.lang.Double.valueOf(r9)     // Catch:{ all -> 0x0a09 }
            r6.zza(r7, r8, r9)     // Catch:{ all -> 0x0a09 }
            r6 = 0
            r16 = 1
            goto L_0x031a
        L_0x01ff:
            com.google.android.gms.measurement.internal.zzam r6 = r2.zzb     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = "value"
            java.lang.Long r6 = r6.zzb(r9)     // Catch:{ all -> 0x0a09 }
            long r9 = r6.longValue()     // Catch:{ all -> 0x0a09 }
        L_0x020b:
            boolean r6 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x0317
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = r8.toUpperCase(r6)     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r6.matches(r8)     // Catch:{ all -> 0x0a09 }
            if (r8 == 0) goto L_0x0317
            java.lang.String r8 = "_ltv_"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0a09 }
            int r11 = r6.length()     // Catch:{ all -> 0x0a09 }
            if (r11 == 0) goto L_0x0234
            java.lang.String r6 = r8.concat(r6)     // Catch:{ all -> 0x0a09 }
            goto L_0x0239
        L_0x0234:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0a09 }
            r6.<init>(r8)     // Catch:{ all -> 0x0a09 }
        L_0x0239:
            r11 = r6
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzky r6 = r6.zzc(r15, r11)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x0275
            java.lang.Object r8 = r6.zze     // Catch:{ all -> 0x0a09 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0a09 }
            if (r8 != 0) goto L_0x024b
            goto L_0x0275
        L_0x024b:
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x0a09 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x0a09 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzky r16 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r12 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.common.util.Clock r12 = r12.zzl()     // Catch:{ all -> 0x0a09 }
            long r18 = r12.currentTimeMillis()     // Catch:{ all -> 0x0a09 }
            long r6 = r6 + r9
            java.lang.Long r12 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a09 }
            r6 = r16
            r7 = r15
            r9 = r11
            r10 = r18
            r14 = 1
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x0a09 }
            r14 = r16
            r16 = 1
            goto L_0x02dc
        L_0x0275:
            r14 = 1
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r8 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzat.zzad     // Catch:{ all -> 0x0a09 }
            int r8 = r8.zzb(r15, r12)     // Catch:{ all -> 0x0a09 }
            int r8 = r8 - r14
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0a09 }
            r6.zzc()     // Catch:{ all -> 0x0a09 }
            r6.zzaj()     // Catch:{ all -> 0x0a09 }
            android.database.sqlite.SQLiteDatabase r12 = r6.mo18354c_()     // Catch:{ SQLiteException -> 0x02ad }
            java.lang.String r7 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r14 = 3
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x02ad }
            r14[r13] = r15     // Catch:{ SQLiteException -> 0x02ad }
            r16 = 1
            r14[r16] = r15     // Catch:{ SQLiteException -> 0x02ab }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x02ab }
            r17 = 2
            r14[r17] = r8     // Catch:{ SQLiteException -> 0x02ab }
            r12.execSQL(r7, r14)     // Catch:{ SQLiteException -> 0x02ab }
            goto L_0x02c2
        L_0x02ab:
            r0 = move-exception
            goto L_0x02b0
        L_0x02ad:
            r0 = move-exception
            r16 = 1
        L_0x02b0:
            r7 = r0
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r15)     // Catch:{ all -> 0x0a09 }
            r6.zza(r8, r12, r7)     // Catch:{ all -> 0x0a09 }
        L_0x02c2:
            com.google.android.gms.measurement.internal.zzky r14 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.common.util.Clock r6 = r6.zzl()     // Catch:{ all -> 0x0a09 }
            long r19 = r6.currentTimeMillis()     // Catch:{ all -> 0x0a09 }
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0a09 }
            r6 = r14
            r7 = r15
            r9 = r11
            r10 = r19
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x0a09 }
        L_0x02dc:
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzky) r14)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x0319
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r15)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzi()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r14.zzc     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = r9.zzc(r10)     // Catch:{ all -> 0x0a09 }
            java.lang.Object r10 = r14.zze     // Catch:{ all -> 0x0a09 }
            r6.zza(r7, r8, r9, r10)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()     // Catch:{ all -> 0x0a09 }
            r8 = 9
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r15
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x0a09 }
            goto L_0x0319
        L_0x0317:
            r16 = 1
        L_0x0319:
            r6 = 1
        L_0x031a:
            if (r6 != 0) goto L_0x032d
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r2.mo18353b_()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzg()
            return
        L_0x032b:
            r16 = 1
        L_0x032d:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r17 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = "_err"
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r19 = r6.equals(r7)     // Catch:{ all -> 0x0a09 }
            boolean r6 = com.google.android.gms.internal.measurement.zzmh.zzb()     // Catch:{ all -> 0x0a09 }
            r20 = 1
            if (r6 == 0) goto L_0x0362
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzby     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x0362
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            r6.zzh()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzam r6 = r2.zzb     // Catch:{ all -> 0x0a09 }
            long r6 = com.google.android.gms.measurement.internal.zzkx.zza((com.google.android.gms.measurement.internal.zzam) r6)     // Catch:{ all -> 0x0a09 }
            long r6 = r6 + r20
            r10 = r6
            goto L_0x0364
        L_0x0362:
            r10 = r20
        L_0x0364:
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            long r7 = r25.zzy()     // Catch:{ all -> 0x0a09 }
            r12 = 1
            r14 = 0
            r22 = 0
            r9 = r15
            r13 = r17
            r26 = r15
            r15 = r19
            r16 = r22
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zza(r7, r9, r10, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0a09 }
            long r7 = r6.zzb     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzat.zzj     // Catch:{ all -> 0x0a09 }
            r15 = 0
            java.lang.Object r9 = r9.zza(r15)     // Catch:{ all -> 0x0a09 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0a09 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0a09 }
            long r9 = (long) r9     // Catch:{ all -> 0x0a09 }
            long r7 = r7 - r9
            r9 = 1000(0x3e8, double:4.94E-321)
            r13 = 0
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x03c3
            long r7 = r7 % r9
            int r2 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r2 != 0) goto L_0x03b4
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r26)     // Catch:{ all -> 0x0a09 }
            long r5 = r6.zzb     // Catch:{ all -> 0x0a09 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a09 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0a09 }
        L_0x03b4:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r2.mo18353b_()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzg()
            return
        L_0x03c3:
            if (r17 == 0) goto L_0x0418
            long r7 = r6.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzat.zzl     // Catch:{ all -> 0x0a09 }
            java.lang.Object r11 = r11.zza(r15)     // Catch:{ all -> 0x0a09 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ all -> 0x0a09 }
            int r11 = r11.intValue()     // Catch:{ all -> 0x0a09 }
            long r11 = (long) r11     // Catch:{ all -> 0x0a09 }
            long r7 = r7 - r11
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0418
            long r7 = r7 % r9
            int r3 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r3 != 0) goto L_0x03f7
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r3 = r3.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r26)     // Catch:{ all -> 0x0a09 }
            long r6 = r6.zza     // Catch:{ all -> 0x0a09 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a09 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x0a09 }
        L_0x03f7:
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r3.zzh()     // Catch:{ all -> 0x0a09 }
            r8 = 16
            java.lang.String r9 = "_ev"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0a09 }
            r11 = 0
            r7 = r26
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r2.mo18353b_()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzg()
            return
        L_0x0418:
            if (r19 == 0) goto L_0x0468
            long r7 = r6.zzd     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzat.zzk     // Catch:{ all -> 0x0a09 }
            int r9 = r9.zzb(r10, r11)     // Catch:{ all -> 0x0a09 }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r9 = java.lang.Math.min(r10, r9)     // Catch:{ all -> 0x0a09 }
            r11 = 0
            int r9 = java.lang.Math.max(r11, r9)     // Catch:{ all -> 0x0a09 }
            long r9 = (long) r9     // Catch:{ all -> 0x0a09 }
            long r7 = r7 - r9
            int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x0469
            int r2 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r2 != 0) goto L_0x0459
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r26)     // Catch:{ all -> 0x0a09 }
            long r5 = r6.zzd     // Catch:{ all -> 0x0a09 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a09 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0a09 }
        L_0x0459:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r2.mo18353b_()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzg()
            return
        L_0x0468:
            r11 = 0
        L_0x0469:
            com.google.android.gms.measurement.internal.zzam r6 = r2.zzb     // Catch:{ all -> 0x0a09 }
            android.os.Bundle r12 = r6.zzb()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = "_o"
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a09 }
            r6.zza((android.os.Bundle) r12, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()     // Catch:{ all -> 0x0a09 }
            r10 = r26
            boolean r6 = r6.zze(r10)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x04a8
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = "_dbg"
            java.lang.Long r8 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0a09 }
            r6.zza((android.os.Bundle) r12, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r6.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = "_r"
            java.lang.Long r8 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0a09 }
            r6.zza((android.os.Bundle) r12, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0a09 }
        L_0x04a8:
            java.lang.String r6 = "_s"
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x04d3
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = "_sno"
            com.google.android.gms.measurement.internal.zzky r6 = r6.zzc(r7, r8)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x04d3
            java.lang.Object r7 = r6.zze     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7 instanceof java.lang.Long     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x04d3
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r7 = r7.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = "_sno"
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x0a09 }
            r7.zza((android.os.Bundle) r12, (java.lang.String) r8, (java.lang.Object) r6)     // Catch:{ all -> 0x0a09 }
        L_0x04d3:
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            long r6 = r6.zzc(r10)     // Catch:{ all -> 0x0a09 }
            int r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r8 <= 0) goto L_0x04f6
            com.google.android.gms.measurement.internal.zzgb r8 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a09 }
            r8.zza(r9, r11, r6)     // Catch:{ all -> 0x0a09 }
        L_0x04f6:
            com.google.android.gms.measurement.internal.zzak r11 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a09 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a09 }
            long r13 = r2.zzd     // Catch:{ all -> 0x0a09 }
            r20 = 0
            r6 = r11
            r2 = r9
            r9 = r10
            r23 = r4
            r4 = r10
            r10 = r2
            r5 = r11
            r2 = r12
            r22 = 0
            r11 = r13
            r13 = r20
            r26 = r15
            r15 = r2
            r6.<init>((com.google.android.gms.measurement.internal.zzgb) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (long) r11, (long) r13, (android.os.Bundle) r15)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = r5.zzb     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzan r2 = r2.zza((java.lang.String) r4, (java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
            if (r2 != 0) goto L_0x0599
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            long r6 = r2.zzh(r4)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()     // Catch:{ all -> 0x0a09 }
            int r2 = r2.zzb(r4)     // Catch:{ all -> 0x0a09 }
            long r8 = (long) r2     // Catch:{ all -> 0x0a09 }
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x057f
            if (r17 == 0) goto L_0x057f
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r4)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ all -> 0x0a09 }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0a09 }
            java.lang.String r5 = r7.zza((java.lang.String) r5)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0a09 }
            int r7 = r7.zzb(r4)     // Catch:{ all -> 0x0a09 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0a09 }
            r2.zza(r3, r6, r5, r7)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkx r6 = r2.zzh()     // Catch:{ all -> 0x0a09 }
            r8 = 8
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r4
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzg()
            return
        L_0x057f:
            com.google.android.gms.measurement.internal.zzan r2 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0a09 }
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0a09 }
            r9 = 0
            r11 = 0
            long r13 = r5.zzc     // Catch:{ all -> 0x0a09 }
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r6 = r2
            r7 = r4
            r6.<init>(r7, r8, r9, r11, r13, r15, r17, r18, r19, r20)     // Catch:{ all -> 0x0a09 }
            goto L_0x05a8
        L_0x0599:
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x0a09 }
            long r6 = r2.zzf     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzak r11 = r5.zza(r4, r6)     // Catch:{ all -> 0x0a09 }
            long r4 = r11.zzc     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzan r2 = r2.zza(r4)     // Catch:{ all -> 0x0a09 }
            r5 = r11
        L_0x05a8:
            com.google.android.gms.measurement.internal.zzac r4 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r4.zza((com.google.android.gms.measurement.internal.zzan) r2)     // Catch:{ all -> 0x0a09 }
            r25.zzx()     // Catch:{ all -> 0x0a09 }
            r25.zzn()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)     // Catch:{ all -> 0x0a09 }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a09 }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a09 }
            java.lang.String r4 = r3.zza     // Catch:{ all -> 0x0a09 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ all -> 0x0a09 }
            r4 = 1
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((int) r4)     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = "android"
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a09 }
            r2.zzf((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
        L_0x05e7:
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x05f4
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0a09 }
            r2.zze((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
        L_0x05f4:
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x0601
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0a09 }
            r2.zzg((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
        L_0x0601:
            long r6 = r3.zzj     // Catch:{ all -> 0x0a09 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0610
            long r6 = r3.zzj     // Catch:{ all -> 0x0a09 }
            int r7 = (int) r6     // Catch:{ all -> 0x0a09 }
            r2.zzh((int) r7)     // Catch:{ all -> 0x0a09 }
        L_0x0610:
            long r6 = r3.zze     // Catch:{ all -> 0x0a09 }
            r2.zzf((long) r6)     // Catch:{ all -> 0x0a09 }
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x0622
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0a09 }
            r2.zzk((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
        L_0x0622:
            boolean r6 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x0655
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r7)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x0655
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzad r6 = r1.zza((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = r3.zzw     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzad r7 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r7)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzad r6 = r6.zzb((com.google.android.gms.measurement.internal.zzad) r7)     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = r3.zzw     // Catch:{ all -> 0x0a09 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x0655
            java.lang.String r6 = r6.zza()     // Catch:{ all -> 0x0a09 }
            r2.zzq(r6)     // Catch:{ all -> 0x0a09 }
        L_0x0655:
            boolean r6 = com.google.android.gms.internal.measurement.zznq.zzb()     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x06a4
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzbj     // Catch:{ all -> 0x0a09 }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x06a4
            java.lang.String r6 = r2.zzo()     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x0682
            java.lang.String r6 = r3.zzv     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x0682
            java.lang.String r6 = r3.zzv     // Catch:{ all -> 0x0a09 }
            r2.zzp(r6)     // Catch:{ all -> 0x0a09 }
        L_0x0682:
            java.lang.String r6 = r2.zzo()     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x06b9
            java.lang.String r6 = r2.zzs()     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x06b9
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x06b9
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x0a09 }
        L_0x06a0:
            r2.zzo(r6)     // Catch:{ all -> 0x0a09 }
            goto L_0x06b9
        L_0x06a4:
            java.lang.String r6 = r2.zzo()     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x06b9
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x06b9
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x0a09 }
            goto L_0x06a0
        L_0x06b9:
            long r6 = r3.zzf     // Catch:{ all -> 0x0a09 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x06c6
            long r6 = r3.zzf     // Catch:{ all -> 0x0a09 }
            r2.zzh((long) r6)     // Catch:{ all -> 0x0a09 }
        L_0x06c6:
            long r6 = r3.zzt     // Catch:{ all -> 0x0a09 }
            r2.zzk((long) r6)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkt r6 = r25.zzh()     // Catch:{ all -> 0x0a09 }
            java.util.List r6 = r6.zze()     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x06d8
            r2.zzd((java.lang.Iterable<? extends java.lang.Integer>) r6)     // Catch:{ all -> 0x0a09 }
        L_0x06d8:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzad r6 = r1.zza((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = r3.zzw     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzad r7 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r7)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzad r6 = r6.zzb((com.google.android.gms.measurement.internal.zzad) r7)     // Catch:{ all -> 0x0a09 }
            boolean r7 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x0702
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r10)     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x0702
            boolean r7 = r6.zzc()     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x07aa
        L_0x0702:
            com.google.android.gms.measurement.internal.zzjv r7 = r1.zzj     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a09 }
            android.util.Pair r7 = r7.zza(r10, r6)     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x0732
            java.lang.Object r10 = r7.first     // Catch:{ all -> 0x0a09 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0a09 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a09 }
            if (r10 != 0) goto L_0x0732
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x07aa
            java.lang.Object r10 = r7.first     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a09 }
            r2.zzh((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            java.lang.Object r10 = r7.second     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x07aa
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x0a09 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0a09 }
            r2.zza((boolean) r7)     // Catch:{ all -> 0x0a09 }
            goto L_0x07aa
        L_0x0732:
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzal r7 = r7.zzw()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            android.content.Context r10 = r10.zzm()     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zza(r10)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x07aa
            boolean r7 = r3.zzp     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x07aa
            boolean r7 = com.google.android.gms.internal.measurement.zzov.zzb()     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x075e
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzcn     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zze(r10, r11)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x07aa
        L_0x075e:
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            android.content.Context r7 = r7.zzm()     // Catch:{ all -> 0x0a09 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r10)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x078a
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = "null secure ID. appId"
            java.lang.String r11 = r2.zzj()     // Catch:{ all -> 0x0a09 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r11)     // Catch:{ all -> 0x0a09 }
            r7.zza(r10, r11)     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = "null"
            goto L_0x07a7
        L_0x078a:
            boolean r10 = r7.isEmpty()     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x07a7
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r2.zzj()     // Catch:{ all -> 0x0a09 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r12)     // Catch:{ all -> 0x0a09 }
            r10.zza(r11, r12)     // Catch:{ all -> 0x0a09 }
        L_0x07a7:
            r2.zzm(r7)     // Catch:{ all -> 0x0a09 }
        L_0x07aa:
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzal r7 = r7.zzw()     // Catch:{ all -> 0x0a09 }
            r7.zzaa()     // Catch:{ all -> 0x0a09 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r7 = r2.zzc((java.lang.String) r7)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzal r10 = r10.zzw()     // Catch:{ all -> 0x0a09 }
            r10.zzaa()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r7 = r7.zzb((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzal r10 = r10.zzw()     // Catch:{ all -> 0x0a09 }
            long r10 = r10.zze()     // Catch:{ all -> 0x0a09 }
            int r11 = (int) r10     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r7 = r7.zzf((int) r11)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzal r10 = r10.zzw()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r10.zzf()     // Catch:{ all -> 0x0a09 }
            r7.zzd((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzcf     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r10)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x07f7
            long r10 = r3.zzl     // Catch:{ all -> 0x0a09 }
            r2.zzj((long) r10)     // Catch:{ all -> 0x0a09 }
        L_0x07f7:
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zzaa()     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x081f
            boolean r7 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x0811
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r10)     // Catch:{ all -> 0x0a09 }
        L_0x0811:
            r2.zzj()     // Catch:{ all -> 0x0a09 }
            boolean r7 = android.text.TextUtils.isEmpty(r26)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x081f
            r7 = r26
            r2.zzn(r7)     // Catch:{ all -> 0x0a09 }
        L_0x081f:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r10)     // Catch:{ all -> 0x0a09 }
            if (r7 != 0) goto L_0x08ca
            com.google.android.gms.measurement.internal.zzf r7 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a09 }
            r7.<init>(r10, r11)     // Catch:{ all -> 0x0a09 }
            boolean r10 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x0850
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0a09 }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x0850
            java.lang.String r10 = r1.zza((com.google.android.gms.measurement.internal.zzad) r6)     // Catch:{ all -> 0x0a09 }
        L_0x084c:
            r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            goto L_0x0855
        L_0x0850:
            java.lang.String r10 = r25.zzz()     // Catch:{ all -> 0x0a09 }
            goto L_0x084c
        L_0x0855:
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0a09 }
            r7.zzf((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0a09 }
            r7.zzb((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            boolean r10 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x0879
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0a09 }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x0879
            boolean r10 = r6.zzc()     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x0884
        L_0x0879:
            com.google.android.gms.measurement.internal.zzjv r10 = r1.zzj     // Catch:{ all -> 0x0a09 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r10.zza(r11)     // Catch:{ all -> 0x0a09 }
            r7.zze((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
        L_0x0884:
            r7.zzg((long) r8)     // Catch:{ all -> 0x0a09 }
            r7.zza((long) r8)     // Catch:{ all -> 0x0a09 }
            r7.zzb((long) r8)     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0a09 }
            r7.zzg((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            long r10 = r3.zzj     // Catch:{ all -> 0x0a09 }
            r7.zzc((long) r10)     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0a09 }
            r7.zzh((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            long r10 = r3.zze     // Catch:{ all -> 0x0a09 }
            r7.zzd((long) r10)     // Catch:{ all -> 0x0a09 }
            long r10 = r3.zzf     // Catch:{ all -> 0x0a09 }
            r7.zze((long) r10)     // Catch:{ all -> 0x0a09 }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0a09 }
            r7.zza((boolean) r10)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzcf     // Catch:{ all -> 0x0a09 }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a09 }
            if (r10 != 0) goto L_0x08be
            long r10 = r3.zzl     // Catch:{ all -> 0x0a09 }
            r7.zzp(r10)     // Catch:{ all -> 0x0a09 }
        L_0x08be:
            long r10 = r3.zzt     // Catch:{ all -> 0x0a09 }
            r7.zzf((long) r10)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r10 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r10.zza((com.google.android.gms.measurement.internal.zzf) r7)     // Catch:{ all -> 0x0a09 }
        L_0x08ca:
            boolean r10 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x08e4
            com.google.android.gms.measurement.internal.zzgb r10 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0a09 }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x08e4
            boolean r6 = r6.zze()     // Catch:{ all -> 0x0a09 }
            if (r6 == 0) goto L_0x08f5
        L_0x08e4:
            java.lang.String r6 = r7.zzd()     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x08f5
            java.lang.String r6 = r7.zzd()     // Catch:{ all -> 0x0a09 }
            r2.zzi((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
        L_0x08f5:
            java.lang.String r6 = r7.zzi()     // Catch:{ all -> 0x0a09 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a09 }
            if (r6 != 0) goto L_0x0906
            java.lang.String r6 = r7.zzi()     // Catch:{ all -> 0x0a09 }
            r2.zzl((java.lang.String) r6)     // Catch:{ all -> 0x0a09 }
        L_0x0906:
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a09 }
            java.util.List r3 = r6.zza((java.lang.String) r3)     // Catch:{ all -> 0x0a09 }
            r6 = 0
        L_0x0911:
            int r7 = r3.size()     // Catch:{ all -> 0x0a09 }
            if (r6 >= r7) goto L_0x0948
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x0a09 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzky r10 = (com.google.android.gms.measurement.internal.zzky) r10     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x0a09 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzky r10 = (com.google.android.gms.measurement.internal.zzky) r10     // Catch:{ all -> 0x0a09 }
            long r10 = r10.zzd     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = r7.zza((long) r10)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzkt r10 = r25.zzh()     // Catch:{ all -> 0x0a09 }
            java.lang.Object r11 = r3.get(r6)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzky r11 = (com.google.android.gms.measurement.internal.zzky) r11     // Catch:{ all -> 0x0a09 }
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a09 }
            r10.zza((com.google.android.gms.internal.measurement.zzcd.zzk.zza) r7, (java.lang.Object) r11)     // Catch:{ all -> 0x0a09 }
            r2.zza((com.google.android.gms.internal.measurement.zzcd.zzk.zza) r7)     // Catch:{ all -> 0x0a09 }
            int r6 = r6 + 1
            goto L_0x0911
        L_0x0948:
            com.google.android.gms.measurement.internal.zzac r3 = r25.zze()     // Catch:{ IOException -> 0x09bd }
            com.google.android.gms.internal.measurement.zzjg r6 = r2.zzy()     // Catch:{ IOException -> 0x09bd }
            com.google.android.gms.internal.measurement.zzhv r6 = (com.google.android.gms.internal.measurement.zzhv) r6     // Catch:{ IOException -> 0x09bd }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = (com.google.android.gms.internal.measurement.zzcd.zzg) r6     // Catch:{ IOException -> 0x09bd }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzcd.zzg) r6)     // Catch:{ IOException -> 0x09bd }
            com.google.android.gms.measurement.internal.zzac r6 = r25.zze()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzam r7 = r5.zze     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x09b3
            com.google.android.gms.measurement.internal.zzam r7 = r5.zze     // Catch:{ all -> 0x0a09 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0a09 }
        L_0x0966:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x097b
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a09 }
            java.lang.String r11 = "_r"
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x0a09 }
            if (r10 == 0) goto L_0x0966
            goto L_0x09b4
        L_0x097b:
            com.google.android.gms.measurement.internal.zzfv r7 = r25.zzc()     // Catch:{ all -> 0x0a09 }
            java.lang.String r10 = r5.zza     // Catch:{ all -> 0x0a09 }
            java.lang.String r11 = r5.zzb     // Catch:{ all -> 0x0a09 }
            boolean r7 = r7.zzc(r10, r11)     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r10 = r25.zze()     // Catch:{ all -> 0x0a09 }
            long r11 = r25.zzy()     // Catch:{ all -> 0x0a09 }
            java.lang.String r13 = r5.zza     // Catch:{ all -> 0x0a09 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzaf r10 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0a09 }
            if (r7 == 0) goto L_0x09b3
            long r10 = r10.zze     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0a09 }
            java.lang.String r12 = r5.zza     // Catch:{ all -> 0x0a09 }
            int r7 = r7.zzc(r12)     // Catch:{ all -> 0x0a09 }
            long r12 = (long) r7     // Catch:{ all -> 0x0a09 }
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x09b3
            goto L_0x09b4
        L_0x09b3:
            r4 = 0
        L_0x09b4:
            boolean r2 = r6.zza((com.google.android.gms.measurement.internal.zzak) r5, (long) r2, (boolean) r4)     // Catch:{ all -> 0x0a09 }
            if (r2 == 0) goto L_0x09d6
            r1.zzn = r8     // Catch:{ all -> 0x0a09 }
            goto L_0x09d6
        L_0x09bd:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ all -> 0x0a09 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()     // Catch:{ all -> 0x0a09 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r2)     // Catch:{ all -> 0x0a09 }
            r4.zza(r5, r2, r3)     // Catch:{ all -> 0x0a09 }
        L_0x09d6:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x0a09 }
            r2.mo18353b_()     // Catch:{ all -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzg()
            r25.zzab()
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzk
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzw()
            java.lang.String r3 = "Background event processing time, ms"
            long r4 = java.lang.System.nanoTime()
            long r4 = r4 - r23
            r6 = 500000(0x7a120, double:2.47033E-318)
            long r4 = r4 + r6
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.zza(r3, r4)
            return
        L_0x0a09:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzac r3 = r25.zze()
            r3.zzg()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzc(com.google.android.gms.measurement.internal.zzar, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final boolean zze(zzn zzn2) {
        return (!zznq.zzb() || !this.zzk.zza().zze(zzn2.zza, zzat.zzbj)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }

    private final zzfh zzv() {
        zzfh zzfh = this.zze;
        if (zzfh != null) {
            return zzfh;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkl zzw() {
        zzb((zzkm) this.zzf);
        return this.zzf;
    }

    private final void zzx() {
        this.zzk.zzp().zzc();
    }

    private final long zzy() {
        long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
        zzfj zzb2 = this.zzk.zzb();
        zzb2.zzaa();
        zzb2.zzc();
        long zza2 = zzb2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzb2.zzo().zzg().nextInt(86400000));
            zzb2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    @Deprecated
    private final String zzz() {
        byte[] bArr = new byte[16];
        this.zzk.zzh().zzg().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final zzad zza(String str) {
        zzad zzad = zzad.zza;
        if (zzmb.zzb() && this.zzk.zza().zza(zzat.zzcp)) {
            zzx();
            zzn();
            zzad = this.zzz.get(str);
            if (zzad == null) {
                zzad = zze().zzj(str);
                if (zzad == null) {
                    zzad = zzad.zza;
                }
                zza(str, zzad);
            }
        }
        return zzad;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzk.zzp().zzc();
        zze().zzu();
        if (this.zzk.zzb().zzc.zza() == 0) {
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        zzab();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzac zze2;
        zzx();
        zzn();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzac();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
                this.zzk.zzb().zzd.zza(0);
                zzab();
                this.zzk.zzq().zzw().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zze();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzc();
                            zze2.zzaj();
                            if (zze2.mo18354c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzq().zze().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzx == null || !this.zzx.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().mo18353b_();
                    zze().zzg();
                    this.zzx = null;
                    if (!zzd().zze() || !zzaa()) {
                        this.zzy = -1;
                        zzab();
                    } else {
                        zzo();
                    }
                    this.zzn = 0;
                } catch (Throwable th3) {
                    zze().zzg();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzk.zzq().zze().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzn = this.zzk.zzl().elapsedRealtime();
                this.zzk.zzq().zzw().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzk.zzq().zzw().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
            }
            zze().zza(list);
            zzab();
        }
        this.zzs = false;
        zzac();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzar zzar, zzn zzn2) {
        List<zzw> list;
        List<zzw> list2;
        List<zzw> list3;
        zzez zze2;
        String str;
        Object zza2;
        String zzc2;
        Object obj;
        zzar zzar2 = zzar;
        zzn zzn3 = zzn2;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn3.zza);
        zzx();
        zzn();
        String str2 = zzn3.zza;
        long j = zzar2.zzd;
        zzh();
        if (zzkt.zza(zzar, zzn2)) {
            if (!zzn3.zzh) {
                zzc(zzn3);
                return;
            }
            if (zzn3.zzu != null) {
                if (zzn3.zzu.contains(zzar2.zza)) {
                    Bundle zzb2 = zzar2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzar2 = new zzar(zzar2.zza, new zzam(zzb2), zzar2.zzc, zzar2.zzd);
                } else {
                    this.zzk.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str2, zzar2.zza, zzar2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                zzac zze3 = zze();
                Preconditions.checkNotEmpty(str2);
                zze3.zzc();
                zze3.zzaj();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zze3.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzex.zza(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze3.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzw next : list) {
                    if (next != null) {
                        this.zzk.zzq().zzw().zza("User property timed out", next.zza, this.zzk.zzi().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            zzc(new zzar(next.zzg, j), zzn3);
                        }
                        zze().zze(str2, next.zzc.zza);
                    }
                }
                zzac zze4 = zze();
                Preconditions.checkNotEmpty(str2);
                zze4.zzc();
                zze4.zzaj();
                if (i < 0) {
                    zze4.zzq().zzh().zza("Invalid time querying expired conditional properties", zzex.zza(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze4.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzw next2 : list2) {
                    if (next2 != null) {
                        this.zzk.zzq().zzw().zza("User property expired", next2.zza, this.zzk.zzi().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str2, next2.zzc.zza);
                        if (next2.zzk != null) {
                            arrayList.add(next2.zzk);
                        }
                        zze().zze(str2, next2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    zzc(new zzar((zzar) obj2, j), zzn3);
                }
                zzac zze5 = zze();
                String str3 = zzar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zze5.zzc();
                zze5.zzaj();
                if (i < 0) {
                    zze5.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzex.zza(str2), zze5.zzn().zza(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze5.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzw next3 : list3) {
                    if (next3 != null) {
                        zzkw zzkw = next3.zzc;
                        zzky zzky = r4;
                        zzky zzky2 = new zzky(next3.zza, next3.zzb, zzkw.zza, j, zzkw.zza());
                        if (zze().zza(zzky)) {
                            zze2 = this.zzk.zzq().zzw();
                            str = "User property triggered";
                            zza2 = next3.zza;
                            zzc2 = this.zzk.zzi().zzc(zzky.zzc);
                            obj = zzky.zze;
                        } else {
                            zze2 = this.zzk.zzq().zze();
                            str = "Too many active user properties, ignoring";
                            zza2 = zzex.zza(next3.zza);
                            zzc2 = this.zzk.zzi().zzc(zzky.zzc);
                            obj = zzky.zze;
                        }
                        zze2.zza(str, zza2, zzc2, obj);
                        if (next3.zzi != null) {
                            arrayList3.add(next3.zzi);
                        }
                        next3.zzc = new zzkw(zzky);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzc(zzar2, zzn3);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj3 = arrayList4.get(i3);
                    i3++;
                    zzc(new zzar((zzar) obj3, j), zzn3);
                }
                zze().mo18353b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzar r36, java.lang.String r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r3 = r37
            com.google.android.gms.measurement.internal.zzac r2 = r35.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r3)
            if (r2 == 0) goto L_0x0112
            java.lang.String r4 = r2.zzl()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x001c
            goto L_0x0112
        L_0x001c:
            java.lang.Boolean r4 = r0.zzb((com.google.android.gms.measurement.internal.zzf) r2)
            if (r4 != 0) goto L_0x0040
            java.lang.String r4 = "_ui"
            java.lang.String r5 = r1.zza
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgb r4 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "Could not find package. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r37)
            r4.zza(r5, r6)
            goto L_0x005a
        L_0x0040:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()
            java.lang.String r2 = "App version does not match; dropping event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r37)
            r1.zza(r2, r3)
            return
        L_0x005a:
            com.google.android.gms.measurement.internal.zzn r15 = new com.google.android.gms.measurement.internal.zzn
            java.lang.String r4 = r2.zze()
            java.lang.String r5 = r2.zzl()
            long r6 = r2.zzm()
            java.lang.String r8 = r2.zzn()
            long r9 = r2.zzo()
            long r11 = r2.zzp()
            boolean r14 = r2.zzr()
            r16 = 0
            java.lang.String r17 = r2.zzi()
            long r18 = r2.zzae()
            r20 = 0
            r22 = 0
            boolean r23 = r2.zzaf()
            boolean r24 = r2.zzag()
            r25 = 0
            java.lang.String r26 = r2.zzf()
            java.lang.Boolean r27 = r2.zzah()
            long r28 = r2.zzq()
            java.util.List r30 = r2.zzai()
            boolean r31 = com.google.android.gms.internal.measurement.zznq.zzb()
            if (r31 == 0) goto L_0x00bf
            com.google.android.gms.measurement.internal.zzgb r13 = r0.zzk
            com.google.android.gms.measurement.internal.zzy r13 = r13.zza()
            java.lang.String r1 = r2.zzc()
            r32 = r14
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzat.zzbj
            boolean r1 = r13.zze(r1, r14)
            if (r1 == 0) goto L_0x00c1
            java.lang.String r1 = r2.zzg()
            goto L_0x00c2
        L_0x00bf:
            r32 = r14
        L_0x00c1:
            r1 = 0
        L_0x00c2:
            boolean r2 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r2 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzgb r2 = r0.zzk
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r13)
            if (r2 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzad r2 = r0.zza((java.lang.String) r3)
            java.lang.String r2 = r2.zza()
            goto L_0x00e1
        L_0x00df:
            java.lang.String r2 = ""
        L_0x00e1:
            r33 = r2
            r2 = r15
            r3 = r37
            r13 = 0
            r14 = r32
            r34 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r19 = r20
            r21 = r22
            r22 = r23
            r23 = r24
            r24 = r25
            r25 = r26
            r26 = r27
            r27 = r28
            r29 = r30
            r30 = r1
            r31 = r33
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (boolean) r24, (java.lang.String) r25, (java.lang.Boolean) r26, (long) r27, (java.util.List<java.lang.String>) r29, (java.lang.String) r30, (java.lang.String) r31)
            r2 = r34
            r1 = r36
            r0.zzb((com.google.android.gms.measurement.internal.zzar) r1, (com.google.android.gms.measurement.internal.zzn) r2)
            return
        L_0x0112:
            com.google.android.gms.measurement.internal.zzgb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzv()
            java.lang.String r2 = "No app data available; dropping event"
            r1.zza(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zza(com.google.android.gms.measurement.internal.zzar, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkm zzkm) {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkw zzkw, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzb2 = this.zzk.zzh().zzb(zzkw.zza);
            if (zzb2 != 0) {
                this.zzk.zzh();
                this.zzk.zzh().zza(zzn2.zza, zzb2, "_ev", zzkx.zza(zzkw.zza, 24, true), zzkw.zza != null ? zzkw.zza.length() : 0);
                return;
            }
            int zzb3 = this.zzk.zzh().zzb(zzkw.zza, zzkw.zza());
            if (zzb3 != 0) {
                this.zzk.zzh();
                String zza2 = zzkx.zza(zzkw.zza, 24, true);
                Object zza3 = zzkw.zza();
                this.zzk.zzh().zza(zzn2.zza, zzb3, "_ev", zza2, (zza3 == null || (!(zza3 instanceof String) && !(zza3 instanceof CharSequence))) ? 0 : String.valueOf(zza3).length());
                return;
            }
            Object zzc2 = this.zzk.zzh().zzc(zzkw.zza, zzkw.zza());
            if (zzc2 != null) {
                if ("_sid".equals(zzkw.zza)) {
                    long j = zzkw.zzb;
                    String str = zzkw.zze;
                    long j2 = 0;
                    zzky zzc3 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc3 == null || !(zzc3.zze instanceof Long)) {
                        if (zzc3 != null) {
                            this.zzk.zzq().zzh().zza("Retrieved last session number from database does not contain a valid (long) value", zzc3.zze);
                        }
                        zzan zza4 = zze().zza(zzn2.zza, "_s");
                        if (zza4 != null) {
                            j2 = zza4.zzc;
                            this.zzk.zzq().zzw().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc3.zze).longValue();
                    }
                    zza(new zzkw("_sno", j, Long.valueOf(j2 + 1), str), zzn2);
                }
                zzky zzky = new zzky(zzn2.zza, zzkw.zze, zzkw.zza, zzkw.zzb, zzc2);
                this.zzk.zzq().zzw().zza("Setting user property", this.zzk.zzi().zzc(zzky.zzc), zzc2);
                zze().zze();
                try {
                    zzc(zzn2);
                    boolean zza5 = zze().zza(zzky);
                    zze().mo18353b_();
                    if (!zza5) {
                        this.zzk.zzq().zze().zza("Too many unique user properties are set. Ignoring user property", this.zzk.zzi().zzc(zzky.zzc), zzky.zze);
                        this.zzk.zzh().zza(zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzg();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzn zzn2) {
        if (this.zzw != null) {
            this.zzx = new ArrayList();
            this.zzx.addAll(this.zzw);
        }
        zzac zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzc();
        zze2.zzaj();
        try {
            SQLiteDatabase c_ = zze2.mo18354c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzq().zze().zza("Error resetting analytics data. appId, error", zzex.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw2) {
        zzn zzb2 = zzb(zzw2.zza);
        if (zzb2 != null) {
            zza(zzw2, zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw2, zzn zzn2) {
        zzez zze2;
        String str;
        Object zza2;
        String zzc2;
        Object zza3;
        zzez zze3;
        String str2;
        Object zza4;
        String zzc3;
        Object obj;
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzb);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzw zzw3 = new zzw(zzw2);
            boolean z = false;
            zzw3.zze = false;
            zze().zze();
            try {
                zzw zzd2 = zze().zzd(zzw3.zza, zzw3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzw3.zzb)) {
                    this.zzk.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzk.zzi().zzc(zzw3.zzc.zza), zzw3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzw3.zzb = zzd2.zzb;
                    zzw3.zzd = zzd2.zzd;
                    zzw3.zzh = zzd2.zzh;
                    zzw3.zzf = zzd2.zzf;
                    zzw3.zzi = zzd2.zzi;
                    zzw3.zze = zzd2.zze;
                    zzw3.zzc = new zzkw(zzw3.zzc.zza, zzd2.zzc.zzb, zzw3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzw3.zzf)) {
                    zzw3.zzc = new zzkw(zzw3.zzc.zza, zzw3.zzd, zzw3.zzc.zza(), zzw3.zzc.zze);
                    zzw3.zze = true;
                    z = true;
                }
                if (zzw3.zze) {
                    zzkw zzkw = zzw3.zzc;
                    zzky zzky = new zzky(zzw3.zza, zzw3.zzb, zzkw.zza, zzkw.zzb, zzkw.zza());
                    if (zze().zza(zzky)) {
                        zze3 = this.zzk.zzq().zzv();
                        str2 = "User property updated immediately";
                        zza4 = zzw3.zza;
                        zzc3 = this.zzk.zzi().zzc(zzky.zzc);
                        obj = zzky.zze;
                    } else {
                        zze3 = this.zzk.zzq().zze();
                        str2 = "(2)Too many active user properties, ignoring";
                        zza4 = zzex.zza(zzw3.zza);
                        zzc3 = this.zzk.zzi().zzc(zzky.zzc);
                        obj = zzky.zze;
                    }
                    zze3.zza(str2, zza4, zzc3, obj);
                    if (z && zzw3.zzi != null) {
                        zzc(new zzar(zzw3.zzi, zzw3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzw3)) {
                    zze2 = this.zzk.zzq().zzv();
                    str = "Conditional property added";
                    zza2 = zzw3.zza;
                    zzc2 = this.zzk.zzi().zzc(zzw3.zzc.zza);
                    zza3 = zzw3.zzc.zza();
                } else {
                    zze2 = this.zzk.zzq().zze();
                    str = "Too many conditional properties, ignoring";
                    zza2 = zzex.zza(zzw3.zza);
                    zzc2 = this.zzk.zzi().zzc(zzw3.zzc.zza);
                    zza3 = zzw3.zzc.zza();
                }
                zze2.zza(str, zza2, zzc2, zza3);
                zze().mo18353b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzx();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0132 A[Catch:{ all -> 0x0179, all -> 0x0182 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142 A[Catch:{ all -> 0x0179, all -> 0x0182 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzx()
            r6.zzn()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0182 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzgb r1 = r6.zzk     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()     // Catch:{ all -> 0x0182 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0182 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0182 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzac r1 = r6.zze()     // Catch:{ all -> 0x0182 }
            r1.zze()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzac r1 = r6.zze()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzb(r7)     // Catch:{ all -> 0x0179 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgb r8 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzh()     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r7)     // Catch:{ all -> 0x0179 }
            r8.zza(r9, r7)     // Catch:{ all -> 0x0179 }
            goto L_0x016d
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzgb r10 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r10 = r10.zzl()     // Catch:{ all -> 0x0179 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r1.zzi((long) r10)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzac r10 = r6.zze()     // Catch:{ all -> 0x0179 }
            r10.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgb r10 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzq()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzw()     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0179 }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfv r9 = r6.zzc()     // Catch:{ all -> 0x0179 }
            r9.zzc(r7)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgb r7 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzb()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfn r7 = r7.zzd     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgb r9 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r9 = r9.zzl()     // Catch:{ all -> 0x0179 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r7.zza(r9)     // Catch:{ all -> 0x0179 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzgb r7 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzb()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfn r7 = r7.zze     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgb r8 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r8 = r8.zzl()     // Catch:{ all -> 0x0179 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r7.zza(r8)     // Catch:{ all -> 0x0179 }
        L_0x00c5:
            r6.zzab()     // Catch:{ all -> 0x0179 }
            goto L_0x016d
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0179 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0179 }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x0179 }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0179 }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfv r9 = r6.zzc()     // Catch:{ all -> 0x0179 }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x0179 }
            if (r9 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0182 }
        L_0x00fa:
            r7.zzg()     // Catch:{ all -> 0x0182 }
            r6.zzr = r0
            r6.zzac()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfv r11 = r6.zzc()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.internal.measurement.zzca$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x0179 }
            if (r11 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzfv r11 = r6.zzc()     // Catch:{ all -> 0x0179 }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x0179 }
            if (r9 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0182 }
            goto L_0x00fa
        L_0x011c:
            com.google.android.gms.measurement.internal.zzgb r9 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r9 = r9.zzl()     // Catch:{ all -> 0x0179 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r1.zzh((long) r2)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzac r9 = r6.zze()     // Catch:{ all -> 0x0179 }
            r9.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x0179 }
            if (r8 != r5) goto L_0x0142
            com.google.android.gms.measurement.internal.zzgb r8 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzj()     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x0179 }
            goto L_0x015a
        L_0x0142:
            com.google.android.gms.measurement.internal.zzgb r7 = r6.zzk     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzq()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzw()     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0179 }
            int r10 = r10.length     // Catch:{ all -> 0x0179 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0179 }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x0179 }
        L_0x015a:
            com.google.android.gms.measurement.internal.zzfa r7 = r6.zzd()     // Catch:{ all -> 0x0179 }
            boolean r7 = r7.zze()     // Catch:{ all -> 0x0179 }
            if (r7 == 0) goto L_0x00c5
            boolean r7 = r6.zzaa()     // Catch:{ all -> 0x0179 }
            if (r7 == 0) goto L_0x00c5
            r6.zzo()     // Catch:{ all -> 0x0179 }
        L_0x016d:
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0179 }
            r7.mo18353b_()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0182 }
            goto L_0x00fa
        L_0x0179:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzac r8 = r6.zze()     // Catch:{ all -> 0x0182 }
            r8.zzg()     // Catch:{ all -> 0x0182 }
            throw r7     // Catch:{ all -> 0x0182 }
        L_0x0182:
            r7 = move-exception
            r6.zzr = r0
            r6.zzac()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzad zzad) {
        if (zzmb.zzb() && this.zzk.zza().zza(zzat.zzcp)) {
            zzx();
            zzn();
            this.zzz.put(str, zzad);
            zzac zze2 = zze();
            if (zzmb.zzb() && zze2.zzs().zza(zzat.zzcp)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzad);
                zze2.zzc();
                zze2.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzad.zza());
                try {
                    if (zze2.mo18354c_().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                        zze2.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzex.zza(str));
                    }
                } catch (SQLiteException e) {
                    zze2.zzq().zze().zza("Error storing consent setting. appId, error", zzex.zza(str), e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzab();
    }

    public final zzy zzb() {
        return this.zzk.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkw zzkw, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzkw.zza) || zzn2.zzs == null) {
                this.zzk.zzq().zzv().zza("Removing user property", this.zzk.zzi().zzc(zzkw.zza));
                zze().zze();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzkw.zza);
                    zze().mo18353b_();
                    this.zzk.zzq().zzv().zza("User property removed", this.zzk.zzi().zzc(zzkw.zza));
                } finally {
                    zze().zzg();
                }
            } else {
                this.zzk.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkw("_npa", this.zzk.zzl().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), "auto"), zzn2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0486 A[Catch:{ SQLiteException -> 0x01ba, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0248 A[Catch:{ SQLiteException -> 0x01ba, all -> 0x04af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r21.zzx()
            r21.zzn()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r0 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            boolean r0 = r21.zze(r22)
            if (r0 != 0) goto L_0x0019
            return
        L_0x0019:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()
            java.lang.String r3 = r2.zza
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzb(r3)
            r3 = 0
            if (r0 == 0) goto L_0x004c
            java.lang.String r5 = r0.zze()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x004c
            java.lang.String r5 = r2.zzb
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x004c
            r0.zzh((long) r3)
            com.google.android.gms.measurement.internal.zzac r5 = r21.zze()
            r5.zza((com.google.android.gms.measurement.internal.zzf) r0)
            com.google.android.gms.measurement.internal.zzfv r0 = r21.zzc()
            java.lang.String r5 = r2.zza
            r0.zzd(r5)
        L_0x004c:
            boolean r0 = r2.zzh
            if (r0 != 0) goto L_0x0054
            r21.zzc(r22)
            return
        L_0x0054:
            long r5 = r2.zzm
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk
            com.google.android.gms.common.util.Clock r0 = r0.zzl()
            long r5 = r0.currentTimeMillis()
        L_0x0064:
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk
            com.google.android.gms.measurement.internal.zzal r0 = r0.zzw()
            r0.zzh()
            int r0 = r2.zzn
            r13 = 0
            r14 = 1
            if (r0 == 0) goto L_0x0090
            if (r0 == r14) goto L_0x0090
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzq()
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzh()
            java.lang.String r8 = "Incorrect app type, assuming installed app. appId, appType"
            java.lang.String r9 = r2.zza
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r9)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.zza(r8, r9, r0)
            r15 = 0
            goto L_0x0091
        L_0x0090:
            r15 = r0
        L_0x0091:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()
            r0.zze()
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_npa"
            com.google.android.gms.measurement.internal.zzky r0 = r0.zzc(r7, r8)     // Catch:{ all -> 0x04af }
            r11 = 1
            if (r0 == 0) goto L_0x00b2
            java.lang.String r7 = "auto"
            java.lang.String r8 = r0.zzb     // Catch:{ all -> 0x04af }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x04af }
            if (r7 == 0) goto L_0x00f8
        L_0x00b2:
            java.lang.Boolean r7 = r2.zzs     // Catch:{ all -> 0x04af }
            if (r7 == 0) goto L_0x00e7
            com.google.android.gms.measurement.internal.zzkw r9 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_npa"
            java.lang.Boolean r7 = r2.zzs     // Catch:{ all -> 0x04af }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x04af }
            if (r7 == 0) goto L_0x00c5
            r16 = r11
            goto L_0x00c7
        L_0x00c5:
            r16 = r3
        L_0x00c7:
            java.lang.Long r16 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x04af }
            java.lang.String r17 = "auto"
            r7 = r9
            r3 = r9
            r9 = r5
            r11 = r16
            r12 = r17
            r7.<init>(r8, r9, r11, r12)     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x00e3
            java.lang.Object r0 = r0.zze     // Catch:{ all -> 0x04af }
            java.lang.Long r4 = r3.zzc     // Catch:{ all -> 0x04af }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x04af }
            if (r0 != 0) goto L_0x00f8
        L_0x00e3:
            r1.zza((com.google.android.gms.measurement.internal.zzkw) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x00f8
        L_0x00e7:
            if (r0 == 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_npa"
            r11 = 0
            java.lang.String r12 = "auto"
            r7 = r0
            r9 = r5
            r7.<init>(r8, r9, r11, r12)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzkw) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
        L_0x00f8:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzb(r3)     // Catch:{ all -> 0x04af }
            r3 = 0
            if (r0 == 0) goto L_0x01cd
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x04af }
            r4.zzh()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zzb     // Catch:{ all -> 0x04af }
            java.lang.String r7 = r0.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = r2.zzr     // Catch:{ all -> 0x04af }
            java.lang.String r9 = r0.zzf()     // Catch:{ all -> 0x04af }
            boolean r4 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r4, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ all -> 0x04af }
            if (r4 == 0) goto L_0x01cd
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()     // Catch:{ all -> 0x04af }
            java.lang.String r7 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r8 = r0.zzc()     // Catch:{ all -> 0x04af }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r8)     // Catch:{ all -> 0x04af }
            r4.zza(r7, r8)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzac r4 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r7 = r0.zzc()     // Catch:{ all -> 0x04af }
            r4.zzaj()     // Catch:{ all -> 0x04af }
            r4.zzc()     // Catch:{ all -> 0x04af }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x04af }
            android.database.sqlite.SQLiteDatabase r0 = r4.mo18354c_()     // Catch:{ SQLiteException -> 0x01ba }
            java.lang.String[] r8 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x01ba }
            r8[r13] = r7     // Catch:{ SQLiteException -> 0x01ba }
            java.lang.String r9 = "events"
            java.lang.String r10 = "app_id=?"
            int r9 = r0.delete(r9, r10, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r13
            java.lang.String r10 = "user_attributes"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "apps"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "raw_events"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "raw_events_metadata"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "event_filters"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "property_filters"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "audience_filter_values"
            java.lang.String r11 = "app_id=?"
            int r10 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r10
            java.lang.String r10 = "consent_settings"
            java.lang.String r11 = "app_id=?"
            int r0 = r0.delete(r10, r11, r8)     // Catch:{ SQLiteException -> 0x01ba }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01cc
            com.google.android.gms.measurement.internal.zzex r0 = r4.zzq()     // Catch:{ SQLiteException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()     // Catch:{ SQLiteException -> 0x01ba }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01ba }
            r0.zza(r8, r7, r9)     // Catch:{ SQLiteException -> 0x01ba }
            goto L_0x01cc
        L_0x01ba:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "Error deleting application data. appId, error"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r7)     // Catch:{ all -> 0x04af }
            r4.zza(r8, r7, r0)     // Catch:{ all -> 0x04af }
        L_0x01cc:
            r0 = r3
        L_0x01cd:
            if (r0 == 0) goto L_0x0228
            long r7 = r0.zzm()     // Catch:{ all -> 0x04af }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x01e6
            long r7 = r0.zzm()     // Catch:{ all -> 0x04af }
            long r11 = r2.zzj     // Catch:{ all -> 0x04af }
            int r4 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x01e6
            r4 = 1
            goto L_0x01e7
        L_0x01e6:
            r4 = 0
        L_0x01e7:
            long r7 = r0.zzm()     // Catch:{ all -> 0x04af }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0203
            java.lang.String r7 = r0.zzl()     // Catch:{ all -> 0x04af }
            if (r7 == 0) goto L_0x0203
            java.lang.String r7 = r0.zzl()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x04af }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x04af }
            if (r7 != 0) goto L_0x0203
            r7 = 1
            goto L_0x0204
        L_0x0203:
            r7 = 0
        L_0x0204:
            r4 = r4 | r7
            if (r4 == 0) goto L_0x0228
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r4.<init>()     // Catch:{ all -> 0x04af }
            java.lang.String r7 = "_pv"
            java.lang.String r0 = r0.zzl()     // Catch:{ all -> 0x04af }
            r4.putString(r7, r0)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzar r0 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_au"
            com.google.android.gms.measurement.internal.zzam r9 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04af }
            r9.<init>(r4)     // Catch:{ all -> 0x04af }
            java.lang.String r10 = "auto"
            r7 = r0
            r11 = r5
            r7.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzar) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
        L_0x0228:
            r21.zzc(r22)     // Catch:{ all -> 0x04af }
            if (r15 != 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.String r7 = "_f"
        L_0x0235:
            com.google.android.gms.measurement.internal.zzan r0 = r0.zza((java.lang.String) r4, (java.lang.String) r7)     // Catch:{ all -> 0x04af }
            goto L_0x0246
        L_0x023a:
            if (r15 != r14) goto L_0x0245
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.String r7 = "_v"
            goto L_0x0235
        L_0x0245:
            r0 = r3
        L_0x0246:
            if (r0 != 0) goto L_0x0486
            r7 = 3600000(0x36ee80, double:1.7786363E-317)
            long r9 = r5 / r7
            r11 = 1
            long r9 = r9 + r11
            long r9 = r9 * r7
            if (r15 != 0) goto L_0x03e7
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_fot"
            java.lang.Long r4 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x04af }
            java.lang.String r15 = "auto"
            r7 = r0
            r9 = r5
            r13 = r11
            r11 = r4
            r12 = r15
            r7.<init>(r8, r9, r11, r12)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzkw) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zzb     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzar     // Catch:{ all -> 0x04af }
            boolean r0 = r0.zze(r4, r7)     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x0287
            r21.zzx()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            r0.zza(r4)     // Catch:{ all -> 0x04af }
        L_0x0287:
            r21.zzx()     // Catch:{ all -> 0x04af }
            r21.zzn()     // Catch:{ all -> 0x04af }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r4.<init>()     // Catch:{ all -> 0x04af }
            java.lang.String r0 = "_c"
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
            java.lang.String r0 = "_r"
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
            java.lang.String r0 = "_uwa"
            r7 = 0
            r4.putLong(r0, r7)     // Catch:{ all -> 0x04af }
            java.lang.String r0 = "_pfo"
            r4.putLong(r0, r7)     // Catch:{ all -> 0x04af }
            java.lang.String r0 = "_sys"
            r4.putLong(r0, r7)     // Catch:{ all -> 0x04af }
            java.lang.String r0 = "_sysu"
            r4.putLong(r0, r7)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzat     // Catch:{ all -> 0x04af }
            boolean r0 = r0.zze(r7, r8)     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x02c7
            java.lang.String r0 = "_et"
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
        L_0x02c7:
            boolean r0 = r2.zzq     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x02d0
            java.lang.String r0 = "_dac"
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
        L_0x02d0:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x04af }
            r0.zzc()     // Catch:{ all -> 0x04af }
            r0.zzaj()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "first_open_count"
            long r11 = r0.zzh(r7, r8)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            android.content.Context r0 = r0.zzm()     // Catch:{ all -> 0x04af }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04af }
            if (r0 != 0) goto L_0x030b
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r7)     // Catch:{ all -> 0x04af }
            r0.zza(r3, r7)     // Catch:{ all -> 0x04af }
            r7 = r11
        L_0x0307:
            r9 = 0
            goto L_0x03ca
        L_0x030b:
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ NameNotFoundException -> 0x031d }
            android.content.Context r0 = r0.zzm()     // Catch:{ NameNotFoundException -> 0x031d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x031d }
            java.lang.String r7 = r2.zza     // Catch:{ NameNotFoundException -> 0x031d }
            r8 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x031d }
            goto L_0x0334
        L_0x031d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r9)     // Catch:{ all -> 0x04af }
            r7.zza(r8, r9, r0)     // Catch:{ all -> 0x04af }
            r0 = r3
        L_0x0334:
            if (r0 == 0) goto L_0x0384
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04af }
            r9 = 0
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 == 0) goto L_0x0384
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04af }
            long r9 = r0.lastUpdateTime     // Catch:{ all -> 0x04af }
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0365
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzbo     // Catch:{ all -> 0x04af }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r7)     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x0360
            r7 = 0
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0363
            java.lang.String r0 = "_uwa"
        L_0x035c:
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
            goto L_0x0363
        L_0x0360:
            java.lang.String r0 = "_uwa"
            goto L_0x035c
        L_0x0363:
            r0 = 0
            goto L_0x0366
        L_0x0365:
            r0 = 1
        L_0x0366:
            com.google.android.gms.measurement.internal.zzkw r15 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_fi"
            if (r0 == 0) goto L_0x036e
            r9 = r13
            goto L_0x0370
        L_0x036e:
            r9 = 0
        L_0x0370:
            java.lang.Long r0 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x04af }
            java.lang.String r18 = "auto"
            r7 = r15
            r9 = r5
            r19 = r11
            r11 = r0
            r12 = r18
            r7.<init>(r8, r9, r11, r12)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzkw) r15, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x0386
        L_0x0384:
            r19 = r11
        L_0x0386:
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ NameNotFoundException -> 0x0398 }
            android.content.Context r0 = r0.zzm()     // Catch:{ NameNotFoundException -> 0x0398 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0398 }
            java.lang.String r7 = r2.zza     // Catch:{ NameNotFoundException -> 0x0398 }
            r8 = 0
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x0398 }
            goto L_0x03ae
        L_0x0398:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r9)     // Catch:{ all -> 0x04af }
            r7.zza(r8, r9, r0)     // Catch:{ all -> 0x04af }
        L_0x03ae:
            if (r3 == 0) goto L_0x03c6
            int r0 = r3.flags     // Catch:{ all -> 0x04af }
            r7 = 1
            r0 = r0 & r7
            if (r0 == 0) goto L_0x03bb
            java.lang.String r0 = "_sys"
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
        L_0x03bb:
            int r0 = r3.flags     // Catch:{ all -> 0x04af }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03c6
            java.lang.String r0 = "_sysu"
            r4.putLong(r0, r13)     // Catch:{ all -> 0x04af }
        L_0x03c6:
            r7 = r19
            goto L_0x0307
        L_0x03ca:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x03d3
            java.lang.String r0 = "_pfo"
            r4.putLong(r0, r7)     // Catch:{ all -> 0x04af }
        L_0x03d3:
            com.google.android.gms.measurement.internal.zzar r0 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_f"
            com.google.android.gms.measurement.internal.zzam r9 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04af }
            r9.<init>(r4)     // Catch:{ all -> 0x04af }
            java.lang.String r10 = "auto"
            r7 = r0
            r11 = r5
            r7.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzar) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x0443
        L_0x03e7:
            r13 = r11
            r3 = 1
            if (r15 != r3) goto L_0x0443
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_fvt"
            java.lang.Long r11 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x04af }
            java.lang.String r12 = "auto"
            r7 = r0
            r9 = r5
            r7.<init>(r8, r9, r11, r12)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzkw) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            r21.zzx()     // Catch:{ all -> 0x04af }
            r21.zzn()     // Catch:{ all -> 0x04af }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r0.<init>()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = "_c"
            r0.putLong(r3, r13)     // Catch:{ all -> 0x04af }
            java.lang.String r3 = "_r"
            r0.putLong(r3, r13)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzat     // Catch:{ all -> 0x04af }
            boolean r3 = r3.zze(r4, r7)     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x0427
            java.lang.String r3 = "_et"
            r0.putLong(r3, r13)     // Catch:{ all -> 0x04af }
        L_0x0427:
            boolean r3 = r2.zzq     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x0430
            java.lang.String r3 = "_dac"
            r0.putLong(r3, r13)     // Catch:{ all -> 0x04af }
        L_0x0430:
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_v"
            com.google.android.gms.measurement.internal.zzam r9 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04af }
            r9.<init>(r0)     // Catch:{ all -> 0x04af }
            java.lang.String r10 = "auto"
            r7 = r3
            r11 = r5
            r7.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzar) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
        L_0x0443:
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzau     // Catch:{ all -> 0x04af }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04af }
            if (r0 != 0) goto L_0x04a0
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r0.<init>()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = "_et"
            r0.putLong(r3, r13)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzat     // Catch:{ all -> 0x04af }
            boolean r3 = r3.zze(r4, r7)     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x0472
            java.lang.String r3 = "_fr"
            r0.putLong(r3, r13)     // Catch:{ all -> 0x04af }
        L_0x0472:
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_e"
            com.google.android.gms.measurement.internal.zzam r9 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04af }
            r9.<init>(r0)     // Catch:{ all -> 0x04af }
            java.lang.String r10 = "auto"
            r7 = r3
            r11 = r5
            r7.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x04af }
        L_0x0482:
            r1.zzb((com.google.android.gms.measurement.internal.zzar) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x04a0
        L_0x0486:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x04a0
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r0.<init>()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04af }
            java.lang.String r8 = "_cd"
            com.google.android.gms.measurement.internal.zzam r9 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04af }
            r9.<init>(r0)     // Catch:{ all -> 0x04af }
            java.lang.String r10 = "auto"
            r7 = r3
            r11 = r5
            r7.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x04af }
            goto L_0x0482
        L_0x04a0:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04af }
            r0.mo18353b_()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()
            r0.zzg()
            return
        L_0x04af:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzac r2 = r21.zze()
            r2.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzw zzw2) {
        zzn zzb2 = zzb(zzw2.zza);
        if (zzb2 != null) {
            zzb(zzw2, zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzw zzw2, zzn zzn2) {
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zze();
            try {
                zzc(zzn2);
                zzw zzd2 = zze().zzd(zzw2.zza, zzw2.zzc.zza);
                if (zzd2 != null) {
                    this.zzk.zzq().zzv().zza("Removing conditional user property", zzw2.zza, this.zzk.zzi().zzc(zzw2.zzc.zza));
                    zze().zze(zzw2.zza, zzw2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzw2.zza, zzw2.zzc.zza);
                    }
                    if (zzw2.zzk != null) {
                        Bundle bundle = null;
                        if (zzw2.zzk.zzb != null) {
                            bundle = zzw2.zzk.zzb.zzb();
                        }
                        zzc(this.zzk.zzh().zza(zzw2.zza, zzw2.zzk.zza, bundle, zzd2.zzb, zzw2.zzk.zzd, true, false, zzlj.zzb() && this.zzk.zza().zza(zzat.zzcs)), zzn2);
                    }
                } else {
                    this.zzk.zzq().zzh().zza("Conditional user property doesn't exist", zzex.zza(zzw2.zza), this.zzk.zzi().zzc(zzw2.zzc.zza));
                }
                zze().mo18353b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a8, code lost:
        if (r1.zzc() != false) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzc(com.google.android.gms.measurement.internal.zzn r7) {
        /*
            r6 = this;
            r6.zzx()
            r6.zzn()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            java.lang.String r0 = r7.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzac r0 = r6.zze()
            java.lang.String r1 = r7.zza
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzb(r1)
            com.google.android.gms.measurement.internal.zzad r1 = com.google.android.gms.measurement.internal.zzad.zza
            boolean r2 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r2 == 0) goto L_0x003e
            com.google.android.gms.measurement.internal.zzgb r2 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x003e
            java.lang.String r1 = r7.zza
            com.google.android.gms.measurement.internal.zzad r1 = r6.zza((java.lang.String) r1)
            java.lang.String r2 = r7.zzw
            com.google.android.gms.measurement.internal.zzad r2 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r2)
            com.google.android.gms.measurement.internal.zzad r1 = r1.zzb((com.google.android.gms.measurement.internal.zzad) r2)
        L_0x003e:
            boolean r2 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzgb r2 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x005c
            boolean r2 = r1.zzc()
            if (r2 == 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            java.lang.String r2 = ""
            goto L_0x0064
        L_0x005c:
            com.google.android.gms.measurement.internal.zzjv r2 = r6.zzj
            java.lang.String r3 = r7.zza
            java.lang.String r2 = r2.zza(r3)
        L_0x0064:
            boolean r3 = com.google.android.gms.internal.measurement.zzmz.zzb()
            if (r3 == 0) goto L_0x01a5
            com.google.android.gms.measurement.internal.zzgb r3 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzbp
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)
            if (r3 == 0) goto L_0x01a5
            if (r0 != 0) goto L_0x00b6
            com.google.android.gms.measurement.internal.zzf r0 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzgb r3 = r6.zzk
            java.lang.String r4 = r7.zza
            r0.<init>(r3, r4)
            boolean r3 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r3 == 0) goto L_0x00ab
            com.google.android.gms.measurement.internal.zzgb r3 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)
            if (r3 == 0) goto L_0x00ab
            boolean r3 = r1.zze()
            if (r3 == 0) goto L_0x00a4
            java.lang.String r3 = r6.zza((com.google.android.gms.measurement.internal.zzad) r1)
            r0.zza((java.lang.String) r3)
        L_0x00a4:
            boolean r1 = r1.zzc()
            if (r1 == 0) goto L_0x00fd
            goto L_0x00b2
        L_0x00ab:
            java.lang.String r1 = r6.zzz()
            r0.zza((java.lang.String) r1)
        L_0x00b2:
            r0.zze((java.lang.String) r2)
            goto L_0x00fd
        L_0x00b6:
            boolean r3 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r3 == 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzgb r3 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)
            if (r3 == 0) goto L_0x00d0
            boolean r3 = r1.zzc()
            if (r3 == 0) goto L_0x00fd
        L_0x00d0:
            java.lang.String r3 = r0.zzh()
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00fd
            r0.zze((java.lang.String) r2)
            boolean r2 = com.google.android.gms.internal.measurement.zzmb.zzb()
            if (r2 == 0) goto L_0x00f6
            com.google.android.gms.measurement.internal.zzgb r2 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcp
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x00f6
            java.lang.String r1 = r6.zza((com.google.android.gms.measurement.internal.zzad) r1)
            goto L_0x00fa
        L_0x00f6:
            java.lang.String r1 = r6.zzz()
        L_0x00fa:
            r0.zza((java.lang.String) r1)
        L_0x00fd:
            java.lang.String r1 = r7.zzb
            r0.zzb((java.lang.String) r1)
            java.lang.String r1 = r7.zzr
            r0.zzc((java.lang.String) r1)
            boolean r1 = com.google.android.gms.internal.measurement.zznq.zzb()
            if (r1 == 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzgb r1 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r1 = r1.zza()
            java.lang.String r2 = r0.zzc()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbj
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0124
            java.lang.String r1 = r7.zzv
            r0.zzd((java.lang.String) r1)
        L_0x0124:
            java.lang.String r1 = r7.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0131
            java.lang.String r1 = r7.zzk
            r0.zzf((java.lang.String) r1)
        L_0x0131:
            long r1 = r7.zze
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x013e
            long r1 = r7.zze
            r0.zzd((long) r1)
        L_0x013e:
            java.lang.String r1 = r7.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x014b
            java.lang.String r1 = r7.zzc
            r0.zzg((java.lang.String) r1)
        L_0x014b:
            long r1 = r7.zzj
            r0.zzc((long) r1)
            java.lang.String r1 = r7.zzd
            if (r1 == 0) goto L_0x0159
            java.lang.String r1 = r7.zzd
            r0.zzh((java.lang.String) r1)
        L_0x0159:
            long r1 = r7.zzf
            r0.zze((long) r1)
            boolean r1 = r7.zzh
            r0.zza((boolean) r1)
            java.lang.String r1 = r7.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0170
            java.lang.String r1 = r7.zzg
            r0.zzi((java.lang.String) r1)
        L_0x0170:
            com.google.android.gms.measurement.internal.zzgb r1 = r6.zzk
            com.google.android.gms.measurement.internal.zzy r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzcf
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x0183
            long r1 = r7.zzl
            r0.zzp(r1)
        L_0x0183:
            boolean r1 = r7.zzo
            r0.zzb((boolean) r1)
            boolean r1 = r7.zzp
            r0.zzc((boolean) r1)
            java.lang.Boolean r1 = r7.zzs
            r0.zza((java.lang.Boolean) r1)
            long r1 = r7.zzt
            r0.zzf((long) r1)
            boolean r7 = r0.zza()
            if (r7 == 0) goto L_0x01a4
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()
            r7.zza((com.google.android.gms.measurement.internal.zzf) r0)
        L_0x01a4:
            return r0
        L_0x01a5:
            com.google.android.gms.measurement.internal.zzf r7 = r6.zza((com.google.android.gms.measurement.internal.zzn) r7, (com.google.android.gms.measurement.internal.zzf) r0, (java.lang.String) r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzc(com.google.android.gms.measurement.internal.zzn):com.google.android.gms.measurement.internal.zzf");
    }

    public final zzfv zzc() {
        zzb((zzkm) this.zzb);
        return this.zzb;
    }

    public final zzfa zzd() {
        zzb((zzkm) this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzk.zzp().zza(new zzks(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzk.zzq().zze().zza("Failed to get app instance id. appId", zzex.zza(zzn2.zza), e);
            return null;
        }
    }

    public final zzac zze() {
        zzb((zzkm) this.zzd);
        return this.zzd;
    }

    public final zzo zzf() {
        zzb((zzkm) this.zzg);
        return this.zzg;
    }

    public final zzil zzg() {
        zzb((zzkm) this.zzi);
        return this.zzi;
    }

    public final zzkt zzh() {
        zzb((zzkm) this.zzh);
        return this.zzh;
    }

    public final zzjv zzi() {
        return this.zzj;
    }

    public final zzev zzj() {
        return this.zzk.zzi();
    }

    public final zzkx zzk() {
        return this.zzk.zzh();
    }

    public final Clock zzl() {
        return this.zzk.zzl();
    }

    public final Context zzm() {
        return this.zzk.zzm();
    }

    /* access modifiers changed from: package-private */
    public final void zzn() {
        if (!this.zzl) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:125|126) */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r1.zzk.zzq().zze().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzex.zza(r5), r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x0357 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02a6 A[Catch:{ all -> 0x0390 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02b7 A[Catch:{ all -> 0x0390 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02db A[Catch:{ MalformedURLException -> 0x0357 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02dd A[Catch:{ MalformedURLException -> 0x0357 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02e5 A[Catch:{ MalformedURLException -> 0x0357 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02f5 A[Catch:{ MalformedURLException -> 0x0357 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x030d A[Catch:{ MalformedURLException -> 0x0357 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x020a A[Catch:{ all -> 0x0390 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020b A[Catch:{ all -> 0x0390 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0211 A[Catch:{ all -> 0x0390 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo() {
        /*
            r17 = this;
            r1 = r17
            r17.zzx()
            r17.zzn()
            r0 = 1
            r1.zzt = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zziv r3 = r3.zzv()     // Catch:{ all -> 0x0390 }
            java.lang.Boolean r3 = r3.zzaf()     // Catch:{ all -> 0x0390 }
            if (r3 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()     // Catch:{ all -> 0x0390 }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
        L_0x0024:
            r0.zza(r3)     // Catch:{ all -> 0x0390 }
        L_0x0027:
            r1.zzt = r2
            r17.zzac()
            return
        L_0x002d:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0390 }
            if (r3 == 0) goto L_0x0040
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x0390 }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            goto L_0x0024
        L_0x0040:
            long r3 = r1.zzn     // Catch:{ all -> 0x0390 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x004c
        L_0x0048:
            r17.zzab()     // Catch:{ all -> 0x0390 }
            goto L_0x0027
        L_0x004c:
            r17.zzx()     // Catch:{ all -> 0x0390 }
            java.util.List<java.lang.Long> r3 = r1.zzw     // Catch:{ all -> 0x0390 }
            if (r3 == 0) goto L_0x0055
            r3 = 1
            goto L_0x0056
        L_0x0055:
            r3 = 0
        L_0x0056:
            if (r3 == 0) goto L_0x0065
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()     // Catch:{ all -> 0x0390 }
            java.lang.String r3 = "Uploading requested multiple times"
            goto L_0x0024
        L_0x0065:
            com.google.android.gms.measurement.internal.zzfa r3 = r17.zzd()     // Catch:{ all -> 0x0390 }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0390 }
            if (r3 != 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzgb r0 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()     // Catch:{ all -> 0x0390 }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zza(r3)     // Catch:{ all -> 0x0390 }
            goto L_0x0048
        L_0x007f:
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.common.util.Clock r3 = r3.zzl()     // Catch:{ all -> 0x0390 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzat.zzap     // Catch:{ all -> 0x0390 }
            r9 = 0
            int r7 = r7.zzb(r9, r8)     // Catch:{ all -> 0x0390 }
            long r10 = com.google.android.gms.measurement.internal.zzy.zzj()     // Catch:{ all -> 0x0390 }
            long r10 = r3 - r10
            r8 = 0
        L_0x009d:
            if (r8 >= r7) goto L_0x00a8
            boolean r12 = r1.zza((java.lang.String) r9, (long) r10)     // Catch:{ all -> 0x0390 }
            if (r12 == 0) goto L_0x00a8
            int r8 = r8 + 1
            goto L_0x009d
        L_0x00a8:
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzb()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzfn r7 = r7.zzc     // Catch:{ all -> 0x0390 }
            long r7 = r7.zza()     // Catch:{ all -> 0x0390 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00d1
            com.google.android.gms.measurement.internal.zzgb r5 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzv()     // Catch:{ all -> 0x0390 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0390 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0390 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0390 }
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzac r5 = r17.zze()     // Catch:{ all -> 0x0390 }
            java.lang.String r5 = r5.mo18355d_()     // Catch:{ all -> 0x0390 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0390 }
            r7 = -1
            if (r6 != 0) goto L_0x036c
            long r10 = r1.zzy     // Catch:{ all -> 0x0390 }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzac r6 = r17.zze()     // Catch:{ all -> 0x0390 }
            long r6 = r6.zzz()     // Catch:{ all -> 0x0390 }
            r1.zzy = r6     // Catch:{ all -> 0x0390 }
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzat.zzf     // Catch:{ all -> 0x0390 }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzat.zzg     // Catch:{ all -> 0x0390 }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x0390 }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzac r8 = r17.zze()     // Catch:{ all -> 0x0390 }
            java.util.List r6 = r8.zza((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x0390 }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0390 }
            if (r7 != 0) goto L_0x0027
            boolean r7 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0390 }
            if (r7 == 0) goto L_0x0139
            com.google.android.gms.measurement.internal.zzgb r7 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0390 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0390 }
            if (r7 == 0) goto L_0x0139
            com.google.android.gms.measurement.internal.zzad r7 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x0390 }
            boolean r7 = r7.zzc()     // Catch:{ all -> 0x0390 }
            if (r7 == 0) goto L_0x018c
        L_0x0139:
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x0390 }
        L_0x013d:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0390 }
            if (r8 == 0) goto L_0x015c
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0390 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0390 }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzg r8 = (com.google.android.gms.internal.measurement.zzcd.zzg) r8     // Catch:{ all -> 0x0390 }
            java.lang.String r10 = r8.zzad()     // Catch:{ all -> 0x0390 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0390 }
            if (r10 != 0) goto L_0x013d
            java.lang.String r7 = r8.zzad()     // Catch:{ all -> 0x0390 }
            goto L_0x015d
        L_0x015c:
            r7 = r9
        L_0x015d:
            if (r7 == 0) goto L_0x018c
            r8 = 0
        L_0x0160:
            int r10 = r6.size()     // Catch:{ all -> 0x0390 }
            if (r8 >= r10) goto L_0x018c
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x0390 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0390 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = (com.google.android.gms.internal.measurement.zzcd.zzg) r10     // Catch:{ all -> 0x0390 }
            java.lang.String r11 = r10.zzad()     // Catch:{ all -> 0x0390 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0390 }
            if (r11 != 0) goto L_0x0189
            java.lang.String r10 = r10.zzad()     // Catch:{ all -> 0x0390 }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x0390 }
            if (r10 != 0) goto L_0x0189
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x0390 }
            goto L_0x018c
        L_0x0189:
            int r8 = r8 + 1
            goto L_0x0160
        L_0x018c:
            com.google.android.gms.internal.measurement.zzcd$zzf$zza r7 = com.google.android.gms.internal.measurement.zzcd.zzf.zzb()     // Catch:{ all -> 0x0390 }
            int r8 = r6.size()     // Catch:{ all -> 0x0390 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0390 }
            int r11 = r6.size()     // Catch:{ all -> 0x0390 }
            r10.<init>(r11)     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzgb r11 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x0390 }
            boolean r11 = r11.zzh(r5)     // Catch:{ all -> 0x0390 }
            if (r11 == 0) goto L_0x01c9
            boolean r11 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0390 }
            if (r11 == 0) goto L_0x01c7
            com.google.android.gms.measurement.internal.zzgb r11 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0390 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r12)     // Catch:{ all -> 0x0390 }
            if (r11 == 0) goto L_0x01c7
            com.google.android.gms.measurement.internal.zzad r11 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x0390 }
            boolean r11 = r11.zzc()     // Catch:{ all -> 0x0390 }
            if (r11 == 0) goto L_0x01c9
        L_0x01c7:
            r11 = 1
            goto L_0x01ca
        L_0x01c9:
            r11 = 0
        L_0x01ca:
            boolean r12 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0390 }
            if (r12 == 0) goto L_0x01eb
            com.google.android.gms.measurement.internal.zzgb r12 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r12 = r12.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0390 }
            boolean r12 = r12.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r13)     // Catch:{ all -> 0x0390 }
            if (r12 == 0) goto L_0x01eb
            com.google.android.gms.measurement.internal.zzad r12 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x0390 }
            boolean r12 = r12.zzc()     // Catch:{ all -> 0x0390 }
            if (r12 == 0) goto L_0x01e9
            goto L_0x01eb
        L_0x01e9:
            r12 = 0
            goto L_0x01ec
        L_0x01eb:
            r12 = 1
        L_0x01ec:
            boolean r13 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0390 }
            if (r13 == 0) goto L_0x020d
            com.google.android.gms.measurement.internal.zzgb r13 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r13 = r13.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0390 }
            boolean r13 = r13.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r14)     // Catch:{ all -> 0x0390 }
            if (r13 == 0) goto L_0x020d
            com.google.android.gms.measurement.internal.zzad r13 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x0390 }
            boolean r13 = r13.zze()     // Catch:{ all -> 0x0390 }
            if (r13 == 0) goto L_0x020b
            goto L_0x020d
        L_0x020b:
            r13 = 0
            goto L_0x020e
        L_0x020d:
            r13 = 1
        L_0x020e:
            r14 = 0
        L_0x020f:
            if (r14 >= r8) goto L_0x0297
            java.lang.Object r15 = r6.get(r14)     // Catch:{ all -> 0x0390 }
            android.util.Pair r15 = (android.util.Pair) r15     // Catch:{ all -> 0x0390 }
            java.lang.Object r15 = r15.first     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzg r15 = (com.google.android.gms.internal.measurement.zzcd.zzg) r15     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzhv$zzb r15 = r15.zzbo()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzhv$zzb r15 = (com.google.android.gms.internal.measurement.zzhv.zzb) r15     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r15 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r15     // Catch:{ all -> 0x0390 }
            java.lang.Object r16 = r6.get(r14)     // Catch:{ all -> 0x0390 }
            r0 = r16
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x0390 }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x0390 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0390 }
            r10.add(r0)     // Catch:{ all -> 0x0390 }
            r16 = r10
            r9 = 31049(0x7949, double:1.534E-319)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r9 = r15.zzg((long) r9)     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r9 = r9.zza((long) r3)     // Catch:{ all -> 0x0390 }
            r9.zzb((boolean) r2)     // Catch:{ all -> 0x0390 }
            if (r11 != 0) goto L_0x0246
            r15.zzr()     // Catch:{ all -> 0x0390 }
        L_0x0246:
            boolean r9 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0390 }
            if (r9 == 0) goto L_0x0267
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0390 }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r10)     // Catch:{ all -> 0x0390 }
            if (r9 == 0) goto L_0x0267
            if (r12 != 0) goto L_0x0262
            r15.zzk()     // Catch:{ all -> 0x0390 }
            r15.zzl()     // Catch:{ all -> 0x0390 }
        L_0x0262:
            if (r13 != 0) goto L_0x0267
            r15.zzm()     // Catch:{ all -> 0x0390 }
        L_0x0267:
            com.google.android.gms.measurement.internal.zzgb r9 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzax     // Catch:{ all -> 0x0390 }
            boolean r9 = r9.zze(r5, r10)     // Catch:{ all -> 0x0390 }
            if (r9 == 0) goto L_0x028c
            com.google.android.gms.internal.measurement.zzjg r9 = r15.zzy()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzhv r9 = (com.google.android.gms.internal.measurement.zzhv) r9     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzg r9 = (com.google.android.gms.internal.measurement.zzcd.zzg) r9     // Catch:{ all -> 0x0390 }
            byte[] r9 = r9.zzbk()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzkt r10 = r17.zzh()     // Catch:{ all -> 0x0390 }
            long r9 = r10.zza((byte[]) r9)     // Catch:{ all -> 0x0390 }
            r15.zzl((long) r9)     // Catch:{ all -> 0x0390 }
        L_0x028c:
            r7.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r15)     // Catch:{ all -> 0x0390 }
            int r14 = r14 + 1
            r10 = r16
            r0 = 1
            r9 = 0
            goto L_0x020f
        L_0x0297:
            r16 = r10
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ all -> 0x0390 }
            r9 = 2
            boolean r6 = r6.zza((int) r9)     // Catch:{ all -> 0x0390 }
            if (r6 == 0) goto L_0x02b7
            com.google.android.gms.measurement.internal.zzkt r6 = r17.zzh()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzjg r9 = r7.zzy()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzhv r9 = (com.google.android.gms.internal.measurement.zzhv) r9     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzf r9 = (com.google.android.gms.internal.measurement.zzcd.zzf) r9     // Catch:{ all -> 0x0390 }
            java.lang.String r9 = r6.zza((com.google.android.gms.internal.measurement.zzcd.zzf) r9)     // Catch:{ all -> 0x0390 }
            goto L_0x02b8
        L_0x02b7:
            r9 = 0
        L_0x02b8:
            r17.zzh()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzjg r6 = r7.zzy()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzhv r6 = (com.google.android.gms.internal.measurement.zzhv) r6     // Catch:{ all -> 0x0390 }
            com.google.android.gms.internal.measurement.zzcd$zzf r6 = (com.google.android.gms.internal.measurement.zzcd.zzf) r6     // Catch:{ all -> 0x0390 }
            byte[] r14 = r6.zzbk()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r6 = com.google.android.gms.measurement.internal.zzat.zzp     // Catch:{ all -> 0x0390 }
            r0 = 0
            java.lang.Object r0 = r6.zza(r0)     // Catch:{ all -> 0x0390 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0390 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0357 }
            r13.<init>(r0)     // Catch:{ MalformedURLException -> 0x0357 }
            boolean r6 = r16.isEmpty()     // Catch:{ MalformedURLException -> 0x0357 }
            if (r6 != 0) goto L_0x02dd
            r6 = 1
            goto L_0x02de
        L_0x02dd:
            r6 = 0
        L_0x02de:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r6)     // Catch:{ MalformedURLException -> 0x0357 }
            java.util.List<java.lang.Long> r6 = r1.zzw     // Catch:{ MalformedURLException -> 0x0357 }
            if (r6 == 0) goto L_0x02f5
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zze()     // Catch:{ MalformedURLException -> 0x0357 }
            java.lang.String r10 = "Set uploading progress before finishing the previous upload"
            r6.zza(r10)     // Catch:{ MalformedURLException -> 0x0357 }
            goto L_0x02fe
        L_0x02f5:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0357 }
            r10 = r16
            r6.<init>(r10)     // Catch:{ MalformedURLException -> 0x0357 }
            r1.zzw = r6     // Catch:{ MalformedURLException -> 0x0357 }
        L_0x02fe:
            com.google.android.gms.measurement.internal.zzgb r6 = r1.zzk     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzfj r6 = r6.zzb()     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzfn r6 = r6.zzd     // Catch:{ MalformedURLException -> 0x0357 }
            r6.zza(r3)     // Catch:{ MalformedURLException -> 0x0357 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0315
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r7.zza((int) r2)     // Catch:{ MalformedURLException -> 0x0357 }
            java.lang.String r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x0357 }
        L_0x0315:
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzw()     // Catch:{ MalformedURLException -> 0x0357 }
            java.lang.String r6 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x0357 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x0357 }
            r4.zza(r6, r3, r7, r9)     // Catch:{ MalformedURLException -> 0x0357 }
            r3 = 1
            r1.zzs = r3     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzfa r11 = r17.zzd()     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzkr r3 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ MalformedURLException -> 0x0357 }
            r3.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x0357 }
            r11.zzc()     // Catch:{ MalformedURLException -> 0x0357 }
            r11.zzaj()     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzfu r4 = r11.zzp()     // Catch:{ MalformedURLException -> 0x0357 }
            com.google.android.gms.measurement.internal.zzfe r6 = new com.google.android.gms.measurement.internal.zzfe     // Catch:{ MalformedURLException -> 0x0357 }
            r15 = 0
            r10 = r6
            r12 = r5
            r16 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x0357 }
            r4.zzc((java.lang.Runnable) r6)     // Catch:{ MalformedURLException -> 0x0357 }
            goto L_0x0027
        L_0x0357:
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzk     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzex r3 = r3.zzq()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ all -> 0x0390 }
            java.lang.String r4 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r5)     // Catch:{ all -> 0x0390 }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x0390 }
            goto L_0x0027
        L_0x036c:
            r1.zzy = r7     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzac r0 = r17.zze()     // Catch:{ all -> 0x0390 }
            long r5 = com.google.android.gms.measurement.internal.zzy.zzj()     // Catch:{ all -> 0x0390 }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zza((long) r3)     // Catch:{ all -> 0x0390 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0390 }
            if (r3 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.zzac r3 = r17.zze()     // Catch:{ all -> 0x0390 }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzb(r0)     // Catch:{ all -> 0x0390 }
            if (r0 == 0) goto L_0x0027
            r1.zza((com.google.android.gms.measurement.internal.zzf) r0)     // Catch:{ all -> 0x0390 }
            goto L_0x0027
        L_0x0390:
            r0 = move-exception
            r1.zzt = r2
            r17.zzac()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzo():void");
    }

    public final zzfu zzp() {
        return this.zzk.zzp();
    }

    public final zzex zzq() {
        return this.zzk.zzq();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzr() {
        String str;
        zzez zzez;
        zzx();
        zzn();
        if (!this.zzm) {
            this.zzm = true;
            if (zzad()) {
                int zza2 = zza(this.zzv);
                int zzae = this.zzk.zzx().zzae();
                zzx();
                if (zza2 > zzae) {
                    zzez = this.zzk.zzq().zze();
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza2 >= zzae) {
                    return;
                } else {
                    if (zza(zzae, this.zzv)) {
                        zzez = this.zzk.zzq().zzw();
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzez = this.zzk.zzq().zze();
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzez.zza(str, Integer.valueOf(zza2), Integer.valueOf(zzae));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs() {
        this.zzq++;
    }

    public final zzx zzt() {
        return this.zzk.zzt();
    }

    /* access modifiers changed from: package-private */
    public final zzgb zzu() {
        return this.zzk;
    }
}
