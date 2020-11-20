package com.github.gcacace.signaturepad.p148b;

import android.os.Build;
import android.view.View;

/* renamed from: com.github.gcacace.signaturepad.b.a */
public class C2210a {
    /* renamed from: a */
    public static boolean m8652a(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }
}
