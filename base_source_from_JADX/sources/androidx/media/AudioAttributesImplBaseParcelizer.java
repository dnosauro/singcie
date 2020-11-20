package androidx.media;

import androidx.versionedparcelable.C1156a;

public final class AudioAttributesImplBaseParcelizer {
    public static C0977c read(C1156a aVar) {
        C0977c cVar = new C0977c();
        cVar.f3124a = aVar.mo6231b(cVar.f3124a, 1);
        cVar.f3125b = aVar.mo6231b(cVar.f3125b, 2);
        cVar.f3126c = aVar.mo6231b(cVar.f3126c, 3);
        cVar.f3127d = aVar.mo6231b(cVar.f3127d, 4);
        return cVar;
    }

    public static void write(C0977c cVar, C1156a aVar) {
        aVar.mo6227a(false, false);
        aVar.mo6215a(cVar.f3124a, 1);
        aVar.mo6215a(cVar.f3125b, 2);
        aVar.mo6215a(cVar.f3126c, 3);
        aVar.mo6215a(cVar.f3127d, 4);
    }
}
