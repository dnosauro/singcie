package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p105d.p131h.C1933a;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.cyberneid.d.g.d.ad */
final class C1799ad {

    /* renamed from: a */
    private final Map<Integer, String> f5814a = new TreeMap();

    /* renamed from: b */
    private int f5815b = 0;

    C1799ad() {
    }

    /* renamed from: a */
    private String m7283a(int i) {
        return String.format("%04X", new Object[]{Integer.valueOf(i)});
    }

    /* renamed from: a */
    private String m7284a(String str) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes(C1933a.f6109b);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", new Object[]{Byte.valueOf(bytes[i])}));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m7285a(BufferedWriter bufferedWriter, String str) {
        bufferedWriter.write(str);
        bufferedWriter.write(10);
    }

    /* renamed from: a */
    public void mo8106a(int i, String str) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("CID is not valid");
        } else if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Text is null or empty");
        } else {
            this.f5814a.put(Integer.valueOf(i), str);
        }
    }

    /* renamed from: a */
    public void mo8107a(OutputStream outputStream) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C1933a.f6108a));
        m7285a(bufferedWriter, "/CIDInit /ProcSet findresource begin");
        m7285a(bufferedWriter, "12 dict begin\n");
        m7285a(bufferedWriter, "begincmap");
        m7285a(bufferedWriter, "/CIDSystemInfo");
        m7285a(bufferedWriter, "<< /Registry ()");
        m7285a(bufferedWriter, "/Ordering ()");
        m7285a(bufferedWriter, "/Supplement ");
        m7285a(bufferedWriter, ">> def\n");
        m7285a(bufferedWriter, "/CMapName /Adobe-Identity-UCS def");
        m7285a(bufferedWriter, "/CMapType 2 def\n");
        if (this.f5815b != 0) {
            m7285a(bufferedWriter, "/WMode /" + this.f5815b + " def");
        }
        m7285a(bufferedWriter, "1 begincodespacerange");
        m7285a(bufferedWriter, "<0000> <FFFF>");
        m7285a(bufferedWriter, "endcodespacerange\n");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String str = null;
        int i = -1;
        int i2 = -1;
        for (Map.Entry next : this.f5814a.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            String str2 = (String) next.getValue();
            if (intValue == i + 1 && str.codePointCount(0, str.length()) == 1 && str2.codePointAt(0) == str.codePointAt(0) + 1 && str.codePointAt(0) + 1 <= 255 - (intValue - i2)) {
                arrayList2.set(arrayList2.size() - 1, Integer.valueOf(intValue));
            } else {
                arrayList.add(Integer.valueOf(intValue));
                arrayList2.add(Integer.valueOf(intValue));
                arrayList3.add(str2);
                i2 = intValue;
            }
            str = str2;
            i = intValue;
        }
        int ceil = (int) Math.ceil(((double) arrayList.size()) / 100.0d);
        for (int i3 = 0; i3 < ceil; i3++) {
            int i4 = 100;
            if (i3 == ceil - 1) {
                i4 = arrayList.size() % 100;
            }
            bufferedWriter.write(i4 + " beginbfrange\n");
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i3 * 100) + i5;
                bufferedWriter.write(60);
                bufferedWriter.write(m7283a(((Integer) arrayList.get(i6)).intValue()));
                bufferedWriter.write("> ");
                bufferedWriter.write(60);
                bufferedWriter.write(m7283a(((Integer) arrayList2.get(i6)).intValue()));
                bufferedWriter.write("> ");
                bufferedWriter.write("<");
                bufferedWriter.write(m7284a((String) arrayList3.get(i6)));
                bufferedWriter.write(">\n");
            }
            m7285a(bufferedWriter, "endbfrange\n");
        }
        m7285a(bufferedWriter, "endcmap");
        m7285a(bufferedWriter, "CMapName currentdict /CMap defineresource pop");
        m7285a(bufferedWriter, "end");
        m7285a(bufferedWriter, "end");
        bufferedWriter.flush();
    }
}
