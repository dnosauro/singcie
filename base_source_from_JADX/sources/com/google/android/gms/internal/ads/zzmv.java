package com.google.android.gms.internal.ads;

import android.net.Uri;

final class zzmv implements zzpb {
    private final Uri uri;
    private final zzon zzaoq;
    private final zzmu zzbdo;
    private final zzpe zzbdp;
    private final /* synthetic */ zzmo zzbei;
    private final zzkc zzben = new zzkc();
    private volatile boolean zzbeo;
    private boolean zzbep = true;
    private long zzbeq;
    /* access modifiers changed from: private */
    public long zzcm = -1;

    public zzmv(zzmo zzmo, Uri uri2, zzon zzon, zzmu zzmu, zzpe zzpe) {
        this.zzbei = zzmo;
        this.uri = (Uri) zzpc.checkNotNull(uri2);
        this.zzaoq = (zzon) zzpc.checkNotNull(zzon);
        this.zzbdo = (zzmu) zzpc.checkNotNull(zzmu);
        this.zzbdp = zzpe;
    }

    public final void cancelLoad() {
        this.zzbeo = true;
    }

    public final void zze(long j, long j2) {
        this.zzben.position = j;
        this.zzbeq = j2;
        this.zzbep = true;
    }

    public final boolean zzhx() {
        return this.zzbeo;
    }

    public final void zzhy() {
        zzjx zzjx;
        int i = 0;
        while (i == 0 && !this.zzbeo) {
            try {
                long j = this.zzben.position;
                this.zzcm = this.zzaoq.zza(new zzoo(this.uri, j, -1, this.zzbei.zzbdl));
                if (this.zzcm != -1) {
                    this.zzcm += j;
                }
                zzjx = new zzjx(this.zzaoq, j, this.zzcm);
                try {
                    zzjw zza = this.zzbdo.zza(zzjx, this.zzaoq.getUri());
                    if (this.zzbep) {
                        zza.zzc(j, this.zzbeq);
                        this.zzbep = false;
                    }
                    while (i == 0 && !this.zzbeo) {
                        this.zzbdp.block();
                        i = zza.zza(zzjx, this.zzben);
                        if (zzjx.getPosition() > this.zzbei.zzbdm + j) {
                            j = zzjx.getPosition();
                            this.zzbdp.zziu();
                            this.zzbei.handler.post(this.zzbei.zzbdr);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzben.position = zzjx.getPosition();
                    }
                    zzpt.zza(this.zzaoq);
                } catch (Throwable th) {
                    th = th;
                    if (!(i == 1 || zzjx == null)) {
                        this.zzben.position = zzjx.getPosition();
                    }
                    zzpt.zza(this.zzaoq);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zzjx = null;
                this.zzben.position = zzjx.getPosition();
                zzpt.zza(this.zzaoq);
                throw th;
            }
        }
    }
}
