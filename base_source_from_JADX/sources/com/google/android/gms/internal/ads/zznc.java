package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.IdentityHashMap;

final class zznc implements zzmy, zznb {
    private zznq zzafe;
    private zznb zzbdt;
    public final zzmy[] zzbev;
    private final IdentityHashMap<zznn, Integer> zzbew = new IdentityHashMap<>();
    private int zzbex;
    private zzmy[] zzbey;
    private zznm zzbez;

    public zznc(zzmy... zzmyArr) {
        this.zzbev = zzmyArr;
    }

    public final long zza(zzoc[] zzocArr, boolean[] zArr, zznn[] zznnArr, boolean[] zArr2, long j) {
        zzoc[] zzocArr2 = zzocArr;
        zznn[] zznnArr2 = zznnArr;
        int[] iArr = new int[zzocArr2.length];
        int[] iArr2 = new int[zzocArr2.length];
        for (int i = 0; i < zzocArr2.length; i++) {
            iArr[i] = zznnArr2[i] == null ? -1 : this.zzbew.get(zznnArr2[i]).intValue();
            iArr2[i] = -1;
            if (zzocArr2[i] != null) {
                zznr zzil = zzocArr2[i].zzil();
                int i2 = 0;
                while (true) {
                    zzmy[] zzmyArr = this.zzbev;
                    if (i2 >= zzmyArr.length) {
                        break;
                    } else if (zzmyArr[i2].zzho().zza(zzil) != -1) {
                        iArr2[i] = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        this.zzbew.clear();
        zznn[] zznnArr3 = new zznn[zzocArr2.length];
        zznn[] zznnArr4 = new zznn[zzocArr2.length];
        zzoc[] zzocArr3 = new zzoc[zzocArr2.length];
        ArrayList arrayList = new ArrayList(this.zzbev.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zzbev.length) {
            for (int i4 = 0; i4 < zzocArr2.length; i4++) {
                zzoc zzoc = null;
                zznnArr4[i4] = iArr[i4] == i3 ? zznnArr2[i4] : null;
                if (iArr2[i4] == i3) {
                    zzoc = zzocArr2[i4];
                }
                zzocArr3[i4] = zzoc;
            }
            ArrayList arrayList2 = arrayList;
            zzoc[] zzocArr4 = zzocArr3;
            int i5 = i3;
            long zza = this.zzbev[i3].zza(zzocArr3, zArr, zznnArr4, zArr2, j2);
            if (i5 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzocArr2.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i5) {
                    zzpc.checkState(zznnArr4[i6] != null);
                    zznnArr3[i6] = zznnArr4[i6];
                    this.zzbew.put(zznnArr4[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    if (zznnArr4[i6] != null) {
                        z2 = false;
                    }
                    zzpc.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zzbev[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzocArr3 = zzocArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznnArr3, 0, zznnArr2, 0, zznnArr3.length);
        this.zzbey = new zzmy[arrayList3.size()];
        arrayList3.toArray(this.zzbey);
        this.zzbez = new zzmp(this.zzbey);
        return j2;
    }

    public final void zza(zzmy zzmy) {
        int i = this.zzbex - 1;
        this.zzbex = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzmy zzho : this.zzbev) {
                i2 += zzho.zzho().length;
            }
            zznr[] zznrArr = new zznr[i2];
            zzmy[] zzmyArr = this.zzbev;
            int length = zzmyArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                zznq zzho2 = zzmyArr[i3].zzho();
                int i5 = zzho2.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    zznrArr[i6] = zzho2.zzbb(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.zzafe = new zznq(zznrArr);
            this.zzbdt.zza(this);
        }
    }

    public final void zza(zznb zznb, long j) {
        this.zzbdt = zznb;
        zzmy[] zzmyArr = this.zzbev;
        this.zzbex = zzmyArr.length;
        for (zzmy zza : zzmyArr) {
            zza.zza(this, j);
        }
    }

    public final /* synthetic */ void zza(zznm zznm) {
        if (this.zzafe != null) {
            this.zzbdt.zza(this);
        }
    }

    public final void zzee(long j) {
        for (zzmy zzee : this.zzbey) {
            zzee.zzee(j);
        }
    }

    public final boolean zzef(long j) {
        return this.zzbez.zzef(j);
    }

    public final long zzeg(long j) {
        long zzeg = this.zzbey[0].zzeg(j);
        int i = 1;
        while (true) {
            zzmy[] zzmyArr = this.zzbey;
            if (i >= zzmyArr.length) {
                return zzeg;
            }
            if (zzmyArr[i].zzeg(zzeg) == zzeg) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final void zzhn() {
        for (zzmy zzhn : this.zzbev) {
            zzhn.zzhn();
        }
    }

    public final zznq zzho() {
        return this.zzafe;
    }

    public final long zzhp() {
        return this.zzbez.zzhp();
    }

    public final long zzhq() {
        long zzhq = this.zzbev[0].zzhq();
        int i = 1;
        while (true) {
            zzmy[] zzmyArr = this.zzbev;
            if (i >= zzmyArr.length) {
                if (zzhq != -9223372036854775807L) {
                    zzmy[] zzmyArr2 = this.zzbey;
                    int length = zzmyArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzmy zzmy = zzmyArr2[i2];
                        if (zzmy == this.zzbev[0] || zzmy.zzeg(zzhq) == zzhq) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhq;
            } else if (zzmyArr[i].zzhq() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzhr() {
        long j = Long.MAX_VALUE;
        for (zzmy zzhr : this.zzbey) {
            long zzhr2 = zzhr.zzhr();
            if (zzhr2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhr2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
