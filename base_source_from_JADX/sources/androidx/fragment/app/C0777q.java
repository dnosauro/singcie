package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.C0521n;
import androidx.core.p030h.C0653r;
import androidx.core.p030h.C0656u;
import androidx.fragment.app.C0775p;
import androidx.p018c.C0400a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.fragment.app.q */
class C0777q {

    /* renamed from: a */
    private static final int[] f2667a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b */
    private static final C0788s f2668b = (Build.VERSION.SDK_INT >= 21 ? new C0783r() : null);

    /* renamed from: c */
    private static final C0788s f2669c = m3223a();

    /* renamed from: androidx.fragment.app.q$a */
    static class C0782a {

        /* renamed from: a */
        public C0735d f2698a;

        /* renamed from: b */
        public boolean f2699b;

        /* renamed from: c */
        public C0730a f2700c;

        /* renamed from: d */
        public C0735d f2701d;

        /* renamed from: e */
        public boolean f2702e;

        /* renamed from: f */
        public C0730a f2703f;

        C0782a() {
        }
    }

    /* renamed from: a */
    static View m3219a(C0400a<String, View> aVar, C0782a aVar2, Object obj, boolean z) {
        C0730a aVar3 = aVar2.f2700c;
        if (obj == null || aVar == null || aVar3.f2655r == null || aVar3.f2655r.isEmpty()) {
            return null;
        }
        return aVar.get((String) (z ? aVar3.f2655r : aVar3.f2656s).get(0));
    }

    /* renamed from: a */
    private static C0400a<String, String> m3220a(int i, ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        C0400a<String, String> aVar = new C0400a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0730a aVar2 = arrayList.get(i4);
            if (aVar2.mo4073b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.f2655r != null) {
                    int size = aVar2.f2655r.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f2655r;
                        arrayList4 = aVar2.f2656s;
                    } else {
                        ArrayList arrayList5 = aVar2.f2655r;
                        arrayList3 = aVar2.f2656s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    static C0400a<String, View> m3221a(C0788s sVar, C0400a<String, String> aVar, Object obj, C0782a aVar2) {
        C0521n nVar;
        ArrayList arrayList;
        String a;
        C0735d dVar = aVar2.f2698a;
        View view = dVar.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        C0400a<String, View> aVar3 = new C0400a<>();
        sVar.mo4567a((Map<String, View>) aVar3, view);
        C0730a aVar4 = aVar2.f2700c;
        if (aVar2.f2699b) {
            nVar = dVar.getExitTransitionCallback();
            arrayList = aVar4.f2655r;
        } else {
            nVar = dVar.getEnterTransitionCallback();
            arrayList = aVar4.f2656s;
        }
        if (arrayList != null) {
            aVar3.mo2811a(arrayList);
            aVar3.mo2811a(aVar.values());
        }
        if (nVar != null) {
            nVar.mo3500a((List<String>) arrayList, (Map<String, View>) aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = aVar3.get(str);
                if (view2 == null) {
                    String a2 = m3229a(aVar, str);
                    if (a2 != null) {
                        aVar.remove(a2);
                    }
                } else if (!str.equals(C0656u.m2632o(view2)) && (a = m3229a(aVar, str)) != null) {
                    aVar.put(a, C0656u.m2632o(view2));
                }
            }
        } else {
            m3231a(aVar, aVar3);
        }
        return aVar3;
    }

    /* renamed from: a */
    private static C0782a m3222a(C0782a aVar, SparseArray<C0782a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        C0782a aVar2 = new C0782a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    /* renamed from: a */
    private static C0788s m3223a() {
        try {
            return (C0788s) Class.forName("androidx.j.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static C0788s m3224a(C0735d dVar, C0735d dVar2) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            Object exitTransition = dVar.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = dVar.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = dVar.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (dVar2 != null) {
            Object enterTransition = dVar2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = dVar2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = dVar2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        C0788s sVar = f2668b;
        if (sVar != null && m3242a(sVar, (List<Object>) arrayList)) {
            return f2668b;
        }
        C0788s sVar2 = f2669c;
        if (sVar2 != null && m3242a(sVar2, (List<Object>) arrayList)) {
            return f2669c;
        }
        if (f2668b == null && f2669c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: a */
    private static Object m3225a(C0788s sVar, ViewGroup viewGroup, View view, C0400a<String, String> aVar, C0782a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2;
        C0788s sVar2 = sVar;
        View view3 = view;
        C0400a<String, String> aVar3 = aVar;
        C0782a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        C0735d dVar = aVar4.f2698a;
        C0735d dVar2 = aVar4.f2701d;
        if (dVar != null) {
            dVar.requireView().setVisibility(0);
        }
        if (dVar == null || dVar2 == null) {
            return null;
        }
        boolean z = aVar4.f2699b;
        Object a = aVar.isEmpty() ? null : m3226a(sVar, dVar, dVar2, z);
        C0400a<String, View> b = m3243b(sVar, aVar3, a, aVar4);
        C0400a<String, View> a2 = m3221a(sVar, aVar3, a, aVar4);
        if (aVar.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj3 = null;
        } else {
            m3241a(arrayList3, b, (Collection<String>) aVar.keySet());
            m3241a(arrayList4, a2, aVar.values());
            obj3 = a;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        m3234a(dVar, dVar2, z, b, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            sVar.mo4537a(obj3, view3, arrayList3);
            m3239a(sVar, obj3, obj2, b, aVar4.f2702e, aVar4.f2703f);
            Rect rect2 = new Rect();
            View a3 = m3219a(a2, aVar4, obj4, z);
            if (a3 != null) {
                sVar.mo4535a(obj4, rect2);
            }
            rect = rect2;
            view2 = a3;
        } else {
            view2 = null;
            rect = null;
        }
        final C0735d dVar3 = dVar;
        final C0735d dVar4 = dVar2;
        final boolean z2 = z;
        final C0400a<String, View> aVar5 = a2;
        final C0788s sVar3 = sVar;
        C0653r.m2564a(viewGroup, new Runnable() {
            public void run() {
                C0777q.m3234a(dVar3, dVar4, z2, (C0400a<String, View>) aVar5, false);
                View view = view2;
                if (view != null) {
                    sVar3.mo4562a(view, rect);
                }
            }
        });
        return obj3;
    }

    /* renamed from: a */
    private static Object m3226a(C0788s sVar, C0735d dVar, C0735d dVar2, boolean z) {
        if (dVar == null || dVar2 == null) {
            return null;
        }
        return sVar.mo4547c(sVar.mo4542b(z ? dVar2.getSharedElementReturnTransition() : dVar.getSharedElementEnterTransition()));
    }

    /* renamed from: a */
    private static Object m3227a(C0788s sVar, C0735d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return sVar.mo4542b(z ? dVar.getReenterTransition() : dVar.getEnterTransition());
    }

    /* renamed from: a */
    private static Object m3228a(C0788s sVar, Object obj, Object obj2, Object obj3, C0735d dVar, boolean z) {
        return (obj == null || obj2 == null || dVar == null) ? true : z ? dVar.getAllowReturnTransitionOverlap() : dVar.getAllowEnterTransitionOverlap() ? sVar.mo4533a(obj2, obj, obj3) : sVar.mo4543b(obj2, obj, obj3);
    }

    /* renamed from: a */
    private static String m3229a(C0400a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.mo2949c(i))) {
                return aVar.mo2948b(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    static ArrayList<View> m3230a(C0788s sVar, Object obj, C0735d dVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = dVar.getView();
        if (view2 != null) {
            sVar.mo4566a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        sVar.mo4539a(obj, arrayList2);
        return arrayList2;
    }

    /* renamed from: a */
    private static void m3231a(C0400a<String, String> aVar, C0400a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.mo2949c(size))) {
                aVar.mo2953d(size);
            }
        }
    }

    /* renamed from: a */
    public static void m3232a(C0730a aVar, SparseArray<C0782a> sparseArray, boolean z) {
        int size = aVar.f2641d.size();
        for (int i = 0; i < size; i++) {
            m3233a(aVar, (C0775p.C0776a) aVar.f2641d.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        if (r10.mAdded != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0079, code lost:
        r13 = r1;
        r1 = false;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0088, code lost:
        if (r10.mHidden == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x008a, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0098  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3233a(androidx.fragment.app.C0730a r16, androidx.fragment.app.C0775p.C0776a r17, android.util.SparseArray<androidx.fragment.app.C0777q.C0782a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.d r10 = r1.f2660b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f2667a
            int r1 = r1.f2659a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f2659a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x007d
            switch(r1) {
                case 3: goto L_0x0053;
                case 4: goto L_0x003b;
                case 5: goto L_0x0029;
                case 6: goto L_0x0053;
                case 7: goto L_0x007d;
                default: goto L_0x0024;
            }
        L_0x0024:
            r1 = 0
        L_0x0025:
            r12 = 0
            r13 = 0
            goto L_0x0090
        L_0x0029:
            if (r20 == 0) goto L_0x0038
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x008c
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x008c
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x008c
            goto L_0x008a
        L_0x0038:
            boolean r1 = r10.mHidden
            goto L_0x008d
        L_0x003b:
            if (r20 == 0) goto L_0x004a
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.mHidden
            if (r1 == 0) goto L_0x006e
        L_0x0049:
            goto L_0x006c
        L_0x004a:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x006e
            goto L_0x0049
        L_0x0053:
            if (r20 == 0) goto L_0x0070
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x006e
            android.view.View r1 = r10.mView
            if (r1 == 0) goto L_0x006e
            android.view.View r1 = r10.mView
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x006e
            float r1 = r10.mPostponedAlpha
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x006e
        L_0x006c:
            r1 = 1
            goto L_0x0079
        L_0x006e:
            r1 = 0
            goto L_0x0079
        L_0x0070:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x006e
            goto L_0x006c
        L_0x0079:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x0090
        L_0x007d:
            if (r20 == 0) goto L_0x0082
            boolean r1 = r10.mIsNewlyAdded
            goto L_0x008d
        L_0x0082:
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x008c
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x008c
        L_0x008a:
            r1 = 1
            goto L_0x008d
        L_0x008c:
            r1 = 0
        L_0x008d:
            r4 = r1
            r1 = 1
            goto L_0x0025
        L_0x0090:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.app.q$a r6 = (androidx.fragment.app.C0777q.C0782a) r6
            if (r4 == 0) goto L_0x00a2
            androidx.fragment.app.q$a r6 = m3222a((androidx.fragment.app.C0777q.C0782a) r6, (android.util.SparseArray<androidx.fragment.app.C0777q.C0782a>) r2, (int) r11)
            r6.f2698a = r10
            r6.f2699b = r3
            r6.f2700c = r0
        L_0x00a2:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
            if (r14 == 0) goto L_0x00b0
            androidx.fragment.app.d r1 = r14.f2701d
            if (r1 != r10) goto L_0x00b0
            r14.f2701d = r15
        L_0x00b0:
            androidx.fragment.app.k r4 = r0.f2497a
            int r1 = r10.mState
            if (r1 >= r5) goto L_0x00c9
            int r1 = r4.f2569m
            if (r1 < r5) goto L_0x00c9
            boolean r1 = r0.f2657t
            if (r1 != 0) goto L_0x00c9
            r4.mo4443k(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.mo4396a((androidx.fragment.app.C0735d) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00c9:
            if (r13 == 0) goto L_0x00db
            if (r14 == 0) goto L_0x00d1
            androidx.fragment.app.d r1 = r14.f2701d
            if (r1 != 0) goto L_0x00db
        L_0x00d1:
            androidx.fragment.app.q$a r14 = m3222a((androidx.fragment.app.C0777q.C0782a) r14, (android.util.SparseArray<androidx.fragment.app.C0777q.C0782a>) r2, (int) r11)
            r14.f2701d = r10
            r14.f2702e = r3
            r14.f2703f = r0
        L_0x00db:
            if (r20 != 0) goto L_0x00e7
            if (r12 == 0) goto L_0x00e7
            if (r14 == 0) goto L_0x00e7
            androidx.fragment.app.d r0 = r14.f2698a
            if (r0 != r10) goto L_0x00e7
            r14.f2698a = r15
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0777q.m3233a(androidx.fragment.app.a, androidx.fragment.app.p$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: a */
    static void m3234a(C0735d dVar, C0735d dVar2, boolean z, C0400a<String, View> aVar, boolean z2) {
        C0521n enterTransitionCallback = z ? dVar2.getEnterTransitionCallback() : dVar.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.mo2948b(i));
                arrayList.add(aVar.mo2949c(i));
            }
            if (z2) {
                enterTransitionCallback.mo3499a((List<String>) arrayList2, (List<View>) arrayList, (List<View>) null);
            } else {
                enterTransitionCallback.mo3501b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.f2698a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3235a(androidx.fragment.app.C0753k r17, int r18, androidx.fragment.app.C0777q.C0782a r19, android.view.View r20, androidx.p018c.C0400a<java.lang.String, java.lang.String> r21) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            androidx.fragment.app.f r1 = r0.f2571o
            boolean r1 = r1.mo4273a()
            if (r1 == 0) goto L_0x0019
            androidx.fragment.app.f r0 = r0.f2571o
            r1 = r18
            android.view.View r0 = r0.mo4272a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            androidx.fragment.app.d r11 = r4.f2698a
            androidx.fragment.app.d r12 = r4.f2701d
            androidx.fragment.app.s r13 = m3224a((androidx.fragment.app.C0735d) r12, (androidx.fragment.app.C0735d) r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.f2699b
            boolean r0 = r4.f2702e
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = m3227a((androidx.fragment.app.C0788s) r13, (androidx.fragment.app.C0735d) r11, (boolean) r14)
            java.lang.Object r6 = m3245b((androidx.fragment.app.C0788s) r13, (androidx.fragment.app.C0735d) r12, (boolean) r0)
            r0 = r13
            r1 = r10
            r2 = r20
            r3 = r21
            r4 = r19
            r5 = r8
            r17 = r6
            r6 = r15
            r18 = r7
            r16 = r10
            r10 = r8
            r8 = r17
            java.lang.Object r8 = m3225a((androidx.fragment.app.C0788s) r0, (android.view.ViewGroup) r1, (android.view.View) r2, (androidx.p018c.C0400a<java.lang.String, java.lang.String>) r3, (androidx.fragment.app.C0777q.C0782a) r4, (java.util.ArrayList<android.view.View>) r5, (java.util.ArrayList<android.view.View>) r6, (java.lang.Object) r7, (java.lang.Object) r8)
            r6 = r18
            if (r6 != 0) goto L_0x0061
            if (r8 != 0) goto L_0x0061
            r7 = r17
            if (r7 != 0) goto L_0x0063
            return
        L_0x0061:
            r7 = r17
        L_0x0063:
            java.util.ArrayList r5 = m3230a((androidx.fragment.app.C0788s) r13, (java.lang.Object) r7, (androidx.fragment.app.C0735d) r12, (java.util.ArrayList<android.view.View>) r10, (android.view.View) r9)
            java.util.ArrayList r9 = m3230a((androidx.fragment.app.C0788s) r13, (java.lang.Object) r6, (androidx.fragment.app.C0735d) r11, (java.util.ArrayList<android.view.View>) r15, (android.view.View) r9)
            r0 = 4
            m3240a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = m3228a((androidx.fragment.app.C0788s) r0, (java.lang.Object) r1, (java.lang.Object) r2, (java.lang.Object) r3, (androidx.fragment.app.C0735d) r4, (boolean) r5)
            if (r14 == 0) goto L_0x00a4
            m3238a((androidx.fragment.app.C0788s) r13, (java.lang.Object) r7, (androidx.fragment.app.C0735d) r12, (java.util.ArrayList<android.view.View>) r11)
            java.util.ArrayList r12 = r13.mo4561a((java.util.ArrayList<android.view.View>) r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.mo4538a(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r13.mo4534a((android.view.ViewGroup) r0, (java.lang.Object) r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r21
            r1.mo4563a(r2, r3, r4, r5, r6)
            r0 = 0
            m3240a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r13.mo4540a((java.lang.Object) r8, (java.util.ArrayList<android.view.View>) r10, (java.util.ArrayList<android.view.View>) r15)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0777q.m3235a(androidx.fragment.app.k, int, androidx.fragment.app.q$a, android.view.View, androidx.c.a):void");
    }

    /* renamed from: a */
    static void m3236a(C0753k kVar, ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (kVar.f2569m >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C0730a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    m3246b(aVar, (SparseArray<C0782a>) sparseArray, z);
                } else {
                    m3232a(aVar, (SparseArray<C0782a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(kVar.f2570n.mo4356i());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C0400a<String, String> a = m3220a(keyAt, arrayList, arrayList2, i, i2);
                    C0782a aVar2 = (C0782a) sparseArray.valueAt(i4);
                    if (z) {
                        m3235a(kVar, keyAt, aVar2, view, a);
                    } else {
                        m3247b(kVar, keyAt, aVar2, view, a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3237a(C0788s sVar, ViewGroup viewGroup, C0735d dVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final C0788s sVar2 = sVar;
        final View view2 = view;
        final C0735d dVar2 = dVar;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        C0653r.m2564a(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    sVar2.mo4548c(obj, view2);
                    arrayList5.addAll(C0777q.m3230a(sVar2, obj3, dVar2, (ArrayList<View>) arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        sVar2.mo4546b(obj4, (ArrayList<View>) arrayList6, (ArrayList<View>) arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m3238a(C0788s sVar, Object obj, C0735d dVar, final ArrayList<View> arrayList) {
        if (dVar != null && obj != null && dVar.mAdded && dVar.mHidden && dVar.mHiddenChanged) {
            dVar.setHideReplaced(true);
            sVar.mo4545b(obj, dVar.getView(), arrayList);
            C0653r.m2564a(dVar.mContainer, new Runnable() {
                public void run() {
                    C0777q.m3240a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    /* renamed from: a */
    private static void m3239a(C0788s sVar, Object obj, Object obj2, C0400a<String, View> aVar, boolean z, C0730a aVar2) {
        if (aVar2.f2655r != null && !aVar2.f2655r.isEmpty()) {
            View view = aVar.get((String) (z ? aVar2.f2656s : aVar2.f2655r).get(0));
            sVar.mo4536a(obj, view);
            if (obj2 != null) {
                sVar.mo4536a(obj2, view);
            }
        }
    }

    /* renamed from: a */
    static void m3240a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static void m3241a(ArrayList<View> arrayList, C0400a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c = aVar.mo2949c(size);
            if (collection.contains(C0656u.m2632o(c))) {
                arrayList.add(c);
            }
        }
    }

    /* renamed from: a */
    private static boolean m3242a(C0788s sVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!sVar.mo4541a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static C0400a<String, View> m3243b(C0788s sVar, C0400a<String, String> aVar, Object obj, C0782a aVar2) {
        C0521n nVar;
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        C0735d dVar = aVar2.f2701d;
        C0400a<String, View> aVar3 = new C0400a<>();
        sVar.mo4567a((Map<String, View>) aVar3, dVar.requireView());
        C0730a aVar4 = aVar2.f2703f;
        if (aVar2.f2702e) {
            nVar = dVar.getEnterTransitionCallback();
            arrayList = aVar4.f2656s;
        } else {
            nVar = dVar.getExitTransitionCallback();
            arrayList = aVar4.f2655r;
        }
        aVar3.mo2811a(arrayList);
        if (nVar != null) {
            nVar.mo3500a((List<String>) arrayList, (Map<String, View>) aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(C0656u.m2632o(view))) {
                    aVar.put(C0656u.m2632o(view), aVar.remove(str));
                }
            }
        } else {
            aVar.mo2811a(aVar3.keySet());
        }
        return aVar3;
    }

    /* renamed from: b */
    private static Object m3244b(C0788s sVar, ViewGroup viewGroup, View view, C0400a<String, String> aVar, C0782a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        C0400a<String, String> aVar3;
        Object obj3;
        Object obj4;
        Rect rect;
        C0788s sVar2 = sVar;
        C0782a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        C0735d dVar = aVar4.f2698a;
        C0735d dVar2 = aVar4.f2701d;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        boolean z = aVar4.f2699b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            obj3 = null;
        } else {
            obj3 = m3226a(sVar2, dVar, dVar2, z);
            aVar3 = aVar;
        }
        C0400a<String, View> b = m3243b(sVar2, aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m3234a(dVar, dVar2, z, b, true);
        if (obj4 != null) {
            rect = new Rect();
            sVar2.mo4537a(obj4, view, arrayList3);
            m3239a(sVar, obj4, obj2, b, aVar4.f2702e, aVar4.f2703f);
            if (obj5 != null) {
                sVar2.mo4535a(obj5, rect);
            }
        } else {
            rect = null;
        }
        final C0788s sVar3 = sVar;
        final C0400a<String, String> aVar5 = aVar;
        final Object obj6 = obj4;
        final C0782a aVar6 = aVar2;
        C07814 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final C0735d dVar3 = dVar;
        final C0735d dVar4 = dVar2;
        final boolean z2 = z;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        C07814 r0 = new Runnable() {
            public void run() {
                C0400a<String, View> a = C0777q.m3221a(sVar3, (C0400a<String, String>) aVar5, obj6, aVar6);
                if (a != null) {
                    arrayList4.addAll(a.values());
                    arrayList4.add(view2);
                }
                C0777q.m3234a(dVar3, dVar4, z2, a, false);
                Object obj = obj6;
                if (obj != null) {
                    sVar3.mo4540a(obj, (ArrayList<View>) arrayList5, (ArrayList<View>) arrayList4);
                    View a2 = C0777q.m3219a(a, aVar6, obj7, z2);
                    if (a2 != null) {
                        sVar3.mo4562a(a2, rect2);
                    }
                }
            }
        };
        C0653r.m2564a(viewGroup, r13);
        return obj4;
    }

    /* renamed from: b */
    private static Object m3245b(C0788s sVar, C0735d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return sVar.mo4542b(z ? dVar.getReturnTransition() : dVar.getExitTransition());
    }

    /* renamed from: b */
    public static void m3246b(C0730a aVar, SparseArray<C0782a> sparseArray, boolean z) {
        if (aVar.f2497a.f2571o.mo4273a()) {
            for (int size = aVar.f2641d.size() - 1; size >= 0; size--) {
                m3233a(aVar, (C0775p.C0776a) aVar.f2641d.get(size), sparseArray, true, z);
            }
        }
    }

    /* renamed from: b */
    private static void m3247b(C0753k kVar, int i, C0782a aVar, View view, C0400a<String, String> aVar2) {
        C0735d dVar;
        C0735d dVar2;
        C0788s a;
        Object obj;
        C0753k kVar2 = kVar;
        C0782a aVar3 = aVar;
        View view2 = view;
        C0400a<String, String> aVar4 = aVar2;
        ViewGroup viewGroup = kVar2.f2571o.mo4273a() ? (ViewGroup) kVar2.f2571o.mo4272a(i) : null;
        if (viewGroup != null && (a = m3224a(dVar2, dVar)) != null) {
            boolean z = aVar3.f2699b;
            boolean z2 = aVar3.f2702e;
            Object a2 = m3227a(a, (dVar = aVar3.f2698a), z);
            Object b = m3245b(a, (dVar2 = aVar3.f2701d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b;
            C0788s sVar = a;
            Object b2 = m3244b(a, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a2, obj2);
            Object obj3 = a2;
            if (obj3 == null && b2 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> a3 = m3230a(sVar, obj, dVar2, (ArrayList<View>) arrayList3, view2);
            Object obj4 = (a3 == null || a3.isEmpty()) ? null : obj;
            sVar.mo4544b(obj3, view2);
            Object a4 = m3228a(sVar, obj3, obj4, b2, dVar, aVar3.f2699b);
            if (a4 != null) {
                ArrayList arrayList4 = new ArrayList();
                C0788s sVar2 = sVar;
                sVar2.mo4538a(a4, obj3, arrayList4, obj4, a3, b2, arrayList2);
                m3237a(sVar2, viewGroup, dVar, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, a3);
                ArrayList arrayList5 = arrayList2;
                sVar.mo4564a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar4);
                sVar.mo4534a(viewGroup, a4);
                sVar.mo4565a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar4);
            }
        }
    }
}
