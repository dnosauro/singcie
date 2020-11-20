package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

public final class zzbns extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context context;
    private View zzaaq;

    private zzbns(Context context2) {
        super(context2);
        this.context = context2;
    }

    public static zzbns zza(Context context2, View view, zzdmu zzdmu) {
        zzbns zzbns = new zzbns(context2);
        zzbns.zzaaq = view;
        zzbns.addView(view);
        zzp.zzln();
        zzazy.zza((View) zzbns, (ViewTreeObserver.OnScrollChangedListener) zzbns);
        zzp.zzln();
        zzazy.zza((View) zzbns, (ViewTreeObserver.OnGlobalLayoutListener) zzbns);
        JSONObject jSONObject = zzdmu.zzhhp;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbns.context);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                zzbns.zza(optJSONObject, relativeLayout, 10);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
            if (optJSONObject2 != null) {
                zzbns.zza(optJSONObject2, relativeLayout, 12);
            }
            zzbns.addView(relativeLayout);
        }
        return zzbns;
    }

    private final void zza(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.context);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString(TextBundle.TEXT_ENTRY, ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzb, 0, zzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzb(double d) {
        zzwq.zzqa();
        return zzayr.zzc(this.context, (int) d);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaaq.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaaq.setY((float) (-iArr[1]));
    }
}
