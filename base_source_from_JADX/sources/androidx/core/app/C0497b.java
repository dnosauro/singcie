package androidx.core.app;

import android.app.ActivityManager;
import android.os.Build;

/* renamed from: androidx.core.app.b */
public final class C0497b {
    /* renamed from: a */
    public static boolean m1960a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }
}
