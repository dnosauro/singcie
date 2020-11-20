package androidx.work;

import androidx.work.C1192e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OverwritingInputMerger extends C1195g {
    /* renamed from: a */
    public C1192e mo6327a(List<C1192e> list) {
        C1192e.C1193a aVar = new C1192e.C1193a();
        HashMap hashMap = new HashMap();
        for (C1192e a : list) {
            hashMap.putAll(a.mo6408a());
        }
        aVar.mo6415a((Map<String, Object>) hashMap);
        return aVar.mo6416a();
    }
}
