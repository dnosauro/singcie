package androidx.p043h.p045b;

import androidx.core.p029g.C0580a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.h.b.a */
public class C0802a<D> {

    /* renamed from: a */
    int f2746a;

    /* renamed from: b */
    C0803a<D> f2747b;

    /* renamed from: c */
    boolean f2748c;

    /* renamed from: d */
    boolean f2749d;

    /* renamed from: e */
    boolean f2750e;

    /* renamed from: f */
    boolean f2751f;

    /* renamed from: g */
    boolean f2752g;

    /* renamed from: androidx.h.b.a$a */
    public interface C0803a<D> {
    }

    /* renamed from: a */
    public String mo4595a(D d) {
        StringBuilder sb = new StringBuilder(64);
        C0580a.m2253a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo4596a() {
        this.f2748c = true;
        this.f2750e = false;
        this.f2749d = false;
        mo4599b();
    }

    /* renamed from: a */
    public void mo4597a(C0803a<D> aVar) {
        C0803a<D> aVar2 = this.f2747b;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (aVar2 == aVar) {
            this.f2747b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    @Deprecated
    /* renamed from: a */
    public void mo4598a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f2746a);
        printWriter.print(" mListener=");
        printWriter.println(this.f2747b);
        if (this.f2748c || this.f2751f || this.f2752g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f2748c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f2751f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f2752g);
        }
        if (this.f2749d || this.f2750e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f2749d);
            printWriter.print(" mReset=");
            printWriter.println(this.f2750e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4599b() {
    }

    /* renamed from: c */
    public boolean mo4600c() {
        return mo4601d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo4601d() {
        return false;
    }

    /* renamed from: e */
    public void mo4602e() {
        this.f2748c = false;
        mo4603f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo4603f() {
    }

    /* renamed from: g */
    public void mo4604g() {
        this.f2749d = true;
        mo4605h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo4605h() {
    }

    /* renamed from: i */
    public void mo4606i() {
        mo4607j();
        this.f2750e = true;
        this.f2748c = false;
        this.f2749d = false;
        this.f2751f = false;
        this.f2752g = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo4607j() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0580a.m2253a(this, sb);
        sb.append(" id=");
        sb.append(this.f2746a);
        sb.append("}");
        return sb.toString();
    }
}
