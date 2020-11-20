package p157d.p161d.p163b;

import p157d.p165f.C3268b;
import p157d.p165f.C3270d;

/* renamed from: d.d.b.l */
public class C3255l {
    /* renamed from: a */
    public C3268b mo25703a(Class cls) {
        return new C3244c(cls);
    }

    /* renamed from: a */
    public C3270d mo25704a(C3249g gVar) {
        return gVar;
    }

    /* renamed from: a */
    public String mo25705a(C3248f fVar) {
        String obj = fVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    /* renamed from: a */
    public String mo25706a(C3251i iVar) {
        return mo25705a((C3248f) iVar);
    }
}
