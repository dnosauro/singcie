package com.google.android.gms.internal.ads;

public abstract class zzhc implements zzhx, zzhy {
    private int index;
    private int state;
    private final int zzaed;
    private zzia zzaee;
    private zznn zzaef;
    private long zzaeg;
    private boolean zzaeh = true;
    private boolean zzaei;

    public zzhc(int i) {
        this.zzaed = i;
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpc.checkState(z);
        this.state = 0;
        this.zzaef = null;
        this.zzaei = false;
        zzeh();
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTrackType() {
        return this.zzaed;
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void start() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpc.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void stop() {
        zzpc.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzhr zzhr, zzjl zzjl, boolean z) {
        int zzb = this.zzaef.zzb(zzhr, zzjl, z);
        if (zzb == -4) {
            if (zzjl.zzgl()) {
                this.zzaeh = true;
                return this.zzaei ? -4 : -3;
            }
            zzjl.zzanz += this.zzaeg;
        } else if (zzb == -5) {
            zzhp zzhp = zzhr.zzahv;
            if (zzhp.zzahp != Long.MAX_VALUE) {
                zzhr.zzahv = zzhp.zzds(zzhp.zzahp + this.zzaeg);
            }
        }
        return zzb;
    }

    public void zza(int i, Object obj) {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) {
    }

    public final void zza(zzia zzia, zzhp[] zzhpArr, zznn zznn, long j, boolean z, long j2) {
        zzpc.checkState(this.state == 0);
        this.zzaee = zzia;
        this.state = 1;
        zze(z);
        zza(zzhpArr, zznn, j2);
        zza(j, z);
    }

    /* access modifiers changed from: protected */
    public void zza(zzhp[] zzhpArr, long j) {
    }

    public final void zza(zzhp[] zzhpArr, zznn zznn, long j) {
        zzpc.checkState(!this.zzaei);
        this.zzaef = zznn;
        this.zzaeh = false;
        this.zzaeg = j;
        zza(zzhpArr, j);
    }

    public final void zzdo(long j) {
        this.zzaei = false;
        this.zzaeh = false;
        zza(j, false);
    }

    /* access modifiers changed from: protected */
    public final void zzdp(long j) {
        this.zzaef.zzeh(j - this.zzaeg);
    }

    public final zzhx zzdz() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) {
    }

    public zzpg zzea() {
        return null;
    }

    public final zznn zzeb() {
        return this.zzaef;
    }

    public final boolean zzec() {
        return this.zzaeh;
    }

    public final void zzed() {
        this.zzaei = true;
    }

    public final boolean zzee() {
        return this.zzaei;
    }

    public final void zzef() {
        this.zzaef.zzhs();
    }

    public int zzeg() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzeh() {
    }

    /* access modifiers changed from: protected */
    public final zzia zzei() {
        return this.zzaee;
    }

    /* access modifiers changed from: protected */
    public final boolean zzej() {
        return this.zzaeh ? this.zzaei : this.zzaef.isReady();
    }
}
