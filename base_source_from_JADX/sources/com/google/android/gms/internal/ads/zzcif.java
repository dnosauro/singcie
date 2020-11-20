package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(19)
public final class zzcif {
    private Context context;
    private PopupWindow zzgiu;

    private static PopupWindow zzd(Context context2, View view) {
        Window window = context2 instanceof Activity ? ((Activity) context2).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context2).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context2);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzd.zzeb("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void zzapd() {
        Context context2 = this.context;
        if (context2 != null && this.zzgiu != null) {
            if ((!(context2 instanceof Activity) || !((Activity) context2).isDestroyed()) && this.zzgiu.isShowing()) {
                this.zzgiu.dismiss();
            }
            this.context = null;
            this.zzgiu = null;
        }
    }

    public final void zzc(Context context2, View view) {
        if (PlatformVersion.isAtLeastKitKat() && !PlatformVersion.isAtLeastLollipop()) {
            this.zzgiu = zzd(context2, view);
            if (this.zzgiu == null) {
                context2 = null;
            }
            this.context = context2;
        }
    }
}
