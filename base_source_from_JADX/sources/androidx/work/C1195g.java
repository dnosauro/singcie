package androidx.work;

import java.util.List;

/* renamed from: androidx.work.g */
public abstract class C1195g {

    /* renamed from: a */
    private static final String f3760a = C1196h.m4737a("InputMerger");

    /* renamed from: a */
    public static C1195g m4734a(String str) {
        try {
            return (C1195g) Class.forName(str).newInstance();
        } catch (Exception e) {
            C1196h a = C1196h.m4736a();
            String str2 = f3760a;
            a.mo6421e(str2, "Trouble instantiating + " + str, e);
            return null;
        }
    }

    /* renamed from: a */
    public abstract C1192e mo6327a(List<C1192e> list);
}
