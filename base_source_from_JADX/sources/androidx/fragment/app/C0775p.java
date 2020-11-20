package androidx.fragment.app;

import androidx.lifecycle.C0947e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.p */
public abstract class C0775p {

    /* renamed from: d */
    ArrayList<C0776a> f2641d = new ArrayList<>();

    /* renamed from: e */
    int f2642e;

    /* renamed from: f */
    int f2643f;

    /* renamed from: g */
    int f2644g;

    /* renamed from: h */
    int f2645h;

    /* renamed from: i */
    int f2646i;

    /* renamed from: j */
    int f2647j;

    /* renamed from: k */
    boolean f2648k;

    /* renamed from: l */
    boolean f2649l = true;

    /* renamed from: m */
    String f2650m;

    /* renamed from: n */
    int f2651n;

    /* renamed from: o */
    CharSequence f2652o;

    /* renamed from: p */
    int f2653p;

    /* renamed from: q */
    CharSequence f2654q;

    /* renamed from: r */
    ArrayList<String> f2655r;

    /* renamed from: s */
    ArrayList<String> f2656s;

    /* renamed from: t */
    boolean f2657t = false;

    /* renamed from: u */
    ArrayList<Runnable> f2658u;

    /* renamed from: androidx.fragment.app.p$a */
    static final class C0776a {

        /* renamed from: a */
        int f2659a;

        /* renamed from: b */
        C0735d f2660b;

        /* renamed from: c */
        int f2661c;

        /* renamed from: d */
        int f2662d;

        /* renamed from: e */
        int f2663e;

        /* renamed from: f */
        int f2664f;

        /* renamed from: g */
        C0947e.C0949b f2665g;

        /* renamed from: h */
        C0947e.C0949b f2666h;

        C0776a() {
        }

        C0776a(int i, C0735d dVar) {
            this.f2659a = i;
            this.f2660b = dVar;
            this.f2665g = C0947e.C0949b.RESUMED;
            this.f2666h = C0947e.C0949b.RESUMED;
        }

        C0776a(int i, C0735d dVar, C0947e.C0949b bVar) {
            this.f2659a = i;
            this.f2660b = dVar;
            this.f2665g = dVar.mMaxState;
            this.f2666h = bVar;
        }
    }

    /* renamed from: a */
    public C0775p mo4522a(int i, C0735d dVar) {
        return mo4526b(i, dVar, (String) null);
    }

    /* renamed from: a */
    public C0775p mo4523a(int i, C0735d dVar, String str) {
        mo4063a(i, dVar, str, 1);
        return this;
    }

    /* renamed from: a */
    public C0775p mo4059a(C0735d dVar) {
        mo4525a(new C0776a(3, dVar));
        return this;
    }

    /* renamed from: a */
    public C0775p mo4060a(C0735d dVar, C0947e.C0949b bVar) {
        mo4525a(new C0776a(10, dVar, bVar));
        return this;
    }

    /* renamed from: a */
    public C0775p mo4524a(C0735d dVar, String str) {
        mo4063a(0, dVar, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4063a(int i, C0735d dVar, String str, int i2) {
        Class<?> cls = dVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (dVar.mTag == null || str.equals(dVar.mTag)) {
                dVar.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + dVar + ": was " + dVar.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + dVar + " with tag " + str + " to container view with no id");
            } else if (dVar.mFragmentId == 0 || dVar.mFragmentId == i) {
                dVar.mFragmentId = i;
                dVar.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + dVar + ": was " + dVar.mFragmentId + " now " + i);
            }
        }
        mo4525a(new C0776a(i2, dVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4525a(C0776a aVar) {
        this.f2641d.add(aVar);
        aVar.f2661c = this.f2642e;
        aVar.f2662d = this.f2643f;
        aVar.f2663e = this.f2644g;
        aVar.f2664f = this.f2645h;
    }

    /* renamed from: b */
    public abstract int mo4069b();

    /* renamed from: b */
    public C0775p mo4526b(int i, C0735d dVar, String str) {
        if (i != 0) {
            mo4063a(i, dVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    /* renamed from: b */
    public C0775p mo4071b(C0735d dVar) {
        mo4525a(new C0776a(6, dVar));
        return this;
    }

    /* renamed from: c */
    public abstract int mo4074c();

    /* renamed from: c */
    public C0775p mo4527c(C0735d dVar) {
        mo4525a(new C0776a(7, dVar));
        return this;
    }

    /* renamed from: d */
    public abstract void mo4075d();

    /* renamed from: e */
    public abstract void mo4076e();

    /* renamed from: i */
    public boolean mo4080i() {
        return this.f2641d.isEmpty();
    }

    /* renamed from: j */
    public C0775p mo4528j() {
        if (!this.f2648k) {
            this.f2649l = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
}
