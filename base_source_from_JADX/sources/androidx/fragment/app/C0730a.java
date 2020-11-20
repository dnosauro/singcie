package androidx.fragment.app;

import android.util.Log;
import androidx.core.p029g.C0581b;
import androidx.fragment.app.C0735d;
import androidx.fragment.app.C0753k;
import androidx.fragment.app.C0775p;
import androidx.lifecycle.C0947e;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a */
final class C0730a extends C0775p implements C0753k.C0765e {

    /* renamed from: a */
    final C0753k f2497a;

    /* renamed from: b */
    boolean f2498b;

    /* renamed from: c */
    int f2499c = -1;

    public C0730a(C0753k kVar) {
        this.f2497a = kVar;
    }

    /* renamed from: b */
    private static boolean m2931b(C0775p.C0776a aVar) {
        C0735d dVar = aVar.f2660b;
        return dVar != null && dVar.mAdded && dVar.mView != null && !dVar.mDetached && !dVar.mHidden && dVar.isPostponed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo4057a(boolean z) {
        if (!this.f2498b) {
            if (C0753k.f2551b) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new C0581b("FragmentManager"));
                mo4065a("  ", printWriter);
                printWriter.close();
            }
            this.f2498b = true;
            this.f2499c = this.f2648k ? this.f2497a.mo4387a(this) : -1;
            this.f2497a.mo4403a((C0753k.C0765e) this, z);
            return this.f2499c;
        }
        throw new IllegalStateException("commit already called");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0735d mo4058a(ArrayList<C0735d> arrayList, C0735d dVar) {
        C0735d dVar2 = dVar;
        int i = 0;
        while (i < this.f2641d.size()) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i);
            switch (aVar.f2659a) {
                case 1:
                case 7:
                    arrayList.add(aVar.f2660b);
                    break;
                case 2:
                    C0735d dVar3 = aVar.f2660b;
                    int i2 = dVar3.mContainerId;
                    C0735d dVar4 = dVar2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        C0735d dVar5 = arrayList.get(size);
                        if (dVar5.mContainerId == i2) {
                            if (dVar5 == dVar3) {
                                z = true;
                            } else {
                                if (dVar5 == dVar4) {
                                    this.f2641d.add(i3, new C0775p.C0776a(9, dVar5));
                                    i3++;
                                    dVar4 = null;
                                }
                                C0775p.C0776a aVar2 = new C0775p.C0776a(3, dVar5);
                                aVar2.f2661c = aVar.f2661c;
                                aVar2.f2663e = aVar.f2663e;
                                aVar2.f2662d = aVar.f2662d;
                                aVar2.f2664f = aVar.f2664f;
                                this.f2641d.add(i3, aVar2);
                                arrayList.remove(dVar5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.f2641d.remove(i3);
                        i3--;
                    } else {
                        aVar.f2659a = 1;
                        arrayList.add(dVar3);
                    }
                    i = i3;
                    dVar2 = dVar4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.f2660b);
                    if (aVar.f2660b != dVar2) {
                        break;
                    } else {
                        this.f2641d.add(i, new C0775p.C0776a(9, aVar.f2660b));
                        i++;
                        dVar2 = null;
                        break;
                    }
                case 8:
                    this.f2641d.add(i, new C0775p.C0776a(9, dVar2));
                    i++;
                    dVar2 = aVar.f2660b;
                    break;
            }
            i++;
        }
        return dVar2;
    }

    /* renamed from: a */
    public C0775p mo4059a(C0735d dVar) {
        if (dVar.mFragmentManager == null || dVar.mFragmentManager == this.f2497a) {
            return super.mo4059a(dVar);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + dVar.toString() + " is already attached to a FragmentManager.");
    }

    /* renamed from: a */
    public C0775p mo4060a(C0735d dVar, C0947e.C0949b bVar) {
        if (dVar.mFragmentManager != this.f2497a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f2497a);
        } else if (bVar.mo5114a(C0947e.C0949b.CREATED)) {
            return super.mo4060a(dVar, bVar);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + C0947e.C0949b.CREATED);
        }
    }

    /* renamed from: a */
    public void mo4061a() {
        if (this.f2658u != null) {
            for (int i = 0; i < this.f2658u.size(); i++) {
                ((Runnable) this.f2658u.get(i)).run();
            }
            this.f2658u = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4062a(int i) {
        if (this.f2648k) {
            if (C0753k.f2551b) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f2641d.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i2);
                if (aVar.f2660b != null) {
                    aVar.f2660b.mBackStackNesting += i;
                    if (C0753k.f2551b) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2660b + " to " + aVar.f2660b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4063a(int i, C0735d dVar, String str, int i2) {
        super.mo4063a(i, dVar, str, i2);
        dVar.mFragmentManager = this.f2497a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4064a(C0735d.C0741c cVar) {
        for (int i = 0; i < this.f2641d.size(); i++) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i);
            if (m2931b(aVar)) {
                aVar.f2660b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    /* renamed from: a */
    public void mo4065a(String str, PrintWriter printWriter) {
        mo4066a(str, printWriter, true);
    }

    /* renamed from: a */
    public void mo4066a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2650m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2499c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2498b);
            if (this.f2646i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2646i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f2647j));
            }
            if (!(this.f2642e == 0 && this.f2643f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2642e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2643f));
            }
            if (!(this.f2644g == 0 && this.f2645h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2644g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2645h));
            }
            if (!(this.f2651n == 0 && this.f2652o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2651n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2652o);
            }
            if (!(this.f2653p == 0 && this.f2654q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2653p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2654q);
            }
        }
        if (!this.f2641d.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2641d.size();
            for (int i = 0; i < size; i++) {
                C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i);
                switch (aVar.f2659a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2659a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2660b);
                if (z) {
                    if (!(aVar.f2661c == 0 && aVar.f2662d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2661c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2662d));
                    }
                    if (aVar.f2663e != 0 || aVar.f2664f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2663e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2664f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4067a(ArrayList<C0730a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f2641d.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i4);
            int i5 = aVar.f2660b != null ? aVar.f2660b.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0730a aVar2 = arrayList.get(i6);
                    int size2 = aVar2.f2641d.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        C0775p.C0776a aVar3 = (C0775p.C0776a) aVar2.f2641d.get(i7);
                        if ((aVar3.f2660b != null ? aVar3.f2660b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo4068a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2) {
        if (C0753k.f2551b) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.f2648k) {
            return true;
        }
        this.f2497a.mo4415b(this);
        return true;
    }

    /* renamed from: b */
    public int mo4069b() {
        return mo4057a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0735d mo4070b(ArrayList<C0735d> arrayList, C0735d dVar) {
        for (int size = this.f2641d.size() - 1; size >= 0; size--) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(size);
            int i = aVar.f2659a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            dVar = null;
                            break;
                        case 9:
                            dVar = aVar.f2660b;
                            break;
                        case 10:
                            aVar.f2666h = aVar.f2665g;
                            break;
                    }
                }
                arrayList.add(aVar.f2660b);
            }
            arrayList.remove(aVar.f2660b);
        }
        return dVar;
    }

    /* renamed from: b */
    public C0775p mo4071b(C0735d dVar) {
        if (dVar.mFragmentManager == null || dVar.mFragmentManager == this.f2497a) {
            return super.mo4071b(dVar);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + dVar.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4072b(boolean z) {
        for (int size = this.f2641d.size() - 1; size >= 0; size--) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(size);
            C0735d dVar = aVar.f2660b;
            if (dVar != null) {
                dVar.setNextTransition(C0753k.m3078d(this.f2646i), this.f2647j);
            }
            int i = aVar.f2659a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        dVar.setNextAnim(aVar.f2663e);
                        this.f2497a.mo4401a(dVar, false);
                        break;
                    case 4:
                        dVar.setNextAnim(aVar.f2663e);
                        this.f2497a.mo4452o(dVar);
                        break;
                    case 5:
                        dVar.setNextAnim(aVar.f2664f);
                        this.f2497a.mo4450n(dVar);
                        break;
                    case 6:
                        dVar.setNextAnim(aVar.f2663e);
                        this.f2497a.mo4458q(dVar);
                        break;
                    case 7:
                        dVar.setNextAnim(aVar.f2664f);
                        this.f2497a.mo4456p(dVar);
                        break;
                    case 8:
                        this.f2497a.mo4464t((C0735d) null);
                        break;
                    case 9:
                        this.f2497a.mo4464t(dVar);
                        break;
                    case 10:
                        this.f2497a.mo4400a(dVar, aVar.f2665g);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f2659a);
                }
            } else {
                dVar.setNextAnim(aVar.f2664f);
                this.f2497a.mo4448m(dVar);
            }
            if (!(this.f2657t || aVar.f2659a == 3 || dVar == null)) {
                this.f2497a.mo4442j(dVar);
            }
        }
        if (!this.f2657t && z) {
            C0753k kVar = this.f2497a;
            kVar.mo4391a(kVar.f2569m, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4073b(int i) {
        int size = this.f2641d.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i2);
            int i3 = aVar.f2660b != null ? aVar.f2660b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public int mo4074c() {
        return mo4057a(true);
    }

    /* renamed from: d */
    public void mo4075d() {
        mo4528j();
        this.f2497a.mo4419b((C0753k.C0765e) this, false);
    }

    /* renamed from: e */
    public void mo4076e() {
        mo4528j();
        this.f2497a.mo4419b((C0753k.C0765e) this, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo4077f() {
        int size = this.f2641d.size();
        for (int i = 0; i < size; i++) {
            C0775p.C0776a aVar = (C0775p.C0776a) this.f2641d.get(i);
            C0735d dVar = aVar.f2660b;
            if (dVar != null) {
                dVar.setNextTransition(this.f2646i, this.f2647j);
            }
            int i2 = aVar.f2659a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        dVar.setNextAnim(aVar.f2662d);
                        this.f2497a.mo4448m(dVar);
                        break;
                    case 4:
                        dVar.setNextAnim(aVar.f2662d);
                        this.f2497a.mo4450n(dVar);
                        break;
                    case 5:
                        dVar.setNextAnim(aVar.f2661c);
                        this.f2497a.mo4452o(dVar);
                        break;
                    case 6:
                        dVar.setNextAnim(aVar.f2662d);
                        this.f2497a.mo4456p(dVar);
                        break;
                    case 7:
                        dVar.setNextAnim(aVar.f2661c);
                        this.f2497a.mo4458q(dVar);
                        break;
                    case 8:
                        this.f2497a.mo4464t(dVar);
                        break;
                    case 9:
                        this.f2497a.mo4464t((C0735d) null);
                        break;
                    case 10:
                        this.f2497a.mo4400a(dVar, aVar.f2666h);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f2659a);
                }
            } else {
                dVar.setNextAnim(aVar.f2661c);
                this.f2497a.mo4401a(dVar, false);
            }
            if (!(this.f2657t || aVar.f2659a == 1 || dVar == null)) {
                this.f2497a.mo4442j(dVar);
            }
        }
        if (!this.f2657t) {
            C0753k kVar = this.f2497a;
            kVar.mo4391a(kVar.f2569m, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo4078g() {
        for (int i = 0; i < this.f2641d.size(); i++) {
            if (m2931b((C0775p.C0776a) this.f2641d.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public String mo4079h() {
        return this.f2650m;
    }

    /* renamed from: i */
    public boolean mo4080i() {
        return this.f2641d.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2499c >= 0) {
            sb.append(" #");
            sb.append(this.f2499c);
        }
        if (this.f2650m != null) {
            sb.append(" ");
            sb.append(this.f2650m);
        }
        sb.append("}");
        return sb.toString();
    }
}
