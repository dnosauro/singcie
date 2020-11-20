package p157d.p158a;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p157d.C3216d;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.z */
class C3210z extends C3209y {
    @NotNull
    /* renamed from: a */
    public static final <K, V> Map<K, V> m9016a() {
        C3204t tVar = C3204t.f7280a;
        if (tVar != null) {
            return tVar;
        }
        throw new C3266f("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @NotNull
    /* renamed from: a */
    public static final <K, V> Map<K, V> m9017a(@NotNull Iterable<? extends C3216d<? extends K, ? extends V>> iterable) {
        C3250h.m9056b(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            return C3207w.m9020b(C3207w.m9018a(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        switch (collection.size()) {
            case 0:
                return C3207w.m9016a();
            case 1:
                return C3207w.m9014a((C3216d) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
            default:
                return C3207w.m9018a(iterable, new LinkedHashMap(C3207w.m9013a(collection.size())));
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m9018a(@NotNull Iterable<? extends C3216d<? extends K, ? extends V>> iterable, @NotNull M m) {
        C3250h.m9056b(iterable, "$this$toMap");
        C3250h.m9056b(m, FirebaseAnalytics.Param.DESTINATION);
        C3207w.m9019a(m, iterable);
        return m;
    }

    /* renamed from: a */
    public static final <K, V> void m9019a(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends C3216d<? extends K, ? extends V>> iterable) {
        C3250h.m9056b(map, "$this$putAll");
        C3250h.m9056b(iterable, "pairs");
        for (C3216d dVar : iterable) {
            map.put(dVar.mo25684c(), dVar.mo25685d());
        }
    }

    @NotNull
    /* renamed from: b */
    public static final <K, V> Map<K, V> m9020b(@NotNull Map<K, ? extends V> map) {
        C3250h.m9056b(map, "$this$optimizeReadOnlyMap");
        switch (map.size()) {
            case 0:
                return C3207w.m9016a();
            case 1:
                return C3207w.m9015a(map);
            default:
                return map;
        }
    }
}
