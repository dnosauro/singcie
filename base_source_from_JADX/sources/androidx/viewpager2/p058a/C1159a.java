package androidx.viewpager2.p058a;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: androidx.viewpager2.a.a */
final class C1159a {

    /* renamed from: a */
    private static final ViewGroup.MarginLayoutParams f3637a = new ViewGroup.MarginLayoutParams(-1, -1);

    /* renamed from: b */
    private LinearLayoutManager f3638b;

    static {
        f3637a.setMargins(0, 0, 0, 0);
    }

    C1159a(LinearLayoutManager linearLayoutManager) {
        this.f3638b = linearLayoutManager;
    }

    /* renamed from: a */
    private static boolean m4597a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (m4597a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m4598b() {
        int i;
        int i2;
        int i3;
        int i4;
        int childCount = this.f3638b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f3638b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{childCount, 2});
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = this.f3638b.getChildAt(i5);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f3637a;
                int[] iArr2 = iArr[i5];
                if (z) {
                    i2 = childAt.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    i2 = childAt.getTop();
                    i = marginLayoutParams.topMargin;
                }
                iArr2[0] = i2 - i;
                int[] iArr3 = iArr[i5];
                if (z) {
                    i4 = childAt.getRight();
                    i3 = marginLayoutParams.rightMargin;
                } else {
                    i4 = childAt.getBottom();
                    i3 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = i4 + i3;
                i5++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i6 = 1; i6 < childCount; i6++) {
            if (iArr[i6 - 1][1] != iArr[i6][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    /* renamed from: c */
    private boolean m4599c() {
        int childCount = this.f3638b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m4597a(this.f3638b.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6249a() {
        return (!m4598b() || this.f3638b.getChildCount() <= 1) && m4599c();
    }
}
