package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxf extends zzaps {
    private final String zzdhn;
    private final zzapo zzgvf;
    private zzazq<JSONObject> zzgvg;
    private final JSONObject zzgvh = new JSONObject();
    @GuardedBy("this")
    private boolean zzgvi = false;

    public zzcxf(String str, zzapo zzapo, zzazq<JSONObject> zzazq) {
        this.zzgvg = zzazq;
        this.zzdhn = str;
        this.zzgvf = zzapo;
        try {
            this.zzgvh.put("adapter_version", this.zzgvf.zzul().toString());
            this.zzgvh.put("sdk_version", this.zzgvf.zzum().toString());
            this.zzgvh.put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.zzdhn);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onFailure(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzgvi     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            org.json.JSONObject r0 = r2.zzgvh     // Catch:{ JSONException -> 0x000e }
            java.lang.String r1 = "signal_error"
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x000e }
        L_0x000e:
            com.google.android.gms.internal.ads.zzazq<org.json.JSONObject> r3 = r2.zzgvg     // Catch:{ all -> 0x001a }
            org.json.JSONObject r0 = r2.zzgvh     // Catch:{ all -> 0x001a }
            r3.set(r0)     // Catch:{ all -> 0x001a }
            r3 = 1
            r2.zzgvi = r3     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxf.onFailure(java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdo(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzgvi     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.lang.String r3 = "Adapter returned null signals"
            r2.onFailure(r3)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0010:
            org.json.JSONObject r0 = r2.zzgvh     // Catch:{ JSONException -> 0x0017 }
            java.lang.String r1 = "signals"
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0017 }
        L_0x0017:
            com.google.android.gms.internal.ads.zzazq<org.json.JSONObject> r3 = r2.zzgvg     // Catch:{ all -> 0x0023 }
            org.json.JSONObject r0 = r2.zzgvh     // Catch:{ all -> 0x0023 }
            r3.set(r0)     // Catch:{ all -> 0x0023 }
            r3 = 1
            r2.zzgvi = r3     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxf.zzdo(java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(com.google.android.gms.internal.ads.zzve r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzgvi     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            org.json.JSONObject r0 = r2.zzgvh     // Catch:{ JSONException -> 0x0010 }
            java.lang.String r1 = "signal_error"
            java.lang.String r3 = r3.zzcgs     // Catch:{ JSONException -> 0x0010 }
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0010 }
        L_0x0010:
            com.google.android.gms.internal.ads.zzazq<org.json.JSONObject> r3 = r2.zzgvg     // Catch:{ all -> 0x001c }
            org.json.JSONObject r0 = r2.zzgvh     // Catch:{ all -> 0x001c }
            r3.set(r0)     // Catch:{ all -> 0x001c }
            r3 = 1
            r2.zzgvi = r3     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxf.zzg(com.google.android.gms.internal.ads.zzve):void");
    }
}
