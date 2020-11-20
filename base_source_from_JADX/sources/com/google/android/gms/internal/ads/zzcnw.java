package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;

public final class zzcnw extends zzcnu {
    public zzcnw(Context context) {
        this.zzgni = new zzast(context, zzp.zzle().zzyw(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        zzazq zzazq;
        zzcoh zzcoh;
        synchronized (this.mLock) {
            if (!this.zzgng) {
                this.zzgng = true;
                try {
                    this.zzgni.zzvq().zzb(this.zzgnh, new zzcnt(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzazq = this.zzdkm;
                    zzcoh = new zzcoh(zzdok.INTERNAL_ERROR);
                } catch (Throwable th) {
                    zzp.zzku().zza(th, "RemoteSignalsClientTask.onConnected");
                    zzazq = this.zzdkm;
                    zzcoh = new zzcoh(zzdok.INTERNAL_ERROR);
                }
            }
        }
        zzazq.setException(zzcoh);
    }

    public final zzdyz<InputStream> zzj(zzatl zzatl) {
        synchronized (this.mLock) {
            if (this.zzgnf) {
                zzazq zzazq = this.zzdkm;
                return zzazq;
            }
            this.zzgnf = true;
            this.zzgnh = zzatl;
            this.zzgni.checkAvailabilityAndConnect();
            this.zzdkm.addListener(new zzcnv(this), zzazj.zzegu);
            zzazq zzazq2 = this.zzdkm;
            return zzazq2;
        }
    }
}
