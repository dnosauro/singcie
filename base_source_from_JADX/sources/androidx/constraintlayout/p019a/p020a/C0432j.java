package androidx.constraintlayout.p019a.p020a;

import java.util.Arrays;

/* renamed from: androidx.constraintlayout.a.a.j */
public class C0432j extends C0425f {

    /* renamed from: ai */
    protected C0425f[] f1592ai = new C0425f[4];

    /* renamed from: aj */
    protected int f1593aj = 0;

    /* renamed from: J */
    public void mo3098J() {
        this.f1593aj = 0;
    }

    /* renamed from: b */
    public void mo3122b(C0425f fVar) {
        int i = this.f1593aj + 1;
        C0425f[] fVarArr = this.f1592ai;
        if (i > fVarArr.length) {
            this.f1592ai = (C0425f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
        }
        C0425f[] fVarArr2 = this.f1592ai;
        int i2 = this.f1593aj;
        fVarArr2[i2] = fVar;
        this.f1593aj = i2 + 1;
    }
}
