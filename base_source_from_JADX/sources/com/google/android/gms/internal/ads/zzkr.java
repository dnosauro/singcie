package com.google.android.gms.internal.ads;

import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzkr {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjo zzahd;
    public int zzahh;
    public byte[] zzahi;
    public int zzahk;
    public int zzahl;
    /* access modifiers changed from: private */
    public String zzahr;
    public String zzark;
    public int zzarl;
    public boolean zzarm;
    public byte[] zzarn;
    public zzkg zzaro;
    public byte[] zzarp;
    public int zzarq;
    public int zzarr;
    public int zzars;
    public boolean zzart;
    public int zzaru;
    public int zzarv;
    public int zzarw;
    public int zzarx;
    public int zzary;
    public float zzarz;
    public float zzasa;
    public float zzasb;
    public float zzasc;
    public float zzasd;
    public float zzase;
    public float zzasf;
    public float zzasg;
    public float zzash;
    public float zzasi;
    public int zzasj;
    public long zzask;
    public long zzasl;
    public boolean zzasm;
    public boolean zzasn;
    public zzkh zzaso;
    public int zzasp;

    private zzkr() {
        this.width = -1;
        this.height = -1;
        this.zzarq = -1;
        this.zzarr = -1;
        this.zzars = 0;
        this.zzahi = null;
        this.zzahh = -1;
        this.zzart = false;
        this.zzaru = -1;
        this.zzarv = -1;
        this.zzarw = -1;
        this.zzarx = ParseQuery.MAX_LIMIT;
        this.zzary = 200;
        this.zzarz = -1.0f;
        this.zzasa = -1.0f;
        this.zzasb = -1.0f;
        this.zzasc = -1.0f;
        this.zzasd = -1.0f;
        this.zzase = -1.0f;
        this.zzasf = -1.0f;
        this.zzasg = -1.0f;
        this.zzash = -1.0f;
        this.zzasi = -1.0f;
        this.zzahk = 1;
        this.zzasj = -1;
        this.zzahl = 8000;
        this.zzask = 0;
        this.zzasl = 0;
        this.zzasn = true;
        this.zzahr = "eng";
    }

    /* synthetic */ zzkr(zzkp zzkp) {
        this();
    }

    private static List<byte[]> zza(zzpn zzpn) {
        try {
            zzpn.zzbm(16);
            if (zzpn.zzjd() != 826496599) {
                return null;
            }
            byte[] bArr = zzpn.data;
            for (int position = zzpn.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing FourCC VC1 codec private");
        }
    }

    private static boolean zzb(zzpn zzpn) {
        try {
            int zzjb = zzpn.zzjb();
            if (zzjb == 1) {
                return true;
            }
            if (zzjb == 65534) {
                zzpn.zzbl(24);
                return zzpn.readLong() == zzkm.zzapk.getMostSignificantBits() && zzpn.readLong() == zzkm.zzapk.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhw("Error parsing vorbis codec private");
                    }
                    throw new zzhw("Error parsing vorbis codec private");
                }
                throw new zzhw("Error parsing vorbis codec private");
            }
            throw new zzhw("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing vorbis codec private");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c1, code lost:
        r13 = r1;
        r19 = r2;
        r2 = null;
        r16 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x022e, code lost:
        r13 = r1;
        r2 = null;
        r16 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0236, code lost:
        r2 = r0.zzarp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x023c, code lost:
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02db, code lost:
        r0.zzasp = r2;
        r13 = r1;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02f1, code lost:
        r13 = r1;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02f3, code lost:
        r16 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02f5, code lost:
        r19 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02f7, code lost:
        r1 = r0.zzasn | false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02fc, code lost:
        if (r0.zzasm == false) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02fe, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0300, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0301, code lost:
        r1 = r1 | r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0306, code lost:
        if (com.google.android.gms.internal.ads.zzpj.zzbc(r13) == false) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0308, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r29), r13, (java.lang.String) null, -1, r16, r0.zzahk, r0.zzahl, r19, r2, r0.zzahd, r1 ? 1 : 0, r0.zzahr);
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032d, code lost:
        if (com.google.android.gms.internal.ads.zzpj.zzbd(r13) == false) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0331, code lost:
        if (r0.zzars != 0) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0333, code lost:
        r1 = r0.zzarq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0335, code lost:
        if (r1 != -1) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0337, code lost:
        r1 = r0.width;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0339, code lost:
        r0.zzarq = r1;
        r1 = r0.zzarr;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x033d, code lost:
        if (r1 != -1) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x033f, code lost:
        r1 = r0.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0341, code lost:
        r0.zzarr = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0343, code lost:
        r1 = r0.zzarq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0347, code lost:
        if (r1 == -1) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0349, code lost:
        r5 = r0.zzarr;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x034b, code lost:
        if (r5 == -1) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x034d, code lost:
        r22 = ((float) (r0.height * r1)) / ((float) (r0.width * r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x035b, code lost:
        r22 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x035f, code lost:
        if (r0.zzart == false) goto L_0x0426;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0365, code lost:
        if (r0.zzarz == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x036b, code lost:
        if (r0.zzasa == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0371, code lost:
        if (r0.zzasb == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0377, code lost:
        if (r0.zzasc == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x037d, code lost:
        if (r0.zzasd == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0383, code lost:
        if (r0.zzase == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0389, code lost:
        if (r0.zzasf == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x038f, code lost:
        if (r0.zzasg == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0395, code lost:
        if (r0.zzash == -1.0f) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x039b, code lost:
        if (r0.zzasi != -1.0f) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x039e, code lost:
        r11 = new byte[25];
        r1 = java.nio.ByteBuffer.wrap(r11);
        r1.put((byte) 0);
        r1.putShort((short) ((int) ((r0.zzarz * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzasa * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzasb * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzasc * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzasd * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzase * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzasf * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) ((r0.zzasg * 50000.0f) + 0.5f)));
        r1.putShort((short) ((int) (r0.zzash + 0.5f)));
        r1.putShort((short) ((int) (r0.zzasi + 0.5f)));
        r1.putShort((short) r0.zzarx);
        r1.putShort((short) r0.zzary);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0418, code lost:
        r25 = new com.google.android.gms.internal.ads.zzpu(r0.zzaru, r0.zzarw, r0.zzarv, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0426, code lost:
        r25 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0428, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r29), r13, (java.lang.String) null, -1, r16, r0.width, r0.height, -1.0f, r2, -1, r22, r0.zzahi, r0.zzahh, r25, r0.zzahd);
        r9 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0454, code lost:
        if ("application/x-subrip".equals(r13) == false) goto L_0x046b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0456, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r29), r13, (java.lang.String) null, -1, r1 ? 1 : 0, r0.zzahr, r0.zzahd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0471, code lost:
        if ("application/vobsub".equals(r13) != false) goto L_0x048c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0479, code lost:
        if ("application/pgs".equals(r13) != false) goto L_0x048c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0481, code lost:
        if ("application/dvbsubs".equals(r13) == false) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x048b, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x048c, code lost:
        r1 = com.google.android.gms.internal.ads.zzhp.zza(java.lang.Integer.toString(r29), r13, (java.lang.String) null, -1, r2, r0.zzahr, r0.zzahd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04a0, code lost:
        r0.zzaso = r28.zzc(r0.number, r9);
        r0.zzaso.zze(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04af, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a8, code lost:
        r12.append("Unsupported PCM bit depth: ");
        r12.append(r4);
        r12.append(". Setting mimeType to ");
        r12.append(r1);
        r4 = r12.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01bc, code lost:
        android.util.Log.w(r2, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzjy r28, int r29) {
        /*
            r27 = this;
            r0 = r27
            java.lang.String r1 = r0.zzark
            int r2 = r1.hashCode()
            r3 = 25
            r4 = 4
            r5 = 8
            r6 = 1
            r7 = 2
            r8 = 0
            r9 = 3
            r10 = -1
            switch(r2) {
                case -2095576542: goto L_0x014c;
                case -2095575984: goto L_0x0142;
                case -1985379776: goto L_0x0137;
                case -1784763192: goto L_0x012c;
                case -1730367663: goto L_0x0121;
                case -1482641358: goto L_0x0116;
                case -1482641357: goto L_0x010b;
                case -1373388978: goto L_0x0100;
                case -933872740: goto L_0x00f5;
                case -538363189: goto L_0x00ea;
                case -538363109: goto L_0x00df;
                case -425012669: goto L_0x00d3;
                case -356037306: goto L_0x00c7;
                case 62923557: goto L_0x00bb;
                case 62923603: goto L_0x00af;
                case 62927045: goto L_0x00a3;
                case 82338133: goto L_0x0098;
                case 82338134: goto L_0x008d;
                case 99146302: goto L_0x0081;
                case 444813526: goto L_0x0075;
                case 542569478: goto L_0x0069;
                case 725957860: goto L_0x005d;
                case 855502857: goto L_0x0052;
                case 1422270023: goto L_0x0046;
                case 1809237540: goto L_0x003b;
                case 1950749482: goto L_0x002f;
                case 1950789798: goto L_0x0023;
                case 1951062397: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0156
        L_0x0017:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 11
            goto L_0x0157
        L_0x0023:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 21
            goto L_0x0157
        L_0x002f:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 16
            goto L_0x0157
        L_0x003b:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 2
            goto L_0x0157
        L_0x0046:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 24
            goto L_0x0157
        L_0x0052:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 7
            goto L_0x0157
        L_0x005d:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 23
            goto L_0x0157
        L_0x0069:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 19
            goto L_0x0157
        L_0x0075:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 9
            goto L_0x0157
        L_0x0081:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 26
            goto L_0x0157
        L_0x008d:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 1
            goto L_0x0157
        L_0x0098:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 0
            goto L_0x0157
        L_0x00a3:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 18
            goto L_0x0157
        L_0x00af:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 15
            goto L_0x0157
        L_0x00bb:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 12
            goto L_0x0157
        L_0x00c7:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 20
            goto L_0x0157
        L_0x00d3:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 25
            goto L_0x0157
        L_0x00df:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 6
            goto L_0x0157
        L_0x00ea:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 4
            goto L_0x0157
        L_0x00f5:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 27
            goto L_0x0157
        L_0x0100:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 8
            goto L_0x0157
        L_0x010b:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 14
            goto L_0x0157
        L_0x0116:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 13
            goto L_0x0157
        L_0x0121:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 10
            goto L_0x0157
        L_0x012c:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 17
            goto L_0x0157
        L_0x0137:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 22
            goto L_0x0157
        L_0x0142:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 3
            goto L_0x0157
        L_0x014c:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0156
            r1 = 5
            goto L_0x0157
        L_0x0156:
            r1 = -1
        L_0x0157:
            r2 = 4096(0x1000, float:5.74E-42)
            r11 = 0
            switch(r1) {
                case 0: goto L_0x02ef;
                case 1: goto L_0x02ec;
                case 2: goto L_0x02e9;
                case 3: goto L_0x02e0;
                case 4: goto L_0x02e0;
                case 5: goto L_0x02e0;
                case 6: goto L_0x02ca;
                case 7: goto L_0x02b8;
                case 8: goto L_0x0298;
                case 9: goto L_0x0295;
                case 10: goto L_0x0285;
                case 11: goto L_0x023f;
                case 12: goto L_0x0234;
                case 13: goto L_0x022c;
                case 14: goto L_0x0229;
                case 15: goto L_0x0225;
                case 16: goto L_0x0221;
                case 17: goto L_0x021d;
                case 18: goto L_0x0219;
                case 19: goto L_0x0219;
                case 20: goto L_0x0215;
                case 21: goto L_0x0212;
                case 22: goto L_0x01c9;
                case 23: goto L_0x0189;
                case 24: goto L_0x0185;
                case 25: goto L_0x0181;
                case 26: goto L_0x017d;
                case 27: goto L_0x0165;
                default: goto L_0x015d;
            }
        L_0x015d:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0165:
            java.lang.String r1 = "application/dvbsubs"
            byte[] r2 = new byte[r4]
            byte[] r4 = r0.zzarp
            byte r5 = r4[r8]
            r2[r8] = r5
            byte r5 = r4[r6]
            r2[r6] = r5
            byte r5 = r4[r7]
            r2[r7] = r5
            byte r4 = r4[r9]
            r2[r9] = r4
            goto L_0x0238
        L_0x017d:
            java.lang.String r1 = "application/pgs"
            goto L_0x02f1
        L_0x0181:
            java.lang.String r1 = "application/vobsub"
            goto L_0x0236
        L_0x0185:
            java.lang.String r1 = "application/x-subrip"
            goto L_0x02f1
        L_0x0189:
            java.lang.String r1 = "audio/raw"
            int r2 = r0.zzasj
            int r2 = com.google.android.gms.internal.ads.zzpt.zzbo(r2)
            if (r2 != 0) goto L_0x01c1
            java.lang.String r1 = "audio/x-unknown"
            java.lang.String r2 = "MatroskaExtractor"
            int r4 = r0.zzasj
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r5 = r5.length()
            int r5 = r5 + 60
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r5)
        L_0x01a8:
            java.lang.String r5 = "Unsupported PCM bit depth: "
            r12.append(r5)
            r12.append(r4)
            java.lang.String r4 = ". Setting mimeType to "
            r12.append(r4)
            r12.append(r1)
            java.lang.String r4 = r12.toString()
        L_0x01bc:
            android.util.Log.w(r2, r4)
            goto L_0x02f1
        L_0x01c1:
            r13 = r1
            r19 = r2
            r2 = r11
            r16 = -1
            goto L_0x02f7
        L_0x01c9:
            java.lang.String r1 = "audio/raw"
            com.google.android.gms.internal.ads.zzpn r2 = new com.google.android.gms.internal.ads.zzpn
            byte[] r4 = r0.zzarp
            r2.<init>((byte[]) r4)
            boolean r2 = zzb(r2)
            if (r2 == 0) goto L_0x01f6
            int r2 = r0.zzasj
            int r2 = com.google.android.gms.internal.ads.zzpt.zzbo(r2)
            if (r2 != 0) goto L_0x01c1
            java.lang.String r1 = "audio/x-unknown"
            java.lang.String r2 = "MatroskaExtractor"
            int r4 = r0.zzasj
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r5 = r5.length()
            int r5 = r5 + 60
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r5)
            goto L_0x01a8
        L_0x01f6:
            java.lang.String r1 = "audio/x-unknown"
            java.lang.String r2 = "MatroskaExtractor"
            java.lang.String r4 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r12 = r5.length()
            if (r12 == 0) goto L_0x020b
            java.lang.String r4 = r4.concat(r5)
            goto L_0x01bc
        L_0x020b:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
            goto L_0x01bc
        L_0x0212:
            java.lang.String r1 = "audio/x-flac"
            goto L_0x0236
        L_0x0215:
            java.lang.String r1 = "audio/vnd.dts.hd"
            goto L_0x02f1
        L_0x0219:
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x02f1
        L_0x021d:
            java.lang.String r1 = "audio/true-hd"
            goto L_0x02f1
        L_0x0221:
            java.lang.String r1 = "audio/eac3"
            goto L_0x02f1
        L_0x0225:
            java.lang.String r1 = "audio/ac3"
            goto L_0x02f1
        L_0x0229:
            java.lang.String r1 = "audio/mpeg"
            goto L_0x022e
        L_0x022c:
            java.lang.String r1 = "audio/mpeg-L2"
        L_0x022e:
            r13 = r1
            r2 = r11
            r16 = 4096(0x1000, float:5.74E-42)
            goto L_0x02f5
        L_0x0234:
            java.lang.String r1 = "audio/mp4a-latm"
        L_0x0236:
            byte[] r2 = r0.zzarp
        L_0x0238:
            java.util.List r2 = java.util.Collections.singletonList(r2)
        L_0x023c:
            r13 = r1
            goto L_0x02f3
        L_0x023f:
            java.lang.String r1 = "audio/opus"
            r2 = 5760(0x1680, float:8.071E-42)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r9)
            byte[] r12 = r0.zzarp
            r4.add(r12)
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r13 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r12 = r12.order(r13)
            long r13 = r0.zzask
            java.nio.ByteBuffer r12 = r12.putLong(r13)
            byte[] r12 = r12.array()
            r4.add(r12)
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r12 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r5 = r5.order(r12)
            long r12 = r0.zzasl
            java.nio.ByteBuffer r5 = r5.putLong(r12)
            byte[] r5 = r5.array()
            r4.add(r5)
            r13 = r1
            r2 = r4
            r16 = 5760(0x1680, float:8.071E-42)
            goto L_0x02f5
        L_0x0285:
            java.lang.String r1 = "audio/vorbis"
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = r0.zzarp
            java.util.List r4 = zzd(r4)
            r13 = r1
            r2 = r4
            r16 = 8192(0x2000, float:1.14794E-41)
            goto L_0x02f5
        L_0x0295:
            java.lang.String r1 = "video/x-unknown"
            goto L_0x02f1
        L_0x0298:
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r2 = r0.zzarp
            r1.<init>((byte[]) r2)
            java.util.List r1 = zza(r1)
            if (r1 == 0) goto L_0x02a8
            java.lang.String r2 = "video/wvc1"
            goto L_0x02b1
        L_0x02a8:
            java.lang.String r2 = "MatroskaExtractor"
            java.lang.String r4 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r2, r4)
            java.lang.String r2 = "video/x-unknown"
        L_0x02b1:
            r13 = r2
            r16 = -1
            r19 = -1
            r2 = r1
            goto L_0x02f7
        L_0x02b8:
            java.lang.String r1 = "video/hevc"
            com.google.android.gms.internal.ads.zzpn r2 = new com.google.android.gms.internal.ads.zzpn
            byte[] r4 = r0.zzarp
            r2.<init>((byte[]) r4)
            com.google.android.gms.internal.ads.zzqb r2 = com.google.android.gms.internal.ads.zzqb.zzi(r2)
            java.util.List<byte[]> r4 = r2.zzahc
            int r2 = r2.zzasp
            goto L_0x02db
        L_0x02ca:
            java.lang.String r1 = "video/avc"
            com.google.android.gms.internal.ads.zzpn r2 = new com.google.android.gms.internal.ads.zzpn
            byte[] r4 = r0.zzarp
            r2.<init>((byte[]) r4)
            com.google.android.gms.internal.ads.zzpv r2 = com.google.android.gms.internal.ads.zzpv.zzg(r2)
            java.util.List<byte[]> r4 = r2.zzahc
            int r2 = r2.zzasp
        L_0x02db:
            r0.zzasp = r2
            r13 = r1
            r2 = r4
            goto L_0x02f3
        L_0x02e0:
            java.lang.String r1 = "video/mp4v-es"
            byte[] r2 = r0.zzarp
            if (r2 != 0) goto L_0x0238
            r2 = r11
            goto L_0x023c
        L_0x02e9:
            java.lang.String r1 = "video/mpeg2"
            goto L_0x02f1
        L_0x02ec:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x02f1
        L_0x02ef:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
        L_0x02f1:
            r13 = r1
            r2 = r11
        L_0x02f3:
            r16 = -1
        L_0x02f5:
            r19 = -1
        L_0x02f7:
            boolean r1 = r0.zzasn
            r1 = r1 | r8
            boolean r4 = r0.zzasm
            if (r4 == 0) goto L_0x0300
            r4 = 2
            goto L_0x0301
        L_0x0300:
            r4 = 0
        L_0x0301:
            r1 = r1 | r4
            boolean r4 = com.google.android.gms.internal.ads.zzpj.zzbc(r13)
            if (r4 == 0) goto L_0x0329
            java.lang.String r12 = java.lang.Integer.toString(r29)
            r14 = 0
            r15 = -1
            int r3 = r0.zzahk
            int r4 = r0.zzahl
            com.google.android.gms.internal.ads.zzjo r5 = r0.zzahd
            java.lang.String r7 = r0.zzahr
            r17 = r3
            r18 = r4
            r20 = r2
            r21 = r5
            r22 = r1
            r23 = r7
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r9 = 1
            goto L_0x04a0
        L_0x0329:
            boolean r4 = com.google.android.gms.internal.ads.zzpj.zzbd(r13)
            if (r4 == 0) goto L_0x044e
            int r1 = r0.zzars
            if (r1 != 0) goto L_0x0343
            int r1 = r0.zzarq
            if (r1 != r10) goto L_0x0339
            int r1 = r0.width
        L_0x0339:
            r0.zzarq = r1
            int r1 = r0.zzarr
            if (r1 != r10) goto L_0x0341
            int r1 = r0.height
        L_0x0341:
            r0.zzarr = r1
        L_0x0343:
            int r1 = r0.zzarq
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 == r10) goto L_0x035b
            int r5 = r0.zzarr
            if (r5 == r10) goto L_0x035b
            int r6 = r0.height
            int r6 = r6 * r1
            float r1 = (float) r6
            int r6 = r0.width
            int r6 = r6 * r5
            float r5 = (float) r6
            float r1 = r1 / r5
            r22 = r1
            goto L_0x035d
        L_0x035b:
            r22 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x035d:
            boolean r1 = r0.zzart
            if (r1 == 0) goto L_0x0426
            float r1 = r0.zzarz
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasa
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasb
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasc
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasd
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzase
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasf
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasg
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzash
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0418
            float r1 = r0.zzasi
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x039e
            goto L_0x0418
        L_0x039e:
            byte[] r11 = new byte[r3]
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r11)
            r1.put(r8)
            float r3 = r0.zzarz
            r4 = 1195593728(0x47435000, float:50000.0)
            float r3 = r3 * r4
            r5 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasa
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasb
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasc
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasd
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzase
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasf
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasg
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzash
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            float r3 = r0.zzasi
            float r3 = r3 + r5
            int r3 = (int) r3
            short r3 = (short) r3
            r1.putShort(r3)
            int r3 = r0.zzarx
            short r3 = (short) r3
            r1.putShort(r3)
            int r3 = r0.zzary
            short r3 = (short) r3
            r1.putShort(r3)
        L_0x0418:
            com.google.android.gms.internal.ads.zzpu r1 = new com.google.android.gms.internal.ads.zzpu
            int r3 = r0.zzaru
            int r4 = r0.zzarw
            int r5 = r0.zzarv
            r1.<init>(r3, r4, r5, r11)
            r25 = r1
            goto L_0x0428
        L_0x0426:
            r25 = r11
        L_0x0428:
            java.lang.String r12 = java.lang.Integer.toString(r29)
            r14 = 0
            r15 = -1
            int r1 = r0.width
            int r3 = r0.height
            r19 = -1082130432(0xffffffffbf800000, float:-1.0)
            r21 = -1
            byte[] r4 = r0.zzahi
            int r5 = r0.zzahh
            com.google.android.gms.internal.ads.zzjo r6 = r0.zzahd
            r17 = r1
            r18 = r3
            r20 = r2
            r23 = r4
            r24 = r5
            r26 = r6
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r9 = 2
            goto L_0x04a0
        L_0x044e:
            java.lang.String r3 = "application/x-subrip"
            boolean r3 = r3.equals(r13)
            if (r3 == 0) goto L_0x046b
            java.lang.String r12 = java.lang.Integer.toString(r29)
            r14 = 0
            r15 = -1
            java.lang.String r2 = r0.zzahr
            com.google.android.gms.internal.ads.zzjo r3 = r0.zzahd
            r16 = r1
            r17 = r2
            r18 = r3
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (int) r15, (int) r16, (java.lang.String) r17, (com.google.android.gms.internal.ads.zzjo) r18)
            goto L_0x04a0
        L_0x046b:
            java.lang.String r1 = "application/vobsub"
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x048c
            java.lang.String r1 = "application/pgs"
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x048c
            java.lang.String r1 = "application/dvbsubs"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x0484
            goto L_0x048c
        L_0x0484:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x048c:
            java.lang.String r12 = java.lang.Integer.toString(r29)
            r14 = 0
            r15 = -1
            java.lang.String r1 = r0.zzahr
            com.google.android.gms.internal.ads.zzjo r3 = r0.zzahd
            r16 = r2
            r17 = r1
            r18 = r3
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (int) r15, (java.util.List<byte[]>) r16, (java.lang.String) r17, (com.google.android.gms.internal.ads.zzjo) r18)
        L_0x04a0:
            int r2 = r0.number
            r3 = r28
            com.google.android.gms.internal.ads.zzkh r2 = r3.zzc(r2, r9)
            r0.zzaso = r2
            com.google.android.gms.internal.ads.zzkh r2 = r0.zzaso
            r2.zze(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkr.zza(com.google.android.gms.internal.ads.zzjy, int):void");
    }
}
