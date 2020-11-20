package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzdvd;
import com.google.android.gms.internal.ads.zzdvx;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.annotation.Nonnull;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

public final class zzbq {
    public static Point zza(MotionEvent motionEvent, View view) {
        int[] zzu = zzu(view);
        return new Point(((int) motionEvent.getRawX()) - zzu[0], ((int) motionEvent.getRawY()) - zzu[1]);
    }

    private static JSONObject zza(Context context, Point point, Point point2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzb(context, point2.x));
            jSONObject.put("y", zzb(context, point2.y));
            jSONObject.put("start_x", zzb(context, point.x));
            jSONObject.put("start_y", zzb(context, point.y));
            return jSONObject;
        } catch (JSONException e) {
            zzd.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    private static JSONObject zza(Context context, Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzb(context, rect.right - rect.left));
        jSONObject.put("height", zzb(context, rect.bottom - rect.top));
        jSONObject.put("x", zzb(context, rect.left));
        jSONObject.put("y", zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    public static JSONObject zza(Context context, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view == null) {
            return jSONObject2;
        }
        try {
            int[] zzu = zzu(view);
            int[] iArr = new int[2];
            if (view != null) {
                iArr[0] = view.getMeasuredWidth();
                iArr[1] = view.getMeasuredHeight();
                for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    iArr[0] = Math.min(((ViewGroup) parent).getMeasuredWidth(), iArr[0]);
                    iArr[1] = Math.min(((ViewGroup) parent).getMeasuredHeight(), iArr[1]);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("width", zzb(context, view.getMeasuredWidth()));
            jSONObject3.put("height", zzb(context, view.getMeasuredHeight()));
            jSONObject3.put("x", zzb(context, zzu[0]));
            jSONObject3.put("y", zzb(context, zzu[1]));
            jSONObject3.put("maximum_visible_width", zzb(context, iArr[0]));
            jSONObject3.put("maximum_visible_height", zzb(context, iArr[1]));
            jSONObject3.put("relative_to", "window");
            jSONObject2.put("frame", jSONObject3);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                jSONObject = zza(context, rect);
            } else {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", 0);
                jSONObject4.put("height", 0);
                jSONObject4.put("x", zzb(context, zzu[0]));
                jSONObject4.put("y", zzb(context, zzu[1]));
                jSONObject4.put("relative_to", "window");
                jSONObject = jSONObject4;
            }
            jSONObject2.put("visible_bounds", jSONObject);
        } catch (Exception unused) {
            zzd.zzfa("Unable to get native ad view bounding box");
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcww)).booleanValue()) {
            String str = "";
            ViewParent parent2 = view.getParent();
            if (parent2 != null) {
                try {
                    str = (String) parent2.getClass().getMethod("getTemplateTypeName", new Class[0]).invoke(parent2, new Object[0]);
                } catch (NoSuchMethodException unused2) {
                } catch (IllegalAccessException | SecurityException | InvocationTargetException e) {
                    zzd.zzc("Cannot access method getTemplateTypeName: ", e);
                }
            }
            char c = 65535;
            try {
                int hashCode = str.hashCode();
                if (hashCode != -2066603854) {
                    if (hashCode == 2019754500) {
                        if (str.equals("medium_template")) {
                            c = 1;
                        }
                    }
                } else if (str.equals("small_template")) {
                    c = 0;
                }
                switch (c) {
                    case 0:
                        jSONObject2.put("native_template_type", 1);
                        break;
                    case 1:
                        jSONObject2.put("native_template_type", 2);
                        break;
                    default:
                        jSONObject2.put("native_template_type", 0);
                        break;
                }
            } catch (JSONException e2) {
                zzd.zzc("Could not log native template signal to JSON", e2);
            }
        }
        return jSONObject2;
    }

    public static JSONObject zza(Context context, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (!(map == null || view == null)) {
            int[] zzu = zzu(view);
            for (Map.Entry next : map.entrySet()) {
                View view2 = (View) ((WeakReference) next.getValue()).get();
                if (view2 != null) {
                    int[] zzu2 = zzu(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        jSONObject4.put("width", zzb(context, view2.getMeasuredWidth()));
                        jSONObject4.put("height", zzb(context, view2.getMeasuredHeight()));
                        boolean z = false;
                        jSONObject4.put("x", zzb(context, zzu2[0] - zzu[0]));
                        jSONObject4.put("y", zzb(context, zzu2[1] - zzu[1]));
                        jSONObject4.put("relative_to", "ad_view");
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zza(context, rect);
                        } else {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("width", 0);
                            jSONObject5.put("height", 0);
                            jSONObject5.put("x", zzb(context, zzu2[0] - zzu[0]));
                            jSONObject5.put("y", zzb(context, zzu2[1] - zzu[1]));
                            jSONObject5.put("relative_to", "ad_view");
                            jSONObject = jSONObject5;
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            jSONObject3.put("font_size", (double) textView.getTextSize());
                            jSONObject3.put(TextBundle.TEXT_ENTRY, textView.getText());
                        }
                        if (map2 != null && map2.containsKey(next.getKey()) && view2.isClickable()) {
                            z = true;
                        }
                        jSONObject3.put("is_clickable", z);
                        jSONObject2.put((String) next.getKey(), jSONObject3);
                    } catch (JSONException unused) {
                        zzd.zzfa("Unable to get asset views information");
                    }
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zza(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", zza(context, point, point2));
                jSONObject.put("asset_id", str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
            zzd.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
        return jSONObject;
    }

    public static boolean zza(Context context, zzdmu zzdmu) {
        if (!zzdmu.zzhhf) {
            return false;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyh)).booleanValue()) {
            return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcyk)).booleanValue();
        }
        String str = (String) zzwq.zzqe().zzd(zzabf.zzcyi);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            for (String equals : zzdvx.zza(zzdvd.zzb(';')).zza((CharSequence) str)) {
                if (equals.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int zzb(Context context, int i) {
        return zzwq.zzqa().zzb(context, i);
    }

    public static JSONObject zzb(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzp.zzkq();
            jSONObject.put("can_show_on_lock_screen", zzm.zzq(view));
            zzp.zzkq();
            jSONObject.put("is_keyguard_locked", zzm.zzav(context));
        } catch (JSONException unused) {
            zzd.zzfa("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zzbm(@Nonnull Context context) {
        JSONObject jSONObject = new JSONObject();
        zzp.zzkq();
        DisplayMetrics zza = zzm.zza((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put("width", zzb(context, zza.widthPixels));
            jSONObject.put("height", zzb(context, zza.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean zzdi(int i) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcrn)).booleanValue()) {
            return true;
        }
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcro)).booleanValue() || i <= 15299999;
    }

    public static JSONObject zzt(View view) {
        String str;
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyg)).booleanValue()) {
                str = "contained_in_scroll_view";
                zzp.zzkq();
                z = zzm.zzs(view);
            } else {
                zzp.zzkq();
                str = "contained_in_scroll_view";
                z = zzm.zzr(view) != -1;
            }
            jSONObject.put(str, z);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static int[] zzu(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static WindowManager.LayoutParams zzyx() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzwq.zzqe().zzd(zzabf.zzcyj)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        return layoutParams;
    }
}
