package p157d;

import org.apache.commons.p172io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.b */
public final class C3211b implements Comparable<C3211b> {
    @NotNull

    /* renamed from: a */
    public static final C3211b f7282a = new C3211b(1, 3, 72);

    /* renamed from: b */
    public static final C3212a f7283b = new C3212a((C3247e) null);

    /* renamed from: c */
    private final int f7284c = m9021a(this.f7285d, this.f7286e, this.f7287f);

    /* renamed from: d */
    private final int f7285d;

    /* renamed from: e */
    private final int f7286e;

    /* renamed from: f */
    private final int f7287f;

    /* renamed from: d.b$a */
    public static final class C3212a {
        private C3212a() {
        }

        public /* synthetic */ C3212a(C3247e eVar) {
            this();
        }
    }

    public C3211b(int i, int i2, int i3) {
        this.f7285d = i;
        this.f7286e = i2;
        this.f7287f = i3;
    }

    /* renamed from: a */
    private final int m9021a(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + FilenameUtils.EXTENSION_SEPARATOR + i2 + FilenameUtils.EXTENSION_SEPARATOR + i3).toString());
    }

    /* renamed from: a */
    public int compareTo(@NotNull C3211b bVar) {
        C3250h.m9056b(bVar, "other");
        return this.f7284c - bVar.f7284c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3211b)) {
            obj = null;
        }
        C3211b bVar = (C3211b) obj;
        return bVar != null && this.f7284c == bVar.f7284c;
    }

    public int hashCode() {
        return this.f7284c;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7285d);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.f7286e);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.f7287f);
        return sb.toString();
    }
}
