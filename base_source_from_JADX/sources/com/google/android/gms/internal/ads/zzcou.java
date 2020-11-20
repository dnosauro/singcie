package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcou extends zzatb {
    private final Context context;
    private final Executor zzfqx;
    private final zzaty zzgoa;
    private final zzatz zzgob;
    private final zzbjl zzgoc;
    private final HashMap<String, zzcpf> zzgod;

    public zzcou(Context context2, Executor executor, zzaty zzaty, zzbjl zzbjl, zzatz zzatz, HashMap<String, zzcpf> hashMap) {
        zzabf.initialize(context2);
        this.context = context2;
        this.zzfqx = executor;
        this.zzgoa = zzaty;
        this.zzgob = zzatz;
        this.zzgoc = zzbjl;
        this.zzgod = hashMap;
    }

    private static zzdyz<JSONObject> zza(zzatl zzatl, zzdro zzdro, zzdga zzdga) {
        zzcoy zzcoy = new zzcoy(zzdga);
        return zzdro.zza(zzdrl.GMS_SIGNALS, zzdyr.zzag(zzatl.zzdvx)).zza(zzcoy).zzb(zzcox.zzgmk).zzaww();
    }

    private static zzdyz<zzatr> zza(zzdyz<JSONObject> zzdyz, zzdro zzdro, zzaml zzaml) {
        return zzdro.zza(zzdrl.BUILD_URL, zzdyz).zza(zzaml.zza("AFMA_getAdDictionary", zzamg.zzdjy, zzcpa.zzdka)).zzaww();
    }

    private final void zza(zzdyz<InputStream> zzdyz, zzatf zzatf) {
        zzdyr.zza(zzdyr.zzb(zzdyz, new zzcpe(this), (Executor) zzazj.zzegp), new zzcpg(this, zzatf), zzazj.zzegu);
    }

    public final zzasu zza(zzass zzass) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzdyz zzdyz, zzdyz zzdyz2) {
        String zzvy = ((zzatr) zzdyz.get()).zzvy();
        this.zzgod.put(zzvy, new zzcpf((zzatr) zzdyz.get(), (JSONObject) zzdyz2.get()));
        return new ByteArrayInputStream(zzvy.getBytes(zzdvk.UTF_8));
    }

    public final void zza(zzass zzass, zzatd zzatd) {
    }

    public final void zza(zzatl zzatl, zzatf zzatf) {
        zzdyz<InputStream> zzb = zzb(zzatl, Binder.getCallingUid());
        zza(zzb, zzatf);
        zzb.addListener(new zzcoz(this), this.zzfqx);
    }

    public final void zza(String str, zzatf zzatf) {
        zza(zzgj(str), zzatf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzarb() {
        zzazm.zza(this.zzgob.zzwa(), "persistFlags");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdyz<java.io.InputStream> zzb(com.google.android.gms.internal.ads.zzatl r11, int r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzamc r0 = com.google.android.gms.ads.internal.zzp.zzld()
            android.content.Context r1 = r10.context
            com.google.android.gms.internal.ads.zzazh r2 = com.google.android.gms.internal.ads.zzazh.zzzi()
            com.google.android.gms.internal.ads.zzaml r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzbjl r1 = r10.zzgoc
            com.google.android.gms.internal.ads.zzdga r1 = r1.zza(r11, r12)
            java.lang.String r2 = "google.afma.response.normalize"
            com.google.android.gms.internal.ads.zzame<com.google.android.gms.internal.ads.zzcpi> r3 = com.google.android.gms.internal.ads.zzcpi.zzgol
            com.google.android.gms.internal.ads.zzamf<java.io.InputStream> r4 = com.google.android.gms.internal.ads.zzamg.zzdjz
            com.google.android.gms.internal.ads.zzamd r2 = r0.zza(r2, r3, r4)
            com.google.android.gms.internal.ads.zzcpj r9 = new com.google.android.gms.internal.ads.zzcpj
            android.content.Context r4 = r10.context
            com.google.android.gms.internal.ads.zzazh r3 = r11.zzdsm
            java.lang.String r5 = r3.zzbrf
            com.google.android.gms.internal.ads.zzaty r6 = r10.zzgoa
            java.lang.String r7 = r11.zzdtm
            r3 = r9
            r8 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            com.google.android.gms.internal.ads.zzdro r12 = r1.zzagn()
            com.google.android.gms.internal.ads.zzacn<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzadf.zzddc
            java.lang.Object r3 = r3.get()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = 0
            if (r3 != 0) goto L_0x0054
            java.lang.String r3 = r11.zzdwb
            if (r3 == 0) goto L_0x0070
            java.lang.String r3 = r11.zzdwb
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0070
            java.lang.String r3 = "Request contained a PoolKey but split request is disabled."
        L_0x0050:
            com.google.android.gms.ads.internal.util.zzd.zzee(r3)
            goto L_0x0070
        L_0x0054:
            java.lang.String r3 = r11.zzdwb
            if (r3 == 0) goto L_0x0070
            java.lang.String r3 = r11.zzdwb
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0070
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzcpf> r3 = r10.zzgod
            java.lang.String r4 = r11.zzdwb
            java.lang.Object r3 = r3.remove(r4)
            r4 = r3
            com.google.android.gms.internal.ads.zzcpf r4 = (com.google.android.gms.internal.ads.zzcpf) r4
            if (r4 != 0) goto L_0x0070
            java.lang.String r3 = "Request contained a PoolKey but no matching parameters were found."
            goto L_0x0050
        L_0x0070:
            r3 = 1
            r5 = 0
            r6 = 2
            if (r4 != 0) goto L_0x00bb
            com.google.android.gms.internal.ads.zzdyz r11 = zza((com.google.android.gms.internal.ads.zzatl) r11, (com.google.android.gms.internal.ads.zzdro) r12, (com.google.android.gms.internal.ads.zzdga) r1)
            com.google.android.gms.internal.ads.zzdyz r0 = zza((com.google.android.gms.internal.ads.zzdyz<org.json.JSONObject>) r11, (com.google.android.gms.internal.ads.zzdro) r12, (com.google.android.gms.internal.ads.zzaml) r0)
            com.google.android.gms.internal.ads.zzdrl r1 = com.google.android.gms.internal.ads.zzdrl.HTTP
            com.google.android.gms.internal.ads.zzdyz[] r4 = new com.google.android.gms.internal.ads.zzdyz[r6]
            r4[r5] = r0
            r4[r3] = r11
            com.google.android.gms.internal.ads.zzdrc r1 = r12.zza(r1, (com.google.android.gms.internal.ads.zzdyz<?>[]) r4)
            com.google.android.gms.internal.ads.zzcot r4 = new com.google.android.gms.internal.ads.zzcot
            r4.<init>(r11, r0)
            com.google.android.gms.internal.ads.zzdrg r1 = r1.zzb(r4)
            com.google.android.gms.internal.ads.zzdrg r1 = r1.zzb(r9)
            com.google.android.gms.internal.ads.zzdqx r1 = r1.zzaww()
            com.google.android.gms.internal.ads.zzdrl r4 = com.google.android.gms.internal.ads.zzdrl.PRE_PROCESS
            r7 = 3
            com.google.android.gms.internal.ads.zzdyz[] r7 = new com.google.android.gms.internal.ads.zzdyz[r7]
            r7[r5] = r11
            r7[r3] = r0
            r7[r6] = r1
            com.google.android.gms.internal.ads.zzdrc r12 = r12.zza(r4, (com.google.android.gms.internal.ads.zzdyz<?>[]) r7)
            com.google.android.gms.internal.ads.zzcow r3 = new com.google.android.gms.internal.ads.zzcow
            r3.<init>(r1, r11, r0)
            com.google.android.gms.internal.ads.zzdrg r11 = r12.zzb(r3)
        L_0x00b2:
            com.google.android.gms.internal.ads.zzdrg r11 = r11.zza(r2)
            com.google.android.gms.internal.ads.zzdqx r11 = r11.zzaww()
            return r11
        L_0x00bb:
            com.google.android.gms.internal.ads.zzcpm r11 = new com.google.android.gms.internal.ads.zzcpm
            org.json.JSONObject r0 = r4.zzgoi
            com.google.android.gms.internal.ads.zzatr r1 = r4.zzgoh
            r11.<init>(r0, r1)
            com.google.android.gms.internal.ads.zzdrl r0 = com.google.android.gms.internal.ads.zzdrl.HTTP
            com.google.android.gms.internal.ads.zzdyz r11 = com.google.android.gms.internal.ads.zzdyr.zzag(r11)
            com.google.android.gms.internal.ads.zzdrg r11 = r12.zza(r0, r11)
            com.google.android.gms.internal.ads.zzdrg r11 = r11.zzb(r9)
            com.google.android.gms.internal.ads.zzdqx r11 = r11.zzaww()
            com.google.android.gms.internal.ads.zzdyz r0 = com.google.android.gms.internal.ads.zzdyr.zzag(r4)
            com.google.android.gms.internal.ads.zzdrl r1 = com.google.android.gms.internal.ads.zzdrl.PRE_PROCESS
            com.google.android.gms.internal.ads.zzdyz[] r4 = new com.google.android.gms.internal.ads.zzdyz[r6]
            r4[r5] = r11
            r4[r3] = r0
            com.google.android.gms.internal.ads.zzdrc r12 = r12.zza(r1, (com.google.android.gms.internal.ads.zzdyz<?>[]) r4)
            com.google.android.gms.internal.ads.zzcov r1 = new com.google.android.gms.internal.ads.zzcov
            r1.<init>(r11, r0)
            com.google.android.gms.internal.ads.zzdrg r11 = r12.zzb(r1)
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcou.zzb(com.google.android.gms.internal.ads.zzatl, int):com.google.android.gms.internal.ads.zzdyz");
    }

    public final void zzb(zzatl zzatl, zzatf zzatf) {
        zza(zzd(zzatl, Binder.getCallingUid()), zzatf);
    }

    public final zzdyz<InputStream> zzc(zzatl zzatl, int i) {
        if (!zzadf.zzddc.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        if (zzatl.zzdwa == null) {
            return zzdyr.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzatl.zzdwa.zzhln == 0 || zzatl.zzdwa.zzhlo == 0) {
            return zzdyr.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzaml zza = zzp.zzld().zza(this.context, zzazh.zzzi());
        zzdga zza2 = this.zzgoc.zza(zzatl, i);
        zzdro zzagn = zza2.zzagn();
        zzdyz<JSONObject> zza3 = zza(zzatl, zzagn, zza2);
        zzdyz<zzatr> zza4 = zza(zza3, zzagn, zza);
        return zzagn.zza(zzdrl.GET_URL_AND_CACHE_KEY, (zzdyz<?>[]) new zzdyz[]{zza3, zza4}).zzb(new zzcpc(this, zza4, zza3)).zzaww();
    }

    public final void zzc(zzatl zzatl, zzatf zzatf) {
        zza(zzc(zzatl, Binder.getCallingUid()), zzatf);
    }

    public final zzdyz<InputStream> zzd(zzatl zzatl, int i) {
        zzaml zza = zzp.zzld().zza(this.context, zzazh.zzzi());
        if (!zzadl.zzddt.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdga zza2 = this.zzgoc.zza(zzatl, i);
        zzdfl<JSONObject> zzagm = zza2.zzagm();
        return zza2.zzagn().zza(zzdrl.GET_SIGNALS, zzdyr.zzag(zzatl.zzdvx)).zza(new zzcpb(zzagm)).zzw(zzdrl.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzamg.zzdjy, zzamg.zzdjz)).zzaww();
    }

    public final zzdyz<InputStream> zzgj(String str) {
        if (!zzadf.zzddc.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcpd zzcpd = new zzcpd(this);
        if (this.zzgod.remove(str) != null) {
            return zzdyr.zzag(zzcpd);
        }
        String valueOf = String.valueOf(str);
        return zzdyr.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }
}
