package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.p019a.p020a.C0417b;
import androidx.constraintlayout.widget.C0462f;

/* renamed from: androidx.constraintlayout.widget.a */
public class C0454a extends C0455b {

    /* renamed from: f */
    private int f1787f;

    /* renamed from: g */
    private int f1788g;

    /* renamed from: h */
    private C0417b f1789h;

    public C0454a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3249a(AttributeSet attributeSet) {
        super.mo3249a(attributeSet);
        this.f1789h = new C0417b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0462f.C0464b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0462f.C0464b.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == C0462f.C0464b.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f1789h.mo2998a(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1793d = this.f1789h;
        mo3253a();
    }

    public int getType() {
        return this.f1787f;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f1789h.mo2998a(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r6 == 6) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r6 == 6) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r6 == 6) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setType(int r6) {
        /*
            r5 = this;
            r5.f1787f = r6
            r5.f1788g = r6
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 6
            r1 = 5
            r2 = 0
            r3 = 1
            r4 = 17
            if (r6 >= r4) goto L_0x001a
            int r6 = r5.f1787f
            if (r6 != r1) goto L_0x0015
        L_0x0012:
            r5.f1788g = r2
            goto L_0x003d
        L_0x0015:
            if (r6 != r0) goto L_0x003d
        L_0x0017:
            r5.f1788g = r3
            goto L_0x003d
        L_0x001a:
            android.content.res.Resources r6 = r5.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.getLayoutDirection()
            if (r3 != r6) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            if (r6 == 0) goto L_0x0035
            int r6 = r5.f1787f
            if (r6 != r1) goto L_0x0032
            goto L_0x0017
        L_0x0032:
            if (r6 != r0) goto L_0x003d
            goto L_0x0012
        L_0x0035:
            int r6 = r5.f1787f
            if (r6 != r1) goto L_0x003a
            goto L_0x0012
        L_0x003a:
            if (r6 != r0) goto L_0x003d
            goto L_0x0017
        L_0x003d:
            androidx.constraintlayout.a.a.b r6 = r5.f1789h
            int r0 = r5.f1788g
            r6.mo2996a((int) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.C0454a.setType(int):void");
    }
}
