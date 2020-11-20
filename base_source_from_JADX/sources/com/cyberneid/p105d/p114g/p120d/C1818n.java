package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.n */
final class C1818n extends C1800ae {

    /* renamed from: c */
    private final C1783c f5878c;

    /* renamed from: d */
    private final C1607d f5879d;

    /* renamed from: e */
    private final C1607d f5880e;

    /* renamed from: f */
    private final Map<Integer, Integer> f5881f;

    /* renamed from: a */
    private void m7399a(String str) {
        String str2 = str + this.f5817b.mo8198g();
        this.f5879d.mo7523a(C1613i.f4900I, str2);
        this.f5817b.mo8178a(str2);
        this.f5880e.mo7523a(C1613i.f4900I, str2);
    }

    /* renamed from: b */
    private void m7400b(Map<Integer, Integer> map) {
        int i;
        C1799ad adVar = new C1799ad();
        int n = this.f5816a.mo7192m().mo7274n();
        boolean z = false;
        for (int i2 = 1; i2 <= n; i2++) {
            if (map == null) {
                i = i2;
            } else if (!map.containsKey(Integer.valueOf(i2))) {
            } else {
                i = map.get(Integer.valueOf(i2)).intValue();
            }
            Integer num = this.f5881f.get(Integer.valueOf(i));
            if (num != null) {
                if (num.intValue() > 65535) {
                    z = true;
                }
                adVar.mo8106a(i, new String(new int[]{num.intValue()}, 0, 1));
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        adVar.mo8107a((OutputStream) byteArrayOutputStream);
        C1764g gVar = new C1764g(this.f5878c, (InputStream) new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), C1613i.f5028cD);
        if (z && ((double) this.f5878c.mo8075m()) < 1.5d) {
            this.f5878c.mo8055a(1.5f);
        }
        this.f5879d.mo7522a(C1613i.f5327hl, (C1760c) gVar);
    }

    /* renamed from: c */
    private void m7401c(Map<Integer, Integer> map) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int intValue = ((Integer) Collections.max(map.keySet())).intValue();
        for (int i = 0; i <= intValue; i++) {
            int intValue2 = map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)).intValue() : 0;
            byteArrayOutputStream.write(new byte[]{(byte) ((intValue2 >> 8) & 255), (byte) (intValue2 & 255)});
        }
        C1764g gVar = new C1764g(this.f5878c, (InputStream) new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), C1613i.f5028cD);
        gVar.mo7959e().mo7518a(C1613i.f5096dS, gVar.mo7961g().length);
        this.f5880e.mo7522a(C1613i.f4968ax, (C1760c) gVar);
    }

    /* renamed from: d */
    private void m7402d(Map<Integer, Integer> map) {
        byte[] bArr = new byte[((((Integer) Collections.max(map.keySet())).intValue() / 8) + 1)];
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            int i = intValue2 / 8;
            bArr[i] = (byte) ((1 << (7 - (intValue2 % 8))) | bArr[i]);
        }
        this.f5817b.mo8182b(new C1764g(this.f5878c, (InputStream) new ByteArrayInputStream(bArr), C1613i.f5028cD));
    }

    /* renamed from: e */
    private void m7403e(Map<Integer, Integer> map) {
        float k = 1000.0f / ((float) this.f5816a.mo7193n().mo7232k());
        C1604a aVar = new C1604a();
        C1604a aVar2 = new C1604a();
        int i = -1;
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            if (map.containsKey(Integer.valueOf(intValue2))) {
                float a = ((float) this.f5816a.mo7195p().mo7255a(map.get(Integer.valueOf(intValue2)).intValue())) * k;
                if (i != intValue2 - 1) {
                    aVar2 = new C1604a();
                    aVar.mo7490a((C1605b) C1612h.m6455a((long) intValue2));
                    aVar.mo7490a((C1605b) aVar2);
                }
                aVar2.mo7490a((C1605b) C1612h.m6455a((long) Math.round(a)));
                i = intValue2;
            }
        }
        this.f5880e.mo7521a(C1613i.f5305hP, (C1605b) aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8112a(InputStream inputStream, String str, Map<Integer, Integer> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Integer) next.getValue()).intValue()), Integer.valueOf(((Integer) next.getKey()).intValue()));
        }
        mo8111a(inputStream);
        m7399a(str);
        m7403e(hashMap);
        m7401c(hashMap);
        m7402d(hashMap);
        m7400b(map);
    }
}
