package p066b.p067a.p068a.p070b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

/* renamed from: b.a.a.b.a */
public final class C1344a {
    @NotNull

    /* renamed from: a */
    private C1346c f4135a;
    @Nullable

    /* renamed from: b */
    private Integer f4136b;
    @Nullable

    /* renamed from: c */
    private String f4137c;

    public C1344a(@NotNull C1346c cVar, @Nullable Integer num, @Nullable String str) {
        C3250h.m9056b(cVar, "event");
        this.f4135a = cVar;
        this.f4136b = num;
        this.f4137c = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1344a(C1346c cVar, Integer num, String str, int i, C3247e eVar) {
        this(cVar, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1344a)) {
            return false;
        }
        C1344a aVar = (C1344a) obj;
        return C3250h.m9055a((Object) this.f4135a, (Object) aVar.f4135a) && C3250h.m9055a((Object) this.f4136b, (Object) aVar.f4136b) && C3250h.m9055a((Object) this.f4137c, (Object) aVar.f4137c);
    }

    public int hashCode() {
        C1346c cVar = this.f4135a;
        int i = 0;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        Integer num = this.f4136b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.f4137c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "Event(event=" + this.f4135a + ", attemptsLeft=" + this.f4136b + ", url=" + this.f4137c + ")";
    }
}
