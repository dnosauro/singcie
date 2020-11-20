package p157d.p158a;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.j */
class C3194j extends C3193i {
    /* renamed from: a */
    public static final <T> int m8988a(@NotNull Iterable<? extends T> iterable, int i) {
        C3250h.m9056b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
