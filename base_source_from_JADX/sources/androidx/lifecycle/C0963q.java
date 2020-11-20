package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.C0947e;

/* renamed from: androidx.lifecycle.q */
public class C0963q extends Fragment {

    /* renamed from: a */
    private C0964a f3103a;

    /* renamed from: androidx.lifecycle.q$a */
    interface C0964a {
        /* renamed from: a */
        void mo5132a();

        /* renamed from: b */
        void mo5133b();

        /* renamed from: c */
        void mo5134c();
    }

    /* renamed from: a */
    public static void m3750a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new C0963q(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m3751a(C0947e.C0948a aVar) {
        Activity activity = getActivity();
        if (activity instanceof C0956j) {
            ((C0956j) activity).mo5119a().mo5115a(aVar);
        } else if (activity instanceof C0952h) {
            C0947e lifecycle = ((C0952h) activity).getLifecycle();
            if (lifecycle instanceof C0953i) {
                ((C0953i) lifecycle).mo5115a(aVar);
            }
        }
    }

    /* renamed from: a */
    private void m3752a(C0964a aVar) {
        if (aVar != null) {
            aVar.mo5132a();
        }
    }

    /* renamed from: b */
    private void m3753b(C0964a aVar) {
        if (aVar != null) {
            aVar.mo5133b();
        }
    }

    /* renamed from: c */
    private void m3754c(C0964a aVar) {
        if (aVar != null) {
            aVar.mo5134c();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m3752a(this.f3103a);
        m3751a(C0947e.C0948a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        m3751a(C0947e.C0948a.ON_DESTROY);
        this.f3103a = null;
    }

    public void onPause() {
        super.onPause();
        m3751a(C0947e.C0948a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        m3754c(this.f3103a);
        m3751a(C0947e.C0948a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        m3753b(this.f3103a);
        m3751a(C0947e.C0948a.ON_START);
    }

    public void onStop() {
        super.onStop();
        m3751a(C0947e.C0948a.ON_STOP);
    }
}
