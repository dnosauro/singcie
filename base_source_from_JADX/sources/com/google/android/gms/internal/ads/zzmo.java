package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

final class zzmo implements zzjy, zzmy, zznk, zzoz<zzmv> {
    /* access modifiers changed from: private */
    public final Handler handler;
    private final Uri uri;
    private final Handler zzaer;
    private boolean zzaft;
    /* access modifiers changed from: private */
    public boolean zzagh;
    private long zzaif;
    private final zzon zzaoq;
    private final int zzbdh;
    /* access modifiers changed from: private */
    public final zzmz zzbdi;
    private final zznd zzbdj;
    private final zzol zzbdk;
    /* access modifiers changed from: private */
    public final String zzbdl = null;
    /* access modifiers changed from: private */
    public final long zzbdm;
    private final zzow zzbdn;
    private final zzmu zzbdo;
    private final zzpe zzbdp;
    private final Runnable zzbdq;
    /* access modifiers changed from: private */
    public final Runnable zzbdr;
    /* access modifiers changed from: private */
    public final SparseArray<zzni> zzbds;
    /* access modifiers changed from: private */
    public zznb zzbdt;
    private zzkf zzbdu;
    private boolean zzbdv;
    private boolean zzbdw;
    private boolean zzbdx;
    private int zzbdy;
    private zznq zzbdz;
    private boolean[] zzbea;
    private boolean[] zzbeb;
    private boolean zzbec;
    private long zzbed;
    private long zzbee;
    private int zzbef;
    private boolean zzbeg;
    private long zzcm;

    public zzmo(Uri uri2, zzon zzon, zzjw[] zzjwArr, int i, Handler handler2, zzmz zzmz, zznd zznd, zzol zzol, String str, int i2) {
        this.uri = uri2;
        this.zzaoq = zzon;
        this.zzbdh = i;
        this.zzaer = handler2;
        this.zzbdi = zzmz;
        this.zzbdj = zznd;
        this.zzbdk = zzol;
        this.zzbdm = (long) i2;
        this.zzbdn = new zzow("Loader:ExtractorMediaPeriod");
        this.zzbdo = new zzmu(zzjwArr, this);
        this.zzbdp = new zzpe();
        this.zzbdq = new zzmr(this);
        this.zzbdr = new zzmq(this);
        this.handler = new Handler();
        this.zzbee = -9223372036854775807L;
        this.zzbds = new SparseArray<>();
        this.zzcm = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        r0 = r9.zzbdu;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void startLoading() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzmv r6 = new com.google.android.gms.internal.ads.zzmv
            android.net.Uri r2 = r9.uri
            com.google.android.gms.internal.ads.zzon r3 = r9.zzaoq
            com.google.android.gms.internal.ads.zzmu r4 = r9.zzbdo
            com.google.android.gms.internal.ads.zzpe r5 = r9.zzbdp
            r0 = r6
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            boolean r0 = r9.zzaft
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0040
            boolean r0 = r9.zzhw()
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            long r3 = r9.zzaif
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            long r7 = r9.zzbee
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0031
            r0 = 1
            r9.zzbeg = r0
            r9.zzbee = r1
            return
        L_0x0031:
            com.google.android.gms.internal.ads.zzkf r0 = r9.zzbdu
            long r3 = r9.zzbee
            long r3 = r0.zzdz(r3)
            long r7 = r9.zzbee
            r6.zze(r3, r7)
            r9.zzbee = r1
        L_0x0040:
            int r0 = r9.zzhu()
            r9.zzbef = r0
            int r0 = r9.zzbdh
            r3 = -1
            if (r0 != r3) goto L_0x0067
            boolean r0 = r9.zzaft
            if (r0 == 0) goto L_0x0066
            long r3 = r9.zzcm
            r7 = -1
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzkf r0 = r9.zzbdu
            if (r0 == 0) goto L_0x0064
            long r3 = r0.getDurationUs()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r0 = 6
            goto L_0x0067
        L_0x0066:
            r0 = 3
        L_0x0067:
            com.google.android.gms.internal.ads.zzow r1 = r9.zzbdn
            r1.zza(r6, r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmo.startLoading():void");
    }

    private final void zza(zzmv zzmv) {
        if (this.zzcm == -1) {
            this.zzcm = zzmv.zzcm;
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public final void zzht() {
        /*
            r8 = this;
            boolean r0 = r8.zzagh
            if (r0 != 0) goto L_0x009d
            boolean r0 = r8.zzaft
            if (r0 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzkf r0 = r8.zzbdu
            if (r0 == 0) goto L_0x009d
            boolean r0 = r8.zzbdv
            if (r0 != 0) goto L_0x0012
            goto L_0x009d
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzni> r0 = r8.zzbds
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.internal.ads.zzni> r3 = r8.zzbds
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzni r3 = (com.google.android.gms.internal.ads.zzni) r3
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzif()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.gms.internal.ads.zzpe r2 = r8.zzbdp
            r2.zziu()
            com.google.android.gms.internal.ads.zznr[] r2 = new com.google.android.gms.internal.ads.zznr[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzbeb = r3
            boolean[] r3 = new boolean[r0]
            r8.zzbea = r3
            com.google.android.gms.internal.ads.zzkf r3 = r8.zzbdu
            long r3 = r3.getDurationUs()
            r8.zzaif = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.gms.internal.ads.zzni> r5 = r8.zzbds
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzni r5 = (com.google.android.gms.internal.ads.zzni) r5
            com.google.android.gms.internal.ads.zzhp r5 = r5.zzif()
            com.google.android.gms.internal.ads.zznr r6 = new com.google.android.gms.internal.ads.zznr
            com.google.android.gms.internal.ads.zzhp[] r7 = new com.google.android.gms.internal.ads.zzhp[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzaha
            boolean r6 = com.google.android.gms.internal.ads.zzpj.zzbd(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.gms.internal.ads.zzpj.zzbc(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.zzbeb
            r5[r3] = r4
            boolean r5 = r8.zzbec
            r4 = r4 | r5
            r8.zzbec = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.gms.internal.ads.zznq r0 = new com.google.android.gms.internal.ads.zznq
            r0.<init>(r2)
            r8.zzbdz = r0
            r8.zzaft = r4
            com.google.android.gms.internal.ads.zznd r0 = r8.zzbdj
            com.google.android.gms.internal.ads.zzno r1 = new com.google.android.gms.internal.ads.zzno
            long r2 = r8.zzaif
            com.google.android.gms.internal.ads.zzkf r4 = r8.zzbdu
            boolean r4 = r4.isSeekable()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zznb r0 = r8.zzbdt
            r0.zza(r8)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmo.zzht():void");
    }

    private final int zzhu() {
        int size = this.zzbds.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbds.valueAt(i2).zzid();
        }
        return i;
    }

    private final long zzhv() {
        int size = this.zzbds.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbds.valueAt(i).zzhv());
        }
        return j;
    }

    private final boolean zzhw() {
        return this.zzbee != -9223372036854775807L;
    }

    public final void release() {
        this.zzbdn.zza((Runnable) new zzmt(this, this.zzbdo));
        this.handler.removeCallbacksAndMessages((Object) null);
        this.zzagh = true;
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, zzhr zzhr, zzjl zzjl, boolean z) {
        if (this.zzbdx || zzhw()) {
            return -3;
        }
        return this.zzbds.valueAt(i).zza(zzhr, zzjl, z, this.zzbeg, this.zzbed);
    }

    public final /* synthetic */ int zza(zzpb zzpb, long j, long j2, IOException iOException) {
        zzkf zzkf;
        zzmv zzmv = (zzmv) zzpb;
        zza(zzmv);
        Handler handler2 = this.zzaer;
        if (!(handler2 == null || this.zzbdi == null)) {
            handler2.post(new zzms(this, iOException));
        }
        if (iOException instanceof zznt) {
            return 3;
        }
        boolean z = zzhu() > this.zzbef;
        if (this.zzcm == -1 && ((zzkf = this.zzbdu) == null || zzkf.getDurationUs() == -9223372036854775807L)) {
            this.zzbed = 0;
            this.zzbdx = this.zzaft;
            int size = this.zzbds.size();
            for (int i = 0; i < size; i++) {
                this.zzbds.valueAt(i).zzk(!this.zzaft || this.zzbea[i]);
            }
            zzmv.zze(0, 0);
        }
        this.zzbef = zzhu();
        return z ? 1 : 0;
    }

    public final long zza(zzoc[] zzocArr, boolean[] zArr, zznn[] zznnArr, boolean[] zArr2, long j) {
        zzpc.checkState(this.zzaft);
        for (int i = 0; i < zzocArr.length; i++) {
            if (zznnArr[i] != null && (zzocArr[i] == null || !zArr[i])) {
                int zza = zznnArr[i].track;
                zzpc.checkState(this.zzbea[zza]);
                this.zzbdy--;
                this.zzbea[zza] = false;
                this.zzbds.valueAt(zza).disable();
                zznnArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzocArr.length; i2++) {
            if (zznnArr[i2] == null && zzocArr[i2] != null) {
                zzoc zzoc = zzocArr[i2];
                zzpc.checkState(zzoc.length() == 1);
                zzpc.checkState(zzoc.zzbd(0) == 0);
                int zza2 = this.zzbdz.zza(zzoc.zzil());
                zzpc.checkState(!this.zzbea[zza2]);
                this.zzbdy++;
                this.zzbea[zza2] = true;
                zznnArr[i2] = new zzmx(this, zza2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzbdw) {
            int size = this.zzbds.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzbea[i3]) {
                    this.zzbds.valueAt(i3).disable();
                }
            }
        }
        if (this.zzbdy == 0) {
            this.zzbdx = false;
            if (this.zzbdn.isLoading()) {
                this.zzbdn.zzis();
            }
        } else if (!this.zzbdw ? j != 0 : z) {
            j = zzeg(j);
            for (int i4 = 0; i4 < zznnArr.length; i4++) {
                if (zznnArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzbdw = true;
        return j;
    }

    public final void zza(zzkf zzkf) {
        this.zzbdu = zzkf;
        this.handler.post(this.zzbdq);
    }

    public final void zza(zznb zznb, long j) {
        this.zzbdt = zznb;
        this.zzbdp.open();
        startLoading();
    }

    public final /* synthetic */ void zza(zzpb zzpb, long j, long j2) {
        zza((zzmv) zzpb);
        this.zzbeg = true;
        if (this.zzaif == -9223372036854775807L) {
            long zzhv = zzhv();
            this.zzaif = zzhv == Long.MIN_VALUE ? 0 : zzhv + 10000;
            this.zzbdj.zzb(new zzno(this.zzaif, this.zzbdu.isSeekable()), (Object) null);
        }
        this.zzbdt.zza(this);
    }

    public final /* synthetic */ void zza(zzpb zzpb, long j, long j2, boolean z) {
        zza((zzmv) zzpb);
        if (!z && this.zzbdy > 0) {
            int size = this.zzbds.size();
            for (int i = 0; i < size; i++) {
                this.zzbds.valueAt(i).zzk(this.zzbea[i]);
            }
            this.zzbdt.zza(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaz(int i) {
        if (!this.zzbeg) {
            return !zzhw() && this.zzbds.valueAt(i).zzie();
        }
        return true;
    }

    public final zzkh zzc(int i, int i2) {
        zzni zzni = this.zzbds.get(i);
        if (zzni != null) {
            return zzni;
        }
        zzni zzni2 = new zzni(this.zzbdk);
        zzni2.zza(this);
        this.zzbds.put(i, zzni2);
        return zzni2;
    }

    /* access modifiers changed from: package-private */
    public final void zze(int i, long j) {
        zzni valueAt = this.zzbds.valueAt(i);
        if (!this.zzbeg || j <= valueAt.zzhv()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzih();
        }
    }

    public final void zzee(long j) {
    }

    public final boolean zzef(long j) {
        if (this.zzbeg) {
            return false;
        }
        if (this.zzaft && this.zzbdy == 0) {
            return false;
        }
        boolean open = this.zzbdp.open();
        if (this.zzbdn.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public final long zzeg(long j) {
        if (!this.zzbdu.isSeekable()) {
            j = 0;
        }
        this.zzbed = j;
        int size = this.zzbds.size();
        boolean z = !zzhw();
        int i = 0;
        while (z && i < size) {
            if (this.zzbea[i]) {
                z = this.zzbds.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzbee = j;
            this.zzbeg = false;
            if (this.zzbdn.isLoading()) {
                this.zzbdn.zzis();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbds.valueAt(i2).zzk(this.zzbea[i2]);
                }
            }
        }
        this.zzbdx = false;
        return j;
    }

    public final void zzf(zzhp zzhp) {
        this.handler.post(this.zzbdq);
    }

    public final void zzgr() {
        this.zzbdv = true;
        this.handler.post(this.zzbdq);
    }

    public final void zzhn() {
        this.zzbdn.zzbg(Integer.MIN_VALUE);
    }

    public final zznq zzho() {
        return this.zzbdz;
    }

    public final long zzhp() {
        if (this.zzbdy == 0) {
            return Long.MIN_VALUE;
        }
        return zzhr();
    }

    public final long zzhq() {
        if (!this.zzbdx) {
            return -9223372036854775807L;
        }
        this.zzbdx = false;
        return this.zzbed;
    }

    public final long zzhr() {
        long j;
        if (this.zzbeg) {
            return Long.MIN_VALUE;
        }
        if (zzhw()) {
            return this.zzbee;
        }
        if (this.zzbec) {
            j = Long.MAX_VALUE;
            int size = this.zzbds.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbeb[i]) {
                    j = Math.min(j, this.zzbds.valueAt(i).zzhv());
                }
            }
        } else {
            j = zzhv();
        }
        return j == Long.MIN_VALUE ? this.zzbed : j;
    }

    /* access modifiers changed from: package-private */
    public final void zzhs() {
        this.zzbdn.zzbg(Integer.MIN_VALUE);
    }
}
