package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zzoq implements zzot {
    private static final Pattern zzbic = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbid = new AtomicReference<>();
    private final boolean zzbie;
    private final int zzbif;
    private final int zzbig;
    private final String zzbih;
    private final zzpp<String> zzbii = null;
    private final zzox zzbij;
    private final zzox zzbik;
    private final zzpd<? super zzoq> zzbil;
    private zzoo zzbim;
    private HttpURLConnection zzbin;
    private InputStream zzbio;
    private boolean zzbip;
    private long zzbiq;
    private long zzbir;
    private long zzbis;
    private long zzcn;

    public zzoq(String str, zzpp<String> zzpp, zzpd<? super zzoq> zzpd, int i, int i2, boolean z, zzox zzox) {
        this.zzbih = zzpc.checkNotEmpty(str);
        this.zzbil = zzpd;
        this.zzbik = new zzox();
        this.zzbif = i;
        this.zzbig = i2;
        this.zzbie = true;
        this.zzbij = null;
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbif);
        httpURLConnection.setReadTimeout(this.zzbig);
        for (Map.Entry next : this.zzbik.zzit().entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzbih);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0036
            long r1 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0011 }
            goto L_0x0038
        L_0x0011:
            java.lang.String r1 = "DefaultHttpDataSource"
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected Content-Length ["
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = "]"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.e(r1, r2)
        L_0x0036:
            r1 = -1
        L_0x0038:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x00d4
            java.util.regex.Pattern r3 = zzbic
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            if (r4 == 0) goto L_0x00d4
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch:{ NumberFormatException -> 0x00af }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x00af }
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch:{ NumberFormatException -> 0x00af }
            long r6 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x00af }
            long r4 = r4 - r6
            r6 = 1
            long r3 = r4 + r6
            r5 = 0
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x006f
            r1 = r3
            goto L_0x00d4
        L_0x006f:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00d4
            java.lang.String r5 = "DefaultHttpDataSource"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00af }
            int r6 = r6.length()     // Catch:{ NumberFormatException -> 0x00af }
            int r6 = r6 + 26
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch:{ NumberFormatException -> 0x00af }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x00af }
            int r6 = r6 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00af }
            r7.<init>(r6)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r6 = "Inconsistent headers ["
            r7.append(r6)     // Catch:{ NumberFormatException -> 0x00af }
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00af }
            r7.append(r8)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r0 = r7.toString()     // Catch:{ NumberFormatException -> 0x00af }
            android.util.Log.w(r5, r0)     // Catch:{ NumberFormatException -> 0x00af }
            long r0 = java.lang.Math.max(r1, r3)     // Catch:{ NumberFormatException -> 0x00af }
            r1 = r0
            goto L_0x00d4
        L_0x00af:
            java.lang.String r0 = "DefaultHttpDataSource"
            java.lang.String r3 = java.lang.String.valueOf(r8)
            int r3 = r3.length()
            int r3 = r3 + 27
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r8)
            java.lang.String r8 = "]"
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            android.util.Log.e(r0, r8)
        L_0x00d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.zzc(java.net.HttpURLConnection):long");
    }

    private final void zziq() {
        HttpURLConnection httpURLConnection = this.zzbin;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzbin = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > android.support.p002v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbio     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x007b
            java.net.HttpURLConnection r2 = r9.zzbin     // Catch:{ all -> 0x008e }
            long r3 = r9.zzbir     // Catch:{ all -> 0x008e }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.zzbir     // Catch:{ all -> 0x008e }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.zzbir     // Catch:{ all -> 0x008e }
            long r7 = r9.zzcn     // Catch:{ all -> 0x008e }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 20
            if (r7 != r8) goto L_0x006b
        L_0x0024:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006b }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            int r3 = r2.read()     // Catch:{ Exception -> 0x006b }
            r4 = -1
            if (r3 != r4) goto L_0x003a
            goto L_0x006b
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006b
        L_0x003a:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006b }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006b }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            java.io.InputStream r2 = r9.zzbio     // Catch:{ IOException -> 0x0071 }
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007b
        L_0x0071:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzoo r4 = r9.zzbim     // Catch:{ all -> 0x008e }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzoo) r4, (int) r5)     // Catch:{ all -> 0x008e }
            throw r3     // Catch:{ all -> 0x008e }
        L_0x007b:
            r9.zzbio = r0
            r9.zziq()
            boolean r0 = r9.zzbip
            if (r0 == 0) goto L_0x008d
            r9.zzbip = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.zzbil
            if (r0 == 0) goto L_0x008d
            r0.zze(r9)
        L_0x008d:
            return
        L_0x008e:
            r2 = move-exception
            r9.zzbio = r0
            r9.zziq()
            boolean r0 = r9.zzbip
            if (r0 == 0) goto L_0x00a1
            r9.zzbip = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.zzbil
            if (r0 == 0) goto L_0x00a1
            r0.zze(r9)
        L_0x00a1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.close():void");
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbin;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbin;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final int read(byte[] bArr, int i, int i2) {
        try {
            if (this.zzbis != this.zzbiq) {
                byte[] andSet = zzbid.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbis != this.zzbiq) {
                    int read = this.zzbio.read(andSet, 0, (int) Math.min(this.zzbiq - this.zzbis, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbis += (long) read;
                        if (this.zzbil != null) {
                            this.zzbil.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzbid.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbir != -1) {
                long j = this.zzbir - this.zzcn;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.zzbio.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcn += (long) read2;
                if (this.zzbil != null) {
                    this.zzbil.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbir == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzov(e, this.zzbim, 2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzoo r25) {
        /*
            r24 = this;
            r10 = r24
            r11 = r25
            r10.zzbim = r11
            r12 = 0
            r10.zzcn = r12
            r10.zzbis = r12
            r14 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x018d }
            android.net.Uri r0 = r11.uri     // Catch:{ IOException -> 0x018d }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x018d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x018d }
            byte[] r3 = r11.zzbia     // Catch:{ IOException -> 0x018d }
            long r8 = r11.position     // Catch:{ IOException -> 0x018d }
            long r6 = r11.zzcm     // Catch:{ IOException -> 0x018d }
            boolean r0 = r11.isFlagSet(r14)     // Catch:{ IOException -> 0x018d }
            boolean r1 = r10.zzbie     // Catch:{ IOException -> 0x018d }
            r15 = 0
            if (r1 != 0) goto L_0x0034
            r16 = 1
            r1 = r24
            r4 = r8
            r8 = r0
            r9 = r16
            java.net.HttpURLConnection r0 = r1.zza(r2, r3, r4, r6, r8, r9)     // Catch:{ IOException -> 0x018d }
            goto L_0x0076
        L_0x0034:
            r4 = r2
            r16 = r3
            r1 = 0
        L_0x0038:
            int r5 = r1 + 1
            r2 = 20
            if (r1 > r2) goto L_0x0170
            r17 = 0
            r1 = r24
            r2 = r4
            r3 = r16
            r19 = r4
            r18 = r5
            r4 = r8
            r20 = r6
            r22 = r8
            r8 = r0
            r9 = r17
            java.net.HttpURLConnection r1 = r1.zza(r2, r3, r4, r6, r8, r9)     // Catch:{ IOException -> 0x018d }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x018d }
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 == r3) goto L_0x011c
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x011c
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x011c
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 == r3) goto L_0x011c
            if (r16 != 0) goto L_0x0075
            r3 = 307(0x133, float:4.3E-43)
            if (r2 == r3) goto L_0x011c
            r3 = 308(0x134, float:4.32E-43)
            if (r2 != r3) goto L_0x0075
            goto L_0x011c
        L_0x0075:
            r0 = r1
        L_0x0076:
            r10.zzbin = r0     // Catch:{ IOException -> 0x018d }
            java.net.HttpURLConnection r0 = r10.zzbin     // Catch:{ IOException -> 0x00f5 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x00f5 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x00da
            r2 = 299(0x12b, float:4.19E-43)
            if (r0 <= r2) goto L_0x0087
            goto L_0x00da
        L_0x0087:
            java.net.HttpURLConnection r2 = r10.zzbin
            r2.getContentType()
            if (r0 != r1) goto L_0x0096
            long r0 = r11.position
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0096
            long r12 = r11.position
        L_0x0096:
            r10.zzbiq = r12
            boolean r0 = r11.isFlagSet(r14)
            if (r0 != 0) goto L_0x00b8
            long r0 = r11.zzcm
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a7
            goto L_0x00b8
        L_0x00a7:
            java.net.HttpURLConnection r0 = r10.zzbin
            long r0 = zzc(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b5
            long r2 = r10.zzbiq
            long r2 = r0 - r2
        L_0x00b5:
            r10.zzbir = r2
            goto L_0x00bc
        L_0x00b8:
            long r0 = r11.zzcm
            r10.zzbir = r0
        L_0x00bc:
            java.net.HttpURLConnection r0 = r10.zzbin     // Catch:{ IOException -> 0x00d0 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x00d0 }
            r10.zzbio = r0     // Catch:{ IOException -> 0x00d0 }
            r10.zzbip = r14
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r10.zzbil
            if (r0 == 0) goto L_0x00cd
            r0.zza(r10, r11)
        L_0x00cd:
            long r0 = r10.zzbir
            return r0
        L_0x00d0:
            r0 = move-exception
            r24.zziq()
            com.google.android.gms.internal.ads.zzov r1 = new com.google.android.gms.internal.ads.zzov
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzoo) r11, (int) r14)
            throw r1
        L_0x00da:
            java.net.HttpURLConnection r1 = r10.zzbin
            java.util.Map r1 = r1.getHeaderFields()
            r24.zziq()
            com.google.android.gms.internal.ads.zzou r2 = new com.google.android.gms.internal.ads.zzou
            r2.<init>(r0, r1, r11)
            r1 = 416(0x1a0, float:5.83E-43)
            if (r0 != r1) goto L_0x00f4
            com.google.android.gms.internal.ads.zzop r0 = new com.google.android.gms.internal.ads.zzop
            r0.<init>(r15)
            r2.initCause(r0)
        L_0x00f4:
            throw r2
        L_0x00f5:
            r0 = move-exception
            r24.zziq()
            com.google.android.gms.internal.ads.zzov r1 = new com.google.android.gms.internal.ads.zzov
            java.lang.String r2 = "Unable to connect to "
            android.net.Uri r3 = r11.uri
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x0112
            java.lang.String r2 = r2.concat(r3)
            goto L_0x0118
        L_0x0112:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x0118:
            r1.<init>(r2, r0, r11, r14)
            throw r1
        L_0x011c:
            r16 = 0
            java.lang.String r2 = "Location"
            java.lang.String r2 = r1.getHeaderField(r2)     // Catch:{ IOException -> 0x018d }
            r1.disconnect()     // Catch:{ IOException -> 0x018d }
            if (r2 == 0) goto L_0x0168
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x018d }
            r1 = r19
            r4.<init>(r1, r2)     // Catch:{ IOException -> 0x018d }
            java.lang.String r1 = r4.getProtocol()     // Catch:{ IOException -> 0x018d }
            java.lang.String r2 = "https"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x018d }
            if (r2 != 0) goto L_0x0160
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x018d }
            if (r2 != 0) goto L_0x0160
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x018d }
            java.lang.String r2 = "Unsupported protocol redirect: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x018d }
            int r3 = r1.length()     // Catch:{ IOException -> 0x018d }
            if (r3 == 0) goto L_0x0157
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IOException -> 0x018d }
            goto L_0x015c
        L_0x0157:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x018d }
            r1.<init>(r2)     // Catch:{ IOException -> 0x018d }
        L_0x015c:
            r0.<init>(r1)     // Catch:{ IOException -> 0x018d }
            throw r0     // Catch:{ IOException -> 0x018d }
        L_0x0160:
            r1 = r18
            r6 = r20
            r8 = r22
            goto L_0x0038
        L_0x0168:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x018d }
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x018d }
            throw r0     // Catch:{ IOException -> 0x018d }
        L_0x0170:
            r18 = r5
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x018d }
            r1 = 31
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018d }
            r2.<init>(r1)     // Catch:{ IOException -> 0x018d }
            java.lang.String r1 = "Too many redirects: "
            r2.append(r1)     // Catch:{ IOException -> 0x018d }
            r1 = r18
            r2.append(r1)     // Catch:{ IOException -> 0x018d }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x018d }
            r0.<init>(r1)     // Catch:{ IOException -> 0x018d }
            throw r0     // Catch:{ IOException -> 0x018d }
        L_0x018d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzov r1 = new com.google.android.gms.internal.ads.zzov
            java.lang.String r2 = "Unable to connect to "
            android.net.Uri r3 = r11.uri
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x01a7
            java.lang.String r2 = r2.concat(r3)
            goto L_0x01ad
        L_0x01a7:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x01ad:
            r1.<init>(r2, r0, r11, r14)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.zza(com.google.android.gms.internal.ads.zzoo):long");
    }
}
