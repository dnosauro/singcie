package com.github.barteksc.pdfviewer.p146g;

import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

/* renamed from: com.github.barteksc.pdfviewer.g.d */
public class C2194d {

    /* renamed from: a */
    private C2192b f6807a;

    /* renamed from: b */
    private final Size f6808b;

    /* renamed from: c */
    private final Size f6809c;

    /* renamed from: d */
    private final Size f6810d;

    /* renamed from: e */
    private SizeF f6811e;

    /* renamed from: f */
    private SizeF f6812f;

    /* renamed from: g */
    private float f6813g;

    /* renamed from: h */
    private float f6814h;

    /* renamed from: i */
    private boolean f6815i;

    public C2194d(C2192b bVar, Size size, Size size2, Size size3, boolean z) {
        this.f6807a = bVar;
        this.f6808b = size;
        this.f6809c = size2;
        this.f6810d = size3;
        this.f6815i = z;
        m8622c();
    }

    /* renamed from: a */
    private SizeF m8619a(Size size, float f) {
        return new SizeF(f, (float) Math.floor((double) (f / (((float) size.mo24001a()) / ((float) size.mo24002b())))));
    }

    /* renamed from: a */
    private SizeF m8620a(Size size, float f, float f2) {
        float a = ((float) size.mo24001a()) / ((float) size.mo24002b());
        float floor = (float) Math.floor((double) (f / a));
        if (floor > f2) {
            f = (float) Math.floor((double) (a * f2));
            floor = f2;
        }
        return new SizeF(f, floor);
    }

    /* renamed from: b */
    private SizeF m8621b(Size size, float f) {
        return new SizeF((float) Math.floor((double) (f / (((float) size.mo24002b()) / ((float) size.mo24001a())))), f);
    }

    /* renamed from: c */
    private void m8622c() {
        switch (this.f6807a) {
            case HEIGHT:
                this.f6812f = m8621b(this.f6809c, (float) this.f6810d.mo24002b());
                this.f6814h = this.f6812f.mo24007b() / ((float) this.f6809c.mo24002b());
                Size size = this.f6808b;
                this.f6811e = m8621b(size, ((float) size.mo24002b()) * this.f6814h);
                return;
            case BOTH:
                float a = m8620a(this.f6808b, (float) this.f6810d.mo24001a(), (float) this.f6810d.mo24002b()).mo24006a() / ((float) this.f6808b.mo24001a());
                Size size2 = this.f6809c;
                this.f6812f = m8620a(size2, ((float) size2.mo24001a()) * a, (float) this.f6810d.mo24002b());
                this.f6814h = this.f6812f.mo24007b() / ((float) this.f6809c.mo24002b());
                this.f6811e = m8620a(this.f6808b, (float) this.f6810d.mo24001a(), ((float) this.f6808b.mo24002b()) * this.f6814h);
                this.f6813g = this.f6811e.mo24006a() / ((float) this.f6808b.mo24001a());
                return;
            default:
                this.f6811e = m8619a(this.f6808b, (float) this.f6810d.mo24001a());
                this.f6813g = this.f6811e.mo24006a() / ((float) this.f6808b.mo24001a());
                Size size3 = this.f6809c;
                this.f6812f = m8619a(size3, ((float) size3.mo24001a()) * this.f6813g);
                return;
        }
    }

    /* renamed from: a */
    public SizeF mo9166a() {
        return this.f6811e;
    }

    /* renamed from: a */
    public SizeF mo9167a(Size size) {
        if (size.mo24001a() <= 0 || size.mo24002b() <= 0) {
            return new SizeF(0.0f, 0.0f);
        }
        float a = this.f6815i ? (float) this.f6810d.mo24001a() : ((float) size.mo24001a()) * this.f6813g;
        float b = this.f6815i ? (float) this.f6810d.mo24002b() : ((float) size.mo24002b()) * this.f6814h;
        switch (this.f6807a) {
            case HEIGHT:
                return m8621b(size, b);
            case BOTH:
                return m8620a(size, a, b);
            default:
                return m8619a(size, a);
        }
    }

    /* renamed from: b */
    public SizeF mo9168b() {
        return this.f6812f;
    }
}
