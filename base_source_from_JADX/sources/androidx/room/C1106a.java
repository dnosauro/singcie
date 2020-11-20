package androidx.room;

import android.content.Context;
import androidx.p046i.p047a.C0814c;
import androidx.room.C1138i;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: androidx.room.a */
public class C1106a {

    /* renamed from: a */
    public final C0814c.C0818c f3478a;

    /* renamed from: b */
    public final Context f3479b;

    /* renamed from: c */
    public final String f3480c;

    /* renamed from: d */
    public final C1138i.C1142d f3481d;

    /* renamed from: e */
    public final List<C1138i.C1140b> f3482e;

    /* renamed from: f */
    public final boolean f3483f;

    /* renamed from: g */
    public final C1138i.C1141c f3484g;

    /* renamed from: h */
    public final Executor f3485h;

    /* renamed from: i */
    public final Executor f3486i;

    /* renamed from: j */
    public final boolean f3487j;

    /* renamed from: k */
    public final boolean f3488k;

    /* renamed from: l */
    public final boolean f3489l;

    /* renamed from: m */
    private final Set<Integer> f3490m;

    public C1106a(Context context, String str, C0814c.C0818c cVar, C1138i.C1142d dVar, List<C1138i.C1140b> list, boolean z, C1138i.C1141c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set) {
        this.f3478a = cVar;
        this.f3479b = context;
        this.f3480c = str;
        this.f3481d = dVar;
        this.f3482e = list;
        this.f3483f = z;
        this.f3484g = cVar2;
        this.f3485h = executor;
        this.f3486i = executor2;
        this.f3487j = z2;
        this.f3488k = z3;
        this.f3489l = z4;
        this.f3490m = set;
    }

    /* renamed from: a */
    public boolean mo6105a(int i, int i2) {
        Set<Integer> set;
        return (!(i > i2) || !this.f3489l) && this.f3488k && ((set = this.f3490m) == null || !set.contains(Integer.valueOf(i)));
    }
}
