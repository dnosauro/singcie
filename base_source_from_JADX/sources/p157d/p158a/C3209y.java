package p157d.p158a;

import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p157d.C3216d;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.y */
class C3209y extends C3208x {
    /* renamed from: a */
    public static final int m9013a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    /* renamed from: a */
    public static final <K, V> Map<K, V> m9014a(@NotNull C3216d<? extends K, ? extends V> dVar) {
        C3250h.m9056b(dVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(dVar.mo25682a(), dVar.mo25683b());
        C3250h.m9053a((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    /* renamed from: a */
    public static final <K, V> Map<K, V> m9015a(@NotNull Map<? extends K, ? extends V> map) {
        C3250h.m9056b(map, "$this$toSingletonMap");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C3250h.m9053a((Object) singletonMap, "java.util.Collections.singletonMap(key, value)");
        C3250h.m9053a((Object) singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
