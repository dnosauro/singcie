package androidx.work;

import android.content.Context;
import androidx.work.impl.C1289h;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.work.o */
public abstract class C1337o {
    protected C1337o() {
    }

    /* renamed from: a */
    public static C1337o m5188a(Context context) {
        return C1289h.m5059b(context);
    }

    /* renamed from: a */
    public static void m5189a(Context context, C1185b bVar) {
        C1289h.m5060b(context, bVar);
    }

    /* renamed from: a */
    public final C1326k mo6680a(C1338p pVar) {
        return mo6585a((List<? extends C1338p>) Collections.singletonList(pVar));
    }

    /* renamed from: a */
    public abstract C1326k mo6584a(String str);

    /* renamed from: a */
    public abstract C1326k mo6585a(List<? extends C1338p> list);
}
