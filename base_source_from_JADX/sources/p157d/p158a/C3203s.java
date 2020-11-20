package p157d.p158a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.apache.commons.p172io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3246d;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.s */
public final class C3203s implements Serializable, List, RandomAccess {

    /* renamed from: a */
    public static final C3203s f7279a = new C3203s();

    private C3203s() {
    }

    /* renamed from: a */
    public int mo25603a() {
        return 0;
    }

    @NotNull
    /* renamed from: a */
    public Void get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + FilenameUtils.EXTENSION_SEPARATOR);
    }

    /* renamed from: a */
    public boolean mo25605a(@NotNull Void voidR) {
        C3250h.m9056b(voidR, "element");
        return false;
    }

    public /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public int mo25610b(@NotNull Void voidR) {
        C3250h.m9056b(voidR, "element");
        return -1;
    }

    /* renamed from: c */
    public int mo25611c(@NotNull Void voidR) {
        C3250h.m9056b(voidR, "element");
        return -1;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            return mo25605a((Void) obj);
        }
        return false;
    }

    public boolean containsAll(@NotNull Collection collection) {
        C3250h.m9056b(collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int hashCode() {
        return 1;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Void) {
            return mo25610b((Void) obj);
        }
        return -1;
    }

    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public Iterator iterator() {
        return C3202r.f7278a;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return mo25611c((Void) obj);
        }
        return -1;
    }

    @NotNull
    public ListIterator listIterator() {
        return C3202r.f7278a;
    }

    @NotNull
    public ListIterator listIterator(int i) {
        if (i == 0) {
            return C3202r.f7278a;
        }
        throw new IndexOutOfBoundsException("Index: " + i);
    }

    public /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return mo25603a();
    }

    @NotNull
    public List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
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
