package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzepo<T> implements zzepf<Set<T>> {
    private static final zzepf<Set<Object>> zzizb = zzepi.zzbb(Collections.emptySet());
    private final List<zzeps<T>> zzizc;
    private final List<zzeps<Collection<T>>> zzizd;

    private zzepo(List<zzeps<T>> list, List<zzeps<Collection<T>>> list2) {
        this.zzizc = list;
        this.zzizd = list2;
    }

    public static <T> zzepq<T> zzas(int i, int i2) {
        return new zzepq<>(i, i2);
    }

    public final /* synthetic */ Object get() {
        int size = this.zzizc.size();
        ArrayList arrayList = new ArrayList(this.zzizd.size());
        int size2 = this.zzizd.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) this.zzizd.get(i2).get();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet zzid = zzepe.zzid(i);
        int size3 = this.zzizc.size();
        for (int i3 = 0; i3 < size3; i3++) {
            zzid.add(zzepl.checkNotNull(this.zzizc.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object checkNotNull : (Collection) arrayList.get(i4)) {
                zzid.add(zzepl.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(zzid);
    }
}
