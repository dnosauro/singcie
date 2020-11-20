package com.github.appintro;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import androidx.appcompat.app.C0094d;
import androidx.appcompat.app.C0096f;
import androidx.appcompat.widget.C0307ba;
import androidx.core.app.C0490a;
import androidx.core.content.C0529a;
import androidx.fragment.app.C0735d;
import androidx.fragment.app.C0750j;
import androidx.p053l.p054a.C0922b;
import com.github.appintro.indicator.DotIndicatorController;
import com.github.appintro.indicator.IndicatorController;
import com.github.appintro.indicator.ProgressIndicatorController;
import com.github.appintro.internal.AppIntroViewPager;
import com.github.appintro.internal.LayoutUtil;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.PermissionWrapper;
import com.github.appintro.internal.viewpager.PagerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3216d;
import p157d.C3257e;
import p157d.C3266f;
import p157d.p158a.C3191g;
import p157d.p161d.p163b.C3250h;

public abstract class AppIntroBase extends C0094d implements AppIntroViewPagerListener {
    private static final String ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED = "colorTransitionEnabled";
    private static final String ARG_BUNDLE_CURRENT_ITEM = "currentItem";
    private static final String ARG_BUNDLE_IS_BUTTON_ENABLED = "isButtonsEnabled";
    private static final String ARG_BUNDLE_IS_FULL_PAGING_ENABLED = "isFullPagingEnabled";
    private static final String ARG_BUNDLE_IS_INDICATOR_ENABLED = "isIndicatorEnabled";
    private static final String ARG_BUNDLE_IS_NEXT_PAGING_ENABLED = "isNextPagingEnabled";
    private static final String ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED = "isSkipButtonsEnabled";
    private static final String ARG_BUNDLE_LOCK_PAGE = "lockPage";
    private static final String ARG_BUNDLE_PERMISSION_MAP = "permissionMap";
    private static final String ARG_BUNDLE_RETAIN_IS_BUTTON_ENABLED = "retainIsButtonEnabled";
    private static final String ARG_BUNDLE_SLIDES_NUMBER = "slidesNumber";
    @Deprecated
    public static final Companion Companion = new Companion((C3247e) null);
    private static final int DEFAULT_SCROLL_DURATION_FACTOR = 1;
    private static final long DEFAULT_VIBRATE_DURATION = 20;
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    private static final String TAG = LogHelper.makeLogTag((Class<?>) AppIntroBase.class);
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private View backButton;
    /* access modifiers changed from: private */
    public int currentlySelectedItem = -1;
    private View doneButton;
    private final List<C0735d> fragments = new ArrayList();
    private ViewGroup indicatorContainer;
    @Nullable
    private IndicatorController indicatorController;
    private boolean isButtonsEnabled = true;
    private boolean isColorTransitionsEnabled;
    private boolean isIndicatorEnabled = true;
    private boolean isSkipButtonEnabled = true;
    private boolean isSystemBackButtonLocked;
    private boolean isVibrate;
    private boolean isWizardMode;
    private View nextButton;
    /* access modifiers changed from: private */
    public AppIntroViewPager pager;
    /* access modifiers changed from: private */
    public PagerAdapter pagerAdapter;
    private HashMap<Integer, PermissionWrapper> permissionsMap = new HashMap<>();
    /* access modifiers changed from: private */
    public boolean retainIsButtonEnabled = true;
    private int savedCurrentItem;
    private View skipButton;
    /* access modifiers changed from: private */
    public int slidesNumber;
    private long vibrateDuration = DEFAULT_VIBRATE_DURATION;
    private Vibrator vibrator;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C3247e eVar) {
            this();
        }
    }

    private final class NextSlideOnClickListener implements View.OnClickListener {
        private boolean isLastSlide;

        public NextSlideOnClickListener(boolean z) {
            this.isLastSlide = z;
        }

        public final boolean isLastSlide() {
            return this.isLastSlide;
        }

        public void onClick(@NotNull View view) {
            C3250h.m9056b(view, "view");
            AppIntroBase.this.dispatchVibration();
            if (!AppIntroBase.this.onCanRequestNextPage()) {
                AppIntroBase.this.onIllegallyRequestedNextPage();
            } else if (AppIntroBase.this.shouldRequestPermission()) {
                AppIntroBase.this.requestPermissions();
            } else {
                C0735d item = AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem());
                if (this.isLastSlide) {
                    AppIntroBase.this.onDonePressed(item);
                } else {
                    AppIntroBase.this.onNextPressed(item);
                }
                AppIntroBase.this.goToNextSlide(this.isLastSlide);
            }
        }

        public final void setLastSlide(boolean z) {
            this.isLastSlide = z;
        }
    }

    public final class OnPageChangeListener implements C0922b.C0932f {
        public OnPageChangeListener() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (AppIntroBase.this.isColorTransitionsEnabled() && i < AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getCount() - 1) {
                AppIntroBase.this.performColorTransition(AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(i), AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(i + 1), f);
            }
        }

        public void onPageSelected(int i) {
            C0735d dVar;
            C0735d dVar2;
            AppIntroBase appIntroBase;
            IndicatorController indicatorController;
            if (AppIntroBase.this.slidesNumber >= 1 && (indicatorController = AppIntroBase.this.getIndicatorController()) != null) {
                indicatorController.selectPosition(i);
            }
            if (!AppIntroBase.access$getPager$p(AppIntroBase.this).isNextPagingEnabled() && AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem() != AppIntroBase.access$getPager$p(AppIntroBase.this).getLockPage()) {
                AppIntroBase appIntroBase2 = AppIntroBase.this;
                appIntroBase2.setButtonsEnabled(appIntroBase2.retainIsButtonEnabled);
                AppIntroBase.access$getPager$p(AppIntroBase.this).setNextPagingEnabled(true);
            }
            AppIntroBase.this.updateButtonsVisibility();
            AppIntroBase.this.setPermissionSlide();
            AppIntroBase.this.onPageSelected(i);
            if (AppIntroBase.this.slidesNumber > 0) {
                if (AppIntroBase.this.currentlySelectedItem == -1) {
                    appIntroBase = AppIntroBase.this;
                    dVar2 = null;
                    dVar = AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(i);
                } else {
                    appIntroBase = AppIntroBase.this;
                    dVar2 = AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.this.currentlySelectedItem);
                    dVar = AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem());
                }
                appIntroBase.dispatchSlideChangedCallbacks(dVar2, dVar);
            }
            AppIntroBase.this.currentlySelectedItem = i;
        }
    }

    public static final /* synthetic */ AppIntroViewPager access$getPager$p(AppIntroBase appIntroBase) {
        AppIntroViewPager appIntroViewPager = appIntroBase.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        return appIntroViewPager;
    }

    public static final /* synthetic */ PagerAdapter access$getPagerAdapter$p(AppIntroBase appIntroBase) {
        PagerAdapter pagerAdapter2 = appIntroBase.pagerAdapter;
        if (pagerAdapter2 == null) {
            C3250h.m9057b("pagerAdapter");
        }
        return pagerAdapter2;
    }

    public static /* synthetic */ void askForPermissions$default(AppIntroBase appIntroBase, String[] strArr, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = true;
            }
            appIntroBase.askForPermissions(strArr, i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: askForPermissions");
    }

    /* access modifiers changed from: private */
    public final void dispatchSlideChangedCallbacks(C0735d dVar, C0735d dVar2) {
        if (dVar instanceof SlideSelectionListener) {
            ((SlideSelectionListener) dVar).onSlideDeselected();
        }
        if (dVar2 instanceof SlideSelectionListener) {
            ((SlideSelectionListener) dVar2).onSlideSelected();
        }
        onSlideChanged(dVar, dVar2);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final void dispatchVibration() {
        if (this.isVibrate) {
            Vibrator vibrator2 = this.vibrator;
            if (vibrator2 == null) {
                C3250h.m9057b("vibrator");
            }
            vibrator2.vibrate(this.vibrateDuration);
        }
    }

    private final int getCurrentSlideNumber() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        return appIntroViewPager.getCurrentSlideNumber(this.fragments.size());
    }

    public static /* synthetic */ void goToNextSlide$default(AppIntroBase appIntroBase, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                AppIntroViewPager appIntroViewPager = appIntroBase.pager;
                if (appIntroViewPager == null) {
                    C3250h.m9057b("pager");
                }
                z = appIntroViewPager.getCurrentItem() + 1 == appIntroBase.slidesNumber;
            }
            appIntroBase.goToNextSlide(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToNextSlide");
    }

    private final void goToPreviousSlide() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.goToPreviousSlide();
    }

    private final void handleDeniedPermission(String str) {
        if (C0490a.m1951a((Activity) this, str)) {
            onUserDeniedPermission(str);
            PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
            if (permissionWrapper != null && !permissionWrapper.getRequired()) {
                this.permissionsMap.remove(Integer.valueOf(permissionWrapper.getPosition()));
                goToNextSlide$default(this, false, 1, (Object) null);
                return;
            }
            return;
        }
        onUserDisabledPermission(str);
    }

    private final void initializeIndicator() {
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup == null) {
            C3250h.m9057b("indicatorContainer");
        }
        IndicatorController indicatorController2 = this.indicatorController;
        viewGroup.addView(indicatorController2 != null ? indicatorController2.newInstance(this) : null);
        IndicatorController indicatorController3 = this.indicatorController;
        if (indicatorController3 != null) {
            indicatorController3.initialize(this.slidesNumber);
        }
        IndicatorController indicatorController4 = this.indicatorController;
        if (indicatorController4 != null) {
            indicatorController4.selectPosition(this.currentlySelectedItem);
        }
    }

    /* access modifiers changed from: private */
    public final void performColorTransition(C0735d dVar, C0735d dVar2, float f) {
        if (!(dVar instanceof SlideBackgroundColorHolder) || !(dVar2 instanceof SlideBackgroundColorHolder)) {
            throw new IllegalStateException("Color transitions are only available if all slides implement SlideBackgroundColorHolder.".toString());
        } else if (dVar.isAdded() && dVar2.isAdded()) {
            SlideBackgroundColorHolder slideBackgroundColorHolder = (SlideBackgroundColorHolder) dVar;
            SlideBackgroundColorHolder slideBackgroundColorHolder2 = (SlideBackgroundColorHolder) dVar2;
            Object evaluate = this.argbEvaluator.evaluate(f, Integer.valueOf(slideBackgroundColorHolder.getDefaultBackgroundColor()), Integer.valueOf(slideBackgroundColorHolder2.getDefaultBackgroundColor()));
            if (evaluate != null) {
                int intValue = ((Integer) evaluate).intValue();
                slideBackgroundColorHolder.setBackgroundColor(intValue);
                slideBackgroundColorHolder2.setBackgroundColor(intValue);
                return;
            }
            throw new C3266f("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* access modifiers changed from: private */
    public final void requestPermissions() {
        setSwipeLock(true);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper != null) {
            C0490a.m1950a(this, permissionWrapper.getPermissions(), 1);
        }
    }

    /* access modifiers changed from: private */
    public final void setPermissionSlide() {
        Map map = this.permissionsMap;
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        if (map.containsKey(Integer.valueOf(appIntroViewPager.getCurrentSlideNumber(this.fragments.size())))) {
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                C3250h.m9057b("pager");
            }
            appIntroViewPager2.setPermissionSlide(true);
            return;
        }
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager3.setPermissionSlide(false);
        setSwipeLock(false);
    }

    /* access modifiers changed from: private */
    public final boolean shouldRequestPermission() {
        return this.permissionsMap.containsKey(Integer.valueOf(getCurrentSlideNumber()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0.getCurrentItem() == 0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r0.getCurrentItem() != (r5.slidesNumber - 1)) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateButtonsVisibility() {
        /*
            r5 = this;
            boolean r0 = r5.isButtonsEnabled
            r1 = 0
            if (r0 == 0) goto L_0x006f
            boolean r0 = r5.isRtl$appintro_release()
            r2 = 1
            if (r0 != 0) goto L_0x001e
            com.github.appintro.internal.AppIntroViewPager r0 = r5.pager
            if (r0 != 0) goto L_0x0015
            java.lang.String r3 = "pager"
            p157d.p161d.p163b.C3250h.m9057b(r3)
        L_0x0015:
            int r0 = r0.getCurrentItem()
            int r3 = r5.slidesNumber
            int r3 = r3 - r2
            if (r0 == r3) goto L_0x0033
        L_0x001e:
            boolean r0 = r5.isRtl$appintro_release()
            if (r0 == 0) goto L_0x0035
            com.github.appintro.internal.AppIntroViewPager r0 = r5.pager
            if (r0 != 0) goto L_0x002d
            java.lang.String r3 = "pager"
            p157d.p161d.p163b.C3250h.m9057b(r3)
        L_0x002d:
            int r0 = r0.getCurrentItem()
            if (r0 != 0) goto L_0x0035
        L_0x0033:
            r0 = 1
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            android.view.View r3 = r5.nextButton
            if (r3 != 0) goto L_0x003f
            java.lang.String r4 = "nextButton"
            p157d.p161d.p163b.C3250h.m9057b(r4)
        L_0x003f:
            r4 = r0 ^ 1
            com.github.appintro.AppIntroBaseKt.setVisible(r3, r4)
            android.view.View r3 = r5.doneButton
            if (r3 != 0) goto L_0x004d
            java.lang.String r4 = "doneButton"
            p157d.p161d.p163b.C3250h.m9057b(r4)
        L_0x004d:
            com.github.appintro.AppIntroBaseKt.setVisible(r3, r0)
            android.view.View r3 = r5.skipButton
            if (r3 != 0) goto L_0x0059
            java.lang.String r4 = "skipButton"
            p157d.p161d.p163b.C3250h.m9057b(r4)
        L_0x0059:
            boolean r4 = r5.isSkipButtonEnabled
            if (r4 == 0) goto L_0x0060
            if (r0 != 0) goto L_0x0060
            r1 = 1
        L_0x0060:
            com.github.appintro.AppIntroBaseKt.setVisible(r3, r1)
            android.view.View r0 = r5.backButton
            if (r0 != 0) goto L_0x006c
            java.lang.String r1 = "backButton"
            p157d.p161d.p163b.C3250h.m9057b(r1)
        L_0x006c:
            boolean r1 = r5.isWizardMode
            goto L_0x009c
        L_0x006f:
            android.view.View r0 = r5.nextButton
            if (r0 != 0) goto L_0x0078
            java.lang.String r2 = "nextButton"
            p157d.p161d.p163b.C3250h.m9057b(r2)
        L_0x0078:
            com.github.appintro.AppIntroBaseKt.setVisible(r0, r1)
            android.view.View r0 = r5.doneButton
            if (r0 != 0) goto L_0x0084
            java.lang.String r2 = "doneButton"
            p157d.p161d.p163b.C3250h.m9057b(r2)
        L_0x0084:
            com.github.appintro.AppIntroBaseKt.setVisible(r0, r1)
            android.view.View r0 = r5.backButton
            if (r0 != 0) goto L_0x0090
            java.lang.String r2 = "backButton"
            p157d.p161d.p163b.C3250h.m9057b(r2)
        L_0x0090:
            com.github.appintro.AppIntroBaseKt.setVisible(r0, r1)
            android.view.View r0 = r5.skipButton
            if (r0 != 0) goto L_0x009c
            java.lang.String r2 = "skipButton"
            p157d.p161d.p163b.C3250h.m9057b(r2)
        L_0x009c:
            com.github.appintro.AppIntroBaseKt.setVisible(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.appintro.AppIntroBase.updateButtonsVisibility():void");
    }

    /* access modifiers changed from: protected */
    public final void addSlide(@NotNull C0735d dVar) {
        C3250h.m9056b(dVar, "fragment");
        if (isRtl$appintro_release()) {
            this.fragments.add(0, dVar);
        } else {
            this.fragments.add(dVar);
        }
        if (this.isWizardMode) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                C3250h.m9057b("pager");
            }
            appIntroViewPager.setOffscreenPageLimit(this.fragments.size());
        }
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 == null) {
            C3250h.m9057b("pagerAdapter");
        }
        pagerAdapter2.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void askForPermissions(@NotNull String[] strArr, int i) {
        askForPermissions$default(this, strArr, i, false, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void askForPermissions(@NotNull String[] strArr, int i, boolean z) {
        C3250h.m9056b(strArr, "permissions");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (i > 0) {
            this.permissionsMap.put(Integer.valueOf(i), new PermissionWrapper(strArr, i, z));
            return;
        }
        throw new IllegalStateException(("Invalid Slide Number: " + i).toString());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final IndicatorController getIndicatorController() {
        return this.indicatorController;
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public final long getVibrateDuration() {
        return this.vibrateDuration;
    }

    /* access modifiers changed from: protected */
    public final void goToNextSlide(boolean z) {
        if (z) {
            onIntroFinished();
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.goToNextSlide();
        onNextSlide();
    }

    /* access modifiers changed from: protected */
    public final boolean isButtonsEnabled() {
        return this.isButtonsEnabled;
    }

    /* access modifiers changed from: protected */
    public final boolean isColorTransitionsEnabled() {
        return this.isColorTransitionsEnabled;
    }

    /* access modifiers changed from: protected */
    public final boolean isIndicatorEnabled() {
        return this.isIndicatorEnabled;
    }

    public final boolean isRtl$appintro_release() {
        Context applicationContext = getApplicationContext();
        C3250h.m9053a((Object) applicationContext, "applicationContext");
        return LayoutUtil.isRtl(applicationContext);
    }

    /* access modifiers changed from: protected */
    public final boolean isSkipButtonEnabled() {
        return this.isSkipButtonEnabled;
    }

    /* access modifiers changed from: protected */
    public final boolean isSystemBackButtonLocked() {
        return this.isSystemBackButtonLocked;
    }

    /* access modifiers changed from: protected */
    public final boolean isVibrate() {
        return this.isVibrate;
    }

    /* access modifiers changed from: protected */
    public final boolean isWizardMode() {
        return this.isWizardMode;
    }

    public void onBackPressed() {
        if (!this.isSystemBackButtonLocked) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                C3250h.m9057b("pager");
            }
            if (appIntroViewPager.isFirstSlide(this.fragments.size())) {
                super.onBackPressed();
                return;
            }
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                C3250h.m9057b("pager");
            }
            appIntroViewPager2.goToPreviousSlide();
        }
    }

    public boolean onCanRequestNextPage() {
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 == null) {
            C3250h.m9057b("pagerAdapter");
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        C0735d item = pagerAdapter2.getItem(appIntroViewPager.getCurrentItem());
        if (!(item instanceof SlidePolicy) || ((SlidePolicy) item).isPolicyRespected()) {
            LogHelper.m8403d(TAG, "Change request will be allowed.");
            return true;
        }
        LogHelper.m8403d(TAG, "Slide policy not respected, denying change request.");
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        C0096f.m129a(true);
        super.onCreate(bundle);
        this.indicatorController = new DotIndicatorController(this);
        showStatusBar(false);
        setContentView(getLayoutId());
        ViewGroup viewGroup = (ViewGroup) findViewById(C2142R.C2145id.indicator_container);
        if (viewGroup != null) {
            this.indicatorContainer = viewGroup;
            View findViewById = findViewById(C2142R.C2145id.next);
            if (findViewById != null) {
                this.nextButton = findViewById;
                View findViewById2 = findViewById(C2142R.C2145id.done);
                if (findViewById2 != null) {
                    this.doneButton = findViewById2;
                    View findViewById3 = findViewById(C2142R.C2145id.skip);
                    if (findViewById3 != null) {
                        this.skipButton = findViewById3;
                        View findViewById4 = findViewById(C2142R.C2145id.back);
                        if (findViewById4 != null) {
                            this.backButton = findViewById4;
                            View view = this.nextButton;
                            if (view == null) {
                                C3250h.m9057b("nextButton");
                            }
                            C0307ba.m1144a(view, getString(C2142R.string.app_intro_next_button));
                            View view2 = this.skipButton;
                            if (view2 == null) {
                                C3250h.m9057b("skipButton");
                            }
                            if (view2 instanceof ImageButton) {
                                View view3 = this.skipButton;
                                if (view3 == null) {
                                    C3250h.m9057b("skipButton");
                                }
                                C0307ba.m1144a(view3, getString(C2142R.string.app_intro_skip_button));
                            }
                            View view4 = this.doneButton;
                            if (view4 == null) {
                                C3250h.m9057b("doneButton");
                            }
                            if (view4 instanceof ImageButton) {
                                View view5 = this.doneButton;
                                if (view5 == null) {
                                    C3250h.m9057b("doneButton");
                                }
                                C0307ba.m1144a(view5, getString(C2142R.string.app_intro_done_button));
                            }
                            View view6 = this.backButton;
                            if (view6 == null) {
                                C3250h.m9057b("backButton");
                            }
                            if (view6 instanceof ImageButton) {
                                View view7 = this.backButton;
                                if (view7 == null) {
                                    C3250h.m9057b("backButton");
                                }
                                C0307ba.m1144a(view7, getString(C2142R.string.app_intro_back_button));
                            }
                            if (isRtl$appintro_release()) {
                                View view8 = this.nextButton;
                                if (view8 == null) {
                                    C3250h.m9057b("nextButton");
                                }
                                view8.setScaleX(-1.0f);
                                View view9 = this.backButton;
                                if (view9 == null) {
                                    C3250h.m9057b("backButton");
                                }
                                view9.setScaleX(-1.0f);
                            }
                            Object systemService = getSystemService("vibrator");
                            if (systemService != null) {
                                this.vibrator = (Vibrator) systemService;
                                C0750j supportFragmentManager = getSupportFragmentManager();
                                C3250h.m9053a((Object) supportFragmentManager, "supportFragmentManager");
                                this.pagerAdapter = new PagerAdapter(supportFragmentManager, this.fragments);
                                View findViewById5 = findViewById(C2142R.C2145id.view_pager);
                                C3250h.m9053a((Object) findViewById5, "findViewById(R.id.view_pager)");
                                this.pager = (AppIntroViewPager) findViewById5;
                                View view10 = this.doneButton;
                                if (view10 == null) {
                                    C3250h.m9057b("doneButton");
                                }
                                view10.setOnClickListener(new NextSlideOnClickListener(true));
                                View view11 = this.nextButton;
                                if (view11 == null) {
                                    C3250h.m9057b("nextButton");
                                }
                                view11.setOnClickListener(new NextSlideOnClickListener(false));
                                View view12 = this.backButton;
                                if (view12 == null) {
                                    C3250h.m9057b("backButton");
                                }
                                view12.setOnClickListener(new AppIntroBase$onCreate$1(this));
                                View view13 = this.skipButton;
                                if (view13 == null) {
                                    C3250h.m9057b("skipButton");
                                }
                                view13.setOnClickListener(new AppIntroBase$onCreate$2(this));
                                AppIntroViewPager appIntroViewPager = this.pager;
                                if (appIntroViewPager == null) {
                                    C3250h.m9057b("pager");
                                }
                                PagerAdapter pagerAdapter2 = this.pagerAdapter;
                                if (pagerAdapter2 == null) {
                                    C3250h.m9057b("pagerAdapter");
                                }
                                appIntroViewPager.setAdapter(pagerAdapter2);
                                AppIntroViewPager appIntroViewPager2 = this.pager;
                                if (appIntroViewPager2 == null) {
                                    C3250h.m9057b("pager");
                                }
                                appIntroViewPager2.addOnPageChangeListener$appintro_release(new OnPageChangeListener());
                                AppIntroViewPager appIntroViewPager3 = this.pager;
                                if (appIntroViewPager3 == null) {
                                    C3250h.m9057b("pager");
                                }
                                appIntroViewPager3.setOnNextPageRequestedListener(this);
                                setScrollDurationFactor(1);
                                return;
                            }
                            throw new C3266f("null cannot be cast to non-null type android.os.Vibrator");
                        }
                        throw new IllegalStateException("Missing Back button: R.id.back".toString());
                    }
                    throw new IllegalStateException("Missing Skip button: R.id.skip".toString());
                }
                throw new IllegalStateException("Missing Done button: R.id.done".toString());
            }
            throw new IllegalStateException("Missing Next button: R.id.next".toString());
        }
        throw new IllegalStateException("Missing Indicator Container: R.id.indicator_container".toString());
    }

    /* access modifiers changed from: protected */
    public void onDonePressed(@Nullable C0735d dVar) {
    }

    public void onIllegallyRequestedNextPage() {
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 == null) {
            C3250h.m9057b("pagerAdapter");
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        C0735d item = pagerAdapter2.getItem(appIntroViewPager.getCurrentItem());
        if (item instanceof SlidePolicy) {
            SlidePolicy slidePolicy = (SlidePolicy) item;
            if (!slidePolicy.isPolicyRespected()) {
                slidePolicy.onUserIllegallyRequestedNextPage();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onIntroFinished() {
    }

    public boolean onKeyDown(int i, @NotNull KeyEvent keyEvent) {
        C3250h.m9056b(keyEvent, "event");
        if (i != 66 && i != 96 && i != 23) {
            return super.onKeyDown(i, keyEvent);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        int currentItem = appIntroViewPager.getCurrentItem();
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 == null) {
            C3250h.m9057b("pagerAdapter");
        }
        boolean z = true;
        if (currentItem != pagerAdapter2.getCount() - 1) {
            z = false;
        }
        goToNextSlide(z);
        if (z) {
            PagerAdapter pagerAdapter3 = this.pagerAdapter;
            if (pagerAdapter3 == null) {
                C3250h.m9057b("pagerAdapter");
            }
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                C3250h.m9057b("pager");
            }
            onDonePressed(pagerAdapter3.getItem(appIntroViewPager2.getCurrentItem()));
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onNextPressed(@Nullable C0735d dVar) {
    }

    /* access modifiers changed from: protected */
    public void onNextSlide() {
    }

    /* access modifiers changed from: protected */
    public void onPageSelected(int i) {
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(@Nullable Bundle bundle) {
        AppIntroViewPager appIntroViewPager;
        int i;
        super.onPostCreate(bundle);
        this.slidesNumber = this.fragments.size();
        initializeIndicator();
        if (isRtl$appintro_release()) {
            appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                C3250h.m9057b("pager");
            }
            i = this.fragments.size() - this.savedCurrentItem;
        } else {
            appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                C3250h.m9057b("pager");
            }
            i = this.savedCurrentItem;
        }
        appIntroViewPager.setCurrentItem(i);
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager2.post(new AppIntroBase$onPostCreate$1(this));
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        C3250h.m9056b(strArr, "permissions");
        C3250h.m9056b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        setSwipeLock(false);
        if (i == 1) {
            Collection arrayList = new ArrayList(iArr.length);
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                arrayList.add(C3257e.m9066a(strArr[i3], Integer.valueOf(iArr[i2])));
                i2++;
                i3++;
            }
            Collection arrayList2 = new ArrayList();
            for (Object next : (List) arrayList) {
                if (((Number) ((C3216d) next).mo25685d()).intValue() == -1) {
                    arrayList2.add(next);
                }
            }
            Iterable<C3216d> iterable = (List) arrayList2;
            Collection arrayList3 = new ArrayList(C3191g.m8988a(iterable, 10));
            for (C3216d c : iterable) {
                arrayList3.add((String) c.mo25684c());
            }
            List<String> list = (List) arrayList3;
            if (list.isEmpty()) {
                this.permissionsMap.remove(Integer.valueOf(getCurrentSlideNumber()));
                goToNextSlide$default(this, false, 1, (Object) null);
                return;
            }
            for (String handleDeniedPermission : list) {
                handleDeniedPermission(handleDeniedPermission);
            }
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                C3250h.m9057b("pager");
            }
            appIntroViewPager.reCenterCurrentSlide$appintro_release();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@NotNull Bundle bundle) {
        C3250h.m9056b(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        this.slidesNumber = bundle.getInt(ARG_BUNDLE_SLIDES_NUMBER);
        this.retainIsButtonEnabled = bundle.getBoolean(ARG_BUNDLE_RETAIN_IS_BUTTON_ENABLED);
        setButtonsEnabled(bundle.getBoolean(ARG_BUNDLE_IS_BUTTON_ENABLED));
        setSkipButtonEnabled(bundle.getBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED));
        setIndicatorEnabled(bundle.getBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED));
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.setLockPage(bundle.getInt(ARG_BUNDLE_LOCK_PAGE));
        this.savedCurrentItem = bundle.getInt(ARG_BUNDLE_CURRENT_ITEM);
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager2.setFullPagingEnabled(bundle.getBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED));
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager3.setNextPagingEnabled(bundle.getBoolean(ARG_BUNDLE_IS_NEXT_PAGING_ENABLED));
        HashMap<Integer, PermissionWrapper> hashMap = (HashMap) bundle.getSerializable(ARG_BUNDLE_PERMISSION_MAP);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.permissionsMap = hashMap;
        this.isColorTransitionsEnabled = bundle.getBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C3250h.m9056b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putInt(ARG_BUNDLE_SLIDES_NUMBER, this.slidesNumber);
        bundle.putBoolean(ARG_BUNDLE_RETAIN_IS_BUTTON_ENABLED, this.retainIsButtonEnabled);
        bundle.putBoolean(ARG_BUNDLE_IS_BUTTON_ENABLED, this.isButtonsEnabled);
        bundle.putBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED, this.isSkipButtonEnabled);
        bundle.putBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED, this.isIndicatorEnabled);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        bundle.putInt(ARG_BUNDLE_LOCK_PAGE, appIntroViewPager.getLockPage());
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            C3250h.m9057b("pager");
        }
        bundle.putInt(ARG_BUNDLE_CURRENT_ITEM, appIntroViewPager2.getCurrentItem());
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            C3250h.m9057b("pager");
        }
        bundle.putBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED, appIntroViewPager3.isFullPagingEnabled());
        AppIntroViewPager appIntroViewPager4 = this.pager;
        if (appIntroViewPager4 == null) {
            C3250h.m9057b("pager");
        }
        bundle.putBoolean(ARG_BUNDLE_IS_NEXT_PAGING_ENABLED, appIntroViewPager4.isNextPagingEnabled());
        bundle.putSerializable(ARG_BUNDLE_PERMISSION_MAP, this.permissionsMap);
        bundle.putBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED, this.isColorTransitionsEnabled);
    }

    /* access modifiers changed from: protected */
    public void onSkipPressed(@Nullable C0735d dVar) {
    }

    /* access modifiers changed from: protected */
    public void onSlideChanged(@Nullable C0735d dVar, @Nullable C0735d dVar2) {
    }

    /* access modifiers changed from: protected */
    public void onUserDeniedPermission(@NotNull String str) {
        C3250h.m9056b(str, "permissionName");
    }

    /* access modifiers changed from: protected */
    public void onUserDisabledPermission(@NotNull String str) {
        C3250h.m9056b(str, "permissionName");
    }

    public void onUserRequestedPermissionsDialog() {
        String str = TAG;
        LogHelper.m8403d(str, "Requesting Permissions on " + getCurrentSlideNumber());
        requestPermissions();
    }

    /* access modifiers changed from: protected */
    public final void setButtonsEnabled(boolean z) {
        this.isButtonsEnabled = z;
        updateButtonsVisibility();
    }

    /* access modifiers changed from: protected */
    public final void setColorTransitionsEnabled(boolean z) {
        this.isColorTransitionsEnabled = z;
    }

    /* access modifiers changed from: protected */
    public final void setCustomTransformer(@Nullable C0922b.C0933g gVar) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.setPageTransformer(true, gVar);
    }

    /* access modifiers changed from: protected */
    public final void setImmersiveMode() {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            C3250h.m9053a((Object) window, "window");
            View decorView = window.getDecorView();
            C3250h.m9053a((Object) decorView, "window.decorView");
            decorView.setSystemUiVisibility(5894);
        }
    }

    /* access modifiers changed from: protected */
    public final void setIndicatorColor(int i, int i2) {
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.setSelectedIndicatorColor(i);
        }
        IndicatorController indicatorController3 = this.indicatorController;
        if (indicatorController3 != null) {
            indicatorController3.setUnselectedIndicatorColor(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void setIndicatorController(@Nullable IndicatorController indicatorController2) {
        this.indicatorController = indicatorController2;
    }

    /* access modifiers changed from: protected */
    public final void setIndicatorEnabled(boolean z) {
        this.isIndicatorEnabled = z;
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup == null) {
            C3250h.m9057b("indicatorContainer");
        }
        AppIntroBaseKt.setVisible(viewGroup, z);
    }

    /* access modifiers changed from: protected */
    public final void setNavBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            C3250h.m9053a((Object) window, "window");
            window.setNavigationBarColor(i);
        }
    }

    /* access modifiers changed from: protected */
    public final void setNavBarColorRes(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            C3250h.m9053a((Object) window, "window");
            window.setNavigationBarColor(C0529a.m2102c(this, i));
        }
    }

    /* access modifiers changed from: protected */
    public final void setNextPageSwipeLock(boolean z) {
        if (z) {
            this.retainIsButtonEnabled = this.isButtonsEnabled;
            setButtonsEnabled(true);
        } else {
            setButtonsEnabled(this.retainIsButtonEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.setNextPagingEnabled(!z);
    }

    /* access modifiers changed from: protected */
    public final void setProgressIndicator() {
        this.indicatorController = new ProgressIndicatorController(this, (AttributeSet) null, 0, 6, (C3247e) null);
    }

    /* access modifiers changed from: protected */
    public final void setScrollDurationFactor(int i) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.setScrollDurationFactor((double) i);
    }

    /* access modifiers changed from: protected */
    public final void setSkipButtonEnabled(boolean z) {
        this.isSkipButtonEnabled = z;
        updateButtonsVisibility();
    }

    /* access modifiers changed from: protected */
    public final void setStatusBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window = getWindow();
            C3250h.m9053a((Object) window, "window");
            window.setStatusBarColor(i);
        }
    }

    /* access modifiers changed from: protected */
    public final void setStatusBarColorRes(int i) {
        setStatusBarColor(C0529a.m2102c(this, i));
    }

    /* access modifiers changed from: protected */
    public final void setSwipeLock(boolean z) {
        if (z) {
            this.retainIsButtonEnabled = this.isButtonsEnabled;
            setButtonsEnabled(true);
        } else {
            setButtonsEnabled(this.retainIsButtonEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.setFullPagingEnabled(!z);
    }

    /* access modifiers changed from: protected */
    public final void setSystemBackButtonLocked(boolean z) {
        this.isSystemBackButtonLocked = z;
    }

    /* access modifiers changed from: protected */
    public final void setTransformer(@NotNull AppIntroPageTransformerType appIntroPageTransformerType) {
        C3250h.m9056b(appIntroPageTransformerType, "appIntroTransformer");
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            C3250h.m9057b("pager");
        }
        appIntroViewPager.setAppIntroPageTransformer(appIntroPageTransformerType);
    }

    /* access modifiers changed from: protected */
    public final void setVibrate(boolean z) {
        this.isVibrate = z;
    }

    /* access modifiers changed from: protected */
    public final void setVibrateDuration(long j) {
        this.vibrateDuration = j;
    }

    /* access modifiers changed from: protected */
    public final void setWizardMode(boolean z) {
        this.isWizardMode = z;
        setSkipButtonEnabled(!z);
        updateButtonsVisibility();
    }

    /* access modifiers changed from: protected */
    public final void showStatusBar(boolean z) {
        if (z) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().setFlags(1024, 1024);
        }
    }
}
