package androidx.p043h.p044a;

import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0972v;
import androidx.p043h.p045b.C0802a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.h.a.a */
public abstract class C0795a {

    /* renamed from: androidx.h.a.a$a */
    public interface C0796a<D> {
        /* renamed from: a */
        void mo4576a(C0802a<D> aVar);

        /* renamed from: a */
        void mo4577a(C0802a<D> aVar, D d);
    }

    /* renamed from: a */
    public static <T extends C0952h & C0972v> C0795a m3295a(T t) {
        return new C0797b(t, ((C0972v) t).getViewModelStore());
    }

    /* renamed from: a */
    public abstract void mo4574a();

    @Deprecated
    /* renamed from: a */
    public abstract void mo4575a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
