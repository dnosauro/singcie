package com.github.appintro.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.p053l.p054a.C0922b;
import com.github.appintro.AppIntroBase;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.AppIntroViewPagerListener;
import com.github.appintro.internal.viewpager.ViewPagerTransformer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;

public final class AppIntroViewPager extends C0922b {
    @Deprecated
    public static final Companion Companion = new Companion((C3247e) null);
    private static final int ON_ILLEGALLY_REQUESTED_NEXT_PAGE_MAX_INTERVAL = 1000;
    private static final int VALID_SWIPE_THRESHOLD_PX_X = 25;
    private static final int VALID_SWIPE_THRESHOLD_PX_Y = 25;
    private float currentTouchDownX;
    private float currentTouchDownY;
    private ScrollerCustomDuration customScroller;
    private long illegallyRequestedNextPageLastCalled;
    private boolean isFullPagingEnabled = true;
    private boolean isNextPagingEnabled = true;
    private boolean isPermissionSlide;
    private int lockPage;
    @Nullable
    private AppIntroViewPagerListener onNextPageRequestedListener;
    private C0922b.C0932f pageChangeListener;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C3247e eVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppIntroViewPager(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        C3250h.m9056b(context, "context");
        C3250h.m9056b(attributeSet, "attrs");
        try {
            Field declaredField = C0922b.class.getDeclaredField("mScroller");
            C3250h.m9053a((Object) declaredField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
            declaredField.setAccessible(true);
            Field declaredField2 = C0922b.class.getDeclaredField("sInterpolator");
            C3250h.m9053a((Object) declaredField2, "ViewPager::class.java.ge…redField(\"sInterpolator\")");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get((Object) null);
            if (obj != null) {
                this.customScroller = new ScrollerCustomDuration(context, (Interpolator) obj);
                declaredField.set(this, this.customScroller);
                return;
            }
            throw new C3266f("null cannot be cast to non-null type android.view.animation.Interpolator");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private final boolean handleTouchEvent(MotionEvent motionEvent) {
        AppIntroViewPagerListener appIntroViewPagerListener;
        AppIntroViewPagerListener appIntroViewPagerListener2;
        if (!this.isFullPagingEnabled) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            boolean z = true;
            if (motionEvent.getAction() == 1) {
                performClick();
            }
            AppIntroViewPagerListener appIntroViewPagerListener3 = this.onNextPageRequestedListener;
            if (appIntroViewPagerListener3 != null) {
                z = appIntroViewPagerListener3.onCanRequestNextPage();
            }
            if (!z) {
                if (userIllegallyRequestNextPage(motionEvent) && (appIntroViewPagerListener2 = this.onNextPageRequestedListener) != null) {
                    appIntroViewPagerListener2.onIllegallyRequestedNextPage();
                }
                return false;
            } else if (this.isPermissionSlide && isSwipeForward(this.currentTouchDownX, motionEvent.getX()) && (appIntroViewPagerListener = this.onNextPageRequestedListener) != null) {
                appIntroViewPagerListener.onUserRequestedPermissionsDialog();
            }
        } else {
            this.currentTouchDownX = motionEvent.getX();
            this.currentTouchDownY = motionEvent.getY();
        }
        return this.isFullPagingEnabled;
    }

    private final boolean isASwipeGesture(MotionEvent motionEvent, float f, float f2) {
        float f3 = (float) 25;
        return Math.abs(motionEvent.getX() - f) >= f3 && Math.abs(motionEvent.getY() - f2) <= f3;
    }

    private final boolean isSwipeForward(float f, float f2) {
        Context context = getContext();
        C3250h.m9053a((Object) context, "context");
        if (LayoutUtil.isRtl(context)) {
            if (f2 > f) {
                return true;
            }
        } else if (f > f2) {
            return true;
        }
        return false;
    }

    private final boolean userIllegallyRequestNextPage(MotionEvent motionEvent) {
        if (!isASwipeGesture(motionEvent, this.currentTouchDownX, this.currentTouchDownY) || System.currentTimeMillis() - this.illegallyRequestedNextPageLastCalled < ((long) 1000)) {
            return false;
        }
        this.illegallyRequestedNextPageLastCalled = System.currentTimeMillis();
        return true;
    }

    public final void addOnPageChangeListener$appintro_release(@NotNull AppIntroBase.OnPageChangeListener onPageChangeListener) {
        C3250h.m9056b(onPageChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        C0922b.C0932f fVar = onPageChangeListener;
        super.addOnPageChangeListener(fVar);
        this.pageChangeListener = fVar;
    }

    public final int getCurrentSlideNumber(int i) {
        Context context = getContext();
        C3250h.m9053a((Object) context, "context");
        return LayoutUtil.isRtl(context) ? i - getCurrentItem() : getCurrentItem() + 1;
    }

    public final int getLockPage() {
        return this.lockPage;
    }

    @Nullable
    public final AppIntroViewPagerListener getOnNextPageRequestedListener() {
        return this.onNextPageRequestedListener;
    }

    public final void goToNextSlide() {
        int currentItem = getCurrentItem();
        Context context = getContext();
        C3250h.m9053a((Object) context, "context");
        setCurrentItem(currentItem + (!LayoutUtil.isRtl(context) ? 1 : -1));
    }

    public final void goToPreviousSlide() {
        int currentItem = getCurrentItem();
        Context context = getContext();
        C3250h.m9053a((Object) context, "context");
        setCurrentItem(currentItem + (!LayoutUtil.isRtl(context) ? -1 : 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0020 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isFirstSlide(int r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "context"
            p157d.p161d.p163b.C3250h.m9053a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = com.github.appintro.internal.LayoutUtil.isRtl(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            int r0 = r3.getCurrentItem()
            int r0 = r0 - r4
            int r0 = r0 + r2
            if (r0 != 0) goto L_0x0021
            goto L_0x0020
        L_0x001a:
            int r4 = r3.getCurrentItem()
            if (r4 != 0) goto L_0x0021
        L_0x0020:
            r1 = 1
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.appintro.internal.AppIntroViewPager.isFirstSlide(int):boolean");
    }

    public final boolean isFullPagingEnabled() {
        return this.isFullPagingEnabled;
    }

    public final boolean isNextPagingEnabled() {
        return this.isNextPagingEnabled;
    }

    public final boolean isPermissionSlide() {
        return this.isPermissionSlide;
    }

    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        C3250h.m9056b(motionEvent, "event");
        if (!handleTouchEvent(motionEvent)) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        C3250h.m9056b(motionEvent, "event");
        if (!handleTouchEvent(motionEvent)) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        return super.performClick();
    }

    public final void reCenterCurrentSlide$appintro_release() {
        int currentItem = getCurrentItem();
        setCurrentItem(Math.max(currentItem - 1, 0), false);
        setCurrentItem(currentItem, false);
    }

    public final void setAppIntroPageTransformer(@NotNull AppIntroPageTransformerType appIntroPageTransformerType) {
        C3250h.m9056b(appIntroPageTransformerType, "appIntroTransformer");
        setPageTransformer(true, new ViewPagerTransformer(appIntroPageTransformerType));
    }

    public void setCurrentItem(int i) {
        C0922b.C0932f fVar;
        int currentItem = super.getCurrentItem();
        super.setCurrentItem(i);
        if (currentItem == 0 && i == 0 && (fVar = this.pageChangeListener) != null) {
            fVar.onPageSelected(0);
        }
    }

    public final void setFullPagingEnabled(boolean z) {
        this.isFullPagingEnabled = z;
    }

    public final void setLockPage(int i) {
        this.lockPage = i;
    }

    public final void setNextPagingEnabled(boolean z) {
        this.isNextPagingEnabled = z;
        if (!z) {
            this.lockPage = getCurrentItem();
        }
    }

    public final void setOnNextPageRequestedListener(@Nullable AppIntroViewPagerListener appIntroViewPagerListener) {
        this.onNextPageRequestedListener = appIntroViewPagerListener;
    }

    public final void setPermissionSlide(boolean z) {
        this.isPermissionSlide = z;
    }

    public final void setScrollDurationFactor(double d) {
        ScrollerCustomDuration scrollerCustomDuration = this.customScroller;
        if (scrollerCustomDuration != null) {
            scrollerCustomDuration.setScrollDurationFactor(d);
        }
    }
}
