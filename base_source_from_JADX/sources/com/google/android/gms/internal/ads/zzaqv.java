package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

public final class zzaqv extends zzaqu implements zzahv<zzbdv> {
    private final Context context;
    private float density;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int rotation;
    private final WindowManager zzbqu;
    private final zzbdv zzdii;
    private final zzaam zzdpk;
    private int zzdpl = -1;
    private int zzdpm = -1;
    private int zzdpn = -1;
    private int zzdpo = -1;
    private DisplayMetrics zzxl;

    public zzaqv(zzbdv zzbdv, Context context2, zzaam zzaam) {
        super(zzbdv);
        this.zzdii = zzbdv;
        this.context = context2;
        this.zzdpk = zzaam;
        this.zzbqu = (WindowManager) context2.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        zzbdv zzbdv = (zzbdv) obj;
        this.zzxl = new DisplayMetrics();
        Display defaultDisplay = this.zzbqu.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzxl);
        this.density = this.zzxl.density;
        this.rotation = defaultDisplay.getRotation();
        zzwq.zzqa();
        DisplayMetrics displayMetrics = this.zzxl;
        this.zzdpl = zzayr.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwq.zzqa();
        DisplayMetrics displayMetrics2 = this.zzxl;
        this.zzdpm = zzayr.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzaaj = this.zzdii.zzaaj();
        if (zzaaj == null || zzaaj.getWindow() == null) {
            this.maxWidth = this.zzdpl;
            i = this.zzdpm;
        } else {
            zzp.zzkq();
            int[] zzf = zzm.zzf(zzaaj);
            zzwq.zzqa();
            this.maxWidth = zzayr.zzb(this.zzxl, zzf[0]);
            zzwq.zzqa();
            i = zzayr.zzb(this.zzxl, zzf[1]);
        }
        this.maxHeight = i;
        if (this.zzdii.zzacq().zzady()) {
            this.zzdpn = this.zzdpl;
            this.zzdpo = this.zzdpm;
        } else {
            this.zzdii.measure(0, 0);
        }
        zza(this.zzdpl, this.zzdpm, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzdii.zzb("onDeviceFeaturesReceived", new zzaqq(new zzaqs().zzae(this.zzdpk.zzrg()).zzad(this.zzdpk.zzrh()).zzaf(this.zzdpk.zzrj()).zzag(this.zzdpk.zzri()).zzah(true)).zzdr());
        int[] iArr = new int[2];
        this.zzdii.getLocationOnScreen(iArr);
        zzj(zzwq.zzqa().zzb(this.context, iArr[0]), zzwq.zzqa().zzb(this.context, iArr[1]));
        if (zzd.isLoggable(2)) {
            zzd.zzez("Dispatching Ready Event.");
        }
        zzdu(this.zzdii.zzaao().zzbrf);
    }

    public final void zzj(int i, int i2) {
        int i3 = 0;
        if (this.context instanceof Activity) {
            zzp.zzkq();
            i3 = zzm.zzh((Activity) this.context)[0];
        }
        if (this.zzdii.zzacq() == null || !this.zzdii.zzacq().zzady()) {
            int width = this.zzdii.getWidth();
            int height = this.zzdii.getHeight();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnc)).booleanValue()) {
                if (width == 0 && this.zzdii.zzacq() != null) {
                    width = this.zzdii.zzacq().widthPixels;
                }
                if (height == 0 && this.zzdii.zzacq() != null) {
                    height = this.zzdii.zzacq().heightPixels;
                }
            }
            this.zzdpn = zzwq.zzqa().zzb(this.context, width);
            this.zzdpo = zzwq.zzqa().zzb(this.context, height);
        }
        zzb(i, i2 - i3, this.zzdpn, this.zzdpo);
        this.zzdii.zzacs().zzi(i, i2);
    }
}
