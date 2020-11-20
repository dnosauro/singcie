package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.C0090b;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.appcompat.view.C0156b;
import androidx.appcompat.view.C0159d;
import androidx.appcompat.view.C0161f;
import androidx.appcompat.view.C0163g;
import androidx.appcompat.view.C0168i;
import androidx.appcompat.view.menu.C0180e;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.view.menu.C0200n;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0255ad;
import androidx.appcompat.widget.C0261ah;
import androidx.appcompat.widget.C0302ay;
import androidx.appcompat.widget.C0312bd;
import androidx.appcompat.widget.C0313be;
import androidx.appcompat.widget.C0337k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.C0490a;
import androidx.core.app.C0508g;
import androidx.core.p030h.C0631aa;
import androidx.core.p030h.C0633ac;
import androidx.core.p030h.C0638d;
import androidx.core.p030h.C0640e;
import androidx.core.p030h.C0652q;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0668y;
import androidx.core.p030h.C0672z;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0952h;
import androidx.p018c.C0400a;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.appcompat.app.g */
class C0097g extends C0096f implements LayoutInflater.Factory2, C0183g.C0184a {

    /* renamed from: t */
    private static final Map<Class<?>, Integer> f183t = new C0400a();

    /* renamed from: u */
    private static final boolean f184u = (Build.VERSION.SDK_INT < 21);

    /* renamed from: v */
    private static final int[] f185v = {16842836};

    /* renamed from: w */
    private static boolean f186w = true;

    /* renamed from: x */
    private static final boolean f187x;

    /* renamed from: A */
    private C0255ad f188A;

    /* renamed from: B */
    private C0107b f189B;

    /* renamed from: C */
    private C0117j f190C;

    /* renamed from: D */
    private boolean f191D;

    /* renamed from: E */
    private boolean f192E;

    /* renamed from: F */
    private ViewGroup f193F;

    /* renamed from: G */
    private TextView f194G;

    /* renamed from: H */
    private View f195H;

    /* renamed from: I */
    private boolean f196I;

    /* renamed from: J */
    private boolean f197J;

    /* renamed from: K */
    private boolean f198K;

    /* renamed from: L */
    private C0116i[] f199L;

    /* renamed from: M */
    private C0116i f200M;

    /* renamed from: N */
    private boolean f201N;

    /* renamed from: O */
    private boolean f202O;

    /* renamed from: P */
    private boolean f203P;

    /* renamed from: Q */
    private boolean f204Q;

    /* renamed from: R */
    private int f205R;

    /* renamed from: S */
    private int f206S;

    /* renamed from: T */
    private boolean f207T;

    /* renamed from: U */
    private boolean f208U;

    /* renamed from: V */
    private C0112f f209V;

    /* renamed from: W */
    private C0112f f210W;

    /* renamed from: X */
    private final Runnable f211X;

    /* renamed from: Y */
    private boolean f212Y;

    /* renamed from: Z */
    private Rect f213Z;

    /* renamed from: a */
    final Object f214a;

    /* renamed from: aa */
    private Rect f215aa;

    /* renamed from: ab */
    private AppCompatViewInflater f216ab;

    /* renamed from: b */
    final Context f217b;

    /* renamed from: c */
    Window f218c;

    /* renamed from: d */
    final C0095e f219d;

    /* renamed from: e */
    C0086a f220e;

    /* renamed from: f */
    MenuInflater f221f;

    /* renamed from: g */
    C0156b f222g;

    /* renamed from: h */
    ActionBarContextView f223h;

    /* renamed from: i */
    PopupWindow f224i;

    /* renamed from: j */
    Runnable f225j;

    /* renamed from: k */
    C0668y f226k;

    /* renamed from: l */
    boolean f227l;

    /* renamed from: m */
    boolean f228m;

    /* renamed from: n */
    boolean f229n;

    /* renamed from: o */
    boolean f230o;

    /* renamed from: p */
    boolean f231p;

    /* renamed from: q */
    boolean f232q;

    /* renamed from: r */
    boolean f233r;

    /* renamed from: s */
    int f234s;

    /* renamed from: y */
    private C0110d f235y;

    /* renamed from: z */
    private CharSequence f236z;

    /* renamed from: androidx.appcompat.app.g$a */
    private class C0106a implements C0090b.C0091a {
        C0106a() {
        }
    }

    /* renamed from: androidx.appcompat.app.g$b */
    private final class C0107b implements C0198m.C0199a {
        C0107b() {
        }

        /* renamed from: a */
        public void mo914a(C0183g gVar, boolean z) {
            C0097g.this.mo878a(gVar);
        }

        /* renamed from: a */
        public boolean mo915a(C0183g gVar) {
            Window.Callback m = C0097g.this.mo891m();
            if (m == null) {
                return true;
            }
            m.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.g$c */
    class C0108c implements C0156b.C0157a {

        /* renamed from: b */
        private C0156b.C0157a f248b;

        public C0108c(C0156b.C0157a aVar) {
            this.f248b = aVar;
        }

        /* renamed from: a */
        public void mo916a(C0156b bVar) {
            this.f248b.mo916a(bVar);
            if (C0097g.this.f224i != null) {
                C0097g.this.f218c.getDecorView().removeCallbacks(C0097g.this.f225j);
            }
            if (C0097g.this.f223h != null) {
                C0097g.this.mo900r();
                C0097g gVar = C0097g.this;
                gVar.f226k = C0656u.m2630m(gVar.f223h).mo3845a(0.0f);
                C0097g.this.f226k.mo3849a((C0672z) new C0631aa() {
                    /* renamed from: b */
                    public void mo913b(View view) {
                        C0097g.this.f223h.setVisibility(8);
                        if (C0097g.this.f224i != null) {
                            C0097g.this.f224i.dismiss();
                        } else if (C0097g.this.f223h.getParent() instanceof View) {
                            C0656u.m2634q((View) C0097g.this.f223h.getParent());
                        }
                        C0097g.this.f223h.removeAllViews();
                        C0097g.this.f226k.mo3849a((C0672z) null);
                        C0097g.this.f226k = null;
                    }
                });
            }
            if (C0097g.this.f219d != null) {
                C0097g.this.f219d.onSupportActionModeFinished(C0097g.this.f222g);
            }
            C0097g.this.f222g = null;
        }

        /* renamed from: a */
        public boolean mo917a(C0156b bVar, Menu menu) {
            return this.f248b.mo917a(bVar, menu);
        }

        /* renamed from: a */
        public boolean mo918a(C0156b bVar, MenuItem menuItem) {
            return this.f248b.mo918a(bVar, menuItem);
        }

        /* renamed from: b */
        public boolean mo919b(C0156b bVar, Menu menu) {
            return this.f248b.mo919b(bVar, menu);
        }
    }

    /* renamed from: androidx.appcompat.app.g$d */
    class C0110d extends C0168i {
        C0110d(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final ActionMode mo920a(ActionMode.Callback callback) {
            C0161f.C0162a aVar = new C0161f.C0162a(C0097g.this.f217b, callback);
            C0156b a = C0097g.this.mo848a((C0156b.C0157a) aVar);
            if (a != null) {
                return aVar.mo1165b(a);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C0097g.this.mo880a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || C0097g.this.mo879a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0183g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            C0097g.this.mo885f(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            C0097g.this.mo884e(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0183g gVar = menu instanceof C0183g ? (C0183g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0116i a = C0097g.this.mo873a(0, true);
            if (!(a == null || a.f268j == null)) {
                menu = a.f268j;
            }
            super.onProvideKeyboardShortcuts(list, menu, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return C0097g.this.mo899q() ? mo920a(callback) : super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (!C0097g.this.mo899q() || i != 0) ? super.onWindowStartingActionMode(callback, i) : mo920a(callback);
        }
    }

    /* renamed from: androidx.appcompat.app.g$e */
    private class C0111e extends C0112f {

        /* renamed from: c */
        private final PowerManager f252c;

        C0111e(Context context) {
            super();
            this.f252c = (PowerManager) context.getSystemService("power");
        }

        /* renamed from: a */
        public int mo931a() {
            return (Build.VERSION.SDK_INT < 21 || !this.f252c.isPowerSaveMode()) ? 1 : 2;
        }

        /* renamed from: b */
        public void mo932b() {
            C0097g.this.mo903u();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public IntentFilter mo933c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    /* renamed from: androidx.appcompat.app.g$f */
    abstract class C0112f {

        /* renamed from: a */
        private BroadcastReceiver f253a;

        C0112f() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract int mo931a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract void mo932b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract IntentFilter mo933c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo934d() {
            mo935e();
            IntentFilter c = mo933c();
            if (c != null && c.countActions() != 0) {
                if (this.f253a == null) {
                    this.f253a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            C0112f.this.mo932b();
                        }
                    };
                }
                C0097g.this.f217b.registerReceiver(this.f253a, c);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo935e() {
            if (this.f253a != null) {
                try {
                    C0097g.this.f217b.unregisterReceiver(this.f253a);
                } catch (IllegalArgumentException unused) {
                }
                this.f253a = null;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.g$g */
    private class C0114g extends C0112f {

        /* renamed from: c */
        private final C0129m f257c;

        C0114g(C0129m mVar) {
            super();
            this.f257c = mVar;
        }

        /* renamed from: a */
        public int mo931a() {
            return this.f257c.mo967a() ? 2 : 1;
        }

        /* renamed from: b */
        public void mo932b() {
            C0097g.this.mo903u();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public IntentFilter mo933c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    /* renamed from: androidx.appcompat.app.g$h */
    private class C0115h extends ContentFrameLayout {
        public C0115h(Context context) {
            super(context);
        }

        /* renamed from: a */
        private boolean m266a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C0097g.this.mo880a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m266a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            C0097g.this.mo886g(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0070a.m63b(getContext(), i));
        }
    }

    /* renamed from: androidx.appcompat.app.g$i */
    protected static final class C0116i {

        /* renamed from: a */
        int f259a;

        /* renamed from: b */
        int f260b;

        /* renamed from: c */
        int f261c;

        /* renamed from: d */
        int f262d;

        /* renamed from: e */
        int f263e;

        /* renamed from: f */
        int f264f;

        /* renamed from: g */
        ViewGroup f265g;

        /* renamed from: h */
        View f266h;

        /* renamed from: i */
        View f267i;

        /* renamed from: j */
        C0183g f268j;

        /* renamed from: k */
        C0180e f269k;

        /* renamed from: l */
        Context f270l;

        /* renamed from: m */
        boolean f271m;

        /* renamed from: n */
        boolean f272n;

        /* renamed from: o */
        boolean f273o;

        /* renamed from: p */
        public boolean f274p;

        /* renamed from: q */
        boolean f275q = false;

        /* renamed from: r */
        boolean f276r;

        /* renamed from: s */
        Bundle f277s;

        C0116i(int i) {
            this.f259a = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0200n mo940a(C0198m.C0199a aVar) {
            if (this.f268j == null) {
                return null;
            }
            if (this.f269k == null) {
                this.f269k = new C0180e(this.f270l, C0059a.C0066g.abc_list_menu_item_layout);
                this.f269k.setCallback(aVar);
                this.f268j.addMenuPresenter(this.f269k);
            }
            return this.f269k.mo1345a(this.f265g);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo941a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0059a.C0060a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0059a.C0060a.panelMenuListTheme, typedValue, true);
            newTheme.applyStyle(typedValue.resourceId != 0 ? typedValue.resourceId : C0059a.C0068i.Theme_AppCompat_CompactMenu, true);
            C0159d dVar = new C0159d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f270l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(C0059a.C0069j.AppCompatTheme);
            this.f260b = obtainStyledAttributes.getResourceId(C0059a.C0069j.AppCompatTheme_panelBackground, 0);
            this.f264f = obtainStyledAttributes.getResourceId(C0059a.C0069j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo942a(C0183g gVar) {
            C0180e eVar;
            C0183g gVar2 = this.f268j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.removeMenuPresenter(this.f269k);
                }
                this.f268j = gVar;
                if (gVar != null && (eVar = this.f269k) != null) {
                    gVar.addMenuPresenter(eVar);
                }
            }
        }

        /* renamed from: a */
        public boolean mo943a() {
            if (this.f266h == null) {
                return false;
            }
            return this.f267i != null || this.f269k.mo1344a().getCount() > 0;
        }
    }

    /* renamed from: androidx.appcompat.app.g$j */
    private final class C0117j implements C0198m.C0199a {
        C0117j() {
        }

        /* renamed from: a */
        public void mo914a(C0183g gVar, boolean z) {
            C0183g rootMenu = gVar.getRootMenu();
            boolean z2 = rootMenu != gVar;
            C0097g gVar2 = C0097g.this;
            if (z2) {
                gVar = rootMenu;
            }
            C0116i a = gVar2.mo874a((Menu) gVar);
            if (a == null) {
                return;
            }
            if (z2) {
                C0097g.this.mo875a(a.f259a, a, rootMenu);
                C0097g.this.mo877a(a, true);
                return;
            }
            C0097g.this.mo877a(a, z);
        }

        /* renamed from: a */
        public boolean mo915a(C0183g gVar) {
            Window.Callback m;
            if (gVar != null || !C0097g.this.f227l || (m = C0097g.this.mo891m()) == null || C0097g.this.f232q) {
                return true;
            }
            m.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25) {
            z = true;
        }
        f187x = z;
        if (f184u && !f186w) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* renamed from: a */
                private boolean m239a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains(AppIntroBaseFragmentKt.ARG_DRAWABLE) || message.contains("Drawable");
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (m239a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    C0097g(Activity activity, C0095e eVar) {
        this(activity, (Window) null, eVar, activity);
    }

    C0097g(Dialog dialog, C0095e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    private C0097g(Context context, Window window, C0095e eVar, Object obj) {
        Integer num;
        C0094d C;
        this.f226k = null;
        this.f191D = true;
        this.f205R = -100;
        this.f211X = new Runnable() {
            public void run() {
                if ((C0097g.this.f234s & 1) != 0) {
                    C0097g.this.mo887h(0);
                }
                if ((C0097g.this.f234s & 4096) != 0) {
                    C0097g.this.mo887h(108);
                }
                C0097g gVar = C0097g.this;
                gVar.f233r = false;
                gVar.f234s = 0;
            }
        };
        this.f217b = context;
        this.f219d = eVar;
        this.f214a = obj;
        if (this.f205R == -100 && (this.f214a instanceof Dialog) && (C = m160C()) != null) {
            this.f205R = C.getDelegate().mo871j();
        }
        if (this.f205R == -100 && (num = f183t.get(this.f214a.getClass())) != null) {
            this.f205R = num.intValue();
            f183t.remove(this.f214a.getClass());
        }
        if (window != null) {
            m165a(window);
        }
        C0337k.m1241a();
    }

    /* renamed from: A */
    private ViewGroup m158A() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f217b.obtainStyledAttributes(C0059a.C0069j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(C0059a.C0069j.AppCompatTheme_windowNoTitle, false)) {
                mo865d(1);
            } else if (obtainStyledAttributes.getBoolean(C0059a.C0069j.AppCompatTheme_windowActionBar, false)) {
                mo865d(108);
            }
            if (obtainStyledAttributes.getBoolean(C0059a.C0069j.AppCompatTheme_windowActionBarOverlay, false)) {
                mo865d(109);
            }
            if (obtainStyledAttributes.getBoolean(C0059a.C0069j.AppCompatTheme_windowActionModeOverlay, false)) {
                mo865d(10);
            }
            this.f230o = obtainStyledAttributes.getBoolean(C0059a.C0069j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            m183y();
            this.f218c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f217b);
            if (this.f231p) {
                viewGroup = (ViewGroup) from.inflate(this.f229n ? C0059a.C0066g.abc_screen_simple_overlay_action_mode : C0059a.C0066g.abc_screen_simple, (ViewGroup) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    C0656u.m2595a((View) viewGroup, (C0652q) new C0652q() {
                        public C0633ac onApplyWindowInsets(View view, C0633ac acVar) {
                            int b = acVar.mo3784b();
                            int i = C0097g.this.mo888i(b);
                            if (b != i) {
                                acVar = acVar.mo3783a(acVar.mo3782a(), i, acVar.mo3785c(), acVar.mo3786d());
                            }
                            return C0656u.m2581a(view, acVar);
                        }
                    });
                } else {
                    ((C0261ah) viewGroup).setOnFitSystemWindowsListener(new C0261ah.C0262a() {
                        /* renamed from: a */
                        public void mo908a(Rect rect) {
                            rect.top = C0097g.this.mo888i(rect.top);
                        }
                    });
                }
            } else if (this.f230o) {
                viewGroup = (ViewGroup) from.inflate(C0059a.C0066g.abc_dialog_title_material, (ViewGroup) null);
                this.f228m = false;
                this.f227l = false;
            } else if (this.f227l) {
                TypedValue typedValue = new TypedValue();
                this.f217b.getTheme().resolveAttribute(C0059a.C0060a.actionBarTheme, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0159d(this.f217b, typedValue.resourceId) : this.f217b).inflate(C0059a.C0066g.abc_screen_toolbar, (ViewGroup) null);
                this.f188A = (C0255ad) viewGroup.findViewById(C0059a.C0065f.decor_content_parent);
                this.f188A.setWindowCallback(mo891m());
                if (this.f228m) {
                    this.f188A.mo1688a(109);
                }
                if (this.f196I) {
                    this.f188A.mo1688a(2);
                }
                if (this.f197J) {
                    this.f188A.mo1688a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.f188A == null) {
                    this.f194G = (TextView) viewGroup.findViewById(C0059a.C0065f.title);
                }
                C0313be.m1164b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0059a.C0065f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f218c.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f218c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.C0222a() {
                    /* renamed from: a */
                    public void mo909a() {
                    }

                    /* renamed from: b */
                    public void mo910b() {
                        C0097g.this.mo902t();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f227l + ", windowActionBarOverlay: " + this.f228m + ", android:windowIsFloating: " + this.f230o + ", windowActionModeOverlay: " + this.f229n + ", windowNoTitle: " + this.f231p + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: B */
    private void m159B() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f193F.findViewById(16908290);
        View decorView = this.f218c.getDecorView();
        contentFrameLayout.mo1818a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f217b.obtainStyledAttributes(C0059a.C0069j.AppCompatTheme);
        obtainStyledAttributes.getValue(C0059a.C0069j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0059a.C0069j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0059a.C0069j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0059a.C0069j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0059a.C0069j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0059a.C0069j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: C */
    private C0094d m160C() {
        Context context = this.f217b;
        while (context != null) {
            if (!(context instanceof C0094d)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (C0094d) context;
            }
        }
        return null;
    }

    /* renamed from: D */
    private void m161D() {
        if (this.f192E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: E */
    private int m162E() {
        int i = this.f205R;
        return i != -100 ? i : m132k();
    }

    /* renamed from: F */
    private C0112f m163F() {
        if (this.f210W == null) {
            this.f210W = new C0111e(this.f217b);
        }
        return this.f210W;
    }

    /* renamed from: G */
    private boolean m164G() {
        if (!this.f208U && (this.f214a instanceof Activity)) {
            PackageManager packageManager = this.f217b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f217b, this.f214a.getClass()), 0);
                this.f207T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.f207T = false;
            }
        }
        this.f208U = true;
        return this.f207T;
    }

    /* renamed from: a */
    private void m165a(Window window) {
        if (this.f218c == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof C0110d)) {
                this.f235y = new C0110d(callback);
                window.setCallback(this.f235y);
                C0302ay a = C0302ay.m1077a(this.f217b, (AttributeSet) null, f185v);
                Drawable b = a.mo2414b(0);
                if (b != null) {
                    window.setBackgroundDrawable(b);
                }
                a.mo2410a();
                this.f218c = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: a */
    private void m166a(C0116i iVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!iVar.f273o && !this.f232q) {
            if (iVar.f259a == 0) {
                if ((this.f217b.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback m = mo891m();
            if (m == null || m.onMenuOpened(iVar.f259a, iVar.f268j)) {
                WindowManager windowManager = (WindowManager) this.f217b.getSystemService("window");
                if (windowManager != null && m173b(iVar, keyEvent)) {
                    if (iVar.f265g == null || iVar.f275q) {
                        if (iVar.f265g == null) {
                            if (!m169a(iVar) || iVar.f265g == null) {
                                return;
                            }
                        } else if (iVar.f275q && iVar.f265g.getChildCount() > 0) {
                            iVar.f265g.removeAllViews();
                        }
                        if (m176c(iVar) && iVar.mo943a()) {
                            ViewGroup.LayoutParams layoutParams2 = iVar.f266h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            iVar.f265g.setBackgroundResource(iVar.f260b);
                            ViewParent parent = iVar.f266h.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(iVar.f266h);
                            }
                            iVar.f265g.addView(iVar.f266h, layoutParams2);
                            if (!iVar.f266h.hasFocus()) {
                                iVar.f266h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (!(iVar.f267i == null || (layoutParams = iVar.f267i.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i = -1;
                        iVar.f272n = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, iVar.f262d, iVar.f263e, 1002, 8519680, -3);
                        layoutParams3.gravity = iVar.f261c;
                        layoutParams3.windowAnimations = iVar.f264f;
                        windowManager.addView(iVar.f265g, layoutParams3);
                        iVar.f273o = true;
                        return;
                    }
                    i = -2;
                    iVar.f272n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, iVar.f262d, iVar.f263e, 1002, 8519680, -3);
                    layoutParams32.gravity = iVar.f261c;
                    layoutParams32.windowAnimations = iVar.f264f;
                    windowManager.addView(iVar.f265g, layoutParams32);
                    iVar.f273o = true;
                    return;
                }
                return;
            }
            mo877a(iVar, true);
        }
    }

    /* renamed from: a */
    private void m167a(C0183g gVar, boolean z) {
        C0255ad adVar = this.f188A;
        if (adVar == null || !adVar.mo1696e() || (ViewConfiguration.get(this.f217b).hasPermanentMenuKey() && !this.f188A.mo1699g())) {
            C0116i a = mo873a(0, true);
            a.f275q = true;
            mo877a(a, false);
            m166a(a, (KeyEvent) null);
            return;
        }
        Window.Callback m = mo891m();
        if (this.f188A.mo1697f() && z) {
            this.f188A.mo1707i();
            if (!this.f232q) {
                m.onPanelClosed(108, mo873a(0, true).f268j);
            }
        } else if (m != null && !this.f232q) {
            if (this.f233r && (this.f234s & 1) != 0) {
                this.f218c.getDecorView().removeCallbacks(this.f211X);
                this.f211X.run();
            }
            C0116i a2 = mo873a(0, true);
            if (a2.f268j != null && !a2.f276r && m.onPreparePanel(0, a2.f267i, a2.f268j)) {
                m.onMenuOpened(108, a2.f268j);
                this.f188A.mo1706h();
            }
        }
    }

    /* renamed from: a */
    private boolean m168a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f218c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || C0656u.m2569B((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m169a(C0116i iVar) {
        iVar.mo941a(mo892n());
        iVar.f265g = new C0115h(iVar.f270l);
        iVar.f261c = 81;
        return true;
    }

    /* renamed from: a */
    private boolean m170a(C0116i iVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((iVar.f271m || m173b(iVar, keyEvent)) && iVar.f268j != null) {
            z = iVar.f268j.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f188A == null) {
            mo877a(iVar, true);
        }
        return z;
    }

    /* renamed from: b */
    private boolean m171b(int i, boolean z) {
        int i2;
        int i3 = this.f217b.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        switch (i) {
            case 1:
                i2 = 16;
                break;
            case 2:
                i2 = 32;
                break;
            default:
                i2 = i3;
                break;
        }
        boolean G = m164G();
        boolean z2 = false;
        if ((f187x || i2 != i3) && !G && Build.VERSION.SDK_INT >= 17 && !this.f202O && (this.f214a instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & -49) | i2;
            try {
                ((ContextThemeWrapper) this.f214a).applyOverrideConfiguration(configuration);
                z2 = true;
            } catch (IllegalStateException e) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e);
            }
        }
        int i4 = this.f217b.getResources().getConfiguration().uiMode & 48;
        if (!z2 && i4 != i2 && z && !G && this.f202O && (Build.VERSION.SDK_INT >= 17 || this.f203P)) {
            Object obj = this.f214a;
            if (obj instanceof Activity) {
                C0490a.m1956e((Activity) obj);
                z2 = true;
            }
        }
        if (!z2 && i4 != i2) {
            m175c(i2, G);
            z2 = true;
        }
        if (z2) {
            Object obj2 = this.f214a;
            if (obj2 instanceof C0094d) {
                ((C0094d) obj2).onNightModeChanged(i);
            }
        }
        return z2;
    }

    /* renamed from: b */
    private boolean m172b(C0116i iVar) {
        Context context = this.f217b;
        if ((iVar.f259a == 0 || iVar.f259a == 108) && this.f188A != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(C0059a.C0060a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0059a.C0060a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0059a.C0060a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                C0159d dVar = new C0159d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        C0183g gVar = new C0183g(context);
        gVar.setCallback(this);
        iVar.mo942a(gVar);
        return true;
    }

    /* renamed from: b */
    private boolean m173b(C0116i iVar, KeyEvent keyEvent) {
        C0255ad adVar;
        C0255ad adVar2;
        C0255ad adVar3;
        if (this.f232q) {
            return false;
        }
        if (iVar.f271m) {
            return true;
        }
        C0116i iVar2 = this.f200M;
        if (!(iVar2 == null || iVar2 == iVar)) {
            mo877a(iVar2, false);
        }
        Window.Callback m = mo891m();
        if (m != null) {
            iVar.f267i = m.onCreatePanelView(iVar.f259a);
        }
        boolean z = iVar.f259a == 0 || iVar.f259a == 108;
        if (z && (adVar3 = this.f188A) != null) {
            adVar3.mo1708j();
        }
        if (iVar.f267i == null && (!z || !(mo890l() instanceof C0122k))) {
            if (iVar.f268j == null || iVar.f276r) {
                if (iVar.f268j == null && (!m172b(iVar) || iVar.f268j == null)) {
                    return false;
                }
                if (z && this.f188A != null) {
                    if (this.f189B == null) {
                        this.f189B = new C0107b();
                    }
                    this.f188A.mo1689a(iVar.f268j, this.f189B);
                }
                iVar.f268j.stopDispatchingItemsChanged();
                if (!m.onCreatePanelMenu(iVar.f259a, iVar.f268j)) {
                    iVar.mo942a((C0183g) null);
                    if (z && (adVar2 = this.f188A) != null) {
                        adVar2.mo1689a((Menu) null, this.f189B);
                    }
                    return false;
                }
                iVar.f276r = false;
            }
            iVar.f268j.stopDispatchingItemsChanged();
            if (iVar.f277s != null) {
                iVar.f268j.restoreActionViewStates(iVar.f277s);
                iVar.f277s = null;
            }
            if (!m.onPreparePanel(0, iVar.f267i, iVar.f268j)) {
                if (z && (adVar = this.f188A) != null) {
                    adVar.mo1689a((Menu) null, this.f189B);
                }
                iVar.f268j.startDispatchingItemsChanged();
                return false;
            }
            iVar.f274p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            iVar.f268j.setQwertyMode(iVar.f274p);
            iVar.f268j.startDispatchingItemsChanged();
        }
        iVar.f271m = true;
        iVar.f272n = false;
        this.f200M = iVar;
        return true;
    }

    /* renamed from: b */
    private boolean m174b(boolean z) {
        if (this.f232q) {
            return false;
        }
        int E = m162E();
        boolean b = m171b(mo889j(E), z);
        if (E == 0) {
            mo904v().mo934d();
        } else {
            C0112f fVar = this.f209V;
            if (fVar != null) {
                fVar.mo935e();
            }
        }
        if (E == 3) {
            m163F().mo934d();
        } else {
            C0112f fVar2 = this.f210W;
            if (fVar2 != null) {
                fVar2.mo935e();
            }
        }
        return b;
    }

    /* renamed from: c */
    private void m175c(int i, boolean z) {
        Resources resources = this.f217b.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            C0121j.m273a(resources);
        }
        int i2 = this.f206S;
        if (i2 != 0) {
            this.f217b.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f217b.getTheme().applyStyle(this.f206S, true);
            }
        }
        if (z) {
            Object obj = this.f214a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof C0952h) {
                    if (!((C0952h) activity).getLifecycle().mo5111a().mo5114a(C0947e.C0949b.STARTED)) {
                        return;
                    }
                } else if (!this.f204Q) {
                    return;
                }
                activity.onConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: c */
    private boolean m176c(C0116i iVar) {
        if (iVar.f267i != null) {
            iVar.f266h = iVar.f267i;
            return true;
        } else if (iVar.f268j == null) {
            return false;
        } else {
            if (this.f190C == null) {
                this.f190C = new C0117j();
            }
            iVar.f266h = (View) iVar.mo940a((C0198m.C0199a) this.f190C);
            return iVar.f266h != null;
        }
    }

    /* renamed from: d */
    private boolean m177d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        C0116i a = mo873a(i, true);
        if (!a.f273o) {
            return m173b(a, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m178e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.view.b r0 = r3.f222g
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.g$i r2 = r3.mo873a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.ad r4 = r3.f188A
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.mo1696e()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.f217b
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.ad r4 = r3.f188A
            boolean r4 = r4.mo1697f()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.f232q
            if (r4 != 0) goto L_0x0063
            boolean r4 = r3.m173b((androidx.appcompat.app.C0097g.C0116i) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0063
            androidx.appcompat.widget.ad r4 = r3.f188A
            boolean r4 = r4.mo1706h()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.ad r4 = r3.f188A
            boolean r4 = r4.mo1707i()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.f273o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r2.f272n
            if (r4 == 0) goto L_0x004c
            goto L_0x0065
        L_0x004c:
            boolean r4 = r2.f271m
            if (r4 == 0) goto L_0x0063
            boolean r4 = r2.f276r
            if (r4 == 0) goto L_0x005b
            r2.f271m = r1
            boolean r4 = r3.m173b((androidx.appcompat.app.C0097g.C0116i) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0063
            r3.m166a((androidx.appcompat.app.C0097g.C0116i) r2, (android.view.KeyEvent) r5)
            r4 = 1
            goto L_0x006a
        L_0x0063:
            r4 = 0
            goto L_0x006a
        L_0x0065:
            boolean r4 = r2.f273o
            r3.mo877a((androidx.appcompat.app.C0097g.C0116i) r2, (boolean) r0)
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            android.content.Context r5 = r3.f217b
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007c
            r5.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0097g.m178e(int, android.view.KeyEvent):boolean");
    }

    /* renamed from: k */
    private void m179k(int i) {
        this.f234s = (1 << i) | this.f234s;
        if (!this.f233r) {
            C0656u.m2597a(this.f218c.getDecorView(), this.f211X);
            this.f233r = true;
        }
    }

    /* renamed from: l */
    private int m180l(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m181w() {
        /*
            r3 = this;
            r3.m184z()
            boolean r0 = r3.f227l
            if (r0 == 0) goto L_0x0033
            androidx.appcompat.app.a r0 = r3.f220e
            if (r0 == 0) goto L_0x000c
            goto L_0x0033
        L_0x000c:
            java.lang.Object r0 = r3.f214a
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x001e
            androidx.appcompat.app.n r1 = new androidx.appcompat.app.n
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r2 = r3.f228m
            r1.<init>(r0, r2)
        L_0x001b:
            r3.f220e = r1
            goto L_0x002a
        L_0x001e:
            boolean r1 = r0 instanceof android.app.Dialog
            if (r1 == 0) goto L_0x002a
            androidx.appcompat.app.n r1 = new androidx.appcompat.app.n
            android.app.Dialog r0 = (android.app.Dialog) r0
            r1.<init>(r0)
            goto L_0x001b
        L_0x002a:
            androidx.appcompat.app.a r0 = r3.f220e
            if (r0 == 0) goto L_0x0033
            boolean r1 = r3.f212Y
            r0.mo741d(r1)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0097g.m181w():void");
    }

    /* renamed from: x */
    private void m182x() {
        C0112f fVar = this.f209V;
        if (fVar != null) {
            fVar.mo935e();
        }
        C0112f fVar2 = this.f210W;
        if (fVar2 != null) {
            fVar2.mo935e();
        }
    }

    /* renamed from: y */
    private void m183y() {
        if (this.f218c == null) {
            Object obj = this.f214a;
            if (obj instanceof Activity) {
                m165a(((Activity) obj).getWindow());
            }
        }
        if (this.f218c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* renamed from: z */
    private void m184z() {
        if (!this.f192E) {
            this.f193F = m158A();
            CharSequence o = mo893o();
            if (!TextUtils.isEmpty(o)) {
                C0255ad adVar = this.f188A;
                if (adVar != null) {
                    adVar.setWindowTitle(o);
                } else if (mo890l() != null) {
                    mo890l().mo733a(o);
                } else {
                    TextView textView = this.f194G;
                    if (textView != null) {
                        textView.setText(o);
                    }
                }
            }
            m159B();
            mo876a(this.f193F);
            this.f192E = true;
            C0116i a = mo873a(0, false);
            if (this.f232q) {
                return;
            }
            if (a == null || a.f268j == null) {
                m179k(108);
            }
        }
    }

    /* renamed from: a */
    public View mo872a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        AppCompatViewInflater appCompatViewInflater;
        boolean z2 = false;
        if (this.f216ab == null) {
            String string = this.f217b.obtainStyledAttributes(C0059a.C0069j.AppCompatTheme).getString(C0059a.C0069j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.f216ab = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.f216ab = appCompatViewInflater;
        }
        if (f184u) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = m168a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.f216ab.createView(view, str, context, attributeSet, z, f184u, true, C0312bd.m1159a());
    }

    /* renamed from: a */
    public C0086a mo847a() {
        m181w();
        return this.f220e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0116i mo873a(int i, boolean z) {
        C0116i[] iVarArr = this.f199L;
        if (iVarArr == null || iVarArr.length <= i) {
            C0116i[] iVarArr2 = new C0116i[(i + 1)];
            if (iVarArr != null) {
                System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
            }
            this.f199L = iVarArr2;
            iVarArr = iVarArr2;
        }
        C0116i iVar = iVarArr[i];
        if (iVar != null) {
            return iVar;
        }
        C0116i iVar2 = new C0116i(i);
        iVarArr[i] = iVar2;
        return iVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0116i mo874a(Menu menu) {
        C0116i[] iVarArr = this.f199L;
        int length = iVarArr != null ? iVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0116i iVar = iVarArr[i];
            if (iVar != null && iVar.f268j == menu) {
                return iVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C0156b mo848a(C0156b.C0157a aVar) {
        C0095e eVar;
        if (aVar != null) {
            C0156b bVar = this.f222g;
            if (bVar != null) {
                bVar.mo990c();
            }
            C0108c cVar = new C0108c(aVar);
            C0086a a = mo847a();
            if (a != null) {
                this.f222g = a.mo730a((C0156b.C0157a) cVar);
                C0156b bVar2 = this.f222g;
                if (!(bVar2 == null || (eVar = this.f219d) == null)) {
                    eVar.onSupportActionModeStarted(bVar2);
                }
            }
            if (this.f222g == null) {
                this.f222g = mo881b((C0156b.C0157a) cVar);
            }
            return this.f222g;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: a */
    public void mo849a(int i) {
        this.f206S = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo875a(int i, C0116i iVar, Menu menu) {
        if (menu == null) {
            if (iVar == null && i >= 0) {
                C0116i[] iVarArr = this.f199L;
                if (i < iVarArr.length) {
                    iVar = iVarArr[i];
                }
            }
            if (iVar != null) {
                menu = iVar.f268j;
            }
        }
        if ((iVar == null || iVar.f273o) && !this.f232q) {
            this.f235y.mo1184a().onPanelClosed(i, menu);
        }
    }

    /* renamed from: a */
    public void mo850a(Context context) {
        m174b(false);
        this.f202O = true;
    }

    /* renamed from: a */
    public void mo851a(Configuration configuration) {
        C0086a a;
        if (this.f227l && this.f192E && (a = mo847a()) != null) {
            a.mo732a(configuration);
        }
        C0337k.m1243b().mo2552a(this.f217b);
        m174b(false);
    }

    /* renamed from: a */
    public void mo852a(Bundle bundle) {
        this.f202O = true;
        m174b(false);
        m183y();
        Object obj = this.f214a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = C0508g.m1979b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                C0086a l = mo890l();
                if (l == null) {
                    this.f212Y = true;
                } else {
                    l.mo741d(true);
                }
            }
        }
        this.f203P = true;
    }

    /* renamed from: a */
    public void mo853a(View view) {
        m184z();
        ViewGroup viewGroup = (ViewGroup) this.f193F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f235y.mo1184a().onContentChanged();
    }

    /* renamed from: a */
    public void mo854a(View view, ViewGroup.LayoutParams layoutParams) {
        m184z();
        ViewGroup viewGroup = (ViewGroup) this.f193F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f235y.mo1184a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo876a(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo877a(C0116i iVar, boolean z) {
        C0255ad adVar;
        if (!z || iVar.f259a != 0 || (adVar = this.f188A) == null || !adVar.mo1697f()) {
            WindowManager windowManager = (WindowManager) this.f217b.getSystemService("window");
            if (!(windowManager == null || !iVar.f273o || iVar.f265g == null)) {
                windowManager.removeView(iVar.f265g);
                if (z) {
                    mo875a(iVar.f259a, iVar, (Menu) null);
                }
            }
            iVar.f271m = false;
            iVar.f272n = false;
            iVar.f273o = false;
            iVar.f266h = null;
            iVar.f275q = true;
            if (this.f200M == iVar) {
                this.f200M = null;
                return;
            }
            return;
        }
        mo878a(iVar.f268j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo878a(C0183g gVar) {
        if (!this.f198K) {
            this.f198K = true;
            this.f188A.mo1709k();
            Window.Callback m = mo891m();
            if (m != null && !this.f232q) {
                m.onPanelClosed(108, gVar);
            }
            this.f198K = false;
        }
    }

    /* renamed from: a */
    public void mo855a(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.f214a instanceof Activity) {
            C0086a a = mo847a();
            if (!(a instanceof C0131n)) {
                this.f221f = null;
                if (a != null) {
                    a.mo747g();
                }
                if (toolbar != null) {
                    C0122k kVar = new C0122k(toolbar, mo893o(), this.f235y);
                    this.f220e = kVar;
                    window = this.f218c;
                    callback = kVar.mo961h();
                } else {
                    this.f220e = null;
                    window = this.f218c;
                    callback = this.f235y;
                }
                window.setCallback(callback);
                mo867f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* renamed from: a */
    public final void mo856a(CharSequence charSequence) {
        this.f236z = charSequence;
        C0255ad adVar = this.f188A;
        if (adVar != null) {
            adVar.setWindowTitle(charSequence);
        } else if (mo890l() != null) {
            mo890l().mo733a(charSequence);
        } else {
            TextView textView = this.f194G;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo879a(int i, KeyEvent keyEvent) {
        C0086a a = mo847a();
        if (a != null && a.mo735a(i, keyEvent)) {
            return true;
        }
        C0116i iVar = this.f200M;
        if (iVar == null || !m170a(iVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f200M == null) {
                C0116i a2 = mo873a(0, true);
                m173b(a2, keyEvent);
                boolean a3 = m170a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f271m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        C0116i iVar2 = this.f200M;
        if (iVar2 != null) {
            iVar2.f272n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo880a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f214a;
        boolean z = true;
        if (((obj instanceof C0638d.C0639a) || (obj instanceof C0118h)) && (decorView = this.f218c.getDecorView()) != null && C0638d.m2525a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f235y.mo1184a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo883c(keyCode, keyEvent) : mo882b(keyCode, keyEvent);
    }

    /* renamed from: b */
    public MenuInflater mo857b() {
        if (this.f221f == null) {
            m181w();
            C0086a aVar = this.f220e;
            this.f221f = new C0163g(aVar != null ? aVar.mo737b() : this.f217b);
        }
        return this.f221f;
    }

    /* renamed from: b */
    public <T extends View> T mo858b(int i) {
        m184z();
        return this.f218c.findViewById(i);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.C0156b mo881b(androidx.appcompat.view.C0156b.C0157a r8) {
        /*
            r7 = this;
            r7.mo900r()
            androidx.appcompat.view.b r0 = r7.f222g
            if (r0 == 0) goto L_0x000a
            r0.mo990c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.C0097g.C0108c
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.g$c r0 = new androidx.appcompat.app.g$c
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.e r0 = r7.f219d
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.f232q
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f222g = r0
            goto L_0x0166
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f223h
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d6
            boolean r0 = r7.f230o
            if (r0 == 0) goto L_0x00b7
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f217b
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.C0059a.C0060a.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f217b
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.d r4 = new androidx.appcompat.view.d
            android.content.Context r6 = r7.f217b
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f217b
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f223h = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.C0059a.C0060a.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f224i = r5
            android.widget.PopupWindow r5 = r7.f224i
            r6 = 2
            androidx.core.widget.C0686h.m2798a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.f224i
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f223h
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f224i
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.C0059a.C0060a.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f223h
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f224i
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.g$6 r0 = new androidx.appcompat.app.g$6
            r0.<init>()
            r7.f225j = r0
            goto L_0x00d6
        L_0x00b7:
            android.view.ViewGroup r0 = r7.f193F
            int r4 = androidx.appcompat.C0059a.C0065f.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d6
            android.content.Context r4 = r7.mo892n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.mo2026a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f223h = r0
        L_0x00d6:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f223h
            if (r0 == 0) goto L_0x0166
            r7.mo900r()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f223h
            r0.mo1665c()
            androidx.appcompat.view.e r0 = new androidx.appcompat.view.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f223h
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f223h
            android.widget.PopupWindow r6 = r7.f224i
            if (r6 != 0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r3 = 0
        L_0x00f2:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.mo987b()
            boolean r8 = r8.mo917a((androidx.appcompat.view.C0156b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x0164
            r0.mo991d()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            r8.mo1662a(r0)
            r7.f222g = r0
            boolean r8 = r7.mo898p()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012e
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            androidx.core.h.y r8 = androidx.core.p030h.C0656u.m2630m(r8)
            androidx.core.h.y r8 = r8.mo3845a((float) r0)
            r7.f226k = r8
            androidx.core.h.y r8 = r7.f226k
            androidx.appcompat.app.g$7 r0 = new androidx.appcompat.app.g$7
            r0.<init>()
            r8.mo3849a((androidx.core.p030h.C0672z) r0)
            goto L_0x0154
        L_0x012e:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0154
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f223h
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.p030h.C0656u.m2634q(r8)
        L_0x0154:
            android.widget.PopupWindow r8 = r7.f224i
            if (r8 == 0) goto L_0x0166
            android.view.Window r8 = r7.f218c
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f225j
            r8.post(r0)
            goto L_0x0166
        L_0x0164:
            r7.f222g = r1
        L_0x0166:
            androidx.appcompat.view.b r8 = r7.f222g
            if (r8 == 0) goto L_0x0171
            androidx.appcompat.app.e r0 = r7.f219d
            if (r0 == 0) goto L_0x0171
            r0.onSupportActionModeStarted(r8)
        L_0x0171:
            androidx.appcompat.view.b r8 = r7.f222g
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0097g.mo881b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* renamed from: b */
    public void mo859b(Bundle bundle) {
        m184z();
    }

    /* renamed from: b */
    public void mo860b(View view, ViewGroup.LayoutParams layoutParams) {
        m184z();
        ((ViewGroup) this.f193F.findViewById(16908290)).addView(view, layoutParams);
        this.f235y.mo1184a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo882b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f201N;
            this.f201N = false;
            C0116i a = mo873a(0, false);
            if (a != null && a.f273o) {
                if (!z) {
                    mo877a(a, true);
                }
                return true;
            } else if (mo901s()) {
                return true;
            }
        } else if (i == 82) {
            m178e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void mo861c() {
        this.f204Q = true;
        mo903u();
        m128a((C0096f) this);
    }

    /* renamed from: c */
    public void mo862c(int i) {
        m184z();
        ViewGroup viewGroup = (ViewGroup) this.f193F.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f217b).inflate(i, viewGroup);
        this.f235y.mo1184a().onContentChanged();
    }

    /* renamed from: c */
    public void mo863c(Bundle bundle) {
        if (this.f205R != -100) {
            f183t.put(this.f214a.getClass(), Integer.valueOf(this.f205R));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo883c(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.f201N = z;
        } else if (i == 82) {
            m177d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public void mo864d() {
        this.f204Q = false;
        m130b((C0096f) this);
        C0086a a = mo847a();
        if (a != null) {
            a.mo743e(false);
        }
        if (this.f214a instanceof Dialog) {
            m182x();
        }
    }

    /* renamed from: d */
    public boolean mo865d(int i) {
        int l = m180l(i);
        if (this.f231p && l == 108) {
            return false;
        }
        if (this.f227l && l == 1) {
            this.f227l = false;
        }
        switch (l) {
            case 1:
                m161D();
                this.f231p = true;
                return true;
            case 2:
                m161D();
                this.f196I = true;
                return true;
            case 5:
                m161D();
                this.f197J = true;
                return true;
            case 10:
                m161D();
                this.f229n = true;
                return true;
            case 108:
                m161D();
                this.f227l = true;
                return true;
            case 109:
                m161D();
                this.f228m = true;
                return true;
            default:
                return this.f218c.requestFeature(l);
        }
    }

    /* renamed from: e */
    public void mo866e() {
        C0086a a = mo847a();
        if (a != null) {
            a.mo743e(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo884e(int i) {
        if (i == 108) {
            C0086a a = mo847a();
            if (a != null) {
                a.mo745f(false);
            }
        } else if (i == 0) {
            C0116i a2 = mo873a(i, true);
            if (a2.f273o) {
                mo877a(a2, false);
            }
        }
    }

    /* renamed from: f */
    public void mo867f() {
        C0086a a = mo847a();
        if (a == null || !a.mo744e()) {
            m179k(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo885f(int i) {
        C0086a a;
        if (i == 108 && (a = mo847a()) != null) {
            a.mo745f(true);
        }
    }

    /* renamed from: g */
    public void mo868g() {
        m130b((C0096f) this);
        if (this.f233r) {
            this.f218c.getDecorView().removeCallbacks(this.f211X);
        }
        this.f204Q = false;
        this.f232q = true;
        C0086a aVar = this.f220e;
        if (aVar != null) {
            aVar.mo747g();
        }
        m182x();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo886g(int i) {
        mo877a(mo873a(i, true), true);
    }

    /* renamed from: h */
    public final C0090b.C0091a mo869h() {
        return new C0106a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo887h(int i) {
        C0116i a;
        C0116i a2 = mo873a(i, true);
        if (a2.f268j != null) {
            Bundle bundle = new Bundle();
            a2.f268j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a2.f277s = bundle;
            }
            a2.f268j.stopDispatchingItemsChanged();
            a2.f268j.clear();
        }
        a2.f276r = true;
        a2.f275q = true;
        if ((i == 108 || i == 0) && this.f188A != null && (a = mo873a(0, false)) != null) {
            a.f271m = false;
            m173b(a, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo888i(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        ActionBarContextView actionBarContextView = this.f223h;
        int i2 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f223h.getLayoutParams();
            z = true;
            if (this.f223h.isShown()) {
                if (this.f213Z == null) {
                    this.f213Z = new Rect();
                    this.f215aa = new Rect();
                }
                Rect rect = this.f213Z;
                Rect rect2 = this.f215aa;
                rect.set(0, i, 0, 0);
                C0313be.m1162a(this.f193F, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.f195H;
                    if (view == null) {
                        this.f195H = new View(this.f217b);
                        this.f195H.setBackgroundColor(this.f217b.getResources().getColor(C0059a.C0062c.abc_input_method_navigation_guard));
                        this.f193F.addView(this.f195H, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f195H.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.f195H == null) {
                    z = false;
                }
                if (!this.f229n && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z3 = true;
                } else {
                    z3 = false;
                }
                z = false;
            }
            if (z2) {
                this.f223h.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.f195H;
        if (view2 != null) {
            if (!z) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: i */
    public void mo870i() {
        LayoutInflater from = LayoutInflater.from(this.f217b);
        if (from.getFactory() == null) {
            C0640e.m2527a(from, this);
        } else if (!(from.getFactory2() instanceof C0097g)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* renamed from: j */
    public int mo871j() {
        return this.f205R;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo889j(int i) {
        C0112f v;
        if (i == -100) {
            return -1;
        }
        switch (i) {
            case -1:
            case 1:
            case 2:
                return i;
            case 0:
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f217b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    v = mo904v();
                    break;
                } else {
                    return -1;
                }
            case 3:
                v = m163F();
                break;
            default:
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
        return v.mo931a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final C0086a mo890l() {
        return this.f220e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final Window.Callback mo891m() {
        return this.f218c.getCallback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final Context mo892n() {
        C0086a a = mo847a();
        Context b = a != null ? a.mo737b() : null;
        return b == null ? this.f217b : b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final CharSequence mo893o() {
        Object obj = this.f214a;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f236z;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return mo872a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public boolean onMenuItemSelected(C0183g gVar, MenuItem menuItem) {
        C0116i a;
        Window.Callback m = mo891m();
        if (m == null || this.f232q || (a = mo874a((Menu) gVar.getRootMenu())) == null) {
            return false;
        }
        return m.onMenuItemSelected(a.f259a, menuItem);
    }

    public void onMenuModeChange(C0183g gVar) {
        m167a(gVar, true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f193F;
     */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo898p() {
        /*
            r1 = this;
            boolean r0 = r1.f192E
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f193F
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.p030h.C0656u.m2642y(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0097g.mo898p():boolean");
    }

    /* renamed from: q */
    public boolean mo899q() {
        return this.f191D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo900r() {
        C0668y yVar = this.f226k;
        if (yVar != null) {
            yVar.mo3852b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo901s() {
        C0156b bVar = this.f222g;
        if (bVar != null) {
            bVar.mo990c();
            return true;
        }
        C0086a a = mo847a();
        return a != null && a.mo746f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo902t() {
        C0255ad adVar = this.f188A;
        if (adVar != null) {
            adVar.mo1709k();
        }
        if (this.f224i != null) {
            this.f218c.getDecorView().removeCallbacks(this.f225j);
            if (this.f224i.isShowing()) {
                try {
                    this.f224i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f224i = null;
        }
        mo900r();
        C0116i a = mo873a(0, false);
        if (a != null && a.f268j != null) {
            a.f268j.close();
        }
    }

    /* renamed from: u */
    public boolean mo903u() {
        return m174b(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final C0112f mo904v() {
        if (this.f209V == null) {
            this.f209V = new C0114g(C0129m.m305a(this.f217b));
        }
        return this.f209V;
    }
}
