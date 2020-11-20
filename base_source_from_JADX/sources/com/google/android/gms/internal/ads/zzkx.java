package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzmd;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.i18n.TextBundle;

final class zzkx {
    private static final int zzavr = zzpt.zzbh("meta");
    private static final int zzawr = zzpt.zzbh("vide");
    private static final int zzaws = zzpt.zzbh("soun");
    private static final int zzawt = zzpt.zzbh(TextBundle.TEXT_ENTRY);
    private static final int zzawu = zzpt.zzbh("sbtl");
    private static final int zzawv = zzpt.zzbh("subt");
    private static final int zzaww = zzpt.zzbh("clcp");
    private static final int zzawx = zzpt.zzbh("cenc");

    private static int zza(zzpn zzpn, int i, int i2, zzky zzky, int i3) {
        zzlr zzlr;
        zzpn zzpn2 = zzpn;
        int position = zzpn.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzpn.zzbl(position);
            int readInt = zzpn.readInt();
            zzpc.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpn.readInt() == zzks.zzaul) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzlr zzlr2 = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzpn.zzbl(i4);
                    int readInt2 = zzpn.readInt();
                    int readInt3 = zzpn.readInt();
                    if (readInt3 == zzks.zzaur) {
                        num = Integer.valueOf(zzpn.readInt());
                    } else if (readInt3 == zzks.zzaum) {
                        zzpn.zzbm(4);
                        z2 = zzpn.readInt() == zzawx;
                    } else if (readInt3 == zzks.zzaun) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzlr = null;
                                break;
                            }
                            zzpn.zzbl(i5);
                            int readInt4 = zzpn.readInt();
                            if (zzpn.readInt() == zzks.zzauo) {
                                zzpn.zzbm(6);
                                boolean z3 = zzpn.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpn.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpn.zze(bArr, 0, 16);
                                zzlr = new zzlr(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        zzlr2 = zzlr;
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzpc.checkArgument(num != null, "frma atom is mandatory");
                    if (zzlr2 != null) {
                        z = true;
                    }
                    zzpc.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlr2);
                }
                if (pair != null) {
                    zzky.zzawy[i3] = (zzlr) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzky zzky2 = zzky;
            position += readInt;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v20, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0541: MOVE  (r2v70 java.lang.String) = (r41v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x071b  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x074a  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0790  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x07e2  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x07eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x07ec  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b6  */
    public static com.google.android.gms.internal.ads.zzlo zza(com.google.android.gms.internal.ads.zzkv r47, com.google.android.gms.internal.ads.zzku r48, long r49, com.google.android.gms.internal.ads.zzjo r51, boolean r52) {
        /*
            r0 = r47
            r15 = r51
            int r1 = com.google.android.gms.internal.ads.zzks.zzatu
            com.google.android.gms.internal.ads.zzkv r1 = r0.zzat(r1)
            int r2 = com.google.android.gms.internal.ads.zzks.zzaui
            com.google.android.gms.internal.ads.zzku r2 = r1.zzas(r2)
            com.google.android.gms.internal.ads.zzpn r2 = r2.zzawg
            r14 = 16
            r2.zzbl(r14)
            int r2 = r2.readInt()
            int r3 = zzaws
            r4 = 4
            r11 = -1
            if (r2 != r3) goto L_0x0023
            r10 = 1
            goto L_0x0043
        L_0x0023:
            int r3 = zzawr
            if (r2 != r3) goto L_0x0029
            r10 = 2
            goto L_0x0043
        L_0x0029:
            int r3 = zzawt
            if (r2 == r3) goto L_0x0042
            int r3 = zzawu
            if (r2 == r3) goto L_0x0042
            int r3 = zzawv
            if (r2 == r3) goto L_0x0042
            int r3 = zzaww
            if (r2 != r3) goto L_0x003a
            goto L_0x0042
        L_0x003a:
            int r3 = zzavr
            if (r2 != r3) goto L_0x0040
            r10 = 4
            goto L_0x0043
        L_0x0040:
            r10 = -1
            goto L_0x0043
        L_0x0042:
            r10 = 3
        L_0x0043:
            r8 = 0
            if (r10 != r11) goto L_0x0047
            return r8
        L_0x0047:
            int r2 = com.google.android.gms.internal.ads.zzks.zzaue
            com.google.android.gms.internal.ads.zzku r2 = r0.zzas(r2)
            com.google.android.gms.internal.ads.zzpn r2 = r2.zzawg
            r7 = 8
            r2.zzbl(r7)
            int r3 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.zzks.zzao(r3)
            if (r3 != 0) goto L_0x0061
            r5 = 8
            goto L_0x0063
        L_0x0061:
            r5 = 16
        L_0x0063:
            r2.zzbm(r5)
            int r5 = r2.readInt()
            r2.zzbm(r4)
            int r6 = r2.getPosition()
            if (r3 != 0) goto L_0x0075
            r12 = 4
            goto L_0x0077
        L_0x0075:
            r12 = 8
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 >= r12) goto L_0x0088
            byte[] r8 = r2.data
            int r20 = r6 + r9
            byte r8 = r8[r20]
            if (r8 == r11) goto L_0x0084
            r6 = 0
            goto L_0x0089
        L_0x0084:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x0078
        L_0x0088:
            r6 = 1
        L_0x0089:
            r20 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 == 0) goto L_0x0097
            r2.zzbm(r12)
        L_0x0095:
            r11 = r8
            goto L_0x00a9
        L_0x0097:
            if (r3 != 0) goto L_0x009e
            long r22 = r2.zzjc()
            goto L_0x00a2
        L_0x009e:
            long r22 = r2.zzjg()
        L_0x00a2:
            int r3 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r3 != 0) goto L_0x00a7
            goto L_0x0095
        L_0x00a7:
            r11 = r22
        L_0x00a9:
            r2.zzbm(r14)
            int r3 = r2.readInt()
            int r6 = r2.readInt()
            r2.zzbm(r4)
            int r4 = r2.readInt()
            int r2 = r2.readInt()
            r14 = 65536(0x10000, float:9.18355E-41)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00ce
            if (r6 != r14) goto L_0x00ce
            if (r4 != r13) goto L_0x00ce
            if (r2 != 0) goto L_0x00ce
            r2 = 90
            goto L_0x00e5
        L_0x00ce:
            if (r3 != 0) goto L_0x00d9
            if (r6 != r13) goto L_0x00d9
            if (r4 != r14) goto L_0x00d9
            if (r2 != 0) goto L_0x00d9
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00e5
        L_0x00d9:
            if (r3 != r13) goto L_0x00e4
            if (r6 != 0) goto L_0x00e4
            if (r4 != 0) goto L_0x00e4
            if (r2 != r13) goto L_0x00e4
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00e5
        L_0x00e4:
            r2 = 0
        L_0x00e5:
            com.google.android.gms.internal.ads.zzld r14 = new com.google.android.gms.internal.ads.zzld
            r14.<init>(r5, r11, r2)
            int r2 = (r49 > r8 ? 1 : (r49 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x00f7
            long r2 = r14.zzde
            r26 = r2
            r2 = r48
            goto L_0x00fb
        L_0x00f7:
            r2 = r48
            r26 = r49
        L_0x00fb:
            com.google.android.gms.internal.ads.zzpn r2 = r2.zzawg
            r2.zzbl(r7)
            int r3 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.zzks.zzao(r3)
            if (r3 != 0) goto L_0x010d
            r3 = 8
            goto L_0x010f
        L_0x010d:
            r3 = 16
        L_0x010f:
            r2.zzbm(r3)
            long r32 = r2.zzjc()
            int r2 = (r26 > r8 ? 1 : (r26 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x011d
            r26 = r8
            goto L_0x0128
        L_0x011d:
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r32
            long r2 = com.google.android.gms.internal.ads.zzpt.zza((long) r26, (long) r28, (long) r30)
            r26 = r2
        L_0x0128:
            int r2 = com.google.android.gms.internal.ads.zzks.zzatv
            com.google.android.gms.internal.ads.zzkv r2 = r1.zzat(r2)
            int r3 = com.google.android.gms.internal.ads.zzks.zzatw
            com.google.android.gms.internal.ads.zzkv r2 = r2.zzat(r3)
            int r3 = com.google.android.gms.internal.ads.zzks.zzauh
            com.google.android.gms.internal.ads.zzku r1 = r1.zzas(r3)
            com.google.android.gms.internal.ads.zzpn r1 = r1.zzawg
            r1.zzbl(r7)
            int r3 = r1.readInt()
            int r3 = com.google.android.gms.internal.ads.zzks.zzao(r3)
            if (r3 != 0) goto L_0x014c
            r4 = 8
            goto L_0x014e
        L_0x014c:
            r4 = 16
        L_0x014e:
            r1.zzbm(r4)
            long r4 = r1.zzjc()
            if (r3 != 0) goto L_0x0159
            r3 = 4
            goto L_0x015b
        L_0x0159:
            r3 = 8
        L_0x015b:
            r1.zzbm(r3)
            int r1 = r1.readUnsignedShort()
            int r3 = r1 >> 10
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r9 = 3
            r8.<init>(r9)
            r8.append(r3)
            r8.append(r6)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            android.util.Pair r13 = android.util.Pair.create(r3, r1)
            int r1 = com.google.android.gms.internal.ads.zzks.zzauj
            com.google.android.gms.internal.ads.zzku r1 = r2.zzas(r1)
            com.google.android.gms.internal.ads.zzpn r12 = r1.zzawg
            int r22 = r14.f6907id
            int r28 = r14.zzahf
            java.lang.Object r1 = r13.second
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11
            r1 = 12
            r12.zzbl(r1)
            int r9 = r12.readInt()
            com.google.android.gms.internal.ads.zzky r8 = new com.google.android.gms.internal.ads.zzky
            r8.<init>(r9)
            r6 = 0
        L_0x01b4:
            if (r6 >= r9) goto L_0x0774
            int r5 = r12.getPosition()
            int r4 = r12.readInt()
            if (r4 <= 0) goto L_0x01c2
            r1 = 1
            goto L_0x01c3
        L_0x01c2:
            r1 = 0
        L_0x01c3:
            java.lang.String r2 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpc.checkArgument(r1, r2)
            int r1 = r12.readInt()
            int r2 = com.google.android.gms.internal.ads.zzks.zzasr
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzass
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzaup
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzavb
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzast
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzasu
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzasv
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzawa
            if (r1 == r2) goto L_0x0589
            int r2 = com.google.android.gms.internal.ads.zzks.zzawb
            if (r1 != r2) goto L_0x01f2
            goto L_0x0589
        L_0x01f2:
            int r2 = com.google.android.gms.internal.ads.zzks.zzasy
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzauq
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzatd
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzatf
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzath
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzatk
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzati
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzatj
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzavo
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzavp
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzatb
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzatc
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzasz
            if (r1 == r2) goto L_0x0315
            int r2 = com.google.android.gms.internal.ads.zzks.zzawe
            if (r1 != r2) goto L_0x022c
            goto L_0x0315
        L_0x022c:
            int r2 = com.google.android.gms.internal.ads.zzks.zzauz
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzks.zzavk
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzks.zzavl
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzks.zzavm
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzks.zzavn
            if (r1 != r2) goto L_0x0241
            goto L_0x026a
        L_0x0241:
            int r2 = com.google.android.gms.internal.ads.zzks.zzawd
            if (r1 != r2) goto L_0x0254
            java.lang.String r1 = java.lang.Integer.toString(r22)
            java.lang.String r2 = "application/x-camera-motion"
            r3 = 0
            r7 = -1
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r7, r15)
            r8.zzahv = r1
            goto L_0x0255
        L_0x0254:
            r3 = 0
        L_0x0255:
            r29 = r4
            r23 = r5
            r25 = r6
            r0 = r8
            r24 = r9
            r19 = r10
            r34 = r11
            r46 = r12
            r45 = r13
            r18 = r14
            goto L_0x0371
        L_0x026a:
            r3 = 0
            r7 = -1
            int r2 = r5 + 8
            r19 = 8
            int r2 = r2 + 8
            r12.zzbl(r2)
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = com.google.android.gms.internal.ads.zzks.zzauz
            if (r1 != r2) goto L_0x0288
            java.lang.String r1 = "application/ttml+xml"
            r2 = r1
            r17 = r3
            r3 = 1
            r7 = 0
            r19 = 8
            goto L_0x02c6
        L_0x0288:
            int r2 = com.google.android.gms.internal.ads.zzks.zzavk
            if (r1 != r2) goto L_0x02a3
            java.lang.String r1 = "application/x-quicktime-tx3g"
            int r2 = r4 + -8
            r19 = 8
            int r2 = r2 + -8
            byte[] r3 = new byte[r2]
            r7 = 0
            r12.zze(r3, r7, r2)
            java.util.List r2 = java.util.Collections.singletonList(r3)
            r17 = r2
            r3 = 1
            r2 = r1
            goto L_0x02c6
        L_0x02a3:
            r7 = 0
            r19 = 8
            int r2 = com.google.android.gms.internal.ads.zzks.zzavl
            if (r1 != r2) goto L_0x02b1
            java.lang.String r1 = "application/x-mp4-vtt"
            r2 = r1
        L_0x02ad:
            r3 = 1
        L_0x02ae:
            r17 = 0
            goto L_0x02c6
        L_0x02b1:
            int r2 = com.google.android.gms.internal.ads.zzks.zzavm
            if (r1 != r2) goto L_0x02bb
            java.lang.String r1 = "application/ttml+xml"
            r2 = r1
            r29 = r20
            goto L_0x02ad
        L_0x02bb:
            int r2 = com.google.android.gms.internal.ads.zzks.zzavn
            if (r1 != r2) goto L_0x030f
            java.lang.String r1 = "application/x-mp4-cea-608"
            r3 = 1
            r8.zzawz = r3
            r2 = r1
            goto L_0x02ae
        L_0x02c6:
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r18 = 0
            r34 = -1
            r35 = 0
            r36 = -1
            r24 = 1
            r37 = 0
            r3 = r18
            r18 = r14
            r14 = r4
            r4 = r34
            r38 = r5
            r5 = r35
            r39 = r6
            r6 = r11
            r19 = 0
            r31 = -1
            r7 = r36
            r40 = r8
            r8 = r51
            r24 = r9
            r19 = r10
            r9 = r29
            r0 = r11
            r48 = r13
            r13 = -1
            r11 = r17
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r40
            r11.zzahv = r1
            r45 = r48
            r34 = r0
            r0 = r11
            r46 = r12
            r29 = r14
            r23 = r38
            goto L_0x036f
        L_0x030f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0315:
            r38 = r5
            r39 = r6
            r24 = r9
            r19 = r10
            r0 = r11
            r48 = r13
            r18 = r14
            r13 = -1
            r14 = r4
            r11 = r8
            r10 = r38
            int r5 = r10 + 8
            r9 = 8
            int r5 = r5 + r9
            r12.zzbl(r5)
            if (r52 == 0) goto L_0x033a
            int r2 = r12.readUnsignedShort()
            r3 = 6
            r12.zzbm(r3)
            goto L_0x033e
        L_0x033a:
            r12.zzbm(r9)
            r2 = 0
        L_0x033e:
            if (r2 == 0) goto L_0x037b
            r8 = 1
            if (r2 != r8) goto L_0x0345
            r7 = 2
            goto L_0x037d
        L_0x0345:
            r7 = 2
            if (r2 != r7) goto L_0x0364
            r2 = 16
            r12.zzbm(r2)
            long r2 = r12.readLong()
            double r2 = java.lang.Double.longBitsToDouble(r2)
            long r2 = java.lang.Math.round(r2)
            int r3 = (int) r2
            int r2 = r12.zzjf()
            r4 = 20
            r12.zzbm(r4)
            goto L_0x0392
        L_0x0364:
            r45 = r48
            r34 = r0
            r23 = r10
            r0 = r11
            r46 = r12
            r29 = r14
        L_0x036f:
            r25 = r39
        L_0x0371:
            r16 = -1
            r17 = 0
        L_0x0375:
            r30 = 16
            r31 = 3
            goto L_0x0757
        L_0x037b:
            r7 = 2
            r8 = 1
        L_0x037d:
            int r3 = r12.readUnsignedShort()
            r4 = 6
            r12.zzbm(r4)
            int r4 = r12.zzje()
            if (r2 != r8) goto L_0x0390
            r2 = 16
            r12.zzbm(r2)
        L_0x0390:
            r2 = r3
            r3 = r4
        L_0x0392:
            int r4 = r12.getPosition()
            int r5 = com.google.android.gms.internal.ads.zzks.zzauq
            if (r1 != r5) goto L_0x03a4
            r6 = r39
            int r1 = zza((com.google.android.gms.internal.ads.zzpn) r12, (int) r10, (int) r14, (com.google.android.gms.internal.ads.zzky) r11, (int) r6)
            r12.zzbl(r4)
            goto L_0x03a6
        L_0x03a4:
            r6 = r39
        L_0x03a6:
            int r5 = com.google.android.gms.internal.ads.zzks.zzatd
            if (r1 != r5) goto L_0x03ad
            java.lang.String r1 = "audio/ac3"
            goto L_0x03f7
        L_0x03ad:
            int r5 = com.google.android.gms.internal.ads.zzks.zzatf
            if (r1 != r5) goto L_0x03b4
            java.lang.String r1 = "audio/eac3"
            goto L_0x03f7
        L_0x03b4:
            int r5 = com.google.android.gms.internal.ads.zzks.zzath
            if (r1 != r5) goto L_0x03bb
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03f7
        L_0x03bb:
            int r5 = com.google.android.gms.internal.ads.zzks.zzati
            if (r1 == r5) goto L_0x03f5
            int r5 = com.google.android.gms.internal.ads.zzks.zzatj
            if (r1 != r5) goto L_0x03c4
            goto L_0x03f5
        L_0x03c4:
            int r5 = com.google.android.gms.internal.ads.zzks.zzatk
            if (r1 != r5) goto L_0x03cb
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03f7
        L_0x03cb:
            int r5 = com.google.android.gms.internal.ads.zzks.zzavo
            if (r1 != r5) goto L_0x03d2
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03f7
        L_0x03d2:
            int r5 = com.google.android.gms.internal.ads.zzks.zzavp
            if (r1 != r5) goto L_0x03d9
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03f7
        L_0x03d9:
            int r5 = com.google.android.gms.internal.ads.zzks.zzatb
            if (r1 == r5) goto L_0x03f2
            int r5 = com.google.android.gms.internal.ads.zzks.zzatc
            if (r1 != r5) goto L_0x03e2
            goto L_0x03f2
        L_0x03e2:
            int r5 = com.google.android.gms.internal.ads.zzks.zzasz
            if (r1 != r5) goto L_0x03e9
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03f7
        L_0x03e9:
            int r5 = com.google.android.gms.internal.ads.zzks.zzawe
            if (r1 != r5) goto L_0x03f0
            java.lang.String r1 = "audio/alac"
            goto L_0x03f7
        L_0x03f0:
            r1 = 0
            goto L_0x03f7
        L_0x03f2:
            java.lang.String r1 = "audio/raw"
            goto L_0x03f7
        L_0x03f5:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03f7:
            r16 = r2
            r17 = r3
            r5 = r4
            r29 = 0
            r4 = r1
        L_0x03ff:
            int r1 = r5 - r10
            if (r1 >= r14) goto L_0x0532
            r12.zzbl(r5)
            int r3 = r12.readInt()
            if (r3 <= 0) goto L_0x040e
            r1 = 1
            goto L_0x040f
        L_0x040e:
            r1 = 0
        L_0x040f:
            java.lang.String r2 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpc.checkArgument(r1, r2)
            int r1 = r12.readInt()
            int r2 = com.google.android.gms.internal.ads.zzks.zzatz
            if (r1 == r2) goto L_0x04b2
            if (r52 == 0) goto L_0x0424
            int r2 = com.google.android.gms.internal.ads.zzks.zzata
            if (r1 != r2) goto L_0x0424
            goto L_0x04b2
        L_0x0424:
            int r2 = com.google.android.gms.internal.ads.zzks.zzate
            if (r1 != r2) goto L_0x0445
            int r1 = r5 + 8
            r12.zzbl(r1)
            java.lang.String r1 = java.lang.Integer.toString(r22)
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzid.zza(r12, r1, r0, r15)
        L_0x0435:
            r11.zzahv = r1
            r13 = r3
            r41 = r4
            r4 = r5
            r43 = r6
            r44 = r10
            r15 = r11
            r11 = 0
            r30 = 2
            goto L_0x04af
        L_0x0445:
            int r2 = com.google.android.gms.internal.ads.zzks.zzatg
            if (r1 != r2) goto L_0x0457
            int r1 = r5 + 8
            r12.zzbl(r1)
            java.lang.String r1 = java.lang.Integer.toString(r22)
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzid.zzb(r12, r1, r0, r15)
            goto L_0x0435
        L_0x0457:
            int r2 = com.google.android.gms.internal.ads.zzks.zzatl
            if (r1 != r2) goto L_0x048e
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r30 = 0
            r31 = -1
            r34 = -1
            r35 = 0
            r36 = 0
            r2 = r4
            r13 = r3
            r3 = r30
            r41 = r4
            r4 = r31
            r42 = r5
            r5 = r34
            r43 = r6
            r6 = r16
            r30 = 2
            r7 = r17
            r8 = r35
            r9 = r51
            r44 = r10
            r10 = r36
            r15 = r11
            r11 = r0
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.zzahv = r1
            goto L_0x04ac
        L_0x048e:
            r13 = r3
            r41 = r4
            r42 = r5
            r43 = r6
            r44 = r10
            r15 = r11
            r30 = 2
            int r2 = com.google.android.gms.internal.ads.zzks.zzawe
            if (r1 != r2) goto L_0x04ac
            byte[] r1 = new byte[r13]
            r4 = r42
            r12.zzbl(r4)
            r11 = 0
            r12.zze(r1, r11, r13)
            r29 = r1
            goto L_0x04af
        L_0x04ac:
            r4 = r42
            r11 = 0
        L_0x04af:
            r10 = -1
            goto L_0x0520
        L_0x04b2:
            r13 = r3
            r41 = r4
            r4 = r5
            r43 = r6
            r44 = r10
            r15 = r11
            r11 = 0
            r30 = 2
            int r2 = com.google.android.gms.internal.ads.zzks.zzatz
            if (r1 != r2) goto L_0x04c5
            r1 = r4
        L_0x04c3:
            r10 = -1
            goto L_0x04eb
        L_0x04c5:
            int r1 = r12.getPosition()
        L_0x04c9:
            int r2 = r1 - r4
            if (r2 >= r13) goto L_0x04e9
            r12.zzbl(r1)
            int r2 = r12.readInt()
            if (r2 <= 0) goto L_0x04d8
            r3 = 1
            goto L_0x04d9
        L_0x04d8:
            r3 = 0
        L_0x04d9:
            java.lang.String r5 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpc.checkArgument(r3, r5)
            int r3 = r12.readInt()
            int r5 = com.google.android.gms.internal.ads.zzks.zzatz
            if (r3 != r5) goto L_0x04e7
            goto L_0x04c3
        L_0x04e7:
            int r1 = r1 + r2
            goto L_0x04c9
        L_0x04e9:
            r1 = -1
            goto L_0x04c3
        L_0x04eb:
            if (r1 == r10) goto L_0x051c
            android.util.Pair r1 = zzb(r12, r1)
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.second
            r29 = r1
            byte[] r29 = (byte[]) r29
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x051e
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzpf.zze(r29)
            java.lang.Object r3 = r1.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r16 = r1
            r17 = r3
            goto L_0x051e
        L_0x051c:
            r2 = r41
        L_0x051e:
            r41 = r2
        L_0x0520:
            int r5 = r4 + r13
            r11 = r15
            r4 = r41
            r6 = r43
            r10 = r44
            r7 = 2
            r8 = 1
            r9 = 8
            r13 = -1
            r15 = r51
            goto L_0x03ff
        L_0x0532:
            r41 = r4
            r43 = r6
            r44 = r10
            r15 = r11
            r10 = -1
            r11 = 0
            r30 = 2
            com.google.android.gms.internal.ads.zzhp r1 = r15.zzahv
            if (r1 != 0) goto L_0x0575
            r2 = r41
            if (r2 == 0) goto L_0x0575
            java.lang.String r1 = "audio/raw"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x054f
            r8 = 2
            goto L_0x0550
        L_0x054f:
            r8 = -1
        L_0x0550:
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r3 = 0
            r4 = -1
            r5 = -1
            if (r29 != 0) goto L_0x055b
            r9 = 0
            goto L_0x0560
        L_0x055b:
            java.util.List r6 = java.util.Collections.singletonList(r29)
            r9 = r6
        L_0x0560:
            r13 = 0
            r6 = r16
            r7 = r17
            r16 = -1
            r10 = r51
            r17 = 0
            r11 = r13
            r13 = r12
            r12 = r0
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r15.zzahv = r1
            goto L_0x057a
        L_0x0575:
            r13 = r12
            r16 = -1
            r17 = 0
        L_0x057a:
            r45 = r48
            r34 = r0
            r46 = r13
            r29 = r14
            r0 = r15
            r25 = r43
            r23 = r44
            goto L_0x0375
        L_0x0589:
            r44 = r5
            r43 = r6
            r15 = r8
            r24 = r9
            r19 = r10
            r0 = r11
            r48 = r13
            r18 = r14
            r16 = -1
            r17 = 0
            r14 = r4
            r13 = r12
            r12 = r44
            int r5 = r12 + 8
            r11 = 8
            int r5 = r5 + r11
            r13.zzbl(r5)
            r10 = 16
            r13.zzbm(r10)
            int r6 = r13.readUnsignedShort()
            int r7 = r13.readUnsignedShort()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 50
            r13.zzbm(r3)
            int r3 = r13.getPosition()
            int r4 = com.google.android.gms.internal.ads.zzks.zzaup
            if (r1 != r4) goto L_0x05cd
            r9 = r43
            int r1 = zza((com.google.android.gms.internal.ads.zzpn) r13, (int) r12, (int) r14, (com.google.android.gms.internal.ads.zzky) r15, (int) r9)
            r13.zzbl(r3)
            goto L_0x05cf
        L_0x05cd:
            r9 = r43
        L_0x05cf:
            r2 = 0
            r4 = 0
            r23 = 1065353216(0x3f800000, float:1.0)
            r29 = -1
            r30 = 0
            r31 = 0
        L_0x05d9:
            int r5 = r3 - r12
            if (r5 >= r14) goto L_0x0716
            r13.zzbl(r3)
            int r5 = r13.getPosition()
            int r8 = r13.readInt()
            if (r8 != 0) goto L_0x05f2
            int r34 = r13.getPosition()
            int r10 = r34 - r12
            if (r10 == r14) goto L_0x0716
        L_0x05f2:
            if (r8 <= 0) goto L_0x05f6
            r10 = 1
            goto L_0x05f7
        L_0x05f6:
            r10 = 0
        L_0x05f7:
            java.lang.String r11 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpc.checkArgument(r10, r11)
            int r10 = r13.readInt()
            int r11 = com.google.android.gms.internal.ads.zzks.zzatx
            if (r10 != r11) goto L_0x0624
            if (r2 != 0) goto L_0x0608
            r2 = 1
            goto L_0x0609
        L_0x0608:
            r2 = 0
        L_0x0609:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            java.lang.String r2 = "video/avc"
            int r5 = r5 + 8
            r13.zzbl(r5)
            com.google.android.gms.internal.ads.zzpv r5 = com.google.android.gms.internal.ads.zzpv.zzg(r13)
            java.util.List<byte[]> r10 = r5.zzahc
            int r11 = r5.zzasp
            r15.zzasp = r11
            if (r4 != 0) goto L_0x0641
            float r5 = r5.zzbkb
            r23 = r5
            goto L_0x0641
        L_0x0624:
            int r11 = com.google.android.gms.internal.ads.zzks.zzaty
            if (r10 != r11) goto L_0x064a
            if (r2 != 0) goto L_0x062c
            r2 = 1
            goto L_0x062d
        L_0x062c:
            r2 = 0
        L_0x062d:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            java.lang.String r2 = "video/hevc"
            int r5 = r5 + 8
            r13.zzbl(r5)
            com.google.android.gms.internal.ads.zzqb r5 = com.google.android.gms.internal.ads.zzqb.zzi(r13)
            java.util.List<byte[]> r10 = r5.zzahc
            int r5 = r5.zzasp
            r15.zzasp = r5
        L_0x0641:
            r34 = r0
            r36 = r1
            r30 = r10
        L_0x0647:
            r11 = 3
            goto L_0x070b
        L_0x064a:
            int r11 = com.google.android.gms.internal.ads.zzks.zzawc
            if (r10 != r11) goto L_0x0660
            if (r2 != 0) goto L_0x0652
            r2 = 1
            goto L_0x0653
        L_0x0652:
            r2 = 0
        L_0x0653:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            int r2 = com.google.android.gms.internal.ads.zzks.zzawa
            if (r1 != r2) goto L_0x065d
            java.lang.String r2 = "video/x-vnd.on2.vp8"
            goto L_0x066e
        L_0x065d:
            java.lang.String r2 = "video/x-vnd.on2.vp9"
            goto L_0x066e
        L_0x0660:
            int r11 = com.google.android.gms.internal.ads.zzks.zzasw
            if (r10 != r11) goto L_0x0673
            if (r2 != 0) goto L_0x0668
            r2 = 1
            goto L_0x0669
        L_0x0668:
            r2 = 0
        L_0x0669:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            java.lang.String r2 = "video/3gpp"
        L_0x066e:
            r34 = r0
            r36 = r1
            goto L_0x0647
        L_0x0673:
            int r11 = com.google.android.gms.internal.ads.zzks.zzatz
            if (r10 != r11) goto L_0x0695
            if (r2 != 0) goto L_0x067b
            r2 = 1
            goto L_0x067c
        L_0x067b:
            r2 = 0
        L_0x067c:
            com.google.android.gms.internal.ads.zzpc.checkState(r2)
            android.util.Pair r2 = zzb(r13, r5)
            java.lang.Object r5 = r2.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r2 = r2.second
            byte[] r2 = (byte[]) r2
            java.util.List r30 = java.util.Collections.singletonList(r2)
            r34 = r0
            r36 = r1
            r2 = r5
            goto L_0x0647
        L_0x0695:
            int r11 = com.google.android.gms.internal.ads.zzks.zzauy
            if (r10 != r11) goto L_0x06b0
            int r5 = r5 + 8
            r13.zzbl(r5)
            int r4 = r13.zzjf()
            int r5 = r13.zzjf()
            float r4 = (float) r4
            float r5 = (float) r5
            float r23 = r4 / r5
            r34 = r0
            r36 = r1
            r4 = 1
            goto L_0x0647
        L_0x06b0:
            int r11 = com.google.android.gms.internal.ads.zzks.zzavy
            if (r10 != r11) goto L_0x06e6
            int r10 = r5 + 8
        L_0x06b6:
            int r11 = r10 - r5
            if (r11 >= r8) goto L_0x06de
            r13.zzbl(r10)
            int r11 = r13.readInt()
            r34 = r0
            int r0 = r13.readInt()
            r36 = r1
            int r1 = com.google.android.gms.internal.ads.zzks.zzavz
            if (r0 != r1) goto L_0x06d8
            byte[] r0 = r13.data
            int r11 = r11 + r10
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r10, r11)
            r31 = r0
            goto L_0x0647
        L_0x06d8:
            int r10 = r10 + r11
            r0 = r34
            r1 = r36
            goto L_0x06b6
        L_0x06de:
            r34 = r0
            r36 = r1
            r31 = 0
            goto L_0x0647
        L_0x06e6:
            r34 = r0
            r36 = r1
            int r0 = com.google.android.gms.internal.ads.zzks.zzavx
            if (r10 != r0) goto L_0x0647
            int r0 = r13.readUnsignedByte()
            r11 = 3
            r13.zzbm(r11)
            if (r0 != 0) goto L_0x070b
            int r0 = r13.readUnsignedByte()
            switch(r0) {
                case 0: goto L_0x0709;
                case 1: goto L_0x0706;
                case 2: goto L_0x0703;
                case 3: goto L_0x0700;
                default: goto L_0x06ff;
            }
        L_0x06ff:
            goto L_0x070b
        L_0x0700:
            r29 = 3
            goto L_0x070b
        L_0x0703:
            r29 = 2
            goto L_0x070b
        L_0x0706:
            r29 = 1
            goto L_0x070b
        L_0x0709:
            r29 = 0
        L_0x070b:
            int r3 = r3 + r8
            r0 = r34
            r1 = r36
            r10 = 16
            r11 = 8
            goto L_0x05d9
        L_0x0716:
            r34 = r0
            r11 = 3
            if (r2 == 0) goto L_0x074a
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r3 = 0
            r4 = -1
            r5 = -1
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 0
            r25 = r9
            r9 = r30
            r30 = 16
            r10 = r28
            r35 = 3
            r11 = r23
            r23 = r12
            r12 = r31
            r45 = r48
            r46 = r13
            r31 = 3
            r13 = r29
            r29 = r14
            r14 = r0
            r0 = r15
            r15 = r51
            com.google.android.gms.internal.ads.zzhp r1 = com.google.android.gms.internal.ads.zzhp.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzahv = r1
            goto L_0x0757
        L_0x074a:
            r45 = r48
            r25 = r9
            r23 = r12
            r46 = r13
            r29 = r14
            r0 = r15
            goto L_0x0375
        L_0x0757:
            int r5 = r23 + r29
            r1 = r46
            r1.zzbl(r5)
            int r6 = r25 + 1
            r15 = r51
            r8 = r0
            r12 = r1
            r14 = r18
            r10 = r19
            r9 = r24
            r11 = r34
            r13 = r45
            r0 = r47
            r7 = 8
            goto L_0x01b4
        L_0x0774:
            r0 = r8
            r19 = r10
            r45 = r13
            r18 = r14
            r17 = 0
            int r1 = com.google.android.gms.internal.ads.zzks.zzauf
            r2 = r47
            com.google.android.gms.internal.ads.zzkv r1 = r2.zzat(r1)
            if (r1 == 0) goto L_0x07e2
            int r2 = com.google.android.gms.internal.ads.zzks.zzaug
            com.google.android.gms.internal.ads.zzku r1 = r1.zzas(r2)
            if (r1 != 0) goto L_0x0790
            goto L_0x07e2
        L_0x0790:
            com.google.android.gms.internal.ads.zzpn r1 = r1.zzawg
            r2 = 8
            r1.zzbl(r2)
            int r2 = r1.readInt()
            int r2 = com.google.android.gms.internal.ads.zzks.zzao(r2)
            int r3 = r1.zzjf()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r6 = 0
        L_0x07a8:
            if (r6 >= r3) goto L_0x07db
            r7 = 1
            if (r2 != r7) goto L_0x07b2
            long r8 = r1.zzjg()
            goto L_0x07b6
        L_0x07b2:
            long r8 = r1.zzjc()
        L_0x07b6:
            r4[r6] = r8
            if (r2 != r7) goto L_0x07bf
            long r8 = r1.readLong()
            goto L_0x07c4
        L_0x07bf:
            int r8 = r1.readInt()
            long r8 = (long) r8
        L_0x07c4:
            r5[r6] = r8
            short r8 = r1.readShort()
            if (r8 != r7) goto L_0x07d3
            r8 = 2
            r1.zzbm(r8)
            int r6 = r6 + 1
            goto L_0x07a8
        L_0x07d3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x07db:
            android.util.Pair r1 = android.util.Pair.create(r4, r5)
            r2 = r1
            r1 = 0
            goto L_0x07e7
        L_0x07e2:
            r1 = 0
            android.util.Pair r2 = android.util.Pair.create(r1, r1)
        L_0x07e7:
            com.google.android.gms.internal.ads.zzhp r3 = r0.zzahv
            if (r3 != 0) goto L_0x07ec
            return r1
        L_0x07ec:
            com.google.android.gms.internal.ads.zzlo r1 = new com.google.android.gms.internal.ads.zzlo
            int r16 = r18.f6907id
            r3 = r45
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            com.google.android.gms.internal.ads.zzhp r5 = r0.zzahv
            int r6 = r0.zzawz
            com.google.android.gms.internal.ads.zzlr[] r7 = r0.zzawy
            int r0 = r0.zzasp
            java.lang.Object r8 = r2.first
            r28 = r8
            long[] r28 = (long[]) r28
            java.lang.Object r2 = r2.second
            r29 = r2
            long[] r29 = (long[]) r29
            r15 = r1
            r17 = r19
            r18 = r3
            r20 = r32
            r22 = r26
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkx.zza(com.google.android.gms.internal.ads.zzkv, com.google.android.gms.internal.ads.zzku, long, com.google.android.gms.internal.ads.zzjo, boolean):com.google.android.gms.internal.ads.zzlo");
    }

    public static zzlt zza(zzlo zzlo, zzkv zzkv, zzka zzka) {
        zzkz zzkz;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j;
        boolean z2;
        int[] iArr3;
        int i5;
        long[] jArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int i6;
        int i7;
        zzlo zzlo2 = zzlo;
        zzkv zzkv2 = zzkv;
        zzka zzka2 = zzka;
        zzku zzas = zzkv2.zzas(zzks.zzavg);
        if (zzas != null) {
            zzkz = new zzlb(zzas);
        } else {
            zzku zzas2 = zzkv2.zzas(zzks.zzavh);
            if (zzas2 != null) {
                zzkz = new zzla(zzas2);
            } else {
                throw new zzhw("Track has no sample table size information");
            }
        }
        int zzgy = zzkz.zzgy();
        if (zzgy == 0) {
            return new zzlt(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzku zzas3 = zzkv2.zzas(zzks.zzavi);
        if (zzas3 == null) {
            zzas3 = zzkv2.zzas(zzks.zzavj);
            z = true;
        } else {
            z = false;
        }
        zzpn zzpn = zzas3.zzawg;
        zzpn zzpn2 = zzkv2.zzas(zzks.zzavf).zzawg;
        zzpn zzpn3 = zzkv2.zzas(zzks.zzavc).zzawg;
        zzku zzas4 = zzkv2.zzas(zzks.zzavd);
        zzpn zzpn4 = zzas4 != null ? zzas4.zzawg : null;
        zzku zzas5 = zzkv2.zzas(zzks.zzave);
        zzpn zzpn5 = zzas5 != null ? zzas5.zzawg : null;
        zzkw zzkw = new zzkw(zzpn2, zzpn, z);
        zzpn3.zzbl(12);
        int zzjf = zzpn3.zzjf() - 1;
        int zzjf2 = zzpn3.zzjf();
        int zzjf3 = zzpn3.zzjf();
        if (zzpn5 != null) {
            zzpn5.zzbl(12);
            i = zzpn5.zzjf();
        } else {
            i = 0;
        }
        int i8 = -1;
        if (zzpn4 != null) {
            zzpn4.zzbl(12);
            i2 = zzpn4.zzjf();
            if (i2 > 0) {
                i8 = zzpn4.zzjf() - 1;
            } else {
                zzpn4 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(zzkz.zzha() && "audio/raw".equals(zzlo2.zzahv.zzaha) && zzjf == 0 && i == 0 && i2 == 0)) {
            jArr2 = new long[zzgy];
            iArr = new int[zzgy];
            jArr = new long[zzgy];
            int i9 = i2;
            iArr2 = new int[zzgy];
            int i10 = i9;
            zzpn zzpn6 = zzpn3;
            int i11 = zzjf3;
            int i12 = i;
            int i13 = i8;
            long j3 = 0;
            long j4 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = zzjf2;
            int i19 = zzjf;
            int i20 = 0;
            while (i20 < zzgy) {
                long j5 = j3;
                int i21 = i14;
                while (i21 == 0) {
                    zzpc.checkState(zzkw.zzgx());
                    j5 = zzkw.zzawl;
                    i21 = zzkw.zzawk;
                    i19 = i19;
                    i11 = i11;
                }
                int i22 = i19;
                int i23 = i11;
                if (zzpn5 != null) {
                    while (i17 == 0 && i12 > 0) {
                        i17 = zzpn5.zzjf();
                        i16 = zzpn5.readInt();
                        i12--;
                    }
                    i17--;
                }
                int i24 = i16;
                jArr2[i20] = j5;
                iArr[i20] = zzkz.zzgz();
                if (iArr[i20] > i15) {
                    i6 = zzgy;
                    i15 = iArr[i20];
                } else {
                    i6 = zzgy;
                }
                zzkz zzkz2 = zzkz;
                jArr[i20] = j4 + ((long) i24);
                iArr2[i20] = zzpn4 == null ? 1 : 0;
                if (i20 == i13) {
                    iArr2[i20] = 1;
                    i10--;
                    if (i10 > 0) {
                        i13 = zzpn4.zzjf() - 1;
                    }
                }
                int i25 = i10;
                int i26 = i13;
                int i27 = i23;
                j4 += (long) i27;
                i18--;
                if (i18 != 0 || i22 <= 0) {
                    i7 = i22;
                } else {
                    i7 = i22 - 1;
                    i18 = zzpn6.zzjf();
                    i27 = zzpn6.zzjf();
                }
                int i28 = i7;
                i20++;
                i13 = i26;
                zzgy = i6;
                i14 = i21 - 1;
                i16 = i24;
                i19 = i28;
                j3 = j5 + ((long) iArr[i20]);
                zzkz zzkz3 = zzkz2;
                i11 = i27;
                i10 = i25;
                zzkz = zzkz3;
            }
            i4 = zzgy;
            int i29 = i19;
            zzpc.checkArgument(i17 == 0);
            while (i12 > 0) {
                zzpc.checkArgument(zzpn5.zzjf() == 0);
                zzpn5.readInt();
                i12--;
            }
            if (i10 == 0 && i18 == 0 && i14 == 0 && i29 == 0) {
                zzlo2 = zzlo;
            } else {
                int i30 = i10;
                zzlo2 = zzlo;
                int i31 = zzlo2.f6908id;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i31);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i30);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i18);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i14);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i29);
                Log.w("AtomParsers", sb.toString());
            }
            j = j4;
            i3 = i15;
        } else {
            i4 = zzgy;
            zzkz zzkz4 = zzkz;
            long[] jArr4 = new long[zzkw.length];
            int[] iArr7 = new int[zzkw.length];
            while (zzkw.zzgx()) {
                jArr4[zzkw.index] = zzkw.zzawl;
                iArr7[zzkw.index] = zzkw.zzawk;
            }
            int zzgz = zzkz4.zzgz();
            long j6 = (long) zzjf3;
            int i32 = PKIFailureInfo.certRevoked / zzgz;
            int i33 = 0;
            for (int zzf : iArr7) {
                i33 += zzpt.zzf(zzf, i32);
            }
            long[] jArr5 = new long[i33];
            int[] iArr8 = new int[i33];
            long[] jArr6 = new long[i33];
            int[] iArr9 = new int[i33];
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i34 < iArr7.length) {
                int i38 = iArr7[i34];
                long j7 = jArr4[i34];
                int i39 = i35;
                int i40 = i37;
                while (i38 > 0) {
                    int min = Math.min(i32, i38);
                    jArr5[i36] = j7;
                    iArr8[i36] = zzgz * min;
                    i40 = Math.max(i40, iArr8[i36]);
                    jArr6[i36] = ((long) i39) * j6;
                    iArr9[i36] = 1;
                    j7 += (long) iArr8[i36];
                    i39 += min;
                    i38 -= min;
                    i36++;
                    jArr4 = jArr4;
                    iArr7 = iArr7;
                }
                long[] jArr7 = jArr4;
                int[] iArr10 = iArr7;
                i34++;
                i37 = i40;
                i35 = i39;
            }
            zzle zzle = new zzle(jArr5, iArr8, i37, jArr6, iArr9);
            jArr2 = zzle.zzaom;
            iArr = zzle.zzaol;
            int i41 = zzle.zzaxg;
            jArr = zzle.zzaxh;
            iArr2 = zzle.zzaxi;
            i3 = i41;
            j = 0;
        }
        if (zzlo2.zzbae == null || zzka.zzgs()) {
            zzpt.zza(jArr, 1000000, zzlo2.zzdd);
            return new zzlt(jArr2, iArr, i3, jArr, iArr2);
        }
        if (zzlo2.zzbae.length == 1 && zzlo2.type == 1 && jArr.length >= 2) {
            long j8 = zzlo2.zzbaf[0];
            long zza = zzpt.zza(zzlo2.zzbae[0], zzlo2.zzdd, zzlo2.zzbab) + j8;
            if (jArr[0] <= j8 && j8 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j9 = j - zza;
                long zza2 = zzpt.zza(j8 - jArr[0], (long) zzlo2.zzahv.zzahl, zzlo2.zzdd);
                long zza3 = zzpt.zza(j9, (long) zzlo2.zzahv.zzahl, zzlo2.zzdd);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    int i42 = (int) zza2;
                    zzka zzka3 = zzka;
                    zzka3.zzahn = i42;
                    zzka3.zzaho = (int) zza3;
                    zzpt.zza(jArr, 1000000, zzlo2.zzdd);
                    return new zzlt(jArr2, iArr, i3, jArr, iArr2);
                }
            }
        }
        if (zzlo2.zzbae.length == 1) {
            char c = 0;
            if (zzlo2.zzbae[0] == 0) {
                int i43 = 0;
                while (i43 < jArr.length) {
                    jArr[i43] = zzpt.zza(jArr[i43] - zzlo2.zzbaf[c], 1000000, zzlo2.zzdd);
                    i43++;
                    c = 0;
                }
                return new zzlt(jArr2, iArr, i3, jArr, iArr2);
            }
        }
        boolean z3 = zzlo2.type == 1;
        int i44 = 0;
        boolean z4 = false;
        int i45 = 0;
        int i46 = 0;
        while (i44 < zzlo2.zzbae.length) {
            long j10 = zzlo2.zzbaf[i44];
            if (j10 != -1) {
                iArr6 = iArr;
                long zza4 = zzpt.zza(zzlo2.zzbae[i44], zzlo2.zzdd, zzlo2.zzbab);
                int zzb = zzpt.zzb(jArr, j10, true, true);
                int zzb2 = zzpt.zzb(jArr, j10 + zza4, z3, false);
                i45 += zzb2 - zzb;
                z4 |= i46 != zzb;
                i46 = zzb2;
            } else {
                iArr6 = iArr;
            }
            i44++;
            iArr = iArr6;
        }
        int[] iArr11 = iArr;
        boolean z5 = (i45 != i4) | z4;
        long[] jArr8 = z5 ? new long[i45] : jArr2;
        int[] iArr12 = z5 ? new int[i45] : iArr11;
        if (z5) {
            i3 = 0;
        }
        int[] iArr13 = z5 ? new int[i45] : iArr2;
        long[] jArr9 = new long[i45];
        int i47 = i3;
        int i48 = 0;
        int i49 = 0;
        while (i48 < zzlo2.zzbae.length) {
            long j11 = zzlo2.zzbaf[i48];
            long j12 = zzlo2.zzbae[i48];
            if (j11 != -1) {
                long j13 = zzlo2.zzdd;
                int[] iArr14 = iArr13;
                i5 = i48;
                int zzb3 = zzpt.zzb(jArr, j11, true, true);
                int zzb4 = zzpt.zzb(jArr, zzpt.zza(j12, j13, zzlo2.zzbab) + j11, z3, false);
                if (z5) {
                    int i50 = zzb4 - zzb3;
                    System.arraycopy(jArr2, zzb3, jArr8, i49, i50);
                    iArr4 = iArr11;
                    System.arraycopy(iArr4, zzb3, iArr12, i49, i50);
                    z2 = z3;
                    iArr5 = iArr14;
                    System.arraycopy(iArr2, zzb3, iArr5, i49, i50);
                } else {
                    iArr4 = iArr11;
                    z2 = z3;
                    iArr5 = iArr14;
                }
                int i51 = i47;
                while (zzb3 < zzb4) {
                    long[] jArr10 = jArr2;
                    int[] iArr15 = iArr2;
                    long j14 = j11;
                    jArr9[i49] = zzpt.zza(j2, 1000000, zzlo2.zzbab) + zzpt.zza(jArr[zzb3] - j11, 1000000, zzlo2.zzdd);
                    if (z5 && iArr12[i49] > i51) {
                        i51 = iArr4[zzb3];
                    }
                    i49++;
                    zzb3++;
                    jArr2 = jArr10;
                    j11 = j14;
                    iArr2 = iArr15;
                }
                jArr3 = jArr2;
                iArr3 = iArr2;
                i47 = i51;
            } else {
                iArr4 = iArr11;
                z2 = z3;
                jArr3 = jArr2;
                iArr3 = iArr2;
                iArr5 = iArr13;
                i5 = i48;
            }
            j2 += j12;
            i48 = i5 + 1;
            iArr13 = iArr5;
            jArr2 = jArr3;
            iArr2 = iArr3;
            z3 = z2;
            iArr11 = iArr4;
        }
        int[] iArr16 = iArr13;
        boolean z6 = false;
        for (int i52 = 0; i52 < iArr16.length && !z6; i52++) {
            z6 |= (iArr16[i52] & 1) != 0;
        }
        if (z6) {
            return new zzlt(jArr8, iArr12, i47, jArr9, iArr16);
        }
        throw new zzhw("The edited sample sequence does not contain a sync sample.");
    }

    public static zzmd zza(zzku zzku, boolean z) {
        if (z) {
            return null;
        }
        zzpn zzpn = zzku.zzawg;
        zzpn.zzbl(8);
        while (zzpn.zzja() >= 8) {
            int position = zzpn.getPosition();
            int readInt = zzpn.readInt();
            if (zzpn.readInt() == zzks.zzavr) {
                zzpn.zzbl(position);
                int i = position + readInt;
                zzpn.zzbm(12);
                while (true) {
                    if (zzpn.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpn.getPosition();
                    int readInt2 = zzpn.readInt();
                    if (zzpn.readInt() == zzks.zzavs) {
                        zzpn.zzbl(position2);
                        int i2 = position2 + readInt2;
                        zzpn.zzbm(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpn.getPosition() < i2) {
                            zzmd.zza zzd = zzll.zzd(zzpn);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmd((List<? extends zzmd.zza>) arrayList);
                        }
                    } else {
                        zzpn.zzbm(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpn.zzbm(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzpn zzpn, int i) {
        zzpn.zzbl(i + 8 + 4);
        zzpn.zzbm(1);
        zzc(zzpn);
        zzpn.zzbm(2);
        int readUnsignedByte = zzpn.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpn.zzbm(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpn.zzbm(zzpn.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpn.zzbm(2);
        }
        zzpn.zzbm(1);
        zzc(zzpn);
        String str = null;
        switch (zzpn.readUnsignedByte()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", (Object) null);
            case CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384 /*165*/:
                str = "audio/ac3";
                break;
            case CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256 /*166*/:
                str = "audio/eac3";
                break;
            case CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384 /*169*/:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256 /*172*/:
                return Pair.create("audio/vnd.dts", (Object) null);
            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256 /*170*/:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384 /*171*/:
                return Pair.create("audio/vnd.dts.hd", (Object) null);
        }
        zzpn.zzbm(12);
        zzpn.zzbm(1);
        int zzc = zzc(zzpn);
        byte[] bArr = new byte[zzc];
        zzpn.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zzc(zzpn zzpn) {
        int readUnsignedByte = zzpn.readUnsignedByte();
        int i = readUnsignedByte & CertificateBody.profileType;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpn.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & CertificateBody.profileType);
        }
        return i;
    }
}
