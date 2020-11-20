package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: androidx.core.app.l */
public final class C0519l {

    /* renamed from: a */
    private static final Object f2033a = new Object();

    /* renamed from: b */
    private static Set<String> f2034b = new HashSet();

    /* renamed from: e */
    private static final Object f2035e = new Object();

    /* renamed from: c */
    private final Context f2036c;

    /* renamed from: d */
    private final NotificationManager f2037d = ((NotificationManager) this.f2036c.getSystemService("notification"));

    private C0519l(Context context) {
        this.f2036c = context;
    }

    /* renamed from: a */
    public static C0519l m2052a(Context context) {
        return new C0519l(context);
    }

    /* renamed from: a */
    public boolean mo3487a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f2037d.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2036c.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2036c.getApplicationInfo();
        String packageName = this.f2036c.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
