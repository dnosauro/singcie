package com.cyberneid.p089b.p097h.p098a;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.b.h.a.c */
public class C1589c {

    /* renamed from: a */
    private C1588b f4832a = null;

    /* renamed from: a */
    private void m6279a(File file, List<URI> list) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (!file2.getName().startsWith(".")) {
                        m6279a(file2, list);
                    }
                } else if (m6280a(file2)) {
                    list.add(file2.toURI());
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m6280a(File file) {
        String lowerCase = file.getName().toLowerCase();
        return lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf") || lowerCase.endsWith(".pfb") || lowerCase.endsWith(".ttc");
    }

    /* renamed from: b */
    private C1588b m6281b() {
        return System.getProperty("java.vendor").equals("The Android Project") ? new C1587a() : new C1591e();
    }

    /* renamed from: a */
    public List<URI> mo7400a() {
        if (this.f4832a == null) {
            this.f4832a = m6281b();
        }
        List<File> b = this.f4832a.mo7399b();
        ArrayList arrayList = new ArrayList();
        for (File a : b) {
            m6279a(a, arrayList);
        }
        return arrayList;
    }
}
