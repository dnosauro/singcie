package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.i */
public abstract class C1647i {
    protected C1647i() {
    }

    /* renamed from: a */
    protected static C1607d m6599a(C1607d dVar, int i) {
        C1605b a = dVar.mo7513a(C1613i.f5003bf, C1613i.f4984bM);
        if (a instanceof C1607d) {
            return (C1607d) a;
        }
        if (a instanceof C1604a) {
            C1604a aVar = (C1604a) a;
            if (i < aVar.mo7494b()) {
                return (C1607d) aVar.mo7485a(i);
            }
        } else if (a != null) {
            Log.e("PdfBox-Android", "Expected DecodeParams to be an Array or Dictionary but found " + a.getClass().getName());
        }
        return new C1607d();
    }

    /* renamed from: a */
    public abstract C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar);

    /* renamed from: b */
    public final void mo7693b(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        mo7658a(inputStream, outputStream, dVar.mo7552i());
    }
}
