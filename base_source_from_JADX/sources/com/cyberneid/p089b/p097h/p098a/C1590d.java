package com.cyberneid.p089b.p097h.p098a;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.b.h.a.d */
public abstract class C1590d implements C1588b {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String[] mo7398a();

    /* renamed from: b */
    public List<File> mo7399b() {
        ArrayList arrayList = new ArrayList();
        String[] a = mo7398a();
        if (a != null) {
            for (String file : a) {
                File file2 = new File(file);
                if (file2.exists() && file2.canRead()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }
}
