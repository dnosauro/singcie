package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

public final class zzcnx extends zzcnu {
    private String zzgnk;
    private int zzgnl = zzcoc.zzgnn;

    public zzcnx(Context context) {
        this.zzgni = new zzast(context, zzp.zzle().zzyw(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        zzazq zzazq;
        zzcoh zzcoh;
        synchronized (this.mLock) {
            if (!this.zzgng) {
                this.zzgng = true;
                try {
                    if (this.zzgnl == zzcoc.zzgno) {
                        this.zzgni.zzvq().zzc(this.zzgnh, new zzcnt(this));
                    } else if (this.zzgnl == zzcoc.zzgnp) {
                        this.zzgni.zzvq().zza(this.zzgnk, (zzatf) new zzcnt(this));
                    } else {
                        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzazq = this.zzdkm;
                    zzcoh = new zzcoh(zzdok.INTERNAL_ERROR);
                    zzazq.setException(zzcoh);
                } catch (Throwable th) {
                    zzp.zzku().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    zzazq = this.zzdkm;
                    zzcoh = new zzcoh(zzdok.INTERNAL_ERROR);
                    zzazq.setException(zzcoh);
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzd.zzeb("Cannot connect to remote service, fallback to local instance.");
        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    public final zzdyz<InputStream> zzgi(String str) {
        synchronized (this.mLock) {
            if (this.zzgnl != zzcoc.zzgnn && this.zzgnl != zzcoc.zzgnp) {
                zzdyz<InputStream> immediateFailedFuture = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INVALID_REQUEST));
                return immediateFailedFuture;
            } else if (this.zzgnf) {
                zzazq zzazq = this.zzdkm;
                return zzazq;
            } else {
                this.zzgnl = zzcoc.zzgnp;
                this.zzgnf = true;
                this.zzgnk = str;
                this.zzgni.checkAvailabilityAndConnect();
                this.zzdkm.addListener(new zzcnz(this), zzazj.zzegu);
                zzazq zzazq2 = this.zzdkm;
                return zzazq2;
            }
        }
    }

    public final zzdyz<InputStream> zzk(zzatl zzatl) {
        synchronized (this.mLock) {
            if (this.zzgnl != zzcoc.zzgnn && this.zzgnl != zzcoc.zzgno) {
                zzdyz<InputStream> immediateFailedFuture = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INVALID_REQUEST));
                return immediateFailedFuture;
            } else if (this.zzgnf) {
                zzazq zzazq = this.zzdkm;
                return zzazq;
            } else {
                this.zzgnl = zzcoc.zzgno;
                this.zzgnf = true;
                this.zzgnh = zzatl;
                this.zzgni.checkAvailabilityAndConnect();
                this.zzdkm.addListener(new zzcoa(this), zzazj.zzegu);
                zzazq zzazq2 = this.zzdkm;
                return zzazq2;
            }
        }
    }
}
