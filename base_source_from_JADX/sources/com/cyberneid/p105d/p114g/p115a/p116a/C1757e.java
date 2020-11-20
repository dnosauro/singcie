package com.cyberneid.p105d.p114g.p115a.p116a;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p114g.p115a.C1762e;
import com.cyberneid.p105d.p114g.p115a.p116a.p117a.C1726d;
import com.cyberneid.p105d.p114g.p115a.p116a.p117a.C1727e;
import com.cyberneid.p105d.p114g.p115a.p116a.p117a.C1728f;
import com.cyberneid.p105d.p114g.p115a.p116a.p117a.C1730h;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.d.g.a.a.e */
public class C1757e extends C1690a {

    /* renamed from: a */
    private static final C1730h f5727a = new C1730h();

    /* renamed from: b */
    private final C1727e f5728b = C1728f.m6971a((CharSequence) new String(mo7889c().mo7961g(), LocalizedMessage.DEFAULT_ENCODING));

    public C1757e(C1605b bVar) {
        super(bVar);
    }

    /* renamed from: a */
    public int mo7883a() {
        return 4;
    }

    /* renamed from: a */
    public float[] mo7885a(float[] fArr) {
        C1726d dVar = new C1726d(f5727a);
        for (int i = 0; i < fArr.length; i++) {
            C1762e b = mo7887b(i);
            dVar.mo7897a().push(Float.valueOf(mo7881a(fArr[i], b.mo7939a(), b.mo7940b())));
        }
        this.f5728b.mo7904a(dVar);
        int e = mo7890e();
        int size = dVar.mo7897a().size();
        if (size >= e) {
            float[] fArr2 = new float[e];
            for (int i2 = e - 1; i2 >= 0; i2--) {
                C1762e a = mo7884a(i2);
                fArr2[i2] = dVar.mo7901e();
                fArr2[i2] = mo7881a(fArr2[i2], a.mo7939a(), a.mo7940b());
            }
            return fArr2;
        }
        throw new IllegalStateException("The type 4 function returned " + size + " values but the Range entry indicates that " + e + " values be returned.");
    }
}
