package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzio extends zzgg<String> implements zzin, RandomAccess {
    private static final zzio zza;
    private static final zzin zzb = zza;
    private final List<Object> zzc;

    static {
        zzio zzio = new zzio();
        zza = zzio;
        zzio.mo17649i_();
    }

    public zzio() {
        this(10);
    }

    public zzio(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzio(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private static String zza(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzgm ? ((zzgm) obj).zzb() : zzhx.zzb((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzin) {
            collection = ((zzin) collection).zzb();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgm) {
            zzgm zzgm = (zzgm) obj;
            String zzb2 = zzgm.zzb();
            if (zzgm.zzc()) {
                this.zzc.set(i, zzb2);
            }
            return zzb2;
        }
        byte[] bArr = (byte[]) obj;
        String zzb3 = zzhx.zzb(bArr);
        if (zzhx.zza(bArr)) {
            this.zzc.set(i, zzb3);
        }
        return zzb3;
    }

    /* renamed from: h_ */
    public final zzin mo17920h_() {
        return zza() ? new zzks(this) : this;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zza(remove);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zza(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* synthetic */ zzid zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzio((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zza(zzgm zzgm) {
        zzc();
        this.zzc.add(zzgm);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    public final List<?> zzb() {
        return Collections.unmodifiableList(this.zzc);
    }
}
