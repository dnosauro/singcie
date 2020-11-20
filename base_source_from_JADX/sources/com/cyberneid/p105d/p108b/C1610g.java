package com.cyberneid.p105d.p108b;

import com.cyberneid.p105d.p109c.C1646h;
import com.cyberneid.p105d.p109c.C1647i;
import com.cyberneid.p105d.p111d.C1656c;
import com.cyberneid.p105d.p111d.C1660f;
import com.cyberneid.p105d.p111d.C1661g;
import com.cyberneid.p105d.p111d.C1664j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.d.b.g */
public final class C1610g extends FilterInputStream {

    /* renamed from: a */
    private final List<C1646h> f4884a;

    private C1610g(InputStream inputStream, List<C1646h> list) {
        super(inputStream);
        this.f4884a = list;
    }

    /* renamed from: a */
    static C1610g m6454a(List<C1647i> list, C1607d dVar, InputStream inputStream, C1664j jVar) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (jVar != null) {
                    final C1656c d = jVar.mo7741d();
                    arrayList.add(list.get(i).mo7657a(inputStream, new C1661g(d), dVar, i));
                    inputStream = new C1660f(d) {
                        public void close() {
                            d.close();
                        }
                    };
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    arrayList.add(list.get(i).mo7657a(inputStream, byteArrayOutputStream, dVar, i));
                    inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
            }
        }
        return new C1610g(inputStream, arrayList);
    }
}
