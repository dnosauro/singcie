package p157d.p164e;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: d.e.c */
public final class C3261c extends C3258a {

    /* renamed from: b */
    public static final C3262a f7316b = new C3262a((C3247e) null);
    @NotNull

    /* renamed from: c */
    private static final C3261c f7317c = new C3261c(1, 0);

    /* renamed from: d.e.c$a */
    public static final class C3262a {
        private C3262a() {
        }

        public /* synthetic */ C3262a(C3247e eVar) {
            this();
        }
    }

    public C3261c(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: e */
    public boolean mo25711e() {
        return mo25707a() > mo25708b();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C3261c) {
            if (!mo25711e() || !((C3261c) obj).mo25711e()) {
                C3261c cVar = (C3261c) obj;
                if (!(mo25707a() == cVar.mo25707a() && mo25708b() == cVar.mo25708b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo25711e()) {
            return -1;
        }
        return (mo25707a() * 31) + mo25708b();
    }

    @NotNull
    public String toString() {
        return mo25707a() + ".." + mo25708b();
    }
}
