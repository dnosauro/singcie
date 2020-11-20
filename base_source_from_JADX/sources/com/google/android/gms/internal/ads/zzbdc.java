package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

public final class zzbdc implements zzahv<zzbbe> {
    private static Integer zza(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzd.zzfa(sb.toString());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.lang.Object r11, java.util.Map r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzbbe r11 = (com.google.android.gms.internal.ads.zzbbe) r11
            r0 = 3
            boolean r0 = com.google.android.gms.ads.internal.util.zzd.isLoggable(r0)
            if (r0 == 0) goto L_0x0035
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r12)
            java.lang.String r1 = "google.afma.Notify_dt"
            r0.remove(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 15
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Precache GMSG: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzeb(r0)
        L_0x0035:
            com.google.android.gms.ads.internal.zzp.zzlm()
            java.lang.String r0 = "abort"
            boolean r0 = r12.containsKey(r0)
            if (r0 == 0) goto L_0x004c
            boolean r11 = com.google.android.gms.internal.ads.zzbcu.zzc(r11)
            if (r11 != 0) goto L_0x004b
            java.lang.String r11 = "Precache abort but no precache task running."
            com.google.android.gms.ads.internal.util.zzd.zzfa(r11)
        L_0x004b:
            return
        L_0x004c:
            java.lang.String r0 = "src"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "periodicReportIntervalMs"
            java.lang.Integer r1 = zza((java.util.Map<java.lang.String, java.lang.String>) r12, (java.lang.String) r1)
            if (r0 == 0) goto L_0x00fa
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]
            r4 = 0
            r3[r4] = r0
            java.lang.String r5 = "demuxed"
            java.lang.Object r5 = r12.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r6 = 0
            if (r5 == 0) goto L_0x00a6
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x008a }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x008a }
            int r7 = r3.length()     // Catch:{ JSONException -> 0x008a }
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ JSONException -> 0x008a }
            r8 = 0
        L_0x0079:
            int r9 = r3.length()     // Catch:{ JSONException -> 0x008a }
            if (r8 >= r9) goto L_0x0088
            java.lang.String r9 = r3.getString(r8)     // Catch:{ JSONException -> 0x008a }
            r7[r8] = r9     // Catch:{ JSONException -> 0x008a }
            int r8 = r8 + 1
            goto L_0x0079
        L_0x0088:
            r3 = r7
            goto L_0x00a6
        L_0x008a:
            java.lang.String r3 = "Malformed demuxed URL list for precache: "
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r7 = r5.length()
            if (r7 == 0) goto L_0x009c
            java.lang.String r3 = r3.concat(r5)
            goto L_0x00a2
        L_0x009c:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x00a2:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r3)
            r3 = r6
        L_0x00a6:
            if (r3 != 0) goto L_0x00ac
            java.lang.String[] r3 = new java.lang.String[r2]
            r3[r4] = r0
        L_0x00ac:
            com.google.android.gms.internal.ads.zzbcs r2 = com.google.android.gms.internal.ads.zzbcu.zzd(r11)
            if (r2 == 0) goto L_0x00b8
            java.lang.String r11 = "Precache task is already running."
        L_0x00b4:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r11)
            return
        L_0x00b8:
            com.google.android.gms.ads.internal.zzb r2 = r11.zzaak()
            if (r2 != 0) goto L_0x00c1
            java.lang.String r11 = "Precache requires a dependency provider."
            goto L_0x00b4
        L_0x00c1:
            com.google.android.gms.internal.ads.zzbbf r2 = new com.google.android.gms.internal.ads.zzbbf
            java.lang.String r5 = "flags"
            java.lang.Object r5 = r12.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r2.<init>(r5)
            java.lang.String r5 = "player"
            java.lang.Integer r5 = zza((java.util.Map<java.lang.String, java.lang.String>) r12, (java.lang.String) r5)
            if (r5 != 0) goto L_0x00da
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
        L_0x00da:
            if (r1 == 0) goto L_0x00e3
            int r1 = r1.intValue()
            r11.zzdq(r1)
        L_0x00e3:
            int r1 = r5.intValue()
            com.google.android.gms.ads.internal.zzb r4 = r11.zzaak()
            com.google.android.gms.internal.ads.zzbdf r4 = r4.zzboh
            com.google.android.gms.internal.ads.zzbcx r1 = r4.zza(r11, r1, r6, r2)
            com.google.android.gms.internal.ads.zzbcs r2 = new com.google.android.gms.internal.ads.zzbcs
            r2.<init>(r11, r1, r0, r3)
            r2.zzxl()
            goto L_0x0102
        L_0x00fa:
            com.google.android.gms.internal.ads.zzbcs r11 = com.google.android.gms.internal.ads.zzbcu.zzd(r11)
            if (r11 == 0) goto L_0x013f
            com.google.android.gms.internal.ads.zzbcx r1 = r11.zzeny
        L_0x0102:
            java.lang.String r11 = "minBufferMs"
            java.lang.Integer r11 = zza((java.util.Map<java.lang.String, java.lang.String>) r12, (java.lang.String) r11)
            if (r11 == 0) goto L_0x0111
            int r11 = r11.intValue()
            r1.zzdl(r11)
        L_0x0111:
            java.lang.String r11 = "maxBufferMs"
            java.lang.Integer r11 = zza((java.util.Map<java.lang.String, java.lang.String>) r12, (java.lang.String) r11)
            if (r11 == 0) goto L_0x0120
            int r11 = r11.intValue()
            r1.zzdm(r11)
        L_0x0120:
            java.lang.String r11 = "bufferForPlaybackMs"
            java.lang.Integer r11 = zza((java.util.Map<java.lang.String, java.lang.String>) r12, (java.lang.String) r11)
            if (r11 == 0) goto L_0x012f
            int r11 = r11.intValue()
            r1.zzdn(r11)
        L_0x012f:
            java.lang.String r11 = "bufferForPlaybackAfterRebufferMs"
            java.lang.Integer r11 = zza((java.util.Map<java.lang.String, java.lang.String>) r12, (java.lang.String) r11)
            if (r11 == 0) goto L_0x013e
            int r11 = r11.intValue()
            r1.zzdo(r11)
        L_0x013e:
            return
        L_0x013f:
            java.lang.String r11 = "Precache must specify a source."
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdc.zza(java.lang.Object, java.util.Map):void");
    }
}
