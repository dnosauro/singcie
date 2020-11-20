package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzabi {
    @VisibleForTesting
    private Context context;
    private File file;
    @VisibleForTesting
    private String zzbrf;
    @VisibleForTesting
    private BlockingQueue<zzabs> zzczh = new ArrayBlockingQueue(100);
    @VisibleForTesting
    private LinkedHashMap<String, String> zzczi = new LinkedHashMap<>();
    @VisibleForTesting
    private Map<String, zzabm> zzczj = new HashMap();
    @VisibleForTesting
    private String zzczk;
    private final HashSet<String> zzczl = new HashSet<>(Arrays.asList(new String[]{"noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"}));
    private AtomicBoolean zzczm;

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8 A[SYNTHETIC, Splitter:B:38:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5 A[SYNTHETIC, Splitter:B:43:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.Map<java.lang.String, java.lang.String> r4, com.google.android.gms.internal.ads.zzabv r5) {
        /*
            r3 = this;
            java.lang.String r0 = r3.zzczk
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0012:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r0.appendQueryParameter(r2, r1)
            goto L_0x0012
        L_0x002e:
            android.net.Uri r4 = r0.build()
            java.lang.String r4 = r4.toString()
            if (r5 != 0) goto L_0x0039
            goto L_0x006e
        L_0x0039:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r4 = r5.zzsa()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0054
            java.lang.String r4 = "&it="
            r0.append(r4)
            java.lang.String r4 = r5.zzsa()
            r0.append(r4)
        L_0x0054:
            java.lang.String r4 = r5.zzsb()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x006a
            java.lang.String r4 = "&blat="
            r0.append(r4)
            java.lang.String r4 = r5.zzsb()
            r0.append(r4)
        L_0x006a:
            java.lang.String r4 = r0.toString()
        L_0x006e:
            java.util.concurrent.atomic.AtomicBoolean r5 = r3.zzczm
            boolean r5 = r5.get()
            if (r5 == 0) goto L_0x00c6
            java.io.File r5 = r3.file
            if (r5 == 0) goto L_0x00c0
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a0 }
            r2 = 1
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x00a0 }
            byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r1.write(r4)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r4 = 10
            r1.write(r4)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r1.close()     // Catch:{ IOException -> 0x0091 }
            return
        L_0x0091:
            r4 = move-exception
            java.lang.String r5 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.zzd.zzd(r5, r4)
            return
        L_0x0098:
            r4 = move-exception
            r0 = r1
            goto L_0x00b3
        L_0x009b:
            r4 = move-exception
            r0 = r1
            goto L_0x00a1
        L_0x009e:
            r4 = move-exception
            goto L_0x00b3
        L_0x00a0:
            r4 = move-exception
        L_0x00a1:
            java.lang.String r5 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.zzd.zzd(r5, r4)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x00b2
            r0.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b2
        L_0x00ac:
            r4 = move-exception
            java.lang.String r5 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.zzd.zzd(r5, r4)
        L_0x00b2:
            return
        L_0x00b3:
            if (r0 == 0) goto L_0x00bf
            r0.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00bf
        L_0x00b9:
            r5 = move-exception
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.zzd.zzd(r0, r5)
        L_0x00bf:
            throw r4
        L_0x00c0:
            java.lang.String r4 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.ads.internal.util.zzd.zzfa(r4)
            return
        L_0x00c6:
            com.google.android.gms.ads.internal.zzp.zzkq()
            android.content.Context r5 = r3.context
            java.lang.String r0 = r3.zzbrf
            com.google.android.gms.ads.internal.util.zzm.zzb(r5, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabi.zza(java.util.Map, com.google.android.gms.internal.ads.zzabv):void");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzcq(str).zzg(str2, (String) next.getValue()));
        }
        return linkedHashMap;
    }

    public final void zza(Context context2, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.context = context2;
        this.zzbrf = str;
        this.zzczk = str2;
        this.zzczm = new AtomicBoolean(false);
        this.zzczm.set(zzacx.zzdcc.get().booleanValue());
        if (this.zzczm.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.zzczi.put((String) next.getKey(), (String) next.getValue());
        }
        zzazj.zzegp.execute(new zzabl(this));
        this.zzczj.put("action", zzabm.zzczq);
        this.zzczj.put("ad_format", zzabm.zzczq);
        this.zzczj.put("e", zzabm.zzczr);
    }

    public final boolean zza(zzabs zzabs) {
        return this.zzczh.offer(zzabs);
    }

    public final zzabm zzcq(String str) {
        zzabm zzabm = this.zzczj.get(str);
        return zzabm != null ? zzabm : zzabm.zzczp;
    }

    public final void zzcr(String str) {
        if (!this.zzczl.contains(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdkVersion", this.zzbrf);
            linkedHashMap.put("ue", str);
            zza(zza((Map<String, String>) this.zzczi, (Map<String, String>) linkedHashMap), (zzabv) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzrr() {
        while (true) {
            try {
                zzabs take = this.zzczh.take();
                zzabv zzrw = take.zzrw();
                if (zzrw != null && !TextUtils.isEmpty(zzrw.zzsa())) {
                    zza(zza((Map<String, String>) this.zzczi, take.zzrx()), zzrw);
                }
            } catch (InterruptedException e) {
                zzd.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }
}
