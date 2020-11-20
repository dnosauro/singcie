package androidx.p049j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p030h.C0656u;
import java.util.Map;

/* renamed from: androidx.j.c */
public class C0845c extends C0874n {

    /* renamed from: a */
    private static final String[] f2816a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b */
    private static final Property<Drawable, PointF> f2817b = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {

        /* renamed from: a */
        private Rect f2827a = new Rect();

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2827a);
            return new PointF((float) this.f2827a.left, (float) this.f2827a.top);
        }

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2827a);
            this.f2827a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2827a);
        }
    };

    /* renamed from: c */
    private static final Property<C0856a, PointF> f2818c = new Property<C0856a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(C0856a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(C0856a aVar, PointF pointF) {
            aVar.mo4734a(pointF);
        }
    };

    /* renamed from: d */
    private static final Property<C0856a, PointF> f2819d = new Property<C0856a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(C0856a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(C0856a aVar, PointF pointF) {
            aVar.mo4735b(pointF);
        }
    };

    /* renamed from: e */
    private static final Property<View, PointF> f2820e = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            C0828ad.m3417a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };

    /* renamed from: f */
    private static final Property<View, PointF> f2821f = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            C0828ad.m3417a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };

    /* renamed from: g */
    private static final Property<View, PointF> f2822g = new Property<View, PointF>(PointF.class, "position") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            C0828ad.m3417a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };

    /* renamed from: k */
    private static C0871k f2823k = new C0871k();

    /* renamed from: h */
    private int[] f2824h = new int[2];

    /* renamed from: i */
    private boolean f2825i = false;

    /* renamed from: j */
    private boolean f2826j = false;

    /* renamed from: androidx.j.c$a */
    private static class C0856a {

        /* renamed from: a */
        private int f2846a;

        /* renamed from: b */
        private int f2847b;

        /* renamed from: c */
        private int f2848c;

        /* renamed from: d */
        private int f2849d;

        /* renamed from: e */
        private View f2850e;

        /* renamed from: f */
        private int f2851f;

        /* renamed from: g */
        private int f2852g;

        C0856a(View view) {
            this.f2850e = view;
        }

        /* renamed from: a */
        private void m3487a() {
            C0828ad.m3417a(this.f2850e, this.f2846a, this.f2847b, this.f2848c, this.f2849d);
            this.f2851f = 0;
            this.f2852g = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4734a(PointF pointF) {
            this.f2846a = Math.round(pointF.x);
            this.f2847b = Math.round(pointF.y);
            this.f2851f++;
            if (this.f2851f == this.f2852g) {
                m3487a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo4735b(PointF pointF) {
            this.f2848c = Math.round(pointF.x);
            this.f2849d = Math.round(pointF.y);
            this.f2852g++;
            if (this.f2851f == this.f2852g) {
                m3487a();
            }
        }
    }

    /* renamed from: a */
    private void m3469a(C0891t tVar) {
        View view = tVar.f2918b;
        if (C0656u.m2642y(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            tVar.f2917a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            tVar.f2917a.put("android:changeBounds:parent", tVar.f2918b.getParent());
            if (this.f2826j) {
                tVar.f2918b.getLocationInWindow(this.f2824h);
                tVar.f2917a.put("android:changeBounds:windowX", Integer.valueOf(this.f2824h[0]));
                tVar.f2917a.put("android:changeBounds:windowY", Integer.valueOf(this.f2824h[1]));
            }
            if (this.f2825i) {
                tVar.f2917a.put("android:changeBounds:clip", C0656u.m2568A(view));
            }
        }
    }

    /* renamed from: a */
    private boolean m3470a(View view, View view2) {
        if (!this.f2826j) {
            return true;
        }
        C0891t matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f2918b) {
            return true;
        }
        return false;
    }

    public void captureEndValues(C0891t tVar) {
        m3469a(tVar);
    }

    public void captureStartValues(C0891t tVar) {
        m3469a(tVar);
    }

    public Animator createAnimator(ViewGroup viewGroup, C0891t tVar, C0891t tVar2) {
        int i;
        View view;
        Animator animator;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Property<View, PointF> property;
        Path path;
        C0891t tVar3 = tVar;
        C0891t tVar4 = tVar2;
        if (tVar3 == null || tVar4 == null) {
            return null;
        }
        Map<String, Object> map = tVar3.f2917a;
        Map<String, Object> map2 = tVar4.f2917a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = tVar4.f2918b;
        if (m3470a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) tVar3.f2917a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) tVar4.f2917a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            View view3 = view2;
            Rect rect4 = (Rect) tVar3.f2917a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) tVar4.f2917a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.f2825i) {
                view = view3;
                C0828ad.m3417a(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        path = getPathMotion().mo4739a((float) i3, (float) i5, (float) i4, (float) i6);
                        property = f2822g;
                    } else {
                        final C0856a aVar = new C0856a(view);
                        ObjectAnimator a = C0865f.m3521a(aVar, f2818c, getPathMotion().mo4739a((float) i3, (float) i5, (float) i4, (float) i6));
                        ObjectAnimator a2 = C0865f.m3521a(aVar, f2819d, getPathMotion().mo4739a((float) i7, (float) i9, (float) i8, (float) i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a, a2});
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            private C0856a mViewBounds = aVar;
                        });
                        animator = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    path = getPathMotion().mo4739a((float) i7, (float) i9, (float) i8, (float) i10);
                    property = f2820e;
                } else {
                    path = getPathMotion().mo4739a((float) i3, (float) i5, (float) i4, (float) i6);
                    property = f2821f;
                }
                animator = C0865f.m3521a(view, property, path);
            } else {
                view = view3;
                C0828ad.m3417a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator a3 = (i3 == i4 && i5 == i6) ? null : C0865f.m3521a(view, f2822g, getPathMotion().mo4739a((float) i3, (float) i5, (float) i4, (float) i6));
                if (rect7 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i2, i2, i13, i14) : rect6;
                if (!rect.equals(rect8)) {
                    C0656u.m2589a(view, rect);
                    C0871k kVar = f2823k;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect8;
                    objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i15 = i4;
                    final int i16 = i6;
                    final int i17 = i8;
                    final int i18 = i10;
                    objectAnimator.addListener(new AnimatorListenerAdapter() {

                        /* renamed from: h */
                        private boolean f2845h;

                        public void onAnimationCancel(Animator animator) {
                            this.f2845h = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.f2845h) {
                                C0656u.m2589a(view4, rect9);
                                C0828ad.m3417a(view4, i15, i16, i17, i18);
                            }
                        }
                    });
                } else {
                    objectAnimator = null;
                }
                animator = C0890s.m3576a(a3, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                C0896y.m3589a(viewGroup4, true);
                addListener(new C0882o() {

                    /* renamed from: a */
                    boolean f2828a = false;

                    /* renamed from: a */
                    public void mo4697a(C0874n nVar) {
                        C0896y.m3589a(viewGroup4, false);
                        this.f2828a = true;
                    }

                    /* renamed from: b */
                    public void mo4694b(C0874n nVar) {
                        if (!this.f2828a) {
                            C0896y.m3589a(viewGroup4, false);
                        }
                        nVar.removeListener(this);
                    }

                    /* renamed from: c */
                    public void mo4695c(C0874n nVar) {
                        C0896y.m3589a(viewGroup4, false);
                    }

                    /* renamed from: d */
                    public void mo4696d(C0874n nVar) {
                        C0896y.m3589a(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) tVar3.f2917a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) tVar3.f2917a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) tVar4.f2917a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) tVar4.f2917a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f2824h);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c = C0828ad.m3421c(view2);
        C0828ad.m3415a(view2, 0.0f);
        C0828ad.m3414a(viewGroup).mo4656a(bitmapDrawable);
        C0866g pathMotion = getPathMotion();
        int[] iArr = this.f2824h;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{C0868i.m3525a(f2817b, pathMotion.mo4739a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f = c;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                C0828ad.m3414a(viewGroup5).mo4657b(bitmapDrawable2);
                C0828ad.m3415a(view5, f);
            }
        });
        return ofPropertyValuesHolder;
    }

    public String[] getTransitionProperties() {
        return f2816a;
    }
}
