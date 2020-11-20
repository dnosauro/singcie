package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import org.spongycastle.crypto.tls.CipherSuite;

public final class zzip {
    private static boolean zzajl = false;
    private static boolean zzajm = false;
    private int streamType;
    private zzhv zzafg;
    private int zzahl;
    private final zzig zzajn = null;
    private final zzja zzajo;
    private final zzjf zzajp;
    private final zzif[] zzajq;
    private final zziv zzajr;
    /* access modifiers changed from: private */
    public final ConditionVariable zzajs;
    private final long[] zzajt;
    private final zzir zzaju;
    private final LinkedList<zziy> zzajv;
    private AudioTrack zzajw;
    private int zzajx;
    private int zzajy;
    private int zzajz;
    private boolean zzaka;
    private int zzakb;
    private long zzakc;
    private zzhv zzakd;
    private long zzake;
    private long zzakf;
    private ByteBuffer zzakg;
    private int zzakh;
    private int zzaki;
    private int zzakj;
    private long zzakk;
    private long zzakl;
    private boolean zzakm;
    private long zzakn;
    private Method zzako;
    private int zzakp;
    private long zzakq;
    private long zzakr;
    private int zzaks;
    private long zzakt;
    private long zzaku;
    private int zzakv;
    private int zzakw;
    private long zzakx;
    private long zzaky;
    private long zzakz;
    private zzif[] zzala;
    private ByteBuffer[] zzalb;
    private ByteBuffer zzalc;
    private ByteBuffer zzald;
    private byte[] zzale;
    private int zzalf;
    private int zzalg;
    private boolean zzalh;
    private boolean zzali;
    private int zzalj;
    private boolean zzalk;
    private boolean zzall;
    private long zzalm;
    private float zzdg;

    public zzip(zzig zzig, zzif[] zzifArr, zziv zziv) {
        this.zzajr = zziv;
        this.zzajs = new ConditionVariable(true);
        if (zzpt.SDK_INT >= 18) {
            try {
                this.zzako = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpt.SDK_INT >= 19) {
            this.zzaju = new zziu();
        } else {
            this.zzaju = new zzir((zzis) null);
        }
        this.zzajo = new zzja();
        this.zzajp = new zzjf();
        this.zzajq = new zzif[(zzifArr.length + 3)];
        this.zzajq[0] = new zzjd();
        zzif[] zzifArr2 = this.zzajq;
        zzifArr2[1] = this.zzajo;
        System.arraycopy(zzifArr, 0, zzifArr2, 2, zzifArr.length);
        this.zzajq[zzifArr.length + 2] = this.zzajp;
        this.zzajt = new long[10];
        this.zzdg = 1.0f;
        this.zzakw = 0;
        this.streamType = 3;
        this.zzalj = 0;
        this.zzafg = zzhv.zzahx;
        this.zzalg = -1;
        this.zzala = new zzif[0];
        this.zzalb = new ByteBuffer[0];
        this.zzajv = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzajw != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d9, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzc(java.nio.ByteBuffer r9, long r10) {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.zzald
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zzpc.checkArgument(r0)
            goto L_0x003b
        L_0x0018:
            r8.zzald = r9
            int r0 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.zzale
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.zzale = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.zzale
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.zzalf = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.zzakt
            com.google.android.gms.internal.ads.zzir r2 = r8.zzaju
            long r4 = r2.zzfy()
            int r2 = r8.zzaks
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.zzakb
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.zzajw
            byte[] r2 = r8.zzale
            int r4 = r8.zzalf
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f2
            int r11 = r8.zzalf
            int r11 = r11 + r10
            r8.zzalf = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f2
        L_0x0076:
            r10 = 0
            goto L_0x00f2
        L_0x0079:
            boolean r2 = r8.zzalk
            if (r2 == 0) goto L_0x00ec
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            android.media.AudioTrack r2 = r8.zzajw
            java.nio.ByteBuffer r4 = r8.zzakg
            if (r4 != 0) goto L_0x00a9
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.zzakg = r4
            java.nio.ByteBuffer r4 = r8.zzakg
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.zzakg
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a9:
            int r4 = r8.zzakh
            if (r4 != 0) goto L_0x00c5
            java.nio.ByteBuffer r4 = r8.zzakg
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.zzakg
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.zzakg
            r10.position(r3)
            r8.zzakh = r0
        L_0x00c5:
            java.nio.ByteBuffer r10 = r8.zzakg
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00dc
            java.nio.ByteBuffer r11 = r8.zzakg
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d9
            r8.zzakh = r3
            r10 = r11
            goto L_0x00f2
        L_0x00d9:
            if (r11 >= r10) goto L_0x00dc
            goto L_0x0076
        L_0x00dc:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e5
            r8.zzakh = r3
            goto L_0x00ea
        L_0x00e5:
            int r10 = r8.zzakh
            int r10 = r10 - r9
            r8.zzakh = r10
        L_0x00ea:
            r10 = r9
            goto L_0x00f2
        L_0x00ec:
            android.media.AudioTrack r10 = r8.zzajw
            int r10 = r10.write(r9, r0, r1)
        L_0x00f2:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.zzalm = r4
            if (r10 < 0) goto L_0x0117
            boolean r9 = r8.zzaka
            if (r9 != 0) goto L_0x0104
            long r4 = r8.zzakt
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.zzakt = r4
        L_0x0104:
            if (r10 != r0) goto L_0x0116
            boolean r9 = r8.zzaka
            if (r9 == 0) goto L_0x0112
            long r9 = r8.zzaku
            int r11 = r8.zzakv
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.zzaku = r9
        L_0x0112:
            r9 = 0
            r8.zzald = r9
            return r1
        L_0x0116:
            return r3
        L_0x0117:
            com.google.android.gms.internal.ads.zzix r9 = new com.google.android.gms.internal.ads.zzix
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zzc(java.nio.ByteBuffer, long):boolean");
    }

    private final void zzdv(long j) {
        ByteBuffer byteBuffer;
        int length = this.zzala.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzalb[i - 1];
            } else {
                byteBuffer = this.zzalc;
                if (byteBuffer == null) {
                    byteBuffer = zzif.zzaiw;
                }
            }
            if (i == length) {
                zzc(byteBuffer, j);
            } else {
                zzif zzif = this.zzala[i];
                zzif.zzn(byteBuffer);
                ByteBuffer zzfm = zzif.zzfm();
                this.zzalb[i] = zzfm;
                if (zzfm.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private final long zzdw(long j) {
        return (j * 1000000) / ((long) this.zzahl);
    }

    private final long zzdx(long j) {
        return (j * ((long) this.zzahl)) / 1000000;
    }

    private final void zzfn() {
        ArrayList arrayList = new ArrayList();
        for (zzif zzif : this.zzajq) {
            if (zzif.isActive()) {
                arrayList.add(zzif);
            } else {
                zzif.flush();
            }
        }
        int size = arrayList.size();
        this.zzala = (zzif[]) arrayList.toArray(new zzif[size]);
        this.zzalb = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzif zzif2 = this.zzala[i];
            zzif2.flush();
            this.zzalb[i] = zzif2.zzfm();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzfq() {
        /*
            r9 = this;
            int r0 = r9.zzalg
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzaka
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzif[] r0 = r9.zzala
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzalg = r0
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzalg
            com.google.android.gms.internal.ads.zzif[] r5 = r9.zzala
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0036
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzfl()
        L_0x0028:
            r9.zzdv(r7)
            boolean r0 = r4.zzfe()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzalg
            int r0 = r0 + r2
            goto L_0x0010
        L_0x0036:
            java.nio.ByteBuffer r0 = r9.zzald
            if (r0 == 0) goto L_0x0042
            r9.zzc(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzald
            if (r0 == 0) goto L_0x0042
            return r3
        L_0x0042:
            r9.zzalg = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zzfq():boolean");
    }

    private final void zzfu() {
        if (!isInitialized()) {
            return;
        }
        if (zzpt.SDK_INT >= 21) {
            this.zzajw.setVolume(this.zzdg);
            return;
        }
        AudioTrack audioTrack = this.zzajw;
        float f = this.zzdg;
        audioTrack.setStereoVolume(f, f);
    }

    private final long zzfv() {
        return this.zzaka ? this.zzaku : this.zzakt / ((long) this.zzaks);
    }

    private final void zzfw() {
        this.zzakk = 0;
        this.zzakj = 0;
        this.zzaki = 0;
        this.zzakl = 0;
        this.zzakm = false;
        this.zzakn = 0;
    }

    private final boolean zzfx() {
        if (zzpt.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzajz;
        return i == 5 || i == 6;
    }

    public final void pause() {
        this.zzali = false;
        if (isInitialized()) {
            zzfw();
            this.zzaju.pause();
        }
    }

    public final void play() {
        this.zzali = true;
        if (isInitialized()) {
            this.zzaky = System.nanoTime() / 1000;
            this.zzajw.play();
        }
    }

    public final void release() {
        reset();
        for (zzif reset : this.zzajq) {
            reset.reset();
        }
        this.zzalj = 0;
        this.zzali = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzakq = 0;
            this.zzakr = 0;
            this.zzakt = 0;
            this.zzaku = 0;
            this.zzakv = 0;
            zzhv zzhv = this.zzakd;
            if (zzhv != null) {
                this.zzafg = zzhv;
                this.zzakd = null;
            } else if (!this.zzajv.isEmpty()) {
                this.zzafg = this.zzajv.getLast().zzafg;
            }
            this.zzajv.clear();
            this.zzake = 0;
            this.zzakf = 0;
            this.zzalc = null;
            this.zzald = null;
            int i = 0;
            while (true) {
                zzif[] zzifArr = this.zzala;
                if (i >= zzifArr.length) {
                    break;
                }
                zzif zzif = zzifArr[i];
                zzif.flush();
                this.zzalb[i] = zzif.zzfm();
                i++;
            }
            this.zzalh = false;
            this.zzalg = -1;
            this.zzakg = null;
            this.zzakh = 0;
            this.zzakw = 0;
            this.zzakz = 0;
            zzfw();
            if (this.zzajw.getPlayState() == 3) {
                this.zzajw.pause();
            }
            AudioTrack audioTrack = this.zzajw;
            this.zzajw = null;
            this.zzaju.zza((AudioTrack) null, false);
            this.zzajs.close();
            new zzis(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzalk) {
                reset();
                this.zzalj = 0;
            }
        }
    }

    public final void setVolume(float f) {
        if (this.zzdg != f) {
            this.zzdg = f;
            zzfu();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0136 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r18, int r19, int r20, int r21, int r22, int[] r23) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r20
            java.lang.String r3 = "audio/raw"
            boolean r3 = r3.equals(r0)
            r4 = 1
            r3 = r3 ^ r4
            r5 = 3
            r6 = 7
            r7 = 6
            r8 = 5
            r9 = 2
            if (r3 == 0) goto L_0x0064
            r11 = -1
            int r12 = r18.hashCode()
            r13 = -1095064472(0xffffffffbebaa468, float:-0.36453557)
            if (r12 == r13) goto L_0x004d
            r13 = 187078296(0xb269698, float:3.208373E-32)
            if (r12 == r13) goto L_0x0043
            r13 = 1504578661(0x59ae0c65, float:6.1237842E15)
            if (r12 == r13) goto L_0x0039
            r13 = 1505942594(0x59c2dc42, float:6.8560402E15)
            if (r12 == r13) goto L_0x002f
            goto L_0x0056
        L_0x002f:
            java.lang.String r12 = "audio/vnd.dts.hd"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0056
            r11 = 3
            goto L_0x0056
        L_0x0039:
            java.lang.String r12 = "audio/eac3"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0056
            r11 = 1
            goto L_0x0056
        L_0x0043:
            java.lang.String r12 = "audio/ac3"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0056
            r11 = 0
            goto L_0x0056
        L_0x004d:
            java.lang.String r12 = "audio/vnd.dts"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0056
            r11 = 2
        L_0x0056:
            switch(r11) {
                case 0: goto L_0x0062;
                case 1: goto L_0x0060;
                case 2: goto L_0x005e;
                case 3: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            r0 = 0
            goto L_0x0066
        L_0x005b:
            r0 = 8
            goto L_0x0066
        L_0x005e:
            r0 = 7
            goto L_0x0066
        L_0x0060:
            r0 = 6
            goto L_0x0066
        L_0x0062:
            r0 = 5
            goto L_0x0066
        L_0x0064:
            r0 = r21
        L_0x0066:
            if (r3 != 0) goto L_0x00ac
            r11 = r19
            r12 = r21
            int r12 = com.google.android.gms.internal.ads.zzpt.zzg(r12, r11)
            r1.zzakp = r12
            com.google.android.gms.internal.ads.zzja r12 = r1.zzajo
            r13 = r23
            r12.zzb(r13)
            com.google.android.gms.internal.ads.zzif[] r12 = r1.zzajq
            int r13 = r12.length
            r15 = r0
            r14 = r11
            r0 = 0
            r11 = 0
        L_0x0080:
            if (r0 >= r13) goto L_0x00a4
            r10 = r12[r0]
            boolean r16 = r10.zzb(r2, r14, r15)     // Catch:{ zzii -> 0x009c }
            r11 = r11 | r16
            boolean r16 = r10.isActive()
            if (r16 == 0) goto L_0x0099
            int r14 = r10.zzfj()
            int r10 = r10.zzfk()
            r15 = r10
        L_0x0099:
            int r0 = r0 + 1
            goto L_0x0080
        L_0x009c:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzit r0 = new com.google.android.gms.internal.ads.zzit
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x00a4:
            if (r11 == 0) goto L_0x00a9
            r17.zzfn()
        L_0x00a9:
            r0 = r11
            r11 = r14
            goto L_0x00b0
        L_0x00ac:
            r11 = r19
            r15 = r0
            r0 = 0
        L_0x00b0:
            r12 = 12
            switch(r11) {
                case 1: goto L_0x00e3;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00dd;
                case 4: goto L_0x00da;
                case 5: goto L_0x00d7;
                case 6: goto L_0x00d4;
                case 7: goto L_0x00d1;
                case 8: goto L_0x00ce;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            com.google.android.gms.internal.ads.zzit r0 = new com.google.android.gms.internal.ads.zzit
            r2 = 38
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unsupported channel count: "
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x00ce:
            int r13 = com.google.android.gms.internal.ads.zzhb.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00e4
        L_0x00d1:
            r13 = 1276(0x4fc, float:1.788E-42)
            goto L_0x00e4
        L_0x00d4:
            r13 = 252(0xfc, float:3.53E-43)
            goto L_0x00e4
        L_0x00d7:
            r13 = 220(0xdc, float:3.08E-43)
            goto L_0x00e4
        L_0x00da:
            r13 = 204(0xcc, float:2.86E-43)
            goto L_0x00e4
        L_0x00dd:
            r13 = 28
            goto L_0x00e4
        L_0x00e0:
            r13 = 12
            goto L_0x00e4
        L_0x00e3:
            r13 = 4
        L_0x00e4:
            int r14 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r10 = 23
            if (r14 > r10) goto L_0x010b
            java.lang.String r10 = "foster"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpt.DEVICE
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x010b
            java.lang.String r10 = "NVIDIA"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpt.MANUFACTURER
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x010b
            if (r11 == r5) goto L_0x0108
            if (r11 == r8) goto L_0x0108
            if (r11 == r6) goto L_0x0105
            goto L_0x010b
        L_0x0105:
            int r10 = com.google.android.gms.internal.ads.zzhb.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x010c
        L_0x0108:
            r10 = 252(0xfc, float:3.53E-43)
            goto L_0x010c
        L_0x010b:
            r10 = r13
        L_0x010c:
            int r5 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r6 = 25
            if (r5 > r6) goto L_0x0122
            java.lang.String r5 = "fugu"
            java.lang.String r6 = com.google.android.gms.internal.ads.zzpt.DEVICE
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0122
            if (r3 == 0) goto L_0x0122
            if (r11 != r4) goto L_0x0122
            r10 = 12
        L_0x0122:
            if (r0 != 0) goto L_0x0137
            boolean r0 = r17.isInitialized()
            if (r0 == 0) goto L_0x0137
            int r0 = r1.zzajy
            if (r0 != r15) goto L_0x0137
            int r0 = r1.zzahl
            if (r0 != r2) goto L_0x0137
            int r0 = r1.zzajx
            if (r0 != r10) goto L_0x0137
            return
        L_0x0137:
            r17.reset()
            r1.zzajy = r15
            r1.zzaka = r3
            r1.zzahl = r2
            r1.zzajx = r10
            if (r3 == 0) goto L_0x0145
            goto L_0x0146
        L_0x0145:
            r15 = 2
        L_0x0146:
            r1.zzajz = r15
            int r0 = com.google.android.gms.internal.ads.zzpt.zzg(r9, r11)
            r1.zzaks = r0
            if (r3 == 0) goto L_0x015e
            int r0 = r1.zzajz
            if (r0 == r8) goto L_0x015b
            if (r0 != r7) goto L_0x0157
            goto L_0x015b
        L_0x0157:
            r0 = 49152(0xc000, float:6.8877E-41)
            goto L_0x0194
        L_0x015b:
            r0 = 20480(0x5000, float:2.8699E-41)
            goto L_0x0194
        L_0x015e:
            int r0 = r1.zzajz
            int r0 = android.media.AudioTrack.getMinBufferSize(r2, r10, r0)
            r2 = -2
            if (r0 == r2) goto L_0x0168
            goto L_0x0169
        L_0x0168:
            r4 = 0
        L_0x0169:
            com.google.android.gms.internal.ads.zzpc.checkState(r4)
            int r2 = r0 << 2
            r4 = 250000(0x3d090, double:1.235164E-318)
            long r4 = r1.zzdx(r4)
            int r5 = (int) r4
            int r4 = r1.zzaks
            int r4 = r4 * r5
            long r5 = (long) r0
            r7 = 750000(0xb71b0, double:3.70549E-318)
            long r7 = r1.zzdx(r7)
            int r0 = r1.zzaks
            long r9 = (long) r0
            long r7 = r7 * r9
            long r5 = java.lang.Math.max(r5, r7)
            int r0 = (int) r5
            if (r2 >= r4) goto L_0x0190
            r0 = r4
            goto L_0x0194
        L_0x0190:
            if (r2 <= r0) goto L_0x0193
            goto L_0x0194
        L_0x0193:
            r0 = r2
        L_0x0194:
            r1.zzakb = r0
            if (r3 == 0) goto L_0x019e
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x01a8
        L_0x019e:
            int r0 = r1.zzakb
            int r2 = r1.zzaks
            int r0 = r0 / r2
            long r2 = (long) r0
            long r2 = r1.zzdw(r2)
        L_0x01a8:
            r1.zzakc = r2
            com.google.android.gms.internal.ads.zzhv r0 = r1.zzafg
            r1.zzb(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final zzhv zzb(zzhv zzhv) {
        if (this.zzaka) {
            this.zzafg = zzhv.zzahx;
            return this.zzafg;
        }
        zzhv zzhv2 = new zzhv(this.zzajp.zza(zzhv.zzahy), this.zzajp.zzb(zzhv.zzahz));
        zzhv zzhv3 = this.zzakd;
        if (zzhv3 == null) {
            zzhv3 = !this.zzajv.isEmpty() ? this.zzajv.getLast().zzafg : this.zzafg;
        }
        if (!zzhv2.equals(zzhv3)) {
            if (isInitialized()) {
                this.zzakd = zzhv2;
            } else {
                this.zzafg = zzhv2;
            }
        }
        return this.zzafg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ce A[SYNTHETIC, Splitter:B:23:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(java.nio.ByteBuffer r25, long r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            java.nio.ByteBuffer r4 = r1.zzalc
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0011
            if (r0 != r4) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r4 = 0
            goto L_0x0012
        L_0x0011:
            r4 = 1
        L_0x0012:
            com.google.android.gms.internal.ads.zzpc.checkArgument(r4)
            boolean r4 = r24.isInitialized()
            r7 = 0
            if (r4 != 0) goto L_0x00e6
            android.os.ConditionVariable r4 = r1.zzajs
            r4.block()
            boolean r4 = r1.zzalk
            if (r4 == 0) goto L_0x0066
            int r4 = r1.zzahl
            int r8 = r1.zzajx
            int r9 = r1.zzajz
            int r13 = r1.zzakb
            int r15 = r1.zzalj
            android.media.AudioAttributes$Builder r10 = new android.media.AudioAttributes$Builder
            r10.<init>()
            android.media.AudioAttributes$Builder r10 = r10.setUsage(r6)
            r11 = 3
            android.media.AudioAttributes$Builder r10 = r10.setContentType(r11)
            r11 = 16
            android.media.AudioAttributes$Builder r10 = r10.setFlags(r11)
            android.media.AudioAttributes r11 = r10.build()
            android.media.AudioFormat$Builder r10 = new android.media.AudioFormat$Builder
            r10.<init>()
            android.media.AudioFormat$Builder r8 = r10.setChannelMask(r8)
            android.media.AudioFormat$Builder r8 = r8.setEncoding(r9)
            android.media.AudioFormat$Builder r4 = r8.setSampleRate(r4)
            android.media.AudioFormat r12 = r4.build()
            android.media.AudioTrack r4 = new android.media.AudioTrack
            r14 = 1
            r10 = r4
            r10.<init>(r11, r12, r13, r14, r15)
        L_0x0063:
            r1.zzajw = r4
            goto L_0x009d
        L_0x0066:
            int r4 = r1.zzalj
            if (r4 != 0) goto L_0x007c
            android.media.AudioTrack r4 = new android.media.AudioTrack
            int r9 = r1.streamType
            int r10 = r1.zzahl
            int r11 = r1.zzajx
            int r12 = r1.zzajz
            int r13 = r1.zzakb
            r14 = 1
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14)
            goto L_0x0063
        L_0x007c:
            android.media.AudioTrack r8 = new android.media.AudioTrack
            int r9 = r1.streamType
            int r10 = r1.zzahl
            int r11 = r1.zzajx
            int r12 = r1.zzajz
            int r13 = r1.zzakb
            r22 = 1
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r20 = r12
            r21 = r13
            r23 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r1.zzajw = r8
        L_0x009d:
            android.media.AudioTrack r4 = r1.zzajw
            int r4 = r4.getState()
            if (r4 != r6) goto L_0x00ce
            android.media.AudioTrack r4 = r1.zzajw
            int r4 = r4.getAudioSessionId()
            int r8 = r1.zzalj
            if (r8 == r4) goto L_0x00b6
            r1.zzalj = r4
            com.google.android.gms.internal.ads.zziv r8 = r1.zzajr
            r8.zzw(r4)
        L_0x00b6:
            com.google.android.gms.internal.ads.zzir r4 = r1.zzaju
            android.media.AudioTrack r8 = r1.zzajw
            boolean r9 = r24.zzfx()
            r4.zza(r8, r9)
            r24.zzfu()
            r1.zzall = r5
            boolean r4 = r1.zzali
            if (r4 == 0) goto L_0x00e6
            r24.play()
            goto L_0x00e6
        L_0x00ce:
            android.media.AudioTrack r0 = r1.zzajw     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            r0.release()     // Catch:{ Exception -> 0x00d8, all -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r0 = move-exception
            r1.zzajw = r7
            throw r0
        L_0x00d8:
            r1.zzajw = r7
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            int r2 = r1.zzahl
            int r3 = r1.zzajx
            int r5 = r1.zzakb
            r0.<init>(r4, r2, r3, r5)
            throw r0
        L_0x00e6:
            boolean r4 = r24.zzfx()
            r8 = 0
            r10 = 2
            if (r4 == 0) goto L_0x010d
            android.media.AudioTrack r4 = r1.zzajw
            int r4 = r4.getPlayState()
            if (r4 != r10) goto L_0x00fa
            r1.zzall = r5
            return r5
        L_0x00fa:
            android.media.AudioTrack r4 = r1.zzajw
            int r4 = r4.getPlayState()
            if (r4 != r6) goto L_0x010d
            com.google.android.gms.internal.ads.zzir r4 = r1.zzaju
            long r11 = r4.zzfy()
            int r4 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x010d
            return r5
        L_0x010d:
            boolean r4 = r1.zzall
            boolean r11 = r24.zzfr()
            r1.zzall = r11
            if (r4 == 0) goto L_0x013a
            boolean r4 = r1.zzall
            if (r4 != 0) goto L_0x013a
            android.media.AudioTrack r4 = r1.zzajw
            int r4 = r4.getPlayState()
            if (r4 == r6) goto L_0x013a
            long r11 = android.os.SystemClock.elapsedRealtime()
            long r13 = r1.zzalm
            long r19 = r11 - r13
            com.google.android.gms.internal.ads.zziv r15 = r1.zzajr
            int r4 = r1.zzakb
            long r11 = r1.zzakc
            long r17 = com.google.android.gms.internal.ads.zzhb.zzdm(r11)
            r16 = r4
            r15.zzc(r16, r17, r19)
        L_0x013a:
            java.nio.ByteBuffer r4 = r1.zzalc
            if (r4 != 0) goto L_0x023c
            boolean r4 = r25.hasRemaining()
            if (r4 != 0) goto L_0x0145
            return r6
        L_0x0145:
            boolean r4 = r1.zzaka
            if (r4 == 0) goto L_0x0186
            int r4 = r1.zzakv
            if (r4 != 0) goto L_0x0186
            int r4 = r1.zzajz
            r11 = 7
            if (r4 == r11) goto L_0x0180
            r11 = 8
            if (r4 != r11) goto L_0x0157
            goto L_0x0180
        L_0x0157:
            r11 = 5
            if (r4 != r11) goto L_0x015f
            int r4 = com.google.android.gms.internal.ads.zzid.zzfi()
            goto L_0x0184
        L_0x015f:
            r11 = 6
            if (r4 != r11) goto L_0x0167
            int r4 = com.google.android.gms.internal.ads.zzid.zzm(r25)
            goto L_0x0184
        L_0x0167:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r2 = 38
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected audio encoding: "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0180:
            int r4 = com.google.android.gms.internal.ads.zziz.zzo(r25)
        L_0x0184:
            r1.zzakv = r4
        L_0x0186:
            com.google.android.gms.internal.ads.zzhv r4 = r1.zzakd
            if (r4 == 0) goto L_0x01b5
            boolean r4 = r24.zzfq()
            if (r4 != 0) goto L_0x0191
            return r5
        L_0x0191:
            java.util.LinkedList<com.google.android.gms.internal.ads.zziy> r4 = r1.zzajv
            com.google.android.gms.internal.ads.zziy r15 = new com.google.android.gms.internal.ads.zziy
            com.google.android.gms.internal.ads.zzhv r12 = r1.zzakd
            long r13 = java.lang.Math.max(r8, r2)
            long r10 = r24.zzfv()
            long r16 = r1.zzdw(r10)
            r10 = 0
            r11 = r15
            r5 = r15
            r15 = r16
            r17 = r10
            r11.<init>(r12, r13, r15, r17)
            r4.add(r5)
            r1.zzakd = r7
            r24.zzfn()
        L_0x01b5:
            int r4 = r1.zzakw
            if (r4 != 0) goto L_0x01c2
            long r4 = java.lang.Math.max(r8, r2)
            r1.zzakx = r4
            r1.zzakw = r6
            goto L_0x0223
        L_0x01c2:
            long r4 = r1.zzakx
            boolean r8 = r1.zzaka
            if (r8 == 0) goto L_0x01cb
            long r8 = r1.zzakr
            goto L_0x01d1
        L_0x01cb:
            long r8 = r1.zzakq
            int r10 = r1.zzakp
            long r10 = (long) r10
            long r8 = r8 / r10
        L_0x01d1:
            long r8 = r1.zzdw(r8)
            long r4 = r4 + r8
            int r8 = r1.zzakw
            if (r8 != r6) goto L_0x0210
            long r8 = r4 - r2
            long r8 = java.lang.Math.abs(r8)
            r10 = 200000(0x30d40, double:9.8813E-319)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0210
            java.lang.String r8 = "AudioTrack"
            r9 = 80
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            java.lang.String r9 = "Discontinuity detected [expected "
            r10.append(r9)
            r10.append(r4)
            java.lang.String r9 = ", got "
            r10.append(r9)
            r10.append(r2)
            java.lang.String r9 = "]"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            android.util.Log.e(r8, r9)
            r8 = 2
            r1.zzakw = r8
            goto L_0x0211
        L_0x0210:
            r8 = 2
        L_0x0211:
            int r9 = r1.zzakw
            if (r9 != r8) goto L_0x0223
            long r8 = r1.zzakx
            long r4 = r2 - r4
            long r8 = r8 + r4
            r1.zzakx = r8
            r1.zzakw = r6
            com.google.android.gms.internal.ads.zziv r4 = r1.zzajr
            r4.zzen()
        L_0x0223:
            boolean r4 = r1.zzaka
            if (r4 == 0) goto L_0x0230
            long r4 = r1.zzakr
            int r8 = r1.zzakv
            long r8 = (long) r8
            long r4 = r4 + r8
            r1.zzakr = r4
            goto L_0x023a
        L_0x0230:
            long r4 = r1.zzakq
            int r8 = r25.remaining()
            long r8 = (long) r8
            long r4 = r4 + r8
            r1.zzakq = r4
        L_0x023a:
            r1.zzalc = r0
        L_0x023c:
            boolean r0 = r1.zzaka
            if (r0 == 0) goto L_0x0246
            java.nio.ByteBuffer r0 = r1.zzalc
            r1.zzc(r0, r2)
            goto L_0x0249
        L_0x0246:
            r1.zzdv(r2)
        L_0x0249:
            java.nio.ByteBuffer r0 = r1.zzalc
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0254
            r1.zzalc = r7
            return r6
        L_0x0254:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zzb(java.nio.ByteBuffer, long):boolean");
    }

    public final boolean zzfe() {
        if (isInitialized()) {
            return this.zzalh && !zzfr();
        }
        return true;
    }

    public final void zzfo() {
        if (this.zzakw == 1) {
            this.zzakw = 2;
        }
    }

    public final void zzfp() {
        if (!this.zzalh && isInitialized() && zzfq()) {
            this.zzaju.zzdy(zzfv());
            this.zzakh = 0;
            this.zzalh = true;
        }
    }

    public final boolean zzfr() {
        if (isInitialized()) {
            if (zzfv() <= this.zzaju.zzfy()) {
                if (zzfx() && this.zzajw.getPlayState() == 2 && this.zzajw.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzhv zzfs() {
        return this.zzafg;
    }

    public final void zzft() {
        if (this.zzalk) {
            this.zzalk = false;
            this.zzalj = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        StringBuilder sb;
        String str;
        if (!(isInitialized() && this.zzakw != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzajw.getPlayState() == 3) {
            long zzfz = this.zzaju.zzfz();
            if (zzfz != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzakl >= 30000) {
                    long[] jArr = this.zzajt;
                    int i = this.zzaki;
                    jArr[i] = zzfz - nanoTime;
                    this.zzaki = (i + 1) % 10;
                    int i2 = this.zzakj;
                    if (i2 < 10) {
                        this.zzakj = i2 + 1;
                    }
                    this.zzakl = nanoTime;
                    this.zzakk = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzakj;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzakk += this.zzajt[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzfx() && nanoTime - this.zzakn >= 500000) {
                    this.zzakm = this.zzaju.zzga();
                    if (this.zzakm) {
                        long zzgb = this.zzaju.zzgb() / 1000;
                        long zzgc = this.zzaju.zzgc();
                        if (zzgb >= this.zzaky) {
                            if (Math.abs(zzgb - nanoTime) > 5000000) {
                                sb = new StringBuilder(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA);
                                str = "Spurious audio timestamp (system clock mismatch): ";
                            } else if (Math.abs(zzdw(zzgc) - zzfz) > 5000000) {
                                sb = new StringBuilder(CipherSuite.TLS_PSK_WITH_RC4_128_SHA);
                                str = "Spurious audio timestamp (frame position mismatch): ";
                            }
                            sb.append(str);
                            sb.append(zzgc);
                            sb.append(", ");
                            sb.append(zzgb);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzfz);
                            Log.w("AudioTrack", sb.toString());
                        }
                        this.zzakm = false;
                    }
                    Method method = this.zzako;
                    if (method != null && !this.zzaka) {
                        try {
                            this.zzakz = (((long) ((Integer) method.invoke(this.zzajw, (Object[]) null)).intValue()) * 1000) - this.zzakc;
                            this.zzakz = Math.max(this.zzakz, 0);
                            if (this.zzakz > 5000000) {
                                long j5 = this.zzakz;
                                StringBuilder sb2 = new StringBuilder(61);
                                sb2.append("Ignoring impossibly large audio latency: ");
                                sb2.append(j5);
                                Log.w("AudioTrack", sb2.toString());
                                this.zzakz = 0;
                            }
                        } catch (Exception unused) {
                            this.zzako = null;
                        }
                    }
                    this.zzakn = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzakm) {
            j = zzdw(this.zzaju.zzgc() + zzdx(nanoTime2 - (this.zzaju.zzgb() / 1000)));
        } else {
            j = this.zzakj == 0 ? this.zzaju.zzfz() : nanoTime2 + this.zzakk;
            if (!z) {
                j -= this.zzakz;
            }
        }
        long j6 = this.zzakx;
        while (!this.zzajv.isEmpty() && j >= this.zzajv.getFirst().zzagu) {
            zziy remove = this.zzajv.remove();
            this.zzafg = remove.zzafg;
            this.zzakf = remove.zzagu;
            this.zzake = remove.zzamc - this.zzakx;
        }
        if (this.zzafg.zzahy == 1.0f) {
            j2 = (j + this.zzake) - this.zzakf;
        } else {
            if (!this.zzajv.isEmpty() || this.zzajp.zzgg() < 1024) {
                j3 = this.zzake;
                j4 = (long) (((double) this.zzafg.zzahy) * ((double) (j - this.zzakf)));
            } else {
                j3 = this.zzake;
                j4 = zzpt.zza(j - this.zzakf, this.zzajp.zzgf(), this.zzajp.zzgg());
            }
            j2 = j4 + j3;
        }
        return j6 + j2;
    }
}
