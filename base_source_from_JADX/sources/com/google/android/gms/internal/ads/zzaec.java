package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

public final class zzaec extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdef = new ArrayList();
    private final zzaeb zzdeq;

    public zzaec(zzaeb zzaeb) {
        zzaej zzaej;
        IBinder iBinder;
        this.zzdeq = zzaeb;
        try {
            this.text = this.zzdeq.getText();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            this.text = "";
        }
        try {
            for (zzaej next : zzaeb.zzsm()) {
                if (!(next instanceof IBinder) || (iBinder = (IBinder) next) == null) {
                    zzaej = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaej = queryLocalInterface instanceof zzaej ? (zzaej) queryLocalInterface : new zzael(iBinder);
                }
                if (zzaej != null) {
                    this.zzdef.add(new zzaek(zzaej));
                }
            }
        } catch (RemoteException e2) {
            zzaza.zzc("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzdef;
    }

    public final CharSequence getText() {
        return this.text;
    }
}
