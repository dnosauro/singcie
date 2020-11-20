package p157d.p166g;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.g.e */
public final class C3276e implements Serializable {

    /* renamed from: a */
    public static final C3277a f7325a = new C3277a((C3247e) null);

    /* renamed from: b */
    private final Pattern f7326b;

    /* renamed from: d.g.e$a */
    public static final class C3277a {
        private C3277a() {
        }

        public /* synthetic */ C3277a(C3247e eVar) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C3276e(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            p157d.p161d.p163b.C3250h.m9056b(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            p157d.p161d.p163b.C3250h.m9053a((java.lang.Object) r2, (java.lang.String) r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p157d.p166g.C3276e.<init>(java.lang.String):void");
    }

    public C3276e(@NotNull Pattern pattern) {
        C3250h.m9056b(pattern, "nativePattern");
        this.f7326b = pattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.f7326b.toString();
        C3250h.m9053a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }
}
