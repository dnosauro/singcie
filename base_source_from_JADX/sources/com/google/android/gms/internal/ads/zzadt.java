package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzadt extends RelativeLayout {
    private static final float[] zzdek = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzdel;

    public zzadt(Context context, zzadq zzadq, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzadq);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzdek, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zzadq.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzp.zzks();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadq.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadq.getText());
            textView.setTextColor(zzadq.getTextColor());
            textView.setTextSize((float) zzadq.getTextSize());
            zzwq.zzqa();
            int zzc = zzayr.zzc(context, 4);
            zzwq.zzqa();
            textView.setPadding(zzc, 0, zzayr.zzc(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadv> zzsn = zzadq.zzsn();
        if (zzsn != null && zzsn.size() > 1) {
            this.zzdel = new AnimationDrawable();
            for (zzadv zzsr : zzsn) {
                try {
                    this.zzdel.addFrame((Drawable) ObjectWrapper.unwrap(zzsr.zzsr()), zzadq.zzso());
                } catch (Exception e) {
                    zzd.zzc("Error while getting drawable.", e);
                }
            }
            zzp.zzks();
            imageView.setBackground(this.zzdel);
        } else if (zzsn.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zzsn.get(0).zzsr()));
            } catch (Exception e2) {
                zzd.zzc("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzdel;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
