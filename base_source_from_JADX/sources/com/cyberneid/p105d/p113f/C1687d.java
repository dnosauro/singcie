package com.cyberneid.p105d.p113f;

import com.cyberneid.p105d.p106a.p107a.C1603a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1606c;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p131h.C1933a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.apache.commons.p172io.IOUtils;

/* renamed from: com.cyberneid.d.f.d */
public class C1687d {

    /* renamed from: a */
    public static final byte[] f5629a = {32};

    /* renamed from: b */
    public static final byte[] f5630b = {10};

    /* renamed from: c */
    private final OutputStream f5631c;

    public C1687d(OutputStream outputStream) {
        this.f5631c = outputStream;
    }

    /* renamed from: a */
    private void m6896a(Object obj) {
        OutputStream outputStream;
        byte[] bArr;
        if (obj instanceof C1622p) {
            C1685b.m6847a((C1622p) obj, this.f5631c);
        } else if (obj instanceof C1609f) {
            ((C1609f) obj).mo7584a(this.f5631c);
        } else if (obj instanceof C1612h) {
            ((C1612h) obj).mo7591a(this.f5631c);
        } else if (obj instanceof C1606c) {
            ((C1606c) obj).mo7507a(this.f5631c);
        } else if (obj instanceof C1613i) {
            ((C1613i) obj).mo7597a(this.f5631c);
        } else {
            if (obj instanceof C1604a) {
                C1604a aVar = (C1604a) obj;
                this.f5631c.write(C1685b.f5592p);
                for (int i = 0; i < aVar.mo7494b(); i++) {
                    m6896a((Object) aVar.mo7495b(i));
                    this.f5631c.write(f5629a);
                }
                outputStream = this.f5631c;
                bArr = C1685b.f5593q;
            } else if (obj instanceof C1607d) {
                this.f5631c.write(C1685b.f5577a);
                for (Map.Entry next : ((C1607d) obj).mo7546f()) {
                    if (next.getValue() != null) {
                        m6896a(next.getKey());
                        this.f5631c.write(f5629a);
                        m6896a(next.getValue());
                        this.f5631c.write(f5629a);
                    }
                }
                this.f5631c.write(C1685b.f5578b);
            } else if (obj instanceof C1603a) {
                C1603a aVar2 = (C1603a) obj;
                if (aVar2.mo7478a().equals("BI")) {
                    this.f5631c.write("BI".getBytes(C1933a.f6111d));
                    C1607d c = aVar2.mo7482c();
                    for (C1613i next2 : c.mo7540c()) {
                        C1605b c2 = c.mo7539c(next2);
                        next2.mo7597a(this.f5631c);
                        this.f5631c.write(f5629a);
                        m6896a((Object) c2);
                        this.f5631c.write(f5630b);
                    }
                    this.f5631c.write("ID".getBytes(C1933a.f6111d));
                    this.f5631c.write(f5630b);
                    this.f5631c.write(aVar2.mo7481b());
                    this.f5631c.write(f5630b);
                    this.f5631c.write("EI".getBytes(C1933a.f6111d));
                } else {
                    this.f5631c.write(aVar2.mo7478a().getBytes(C1933a.f6111d));
                }
                outputStream = this.f5631c;
                bArr = f5630b;
            } else {
                throw new IOException("Error:Unknown type in content stream:" + obj);
            }
            outputStream.write(bArr);
        }
        outputStream = this.f5631c;
        bArr = f5629a;
        outputStream.write(bArr);
    }

    /* renamed from: a */
    public void mo7848a(List list) {
        for (Object a : list) {
            m6896a(a);
        }
    }

    /* renamed from: a */
    public void mo7849a(Object... objArr) {
        for (Object a : objArr) {
            m6896a(a);
        }
        this.f5631c.write(IOUtils.LINE_SEPARATOR_UNIX.getBytes(C1933a.f6108a));
    }
}
