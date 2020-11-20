package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzks extends AbstractList<String> implements zzin, RandomAccess {
    /* access modifiers changed from: private */
    public final zzin zza;

    public zzks(zzin zzin) {
        this.zza = zzin;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    /* renamed from: h_ */
    public final zzin mo17920h_() {
        return this;
    }

    public final Iterator<String> iterator() {
        return new zzku(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzkr(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzgm zzgm) {
        throw new UnsupportedOperationException();
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final List<?> zzb() {
        return this.zza.zzb();
    }
}
