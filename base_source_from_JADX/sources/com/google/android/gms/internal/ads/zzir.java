package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import org.spongycastle.asn1.cmc.BodyPartID;

class zzir {
    private int zzahl;
    protected AudioTrack zzajw;
    private boolean zzalo;
    private long zzalp;
    private long zzalq;
    private long zzalr;
    private long zzals;
    private long zzalt;
    private long zzalu;

    private zzir() {
    }

    /* synthetic */ zzir(zzis zzis) {
        this();
    }

    public final void pause() {
        if (this.zzals == -9223372036854775807L) {
            this.zzajw.pause();
        }
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzajw = audioTrack;
        this.zzalo = z;
        this.zzals = -9223372036854775807L;
        this.zzalp = 0;
        this.zzalq = 0;
        this.zzalr = 0;
        if (audioTrack != null) {
            this.zzahl = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzalt = zzfy();
        this.zzals = SystemClock.elapsedRealtime() * 1000;
        this.zzalu = j;
        this.zzajw.stop();
    }

    public final long zzfy() {
        if (this.zzals != -9223372036854775807L) {
            return Math.min(this.zzalu, this.zzalt + ((((SystemClock.elapsedRealtime() * 1000) - this.zzals) * ((long) this.zzahl)) / 1000000));
        }
        int playState = this.zzajw.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = BodyPartID.bodyIdMax & ((long) this.zzajw.getPlaybackHeadPosition());
        if (this.zzalo) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzalr = this.zzalp;
            }
            playbackHeadPosition += this.zzalr;
        }
        if (this.zzalp > playbackHeadPosition) {
            this.zzalq++;
        }
        this.zzalp = playbackHeadPosition;
        return playbackHeadPosition + (this.zzalq << 32);
    }

    public final long zzfz() {
        return (zzfy() * 1000000) / ((long) this.zzahl);
    }

    public boolean zzga() {
        return false;
    }

    public long zzgb() {
        throw new UnsupportedOperationException();
    }

    public long zzgc() {
        throw new UnsupportedOperationException();
    }
}
