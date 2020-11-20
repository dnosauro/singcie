package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

public abstract class zzcnu implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final Object mLock = new Object();
    protected final zzazq<InputStream> zzdkm = new zzazq<>();
    protected boolean zzgnf = false;
    protected boolean zzgng = false;
    protected zzatl zzgnh;
    protected zzast zzgni;

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzd.zzeb("Disconnected from remote ad request service.");
        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    public void onConnectionSuspended(int i) {
        zzd.zzeb("Cannot connect to remote service, fallback to local instance.");
    }

    /* access modifiers changed from: protected */
    public final void zzara() {
        synchronized (this.mLock) {
            this.zzgng = true;
            if (this.zzgni.isConnected() || this.zzgni.isConnecting()) {
                this.zzgni.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
