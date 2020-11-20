package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzdnp {
    /* access modifiers changed from: private */
    public boolean zzbnx;
    /* access modifiers changed from: private */
    public zzvn zzbpe;
    /* access modifiers changed from: private */
    public zzadz zzdnh;
    /* access modifiers changed from: private */
    public zzajl zzdui;
    /* access modifiers changed from: private */
    public int zzgwz = 1;
    /* access modifiers changed from: private */
    public boolean zzgyj = false;
    /* access modifiers changed from: private */
    public zzxu zzhim;
    /* access modifiers changed from: private */
    public zzaak zzhin;
    /* access modifiers changed from: private */
    public zzvk zzhio;
    /* access modifiers changed from: private */
    public String zzhip;
    /* access modifiers changed from: private */
    public ArrayList<String> zzhiq;
    /* access modifiers changed from: private */
    public ArrayList<String> zzhir;
    /* access modifiers changed from: private */
    public zzvw zzhis;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzhit;
    /* access modifiers changed from: private */
    public zzxo zzhiu;
    /* access modifiers changed from: private */
    public zzdnc zzhiw = new zzdnc();

    public final zzvk zzaup() {
        return this.zzhio;
    }

    public final String zzauq() {
        return this.zzhip;
    }

    public final zzdnc zzaur() {
        return this.zzhiw;
    }

    public final zzdnn zzaus() {
        Preconditions.checkNotNull(this.zzhip, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbpe, "ad size must not be null");
        Preconditions.checkNotNull(this.zzhio, "ad request must not be null");
        return new zzdnn(this);
    }

    public final boolean zzaut() {
        return this.zzgyj;
    }

    public final zzdnp zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhit = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbnx = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzhiu = publisherAdViewOptions.zzju();
        }
        return this;
    }

    public final zzdnp zzb(zzadz zzadz) {
        this.zzdnh = zzadz;
        return this;
    }

    public final zzdnp zzb(zzajl zzajl) {
        this.zzdui = zzajl;
        this.zzhin = new zzaak(false, true, false);
        return this;
    }

    public final zzdnp zzb(zzvw zzvw) {
        this.zzhis = zzvw;
        return this;
    }

    public final zzdnp zzbn(boolean z) {
        this.zzgyj = z;
        return this;
    }

    public final zzdnp zzbo(boolean z) {
        this.zzbnx = z;
        return this;
    }

    public final zzdnp zzc(zzaak zzaak) {
        this.zzhin = zzaak;
        return this;
    }

    public final zzdnp zzc(zzdnn zzdnn) {
        this.zzhiw.zza(zzdnn.zzhiv);
        this.zzhio = zzdnn.zzhio;
        this.zzbpe = zzdnn.zzbpe;
        this.zzhim = zzdnn.zzhim;
        this.zzhip = zzdnn.zzhip;
        this.zzhin = zzdnn.zzhin;
        this.zzhiq = zzdnn.zzhiq;
        this.zzhir = zzdnn.zzhir;
        this.zzdnh = zzdnn.zzdnh;
        this.zzhis = zzdnn.zzhis;
        zzdnp zzb = zzb(zzdnn.zzhit);
        zzb.zzgyj = zzdnn.zzgyj;
        return zzb;
    }

    public final zzdnp zzc(zzxu zzxu) {
        this.zzhim = zzxu;
        return this;
    }

    public final zzdnp zzc(ArrayList<String> arrayList) {
        this.zzhiq = arrayList;
        return this;
    }

    public final zzdnp zzd(ArrayList<String> arrayList) {
        this.zzhir = arrayList;
        return this;
    }

    public final zzdnp zzee(int i) {
        this.zzgwz = i;
        return this;
    }

    public final zzdnp zzf(zzvn zzvn) {
        this.zzbpe = zzvn;
        return this;
    }

    public final zzdnp zzgq(String str) {
        this.zzhip = str;
        return this;
    }

    public final zzdnp zzh(zzvk zzvk) {
        this.zzhio = zzvk;
        return this;
    }

    public final zzvn zzkf() {
        return this.zzbpe;
    }
}
