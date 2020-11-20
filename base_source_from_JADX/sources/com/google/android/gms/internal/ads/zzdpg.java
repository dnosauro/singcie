package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.p172io.IOUtils;

final class zzdpg implements zzdpd {
    @GuardedBy("this")
    private final ConcurrentHashMap<zzdpq, zzdpe> zzhkt;
    private zzdpk zzhku;
    private zzdpi zzhkv = new zzdpi();

    public zzdpg(zzdpk zzdpk) {
        this.zzhkt = new ConcurrentHashMap<>(zzdpk.zzhlo);
        this.zzhku = zzdpk;
    }

    private final void dumpToLog() {
        if (zzdpk.zzavr()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhku.zzhlm);
            sb.append(" PoolCollection");
            sb.append(this.zzhkv.zzavq());
            int i = 0;
            for (Map.Entry next : this.zzhkt.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(next.getValue());
                sb.append("#");
                sb.append(((zzdpq) next.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzdpe) next.getValue()).size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = ((zzdpe) next.getValue()).size(); size < this.zzhku.zzhlo; size++) {
                    sb.append("[ ]");
                }
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                sb.append(((zzdpe) next.getValue()).zzavg());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            while (i < this.zzhku.zzhln) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzd.zzeb(sb.toString());
        }
    }

    private final void zza(zzdpn<?> zzdpn, zzdqg zzdqg) {
        if (zzdpn != null) {
            zzdpn.zzhmb.zzakk().zzc((zzue.zzb) ((zzekh) zzue.zzb.zznk().zza(zzue.zzb.zza.zznm().zza(zzue.zzb.C3721zzb.IN_MEMORY).zza(zzue.zzb.zzd.zzno().zzq(zzdqg.zzhnd).zzby(zzdqg.zzhmy))).zzbhv()));
        }
        dumpToLog();
    }

    public final synchronized zzdpn<?> zza(zzdpq zzdpq) {
        zzdpn<?> zzdpn;
        zzdpe zzdpe = this.zzhkt.get(zzdpq);
        zzdpn = null;
        if (zzdpe != null) {
            zzdpn = zzdpe.zzavd();
            if (zzdpn == null) {
                this.zzhkv.zzavl();
            }
            zza(zzdpn, zzdpe.zzavh());
        } else {
            this.zzhkv.zzavk();
            zza((zzdpn<?>) null, (zzdqg) null);
        }
        return zzdpn;
    }

    @Deprecated
    public final zzdpq zza(zzvk zzvk, String str, zzvw zzvw) {
        return new zzdpp(zzvk, str, new zzatt(this.zzhku.context).zzvz().zzdwr, this.zzhku.zzhlq, zzvw);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        r1.remove(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.internal.ads.zzdpq r10, com.google.android.gms.internal.ads.zzdpn<?> r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r0 = r9.zzhkt     // Catch:{ all -> 0x015f }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r0 = (com.google.android.gms.internal.ads.zzdpe) r0     // Catch:{ all -> 0x015f }
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ all -> 0x015f }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x015f }
            r11.zzhmd = r1     // Catch:{ all -> 0x015f }
            if (r0 != 0) goto L_0x0108
            com.google.android.gms.internal.ads.zzdpe r0 = new com.google.android.gms.internal.ads.zzdpe     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpk r1 = r9.zzhku     // Catch:{ all -> 0x015f }
            int r1 = r1.zzhlo     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpk r2 = r9.zzhku     // Catch:{ all -> 0x015f }
            int r2 = r2.zzhlp     // Catch:{ all -> 0x015f }
            int r2 = r2 * 1000
            r0.<init>(r1, r2)     // Catch:{ all -> 0x015f }
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
            int r1 = r1.size()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpk r2 = r9.zzhku     // Catch:{ all -> 0x015f }
            int r2 = r2.zzhln     // Catch:{ all -> 0x015f }
            if (r1 != r2) goto L_0x00fe
            int[] r1 = com.google.android.gms.internal.ads.zzdpf.zzhks     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpk r2 = r9.zzhku     // Catch:{ all -> 0x015f }
            int r2 = r2.zzhls     // Catch:{ all -> 0x015f }
            int r2 = r2 + -1
            r1 = r1[r2]     // Catch:{ all -> 0x015f }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00bf;
                case 2: goto L_0x0085;
                case 3: goto L_0x0045;
                default: goto L_0x0043;
            }     // Catch:{ all -> 0x015f }
        L_0x0043:
            goto L_0x00f9
        L_0x0045:
            r1 = 2147483647(0x7fffffff, float:NaN)
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r2 = r9.zzhkt     // Catch:{ all -> 0x015f }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x015f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x015f }
        L_0x0052:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x015f }
            if (r3 == 0) goto L_0x007c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x015f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x015f }
            java.lang.Object r5 = r3.getValue()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r5 = (com.google.android.gms.internal.ads.zzdpe) r5     // Catch:{ all -> 0x015f }
            int r5 = r5.zzavf()     // Catch:{ all -> 0x015f }
            if (r5 >= r1) goto L_0x0052
            java.lang.Object r1 = r3.getValue()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r1 = (com.google.android.gms.internal.ads.zzdpe) r1     // Catch:{ all -> 0x015f }
            int r1 = r1.zzavf()     // Catch:{ all -> 0x015f }
            java.lang.Object r3 = r3.getKey()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpq r3 = (com.google.android.gms.internal.ads.zzdpq) r3     // Catch:{ all -> 0x015f }
            r4 = r3
            goto L_0x0052
        L_0x007c:
            if (r4 == 0) goto L_0x00f9
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
        L_0x0080:
            r1.remove(r4)     // Catch:{ all -> 0x015f }
            goto L_0x00f9
        L_0x0085:
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x015f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x015f }
        L_0x008f:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x015f }
            if (r5 == 0) goto L_0x00ba
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x015f }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x015f }
            java.lang.Object r6 = r5.getValue()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r6 = (com.google.android.gms.internal.ads.zzdpe) r6     // Catch:{ all -> 0x015f }
            long r6 = r6.zzave()     // Catch:{ all -> 0x015f }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x008f
            java.lang.Object r2 = r5.getValue()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r2 = (com.google.android.gms.internal.ads.zzdpe) r2     // Catch:{ all -> 0x015f }
            long r2 = r2.zzave()     // Catch:{ all -> 0x015f }
            java.lang.Object r4 = r5.getKey()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpq r4 = (com.google.android.gms.internal.ads.zzdpq) r4     // Catch:{ all -> 0x015f }
            goto L_0x008f
        L_0x00ba:
            if (r4 == 0) goto L_0x00f9
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
            goto L_0x0080
        L_0x00bf:
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x015f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x015f }
        L_0x00c9:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x015f }
            if (r5 == 0) goto L_0x00f4
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x015f }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x015f }
            java.lang.Object r6 = r5.getValue()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r6 = (com.google.android.gms.internal.ads.zzdpe) r6     // Catch:{ all -> 0x015f }
            long r6 = r6.getCreationTimeMillis()     // Catch:{ all -> 0x015f }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x00c9
            java.lang.Object r2 = r5.getValue()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpe r2 = (com.google.android.gms.internal.ads.zzdpe) r2     // Catch:{ all -> 0x015f }
            long r2 = r2.getCreationTimeMillis()     // Catch:{ all -> 0x015f }
            java.lang.Object r4 = r5.getKey()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpq r4 = (com.google.android.gms.internal.ads.zzdpq) r4     // Catch:{ all -> 0x015f }
            goto L_0x00c9
        L_0x00f4:
            if (r4 == 0) goto L_0x00f9
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
            goto L_0x0080
        L_0x00f9:
            com.google.android.gms.internal.ads.zzdpi r1 = r9.zzhkv     // Catch:{ all -> 0x015f }
            r1.zzavn()     // Catch:{ all -> 0x015f }
        L_0x00fe:
            java.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpe> r1 = r9.zzhkt     // Catch:{ all -> 0x015f }
            r1.put(r10, r0)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpi r10 = r9.zzhkv     // Catch:{ all -> 0x015f }
            r10.zzavm()     // Catch:{ all -> 0x015f }
        L_0x0108:
            boolean r10 = r0.zzb(r11)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpi r1 = r9.zzhkv     // Catch:{ all -> 0x015f }
            r1.zzavo()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdpi r1 = r9.zzhkv     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdph r1 = r1.zzavp()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzdqg r0 = r0.zzavh()     // Catch:{ all -> 0x015f }
            if (r11 == 0) goto L_0x015a
            com.google.android.gms.internal.ads.zzue$zzb$zzc r2 = com.google.android.gms.internal.ads.zzue.zzb.zznk()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zza$zza r3 = com.google.android.gms.internal.ads.zzue.zzb.zza.zznm()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zzb r4 = com.google.android.gms.internal.ads.zzue.zzb.C3721zzb.IN_MEMORY     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zza$zza r3 = r3.zza((com.google.android.gms.internal.ads.zzue.zzb.C3721zzb) r4)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zze$zza r4 = com.google.android.gms.internal.ads.zzue.zzb.zze.zznq()     // Catch:{ all -> 0x015f }
            boolean r5 = r1.zzhkw     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zze$zza r4 = r4.zzs(r5)     // Catch:{ all -> 0x015f }
            boolean r1 = r1.zzhkx     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zze$zza r1 = r4.zzt(r1)     // Catch:{ all -> 0x015f }
            int r0 = r0.zzhmy     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zze$zza r0 = r1.zzca(r0)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zza$zza r0 = r3.zza((com.google.android.gms.internal.ads.zzue.zzb.zze.zza) r0)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb$zzc r0 = r2.zza(r0)     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzels r0 = r0.zzbhv()     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzekh r0 = (com.google.android.gms.internal.ads.zzekh) r0     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzue$zzb r0 = (com.google.android.gms.internal.ads.zzue.zzb) r0     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzboz<AdT> r11 = r11.zzhmb     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzbwd r11 = r11.zzakk()     // Catch:{ all -> 0x015f }
            r11.zzd(r0)     // Catch:{ all -> 0x015f }
        L_0x015a:
            r9.dumpToLog()     // Catch:{ all -> 0x015f }
            monitor-exit(r9)
            return r10
        L_0x015f:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpg.zza(com.google.android.gms.internal.ads.zzdpq, com.google.android.gms.internal.ads.zzdpn):boolean");
    }

    public final zzdpk zzavc() {
        return this.zzhku;
    }

    public final synchronized boolean zzb(zzdpq zzdpq) {
        zzdpe zzdpe = this.zzhkt.get(zzdpq);
        if (zzdpe != null) {
            return zzdpe.size() < this.zzhku.zzhlo;
        }
        return true;
    }
}
