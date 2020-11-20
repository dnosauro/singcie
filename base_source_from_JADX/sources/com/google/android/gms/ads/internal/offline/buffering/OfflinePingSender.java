package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzani;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzwq;

@KeepForSdk
public class OfflinePingSender extends Worker {
    private final zzaqw zzdpp;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zzdpp = zzwq.zzqb().zzb(context, (zzani) new zzanj());
    }

    public ListenableWorker.C1178a doWork() {
        try {
            this.zzdpp.zzuz();
            return ListenableWorker.C1178a.m4667a();
        } catch (RemoteException unused) {
            return ListenableWorker.C1178a.m4670c();
        }
    }
}
