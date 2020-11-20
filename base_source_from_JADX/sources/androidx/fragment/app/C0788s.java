package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p030h.C0653r;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0666w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
/* renamed from: androidx.fragment.app.s */
public abstract class C0788s {
    /* renamed from: a */
    static String m3265a(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    /* renamed from: a */
    protected static void m3266a(List<View> list, View view) {
        int size = list.size();
        if (!m3268a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m3268a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected static boolean m3267a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    private static boolean m3268a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public abstract Object mo4533a(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<String> mo4561a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(C0656u.m2632o(view));
            C0656u.m2599a(view, (String) null);
        }
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4562a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4563a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String o = C0656u.m2632o(view2);
            arrayList4.add(o);
            if (o != null) {
                C0656u.m2599a(view2, (String) null);
                String str = map.get(o);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        C0656u.m2599a(arrayList2.get(i2), o);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        C0653r.m2564a(view, new Runnable() {
            public void run() {
                for (int i = 0; i < size; i++) {
                    C0656u.m2599a((View) arrayList5.get(i), (String) arrayList6.get(i));
                    C0656u.m2599a((View) arrayList7.get(i), (String) arrayList4.get(i));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4564a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        C0653r.m2564a(view, new Runnable() {
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    String o = C0656u.m2632o(view);
                    if (o != null) {
                        C0656u.m2599a(view, C0788s.m3265a((Map<String, String>) map, o));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public abstract void mo4534a(ViewGroup viewGroup, Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4565a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        C0653r.m2564a(viewGroup, new Runnable() {
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    C0656u.m2599a(view, (String) map.get(C0656u.m2632o(view)));
                }
            }
        });
    }

    /* renamed from: a */
    public abstract void mo4535a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo4536a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo4537a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4538a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo4539a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4540a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4566a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z = view instanceof ViewGroup;
            ViewGroup viewGroup = view;
            if (z) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                boolean a = C0666w.m2685a(viewGroup2);
                viewGroup = viewGroup2;
                if (!a) {
                    int childCount = viewGroup2.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        mo4566a(arrayList, viewGroup2.getChildAt(i));
                    }
                    return;
                }
            }
            arrayList.add(viewGroup);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4567a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String o = C0656u.m2632o(view);
            if (o != null) {
                map.put(o, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    mo4567a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    public abstract boolean mo4541a(Object obj);

    /* renamed from: b */
    public abstract Object mo4542b(Object obj);

    /* renamed from: b */
    public abstract Object mo4543b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo4544b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo4545b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo4546b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo4547c(Object obj);

    /* renamed from: c */
    public abstract void mo4548c(Object obj, View view);
}
