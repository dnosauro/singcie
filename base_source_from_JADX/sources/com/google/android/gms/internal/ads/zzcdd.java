package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcdd implements View.OnClickListener {
    private final Clock zzbpw;
    private final zzcgh zzgep;
    private zzage zzgeq;
    private zzahv<Object> zzger;
    String zzges;
    Long zzget;
    WeakReference<View> zzgeu;

    public zzcdd(zzcgh zzcgh, Clock clock) {
        this.zzgep = zzcgh;
        this.zzbpw = clock;
    }

    private final void zzaom() {
        View view;
        this.zzges = null;
        this.zzget = null;
        WeakReference<View> weakReference = this.zzgeu;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzgeu = null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzgeq != null && this.zzget != null) {
            zzaom();
            try {
                this.zzgeq.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzgeu;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zzges == null || this.zzget == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzges);
                hashMap.put("time_interval", String.valueOf(this.zzbpw.currentTimeMillis() - this.zzget.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzgep.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            zzaom();
        }
    }

    public final void zza(zzage zzage) {
        this.zzgeq = zzage;
        zzahv<Object> zzahv = this.zzger;
        if (zzahv != null) {
            this.zzgep.zzb("/unconfirmedClick", zzahv);
        }
        this.zzger = new zzcdg(this, zzage);
        this.zzgep.zza("/unconfirmedClick", this.zzger);
    }

    public final zzage zzaol() {
        return this.zzgeq;
    }
}
