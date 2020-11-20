package com.github.barteksc.pdfviewer.p143d;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* renamed from: com.github.barteksc.pdfviewer.d.b */
public class C2174b {

    /* renamed from: a */
    private int f6738a;

    /* renamed from: b */
    private Bitmap f6739b;

    /* renamed from: c */
    private RectF f6740c;

    /* renamed from: d */
    private boolean f6741d;

    /* renamed from: e */
    private int f6742e;

    public C2174b(int i, Bitmap bitmap, RectF rectF, boolean z, int i2) {
        this.f6738a = i;
        this.f6739b = bitmap;
        this.f6740c = rectF;
        this.f6741d = z;
        this.f6742e = i2;
    }

    /* renamed from: a */
    public int mo9119a() {
        return this.f6742e;
    }

    /* renamed from: a */
    public void mo9120a(int i) {
        this.f6742e = i;
    }

    /* renamed from: b */
    public int mo9121b() {
        return this.f6738a;
    }

    /* renamed from: c */
    public Bitmap mo9122c() {
        return this.f6739b;
    }

    /* renamed from: d */
    public RectF mo9123d() {
        return this.f6740c;
    }

    /* renamed from: e */
    public boolean mo9124e() {
        return this.f6741d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2174b)) {
            return false;
        }
        C2174b bVar = (C2174b) obj;
        return bVar.mo9121b() == this.f6738a && bVar.mo9123d().left == this.f6740c.left && bVar.mo9123d().right == this.f6740c.right && bVar.mo9123d().top == this.f6740c.top && bVar.mo9123d().bottom == this.f6740c.bottom;
    }
}
