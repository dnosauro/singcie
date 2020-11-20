package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.C0521n;
import androidx.core.p029g.C0580a;
import androidx.core.p030h.C0640e;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0951g;
import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0953i;
import androidx.lifecycle.C0960n;
import androidx.lifecycle.C0971u;
import androidx.lifecycle.C0972v;
import androidx.lifecycle.LiveData;
import androidx.p043h.p044a.C0795a;
import androidx.savedstate.C1150a;
import androidx.savedstate.C1153b;
import androidx.savedstate.C1154c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.fragment.app.d */
public class C0735d implements ComponentCallbacks, View.OnCreateContextMenuListener, C0952h, C0972v, C1154c {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    boolean mAdded;
    C0739a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    C0753k mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    C0753k mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    C0749i mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    C0953i mLifecycleRegistry;
    C0947e.C0949b mMaxState;
    boolean mMenuVisible;
    C0735d mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    C1153b mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    C0735d mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    C0792t mViewLifecycleOwner;
    C0960n<C0952h> mViewLifecycleOwnerLiveData;
    String mWho;

    /* renamed from: androidx.fragment.app.d$a */
    static class C0739a {

        /* renamed from: a */
        View f2519a;

        /* renamed from: b */
        Animator f2520b;

        /* renamed from: c */
        int f2521c;

        /* renamed from: d */
        int f2522d;

        /* renamed from: e */
        int f2523e;

        /* renamed from: f */
        int f2524f;

        /* renamed from: g */
        Object f2525g = null;

        /* renamed from: h */
        Object f2526h = C0735d.USE_DEFAULT_TRANSITION;

        /* renamed from: i */
        Object f2527i = null;

        /* renamed from: j */
        Object f2528j = C0735d.USE_DEFAULT_TRANSITION;

        /* renamed from: k */
        Object f2529k = null;

        /* renamed from: l */
        Object f2530l = C0735d.USE_DEFAULT_TRANSITION;

        /* renamed from: m */
        Boolean f2531m;

        /* renamed from: n */
        Boolean f2532n;

        /* renamed from: o */
        C0521n f2533o = null;

        /* renamed from: p */
        C0521n f2534p = null;

        /* renamed from: q */
        boolean f2535q;

        /* renamed from: r */
        C0741c f2536r;

        /* renamed from: s */
        boolean f2537s;

        C0739a() {
        }
    }

    /* renamed from: androidx.fragment.app.d$b */
    public static class C0740b extends RuntimeException {
        public C0740b(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: androidx.fragment.app.d$c */
    interface C0741c {
        /* renamed from: a */
        void mo4274a();

        /* renamed from: b */
        void mo4275b();
    }

    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: androidx.fragment.app.d$d */
    public static class C0742d implements Parcelable {
        public static final Parcelable.Creator<C0742d> CREATOR = new Parcelable.ClassLoaderCreator<C0742d>() {
            /* renamed from: a */
            public C0742d createFromParcel(Parcel parcel) {
                return new C0742d(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public C0742d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0742d(parcel, classLoader);
            }

            /* renamed from: a */
            public C0742d[] newArray(int i) {
                return new C0742d[i];
            }
        };

        /* renamed from: a */
        final Bundle f2538a;

        C0742d(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f2538a = parcel.readBundle();
            if (classLoader != null && (bundle = this.f2538a) != null) {
                bundle.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f2538a);
        }
    }

    public C0735d() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new C0753k();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() {
            public void run() {
                C0735d.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = C0947e.C0949b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new C0960n<>();
        initLifecycle();
    }

    public C0735d(int i) {
        this();
        this.mContentLayoutId = i;
    }

    private C0739a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new C0739a();
        }
        return this.mAnimationInfo;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new C0953i(this);
        this.mSavedStateRegistryController = C1153b.m4533a((C1154c) this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.mo5112a((C0951g) new Fragment$2(this));
        }
    }

    @Deprecated
    public static C0735d instantiate(Context context, String str) {
        return instantiate(context, str, (Bundle) null);
    }

    @Deprecated
    public static C0735d instantiate(Context context, String str, Bundle bundle) {
        try {
            C0735d dVar = (C0735d) C0748h.m3010b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(dVar.getClass().getClassLoader());
                dVar.setArguments(bundle);
            }
            return dVar;
        } catch (InstantiationException e) {
            throw new C0740b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new C0740b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new C0740b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new C0740b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    /* access modifiers changed from: package-private */
    public void callStartTransitionListener() {
        C0741c cVar;
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            cVar = null;
        } else {
            aVar.f2535q = false;
            cVar = aVar.f2536r;
            this.mAnimationInfo.f2536r = null;
        }
        if (cVar != null) {
            cVar.mo4274a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        C0735d targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            C0795a.m3295a(this).mo4575a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        C0753k kVar = this.mChildFragmentManager;
        kVar.mo4364a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public C0735d findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.mo4412b(str);
    }

    public final C0744e getActivity() {
        C0749i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return (C0744e) iVar.mo4355h();
    }

    public boolean getAllowEnterTransitionOverlap() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.f2532n == null) {
            return true;
        }
        return this.mAnimationInfo.f2532n.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.f2531m == null) {
            return true;
        }
        return this.mAnimationInfo.f2531m.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public View getAnimatingAway() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2519a;
    }

    /* access modifiers changed from: package-private */
    public Animator getAnimator() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2520b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final C0750j getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        C0749i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.mo4356i();
    }

    public Object getEnterTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2525g;
    }

    /* access modifiers changed from: package-private */
    public C0521n getEnterTransitionCallback() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2533o;
    }

    public Object getExitTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2527i;
    }

    /* access modifiers changed from: package-private */
    public C0521n getExitTransitionCallback() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2534p;
    }

    public final C0750j getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        C0749i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.mo4328g();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater((Bundle) null) : layoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        C0749i iVar = this.mHost;
        if (iVar != null) {
            LayoutInflater b = iVar.mo4322b();
            C0640e.m2527a(b, this.mChildFragmentManager.mo4386B());
            return b;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public C0947e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public C0795a getLoaderManager() {
        return C0795a.m3295a(this);
    }

    /* access modifiers changed from: package-private */
    public int getNextAnim() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f2522d;
    }

    /* access modifiers changed from: package-private */
    public int getNextTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f2523e;
    }

    /* access modifiers changed from: package-private */
    public int getNextTransitionStyle() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f2524f;
    }

    public final C0735d getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2528j == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.f2528j;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2526h == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.f2526h;
    }

    public final C1150a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.mo6204a();
    }

    public Object getSharedElementEnterTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2529k;
    }

    public Object getSharedElementReturnTransition() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f2530l == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mAnimationInfo.f2530l;
    }

    /* access modifiers changed from: package-private */
    public int getStateAfterAnimating() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f2521c;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final C0735d getTargetFragment() {
        C0735d dVar = this.mTarget;
        if (dVar != null) {
            return dVar;
        }
        C0753k kVar = this.mFragmentManager;
        if (kVar == null || this.mTargetWho == null) {
            return null;
        }
        return kVar.f2563g.get(this.mTargetWho);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public C0952h getViewLifecycleOwner() {
        C0792t tVar = this.mViewLifecycleOwner;
        if (tVar != null) {
            return tVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<C0952h> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public C0971u getViewModelStore() {
        C0753k kVar = this.mFragmentManager;
        if (kVar != null) {
            return kVar.mo4413b(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new C0753k();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    /* access modifiers changed from: package-private */
    public boolean isHideReplaced() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.f2537s;
    }

    /* access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    /* access modifiers changed from: package-private */
    public boolean isPostponed() {
        C0739a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.f2535q;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isStateSaved() {
        C0753k kVar = this.mFragmentManager;
        if (kVar == null) {
            return false;
        }
        return kVar.mo4369f();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r1.mView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isVisible() {
        /*
            r1 = this;
            boolean r0 = r1.isAdded()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.isHidden()
            if (r0 != 0) goto L_0x0020
            android.view.View r0 = r1.mView
            if (r0 == 0) goto L_0x0020
            android.os.IBinder r0 = r0.getWindowToken()
            if (r0 == 0) goto L_0x0020
            android.view.View r0 = r1.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0735d.isVisible():boolean");
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.mo4451o();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        C0749i iVar = this.mHost;
        Activity h = iVar == null ? null : iVar.mo4355h();
        if (h != null) {
            this.mCalled = false;
            onAttach(h);
        }
    }

    public void onAttachFragment(C0735d dVar) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.mo4405a(1)) {
            this.mChildFragmentManager.mo4455p();
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        C0749i iVar = this.mHost;
        Activity h = iVar == null ? null : iVar.mo4355h();
        if (h != null) {
            this.mCalled = false;
            onInflate(h, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    /* access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.mo4451o();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            this.mChildFragmentManager.mo4457q();
            return;
        }
        throw new C0793u("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public void performAttach() {
        this.mChildFragmentManager.mo4402a(this.mHost, (C0746f) new C0746f() {
            /* renamed from: a */
            public View mo4272a(int i) {
                if (C0735d.this.mView != null) {
                    return C0735d.this.mView.findViewById(i);
                }
                throw new IllegalStateException("Fragment " + this + " does not have a view");
            }

            /* renamed from: a */
            public boolean mo4273a() {
                return C0735d.this.mView != null;
            }
        }, this);
        this.mCalled = false;
        onAttach(this.mHost.mo4356i());
        if (!this.mCalled) {
            throw new C0793u("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.mo4392a(configuration);
    }

    /* access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            return onContextItemSelected(menuItem) || this.mChildFragmentManager.mo4421b(menuItem);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.mo4451o();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.mo6205a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.mo5115a(C0947e.C0948a.ON_CREATE);
            return;
        }
        throw new C0793u("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.mo4407a(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.mo4451o();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new C0792t();
        this.mView = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4571a();
            this.mViewLifecycleOwnerLiveData.mo4583b(this.mViewLifecycleOwner);
        } else if (!this.mViewLifecycleOwner.mo4573b()) {
            this.mViewLifecycleOwner = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.mo4468w();
        this.mLifecycleRegistry.mo5115a(C0947e.C0948a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new C0793u("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.mo4467v();
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4572a(C0947e.C0948a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            C0795a.m3295a(this).mo4574a();
            this.mPerformedCreateView = false;
            return;
        }
        throw new C0793u("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new C0793u("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.mChildFragmentManager.mo4367d()) {
            this.mChildFragmentManager.mo4468w();
            this.mChildFragmentManager = new C0753k();
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    /* access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.mo4469x();
    }

    /* access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.mo4404a(z);
    }

    /* access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.mo4408a(menuItem);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.mo4414b(menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.mo4463t();
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4572a(C0947e.C0948a.ON_PAUSE);
        }
        this.mLifecycleRegistry.mo5115a(C0947e.C0948a.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new C0793u("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.mo4420b(z);
    }

    /* access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.mo4406a(menu);
    }

    /* access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean a = this.mFragmentManager.mo4409a(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != a) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(a);
            onPrimaryNavigationFragmentChanged(a);
            this.mChildFragmentManager.mo4470y();
        }
    }

    /* access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.mo4451o();
        this.mChildFragmentManager.mo4444k();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            this.mLifecycleRegistry.mo5115a(C0947e.C0948a.ON_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.mo4572a(C0947e.C0948a.ON_RESUME);
            }
            this.mChildFragmentManager.mo4462s();
            this.mChildFragmentManager.mo4444k();
            return;
        }
        throw new C0793u("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.mo6206b(bundle);
        Parcelable n = this.mChildFragmentManager.mo4449n();
        if (n != null) {
            bundle.putParcelable("android:support:fragments", n);
        }
    }

    /* access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.mo4451o();
        this.mChildFragmentManager.mo4444k();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            this.mLifecycleRegistry.mo5115a(C0947e.C0948a.ON_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.mo4572a(C0947e.C0948a.ON_START);
            }
            this.mChildFragmentManager.mo4459r();
            return;
        }
        throw new C0793u("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.mo4466u();
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4572a(C0947e.C0948a.ON_STOP);
        }
        this.mLifecycleRegistry.mo5115a(C0947e.C0948a.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new C0793u("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f2535q = true;
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        ensureAnimationInfo().f2535q = true;
        C0753k kVar = this.mFragmentManager;
        Handler j2 = kVar != null ? kVar.f2570n.mo4357j() : new Handler(Looper.getMainLooper());
        j2.removeCallbacks(this.mPostponedDurationRunnable);
        j2.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i) {
        C0749i iVar = this.mHost;
        if (iVar != null) {
            iVar.mo4318a(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final C0744e requireActivity() {
        C0744e activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final C0750j requireFragmentManager() {
        C0750j fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final C0735d requireParentFragment() {
        C0735d parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* access modifiers changed from: package-private */
    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.mChildFragmentManager.mo4394a(parcelable);
            this.mChildFragmentManager.mo4455p();
        }
    }

    /* access modifiers changed from: package-private */
    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new C0793u("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.mo4572a(C0947e.C0948a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f2532n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f2531m = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f2519a = view;
    }

    /* access modifiers changed from: package-private */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f2520b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(C0521n nVar) {
        ensureAnimationInfo().f2533o = nVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f2525g = obj;
    }

    public void setExitSharedElementCallback(C0521n nVar) {
        ensureAnimationInfo().f2534p = nVar;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f2527i = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.mo4325d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().f2537s = z;
    }

    public void setInitialSavedState(C0742d dVar) {
        if (this.mFragmentManager == null) {
            this.mSavedFragmentState = (dVar == null || dVar.f2538a == null) ? null : dVar.f2538a;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo4325d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextAnim(int i) {
        if (this.mAnimationInfo != null || i != 0) {
            ensureAnimationInfo().f2522d = i;
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo != null || i != 0 || i2 != 0) {
            ensureAnimationInfo();
            C0739a aVar = this.mAnimationInfo;
            aVar.f2523e = i;
            aVar.f2524f = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(C0741c cVar) {
        ensureAnimationInfo();
        if (cVar != this.mAnimationInfo.f2536r) {
            if (cVar == null || this.mAnimationInfo.f2536r == null) {
                if (this.mAnimationInfo.f2535q) {
                    this.mAnimationInfo.f2536r = cVar;
                }
                if (cVar != null) {
                    cVar.mo4275b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f2528j = obj;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        C0753k kVar = this.mFragmentManager;
        if (kVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            kVar.mo4426d(this);
        } else {
            kVar.mo4429e(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f2526h = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f2529k = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f2530l = obj;
    }

    /* access modifiers changed from: package-private */
    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f2521c = i;
    }

    public void setTargetFragment(C0735d dVar, int i) {
        C0750j fragmentManager = getFragmentManager();
        C0750j fragmentManager2 = dVar != null ? dVar.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            C0735d dVar2 = dVar;
            while (dVar2 != null) {
                if (dVar2 != this) {
                    dVar2 = dVar2.getTargetFragment();
                } else {
                    throw new IllegalArgumentException("Setting " + dVar + " as the target of " + this + " would create a target cycle");
                }
            }
            if (dVar == null) {
                this.mTargetWho = null;
            } else if (this.mFragmentManager == null || dVar.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = dVar;
                this.mTargetRequestCode = i;
                return;
            } else {
                this.mTargetWho = dVar.mWho;
            }
            this.mTarget = null;
            this.mTargetRequestCode = i;
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " must share the same FragmentManager to be set as a target fragment");
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.mo4431f(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        C0749i iVar = this.mHost;
        if (iVar != null) {
            return iVar.mo4321a(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, (Bundle) null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        C0749i iVar = this.mHost;
        if (iVar != null) {
            iVar.mo4316a(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, (Bundle) null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        C0749i iVar = this.mHost;
        if (iVar != null) {
            iVar.mo4316a(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        C0749i iVar = this.mHost;
        if (iVar != null) {
            iVar.mo4317a(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        C0753k kVar = this.mFragmentManager;
        if (kVar == null || kVar.f2570n == null) {
            ensureAnimationInfo().f2535q = false;
        } else if (Looper.myLooper() != this.mFragmentManager.f2570n.mo4357j().getLooper()) {
            this.mFragmentManager.f2570n.mo4357j().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    C0735d.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        C0580a.m2253a(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }
}
