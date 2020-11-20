package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0156b;

/* renamed from: androidx.appcompat.app.a */
public abstract class C0086a {

    /* renamed from: androidx.appcompat.app.a$a */
    public static class C0087a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f177a;

        public C0087a(int i, int i2) {
            super(i, i2);
            this.f177a = 0;
            this.f177a = 8388627;
        }

        public C0087a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f177a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.ActionBarLayout);
            this.f177a = obtainStyledAttributes.getInt(C0059a.C0069j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0087a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f177a = 0;
        }

        public C0087a(C0087a aVar) {
            super(aVar);
            this.f177a = 0;
            this.f177a = aVar.f177a;
        }
    }

    /* renamed from: androidx.appcompat.app.a$b */
    public interface C0088b {
        /* renamed from: a */
        void mo748a(boolean z);
    }

    @Deprecated
    /* renamed from: androidx.appcompat.app.a$c */
    public static abstract class C0089c {
        /* renamed from: a */
        public abstract Drawable mo749a();

        /* renamed from: b */
        public abstract CharSequence mo750b();

        /* renamed from: c */
        public abstract View mo751c();

        /* renamed from: d */
        public abstract void mo752d();

        /* renamed from: e */
        public abstract CharSequence mo753e();
    }

    /* renamed from: a */
    public abstract int mo729a();

    /* renamed from: a */
    public C0156b mo730a(C0156b.C0157a aVar) {
        return null;
    }

    /* renamed from: a */
    public void mo731a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* renamed from: a */
    public void mo732a(Configuration configuration) {
    }

    /* renamed from: a */
    public void mo733a(CharSequence charSequence) {
    }

    /* renamed from: a */
    public abstract void mo734a(boolean z);

    /* renamed from: a */
    public boolean mo735a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    public boolean mo736a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public Context mo737b() {
        return null;
    }

    /* renamed from: b */
    public void mo738b(boolean z) {
    }

    /* renamed from: c */
    public void mo739c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: c */
    public boolean mo740c() {
        return false;
    }

    /* renamed from: d */
    public void mo741d(boolean z) {
    }

    /* renamed from: d */
    public boolean mo742d() {
        return false;
    }

    /* renamed from: e */
    public void mo743e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo744e() {
        return false;
    }

    /* renamed from: f */
    public void mo745f(boolean z) {
    }

    /* renamed from: f */
    public boolean mo746f() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo747g() {
    }
}
