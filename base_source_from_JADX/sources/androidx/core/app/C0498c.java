package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: androidx.core.app.c */
final class C0498c {

    /* renamed from: a */
    protected static final Class<?> f1931a = m1969d();

    /* renamed from: b */
    protected static final Field f1932b = m1965b();

    /* renamed from: c */
    protected static final Field f1933c = m1967c();

    /* renamed from: d */
    protected static final Method f1934d = m1961a(f1931a);

    /* renamed from: e */
    protected static final Method f1935e = m1966b(f1931a);

    /* renamed from: f */
    protected static final Method f1936f = m1968c(f1931a);

    /* renamed from: g */
    private static final Handler f1937g = new Handler(Looper.getMainLooper());

    /* renamed from: androidx.core.app.c$a */
    private static final class C0502a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        Object f1944a;

        /* renamed from: b */
        private Activity f1945b;

        /* renamed from: c */
        private boolean f1946c = false;

        /* renamed from: d */
        private boolean f1947d = false;

        /* renamed from: e */
        private boolean f1948e = false;

        C0502a(Activity activity) {
            this.f1945b = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f1945b == activity) {
                this.f1945b = null;
                this.f1947d = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1947d && !this.f1948e && !this.f1946c && C0498c.m1964a(this.f1944a, activity)) {
                this.f1948e = true;
                this.f1944a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f1945b == activity) {
                this.f1946c = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: a */
    private static Method m1961a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m1962a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    /* renamed from: a */
    static boolean m1963a(Activity activity) {
        Object obj;
        final Application application;
        final C0502a aVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (m1962a() && f1936f == null) {
            return false;
        } else {
            if (f1935e == null && f1934d == null) {
                return false;
            }
            try {
                final Object obj2 = f1933c.get(activity);
                if (obj2 == null || (obj = f1932b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                aVar = new C0502a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                f1937g.post(new Runnable() {
                    public void run() {
                        aVar.f1944a = obj2;
                    }
                });
                if (m1962a()) {
                    f1936f.invoke(obj, new Object[]{obj2, null, null, 0, false, null, null, false, false});
                } else {
                    activity.recreate();
                }
                f1937g.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* renamed from: a */
    protected static boolean m1964a(Object obj, Activity activity) {
        try {
            final Object obj2 = f1933c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = f1932b.get(activity);
            f1937g.postAtFrontOfQueue(new Runnable() {
                public void run() {
                    try {
                        if (C0498c.f1934d != null) {
                            C0498c.f1934d.invoke(obj3, new Object[]{obj2, false, "AppCompat recreation"});
                            return;
                        }
                        C0498c.f1935e.invoke(obj3, new Object[]{obj2, false});
                    } catch (RuntimeException e) {
                        if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* renamed from: b */
    private static Field m1965b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static Method m1966b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static Field m1967c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static Method m1968c(Class<?> cls) {
        if (m1962a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: d */
    private static Class<?> m1969d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
