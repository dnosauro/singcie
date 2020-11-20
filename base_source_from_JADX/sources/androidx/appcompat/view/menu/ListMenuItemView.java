package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0200n;
import androidx.appcompat.widget.C0302ay;
import androidx.core.p030h.C0656u;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, C0200n.C0201a {

    /* renamed from: a */
    private C0187i f514a;

    /* renamed from: b */
    private ImageView f515b;

    /* renamed from: c */
    private RadioButton f516c;

    /* renamed from: d */
    private TextView f517d;

    /* renamed from: e */
    private CheckBox f518e;

    /* renamed from: f */
    private TextView f519f;

    /* renamed from: g */
    private ImageView f520g;

    /* renamed from: h */
    private ImageView f521h;

    /* renamed from: i */
    private LinearLayout f522i;

    /* renamed from: j */
    private Drawable f523j;

    /* renamed from: k */
    private int f524k;

    /* renamed from: l */
    private Context f525l;

    /* renamed from: m */
    private boolean f526m;

    /* renamed from: n */
    private Drawable f527n;

    /* renamed from: o */
    private boolean f528o;

    /* renamed from: p */
    private int f529p;

    /* renamed from: q */
    private LayoutInflater f530q;

    /* renamed from: r */
    private boolean f531r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0302ay a = C0302ay.m1078a(getContext(), attributeSet, C0059a.C0069j.MenuView, i, 0);
        this.f523j = a.mo2409a(C0059a.C0069j.MenuView_android_itemBackground);
        this.f524k = a.mo2423g(C0059a.C0069j.MenuView_android_itemTextAppearance, -1);
        this.f526m = a.mo2411a(C0059a.C0069j.MenuView_preserveIconSpacing, false);
        this.f525l = context;
        this.f527n = a.mo2409a(C0059a.C0069j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, C0059a.C0060a.dropDownListViewStyle, 0);
        this.f528o = obtainStyledAttributes.hasValue(0);
        a.mo2410a();
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m534a() {
        this.f515b = (ImageView) getInflater().inflate(C0059a.C0066g.abc_list_menu_item_icon, this, false);
        m536a((View) this.f515b, 0);
    }

    /* renamed from: a */
    private void m535a(View view) {
        m536a(view, -1);
    }

    /* renamed from: a */
    private void m536a(View view, int i) {
        LinearLayout linearLayout = this.f522i;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    /* renamed from: b */
    private void m537b() {
        this.f516c = (RadioButton) getInflater().inflate(C0059a.C0066g.abc_list_menu_item_radio, this, false);
        m535a(this.f516c);
    }

    /* renamed from: c */
    private void m538c() {
        this.f518e = (CheckBox) getInflater().inflate(C0059a.C0066g.abc_list_menu_item_checkbox, this, false);
        m535a(this.f518e);
    }

    private LayoutInflater getInflater() {
        if (this.f530q == null) {
            this.f530q = LayoutInflater.from(getContext());
        }
        return this.f530q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f520g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void mo1226a(boolean z, char c) {
        int i = (!z || !this.f514a.mo1466f()) ? 8 : 0;
        if (i == 0) {
            this.f519f.setText(this.f514a.mo1464e());
        }
        if (this.f519f.getVisibility() != i) {
            this.f519f.setVisibility(i);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f521h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f521h.getLayoutParams();
            rect.top += this.f521h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public C0187i getItemData() {
        return this.f514a;
    }

    public void initialize(C0187i iVar, int i) {
        this.f514a = iVar;
        this.f529p = i;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.mo1453a((C0200n.C0201a) this));
        setCheckable(iVar.isCheckable());
        mo1226a(iVar.mo1466f(), iVar.mo1462d());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C0656u.m2590a((View) this, this.f523j);
        this.f517d = (TextView) findViewById(C0059a.C0065f.title);
        int i = this.f524k;
        if (i != -1) {
            this.f517d.setTextAppearance(this.f525l, i);
        }
        this.f519f = (TextView) findViewById(C0059a.C0065f.shortcut);
        this.f520g = (ImageView) findViewById(C0059a.C0065f.submenuarrow);
        ImageView imageView = this.f520g;
        if (imageView != null) {
            imageView.setImageDrawable(this.f527n);
        }
        this.f521h = (ImageView) findViewById(C0059a.C0065f.group_divider);
        this.f522i = (LinearLayout) findViewById(C0059a.C0065f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f515b != null && this.f526m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f515b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f516c != null || this.f518e != null) {
            if (this.f514a.mo1467g()) {
                if (this.f516c == null) {
                    m537b();
                }
                compoundButton2 = this.f516c;
                compoundButton = this.f518e;
            } else {
                if (this.f518e == null) {
                    m538c();
                }
                compoundButton2 = this.f518e;
                compoundButton = this.f516c;
            }
            if (z) {
                compoundButton2.setChecked(this.f514a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f518e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f516c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f514a.mo1467g()) {
            if (this.f516c == null) {
                m537b();
            }
            compoundButton = this.f516c;
        } else {
            if (this.f518e == null) {
                m538c();
            }
            compoundButton = this.f518e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f531r = z;
        this.f526m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f521h;
        if (imageView != null) {
            imageView.setVisibility((this.f528o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f514a.mo1482i() || this.f531r;
        if (!z && !this.f526m) {
            return;
        }
        if (this.f515b != null || drawable != null || this.f526m) {
            if (this.f515b == null) {
                m534a();
            }
            if (drawable != null || this.f526m) {
                ImageView imageView = this.f515b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f515b.getVisibility() != 0) {
                    this.f515b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f515b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i;
        if (charSequence != null) {
            this.f517d.setText(charSequence);
            if (this.f517d.getVisibility() != 0) {
                textView = this.f517d;
                i = 0;
            } else {
                return;
            }
        } else {
            i = 8;
            if (this.f517d.getVisibility() != 8) {
                textView = this.f517d;
            } else {
                return;
            }
        }
        textView.setVisibility(i);
    }
}
