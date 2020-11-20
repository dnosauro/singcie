package com.cyberneid.p105d.p112e;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1617m;
import com.cyberneid.p105d.p108b.C1619o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.cyberneid.d.e.i */
public class C1677i extends C1666a {

    /* renamed from: c */
    private final C1619o f5559c;

    /* renamed from: d */
    private final C1680l f5560d;

    public C1677i(C1619o oVar, C1608e eVar, C1680l lVar) {
        super(new C1669d(oVar.mo7627l()));
        this.f5511b = eVar;
        this.f5559c = oVar;
        this.f5560d = lVar;
    }

    /* renamed from: r */
    public void mo7778r() {
        C1617m mVar;
        C1680l lVar;
        long j;
        C1605b c = this.f5559c.mo7539c(C1613i.f5305hP);
        if (c instanceof C1604a) {
            C1604a aVar = (C1604a) c;
            C1604a aVar2 = (C1604a) this.f5559c.mo7539c(C1613i.f5122ds);
            if (aVar2 == null) {
                aVar2 = new C1604a();
                aVar2.mo7490a((C1605b) C1612h.f4886a);
                aVar2.mo7490a(this.f5559c.mo7539c(C1613i.f5288gz));
            }
            ArrayList arrayList = new ArrayList();
            Iterator<C1605b> it = aVar2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                long b = ((C1612h) it.next()).mo7585b();
                int c2 = ((C1612h) it.next()).mo7586c();
                for (int i = 0; i < c2; i++) {
                    arrayList.add(Long.valueOf(((long) i) + b));
                }
            }
            Iterator it2 = arrayList.iterator();
            int c3 = aVar.mo7498c(0);
            int c4 = aVar.mo7498c(1);
            int c5 = aVar.mo7498c(2);
            int i2 = c3 + c4 + c5;
            while (!this.f5510a.mo7797d() && it2.hasNext()) {
                byte[] bArr = new byte[i2];
                this.f5510a.mo7789a(bArr);
                int i3 = 0;
                for (int i4 = 0; i4 < c3; i4++) {
                    i3 += (bArr[i4] & 255) << (((c3 - i4) - 1) * 8);
                }
                Long l = (Long) it2.next();
                switch (i3) {
                    case 1:
                        int i5 = 0;
                        for (int i6 = 0; i6 < c4; i6++) {
                            i5 += (bArr[i6 + c3] & 255) << (((c4 - i6) - 1) * 8);
                        }
                        int i7 = 0;
                        for (int i8 = 0; i8 < c5; i8++) {
                            i7 += (bArr[(i8 + c3) + c4] & 255) << (((c5 - i8) - 1) * 8);
                        }
                        mVar = new C1617m(l.longValue(), i7);
                        lVar = this.f5560d;
                        j = (long) i5;
                        break;
                    case 2:
                        int i9 = 0;
                        for (int i10 = 0; i10 < c4; i10++) {
                            i9 += (bArr[i10 + c3] & 255) << (((c4 - i10) - 1) * 8);
                        }
                        mVar = new C1617m(l.longValue(), 0);
                        lVar = this.f5560d;
                        j = (long) (-i9);
                        break;
                }
                lVar.mo7812a(mVar, j);
            }
            return;
        }
        throw new IOException("/W array is missing in Xref stream");
    }
}
