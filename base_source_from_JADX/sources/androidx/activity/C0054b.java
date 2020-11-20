package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.C0506f;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0953i;
import androidx.lifecycle.C0963q;
import androidx.lifecycle.C0971u;
import androidx.lifecycle.C0972v;
import androidx.savedstate.C1150a;
import androidx.savedstate.C1153b;
import androidx.savedstate.C1154c;

/* renamed from: androidx.activity.b */
public class C0054b extends C0506f implements C0058d, C0952h, C0972v, C1154c {
    private int mContentLayoutId;
    private final C0953i mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final C1153b mSavedStateRegistryController;
    private C0971u mViewModelStore;

    /* renamed from: androidx.activity.b$a */
    static final class C0056a {

        /* renamed from: a */
        Object f46a;

        /* renamed from: b */
        C0971u f47b;

        C0056a() {
        }
    }

    public C0054b() {
        this.mLifecycleRegistry = new C0953i(this);
        this.mSavedStateRegistryController = C1153b.m4533a((C1154c) this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public void run() {
                C0054b.super.onBackPressed();
            }
        });
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().mo5112a(new ComponentActivity$2(this));
            }
            getLifecycle().mo5112a(new ComponentActivity$3(this));
            if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
                getLifecycle().mo5112a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public C0054b(int i) {
        this();
        this.mContentLayoutId = i;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        C0056a aVar = (C0056a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f46a;
        }
        return null;
    }

    public C0947e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final C1150a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.mo6204a();
    }

    public C0971u getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                C0056a aVar = (C0056a) getLastNonConfigurationInstance();
                if (aVar != null) {
                    this.mViewModelStore = aVar.f47b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new C0971u();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.mo661a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.mo6205a(bundle);
        C0963q.m3750a((Activity) this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        C0056a aVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C0971u uVar = this.mViewModelStore;
        if (uVar == null && (aVar = (C0056a) getLastNonConfigurationInstance()) != null) {
            uVar = aVar.f47b;
        }
        if (uVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C0056a aVar2 = new C0056a();
        aVar2.f46a = onRetainCustomNonConfigurationInstance;
        aVar2.f47b = uVar;
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        C0947e lifecycle = getLifecycle();
        if (lifecycle instanceof C0953i) {
            ((C0953i) lifecycle).mo5117b(C0947e.C0949b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.mo6206b(bundle);
    }
}
