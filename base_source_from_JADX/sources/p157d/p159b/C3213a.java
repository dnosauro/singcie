package p157d.p159b;

import java.util.Timer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: d.b.a */
public final class C3213a {
    @NotNull
    /* renamed from: a */
    public static final Timer m9023a(@Nullable String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }
}
