package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.app.e */
public final class C0504e {

    /* renamed from: androidx.core.app.e$a */
    static class C0505a {

        /* renamed from: a */
        private static Method f1949a;

        /* renamed from: b */
        private static boolean f1950b;

        /* renamed from: c */
        private static Method f1951c;

        /* renamed from: d */
        private static boolean f1952d;

        /* renamed from: a */
        public static IBinder m1974a(Bundle bundle, String str) {
            if (!f1950b) {
                try {
                    f1949a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f1949a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f1950b = true;
            }
            Method method = f1949a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f1949a = null;
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m1975a(Bundle bundle, String str, IBinder iBinder) {
            if (!f1952d) {
                try {
                    f1951c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f1951c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                f1952d = true;
            }
            Method method = f1951c;
            if (method != null) {
                try {
                    method.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    f1951c = null;
                }
            }
        }
    }

    /* renamed from: a */
    public static IBinder m1972a(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : C0505a.m1974a(bundle, str);
    }

    /* renamed from: a */
    public static void m1973a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C0505a.m1975a(bundle, str, iBinder);
        }
    }
}
