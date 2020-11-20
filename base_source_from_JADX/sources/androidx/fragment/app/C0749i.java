package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.C0490a;
import androidx.core.p029g.C0588f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.i */
public abstract class C0749i<E> extends C0746f {

    /* renamed from: a */
    private final Activity f2542a;

    /* renamed from: b */
    final C0753k f2543b;

    /* renamed from: c */
    private final Context f2544c;

    /* renamed from: d */
    private final Handler f2545d;

    /* renamed from: e */
    private final int f2546e;

    C0749i(Activity activity, Context context, Handler handler, int i) {
        this.f2543b = new C0753k();
        this.f2542a = activity;
        this.f2544c = (Context) C0588f.m2267a(context, (Object) "context == null");
        this.f2545d = (Handler) C0588f.m2267a(handler, (Object) "handler == null");
        this.f2546e = i;
    }

    C0749i(C0744e eVar) {
        this(eVar, eVar, new Handler(), 0);
    }

    /* renamed from: a */
    public View mo4272a(int i) {
        return null;
    }

    /* renamed from: a */
    public void mo4316a(C0735d dVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f2544c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    /* renamed from: a */
    public void mo4317a(C0735d dVar, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i == -1) {
            C0490a.m1948a(this.f2542a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    /* renamed from: a */
    public void mo4318a(C0735d dVar, String[] strArr, int i) {
    }

    /* renamed from: a */
    public void mo4319a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public boolean mo4273a() {
        return true;
    }

    /* renamed from: a */
    public boolean mo4320a(C0735d dVar) {
        return true;
    }

    /* renamed from: a */
    public boolean mo4321a(String str) {
        return false;
    }

    /* renamed from: b */
    public LayoutInflater mo4322b() {
        return LayoutInflater.from(this.f2544c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4323b(C0735d dVar) {
    }

    /* renamed from: d */
    public void mo4325d() {
    }

    /* renamed from: e */
    public boolean mo4326e() {
        return true;
    }

    /* renamed from: f */
    public int mo4327f() {
        return this.f2546e;
    }

    /* renamed from: g */
    public abstract E mo4328g();

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Activity mo4355h() {
        return this.f2542a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Context mo4356i() {
        return this.f2544c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public Handler mo4357j() {
        return this.f2545d;
    }
}
