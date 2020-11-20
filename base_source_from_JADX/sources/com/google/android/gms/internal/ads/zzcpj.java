package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcpj implements zzdqv<zzcpm, zzcpl> {
    private final Context context;
    private final String zzdtm;
    private final zzaty zzgoa;
    private final String zzgom;
    private final int zzgon;

    public zzcpj(Context context2, String str, zzaty zzaty, String str2, int i) {
        this.context = context2;
        this.zzgom = str;
        this.zzgoa = zzaty;
        this.zzdtm = str2;
        this.zzgon = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r4 = new java.io.InputStreamReader(r11.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        com.google.android.gms.ads.internal.zzp.zzkq();
        r0 = com.google.android.gms.ads.internal.util.zzm.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4);
        r7.zzev(r0);
        r3.zzdul = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01b7, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01c9, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcvg)).booleanValue() == false) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01d3, code lost:
        throw new com.google.android.gms.internal.ads.zzcme(com.google.android.gms.internal.ads.zzdok.NO_FILL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01d4, code lost:
        r3.zzgot = com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime() - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r11.disconnect();
        r1.zzgoa.zzwb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01e8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x028d A[Catch:{ all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02a1 A[SYNTHETIC, Splitter:B:122:0x02a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzcpl zza(java.lang.String r18, com.google.android.gms.internal.ads.zzatr r19, org.json.JSONObject r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            java.lang.String r2 = "http_timeout_millis"
            r3 = 60000(0xea60, float:8.4078E-41)
            int r2 = r0.optInt(r2, r3)     // Catch:{ IOException -> 0x02ac }
            int r3 = r19.getErrorCode()     // Catch:{ IOException -> 0x02ac }
            r4 = -2
            r11 = 1
            if (r3 == r4) goto L_0x0040
            int r0 = r19.getErrorCode()     // Catch:{ IOException -> 0x02ac }
            if (r0 != r11) goto L_0x0038
            java.util.List r0 = r19.zzvt()     // Catch:{ IOException -> 0x02ac }
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = ", "
            java.util.List r2 = r19.zzvt()     // Catch:{ IOException -> 0x02ac }
            java.lang.String r0 = android.text.TextUtils.join(r0, r2)     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.ads.internal.util.zzd.zzey(r0)     // Catch:{ IOException -> 0x02ac }
        L_0x002e:
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INVALID_REQUEST     // Catch:{ IOException -> 0x02ac }
            java.lang.String r3 = "Error building request URL."
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x02ac }
            throw r0     // Catch:{ IOException -> 0x02ac }
        L_0x0038:
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ IOException -> 0x02ac }
            r0.<init>(r2)     // Catch:{ IOException -> 0x02ac }
            throw r0     // Catch:{ IOException -> 0x02ac }
        L_0x0040:
            com.google.android.gms.internal.ads.zzcpl r3 = new com.google.android.gms.internal.ads.zzcpl     // Catch:{ IOException -> 0x02ac }
            r3.<init>()     // Catch:{ IOException -> 0x02ac }
            java.lang.String r4 = "SDK version: "
            java.lang.String r5 = r1.zzgom     // Catch:{ IOException -> 0x02ac }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x02ac }
            int r6 = r5.length()     // Catch:{ IOException -> 0x02ac }
            if (r6 == 0) goto L_0x0058
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x02ac }
            goto L_0x005e
        L_0x0058:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x02ac }
            r5.<init>(r4)     // Catch:{ IOException -> 0x02ac }
            r4 = r5
        L_0x005e:
            com.google.android.gms.ads.internal.util.zzd.zzez(r4)     // Catch:{ IOException -> 0x02ac }
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r5 = java.lang.String.valueOf(r18)     // Catch:{ IOException -> 0x02ac }
            int r6 = r5.length()     // Catch:{ IOException -> 0x02ac }
            if (r6 == 0) goto L_0x0072
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x02ac }
            goto L_0x0078
        L_0x0072:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x02ac }
            r5.<init>(r4)     // Catch:{ IOException -> 0x02ac }
            r4 = r5
        L_0x0078:
            com.google.android.gms.ads.internal.util.zzd.zzeb(r4)     // Catch:{ IOException -> 0x02ac }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x02ac }
            r5 = r18
            r4.<init>(r5)     // Catch:{ IOException -> 0x02ac }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x02ac }
            r12.<init>()     // Catch:{ IOException -> 0x02ac }
            r5 = 0
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ IOException -> 0x02ac }
            long r13 = r6.elapsedRealtime()     // Catch:{ IOException -> 0x02ac }
            r15 = 0
        L_0x0091:
            com.google.android.gms.internal.ads.zzaty r5 = r1.zzgoa     // Catch:{ IOException -> 0x02ac }
            int r6 = r1.zzgon     // Catch:{ IOException -> 0x02ac }
            r5.zzdd(r6)     // Catch:{ IOException -> 0x02ac }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x02ac }
            r10 = r4
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.ads.internal.util.zzm r4 = com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ zzcme -> 0x0279, all -> 0x0276 }
            android.content.Context r5 = r1.context     // Catch:{ zzcme -> 0x0279, all -> 0x0276 }
            java.lang.String r6 = r1.zzgom     // Catch:{ zzcme -> 0x0279, all -> 0x0276 }
            r7 = 0
            r9 = 0
            r8 = r10
            r11 = r10
            r10 = r2
            r4.zza(r5, r6, r7, r8, r9, r10)     // Catch:{ zzcme -> 0x0274 }
            boolean r4 = android.text.TextUtils.isEmpty(r21)     // Catch:{ zzcme -> 0x0274 }
            if (r4 != 0) goto L_0x00bd
            java.lang.String r4 = "Cookie"
            r5 = r21
            r11.addRequestProperty(r4, r5)     // Catch:{ zzcme -> 0x0274 }
            goto L_0x00bf
        L_0x00bd:
            r5 = r21
        L_0x00bf:
            boolean r4 = r19.zzvw()     // Catch:{ zzcme -> 0x0274 }
            if (r4 == 0) goto L_0x0109
            java.lang.String r4 = "pii"
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ zzcme -> 0x0274 }
            if (r4 == 0) goto L_0x0104
            java.lang.String r6 = "doritos"
            java.lang.String r7 = ""
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ zzcme -> 0x0274 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ zzcme -> 0x0274 }
            if (r6 != 0) goto L_0x00e8
            java.lang.String r6 = "x-afma-drt-cookie"
            java.lang.String r7 = "doritos"
            java.lang.String r8 = ""
            java.lang.String r7 = r4.optString(r7, r8)     // Catch:{ zzcme -> 0x0274 }
            r11.addRequestProperty(r6, r7)     // Catch:{ zzcme -> 0x0274 }
        L_0x00e8:
            java.lang.String r6 = "doritos_v2"
            java.lang.String r7 = ""
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ zzcme -> 0x0274 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ zzcme -> 0x0274 }
            if (r6 != 0) goto L_0x0109
            java.lang.String r6 = "x-afma-drt-v2-cookie"
            java.lang.String r7 = "doritos_v2"
            java.lang.String r8 = ""
            java.lang.String r4 = r4.optString(r7, r8)     // Catch:{ zzcme -> 0x0274 }
            r11.addRequestProperty(r6, r4)     // Catch:{ zzcme -> 0x0274 }
            goto L_0x0109
        L_0x0104:
            java.lang.String r4 = "DSID signal does not exist."
            com.google.android.gms.ads.internal.util.zzd.zzee(r4)     // Catch:{ zzcme -> 0x0274 }
        L_0x0109:
            if (r19 == 0) goto L_0x013e
            java.lang.String r6 = r19.zzvv()     // Catch:{ zzcme -> 0x0274 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ zzcme -> 0x0274 }
            if (r6 != 0) goto L_0x013e
            r6 = 1
            r11.setDoOutput(r6)     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r6 = r19.zzvv()     // Catch:{ zzcme -> 0x0274 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzcme -> 0x0274 }
            int r7 = r6.length     // Catch:{ zzcme -> 0x0274 }
            r11.setFixedLengthStreamingMode(r7)     // Catch:{ zzcme -> 0x0274 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0138 }
            java.io.OutputStream r8 = r11.getOutputStream()     // Catch:{ all -> 0x0138 }
            r7.<init>(r8)     // Catch:{ all -> 0x0138 }
            r7.write(r6)     // Catch:{ all -> 0x0135 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzcme -> 0x0274 }
            goto L_0x013f
        L_0x0135:
            r0 = move-exception
            r4 = r7
            goto L_0x013a
        L_0x0138:
            r0 = move-exception
            r4 = 0
        L_0x013a:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzcme -> 0x0274 }
            throw r0     // Catch:{ zzcme -> 0x0274 }
        L_0x013e:
            r6 = 0
        L_0x013f:
            com.google.android.gms.internal.ads.zzayu r7 = new com.google.android.gms.internal.ads.zzayu     // Catch:{ zzcme -> 0x0274 }
            r7.<init>()     // Catch:{ zzcme -> 0x0274 }
            r7.zza((java.net.HttpURLConnection) r11, (byte[]) r6)     // Catch:{ zzcme -> 0x0274 }
            int r6 = r11.getResponseCode()     // Catch:{ zzcme -> 0x0274 }
            java.util.Map r8 = r11.getHeaderFields()     // Catch:{ zzcme -> 0x0274 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ zzcme -> 0x0274 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ zzcme -> 0x0274 }
        L_0x0157:
            boolean r9 = r8.hasNext()     // Catch:{ zzcme -> 0x0274 }
            if (r9 == 0) goto L_0x0188
            java.lang.Object r9 = r8.next()     // Catch:{ zzcme -> 0x0274 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ zzcme -> 0x0274 }
            java.lang.Object r10 = r9.getKey()     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ zzcme -> 0x0274 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ zzcme -> 0x0274 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ zzcme -> 0x0274 }
            boolean r16 = r12.containsKey(r10)     // Catch:{ zzcme -> 0x0274 }
            if (r16 == 0) goto L_0x017f
            java.lang.Object r10 = r12.get(r10)     // Catch:{ zzcme -> 0x0274 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ zzcme -> 0x0274 }
            r10.addAll(r9)     // Catch:{ zzcme -> 0x0274 }
            goto L_0x0157
        L_0x017f:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ zzcme -> 0x0274 }
            r4.<init>(r9)     // Catch:{ zzcme -> 0x0274 }
            r12.put(r10, r4)     // Catch:{ zzcme -> 0x0274 }
            goto L_0x0157
        L_0x0188:
            r7.zza((java.net.HttpURLConnection) r11, (int) r6)     // Catch:{ zzcme -> 0x0274 }
            r3.zzgos = r6     // Catch:{ zzcme -> 0x0274 }
            r3.zzal = r12     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r4 = ""
            r3.zzdul = r4     // Catch:{ zzcme -> 0x0274 }
            r4 = 200(0xc8, float:2.8E-43)
            r8 = 300(0x12c, float:4.2E-43)
            if (r6 < r4) goto L_0x01f0
            if (r6 >= r8) goto L_0x01f0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x01ea }
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ all -> 0x01ea }
            r4.<init>(r0)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x01e8 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzm.zza((java.io.InputStreamReader) r4)     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzcme -> 0x0274 }
            r7.zzev(r0)     // Catch:{ zzcme -> 0x0274 }
            r3.zzdul = r0     // Catch:{ zzcme -> 0x0274 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzcme -> 0x0274 }
            if (r0 == 0) goto L_0x01d4
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcvg     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzcme -> 0x0274 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ zzcme -> 0x0274 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzcme -> 0x0274 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzcme -> 0x0274 }
            if (r0 == 0) goto L_0x01cc
            goto L_0x01d4
        L_0x01cc:
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.NO_FILL     // Catch:{ zzcme -> 0x0274 }
            r0.<init>(r2)     // Catch:{ zzcme -> 0x0274 }
            throw r0     // Catch:{ zzcme -> 0x0274 }
        L_0x01d4:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ zzcme -> 0x0274 }
            long r4 = r0.elapsedRealtime()     // Catch:{ zzcme -> 0x0274 }
            long r4 = r4 - r13
            r3.zzgot = r4     // Catch:{ zzcme -> 0x0274 }
            r11.disconnect()     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.internal.ads.zzaty r0 = r1.zzgoa     // Catch:{ IOException -> 0x02ac }
            r0.zzwb()     // Catch:{ IOException -> 0x02ac }
            return r3
        L_0x01e8:
            r0 = move-exception
            goto L_0x01ec
        L_0x01ea:
            r0 = move-exception
            r4 = 0
        L_0x01ec:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzcme -> 0x0274 }
            throw r0     // Catch:{ zzcme -> 0x0274 }
        L_0x01f0:
            if (r6 < r8) goto L_0x0245
            r4 = 400(0x190, float:5.6E-43)
            if (r6 >= r4) goto L_0x0245
            java.lang.String r4 = "Location"
            java.lang.String r4 = r11.getHeaderField(r4)     // Catch:{ zzcme -> 0x0274 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ zzcme -> 0x0274 }
            if (r6 != 0) goto L_0x0236
            java.net.URL r6 = new java.net.URL     // Catch:{ zzcme -> 0x0274 }
            r6.<init>(r4)     // Catch:{ zzcme -> 0x0274 }
            r4 = 1
            int r15 = r15 + r4
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r7 = com.google.android.gms.internal.ads.zzabf.zzcuh     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzabb r8 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzcme -> 0x0274 }
            java.lang.Object r7 = r8.zzd(r7)     // Catch:{ zzcme -> 0x0274 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzcme -> 0x0274 }
            int r7 = r7.intValue()     // Catch:{ zzcme -> 0x0274 }
            if (r15 > r7) goto L_0x0227
            r11.disconnect()     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.internal.ads.zzaty r7 = r1.zzgoa     // Catch:{ IOException -> 0x02ac }
            r7.zzwb()     // Catch:{ IOException -> 0x02ac }
            r4 = r6
            r11 = 1
            goto L_0x0091
        L_0x0227:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r4 = "Too many redirects"
            r0.<init>(r2, r4)     // Catch:{ zzcme -> 0x0274 }
            throw r0     // Catch:{ zzcme -> 0x0274 }
        L_0x0236:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzdok r2 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r4 = "No location header to follow redirect"
            r0.<init>(r2, r4)     // Catch:{ zzcme -> 0x0274 }
            throw r0     // Catch:{ zzcme -> 0x0274 }
        L_0x0245:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzcme -> 0x0274 }
            r2 = 46
            r0.<init>(r2)     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r4 = "Received error HTTP response code: "
            r0.append(r4)     // Catch:{ zzcme -> 0x0274 }
            r0.append(r6)     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r0 = r0.toString()     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzcme r0 = new com.google.android.gms.internal.ads.zzcme     // Catch:{ zzcme -> 0x0274 }
            com.google.android.gms.internal.ads.zzdok r4 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR     // Catch:{ zzcme -> 0x0274 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzcme -> 0x0274 }
            r5.<init>(r2)     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r2 = "Received error HTTP response code: "
            r5.append(r2)     // Catch:{ zzcme -> 0x0274 }
            r5.append(r6)     // Catch:{ zzcme -> 0x0274 }
            java.lang.String r2 = r5.toString()     // Catch:{ zzcme -> 0x0274 }
            r0.<init>(r4, r2)     // Catch:{ zzcme -> 0x0274 }
            throw r0     // Catch:{ zzcme -> 0x0274 }
        L_0x0274:
            r0 = move-exception
            goto L_0x027b
        L_0x0276:
            r0 = move-exception
            r11 = r10
            goto L_0x02a3
        L_0x0279:
            r0 = move-exception
            r11 = r10
        L_0x027b:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcza     // Catch:{ all -> 0x02a2 }
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x02a2 }
            java.lang.Object r2 = r4.zzd(r2)     // Catch:{ all -> 0x02a2 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x02a2 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x02a2 }
            if (r2 == 0) goto L_0x02a1
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ all -> 0x02a2 }
            long r4 = r0.elapsedRealtime()     // Catch:{ all -> 0x02a2 }
            long r4 = r4 - r13
            r3.zzgot = r4     // Catch:{ all -> 0x02a2 }
            r11.disconnect()     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.internal.ads.zzaty r0 = r1.zzgoa     // Catch:{ IOException -> 0x02ac }
            r0.zzwb()     // Catch:{ IOException -> 0x02ac }
            return r3
        L_0x02a1:
            throw r0     // Catch:{ all -> 0x02a2 }
        L_0x02a2:
            r0 = move-exception
        L_0x02a3:
            r11.disconnect()     // Catch:{ IOException -> 0x02ac }
            com.google.android.gms.internal.ads.zzaty r2 = r1.zzgoa     // Catch:{ IOException -> 0x02ac }
            r2.zzwb()     // Catch:{ IOException -> 0x02ac }
            throw r0     // Catch:{ IOException -> 0x02ac }
        L_0x02ac:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x02c2
            java.lang.String r2 = r2.concat(r3)
            goto L_0x02c8
        L_0x02c2:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x02c8:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r2)
            com.google.android.gms.internal.ads.zzcme r3 = new com.google.android.gms.internal.ads.zzcme
            com.google.android.gms.internal.ads.zzdok r4 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR
            r3.<init>(r4, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpj.zza(java.lang.String, com.google.android.gms.internal.ads.zzatr, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzcpl");
    }

    public final /* synthetic */ Object apply(Object obj) {
        zzcpm zzcpm = (zzcpm) obj;
        return zza(zzcpm.zzgoh.getUrl(), zzcpm.zzgoh, zzcpm.zzgoi, this.zzdtm);
    }
}
