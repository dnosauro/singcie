package androidx.p043h.p044a;

import android.os.Bundle;
import android.util.Log;
import androidx.core.p029g.C0580a;
import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0960n;
import androidx.lifecycle.C0961o;
import androidx.lifecycle.C0967s;
import androidx.lifecycle.C0968t;
import androidx.lifecycle.C0971u;
import androidx.p018c.C0414h;
import androidx.p043h.p044a.C0795a;
import androidx.p043h.p045b.C0802a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.h.a.b */
class C0797b extends C0795a {

    /* renamed from: a */
    static boolean f2731a = false;

    /* renamed from: b */
    private final C0952h f2732b;

    /* renamed from: c */
    private final C0800c f2733c;

    /* renamed from: androidx.h.a.b$a */
    public static class C0798a<D> extends C0960n<D> implements C0802a.C0803a<D> {

        /* renamed from: e */
        private final int f2734e;

        /* renamed from: f */
        private final Bundle f2735f;

        /* renamed from: g */
        private final C0802a<D> f2736g;

        /* renamed from: h */
        private C0952h f2737h;

        /* renamed from: i */
        private C0799b<D> f2738i;

        /* renamed from: j */
        private C0802a<D> f2739j;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0802a<D> mo4579a(boolean z) {
            if (C0797b.f2731a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f2736g.mo4600c();
            this.f2736g.mo4604g();
            C0799b<D> bVar = this.f2738i;
            if (bVar != null) {
                mo4580a(bVar);
                if (z) {
                    bVar.mo4591b();
                }
            }
            this.f2736g.mo4597a(this);
            if ((bVar == null || bVar.mo4590a()) && !z) {
                return this.f2736g;
            }
            this.f2736g.mo4606i();
            return this.f2739j;
        }

        /* renamed from: a */
        public void mo4580a(C0961o<? super D> oVar) {
            super.mo4580a(oVar);
            this.f2737h = null;
            this.f2738i = null;
        }

        /* renamed from: a */
        public void mo4581a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2734e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2735f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f2736g);
            C0802a<D> aVar = this.f2736g;
            aVar.mo4598a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f2738i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f2738i);
                C0799b<D> bVar = this.f2738i;
                bVar.mo4589a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(mo4585e().mo4595a(mo5088a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(mo5092d());
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4582b() {
            if (C0797b.f2731a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f2736g.mo4596a();
        }

        /* renamed from: b */
        public void mo4583b(D d) {
            super.mo4583b(d);
            C0802a<D> aVar = this.f2739j;
            if (aVar != null) {
                aVar.mo4606i();
                this.f2739j = null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4584c() {
            if (C0797b.f2731a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f2736g.mo4602e();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public C0802a<D> mo4585e() {
            return this.f2736g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo4586f() {
            C0952h hVar = this.f2737h;
            C0799b<D> bVar = this.f2738i;
            if (hVar != null && bVar != null) {
                super.mo4580a(bVar);
                mo5090a(hVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2734e);
            sb.append(" : ");
            C0580a.m2253a(this.f2736g, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.h.a.b$b */
    static class C0799b<D> implements C0961o<D> {

        /* renamed from: a */
        private final C0802a<D> f2740a;

        /* renamed from: b */
        private final C0795a.C0796a<D> f2741b;

        /* renamed from: c */
        private boolean f2742c;

        /* renamed from: a */
        public void mo4588a(D d) {
            if (C0797b.f2731a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f2740a + ": " + this.f2740a.mo4595a(d));
            }
            this.f2741b.mo4577a(this.f2740a, d);
            this.f2742c = true;
        }

        /* renamed from: a */
        public void mo4589a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f2742c);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo4590a() {
            return this.f2742c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo4591b() {
            if (this.f2742c) {
                if (C0797b.f2731a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f2740a);
                }
                this.f2741b.mo4576a(this.f2740a);
            }
        }

        public String toString() {
            return this.f2741b.toString();
        }
    }

    /* renamed from: androidx.h.a.b$c */
    static class C0800c extends C0967s {

        /* renamed from: a */
        private static final C0968t.C0969a f2743a = new C0968t.C0969a() {
            /* renamed from: a */
            public <T extends C0967s> T mo4503a(Class<T> cls) {
                return new C0800c();
            }
        };

        /* renamed from: b */
        private C0414h<C0798a> f2744b = new C0414h<>();

        /* renamed from: c */
        private boolean f2745c = false;

        C0800c() {
        }

        /* renamed from: a */
        static C0800c m3314a(C0971u uVar) {
            return (C0800c) new C0968t(uVar, f2743a).mo5142a(C0800c.class);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4491a() {
            super.mo4491a();
            int b = this.f2744b.mo2971b();
            for (int i = 0; i < b; i++) {
                this.f2744b.mo2978d(i).mo4579a(true);
            }
            this.f2744b.mo2975c();
        }

        /* renamed from: a */
        public void mo4593a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2744b.mo2971b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f2744b.mo2971b(); i++) {
                    C0798a d = this.f2744b.mo2978d(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2744b.mo2974c(i));
                    printWriter.print(": ");
                    printWriter.println(d.toString());
                    d.mo4581a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo4594b() {
            int b = this.f2744b.mo2971b();
            for (int i = 0; i < b; i++) {
                this.f2744b.mo2978d(i).mo4586f();
            }
        }
    }

    C0797b(C0952h hVar, C0971u uVar) {
        this.f2732b = hVar;
        this.f2733c = C0800c.m3314a(uVar);
    }

    /* renamed from: a */
    public void mo4574a() {
        this.f2733c.mo4594b();
    }

    @Deprecated
    /* renamed from: a */
    public void mo4575a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2733c.mo4593a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0580a.m2253a(this.f2732b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
