package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import com.parse.ParseQuery;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzfa {
    private static final String TAG = "zzfa";
    protected Context context;
    private volatile boolean zzwn;
    private zzey zzym;
    private ExecutorService zzyv;
    private DexClassLoader zzyw;
    private zzeh zzyx;
    private byte[] zzyy;
    private volatile AdvertisingIdClient zzyz = null;
    private Future zzza;
    private boolean zzzb;
    /* access modifiers changed from: private */
    public volatile zzcf.zza zzzc;
    private Future zzzd;
    private zzdt zzze;
    private boolean zzzf;
    private boolean zzzg;
    private Map<Pair<String, String>, zzgj> zzzh;
    private boolean zzzi;

    private zzfa(Context context2) {
        boolean z = false;
        this.zzwn = false;
        this.zzza = null;
        this.zzzc = null;
        this.zzzd = null;
        this.zzzf = false;
        this.zzzg = false;
        this.zzzi = false;
        Context applicationContext = context2.getApplicationContext();
        this.zzzb = applicationContext != null ? true : z;
        this.context = this.zzzb ? applicationContext : context2;
        this.zzzh = new HashMap();
        if (this.zzym == null) {
            this.zzym = new zzey(this.context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(29:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|27|28|29|(2:31|(1:33)(2:34|35))|36|(1:38)|39|40|41|42|43|44|45) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ zzek -> 0x0133, zzet -> 0x013a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[Catch:{ all -> 0x0100, FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2 A[Catch:{ all -> 0x0100, FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfa zza(android.content.Context r8, java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
            com.google.android.gms.internal.ads.zzfa r0 = new com.google.android.gms.internal.ads.zzfa
            r0.<init>(r8)
            com.google.android.gms.internal.ads.zzez r8 = new com.google.android.gms.internal.ads.zzez     // Catch:{ zzet -> 0x013a }
            r8.<init>()     // Catch:{ zzet -> 0x013a }
            java.util.concurrent.ExecutorService r8 = java.util.concurrent.Executors.newCachedThreadPool(r8)     // Catch:{ zzet -> 0x013a }
            r0.zzyv = r8     // Catch:{ zzet -> 0x013a }
            r0.zzwn = r11     // Catch:{ zzet -> 0x013a }
            if (r11 == 0) goto L_0x0021
            java.util.concurrent.ExecutorService r8 = r0.zzyv     // Catch:{ zzet -> 0x013a }
            com.google.android.gms.internal.ads.zzfc r11 = new com.google.android.gms.internal.ads.zzfc     // Catch:{ zzet -> 0x013a }
            r11.<init>(r0)     // Catch:{ zzet -> 0x013a }
            java.util.concurrent.Future r8 = r8.submit(r11)     // Catch:{ zzet -> 0x013a }
            r0.zzza = r8     // Catch:{ zzet -> 0x013a }
        L_0x0021:
            java.util.concurrent.ExecutorService r8 = r0.zzyv     // Catch:{ zzet -> 0x013a }
            com.google.android.gms.internal.ads.zzfe r11 = new com.google.android.gms.internal.ads.zzfe     // Catch:{ zzet -> 0x013a }
            r11.<init>(r0)     // Catch:{ zzet -> 0x013a }
            r8.execute(r11)     // Catch:{ zzet -> 0x013a }
            r8 = 1
            r11 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ Throwable -> 0x004b }
            android.content.Context r2 = r0.context     // Catch:{ Throwable -> 0x004b }
            int r2 = r1.getApkVersion(r2)     // Catch:{ Throwable -> 0x004b }
            if (r2 <= 0) goto L_0x003b
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            r0.zzzf = r2     // Catch:{ Throwable -> 0x004b }
            android.content.Context r2 = r0.context     // Catch:{ Throwable -> 0x004b }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ Throwable -> 0x004b }
            if (r1 != 0) goto L_0x0048
            r1 = 1
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            r0.zzzg = r1     // Catch:{ Throwable -> 0x004b }
        L_0x004b:
            r0.zza((int) r11, (boolean) r8)     // Catch:{ zzet -> 0x013a }
            boolean r1 = com.google.android.gms.internal.ads.zzff.isMainThread()     // Catch:{ zzet -> 0x013a }
            if (r1 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzcrh     // Catch:{ zzet -> 0x013a }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzet -> 0x013a }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ zzet -> 0x013a }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzet -> 0x013a }
            boolean r1 = r1.booleanValue()     // Catch:{ zzet -> 0x013a }
            if (r1 != 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ zzet -> 0x013a }
            java.lang.String r9 = "Task Context initialization must not be called from the UI thread."
            r8.<init>(r9)     // Catch:{ zzet -> 0x013a }
            throw r8     // Catch:{ zzet -> 0x013a }
        L_0x006f:
            com.google.android.gms.internal.ads.zzeh r1 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzet -> 0x013a }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzet -> 0x013a }
            r0.zzyx = r1     // Catch:{ zzet -> 0x013a }
            com.google.android.gms.internal.ads.zzeh r1 = r0.zzyx     // Catch:{ zzek -> 0x0133 }
            byte[] r9 = r1.zzao(r9)     // Catch:{ zzek -> 0x0133 }
            r0.zzyy = r9     // Catch:{ zzek -> 0x0133 }
            android.content.Context r9 = r0.context     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.io.File r9 = r9.getCacheDir()     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            if (r9 != 0) goto L_0x0098
            android.content.Context r9 = r0.context     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r1 = "dex"
            java.io.File r9 = r9.getDir(r1, r11)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            if (r9 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            com.google.android.gms.internal.ads.zzet r8 = new com.google.android.gms.internal.ads.zzet     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            throw r8     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
        L_0x0098:
            java.lang.String r1 = "1596060835607"
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r4 = "%s/%s.jar"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r6[r11] = r9     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r6[r8] = r1     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r4 = java.lang.String.format(r4, r6)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            boolean r4 = r3.exists()     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            if (r4 != 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzeh r4 = r0.zzyx     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            byte[] r6 = r0.zzyy     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            byte[] r10 = r4.zza(r6, r10)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            int r6 = r10.length     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r4.write(r10, r11, r6)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
        L_0x00c9:
            r0.zzb((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            dalvik.system.DexClassLoader r10 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = r3.getAbsolutePath()     // Catch:{ all -> 0x0100 }
            java.lang.String r6 = r9.getAbsolutePath()     // Catch:{ all -> 0x0100 }
            android.content.Context r7 = r0.context     // Catch:{ all -> 0x0100 }
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch:{ all -> 0x0100 }
            r10.<init>(r4, r6, r2, r7)     // Catch:{ all -> 0x0100 }
            r0.zzyw = r10     // Catch:{ all -> 0x0100 }
            zzc(r3)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r0.zza((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r10 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r2[r11] = r9     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r2[r8] = r1     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r9 = java.lang.String.format(r10, r2)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            zzap(r9)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            com.google.android.gms.internal.ads.zzdt r9 = new com.google.android.gms.internal.ads.zzdt     // Catch:{ zzet -> 0x013a }
            r9.<init>(r0)     // Catch:{ zzet -> 0x013a }
            r0.zzze = r9     // Catch:{ zzet -> 0x013a }
            r0.zzzi = r8     // Catch:{ zzet -> 0x013a }
            goto L_0x013a
        L_0x0100:
            r10 = move-exception
            zzc(r3)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r0.zza((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r2 = "%s/%s.dex"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r3[r11] = r9     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            r3[r8] = r1     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            zzap(r8)     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
            throw r10     // Catch:{ FileNotFoundException -> 0x012c, IOException -> 0x0125, zzek -> 0x011e, NullPointerException -> 0x0117 }
        L_0x0117:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzet r9 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x013a }
            r9.<init>(r8)     // Catch:{ zzet -> 0x013a }
            throw r9     // Catch:{ zzet -> 0x013a }
        L_0x011e:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzet r9 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x013a }
            r9.<init>(r8)     // Catch:{ zzet -> 0x013a }
            throw r9     // Catch:{ zzet -> 0x013a }
        L_0x0125:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzet r9 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x013a }
            r9.<init>(r8)     // Catch:{ zzet -> 0x013a }
            throw r9     // Catch:{ zzet -> 0x013a }
        L_0x012c:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzet r9 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x013a }
            r9.<init>(r8)     // Catch:{ zzet -> 0x013a }
            throw r9     // Catch:{ zzet -> 0x013a }
        L_0x0133:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzet r9 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x013a }
            r9.<init>(r8)     // Catch:{ zzet -> 0x013a }
            throw r9     // Catch:{ zzet -> 0x013a }
        L_0x013a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfa.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzfa");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c4 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d6 A[SYNTHETIC, Splitter:B:39:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db A[SYNTHETIC, Splitter:B:43:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5 A[SYNTHETIC, Splitter:B:52:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ea A[SYNTHETIC, Splitter:B:56:0x00ea] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r8, java.lang.String r9) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "%s/%s.tmp"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r8
            r5 = 1
            r3[r5] = r9
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r8
            r2[r5] = r9
            java.lang.String r8 = java.lang.String.format(r3, r2)
            r1.<init>(r8)
            boolean r8 = r1.exists()
            if (r8 != 0) goto L_0x0033
            return
        L_0x0033:
            long r2 = r1.length()
            r5 = 0
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x003e
            return
        L_0x003e:
            int r8 = (int) r2
            byte[] r8 = new byte[r8]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d2 }
            r3.<init>(r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d2 }
            int r5 = r3.read(r8)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            if (r5 > 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            zzc(r1)
            return
        L_0x0054:
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = "test"
            r5.print(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = "test"
            r5.print(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = "test"
            r5.print(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r5 = com.google.android.gms.internal.ads.zzcf.zzc.zzbe()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzeiu r6 = com.google.android.gms.internal.ads.zzeiu.zzt(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r5 = r5.zzd(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r9 = r9.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzeiu r9 = com.google.android.gms.internal.ads.zzeiu.zzt(r9)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r9 = r5.zzc(r9)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzeh r5 = r7.zzyx     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r6 = r7.zzyy     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r8 = r5.zzb(r6, r8)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r8 = r8.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzeiu r5 = com.google.android.gms.internal.ads.zzeiu.zzt(r8)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r5 = r9.zza(r5)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r8 = com.google.android.gms.internal.ads.zzcx.zzb(r8)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzeiu r8 = com.google.android.gms.internal.ads.zzeiu.zzt(r8)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            r5.zzb(r8)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            r0.createNewFile()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            r8.<init>(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzels r9 = r9.zzbhv()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            com.google.android.gms.internal.ads.zzekh r9 = (com.google.android.gms.internal.ads.zzekh) r9     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            com.google.android.gms.internal.ads.zzcf$zzc r9 = (com.google.android.gms.internal.ads.zzcf.zzc) r9     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            byte[] r9 = r9.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            int r0 = r9.length     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            r8.write(r9, r4, r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            r8.close()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            r3.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00c4:
            r8.close()     // Catch:{ IOException -> 0x00c7 }
        L_0x00c7:
            zzc(r1)
            return
        L_0x00cb:
            r9 = move-exception
            r2 = r8
            goto L_0x00d4
        L_0x00ce:
            r2 = r8
            goto L_0x00e3
        L_0x00d0:
            r9 = move-exception
            goto L_0x00d4
        L_0x00d2:
            r9 = move-exception
            r3 = r2
        L_0x00d4:
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00d9:
            if (r2 == 0) goto L_0x00de
            r2.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            zzc(r1)
            throw r9
        L_0x00e2:
            r3 = r2
        L_0x00e3:
            if (r3 == 0) goto L_0x00e8
            r3.close()     // Catch:{ IOException -> 0x00e8 }
        L_0x00e8:
            if (r2 == 0) goto L_0x00ed
            r2.close()     // Catch:{ IOException -> 0x00ed }
        L_0x00ed:
            zzc(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfa.zza(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzcf.zza zza) {
        if (i < 4) {
            return zza == null || !zza.zzaj() || zza.zzaf().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zza.zzao() || !zza.zzap().zzbg() || zza.zzap().zzbh() == -2;
        }
        return false;
    }

    private static void zzap(String str) {
        zzc(new File(str));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2 A[SYNTHETIC, Splitter:B:52:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7 A[SYNTHETIC, Splitter:B:56:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ee A[SYNTHETIC, Splitter:B:64:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC, Splitter:B:68:0x00f3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "%s/%s.tmp"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x001b
            return r4
        L_0x001b:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = java.lang.String.format(r3, r2)
            r1.<init>(r10)
            boolean r10 = r1.exists()
            if (r10 == 0) goto L_0x0033
            return r4
        L_0x0033:
            r10 = 0
            long r2 = r0.length()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0042
            zzc(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            return r4
        L_0x0042:
            int r3 = (int) r2     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            byte[] r2 = new byte[r3]     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            r3.<init>(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            int r6 = r3.read(r2)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r6 > 0) goto L_0x005e
            java.lang.String r11 = TAG     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            zzc(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r3.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r4
        L_0x005e:
            com.google.android.gms.internal.ads.zzeju r6 = com.google.android.gms.internal.ads.zzeju.zzbhf()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzcf$zzc r2 = com.google.android.gms.internal.ads.zzcf.zzc.zzb((byte[]) r2, (com.google.android.gms.internal.ads.zzeju) r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzeiu r7 = r2.zzbc()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r6.<init>(r7)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r11 = r11.equals(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r11 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzeiu r11 = r2.zzbb()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzeiu r6 = r2.zzba()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = com.google.android.gms.internal.ads.zzcx.zzb(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r11 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzeiu r11 = r2.zzbd()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = r6.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r11 != 0) goto L_0x00a8
            goto L_0x00d5
        L_0x00a8:
            com.google.android.gms.internal.ads.zzeh r11 = r9.zzyx     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r0 = r9.zzyy     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzeiu r2 = r2.zzba()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r2 = r2.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r6.<init>(r2)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r11 = r11.zza(r0, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r1.createNewFile()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r0.<init>(r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            int r10 = r11.length     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00d0 }
            r0.write(r11, r4, r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00d0 }
            r3.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            return r5
        L_0x00d0:
            r11 = move-exception
            r10 = r0
            goto L_0x00e0
        L_0x00d3:
            r10 = r0
            goto L_0x00ec
        L_0x00d5:
            zzc(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r3.close()     // Catch:{ IOException -> 0x00db }
        L_0x00db:
            return r4
        L_0x00dc:
            r11 = move-exception
            goto L_0x00e0
        L_0x00de:
            r11 = move-exception
            r3 = r10
        L_0x00e0:
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ IOException -> 0x00e5 }
        L_0x00e5:
            if (r10 == 0) goto L_0x00ea
            r10.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            throw r11
        L_0x00eb:
            r3 = r10
        L_0x00ec:
            if (r3 == 0) goto L_0x00f1
            r3.close()     // Catch:{ IOException -> 0x00f1 }
        L_0x00f1:
            if (r10 == 0) goto L_0x00f6
            r10.close()     // Catch:{ IOException -> 0x00f6 }
        L_0x00f6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfa.zzb(java.io.File, java.lang.String):boolean");
    }

    private static void zzc(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* access modifiers changed from: private */
    public final void zzcq() {
        try {
            if (this.zzyz == null && this.zzzb) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.context);
                advertisingIdClient.start();
                this.zzyz = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzyz = null;
        }
    }

    private final zzcf.zza zzcr() {
        try {
            return zzdsp.zzj(this.context, this.context.getPackageName(), Integer.toString(this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isInitialized() {
        return this.zzzi;
    }

    public final Method zza(String str, String str2) {
        zzgj zzgj = this.zzzh.get(new Pair(str, str2));
        if (zzgj == null) {
            return null;
        }
        return zzgj.zzdb();
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, boolean z) {
        if (this.zzzg) {
            Future<?> submit = this.zzyv.submit(new zzfb(this, i, z));
            if (i == 0) {
                this.zzzd = submit;
            }
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzzh.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzzh.put(new Pair(str, str2), new zzgj(this, str, str2, clsArr));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzcf.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * ParseQuery.MAX_LIMIT));
            } catch (InterruptedException unused) {
            }
        }
        return zzcr();
    }

    public final int zzbu() {
        if (this.zzze != null) {
            return zzdt.zzbu();
        }
        return Integer.MIN_VALUE;
    }

    public final boolean zzcf() {
        return this.zzym.zzcf();
    }

    public final ExecutorService zzcg() {
        return this.zzyv;
    }

    public final DexClassLoader zzch() {
        return this.zzyw;
    }

    public final zzeh zzci() {
        return this.zzyx;
    }

    public final byte[] zzcj() {
        return this.zzyy;
    }

    public final boolean zzck() {
        return this.zzzf;
    }

    public final zzdt zzcl() {
        return this.zzze;
    }

    public final boolean zzcm() {
        return this.zzzg;
    }

    /* access modifiers changed from: package-private */
    public final zzey zzcn() {
        return this.zzym;
    }

    public final zzcf.zza zzco() {
        return this.zzzc;
    }

    public final Future zzcp() {
        return this.zzzd;
    }

    public final AdvertisingIdClient zzcs() {
        if (!this.zzwn) {
            return null;
        }
        if (this.zzyz != null) {
            return this.zzyz;
        }
        Future future = this.zzza;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzza = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzza.cancel(true);
            }
        }
        return this.zzyz;
    }
}
