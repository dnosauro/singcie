package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0182f;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0187i;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.am */
public class C0277am extends C0268ak implements C0276al {

    /* renamed from: a */
    private static Method f1009a;

    /* renamed from: b */
    private C0276al f1010b;

    /* renamed from: androidx.appcompat.widget.am$a */
    public static class C0278a extends C0258ag {

        /* renamed from: b */
        final int f1011b;

        /* renamed from: c */
        final int f1012c;

        /* renamed from: d */
        private C0276al f1013d;

        /* renamed from: e */
        private MenuItem f1014e;

        public C0278a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1011b = 22;
                this.f1012c = 21;
                return;
            }
            this.f1011b = 21;
            this.f1012c = 22;
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ int mo2132a(int i, int i2, int i3, int i4, int i5) {
            return super.mo2132a(i, i2, i3, i4, i5);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2133a(MotionEvent motionEvent, int i) {
            return super.mo2133a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            int pointToPosition;
            int i2;
            if (this.f1013d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                }
                C0182f fVar = (C0182f) adapter;
                C0187i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < fVar.getCount()) {
                    iVar = fVar.getItem(i2);
                }
                MenuItem menuItem = this.f1014e;
                if (menuItem != iVar) {
                    C0183g a = fVar.mo1356a();
                    if (menuItem != null) {
                        this.f1013d.mo1340a(a, menuItem);
                    }
                    this.f1014e = iVar;
                    if (iVar != null) {
                        this.f1013d.mo1341b(a, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f1011b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f1012c) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0182f) getAdapter()).mo1356a().close(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(C0276al alVar) {
            this.f1013d = alVar;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1009a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public C0277am(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0258ag mo2198a(Context context, boolean z) {
        C0278a aVar = new C0278a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    /* renamed from: a */
    public void mo1340a(C0183g gVar, MenuItem menuItem) {
        C0276al alVar = this.f1010b;
        if (alVar != null) {
            alVar.mo1340a(gVar, menuItem);
        }
    }

    /* renamed from: a */
    public void mo2234a(C0276al alVar) {
        this.f1010b = alVar;
    }

    /* renamed from: a */
    public void mo2235a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f983g.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void mo1341b(C0183g gVar, MenuItem menuItem) {
        C0276al alVar = this.f1010b;
        if (alVar != null) {
            alVar.mo1341b(gVar, menuItem);
        }
    }

    /* renamed from: b */
    public void mo2236b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f983g.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: c */
    public void mo2237c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1009a;
            if (method != null) {
                try {
                    method.invoke(this.f983g, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f983g.setTouchModal(z);
        }
    }
}
