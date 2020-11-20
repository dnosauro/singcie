package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p049j.C0874n;
import androidx.p049j.C0891t;
import java.util.Map;

public class TextScale extends C0874n {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(C0891t tVar) {
        if (tVar.f2918b instanceof TextView) {
            tVar.f2917a.put(PROPNAME_SCALE, Float.valueOf(((TextView) tVar.f2918b).getScaleX()));
        }
    }

    public void captureEndValues(C0891t tVar) {
        captureValues(tVar);
    }

    public void captureStartValues(C0891t tVar) {
        captureValues(tVar);
    }

    public Animator createAnimator(ViewGroup viewGroup, C0891t tVar, C0891t tVar2) {
        if (tVar == null || tVar2 == null || !(tVar.f2918b instanceof TextView) || !(tVar2.f2918b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) tVar2.f2918b;
        Map<String, Object> map = tVar.f2917a;
        Map<String, Object> map2 = tVar2.f2917a;
        float f = 1.0f;
        float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (map2.get(PROPNAME_SCALE) != null) {
            f = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
