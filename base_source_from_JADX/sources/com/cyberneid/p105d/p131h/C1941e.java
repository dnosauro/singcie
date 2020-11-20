package com.cyberneid.p105d.p131h;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.h.e */
public class C1941e {

    /* renamed from: a */
    public static C1942a f6142a = C1942a.MINIMUM;

    /* renamed from: b */
    private static Context f6143b;

    /* renamed from: c */
    private static AssetManager f6144c = null;

    /* renamed from: d */
    private static boolean f6145d = false;

    /* renamed from: com.cyberneid.d.h.e$a */
    public enum C1942a {
        FULL,
        MINIMUM,
        NONE
    }

    /* renamed from: a */
    public static InputStream m7993a(String str) {
        return f6144c.open(str);
    }

    /* renamed from: a */
    public static void m7994a(Context context) {
        if (f6143b == null) {
            f6143b = context.getApplicationContext();
            f6144c = f6143b.getAssets();
        }
    }

    /* renamed from: a */
    public static boolean m7995a() {
        if (f6144c == null && !f6145d) {
            Log.w("PdfBox-Android", "Call PDFBoxResourceLoader.init() first to decrease resource load time");
            f6145d = true;
        }
        return f6144c != null;
    }
}
