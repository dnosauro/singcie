package androidx.p035e.p037b;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: androidx.e.b.b */
class C0718b {

    /* renamed from: androidx.e.b.b$a */
    public interface C0719a<T> {
        /* renamed from: a */
        void mo4020a(T t, Rect rect);
    }

    /* renamed from: androidx.e.b.b$b */
    public interface C0720b<T, V> {
        /* renamed from: a */
        int mo4022a(T t);

        /* renamed from: a */
        V mo4024a(T t, int i);
    }

    /* renamed from: androidx.e.b.b$c */
    private static class C0721c<T> implements Comparator<T> {

        /* renamed from: a */
        private final Rect f2463a = new Rect();

        /* renamed from: b */
        private final Rect f2464b = new Rect();

        /* renamed from: c */
        private final boolean f2465c;

        /* renamed from: d */
        private final C0719a<T> f2466d;

        C0721c(boolean z, C0719a<T> aVar) {
            this.f2465c = z;
            this.f2466d = aVar;
        }

        public int compare(T t, T t2) {
            Rect rect = this.f2463a;
            Rect rect2 = this.f2464b;
            this.f2466d.mo4020a(t, rect);
            this.f2466d.mo4020a(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                return this.f2465c ? 1 : -1;
            }
            if (rect.left > rect2.left) {
                return this.f2465c ? -1 : 1;
            }
            if (rect.bottom < rect2.bottom) {
                return -1;
            }
            if (rect.bottom > rect2.bottom) {
                return 1;
            }
            if (rect.right < rect2.right) {
                return this.f2465c ? 1 : -1;
            }
            if (rect.right > rect2.right) {
                return this.f2465c ? -1 : 1;
            }
            return 0;
        }
    }

    /* renamed from: a */
    private static int m2876a(int i, int i2) {
        return (i * 13 * i) + (i2 * i2);
    }

    /* renamed from: a */
    public static <L, T> T m2877a(L l, C0720b<L, T> bVar, C0719a<T> aVar, T t, int i, boolean z, boolean z2) {
        int a = bVar.mo4022a(l);
        ArrayList arrayList = new ArrayList(a);
        for (int i2 = 0; i2 < a; i2++) {
            arrayList.add(bVar.mo4024a(l, i2));
        }
        Collections.sort(arrayList, new C0721c(z, aVar));
        switch (i) {
            case 1:
                return m2883b(t, arrayList, z2);
            case 2:
                return m2879a(t, arrayList, z2);
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <L, T> T m2878a(L r7, androidx.p035e.p037b.C0718b.C0720b<L, T> r8, androidx.p035e.p037b.C0718b.C0719a<T> r9, T r10, android.graphics.Rect r11, int r12) {
        /*
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r11)
            r1 = 17
            r2 = 0
            if (r12 == r1) goto L_0x0038
            r1 = 33
            if (r12 == r1) goto L_0x002e
            r1 = 66
            if (r12 == r1) goto L_0x0026
            r1 = 130(0x82, float:1.82E-43)
            if (r12 != r1) goto L_0x001e
            int r1 = r11.height()
            int r1 = r1 + 1
            int r1 = -r1
            goto L_0x0034
        L_0x001e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r7.<init>(r8)
            throw r7
        L_0x0026:
            int r1 = r11.width()
            int r1 = r1 + 1
            int r1 = -r1
            goto L_0x003e
        L_0x002e:
            int r1 = r11.height()
            int r1 = r1 + 1
        L_0x0034:
            r0.offset(r2, r1)
            goto L_0x0041
        L_0x0038:
            int r1 = r11.width()
            int r1 = r1 + 1
        L_0x003e:
            r0.offset(r1, r2)
        L_0x0041:
            r1 = 0
            int r3 = r8.mo4022a(r7)
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
        L_0x004b:
            if (r2 >= r3) goto L_0x0064
            java.lang.Object r5 = r8.mo4024a(r7, r2)
            if (r5 != r10) goto L_0x0054
            goto L_0x0061
        L_0x0054:
            r9.mo4020a(r5, r4)
            boolean r6 = m2881a(r12, r11, r4, r0)
            if (r6 == 0) goto L_0x0061
            r0.set(r4)
            r1 = r5
        L_0x0061:
            int r2 = r2 + 1
            goto L_0x004b
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p035e.p037b.C0718b.m2878a(java.lang.Object, androidx.e.b.b$b, androidx.e.b.b$a, java.lang.Object, android.graphics.Rect, int):java.lang.Object");
    }

    /* renamed from: a */
    private static <T> T m2879a(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int lastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    /* renamed from: a */
    private static boolean m2880a(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* renamed from: a */
    private static boolean m2881a(int i, Rect rect, Rect rect2, Rect rect3) {
        if (!m2882a(rect, rect2, i)) {
            return false;
        }
        if (m2882a(rect, rect3, i) && !m2885b(i, rect, rect2, rect3)) {
            return !m2885b(i, rect, rect3, rect2) && m2876a(m2886c(i, rect, rect2), m2890g(i, rect, rect2)) < m2876a(m2886c(i, rect, rect3), m2890g(i, rect, rect3));
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m2882a(Rect rect, Rect rect2, int i) {
        if (i == 17) {
            return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
        }
        if (i == 33) {
            return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
        }
        if (i == 66) {
            return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
        }
        if (i == 130) {
            return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: b */
    private static <T> T m2883b(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int indexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* renamed from: b */
    private static boolean m2884b(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        }
        if (i == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i == 66) {
            return rect.right <= rect2.left;
        }
        if (i == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: b */
    private static boolean m2885b(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean a = m2880a(i, rect, rect2);
        if (m2880a(i, rect, rect3) || !a) {
            return false;
        }
        return !m2884b(i, rect, rect3) || i == 17 || i == 66 || m2886c(i, rect, rect2) < m2888e(i, rect, rect3);
    }

    /* renamed from: c */
    private static int m2886c(int i, Rect rect, Rect rect2) {
        return Math.max(0, m2887d(i, rect, rect2));
    }

    /* renamed from: d */
    private static int m2887d(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    /* renamed from: e */
    private static int m2888e(int i, Rect rect, Rect rect2) {
        return Math.max(1, m2889f(i, rect, rect2));
    }

    /* renamed from: f */
    private static int m2889f(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (i == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect2.bottom;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    /* renamed from: g */
    private static int m2890g(int i, Rect rect, Rect rect2) {
        int height;
        int i2;
        int height2;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = rect.left + (rect.width() / 2);
            i2 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - (i2 + (height2 / 2)));
        }
        height = rect.top + (rect.height() / 2);
        i2 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - (i2 + (height2 / 2)));
    }
}
