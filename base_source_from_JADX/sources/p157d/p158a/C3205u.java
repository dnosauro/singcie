package p157d.p158a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3246d;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.u */
public final class C3205u implements Serializable, Set {

    /* renamed from: a */
    public static final C3205u f7281a = new C3205u();

    private C3205u() {
    }

    /* renamed from: a */
    public int mo25655a() {
        return 0;
    }

    /* renamed from: a */
    public boolean mo25656a(@NotNull Void voidR) {
        C3250h.m9056b(voidR, "element");
        return false;
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            return mo25656a((Void) obj);
        }
        return false;
    }

    public boolean containsAll(@NotNull Collection collection) {
        C3250h.m9056b(collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public Iterator iterator() {
        return C3202r.f7278a;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return mo25655a();
    }

    public Object[] toArray() {
        return C3246d.m9046a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return C3246d.m9047a(this, tArr);
    }

    @NotNull
    public String toString() {
        return "[]";
    }
}
