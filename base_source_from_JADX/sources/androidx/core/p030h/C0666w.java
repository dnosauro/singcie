package androidx.core.p030h;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.C0481a;

/* renamed from: androidx.core.h.w */
public final class C0666w {
    /* renamed from: a */
    public static boolean m2685a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(C0481a.C0484c.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && C0656u.m2632o(viewGroup) == null) ? false : true;
    }
}
