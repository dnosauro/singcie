package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
public final class zzbbl extends zzbap implements TextureView.SurfaceTextureListener, zzbck {
    private Surface zzblj;
    private final zzbbe zzehi;
    private final zzbbh zzehj;
    private final boolean zzehk;
    private int zzehp;
    private int zzehq;
    private int zzehs;
    private int zzeht;
    private zzbbc zzehu;
    private final boolean zzehv;
    private zzbam zzehx;
    private String[] zzeiw;
    private final zzbbf zzelt;
    private zzbca zzelu;
    private String zzelv;
    private boolean zzelw;
    private int zzelx = 1;
    private boolean zzely;
    private boolean zzelz;
    private float zzema;

    public zzbbl(Context context, zzbbh zzbbh, zzbbe zzbbe, boolean z, boolean z2, zzbbf zzbbf) {
        super(context);
        this.zzehk = z2;
        this.zzehi = zzbbe;
        this.zzehj = zzbbh;
        this.zzehv = z;
        this.zzelt = zzbbf;
        setSurfaceTextureListener(this);
        this.zzehj.zzb(this);
    }

    private final void zza(float f, boolean z) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzb(f, z);
        } else {
            zzd.zzfa("Trying to set volume before player is initalized.");
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zza(surface, z);
        } else {
            zzd.zzfa("Trying to set surface before player is initalized.");
        }
    }

    private final zzbca zzaaw() {
        return new zzbca(this.zzehi.getContext(), this.zzelt, this.zzehi);
    }

    private final String zzaax() {
        return zzp.zzkq().zzq(this.zzehi.getContext(), this.zzehi.zzaao().zzbrf);
    }

    private final boolean zzaay() {
        zzbca zzbca = this.zzelu;
        return (zzbca == null || zzbca.zzabp() == null || this.zzelw) ? false : true;
    }

    private final boolean zzaaz() {
        return zzaay() && this.zzelx != 1;
    }

    private final void zzaba() {
        String str;
        String str2;
        if (this.zzelu == null && (str = this.zzelv) != null && this.zzblj != null) {
            if (str.startsWith("cache:")) {
                zzbcx zzff = this.zzehi.zzff(this.zzelv);
                if (zzff instanceof zzbdi) {
                    this.zzelu = ((zzbdi) zzff).zzabu();
                    if (this.zzelu.zzabp() == null) {
                        str2 = "Precached video player has been released.";
                    }
                } else if (zzff instanceof zzbdj) {
                    zzbdj zzbdj = (zzbdj) zzff;
                    String zzaax = zzaax();
                    ByteBuffer byteBuffer = zzbdj.getByteBuffer();
                    boolean zzabv = zzbdj.zzabv();
                    String url = zzbdj.getUrl();
                    if (url == null) {
                        str2 = "Stream cache URL is null.";
                    } else {
                        this.zzelu = zzaaw();
                        this.zzelu.zza(new Uri[]{Uri.parse(url)}, zzaax, byteBuffer, zzabv);
                    }
                } else {
                    String valueOf = String.valueOf(this.zzelv);
                    zzd.zzfa(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
                zzd.zzfa(str2);
                return;
            }
            this.zzelu = zzaaw();
            String zzaax2 = zzaax();
            Uri[] uriArr = new Uri[this.zzeiw.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzeiw;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzelu.zza(uriArr, zzaax2);
            this.zzelu.zza((zzbck) this);
            zza(this.zzblj, false);
            if (this.zzelu.zzabp() != null) {
                this.zzelx = this.zzelu.zzabp().getPlaybackState();
                if (this.zzelx == 3) {
                    zzabb();
                }
            }
        }
    }

    private final void zzabb() {
        if (!this.zzely) {
            this.zzely = true;
            zzm.zzedd.post(new zzbbk(this));
            zzzq();
            this.zzehj.zzfb();
            if (this.zzelz) {
                play();
            }
        }
    }

    private final void zzabc() {
        zzo(this.zzehp, this.zzehq);
    }

    private final void zzabd() {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzav(true);
        }
    }

    private final void zzabe() {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzav(false);
        }
    }

    private final void zzo(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzema != f) {
            this.zzema = f;
            requestLayout();
        }
    }

    public final int getCurrentPosition() {
        if (zzaaz()) {
            return (int) this.zzelu.zzabp().zzem();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzaaz()) {
            return (int) this.zzelu.zzabp().getDuration();
        }
        return 0;
    }

    public final long getTotalBytes() {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            return zzbca.getTotalBytes();
        }
        return -1;
    }

    public final int getVideoHeight() {
        return this.zzehq;
    }

    public final int getVideoWidth() {
        return this.zzehp;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a A[LOOP:0: B:30:0x007a->B:35:0x0095, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.zzema
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbbc r2 = r10.zzehu
            if (r2 != 0) goto L_0x002a
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            float r0 = r10.zzema
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002a
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x002a:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbbc r0 = r10.zzehu
            if (r0 == 0) goto L_0x0034
            r0.zzm(r11, r12)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a2
            int r0 = r10.zzehs
            if (r0 <= 0) goto L_0x0040
            if (r0 != r11) goto L_0x0046
        L_0x0040:
            int r0 = r10.zzeht
            if (r0 <= 0) goto L_0x009e
            if (r0 == r12) goto L_0x009e
        L_0x0046:
            boolean r0 = r10.zzehk
            if (r0 == 0) goto L_0x009e
            boolean r0 = r10.zzaay()
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzbca r0 = r10.zzelu
            com.google.android.gms.internal.ads.zzhd r0 = r0.zzabp()
            long r2 = r0.zzem()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009e
            boolean r2 = r0.zzek()
            if (r2 == 0) goto L_0x0067
            goto L_0x009e
        L_0x0067:
            r2 = 1
            r10.zza((float) r1, (boolean) r2)
            r0.zzf(r2)
            long r1 = r0.zzem()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r3 = r3.currentTimeMillis()
        L_0x007a:
            boolean r5 = r10.zzaay()
            if (r5 == 0) goto L_0x0097
            long r5 = r0.zzem()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x007a
        L_0x0097:
            r1 = 0
            r0.zzf(r1)
            r10.zzzq()
        L_0x009e:
            r10.zzehs = r11
            r10.zzeht = r12
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbl.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzehv) {
            this.zzehu = new zzbbc(getContext());
            this.zzehu.zza(surfaceTexture, i, i2);
            this.zzehu.start();
            SurfaceTexture zzaae = this.zzehu.zzaae();
            if (zzaae != null) {
                surfaceTexture = zzaae;
            } else {
                this.zzehu.zzaad();
                this.zzehu = null;
            }
        }
        this.zzblj = new Surface(surfaceTexture);
        if (this.zzelu == null) {
            zzaba();
        } else {
            zza(this.zzblj, true);
            if (!this.zzelt.zzekr) {
                zzabd();
            }
        }
        if (this.zzehp == 0 || this.zzehq == 0) {
            zzo(i, i2);
        } else {
            zzabc();
        }
        zzm.zzedd.post(new zzbbr(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbbc zzbbc = this.zzehu;
        if (zzbbc != null) {
            zzbbc.zzaad();
            this.zzehu = null;
        }
        if (this.zzelu != null) {
            zzabe();
            Surface surface = this.zzblj;
            if (surface != null) {
                surface.release();
            }
            this.zzblj = null;
            zza((Surface) null, true);
        }
        zzm.zzedd.post(new zzbbt(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbbc zzbbc = this.zzehu;
        if (zzbbc != null) {
            zzbbc.zzm(i, i2);
        }
        zzm.zzedd.post(new zzbbq(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzehj.zzc(this);
        this.zzeih.zza(surfaceTexture, this.zzehx);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzd.zzee(sb.toString());
        zzm.zzedd.post(new zzbbs(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        if (zzaaz()) {
            if (this.zzelt.zzekr) {
                zzabe();
            }
            this.zzelu.zzabp().zzf(false);
            this.zzehj.zzaau();
            this.zzeii.zzaau();
            zzm.zzedd.post(new zzbbo(this));
        }
    }

    public final void play() {
        if (zzaaz()) {
            if (this.zzelt.zzekr) {
                zzabd();
            }
            this.zzelu.zzabp().zzf(true);
            this.zzehj.zzaat();
            this.zzeii.zzaat();
            this.zzeih.zzzs();
            zzm.zzedd.post(new zzbbp(this));
            return;
        }
        this.zzelz = true;
    }

    public final void seekTo(int i) {
        if (zzaaz()) {
            this.zzelu.zzabp().seekTo((long) i);
        }
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzelv = str;
            this.zzeiw = new String[]{str};
            zzaba();
        }
    }

    public final void stop() {
        if (zzaay()) {
            this.zzelu.zzabp().stop();
            if (this.zzelu != null) {
                zza((Surface) null, true);
                zzbca zzbca = this.zzelu;
                if (zzbca != null) {
                    zzbca.zza((zzbck) null);
                    this.zzelu.release();
                    this.zzelu = null;
                }
                this.zzelx = 1;
                this.zzelw = false;
                this.zzely = false;
                this.zzelz = false;
            }
        }
        this.zzehj.zzaau();
        this.zzeii.zzaau();
        this.zzehj.onStop();
    }

    public final void zza(float f, float f2) {
        zzbbc zzbbc = this.zzehu;
        if (zzbbc != null) {
            zzbbc.zzb(f, f2);
        }
    }

    public final void zza(zzbam zzbam) {
        this.zzehx = zzbam;
    }

    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzd.zzfa(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzelw = true;
        if (this.zzelt.zzekr) {
            zzabe();
        }
        zzm.zzedd.post(new zzbbm(this, sb2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzabf() {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzzu();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzabg() {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzzr();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzabh() {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzabi() {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzzs();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzabj() {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzzt();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzabk() {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzfb();
        }
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzelv = str;
            this.zzeiw = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzaba();
        }
    }

    public final void zzb(boolean z, long j) {
        if (this.zzehi != null) {
            zzazj.zzegt.execute(new zzbbv(this, z, j));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzehi.zza(z, j);
    }

    public final void zzdl(int i) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzabs().zzdt(i);
        }
    }

    public final void zzdm(int i) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzabs().zzdu(i);
        }
    }

    public final void zzdn(int i) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzabs().zzdn(i);
        }
    }

    public final void zzdo(int i) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzabs().zzdo(i);
        }
    }

    public final void zzdp(int i) {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            zzbca.zzdp(i);
        }
    }

    public final void zzdr(int i) {
        if (this.zzelx != i) {
            this.zzelx = i;
            switch (i) {
                case 3:
                    zzabb();
                    return;
                case 4:
                    if (this.zzelt.zzekr) {
                        zzabe();
                    }
                    this.zzehj.zzaau();
                    this.zzeii.zzaau();
                    zzm.zzedd.post(new zzbbn(this));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzds(int i) {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfg(String str) {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzm("ExoPlayerAdapter error", str);
        }
    }

    public final void zzn(int i, int i2) {
        this.zzehp = i;
        this.zzehq = i2;
        zzabc();
    }

    public final long zzna() {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            return zzbca.zzna();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.zzk(i, i2);
        }
    }

    public final String zzzk() {
        String valueOf = String.valueOf("ExoPlayer/3");
        String valueOf2 = String.valueOf(this.zzehv ? " spherical" : "");
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final long zzzo() {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            return zzbca.zzzo();
        }
        return -1;
    }

    public final int zzzp() {
        zzbca zzbca = this.zzelu;
        if (zzbca != null) {
            return zzbca.zzzp();
        }
        return -1;
    }

    public final void zzzq() {
        zza(this.zzeii.getVolume(), false);
    }
}
