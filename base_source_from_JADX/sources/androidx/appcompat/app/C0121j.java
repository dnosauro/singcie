package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: androidx.appcompat.app.j */
class C0121j {

    /* renamed from: a */
    private static Field f280a;

    /* renamed from: b */
    private static boolean f281b;

    /* renamed from: c */
    private static Class<?> f282c;

    /* renamed from: d */
    private static boolean f283d;

    /* renamed from: e */
    private static Field f284e;

    /* renamed from: f */
    private static boolean f285f;

    /* renamed from: g */
    private static Field f286g;

    /* renamed from: h */
    private static boolean f287h;

    /* renamed from: a */
    static void m273a(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                m277d(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                m276c(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                m275b(resources);
            }
        }
    }

    /* renamed from: a */
    private static void m274a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f283d) {
            try {
                f282c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f283d = true;
        }
        Class<?> cls = f282c;
        if (cls != null) {
            if (!f285f) {
                try {
                    f284e = cls.getDeclaredField("mUnthemedEntries");
                    f284e.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                f285f = true;
            }
            Field field = f284e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    /* renamed from: b */
    private static void m275b(Resources resources) {
        Map map;
        if (!f281b) {
            try {
                f280a = Resources.class.getDeclaredField("mDrawableCache");
                f280a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f281b = true;
        }
        Field field = f280a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: c */
    private static void m276c(Resources resources) {
        if (!f281b) {
            try {
                f280a = Resources.class.getDeclaredField("mDrawableCache");
                f280a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f281b = true;
        }
        Object obj = null;
        Field field = f280a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj != null) {
            m274a(obj);
        }
    }

    /* renamed from: d */
    private static void m277d(Resources resources) {
        Object obj;
        if (!f287h) {
            try {
                f286g = Resources.class.getDeclaredField("mResourcesImpl");
                f286g.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f287h = true;
        }
        Field field = f286g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                obj = null;
            }
            if (obj != null) {
                if (!f281b) {
                    try {
                        f280a = obj.getClass().getDeclaredField("mDrawableCache");
                        f280a.setAccessible(true);
                    } catch (NoSuchFieldException e3) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                    }
                    f281b = true;
                }
                Field field2 = f280a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                    }
                }
                if (obj2 != null) {
                    m274a(obj2);
                }
            }
        }
    }
}
