package com.google.android.gms.internal.ads;

final class zzlq {
    public int zzaxa;
    public zzlc zzbah;
    public long zzbai;
    public long zzbaj;
    public long zzbak;
    public int zzbal;
    public long[] zzbam;
    public int[] zzban;
    public int[] zzbao;
    public int[] zzbap;
    public long[] zzbaq;
    public boolean[] zzbar;
    public boolean zzbas;
    public boolean[] zzbat;
    public zzlr zzbau;
    public int zzbav;
    public zzpn zzbaw;
    public boolean zzbax;
    public long zzbay;

    zzlq() {
    }

    public final void zzau(int i) {
        zzpn zzpn = this.zzbaw;
        if (zzpn == null || zzpn.limit() < i) {
            this.zzbaw = new zzpn(i);
        }
        this.zzbav = i;
        this.zzbas = true;
        this.zzbax = true;
    }

    public final long zzav(int i) {
        return this.zzbaq[i] + ((long) this.zzbap[i]);
    }
}
