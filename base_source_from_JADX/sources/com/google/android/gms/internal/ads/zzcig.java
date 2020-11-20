package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzag;
import java.util.ArrayList;

public final class zzcig extends FrameLayout {
    private final zzag zzdqz;

    public zzcig(Context context, View view, zzag zzag) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zzdqz = zzag;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zzdqz.zzd(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzbdv)) {
                arrayList.add((zzbdv) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzbdv) obj).destroy();
        }
    }
}
