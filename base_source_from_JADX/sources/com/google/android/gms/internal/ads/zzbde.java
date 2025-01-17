package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzbde extends zzbcx {
    private static final Set<String> zzeop = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzeoq = new DecimalFormat("#,###");
    private File zzcw;
    private boolean zzeor;

    public zzbde(zzbbe zzbbe) {
        super(zzbbe);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzd.zzfa("Context.getCacheDir() returned null");
            return;
        }
        this.zzcw = new File(cacheDir, "admobVideoStreams");
        if (!this.zzcw.isDirectory() && !this.zzcw.mkdirs()) {
            String valueOf = String.valueOf(this.zzcw.getAbsolutePath());
            zzd.zzfa(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzcw = null;
        } else if (!this.zzcw.setReadable(true, false) || !this.zzcw.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzcw.getAbsolutePath());
            zzd.zzfa(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzcw = null;
        }
    }

    private final File zzd(File file) {
        return new File(this.zzcw, String.valueOf(file.getName()).concat(".done"));
    }

    public final void abort() {
        this.zzeor = true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v29, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ee, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f9, code lost:
        if (r1 < 400) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01fb, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x020b, code lost:
        if (r2.length() == 0) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x020d, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0213, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0240, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0241, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0249, code lost:
        if (r7 >= 0) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0255, code lost:
        if (r1.length() == 0) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0257, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x025c, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0262, code lost:
        com.google.android.gms.ads.internal.util.zzd.zzfa(r0);
        zza(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zzeop.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0273, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r1 = zzeoq.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmg)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x028b, code lost:
        if (r7 <= r3) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r9);
        com.google.android.gms.ads.internal.util.zzd.zzfa(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c6, code lost:
        if (r1.length() == 0) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c8, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02cd, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d3, code lost:
        zza(r9, r12.getAbsolutePath(), "sizeExceeded", r0);
        zzeop.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.ads.internal.util.zzd.zzeb(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(org.spongycastle.asn1.cmp.PKIFailureInfo.badCertTemplate);
        r16 = com.google.android.gms.ads.internal.zzp.zzkx();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x033b, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r6 = new com.google.android.gms.ads.internal.util.zzbs(((java.lang.Long) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmj)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmi)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0355, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0359, code lost:
        if (r20 < 0) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x035b, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x035d, code lost:
        if (r11 <= r3) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x035f, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x036f, code lost:
        if (r1.length() == 0) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0371, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0377, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0383, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0384, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0387, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x038a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x038d, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x038f, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0399, code lost:
        if (r2.write(r1) > 0) goto L_0x0467;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x039b, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03aa, code lost:
        if (r24 > 0) goto L_0x0425;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03ac, code lost:
        r20 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03b0, code lost:
        if (r8.zzeor != false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03b6, code lost:
        if (r6.tryAcquire() == false) goto L_0x03ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03b8, code lost:
        r21 = r12.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03be, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03c0, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03c2, code lost:
        r24 = r10;
        r10 = com.google.android.gms.internal.ads.zzayr.zzzz;
        r1 = r1;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r4 = r21;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03e0, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzbcw(r30, r31, r4, r11, r7, false);
        r10.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ea, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03ef, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0401, code lost:
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0415, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0424, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0425, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0458, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0459, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x045c, code lost:
        r2 = r2.toString();
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0463, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x046b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x046e, code lost:
        r27 = r4;
        r22 = r15;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0475, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0484, code lost:
        if (com.google.android.gms.ads.internal.util.zzd.isLoggable(3) == false) goto L_0x04c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0486, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        r1 = zzeoq.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.ads.internal.util.zzd.zzeb(r3.toString());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04bd, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04bf, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:?, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04ce, code lost:
        if (r0.isFile() == false) goto L_0x04d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04d0, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04d8, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        r0.createNewFile();
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        zza(r9, r12.getAbsolutePath(), r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x04e4, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        zzeop.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04e9, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x04eb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04ef, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04f2, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04f4, code lost:
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04fa, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x04fe, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0501, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0504, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x050a, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0514, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0515, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x051f, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0520, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0523, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0526, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0529, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x052c, code lost:
        r2 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0532, code lost:
        com.google.android.gms.ads.internal.zzp.zzku().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0542, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r9);
        r3.append("\"");
        com.google.android.gms.ads.internal.util.zzd.zzez(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0566, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r9);
        r4.append("\"");
        com.google.android.gms.ads.internal.util.zzd.zzd(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x05a5, code lost:
        r0 = "Could not delete partial cache file at ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x05aa, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0401, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012d, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.ads.internal.zzp.zzlc();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcmk)).intValue();
        r3 = new java.net.URL(r9);
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0149, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014c, code lost:
        if (r2 > 20) goto L_0x0515;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014e, code lost:
        r5 = r3.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015a, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x050a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015c, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzayu();
        r6.zza(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.zza(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0173, code lost:
        if ((r7 / 100) != 3) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = r5.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017b, code lost:
        if (r4 == null) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017d, code lost:
        r6 = new java.net.URL(r3, r4);
        r3 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0186, code lost:
        if (r3 == null) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018e, code lost:
        if (r3.equals("http") != false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0196, code lost:
        if (r3.equals("https") != false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0198, code lost:
        r2 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a4, code lost:
        if (r2.length() == 0) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a6, code lost:
        r1 = "Unsupported scheme: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ab, code lost:
        r1 = new java.lang.String("Unsupported scheme: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b4, code lost:
        throw new java.io.IOException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b5, code lost:
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01bf, code lost:
        if (r4.length() == 0) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c1, code lost:
        r3 = "Redirecting to ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c6, code lost:
        r3 = new java.lang.String("Redirecting to ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cc, code lost:
        com.google.android.gms.ads.internal.util.zzd.zzeb(r3);
        r5.disconnect();
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01dc, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e4, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e8, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e9, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:217:0x04db */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04bd A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r22 r24 r27 
      PHI: (r22v8 java.lang.String) = (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v16 java.lang.String), (r22v16 java.lang.String) binds: [B:215:0x04d8, B:216:?, B:213:0x04d0, B:214:?, B:203:0x0486, B:204:?, B:172:0x03c0, B:175:0x03e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 java.lang.String) = (r24v12 java.lang.String), (r24v13 java.lang.String), (r24v15 java.lang.String), (r24v17 java.lang.String), (r24v19 java.lang.String), (r24v21 java.lang.String), (r24v26 java.lang.String), (r24v29 java.lang.String) binds: [B:215:0x04d8, B:216:?, B:213:0x04d0, B:214:?, B:203:0x0486, B:204:?, B:172:0x03c0, B:175:0x03e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v10 java.io.FileOutputStream) = (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v15 java.io.FileOutputStream), (r27v18 java.io.FileOutputStream) binds: [B:215:0x04d8, B:216:?, B:213:0x04d0, B:214:?, B:203:0x0486, B:204:?, B:172:0x03c0, B:175:0x03e0] A[DONT_GENERATE, DONT_INLINE], Splitter:B:175:0x03e0] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x05a5  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x05aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfj(java.lang.String r31) {
        /*
            r30 = this;
            r8 = r30
            r9 = r31
            java.io.File r0 = r8.zzcw
            r10 = 0
            r11 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "noCacheDir"
        L_0x000c:
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0010:
            java.io.File r0 = r8.zzcw
            if (r0 != 0) goto L_0x0016
            r3 = 0
            goto L_0x0032
        L_0x0016:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x001d:
            if (r2 >= r1) goto L_0x0032
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x002f
            int r3 = r3 + 1
        L_0x002f:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x0032:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzabf.zzcmf
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0094
            java.io.File r0 = r8.zzcw
            if (r0 != 0) goto L_0x004a
        L_0x0048:
            r0 = 0
            goto L_0x0089
        L_0x004a:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r4 = r1
            r2 = r10
            r1 = 0
        L_0x0057:
            if (r1 >= r3) goto L_0x0074
            r6 = r0[r1]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0071
            long r12 = r6.lastModified()
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0071
            r2 = r6
            r4 = r12
        L_0x0071:
            int r1 = r1 + 1
            goto L_0x0057
        L_0x0074:
            if (r2 == 0) goto L_0x0048
            boolean r0 = r2.delete()
            java.io.File r1 = r8.zzd(r2)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0089
            boolean r1 = r1.delete()
            r0 = r0 & r1
        L_0x0089:
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)
            java.lang.String r0 = "expireFailed"
            goto L_0x000c
        L_0x0094:
            java.lang.String r0 = r30.zzfk(r31)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.zzcw
            r12.<init>(r1, r0)
            java.io.File r0 = r8.zzd(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d7
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00d7
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00c6
            java.lang.String r0 = r0.concat(r2)
            goto L_0x00cc
        L_0x00c6:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x00cc:
            com.google.android.gms.ads.internal.util.zzd.zzeb(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza((java.lang.String) r9, (java.lang.String) r0, (int) r1)
            return r13
        L_0x00d7:
            java.io.File r1 = r8.zzcw
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00f1
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x00f7
        L_0x00f1:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x00f7:
            java.util.Set<java.lang.String> r1 = zzeop
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = zzeop     // Catch:{ all -> 0x05c1 }
            boolean r2 = r2.contains(r14)     // Catch:{ all -> 0x05c1 }
            if (r2 == 0) goto L_0x0127
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ all -> 0x05c1 }
            int r3 = r2.length()     // Catch:{ all -> 0x05c1 }
            if (r3 == 0) goto L_0x0113
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x05c1 }
            goto L_0x0119
        L_0x0113:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x05c1 }
            r2.<init>(r0)     // Catch:{ all -> 0x05c1 }
            r0 = r2
        L_0x0119:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ all -> 0x05c1 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x05c1 }
            java.lang.String r2 = "inProgress"
            r8.zza(r9, r0, r2, r10)     // Catch:{ all -> 0x05c1 }
            monitor-exit(r1)     // Catch:{ all -> 0x05c1 }
            return r11
        L_0x0127:
            java.util.Set<java.lang.String> r2 = zzeop     // Catch:{ all -> 0x05c1 }
            r2.add(r14)     // Catch:{ all -> 0x05c1 }
            monitor-exit(r1)     // Catch:{ all -> 0x05c1 }
            java.lang.String r15 = "error"
            com.google.android.gms.ads.internal.zzp.zzlc()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcmk     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r3 = r2
            r2 = 0
        L_0x0149:
            int r2 = r2 + r13
            r4 = 20
            if (r2 > r4) goto L_0x0515
            java.net.URLConnection r5 = r3.openConnection()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r5.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r5.setReadTimeout(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            boolean r6 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            if (r6 == 0) goto L_0x050a
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            com.google.android.gms.internal.ads.zzayu r6 = new com.google.android.gms.internal.ads.zzayu     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r6.<init>()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r6.zza((java.net.HttpURLConnection) r5, (byte[]) r10)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r5.setInstanceFollowRedirects(r11)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r7 = r5.getResponseCode()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r6.zza((java.net.HttpURLConnection) r5, (int) r7)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r7 = r7 / 100
            r6 = 3
            if (r7 != r6) goto L_0x01ec
            java.lang.String r4 = "Location"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r4 == 0) goto L_0x01dd
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r6.<init>(r3, r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r3 = r6.getProtocol()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r3 == 0) goto L_0x01d5
            java.lang.String r7 = "http"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r7 != 0) goto L_0x01b5
            java.lang.String r7 = "https"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r7 != 0) goto L_0x01b5
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "Unsupported scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r3 == 0) goto L_0x01ab
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            goto L_0x01b1
        L_0x01ab:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r1 = r2
        L_0x01b1:
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x01b5:
            java.lang.String r3 = "Redirecting to "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r7 = r4.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r7 == 0) goto L_0x01c6
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            goto L_0x01cc
        L_0x01c6:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r3 = r4
        L_0x01cc:
            com.google.android.gms.ads.internal.util.zzd.zzeb(r3)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r5.disconnect()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r3 = r6
            goto L_0x0149
        L_0x01d5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "Protocol is null"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x01dd:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "Missing Location header in redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x01e5:
            r0 = move-exception
            goto L_0x01e8
        L_0x01e7:
            r0 = move-exception
        L_0x01e8:
            r2 = r10
        L_0x01e9:
            r1 = r14
            goto L_0x052e
        L_0x01ec:
            boolean r1 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            if (r1 == 0) goto L_0x0245
            r1 = r5
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r1 = r1.getResponseCode()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x0245
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r2 = java.lang.Integer.toString(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r3 == 0) goto L_0x0213
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2 = r0
            goto L_0x0218
        L_0x0213:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x0218:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r3 = "HTTP status code "
            r4.append(r3)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r4.append(r1)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r1 = " at "
            r4.append(r1)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r4.append(r9)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            throw r0     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
        L_0x0241:
            r0 = move-exception
            goto L_0x01e9
        L_0x0243:
            r0 = move-exception
            goto L_0x01e9
        L_0x0245:
            int r7 = r5.getContentLength()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            if (r7 >= 0) goto L_0x0274
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r1 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r2 == 0) goto L_0x025c
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            goto L_0x0262
        L_0x025c:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r0 = r1
        L_0x0262:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "contentLengthMissing"
            r8.zza(r9, r0, r1, r10)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.util.Set<java.lang.String> r0 = zzeop     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            return r11
        L_0x0274:
            java.text.DecimalFormat r1 = zzeoq     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            long r2 = (long) r7     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzabf.zzcmg     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r3 = r2.intValue()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            if (r7 <= r3) goto L_0x02e2
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r0 = r0.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r0 = r0 + 33
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r0 = "Content length "
            r2.append(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2.append(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r0 = " exceeds limit at "
            r2.append(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2.append(r9)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r2 == 0) goto L_0x02cd
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            goto L_0x02d3
        L_0x02cd:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r0 = r1
        L_0x02d3:
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r2 = "sizeExceeded"
            r8.zza(r9, r1, r2, r0)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.util.Set<java.lang.String> r0 = zzeop     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            return r11
        L_0x02e2:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r2 = r2 + r4
            java.lang.String r4 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.String r2 = "Caching "
            r4.append(r2)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r4.append(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r4.append(r9)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            com.google.android.gms.ads.internal.util.zzd.zzeb(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x0528, RuntimeException -> 0x0526 }
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzabf.zzcmj     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            com.google.android.gms.internal.ads.zzabb r10 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            java.lang.Object r6 = r10.zzd(r6)     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException -> 0x0500, RuntimeException -> 0x04fe }
            r10 = r14
            long r13 = r6.longValue()     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            com.google.android.gms.ads.internal.util.zzbs r6 = new com.google.android.gms.ads.internal.util.zzbs     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            r6.<init>(r13)     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r13 = com.google.android.gms.internal.ads.zzabf.zzcmi     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            com.google.android.gms.internal.ads.zzabb r14 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            java.lang.Object r13 = r14.zzd(r13)     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            long r13 = r13.longValue()     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
        L_0x0355:
            int r20 = r5.read(r1)     // Catch:{ IOException -> 0x04f9, RuntimeException -> 0x04f7 }
            if (r20 < 0) goto L_0x0475
            int r11 = r11 + r20
            if (r11 <= r3) goto L_0x0392
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r11)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            int r2 = r1.length()     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            if (r2 == 0) goto L_0x0377
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            r1 = r0
            goto L_0x037c
        L_0x0377:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            r1.<init>(r0)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
        L_0x037c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0386, RuntimeException -> 0x0384 }
            java.lang.String r2 = "stream cache file size limit exceeded"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0386, RuntimeException -> 0x0384 }
            throw r0     // Catch:{ IOException -> 0x0386, RuntimeException -> 0x0384 }
        L_0x0384:
            r0 = move-exception
            goto L_0x0387
        L_0x0386:
            r0 = move-exception
        L_0x0387:
            r2 = r1
            r1 = r10
            goto L_0x038f
        L_0x038a:
            r0 = move-exception
            goto L_0x038d
        L_0x038c:
            r0 = move-exception
        L_0x038d:
            r1 = r10
            r2 = 0
        L_0x038f:
            r10 = r4
            goto L_0x052e
        L_0x0392:
            r1.flip()     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
        L_0x0395:
            int r20 = r2.write(r1)     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            if (r20 > 0) goto L_0x0467
            r1.clear()     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            long r20 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            long r20 = r20 - r17
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r13
            int r24 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r24 > 0) goto L_0x0425
            r20 = r1
            boolean r1 = r8.zzeor     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            if (r1 != 0) goto L_0x0415
            boolean r1 = r6.tryAcquire()     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            if (r1 == 0) goto L_0x03ef
            java.lang.String r21 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzayr.zzzz     // Catch:{ IOException -> 0x046d, RuntimeException -> 0x046b }
            r22 = r15
            com.google.android.gms.internal.ads.zzbcw r15 = new com.google.android.gms.internal.ads.zzbcw     // Catch:{ IOException -> 0x03e9, RuntimeException -> 0x03e7 }
            r23 = 0
            r24 = r10
            r10 = r1
            r1 = r15
            r25 = r2
            r2 = r30
            r26 = r3
            r3 = r31
            r27 = r4
            r4 = r21
            r21 = r5
            r5 = r11
            r19 = r6
            r28 = 3
            r6 = r7
            r29 = r7
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            r10.post(r15)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            goto L_0x0401
        L_0x03e7:
            r0 = move-exception
            goto L_0x03ea
        L_0x03e9:
            r0 = move-exception
        L_0x03ea:
            r27 = r4
            r1 = r10
            goto L_0x04f4
        L_0x03ef:
            r25 = r2
            r26 = r3
            r27 = r4
            r21 = r5
            r19 = r6
            r29 = r7
            r24 = r10
            r22 = r15
            r28 = 3
        L_0x0401:
            r6 = r19
            r1 = r20
            r5 = r21
            r15 = r22
            r10 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r7 = r29
            goto L_0x0355
        L_0x0415:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            throw r0     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
        L_0x0425:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r13)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            r2.append(r0)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.lang.String r10 = r2.toString()     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x045b, RuntimeException -> 0x0459 }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x045b, RuntimeException -> 0x0459 }
            throw r0     // Catch:{ IOException -> 0x045b, RuntimeException -> 0x0459 }
        L_0x0459:
            r0 = move-exception
            goto L_0x045c
        L_0x045b:
            r0 = move-exception
        L_0x045c:
            r2 = r10
            r1 = r24
            r10 = r27
            goto L_0x052e
        L_0x0463:
            r0 = move-exception
            goto L_0x04c2
        L_0x0465:
            r0 = move-exception
            goto L_0x04c2
        L_0x0467:
            r28 = 3
            goto L_0x0395
        L_0x046b:
            r0 = move-exception
            goto L_0x046e
        L_0x046d:
            r0 = move-exception
        L_0x046e:
            r27 = r4
            r22 = r15
            r1 = r10
            goto L_0x0506
        L_0x0475:
            r27 = r4
            r24 = r10
            r22 = r15
            r28 = 3
            r27.close()     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            boolean r1 = com.google.android.gms.ads.internal.util.zzd.isLoggable(r28)     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            if (r1 == 0) goto L_0x04c5
            java.text.DecimalFormat r1 = zzeoq     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            long r2 = (long) r11     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            int r2 = r2.length()     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            int r3 = r3.length()     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            r3.<init>(r2)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            r3.append(r1)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            r3.append(r9)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            com.google.android.gms.ads.internal.util.zzd.zzeb(r1)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            goto L_0x04c5
        L_0x04bd:
            r0 = move-exception
            goto L_0x04c0
        L_0x04bf:
            r0 = move-exception
        L_0x04c0:
            r15 = r22
        L_0x04c2:
            r1 = r24
            goto L_0x0506
        L_0x04c5:
            r1 = 0
            r2 = 1
            r12.setReadable(r2, r1)     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            if (r1 == 0) goto L_0x04d8
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x04bf, RuntimeException -> 0x04bd }
            goto L_0x04db
        L_0x04d8:
            r0.createNewFile()     // Catch:{ IOException -> 0x04db, RuntimeException -> 0x04bd }
        L_0x04db:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            r8.zza((java.lang.String) r9, (java.lang.String) r0, (int) r11)     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            java.util.Set<java.lang.String> r0 = zzeop     // Catch:{ IOException -> 0x04f1, RuntimeException -> 0x04ef }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x04ed, RuntimeException -> 0x04eb }
            r0 = 1
            return r0
        L_0x04eb:
            r0 = move-exception
            goto L_0x04f4
        L_0x04ed:
            r0 = move-exception
            goto L_0x04f4
        L_0x04ef:
            r0 = move-exception
            goto L_0x04f2
        L_0x04f1:
            r0 = move-exception
        L_0x04f2:
            r1 = r24
        L_0x04f4:
            r15 = r22
            goto L_0x0506
        L_0x04f7:
            r0 = move-exception
            goto L_0x04fa
        L_0x04f9:
            r0 = move-exception
        L_0x04fa:
            r27 = r4
            r1 = r10
            goto L_0x0504
        L_0x04fe:
            r0 = move-exception
            goto L_0x0501
        L_0x0500:
            r0 = move-exception
        L_0x0501:
            r27 = r4
            r1 = r14
        L_0x0504:
            r22 = r15
        L_0x0506:
            r10 = r27
            r2 = 0
            goto L_0x052e
        L_0x050a:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            java.lang.String r2 = "Invalid protocol."
            r0.<init>(r2)     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            throw r0     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
        L_0x0515:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            java.lang.String r2 = "Too many redirects (20)"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            throw r0     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
        L_0x0520:
            r0 = move-exception
            goto L_0x0523
        L_0x0522:
            r0 = move-exception
        L_0x0523:
            r15 = r22
            goto L_0x052c
        L_0x0526:
            r0 = move-exception
            goto L_0x0529
        L_0x0528:
            r0 = move-exception
        L_0x0529:
            r1 = r14
            r22 = r15
        L_0x052c:
            r2 = 0
            r10 = 0
        L_0x052e:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x053b
            com.google.android.gms.internal.ads.zzayg r3 = com.google.android.gms.ads.internal.zzp.zzku()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zza(r0, r4)
        L_0x053b:
            r10.close()     // Catch:{ IOException | NullPointerException -> 0x053e }
        L_0x053e:
            boolean r3 = r8.zzeor
            if (r3 == 0) goto L_0x0566
            java.lang.String r0 = java.lang.String.valueOf(r31)
            int r0 = r0.length()
            int r0 = r0 + 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r3.append(r0)
            r3.append(r9)
            java.lang.String r0 = "\""
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)
            goto L_0x0589
        L_0x0566:
            java.lang.String r3 = java.lang.String.valueOf(r31)
            int r3 = r3.length()
            int r3 = r3 + 25
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Preload failed for URL \""
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = "\""
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzd(r3, r0)
        L_0x0589:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x05b3
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x05b3
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r3 = r12.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x05aa
            java.lang.String r0 = r0.concat(r3)
            goto L_0x05b0
        L_0x05aa:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
            r0 = r3
        L_0x05b0:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)
        L_0x05b3:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r15, r2)
            java.util.Set<java.lang.String> r0 = zzeop
            r0.remove(r1)
            r1 = 0
            return r1
        L_0x05c1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x05c1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbde.zzfj(java.lang.String):boolean");
    }
}
