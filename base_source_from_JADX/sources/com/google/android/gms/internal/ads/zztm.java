package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.io.IOException;

final /* synthetic */ class zztm implements Runnable {
    private final zztn zzbvj;
    private final zztc zzbvk;
    private final zztf zzbvl;
    private final zzazq zzbvm;

    zztm(zztn zztn, zztc zztc, zztf zztf, zzazq zzazq) {
        this.zzbvj = zztn;
        this.zzbvk = zztc;
        this.zzbvl = zztf;
        this.zzbvm = zzazq;
    }

    public final void run() {
        zztn zztn = this.zzbvj;
        zztc zztc = this.zzbvk;
        zztf zztf = this.zzbvl;
        zzazq zzazq = this.zzbvm;
        try {
            zztg zznc = zztc.zznc();
            zzta zzc = zztc.zznd() ? zznc.zzc(zztf) : zznc.zza(zztf);
            if (!zzc.zzmv()) {
                zzazq.setException(new RuntimeException("No entry contents."));
                zztn.zzbvh.disconnect();
                return;
            }
            zzto zzto = new zzto(zztn, zzc.zzmw(), 1);
            int read = zzto.read();
            if (read != -1) {
                zzto.unread(read);
                zzazq.set(zztt.zza(zzto, zzc.zzmy(), zzc.zznb(), zzc.zzna(), zzc.zzmz()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzd.zzc("Unable to obtain a cache service instance.", e);
            zzazq.setException(e);
            zztn.zzbvh.disconnect();
        }
    }
}
