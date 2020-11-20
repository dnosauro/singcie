package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzwq;

public final class zzr extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdru;
    private final zzz zzdrv;

    public zzr(Context context, zzq zzq, zzz zzz) {
        super(context);
        this.zzdrv = zzz;
        setOnClickListener(this);
        this.zzdru = new ImageButton(context);
        this.zzdru.setImageResource(17301527);
        this.zzdru.setBackgroundColor(0);
        this.zzdru.setOnClickListener(this);
        ImageButton imageButton = this.zzdru;
        zzwq.zzqa();
        int zzc = zzayr.zzc(context, zzq.paddingLeft);
        zzwq.zzqa();
        int zzc2 = zzayr.zzc(context, 0);
        zzwq.zzqa();
        int zzc3 = zzayr.zzc(context, zzq.paddingRight);
        zzwq.zzqa();
        imageButton.setPadding(zzc, zzc2, zzc3, zzayr.zzc(context, zzq.paddingBottom));
        this.zzdru.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zzdru;
        zzwq.zzqa();
        int zzc4 = zzayr.zzc(context, zzq.size + zzq.paddingLeft + zzq.paddingRight);
        zzwq.zzqa();
        addView(imageButton2, new FrameLayout.LayoutParams(zzc4, zzayr.zzc(context, zzq.size + zzq.paddingBottom), 17));
    }

    public final void onClick(View view) {
        zzz zzz = this.zzdrv;
        if (zzz != null) {
            zzz.zzvd();
        }
    }

    public final void zzal(boolean z) {
        ImageButton imageButton;
        int i;
        if (z) {
            imageButton = this.zzdru;
            i = 8;
        } else {
            imageButton = this.zzdru;
            i = 0;
        }
        imageButton.setVisibility(i);
    }
}
