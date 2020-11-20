package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.widget.C0302ay;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, C0183g.C0185b, C0200n {

    /* renamed from: a */
    private static final int[] f511a = {16842964, 16843049};

    /* renamed from: b */
    private C0183g f512b;

    /* renamed from: c */
    private int f513c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0302ay a = C0302ay.m1078a(context, attributeSet, f511a, i, 0);
        if (a.mo2424g(0)) {
            setBackgroundDrawable(a.mo2409a(0));
        }
        if (a.mo2424g(1)) {
            setDivider(a.mo2409a(1));
        }
        a.mo2410a();
    }

    /* renamed from: a */
    public boolean mo1221a(C0187i iVar) {
        return this.f512b.performItemAction(iVar, 0);
    }

    public int getWindowAnimations() {
        return this.f513c;
    }

    public void initialize(C0183g gVar) {
        this.f512b = gVar;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo1221a((C0187i) getAdapter().getItem(i));
    }
}
