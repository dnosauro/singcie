package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.C0059a;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.appcompat.widget.C0279an;
import androidx.core.graphics.C0589a;

/* renamed from: androidx.appcompat.widget.k */
public final class C0337k {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final PorterDuff.Mode f1212a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static C0337k f1213b;

    /* renamed from: c */
    private C0279an f1214c;

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m1240a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a;
        synchronized (C0337k.class) {
            a = C0279an.m990a(i, mode);
        }
        return a;
    }

    /* renamed from: a */
    public static synchronized void m1241a() {
        synchronized (C0337k.class) {
            if (f1213b == null) {
                f1213b = new C0337k();
                f1213b.f1214c = C0279an.m994a();
                f1213b.f1214c.mo2245a((C0279an.C0284e) new C0279an.C0284e() {

                    /* renamed from: a */
                    private final int[] f1215a = {C0059a.C0064e.abc_textfield_search_default_mtrl_alpha, C0059a.C0064e.abc_textfield_default_mtrl_alpha, C0059a.C0064e.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b */
                    private final int[] f1216b = {C0059a.C0064e.abc_ic_commit_search_api_mtrl_alpha, C0059a.C0064e.abc_seekbar_tick_mark_material, C0059a.C0064e.abc_ic_menu_share_mtrl_alpha, C0059a.C0064e.abc_ic_menu_copy_mtrl_am_alpha, C0059a.C0064e.abc_ic_menu_cut_mtrl_alpha, C0059a.C0064e.abc_ic_menu_selectall_mtrl_alpha, C0059a.C0064e.abc_ic_menu_paste_mtrl_am_alpha};

                    /* renamed from: c */
                    private final int[] f1217c = {C0059a.C0064e.abc_textfield_activated_mtrl_alpha, C0059a.C0064e.abc_textfield_search_activated_mtrl_alpha, C0059a.C0064e.abc_cab_background_top_mtrl_alpha, C0059a.C0064e.abc_text_cursor_material, C0059a.C0064e.abc_text_select_handle_left_mtrl_dark, C0059a.C0064e.abc_text_select_handle_middle_mtrl_dark, C0059a.C0064e.abc_text_select_handle_right_mtrl_dark, C0059a.C0064e.abc_text_select_handle_left_mtrl_light, C0059a.C0064e.abc_text_select_handle_middle_mtrl_light, C0059a.C0064e.abc_text_select_handle_right_mtrl_light};

                    /* renamed from: d */
                    private final int[] f1218d = {C0059a.C0064e.abc_popup_background_mtrl_mult, C0059a.C0064e.abc_cab_background_internal_bg, C0059a.C0064e.abc_menu_hardkey_panel_mtrl_mult};

                    /* renamed from: e */
                    private final int[] f1219e = {C0059a.C0064e.abc_tab_indicator_material, C0059a.C0064e.abc_textfield_search_material};

                    /* renamed from: f */
                    private final int[] f1220f = {C0059a.C0064e.abc_btn_check_material, C0059a.C0064e.abc_btn_radio_material, C0059a.C0064e.abc_btn_check_material_anim, C0059a.C0064e.abc_btn_radio_material_anim};

                    /* renamed from: a */
                    private ColorStateList m1249a(Context context) {
                        return m1253b(context, C0297at.m1066a(context, C0059a.C0060a.colorButtonNormal));
                    }

                    /* renamed from: a */
                    private void m1250a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (C0257af.m917c(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = C0337k.f1212a;
                        }
                        drawable.setColorFilter(C0337k.m1240a(i, mode));
                    }

                    /* renamed from: a */
                    private boolean m1251a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    /* renamed from: b */
                    private ColorStateList m1252b(Context context) {
                        return m1253b(context, 0);
                    }

                    /* renamed from: b */
                    private ColorStateList m1253b(Context context, int i) {
                        int a = C0297at.m1066a(context, C0059a.C0060a.colorControlHighlight);
                        int c = C0297at.m1070c(context, C0059a.C0060a.colorButtonNormal);
                        return new ColorStateList(new int[][]{C0297at.f1074a, C0297at.f1077d, C0297at.f1075b, C0297at.f1081h}, new int[]{c, C0589a.m2270a(a, i), C0589a.m2270a(a, i), i});
                    }

                    /* renamed from: c */
                    private ColorStateList m1254c(Context context) {
                        return m1253b(context, C0297at.m1066a(context, C0059a.C0060a.colorAccent));
                    }

                    /* renamed from: d */
                    private ColorStateList m1255d(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList b = C0297at.m1069b(context, C0059a.C0060a.colorSwitchThumbNormal);
                        if (b == null || !b.isStateful()) {
                            iArr[0] = C0297at.f1074a;
                            iArr2[0] = C0297at.m1070c(context, C0059a.C0060a.colorSwitchThumbNormal);
                            iArr[1] = C0297at.f1078e;
                            iArr2[1] = C0297at.m1066a(context, C0059a.C0060a.colorControlActivated);
                            iArr[2] = C0297at.f1081h;
                            iArr2[2] = C0297at.m1066a(context, C0059a.C0060a.colorSwitchThumbNormal);
                        } else {
                            iArr[0] = C0297at.f1074a;
                            iArr2[0] = b.getColorForState(iArr[0], 0);
                            iArr[1] = C0297at.f1078e;
                            iArr2[1] = C0297at.m1066a(context, C0059a.C0060a.colorControlActivated);
                            iArr[2] = C0297at.f1081h;
                            iArr2[2] = b.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    /* renamed from: a */
                    public ColorStateList mo2251a(Context context, int i) {
                        if (i == C0059a.C0064e.abc_edit_text_material) {
                            return C0070a.m60a(context, C0059a.C0062c.abc_tint_edittext);
                        }
                        if (i == C0059a.C0064e.abc_switch_track_mtrl_alpha) {
                            return C0070a.m60a(context, C0059a.C0062c.abc_tint_switch_track);
                        }
                        if (i == C0059a.C0064e.abc_switch_thumb_material) {
                            return m1255d(context);
                        }
                        if (i == C0059a.C0064e.abc_btn_default_mtrl_shape) {
                            return m1249a(context);
                        }
                        if (i == C0059a.C0064e.abc_btn_borderless_material) {
                            return m1252b(context);
                        }
                        if (i == C0059a.C0064e.abc_btn_colored_material) {
                            return m1254c(context);
                        }
                        if (i == C0059a.C0064e.abc_spinner_mtrl_am_alpha || i == C0059a.C0064e.abc_spinner_textfield_background_material) {
                            return C0070a.m60a(context, C0059a.C0062c.abc_tint_spinner);
                        }
                        if (m1251a(this.f1216b, i)) {
                            return C0297at.m1069b(context, C0059a.C0060a.colorControlNormal);
                        }
                        if (m1251a(this.f1219e, i)) {
                            return C0070a.m60a(context, C0059a.C0062c.abc_tint_default);
                        }
                        if (m1251a(this.f1220f, i)) {
                            return C0070a.m60a(context, C0059a.C0062c.abc_tint_btn_checkable);
                        }
                        if (i == C0059a.C0064e.abc_seekbar_thumb_material) {
                            return C0070a.m60a(context, C0059a.C0062c.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    /* renamed from: a */
                    public PorterDuff.Mode mo2252a(int i) {
                        if (i == C0059a.C0064e.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    /* renamed from: a */
                    public Drawable mo2253a(C0279an anVar, Context context, int i) {
                        if (i != C0059a.C0064e.abc_cab_background_top_material) {
                            return null;
                        }
                        return new LayerDrawable(new Drawable[]{anVar.mo2241a(context, C0059a.C0064e.abc_cab_background_internal_bg), anVar.mo2241a(context, C0059a.C0064e.abc_cab_background_top_mtrl_alpha)});
                    }

                    /* renamed from: a */
                    public boolean mo2254a(Context context, int i, Drawable drawable) {
                        LayerDrawable layerDrawable;
                        Drawable findDrawableByLayerId;
                        int i2;
                        if (i == C0059a.C0064e.abc_seekbar_track_material) {
                            layerDrawable = (LayerDrawable) drawable;
                            m1250a(layerDrawable.findDrawableByLayerId(16908288), C0297at.m1066a(context, C0059a.C0060a.colorControlNormal), C0337k.f1212a);
                            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                            i2 = C0059a.C0060a.colorControlNormal;
                        } else if (i != C0059a.C0064e.abc_ratingbar_material && i != C0059a.C0064e.abc_ratingbar_indicator_material && i != C0059a.C0064e.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            layerDrawable = (LayerDrawable) drawable;
                            m1250a(layerDrawable.findDrawableByLayerId(16908288), C0297at.m1070c(context, C0059a.C0060a.colorControlNormal), C0337k.f1212a);
                            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                            i2 = C0059a.C0060a.colorControlActivated;
                        }
                        m1250a(findDrawableByLayerId, C0297at.m1066a(context, i2), C0337k.f1212a);
                        m1250a(layerDrawable.findDrawableByLayerId(16908301), C0297at.m1066a(context, C0059a.C0060a.colorControlActivated), C0337k.f1212a);
                        return true;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066 A[RETURN] */
                    /* renamed from: b */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean mo2255b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0337k.f1212a
                            int[] r1 = r6.f1215a
                            boolean r1 = r6.m1251a((int[]) r1, (int) r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0018
                            int r2 = androidx.appcompat.C0059a.C0060a.colorControlNormal
                        L_0x0014:
                            r1 = r0
                            r8 = 1
                            r0 = -1
                            goto L_0x0049
                        L_0x0018:
                            int[] r1 = r6.f1217c
                            boolean r1 = r6.m1251a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x0023
                            int r2 = androidx.appcompat.C0059a.C0060a.colorControlActivated
                            goto L_0x0014
                        L_0x0023:
                            int[] r1 = r6.f1218d
                            boolean r1 = r6.m1251a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x002e
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L_0x0014
                        L_0x002e:
                            int r1 = androidx.appcompat.C0059a.C0064e.abc_list_divider_mtrl_alpha
                            if (r8 != r1) goto L_0x0040
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = r0
                            r0 = r8
                            r8 = 1
                            goto L_0x0049
                        L_0x0040:
                            int r1 = androidx.appcompat.C0059a.C0064e.abc_dialog_material_background
                            if (r8 != r1) goto L_0x0045
                            goto L_0x0014
                        L_0x0045:
                            r1 = r0
                            r8 = 0
                            r0 = -1
                            r2 = 0
                        L_0x0049:
                            if (r8 == 0) goto L_0x0066
                            boolean r8 = androidx.appcompat.widget.C0257af.m917c(r9)
                            if (r8 == 0) goto L_0x0055
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x0055:
                            int r7 = androidx.appcompat.widget.C0297at.m1066a(r7, r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.C0337k.m1240a((int) r7, (android.graphics.PorterDuff.Mode) r1)
                            r9.setColorFilter(r7)
                            if (r0 == r3) goto L_0x0065
                            r9.setAlpha(r0)
                        L_0x0065:
                            return r5
                        L_0x0066:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0337k.C03381.mo2255b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }
                });
            }
        }
    }

    /* renamed from: a */
    static void m1242a(Drawable drawable, C0300aw awVar, int[] iArr) {
        C0279an.m996a(drawable, awVar, iArr);
    }

    /* renamed from: b */
    public static synchronized C0337k m1243b() {
        C0337k kVar;
        synchronized (C0337k.class) {
            if (f1213b == null) {
                m1241a();
            }
            kVar = f1213b;
        }
        return kVar;
    }

    /* renamed from: a */
    public synchronized Drawable mo2550a(Context context, int i) {
        return this.f1214c.mo2241a(context, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Drawable mo2551a(Context context, int i, boolean z) {
        return this.f1214c.mo2242a(context, i, z);
    }

    /* renamed from: a */
    public synchronized void mo2552a(Context context) {
        this.f1214c.mo2244a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized ColorStateList mo2553b(Context context, int i) {
        return this.f1214c.mo2247b(context, i);
    }
}
