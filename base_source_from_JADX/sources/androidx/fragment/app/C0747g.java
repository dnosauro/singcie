package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p029g.C0588f;
import androidx.lifecycle.C0972v;

/* renamed from: androidx.fragment.app.g */
public class C0747g {

    /* renamed from: a */
    private final C0749i<?> f2540a;

    private C0747g(C0749i<?> iVar) {
        this.f2540a = iVar;
    }

    /* renamed from: a */
    public static C0747g m2984a(C0749i<?> iVar) {
        return new C0747g((C0749i) C0588f.m2267a(iVar, (Object) "callbacks == null"));
    }

    /* renamed from: a */
    public View mo4330a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2540a.f2543b.onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: a */
    public C0735d mo4331a(String str) {
        return this.f2540a.f2543b.mo4412b(str);
    }

    /* renamed from: a */
    public C0750j mo4332a() {
        return this.f2540a.f2543b;
    }

    /* renamed from: a */
    public void mo4333a(Configuration configuration) {
        this.f2540a.f2543b.mo4392a(configuration);
    }

    /* renamed from: a */
    public void mo4334a(Parcelable parcelable) {
        C0749i<?> iVar = this.f2540a;
        if (iVar instanceof C0972v) {
            iVar.f2543b.mo4394a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    /* renamed from: a */
    public void mo4335a(C0735d dVar) {
        C0753k kVar = this.f2540a.f2543b;
        C0749i<?> iVar = this.f2540a;
        kVar.mo4402a((C0749i) iVar, (C0746f) iVar, dVar);
    }

    /* renamed from: a */
    public void mo4336a(boolean z) {
        this.f2540a.f2543b.mo4404a(z);
    }

    /* renamed from: a */
    public boolean mo4337a(Menu menu) {
        return this.f2540a.f2543b.mo4406a(menu);
    }

    /* renamed from: a */
    public boolean mo4338a(Menu menu, MenuInflater menuInflater) {
        return this.f2540a.f2543b.mo4407a(menu, menuInflater);
    }

    /* renamed from: a */
    public boolean mo4339a(MenuItem menuItem) {
        return this.f2540a.f2543b.mo4408a(menuItem);
    }

    /* renamed from: b */
    public void mo4340b() {
        this.f2540a.f2543b.mo4451o();
    }

    /* renamed from: b */
    public void mo4341b(Menu menu) {
        this.f2540a.f2543b.mo4414b(menu);
    }

    /* renamed from: b */
    public void mo4342b(boolean z) {
        this.f2540a.f2543b.mo4420b(z);
    }

    /* renamed from: b */
    public boolean mo4343b(MenuItem menuItem) {
        return this.f2540a.f2543b.mo4421b(menuItem);
    }

    /* renamed from: c */
    public Parcelable mo4344c() {
        return this.f2540a.f2543b.mo4449n();
    }

    /* renamed from: d */
    public void mo4345d() {
        this.f2540a.f2543b.mo4455p();
    }

    /* renamed from: e */
    public void mo4346e() {
        this.f2540a.f2543b.mo4457q();
    }

    /* renamed from: f */
    public void mo4347f() {
        this.f2540a.f2543b.mo4459r();
    }

    /* renamed from: g */
    public void mo4348g() {
        this.f2540a.f2543b.mo4462s();
    }

    /* renamed from: h */
    public void mo4349h() {
        this.f2540a.f2543b.mo4463t();
    }

    /* renamed from: i */
    public void mo4350i() {
        this.f2540a.f2543b.mo4466u();
    }

    /* renamed from: j */
    public void mo4351j() {
        this.f2540a.f2543b.mo4468w();
    }

    /* renamed from: k */
    public void mo4352k() {
        this.f2540a.f2543b.mo4469x();
    }

    /* renamed from: l */
    public boolean mo4353l() {
        return this.f2540a.f2543b.mo4444k();
    }
}
