package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjo;
import com.google.firebase.FirebaseError;
import com.parse.ParseException;
import com.unboundid.asn1.ASN1Constants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import org.spongycastle.crypto.tls.CipherSuite;

public final class zzkm implements zzjw {
    private static final zzkb zzaph = new zzkp();
    private static final byte[] zzapi = {ASN1Constants.UNIVERSAL_SET_TYPE, 10, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 58, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 58, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 44, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 32, 45, 45, 62, 32, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 58, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 58, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 44, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 10};
    private static final byte[] zzapj = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID zzapk = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaif;
    private final zzkt zzapb;
    private final zzkk zzapl;
    private final SparseArray<zzkr> zzapm;
    private final boolean zzapn;
    private final zzpn zzapo;
    private final zzpn zzapp;
    private final zzpn zzapq;
    private final zzpn zzapr;
    private final zzpn zzaps;
    private final zzpn zzapt;
    private final zzpn zzapu;
    private final zzpn zzapv;
    private final zzpn zzapw;
    private ByteBuffer zzapx;
    private long zzapy;
    private long zzapz;
    private long zzaqa;
    private long zzaqb;
    private zzkr zzaqc;
    private boolean zzaqd;
    private int zzaqe;
    private long zzaqf;
    private boolean zzaqg;
    private long zzaqh;
    private long zzaqi;
    private long zzaqj;
    private zzph zzaqk;
    private zzph zzaql;
    private boolean zzaqm;
    private int zzaqn;
    private long zzaqo;
    private long zzaqp;
    private int zzaqq;
    private int zzaqr;
    private int[] zzaqs;
    private int zzaqt;
    private int zzaqu;
    private int zzaqv;
    private int zzaqw;
    private boolean zzaqx;
    private boolean zzaqy;
    private boolean zzaqz;
    private boolean zzara;
    private byte zzarb;
    private int zzarc;
    private int zzard;
    private int zzare;
    private boolean zzarf;
    private boolean zzarg;
    private zzjy zzarh;

    public zzkm() {
        this(0);
    }

    private zzkm(int i) {
        this(new zzkj(), 0);
    }

    private zzkm(zzkk zzkk, int i) {
        this.zzapz = -1;
        this.zzaqa = -9223372036854775807L;
        this.zzaqb = -9223372036854775807L;
        this.zzaif = -9223372036854775807L;
        this.zzaqh = -1;
        this.zzaqi = -1;
        this.zzaqj = -9223372036854775807L;
        this.zzapl = zzkk;
        this.zzapl.zza(new zzko(this, (zzkp) null));
        this.zzapn = true;
        this.zzapb = new zzkt();
        this.zzapm = new SparseArray<>();
        this.zzapq = new zzpn(4);
        this.zzapr = new zzpn(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzaps = new zzpn(4);
        this.zzapo = new zzpn(zzpi.zzbjq);
        this.zzapp = new zzpn(4);
        this.zzapt = new zzpn();
        this.zzapu = new zzpn();
        this.zzapv = new zzpn(8);
        this.zzapw = new zzpn();
    }

    private final int zza(zzjz zzjz, zzkh zzkh, int i) {
        int i2;
        int zzja = this.zzapt.zzja();
        if (zzja > 0) {
            i2 = Math.min(i, zzja);
            zzkh.zza(this.zzapt, i2);
        } else {
            i2 = zzkh.zza(zzjz, i, false);
        }
        this.zzaqw += i2;
        this.zzare += i2;
        return i2;
    }

    private final void zza(zzjz zzjz, zzkr zzkr, int i) {
        int i2;
        if ("S_TEXT/UTF8".equals(zzkr.zzark)) {
            int length = zzapi.length + i;
            if (this.zzapu.capacity() < length) {
                this.zzapu.data = Arrays.copyOf(zzapi, length + i);
            }
            zzjz.readFully(this.zzapu.data, zzapi.length, i);
            this.zzapu.zzbl(0);
            this.zzapu.zzbk(length);
            return;
        }
        zzkh zzkh = zzkr.zzaso;
        if (!this.zzaqx) {
            if (zzkr.zzarm) {
                this.zzaqv &= -1073741825;
                int i3 = 128;
                if (!this.zzaqy) {
                    zzjz.readFully(this.zzapq.data, 0, 1);
                    this.zzaqw++;
                    if ((this.zzapq.data[0] & 128) != 128) {
                        this.zzarb = this.zzapq.data[0];
                        this.zzaqy = true;
                    } else {
                        throw new zzhw("Extension bit is set in signal byte");
                    }
                }
                byte b = this.zzarb;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzaqv |= 1073741824;
                    if (!this.zzaqz) {
                        zzjz.readFully(this.zzapv.data, 0, 8);
                        this.zzaqw += 8;
                        this.zzaqz = true;
                        byte[] bArr = this.zzapq.data;
                        if (!z) {
                            i3 = 0;
                        }
                        bArr[0] = (byte) (i3 | 8);
                        this.zzapq.zzbl(0);
                        zzkh.zza(this.zzapq, 1);
                        this.zzare++;
                        this.zzapv.zzbl(0);
                        zzkh.zza(this.zzapv, 8);
                        this.zzare += 8;
                    }
                    if (z) {
                        if (!this.zzara) {
                            zzjz.readFully(this.zzapq.data, 0, 1);
                            this.zzaqw++;
                            this.zzapq.zzbl(0);
                            this.zzarc = this.zzapq.readUnsignedByte();
                            this.zzara = true;
                        }
                        int i4 = this.zzarc << 2;
                        this.zzapq.reset(i4);
                        zzjz.readFully(this.zzapq.data, 0, i4);
                        this.zzaqw += i4;
                        short s = (short) ((this.zzarc / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzapx;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.zzapx = ByteBuffer.allocate(i5);
                        }
                        this.zzapx.position(0);
                        this.zzapx.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.zzarc;
                            if (i6 >= i2) {
                                break;
                            }
                            int zzjf = this.zzapq.zzjf();
                            if (i6 % 2 == 0) {
                                this.zzapx.putShort((short) (zzjf - i7));
                            } else {
                                this.zzapx.putInt(zzjf - i7);
                            }
                            i6++;
                            i7 = zzjf;
                        }
                        int i8 = (i - this.zzaqw) - i7;
                        if (i2 % 2 == 1) {
                            this.zzapx.putInt(i8);
                        } else {
                            this.zzapx.putShort((short) i8);
                            this.zzapx.putInt(0);
                        }
                        this.zzapw.zzc(this.zzapx.array(), i5);
                        zzkh.zza(this.zzapw, i5);
                        this.zzare += i5;
                    }
                }
            } else if (zzkr.zzarn != null) {
                this.zzapt.zzc(zzkr.zzarn, zzkr.zzarn.length);
            }
            this.zzaqx = true;
        }
        int limit = i + this.zzapt.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzkr.zzark) && !"V_MPEGH/ISO/HEVC".equals(zzkr.zzark)) {
            while (true) {
                int i9 = this.zzaqw;
                if (i9 >= limit) {
                    break;
                }
                zza(zzjz, zzkh, limit - i9);
            }
        } else {
            byte[] bArr2 = this.zzapp.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i10 = zzkr.zzasp;
            int i11 = 4 - zzkr.zzasp;
            while (this.zzaqw < limit) {
                int i12 = this.zzard;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzapt.zzja());
                    zzjz.readFully(bArr2, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzapt.zze(bArr2, i11, min);
                    }
                    this.zzaqw += i10;
                    this.zzapp.zzbl(0);
                    this.zzard = this.zzapp.zzjf();
                    this.zzapo.zzbl(0);
                    zzkh.zza(this.zzapo, 4);
                    this.zzare += 4;
                } else {
                    this.zzard = i12 - zza(zzjz, zzkh, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzkr.zzark)) {
            this.zzapr.zzbl(0);
            zzkh.zza(this.zzapr, 4);
            this.zzare += 4;
        }
    }

    private final void zza(zzkr zzkr, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzkr.zzark)) {
            byte[] bArr2 = this.zzapu.data;
            long j2 = this.zzaqp;
            if (j2 == -9223372036854775807L) {
                bArr = zzapj;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzpt.zzbg(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzkh zzkh = zzkr.zzaso;
            zzpn zzpn = this.zzapu;
            zzkh.zza(zzpn, zzpn.limit());
            this.zzare += this.zzapu.limit();
        }
        zzkr.zzaso.zza(j, this.zzaqv, this.zzare, 0, zzkr.zzaro);
        this.zzarf = true;
        zzgu();
    }

    private static int[] zza(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }

    static int zzal(int i) {
        switch (i) {
            case 131:
            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA /*136*/:
            case 155:
            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /*159*/:
            case CipherSuite.TLS_PSK_WITH_NULL_SHA256 /*176*/:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384 /*179*/:
            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 /*186*/:
            case 215:
            case 231:
            case 241:
            case ParseException.INVALID_LINKED_SESSION /*251*/:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA /*134*/:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 2274716:
                return 3;
            case 160:
            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256 /*174*/:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384 /*183*/:
            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256 /*187*/:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384 /*161*/:
            case CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 /*163*/:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384 /*181*/:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean zzam(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final void zzb(zzjz zzjz, int i) {
        if (this.zzapq.limit() < i) {
            if (this.zzapq.capacity() < i) {
                zzpn zzpn = this.zzapq;
                zzpn.zzc(Arrays.copyOf(zzpn.data, Math.max(this.zzapq.data.length << 1, i)), this.zzapq.limit());
            }
            zzjz.readFully(this.zzapq.data, this.zzapq.limit(), i - this.zzapq.limit());
            this.zzapq.zzbk(i);
        }
    }

    private final long zzea(long j) {
        long j2 = this.zzaqa;
        if (j2 != -9223372036854775807L) {
            return zzpt.zza(j, j2, 1000);
        }
        throw new zzhw("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void zzgu() {
        this.zzaqw = 0;
        this.zzare = 0;
        this.zzard = 0;
        this.zzaqx = false;
        this.zzaqy = false;
        this.zzara = false;
        this.zzarc = 0;
        this.zzarb = 0;
        this.zzaqz = false;
        this.zzapt.reset();
    }

    public final void release() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r9, com.google.android.gms.internal.ads.zzkc r10) {
        /*
            r8 = this;
            r0 = 0
            r8.zzarf = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r8.zzarf
            if (r3 != 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzkk r2 = r8.zzapl
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L_0x0005
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaqg
            if (r5 == 0) goto L_0x0025
            r8.zzaqi = r3
            long r3 = r8.zzaqh
            r10.position = r3
            r8.zzaqg = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r8.zzaqd
            if (r3 == 0) goto L_0x0036
            long r3 = r8.zzaqi
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r10.position = r3
            r8.zzaqi = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            return r0
        L_0x003d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzaqc.zzahl = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzaqc.zzarz = (float) d;
                    return;
                case 21970:
                    this.zzaqc.zzasa = (float) d;
                    return;
                case 21971:
                    this.zzaqc.zzasb = (float) d;
                    return;
                case 21972:
                    this.zzaqc.zzasc = (float) d;
                    return;
                case 21973:
                    this.zzaqc.zzasd = (float) d;
                    return;
                case 21974:
                    this.zzaqc.zzase = (float) d;
                    return;
                case 21975:
                    this.zzaqc.zzasf = (float) d;
                    return;
                case 21976:
                    this.zzaqc.zzasg = (float) d;
                    return;
                case 21977:
                    this.zzaqc.zzash = (float) d;
                    return;
                case 21978:
                    this.zzaqc.zzasi = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzaqb = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fb, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(int r20, int r21, com.google.android.gms.internal.ads.zzjz r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 4
            r7 = 0
            r8 = 1
            if (r1 == r4) goto L_0x0091
            if (r1 == r5) goto L_0x0091
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0085
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0076
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0058
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004c
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0033
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqc
            byte[] r4 = new byte[r2]
            r1.zzahi = r4
            byte[] r1 = r1.zzahi
            r3.readFully(r1, r7, r2)
            return
        L_0x0033:
            com.google.android.gms.internal.ads.zzhw r2 = new com.google.android.gms.internal.ads.zzhw
            r3 = 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected id: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x004c:
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqc
            byte[] r4 = new byte[r2]
            r1.zzarp = r4
            byte[] r1 = r1.zzarp
            r3.readFully(r1, r7, r2)
            return
        L_0x0058:
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaps
            byte[] r1 = r1.data
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaps
            byte[] r1 = r1.data
            int r6 = r6 - r2
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaps
            r1.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaps
            long r1 = r1.zzjc()
            int r2 = (int) r1
            r0.zzaqe = r2
            return
        L_0x0076:
            byte[] r1 = new byte[r2]
            r3.readFully(r1, r7, r2)
            com.google.android.gms.internal.ads.zzkr r2 = r0.zzaqc
            com.google.android.gms.internal.ads.zzkg r3 = new com.google.android.gms.internal.ads.zzkg
            r3.<init>(r8, r1)
            r2.zzaro = r3
            return
        L_0x0085:
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqc
            byte[] r4 = new byte[r2]
            r1.zzarn = r4
            byte[] r1 = r1.zzarn
            r3.readFully(r1, r7, r2)
            return
        L_0x0091:
            int r4 = r0.zzaqn
            r9 = 8
            if (r4 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzkt r4 = r0.zzapb
            long r10 = r4.zza(r3, r7, r8, r9)
            int r4 = (int) r10
            r0.zzaqt = r4
            com.google.android.gms.internal.ads.zzkt r4 = r0.zzapb
            int r4 = r4.zzgw()
            r0.zzaqu = r4
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzaqp = r10
            r0.zzaqn = r8
            com.google.android.gms.internal.ads.zzpn r4 = r0.zzapq
            r4.reset()
        L_0x00b6:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzkr> r4 = r0.zzapm
            int r10 = r0.zzaqt
            java.lang.Object r4 = r4.get(r10)
            com.google.android.gms.internal.ads.zzkr r4 = (com.google.android.gms.internal.ads.zzkr) r4
            if (r4 != 0) goto L_0x00cc
            int r1 = r0.zzaqu
            int r1 = r2 - r1
            r3.zzag(r1)
            r0.zzaqn = r7
            return
        L_0x00cc:
            int r10 = r0.zzaqn
            if (r10 != r8) goto L_0x0282
            r10 = 3
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzapq
            byte[] r11 = r11.data
            r12 = 2
            byte r11 = r11[r12]
            r11 = r11 & 6
            int r11 = r11 >> r8
            r13 = 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00f6
            r0.zzaqr = r8
            int[] r6 = r0.zzaqs
            int[] r6 = zza((int[]) r6, (int) r8)
            r0.zzaqs = r6
            int[] r6 = r0.zzaqs
            int r11 = r0.zzaqu
            int r2 = r2 - r11
            int r2 = r2 - r10
            r6[r7] = r2
            goto L_0x020f
        L_0x00f6:
            if (r1 != r5) goto L_0x027a
            r0.zzb(r3, r6)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzapq
            byte[] r14 = r14.data
            byte r14 = r14[r10]
            r14 = r14 & r13
            int r14 = r14 + r8
            r0.zzaqr = r14
            int[] r14 = r0.zzaqs
            int r15 = r0.zzaqr
            int[] r14 = zza((int[]) r14, (int) r15)
            r0.zzaqs = r14
            if (r11 != r12) goto L_0x011f
            int r10 = r0.zzaqu
            int r2 = r2 - r10
            int r2 = r2 - r6
            int r6 = r0.zzaqr
            int r2 = r2 / r6
            int[] r10 = r0.zzaqs
            java.util.Arrays.fill(r10, r7, r6, r2)
            goto L_0x020f
        L_0x011f:
            if (r11 != r8) goto L_0x0157
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x0124:
            int r14 = r0.zzaqr
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x014b
            int[] r14 = r0.zzaqs
            r14[r6] = r7
        L_0x012e:
            int r10 = r10 + r8
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzapq
            byte[] r14 = r14.data
            int r15 = r10 + -1
            byte r14 = r14[r15]
            r14 = r14 & r13
            int[] r15 = r0.zzaqs
            r16 = r15[r6]
            int r16 = r16 + r14
            r15[r6] = r16
            if (r14 == r13) goto L_0x012e
            r14 = r15[r6]
            int r11 = r11 + r14
            int r6 = r6 + 1
            goto L_0x0124
        L_0x014b:
            int[] r6 = r0.zzaqs
            int r14 = r14 - r8
            int r15 = r0.zzaqu
            int r2 = r2 - r15
            int r2 = r2 - r10
            int r2 = r2 - r11
            r6[r14] = r2
            goto L_0x020f
        L_0x0157:
            if (r11 != r10) goto L_0x0261
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x015c:
            int r14 = r0.zzaqr
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x0204
            int[] r14 = r0.zzaqs
            r14[r6] = r7
            int r10 = r10 + 1
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzapq
            byte[] r14 = r14.data
            int r15 = r10 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x01fc
            r16 = 0
            r14 = 0
        L_0x0178:
            if (r14 >= r9) goto L_0x01c7
            int r18 = 7 - r14
            int r5 = r8 << r18
            com.google.android.gms.internal.ads.zzpn r12 = r0.zzapq
            byte[] r12 = r12.data
            byte r12 = r12[r15]
            r12 = r12 & r5
            if (r12 == 0) goto L_0x01bd
            int r10 = r10 + r14
            r0.zzb(r3, r10)
            com.google.android.gms.internal.ads.zzpn r12 = r0.zzapq
            byte[] r12 = r12.data
            int r16 = r15 + 1
            byte r12 = r12[r15]
            r12 = r12 & r13
            int r5 = ~r5
            r5 = r5 & r12
            long r7 = (long) r5
            r5 = r16
        L_0x0199:
            r16 = r7
            if (r5 >= r10) goto L_0x01af
            long r7 = r16 << r9
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzapq
            byte[] r15 = r15.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r13
            long r12 = (long) r5
            long r7 = r7 | r12
            r5 = r16
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0199
        L_0x01af:
            if (r6 <= 0) goto L_0x01c7
            int r14 = r14 * 7
            int r14 = r14 + 6
            r7 = 1
            long r12 = r7 << r14
            long r12 = r12 - r7
            long r16 = r16 - r12
            goto L_0x01c7
        L_0x01bd:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0178
        L_0x01c7:
            r7 = r16
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x01f4
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x01f4
            int r5 = (int) r7
            int[] r7 = r0.zzaqs
            if (r6 != 0) goto L_0x01dd
            goto L_0x01e2
        L_0x01dd:
            int r8 = r6 + -1
            r8 = r7[r8]
            int r5 = r5 + r8
        L_0x01e2:
            r7[r6] = r5
            int[] r5 = r0.zzaqs
            r5 = r5[r6]
            int r11 = r11 + r5
            int r6 = r6 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x015c
        L_0x01f4:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x01fc:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x0204:
            int[] r5 = r0.zzaqs
            r6 = 1
            int r14 = r14 - r6
            int r6 = r0.zzaqu
            int r2 = r2 - r6
            int r2 = r2 - r10
            int r2 = r2 - r11
            r5[r14] = r2
        L_0x020f:
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzapq
            byte[] r2 = r2.data
            r5 = 0
            byte r2 = r2[r5]
            int r2 = r2 << r9
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzapq
            byte[] r5 = r5.data
            r6 = 1
            byte r5 = r5[r6]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r2 = r2 | r5
            long r5 = r0.zzaqj
            long r7 = (long) r2
            long r7 = r0.zzea(r7)
            long r5 = r5 + r7
            r0.zzaqo = r5
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzapq
            byte[] r2 = r2.data
            r5 = 2
            byte r2 = r2[r5]
            r2 = r2 & r9
            if (r2 != r9) goto L_0x0238
            r2 = 1
            goto L_0x0239
        L_0x0238:
            r2 = 0
        L_0x0239:
            int r6 = r4.type
            if (r6 == r5) goto L_0x024f
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x024d
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzapq
            byte[] r6 = r6.data
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x024d
            goto L_0x024f
        L_0x024d:
            r5 = 0
            goto L_0x0250
        L_0x024f:
            r5 = 1
        L_0x0250:
            if (r2 == 0) goto L_0x0255
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0256
        L_0x0255:
            r7 = 0
        L_0x0256:
            r2 = r5 | r7
            r0.zzaqv = r2
            r2 = 2
            r0.zzaqn = r2
            r2 = 0
            r0.zzaqq = r2
            goto L_0x0282
        L_0x0261:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected lacing value: "
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x027a:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x0282:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02ad
        L_0x0286:
            int r1 = r0.zzaqq
            int r2 = r0.zzaqr
            if (r1 >= r2) goto L_0x02a9
            int[] r2 = r0.zzaqs
            r1 = r2[r1]
            r0.zza((com.google.android.gms.internal.ads.zzjz) r3, (com.google.android.gms.internal.ads.zzkr) r4, (int) r1)
            long r1 = r0.zzaqo
            int r5 = r0.zzaqq
            int r6 = r4.zzarl
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.zza((com.google.android.gms.internal.ads.zzkr) r4, (long) r1)
            int r1 = r0.zzaqq
            r2 = 1
            int r1 = r1 + r2
            r0.zzaqq = r1
            goto L_0x0286
        L_0x02a9:
            r1 = 0
            r0.zzaqn = r1
            return
        L_0x02ad:
            r1 = 0
            int[] r2 = r0.zzaqs
            r1 = r2[r1]
            r0.zza((com.google.android.gms.internal.ads.zzjz) r3, (com.google.android.gms.internal.ads.zzkr) r4, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.zza(int, int, com.google.android.gms.internal.ads.zzjz):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str) {
        if (i == 134) {
            this.zzaqc.zzark = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.zzaqc.zzahr = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        }
    }

    public final void zza(zzjy zzjy) {
        this.zzarh = zzjy;
    }

    public final boolean zza(zzjz zzjz) {
        return new zzkq().zza(zzjz);
    }

    /* access modifiers changed from: package-private */
    public final void zzan(int i) {
        zzkf zzkf;
        zzph zzph;
        zzph zzph2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzaqc.zzark;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    zzkr zzkr = this.zzaqc;
                    zzkr.zza(this.zzarh, zzkr.number);
                    this.zzapm.put(this.zzaqc.number, this.zzaqc);
                }
                this.zzaqc = null;
            } else if (i == 19899) {
                int i4 = this.zzaqe;
                if (i4 != -1) {
                    long j = this.zzaqf;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzaqh = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzhw("Mandatory element SeekID or SeekPosition not found");
            } else if (i != 25152) {
                if (i != 28032) {
                    if (i == 357149030) {
                        if (this.zzaqa == -9223372036854775807L) {
                            this.zzaqa = 1000000;
                        }
                        long j2 = this.zzaqb;
                        if (j2 != -9223372036854775807L) {
                            this.zzaif = zzea(j2);
                        }
                    } else if (i != 374648427) {
                        if (i == 475249515 && !this.zzaqd) {
                            zzjy zzjy = this.zzarh;
                            if (this.zzapz == -1 || this.zzaif == -9223372036854775807L || (zzph = this.zzaqk) == null || zzph.size() == 0 || (zzph2 = this.zzaql) == null || zzph2.size() != this.zzaqk.size()) {
                                this.zzaqk = null;
                                this.zzaql = null;
                                zzkf = new zzke(this.zzaif);
                            } else {
                                int size = this.zzaqk.size();
                                int[] iArr = new int[size];
                                long[] jArr = new long[size];
                                long[] jArr2 = new long[size];
                                long[] jArr3 = new long[size];
                                for (int i5 = 0; i5 < size; i5++) {
                                    jArr3[i5] = this.zzaqk.get(i5);
                                    jArr[i5] = this.zzapz + this.zzaql.get(i5);
                                }
                                while (true) {
                                    i2 = size - 1;
                                    if (i3 >= i2) {
                                        break;
                                    }
                                    int i6 = i3 + 1;
                                    iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                                    jArr2[i3] = jArr3[i6] - jArr3[i3];
                                    i3 = i6;
                                }
                                iArr[i2] = (int) ((this.zzapz + this.zzapy) - jArr[i2]);
                                jArr2[i2] = this.zzaif - jArr3[i2];
                                this.zzaqk = null;
                                this.zzaql = null;
                                zzkf = new zzju(iArr, jArr, jArr2, jArr3);
                            }
                            zzjy.zza(zzkf);
                            this.zzaqd = true;
                        }
                    } else if (this.zzapm.size() != 0) {
                        this.zzarh.zzgr();
                    } else {
                        throw new zzhw("No valid tracks were found");
                    }
                } else if (this.zzaqc.zzarm && this.zzaqc.zzarn != null) {
                    throw new zzhw("Combining encryption and compression is not supported");
                }
            } else if (!this.zzaqc.zzarm) {
            } else {
                if (this.zzaqc.zzaro != null) {
                    this.zzaqc.zzahd = new zzjo(new zzjo.zza(zzhb.UUID_NIL, "video/webm", this.zzaqc.zzaro.zzaoy));
                    return;
                }
                throw new zzhw("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.zzaqn == 2) {
            if (!this.zzarg) {
                this.zzaqv |= 1;
            }
            zza(this.zzapm.get(this.zzaqt), this.zzaqo);
            this.zzaqn = 0;
        }
    }

    public final void zzc(long j, long j2) {
        this.zzaqj = -9223372036854775807L;
        this.zzaqn = 0;
        this.zzapl.reset();
        this.zzapb.reset();
        zzgu();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j) {
        boolean z = false;
        switch (i) {
            case 131:
                this.zzaqc.type = (int) j;
                return;
            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA /*136*/:
                zzkr zzkr = this.zzaqc;
                if (j == 1) {
                    z = true;
                }
                zzkr.zzasm = z;
                return;
            case 155:
                this.zzaqp = zzea(j);
                return;
            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /*159*/:
                this.zzaqc.zzahk = (int) j;
                return;
            case CipherSuite.TLS_PSK_WITH_NULL_SHA256 /*176*/:
                this.zzaqc.width = (int) j;
                return;
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384 /*179*/:
                this.zzaqk.add(zzea(j));
                return;
            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 /*186*/:
                this.zzaqc.height = (int) j;
                return;
            case 215:
                this.zzaqc.number = (int) j;
                return;
            case 231:
                this.zzaqj = zzea(j);
                return;
            case 241:
                if (!this.zzaqm) {
                    this.zzaql.add(j);
                    this.zzaqm = true;
                    return;
                }
                return;
            case ParseException.INVALID_LINKED_SESSION /*251*/:
                this.zzarg = true;
                return;
            case 16980:
                if (j != 3) {
                    StringBuilder sb = new StringBuilder(50);
                    sb.append("ContentCompAlgo ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new zzhw(sb.toString());
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("DocTypeReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzhw(sb2.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("EBMLReadVersion ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw new zzhw(sb3.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    StringBuilder sb4 = new StringBuilder(49);
                    sb4.append("ContentEncAlgo ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzhw(sb4.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    StringBuilder sb5 = new StringBuilder(56);
                    sb5.append("AESSettingsCipherMode ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw new zzhw(sb5.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    StringBuilder sb6 = new StringBuilder(55);
                    sb6.append("ContentEncodingOrder ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw new zzhw(sb6.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    StringBuilder sb7 = new StringBuilder(55);
                    sb7.append("ContentEncodingScope ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw new zzhw(sb7.toString());
                }
                return;
            case 21420:
                this.zzaqf = j + this.zzapz;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 3) {
                    this.zzaqc.zzahh = 1;
                    return;
                } else if (i2 != 15) {
                    switch (i2) {
                        case 0:
                            this.zzaqc.zzahh = 0;
                            return;
                        case 1:
                            this.zzaqc.zzahh = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    this.zzaqc.zzahh = 3;
                    return;
                }
            case 21680:
                this.zzaqc.zzarq = (int) j;
                return;
            case 21682:
                this.zzaqc.zzars = (int) j;
                return;
            case 21690:
                this.zzaqc.zzarr = (int) j;
                return;
            case 21930:
                zzkr zzkr2 = this.zzaqc;
                if (j == 1) {
                    z = true;
                }
                zzkr2.zzasn = z;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.zzaqc.zzarw = 2;
                        return;
                    case 2:
                        this.zzaqc.zzarw = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int i3 = (int) j;
                if (i3 != 1) {
                    if (i3 == 16) {
                        this.zzaqc.zzarv = 6;
                        return;
                    } else if (i3 != 18) {
                        switch (i3) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    } else {
                        this.zzaqc.zzarv = 7;
                        return;
                    }
                }
                this.zzaqc.zzarv = 3;
                return;
            case 21947:
                zzkr zzkr3 = this.zzaqc;
                zzkr3.zzart = true;
                int i4 = (int) j;
                if (i4 == 1) {
                    zzkr3.zzaru = 1;
                    return;
                } else if (i4 != 9) {
                    switch (i4) {
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            zzkr3.zzaru = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    zzkr3.zzaru = 6;
                    return;
                }
            case 21948:
                this.zzaqc.zzarx = (int) j;
                return;
            case 21949:
                this.zzaqc.zzary = (int) j;
                return;
            case 22186:
                this.zzaqc.zzask = j;
                return;
            case 22203:
                this.zzaqc.zzasl = j;
                return;
            case 25188:
                this.zzaqc.zzasj = (int) j;
                return;
            case 2352003:
                this.zzaqc.zzarl = (int) j;
                return;
            case 2807729:
                this.zzaqa = j;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j, long j2) {
        if (i == 160) {
            this.zzarg = false;
        } else if (i == 174) {
            this.zzaqc = new zzkr((zzkp) null);
        } else if (i == 187) {
            this.zzaqm = false;
        } else if (i == 19899) {
            this.zzaqe = -1;
            this.zzaqf = -1;
        } else if (i == 20533) {
            this.zzaqc.zzarm = true;
        } else if (i == 21968) {
            this.zzaqc.zzart = true;
        } else if (i == 25152) {
        } else {
            if (i == 408125543) {
                long j3 = this.zzapz;
                if (j3 == -1 || j3 == j) {
                    this.zzapz = j;
                    this.zzapy = j2;
                    return;
                }
                throw new zzhw("Multiple Segment elements not supported");
            } else if (i == 475249515) {
                this.zzaqk = new zzph();
                this.zzaql = new zzph();
            } else if (i != 524531317 || this.zzaqd) {
            } else {
                if (!this.zzapn || this.zzaqh == -1) {
                    this.zzarh.zza(new zzke(this.zzaif));
                    this.zzaqd = true;
                    return;
                }
                this.zzaqg = true;
            }
        }
    }
}
