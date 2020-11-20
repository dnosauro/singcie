package p157d.p158a;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* renamed from: d.a.v */
public abstract class C3206v implements Iterator<Integer> {
    @NotNull
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(mo25674b());
    }

    /* renamed from: b */
    public abstract int mo25674b();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
