package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0156b;
import androidx.core.p030h.C0638d;

/* renamed from: androidx.appcompat.app.h */
public class C0118h extends Dialog implements C0095e {
    private C0096f mDelegate;
    private final C0638d.C0639a mKeyDispatcher;

    public C0118h(Context context) {
        this(context, 0);
    }

    public C0118h(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new C0638d.C0639a() {
            public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return C0118h.this.superDispatchKeyEvent(keyEvent);
            }
        };
        C0096f delegate = getDelegate();
        delegate.mo849a(getThemeResId(context, i));
        delegate.mo852a((Bundle) null);
    }

    protected C0118h(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new C0638d.C0639a() {
            public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return C0118h.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0059a.C0060a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo860b(view, layoutParams);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0638d.m2526a(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().mo858b(i);
    }

    public C0096f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0096f.m127a((Dialog) this, (C0095e) this);
        }
        return this.mDelegate;
    }

    public C0086a getSupportActionBar() {
        return getDelegate().mo847a();
    }

    public void invalidateOptionsMenu() {
        getDelegate().mo867f();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().mo870i();
        super.onCreate(bundle);
        getDelegate().mo852a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().mo864d();
    }

    public void onSupportActionModeFinished(C0156b bVar) {
    }

    public void onSupportActionModeStarted(C0156b bVar) {
    }

    public C0156b onWindowStartingSupportActionMode(C0156b.C0157a aVar) {
        return null;
    }

    public void setContentView(int i) {
        getDelegate().mo862c(i);
    }

    public void setContentView(View view) {
        getDelegate().mo853a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo854a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().mo856a((CharSequence) getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().mo856a(charSequence);
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().mo865d(i);
    }
}
