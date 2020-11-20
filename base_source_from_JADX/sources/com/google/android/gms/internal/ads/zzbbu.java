package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

final class zzbbu implements zzot {
    private static final Pattern zzbic = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbid = new AtomicReference<>();
    private final int zzbif;
    private final int zzbig;
    private final String zzbih;
    private final zzox zzbik;
    private final zzpd<? super zzbbu> zzbil;
    private zzoo zzbim;
    private HttpURLConnection zzbin;
    private InputStream zzbio;
    private boolean zzbip;
    private long zzbiq;
    private long zzbir;
    private long zzbis;
    private long zzcn;
    private SSLSocketFactory zzemb = new zzbbx(this);
    /* access modifiers changed from: private */
    public int zzemc;
    private Set<Socket> zzemd = new HashSet();

    zzbbu(String str, zzpd<? super zzbbu> zzpd, int i, int i2, int i3) {
        this.zzbih = zzpc.checkNotEmpty(str);
        this.zzbil = zzpd;
        this.zzbik = new zzox();
        this.zzbif = i;
        this.zzbig = i2;
        this.zzemc = i3;
    }

    /* access modifiers changed from: private */
    public final void zza(Socket socket) {
        this.zzemd.add(socket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0034
            long r1 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0011 }
            goto L_0x0036
        L_0x0011:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = "]"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzey(r1)
        L_0x0034:
            r1 = -1
        L_0x0036:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x00ce
            java.util.regex.Pattern r3 = zzbic
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            if (r4 == 0) goto L_0x00ce
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch:{ NumberFormatException -> 0x00ab }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x00ab }
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch:{ NumberFormatException -> 0x00ab }
            long r6 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x00ab }
            long r4 = r4 - r6
            r6 = 1
            long r3 = r4 + r6
            r5 = 0
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x006d
            r1 = r3
            goto L_0x00ce
        L_0x006d:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00ce
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ab }
            int r5 = r5.length()     // Catch:{ NumberFormatException -> 0x00ab }
            int r5 = r5 + 26
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ NumberFormatException -> 0x00ab }
            int r6 = r6.length()     // Catch:{ NumberFormatException -> 0x00ab }
            int r5 = r5 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00ab }
            r6.<init>(r5)     // Catch:{ NumberFormatException -> 0x00ab }
            java.lang.String r5 = "Inconsistent headers ["
            r6.append(r5)     // Catch:{ NumberFormatException -> 0x00ab }
            r6.append(r0)     // Catch:{ NumberFormatException -> 0x00ab }
            java.lang.String r0 = "] ["
            r6.append(r0)     // Catch:{ NumberFormatException -> 0x00ab }
            r6.append(r8)     // Catch:{ NumberFormatException -> 0x00ab }
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch:{ NumberFormatException -> 0x00ab }
            java.lang.String r0 = r6.toString()     // Catch:{ NumberFormatException -> 0x00ab }
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ NumberFormatException -> 0x00ab }
            long r0 = java.lang.Math.max(r1, r3)     // Catch:{ NumberFormatException -> 0x00ab }
            r1 = r0
            goto L_0x00ce
        L_0x00ab:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r3.append(r0)
            r3.append(r8)
            java.lang.String r8 = "]"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            com.google.android.gms.ads.internal.util.zzd.zzey(r8)
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.zzc(java.net.HttpURLConnection):long");
    }

    private final void zziq() {
        HttpURLConnection httpURLConnection = this.zzbin;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzd.zzc("Unexpected error while disconnecting", e);
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
            java.io.InputStream r2 = r9.zzbio     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x007b
            java.net.HttpURLConnection r2 = r9.zzbin     // Catch:{ all -> 0x0093 }
            long r3 = r9.zzbir     // Catch:{ all -> 0x0093 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.zzbir     // Catch:{ all -> 0x0093 }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.zzbir     // Catch:{ all -> 0x0093 }
            long r7 = r9.zzcn     // Catch:{ all -> 0x0093 }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x0093 }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x0093 }
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
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzoo r4 = r9.zzbim     // Catch:{ all -> 0x0093 }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzoo) r4, (int) r5)     // Catch:{ all -> 0x0093 }
            throw r3     // Catch:{ all -> 0x0093 }
        L_0x007b:
            r9.zzbio = r0
            r9.zziq()
            boolean r0 = r9.zzbip
            if (r0 == 0) goto L_0x008d
            r9.zzbip = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzbbu> r0 = r9.zzbil
            if (r0 == 0) goto L_0x008d
            r0.zze(r9)
        L_0x008d:
            java.util.Set<java.net.Socket> r0 = r9.zzemd
            r0.clear()
            return
        L_0x0093:
            r2 = move-exception
            r9.zzbio = r0
            r9.zziq()
            boolean r0 = r9.zzbip
            if (r0 == 0) goto L_0x00a6
            r9.zzbip = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzbbu> r0 = r9.zzbil
            if (r0 == 0) goto L_0x00a6
            r0.zze(r9)
        L_0x00a6:
            java.util.Set<java.net.Socket> r0 = r9.zzemd
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.close():void");
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

    /* access modifiers changed from: package-private */
    public final void setReceiveBufferSize(int i) {
        this.zzemc = i;
        for (Socket next : this.zzemd) {
            if (!next.isClosed()) {
                try {
                    next.setReceiveBufferSize(this.zzemc);
                } catch (SocketException e) {
                    zzd.zzd("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x011f A[EDGE_INSN: B:117:0x011f->B:47:0x011f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0115 A[Catch:{ IOException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzoo r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r1.zzbim = r2
            r3 = 0
            r1.zzcn = r3
            r1.zzbis = r3
            r5 = 1
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0239 }
            android.net.Uri r6 = r2.uri     // Catch:{ IOException -> 0x0239 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0239 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0239 }
            byte[] r6 = r2.zzbia     // Catch:{ IOException -> 0x0239 }
            long r7 = r2.position     // Catch:{ IOException -> 0x0239 }
            long r9 = r2.zzcm     // Catch:{ IOException -> 0x0239 }
            boolean r11 = r2.isFlagSet(r5)     // Catch:{ IOException -> 0x0239 }
            r13 = r6
            r6 = r0
            r0 = 0
        L_0x0025:
            int r14 = r0 + 1
            r15 = 20
            if (r0 > r15) goto L_0x0220
            java.net.URLConnection r0 = r6.openConnection()     // Catch:{ IOException -> 0x0239 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0239 }
            boolean r5 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x0239 }
            if (r5 == 0) goto L_0x003d
            r5 = r0
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ IOException -> 0x0239 }
            javax.net.ssl.SSLSocketFactory r12 = r1.zzemb     // Catch:{ IOException -> 0x0239 }
            r5.setSSLSocketFactory(r12)     // Catch:{ IOException -> 0x0239 }
        L_0x003d:
            int r5 = r1.zzbif     // Catch:{ IOException -> 0x0239 }
            r0.setConnectTimeout(r5)     // Catch:{ IOException -> 0x0239 }
            int r5 = r1.zzbig     // Catch:{ IOException -> 0x0239 }
            r0.setReadTimeout(r5)     // Catch:{ IOException -> 0x0239 }
            com.google.android.gms.internal.ads.zzox r5 = r1.zzbik     // Catch:{ IOException -> 0x0239 }
            java.util.Map r5 = r5.zzit()     // Catch:{ IOException -> 0x0239 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0239 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0239 }
        L_0x0055:
            boolean r12 = r5.hasNext()     // Catch:{ IOException -> 0x0239 }
            if (r12 == 0) goto L_0x0075
            java.lang.Object r12 = r5.next()     // Catch:{ IOException -> 0x0239 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ IOException -> 0x0239 }
            java.lang.Object r16 = r12.getKey()     // Catch:{ IOException -> 0x0239 }
            r15 = r16
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x0239 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ IOException -> 0x0239 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x0239 }
            r0.setRequestProperty(r15, r12)     // Catch:{ IOException -> 0x0239 }
            r15 = 20
            goto L_0x0055
        L_0x0075:
            r17 = -1
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x007f
            int r5 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x00c4
        L_0x007f:
            r5 = 27
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0239 }
            r12.<init>(r5)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r5 = "bytes="
            r12.append(r5)     // Catch:{ IOException -> 0x0239 }
            r12.append(r7)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r5 = "-"
            r12.append(r5)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r5 = r12.toString()     // Catch:{ IOException -> 0x0239 }
            int r12 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r12 == 0) goto L_0x00bf
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0239 }
            long r19 = r7 + r9
            r21 = 1
            long r3 = r19 - r21
            java.lang.String r12 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0239 }
            int r12 = r12.length()     // Catch:{ IOException -> 0x0239 }
            r15 = 20
            int r12 = r12 + r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0239 }
            r15.<init>(r12)     // Catch:{ IOException -> 0x0239 }
            r15.append(r5)     // Catch:{ IOException -> 0x0239 }
            r15.append(r3)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r5 = r15.toString()     // Catch:{ IOException -> 0x0239 }
        L_0x00bf:
            java.lang.String r3 = "Range"
            r0.setRequestProperty(r3, r5)     // Catch:{ IOException -> 0x0239 }
        L_0x00c4:
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = r1.zzbih     // Catch:{ IOException -> 0x0239 }
            r0.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0239 }
            if (r11 != 0) goto L_0x00d4
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r0.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0239 }
        L_0x00d4:
            r3 = 0
            r0.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x0239 }
            if (r13 == 0) goto L_0x00dc
            r3 = 1
            goto L_0x00dd
        L_0x00dc:
            r3 = 0
        L_0x00dd:
            r0.setDoOutput(r3)     // Catch:{ IOException -> 0x0239 }
            if (r13 == 0) goto L_0x00fc
            java.lang.String r3 = "POST"
            r0.setRequestMethod(r3)     // Catch:{ IOException -> 0x0239 }
            int r3 = r13.length     // Catch:{ IOException -> 0x0239 }
            if (r3 == 0) goto L_0x00fc
            int r3 = r13.length     // Catch:{ IOException -> 0x0239 }
            r0.setFixedLengthStreamingMode(r3)     // Catch:{ IOException -> 0x0239 }
            r0.connect()     // Catch:{ IOException -> 0x0239 }
            java.io.OutputStream r3 = r0.getOutputStream()     // Catch:{ IOException -> 0x0239 }
            r3.write(r13)     // Catch:{ IOException -> 0x0239 }
            r3.close()     // Catch:{ IOException -> 0x0239 }
            goto L_0x00ff
        L_0x00fc:
            r0.connect()     // Catch:{ IOException -> 0x0239 }
        L_0x00ff:
            int r3 = r0.getResponseCode()     // Catch:{ IOException -> 0x0239 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 == r4) goto L_0x01c9
            r4 = 301(0x12d, float:4.22E-43)
            if (r3 == r4) goto L_0x01c9
            r4 = 302(0x12e, float:4.23E-43)
            if (r3 == r4) goto L_0x01c9
            r4 = 303(0x12f, float:4.25E-43)
            if (r3 == r4) goto L_0x01c9
            if (r13 != 0) goto L_0x011f
            r4 = 307(0x133, float:4.3E-43)
            if (r3 == r4) goto L_0x01c9
            r4 = 308(0x134, float:4.32E-43)
            if (r3 != r4) goto L_0x011f
            goto L_0x01c9
        L_0x011f:
            r1.zzbin = r0     // Catch:{ IOException -> 0x0239 }
            java.net.HttpURLConnection r0 = r1.zzbin     // Catch:{ IOException -> 0x01a1 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x01a1 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x0185
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x0130
            goto L_0x0185
        L_0x0130:
            if (r0 != r3) goto L_0x013d
            long r3 = r2.position
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x013f
            long r3 = r2.position
            goto L_0x0140
        L_0x013d:
            r12 = 0
        L_0x013f:
            r3 = r12
        L_0x0140:
            r1.zzbiq = r3
            r3 = 1
            boolean r0 = r2.isFlagSet(r3)
            if (r0 != 0) goto L_0x0161
            long r3 = r2.zzcm
            int r0 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0150
            goto L_0x0161
        L_0x0150:
            java.net.HttpURLConnection r0 = r1.zzbin
            long r3 = zzc(r0)
            int r0 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x015e
            long r5 = r1.zzbiq
            long r17 = r3 - r5
        L_0x015e:
            r3 = r17
            goto L_0x0163
        L_0x0161:
            long r3 = r2.zzcm
        L_0x0163:
            r1.zzbir = r3
            java.net.HttpURLConnection r0 = r1.zzbin     // Catch:{ IOException -> 0x017a }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x017a }
            r1.zzbio = r0     // Catch:{ IOException -> 0x017a }
            r3 = 1
            r1.zzbip = r3
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzbbu> r0 = r1.zzbil
            if (r0 == 0) goto L_0x0177
            r0.zza(r1, r2)
        L_0x0177:
            long r2 = r1.zzbir
            return r2
        L_0x017a:
            r0 = move-exception
            r25.zziq()
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzoo) r2, (int) r4)
            throw r3
        L_0x0185:
            java.net.HttpURLConnection r3 = r1.zzbin
            java.util.Map r3 = r3.getHeaderFields()
            r25.zziq()
            com.google.android.gms.internal.ads.zzou r4 = new com.google.android.gms.internal.ads.zzou
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x01a0
            com.google.android.gms.internal.ads.zzop r0 = new com.google.android.gms.internal.ads.zzop
            r3 = 0
            r0.<init>(r3)
            r4.initCause(r0)
        L_0x01a0:
            throw r4
        L_0x01a1:
            r0 = move-exception
            r25.zziq()
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov
            java.lang.String r4 = "Unable to connect to "
            android.net.Uri r5 = r2.uri
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x01be
            java.lang.String r4 = r4.concat(r5)
            goto L_0x01c4
        L_0x01be:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x01c4:
            r5 = 1
            r3.<init>(r4, r0, r2, r5)
            throw r3
        L_0x01c9:
            r3 = 0
            r12 = 0
            r4 = 0
            java.lang.String r5 = "Location"
            java.lang.String r5 = r0.getHeaderField(r5)     // Catch:{ IOException -> 0x0239 }
            r0.disconnect()     // Catch:{ IOException -> 0x0239 }
            if (r5 == 0) goto L_0x0218
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0239 }
            r0.<init>(r6, r5)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r5 = r0.getProtocol()     // Catch:{ IOException -> 0x0239 }
            java.lang.String r6 = "https"
            boolean r6 = r6.equals(r5)     // Catch:{ IOException -> 0x0239 }
            if (r6 != 0) goto L_0x020e
            java.lang.String r6 = "http"
            boolean r6 = r6.equals(r5)     // Catch:{ IOException -> 0x0239 }
            if (r6 != 0) goto L_0x020e
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0239 }
            java.lang.String r3 = "Unsupported protocol redirect: "
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0239 }
            int r5 = r4.length()     // Catch:{ IOException -> 0x0239 }
            if (r5 == 0) goto L_0x0204
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException -> 0x0239 }
            goto L_0x020a
        L_0x0204:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0239 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0239 }
            r3 = r4
        L_0x020a:
            r0.<init>(r3)     // Catch:{ IOException -> 0x0239 }
            throw r0     // Catch:{ IOException -> 0x0239 }
        L_0x020e:
            r6 = r0
            r0 = r14
            r5 = 1
            r23 = r12
            r13 = r4
            r3 = r23
            goto L_0x0025
        L_0x0218:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0239 }
            java.lang.String r3 = "Null location redirect"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0239 }
            throw r0     // Catch:{ IOException -> 0x0239 }
        L_0x0220:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x0239 }
            r3 = 31
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0239 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r3 = "Too many redirects: "
            r4.append(r3)     // Catch:{ IOException -> 0x0239 }
            r4.append(r14)     // Catch:{ IOException -> 0x0239 }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0239 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0239 }
            throw r0     // Catch:{ IOException -> 0x0239 }
        L_0x0239:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov
            java.lang.String r4 = "Unable to connect to "
            android.net.Uri r5 = r2.uri
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0253
            java.lang.String r4 = r4.concat(r5)
            goto L_0x0259
        L_0x0253:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x0259:
            r5 = 1
            r3.<init>(r4, r0, r2, r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.zza(com.google.android.gms.internal.ads.zzoo):long");
    }
}
