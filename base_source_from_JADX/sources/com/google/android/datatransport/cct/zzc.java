package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.p149a.zzo;
import com.google.android.datatransport.cct.p149a.zzp;
import com.google.android.datatransport.cct.p149a.zzq;
import com.google.android.datatransport.cct.p149a.zzr;
import com.google.android.datatransport.cct.p149a.zzt;
import com.google.android.datatransport.cct.p149a.zzu;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.parse.ParseQuery;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

final class zzc implements TransportBackend {
    private final DataEncoder zza = new JsonDataEncoderBuilder().configureWith(com.google.android.datatransport.cct.p149a.zzb.zza).ignoreNullValues(true).build();
    private final ConnectivityManager zzb;
    final URL zzc;
    private final Clock zzd;
    private final Clock zze;
    private final int zzf;

    static final class zza {
        final URL zza;
        final zzo zzb;
        final String zzc;

        zza(URL url, zzo zzo, String str) {
            this.zza = url;
            this.zzb = zzo;
            this.zzc = str;
        }

        /* access modifiers changed from: package-private */
        public zza zza(URL url) {
            return new zza(url, this.zzb, this.zzc);
        }
    }

    static final class zzb {
        final int zza;
        final URL zzb;
        final long zzc;

        zzb(int i, URL url, long j) {
            this.zza = i;
            this.zzb = url;
            this.zzc = j;
        }
    }

    zzc(Context context, Clock clock, Clock clock2) {
        this.zzb = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzc = zza(CCTDestination.zza);
        this.zzd = clock2;
        this.zze = clock;
        this.zzf = 40000;
    }

    static /* synthetic */ zza zza(zza zza2, zzb zzb2) {
        URL url = zzb2.zzb;
        if (url == null) {
            return null;
        }
        Logging.m8674d("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return zza2.zza(zzb2.zzb);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0126 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0143 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x014a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.datatransport.cct.zzc.zzb zza(com.google.android.datatransport.cct.zzc.zza r10) {
        /*
            r9 = this;
            java.net.URL r0 = r10.zza
            java.lang.String r1 = "CctTransportBackend"
            java.lang.String r2 = "Making request to: %s"
            com.google.android.datatransport.runtime.logging.Logging.m8674d((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object) r0)
            java.net.URL r0 = r10.zza
            java.net.URLConnection r0 = r0.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r1 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r1)
            int r1 = r9.zzf
            r0.setReadTimeout(r1)
            r1 = 1
            r0.setDoOutput(r1)
            r2 = 0
            r0.setInstanceFollowRedirects(r2)
            java.lang.String r3 = "POST"
            r0.setRequestMethod(r3)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "2.3.1"
            r1[r2] = r3
            java.lang.String r2 = "datatransport/%s android/"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            java.lang.String r2 = "User-Agent"
            r0.setRequestProperty(r2, r1)
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r0.setRequestProperty(r1, r2)
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            r0.setRequestProperty(r1, r2)
            java.lang.String r1 = "Accept-Encoding"
            java.lang.String r2 = "gzip"
            r0.setRequestProperty(r1, r2)
            java.lang.String r1 = r10.zzc
            if (r1 == 0) goto L_0x0057
            java.lang.String r2 = "X-Goog-Api-Key"
            r0.setRequestProperty(r2, r1)
        L_0x0057:
            r1 = 0
            r3 = 0
            java.io.OutputStream r4 = r0.getOutputStream()     // Catch:{ ConnectException -> 0x015f, UnknownHostException -> 0x015d, EncodingException -> 0x014d, IOException -> 0x014b }
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch:{ Throwable -> 0x0144 }
            r5.<init>(r4)     // Catch:{ Throwable -> 0x0144 }
            com.google.firebase.encoders.DataEncoder r6 = r9.zza     // Catch:{ Throwable -> 0x013f }
            com.google.android.datatransport.cct.a.zzo r10 = r10.zzb     // Catch:{ Throwable -> 0x013f }
            java.io.BufferedWriter r7 = new java.io.BufferedWriter     // Catch:{ Throwable -> 0x013f }
            java.io.OutputStreamWriter r8 = new java.io.OutputStreamWriter     // Catch:{ Throwable -> 0x013f }
            r8.<init>(r5)     // Catch:{ Throwable -> 0x013f }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x013f }
            r6.encode(r10, r7)     // Catch:{ Throwable -> 0x013f }
            r5.close()     // Catch:{ Throwable -> 0x0144 }
            if (r4 == 0) goto L_0x007c
            r4.close()     // Catch:{ ConnectException -> 0x015f, UnknownHostException -> 0x015d, EncodingException -> 0x014d, IOException -> 0x014b }
        L_0x007c:
            int r10 = r0.getResponseCode()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Status Code: "
            r4.append(r5)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "CctTransportBackend"
            com.google.android.datatransport.runtime.logging.Logging.m8678i(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Type: "
            r4.append(r5)
            java.lang.String r5 = "Content-Type"
            java.lang.String r5 = r0.getHeaderField(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "CctTransportBackend"
            com.google.android.datatransport.runtime.logging.Logging.m8678i(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Encoding: "
            r4.append(r5)
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r5 = r0.getHeaderField(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "CctTransportBackend"
            com.google.android.datatransport.runtime.logging.Logging.m8678i(r5, r4)
            r4 = 302(0x12e, float:4.23E-43)
            if (r10 == r4) goto L_0x012e
            r4 = 301(0x12d, float:4.22E-43)
            if (r10 == r4) goto L_0x012e
            r4 = 307(0x133, float:4.3E-43)
            if (r10 != r4) goto L_0x00db
            goto L_0x012e
        L_0x00db:
            r4 = 200(0xc8, float:2.8E-43)
            if (r10 == r4) goto L_0x00e5
            com.google.android.datatransport.cct.zzc$zzb r0 = new com.google.android.datatransport.cct.zzc$zzb
            r0.<init>(r10, r3, r1)
            return r0
        L_0x00e5:
            java.io.InputStream r1 = r0.getInputStream()
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r0 = r0.getHeaderField(r2)     // Catch:{ Throwable -> 0x0127 }
            java.lang.String r2 = "gzip"
            boolean r0 = r2.equals(r0)     // Catch:{ Throwable -> 0x0127 }
            if (r0 == 0) goto L_0x00fd
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ Throwable -> 0x0127 }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0127 }
            goto L_0x00fe
        L_0x00fd:
            r0 = r1
        L_0x00fe:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0120 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0120 }
            r4.<init>(r0)     // Catch:{ Throwable -> 0x0120 }
            r2.<init>(r4)     // Catch:{ Throwable -> 0x0120 }
            com.google.android.datatransport.cct.a.zzs r2 = com.google.android.datatransport.cct.p149a.zzs.zza(r2)     // Catch:{ Throwable -> 0x0120 }
            long r4 = r2.zza()     // Catch:{ Throwable -> 0x0120 }
            com.google.android.datatransport.cct.zzc$zzb r2 = new com.google.android.datatransport.cct.zzc$zzb     // Catch:{ Throwable -> 0x0120 }
            r2.<init>(r10, r3, r4)     // Catch:{ Throwable -> 0x0120 }
            if (r0 == 0) goto L_0x011a
            r0.close()     // Catch:{ Throwable -> 0x0127 }
        L_0x011a:
            if (r1 == 0) goto L_0x011f
            r1.close()
        L_0x011f:
            return r2
        L_0x0120:
            r10 = move-exception
            if (r0 == 0) goto L_0x0126
            r0.close()     // Catch:{ Throwable -> 0x0126 }
        L_0x0126:
            throw r10     // Catch:{ Throwable -> 0x0127 }
        L_0x0127:
            r10 = move-exception
            if (r1 == 0) goto L_0x012d
            r1.close()     // Catch:{ Throwable -> 0x012d }
        L_0x012d:
            throw r10
        L_0x012e:
            java.lang.String r3 = "Location"
            java.lang.String r0 = r0.getHeaderField(r3)
            com.google.android.datatransport.cct.zzc$zzb r3 = new com.google.android.datatransport.cct.zzc$zzb
            java.net.URL r4 = new java.net.URL
            r4.<init>(r0)
            r3.<init>(r10, r4, r1)
            return r3
        L_0x013f:
            r10 = move-exception
            r5.close()     // Catch:{ Throwable -> 0x0143 }
        L_0x0143:
            throw r10     // Catch:{ Throwable -> 0x0144 }
        L_0x0144:
            r10 = move-exception
            if (r4 == 0) goto L_0x014a
            r4.close()     // Catch:{ Throwable -> 0x014a }
        L_0x014a:
            throw r10     // Catch:{ ConnectException -> 0x015f, UnknownHostException -> 0x015d, EncodingException -> 0x014d, IOException -> 0x014b }
        L_0x014b:
            r10 = move-exception
            goto L_0x014e
        L_0x014d:
            r10 = move-exception
        L_0x014e:
            java.lang.String r0 = "CctTransportBackend"
            java.lang.String r4 = "Couldn't encode request, returning with 400"
            com.google.android.datatransport.runtime.logging.Logging.m8677e(r0, r4, r10)
            com.google.android.datatransport.cct.zzc$zzb r10 = new com.google.android.datatransport.cct.zzc$zzb
            r0 = 400(0x190, float:5.6E-43)
            r10.<init>(r0, r3, r1)
            return r10
        L_0x015d:
            r10 = move-exception
            goto L_0x0160
        L_0x015f:
            r10 = move-exception
        L_0x0160:
            java.lang.String r0 = "CctTransportBackend"
            java.lang.String r4 = "Couldn't open connection, returning with 500"
            com.google.android.datatransport.runtime.logging.Logging.m8677e(r0, r4, r10)
            com.google.android.datatransport.cct.zzc$zzb r10 = new com.google.android.datatransport.cct.zzc$zzb
            r0 = 500(0x1f4, float:7.0E-43)
            r10.<init>(r0, r3, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.zzc.zza(com.google.android.datatransport.cct.zzc$zza):com.google.android.datatransport.cct.zzc$zzb");
    }

    private static URL zza(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        int i;
        zzt.zzb zzb2;
        NetworkInfo activeNetworkInfo = this.zzb.getActiveNetworkInfo();
        EventInternal.Builder addMetadata = eventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        EventInternal.Builder addMetadata2 = addMetadata.addMetadata("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / ParseQuery.MAX_LIMIT)).addMetadata("net-type", activeNetworkInfo == null ? zzt.zzc.NONE.zza() : activeNetworkInfo.getType());
        if (activeNetworkInfo == null) {
            zzb2 = zzt.zzb.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            i = activeNetworkInfo.getSubtype();
            if (i == -1) {
                zzb2 = zzt.zzb.COMBINED;
            } else {
                if (zzt.zzb.zza(i) == null) {
                    i = 0;
                }
                return addMetadata2.addMetadata("mobile-subtype", i).build();
            }
        }
        i = zzb2.zza();
        return addMetadata2.addMetadata("mobile-subtype", i).build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        zzq.zza zza2;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            zzr.zza zza3 = zzr.zza().zza(zzu.DEFAULT).zza(this.zze.getTime()).zzb(this.zzd.getTime()).zza(zzp.zza().zza(zzp.zzb.ANDROID_FIREBASE).zza(com.google.android.datatransport.cct.p149a.zza.zza().zza(Integer.valueOf(eventInternal.getInteger("sdk-version"))).zze(eventInternal.get("model")).zzc(eventInternal.get("hardware")).zza(eventInternal.get("device")).zzg(eventInternal.get("product")).zzf(eventInternal.get("os-uild")).zzd(eventInternal.get("manufacturer")).zzb(eventInternal.get("fingerprint")).zza()).zza());
            try {
                zza3.zza(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                zza3.zzb((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.m8671of("proto"))) {
                    zza2 = zzq.zza(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.m8671of("json"))) {
                    zza2 = zzq.zza(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.m8679w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                zza2.zza(eventInternal2.getEventMillis()).zzb(eventInternal2.getUptimeMillis()).zzc(eventInternal2.getLong("tz-offset")).zza(zzt.zza().zza(zzt.zzc.zza(eventInternal2.getInteger("net-type"))).zza(zzt.zzb.zza(eventInternal2.getInteger("mobile-subtype"))).zza());
                if (eventInternal2.getCode() != null) {
                    zza2.zza(eventInternal2.getCode());
                }
                arrayList3.add(zza2.zza());
            }
            zza3.zza((List<zzq>) arrayList3);
            arrayList2.add(zza3.zza());
        }
        zzo zza4 = zzo.zza(arrayList2);
        String str = null;
        URL url = this.zzc;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = zza(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.fatalError();
            }
        }
        try {
            zzb zzb2 = (zzb) Retries.retry(5, new zza(url, zza4, str), zza.zza(this), zzb.zza());
            if (zzb2.zza == 200) {
                return BackendResponse.m8672ok(zzb2.zzc);
            }
            int i = zzb2.zza;
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.m8677e("CctTransportBackend", "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }
}
