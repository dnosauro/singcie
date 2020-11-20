package com.cyberneid.p105d.p114g.p122e.p125c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p123a.C1839g;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import com.cyberneid.p105d.p114g.p122e.p123a.C1845m;
import java.io.ByteArrayInputStream;

/* renamed from: com.cyberneid.d.g.e.c.b */
public final class C1856b {

    /* renamed from: com.cyberneid.d.g.e.c.b$a */
    private static class C1858a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f6001a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f6002b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f6003c;

        private C1858a() {
        }
    }

    /* renamed from: a */
    private static C1858a m7697a(byte[] bArr) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        C1858a aVar = new C1858a();
        int unused = aVar.f6001a = decodeByteArray.getWidth();
        int unused2 = aVar.f6002b = decodeByteArray.getHeight();
        int unused3 = aVar.f6003c = decodeByteArray.getConfig() == Bitmap.Config.ARGB_8888 ? 4 : decodeByteArray.getConfig() == Bitmap.Config.ALPHA_8 ? 1 : 3;
        return aVar;
    }

    /* renamed from: a */
    public static C1861e m7698a(C1783c cVar, byte[] bArr) {
        C1838f fVar;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        C1858a a = m7697a(bArr);
        int a2 = a.f6003c;
        if (a2 != 1) {
            switch (a2) {
                case 3:
                    fVar = C1845m.f5975a;
                    break;
                case 4:
                    fVar = C1839g.f5961a;
                    break;
                default:
                    throw new UnsupportedOperationException("number of data elements not supported: " + a.f6003c);
            }
        } else {
            fVar = C1841i.f5963a;
        }
        C1838f fVar2 = fVar;
        C1861e eVar = new C1861e(cVar, byteArrayInputStream, C1613i.f5000bc, a.f6001a, a.f6002b, 8, fVar2);
        if (fVar2 instanceof C1839g) {
            C1604a aVar = new C1604a();
            aVar.mo7490a((C1605b) C1612h.f4887b);
            aVar.mo7490a((C1605b) C1612h.f4886a);
            aVar.mo7490a((C1605b) C1612h.f4887b);
            aVar.mo7490a((C1605b) C1612h.f4886a);
            aVar.mo7490a((C1605b) C1612h.f4887b);
            aVar.mo7490a((C1605b) C1612h.f4886a);
            aVar.mo7490a((C1605b) C1612h.f4887b);
            aVar.mo7490a((C1605b) C1612h.f4886a);
            eVar.mo8301a(aVar);
        }
        return eVar;
    }
}
