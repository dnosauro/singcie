package androidx.p049j;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0788s;
import androidx.p049j.C0874n;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.j.e */
public class C0860e extends C0788s {
    /* renamed from: a */
    private static boolean m3495a(C0874n nVar) {
        return !m3267a((List) nVar.getTargetIds()) || !m3267a((List) nVar.getTargetNames()) || !m3267a((List) nVar.getTargetTypes());
    }

    /* renamed from: a */
    public Object mo4533a(Object obj, Object obj2, Object obj3) {
        C0887r rVar = new C0887r();
        if (obj != null) {
            rVar.mo4820a((C0874n) obj);
        }
        if (obj2 != null) {
            rVar.mo4820a((C0874n) obj2);
        }
        if (obj3 != null) {
            rVar.mo4820a((C0874n) obj3);
        }
        return rVar;
    }

    /* renamed from: a */
    public void mo4534a(ViewGroup viewGroup, Object obj) {
        C0883p.m3545a(viewGroup, (C0874n) obj);
    }

    /* renamed from: a */
    public void mo4535a(Object obj, final Rect rect) {
        if (obj != null) {
            ((C0874n) obj).setEpicenterCallback(new C0874n.C0880c() {
                /* renamed from: a */
                public Rect mo4738a(C0874n nVar) {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    /* renamed from: a */
    public void mo4536a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            mo4562a(view, rect);
            ((C0874n) obj).setEpicenterCallback(new C0874n.C0880c() {
                /* renamed from: a */
                public Rect mo4738a(C0874n nVar) {
                    return rect;
                }
            });
        }
    }

    /* renamed from: a */
    public void mo4537a(Object obj, View view, ArrayList<View> arrayList) {
        C0887r rVar = (C0887r) obj;
        List<View> targets = rVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m3266a(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo4539a((Object) rVar, arrayList);
    }

    /* renamed from: a */
    public void mo4538a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((C0874n) obj).addListener(new C0882o() {
            /* renamed from: b */
            public void mo4694b(C0874n nVar) {
                nVar.removeListener(this);
            }

            /* renamed from: e */
            public void mo4698e(C0874n nVar) {
                Object obj = obj5;
                if (obj != null) {
                    C0860e.this.mo4546b(obj, (ArrayList<View>) arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    C0860e.this.mo4546b(obj2, (ArrayList<View>) arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    C0860e.this.mo4546b(obj3, (ArrayList<View>) arrayList6, (ArrayList<View>) null);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo4539a(Object obj, ArrayList<View> arrayList) {
        C0874n nVar = (C0874n) obj;
        if (nVar != null) {
            int i = 0;
            if (nVar instanceof C0887r) {
                C0887r rVar = (C0887r) nVar;
                int a = rVar.mo4813a();
                while (i < a) {
                    mo4539a((Object) rVar.mo4823b(i), arrayList);
                    i++;
                }
            } else if (!m3495a(nVar) && m3267a((List) nVar.getTargets())) {
                int size = arrayList.size();
                while (i < size) {
                    nVar.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4540a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        C0887r rVar = (C0887r) obj;
        if (rVar != null) {
            rVar.getTargets().clear();
            rVar.getTargets().addAll(arrayList2);
            mo4546b((Object) rVar, arrayList, arrayList2);
        }
    }

    /* renamed from: a */
    public boolean mo4541a(Object obj) {
        return obj instanceof C0874n;
    }

    /* renamed from: b */
    public Object mo4542b(Object obj) {
        if (obj != null) {
            return ((C0874n) obj).clone();
        }
        return null;
    }

    /* renamed from: b */
    public Object mo4543b(Object obj, Object obj2, Object obj3) {
        C0874n nVar = (C0874n) obj;
        C0874n nVar2 = (C0874n) obj2;
        C0874n nVar3 = (C0874n) obj3;
        if (nVar != null && nVar2 != null) {
            nVar = new C0887r().mo4820a(nVar).mo4820a(nVar2).mo4814a(1);
        } else if (nVar == null) {
            nVar = nVar2 != null ? nVar2 : null;
        }
        if (nVar3 == null) {
            return nVar;
        }
        C0887r rVar = new C0887r();
        if (nVar != null) {
            rVar.mo4820a(nVar);
        }
        rVar.mo4820a(nVar3);
        return rVar;
    }

    /* renamed from: b */
    public void mo4544b(Object obj, View view) {
        if (obj != null) {
            ((C0874n) obj).addTarget(view);
        }
    }

    /* renamed from: b */
    public void mo4545b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((C0874n) obj).addListener(new C0874n.C0881d() {
            /* renamed from: a */
            public void mo4697a(C0874n nVar) {
            }

            /* renamed from: b */
            public void mo4694b(C0874n nVar) {
                nVar.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            /* renamed from: c */
            public void mo4695c(C0874n nVar) {
            }

            /* renamed from: d */
            public void mo4696d(C0874n nVar) {
            }

            /* renamed from: e */
            public void mo4698e(C0874n nVar) {
            }
        });
    }

    /* renamed from: b */
    public void mo4546b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        C0874n nVar = (C0874n) obj;
        int i = 0;
        if (nVar instanceof C0887r) {
            C0887r rVar = (C0887r) nVar;
            int a = rVar.mo4813a();
            while (i < a) {
                mo4546b((Object) rVar.mo4823b(i), arrayList, arrayList2);
                i++;
            }
        } else if (!m3495a(nVar)) {
            List<View> targets = nVar.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    nVar.addTarget(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    nVar.removeTarget(arrayList.get(size2));
                }
            }
        }
    }

    /* renamed from: c */
    public Object mo4547c(Object obj) {
        if (obj == null) {
            return null;
        }
        C0887r rVar = new C0887r();
        rVar.mo4820a((C0874n) obj);
        return rVar;
    }

    /* renamed from: c */
    public void mo4548c(Object obj, View view) {
        if (obj != null) {
            ((C0874n) obj).removeTarget(view);
        }
    }
}
