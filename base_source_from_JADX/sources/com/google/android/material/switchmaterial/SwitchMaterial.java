package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0295as;
import com.google.android.material.C2246R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;

public class SwitchMaterial extends C0295as {
    private static final int DEF_STYLE_RES = C2246R.C2250style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    private final ElevationOverlayProvider elevationOverlayProvider;
    private ColorStateList materialThemeColorsThumbTintList;
    private ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    public SwitchMaterial(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2246R.attr.switchStyle);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet, int i) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        this.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C2246R.styleable.SwitchMaterial, i, DEF_STYLE_RES, new int[0]);
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(C2246R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        obtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList == null) {
            int color = MaterialColors.getColor(this, C2246R.attr.colorSurface);
            int color2 = MaterialColors.getColor(this, C2246R.attr.colorControlActivated);
            float dimension = getResources().getDimension(C2246R.dimen.mtrl_switch_thumb_elevation);
            if (this.elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
                dimension += ViewUtils.getParentAbsoluteElevation(this);
            }
            int compositeOverlayIfNeeded = this.elevationOverlayProvider.compositeOverlayIfNeeded(color, dimension);
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            iArr[0] = MaterialColors.layer(color, color2, 1.0f);
            iArr[1] = compositeOverlayIfNeeded;
            iArr[2] = MaterialColors.layer(color, color2, 0.38f);
            iArr[3] = compositeOverlayIfNeeded;
            this.materialThemeColorsThumbTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsThumbTintList;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int color = MaterialColors.getColor(this, C2246R.attr.colorSurface);
            int color2 = MaterialColors.getColor(this, C2246R.attr.colorControlActivated);
            int color3 = MaterialColors.getColor(this, C2246R.attr.colorOnSurface);
            iArr[0] = MaterialColors.layer(color, color2, 0.54f);
            iArr[1] = MaterialColors.layer(color, color3, 0.32f);
            iArr[2] = MaterialColors.layer(color, color2, 0.12f);
            iArr[3] = MaterialColors.layer(color, color3, 0.12f);
            this.materialThemeColorsTrackTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTrackTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.useMaterialThemeColors && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList colorStateList;
        this.useMaterialThemeColors = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            colorStateList = getMaterialThemeColorsTrackTintList();
        } else {
            colorStateList = null;
            setThumbTintList((ColorStateList) null);
        }
        setTrackTintList(colorStateList);
    }
}
