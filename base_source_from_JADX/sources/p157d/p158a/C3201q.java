package p157d.p158a;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.q */
class C3201q extends C3200p {
    @NotNull
    /* renamed from: a */
    public static final <T, C extends Collection<? super T>> C m8990a(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        C3250h.m9056b(iterable, "$this$toCollection");
        C3250h.m9056b(c, FirebaseAnalytics.Param.DESTINATION);
        for (Object add : iterable) {
            c.add(add);
        }
        return c;
    }

    @NotNull
    /* renamed from: a */
    public static final <T> List<T> m8991a(@NotNull Iterable<? extends T> iterable) {
        C3250h.m9056b(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return C3191g.m8993b(iterable);
        }
        List<T> c = C3191g.m8994c(iterable);
        C3191g.m8989c(c);
        return c;
    }

    @NotNull
    /* renamed from: a */
    public static final <T> List<T> m8992a(@NotNull Collection<? extends T> collection) {
        C3250h.m9056b(collection, "$this$toMutableList");
        return new ArrayList<>(collection);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> List<T> m8993b(@NotNull Iterable<? extends T> iterable) {
        C3250h.m9056b(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return C3191g.m8986b(C3191g.m8994c(iterable));
        }
        Collection collection = (Collection) iterable;
        switch (collection.size()) {
            case 0:
                return C3191g.m8984a();
            case 1:
                return C3191g.m8982a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            default:
                return C3191g.m8992a(collection);
        }
    }

    @NotNull
    /* renamed from: c */
    public static final <T> List<T> m8994c(@NotNull Iterable<? extends T> iterable) {
        C3250h.m9056b(iterable, "$this$toMutableList");
        return iterable instanceof Collection ? C3191g.m8992a((Collection) iterable) : (List) C3191g.m8990a(iterable, new ArrayList());
    }

    /* renamed from: d */
    public static final <T> T m8995d(@NotNull List<? extends T> list) {
        C3250h.m9056b(list, "$this$last");
        if (!list.isEmpty()) {
            return list.get(C3191g.m8983a(list));
        }
        throw new NoSuchElementException("List is empty.");
    }
}
