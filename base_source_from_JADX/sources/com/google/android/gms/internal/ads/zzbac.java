package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public final class zzbac extends zzbap implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzehh = new HashMap();
    private final zzbbe zzehi;
    private final zzbbh zzehj;
    private final boolean zzehk;
    private int zzehl = 0;
    private int zzehm = 0;
    private MediaPlayer zzehn;
    private Uri zzeho;
    private int zzehp;
    private int zzehq;
    private int zzehr;
    private int zzehs;
    private int zzeht;
    private zzbbc zzehu;
    private boolean zzehv;
    private int zzehw;
    /* access modifiers changed from: private */
    public zzbam zzehx;
    private Integer zzehy = null;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzehh.put(-1004, "MEDIA_ERROR_IO");
            zzehh.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzehh.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzehh.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzehh.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzehh.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzehh.put(1, "MEDIA_ERROR_UNKNOWN");
        zzehh.put(1, "MEDIA_INFO_UNKNOWN");
        zzehh.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzehh.put(701, "MEDIA_INFO_BUFFERING_START");
        zzehh.put(702, "MEDIA_INFO_BUFFERING_END");
        zzehh.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzehh.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzehh.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzehh.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzehh.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzbac(Context context, zzbbe zzbbe, boolean z, boolean z2, zzbbf zzbbf, zzbbh zzbbh) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzehi = zzbbe;
        this.zzehj = zzbbh;
        this.zzehv = z;
        this.zzehk = z2;
        this.zzehj.zzb(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        r0.put(r4, r3.getString("codecs-string"));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.media.MediaPlayer r11) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcqn
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzbbe r0 = r10.zzehi
            if (r0 == 0) goto L_0x0128
            if (r11 == 0) goto L_0x0128
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 >= r1) goto L_0x0020
            goto L_0x0128
        L_0x0020:
            android.media.MediaPlayer$TrackInfo[] r11 = r11.getTrackInfo()
            if (r11 != 0) goto L_0x0027
            return
        L_0x0027:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r11.length
            r2 = 0
        L_0x002e:
            if (r2 >= r1) goto L_0x011b
            r3 = r11[r2]
            if (r3 == 0) goto L_0x0117
            int r4 = r3.getTrackType()
            r5 = 30
            switch(r4) {
                case 1: goto L_0x0071;
                case 2: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0117
        L_0x003f:
            android.media.MediaFormat r3 = r3.getFormat()
            if (r3 == 0) goto L_0x0117
            java.lang.String r4 = "mime"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x0058
            java.lang.String r4 = "audioMime"
            java.lang.String r6 = "mime"
            java.lang.String r6 = r3.getString(r6)
            r0.put(r4, r6)
        L_0x0058:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x0117
            java.lang.String r4 = "codecs-string"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x0117
            java.lang.String r4 = "audioCodec"
        L_0x0066:
            java.lang.String r5 = "codecs-string"
            java.lang.String r3 = r3.getString(r5)
            r0.put(r4, r3)
            goto L_0x0117
        L_0x0071:
            android.media.MediaFormat r3 = r3.getFormat()
            if (r3 == 0) goto L_0x0117
            java.lang.String r4 = "frame-rate"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x009e
            java.lang.String r4 = "frameRate"
            java.lang.String r6 = "frame-rate"
            float r6 = r3.getFloat(r6)     // Catch:{ ClassCastException -> 0x008f }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ ClassCastException -> 0x008f }
            r0.put(r4, r6)     // Catch:{ ClassCastException -> 0x008f }
            goto L_0x009e
        L_0x008f:
            java.lang.String r4 = "frameRate"
            java.lang.String r6 = "frame-rate"
            int r6 = r3.getInteger(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.put(r4, r6)
        L_0x009e:
            java.lang.String r4 = "bitrate"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x00bd
            java.lang.String r4 = "bitrate"
            int r4 = r3.getInteger(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r10.zzehy = r4
            java.lang.String r4 = "bitRate"
            java.lang.Integer r6 = r10.zzehy
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.put(r4, r6)
        L_0x00bd:
            java.lang.String r4 = "width"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x00f4
            java.lang.String r4 = "height"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x00f4
            java.lang.String r4 = "resolution"
            java.lang.String r6 = "width"
            int r6 = r3.getInteger(r6)
            java.lang.String r7 = "height"
            int r7 = r3.getInteger(r7)
            r8 = 23
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            r9.append(r6)
            java.lang.String r6 = "x"
            r9.append(r6)
            r9.append(r7)
            java.lang.String r6 = r9.toString()
            r0.put(r4, r6)
        L_0x00f4:
            java.lang.String r4 = "mime"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x0107
            java.lang.String r4 = "videoMime"
            java.lang.String r6 = "mime"
            java.lang.String r6 = r3.getString(r6)
            r0.put(r4, r6)
        L_0x0107:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x0117
            java.lang.String r4 = "codecs-string"
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x0117
            java.lang.String r4 = "videoCodec"
            goto L_0x0066
        L_0x0117:
            int r2 = r2 + 1
            goto L_0x002e
        L_0x011b:
            boolean r11 = r0.isEmpty()
            if (r11 != 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzbbe r11 = r10.zzehi
            java.lang.String r1 = "onMetadataEvent"
            r11.zza(r1, r0)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.zza(android.media.MediaPlayer):void");
    }

    private final void zzas(boolean z) {
        zzd.zzee("AdMediaPlayerView release");
        zzbbc zzbbc = this.zzehu;
        if (zzbbc != null) {
            zzbbc.zzaad();
            this.zzehu = null;
        }
        MediaPlayer mediaPlayer = this.zzehn;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzehn.release();
            this.zzehn = null;
            zzdj(0);
            if (z) {
                this.zzehm = 0;
                this.zzehm = 0;
            }
        }
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzehn;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzd.zzfa("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzdj(int i) {
        if (i == 3) {
            this.zzehj.zzaat();
            this.zzeii.zzaat();
        } else if (this.zzehl == 3) {
            this.zzehj.zzaau();
            this.zzeii.zzaau();
        }
        this.zzehl = i;
    }

    private final void zzzl() {
        zzd.zzee("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzeho != null && surfaceTexture != null) {
            zzas(false);
            try {
                zzp.zzlg();
                this.zzehn = new MediaPlayer();
                this.zzehn.setOnBufferingUpdateListener(this);
                this.zzehn.setOnCompletionListener(this);
                this.zzehn.setOnErrorListener(this);
                this.zzehn.setOnInfoListener(this);
                this.zzehn.setOnPreparedListener(this);
                this.zzehn.setOnVideoSizeChangedListener(this);
                this.zzehr = 0;
                if (this.zzehv) {
                    this.zzehu = new zzbbc(getContext());
                    this.zzehu.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzehu.start();
                    SurfaceTexture zzaae = this.zzehu.zzaae();
                    if (zzaae != null) {
                        surfaceTexture = zzaae;
                    } else {
                        this.zzehu.zzaad();
                        this.zzehu = null;
                    }
                }
                this.zzehn.setDataSource(getContext(), this.zzeho);
                zzp.zzlh();
                this.zzehn.setSurface(new Surface(surfaceTexture));
                this.zzehn.setAudioStreamType(3);
                this.zzehn.setScreenOnWhilePlaying(true);
                this.zzehn.prepareAsync();
                zzdj(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzeho);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzd.zzd(sb.toString(), e);
                onError(this.zzehn, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzzm() {
        /*
            r8 = this;
            boolean r0 = r8.zzehk
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzzn()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.zzehn
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.zzehm
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            r0 = 0
            r8.zzd(r0)
            android.media.MediaPlayer r0 = r8.zzehn
            r0.start()
            android.media.MediaPlayer r0 = r8.zzehn
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzzn()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.zzehn
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzehn
            r0.pause()
            r8.zzzq()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.zzzm():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzehl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzzn() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzehn
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzehl
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.zzzn():boolean");
    }

    public final int getCurrentPosition() {
        if (zzzn()) {
            return this.zzehn.getCurrentPosition();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzzn()) {
            return this.zzehn.getDuration();
        }
        return -1;
    }

    public final long getTotalBytes() {
        if (this.zzehy != null) {
            return ((long) getDuration()) * ((long) this.zzehy.intValue());
        }
        return -1;
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzehn;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzehn;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzehr = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzd.zzee("AdMediaPlayerView completion");
        zzdj(5);
        this.zzehm = 5;
        zzm.zzedd.post(new zzbah(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzehh.get(Integer.valueOf(i));
        String str2 = zzehh.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.zzfa(sb.toString());
        zzdj(-1);
        this.zzehm = -1;
        zzm.zzedd.post(new zzbag(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzehh.get(Integer.valueOf(i));
        String str2 = zzehh.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.zzee(sb.toString());
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzehp
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.zzehq
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.zzehp
            if (r2 <= 0) goto L_0x0088
            int r2 = r5.zzehq
            if (r2 <= 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzbbc r2 = r5.zzehu
            if (r2 != 0) goto L_0x0088
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0048
            if (r1 != r2) goto L_0x0048
            int r0 = r5.zzehp
            int r1 = r0 * r7
            int r2 = r5.zzehq
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003d
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            goto L_0x0088
        L_0x003d:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L_0x0069
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L_0x0089
        L_0x0048:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x005a
            int r0 = r5.zzehq
            int r0 = r0 * r6
            int r2 = r5.zzehp
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0058
            if (r0 <= r7) goto L_0x0058
            goto L_0x0067
        L_0x0058:
            r1 = r0
            goto L_0x0089
        L_0x005a:
            if (r1 != r2) goto L_0x006b
            int r1 = r5.zzehp
            int r1 = r1 * r7
            int r2 = r5.zzehq
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0068
            if (r1 <= r6) goto L_0x0068
        L_0x0067:
            goto L_0x0069
        L_0x0068:
            r6 = r1
        L_0x0069:
            r1 = r7
            goto L_0x0089
        L_0x006b:
            int r2 = r5.zzehp
            int r4 = r5.zzehq
            if (r1 != r3) goto L_0x0078
            if (r4 <= r7) goto L_0x0078
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L_0x0079
        L_0x0078:
            r1 = r4
        L_0x0079:
            if (r0 != r3) goto L_0x0086
            if (r2 <= r6) goto L_0x0086
            int r7 = r5.zzehq
            int r7 = r7 * r6
            int r0 = r5.zzehp
            int r1 = r7 / r0
            goto L_0x0089
        L_0x0086:
            r6 = r2
            goto L_0x0089
        L_0x0088:
            r6 = r0
        L_0x0089:
            r5.setMeasuredDimension(r6, r1)
            com.google.android.gms.internal.ads.zzbbc r7 = r5.zzehu
            if (r7 == 0) goto L_0x0093
            r7.zzm(r6, r1)
        L_0x0093:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r7 != r0) goto L_0x00ac
            int r7 = r5.zzehs
            if (r7 <= 0) goto L_0x009f
            if (r7 != r6) goto L_0x00a5
        L_0x009f:
            int r7 = r5.zzeht
            if (r7 <= 0) goto L_0x00a8
            if (r7 == r1) goto L_0x00a8
        L_0x00a5:
            r5.zzzm()
        L_0x00a8:
            r5.zzehs = r6
            r5.zzeht = r1
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.onMeasure(int, int):void");
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzd.zzee("AdMediaPlayerView prepared");
        zzdj(2);
        this.zzehj.zzfb();
        zzm.zzedd.post(new zzbae(this, mediaPlayer));
        this.zzehp = mediaPlayer.getVideoWidth();
        this.zzehq = mediaPlayer.getVideoHeight();
        int i = this.zzehw;
        if (i != 0) {
            seekTo(i);
        }
        zzzm();
        int i2 = this.zzehp;
        int i3 = this.zzehq;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzd.zzez(sb.toString());
        if (this.zzehm == 3) {
            play();
        }
        zzzq();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.zzee("AdMediaPlayerView surface created");
        zzzl();
        zzm.zzedd.post(new zzbaj(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzd.zzee("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzehn;
        if (mediaPlayer != null && this.zzehw == 0) {
            this.zzehw = mediaPlayer.getCurrentPosition();
        }
        zzbbc zzbbc = this.zzehu;
        if (zzbbc != null) {
            zzbbc.zzaad();
        }
        zzm.zzedd.post(new zzbal(this));
        zzas(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.zzee("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzehm == 3;
        if (!(this.zzehp == i && this.zzehq == i2)) {
            z = false;
        }
        if (this.zzehn != null && z2 && z) {
            int i3 = this.zzehw;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbbc zzbbc = this.zzehu;
        if (zzbbc != null) {
            zzbbc.zzm(i, i2);
        }
        zzm.zzedd.post(new zzbai(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzehj.zzc(this);
        this.zzeih.zza(surfaceTexture, this.zzehx);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzd.zzee(sb.toString());
        this.zzehp = mediaPlayer.getVideoWidth();
        this.zzehq = mediaPlayer.getVideoHeight();
        if (this.zzehp != 0 && this.zzehq != 0) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzd.zzee(sb.toString());
        zzm.zzedd.post(new zzbaf(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        zzd.zzee("AdMediaPlayerView pause");
        if (zzzn() && this.zzehn.isPlaying()) {
            this.zzehn.pause();
            zzdj(4);
            zzm.zzedd.post(new zzban(this));
        }
        this.zzehm = 4;
    }

    public final void play() {
        zzd.zzee("AdMediaPlayerView play");
        if (zzzn()) {
            this.zzehn.start();
            zzdj(3);
            this.zzeih.zzzs();
            zzm.zzedd.post(new zzbak(this));
        }
        this.zzehm = 3;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzd.zzee(sb.toString());
        if (zzzn()) {
            this.zzehn.seekTo(i);
            this.zzehw = 0;
            return;
        }
        this.zzehw = i;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zztf zzd = zztf.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzeho = parse;
            this.zzehw = 0;
            zzzl();
            requestLayout();
            invalidate();
        }
    }

    public final void stop() {
        zzd.zzee("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzehn;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzehn.release();
            this.zzehn = null;
            zzdj(0);
            this.zzehm = 0;
        }
        this.zzehj.onStop();
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
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

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdk(int i) {
        zzbam zzbam = this.zzehx;
        if (zzbam != null) {
            zzbam.onWindowVisibilityChanged(i);
        }
    }

    public final long zzna() {
        return 0;
    }

    public final String zzzk() {
        String valueOf = String.valueOf(this.zzehv ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    public final long zzzo() {
        if (this.zzehy != null) {
            return (getTotalBytes() * ((long) this.zzehr)) / 100;
        }
        return -1;
    }

    public final int zzzp() {
        if (Build.VERSION.SDK_INT < 26 || !zzzn()) {
            return -1;
        }
        return this.zzehn.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final void zzzq() {
        zzd(this.zzeii.getVolume());
    }
}
