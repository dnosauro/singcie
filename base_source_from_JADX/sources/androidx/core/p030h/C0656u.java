package androidx.core.p030h;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.C0481a;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.p031a.C0614c;
import androidx.core.p030h.p031a.C0622f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.core.h.u */
public class C0656u {

    /* renamed from: a */
    private static final AtomicInteger f2310a = new AtomicInteger(1);

    /* renamed from: b */
    private static Field f2311b;

    /* renamed from: c */
    private static boolean f2312c;

    /* renamed from: d */
    private static Field f2313d;

    /* renamed from: e */
    private static boolean f2314e;

    /* renamed from: f */
    private static WeakHashMap<View, String> f2315f;

    /* renamed from: g */
    private static WeakHashMap<View, C0668y> f2316g = null;

    /* renamed from: h */
    private static Field f2317h;

    /* renamed from: i */
    private static boolean f2318i = false;

    /* renamed from: j */
    private static ThreadLocal<Rect> f2319j;

    /* renamed from: k */
    private static final int[] f2320k = {C0481a.C0484c.accessibility_custom_action_0, C0481a.C0484c.accessibility_custom_action_1, C0481a.C0484c.accessibility_custom_action_2, C0481a.C0484c.accessibility_custom_action_3, C0481a.C0484c.accessibility_custom_action_4, C0481a.C0484c.accessibility_custom_action_5, C0481a.C0484c.accessibility_custom_action_6, C0481a.C0484c.accessibility_custom_action_7, C0481a.C0484c.accessibility_custom_action_8, C0481a.C0484c.accessibility_custom_action_9, C0481a.C0484c.accessibility_custom_action_10, C0481a.C0484c.accessibility_custom_action_11, C0481a.C0484c.accessibility_custom_action_12, C0481a.C0484c.accessibility_custom_action_13, C0481a.C0484c.accessibility_custom_action_14, C0481a.C0484c.accessibility_custom_action_15, C0481a.C0484c.accessibility_custom_action_16, C0481a.C0484c.accessibility_custom_action_17, C0481a.C0484c.accessibility_custom_action_18, C0481a.C0484c.accessibility_custom_action_19, C0481a.C0484c.accessibility_custom_action_20, C0481a.C0484c.accessibility_custom_action_21, C0481a.C0484c.accessibility_custom_action_22, C0481a.C0484c.accessibility_custom_action_23, C0481a.C0484c.accessibility_custom_action_24, C0481a.C0484c.accessibility_custom_action_25, C0481a.C0484c.accessibility_custom_action_26, C0481a.C0484c.accessibility_custom_action_27, C0481a.C0484c.accessibility_custom_action_28, C0481a.C0484c.accessibility_custom_action_29, C0481a.C0484c.accessibility_custom_action_30, C0481a.C0484c.accessibility_custom_action_31};

    /* renamed from: l */
    private static C0661a f2321l = new C0661a();

    /* renamed from: androidx.core.h.u$a */
    static class C0661a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private WeakHashMap<View, Boolean> f2323a = new WeakHashMap<>();

        C0661a() {
        }

        /* renamed from: a */
        private void m2662a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        /* renamed from: a */
        private void m2663a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    C0656u.m2622g(view, 16);
                }
                this.f2323a.put(view, Boolean.valueOf(z2));
            }
        }

        public void onGlobalLayout() {
            for (Map.Entry next : this.f2323a.entrySet()) {
                m2663a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
            }
        }

        public void onViewAttachedToWindow(View view) {
            m2662a(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: androidx.core.h.u$b */
    static abstract class C0662b<T> {

        /* renamed from: a */
        private final int f2324a;

        /* renamed from: b */
        private final Class<T> f2325b;

        /* renamed from: c */
        private final int f2326c;

        C0662b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        C0662b(int i, Class<T> cls, int i2, int i3) {
            this.f2324a = i;
            this.f2325b = cls;
            this.f2326c = i3;
        }

        /* renamed from: a */
        private boolean m2664a() {
            return Build.VERSION.SDK_INT >= this.f2326c;
        }

        /* renamed from: b */
        private boolean m2665b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo3825a(View view, T t);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3827a(T t, T t2) {
            return !t2.equals(t);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract T mo3828b(View view);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3838b(View view, T t) {
            if (m2664a()) {
                mo3825a(view, t);
            } else if (m2665b() && mo3827a(mo3840c(view), (Object) t)) {
                C0656u.m2609c(view);
                view.setTag(this.f2324a, t);
                C0656u.m2622g(view, 0);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo3839b(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public T mo3840c(View view) {
            if (m2664a()) {
                return mo3828b(view);
            }
            if (!m2665b()) {
                return null;
            }
            T tag = view.getTag(this.f2324a);
            if (this.f2325b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
    }

    /* renamed from: androidx.core.h.u$c */
    public interface C0663c {
        /* renamed from: a */
        boolean mo3841a(View view, KeyEvent keyEvent);
    }

    /* renamed from: androidx.core.h.u$d */
    static class C0664d {

        /* renamed from: a */
        private static final ArrayList<WeakReference<View>> f2327a = new ArrayList<>();

        /* renamed from: b */
        private WeakHashMap<View, Boolean> f2328b = null;

        /* renamed from: c */
        private SparseArray<WeakReference<View>> f2329c = null;

        /* renamed from: d */
        private WeakReference<KeyEvent> f2330d = null;

        C0664d() {
        }

        /* renamed from: a */
        private SparseArray<WeakReference<View>> m2673a() {
            if (this.f2329c == null) {
                this.f2329c = new SparseArray<>();
            }
            return this.f2329c;
        }

        /* renamed from: a */
        static C0664d m2674a(View view) {
            C0664d dVar = (C0664d) view.getTag(C0481a.C0484c.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            C0664d dVar2 = new C0664d();
            view.setTag(C0481a.C0484c.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        /* renamed from: b */
        private View m2675b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2328b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b = m2675b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b != null) {
                            return b;
                        }
                    }
                }
                if (m2677c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        /* renamed from: b */
        private void m2676b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2328b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!f2327a.isEmpty()) {
                synchronized (f2327a) {
                    if (this.f2328b == null) {
                        this.f2328b = new WeakHashMap<>();
                    }
                    for (int size = f2327a.size() - 1; size >= 0; size--) {
                        View view = (View) f2327a.get(size).get();
                        if (view == null) {
                            f2327a.remove(size);
                        } else {
                            this.f2328b.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2328b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: c */
        private boolean m2677c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(C0481a.C0484c.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((C0663c) arrayList.get(size)).mo3841a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3842a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f2330d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f2330d = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> a = m2673a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = a.valueAt(indexOfKey);
                a.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = a.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && C0656u.m2569B(view)) {
                m2677c(view, keyEvent);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3843a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m2676b();
            }
            View b = m2675b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    m2673a().put(keyCode, new WeakReference(b));
                }
            }
            return b != null;
        }
    }

    /* renamed from: A */
    public static Rect m2568A(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    /* renamed from: B */
    public static boolean m2569B(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    /* renamed from: C */
    public static boolean m2570C(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    /* renamed from: D */
    public static Display m2571D(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (m2569B(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* renamed from: E */
    public static boolean m2572E(View view) {
        Boolean c = m2610c().mo3840c(view);
        if (c == null) {
            return false;
        }
        return c.booleanValue();
    }

    /* renamed from: F */
    public static CharSequence m2573F(View view) {
        return m2613d().mo3840c(view);
    }

    /* renamed from: G */
    public static boolean m2574G(View view) {
        Boolean c = m2616e().mo3840c(view);
        if (c == null) {
            return false;
        }
        return c.booleanValue();
    }

    /* renamed from: H */
    private static View.AccessibilityDelegate m2575H(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : m2576I(view);
    }

    /* renamed from: I */
    private static View.AccessibilityDelegate m2576I(View view) {
        if (f2318i) {
            return null;
        }
        if (f2317h == null) {
            try {
                f2317h = View.class.getDeclaredField("mAccessibilityDelegate");
                f2317h.setAccessible(true);
            } catch (Throwable unused) {
                f2318i = true;
                return null;
            }
        }
        try {
            Object obj = f2317h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2318i = true;
            return null;
        }
    }

    /* renamed from: J */
    private static List<C0614c.C0615a> m2577J(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(C0481a.C0484c.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(C0481a.C0484c.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    /* renamed from: K */
    private static void m2578K(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: a */
    public static int m2579a() {
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i = f2310a.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f2310a.compareAndSet(i, i2));
        return i;
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static int m2580a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    /* renamed from: a */
    public static C0633ac m2581a(View view, C0633ac acVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return acVar;
        }
        WindowInsets h = acVar.mo3791h();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(h);
        if (!onApplyWindowInsets.equals(h)) {
            h = new WindowInsets(onApplyWindowInsets);
        }
        return C0633ac.m2496a(h);
    }

    /* renamed from: a */
    private static void m2582a(int i, View view) {
        List<C0614c.C0615a> J = m2577J(view);
        for (int i2 = 0; i2 < J.size(); i2++) {
            if (J.get(i2).mo3763a() == i) {
                J.remove(i2);
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m2583a(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    /* renamed from: a */
    public static void m2584a(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    /* renamed from: a */
    public static void m2585a(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: a */
    public static void m2586a(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m2587a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof C0655t) {
            ((C0655t) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2588a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof C0655t) {
            ((C0655t) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* renamed from: a */
    public static void m2589a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* renamed from: a */
    public static void m2590a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: a */
    private static void m2591a(View view, C0614c.C0615a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2609c(view);
            m2582a(aVar.mo3763a(), view);
            m2577J(view).add(aVar);
            m2622g(view, 0);
        }
    }

    /* renamed from: a */
    public static void m2592a(View view, C0614c.C0615a aVar, CharSequence charSequence, C0622f fVar) {
        if (fVar == null && charSequence == null) {
            m2611c(view, aVar.mo3763a());
        } else {
            m2591a(view, aVar.mo3764a(charSequence, fVar));
        }
    }

    /* renamed from: a */
    public static void m2593a(View view, C0614c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.mo3703a());
    }

    /* renamed from: a */
    public static void m2594a(View view, C0610a aVar) {
        if (aVar == null && (m2575H(view) instanceof C0610a.C0611a)) {
            aVar = new C0610a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    /* renamed from: a */
    public static void m2595a(View view, final C0652q qVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (qVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return qVar.onApplyWindowInsets(view, C0633ac.m2496a(windowInsets)).mo3791h();
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2596a(View view, C0654s sVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (sVar != null ? sVar.mo3821a() : null));
        }
    }

    /* renamed from: a */
    public static void m2597a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* renamed from: a */
    public static void m2598a(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* renamed from: a */
    public static void m2599a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f2315f == null) {
            f2315f = new WeakHashMap<>();
        }
        f2315f.put(view, str);
    }

    /* renamed from: a */
    public static void m2600a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    /* renamed from: a */
    public static boolean m2601a(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    /* renamed from: a */
    static boolean m2602a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0664d.m2674a(view).mo3842a(keyEvent);
    }

    /* renamed from: b */
    private static Rect m2603b() {
        if (f2319j == null) {
            f2319j = new ThreadLocal<>();
        }
        Rect rect = f2319j.get();
        if (rect == null) {
            rect = new Rect();
            f2319j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* renamed from: b */
    public static C0610a m2604b(View view) {
        View.AccessibilityDelegate H = m2575H(view);
        if (H == null) {
            return null;
        }
        return H instanceof C0610a.C0611a ? ((C0610a.C0611a) H).f2234a : new C0610a(H);
    }

    /* renamed from: b */
    public static C0633ac m2605b(View view, C0633ac acVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return acVar;
        }
        WindowInsets h = acVar.mo3791h();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(h);
        if (!dispatchApplyWindowInsets.equals(h)) {
            h = new WindowInsets(dispatchApplyWindowInsets);
        }
        return C0633ac.m2496a(h);
    }

    /* renamed from: b */
    public static void m2606b(View view, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (i == 4) {
                i = 2;
            }
        }
        view.setImportantForAccessibility(i);
    }

    @Deprecated
    /* renamed from: b */
    public static void m2607b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: b */
    static boolean m2608b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0664d.m2674a(view).mo3843a(view, keyEvent);
    }

    /* renamed from: c */
    static C0610a m2609c(View view) {
        C0610a b = m2604b(view);
        if (b == null) {
            b = new C0610a();
        }
        m2594a(view, b);
        return b;
    }

    /* renamed from: c */
    private static C0662b<Boolean> m2610c() {
        return new C0662b<Boolean>(C0481a.C0484c.tag_screen_reader_focusable, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public Boolean mo3828b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo3825a(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo3827a(Boolean bool, Boolean bool2) {
                return !mo3839b(bool, bool2);
            }
        };
    }

    /* renamed from: c */
    public static void m2611c(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2582a(i, view);
            m2622g(view, 0);
        }
    }

    /* renamed from: c */
    public static void m2612c(View view, boolean z) {
        m2616e().mo3838b(view, Boolean.valueOf(z));
    }

    /* renamed from: d */
    private static C0662b<CharSequence> m2613d() {
        return new C0662b<CharSequence>(C0481a.C0484c.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public CharSequence mo3828b(View view) {
                return view.getAccessibilityPaneTitle();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo3825a(View view, CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo3827a(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    /* renamed from: d */
    public static void m2614d(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    /* renamed from: d */
    public static boolean m2615d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    /* renamed from: e */
    private static C0662b<Boolean> m2616e() {
        return new C0662b<Boolean>(C0481a.C0484c.tag_accessibility_heading, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public Boolean mo3828b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo3825a(View view, Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo3827a(Boolean bool, Boolean bool2) {
                return !mo3839b(bool, bool2);
            }
        };
    }

    /* renamed from: e */
    public static void m2617e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* renamed from: e */
    public static void m2618e(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b = m2603b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m2624h(view, i);
            if (z && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        } else {
            m2624h(view, i);
        }
    }

    /* renamed from: f */
    public static int m2619f(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    /* renamed from: f */
    public static void m2620f(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b = m2603b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m2626i(view, i);
            if (z && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        } else {
            m2626i(view, i);
        }
    }

    /* renamed from: g */
    public static int m2621g(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    /* renamed from: g */
    static void m2622g(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = m2573F(view) != null;
            if (m2623h(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    /* renamed from: h */
    public static int m2623h(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: h */
    private static void m2624h(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            m2578K(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m2578K((View) parent);
            }
        }
    }

    /* renamed from: i */
    public static int m2625i(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    /* renamed from: i */
    private static void m2626i(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            m2578K(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m2578K((View) parent);
            }
        }
    }

    /* renamed from: j */
    public static int m2627j(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    /* renamed from: k */
    public static int m2628k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f2312c) {
            try {
                f2311b = View.class.getDeclaredField("mMinWidth");
                f2311b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2312c = true;
        }
        Field field = f2311b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: l */
    public static int m2629l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f2314e) {
            try {
                f2313d = View.class.getDeclaredField("mMinHeight");
                f2313d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2314e = true;
        }
        Field field = f2313d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: m */
    public static C0668y m2630m(View view) {
        if (f2316g == null) {
            f2316g = new WeakHashMap<>();
        }
        C0668y yVar = f2316g.get(view);
        if (yVar != null) {
            return yVar;
        }
        C0668y yVar2 = new C0668y(view);
        f2316g.put(view, yVar2);
        return yVar2;
    }

    /* renamed from: n */
    public static float m2631n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* renamed from: o */
    public static String m2632o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f2315f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    /* renamed from: p */
    public static int m2633p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* renamed from: q */
    public static void m2634q(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* renamed from: r */
    public static boolean m2635r(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    /* renamed from: s */
    public static boolean m2636s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    /* renamed from: t */
    public static boolean m2637t(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    /* renamed from: u */
    public static ColorStateList m2638u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof C0655t) {
            return ((C0655t) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* renamed from: v */
    public static PorterDuff.Mode m2639v(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof C0655t) {
            return ((C0655t) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* renamed from: w */
    public static boolean m2640w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof C0644i) {
            return ((C0644i) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* renamed from: x */
    public static void m2641x(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof C0644i) {
            ((C0644i) view).stopNestedScroll();
        }
    }

    /* renamed from: y */
    public static boolean m2642y(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: z */
    public static float m2643z(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }
}
