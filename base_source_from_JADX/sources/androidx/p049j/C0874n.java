package androidx.p049j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.content.p025a.C0544g;
import androidx.core.p030h.C0656u;
import androidx.p018c.C0400a;
import androidx.p018c.C0405d;
import androidx.p018c.C0413g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.j.n */
public abstract class C0874n implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final C0866g STRAIGHT_PATH_MOTION = new C0866g() {
        /* renamed from: a */
        public Path mo4739a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<C0400a<Animator, C0878a>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private C0892u mEndValues = new C0892u();
    private ArrayList<C0891t> mEndValuesList;
    private boolean mEnded = false;
    private C0880c mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<C0881d> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private C0400a<String, String> mNameOverrides;
    private int mNumInstances = 0;
    C0887r mParent = null;
    private C0866g mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    C0886q mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private C0892u mStartValues = new C0892u();
    private ArrayList<C0891t> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    /* renamed from: androidx.j.n$a */
    private static class C0878a {

        /* renamed from: a */
        View f2894a;

        /* renamed from: b */
        String f2895b;

        /* renamed from: c */
        C0891t f2896c;

        /* renamed from: d */
        C0843an f2897d;

        /* renamed from: e */
        C0874n f2898e;

        C0878a(View view, String str, C0874n nVar, C0843an anVar, C0891t tVar) {
            this.f2894a = view;
            this.f2895b = str;
            this.f2896c = tVar;
            this.f2897d = anVar;
            this.f2898e = nVar;
        }
    }

    /* renamed from: androidx.j.n$b */
    private static class C0879b {
        /* renamed from: a */
        static <T> ArrayList<T> m3531a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        /* renamed from: b */
        static <T> ArrayList<T> m3532b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    /* renamed from: androidx.j.n$c */
    public static abstract class C0880c {
        /* renamed from: a */
        public abstract Rect mo4738a(C0874n nVar);
    }

    /* renamed from: androidx.j.n$d */
    public interface C0881d {
        /* renamed from: a */
        void mo4697a(C0874n nVar);

        /* renamed from: b */
        void mo4694b(C0874n nVar);

        /* renamed from: c */
        void mo4695c(C0874n nVar);

        /* renamed from: d */
        void mo4696d(C0874n nVar);

        /* renamed from: e */
        void mo4698e(C0874n nVar);
    }

    public C0874n() {
    }

    @SuppressLint({"RestrictedApi"})
    public C0874n(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0873m.f2882c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a = (long) C0544g.m2154a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (a >= 0) {
            setDuration(a);
        }
        long a2 = (long) C0544g.m2154a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a2 > 0) {
            setStartDelay(a2);
        }
        int c = C0544g.m2164c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, c));
        }
        String a3 = C0544g.m2159a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "matchOrder", 3);
        if (a3 != null) {
            setMatchOrder(parseMatchOrder(a3));
        }
        obtainStyledAttributes.recycle();
    }

    private void addUnmatched(C0400a<View, C0891t> aVar, C0400a<View, C0891t> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            C0891t c = aVar.mo2949c(i);
            if (isValidTarget(c.f2918b)) {
                this.mStartValuesList.add(c);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            C0891t c2 = aVar2.mo2949c(i2);
            if (isValidTarget(c2.f2918b)) {
                this.mEndValuesList.add(c2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private static void addViewValues(C0892u uVar, View view, C0891t tVar) {
        uVar.f2920a.put(view, tVar);
        int id = view.getId();
        if (id >= 0) {
            if (uVar.f2921b.indexOfKey(id) >= 0) {
                uVar.f2921b.put(id, (Object) null);
            } else {
                uVar.f2921b.put(id, view);
            }
        }
        String o = C0656u.m2632o(view);
        if (o != null) {
            if (uVar.f2923d.containsKey(o)) {
                uVar.f2923d.put(o, null);
            } else {
                uVar.f2923d.put(o, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (uVar.f2922c.mo2858d(itemIdAtPosition) >= 0) {
                    View a = uVar.f2922c.mo2846a(itemIdAtPosition);
                    if (a != null) {
                        C0656u.m2600a(a, false);
                        uVar.f2922c.mo2852b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                C0656u.m2600a(view, true);
                uVar.f2922c.mo2852b(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i = 0;
                        while (i < size) {
                            if (!this.mTargetTypeExcludes.get(i).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        C0891t tVar = new C0891t(view);
                        if (z) {
                            captureStartValues(tVar);
                        } else {
                            captureEndValues(tVar);
                        }
                        tVar.f2919c.add(this);
                        capturePropagationValues(tVar);
                        addViewValues(z ? this.mStartValues : this.mEndValues, view, tVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i2 = 0;
                                    while (i2 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                            i2++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    captureHierarchy(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        return i > 0 ? z ? C0879b.m3531a(arrayList, Integer.valueOf(i)) : C0879b.m3532b(arrayList, Integer.valueOf(i)) : arrayList;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        return t != null ? z ? C0879b.m3531a(arrayList, t) : C0879b.m3532b(arrayList, t) : arrayList;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        return cls != null ? z ? C0879b.m3531a(arrayList, cls) : C0879b.m3532b(arrayList, cls) : arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        return view != null ? z ? C0879b.m3531a(arrayList, view) : C0879b.m3532b(arrayList, view) : arrayList;
    }

    private static C0400a<Animator, C0878a> getRunningAnimators() {
        C0400a<Animator, C0878a> aVar = sRunningAnimators.get();
        if (aVar != null) {
            return aVar;
        }
        C0400a<Animator, C0878a> aVar2 = new C0400a<>();
        sRunningAnimators.set(aVar2);
        return aVar2;
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean isValueChanged(C0891t tVar, C0891t tVar2, String str) {
        Object obj = tVar.f2917a.get(str);
        Object obj2 = tVar2.f2917a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void matchIds(C0400a<View, C0891t> aVar, C0400a<View, C0891t> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                C0891t tVar = aVar.get(valueAt);
                C0891t tVar2 = aVar2.get(view);
                if (!(tVar == null || tVar2 == null)) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void matchInstances(C0400a<View, C0891t> aVar, C0400a<View, C0891t> aVar2) {
        C0891t remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b = aVar.mo2948b(size);
            if (b != null && isValidTarget(b) && (remove = aVar2.remove(b)) != null && isValidTarget(remove.f2918b)) {
                this.mStartValuesList.add(aVar.mo2953d(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(C0400a<View, C0891t> aVar, C0400a<View, C0891t> aVar2, C0405d<View> dVar, C0405d<View> dVar2) {
        View a;
        int b = dVar.mo2849b();
        for (int i = 0; i < b; i++) {
            View c = dVar.mo2853c(i);
            if (c != null && isValidTarget(c) && (a = dVar2.mo2846a(dVar.mo2850b(i))) != null && isValidTarget(a)) {
                C0891t tVar = aVar.get(c);
                C0891t tVar2 = aVar2.get(a);
                if (!(tVar == null || tVar2 == null)) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    aVar.remove(c);
                    aVar2.remove(a);
                }
            }
        }
    }

    private void matchNames(C0400a<View, C0891t> aVar, C0400a<View, C0891t> aVar2, C0400a<String, View> aVar3, C0400a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View c = aVar3.mo2949c(i);
            if (c != null && isValidTarget(c) && (view = aVar4.get(aVar3.mo2948b(i))) != null && isValidTarget(view)) {
                C0891t tVar = aVar.get(c);
                C0891t tVar2 = aVar2.get(view);
                if (!(tVar == null || tVar2 == null)) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    aVar.remove(c);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(C0892u uVar, C0892u uVar2) {
        C0400a aVar = new C0400a((C0413g) uVar.f2920a);
        C0400a aVar2 = new C0400a((C0413g) uVar2.f2920a);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                switch (iArr[i]) {
                    case 1:
                        matchInstances(aVar, aVar2);
                        break;
                    case 2:
                        matchNames(aVar, aVar2, uVar.f2923d, uVar2.f2923d);
                        break;
                    case 3:
                        matchIds(aVar, aVar2, uVar.f2921b, uVar2.f2921b);
                        break;
                    case 4:
                        matchItemIds(aVar, aVar2, uVar.f2922c, uVar2.f2922c);
                        break;
                }
                i++;
            } else {
                addUnmatched(aVar, aVar2);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, final C0400a<Animator, C0878a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    C0874n.this.mCurrentAnimators.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    C0874n.this.mCurrentAnimators.add(animator);
                }
            });
            animate(animator);
        }
    }

    public C0874n addListener(C0881d dVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public C0874n addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public C0874n addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public C0874n addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public C0874n addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    /* access modifiers changed from: protected */
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                C0874n.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<C0881d> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((C0881d) arrayList2.get(i)).mo4697a(this);
            }
        }
    }

    public abstract void captureEndValues(C0891t tVar);

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(C0891t tVar) {
        String[] a;
        if (this.mPropagation != null && !tVar.f2917a.isEmpty() && (a = this.mPropagation.mo4812a()) != null) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= a.length) {
                    z = true;
                    break;
                } else if (!tVar.f2917a.containsKey(a[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.mPropagation.mo4811a(tVar);
            }
        }
    }

    public abstract void captureStartValues(C0891t tVar);

    /* access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        C0400a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    C0891t tVar = new C0891t(findViewById);
                    if (z) {
                        captureStartValues(tVar);
                    } else {
                        captureEndValues(tVar);
                    }
                    tVar.f2919c.add(this);
                    capturePropagationValues(tVar);
                    addViewValues(z ? this.mStartValues : this.mEndValues, findViewById, tVar);
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                C0891t tVar2 = new C0891t(view);
                if (z) {
                    captureStartValues(tVar2);
                } else {
                    captureEndValues(tVar2);
                }
                tVar2.f2919c.add(this);
                capturePropagationValues(tVar2);
                addViewValues(z ? this.mStartValues : this.mEndValues, view, tVar2);
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!z && (aVar = this.mNameOverrides) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(this.mStartValues.f2923d.remove(this.mNameOverrides.mo2948b(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList3.get(i4);
                if (view2 != null) {
                    this.mStartValues.f2923d.put(this.mNameOverrides.mo2949c(i4), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        C0892u uVar;
        if (z) {
            this.mStartValues.f2920a.clear();
            this.mStartValues.f2921b.clear();
            uVar = this.mStartValues;
        } else {
            this.mEndValues.f2920a.clear();
            this.mEndValues.f2921b.clear();
            uVar = this.mEndValues;
        }
        uVar.f2922c.mo2859d();
    }

    public C0874n clone() {
        try {
            C0874n nVar = (C0874n) super.clone();
            nVar.mAnimators = new ArrayList<>();
            nVar.mStartValues = new C0892u();
            nVar.mEndValues = new C0892u();
            nVar.mStartValuesList = null;
            nVar.mEndValuesList = null;
            return nVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, C0891t tVar, C0891t tVar2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, C0892u uVar, C0892u uVar2, ArrayList<C0891t> arrayList, ArrayList<C0891t> arrayList2) {
        int i;
        int i2;
        Animator createAnimator;
        View view;
        Animator animator;
        C0891t tVar;
        C0891t tVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        C0400a<Animator, C0878a> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            C0891t tVar3 = arrayList.get(i3);
            C0891t tVar4 = arrayList2.get(i3);
            if (tVar3 != null && !tVar3.f2919c.contains(this)) {
                tVar3 = null;
            }
            if (tVar4 != null && !tVar4.f2919c.contains(this)) {
                tVar4 = null;
            }
            if (!(tVar3 == null && tVar4 == null)) {
                if ((tVar3 == null || tVar4 == null || isTransitionRequired(tVar3, tVar4)) && (createAnimator = createAnimator(viewGroup2, tVar3, tVar4)) != null) {
                    if (tVar4 != null) {
                        view = tVar4.f2918b;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            tVar2 = new C0891t(view);
                            Animator animator3 = createAnimator;
                            i2 = size;
                            C0891t tVar5 = uVar2.f2920a.get(view);
                            if (tVar5 != null) {
                                int i4 = 0;
                                while (i4 < transitionProperties.length) {
                                    tVar2.f2917a.put(transitionProperties[i4], tVar5.f2917a.get(transitionProperties[i4]));
                                    i4++;
                                    i3 = i3;
                                    tVar5 = tVar5;
                                    ArrayList<C0891t> arrayList3 = arrayList2;
                                }
                            }
                            i = i3;
                            int size2 = runningAnimators.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                C0878a aVar = runningAnimators.get(runningAnimators.mo2948b(i5));
                                if (aVar.f2896c != null && aVar.f2894a == view && aVar.f2895b.equals(getName()) && aVar.f2896c.equals(tVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            i2 = size;
                            i = i3;
                            animator2 = createAnimator;
                            tVar2 = null;
                        }
                        animator = animator2;
                        tVar = tVar2;
                    } else {
                        i2 = size;
                        i = i3;
                        view = tVar3.f2918b;
                        animator = createAnimator;
                        tVar = null;
                    }
                    if (animator != null) {
                        C0886q qVar = this.mPropagation;
                        if (qVar != null) {
                            long a = qVar.mo4810a(viewGroup2, this, tVar3, tVar4);
                            sparseIntArray.put(this.mAnimators.size(), (int) a);
                            j = Math.min(a, j);
                        }
                        runningAnimators.put(animator, new C0878a(view, getName(), this, C0828ad.m3419b(viewGroup), tVar));
                        this.mAnimators.add(animator);
                        j = j;
                    }
                    i3 = i + 1;
                    size = i2;
                }
            }
            i2 = size;
            i = i3;
            i3 = i + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator4 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i6)) - j) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            ArrayList<C0881d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((C0881d) arrayList2.get(i)).mo4694b(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.f2922c.mo2849b(); i2++) {
                View c = this.mStartValues.f2922c.mo2853c(i2);
                if (c != null) {
                    C0656u.m2600a(c, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.f2922c.mo2849b(); i3++) {
                View c2 = this.mEndValues.f2922c.mo2853c(i3);
                if (c2 != null) {
                    C0656u.m2600a(c2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public C0874n excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public C0874n excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public C0874n excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public C0874n excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public C0874n excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public C0874n excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public C0874n excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        C0400a<Animator, C0878a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            C0843an b = C0828ad.m3419b(viewGroup);
            C0400a aVar = new C0400a((C0413g) runningAnimators);
            runningAnimators.clear();
            for (int i = size - 1; i >= 0; i--) {
                C0878a aVar2 = (C0878a) aVar.mo2949c(i);
                if (!(aVar2.f2894a == null || b == null || !b.equals(aVar2.f2897d))) {
                    ((Animator) aVar.mo2948b(i)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        C0880c cVar = this.mEpicenterCallback;
        if (cVar == null) {
            return null;
        }
        return cVar.mo4738a(this);
    }

    public C0880c getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* access modifiers changed from: package-private */
    public C0891t getMatchedTransitionValues(View view, boolean z) {
        C0887r rVar = this.mParent;
        if (rVar != null) {
            return rVar.getMatchedTransitionValues(view, z);
        }
        ArrayList<C0891t> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            C0891t tVar = arrayList.get(i2);
            if (tVar == null) {
                return null;
            }
            if (tVar.f2918b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < 0) {
            return null;
        }
        return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
    }

    public String getName() {
        return this.mName;
    }

    public C0866g getPathMotion() {
        return this.mPathMotion;
    }

    public C0886q getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public C0891t getTransitionValues(View view, boolean z) {
        C0887r rVar = this.mParent;
        if (rVar != null) {
            return rVar.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f2920a.get(view);
    }

    public boolean isTransitionRequired(C0891t tVar, C0891t tVar2) {
        if (tVar == null || tVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i = 0;
            while (i < length) {
                if (!isValueChanged(tVar, tVar2, transitionProperties[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String isValueChanged : tVar.f2917a.keySet()) {
            if (isValueChanged(tVar, tVar2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && C0656u.m2632o(view) != null && this.mTargetNameExcludes.contains(C0656u.m2632o(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(C0656u.m2632o(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(View view) {
        if (!this.mEnded) {
            C0400a<Animator, C0878a> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            C0843an b = C0828ad.m3419b(view);
            for (int i = size - 1; i >= 0; i--) {
                C0878a c = runningAnimators.mo2949c(i);
                if (c.f2894a != null && b.equals(c.f2897d)) {
                    C0822a.m3396a(runningAnimators.mo2948b(i));
                }
            }
            ArrayList<C0881d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C0881d) arrayList2.get(i2)).mo4695c(this);
                }
            }
            this.mPaused = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        C0878a aVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        C0400a<Animator, C0878a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        C0843an b = C0828ad.m3419b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator b2 = runningAnimators.mo2948b(i);
            if (!(b2 == null || (aVar = runningAnimators.get(b2)) == null || aVar.f2894a == null || !b.equals(aVar.f2897d))) {
                C0891t tVar = aVar.f2896c;
                View view = aVar.f2894a;
                C0891t transitionValues = getTransitionValues(view, true);
                C0891t matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f2920a.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && aVar.f2898e.isTransitionRequired(tVar, matchedTransitionValues)) {
                    if (b2.isRunning() || b2.isStarted()) {
                        b2.cancel();
                    } else {
                        runningAnimators.remove(b2);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public C0874n removeListener(C0881d dVar) {
        ArrayList<C0881d> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public C0874n removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public C0874n removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public C0874n removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public C0874n removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                C0400a<Animator, C0878a> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                C0843an b = C0828ad.m3419b(view);
                for (int i = size - 1; i >= 0; i--) {
                    C0878a c = runningAnimators.mo2949c(i);
                    if (c.f2894a != null && b.equals(c.f2897d)) {
                        C0822a.m3398b(runningAnimators.mo2948b(i));
                    }
                }
                ArrayList<C0881d> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C0881d) arrayList2.get(i2)).mo4696d(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        start();
        C0400a<Animator, C0878a> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public C0874n setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public void setEpicenterCallback(C0880c cVar) {
        this.mEpicenterCallback = cVar;
    }

    public C0874n setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        int[] iArr2;
        if (iArr == null || iArr.length == 0) {
            iArr2 = DEFAULT_MATCH_ORDER;
        } else {
            int i = 0;
            while (i < iArr.length) {
                if (!isValidMatch(iArr[i])) {
                    throw new IllegalArgumentException("matches contains invalid value");
                } else if (!alreadyContains(iArr, i)) {
                    i++;
                } else {
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
            }
            iArr2 = (int[]) iArr.clone();
        }
        this.mMatchOrder = iArr2;
    }

    public void setPathMotion(C0866g gVar) {
        if (gVar == null) {
            gVar = STRAIGHT_PATH_MOTION;
        }
        this.mPathMotion = gVar;
    }

    public void setPropagation(C0886q qVar) {
        this.mPropagation = qVar;
    }

    /* access modifiers changed from: package-private */
    public C0874n setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public C0874n setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<C0881d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((C0881d) arrayList2.get(i)).mo4698e(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.mTargetIds.get(i);
            }
            str3 = str4;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }
}
