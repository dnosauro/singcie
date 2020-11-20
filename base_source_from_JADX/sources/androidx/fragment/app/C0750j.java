package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: androidx.fragment.app.j */
public abstract class C0750j {

    /* renamed from: a */
    static final C0748h f2547a = new C0748h();

    /* renamed from: b */
    private C0748h f2548b = null;

    /* renamed from: androidx.fragment.app.j$a */
    public static abstract class C0751a {
        /* renamed from: a */
        public void mo4370a(C0750j jVar, C0735d dVar) {
        }

        /* renamed from: a */
        public void mo4371a(C0750j jVar, C0735d dVar, Context context) {
        }

        /* renamed from: a */
        public void mo4372a(C0750j jVar, C0735d dVar, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo4373a(C0750j jVar, C0735d dVar, View view, Bundle bundle) {
        }

        /* renamed from: b */
        public void mo4374b(C0750j jVar, C0735d dVar) {
        }

        /* renamed from: b */
        public void mo4375b(C0750j jVar, C0735d dVar, Context context) {
        }

        /* renamed from: b */
        public void mo4376b(C0750j jVar, C0735d dVar, Bundle bundle) {
        }

        /* renamed from: c */
        public void mo4377c(C0750j jVar, C0735d dVar) {
        }

        /* renamed from: c */
        public void mo4378c(C0750j jVar, C0735d dVar, Bundle bundle) {
        }

        /* renamed from: d */
        public void mo4379d(C0750j jVar, C0735d dVar) {
        }

        /* renamed from: d */
        public void mo4380d(C0750j jVar, C0735d dVar, Bundle bundle) {
        }

        /* renamed from: e */
        public void mo4381e(C0750j jVar, C0735d dVar) {
        }

        /* renamed from: f */
        public void mo4382f(C0750j jVar, C0735d dVar) {
        }

        /* renamed from: g */
        public void mo4383g(C0750j jVar, C0735d dVar) {
        }
    }

    /* renamed from: androidx.fragment.app.j$b */
    public interface C0752b {
        /* renamed from: a */
        void mo4384a();
    }

    /* renamed from: a */
    public abstract C0735d mo4358a(String str);

    /* renamed from: a */
    public abstract C0775p mo4359a();

    /* renamed from: a */
    public abstract void mo4360a(int i, int i2);

    /* renamed from: a */
    public void mo4361a(C0748h hVar) {
        this.f2548b = hVar;
    }

    /* renamed from: a */
    public abstract void mo4362a(C0751a aVar);

    /* renamed from: a */
    public abstract void mo4363a(C0751a aVar, boolean z);

    /* renamed from: a */
    public abstract void mo4364a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: b */
    public abstract boolean mo4365b();

    /* renamed from: c */
    public abstract List<C0735d> mo4366c();

    /* renamed from: d */
    public abstract boolean mo4367d();

    /* renamed from: e */
    public C0748h mo4368e() {
        if (this.f2548b == null) {
            this.f2548b = f2547a;
        }
        return this.f2548b;
    }

    /* renamed from: f */
    public abstract boolean mo4369f();
}
