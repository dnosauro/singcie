package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.C0054b;
import androidx.activity.C0058d;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.C0490a;
import androidx.core.app.C0521n;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0953i;
import androidx.lifecycle.C0971u;
import androidx.lifecycle.C0972v;
import androidx.p018c.C0414h;
import androidx.p043h.p044a.C0795a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.e */
public class C0744e extends C0054b implements C0490a.C0492a, C0490a.C0494c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0953i mFragmentLifecycleRegistry = new C0953i(this);
    final C0747g mFragments = C0747g.m2984a((C0749i<?>) new C0745a());
    int mNextCandidateRequestIndex;
    C0414h<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;

    /* renamed from: androidx.fragment.app.e$a */
    class C0745a extends C0749i<C0744e> implements C0058d, C0972v {
        public C0745a() {
            super(C0744e.this);
        }

        /* renamed from: a */
        public View mo4272a(int i) {
            return C0744e.this.findViewById(i);
        }

        /* renamed from: a */
        public void mo4316a(C0735d dVar, Intent intent, int i, Bundle bundle) {
            C0744e.this.startActivityFromFragment(dVar, intent, i, bundle);
        }

        /* renamed from: a */
        public void mo4317a(C0735d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            C0744e.this.startIntentSenderFromFragment(dVar, intentSender, i, intent, i2, i3, i4, bundle);
        }

        /* renamed from: a */
        public void mo4318a(C0735d dVar, String[] strArr, int i) {
            C0744e.this.requestPermissionsFromFragment(dVar, strArr, i);
        }

        /* renamed from: a */
        public void mo4319a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            C0744e.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        /* renamed from: a */
        public boolean mo4273a() {
            Window window = C0744e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        /* renamed from: a */
        public boolean mo4320a(C0735d dVar) {
            return !C0744e.this.isFinishing();
        }

        /* renamed from: a */
        public boolean mo4321a(String str) {
            return C0490a.m1951a((Activity) C0744e.this, str);
        }

        /* renamed from: b */
        public LayoutInflater mo4322b() {
            return C0744e.this.getLayoutInflater().cloneInContext(C0744e.this);
        }

        /* renamed from: b */
        public void mo4323b(C0735d dVar) {
            C0744e.this.onAttachFragment(dVar);
        }

        /* renamed from: c */
        public C0744e mo4328g() {
            return C0744e.this;
        }

        /* renamed from: d */
        public void mo4325d() {
            C0744e.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: e */
        public boolean mo4326e() {
            return C0744e.this.getWindow() != null;
        }

        /* renamed from: f */
        public int mo4327f() {
            Window window = C0744e.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public C0947e getLifecycle() {
            return C0744e.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return C0744e.this.getOnBackPressedDispatcher();
        }

        public C0971u getViewModelStore() {
            return C0744e.this.getViewModelStore();
        }
    }

    public C0744e() {
    }

    public C0744e(int i) {
        super(i);
    }

    private int allocateRequestIndex(C0735d dVar) {
        if (this.mPendingFragmentActivityResults.mo2971b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.mo2979e(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.mo2973b(i, dVar.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void checkForValidRequestCode(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), C0947e.C0949b.CREATED));
    }

    private static boolean markState(C0750j jVar, C0947e.C0949b bVar) {
        boolean z = false;
        for (C0735d next : jVar.mo4366c()) {
            if (next != null) {
                if (next.getLifecycle().mo5111a().mo5114a(C0947e.C0949b.STARTED)) {
                    next.mLifecycleRegistry.mo5117b(bVar);
                    z = true;
                }
                if (next.getHost() != null) {
                    z |= markState(next.getChildFragmentManager(), bVar);
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mo4330a(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            C0795a.m3295a(this).mo4575a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.mo4332a().mo4364a(str, fileDescriptor, printWriter, strArr);
    }

    public C0750j getSupportFragmentManager() {
        return this.mFragments.mo4332a();
    }

    @Deprecated
    public C0795a getSupportLoaderManager() {
        return C0795a.m3295a(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.mo4340b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a = this.mPendingFragmentActivityResults.mo2969a(i4);
            this.mPendingFragmentActivityResults.mo2972b(i4);
            if (a == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C0735d a2 = this.mFragments.mo4331a(a);
            if (a2 == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + a);
                return;
            }
            a2.onActivityResult(i & 65535, i2, intent);
            return;
        }
        C0490a.C0493b a3 = C0490a.m1945a();
        if (a3 == null || !a3.mo3409a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachFragment(C0735d dVar) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.mo4340b();
        this.mFragments.mo4333a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mFragments.mo4335a((C0735d) null);
        if (bundle != null) {
            this.mFragments.mo4334a(bundle.getParcelable(FRAGMENTS_TAG));
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C0414h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.mo2973b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C0414h<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_CREATE);
        this.mFragments.mo4345d();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.mFragments.mo4338a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.mo4351j();
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mo4352k();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.mo4339a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.mo4343b(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.mo4336a(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.mo4340b();
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.mo4341b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.mo4349h();
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.mo4342b(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.mo4337a(menu) : super.onPreparePanel(i, view, menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.mo4340b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String a = this.mPendingFragmentActivityResults.mo2969a(i3);
            this.mPendingFragmentActivityResults.mo2972b(i3);
            if (a == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C0735d a2 = this.mFragments.mo4331a(a);
            if (a2 == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + a);
                return;
            }
            a2.onRequestPermissionsResult(i & 65535, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.mo4340b();
        this.mFragments.mo4353l();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_RESUME);
        this.mFragments.mo4348g();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_STOP);
        Parcelable c = this.mFragments.mo4344c();
        if (c != null) {
            bundle.putParcelable(FRAGMENTS_TAG, c);
        }
        if (this.mPendingFragmentActivityResults.mo2971b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.mo2971b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.mo2971b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.mo2971b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.mo2974c(i);
                strArr[i] = this.mPendingFragmentActivityResults.mo2978d(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mo4346e();
        }
        this.mFragments.mo4340b();
        this.mFragments.mo4353l();
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_START);
        this.mFragments.mo4347f();
    }

    public void onStateNotSaved() {
        this.mFragments.mo4340b();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.mo4350i();
        this.mFragmentLifecycleRegistry.mo5115a(C0947e.C0948a.ON_STOP);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void requestPermissionsFromFragment(C0735d dVar, String[] strArr, int i) {
        if (i == -1) {
            C0490a.m1950a(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C0490a.m1950a(this, strArr, ((allocateRequestIndex(dVar) + 1) << 16) + (i & 65535));
            this.mRequestedPermissionsFromFragment = false;
        } catch (Throwable th) {
            this.mRequestedPermissionsFromFragment = false;
            throw th;
        }
    }

    public void setEnterSharedElementCallback(C0521n nVar) {
        C0490a.m1949a((Activity) this, nVar);
    }

    public void setExitSharedElementCallback(C0521n nVar) {
        C0490a.m1953b(this, nVar);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startActivityFromFragment(C0735d dVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(dVar, intent, i, (Bundle) null);
    }

    public void startActivityFromFragment(C0735d dVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C0490a.m1947a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            C0490a.m1947a(this, intent, ((allocateRequestIndex(dVar) + 1) << 16) + (i & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void startIntentSenderFromFragment(C0735d dVar, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        int i5 = i;
        this.mStartedIntentSenderFromFragment = true;
        if (i5 == -1) {
            try {
                C0490a.m1948a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            C0490a.m1948a(this, intentSender, ((allocateRequestIndex(dVar) + 1) << 16) + (i5 & 65535), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        C0490a.m1952b(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        C0490a.m1954c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0490a.m1955d(this);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
    }
}
