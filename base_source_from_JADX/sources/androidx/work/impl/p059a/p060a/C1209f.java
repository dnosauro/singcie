package androidx.work.impl.p059a.p060a;

import android.content.Context;
import android.os.Build;
import androidx.work.C1196h;
import androidx.work.C1198i;
import androidx.work.impl.p059a.C1212b;
import androidx.work.impl.p059a.p061b.C1223g;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.utils.p065b.C1311a;

/* renamed from: androidx.work.impl.a.a.f */
public class C1209f extends C1205c<C1212b> {

    /* renamed from: a */
    private static final String f3782a = C1196h.m4737a("NetworkNotRoamingCtrlr");

    public C1209f(Context context, C1311a aVar) {
        super(C1223g.m4848a(context, aVar).mo6477c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6437b(C1212b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return !bVar.mo6450a() || !bVar.mo6453d();
        }
        C1196h.m4736a().mo6418b(f3782a, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !bVar.mo6450a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6435a(C1240j jVar) {
        return jVar.f3846j.mo6377a() == C1198i.NOT_ROAMING;
    }
}
