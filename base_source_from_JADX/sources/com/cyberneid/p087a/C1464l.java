package com.cyberneid.p087a;

import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p126f.p129c.C1896c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/* renamed from: com.cyberneid.a.l */
public class C1464l {

    /* renamed from: a */
    C1783c f4348a;

    /* renamed from: b */
    private List<C1896c> f4349b;

    /* renamed from: c */
    private byte[] f4350c;

    /* renamed from: a */
    public int mo6939a() {
        return this.f4349b.size();
    }

    /* renamed from: a */
    public int mo6940a(byte[] bArr) {
        this.f4350c = bArr;
        this.f4348a = C1783c.m7200a(bArr);
        this.f4349b = this.f4348a.mo8068f();
        return this.f4349b.size();
    }

    /* renamed from: a */
    public C1451a mo6941a(int i) {
        C1896c cVar = this.f4349b.get(i);
        C1451a a = C1451a.m5469a(((C1622p) cVar.mo7505d().mo7539c(C1613i.f4934aP)).mo7643c());
        new ByteArrayOutputStream();
        cVar.mo8375b();
        try {
            byte[] b = cVar.mo8374b(this.f4350c);
            C1459h hVar = new C1459h(a);
            hVar.mo6922a(b);
            return C1451a.m5469a(hVar.mo6923a());
        } catch (IOException e) {
            e.printStackTrace();
            throw new C1458g(-2130706266);
        }
    }
}
