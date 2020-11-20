package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzat;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.TimeUnit;

public final class zzbbh {
    private final Context context;
    private final zzazh zzdsm;
    private final String zzdtb;
    private final zzabs zzeil;
    private boolean zzeip;
    private final zzabq zzelc;
    private final zzat zzeld = new zzay().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzyv();
    private final long[] zzele;
    private final String[] zzelf;
    private boolean zzelg = false;
    private boolean zzelh = false;
    private boolean zzeli = false;
    private boolean zzelj = false;
    private zzbap zzelk;
    private boolean zzell;
    private boolean zzelm;
    private long zzeln = -1;

    public zzbbh(Context context2, zzazh zzazh, String str, zzabs zzabs, zzabq zzabq) {
        this.context = context2;
        this.zzdsm = zzazh;
        this.zzdtb = str;
        this.zzeil = zzabs;
        this.zzelc = zzabq;
        String str2 = (String) zzwq.zzqe().zzd(zzabf.zzcml);
        if (str2 == null) {
            this.zzelf = new String[0];
            this.zzele = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzelf = new String[split.length];
        this.zzele = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzele[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzd.zzd("Unable to parse frame hash target time number.", e);
                this.zzele[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (zzadn.zzddx.get().booleanValue() && !this.zzell) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzdtb);
            bundle.putString("player", this.zzelk.zzzk());
            for (zzav next : this.zzeld.zzyu()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(next.count));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(next.name);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(next.zzeel));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzele;
                if (i < jArr.length) {
                    String str = this.zzelf[i];
                    if (str != null) {
                        String valueOf5 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf5);
                        bundle.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzp.zzkq().zza(this.context, this.zzdsm.zzbrf, "gmob-apps", bundle, true);
                    this.zzell = true;
                    return;
                }
            }
        }
    }

    public final void zzaat() {
        this.zzeip = true;
        if (this.zzelh && !this.zzeli) {
            zzabn.zza(this.zzeil, this.zzelc, "vfp2");
            this.zzeli = true;
        }
    }

    public final void zzaau() {
        this.zzeip = false;
    }

    public final void zzb(zzbap zzbap) {
        zzabn.zza(this.zzeil, this.zzelc, "vpc2");
        this.zzelg = true;
        zzabs zzabs = this.zzeil;
        if (zzabs != null) {
            zzabs.zzh("vpn", zzbap.zzzk());
        }
        this.zzelk = zzbap;
    }

    public final void zzc(zzbap zzbap) {
        if (this.zzeli && !this.zzelj) {
            if (zzd.zzxn() && !this.zzelj) {
                zzd.zzee("VideoMetricsMixin first frame");
            }
            zzabn.zza(this.zzeil, this.zzelc, "vff2");
            this.zzelj = true;
        }
        long nanoTime = zzp.zzkx().nanoTime();
        if (this.zzeip && this.zzelm && this.zzeln != -1) {
            this.zzeld.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzeln)));
        }
        this.zzelm = this.zzeip;
        this.zzeln = nanoTime;
        long longValue = ((Long) zzwq.zzqe().zzd(zzabf.zzcmm)).longValue();
        long currentPosition = (long) zzbap.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzelf;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.zzele[i])) {
                zzbap zzbap2 = zzbap;
                i++;
            } else {
                String[] strArr2 = this.zzelf;
                int i2 = 8;
                Bitmap bitmap = zzbap.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    long j4 = j2;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j4 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j2 = j4;
                    i2 = 8;
                    j = j3;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzfb() {
        if (this.zzelg && !this.zzelh) {
            zzabn.zza(this.zzeil, this.zzelc, "vfr2");
            this.zzelh = true;
        }
    }
}
