package androidx.core.p030h.p031a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.core.h.a.d */
public class C0618d {

    /* renamed from: a */
    private final Object f2285a;

    /* renamed from: androidx.core.h.a.d$a */
    static class C0619a extends AccessibilityNodeProvider {

        /* renamed from: a */
        final C0618d f2286a;

        C0619a(C0618d dVar) {
            this.f2286a = dVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C0614c a = this.f2286a.mo3769a(i);
            if (a == null) {
                return null;
            }
            return a.mo3703a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<C0614c> a = this.f2286a.mo3771a(str, i);
            if (a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a.get(i2).mo3703a());
            }
            return arrayList;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f2286a.mo3772a(i, i2, bundle);
        }
    }

    /* renamed from: androidx.core.h.a.d$b */
    static class C0620b extends C0619a {
        C0620b(C0618d dVar) {
            super(dVar);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            C0614c b = this.f2286a.mo3773b(i);
            if (b == null) {
                return null;
            }
            return b.mo3703a();
        }
    }

    public C0618d() {
        this.f2285a = Build.VERSION.SDK_INT >= 19 ? new C0620b(this) : Build.VERSION.SDK_INT >= 16 ? new C0619a(this) : null;
    }

    public C0618d(Object obj) {
        this.f2285a = obj;
    }

    /* renamed from: a */
    public C0614c mo3769a(int i) {
        return null;
    }

    /* renamed from: a */
    public Object mo3770a() {
        return this.f2285a;
    }

    /* renamed from: a */
    public List<C0614c> mo3771a(String str, int i) {
        return null;
    }

    /* renamed from: a */
    public boolean mo3772a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: b */
    public C0614c mo3773b(int i) {
        return null;
    }
}
