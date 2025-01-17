package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zav implements zabt {
    private final /* synthetic */ zas zaeq;

    private zav(zas zas) {
        this.zaeq = zas;
    }

    /* synthetic */ zav(zas zas, zat zat) {
        this(zas);
    }

    public final void zab(int i, boolean z) {
        this.zaeq.zaeo.lock();
        try {
            if (this.zaeq.zaen) {
                boolean unused = this.zaeq.zaen = false;
                this.zaeq.zaa(i, z);
            } else {
                boolean unused2 = this.zaeq.zaen = true;
                this.zaeq.zaef.onConnectionSuspended(i);
            }
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    public final void zab(Bundle bundle) {
        this.zaeq.zaeo.lock();
        try {
            ConnectionResult unused = this.zaeq.zaem = ConnectionResult.RESULT_SUCCESS;
            this.zaeq.zax();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    public final void zac(ConnectionResult connectionResult) {
        this.zaeq.zaeo.lock();
        try {
            ConnectionResult unused = this.zaeq.zaem = connectionResult;
            this.zaeq.zax();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }
}
