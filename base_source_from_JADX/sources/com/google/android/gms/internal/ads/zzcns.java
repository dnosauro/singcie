package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

public final class zzcns extends zzcnu {
    public zzcns(Context context) {
        this.zzgni = new zzast(context, zzp.zzle().zzyw(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        zzazq zzazq;
        zzcoh zzcoh;
        synchronized (this.mLock) {
            if (!this.zzgng) {
                this.zzgng = true;
                try {
                    this.zzgni.zzvq().zza(this.zzgnh, (zzatf) new zzcnt(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzazq = this.zzdkm;
                    zzcoh = new zzcoh(zzdok.INTERNAL_ERROR);
                } catch (Throwable th) {
                    zzp.zzku().zza(th, "RemoteAdRequestClientTask.onConnected");
                    zzazq = this.zzdkm;
                    zzcoh = new zzcoh(zzdok.INTERNAL_ERROR);
                }
            }
        }
        zzazq.setException(zzcoh);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzd.zzeb("Cannot connect to remote service, fallback to local instance.");
        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    public final zzdyz<InputStream> zzi(zzatl zzatl) {
        synchronized (this.mLock) {
            if (this.zzgnf) {
                zzazq zzazq = this.zzdkm;
                return zzazq;
            }
            this.zzgnf = true;
            this.zzgnh = zzatl;
            this.zzgni.checkAvailabilityAndConnect();
            this.zzdkm.addListener(new zzcnr(this), zzazj.zzegu);
            zzazq zzazq2 = this.zzdkm;
            return zzazq2;
        }
    }
}
