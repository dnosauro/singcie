package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.C0090b;
import androidx.appcompat.view.C0156b;
import androidx.appcompat.widget.C0312bd;
import androidx.appcompat.widget.Toolbar;
import androidx.p018c.C0402b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* renamed from: androidx.appcompat.app.f */
public abstract class C0096f {

    /* renamed from: a */
    private static int f180a = -100;

    /* renamed from: b */
    private static final C0402b<WeakReference<C0096f>> f181b = new C0402b<>();

    /* renamed from: c */
    private static final Object f182c = new Object();

    C0096f() {
    }

    /* renamed from: a */
    public static C0096f m126a(Activity activity, C0095e eVar) {
        return new C0097g(activity, eVar);
    }

    /* renamed from: a */
    public static C0096f m127a(Dialog dialog, C0095e eVar) {
        return new C0097g(dialog, eVar);
    }

    /* renamed from: a */
    static void m128a(C0096f fVar) {
        synchronized (f182c) {
            m131c(fVar);
            f181b.add(new WeakReference(fVar));
        }
    }

    /* renamed from: a */
    public static void m129a(boolean z) {
        C0312bd.m1158a(z);
    }

    /* renamed from: b */
    static void m130b(C0096f fVar) {
        synchronized (f182c) {
            m131c(fVar);
        }
    }

    /* renamed from: c */
    private static void m131c(C0096f fVar) {
        synchronized (f182c) {
            Iterator<WeakReference<C0096f>> it = f181b.iterator();
            while (it.hasNext()) {
                C0096f fVar2 = (C0096f) it.next().get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: k */
    public static int m132k() {
        return f180a;
    }

    /* renamed from: a */
    public abstract C0086a mo847a();

    /* renamed from: a */
    public abstract C0156b mo848a(C0156b.C0157a aVar);

    /* renamed from: a */
    public void mo849a(int i) {
    }

    /* renamed from: a */
    public void mo850a(Context context) {
    }

    /* renamed from: a */
    public abstract void mo851a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo852a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo853a(View view);

    /* renamed from: a */
    public abstract void mo854a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo855a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo856a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo857b();

    /* renamed from: b */
    public abstract <T extends View> T mo858b(int i);

    /* renamed from: b */
    public abstract void mo859b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo860b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: c */
    public abstract void mo861c();

    /* renamed from: c */
    public abstract void mo862c(int i);

    /* renamed from: c */
    public abstract void mo863c(Bundle bundle);

    /* renamed from: d */
    public abstract void mo864d();

    /* renamed from: d */
    public abstract boolean mo865d(int i);

    /* renamed from: e */
    public abstract void mo866e();

    /* renamed from: f */
    public abstract void mo867f();

    /* renamed from: g */
    public abstract void mo868g();

    /* renamed from: h */
    public abstract C0090b.C0091a mo869h();

    /* renamed from: i */
    public abstract void mo870i();

    /* renamed from: j */
    public int mo871j() {
        return -100;
    }
}
