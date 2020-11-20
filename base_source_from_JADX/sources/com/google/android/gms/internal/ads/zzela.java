package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzela extends zzeio<String> implements zzekz, RandomAccess {
    private static final zzela zzioy;
    private static final zzekz zzioz = zzioy;
    private final List<Object> zzipa;

    static {
        zzela zzela = new zzela();
        zzioy = zzela;
        zzela.zzbfl();
    }

    public zzela() {
        this(10);
    }

    public zzela(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzela(ArrayList<Object> arrayList) {
        this.zzipa = arrayList;
    }

    private static String zzam(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzeiu ? ((zzeiu) obj).zzbfq() : zzekk.zzy((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzbfm();
        this.zzipa.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbfm();
        if (collection instanceof zzekz) {
            collection = ((zzekz) collection).zzbiu();
        }
        boolean addAll = this.zzipa.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzbfm();
        this.zzipa.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzipa.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeiu) {
            zzeiu zzeiu = (zzeiu) obj;
            String zzbfq = zzeiu.zzbfq();
            if (zzeiu.zzbfr()) {
                this.zzipa.set(i, zzbfq);
            }
            return zzbfq;
        }
        byte[] bArr = (byte[]) obj;
        String zzy = zzekk.zzy(bArr);
        if (zzekk.zzx(bArr)) {
            this.zzipa.set(i, zzy);
        }
        return zzy;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        Object remove = this.zzipa.remove(i);
        this.modCount++;
        return zzam(remove);
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
        zzbfm();
        return zzam(this.zzipa.set(i, (String) obj));
    }

    public final int size() {
        return this.zzipa.size();
    }

    public final void zzak(zzeiu zzeiu) {
        zzbfm();
        this.zzipa.add(zzeiu);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zzbfk() {
        return super.zzbfk();
    }

    public final List<?> zzbiu() {
        return Collections.unmodifiableList(this.zzipa);
    }

    public final zzekz zzbiv() {
        return zzbfk() ? new zzenk(this) : this;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzipa);
            return new zzela((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final Object zzhi(int i) {
        return this.zzipa.get(i);
    }
}
