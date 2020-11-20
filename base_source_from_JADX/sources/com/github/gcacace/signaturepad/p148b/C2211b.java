package com.github.gcacace.signaturepad.p148b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewTreeObserver;

/* renamed from: com.github.gcacace.signaturepad.b.b */
public class C2211b {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m8653a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
