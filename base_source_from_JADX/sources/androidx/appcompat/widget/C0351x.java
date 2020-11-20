package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.C0092c;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.p030h.C0655t;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.appcompat.widget.x */
public class C0351x extends Spinner implements C0655t {

    /* renamed from: c */
    private static final int[] f1243c = {16843505};

    /* renamed from: a */
    int f1244a;

    /* renamed from: b */
    final Rect f1245b;

    /* renamed from: d */
    private final C0332f f1246d;

    /* renamed from: e */
    private final Context f1247e;

    /* renamed from: f */
    private C0263ai f1248f;

    /* renamed from: g */
    private SpinnerAdapter f1249g;

    /* renamed from: h */
    private final boolean f1250h;

    /* renamed from: i */
    private C0362e f1251i;

    /* renamed from: androidx.appcompat.widget.x$a */
    class C0354a implements DialogInterface.OnClickListener, C0362e {

        /* renamed from: a */
        C0092c f1255a;

        /* renamed from: c */
        private ListAdapter f1257c;

        /* renamed from: d */
        private CharSequence f1258d;

        C0354a() {
        }

        /* renamed from: a */
        public CharSequence mo2644a() {
            return this.f1258d;
        }

        /* renamed from: a */
        public void mo2645a(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        /* renamed from: a */
        public void mo2646a(int i, int i2) {
            if (this.f1257c != null) {
                C0092c.C0093a aVar = new C0092c.C0093a(C0351x.this.getPopupContext());
                CharSequence charSequence = this.f1258d;
                if (charSequence != null) {
                    aVar.setTitle(charSequence);
                }
                this.f1255a = aVar.setSingleChoiceItems(this.f1257c, C0351x.this.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                ListView a = this.f1255a.mo754a();
                if (Build.VERSION.SDK_INT >= 17) {
                    a.setTextDirection(i);
                    a.setTextAlignment(i2);
                }
                this.f1255a.show();
            }
        }

        /* renamed from: a */
        public void mo2647a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        /* renamed from: a */
        public void mo2648a(ListAdapter listAdapter) {
            this.f1257c = listAdapter;
        }

        /* renamed from: a */
        public void mo2649a(CharSequence charSequence) {
            this.f1258d = charSequence;
        }

        /* renamed from: b */
        public void mo2650b() {
            C0092c cVar = this.f1255a;
            if (cVar != null) {
                cVar.dismiss();
                this.f1255a = null;
            }
        }

        /* renamed from: b */
        public void mo2651b(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        /* renamed from: c */
        public void mo2652c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        /* renamed from: c */
        public boolean mo2653c() {
            C0092c cVar = this.f1255a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        /* renamed from: d */
        public Drawable mo2654d() {
            return null;
        }

        /* renamed from: e */
        public int mo2655e() {
            return 0;
        }

        /* renamed from: f */
        public int mo2656f() {
            return 0;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C0351x.this.setSelection(i);
            if (C0351x.this.getOnItemClickListener() != null) {
                C0351x.this.performItemClick((View) null, i, this.f1257c.getItemId(i));
            }
            mo2650b();
        }
    }

    /* renamed from: androidx.appcompat.widget.x$b */
    private static class C0355b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f1259a;

        /* renamed from: b */
        private ListAdapter f1260b;

        public C0355b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1259a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1260b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof C0298au) {
                C0298au auVar = (C0298au) spinnerAdapter;
                if (auVar.mo2399a() == null) {
                    auVar.mo2400a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1260b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1260b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1259a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.x$c */
    class C0356c extends C0268ak implements C0362e {

        /* renamed from: a */
        ListAdapter f1261a;

        /* renamed from: h */
        private CharSequence f1263h;

        /* renamed from: i */
        private final Rect f1264i = new Rect();

        /* renamed from: j */
        private int f1265j;

        public C0356c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            mo2207b((View) C0351x.this);
            mo2205a(true);
            mo2210d(0);
            mo2202a((AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener(C0351x.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    C0351x.this.setSelection(i);
                    if (C0351x.this.getOnItemClickListener() != null) {
                        C0351x.this.performItemClick(view, i, C0356c.this.f1261a.getItemId(i));
                    }
                    C0356c.this.mo1325b();
                }
            });
        }

        /* renamed from: a */
        public CharSequence mo2644a() {
            return this.f1263h;
        }

        /* renamed from: a */
        public void mo2646a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean c = mo1329c();
            mo2672g();
            mo2217i(2);
            super.mo1331j_();
            ListView k_ = mo1332k_();
            k_.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                k_.setTextDirection(i);
                k_.setTextAlignment(i2);
            }
            mo2220j(C0351x.this.getSelectedItemPosition());
            if (!c && (viewTreeObserver = C0351x.this.getViewTreeObserver()) != null) {
                final C03582 r6 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        C0356c cVar = C0356c.this;
                        if (!cVar.mo2671a((View) C0351x.this)) {
                            C0356c.this.mo1325b();
                            return;
                        }
                        C0356c.this.mo2672g();
                        C0356c.super.mo1331j_();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r6);
                mo2204a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = C0351x.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r6);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        public void mo2203a(ListAdapter listAdapter) {
            super.mo2203a(listAdapter);
            this.f1261a = listAdapter;
        }

        /* renamed from: a */
        public void mo2649a(CharSequence charSequence) {
            this.f1263h = charSequence;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo2671a(View view) {
            return C0656u.m2569B(view) && view.getGlobalVisibleRect(this.f1264i);
        }

        /* renamed from: c */
        public void mo2652c(int i) {
            this.f1265j = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo2672g() {
            int i;
            Drawable d = mo2209d();
            int i2 = 0;
            if (d != null) {
                d.getPadding(C0351x.this.f1245b);
                i2 = C0313be.m1163a(C0351x.this) ? C0351x.this.f1245b.right : -C0351x.this.f1245b.left;
            } else {
                Rect rect = C0351x.this.f1245b;
                C0351x.this.f1245b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = C0351x.this.getPaddingLeft();
            int paddingRight = C0351x.this.getPaddingRight();
            int width = C0351x.this.getWidth();
            if (C0351x.this.f1244a == -2) {
                int a = C0351x.this.mo2617a((SpinnerAdapter) this.f1261a, mo2209d());
                int i3 = (C0351x.this.getContext().getResources().getDisplayMetrics().widthPixels - C0351x.this.f1245b.left) - C0351x.this.f1245b.right;
                if (a > i3) {
                    a = i3;
                }
                i = Math.max(a, (width - paddingLeft) - paddingRight);
            } else {
                i = C0351x.this.f1244a == -1 ? (width - paddingLeft) - paddingRight : C0351x.this.f1244a;
            }
            mo2216h(i);
            mo2206b(C0313be.m1163a(C0351x.this) ? i2 + (((width - paddingRight) - mo2221k()) - mo2673h()) : i2 + paddingLeft + mo2673h());
        }

        /* renamed from: h */
        public int mo2673h() {
            return this.f1265j;
        }
    }

    /* renamed from: androidx.appcompat.widget.x$d */
    static class C0360d extends View.BaseSavedState {
        public static final Parcelable.Creator<C0360d> CREATOR = new Parcelable.Creator<C0360d>() {
            /* renamed from: a */
            public C0360d createFromParcel(Parcel parcel) {
                return new C0360d(parcel);
            }

            /* renamed from: a */
            public C0360d[] newArray(int i) {
                return new C0360d[i];
            }
        };

        /* renamed from: a */
        boolean f1271a;

        C0360d(Parcel parcel) {
            super(parcel);
            this.f1271a = parcel.readByte() != 0;
        }

        C0360d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f1271a ? (byte) 1 : 0);
        }
    }

    /* renamed from: androidx.appcompat.widget.x$e */
    interface C0362e {
        /* renamed from: a */
        CharSequence mo2644a();

        /* renamed from: a */
        void mo2645a(int i);

        /* renamed from: a */
        void mo2646a(int i, int i2);

        /* renamed from: a */
        void mo2647a(Drawable drawable);

        /* renamed from: a */
        void mo2648a(ListAdapter listAdapter);

        /* renamed from: a */
        void mo2649a(CharSequence charSequence);

        /* renamed from: b */
        void mo2650b();

        /* renamed from: b */
        void mo2651b(int i);

        /* renamed from: c */
        void mo2652c(int i);

        /* renamed from: c */
        boolean mo2653c();

        /* renamed from: d */
        Drawable mo2654d();

        /* renamed from: e */
        int mo2655e();

        /* renamed from: f */
        int mo2656f();
    }

    public C0351x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.spinnerStyle);
    }

    public C0351x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0351x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r11 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r11 != null) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036 A[SYNTHETIC, Splitter:B:10:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0351x(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1245b = r0
            int[] r0 = androidx.appcompat.C0059a.C0069j.Spinner
            r1 = 0
            androidx.appcompat.widget.ay r0 = androidx.appcompat.widget.C0302ay.m1078a(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.f r2 = new androidx.appcompat.widget.f
            r2.<init>(r6)
            r6.f1246d = r2
            if (r11 == 0) goto L_0x0022
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
        L_0x001f:
            r6.f1247e = r2
            goto L_0x0032
        L_0x0022:
            int r11 = androidx.appcompat.C0059a.C0069j.Spinner_popupTheme
            int r11 = r0.mo2423g(r11, r1)
            if (r11 == 0) goto L_0x0030
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>((android.content.Context) r7, (int) r11)
            goto L_0x001f
        L_0x0030:
            r6.f1247e = r7
        L_0x0032:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x0064
            int[] r11 = f1243c     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x004c }
            if (r3 == 0) goto L_0x0046
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x004c }
        L_0x0046:
            if (r11 == 0) goto L_0x0064
        L_0x0048:
            r11.recycle()
            goto L_0x0064
        L_0x004c:
            r3 = move-exception
            goto L_0x0053
        L_0x004e:
            r7 = move-exception
            r11 = r2
            goto L_0x005e
        L_0x0051:
            r3 = move-exception
            r11 = r2
        L_0x0053:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x0064
            goto L_0x0048
        L_0x005d:
            r7 = move-exception
        L_0x005e:
            if (r11 == 0) goto L_0x0063
            r11.recycle()
        L_0x0063:
            throw r7
        L_0x0064:
            switch(r10) {
                case 0: goto L_0x009f;
                case 1: goto L_0x0068;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x00b1
        L_0x0068:
            androidx.appcompat.widget.x$c r10 = new androidx.appcompat.widget.x$c
            android.content.Context r11 = r6.f1247e
            r10.<init>(r11, r8, r9)
            android.content.Context r11 = r6.f1247e
            int[] r3 = androidx.appcompat.C0059a.C0069j.Spinner
            androidx.appcompat.widget.ay r11 = androidx.appcompat.widget.C0302ay.m1078a(r11, r8, r3, r9, r1)
            int r1 = androidx.appcompat.C0059a.C0069j.Spinner_android_dropDownWidth
            r3 = -2
            int r1 = r11.mo2421f(r1, r3)
            r6.f1244a = r1
            int r1 = androidx.appcompat.C0059a.C0069j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r11.mo2409a(r1)
            r10.mo2201a((android.graphics.drawable.Drawable) r1)
            int r1 = androidx.appcompat.C0059a.C0069j.Spinner_android_prompt
            java.lang.String r1 = r0.mo2418d(r1)
            r10.mo2649a((java.lang.CharSequence) r1)
            r11.mo2410a()
            r6.f1251i = r10
            androidx.appcompat.widget.x$1 r11 = new androidx.appcompat.widget.x$1
            r11.<init>(r6, r10)
            r6.f1248f = r11
            goto L_0x00b1
        L_0x009f:
            androidx.appcompat.widget.x$a r10 = new androidx.appcompat.widget.x$a
            r10.<init>()
            r6.f1251i = r10
            androidx.appcompat.widget.x$e r10 = r6.f1251i
            int r11 = androidx.appcompat.C0059a.C0069j.Spinner_android_prompt
            java.lang.String r11 = r0.mo2418d(r11)
            r10.mo2649a((java.lang.CharSequence) r11)
        L_0x00b1:
            int r10 = androidx.appcompat.C0059a.C0069j.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.mo2422f(r10)
            if (r10 == 0) goto L_0x00c9
            android.widget.ArrayAdapter r11 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r11.<init>(r7, r1, r10)
            int r7 = androidx.appcompat.C0059a.C0066g.support_simple_spinner_dropdown_item
            r11.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r11)
        L_0x00c9:
            r0.mo2410a()
            r7 = 1
            r6.f1250h = r7
            android.widget.SpinnerAdapter r7 = r6.f1249g
            if (r7 == 0) goto L_0x00d8
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f1249g = r2
        L_0x00d8:
            androidx.appcompat.widget.f r7 = r6.f1246d
            r7.mo2504a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0351x.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2617a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.f1245b);
        return i2 + this.f1245b.left + this.f1245b.right;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2618a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1251i.mo2646a(getTextDirection(), getTextAlignment());
        } else {
            this.f1251i.mo2646a(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            fVar.mo2507c();
        }
    }

    public int getDropDownHorizontalOffset() {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            return eVar.mo2656f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            return eVar.mo2655e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f1251i != null) {
            return this.f1244a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final C0362e getInternalPopup() {
        return this.f1251i;
    }

    public Drawable getPopupBackground() {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            return eVar.mo2654d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f1247e;
    }

    public CharSequence getPrompt() {
        C0362e eVar = this.f1251i;
        return eVar != null ? eVar.mo2644a() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            return fVar.mo2499a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            return fVar.mo2505b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0362e eVar = this.f1251i;
        if (eVar != null && eVar.mo2653c()) {
            this.f1251i.mo2650b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1251i != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo2617a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        C0360d dVar = (C0360d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        if (dVar.f1271a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!C0351x.this.getInternalPopup().mo2653c()) {
                        C0351x.this.mo2618a();
                    }
                    ViewTreeObserver viewTreeObserver = C0351x.this.getViewTreeObserver();
                    if (viewTreeObserver == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        C0360d dVar = new C0360d(super.onSaveInstanceState());
        C0362e eVar = this.f1251i;
        dVar.f1271a = eVar != null && eVar.mo2653c();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0263ai aiVar = this.f1248f;
        if (aiVar == null || !aiVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        C0362e eVar = this.f1251i;
        if (eVar == null) {
            return super.performClick();
        }
        if (eVar.mo2653c()) {
            return true;
        }
        mo2618a();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1250h) {
            this.f1249g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1251i != null) {
            Context context = this.f1247e;
            if (context == null) {
                context = getContext();
            }
            this.f1251i.mo2648a((ListAdapter) new C0355b(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            fVar.mo2503a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            fVar.mo2500a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            eVar.mo2652c(i);
            this.f1251i.mo2651b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            eVar.mo2645a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f1251i != null) {
            this.f1244a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            eVar.mo2647a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0070a.m63b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        C0362e eVar = this.f1251i;
        if (eVar != null) {
            eVar.mo2649a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            fVar.mo2501a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0332f fVar = this.f1246d;
        if (fVar != null) {
            fVar.mo2502a(mode);
        }
    }
}
