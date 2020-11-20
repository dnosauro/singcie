package p157d.p166g;

import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.LocalizedMessage;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.g.d */
public final class C3275d {
    @NotNull

    /* renamed from: a */
    public static final Charset f7318a;
    @NotNull

    /* renamed from: b */
    public static final Charset f7319b;
    @NotNull

    /* renamed from: c */
    public static final Charset f7320c;
    @NotNull

    /* renamed from: d */
    public static final Charset f7321d;
    @NotNull

    /* renamed from: e */
    public static final Charset f7322e;
    @NotNull

    /* renamed from: f */
    public static final Charset f7323f;

    /* renamed from: g */
    public static final C3275d f7324g = new C3275d();

    static {
        Charset forName = Charset.forName("UTF-8");
        C3250h.m9053a((Object) forName, "Charset.forName(\"UTF-8\")");
        f7318a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        C3250h.m9053a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f7319b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        C3250h.m9053a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f7320c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        C3250h.m9053a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f7321d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        C3250h.m9053a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f7322e = forName5;
        Charset forName6 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
        C3250h.m9053a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f7323f = forName6;
    }

    private C3275d() {
    }
}
