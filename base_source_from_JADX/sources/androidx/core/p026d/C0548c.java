package androidx.core.p026d;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* renamed from: androidx.core.d.c */
public class C0548c {
    /* renamed from: a */
    public static boolean m2170a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
        return true;
    }
}
