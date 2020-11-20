package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.C0187i;
import androidx.appcompat.view.menu.C0200n;
import androidx.appcompat.widget.C0307ba;
import androidx.core.content.C0529a;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.C0654s;
import androidx.core.p030h.C0656u;
import androidx.core.widget.C0687i;
import com.google.android.material.C2246R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

public class BottomNavigationItemView extends FrameLayout implements C0200n.C0201a {
    private static final int[] CHECKED_STATE_SET = {16842912};
    public static final int INVALID_ITEM_POSITION = -1;
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    /* access modifiers changed from: private */
    public ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private C0187i itemData;
    private int itemPosition;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    public BottomNavigationItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itemPosition = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(C2246R.layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(C2246R.C2248drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(C2246R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(C2246R.C2249id.icon);
        this.smallLabel = (TextView) findViewById(C2246R.C2249id.smallLabel);
        this.largeLabel = (TextView) findViewById(C2246R.C2249id.largeLabel);
        C0656u.m2606b((View) this.smallLabel, 2);
        C0656u.m2606b((View) this.largeLabel, 2);
        setFocusable(true);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (BottomNavigationItemView.this.icon.getVisibility() == 0) {
                        BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                        bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
                    }
                }
            });
        }
        C0656u.m2594a((View) this, (C0610a) null);
    }

    private void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f;
        this.scaleDownFactor = (f * 1.0f) / f2;
    }

    private FrameLayout getCustomParentForBadge(View view) {
        if (view != this.icon || !BadgeUtils.USE_COMPAT_PARENT) {
            return null;
        }
        return (FrameLayout) this.icon.getParent();
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    private void setViewLayoutParams(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void setViewValues(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
            this.badgeDrawable = null;
        }
    }

    /* access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    public C0187i getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void initialize(C0187i iVar, int i) {
        this.itemData = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        C0307ba.m1144a(this, !TextUtils.isEmpty(iVar.getTooltipText()) ? iVar.getTooltipText() : iVar.getTitle());
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        C0187i iVar = this.itemData;
        if (iVar != null && iVar.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.badgeDrawable.getContentDescription());
        }
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    /* access modifiers changed from: package-private */
    public void setBadge(BadgeDrawable badgeDrawable2) {
        this.badgeDrawable = badgeDrawable2;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a5, code lost:
        if (r8 != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a8, code lost:
        if (r8 != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ab, code lost:
        refreshDrawableState();
        setSelected(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00b1, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0051, code lost:
        if (r8 != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0053, code lost:
        setViewLayoutParams(r7.icon, (int) (((float) r7.defaultMargin) + r7.shiftAmount), 49);
        setViewValues(r7.largeLabel, 1.0f, 1.0f, 0);
        r0 = r7.smallLabel;
        r1 = r7.scaleUpFactor;
        setViewValues(r0, r1, r1, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x006c, code lost:
        setViewLayoutParams(r7.icon, r7.defaultMargin, 49);
        r0 = r7.largeLabel;
        r1 = r7.scaleDownFactor;
        setViewValues(r0, r1, r1, 4);
        setViewValues(r7.smallLabel, 1.0f, 1.0f, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0080, code lost:
        if (r8 != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0082, code lost:
        setViewLayoutParams(r7.icon, r7.defaultMargin, 49);
        setViewValues(r7.largeLabel, 1.0f, 1.0f, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x008f, code lost:
        setViewLayoutParams(r7.icon, r7.defaultMargin, 17);
        setViewValues(r7.largeLabel, 0.5f, 0.5f, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x009b, code lost:
        r7.smallLabel.setVisibility(4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setChecked(boolean r8) {
        /*
            r7 = this;
            android.widget.TextView r0 = r7.largeLabel
            int r1 = r0.getWidth()
            int r1 = r1 / 2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r7.largeLabel
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            android.widget.TextView r0 = r7.smallLabel
            int r1 = r0.getWidth()
            int r1 = r1 / 2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r7.smallLabel
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            int r0 = r7.labelVisibilityMode
            r1 = 17
            r2 = 1056964608(0x3f000000, float:0.5)
            r3 = 0
            r4 = 49
            r5 = 4
            r6 = 1065353216(0x3f800000, float:1.0)
            switch(r0) {
                case -1: goto L_0x00a1;
                case 0: goto L_0x0080;
                case 1: goto L_0x0051;
                case 2: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x00ab
        L_0x003d:
            android.widget.ImageView r0 = r7.icon
            int r2 = r7.defaultMargin
            r7.setViewLayoutParams(r0, r2, r1)
            android.widget.TextView r0 = r7.largeLabel
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r7.smallLabel
            r0.setVisibility(r1)
            goto L_0x00ab
        L_0x0051:
            if (r8 == 0) goto L_0x006c
        L_0x0053:
            android.widget.ImageView r0 = r7.icon
            int r1 = r7.defaultMargin
            float r1 = (float) r1
            float r2 = r7.shiftAmount
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.setViewLayoutParams(r0, r1, r4)
            android.widget.TextView r0 = r7.largeLabel
            r7.setViewValues(r0, r6, r6, r3)
            android.widget.TextView r0 = r7.smallLabel
            float r1 = r7.scaleUpFactor
            r7.setViewValues(r0, r1, r1, r5)
            goto L_0x00ab
        L_0x006c:
            android.widget.ImageView r0 = r7.icon
            int r1 = r7.defaultMargin
            r7.setViewLayoutParams(r0, r1, r4)
            android.widget.TextView r0 = r7.largeLabel
            float r1 = r7.scaleDownFactor
            r7.setViewValues(r0, r1, r1, r5)
            android.widget.TextView r0 = r7.smallLabel
            r7.setViewValues(r0, r6, r6, r3)
            goto L_0x00ab
        L_0x0080:
            if (r8 == 0) goto L_0x008f
        L_0x0082:
            android.widget.ImageView r0 = r7.icon
            int r1 = r7.defaultMargin
            r7.setViewLayoutParams(r0, r1, r4)
            android.widget.TextView r0 = r7.largeLabel
            r7.setViewValues(r0, r6, r6, r3)
            goto L_0x009b
        L_0x008f:
            android.widget.ImageView r0 = r7.icon
            int r3 = r7.defaultMargin
            r7.setViewLayoutParams(r0, r3, r1)
            android.widget.TextView r0 = r7.largeLabel
            r7.setViewValues(r0, r2, r2, r5)
        L_0x009b:
            android.widget.TextView r0 = r7.smallLabel
            r0.setVisibility(r5)
            goto L_0x00ab
        L_0x00a1:
            boolean r0 = r7.isShifting
            if (r0 == 0) goto L_0x00a8
            if (r8 == 0) goto L_0x008f
            goto L_0x0082
        L_0x00a8:
            if (r8 == 0) goto L_0x006c
            goto L_0x0053
        L_0x00ab:
            r7.refreshDrawableState()
            r7.setSelected(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomnavigation.BottomNavigationItemView.setChecked(boolean):void");
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        C0656u.m2596a((View) this, z ? C0654s.m2566a(getContext(), 1002) : null);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.originalIconDrawable) {
            this.originalIconDrawable = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C0595a.m2330g(drawable).mutate();
                this.wrappedIconDrawable = drawable;
                ColorStateList colorStateList = this.iconTint;
                if (colorStateList != null) {
                    C0595a.m2319a(this.wrappedIconDrawable, colorStateList);
                }
            }
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            C0595a.m2319a(drawable, this.iconTint);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : C0529a.m2093a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        C0656u.m2590a((View) this, drawable);
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(int i) {
        C0687i.m2806a(this.largeLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(int i) {
        C0687i.m2806a(this.smallLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        C0187i iVar = this.itemData;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        C0187i iVar2 = this.itemData;
        if (iVar2 != null && !TextUtils.isEmpty(iVar2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        C0307ba.m1144a(this, charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
