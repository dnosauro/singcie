package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p030h.p031a.C0614c;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.C1022i implements RecyclerView.C1039t.C1041b {

    /* renamed from: a */
    C1054e[] f3257a;

    /* renamed from: b */
    C1086j f3258b;

    /* renamed from: c */
    C1086j f3259c;

    /* renamed from: d */
    boolean f3260d = false;

    /* renamed from: e */
    boolean f3261e = false;

    /* renamed from: f */
    int f3262f = -1;

    /* renamed from: g */
    int f3263g = Integer.MIN_VALUE;

    /* renamed from: h */
    C1049c f3264h = new C1049c();

    /* renamed from: i */
    private int f3265i = -1;

    /* renamed from: j */
    private int f3266j;

    /* renamed from: k */
    private int f3267k;

    /* renamed from: l */
    private final C1081f f3268l;

    /* renamed from: m */
    private BitSet f3269m;

    /* renamed from: n */
    private int f3270n = 2;

    /* renamed from: o */
    private boolean f3271o;

    /* renamed from: p */
    private boolean f3272p;

    /* renamed from: q */
    private C1052d f3273q;

    /* renamed from: r */
    private int f3274r;

    /* renamed from: s */
    private final Rect f3275s = new Rect();

    /* renamed from: t */
    private final C1047a f3276t = new C1047a();

    /* renamed from: u */
    private boolean f3277u = false;

    /* renamed from: v */
    private boolean f3278v = true;

    /* renamed from: w */
    private int[] f3279w;

    /* renamed from: x */
    private final Runnable f3280x = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.mo5849a();
        }
    };

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$a */
    class C1047a {

        /* renamed from: a */
        int f3282a;

        /* renamed from: b */
        int f3283b;

        /* renamed from: c */
        boolean f3284c;

        /* renamed from: d */
        boolean f3285d;

        /* renamed from: e */
        boolean f3286e;

        /* renamed from: f */
        int[] f3287f;

        C1047a() {
            mo5864a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5864a() {
            this.f3282a = -1;
            this.f3283b = Integer.MIN_VALUE;
            this.f3284c = false;
            this.f3285d = false;
            this.f3286e = false;
            int[] iArr = this.f3287f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5865a(int i) {
            this.f3283b = this.f3284c ? StaggeredGridLayoutManager.this.f3258b.mo6042d() - i : StaggeredGridLayoutManager.this.f3258b.mo6040c() + i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5866a(C1054e[] eVarArr) {
            int length = eVarArr.length;
            int[] iArr = this.f3287f;
            if (iArr == null || iArr.length < length) {
                this.f3287f = new int[StaggeredGridLayoutManager.this.f3257a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f3287f[i] = eVarArr[i].mo5898a(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5867b() {
            this.f3283b = this.f3284c ? StaggeredGridLayoutManager.this.f3258b.mo6042d() : StaggeredGridLayoutManager.this.f3258b.mo6040c();
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$b */
    public static class C1048b extends RecyclerView.C1027j {

        /* renamed from: a */
        C1054e f3289a;

        /* renamed from: b */
        boolean f3290b;

        public C1048b(int i, int i2) {
            super(i, i2);
        }

        public C1048b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1048b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C1048b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* renamed from: a */
        public boolean mo5868a() {
            return this.f3290b;
        }

        /* renamed from: b */
        public final int mo5869b() {
            C1054e eVar = this.f3289a;
            if (eVar == null) {
                return -1;
            }
            return eVar.f3311e;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c */
    static class C1049c {

        /* renamed from: a */
        int[] f3291a;

        /* renamed from: b */
        List<C1050a> f3292b;

        @SuppressLint({"BanParcelableUsage"})
        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a */
        static class C1050a implements Parcelable {
            public static final Parcelable.Creator<C1050a> CREATOR = new Parcelable.Creator<C1050a>() {
                /* renamed from: a */
                public C1050a createFromParcel(Parcel parcel) {
                    return new C1050a(parcel);
                }

                /* renamed from: a */
                public C1050a[] newArray(int i) {
                    return new C1050a[i];
                }
            };

            /* renamed from: a */
            int f3293a;

            /* renamed from: b */
            int f3294b;

            /* renamed from: c */
            int[] f3295c;

            /* renamed from: d */
            boolean f3296d;

            C1050a() {
            }

            C1050a(Parcel parcel) {
                this.f3293a = parcel.readInt();
                this.f3294b = parcel.readInt();
                this.f3296d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f3295c = new int[readInt];
                    parcel.readIntArray(this.f3295c);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public int mo5882a(int i) {
                int[] iArr = this.f3295c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3293a + ", mGapDir=" + this.f3294b + ", mHasUnwantedGapAfter=" + this.f3296d + ", mGapPerSpan=" + Arrays.toString(this.f3295c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3293a);
                parcel.writeInt(this.f3294b);
                parcel.writeInt(this.f3296d ? 1 : 0);
                int[] iArr = this.f3295c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f3295c);
            }
        }

        C1049c() {
        }

        /* renamed from: c */
        private void m4067c(int i, int i2) {
            List<C1050a> list = this.f3292b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    C1050a aVar = this.f3292b.get(size);
                    if (aVar.f3293a >= i) {
                        if (aVar.f3293a < i3) {
                            this.f3292b.remove(size);
                        } else {
                            aVar.f3293a -= i2;
                        }
                    }
                }
            }
        }

        /* renamed from: d */
        private void m4068d(int i, int i2) {
            List<C1050a> list = this.f3292b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    C1050a aVar = this.f3292b.get(size);
                    if (aVar.f3293a >= i) {
                        aVar.f3293a += i2;
                    }
                }
            }
        }

        /* renamed from: g */
        private int m4069g(int i) {
            if (this.f3292b == null) {
                return -1;
            }
            C1050a f = mo5881f(i);
            if (f != null) {
                this.f3292b.remove(f);
            }
            int size = this.f3292b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f3292b.get(i2).f3293a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f3292b.remove(i2);
            return this.f3292b.get(i2).f3293a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5870a(int i) {
            List<C1050a> list = this.f3292b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3292b.get(size).f3293a >= i) {
                        this.f3292b.remove(size);
                    }
                }
            }
            return mo5876b(i);
        }

        /* renamed from: a */
        public C1050a mo5871a(int i, int i2, int i3, boolean z) {
            List<C1050a> list = this.f3292b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1050a aVar = this.f3292b.get(i4);
                if (aVar.f3293a >= i2) {
                    return null;
                }
                if (aVar.f3293a >= i && (i3 == 0 || aVar.f3294b == i3 || (z && aVar.f3296d))) {
                    return aVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5872a() {
            int[] iArr = this.f3291a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3292b = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5873a(int i, int i2) {
            int[] iArr = this.f3291a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                mo5880e(i3);
                int[] iArr2 = this.f3291a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f3291a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                m4067c(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5874a(int i, C1054e eVar) {
            mo5880e(i);
            this.f3291a[i] = eVar.f3311e;
        }

        /* renamed from: a */
        public void mo5875a(C1050a aVar) {
            if (this.f3292b == null) {
                this.f3292b = new ArrayList();
            }
            int size = this.f3292b.size();
            for (int i = 0; i < size; i++) {
                C1050a aVar2 = this.f3292b.get(i);
                if (aVar2.f3293a == aVar.f3293a) {
                    this.f3292b.remove(i);
                }
                if (aVar2.f3293a >= aVar.f3293a) {
                    this.f3292b.add(i, aVar);
                    return;
                }
            }
            this.f3292b.add(aVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5876b(int i) {
            int[] iArr = this.f3291a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = m4069g(i);
            if (g == -1) {
                int[] iArr2 = this.f3291a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f3291a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f3291a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5877b(int i, int i2) {
            int[] iArr = this.f3291a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                mo5880e(i3);
                int[] iArr2 = this.f3291a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f3291a, i, i3, -1);
                m4068d(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo5878c(int i) {
            int[] iArr = this.f3291a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo5879d(int i) {
            int length = this.f3291a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5880e(int i) {
            int[] iArr = this.f3291a;
            if (iArr == null) {
                this.f3291a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f3291a, -1);
            } else if (i >= iArr.length) {
                this.f3291a = new int[mo5879d(i)];
                System.arraycopy(iArr, 0, this.f3291a, 0, iArr.length);
                int[] iArr2 = this.f3291a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* renamed from: f */
        public C1050a mo5881f(int i) {
            List<C1050a> list = this.f3292b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                C1050a aVar = this.f3292b.get(size);
                if (aVar.f3293a == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d */
    public static class C1052d implements Parcelable {
        public static final Parcelable.Creator<C1052d> CREATOR = new Parcelable.Creator<C1052d>() {
            /* renamed from: a */
            public C1052d createFromParcel(Parcel parcel) {
                return new C1052d(parcel);
            }

            /* renamed from: a */
            public C1052d[] newArray(int i) {
                return new C1052d[i];
            }
        };

        /* renamed from: a */
        int f3297a;

        /* renamed from: b */
        int f3298b;

        /* renamed from: c */
        int f3299c;

        /* renamed from: d */
        int[] f3300d;

        /* renamed from: e */
        int f3301e;

        /* renamed from: f */
        int[] f3302f;

        /* renamed from: g */
        List<C1049c.C1050a> f3303g;

        /* renamed from: h */
        boolean f3304h;

        /* renamed from: i */
        boolean f3305i;

        /* renamed from: j */
        boolean f3306j;

        public C1052d() {
        }

        C1052d(Parcel parcel) {
            this.f3297a = parcel.readInt();
            this.f3298b = parcel.readInt();
            this.f3299c = parcel.readInt();
            int i = this.f3299c;
            if (i > 0) {
                this.f3300d = new int[i];
                parcel.readIntArray(this.f3300d);
            }
            this.f3301e = parcel.readInt();
            int i2 = this.f3301e;
            if (i2 > 0) {
                this.f3302f = new int[i2];
                parcel.readIntArray(this.f3302f);
            }
            boolean z = false;
            this.f3304h = parcel.readInt() == 1;
            this.f3305i = parcel.readInt() == 1;
            this.f3306j = parcel.readInt() == 1 ? true : z;
            this.f3303g = parcel.readArrayList(C1049c.C1050a.class.getClassLoader());
        }

        public C1052d(C1052d dVar) {
            this.f3299c = dVar.f3299c;
            this.f3297a = dVar.f3297a;
            this.f3298b = dVar.f3298b;
            this.f3300d = dVar.f3300d;
            this.f3301e = dVar.f3301e;
            this.f3302f = dVar.f3302f;
            this.f3304h = dVar.f3304h;
            this.f3305i = dVar.f3305i;
            this.f3306j = dVar.f3306j;
            this.f3303g = dVar.f3303g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5890a() {
            this.f3300d = null;
            this.f3299c = 0;
            this.f3301e = 0;
            this.f3302f = null;
            this.f3303g = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5891b() {
            this.f3300d = null;
            this.f3299c = 0;
            this.f3297a = -1;
            this.f3298b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3297a);
            parcel.writeInt(this.f3298b);
            parcel.writeInt(this.f3299c);
            if (this.f3299c > 0) {
                parcel.writeIntArray(this.f3300d);
            }
            parcel.writeInt(this.f3301e);
            if (this.f3301e > 0) {
                parcel.writeIntArray(this.f3302f);
            }
            parcel.writeInt(this.f3304h ? 1 : 0);
            parcel.writeInt(this.f3305i ? 1 : 0);
            parcel.writeInt(this.f3306j ? 1 : 0);
            parcel.writeList(this.f3303g);
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$e */
    class C1054e {

        /* renamed from: a */
        ArrayList<View> f3307a = new ArrayList<>();

        /* renamed from: b */
        int f3308b = Integer.MIN_VALUE;

        /* renamed from: c */
        int f3309c = Integer.MIN_VALUE;

        /* renamed from: d */
        int f3310d = 0;

        /* renamed from: e */
        final int f3311e;

        C1054e(int i) {
            this.f3311e = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5898a(int i) {
            int i2 = this.f3308b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3307a.size() == 0) {
                return i;
            }
            mo5902a();
            return this.f3308b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5899a(int i, int i2, boolean z) {
            return mo5900a(i, i2, false, false, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5900a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = StaggeredGridLayoutManager.this.f3258b.mo6040c();
            int d = StaggeredGridLayoutManager.this.f3258b.mo6042d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f3307a.get(i);
                int a = StaggeredGridLayoutManager.this.f3258b.mo6035a(view);
                int b = StaggeredGridLayoutManager.this.f3258b.mo6039b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a < d : a <= d;
                if (!z3 ? b > c : b >= c) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (!z2 && a >= c && b <= d) {
                        }
                    } else if (a >= c && b <= d) {
                    }
                    return StaggeredGridLayoutManager.this.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        /* renamed from: a */
        public View mo5901a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f3307a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f3307a.get(size);
                    if ((StaggeredGridLayoutManager.this.f3260d && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || ((!StaggeredGridLayoutManager.this.f3260d && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3307a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f3307a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f3260d && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || ((!StaggeredGridLayoutManager.this.f3260d && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5902a() {
            C1049c.C1050a f;
            View view = this.f3307a.get(0);
            C1048b c = mo5908c(view);
            this.f3308b = StaggeredGridLayoutManager.this.f3258b.mo6035a(view);
            if (c.f3290b && (f = StaggeredGridLayoutManager.this.f3264h.mo5881f(c.mo5703f())) != null && f.f3294b == -1) {
                this.f3308b -= f.mo5882a(this.f3311e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5903a(View view) {
            C1048b c = mo5908c(view);
            c.f3289a = this;
            this.f3307a.add(0, view);
            this.f3308b = Integer.MIN_VALUE;
            if (this.f3307a.size() == 1) {
                this.f3309c = Integer.MIN_VALUE;
            }
            if (c.mo5701d() || c.mo5702e()) {
                this.f3310d += StaggeredGridLayoutManager.this.f3258b.mo6045e(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5904a(boolean z, int i) {
            int b = z ? mo5906b(Integer.MIN_VALUE) : mo5898a(Integer.MIN_VALUE);
            mo5913e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < StaggeredGridLayoutManager.this.f3258b.mo6042d()) {
                    return;
                }
                if (z || b <= StaggeredGridLayoutManager.this.f3258b.mo6040c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f3309c = b;
                    this.f3308b = b;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5905b() {
            int i = this.f3308b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo5902a();
            return this.f3308b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5906b(int i) {
            int i2 = this.f3309c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3307a.size() == 0) {
                return i;
            }
            mo5909c();
            return this.f3309c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5907b(View view) {
            C1048b c = mo5908c(view);
            c.f3289a = this;
            this.f3307a.add(view);
            this.f3309c = Integer.MIN_VALUE;
            if (this.f3307a.size() == 1) {
                this.f3308b = Integer.MIN_VALUE;
            }
            if (c.mo5701d() || c.mo5702e()) {
                this.f3310d += StaggeredGridLayoutManager.this.f3258b.mo6045e(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C1048b mo5908c(View view) {
            return (C1048b) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5909c() {
            C1049c.C1050a f;
            ArrayList<View> arrayList = this.f3307a;
            View view = arrayList.get(arrayList.size() - 1);
            C1048b c = mo5908c(view);
            this.f3309c = StaggeredGridLayoutManager.this.f3258b.mo6039b(view);
            if (c.f3290b && (f = StaggeredGridLayoutManager.this.f3264h.mo5881f(c.mo5703f())) != null && f.f3294b == 1) {
                this.f3309c += f.mo5882a(this.f3311e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5910c(int i) {
            this.f3308b = i;
            this.f3309c = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo5911d() {
            int i = this.f3309c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo5909c();
            return this.f3309c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5912d(int i) {
            int i2 = this.f3308b;
            if (i2 != Integer.MIN_VALUE) {
                this.f3308b = i2 + i;
            }
            int i3 = this.f3309c;
            if (i3 != Integer.MIN_VALUE) {
                this.f3309c = i3 + i;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5913e() {
            this.f3307a.clear();
            mo5914f();
            this.f3310d = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo5914f() {
            this.f3308b = Integer.MIN_VALUE;
            this.f3309c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo5915g() {
            int size = this.f3307a.size();
            View remove = this.f3307a.remove(size - 1);
            C1048b c = mo5908c(remove);
            c.f3289a = null;
            if (c.mo5701d() || c.mo5702e()) {
                this.f3310d -= StaggeredGridLayoutManager.this.f3258b.mo6045e(remove);
            }
            if (size == 1) {
                this.f3308b = Integer.MIN_VALUE;
            }
            this.f3309c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo5916h() {
            View remove = this.f3307a.remove(0);
            C1048b c = mo5908c(remove);
            c.f3289a = null;
            if (this.f3307a.size() == 0) {
                this.f3309c = Integer.MIN_VALUE;
            }
            if (c.mo5701d() || c.mo5702e()) {
                this.f3310d -= StaggeredGridLayoutManager.this.f3258b.mo6045e(remove);
            }
            this.f3308b = Integer.MIN_VALUE;
        }

        /* renamed from: i */
        public int mo5917i() {
            return this.f3310d;
        }

        /* renamed from: j */
        public int mo5918j() {
            int i;
            int i2;
            if (StaggeredGridLayoutManager.this.f3260d) {
                i2 = this.f3307a.size() - 1;
                i = -1;
            } else {
                i2 = 0;
                i = this.f3307a.size();
            }
            return mo5899a(i2, i, true);
        }

        /* renamed from: k */
        public int mo5919k() {
            int i;
            int i2;
            if (StaggeredGridLayoutManager.this.f3260d) {
                i2 = 0;
                i = this.f3307a.size();
            } else {
                i2 = this.f3307a.size() - 1;
                i = -1;
            }
            return mo5899a(i2, i, true);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.C1022i.C1026b properties = getProperties(context, attributeSet, i, i2);
        mo5852b(properties.f3201a);
        mo5845a(properties.f3202b);
        mo5848a(properties.f3203c);
        this.f3268l = new C1081f();
        m4034j();
    }

    /* renamed from: a */
    private int m4003a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* renamed from: a */
    private int m4004a(RecyclerView.C1034p pVar, C1081f fVar, RecyclerView.C1042u uVar) {
        int i;
        C1054e eVar;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View view;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        RecyclerView.C1034p pVar2 = pVar;
        C1081f fVar2 = fVar;
        ? r9 = 0;
        this.f3269m.set(0, this.f3265i, true);
        if (this.f3268l.f3440i) {
            i = fVar2.f3436e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i = fVar2.f3436e == 1 ? fVar2.f3438g + fVar2.f3433b : fVar2.f3437f - fVar2.f3433b;
        }
        m4007a(fVar2.f3436e, i);
        int d = this.f3261e ? this.f3258b.mo6042d() : this.f3258b.mo6040c();
        boolean z = false;
        while (fVar.mo6018a(uVar) && (this.f3268l.f3440i || !this.f3269m.isEmpty())) {
            View a = fVar2.mo6017a(pVar2);
            C1048b bVar = (C1048b) a.getLayoutParams();
            int f = bVar.mo5703f();
            int c = this.f3264h.mo5878c(f);
            boolean z2 = c == -1;
            if (z2) {
                eVar = bVar.f3290b ? this.f3257a[r9] : m4006a(fVar2);
                this.f3264h.mo5874a(f, eVar);
            } else {
                eVar = this.f3257a[c];
            }
            C1054e eVar2 = eVar;
            bVar.f3289a = eVar2;
            if (fVar2.f3436e == 1) {
                addView(a);
            } else {
                addView(a, r9);
            }
            m4011a(a, bVar, (boolean) r9);
            if (fVar2.f3436e == 1) {
                int i8 = bVar.f3290b ? m4032i(d) : eVar2.mo5906b(d);
                int e = this.f3258b.mo6045e(a) + i8;
                if (z2 && bVar.f3290b) {
                    C1049c.C1050a e2 = m4028e(i8);
                    e2.f3294b = -1;
                    e2.f3293a = f;
                    this.f3264h.mo5875a(e2);
                }
                i2 = e;
                i3 = i8;
            } else {
                int h = bVar.f3290b ? m4031h(d) : eVar2.mo5898a(d);
                i3 = h - this.f3258b.mo6045e(a);
                if (z2 && bVar.f3290b) {
                    C1049c.C1050a f2 = m4029f(h);
                    f2.f3294b = 1;
                    f2.f3293a = f;
                    this.f3264h.mo5875a(f2);
                }
                i2 = h;
            }
            if (bVar.f3290b && fVar2.f3435d == -1) {
                if (!z2) {
                    if (!(fVar2.f3436e == 1 ? mo5859f() : mo5860g())) {
                        C1049c.C1050a f3 = this.f3264h.mo5881f(f);
                        if (f3 != null) {
                            f3.f3296d = true;
                        }
                    }
                }
                this.f3277u = true;
            }
            m4010a(a, bVar, fVar2);
            if (!mo5857d() || this.f3266j != 1) {
                int c2 = bVar.f3290b ? this.f3259c.mo6040c() : (eVar2.f3311e * this.f3267k) + this.f3259c.mo6040c();
                i5 = c2;
                i4 = this.f3259c.mo6045e(a) + c2;
            } else {
                int d2 = bVar.f3290b ? this.f3259c.mo6042d() : this.f3259c.mo6042d() - (((this.f3265i - 1) - eVar2.f3311e) * this.f3267k);
                i4 = d2;
                i5 = d2 - this.f3259c.mo6045e(a);
            }
            if (this.f3266j == 1) {
                staggeredGridLayoutManager = this;
                view = a;
                i7 = i5;
                i5 = i3;
                i6 = i4;
            } else {
                staggeredGridLayoutManager = this;
                view = a;
                i7 = i3;
                i6 = i2;
                i2 = i4;
            }
            staggeredGridLayoutManager.layoutDecoratedWithMargins(view, i7, i5, i6, i2);
            if (bVar.f3290b) {
                m4007a(this.f3268l.f3436e, i);
            } else {
                m4016a(eVar2, this.f3268l.f3436e, i);
            }
            m4014a(pVar2, this.f3268l);
            if (this.f3268l.f3439h && a.hasFocusable()) {
                if (bVar.f3290b) {
                    this.f3269m.clear();
                } else {
                    this.f3269m.set(eVar2.f3311e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            m4014a(pVar2, this.f3268l);
        }
        int c3 = this.f3268l.f3436e == -1 ? this.f3258b.mo6040c() - m4031h(this.f3258b.mo6040c()) : m4032i(this.f3258b.mo6042d()) - this.f3258b.mo6042d();
        if (c3 > 0) {
            return Math.min(fVar2.f3433b, c3);
        }
        return 0;
    }

    /* renamed from: a */
    private int m4005a(RecyclerView.C1042u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C1093m.m4324a(uVar, this.f3258b, mo5851b(!this.f3278v), mo5854c(!this.f3278v), this, this.f3278v, this.f3261e);
    }

    /* renamed from: a */
    private C1054e m4006a(C1081f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (m4036k(fVar.f3436e)) {
            i2 = this.f3265i - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.f3265i;
            i = 1;
        }
        C1054e eVar = null;
        if (fVar.f3436e == 1) {
            int i4 = Integer.MAX_VALUE;
            int c = this.f3258b.mo6040c();
            while (i2 != i3) {
                C1054e eVar2 = this.f3257a[i2];
                int b = eVar2.mo5906b(c);
                if (b < i4) {
                    eVar = eVar2;
                    i4 = b;
                }
                i2 += i;
            }
            return eVar;
        }
        int i5 = Integer.MIN_VALUE;
        int d = this.f3258b.mo6042d();
        while (i2 != i3) {
            C1054e eVar3 = this.f3257a[i2];
            int a = eVar3.mo5898a(d);
            if (a > i5) {
                eVar = eVar3;
                i5 = a;
            }
            i2 += i;
        }
        return eVar;
    }

    /* renamed from: a */
    private void m4007a(int i, int i2) {
        for (int i3 = 0; i3 < this.f3265i; i3++) {
            if (!this.f3257a[i3].f3307a.isEmpty()) {
                m4016a(this.f3257a[i3], i, i2);
            }
        }
    }

    /* renamed from: a */
    private void m4008a(View view) {
        for (int i = this.f3265i - 1; i >= 0; i--) {
            this.f3257a[i].mo5907b(view);
        }
    }

    /* renamed from: a */
    private void m4009a(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.f3275s);
        C1048b bVar = (C1048b) view.getLayoutParams();
        int a = m4003a(i, bVar.leftMargin + this.f3275s.left, bVar.rightMargin + this.f3275s.right);
        int a2 = m4003a(i2, bVar.topMargin + this.f3275s.top, bVar.bottomMargin + this.f3275s.bottom);
        if (z ? shouldReMeasureChild(view, a, a2, bVar) : shouldMeasureChild(view, a, a2, bVar)) {
            view.measure(a, a2);
        }
    }

    /* renamed from: a */
    private void m4010a(View view, C1048b bVar, C1081f fVar) {
        if (fVar.f3436e == 1) {
            if (bVar.f3290b) {
                m4008a(view);
            } else {
                bVar.f3289a.mo5907b(view);
            }
        } else if (bVar.f3290b) {
            m4021b(view);
        } else {
            bVar.f3289a.mo5903a(view);
        }
    }

    /* renamed from: a */
    private void m4011a(View view, C1048b bVar, boolean z) {
        int i;
        int i2;
        if (bVar.f3290b) {
            if (this.f3266j == 1) {
                i2 = this.f3274r;
            } else {
                m4009a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), this.f3274r, z);
                return;
            }
        } else if (this.f3266j == 1) {
            i2 = getChildMeasureSpec(this.f3267k, getWidthMode(), 0, bVar.width, false);
        } else {
            i2 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true);
            i = getChildMeasureSpec(this.f3267k, getHeightMode(), 0, bVar.height, false);
            m4009a(view, i2, i, z);
        }
        i = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true);
        m4009a(view, i2, i, z);
    }

    /* renamed from: a */
    private void m4012a(RecyclerView.C1034p pVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f3258b.mo6039b(childAt) <= i && this.f3258b.mo6041c(childAt) <= i) {
                C1048b bVar = (C1048b) childAt.getLayoutParams();
                if (bVar.f3290b) {
                    int i2 = 0;
                    while (i2 < this.f3265i) {
                        if (this.f3257a[i2].f3307a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f3265i; i3++) {
                        this.f3257a[i3].mo5916h();
                    }
                } else if (bVar.f3289a.f3307a.size() != 1) {
                    bVar.f3289a.mo5916h();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, pVar);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0151, code lost:
        if (mo5849a() != false) goto L_0x0155;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4013a(androidx.recyclerview.widget.RecyclerView.C1034p r9, androidx.recyclerview.widget.RecyclerView.C1042u r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.f3276t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r1 = r8.f3273q
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f3262f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.mo5796e()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.mo5864a()
            return
        L_0x0018:
            boolean r1 = r0.f3286e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f3262f
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r1 = r8.f3273q
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.mo5864a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3273q
            if (r5 == 0) goto L_0x0037
            r8.m4015a((androidx.recyclerview.widget.StaggeredGridLayoutManager.C1047a) r0)
            goto L_0x003e
        L_0x0037:
            r8.m4035k()
            boolean r5 = r8.f3261e
            r0.f3284c = r5
        L_0x003e:
            r8.mo5847a((androidx.recyclerview.widget.RecyclerView.C1042u) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1047a) r0)
            r0.f3286e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3273q
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f3262f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f3284c
            boolean r6 = r8.f3271o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.mo5857d()
            boolean r6 = r8.f3272p
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r5 = r8.f3264h
            r5.mo5872a()
            r0.f3285d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3273q
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f3299c
            if (r5 >= r4) goto L_0x00cb
        L_0x006e:
            boolean r5 = r0.f3285d
            if (r5 == 0) goto L_0x0090
            r1 = 0
        L_0x0073:
            int r5 = r8.f3265i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3257a
            r5 = r5[r1]
            r5.mo5913e()
            int r5 = r0.f3283b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3257a
            r5 = r5[r1]
            int r6 = r0.f3283b
            r5.mo5910c((int) r6)
        L_0x008d:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x0090:
            if (r1 != 0) goto L_0x00b1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.f3276t
            int[] r1 = r1.f3287f
            if (r1 != 0) goto L_0x0099
            goto L_0x00b1
        L_0x0099:
            r1 = 0
        L_0x009a:
            int r5 = r8.f3265i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3257a
            r5 = r5[r1]
            r5.mo5913e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.f3276t
            int[] r6 = r6.f3287f
            r6 = r6[r1]
            r5.mo5910c((int) r6)
            int r1 = r1 + 1
            goto L_0x009a
        L_0x00b1:
            r1 = 0
        L_0x00b2:
            int r5 = r8.f3265i
            if (r1 >= r5) goto L_0x00c4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3257a
            r5 = r5[r1]
            boolean r6 = r8.f3261e
            int r7 = r0.f3283b
            r5.mo5904a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00c4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.f3276t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3257a
            r1.mo5866a((androidx.recyclerview.widget.StaggeredGridLayoutManager.C1054e[]) r5)
        L_0x00cb:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.f r1 = r8.f3268l
            r1.f3432a = r3
            r8.f3277u = r3
            androidx.recyclerview.widget.j r1 = r8.f3259c
            int r1 = r1.mo6046f()
            r8.mo5856c((int) r1)
            int r1 = r0.f3282a
            r8.m4020b((int) r1, (androidx.recyclerview.widget.RecyclerView.C1042u) r10)
            boolean r1 = r0.f3284c
            if (r1 == 0) goto L_0x00f2
            r8.m4027d(r2)
            androidx.recyclerview.widget.f r1 = r8.f3268l
            r8.m4004a((androidx.recyclerview.widget.RecyclerView.C1034p) r9, (androidx.recyclerview.widget.C1081f) r1, (androidx.recyclerview.widget.RecyclerView.C1042u) r10)
            r8.m4027d(r4)
            goto L_0x00fd
        L_0x00f2:
            r8.m4027d(r4)
            androidx.recyclerview.widget.f r1 = r8.f3268l
            r8.m4004a((androidx.recyclerview.widget.RecyclerView.C1034p) r9, (androidx.recyclerview.widget.C1081f) r1, (androidx.recyclerview.widget.RecyclerView.C1042u) r10)
            r8.m4027d(r2)
        L_0x00fd:
            androidx.recyclerview.widget.f r1 = r8.f3268l
            int r2 = r0.f3282a
            androidx.recyclerview.widget.f r5 = r8.f3268l
            int r5 = r5.f3435d
            int r2 = r2 + r5
            r1.f3434c = r2
            androidx.recyclerview.widget.f r1 = r8.f3268l
            r8.m4004a((androidx.recyclerview.widget.RecyclerView.C1034p) r9, (androidx.recyclerview.widget.C1081f) r1, (androidx.recyclerview.widget.RecyclerView.C1042u) r10)
            r8.m4038l()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x0127
            boolean r1 = r8.f3261e
            if (r1 == 0) goto L_0x0121
            r8.m4023b((androidx.recyclerview.widget.RecyclerView.C1034p) r9, (androidx.recyclerview.widget.RecyclerView.C1042u) r10, (boolean) r4)
            r8.m4025c(r9, r10, r3)
            goto L_0x0127
        L_0x0121:
            r8.m4025c(r9, r10, r4)
            r8.m4023b((androidx.recyclerview.widget.RecyclerView.C1034p) r9, (androidx.recyclerview.widget.RecyclerView.C1042u) r10, (boolean) r3)
        L_0x0127:
            if (r11 == 0) goto L_0x0154
            boolean r11 = r10.mo5792a()
            if (r11 != 0) goto L_0x0154
            int r11 = r8.f3270n
            if (r11 == 0) goto L_0x0145
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x0145
            boolean r11 = r8.f3277u
            if (r11 != 0) goto L_0x0143
            android.view.View r11 = r8.mo5850b()
            if (r11 == 0) goto L_0x0145
        L_0x0143:
            r11 = 1
            goto L_0x0146
        L_0x0145:
            r11 = 0
        L_0x0146:
            if (r11 == 0) goto L_0x0154
            java.lang.Runnable r11 = r8.f3280x
            r8.removeCallbacks(r11)
            boolean r11 = r8.mo5849a()
            if (r11 == 0) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r4 = 0
        L_0x0155:
            boolean r11 = r10.mo5792a()
            if (r11 == 0) goto L_0x0160
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.f3276t
            r11.mo5864a()
        L_0x0160:
            boolean r11 = r0.f3284c
            r8.f3271o = r11
            boolean r11 = r8.mo5857d()
            r8.f3272p = r11
            if (r4 == 0) goto L_0x0174
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.f3276t
            r11.mo5864a()
            r8.m4013a((androidx.recyclerview.widget.RecyclerView.C1034p) r9, (androidx.recyclerview.widget.RecyclerView.C1042u) r10, (boolean) r3)
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4013a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r4.f3436e == -1) goto L_0x0012;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4014a(androidx.recyclerview.widget.RecyclerView.C1034p r3, androidx.recyclerview.widget.C1081f r4) {
        /*
            r2 = this;
            boolean r0 = r4.f3432a
            if (r0 == 0) goto L_0x004f
            boolean r0 = r4.f3440i
            if (r0 == 0) goto L_0x0009
            goto L_0x004f
        L_0x0009:
            int r0 = r4.f3433b
            r1 = -1
            if (r0 != 0) goto L_0x001e
            int r0 = r4.f3436e
            if (r0 != r1) goto L_0x0018
        L_0x0012:
            int r4 = r4.f3438g
        L_0x0014:
            r2.m4022b((androidx.recyclerview.widget.RecyclerView.C1034p) r3, (int) r4)
            goto L_0x004f
        L_0x0018:
            int r4 = r4.f3437f
        L_0x001a:
            r2.m4012a((androidx.recyclerview.widget.RecyclerView.C1034p) r3, (int) r4)
            goto L_0x004f
        L_0x001e:
            int r0 = r4.f3436e
            if (r0 != r1) goto L_0x0039
            int r0 = r4.f3437f
            int r1 = r4.f3437f
            int r1 = r2.m4030g(r1)
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x002e
            goto L_0x0012
        L_0x002e:
            int r1 = r4.f3438g
            int r4 = r4.f3433b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L_0x0014
        L_0x0039:
            int r0 = r4.f3438g
            int r0 = r2.m4033j(r0)
            int r1 = r4.f3438g
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0045
            goto L_0x0018
        L_0x0045:
            int r1 = r4.f3437f
            int r4 = r4.f3433b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L_0x001a
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4014a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.f):void");
    }

    /* renamed from: a */
    private void m4015a(C1047a aVar) {
        boolean z;
        if (this.f3273q.f3299c > 0) {
            if (this.f3273q.f3299c == this.f3265i) {
                for (int i = 0; i < this.f3265i; i++) {
                    this.f3257a[i].mo5913e();
                    int i2 = this.f3273q.f3300d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 += this.f3273q.f3305i ? this.f3258b.mo6042d() : this.f3258b.mo6040c();
                    }
                    this.f3257a[i].mo5910c(i2);
                }
            } else {
                this.f3273q.mo5890a();
                C1052d dVar = this.f3273q;
                dVar.f3297a = dVar.f3298b;
            }
        }
        this.f3272p = this.f3273q.f3306j;
        mo5848a(this.f3273q.f3304h);
        m4035k();
        if (this.f3273q.f3297a != -1) {
            this.f3262f = this.f3273q.f3297a;
            z = this.f3273q.f3305i;
        } else {
            z = this.f3261e;
        }
        aVar.f3284c = z;
        if (this.f3273q.f3301e > 1) {
            this.f3264h.f3291a = this.f3273q.f3302f;
            this.f3264h.f3292b = this.f3273q.f3303g;
        }
    }

    /* renamed from: a */
    private void m4016a(C1054e eVar, int i, int i2) {
        int i3 = eVar.mo5917i();
        if (i == -1) {
            if (eVar.mo5905b() + i3 > i2) {
                return;
            }
        } else if (eVar.mo5911d() - i3 < i2) {
            return;
        }
        this.f3269m.set(eVar.f3311e, false);
    }

    /* renamed from: a */
    private boolean m4017a(C1054e eVar) {
        if (this.f3261e) {
            if (eVar.mo5911d() < this.f3258b.mo6042d()) {
                return !eVar.mo5908c(eVar.f3307a.get(eVar.f3307a.size() - 1)).f3290b;
            }
        } else if (eVar.mo5905b() > this.f3258b.mo6040c()) {
            return !eVar.mo5908c(eVar.f3307a.get(0)).f3290b;
        }
        return false;
    }

    /* renamed from: b */
    private int m4018b(RecyclerView.C1042u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C1093m.m4323a(uVar, this.f3258b, mo5851b(!this.f3278v), mo5854c(!this.f3278v), this, this.f3278v);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4019b(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.f3261e
            if (r0 == 0) goto L_0x0009
            int r0 = r5.mo5861h()
            goto L_0x000d
        L_0x0009:
            int r0 = r5.mo5862i()
        L_0x000d:
            r1 = 8
            if (r8 != r1) goto L_0x001b
            if (r6 >= r7) goto L_0x0016
            int r2 = r7 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L_0x001f
        L_0x001b:
            int r2 = r6 + r7
        L_0x001d:
            r3 = r2
            r2 = r6
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r4 = r5.f3264h
            r4.mo5876b(r2)
            if (r8 == r1) goto L_0x0036
            switch(r8) {
                case 1: goto L_0x0030;
                case 2: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0041
        L_0x002a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.f3264h
            r8.mo5873a((int) r6, (int) r7)
            goto L_0x0041
        L_0x0030:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.f3264h
            r8.mo5877b(r6, r7)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.f3264h
            r1 = 1
            r8.mo5873a((int) r6, (int) r1)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r6 = r5.f3264h
            r6.mo5877b(r7, r1)
        L_0x0041:
            if (r3 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r6 = r5.f3261e
            if (r6 == 0) goto L_0x004d
            int r6 = r5.mo5862i()
            goto L_0x0051
        L_0x004d:
            int r6 = r5.mo5861h()
        L_0x0051:
            if (r2 > r6) goto L_0x0056
            r5.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4019b(int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4020b(int r5, androidx.recyclerview.widget.RecyclerView.C1042u r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.f r0 = r4.f3268l
            r1 = 0
            r0.f3433b = r1
            r0.f3434c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.mo5794c()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.f3261e
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.j r5 = r4.f3258b
            int r5 = r5.mo6046f()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.j r5 = r4.f3258b
            int r5 = r5.mo6046f()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.f r0 = r4.f3268l
            androidx.recyclerview.widget.j r3 = r4.f3258b
            int r3 = r3.mo6040c()
            int r3 = r3 - r6
            r0.f3437f = r3
            androidx.recyclerview.widget.f r6 = r4.f3268l
            androidx.recyclerview.widget.j r0 = r4.f3258b
            int r0 = r0.mo6042d()
            int r0 = r0 + r5
            r6.f3438g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.f r0 = r4.f3268l
            androidx.recyclerview.widget.j r3 = r4.f3258b
            int r3 = r3.mo6044e()
            int r3 = r3 + r5
            r0.f3438g = r3
            androidx.recyclerview.widget.f r5 = r4.f3268l
            int r6 = -r6
            r5.f3437f = r6
        L_0x005d:
            androidx.recyclerview.widget.f r5 = r4.f3268l
            r5.f3439h = r1
            r5.f3432a = r2
            androidx.recyclerview.widget.j r6 = r4.f3258b
            int r6 = r6.mo6049h()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.j r6 = r4.f3258b
            int r6 = r6.mo6044e()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.f3440i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4020b(int, androidx.recyclerview.widget.RecyclerView$u):void");
    }

    /* renamed from: b */
    private void m4021b(View view) {
        for (int i = this.f3265i - 1; i >= 0; i--) {
            this.f3257a[i].mo5903a(view);
        }
    }

    /* renamed from: b */
    private void m4022b(RecyclerView.C1034p pVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f3258b.mo6035a(childAt) >= i && this.f3258b.mo6043d(childAt) >= i) {
                C1048b bVar = (C1048b) childAt.getLayoutParams();
                if (bVar.f3290b) {
                    int i2 = 0;
                    while (i2 < this.f3265i) {
                        if (this.f3257a[i2].f3307a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f3265i; i3++) {
                        this.f3257a[i3].mo5915g();
                    }
                } else if (bVar.f3289a.f3307a.size() != 1) {
                    bVar.f3289a.mo5915g();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, pVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m4023b(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, boolean z) {
        int d;
        int i = m4032i(Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE && (d = this.f3258b.mo6042d() - i) > 0) {
            int i2 = d - (-mo5844a(-d, pVar, uVar));
            if (z && i2 > 0) {
                this.f3258b.mo6037a(i2);
            }
        }
    }

    /* renamed from: c */
    private int m4024c(RecyclerView.C1042u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C1093m.m4325b(uVar, this.f3258b, mo5851b(!this.f3278v), mo5854c(!this.f3278v), this, this.f3278v);
    }

    /* renamed from: c */
    private void m4025c(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, boolean z) {
        int c;
        int h = m4031h(Integer.MAX_VALUE);
        if (h != Integer.MAX_VALUE && (c = h - this.f3258b.mo6040c()) > 0) {
            int a = c - mo5844a(c, pVar, uVar);
            if (z && a > 0) {
                this.f3258b.mo6037a(-a);
            }
        }
    }

    /* renamed from: c */
    private boolean m4026c(RecyclerView.C1042u uVar, C1047a aVar) {
        aVar.f3282a = this.f3271o ? m4040n(uVar.mo5796e()) : m4039m(uVar.mo5796e());
        aVar.f3283b = Integer.MIN_VALUE;
        return true;
    }

    /* renamed from: d */
    private void m4027d(int i) {
        C1081f fVar = this.f3268l;
        fVar.f3436e = i;
        int i2 = 1;
        if (this.f3261e != (i == -1)) {
            i2 = -1;
        }
        fVar.f3435d = i2;
    }

    /* renamed from: e */
    private C1049c.C1050a m4028e(int i) {
        C1049c.C1050a aVar = new C1049c.C1050a();
        aVar.f3295c = new int[this.f3265i];
        for (int i2 = 0; i2 < this.f3265i; i2++) {
            aVar.f3295c[i2] = i - this.f3257a[i2].mo5906b(i);
        }
        return aVar;
    }

    /* renamed from: f */
    private C1049c.C1050a m4029f(int i) {
        C1049c.C1050a aVar = new C1049c.C1050a();
        aVar.f3295c = new int[this.f3265i];
        for (int i2 = 0; i2 < this.f3265i; i2++) {
            aVar.f3295c[i2] = this.f3257a[i2].mo5898a(i) - i;
        }
        return aVar;
    }

    /* renamed from: g */
    private int m4030g(int i) {
        int a = this.f3257a[0].mo5898a(i);
        for (int i2 = 1; i2 < this.f3265i; i2++) {
            int a2 = this.f3257a[i2].mo5898a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: h */
    private int m4031h(int i) {
        int a = this.f3257a[0].mo5898a(i);
        for (int i2 = 1; i2 < this.f3265i; i2++) {
            int a2 = this.f3257a[i2].mo5898a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: i */
    private int m4032i(int i) {
        int b = this.f3257a[0].mo5906b(i);
        for (int i2 = 1; i2 < this.f3265i; i2++) {
            int b2 = this.f3257a[i2].mo5906b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: j */
    private int m4033j(int i) {
        int b = this.f3257a[0].mo5906b(i);
        for (int i2 = 1; i2 < this.f3265i; i2++) {
            int b2 = this.f3257a[i2].mo5906b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: j */
    private void m4034j() {
        this.f3258b = C1086j.m4264a(this, this.f3266j);
        this.f3259c = C1086j.m4264a(this, 1 - this.f3266j);
    }

    /* renamed from: k */
    private void m4035k() {
        this.f3261e = (this.f3266j == 1 || !mo5857d()) ? this.f3260d : !this.f3260d;
    }

    /* renamed from: k */
    private boolean m4036k(int i) {
        if (this.f3266j == 0) {
            return (i == -1) != this.f3261e;
        }
        return ((i == -1) == this.f3261e) == mo5857d();
    }

    /* renamed from: l */
    private int m4037l(int i) {
        if (getChildCount() == 0) {
            return this.f3261e ? 1 : -1;
        }
        return (i < mo5862i()) != this.f3261e ? -1 : 1;
    }

    /* renamed from: l */
    private void m4038l() {
        int i;
        int i2;
        if (this.f3259c.mo6049h() != 1073741824) {
            int childCount = getChildCount();
            float f = 0.0f;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                float e = (float) this.f3259c.mo6045e(childAt);
                if (e >= f) {
                    if (((C1048b) childAt.getLayoutParams()).mo5868a()) {
                        e = (e * 1.0f) / ((float) this.f3265i);
                    }
                    f = Math.max(f, e);
                }
            }
            int i4 = this.f3267k;
            int round = Math.round(f * ((float) this.f3265i));
            if (this.f3259c.mo6049h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f3259c.mo6046f());
            }
            mo5856c(round);
            if (this.f3267k != i4) {
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt2 = getChildAt(i5);
                    C1048b bVar = (C1048b) childAt2.getLayoutParams();
                    if (!bVar.f3290b) {
                        if (!mo5857d() || this.f3266j != 1) {
                            i = bVar.f3289a.f3311e * this.f3267k;
                            i2 = bVar.f3289a.f3311e * i4;
                            if (this.f3266j != 1) {
                                childAt2.offsetTopAndBottom(i - i2);
                            }
                        } else {
                            i = (-((this.f3265i - 1) - bVar.f3289a.f3311e)) * this.f3267k;
                            i2 = (-((this.f3265i - 1) - bVar.f3289a.f3311e)) * i4;
                        }
                        childAt2.offsetLeftAndRight(i - i2);
                    }
                }
            }
        }
    }

    /* renamed from: m */
    private int m4039m(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: n */
    private int m4040n(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: o */
    private int m4041o(int i) {
        if (i == 17) {
            return this.f3266j == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.f3266j == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.f3266j == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.f3266j == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.f3266j != 1 && mo5857d()) ? 1 : -1;
            case 2:
                return (this.f3266j != 1 && mo5857d()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5844a(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        mo5846a(i, uVar);
        int a = m4004a(pVar, this.f3268l, uVar);
        if (this.f3268l.f3433b >= a) {
            i = i < 0 ? -a : a;
        }
        this.f3258b.mo6037a(-i);
        this.f3271o = this.f3261e;
        C1081f fVar = this.f3268l;
        fVar.f3433b = 0;
        m4014a(pVar, fVar);
        return i;
    }

    /* renamed from: a */
    public void mo5845a(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.f3265i) {
            mo5855c();
            this.f3265i = i;
            this.f3269m = new BitSet(this.f3265i);
            this.f3257a = new C1054e[this.f3265i];
            for (int i2 = 0; i2 < this.f3265i; i2++) {
                this.f3257a[i2] = new C1054e(i2);
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5846a(int i, RecyclerView.C1042u uVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = mo5861h();
            i2 = 1;
        } else {
            i3 = mo5862i();
            i2 = -1;
        }
        this.f3268l.f3432a = true;
        m4020b(i3, uVar);
        m4027d(i2);
        C1081f fVar = this.f3268l;
        fVar.f3434c = i3 + fVar.f3435d;
        this.f3268l.f3433b = Math.abs(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5847a(RecyclerView.C1042u uVar, C1047a aVar) {
        if (!mo5853b(uVar, aVar) && !m4026c(uVar, aVar)) {
            aVar.mo5867b();
            aVar.f3282a = 0;
        }
    }

    /* renamed from: a */
    public void mo5848a(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        C1052d dVar = this.f3273q;
        if (!(dVar == null || dVar.f3304h == z)) {
            this.f3273q.f3304h = z;
        }
        this.f3260d = z;
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5849a() {
        int i;
        int i2;
        if (getChildCount() == 0 || this.f3270n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f3261e) {
            i2 = mo5861h();
            i = mo5862i();
        } else {
            i2 = mo5862i();
            i = mo5861h();
        }
        if (i2 == 0 && mo5850b() != null) {
            this.f3264h.mo5872a();
        } else if (!this.f3277u) {
            return false;
        } else {
            int i3 = this.f3261e ? -1 : 1;
            int i4 = i + 1;
            C1049c.C1050a a = this.f3264h.mo5871a(i2, i4, i3, true);
            if (a == null) {
                this.f3277u = false;
                this.f3264h.mo5870a(i4);
                return false;
            }
            C1049c.C1050a a2 = this.f3264h.mo5871a(i2, a.f3293a, i3 * -1, true);
            if (a2 == null) {
                this.f3264h.mo5870a(a.f3293a);
            } else {
                this.f3264h.mo5870a(a2.f3293a + 1);
            }
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f3273q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo5850b() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3265i
            r2.<init>(r3)
            int r3 = r12.f3265i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f3266j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.mo5857d()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f3261e
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1048b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f3289a
            int r9 = r9.f3311e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f3289a
            boolean r9 = r12.m4017a((androidx.recyclerview.widget.StaggeredGridLayoutManager.C1054e) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f3289a
            int r9 = r9.f3311e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f3290b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f3261e
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.j r10 = r12.f3258b
            int r10 = r10.mo6039b((android.view.View) r7)
            androidx.recyclerview.widget.j r11 = r12.f3258b
            int r11 = r11.mo6039b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.j r10 = r12.f3258b
            int r10 = r10.mo6035a((android.view.View) r7)
            androidx.recyclerview.widget.j r11 = r12.f3258b
            int r11 = r11.mo6035a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1048b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r8 = r8.f3289a
            int r8 = r8.f3311e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r9.f3289a
            int r9 = r9.f3311e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.mo5850b():android.view.View");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5851b(boolean z) {
        int c = this.f3258b.mo6040c();
        int d = this.f3258b.mo6042d();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int a = this.f3258b.mo6035a(childAt);
            if (this.f3258b.mo6039b(childAt) > c && a < d) {
                if (a >= c || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: b */
    public void mo5852b(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.f3266j) {
                this.f3266j = i;
                C1086j jVar = this.f3258b;
                this.f3258b = this.f3259c;
                this.f3259c = jVar;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5853b(RecyclerView.C1042u uVar, C1047a aVar) {
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (!uVar.mo5792a() && (i = this.f3262f) != -1) {
            if (i < 0 || i >= uVar.mo5796e()) {
                this.f3262f = -1;
                this.f3263g = Integer.MIN_VALUE;
            } else {
                C1052d dVar = this.f3273q;
                if (dVar == null || dVar.f3297a == -1 || this.f3273q.f3299c < 1) {
                    View findViewByPosition = findViewByPosition(this.f3262f);
                    if (findViewByPosition != null) {
                        aVar.f3282a = this.f3261e ? mo5861h() : mo5862i();
                        if (this.f3263g != Integer.MIN_VALUE) {
                            if (aVar.f3284c) {
                                i3 = this.f3258b.mo6042d() - this.f3263g;
                                i2 = this.f3258b.mo6039b(findViewByPosition);
                            } else {
                                i3 = this.f3258b.mo6040c() + this.f3263g;
                                i2 = this.f3258b.mo6035a(findViewByPosition);
                            }
                            aVar.f3283b = i3 - i2;
                            return true;
                        } else if (this.f3258b.mo6045e(findViewByPosition) > this.f3258b.mo6046f()) {
                            aVar.f3283b = aVar.f3284c ? this.f3258b.mo6042d() : this.f3258b.mo6040c();
                            return true;
                        } else {
                            int a = this.f3258b.mo6035a(findViewByPosition) - this.f3258b.mo6040c();
                            if (a < 0) {
                                aVar.f3283b = -a;
                                return true;
                            }
                            int d = this.f3258b.mo6042d() - this.f3258b.mo6039b(findViewByPosition);
                            if (d < 0) {
                                aVar.f3283b = d;
                                return true;
                            }
                            aVar.f3283b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f3282a = this.f3262f;
                        int i4 = this.f3263g;
                        if (i4 == Integer.MIN_VALUE) {
                            if (m4037l(aVar.f3282a) == 1) {
                                z = true;
                            }
                            aVar.f3284c = z;
                            aVar.mo5867b();
                        } else {
                            aVar.mo5865a(i4);
                        }
                        aVar.f3285d = true;
                    }
                } else {
                    aVar.f3283b = Integer.MIN_VALUE;
                    aVar.f3282a = this.f3262f;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo5854c(boolean z) {
        int c = this.f3258b.mo6040c();
        int d = this.f3258b.mo6042d();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int a = this.f3258b.mo6035a(childAt);
            int b = this.f3258b.mo6039b(childAt);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: c */
    public void mo5855c() {
        this.f3264h.mo5872a();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5856c(int i) {
        this.f3267k = i / this.f3265i;
        this.f3274r = View.MeasureSpec.makeMeasureSpec(i, this.f3259c.mo6049h());
    }

    public boolean canScrollHorizontally() {
        return this.f3266j == 0;
    }

    public boolean canScrollVertically() {
        return this.f3266j == 1;
    }

    public boolean checkLayoutParams(RecyclerView.C1027j jVar) {
        return jVar instanceof C1048b;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.C1042u uVar, RecyclerView.C1022i.C1025a aVar) {
        int i3;
        int i4;
        if (this.f3266j != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            mo5846a(i, uVar);
            int[] iArr = this.f3279w;
            if (iArr == null || iArr.length < this.f3265i) {
                this.f3279w = new int[this.f3265i];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f3265i; i6++) {
                if (this.f3268l.f3435d == -1) {
                    i4 = this.f3268l.f3437f;
                    i3 = this.f3257a[i6].mo5898a(this.f3268l.f3437f);
                } else {
                    i4 = this.f3257a[i6].mo5906b(this.f3268l.f3438g);
                    i3 = this.f3268l.f3438g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.f3279w[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.f3279w, 0, i5);
            for (int i8 = 0; i8 < i5 && this.f3268l.mo6018a(uVar); i8++) {
                aVar.mo5699b(this.f3268l.f3434c, this.f3279w[i8]);
                this.f3268l.f3434c += this.f3268l.f3435d;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.C1042u uVar) {
        return m4018b(uVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.C1042u uVar) {
        return m4005a(uVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.C1042u uVar) {
        return m4024c(uVar);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int l = m4037l(i);
        PointF pointF = new PointF();
        if (l == 0) {
            return null;
        }
        if (this.f3266j == 0) {
            pointF.x = (float) l;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) l;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.C1042u uVar) {
        return m4018b(uVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.C1042u uVar) {
        return m4005a(uVar);
    }

    public int computeVerticalScrollRange(RecyclerView.C1042u uVar) {
        return m4024c(uVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5857d() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo5858e() {
        View c = this.f3261e ? mo5854c(true) : mo5851b(true);
        if (c == null) {
            return -1;
        }
        return getPosition(c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo5859f() {
        int b = this.f3257a[0].mo5906b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3265i; i++) {
            if (this.f3257a[i].mo5906b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo5860g() {
        int a = this.f3257a[0].mo5898a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3265i; i++) {
            if (this.f3257a[i].mo5898a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    public RecyclerView.C1027j generateDefaultLayoutParams() {
        return this.f3266j == 0 ? new C1048b(-2, -1) : new C1048b(-1, -2);
    }

    public RecyclerView.C1027j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C1048b(context, attributeSet);
    }

    public RecyclerView.C1027j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C1048b((ViewGroup.MarginLayoutParams) layoutParams) : new C1048b(layoutParams);
    }

    public int getColumnCountForAccessibility(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return this.f3266j == 1 ? this.f3265i : super.getColumnCountForAccessibility(pVar, uVar);
    }

    public int getRowCountForAccessibility(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return this.f3266j == 0 ? this.f3265i : super.getRowCountForAccessibility(pVar, uVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo5861h() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5862i() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public boolean isAutoMeasureEnabled() {
        return this.f3270n != 0;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f3265i; i2++) {
            this.f3257a[i2].mo5912d(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f3265i; i2++) {
            this.f3257a[i2].mo5912d(i);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C1034p pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        removeCallbacks(this.f3280x);
        for (int i = 0; i < this.f3265i; i++) {
            this.f3257a[i].mo5913e();
        }
        recyclerView.requestLayout();
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        View findContainingItemView;
        View a;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        m4035k();
        int o = m4041o(i);
        if (o == Integer.MIN_VALUE) {
            return null;
        }
        C1048b bVar = (C1048b) findContainingItemView.getLayoutParams();
        boolean z = bVar.f3290b;
        C1054e eVar = bVar.f3289a;
        int h = o == 1 ? mo5861h() : mo5862i();
        m4020b(h, uVar);
        m4027d(o);
        C1081f fVar = this.f3268l;
        fVar.f3434c = fVar.f3435d + h;
        this.f3268l.f3433b = (int) (((float) this.f3258b.mo6046f()) * 0.33333334f);
        C1081f fVar2 = this.f3268l;
        fVar2.f3439h = true;
        fVar2.f3432a = false;
        m4004a(pVar, fVar2, uVar);
        this.f3271o = this.f3261e;
        if (!z && (a = eVar.mo5901a(h, o)) != null && a != findContainingItemView) {
            return a;
        }
        if (m4036k(o)) {
            for (int i2 = this.f3265i - 1; i2 >= 0; i2--) {
                View a2 = this.f3257a[i2].mo5901a(h, o);
                if (a2 != null && a2 != findContainingItemView) {
                    return a2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f3265i; i3++) {
                View a3 = this.f3257a[i3].mo5901a(h, o);
                if (a3 != null && a3 != findContainingItemView) {
                    return a3;
                }
            }
        }
        boolean z2 = (this.f3260d ^ true) == (o == -1);
        if (!z) {
            View findViewByPosition = findViewByPosition(z2 ? eVar.mo5918j() : eVar.mo5919k());
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (m4036k(o)) {
            for (int i4 = this.f3265i - 1; i4 >= 0; i4--) {
                if (i4 != eVar.f3311e) {
                    View findViewByPosition2 = findViewByPosition(z2 ? this.f3257a[i4].mo5918j() : this.f3257a[i4].mo5919k());
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f3265i; i5++) {
                View findViewByPosition3 = findViewByPosition(z2 ? this.f3257a[i5].mo5918j() : this.f3257a[i5].mo5919k());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b = mo5851b(false);
            View c = mo5854c(false);
            if (b != null && c != null) {
                int position = getPosition(b);
                int position2 = getPosition(c);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, View view, C0614c cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C1048b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        C1048b bVar = (C1048b) layoutParams;
        if (this.f3266j == 0) {
            i4 = bVar.mo5869b();
            i3 = bVar.f3290b ? this.f3265i : 1;
            i2 = -1;
            i = -1;
        } else {
            i4 = -1;
            i3 = -1;
            i2 = bVar.mo5869b();
            i = bVar.f3290b ? this.f3265i : 1;
        }
        cVar.mo3717b((Object) C0614c.C0617c.m2482a(i4, i3, i2, i, false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m4019b(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3264h.mo5872a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m4019b(i, i2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m4019b(i, i2, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m4019b(i, i2, 4);
    }

    public void onLayoutChildren(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        m4013a(pVar, uVar, true);
    }

    public void onLayoutCompleted(RecyclerView.C1042u uVar) {
        super.onLayoutCompleted(uVar);
        this.f3262f = -1;
        this.f3263g = Integer.MIN_VALUE;
        this.f3273q = null;
        this.f3276t.mo5864a();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1052d) {
            this.f3273q = (C1052d) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i;
        int i2;
        C1052d dVar = this.f3273q;
        if (dVar != null) {
            return new C1052d(dVar);
        }
        C1052d dVar2 = new C1052d();
        dVar2.f3304h = this.f3260d;
        dVar2.f3305i = this.f3271o;
        dVar2.f3306j = this.f3272p;
        C1049c cVar = this.f3264h;
        if (cVar == null || cVar.f3291a == null) {
            dVar2.f3301e = 0;
        } else {
            dVar2.f3302f = this.f3264h.f3291a;
            dVar2.f3301e = dVar2.f3302f.length;
            dVar2.f3303g = this.f3264h.f3292b;
        }
        if (getChildCount() > 0) {
            dVar2.f3297a = this.f3271o ? mo5861h() : mo5862i();
            dVar2.f3298b = mo5858e();
            int i3 = this.f3265i;
            dVar2.f3299c = i3;
            dVar2.f3300d = new int[i3];
            for (int i4 = 0; i4 < this.f3265i; i4++) {
                if (this.f3271o) {
                    i = this.f3257a[i4].mo5906b(Integer.MIN_VALUE);
                    if (i != Integer.MIN_VALUE) {
                        i2 = this.f3258b.mo6042d();
                    } else {
                        dVar2.f3300d[i4] = i;
                    }
                } else {
                    i = this.f3257a[i4].mo5898a(Integer.MIN_VALUE);
                    if (i != Integer.MIN_VALUE) {
                        i2 = this.f3258b.mo6040c();
                    } else {
                        dVar2.f3300d[i4] = i;
                    }
                }
                i -= i2;
                dVar2.f3300d[i4] = i;
            }
        } else {
            dVar2.f3297a = -1;
            dVar2.f3298b = -1;
            dVar2.f3299c = 0;
        }
        return dVar2;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            mo5849a();
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return mo5844a(i, pVar, uVar);
    }

    public void scrollToPosition(int i) {
        C1052d dVar = this.f3273q;
        if (!(dVar == null || dVar.f3297a == i)) {
            this.f3273q.mo5891b();
        }
        this.f3262f = i;
        this.f3263g = Integer.MIN_VALUE;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return mo5844a(i, pVar, uVar);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3266j == 1) {
            i4 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i3 = chooseSize(i, (this.f3267k * this.f3265i) + paddingLeft, getMinimumWidth());
        } else {
            i3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            i4 = chooseSize(i2, (this.f3267k * this.f3265i) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C1042u uVar, int i) {
        C1082g gVar = new C1082g(recyclerView.getContext());
        gVar.setTargetPosition(i);
        startSmoothScroll(gVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f3273q == null;
    }
}
