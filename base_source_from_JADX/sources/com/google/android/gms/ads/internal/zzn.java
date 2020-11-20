package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzef;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzn extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzj zzbpl;

    private zzn(zzj zzj) {
        this.zzbpl = zzj;
    }

    /* synthetic */ zzn(zzj zzj, zzm zzm) {
        this(zzj);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzef unused = this.zzbpl.zzbpj = (zzef) this.zzbpl.zzbpf.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaza.zzd("", e);
        }
        return this.zzbpl.zzkk();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zzbpl.zzbph != null && str != null) {
            this.zzbpl.zzbph.loadUrl(str);
        }
    }
}
