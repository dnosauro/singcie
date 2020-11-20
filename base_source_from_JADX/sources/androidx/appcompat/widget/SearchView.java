package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0158c;
import androidx.core.p030h.C0656u;
import androidx.p032d.p033a.C0692a;
import androidx.p035e.p036a.C0711a;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public class SearchView extends C0266aj implements C0158c {

    /* renamed from: i */
    static final C0234a f818i = new C0234a();

    /* renamed from: A */
    private C0236c f819A;

    /* renamed from: B */
    private C0235b f820B;

    /* renamed from: C */
    private C0237d f821C;

    /* renamed from: D */
    private View.OnClickListener f822D;

    /* renamed from: E */
    private boolean f823E;

    /* renamed from: F */
    private boolean f824F;

    /* renamed from: G */
    private boolean f825G;

    /* renamed from: H */
    private CharSequence f826H;

    /* renamed from: I */
    private boolean f827I;

    /* renamed from: J */
    private boolean f828J;

    /* renamed from: K */
    private int f829K;

    /* renamed from: L */
    private boolean f830L;

    /* renamed from: M */
    private CharSequence f831M;

    /* renamed from: N */
    private CharSequence f832N;

    /* renamed from: O */
    private boolean f833O;

    /* renamed from: P */
    private int f834P;

    /* renamed from: Q */
    private Bundle f835Q;

    /* renamed from: R */
    private final Runnable f836R;

    /* renamed from: S */
    private Runnable f837S;

    /* renamed from: T */
    private final WeakHashMap<String, Drawable.ConstantState> f838T;

    /* renamed from: U */
    private final View.OnClickListener f839U;

    /* renamed from: V */
    private final TextView.OnEditorActionListener f840V;

    /* renamed from: W */
    private final AdapterView.OnItemClickListener f841W;

    /* renamed from: a */
    final SearchAutoComplete f842a;

    /* renamed from: aa */
    private final AdapterView.OnItemSelectedListener f843aa;

    /* renamed from: ab */
    private TextWatcher f844ab;

    /* renamed from: b */
    final ImageView f845b;

    /* renamed from: c */
    final ImageView f846c;

    /* renamed from: d */
    final ImageView f847d;

    /* renamed from: e */
    final ImageView f848e;

    /* renamed from: f */
    View.OnFocusChangeListener f849f;

    /* renamed from: g */
    C0692a f850g;

    /* renamed from: h */
    SearchableInfo f851h;

    /* renamed from: j */
    View.OnKeyListener f852j;

    /* renamed from: k */
    private final View f853k;

    /* renamed from: l */
    private final View f854l;

    /* renamed from: m */
    private final View f855m;

    /* renamed from: n */
    private final View f856n;

    /* renamed from: o */
    private C0240f f857o;

    /* renamed from: p */
    private Rect f858p;

    /* renamed from: q */
    private Rect f859q;

    /* renamed from: r */
    private int[] f860r;

    /* renamed from: s */
    private int[] f861s;

    /* renamed from: t */
    private final ImageView f862t;

    /* renamed from: u */
    private final Drawable f863u;

    /* renamed from: v */
    private final int f864v;

    /* renamed from: w */
    private final int f865w;

    /* renamed from: x */
    private final Intent f866x;

    /* renamed from: y */
    private final Intent f867y;

    /* renamed from: z */
    private final CharSequence f868z;

    public static class SearchAutoComplete extends C0331e {

        /* renamed from: a */
        final Runnable f879a;

        /* renamed from: b */
        private int f880b;

        /* renamed from: c */
        private SearchView f881c;

        /* renamed from: d */
        private boolean f882d;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0059a.C0060a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f879a = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.mo1893b();
                }
            };
            this.f880b = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1892a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1893b() {
            if (this.f882d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f882d = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f880b <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f882d) {
                removeCallbacks(this.f879a);
                post(this.f879a);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f881c.mo1855i();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f881c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f881c.hasFocus() && getVisibility() == 0) {
                this.f882d = true;
                if (SearchView.m778a(getContext())) {
                    SearchView.f818i.mo1907a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f882d = false;
                removeCallbacks(this.f879a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f882d = false;
                removeCallbacks(this.f879a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f882d = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f881c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f880b = i;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    private static class C0234a {

        /* renamed from: a */
        private Method f884a;

        /* renamed from: b */
        private Method f885b;

        /* renamed from: c */
        private Method f886c;

        C0234a() {
            try {
                this.f884a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f884a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f885b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f885b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                this.f886c = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f886c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1906a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f884a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1907a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f886c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1908b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f885b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    public interface C0235b {
        /* renamed from: a */
        boolean mo1909a();
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    public interface C0236c {
        /* renamed from: a */
        boolean mo1910a(String str);

        /* renamed from: b */
        boolean mo1911b(String str);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    public interface C0237d {
        /* renamed from: a */
        boolean mo1912a(int i);

        /* renamed from: b */
        boolean mo1913b(int i);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    static class C0238e extends C0711a {
        public static final Parcelable.Creator<C0238e> CREATOR = new Parcelable.ClassLoaderCreator<C0238e>() {
            /* renamed from: a */
            public C0238e createFromParcel(Parcel parcel) {
                return new C0238e(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public C0238e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0238e(parcel, classLoader);
            }

            /* renamed from: a */
            public C0238e[] newArray(int i) {
                return new C0238e[i];
            }
        };

        /* renamed from: a */
        boolean f887a;

        public C0238e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f887a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        C0238e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f887a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f887a));
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    private static class C0240f extends TouchDelegate {

        /* renamed from: a */
        private final View f888a;

        /* renamed from: b */
        private final Rect f889b = new Rect();

        /* renamed from: c */
        private final Rect f890c = new Rect();

        /* renamed from: d */
        private final Rect f891d = new Rect();

        /* renamed from: e */
        private final int f892e;

        /* renamed from: f */
        private boolean f893f;

        public C0240f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f892e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            mo1922a(rect, rect2);
            this.f888a = view;
        }

        /* renamed from: a */
        public void mo1922a(Rect rect, Rect rect2) {
            this.f889b.set(rect);
            this.f891d.set(rect);
            Rect rect3 = this.f891d;
            int i = this.f892e;
            rect3.inset(-i, -i);
            this.f890c.set(rect2);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                float r0 = r7.getX()
                int r0 = (int) r0
                float r1 = r7.getY()
                int r1 = (int) r1
                int r2 = r7.getAction()
                r3 = 1
                r4 = 0
                switch(r2) {
                    case 0: goto L_0x0027;
                    case 1: goto L_0x0019;
                    case 2: goto L_0x0019;
                    case 3: goto L_0x0014;
                    default: goto L_0x0013;
                }
            L_0x0013:
                goto L_0x0033
            L_0x0014:
                boolean r2 = r6.f893f
                r6.f893f = r4
                goto L_0x0034
            L_0x0019:
                boolean r2 = r6.f893f
                if (r2 == 0) goto L_0x0034
                android.graphics.Rect r5 = r6.f891d
                boolean r5 = r5.contains(r0, r1)
                if (r5 != 0) goto L_0x0034
                r3 = 0
                goto L_0x0034
            L_0x0027:
                android.graphics.Rect r2 = r6.f889b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x0033
                r6.f893f = r3
                r2 = 1
                goto L_0x0034
            L_0x0033:
                r2 = 0
            L_0x0034:
                if (r2 == 0) goto L_0x0067
                if (r3 == 0) goto L_0x0052
                android.graphics.Rect r2 = r6.f890c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x0052
                android.view.View r0 = r6.f888a
                int r0 = r0.getWidth()
                int r0 = r0 / 2
                float r0 = (float) r0
                android.view.View r1 = r6.f888a
                int r1 = r1.getHeight()
                int r1 = r1 / 2
                goto L_0x005d
            L_0x0052:
                android.graphics.Rect r2 = r6.f890c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r6.f890c
                int r2 = r2.top
                int r1 = r1 - r2
            L_0x005d:
                float r1 = (float) r1
                r7.setLocation(r0, r1)
                android.view.View r0 = r6.f888a
                boolean r4 = r0.dispatchTouchEvent(r7)
            L_0x0067:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.C0240f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f858p = new Rect();
        this.f859q = new Rect();
        this.f860r = new int[2];
        this.f861s = new int[2];
        this.f836R = new Runnable() {
            public void run() {
                SearchView.this.mo1842d();
            }
        };
        this.f837S = new Runnable() {
            public void run() {
                if (SearchView.this.f850g instanceof C0293ar) {
                    SearchView.this.f850g.mo2336a((Cursor) null);
                }
            }
        };
        this.f838T = new WeakHashMap<>();
        this.f839U = new View.OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.f845b) {
                    SearchView.this.mo1845g();
                } else if (view == SearchView.this.f847d) {
                    SearchView.this.mo1844f();
                } else if (view == SearchView.this.f846c) {
                    SearchView.this.mo1843e();
                } else if (view == SearchView.this.f848e) {
                    SearchView.this.mo1854h();
                } else if (view == SearchView.this.f842a) {
                    SearchView.this.mo1857k();
                }
            }
        };
        this.f852j = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.f851h == null) {
                    return false;
                }
                if (SearchView.this.f842a.isPopupShowing() && SearchView.this.f842a.getListSelection() != -1) {
                    return SearchView.this.mo1838a(view, i, keyEvent);
                }
                if (SearchView.this.f842a.mo1892a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView = SearchView.this;
                searchView.mo1833a(0, (String) null, searchView.f842a.getText().toString());
                return true;
            }
        };
        this.f840V = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.mo1843e();
                return true;
            }
        };
        this.f841W = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.mo1837a(i, 0, (String) null);
            }
        };
        this.f843aa = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.mo1836a(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f844ab = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.mo1839b(charSequence);
            }
        };
        C0302ay a = C0302ay.m1078a(context, attributeSet, C0059a.C0069j.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.mo2423g(C0059a.C0069j.SearchView_layout, C0059a.C0066g.abc_search_view), this, true);
        this.f842a = (SearchAutoComplete) findViewById(C0059a.C0065f.search_src_text);
        this.f842a.setSearchView(this);
        this.f853k = findViewById(C0059a.C0065f.search_edit_frame);
        this.f854l = findViewById(C0059a.C0065f.search_plate);
        this.f855m = findViewById(C0059a.C0065f.submit_area);
        this.f845b = (ImageView) findViewById(C0059a.C0065f.search_button);
        this.f846c = (ImageView) findViewById(C0059a.C0065f.search_go_btn);
        this.f847d = (ImageView) findViewById(C0059a.C0065f.search_close_btn);
        this.f848e = (ImageView) findViewById(C0059a.C0065f.search_voice_btn);
        this.f862t = (ImageView) findViewById(C0059a.C0065f.search_mag_icon);
        C0656u.m2590a(this.f854l, a.mo2409a(C0059a.C0069j.SearchView_queryBackground));
        C0656u.m2590a(this.f855m, a.mo2409a(C0059a.C0069j.SearchView_submitBackground));
        this.f845b.setImageDrawable(a.mo2409a(C0059a.C0069j.SearchView_searchIcon));
        this.f846c.setImageDrawable(a.mo2409a(C0059a.C0069j.SearchView_goIcon));
        this.f847d.setImageDrawable(a.mo2409a(C0059a.C0069j.SearchView_closeIcon));
        this.f848e.setImageDrawable(a.mo2409a(C0059a.C0069j.SearchView_voiceIcon));
        this.f862t.setImageDrawable(a.mo2409a(C0059a.C0069j.SearchView_searchIcon));
        this.f863u = a.mo2409a(C0059a.C0069j.SearchView_searchHintIcon);
        C0307ba.m1144a(this.f845b, getResources().getString(C0059a.C0067h.abc_searchview_description_search));
        this.f864v = a.mo2423g(C0059a.C0069j.SearchView_suggestionRowLayout, C0059a.C0066g.abc_search_dropdown_item_icons_2line);
        this.f865w = a.mo2423g(C0059a.C0069j.SearchView_commitIcon, 0);
        this.f845b.setOnClickListener(this.f839U);
        this.f847d.setOnClickListener(this.f839U);
        this.f846c.setOnClickListener(this.f839U);
        this.f848e.setOnClickListener(this.f839U);
        this.f842a.setOnClickListener(this.f839U);
        this.f842a.addTextChangedListener(this.f844ab);
        this.f842a.setOnEditorActionListener(this.f840V);
        this.f842a.setOnItemClickListener(this.f841W);
        this.f842a.setOnItemSelectedListener(this.f843aa);
        this.f842a.setOnKeyListener(this.f852j);
        this.f842a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f849f != null) {
                    SearchView.this.f849f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a.mo2411a(C0059a.C0069j.SearchView_iconifiedByDefault, true));
        int e = a.mo2419e(C0059a.C0069j.SearchView_android_maxWidth, -1);
        if (e != -1) {
            setMaxWidth(e);
        }
        this.f868z = a.mo2416c(C0059a.C0069j.SearchView_defaultQueryHint);
        this.f826H = a.mo2416c(C0059a.C0069j.SearchView_queryHint);
        int a2 = a.mo2407a(C0059a.C0069j.SearchView_android_imeOptions, -1);
        if (a2 != -1) {
            setImeOptions(a2);
        }
        int a3 = a.mo2407a(C0059a.C0069j.SearchView_android_inputType, -1);
        if (a3 != -1) {
            setInputType(a3);
        }
        setFocusable(a.mo2411a(C0059a.C0069j.SearchView_android_focusable, true));
        a.mo2410a();
        this.f866x = new Intent("android.speech.action.WEB_SEARCH");
        this.f866x.addFlags(268435456);
        this.f866x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f867y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f867y.addFlags(268435456);
        this.f856n = findViewById(this.f842a.getDropDownAnchor());
        View view = this.f856n;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    SearchView.this.mo1856j();
                }
            });
        }
        m777a(this.f823E);
        m790q();
    }

    /* renamed from: a */
    private Intent m772a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: a */
    private Intent m773a(Cursor cursor, int i, String str) {
        int i2;
        String a;
        try {
            String a2 = C0293ar.m1044a(cursor, "suggest_intent_action");
            if (a2 == null) {
                a2 = this.f851h.getSuggestIntentAction();
            }
            if (a2 == null) {
                a2 = "android.intent.action.SEARCH";
            }
            String str2 = a2;
            String a3 = C0293ar.m1044a(cursor, "suggest_intent_data");
            if (a3 == null) {
                a3 = this.f851h.getSuggestIntentData();
            }
            if (!(a3 == null || (a = C0293ar.m1044a(cursor, "suggest_intent_data_id")) == null)) {
                a3 = a3 + "/" + Uri.encode(a);
            }
            return m774a(str2, a3 == null ? null : Uri.parse(a3), C0293ar.m1044a(cursor, "suggest_intent_extra_data"), C0293ar.m1044a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            return null;
        }
    }

    /* renamed from: a */
    private Intent m774a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f832N);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f835Q;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f851h.getSearchActivity());
        return intent;
    }

    /* renamed from: a */
    private void m775a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    /* renamed from: a */
    private void m776a(View view, Rect rect) {
        view.getLocationInWindow(this.f860r);
        getLocationInWindow(this.f861s);
        int[] iArr = this.f860r;
        int i = iArr[1];
        int[] iArr2 = this.f861s;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    /* renamed from: a */
    private void m777a(boolean z) {
        this.f824F = z;
        int i = 8;
        boolean z2 = false;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f842a.getText());
        this.f845b.setVisibility(i2);
        m781b(z3);
        this.f853k.setVisibility(z ? 8 : 0);
        if (this.f862t.getDrawable() != null && !this.f823E) {
            i = 0;
        }
        this.f862t.setVisibility(i);
        m788o();
        if (!z3) {
            z2 = true;
        }
        m784c(z2);
        m787n();
    }

    /* renamed from: a */
    static boolean m778a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: b */
    private Intent m779b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f835Q;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        String str = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String str2 = null;
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str2 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str2);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: b */
    private void m780b(int i) {
        CharSequence b;
        Editable text = this.f842a.getText();
        Cursor a = this.f850g.mo3958a();
        if (a != null) {
            if (!a.moveToPosition(i) || (b = this.f850g.mo2338b(a)) == null) {
                setQuery(text);
            } else {
                setQuery(b);
            }
        }
    }

    /* renamed from: b */
    private void m781b(boolean z) {
        this.f846c.setVisibility((!this.f825G || !m786m() || !hasFocus() || (!z && this.f830L)) ? 8 : 0);
    }

    /* renamed from: b */
    private boolean m782b(int i, int i2, String str) {
        Cursor a = this.f850g.mo3958a();
        if (a == null || !a.moveToPosition(i)) {
            return false;
        }
        m775a(m773a(a, i2, str));
        return true;
    }

    /* renamed from: c */
    private CharSequence m783c(CharSequence charSequence) {
        if (!this.f823E || this.f863u == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f842a.getTextSize()) * 1.25d);
        this.f863u.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f863u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: c */
    private void m784c(boolean z) {
        int i;
        if (!this.f830L || mo1840c() || !z) {
            i = 8;
        } else {
            i = 0;
            this.f846c.setVisibility(8);
        }
        this.f848e.setVisibility(i);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0059a.C0063d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0059a.C0063d.abc_search_view_preferred_width);
    }

    /* renamed from: l */
    private boolean m785l() {
        SearchableInfo searchableInfo = this.f851h;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f851h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f866x;
        } else if (this.f851h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f867y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, PKIFailureInfo.notAuthorized) == null) ? false : true;
    }

    /* renamed from: m */
    private boolean m786m() {
        return (this.f825G || this.f830L) && !mo1840c();
    }

    /* renamed from: n */
    private void m787n() {
        this.f855m.setVisibility((!m786m() || !(this.f846c.getVisibility() == 0 || this.f848e.getVisibility() == 0)) ? 8 : 0);
    }

    /* renamed from: o */
    private void m788o() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f842a.getText());
        int i = 0;
        if (!z2 && (!this.f823E || this.f833O)) {
            z = false;
        }
        ImageView imageView = this.f847d;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f847d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: p */
    private void m789p() {
        post(this.f836R);
    }

    /* renamed from: q */
    private void m790q() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f842a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m783c(queryHint));
    }

    /* renamed from: r */
    private void m791r() {
        this.f842a.setThreshold(this.f851h.getSuggestThreshold());
        this.f842a.setImeOptions(this.f851h.getImeOptions());
        int inputType = this.f851h.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f851h.getSuggestAuthority() != null) {
                inputType = inputType | PKIFailureInfo.notAuthorized | PKIFailureInfo.signerNotTrusted;
            }
        }
        this.f842a.setInputType(inputType);
        C0692a aVar = this.f850g;
        if (aVar != null) {
            aVar.mo2336a((Cursor) null);
        }
        if (this.f851h.getSuggestAuthority() != null) {
            this.f850g = new C0293ar(getContext(), this, this.f851h, this.f838T);
            this.f842a.setAdapter(this.f850g);
            C0293ar arVar = (C0293ar) this.f850g;
            if (this.f827I) {
                i = 2;
            }
            arVar.mo2335a(i);
        }
    }

    /* renamed from: s */
    private void m792s() {
        this.f842a.dismissDropDown();
    }

    private void setQuery(CharSequence charSequence) {
        this.f842a.setText(charSequence);
        this.f842a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: a */
    public void mo1138a() {
        if (!this.f833O) {
            this.f833O = true;
            this.f834P = this.f842a.getImeOptions();
            this.f842a.setImeOptions(this.f834P | 33554432);
            this.f842a.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1833a(int i, String str, String str2) {
        getContext().startActivity(m774a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1834a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: a */
    public void mo1835a(CharSequence charSequence, boolean z) {
        this.f842a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f842a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f832N = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            mo1843e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1836a(int i) {
        C0237d dVar = this.f821C;
        if (dVar != null && dVar.mo1912a(i)) {
            return false;
        }
        m780b(i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1837a(int i, int i2, String str) {
        C0237d dVar = this.f821C;
        if (dVar != null && dVar.mo1913b(i)) {
            return false;
        }
        m782b(i, 0, (String) null);
        this.f842a.setImeVisibility(false);
        m792s();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1838a(View view, int i, KeyEvent keyEvent) {
        if (this.f851h != null && this.f850g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return mo1837a(this.f842a.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                this.f842a.setSelection(i == 21 ? 0 : this.f842a.length());
                this.f842a.setListSelection(0);
                this.f842a.clearListSelection();
                f818i.mo1907a(this.f842a, true);
                return true;
            } else if (i != 19 || this.f842a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo1139b() {
        mo1835a((CharSequence) "", false);
        clearFocus();
        m777a(true);
        this.f842a.setImeOptions(this.f834P);
        this.f833O = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1839b(CharSequence charSequence) {
        Editable text = this.f842a.getText();
        this.f832N = text;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(text);
        m781b(z2);
        if (z2) {
            z = false;
        }
        m784c(z);
        m788o();
        m787n();
        if (this.f819A != null && !TextUtils.equals(charSequence, this.f831M)) {
            this.f819A.mo1911b(charSequence.toString());
        }
        this.f831M = charSequence.toString();
    }

    /* renamed from: c */
    public boolean mo1840c() {
        return this.f824F;
    }

    public void clearFocus() {
        this.f828J = true;
        super.clearFocus();
        this.f842a.clearFocus();
        this.f842a.setImeVisibility(false);
        this.f828J = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1842d() {
        int[] iArr = this.f842a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f854l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f855m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo1843e() {
        Editable text = this.f842a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            C0236c cVar = this.f819A;
            if (cVar == null || !cVar.mo1910a(text.toString())) {
                if (this.f851h != null) {
                    mo1833a(0, (String) null, text.toString());
                }
                this.f842a.setImeVisibility(false);
                m792s();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo1844f() {
        if (!TextUtils.isEmpty(this.f842a.getText())) {
            this.f842a.setText("");
            this.f842a.requestFocus();
            this.f842a.setImeVisibility(true);
        } else if (this.f823E) {
            C0235b bVar = this.f820B;
            if (bVar == null || !bVar.mo1909a()) {
                clearFocus();
                m777a(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo1845g() {
        m777a(false);
        this.f842a.requestFocus();
        this.f842a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f822D;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public int getImeOptions() {
        return this.f842a.getImeOptions();
    }

    public int getInputType() {
        return this.f842a.getInputType();
    }

    public int getMaxWidth() {
        return this.f829K;
    }

    public CharSequence getQuery() {
        return this.f842a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f826H;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f851h;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f868z : getContext().getText(this.f851h.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.f865w;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.f864v;
    }

    public C0692a getSuggestionsAdapter() {
        return this.f850g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1854h() {
        Intent b;
        SearchableInfo searchableInfo = this.f851h;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    b = m772a(this.f866x, searchableInfo);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    b = m779b(this.f867y, searchableInfo);
                } else {
                    return;
                }
                getContext().startActivity(b);
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo1855i() {
        m777a(mo1840c());
        m789p();
        if (this.f842a.hasFocus()) {
            mo1857k();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo1856j() {
        if (this.f856n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f854l.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = C0313be.m1163a(this);
            int dimensionPixelSize = this.f823E ? resources.getDimensionPixelSize(C0059a.C0063d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(C0059a.C0063d.abc_dropdownitem_text_padding_left) : 0;
            this.f842a.getDropDownBackground().getPadding(rect);
            this.f842a.setDropDownHorizontalOffset(a ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f842a.setDropDownWidth((((this.f856n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo1857k() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f842a.refreshAutoCompleteResults();
            return;
        }
        f818i.mo1906a(this.f842a);
        f818i.mo1908b(this.f842a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f836R);
        post(this.f837S);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m776a((View) this.f842a, this.f858p);
            this.f859q.set(this.f858p.left, 0, this.f858p.right, i4 - i2);
            C0240f fVar = this.f857o;
            if (fVar == null) {
                this.f857o = new C0240f(this.f859q, this.f858p, this.f842a);
                setTouchDelegate(this.f857o);
                return;
            }
            fVar.mo1922a(this.f859q, this.f858p);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 <= 0) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.mo1840c()
            if (r0 == 0) goto L_0x000a
            super.onMeasure(r4, r5)
            return
        L_0x000a:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x002c
            if (r0 == 0) goto L_0x0022
            if (r0 == r2) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            int r0 = r3.f829K
            if (r0 <= 0) goto L_0x0039
            goto L_0x0030
        L_0x0022:
            int r4 = r3.f829K
            if (r4 <= 0) goto L_0x0027
            goto L_0x0039
        L_0x0027:
            int r4 = r3.getPreferredWidth()
            goto L_0x0039
        L_0x002c:
            int r0 = r3.f829K
            if (r0 <= 0) goto L_0x0031
        L_0x0030:
            goto L_0x0035
        L_0x0031:
            int r0 = r3.getPreferredWidth()
        L_0x0035:
            int r4 = java.lang.Math.min(r0, r4)
        L_0x0039:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x004b
            if (r0 == 0) goto L_0x0046
            goto L_0x0053
        L_0x0046:
            int r5 = r3.getPreferredHeight()
            goto L_0x0053
        L_0x004b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0053:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0238e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0238e eVar = (C0238e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        m777a(eVar.f887a);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0238e eVar = new C0238e(super.onSaveInstanceState());
        eVar.f887a = mo1840c();
        return eVar;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m789p();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f828J || !isFocusable()) {
            return false;
        }
        if (mo1840c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f842a.requestFocus(i, rect);
        if (requestFocus) {
            m777a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f835Q = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            mo1844f();
        } else {
            mo1845g();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f823E != z) {
            this.f823E = z;
            m777a(z);
            m790q();
        }
    }

    public void setImeOptions(int i) {
        this.f842a.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f842a.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f829K = i;
        requestLayout();
    }

    public void setOnCloseListener(C0235b bVar) {
        this.f820B = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f849f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(C0236c cVar) {
        this.f819A = cVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f822D = onClickListener;
    }

    public void setOnSuggestionListener(C0237d dVar) {
        this.f821C = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f826H = charSequence;
        m790q();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f827I = z;
        C0692a aVar = this.f850g;
        if (aVar instanceof C0293ar) {
            ((C0293ar) aVar).mo2335a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f851h = searchableInfo;
        if (this.f851h != null) {
            m791r();
            m790q();
        }
        this.f830L = m785l();
        if (this.f830L) {
            this.f842a.setPrivateImeOptions("nm");
        }
        m777a(mo1840c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f825G = z;
        m777a(mo1840c());
    }

    public void setSuggestionsAdapter(C0692a aVar) {
        this.f850g = aVar;
        this.f842a.setAdapter(this.f850g);
    }
}
