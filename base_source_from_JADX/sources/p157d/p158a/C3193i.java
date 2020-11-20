package p157d.p158a;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.i */
class C3193i extends C3192h {
    /* renamed from: a */
    public static final <T> int m8983a(@NotNull List<? extends T> list) {
        C3250h.m9056b(list, "$this$lastIndex");
        return list.size() - 1;
    }

    @NotNull
    /* renamed from: a */
    public static final <T> List<T> m8984a() {
        return C3203s.f7279a;
    }

    @NotNull
    /* renamed from: a */
    public static final <T> List<T> m8985a(@NotNull T... tArr) {
        C3250h.m9056b(tArr, "elements");
        return tArr.length > 0 ? C3184a.m8976a(tArr) : C3191g.m8984a();
    }

    @NotNull
    /* renamed from: b */
    public static final <T> List<T> m8986b(@NotNull List<? extends T> list) {
        C3250h.m9056b(list, "$this$optimizeReadOnlyList");
        switch (list.size()) {
            case 0:
                return C3191g.m8984a();
            case 1:
                return C3191g.m8982a(list.get(0));
            default:
                return list;
        }
    }

    /* renamed from: b */
    public static final void m8987b() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
