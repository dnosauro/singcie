package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.widget.C0266aj;
import androidx.core.p030h.C0656u;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {

    /* renamed from: A */
    private int f57A;

    /* renamed from: B */
    private boolean f58B = false;

    /* renamed from: C */
    private CharSequence f59C;

    /* renamed from: D */
    private Drawable f60D;

    /* renamed from: E */
    private CharSequence f61E;

    /* renamed from: F */
    private Drawable f62F;

    /* renamed from: G */
    private CharSequence f63G;

    /* renamed from: H */
    private Drawable f64H;

    /* renamed from: I */
    private int f65I = 0;

    /* renamed from: J */
    private Drawable f66J;

    /* renamed from: K */
    private ImageView f67K;

    /* renamed from: L */
    private TextView f68L;

    /* renamed from: M */
    private TextView f69M;

    /* renamed from: N */
    private View f70N;

    /* renamed from: O */
    private int f71O;

    /* renamed from: P */
    private int f72P;

    /* renamed from: Q */
    private boolean f73Q;

    /* renamed from: R */
    private int f74R = 0;

    /* renamed from: S */
    private final View.OnClickListener f75S = new View.OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r0 = r0.f78c
                if (r3 != r0) goto L_0x0015
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.os.Message r0 = r0.f79d
                if (r0 == 0) goto L_0x0015
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f79d
            L_0x0010:
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x0038
            L_0x0015:
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r0 = r0.f80e
                if (r3 != r0) goto L_0x0026
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.os.Message r0 = r0.f81f
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f81f
                goto L_0x0010
            L_0x0026:
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r0 = r0.f82g
                if (r3 != r0) goto L_0x0037
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f83h
                if (r3 == 0) goto L_0x0037
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f83h
                goto L_0x0010
            L_0x0037:
                r3 = 0
            L_0x0038:
                if (r3 == 0) goto L_0x003d
                r3.sendToTarget()
            L_0x003d:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r3 = r3.f91p
                r0 = 1
                androidx.appcompat.app.AlertController r1 = androidx.appcompat.app.AlertController.this
                androidx.appcompat.app.h r1 = r1.f76a
                android.os.Message r3 = r3.obtainMessage(r0, r1)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.C00721.onClick(android.view.View):void");
        }
    };

    /* renamed from: a */
    final C0118h f76a;

    /* renamed from: b */
    ListView f77b;

    /* renamed from: c */
    Button f78c;

    /* renamed from: d */
    Message f79d;

    /* renamed from: e */
    Button f80e;

    /* renamed from: f */
    Message f81f;

    /* renamed from: g */
    Button f82g;

    /* renamed from: h */
    Message f83h;

    /* renamed from: i */
    NestedScrollView f84i;

    /* renamed from: j */
    ListAdapter f85j;

    /* renamed from: k */
    int f86k = -1;

    /* renamed from: l */
    int f87l;

    /* renamed from: m */
    int f88m;

    /* renamed from: n */
    int f89n;

    /* renamed from: o */
    int f90o;

    /* renamed from: p */
    Handler f91p;

    /* renamed from: q */
    private final Context f92q;

    /* renamed from: r */
    private final Window f93r;

    /* renamed from: s */
    private final int f94s;

    /* renamed from: t */
    private CharSequence f95t;

    /* renamed from: u */
    private CharSequence f96u;

    /* renamed from: v */
    private View f97v;

    /* renamed from: w */
    private int f98w;

    /* renamed from: x */
    private int f99x;

    /* renamed from: y */
    private int f100y;

    /* renamed from: z */
    private int f101z;

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f115a;

        /* renamed from: b */
        private final int f116b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.RecycleListView);
            this.f116b = obtainStyledAttributes.getDimensionPixelOffset(C0059a.C0069j.RecycleListView_paddingBottomNoButtons, -1);
            this.f115a = obtainStyledAttributes.getDimensionPixelOffset(C0059a.C0069j.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: a */
        public void mo701a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f115a, getPaddingRight(), z2 ? getPaddingBottom() : this.f116b);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    public static class C0077a {

        /* renamed from: A */
        public int f117A;

        /* renamed from: B */
        public int f118B;

        /* renamed from: C */
        public int f119C;

        /* renamed from: D */
        public int f120D;

        /* renamed from: E */
        public boolean f121E = false;

        /* renamed from: F */
        public boolean[] f122F;

        /* renamed from: G */
        public boolean f123G;

        /* renamed from: H */
        public boolean f124H;

        /* renamed from: I */
        public int f125I = -1;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f126J;

        /* renamed from: K */
        public Cursor f127K;

        /* renamed from: L */
        public String f128L;

        /* renamed from: M */
        public String f129M;

        /* renamed from: N */
        public boolean f130N;

        /* renamed from: O */
        public AdapterView.OnItemSelectedListener f131O;

        /* renamed from: P */
        public C0082a f132P;

        /* renamed from: Q */
        public boolean f133Q = true;

        /* renamed from: a */
        public final Context f134a;

        /* renamed from: b */
        public final LayoutInflater f135b;

        /* renamed from: c */
        public int f136c = 0;

        /* renamed from: d */
        public Drawable f137d;

        /* renamed from: e */
        public int f138e = 0;

        /* renamed from: f */
        public CharSequence f139f;

        /* renamed from: g */
        public View f140g;

        /* renamed from: h */
        public CharSequence f141h;

        /* renamed from: i */
        public CharSequence f142i;

        /* renamed from: j */
        public Drawable f143j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f144k;

        /* renamed from: l */
        public CharSequence f145l;

        /* renamed from: m */
        public Drawable f146m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f147n;

        /* renamed from: o */
        public CharSequence f148o;

        /* renamed from: p */
        public Drawable f149p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f150q;

        /* renamed from: r */
        public boolean f151r;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f152s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f153t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f154u;

        /* renamed from: v */
        public CharSequence[] f155v;

        /* renamed from: w */
        public ListAdapter f156w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f157x;

        /* renamed from: y */
        public int f158y;

        /* renamed from: z */
        public View f159z;

        /* renamed from: androidx.appcompat.app.AlertController$a$a */
        public interface C0082a {
            /* renamed from: a */
            void mo708a(ListView listView);
        }

        public C0077a(Context context) {
            this.f134a = context;
            this.f151r = true;
            this.f135b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v6, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v20, types: [androidx.appcompat.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r1v21, types: [androidx.appcompat.app.AlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m95b(final androidx.appcompat.app.AlertController r12) {
            /*
                r11 = this;
                android.view.LayoutInflater r0 = r11.f135b
                int r1 = r12.f87l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r11.f123G
                r8 = 1
                if (r1 == 0) goto L_0x0033
                android.database.Cursor r4 = r11.f127K
                if (r4 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$a$1 r9 = new androidx.appcompat.app.AlertController$a$1
                android.content.Context r3 = r11.f134a
                int r4 = r12.f88m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r11.f155v
                r1 = r9
                r2 = r11
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0067
            L_0x0026:
                androidx.appcompat.app.AlertController$a$2 r9 = new androidx.appcompat.app.AlertController$a$2
                android.content.Context r3 = r11.f134a
                r5 = 0
                r1 = r9
                r2 = r11
                r6 = r0
                r7 = r12
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0067
            L_0x0033:
                boolean r1 = r11.f124H
                if (r1 == 0) goto L_0x003a
                int r1 = r12.f89n
                goto L_0x003c
            L_0x003a:
                int r1 = r12.f90o
            L_0x003c:
                r4 = r1
                android.database.Cursor r5 = r11.f127K
                r1 = 16908308(0x1020014, float:2.3877285E-38)
                if (r5 == 0) goto L_0x0059
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r11.f134a
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r2 = r11.f128L
                r7 = 0
                r6[r7] = r2
                int[] r10 = new int[r8]
                r10[r7] = r1
                r2 = r9
                r7 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0067
            L_0x0059:
                android.widget.ListAdapter r9 = r11.f156w
                if (r9 == 0) goto L_0x005e
                goto L_0x0067
            L_0x005e:
                androidx.appcompat.app.AlertController$c r9 = new androidx.appcompat.app.AlertController$c
                android.content.Context r2 = r11.f134a
                java.lang.CharSequence[] r3 = r11.f155v
                r9.<init>(r2, r4, r1, r3)
            L_0x0067:
                androidx.appcompat.app.AlertController$a$a r1 = r11.f132P
                if (r1 == 0) goto L_0x006e
                r1.mo708a(r0)
            L_0x006e:
                r12.f85j = r9
                int r1 = r11.f125I
                r12.f86k = r1
                android.content.DialogInterface$OnClickListener r1 = r11.f157x
                if (r1 == 0) goto L_0x0081
                androidx.appcompat.app.AlertController$a$3 r1 = new androidx.appcompat.app.AlertController$a$3
                r1.<init>(r12)
            L_0x007d:
                r0.setOnItemClickListener(r1)
                goto L_0x008b
            L_0x0081:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r11.f126J
                if (r1 == 0) goto L_0x008b
                androidx.appcompat.app.AlertController$a$4 r1 = new androidx.appcompat.app.AlertController$a$4
                r1.<init>(r0, r12)
                goto L_0x007d
            L_0x008b:
                android.widget.AdapterView$OnItemSelectedListener r1 = r11.f131O
                if (r1 == 0) goto L_0x0092
                r0.setOnItemSelectedListener(r1)
            L_0x0092:
                boolean r1 = r11.f124H
                if (r1 == 0) goto L_0x009a
                r0.setChoiceMode(r8)
                goto L_0x00a2
            L_0x009a:
                boolean r1 = r11.f123G
                if (r1 == 0) goto L_0x00a2
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a2:
                r12.f77b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.C0077a.m95b(androidx.appcompat.app.AlertController):void");
        }

        /* renamed from: a */
        public void mo702a(AlertController alertController) {
            View view = this.f140g;
            if (view != null) {
                alertController.mo690b(view);
            } else {
                CharSequence charSequence = this.f139f;
                if (charSequence != null) {
                    alertController.mo686a(charSequence);
                }
                Drawable drawable = this.f137d;
                if (drawable != null) {
                    alertController.mo684a(drawable);
                }
                int i = this.f136c;
                if (i != 0) {
                    alertController.mo689b(i);
                }
                int i2 = this.f138e;
                if (i2 != 0) {
                    alertController.mo689b(alertController.mo693c(i2));
                }
            }
            CharSequence charSequence2 = this.f141h;
            if (charSequence2 != null) {
                alertController.mo691b(charSequence2);
            }
            if (!(this.f142i == null && this.f143j == null)) {
                alertController.mo683a(-1, this.f142i, this.f144k, (Message) null, this.f143j);
            }
            if (!(this.f145l == null && this.f146m == null)) {
                alertController.mo683a(-2, this.f145l, this.f147n, (Message) null, this.f146m);
            }
            if (!(this.f148o == null && this.f149p == null)) {
                alertController.mo683a(-3, this.f148o, this.f150q, (Message) null, this.f149p);
            }
            if (!(this.f155v == null && this.f127K == null && this.f156w == null)) {
                m95b(alertController);
            }
            View view2 = this.f159z;
            if (view2 == null) {
                int i3 = this.f158y;
                if (i3 != 0) {
                    alertController.mo682a(i3);
                }
            } else if (this.f121E) {
                alertController.mo685a(view2, this.f117A, this.f118B, this.f119C, this.f120D);
            } else {
                alertController.mo694c(view2);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$b */
    private static final class C0083b extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f172a;

        public C0083b(DialogInterface dialogInterface) {
            this.f172a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f172a.get(), message.what);
                        return;
                    default:
                        return;
                }
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    private static class C0084c extends ArrayAdapter<CharSequence> {
        public C0084c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, C0118h hVar, Window window) {
        this.f92q = context;
        this.f76a = hVar;
        this.f93r = window;
        this.f91p = new C0083b(hVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, C0059a.C0069j.AlertDialog, C0059a.C0060a.alertDialogStyle, 0);
        this.f71O = obtainStyledAttributes.getResourceId(C0059a.C0069j.AlertDialog_android_layout, 0);
        this.f72P = obtainStyledAttributes.getResourceId(C0059a.C0069j.AlertDialog_buttonPanelSideLayout, 0);
        this.f87l = obtainStyledAttributes.getResourceId(C0059a.C0069j.AlertDialog_listLayout, 0);
        this.f88m = obtainStyledAttributes.getResourceId(C0059a.C0069j.AlertDialog_multiChoiceItemLayout, 0);
        this.f89n = obtainStyledAttributes.getResourceId(C0059a.C0069j.AlertDialog_singleChoiceItemLayout, 0);
        this.f90o = obtainStyledAttributes.getResourceId(C0059a.C0069j.AlertDialog_listItemLayout, 0);
        this.f73Q = obtainStyledAttributes.getBoolean(C0059a.C0069j.AlertDialog_showTitle, true);
        this.f94s = obtainStyledAttributes.getDimensionPixelSize(C0059a.C0069j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        hVar.supportRequestWindowFeature(1);
    }

    /* renamed from: a */
    private ViewGroup m67a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: a */
    static void m68a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m69a(ViewGroup viewGroup) {
        View view = this.f97v;
        boolean z = false;
        if (view == null) {
            view = this.f98w != 0 ? LayoutInflater.from(this.f92q).inflate(this.f98w, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !m73a(view)) {
            this.f93r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f93r.findViewById(C0059a.C0065f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f58B) {
                frameLayout.setPadding(this.f99x, this.f100y, this.f101z, this.f57A);
            }
            if (this.f77b != null) {
                ((C0266aj.C0267a) viewGroup.getLayoutParams()).f964g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    private void m70a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.f93r.findViewById(C0059a.C0065f.scrollIndicatorUp);
        View findViewById2 = this.f93r.findViewById(C0059a.C0065f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            C0656u.m2585a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f96u != null) {
                this.f84i.setOnScrollChangeListener(new NestedScrollView.C0674b() {
                    /* renamed from: a */
                    public void mo696a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m68a(nestedScrollView, findViewById, view2);
                    }
                });
                this.f84i.post(new Runnable() {
                    public void run() {
                        AlertController.m68a(AlertController.this.f84i, findViewById, view2);
                    }
                });
                return;
            }
            ListView listView = this.f77b;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m68a(absListView, findViewById, view2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.f77b.post(new Runnable() {
                    public void run() {
                        AlertController.m68a(AlertController.this.f77b, findViewById, view2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    /* renamed from: a */
    private void m71a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private static boolean m72a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0059a.C0060a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    /* renamed from: a */
    static boolean m73a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m73a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m74b(ViewGroup viewGroup) {
        if (this.f70N != null) {
            viewGroup.addView(this.f70N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f93r.findViewById(C0059a.C0065f.title_template).setVisibility(8);
            return;
        }
        this.f67K = (ImageView) this.f93r.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f95t)) || !this.f73Q) {
            this.f93r.findViewById(C0059a.C0065f.title_template).setVisibility(8);
            this.f67K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f68L = (TextView) this.f93r.findViewById(C0059a.C0065f.alertTitle);
        this.f68L.setText(this.f95t);
        int i = this.f65I;
        if (i != 0) {
            this.f67K.setImageResource(i);
            return;
        }
        Drawable drawable = this.f66J;
        if (drawable != null) {
            this.f67K.setImageDrawable(drawable);
            return;
        }
        this.f68L.setPadding(this.f67K.getPaddingLeft(), this.f67K.getPaddingTop(), this.f67K.getPaddingRight(), this.f67K.getPaddingBottom());
        this.f67K.setVisibility(8);
    }

    /* renamed from: c */
    private int m75c() {
        int i = this.f72P;
        return i == 0 ? this.f71O : this.f74R == 1 ? i : this.f71O;
    }

    /* renamed from: c */
    private void m76c(ViewGroup viewGroup) {
        this.f84i = (NestedScrollView) this.f93r.findViewById(C0059a.C0065f.scrollView);
        this.f84i.setFocusable(false);
        this.f84i.setNestedScrollingEnabled(false);
        this.f69M = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.f69M;
        if (textView != null) {
            CharSequence charSequence = this.f96u;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.f84i.removeView(this.f69M);
            if (this.f77b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f84i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f84i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f77b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: d */
    private void m77d() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f93r.findViewById(C0059a.C0065f.parentPanel);
        View findViewById4 = findViewById3.findViewById(C0059a.C0065f.topPanel);
        View findViewById5 = findViewById3.findViewById(C0059a.C0065f.contentPanel);
        View findViewById6 = findViewById3.findViewById(C0059a.C0065f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(C0059a.C0065f.customPanel);
        m69a(viewGroup);
        View findViewById7 = viewGroup.findViewById(C0059a.C0065f.topPanel);
        View findViewById8 = viewGroup.findViewById(C0059a.C0065f.contentPanel);
        View findViewById9 = viewGroup.findViewById(C0059a.C0065f.buttonPanel);
        ViewGroup a = m67a(findViewById7, findViewById4);
        ViewGroup a2 = m67a(findViewById8, findViewById5);
        ViewGroup a3 = m67a(findViewById9, findViewById6);
        m76c(a2);
        m78d(a3);
        m74b(a);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null || (findViewById2 = a2.findViewById(C0059a.C0065f.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.f84i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f96u == null && this.f77b == null)) {
                view = a.findViewById(C0059a.C0065f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(a2 == null || (findViewById = a2.findViewById(C0059a.C0065f.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f77b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).mo701a(z2, z3);
        }
        if (!z) {
            View view2 = this.f77b;
            if (view2 == null) {
                view2 = this.f84i;
            }
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                m70a(a2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f77b;
        if (listView2 != null && (listAdapter = this.f85j) != null) {
            listView2.setAdapter(listAdapter);
            int i = this.f86k;
            if (i > -1) {
                listView2.setItemChecked(i, true);
                listView2.setSelection(i);
            }
        }
    }

    /* renamed from: d */
    private void m78d(ViewGroup viewGroup) {
        boolean z;
        Button button;
        this.f78c = (Button) viewGroup.findViewById(16908313);
        this.f78c.setOnClickListener(this.f75S);
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.f59C) || this.f60D != null) {
            this.f78c.setText(this.f59C);
            Drawable drawable = this.f60D;
            if (drawable != null) {
                int i = this.f94s;
                drawable.setBounds(0, 0, i, i);
                this.f78c.setCompoundDrawables(this.f60D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f78c.setVisibility(0);
            z = true;
        } else {
            this.f78c.setVisibility(8);
            z = false;
        }
        this.f80e = (Button) viewGroup.findViewById(16908314);
        this.f80e.setOnClickListener(this.f75S);
        if (!TextUtils.isEmpty(this.f61E) || this.f62F != null) {
            this.f80e.setText(this.f61E);
            Drawable drawable2 = this.f62F;
            if (drawable2 != null) {
                int i2 = this.f94s;
                drawable2.setBounds(0, 0, i2, i2);
                this.f80e.setCompoundDrawables(this.f62F, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f80e.setVisibility(0);
            z |= true;
        } else {
            this.f80e.setVisibility(8);
        }
        this.f82g = (Button) viewGroup.findViewById(16908315);
        this.f82g.setOnClickListener(this.f75S);
        if (!TextUtils.isEmpty(this.f63G) || this.f64H != null) {
            this.f82g.setText(this.f63G);
            Drawable drawable3 = this.f60D;
            if (drawable3 != null) {
                int i3 = this.f94s;
                drawable3.setBounds(0, 0, i3, i3);
                this.f78c.setCompoundDrawables(this.f60D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f82g.setVisibility(0);
            z |= true;
        } else {
            this.f82g.setVisibility(8);
        }
        if (m72a(this.f92q)) {
            if (z) {
                button = this.f78c;
            } else if (z) {
                button = this.f80e;
            } else if (z) {
                button = this.f82g;
            }
            m71a(button);
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo681a() {
        this.f76a.setContentView(m75c());
        m77d();
    }

    /* renamed from: a */
    public void mo682a(int i) {
        this.f97v = null;
        this.f98w = i;
        this.f58B = false;
    }

    /* renamed from: a */
    public void mo683a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f91p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f63G = charSequence;
                this.f83h = message;
                this.f64H = drawable;
                return;
            case -2:
                this.f61E = charSequence;
                this.f81f = message;
                this.f62F = drawable;
                return;
            case -1:
                this.f59C = charSequence;
                this.f79d = message;
                this.f60D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: a */
    public void mo684a(Drawable drawable) {
        this.f66J = drawable;
        this.f65I = 0;
        ImageView imageView = this.f67K;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.f67K.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: a */
    public void mo685a(View view, int i, int i2, int i3, int i4) {
        this.f97v = view;
        this.f98w = 0;
        this.f58B = true;
        this.f99x = i;
        this.f100y = i2;
        this.f101z = i3;
        this.f57A = i4;
    }

    /* renamed from: a */
    public void mo686a(CharSequence charSequence) {
        this.f95t = charSequence;
        TextView textView = this.f68L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: a */
    public boolean mo687a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f84i;
        return nestedScrollView != null && nestedScrollView.mo3865a(keyEvent);
    }

    /* renamed from: b */
    public ListView mo688b() {
        return this.f77b;
    }

    /* renamed from: b */
    public void mo689b(int i) {
        this.f66J = null;
        this.f65I = i;
        ImageView imageView = this.f67K;
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            imageView.setVisibility(0);
            this.f67K.setImageResource(this.f65I);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: b */
    public void mo690b(View view) {
        this.f70N = view;
    }

    /* renamed from: b */
    public void mo691b(CharSequence charSequence) {
        this.f96u = charSequence;
        TextView textView = this.f69M;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: b */
    public boolean mo692b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f84i;
        return nestedScrollView != null && nestedScrollView.mo3865a(keyEvent);
    }

    /* renamed from: c */
    public int mo693c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f92q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: c */
    public void mo694c(View view) {
        this.f97v = view;
        this.f98w = 0;
        this.f58B = false;
    }
}
