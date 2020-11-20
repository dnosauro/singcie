package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public final class zzlh implements zzjw {
    private static final zzkb zzaph = new zzlg();
    private static final int zzaxj = zzpt.zzbh("seig");
    private static final byte[] zzaxk = {Filter.FILTER_TYPE_NOT, 57, 79, 82, 90, -101, 79, 20, Filter.FILTER_TYPE_NOT, 68, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 124, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -115, -12};
    private final int flags;
    private long zzaif;
    private final zzpn zzapo;
    private int zzard;
    private int zzare;
    private zzjy zzarh;
    private final zzlo zzaxl;
    private final SparseArray<zzli> zzaxm;
    private final zzpn zzaxn;
    private final zzpn zzaxo;
    private final zzpn zzaxp;
    private final zzpr zzaxq;
    private final zzpn zzaxr;
    private final byte[] zzaxs;
    private final Stack<zzkv> zzaxt;
    private final LinkedList<zzlj> zzaxu;
    private int zzaxv;
    private int zzaxw;
    private long zzaxx;
    private int zzaxy;
    private zzpn zzaxz;
    private long zzaya;
    private int zzayb;
    private long zzayc;
    private zzli zzayd;
    private int zzaye;
    private boolean zzayf;
    private zzkh zzayg;
    private zzkh[] zzayh;
    private boolean zzayi;

    public zzlh() {
        this(0);
    }

    private zzlh(int i) {
        this(0, (zzpr) null);
    }

    private zzlh(int i, zzpr zzpr) {
        this(0, (zzpr) null, (zzlo) null);
    }

    private zzlh(int i, zzpr zzpr, zzlo zzlo) {
        this.flags = 0;
        this.zzaxq = null;
        this.zzaxl = null;
        this.zzaxr = new zzpn(16);
        this.zzapo = new zzpn(zzpi.zzbjq);
        this.zzaxn = new zzpn(5);
        this.zzaxo = new zzpn();
        this.zzaxp = new zzpn(1);
        this.zzaxs = new byte[16];
        this.zzaxt = new Stack<>();
        this.zzaxu = new LinkedList<>();
        this.zzaxm = new SparseArray<>();
        this.zzaif = -9223372036854775807L;
        this.zzayc = -9223372036854775807L;
        zzhb();
    }

    private static void zza(zzpn zzpn, int i, zzlq zzlq) {
        zzpn.zzbl(i + 8);
        int zzap = zzks.zzap(zzpn.readInt());
        if ((zzap & 1) == 0) {
            boolean z = (zzap & 2) != 0;
            int zzjf = zzpn.zzjf();
            if (zzjf == zzlq.zzaxa) {
                Arrays.fill(zzlq.zzbat, 0, zzjf, z);
                zzlq.zzau(zzpn.zzja());
                zzpn.zze(zzlq.zzbaw.data, 0, zzlq.zzbav);
                zzlq.zzbaw.zzbl(0);
                zzlq.zzbax = false;
                return;
            }
            int i2 = zzlq.zzaxa;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzjf);
            sb.append(", ");
            sb.append(i2);
            throw new zzhw(sb.toString());
        }
        throw new zzhw("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzjo zzb(java.util.List<com.google.android.gms.internal.ads.zzku> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0008:
            if (r3 >= r0) goto L_0x00b9
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzku r5 = (com.google.android.gms.internal.ads.zzku) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzks.zzauk
            if (r6 != r7) goto L_0x00b5
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzpn r5 = r5.zzawg
            byte[] r5 = r5.data
            com.google.android.gms.internal.ads.zzpn r6 = new com.google.android.gms.internal.ads.zzpn
            r6.<init>((byte[]) r5)
            int r7 = r6.limit()
            r8 = 32
            if (r7 >= r8) goto L_0x0030
        L_0x002e:
            r6 = r2
            goto L_0x0099
        L_0x0030:
            r6.zzbl(r1)
            int r7 = r6.readInt()
            int r8 = r6.zzja()
            int r8 = r8 + 4
            if (r7 == r8) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r7 = r6.readInt()
            int r8 = com.google.android.gms.internal.ads.zzks.zzauk
            if (r7 == r8) goto L_0x0049
            goto L_0x002e
        L_0x0049:
            int r7 = r6.readInt()
            int r7 = com.google.android.gms.internal.ads.zzks.zzao(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x006d
            java.lang.String r6 = "PsshAtomUtil"
            r8 = 37
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r8 = "Unsupported pssh version: "
            r9.append(r8)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            android.util.Log.w(r6, r7)
            goto L_0x002e
        L_0x006d:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.readLong()
            long r12 = r6.readLong()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0085
            int r7 = r6.zzjf()
            int r7 = r7 << 4
            r6.zzbm(r7)
        L_0x0085:
            int r7 = r6.zzjf()
            int r8 = r6.zzja()
            if (r7 == r8) goto L_0x0090
            goto L_0x002e
        L_0x0090:
            byte[] r8 = new byte[r7]
            r6.zze(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x0099:
            if (r6 != 0) goto L_0x009d
            r6 = r2
            goto L_0x00a1
        L_0x009d:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x00a1:
            if (r6 != 0) goto L_0x00ab
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00b5
        L_0x00ab:
            com.google.android.gms.internal.ads.zzjo$zza r7 = new com.google.android.gms.internal.ads.zzjo$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        L_0x00b5:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00b9:
            if (r4 != 0) goto L_0x00bc
            return r2
        L_0x00bc:
            com.google.android.gms.internal.ads.zzjo r14 = new com.google.android.gms.internal.ads.zzjo
            r14.<init>((java.util.List<com.google.android.gms.internal.ads.zzjo.zza>) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzb(java.util.List):com.google.android.gms.internal.ads.zzjo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:156:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0660  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzeb(long r55) {
        /*
            r54 = this;
            r0 = r54
        L_0x0002:
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r1 = r0.zzaxt
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0702
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r1 = r0.zzaxt
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzkv r1 = (com.google.android.gms.internal.ads.zzkv) r1
            long r1 = r1.zzawh
            int r3 = (r1 > r55 ? 1 : (r1 == r55 ? 0 : -1))
            if (r3 != 0) goto L_0x0702
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r1 = r0.zzaxt
            java.lang.Object r1 = r1.pop()
            com.google.android.gms.internal.ads.zzkv r1 = (com.google.android.gms.internal.ads.zzkv) r1
            int r2 = r1.type
            int r3 = com.google.android.gms.internal.ads.zzks.zzatr
            r4 = 0
            r5 = 12
            r6 = 4
            r7 = 8
            r9 = 1
            if (r2 != r3) goto L_0x01cc
            java.lang.String r2 = "Unexpected moov box."
            com.google.android.gms.internal.ads.zzpc.checkState(r9, r2)
            java.util.List<com.google.android.gms.internal.ads.zzku> r2 = r1.zzawi
            com.google.android.gms.internal.ads.zzjo r2 = zzb(r2)
            int r3 = com.google.android.gms.internal.ads.zzks.zzauc
            com.google.android.gms.internal.ads.zzkv r3 = r1.zzat(r3)
            android.util.SparseArray r15 = new android.util.SparseArray
            r15.<init>()
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.gms.internal.ads.zzku> r12 = r3.zzawi
            int r12 = r12.size()
            r16 = r10
            r10 = 0
        L_0x0051:
            if (r10 >= r12) goto L_0x00be
            java.util.List<com.google.android.gms.internal.ads.zzku> r11 = r3.zzawi
            java.lang.Object r11 = r11.get(r10)
            com.google.android.gms.internal.ads.zzku r11 = (com.google.android.gms.internal.ads.zzku) r11
            int r13 = r11.type
            int r14 = com.google.android.gms.internal.ads.zzks.zzato
            if (r13 != r14) goto L_0x0098
            com.google.android.gms.internal.ads.zzpn r11 = r11.zzawg
            r11.zzbl(r5)
            int r13 = r11.readInt()
            int r14 = r11.zzjf()
            int r14 = r14 - r9
            int r5 = r11.zzjf()
            int r8 = r11.zzjf()
            int r11 = r11.readInt()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            com.google.android.gms.internal.ads.zzlc r9 = new com.google.android.gms.internal.ads.zzlc
            r9.<init>(r14, r5, r8, r11)
            android.util.Pair r5 = android.util.Pair.create(r13, r9)
            java.lang.Object r8 = r5.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r5 = r5.second
            com.google.android.gms.internal.ads.zzlc r5 = (com.google.android.gms.internal.ads.zzlc) r5
            r15.put(r8, r5)
            goto L_0x00b8
        L_0x0098:
            int r5 = r11.type
            int r8 = com.google.android.gms.internal.ads.zzks.zzaud
            if (r5 != r8) goto L_0x00b8
            com.google.android.gms.internal.ads.zzpn r5 = r11.zzawg
            r5.zzbl(r7)
            int r8 = r5.readInt()
            int r8 = com.google.android.gms.internal.ads.zzks.zzao(r8)
            if (r8 != 0) goto L_0x00b2
            long r8 = r5.zzjc()
            goto L_0x00b6
        L_0x00b2:
            long r8 = r5.zzjg()
        L_0x00b6:
            r16 = r8
        L_0x00b8:
            int r10 = r10 + 1
            r5 = 12
            r9 = 1
            goto L_0x0051
        L_0x00be:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzkv> r5 = r1.zzawj
            int r5 = r5.size()
            r8 = 0
        L_0x00ca:
            if (r8 >= r5) goto L_0x00fa
            java.util.List<com.google.android.gms.internal.ads.zzkv> r9 = r1.zzawj
            java.lang.Object r9 = r9.get(r8)
            r10 = r9
            com.google.android.gms.internal.ads.zzkv r10 = (com.google.android.gms.internal.ads.zzkv) r10
            int r9 = r10.type
            int r11 = com.google.android.gms.internal.ads.zzks.zzatt
            if (r9 != r11) goto L_0x00f3
            int r9 = com.google.android.gms.internal.ads.zzks.zzats
            com.google.android.gms.internal.ads.zzku r11 = r1.zzas(r9)
            r9 = 0
            r12 = r16
            r14 = r2
            r7 = r15
            r15 = r9
            com.google.android.gms.internal.ads.zzlo r9 = com.google.android.gms.internal.ads.zzkx.zza((com.google.android.gms.internal.ads.zzkv) r10, (com.google.android.gms.internal.ads.zzku) r11, (long) r12, (com.google.android.gms.internal.ads.zzjo) r14, (boolean) r15)
            if (r9 == 0) goto L_0x00f4
            int r10 = r9.f6908id
            r3.put(r10, r9)
            goto L_0x00f4
        L_0x00f3:
            r7 = r15
        L_0x00f4:
            int r8 = r8 + 1
            r15 = r7
            r7 = 8
            goto L_0x00ca
        L_0x00fa:
            r7 = r15
            int r1 = r3.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r2 = r2.size()
            if (r2 != 0) goto L_0x019b
            r2 = 0
        L_0x0108:
            if (r2 >= r1) goto L_0x013c
            java.lang.Object r5 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzlo r5 = (com.google.android.gms.internal.ads.zzlo) r5
            com.google.android.gms.internal.ads.zzli r8 = new com.google.android.gms.internal.ads.zzli
            com.google.android.gms.internal.ads.zzjy r9 = r0.zzarh
            int r10 = r5.type
            com.google.android.gms.internal.ads.zzkh r9 = r9.zzc(r2, r10)
            r8.<init>(r9)
            int r9 = r5.f6908id
            java.lang.Object r9 = r7.get(r9)
            com.google.android.gms.internal.ads.zzlc r9 = (com.google.android.gms.internal.ads.zzlc) r9
            r8.zza(r5, r9)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r9 = r0.zzaxm
            int r10 = r5.f6908id
            r9.put(r10, r8)
            long r8 = r0.zzaif
            long r10 = r5.zzaif
            long r8 = java.lang.Math.max(r8, r10)
            r0.zzaif = r8
            int r2 = r2 + 1
            goto L_0x0108
        L_0x013c:
            int r1 = r0.flags
            r1 = r1 & r6
            if (r1 == 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzkh r1 = r0.zzayg
            if (r1 != 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzjy r1 = r0.zzarh
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r2 = r2.size()
            com.google.android.gms.internal.ads.zzkh r1 = r1.zzc(r2, r6)
            r0.zzayg = r1
            com.google.android.gms.internal.ads.zzkh r1 = r0.zzayg
            java.lang.String r2 = "application/x-emsg"
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.ads.zzhp r2 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r4, (java.lang.String) r2, (long) r5)
            r1.zze(r2)
        L_0x0163:
            int r1 = r0.flags
            r2 = 8
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0194
            com.google.android.gms.internal.ads.zzkh[] r1 = r0.zzayh
            if (r1 != 0) goto L_0x0194
            com.google.android.gms.internal.ads.zzjy r1 = r0.zzarh
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 + r3
            r3 = 3
            com.google.android.gms.internal.ads.zzkh r1 = r1.zzc(r2, r3)
            r2 = 0
            java.lang.String r3 = "application/cea-608"
            r4 = 0
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            com.google.android.gms.internal.ads.zzhp r2 = com.google.android.gms.internal.ads.zzhp.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (int) r6, (java.lang.String) r7, (com.google.android.gms.internal.ads.zzjo) r8)
            r1.zze(r2)
            r2 = 1
            com.google.android.gms.internal.ads.zzkh[] r2 = new com.google.android.gms.internal.ads.zzkh[r2]
            r3 = 0
            r2[r3] = r1
            r0.zzayh = r2
        L_0x0194:
            com.google.android.gms.internal.ads.zzjy r1 = r0.zzarh
            r1.zzgr()
            goto L_0x0002
        L_0x019b:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r2 = r2.size()
            if (r2 != r1) goto L_0x01a6
            r19 = 1
            goto L_0x01a8
        L_0x01a6:
            r19 = 0
        L_0x01a8:
            com.google.android.gms.internal.ads.zzpc.checkState(r19)
            r2 = 0
        L_0x01ac:
            if (r2 >= r1) goto L_0x0002
            java.lang.Object r4 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzlo r4 = (com.google.android.gms.internal.ads.zzlo) r4
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r5 = r0.zzaxm
            int r6 = r4.f6908id
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzli r5 = (com.google.android.gms.internal.ads.zzli) r5
            int r6 = r4.f6908id
            java.lang.Object r6 = r7.get(r6)
            com.google.android.gms.internal.ads.zzlc r6 = (com.google.android.gms.internal.ads.zzlc) r6
            r5.zza(r4, r6)
            int r2 = r2 + 1
            goto L_0x01ac
        L_0x01cc:
            int r2 = r1.type
            int r3 = com.google.android.gms.internal.ads.zzks.zzaua
            if (r2 != r3) goto L_0x06eb
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r3 = r0.flags
            byte[] r5 = r0.zzaxs
            java.util.List<com.google.android.gms.internal.ads.zzkv> r7 = r1.zzawj
            int r7 = r7.size()
            r8 = 0
        L_0x01df:
            if (r8 >= r7) goto L_0x06bd
            java.util.List<com.google.android.gms.internal.ads.zzkv> r9 = r1.zzawj
            java.lang.Object r9 = r9.get(r8)
            com.google.android.gms.internal.ads.zzkv r9 = (com.google.android.gms.internal.ads.zzkv) r9
            int r10 = r9.type
            int r11 = com.google.android.gms.internal.ads.zzks.zzaub
            if (r10 != r11) goto L_0x069b
            int r10 = com.google.android.gms.internal.ads.zzks.zzatn
            com.google.android.gms.internal.ads.zzku r10 = r9.zzas(r10)
            com.google.android.gms.internal.ads.zzpn r10 = r10.zzawg
            r11 = 8
            r10.zzbl(r11)
            int r11 = r10.readInt()
            int r11 = com.google.android.gms.internal.ads.zzks.zzap(r11)
            int r12 = r10.readInt()
            r13 = r3 & 16
            if (r13 != 0) goto L_0x020d
            goto L_0x020e
        L_0x020d:
            r12 = 0
        L_0x020e:
            java.lang.Object r12 = r2.get(r12)
            com.google.android.gms.internal.ads.zzli r12 = (com.google.android.gms.internal.ads.zzli) r12
            if (r12 != 0) goto L_0x0217
            goto L_0x0263
        L_0x0217:
            r13 = r11 & 1
            if (r13 == 0) goto L_0x0227
            long r13 = r10.zzjg()
            com.google.android.gms.internal.ads.zzlq r15 = r12.zzayj
            r15.zzbaj = r13
            com.google.android.gms.internal.ads.zzlq r15 = r12.zzayj
            r15.zzbak = r13
        L_0x0227:
            com.google.android.gms.internal.ads.zzlc r13 = r12.zzayl
            r14 = r11 & 2
            if (r14 == 0) goto L_0x0234
            int r14 = r10.zzjf()
            r15 = 1
            int r14 = r14 - r15
            goto L_0x0236
        L_0x0234:
            int r14 = r13.zzaxf
        L_0x0236:
            r15 = r11 & 8
            if (r15 == 0) goto L_0x023f
            int r15 = r10.zzjf()
            goto L_0x0241
        L_0x023f:
            int r15 = r13.duration
        L_0x0241:
            r16 = r11 & 16
            if (r16 == 0) goto L_0x024c
            int r16 = r10.zzjf()
            r4 = r16
            goto L_0x024e
        L_0x024c:
            int r4 = r13.size
        L_0x024e:
            r11 = r11 & 32
            if (r11 == 0) goto L_0x0257
            int r10 = r10.zzjf()
            goto L_0x0259
        L_0x0257:
            int r10 = r13.flags
        L_0x0259:
            com.google.android.gms.internal.ads.zzlq r11 = r12.zzayj
            com.google.android.gms.internal.ads.zzlc r13 = new com.google.android.gms.internal.ads.zzlc
            r13.<init>(r14, r15, r4, r10)
            r11.zzbah = r13
            r4 = r12
        L_0x0263:
            if (r4 == 0) goto L_0x069b
            com.google.android.gms.internal.ads.zzlq r10 = r4.zzayj
            long r11 = r10.zzbay
            r4.reset()
            int r13 = com.google.android.gms.internal.ads.zzks.zzatm
            com.google.android.gms.internal.ads.zzku r13 = r9.zzas(r13)
            if (r13 == 0) goto L_0x0299
            r13 = r3 & 2
            if (r13 != 0) goto L_0x0299
            int r11 = com.google.android.gms.internal.ads.zzks.zzatm
            com.google.android.gms.internal.ads.zzku r11 = r9.zzas(r11)
            com.google.android.gms.internal.ads.zzpn r11 = r11.zzawg
            r12 = 8
            r11.zzbl(r12)
            int r12 = r11.readInt()
            int r12 = com.google.android.gms.internal.ads.zzks.zzao(r12)
            r13 = 1
            if (r12 != r13) goto L_0x0295
            long r11 = r11.zzjg()
            goto L_0x0299
        L_0x0295:
            long r11 = r11.zzjc()
        L_0x0299:
            java.util.List<com.google.android.gms.internal.ads.zzku> r13 = r9.zzawi
            int r14 = r13.size()
            r20 = r2
            r2 = 0
            r6 = 0
            r15 = 0
        L_0x02a4:
            if (r15 >= r14) goto L_0x02d2
            java.lang.Object r21 = r13.get(r15)
            r22 = r7
            r7 = r21
            com.google.android.gms.internal.ads.zzku r7 = (com.google.android.gms.internal.ads.zzku) r7
            r23 = r11
            int r11 = r7.type
            int r12 = com.google.android.gms.internal.ads.zzks.zzatp
            if (r11 != r12) goto L_0x02c9
            com.google.android.gms.internal.ads.zzpn r7 = r7.zzawg
            r11 = 12
            r7.zzbl(r11)
            int r7 = r7.zzjf()
            if (r7 <= 0) goto L_0x02cb
            int r2 = r2 + r7
            int r6 = r6 + 1
            goto L_0x02cb
        L_0x02c9:
            r11 = 12
        L_0x02cb:
            int r15 = r15 + 1
            r7 = r22
            r11 = r23
            goto L_0x02a4
        L_0x02d2:
            r22 = r7
            r23 = r11
            r7 = 0
            r11 = 12
            r4.zzayo = r7
            r4.zzayn = r7
            r4.zzaym = r7
            com.google.android.gms.internal.ads.zzlq r7 = r4.zzayj
            r7.zzbal = r6
            r7.zzaxa = r2
            int[] r12 = r7.zzban
            if (r12 == 0) goto L_0x02ee
            int[] r12 = r7.zzban
            int r12 = r12.length
            if (r12 >= r6) goto L_0x02f6
        L_0x02ee:
            long[] r12 = new long[r6]
            r7.zzbam = r12
            int[] r6 = new int[r6]
            r7.zzban = r6
        L_0x02f6:
            int[] r6 = r7.zzbao
            if (r6 == 0) goto L_0x02ff
            int[] r6 = r7.zzbao
            int r6 = r6.length
            if (r6 >= r2) goto L_0x0317
        L_0x02ff:
            int r2 = r2 * 125
            int r2 = r2 / 100
            int[] r6 = new int[r2]
            r7.zzbao = r6
            int[] r6 = new int[r2]
            r7.zzbap = r6
            long[] r6 = new long[r2]
            r7.zzbaq = r6
            boolean[] r6 = new boolean[r2]
            r7.zzbar = r6
            boolean[] r2 = new boolean[r2]
            r7.zzbat = r2
        L_0x0317:
            r2 = 0
            r6 = 0
            r7 = 0
        L_0x031a:
            r25 = 0
            if (r2 >= r14) goto L_0x04b9
            java.lang.Object r18 = r13.get(r2)
            r11 = r18
            com.google.android.gms.internal.ads.zzku r11 = (com.google.android.gms.internal.ads.zzku) r11
            int r15 = r11.type
            int r12 = com.google.android.gms.internal.ads.zzks.zzatp
            if (r15 != r12) goto L_0x048a
            int r12 = r6 + 1
            com.google.android.gms.internal.ads.zzpn r11 = r11.zzawg
            r15 = 8
            r11.zzbl(r15)
            int r15 = r11.readInt()
            int r15 = com.google.android.gms.internal.ads.zzks.zzap(r15)
            r28 = r12
            com.google.android.gms.internal.ads.zzlo r12 = r4.zzayk
            r29 = r13
            com.google.android.gms.internal.ads.zzlq r13 = r4.zzayj
            r30 = r14
            com.google.android.gms.internal.ads.zzlc r14 = r13.zzbah
            int[] r0 = r13.zzban
            int r31 = r11.zzjf()
            r0[r6] = r31
            long[] r0 = r13.zzbam
            r32 = r4
            r31 = r5
            long r4 = r13.zzbaj
            r0[r6] = r4
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0372
            long[] r0 = r13.zzbam
            r4 = r0[r6]
            r33 = r1
            int r1 = r11.readInt()
            r34 = r8
            r35 = r9
            long r8 = (long) r1
            long r4 = r4 + r8
            r0[r6] = r4
            goto L_0x0378
        L_0x0372:
            r33 = r1
            r34 = r8
            r35 = r9
        L_0x0378:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x037e
            r0 = 1
            goto L_0x037f
        L_0x037e:
            r0 = 0
        L_0x037f:
            int r1 = r14.flags
            if (r0 == 0) goto L_0x0387
            int r1 = r11.zzjf()
        L_0x0387:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x038d
            r4 = 1
            goto L_0x038e
        L_0x038d:
            r4 = 0
        L_0x038e:
            r5 = r15 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0394
            r5 = 1
            goto L_0x0395
        L_0x0394:
            r5 = 0
        L_0x0395:
            r8 = r15 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x039b
            r8 = 1
            goto L_0x039c
        L_0x039b:
            r8 = 0
        L_0x039c:
            r9 = r15 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x03a2
            r9 = 1
            goto L_0x03a3
        L_0x03a2:
            r9 = 0
        L_0x03a3:
            long[] r15 = r12.zzbae
            if (r15 == 0) goto L_0x03c8
            long[] r15 = r12.zzbae
            int r15 = r15.length
            r36 = r1
            r1 = 1
            if (r15 != r1) goto L_0x03ca
            long[] r1 = r12.zzbae
            r15 = 0
            r37 = r1[r15]
            int r1 = (r37 > r25 ? 1 : (r37 == r25 ? 0 : -1))
            if (r1 != 0) goto L_0x03ca
            long[] r1 = r12.zzbaf
            r37 = r1[r15]
            r39 = 1000(0x3e8, double:4.94E-321)
            r15 = r2
            long r1 = r12.zzdd
            r41 = r1
            long r25 = com.google.android.gms.internal.ads.zzpt.zza((long) r37, (long) r39, (long) r41)
            goto L_0x03cb
        L_0x03c8:
            r36 = r1
        L_0x03ca:
            r15 = r2
        L_0x03cb:
            int[] r1 = r13.zzbao
            int[] r2 = r13.zzbap
            r37 = r10
            long[] r10 = r13.zzbaq
            r38 = r15
            boolean[] r15 = r13.zzbar
            r39 = r15
            int r15 = r12.type
            r40 = r1
            r1 = 2
            if (r15 != r1) goto L_0x03e6
            r1 = r3 & 1
            if (r1 == 0) goto L_0x03e6
            r1 = 1
            goto L_0x03e7
        L_0x03e6:
            r1 = 0
        L_0x03e7:
            int[] r15 = r13.zzban
            r15 = r15[r6]
            int r15 = r15 + r7
            r47 = r1
            r27 = r2
            long r1 = r12.zzdd
            if (r6 <= 0) goto L_0x03f8
            r12 = r7
            long r6 = r13.zzbay
            goto L_0x03fb
        L_0x03f8:
            r12 = r7
            r6 = r23
        L_0x03fb:
            if (r12 >= r15) goto L_0x0482
            if (r4 == 0) goto L_0x0408
            int r41 = r11.zzjf()
            r48 = r3
            r3 = r41
            goto L_0x040c
        L_0x0408:
            r48 = r3
            int r3 = r14.duration
        L_0x040c:
            if (r5 == 0) goto L_0x0417
            int r41 = r11.zzjf()
            r49 = r4
            r4 = r41
            goto L_0x041b
        L_0x0417:
            r49 = r4
            int r4 = r14.size
        L_0x041b:
            if (r12 != 0) goto L_0x0424
            if (r0 == 0) goto L_0x0424
            r50 = r0
            r0 = r36
            goto L_0x0433
        L_0x0424:
            if (r8 == 0) goto L_0x042f
            int r41 = r11.readInt()
            r50 = r0
            r0 = r41
            goto L_0x0433
        L_0x042f:
            r50 = r0
            int r0 = r14.flags
        L_0x0433:
            if (r9 == 0) goto L_0x0447
            r51 = r5
            int r5 = r11.readInt()
            int r5 = r5 * 1000
            r52 = r8
            r53 = r9
            long r8 = (long) r5
            long r8 = r8 / r1
            int r5 = (int) r8
            r27[r12] = r5
            goto L_0x0450
        L_0x0447:
            r51 = r5
            r52 = r8
            r53 = r9
            r5 = 0
            r27[r12] = r5
        L_0x0450:
            r43 = 1000(0x3e8, double:4.94E-321)
            r41 = r6
            r45 = r1
            long r8 = com.google.android.gms.internal.ads.zzpt.zza((long) r41, (long) r43, (long) r45)
            long r8 = r8 - r25
            r10[r12] = r8
            r40[r12] = r4
            r4 = 16
            int r0 = r0 >> r4
            r4 = 1
            r0 = r0 & r4
            if (r0 != 0) goto L_0x046d
            if (r47 == 0) goto L_0x046b
            if (r12 != 0) goto L_0x046d
        L_0x046b:
            r0 = 1
            goto L_0x046e
        L_0x046d:
            r0 = 0
        L_0x046e:
            r39[r12] = r0
            long r3 = (long) r3
            long r6 = r6 + r3
            int r12 = r12 + 1
            r3 = r48
            r4 = r49
            r0 = r50
            r5 = r51
            r8 = r52
            r9 = r53
            goto L_0x03fb
        L_0x0482:
            r48 = r3
            r13.zzbay = r6
            r7 = r15
            r6 = r28
            goto L_0x049f
        L_0x048a:
            r33 = r1
            r38 = r2
            r48 = r3
            r32 = r4
            r31 = r5
            r12 = r7
            r34 = r8
            r35 = r9
            r37 = r10
            r29 = r13
            r30 = r14
        L_0x049f:
            int r2 = r38 + 1
            r13 = r29
            r14 = r30
            r5 = r31
            r4 = r32
            r1 = r33
            r8 = r34
            r9 = r35
            r10 = r37
            r3 = r48
            r0 = r54
            r11 = 12
            goto L_0x031a
        L_0x04b9:
            r33 = r1
            r48 = r3
            r32 = r4
            r31 = r5
            r34 = r8
            r35 = r9
            r37 = r10
            int r0 = com.google.android.gms.internal.ads.zzks.zzaus
            com.google.android.gms.internal.ads.zzku r0 = r9.zzas(r0)
            if (r0 == 0) goto L_0x054e
            r4 = r32
            com.google.android.gms.internal.ads.zzlo r1 = r4.zzayk
            com.google.android.gms.internal.ads.zzlr[] r1 = r1.zzbad
            r2 = r37
            com.google.android.gms.internal.ads.zzlc r3 = r2.zzbah
            int r3 = r3.zzaxf
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzawg
            int r1 = r1.zzbba
            r3 = 8
            r0.zzbl(r3)
            int r4 = r0.readInt()
            int r4 = com.google.android.gms.internal.ads.zzks.zzap(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x04f5
            r0.zzbm(r3)
        L_0x04f5:
            int r3 = r0.readUnsignedByte()
            int r4 = r0.zzjf()
            int r5 = r2.zzaxa
            if (r4 != r5) goto L_0x052b
            if (r3 != 0) goto L_0x0518
            boolean[] r3 = r2.zzbat
            r5 = 0
            r6 = 0
        L_0x0507:
            if (r5 >= r4) goto L_0x0527
            int r7 = r0.readUnsignedByte()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x0512
            r7 = 1
            goto L_0x0513
        L_0x0512:
            r7 = 0
        L_0x0513:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x0507
        L_0x0518:
            if (r3 <= r1) goto L_0x051c
            r0 = 1
            goto L_0x051d
        L_0x051c:
            r0 = 0
        L_0x051d:
            int r3 = r3 * r4
            r1 = 0
            int r6 = r3 + 0
            boolean[] r3 = r2.zzbat
            java.util.Arrays.fill(r3, r1, r4, r0)
        L_0x0527:
            r2.zzau(r6)
            goto L_0x0550
        L_0x052b:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            int r1 = r2.zzaxa
            r2 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Length mismatch: "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ", "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x054e:
            r2 = r37
        L_0x0550:
            int r0 = com.google.android.gms.internal.ads.zzks.zzaut
            com.google.android.gms.internal.ads.zzku r0 = r9.zzas(r0)
            if (r0 == 0) goto L_0x05a2
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzawg
            r1 = 8
            r0.zzbl(r1)
            int r3 = r0.readInt()
            int r4 = com.google.android.gms.internal.ads.zzks.zzap(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x056e
            r0.zzbm(r1)
        L_0x056e:
            int r1 = r0.zzjf()
            if (r1 != r5) goto L_0x0589
            int r1 = com.google.android.gms.internal.ads.zzks.zzao(r3)
            long r3 = r2.zzbak
            if (r1 != 0) goto L_0x0581
            long r0 = r0.zzjc()
            goto L_0x0585
        L_0x0581:
            long r0 = r0.zzjg()
        L_0x0585:
            long r3 = r3 + r0
            r2.zzbak = r3
            goto L_0x05a2
        L_0x0589:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            r2 = 40
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected saio entry count: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x05a2:
            int r0 = com.google.android.gms.internal.ads.zzks.zzaux
            com.google.android.gms.internal.ads.zzku r0 = r9.zzas(r0)
            if (r0 == 0) goto L_0x05b0
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzawg
            r1 = 0
            zza(r0, r1, r2)
        L_0x05b0:
            int r0 = com.google.android.gms.internal.ads.zzks.zzauu
            com.google.android.gms.internal.ads.zzku r0 = r9.zzas(r0)
            int r1 = com.google.android.gms.internal.ads.zzks.zzauv
            com.google.android.gms.internal.ads.zzku r1 = r9.zzas(r1)
            if (r0 == 0) goto L_0x0655
            if (r1 == 0) goto L_0x0655
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzawg
            com.google.android.gms.internal.ads.zzpn r1 = r1.zzawg
            r3 = 8
            r0.zzbl(r3)
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            int r5 = zzaxj
            if (r4 != r5) goto L_0x0655
            int r3 = com.google.android.gms.internal.ads.zzks.zzao(r3)
            r4 = 1
            if (r3 != r4) goto L_0x05e0
            r3 = 4
            r0.zzbm(r3)
        L_0x05e0:
            int r0 = r0.readInt()
            if (r0 != r4) goto L_0x064d
            r0 = 8
            r1.zzbl(r0)
            int r0 = r1.readInt()
            int r3 = r1.readInt()
            int r5 = zzaxj
            if (r3 != r5) goto L_0x064b
            int r0 = com.google.android.gms.internal.ads.zzks.zzao(r0)
            if (r0 != r4) goto L_0x0610
            long r3 = r1.zzjc()
            int r0 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r0 == 0) goto L_0x0608
            r0 = 4
            r3 = 2
            goto L_0x0619
        L_0x0608:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x0610:
            r3 = 2
            if (r0 < r3) goto L_0x0618
            r0 = 4
            r1.zzbm(r0)
            goto L_0x0619
        L_0x0618:
            r0 = 4
        L_0x0619:
            long r4 = r1.zzjc()
            r6 = 1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0643
            r1.zzbm(r3)
            int r3 = r1.readUnsignedByte()
            r4 = 1
            if (r3 != r4) goto L_0x0657
            int r3 = r1.readUnsignedByte()
            r5 = 16
            byte[] r6 = new byte[r5]
            r7 = 0
            r1.zze(r6, r7, r5)
            r2.zzbas = r4
            com.google.android.gms.internal.ads.zzlr r1 = new com.google.android.gms.internal.ads.zzlr
            r1.<init>(r4, r3, r6)
            r2.zzbau = r1
            goto L_0x0657
        L_0x0643:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x064b:
            r0 = 4
            goto L_0x0657
        L_0x064d:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0655:
            r0 = 4
            r4 = 1
        L_0x0657:
            java.util.List<com.google.android.gms.internal.ads.zzku> r1 = r9.zzawi
            int r1 = r1.size()
            r3 = 0
        L_0x065e:
            if (r3 >= r1) goto L_0x0695
            java.util.List<com.google.android.gms.internal.ads.zzku> r5 = r9.zzawi
            java.lang.Object r5 = r5.get(r3)
            com.google.android.gms.internal.ads.zzku r5 = (com.google.android.gms.internal.ads.zzku) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzks.zzauw
            if (r6 != r7) goto L_0x0689
            com.google.android.gms.internal.ads.zzpn r5 = r5.zzawg
            r6 = 8
            r5.zzbl(r6)
            r7 = r31
            r8 = 0
            r10 = 16
            r5.zze(r7, r8, r10)
            byte[] r11 = zzaxk
            boolean r11 = java.util.Arrays.equals(r7, r11)
            if (r11 == 0) goto L_0x0690
            zza(r5, r10, r2)
            goto L_0x0690
        L_0x0689:
            r7 = r31
            r6 = 8
            r8 = 0
            r10 = 16
        L_0x0690:
            int r3 = r3 + 1
            r31 = r7
            goto L_0x065e
        L_0x0695:
            r7 = r31
            r6 = 8
            r8 = 0
            goto L_0x06ab
        L_0x069b:
            r33 = r1
            r20 = r2
            r48 = r3
            r22 = r7
            r34 = r8
            r0 = 4
            r4 = 1
            r6 = 8
            r8 = 0
            r7 = r5
        L_0x06ab:
            int r1 = r34 + 1
            r8 = r1
            r5 = r7
            r2 = r20
            r7 = r22
            r1 = r33
            r3 = r48
            r0 = r54
            r4 = 0
            r6 = 4
            goto L_0x01df
        L_0x06bd:
            r8 = 0
            java.util.List<com.google.android.gms.internal.ads.zzku> r0 = r1.zzawi
            com.google.android.gms.internal.ads.zzjo r0 = zzb(r0)
            if (r0 == 0) goto L_0x06e8
            r2 = r54
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r1 = r2.zzaxm
            int r1 = r1.size()
        L_0x06ce:
            if (r8 >= r1) goto L_0x06ff
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r3 = r2.zzaxm
            java.lang.Object r3 = r3.valueAt(r8)
            com.google.android.gms.internal.ads.zzli r3 = (com.google.android.gms.internal.ads.zzli) r3
            com.google.android.gms.internal.ads.zzkh r4 = r3.zzaso
            com.google.android.gms.internal.ads.zzlo r3 = r3.zzayk
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzahv
            com.google.android.gms.internal.ads.zzhp r3 = r3.zza((com.google.android.gms.internal.ads.zzjo) r0)
            r4.zze(r3)
            int r8 = r8 + 1
            goto L_0x06ce
        L_0x06e8:
            r2 = r54
            goto L_0x06ff
        L_0x06eb:
            r2 = r0
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r0 = r2.zzaxt
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06ff
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r0 = r2.zzaxt
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzkv r0 = (com.google.android.gms.internal.ads.zzkv) r0
            r0.zza((com.google.android.gms.internal.ads.zzkv) r1)
        L_0x06ff:
            r0 = r2
            goto L_0x0002
        L_0x0702:
            r2 = r0
            r54.zzhb()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzeb(long):void");
    }

    private final void zzhb() {
        this.zzaxv = 0;
        this.zzaxy = 0;
    }

    public final void release() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:253:0x0360 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x05ee A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0004 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r27, com.google.android.gms.internal.ads.zzkc r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
        L_0x0004:
            int r2 = r0.zzaxv
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = 3
            r6 = 2
            r7 = 4
            r8 = 0
            r9 = 8
            r11 = 0
            switch(r2) {
                case 0: goto L_0x01d9;
                case 1: goto L_0x007d;
                case 2: goto L_0x0026;
                default: goto L_0x0015;
            }
        L_0x0015:
            if (r2 != r5) goto L_0x0459
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            if (r2 != 0) goto L_0x03ce
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r7 = r2.size()
            r12 = r3
            r4 = r8
            r3 = 0
            goto L_0x0372
        L_0x0026:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r2 = r0.zzaxm
            int r2 = r2.size()
            r6 = r3
            r3 = 0
        L_0x002e:
            if (r3 >= r2) goto L_0x0052
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r4 = r0.zzaxm
            java.lang.Object r4 = r4.valueAt(r3)
            com.google.android.gms.internal.ads.zzli r4 = (com.google.android.gms.internal.ads.zzli) r4
            com.google.android.gms.internal.ads.zzlq r4 = r4.zzayj
            boolean r9 = r4.zzbax
            if (r9 == 0) goto L_0x004f
            long r9 = r4.zzbak
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 >= 0) goto L_0x004f
            long r6 = r4.zzbak
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r4 = r0.zzaxm
            java.lang.Object r4 = r4.valueAt(r3)
            com.google.android.gms.internal.ads.zzli r4 = (com.google.android.gms.internal.ads.zzli) r4
            r8 = r4
        L_0x004f:
            int r3 = r3 + 1
            goto L_0x002e
        L_0x0052:
            if (r8 != 0) goto L_0x0057
            r0.zzaxv = r5
            goto L_0x0004
        L_0x0057:
            long r2 = r27.getPosition()
            long r6 = r6 - r2
            int r2 = (int) r6
            if (r2 < 0) goto L_0x0075
            r1.zzag(r2)
            com.google.android.gms.internal.ads.zzlq r2 = r8.zzayj
            com.google.android.gms.internal.ads.zzpn r3 = r2.zzbaw
            byte[] r3 = r3.data
            int r4 = r2.zzbav
            r1.readFully(r3, r11, r4)
            com.google.android.gms.internal.ads.zzpn r3 = r2.zzbaw
            r3.zzbl(r11)
            r2.zzbax = r11
            goto L_0x0004
        L_0x0075:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Offset to encryption data was negative."
            r1.<init>(r2)
            throw r1
        L_0x007d:
            long r2 = r0.zzaxx
            int r3 = (int) r2
            int r2 = r0.zzaxy
            int r3 = r3 - r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxz
            if (r2 == 0) goto L_0x01cd
            byte[] r2 = r2.data
            r1.readFully(r2, r9, r3)
            com.google.android.gms.internal.ads.zzku r2 = new com.google.android.gms.internal.ads.zzku
            int r3 = r0.zzaxw
            com.google.android.gms.internal.ads.zzpn r4 = r0.zzaxz
            r2.<init>(r3, r4)
            long r3 = r27.getPosition()
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r5 = r0.zzaxt
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x00ae
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzaxt
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzkv r3 = (com.google.android.gms.internal.ads.zzkv) r3
            r3.zza((com.google.android.gms.internal.ads.zzku) r2)
            goto L_0x01d0
        L_0x00ae:
            int r5 = r2.type
            int r8 = com.google.android.gms.internal.ads.zzks.zzatq
            if (r5 != r8) goto L_0x0175
            com.google.android.gms.internal.ads.zzpn r2 = r2.zzawg
            r2.zzbl(r9)
            int r5 = r2.readInt()
            int r5 = com.google.android.gms.internal.ads.zzks.zzao(r5)
            r2.zzbm(r7)
            long r8 = r2.zzjc()
            if (r5 != 0) goto L_0x00d3
            long r12 = r2.zzjc()
            long r14 = r2.zzjc()
            goto L_0x00db
        L_0x00d3:
            long r12 = r2.zzjg()
            long r14 = r2.zzjg()
        L_0x00db:
            long r3 = r3 + r14
            r18 = r3
            r3 = r12
            r14 = 1000000(0xf4240, double:4.940656E-318)
            r12 = r3
            r16 = r8
            long r20 = com.google.android.gms.internal.ads.zzpt.zza((long) r12, (long) r14, (long) r16)
            r2.zzbm(r6)
            int r5 = r2.readUnsignedShort()
            int[] r6 = new int[r5]
            long[] r14 = new long[r5]
            long[] r15 = new long[r5]
            long[] r12 = new long[r5]
            r16 = r3
            r3 = r20
        L_0x00fc:
            if (r11 >= r5) goto L_0x014b
            int r13 = r2.readInt()
            r22 = -2147483648(0xffffffff80000000, float:-0.0)
            r22 = r13 & r22
            if (r22 != 0) goto L_0x0143
            long r22 = r2.zzjc()
            r24 = 2147483647(0x7fffffff, float:NaN)
            r13 = r13 & r24
            r6[r11] = r13
            r14[r11] = r18
            r12[r11] = r3
            long r3 = r16 + r22
            r16 = 1000000(0xf4240, double:4.940656E-318)
            r10 = r12
            r12 = r3
            r25 = r14
            r7 = r15
            r14 = r16
            r16 = r8
            long r12 = com.google.android.gms.internal.ads.zzpt.zza((long) r12, (long) r14, (long) r16)
            r14 = r10[r11]
            long r14 = r12 - r14
            r7[r11] = r14
            r14 = 4
            r2.zzbm(r14)
            r14 = r6[r11]
            long r14 = (long) r14
            long r18 = r18 + r14
            int r11 = r11 + 1
            r16 = r3
            r15 = r7
            r3 = r12
            r14 = r25
            r7 = 4
            r12 = r10
            goto L_0x00fc
        L_0x0143:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unhandled indirect reference"
            r1.<init>(r2)
            throw r1
        L_0x014b:
            r10 = r12
            r25 = r14
            r7 = r15
            java.lang.Long r2 = java.lang.Long.valueOf(r20)
            com.google.android.gms.internal.ads.zzju r3 = new com.google.android.gms.internal.ads.zzju
            r4 = r25
            r3.<init>(r6, r4, r7, r10)
            android.util.Pair r2 = android.util.Pair.create(r2, r3)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            r0.zzayc = r3
            com.google.android.gms.internal.ads.zzjy r3 = r0.zzarh
            java.lang.Object r2 = r2.second
            com.google.android.gms.internal.ads.zzkf r2 = (com.google.android.gms.internal.ads.zzkf) r2
            r3.zza(r2)
            r2 = 1
            r0.zzayi = r2
            goto L_0x01d0
        L_0x0175:
            int r3 = r2.type
            int r4 = com.google.android.gms.internal.ads.zzks.zzavw
            if (r3 != r4) goto L_0x01d0
            com.google.android.gms.internal.ads.zzpn r2 = r2.zzawg
            com.google.android.gms.internal.ads.zzkh r3 = r0.zzayg
            if (r3 == 0) goto L_0x01d0
            r3 = 12
            r2.zzbl(r3)
            r2.zzjh()
            r2.zzjh()
            long r8 = r2.zzjc()
            long r4 = r2.zzjc()
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = com.google.android.gms.internal.ads.zzpt.zza((long) r4, (long) r6, (long) r8)
            r2.zzbl(r3)
            int r10 = r2.zzja()
            com.google.android.gms.internal.ads.zzkh r3 = r0.zzayg
            r3.zza(r2, r10)
            long r2 = r0.zzayc
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01bd
            com.google.android.gms.internal.ads.zzkh r6 = r0.zzayg
            long r7 = r2 + r4
            r9 = 1
            r11 = 0
            r12 = 0
            r6.zza(r7, r9, r10, r11, r12)
            goto L_0x01d0
        L_0x01bd:
            java.util.LinkedList<com.google.android.gms.internal.ads.zzlj> r2 = r0.zzaxu
            com.google.android.gms.internal.ads.zzlj r3 = new com.google.android.gms.internal.ads.zzlj
            r3.<init>(r4, r10)
            r2.addLast(r3)
            int r2 = r0.zzayb
            int r2 = r2 + r10
            r0.zzayb = r2
            goto L_0x01d0
        L_0x01cd:
            r1.zzag(r3)
        L_0x01d0:
            long r2 = r27.getPosition()
            r0.zzeb(r2)
            goto L_0x0004
        L_0x01d9:
            int r2 = r0.zzaxy
            if (r2 != 0) goto L_0x0201
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            byte[] r2 = r2.data
            r3 = 1
            boolean r2 = r1.zza(r2, r11, r9, r3)
            if (r2 != 0) goto L_0x01ea
            goto L_0x035e
        L_0x01ea:
            r0.zzaxy = r9
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            r2.zzbl(r11)
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            long r2 = r2.zzjc()
            r0.zzaxx = r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            int r2 = r2.readInt()
            r0.zzaxw = r2
        L_0x0201:
            long r2 = r0.zzaxx
            r4 = 1
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x021d
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            byte[] r2 = r2.data
            r1.readFully(r2, r9, r9)
            int r2 = r0.zzaxy
            int r2 = r2 + r9
            r0.zzaxy = r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            long r2 = r2.zzjg()
            r0.zzaxx = r2
        L_0x021d:
            long r2 = r0.zzaxx
            int r4 = r0.zzaxy
            long r4 = (long) r4
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x036a
            long r2 = r27.getPosition()
            int r4 = r0.zzaxy
            long r4 = (long) r4
            long r2 = r2 - r4
            int r4 = r0.zzaxw
            int r5 = com.google.android.gms.internal.ads.zzks.zzaua
            if (r4 != r5) goto L_0x0250
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r4 = r0.zzaxm
            int r4 = r4.size()
            r5 = 0
        L_0x023b:
            if (r5 >= r4) goto L_0x0250
            android.util.SparseArray<com.google.android.gms.internal.ads.zzli> r7 = r0.zzaxm
            java.lang.Object r7 = r7.valueAt(r5)
            com.google.android.gms.internal.ads.zzli r7 = (com.google.android.gms.internal.ads.zzli) r7
            com.google.android.gms.internal.ads.zzlq r7 = r7.zzayj
            r7.zzbai = r2
            r7.zzbak = r2
            r7.zzbaj = r2
            int r5 = r5 + 1
            goto L_0x023b
        L_0x0250:
            int r4 = r0.zzaxw
            int r5 = com.google.android.gms.internal.ads.zzks.zzasx
            if (r4 != r5) goto L_0x0274
            r0.zzayd = r8
            long r4 = r0.zzaxx
            long r2 = r2 + r4
            r0.zzaya = r2
            boolean r2 = r0.zzayi
            if (r2 != 0) goto L_0x0270
            com.google.android.gms.internal.ads.zzjy r2 = r0.zzarh
            com.google.android.gms.internal.ads.zzke r3 = new com.google.android.gms.internal.ads.zzke
            long r4 = r0.zzaif
            r3.<init>(r4)
            r2.zza(r3)
            r2 = 1
            r0.zzayi = r2
        L_0x0270:
            r0.zzaxv = r6
            goto L_0x035d
        L_0x0274:
            int r2 = r0.zzaxw
            int r3 = com.google.android.gms.internal.ads.zzks.zzatr
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzatt
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzatu
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzatv
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzatw
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzaua
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzaub
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzauc
            if (r2 == r3) goto L_0x029d
            int r3 = com.google.android.gms.internal.ads.zzks.zzauf
            if (r2 != r3) goto L_0x029b
            goto L_0x029d
        L_0x029b:
            r2 = 0
            goto L_0x029e
        L_0x029d:
            r2 = 1
        L_0x029e:
            if (r2 == 0) goto L_0x02c9
            long r2 = r27.getPosition()
            long r4 = r0.zzaxx
            long r2 = r2 + r4
            r4 = 8
            long r2 = r2 - r4
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r4 = r0.zzaxt
            com.google.android.gms.internal.ads.zzkv r5 = new com.google.android.gms.internal.ads.zzkv
            int r6 = r0.zzaxw
            r5.<init>(r6, r2)
            r4.add(r5)
            long r4 = r0.zzaxx
            int r6 = r0.zzaxy
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x02c4
            r0.zzeb(r2)
            goto L_0x035d
        L_0x02c4:
            r26.zzhb()
            goto L_0x035d
        L_0x02c9:
            int r2 = r0.zzaxw
            int r3 = com.google.android.gms.internal.ads.zzks.zzaui
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzauh
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzats
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzatq
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzauj
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzatm
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzatn
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzaue
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzato
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzatp
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzauk
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzaus
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzaut
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzaux
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzauw
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzauu
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzauv
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzaug
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzaud
            if (r2 == r3) goto L_0x031e
            int r3 = com.google.android.gms.internal.ads.zzks.zzavw
            if (r2 != r3) goto L_0x031c
            goto L_0x031e
        L_0x031c:
            r2 = 0
            goto L_0x031f
        L_0x031e:
            r2 = 1
        L_0x031f:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r2 == 0) goto L_0x0352
            int r2 = r0.zzaxy
            if (r2 != r9) goto L_0x034a
            long r5 = r0.zzaxx
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0342
            com.google.android.gms.internal.ads.zzpn r2 = new com.google.android.gms.internal.ads.zzpn
            int r3 = (int) r5
            r2.<init>((int) r3)
            r0.zzaxz = r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaxr
            byte[] r2 = r2.data
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxz
            byte[] r3 = r3.data
            java.lang.System.arraycopy(r2, r11, r3, r11, r9)
            goto L_0x035a
        L_0x0342:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Leaf atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x034a:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Leaf atom defines extended atom size (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x0352:
            long r5 = r0.zzaxx
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0362
            r0.zzaxz = r8
        L_0x035a:
            r2 = 1
            r0.zzaxv = r2
        L_0x035d:
            r11 = 1
        L_0x035e:
            if (r11 != 0) goto L_0x0004
            r1 = -1
            return r1
        L_0x0362:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Skipping atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x036a:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Atom size less than header length (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x0372:
            if (r3 >= r7) goto L_0x0393
            java.lang.Object r10 = r2.valueAt(r3)
            com.google.android.gms.internal.ads.zzli r10 = (com.google.android.gms.internal.ads.zzli) r10
            int r14 = r10.zzayo
            com.google.android.gms.internal.ads.zzlq r15 = r10.zzayj
            int r15 = r15.zzbal
            if (r14 == r15) goto L_0x0390
            com.google.android.gms.internal.ads.zzlq r14 = r10.zzayj
            long[] r14 = r14.zzbam
            int r15 = r10.zzayo
            r15 = r14[r15]
            int r14 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0390
            r4 = r10
            r12 = r15
        L_0x0390:
            int r3 = r3 + 1
            goto L_0x0372
        L_0x0393:
            if (r4 != 0) goto L_0x03b1
            long r2 = r0.zzaya
            long r4 = r27.getPosition()
            long r2 = r2 - r4
            int r3 = (int) r2
            if (r3 < 0) goto L_0x03a9
            r1.zzag(r3)
            r26.zzhb()
            r3 = 0
            r5 = 0
            goto L_0x05ec
        L_0x03a9:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Offset to end of mdat was negative."
            r1.<init>(r2)
            throw r1
        L_0x03b1:
            com.google.android.gms.internal.ads.zzlq r2 = r4.zzayj
            long[] r2 = r2.zzbam
            int r3 = r4.zzayo
            r12 = r2[r3]
            long r2 = r27.getPosition()
            long r12 = r12 - r2
            int r2 = (int) r12
            if (r2 >= 0) goto L_0x03c9
            java.lang.String r2 = "FragmentedMp4Extractor"
            java.lang.String r3 = "Ignoring negative offset to sample data."
            android.util.Log.w(r2, r3)
            r2 = 0
        L_0x03c9:
            r1.zzag(r2)
            r0.zzayd = r4
        L_0x03ce:
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            com.google.android.gms.internal.ads.zzlq r2 = r2.zzayj
            int[] r2 = r2.zzbao
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            int r3 = r3.zzaym
            r2 = r2[r3]
            r0.zzaye = r2
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            com.google.android.gms.internal.ads.zzlq r2 = r2.zzayj
            boolean r2 = r2.zzbas
            if (r2 == 0) goto L_0x0441
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            com.google.android.gms.internal.ads.zzlq r3 = r2.zzayj
            com.google.android.gms.internal.ads.zzpn r4 = r3.zzbaw
            com.google.android.gms.internal.ads.zzlc r7 = r3.zzbah
            int r7 = r7.zzaxf
            com.google.android.gms.internal.ads.zzlr r10 = r3.zzbau
            if (r10 == 0) goto L_0x03f5
            com.google.android.gms.internal.ads.zzlr r7 = r3.zzbau
            goto L_0x03fb
        L_0x03f5:
            com.google.android.gms.internal.ads.zzlo r10 = r2.zzayk
            com.google.android.gms.internal.ads.zzlr[] r10 = r10.zzbad
            r7 = r10[r7]
        L_0x03fb:
            int r7 = r7.zzbba
            boolean[] r3 = r3.zzbat
            int r10 = r2.zzaym
            boolean r3 = r3[r10]
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzaxp
            byte[] r10 = r10.data
            if (r3 == 0) goto L_0x040c
            r12 = 128(0x80, float:1.794E-43)
            goto L_0x040d
        L_0x040c:
            r12 = 0
        L_0x040d:
            r12 = r12 | r7
            byte r12 = (byte) r12
            r10[r11] = r12
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzaxp
            r10.zzbl(r11)
            com.google.android.gms.internal.ads.zzkh r2 = r2.zzaso
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzaxp
            r12 = 1
            r2.zza(r10, r12)
            r2.zza(r4, r7)
            if (r3 != 0) goto L_0x0426
            int r7 = r7 + 1
            goto L_0x0437
        L_0x0426:
            int r3 = r4.readUnsignedShort()
            r10 = -2
            r4.zzbm(r10)
            int r3 = r3 * 6
            int r3 = r3 + r6
            r2.zza(r4, r3)
            int r7 = r7 + 1
            int r7 = r7 + r3
        L_0x0437:
            r0.zzare = r7
            int r2 = r0.zzaye
            int r3 = r0.zzare
            int r2 = r2 + r3
            r0.zzaye = r2
            goto L_0x0443
        L_0x0441:
            r0.zzare = r11
        L_0x0443:
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            com.google.android.gms.internal.ads.zzlo r2 = r2.zzayk
            int r2 = r2.zzbac
            r3 = 1
            if (r2 != r3) goto L_0x0454
            int r2 = r0.zzaye
            int r2 = r2 - r9
            r0.zzaye = r2
            r1.zzag(r9)
        L_0x0454:
            r2 = 4
            r0.zzaxv = r2
            r0.zzard = r11
        L_0x0459:
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            com.google.android.gms.internal.ads.zzlq r2 = r2.zzayj
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            com.google.android.gms.internal.ads.zzlo r3 = r3.zzayk
            com.google.android.gms.internal.ads.zzli r4 = r0.zzayd
            com.google.android.gms.internal.ads.zzkh r12 = r4.zzaso
            com.google.android.gms.internal.ads.zzli r4 = r0.zzayd
            int r4 = r4.zzaym
            int r7 = r3.zzasp
            r9 = 1000(0x3e8, double:4.94E-321)
            if (r7 == 0) goto L_0x0533
            com.google.android.gms.internal.ads.zzpn r7 = r0.zzaxn
            byte[] r7 = r7.data
            r7[r11] = r11
            r13 = 1
            r7[r13] = r11
            r7[r6] = r11
            int r6 = r3.zzasp
            int r6 = r6 + r13
            int r13 = r3.zzasp
            r14 = 4
            int r13 = 4 - r13
        L_0x0482:
            int r14 = r0.zzare
            int r15 = r0.zzaye
            if (r14 >= r15) goto L_0x0545
            int r14 = r0.zzard
            if (r14 != 0) goto L_0x04d0
            r1.readFully(r7, r13, r6)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxn
            r14.zzbl(r11)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxn
            int r14 = r14.zzjf()
            r15 = 1
            int r14 = r14 - r15
            r0.zzard = r14
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzapo
            r14.zzbl(r11)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzapo
            r5 = 4
            r12.zza(r14, r5)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxn
            r12.zza(r14, r15)
            com.google.android.gms.internal.ads.zzkh[] r14 = r0.zzayh
            if (r14 == 0) goto L_0x04c0
            com.google.android.gms.internal.ads.zzhp r14 = r3.zzahv
            java.lang.String r14 = r14.zzaha
            byte r15 = r7[r5]
            boolean r14 = com.google.android.gms.internal.ads.zzpi.zza(r14, r15)
            if (r14 == 0) goto L_0x04c0
            r14 = 1
            goto L_0x04c1
        L_0x04c0:
            r14 = 0
        L_0x04c1:
            r0.zzayf = r14
            int r14 = r0.zzare
            int r14 = r14 + 5
            r0.zzare = r14
            int r14 = r0.zzaye
            int r14 = r14 + r13
            r0.zzaye = r14
            r5 = 3
            goto L_0x0482
        L_0x04d0:
            r5 = 4
            boolean r15 = r0.zzayf
            if (r15 == 0) goto L_0x051d
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaxo
            r15.reset(r14)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxo
            byte[] r14 = r14.data
            int r15 = r0.zzard
            r1.readFully(r14, r11, r15)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxo
            int r15 = r0.zzard
            r12.zza(r14, r15)
            int r14 = r0.zzard
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaxo
            byte[] r15 = r15.data
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzaxo
            int r5 = r5.limit()
            int r5 = com.google.android.gms.internal.ads.zzpi.zzb(r15, r5)
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaxo
            java.lang.String r8 = "video/hevc"
            com.google.android.gms.internal.ads.zzhp r11 = r3.zzahv
            java.lang.String r11 = r11.zzaha
            boolean r8 = r8.equals(r11)
            r15.zzbl(r8)
            com.google.android.gms.internal.ads.zzpn r8 = r0.zzaxo
            r8.zzbk(r5)
            long r15 = r2.zzav(r4)
            r8 = r6
            long r5 = r15 * r9
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzaxo
            com.google.android.gms.internal.ads.zzkh[] r15 = r0.zzayh
            com.google.android.gms.internal.ads.zzns.zza(r5, r11, r15)
            goto L_0x0523
        L_0x051d:
            r8 = r6
            r5 = 0
            int r14 = r12.zza(r1, r14, r5)
        L_0x0523:
            int r5 = r0.zzare
            int r5 = r5 + r14
            r0.zzare = r5
            int r5 = r0.zzard
            int r5 = r5 - r14
            r0.zzard = r5
            r6 = r8
            r5 = 3
            r8 = 0
            r11 = 0
            goto L_0x0482
        L_0x0533:
            int r5 = r0.zzare
            int r6 = r0.zzaye
            if (r5 >= r6) goto L_0x0545
            int r6 = r6 - r5
            r5 = 0
            int r6 = r12.zza(r1, r6, r5)
            int r5 = r0.zzare
            int r5 = r5 + r6
            r0.zzare = r5
            goto L_0x0533
        L_0x0545:
            long r5 = r2.zzav(r4)
            long r5 = r5 * r9
            boolean r7 = r2.zzbas
            if (r7 == 0) goto L_0x0552
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x0553
        L_0x0552:
            r11 = 0
        L_0x0553:
            boolean[] r7 = r2.zzbar
            boolean r4 = r7[r4]
            r15 = r11 | r4
            boolean r4 = r2.zzbas
            if (r4 == 0) goto L_0x0581
            com.google.android.gms.internal.ads.zzlr r4 = r2.zzbau
            if (r4 == 0) goto L_0x0564
            com.google.android.gms.internal.ads.zzlr r3 = r2.zzbau
            goto L_0x056c
        L_0x0564:
            com.google.android.gms.internal.ads.zzlr[] r3 = r3.zzbad
            com.google.android.gms.internal.ads.zzlc r4 = r2.zzbah
            int r4 = r4.zzaxf
            r3 = r3[r4]
        L_0x056c:
            r8 = r3
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            com.google.android.gms.internal.ads.zzlr r3 = r3.zzayq
            if (r8 == r3) goto L_0x057c
            com.google.android.gms.internal.ads.zzkg r3 = new com.google.android.gms.internal.ads.zzkg
            byte[] r4 = r8.zzbbb
            r7 = 1
            r3.<init>(r7, r4)
            goto L_0x0583
        L_0x057c:
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            com.google.android.gms.internal.ads.zzkg r3 = r3.zzayp
            goto L_0x0583
        L_0x0581:
            r3 = 0
            r8 = 0
        L_0x0583:
            com.google.android.gms.internal.ads.zzli r4 = r0.zzayd
            r4.zzayp = r3
            r4.zzayq = r8
            int r4 = r0.zzaye
            r17 = 0
            r13 = r5
            r16 = r4
            r18 = r3
            r12.zza(r13, r15, r16, r17, r18)
        L_0x0595:
            java.util.LinkedList<com.google.android.gms.internal.ads.zzlj> r3 = r0.zzaxu
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x05bb
            java.util.LinkedList<com.google.android.gms.internal.ads.zzlj> r3 = r0.zzaxu
            java.lang.Object r3 = r3.removeFirst()
            com.google.android.gms.internal.ads.zzlj r3 = (com.google.android.gms.internal.ads.zzlj) r3
            int r4 = r0.zzayb
            int r7 = r3.size
            int r4 = r4 - r7
            r0.zzayb = r4
            com.google.android.gms.internal.ads.zzkh r7 = r0.zzayg
            long r8 = r3.zzayr
            long r8 = r8 + r5
            r10 = 1
            int r11 = r3.size
            int r12 = r0.zzayb
            r13 = 0
            r7.zza(r8, r10, r11, r12, r13)
            goto L_0x0595
        L_0x05bb:
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            int r4 = r3.zzaym
            r5 = 1
            int r4 = r4 + r5
            r3.zzaym = r4
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            int r4 = r3.zzayn
            int r4 = r4 + r5
            r3.zzayn = r4
            com.google.android.gms.internal.ads.zzli r3 = r0.zzayd
            int r3 = r3.zzayn
            int[] r2 = r2.zzban
            com.google.android.gms.internal.ads.zzli r4 = r0.zzayd
            int r4 = r4.zzayo
            r2 = r2[r4]
            if (r3 != r2) goto L_0x05e8
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            int r3 = r2.zzayo
            int r3 = r3 + r5
            r2.zzayo = r3
            com.google.android.gms.internal.ads.zzli r2 = r0.zzayd
            r3 = 0
            r2.zzayn = r3
            r2 = 0
            r0.zzayd = r2
            goto L_0x05e9
        L_0x05e8:
            r3 = 0
        L_0x05e9:
            r2 = 3
            r0.zzaxv = r2
        L_0x05ec:
            if (r5 == 0) goto L_0x0004
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    public final void zza(zzjy zzjy) {
        this.zzarh = zzjy;
    }

    public final boolean zza(zzjz zzjz) {
        return zzlp.zzd(zzjz);
    }

    public final void zzc(long j, long j2) {
        int size = this.zzaxm.size();
        for (int i = 0; i < size; i++) {
            this.zzaxm.valueAt(i).reset();
        }
        this.zzaxu.clear();
        this.zzayb = 0;
        this.zzaxt.clear();
        zzhb();
    }
}
