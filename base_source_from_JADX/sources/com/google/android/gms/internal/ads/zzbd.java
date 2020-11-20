package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class zzbd extends zzar {
    private final zzbf zzcs;
    private final SSLSocketFactory zzct;

    public zzbd() {
        this((zzbf) null);
    }

    private zzbd(zzbf zzbf) {
        this((zzbf) null, (SSLSocketFactory) null);
    }

    private zzbd(zzbf zzbf, SSLSocketFactory sSLSocketFactory) {
        this.zzcs = null;
        this.zzct = null;
    }

    /* access modifiers changed from: private */
    public static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static List<zzu> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String zzu : (List) next.getValue()) {
                    arrayList.add(new zzu((String) next.getKey(), zzu));
                }
            }
        }
        return arrayList;
    }

    private static void zza(HttpURLConnection httpURLConnection, zzaa<?> zzaa) {
        byte[] zzg = zzaa.zzg();
        if (zzg != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                String valueOf = String.valueOf("UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", valueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(valueOf) : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzg);
            dataOutputStream.close();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006e, code lost:
        zza(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0074, code lost:
        r0.setRequestMethod(r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbb zza(com.google.android.gms.internal.ads.zzaa<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getUrl()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.putAll(r8)
            java.util.Map r8 = r7.getHeaders()
            r1.putAll(r8)
            java.net.URL r8 = new java.net.URL
            r8.<init>(r0)
            java.net.URLConnection r0 = r8.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            boolean r2 = java.net.HttpURLConnection.getFollowRedirects()
            r0.setInstanceFollowRedirects(r2)
            int r2 = r7.zzi()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r3 = 1
            r0.setDoInput(r3)
            java.lang.String r4 = "https"
            java.lang.String r8 = r8.getProtocol()
            r4.equals(r8)
            java.util.Set r8 = r1.keySet()     // Catch:{ all -> 0x00ec }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00ec }
        L_0x0048:
            boolean r4 = r8.hasNext()     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r8.next()     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00ec }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x00ec }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00ec }
            r0.setRequestProperty(r4, r5)     // Catch:{ all -> 0x00ec }
            goto L_0x0048
        L_0x005e:
            int r8 = r7.getMethod()     // Catch:{ all -> 0x00ec }
            switch(r8) {
                case -1: goto L_0x0090;
                case 0: goto L_0x008d;
                case 1: goto L_0x0087;
                case 2: goto L_0x0081;
                case 3: goto L_0x007e;
                case 4: goto L_0x007b;
                case 5: goto L_0x0078;
                case 6: goto L_0x0072;
                case 7: goto L_0x0069;
                default: goto L_0x0065;
            }     // Catch:{ all -> 0x00ec }
        L_0x0065:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ec }
            goto L_0x00e6
        L_0x0069:
            java.lang.String r8 = "PATCH"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00ec }
        L_0x006e:
            zza((java.net.HttpURLConnection) r0, (com.google.android.gms.internal.ads.zzaa<?>) r7)     // Catch:{ all -> 0x00ec }
            goto L_0x0090
        L_0x0072:
            java.lang.String r8 = "TRACE"
        L_0x0074:
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00ec }
            goto L_0x0090
        L_0x0078:
            java.lang.String r8 = "OPTIONS"
            goto L_0x0074
        L_0x007b:
            java.lang.String r8 = "HEAD"
            goto L_0x0074
        L_0x007e:
            java.lang.String r8 = "DELETE"
            goto L_0x0074
        L_0x0081:
            java.lang.String r8 = "PUT"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00ec }
            goto L_0x006e
        L_0x0087:
            java.lang.String r8 = "POST"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00ec }
            goto L_0x006e
        L_0x008d:
            java.lang.String r8 = "GET"
            goto L_0x0074
        L_0x0090:
            int r8 = r0.getResponseCode()     // Catch:{ all -> 0x00ec }
            r1 = -1
            if (r8 == r1) goto L_0x00de
            int r7 = r7.getMethod()     // Catch:{ all -> 0x00ec }
            r1 = 4
            if (r7 == r1) goto L_0x00b0
            r7 = 100
            if (r7 > r8) goto L_0x00a6
            r7 = 200(0xc8, float:2.8E-43)
            if (r8 < r7) goto L_0x00b0
        L_0x00a6:
            r7 = 204(0xcc, float:2.86E-43)
            if (r8 == r7) goto L_0x00b0
            r7 = 304(0x130, float:4.26E-43)
            if (r8 == r7) goto L_0x00b0
            r7 = 1
            goto L_0x00b1
        L_0x00b0:
            r7 = 0
        L_0x00b1:
            if (r7 != 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzbb r7 = new com.google.android.gms.internal.ads.zzbb     // Catch:{ all -> 0x00ec }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x00ec }
            java.util.List r1 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x00ec }
            r7.<init>(r8, r1)     // Catch:{ all -> 0x00ec }
            r0.disconnect()
            return r7
        L_0x00c4:
            com.google.android.gms.internal.ads.zzbb r7 = new com.google.android.gms.internal.ads.zzbb     // Catch:{ all -> 0x00db }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x00db }
            java.util.List r1 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x00db }
            int r2 = r0.getContentLength()     // Catch:{ all -> 0x00db }
            com.google.android.gms.internal.ads.zzbg r4 = new com.google.android.gms.internal.ads.zzbg     // Catch:{ all -> 0x00db }
            r4.<init>(r0)     // Catch:{ all -> 0x00db }
            r7.<init>(r8, r1, r2, r4)     // Catch:{ all -> 0x00db }
            return r7
        L_0x00db:
            r7 = move-exception
            r2 = 1
            goto L_0x00ed
        L_0x00de:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x00ec }
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)     // Catch:{ all -> 0x00ec }
            throw r7     // Catch:{ all -> 0x00ec }
        L_0x00e6:
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)     // Catch:{ all -> 0x00ec }
            throw r7     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r7 = move-exception
        L_0x00ed:
            if (r2 != 0) goto L_0x00f2
            r0.disconnect()
        L_0x00f2:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbd.zza(com.google.android.gms.internal.ads.zzaa, java.util.Map):com.google.android.gms.internal.ads.zzbb");
    }
}
