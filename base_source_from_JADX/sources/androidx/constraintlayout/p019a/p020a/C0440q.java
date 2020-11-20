package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0442c;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.a.a.q */
public class C0440q extends C0425f {

    /* renamed from: az */
    protected ArrayList<C0425f> f1621az = new ArrayList<>();

    /* renamed from: D */
    public void mo3022D() {
        super.mo3022D();
        ArrayList<C0425f> arrayList = this.f1621az;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                C0425f fVar = this.f1621az.get(i);
                fVar.mo3043b(mo3089t(), mo3092u());
                if (!(fVar instanceof C0428g)) {
                    fVar.mo3022D();
                }
            }
        }
    }

    /* renamed from: N */
    public void mo3102N() {
        mo3022D();
        ArrayList<C0425f> arrayList = this.f1621az;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                C0425f fVar = this.f1621az.get(i);
                if (fVar instanceof C0440q) {
                    ((C0440q) fVar).mo3102N();
                }
            }
        }
    }

    /* renamed from: T */
    public C0428g mo3147T() {
        C0425f k = mo3071k();
        C0428g gVar = this instanceof C0428g ? (C0428g) this : null;
        while (k != null) {
            C0425f k2 = k.mo3071k();
            if (k instanceof C0428g) {
                gVar = (C0428g) k;
            }
            k = k2;
        }
        return gVar;
    }

    /* renamed from: U */
    public void mo3148U() {
        this.f1621az.clear();
    }

    /* renamed from: a */
    public void mo3038a(C0442c cVar) {
        super.mo3038a(cVar);
        int size = this.f1621az.size();
        for (int i = 0; i < size; i++) {
            this.f1621az.get(i).mo3038a(cVar);
        }
    }

    /* renamed from: b */
    public void mo3043b(int i, int i2) {
        super.mo3043b(i, i2);
        int size = this.f1621az.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1621az.get(i3).mo3043b(mo3093v(), mo3094w());
        }
    }

    /* renamed from: b */
    public void mo3149b(C0425f fVar) {
        this.f1621az.add(fVar);
        if (fVar.mo3071k() != null) {
            ((C0440q) fVar.mo3071k()).mo3150c(fVar);
        }
        fVar.mo3036a((C0425f) this);
    }

    /* renamed from: c */
    public void mo3150c(C0425f fVar) {
        this.f1621az.remove(fVar);
        fVar.mo3036a((C0425f) null);
    }

    /* renamed from: f */
    public void mo3062f() {
        this.f1621az.clear();
        super.mo3062f();
    }
}
