package com.cyberneid.p105d.p112e;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1619o;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.d.e.e */
public class C1670e extends C1666a {

    /* renamed from: c */
    private List<C1616l> f5539c = null;

    /* renamed from: d */
    private final C1619o f5540d;

    public C1670e(C1619o oVar, C1608e eVar) {
        super(new C1669d(oVar.mo7627l()));
        this.f5511b = eVar;
        this.f5540d = oVar;
    }

    /* renamed from: r */
    public void mo7778r() {
        try {
            int b = this.f5540d.mo7530b("N");
            ArrayList arrayList = new ArrayList(b);
            this.f5539c = new ArrayList(b);
            for (int i = 0; i < b; i++) {
                mo7766p();
                arrayList.add(Long.valueOf((long) mo7763m()));
            }
            int i2 = 0;
            while (true) {
                C1605b f = mo7756f();
                if (f == null) {
                    break;
                }
                C1616l lVar = new C1616l(f);
                lVar.mo7605a(0);
                if (i2 >= arrayList.size()) {
                    Log.e("PdfBox-Android", "/ObjStm (object stream) has more objects than /N " + b);
                    break;
                }
                lVar.mo7606a(((Long) arrayList.get(i2)).longValue());
                this.f5539c.add(lVar);
                if (!this.f5510a.mo7797d() && this.f5510a.mo7795c() == 101) {
                    mo7758h();
                }
                i2++;
            }
        } finally {
            this.f5510a.close();
        }
    }

    /* renamed from: s */
    public List<C1616l> mo7779s() {
        return this.f5539c;
    }
}
