package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbar extends FrameLayout implements zzbam {
    private final zzbbe zzehi;
    private final FrameLayout zzeik;
    private final zzabs zzeil;
    private final zzbbg zzeim;
    private final long zzein;
    private zzbap zzeio;
    private boolean zzeip;
    private boolean zzeiq;
    private boolean zzeir;
    private boolean zzeis;
    private long zzeit;
    private long zzeiu;
    private String zzeiv;
    private String[] zzeiw;
    private Bitmap zzeix;
    private ImageView zzeiy;
    private boolean zzeiz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbar(Context context, zzbbe zzbbe, int i, boolean z, zzabs zzabs, zzbbf zzbbf) {
        super(context);
        Context context2 = context;
        this.zzehi = zzbbe;
        this.zzeil = zzabs;
        this.zzeik = new FrameLayout(context);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcmw)).booleanValue()) {
            this.zzeik.setBackgroundResource(17170444);
        }
        addView(this.zzeik, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbbe.zzaak());
        this.zzeio = zzbbe.zzaak().zzboi.zza(context, zzbbe, i, z, zzabs, zzbbf);
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            this.zzeik.addView(zzbap, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcmn)).booleanValue()) {
                zzzy();
            }
        }
        this.zzeiy = new ImageView(context);
        this.zzein = ((Long) zzwq.zzqe().zzd(zzabf.zzcmr)).longValue();
        this.zzeis = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcmp)).booleanValue();
        zzabs zzabs2 = this.zzeil;
        if (zzabs2 != null) {
            zzabs2.zzh("spinner_used", this.zzeis ? "1" : "0");
        }
        this.zzeim = new zzbbg(this);
        zzbap zzbap2 = this.zzeio;
        if (zzbap2 != null) {
            zzbap2.zza(this);
        }
        if (this.zzeio == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzbbe zzbbe, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzbbe.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbbe zzbbe, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbbe.zza("onVideoEvent", hashMap);
    }

    private final boolean zzaaa() {
        return this.zzeiy.getParent() != null;
    }

    private final void zzaab() {
        if (this.zzehi.zzaaj() != null && this.zzeiq && !this.zzeir) {
            this.zzehi.zzaaj().getWindow().clearFlags(128);
            this.zzeiq = false;
        }
    }

    public static void zzb(zzbbe zzbbe) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbbe.zza("onVideoEvent", hashMap);
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzehi.zza("onVideoEvent", hashMap);
    }

    public final void destroy() {
        this.zzeim.pause();
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.stop();
        }
        zzaab();
    }

    public final void finalize() {
        try {
            this.zzeim.pause();
            if (this.zzeio != null) {
                zzbap zzbap = this.zzeio;
                zzdzc zzdzc = zzazj.zzegt;
                zzbap.getClass();
                zzdzc.execute(zzbaq.zza(zzbap));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onPaused() {
        zzd("pause", new String[0]);
        zzaab();
        this.zzeip = false;
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzeim.resume();
        } else {
            this.zzeim.pause();
            this.zzeiu = this.zzeit;
        }
        zzm.zzedd.post(new zzbat(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzeim.resume();
            z = true;
        } else {
            this.zzeim.pause();
            this.zzeiu = this.zzeit;
            z = false;
        }
        zzm.zzedd.post(new zzbau(this, z));
    }

    public final void pause() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.pause();
        }
    }

    public final void play() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.play();
        }
    }

    public final void seekTo(int i) {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.seekTo(i);
        }
    }

    public final void setVolume(float f) {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.zzeii.setVolume(f);
            zzbap.zzzq();
        }
    }

    public final void zza(float f, float f2) {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.zza(f, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzat(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzc(String str, String[] strArr) {
        this.zzeiv = str;
        this.zzeiw = strArr;
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzeik.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzdl(int i) {
        this.zzeio.zzdl(i);
    }

    public final void zzdm(int i) {
        this.zzeio.zzdm(i);
    }

    public final void zzdn(int i) {
        this.zzeio.zzdn(i);
    }

    public final void zzdo(int i) {
        this.zzeio.zzdo(i);
    }

    public final void zzdp(int i) {
        this.zzeio.zzdp(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzfb() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null && this.zzeiu == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) zzbap.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzeio.getVideoWidth()), "videoHeight", String.valueOf(this.zzeio.getVideoHeight()));
        }
    }

    public final void zzhy() {
        if (this.zzeio != null) {
            if (!TextUtils.isEmpty(this.zzeiv)) {
                this.zzeio.zzb(this.zzeiv, this.zzeiw);
            } else {
                zzd("no_src", new String[0]);
            }
        }
    }

    public final void zzk(int i, int i2) {
        if (this.zzeis) {
            int max = Math.max(i / ((Integer) zzwq.zzqe().zzd(zzabf.zzcmq)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzwq.zzqe().zzd(zzabf.zzcmq)).intValue(), 1);
            Bitmap bitmap = this.zzeix;
            if (bitmap == null || bitmap.getWidth() != max || this.zzeix.getHeight() != max2) {
                this.zzeix = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzeiz = false;
            }
        }
    }

    public final void zzm(String str, String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    public final void zzzr() {
        this.zzeim.resume();
        zzm.zzedd.post(new zzbas(this));
    }

    public final void zzzs() {
        if (this.zzehi.zzaaj() != null && !this.zzeiq) {
            this.zzeir = (this.zzehi.zzaaj().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzeir) {
                this.zzehi.zzaaj().getWindow().addFlags(128);
                this.zzeiq = true;
            }
        }
        this.zzeip = true;
    }

    public final void zzzt() {
        zzd("ended", new String[0]);
        zzaab();
    }

    public final void zzzu() {
        if (this.zzeiz && this.zzeix != null && !zzaaa()) {
            this.zzeiy.setImageBitmap(this.zzeix);
            this.zzeiy.invalidate();
            this.zzeik.addView(this.zzeiy, new FrameLayout.LayoutParams(-1, -1));
            this.zzeik.bringChildToFront(this.zzeiy);
        }
        this.zzeim.pause();
        this.zzeiu = this.zzeit;
        zzm.zzedd.post(new zzbav(this));
    }

    public final void zzzv() {
        if (this.zzeip && zzaaa()) {
            this.zzeik.removeView(this.zzeiy);
        }
        if (this.zzeix != null) {
            long elapsedRealtime = zzp.zzkx().elapsedRealtime();
            if (this.zzeio.getBitmap(this.zzeix) != null) {
                this.zzeiz = true;
            }
            long elapsedRealtime2 = zzp.zzkx().elapsedRealtime() - elapsedRealtime;
            if (zzd.zzxn()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzd.zzee(sb.toString());
            }
            if (elapsedRealtime2 > this.zzein) {
                zzd.zzfa("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzeis = false;
                this.zzeix = null;
                zzabs zzabs = this.zzeil;
                if (zzabs != null) {
                    zzabs.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzzw() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.zzeii.setMuted(true);
            zzbap.zzzq();
        }
    }

    public final void zzzx() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            zzbap.zzeii.setMuted(false);
            zzbap.zzzq();
        }
    }

    @TargetApi(14)
    public final void zzzy() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            TextView textView = new TextView(zzbap.getContext());
            String valueOf = String.valueOf(this.zzeio.zzzk());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.zzeik.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzeik.bringChildToFront(textView);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzzz() {
        zzbap zzbap = this.zzeio;
        if (zzbap != null) {
            long currentPosition = (long) zzbap.getCurrentPosition();
            if (this.zzeit != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue()) {
                    zzd("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzeio.getTotalBytes()), "qoeCachedBytes", String.valueOf(this.zzeio.zzna()), "qoeLoadedBytes", String.valueOf(this.zzeio.zzzo()), "droppedFrames", String.valueOf(this.zzeio.zzzp()), "reportTime", String.valueOf(zzp.zzkx().currentTimeMillis()));
                } else {
                    zzd("timeupdate", "time", String.valueOf(f));
                }
                this.zzeit = currentPosition;
            }
        }
    }
}
