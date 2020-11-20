package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

public final class zzwq {
    private static zzwq zzciw = new zzwq();
    private final zzayr zzcix;
    private final zzvx zzciy;
    private final String zzciz;
    private final zzaaw zzcja;
    private final zzaay zzcjb;
    private final zzabb zzcjc;
    private final zzazh zzcjd;
    private final Random zzcje;
    private final WeakHashMap<QueryInfo, String> zzcjf;

    protected zzwq() {
        this(new zzayr(), new zzvx(new zzvi(), new zzvf(), new zzzp(), new zzagn(), new zzaut(), new zzavx(), new zzarh(), new zzagm()), new zzaaw(), new zzaay(), new zzabb(), zzayr.zzzf(), new zzazh(0, 203404000, true), new Random(), new WeakHashMap());
    }

    private zzwq(zzayr zzayr, zzvx zzvx, zzaaw zzaaw, zzaay zzaay, zzabb zzabb, String str, zzazh zzazh, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.zzcix = zzayr;
        this.zzciy = zzvx;
        this.zzcja = zzaaw;
        this.zzcjb = zzaay;
        this.zzcjc = zzabb;
        this.zzciz = str;
        this.zzcjd = zzazh;
        this.zzcje = random;
        this.zzcjf = weakHashMap;
    }

    public static zzayr zzqa() {
        return zzciw.zzcix;
    }

    public static zzvx zzqb() {
        return zzciw.zzciy;
    }

    public static zzaay zzqc() {
        return zzciw.zzcjb;
    }

    public static zzaaw zzqd() {
        return zzciw.zzcja;
    }

    public static zzabb zzqe() {
        return zzciw.zzcjc;
    }

    public static String zzqf() {
        return zzciw.zzciz;
    }

    public static zzazh zzqg() {
        return zzciw.zzcjd;
    }

    public static Random zzqh() {
        return zzciw.zzcje;
    }

    public static WeakHashMap<QueryInfo, String> zzqi() {
        return zzciw.zzcjf;
    }
}
