package com.google.android.gms.internal.ads;

import androidx.p018c.C0413g;
import java.util.ArrayList;

public final class zzccl {
    public static final zzccl zzgdq = new zzccn().zzany();
    private final zzafk zzgdj;
    private final zzafj zzgdk;
    private final zzafy zzgdl;
    private final zzafx zzgdm;
    private final zzajt zzgdn;
    private final C0413g<String, zzafq> zzgdo;
    private final C0413g<String, zzafp> zzgdp;

    private zzccl(zzccn zzccn) {
        this.zzgdj = zzccn.zzgdj;
        this.zzgdk = zzccn.zzgdk;
        this.zzgdl = zzccn.zzgdl;
        this.zzgdo = new C0413g<>(zzccn.zzgdo);
        this.zzgdp = new C0413g<>(zzccn.zzgdp);
        this.zzgdm = zzccn.zzgdm;
        this.zzgdn = zzccn.zzgdn;
    }

    public final zzafk zzanr() {
        return this.zzgdj;
    }

    public final zzafj zzans() {
        return this.zzgdk;
    }

    public final zzafy zzant() {
        return this.zzgdl;
    }

    public final zzafx zzanu() {
        return this.zzgdm;
    }

    public final zzajt zzanv() {
        return this.zzgdn;
    }

    public final ArrayList<String> zzanw() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzgdl != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzgdj != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzgdk != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzgdo.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzgdn != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzanx() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzgdo.size());
        for (int i = 0; i < this.zzgdo.size(); i++) {
            arrayList.add(this.zzgdo.mo2948b(i));
        }
        return arrayList;
    }

    public final zzafq zzga(String str) {
        return this.zzgdo.get(str);
    }

    public final zzafp zzgb(String str) {
        return this.zzgdp.get(str);
    }
}
