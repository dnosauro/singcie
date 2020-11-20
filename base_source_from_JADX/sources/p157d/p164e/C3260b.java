package p157d.p164e;

import java.util.NoSuchElementException;
import p157d.p158a.C3206v;

/* renamed from: d.e.b */
public final class C3260b extends C3206v {

    /* renamed from: a */
    private final int f7312a;

    /* renamed from: b */
    private boolean f7313b;

    /* renamed from: c */
    private int f7314c;

    /* renamed from: d */
    private final int f7315d;

    public C3260b(int i, int i2, int i3) {
        this.f7315d = i3;
        this.f7312a = i2;
        boolean z = true;
        if (this.f7315d <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f7313b = z;
        this.f7314c = !this.f7313b ? this.f7312a : i;
    }

    /* renamed from: b */
    public int mo25674b() {
        int i = this.f7314c;
        if (i != this.f7312a) {
            this.f7314c = this.f7315d + i;
        } else if (this.f7313b) {
            this.f7313b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }

    public boolean hasNext() {
        return this.f7313b;
    }
}
