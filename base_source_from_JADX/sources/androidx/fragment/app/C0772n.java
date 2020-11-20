package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.C0947e;
import androidx.p053l.p054a.C0921a;

/* renamed from: androidx.fragment.app.n */
public abstract class C0772n extends C0921a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private C0775p mCurTransaction;
    private C0735d mCurrentPrimaryItem;
    private final C0750j mFragmentManager;

    @Deprecated
    public C0772n(C0750j jVar) {
        this(jVar, 0);
    }

    public C0772n(C0750j jVar, int i) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = jVar;
        this.mBehavior = i;
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        C0735d dVar = (C0735d) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.mo4359a();
        }
        this.mCurTransaction.mo4071b(dVar);
        if (dVar == this.mCurrentPrimaryItem) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        C0775p pVar = this.mCurTransaction;
        if (pVar != null) {
            pVar.mo4076e();
            this.mCurTransaction = null;
        }
    }

    public abstract C0735d getItem(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.mo4359a();
        }
        long itemId = getItemId(i);
        C0735d a = this.mFragmentManager.mo4358a(makeFragmentName(viewGroup.getId(), itemId));
        if (a != null) {
            this.mCurTransaction.mo4527c(a);
        } else {
            a = getItem(i);
            this.mCurTransaction.mo4523a(viewGroup.getId(), a, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (a != this.mCurrentPrimaryItem) {
            a.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.mo4060a(a, C0947e.C0949b.STARTED);
            } else {
                a.setUserVisibleHint(false);
            }
        }
        return a;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((C0735d) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        C0735d dVar = (C0735d) obj;
        C0735d dVar2 = this.mCurrentPrimaryItem;
        if (dVar != dVar2) {
            if (dVar2 != null) {
                dVar2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.mo4359a();
                    }
                    this.mCurTransaction.mo4060a(this.mCurrentPrimaryItem, C0947e.C0949b.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            dVar.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.mo4359a();
                }
                this.mCurTransaction.mo4060a(dVar, C0947e.C0949b.RESUMED);
            } else {
                dVar.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = dVar;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
