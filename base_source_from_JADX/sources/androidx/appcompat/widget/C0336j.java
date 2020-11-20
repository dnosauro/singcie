package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.widget.C0681c;

/* renamed from: androidx.appcompat.widget.j */
class C0336j {

    /* renamed from: a */
    private final CompoundButton f1206a;

    /* renamed from: b */
    private ColorStateList f1207b = null;

    /* renamed from: c */
    private PorterDuff.Mode f1208c = null;

    /* renamed from: d */
    private boolean f1209d = false;

    /* renamed from: e */
    private boolean f1210e = false;

    /* renamed from: f */
    private boolean f1211f;

    C0336j(CompoundButton compoundButton) {
        this.f1206a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.C0681c.m2788b(r2.f1206a);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo2542a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f1206a
            android.graphics.drawable.Drawable r0 = androidx.core.widget.C0681c.m2788b(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0336j.mo2542a(int):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo2543a() {
        return this.f1207b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2544a(ColorStateList colorStateList) {
        this.f1207b = colorStateList;
        this.f1209d = true;
        mo2549d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2545a(PorterDuff.Mode mode) {
        this.f1208c = mode;
        this.f1210e = true;
        mo2549d();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[SYNTHETIC, Splitter:B:12:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[Catch:{ all -> 0x0080 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2546a(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f1206a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.C0059a.C0069j.CompoundButton
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.C0059a.C0069j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            int r5 = androidx.appcompat.C0059a.C0069j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            android.widget.CompoundButton r0 = r3.f1206a     // Catch:{ NotFoundException -> 0x002e }
            android.widget.CompoundButton r1 = r3.f1206a     // Catch:{ NotFoundException -> 0x002e }
            android.content.Context r1 = r1.getContext()     // Catch:{ NotFoundException -> 0x002e }
            android.graphics.drawable.Drawable r5 = androidx.appcompat.p009a.p010a.C0070a.m63b(r1, r5)     // Catch:{ NotFoundException -> 0x002e }
            r0.setButtonDrawable(r5)     // Catch:{ NotFoundException -> 0x002e }
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r5 != 0) goto L_0x0050
            int r5 = androidx.appcompat.C0059a.C0069j.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            int r5 = androidx.appcompat.C0059a.C0069j.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            android.widget.CompoundButton r0 = r3.f1206a     // Catch:{ all -> 0x0080 }
            android.widget.CompoundButton r1 = r3.f1206a     // Catch:{ all -> 0x0080 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0080 }
            android.graphics.drawable.Drawable r5 = androidx.appcompat.p009a.p010a.C0070a.m63b(r1, r5)     // Catch:{ all -> 0x0080 }
            r0.setButtonDrawable(r5)     // Catch:{ all -> 0x0080 }
        L_0x0050:
            int r5 = androidx.appcompat.C0059a.C0069j.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0063
            android.widget.CompoundButton r5 = r3.f1206a     // Catch:{ all -> 0x0080 }
            int r0 = androidx.appcompat.C0059a.C0069j.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            android.content.res.ColorStateList r0 = r4.getColorStateList(r0)     // Catch:{ all -> 0x0080 }
            androidx.core.widget.C0681c.m2786a((android.widget.CompoundButton) r5, (android.content.res.ColorStateList) r0)     // Catch:{ all -> 0x0080 }
        L_0x0063:
            int r5 = androidx.appcompat.C0059a.C0069j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x007c
            android.widget.CompoundButton r5 = r3.f1206a     // Catch:{ all -> 0x0080 }
            int r0 = androidx.appcompat.C0059a.C0069j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            r1 = -1
            int r0 = r4.getInt(r0, r1)     // Catch:{ all -> 0x0080 }
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0257af.m914a(r0, r1)     // Catch:{ all -> 0x0080 }
            androidx.core.widget.C0681c.m2787a((android.widget.CompoundButton) r5, (android.graphics.PorterDuff.Mode) r0)     // Catch:{ all -> 0x0080 }
        L_0x007c:
            r4.recycle()
            return
        L_0x0080:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0336j.mo2546a(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo2547b() {
        return this.f1208c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2548c() {
        if (this.f1211f) {
            this.f1211f = false;
            return;
        }
        this.f1211f = true;
        mo2549d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2549d() {
        Drawable b = C0681c.m2788b(this.f1206a);
        if (b == null) {
            return;
        }
        if (this.f1209d || this.f1210e) {
            Drawable mutate = C0595a.m2330g(b).mutate();
            if (this.f1209d) {
                C0595a.m2319a(mutate, this.f1207b);
            }
            if (this.f1210e) {
                C0595a.m2322a(mutate, this.f1208c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1206a.getDrawableState());
            }
            this.f1206a.setButtonDrawable(mutate);
        }
    }
}
