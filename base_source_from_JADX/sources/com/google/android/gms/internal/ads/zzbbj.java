package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@TargetApi(14)
public final class zzbbj implements AudioManager.OnAudioFocusChangeListener {
    private float zzdg = 1.0f;
    private boolean zzeip;
    private final AudioManager zzelo;
    private final zzbbi zzelp;
    private boolean zzelq;
    private boolean zzelr;

    public zzbbj(Context context, zzbbi zzbbi) {
        this.zzelo = (AudioManager) context.getSystemService("audio");
        this.zzelp = zzbbi;
    }

    private final void zzaav() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = this.zzeip && !this.zzelr && this.zzdg > 0.0f;
        if (z4 && !(z2 = this.zzelq)) {
            AudioManager audioManager = this.zzelo;
            if (audioManager != null && !z2) {
                if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                    z3 = true;
                }
                this.zzelq = z3;
            }
            this.zzelp.zzzq();
        } else if (!z4 && (z = this.zzelq)) {
            AudioManager audioManager2 = this.zzelo;
            if (audioManager2 != null && z) {
                if (audioManager2.abandonAudioFocus(this) == 0) {
                    z3 = true;
                }
                this.zzelq = z3;
            }
            this.zzelp.zzzq();
        }
    }

    public final float getVolume() {
        float f = this.zzelr ? 0.0f : this.zzdg;
        if (this.zzelq) {
            return f;
        }
        return 0.0f;
    }

    public final void onAudioFocusChange(int i) {
        this.zzelq = i > 0;
        this.zzelp.zzzq();
    }

    public final void setMuted(boolean z) {
        this.zzelr = z;
        zzaav();
    }

    public final void setVolume(float f) {
        this.zzdg = f;
        zzaav();
    }

    public final void zzaat() {
        this.zzeip = true;
        zzaav();
    }

    public final void zzaau() {
        this.zzeip = false;
        zzaav();
    }
}
