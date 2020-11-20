package p157d.p158a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.t */
final class C3204t implements Serializable, Map {

    /* renamed from: a */
    public static final C3204t f7280a = new C3204t();

    private C3204t() {
    }

    /* renamed from: a */
    public int mo25634a() {
        return 0;
    }

    @Nullable
    /* renamed from: a */
    public Void mo25635a(@Nullable Object obj) {
        return null;
    }

    /* renamed from: a */
    public boolean mo25636a(@NotNull Void voidR) {
        C3250h.m9056b(voidR, "value");
        return false;
    }

    @NotNull
    /* renamed from: b */
    public Set<Map.Entry> mo25637b() {
        return C3205u.f7281a;
    }

    @NotNull
    /* renamed from: c */
    public Set<Object> mo25638c() {
        return C3205u.f7281a;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(@Nullable Object obj) {
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return mo25636a((Void) obj);
        }
        return false;
    }

    @NotNull
    /* renamed from: d */
    public Collection mo25642d() {
        return C3203s.f7279a;
    }

    public final Set<Map.Entry> entrySet() {
        return mo25637b();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public final Object get(Object obj) {
        return mo25635a(obj);
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public final Set<Object> keySet() {
        return mo25638c();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return mo25634a();
    }

    @NotNull
    public String toString() {
        return "{}";
    }

    public final Collection values() {
        return mo25642d();
    }
}
