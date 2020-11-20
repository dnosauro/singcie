package com.cyberneid.p089b.p092c;

import com.cyberneid.p105d.p131h.C1941e;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.c.c */
public class C1533c {

    /* renamed from: a */
    private final byte[] f4556a = new byte[512];

    /* renamed from: com.cyberneid.b.c.c$a */
    private final class C1535a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f4558b;

        private C1535a(String str) {
            this.f4558b = str;
        }
    }

    /* renamed from: com.cyberneid.b.c.c$b */
    private final class C1536b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f4560b;

        private C1536b(String str) {
            this.f4560b = str;
        }
    }

    /* renamed from: a */
    private int m5895a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return (bArr[i] + 256) % 256 < (bArr2[i] + 256) % 256 ? -1 : 1;
            }
        }
        return 1;
    }

    /* renamed from: a */
    private Object m5896a(PushbackInputStream pushbackInputStream) {
        int read;
        int i;
        Object obj;
        int read2;
        int read3;
        while (true) {
            read = pushbackInputStream.read();
            if (read != 9 && read != 32 && read != 13 && read != 10) {
                break;
            }
        }
        if (read == -1) {
            return null;
        }
        if (read == 37) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char) read);
            m5897a((InputStream) pushbackInputStream, stringBuffer);
            return stringBuffer.toString();
        } else if (read == 40) {
            StringBuffer stringBuffer2 = new StringBuffer();
            while (true) {
                int read4 = pushbackInputStream.read();
                if (read4 != -1 && read4 != 41) {
                    stringBuffer2.append((char) read4);
                }
            }
            return stringBuffer2.toString();
        } else if (read == 60) {
            int read5 = pushbackInputStream.read();
            if (read5 == 60) {
                HashMap hashMap = new HashMap();
                Object a = m5896a(pushbackInputStream);
                while ((a instanceof C1535a) && a != ">>") {
                    hashMap.put(((C1535a) a).f4558b, m5896a(pushbackInputStream));
                    a = m5896a(pushbackInputStream);
                }
                return hashMap;
            }
            int i2 = -1;
            int i3 = 16;
            while (read5 != -1 && read5 != 62) {
                if (read5 < 48 || read5 > 57) {
                    int i4 = 65;
                    if (read5 < 65 || read5 > 70) {
                        i4 = 97;
                        if (read5 < 97 || read5 > 102) {
                            if (m5902a(read5)) {
                                read5 = pushbackInputStream.read();
                            } else {
                                throw new IOException("Error: expected hex character and not " + ((char) read5) + ":" + read5);
                            }
                        }
                    }
                    i = (read5 + 10) - i4;
                } else {
                    i = read5 - 48;
                }
                int i5 = i * i3;
                if (i3 == 16) {
                    i2++;
                    this.f4556a[i2] = 0;
                    i3 = 1;
                } else {
                    i3 = 16;
                }
                byte[] bArr = this.f4556a;
                bArr[i2] = (byte) (bArr[i2] + i5);
                read5 = pushbackInputStream.read();
            }
            int i6 = i2 + 1;
            byte[] bArr2 = new byte[i6];
            System.arraycopy(this.f4556a, 0, bArr2, 0, i6);
            return bArr2;
        } else if (read != 62) {
            if (read == 91) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    Object a2 = m5896a(pushbackInputStream);
                    if (a2 == null || a2 == "]") {
                        return arrayList;
                    }
                    arrayList.add(a2);
                }
            } else if (read == 93) {
                return "]";
            } else {
                switch (read) {
                    case 47:
                        StringBuffer stringBuffer3 = new StringBuffer();
                        while (true) {
                            read2 = pushbackInputStream.read();
                            if (!m5902a(read2) && !m5905b(read2)) {
                                stringBuffer3.append((char) read2);
                            }
                        }
                        if (m5905b(read2)) {
                            pushbackInputStream.unread(read2);
                        }
                        obj = new C1535a(stringBuffer3.toString());
                        break;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append((char) read);
                        while (true) {
                            read3 = pushbackInputStream.read();
                            if (!m5902a(read3)) {
                                char c = (char) read3;
                                if (Character.isDigit(c) || read3 == 46) {
                                    stringBuffer4.append(c);
                                }
                            }
                        }
                        pushbackInputStream.unread(read3);
                        String stringBuffer5 = stringBuffer4.toString();
                        return stringBuffer5.indexOf(46) >= 0 ? new Double(stringBuffer5) : new Integer(stringBuffer5);
                    default:
                        StringBuffer stringBuffer6 = new StringBuffer();
                        do {
                            stringBuffer6.append((char) read);
                            read = pushbackInputStream.read();
                            if (m5902a(read) || m5905b(read) || Character.isDigit(read)) {
                                if (m5905b(read) || Character.isDigit(read)) {
                                    pushbackInputStream.unread(read);
                                }
                                obj = new C1536b(stringBuffer6.toString());
                                break;
                            }
                            stringBuffer6.append((char) read);
                            read = pushbackInputStream.read();
                            pushbackInputStream.unread(read);
                            obj = new C1536b(stringBuffer6.toString());
                        } while (Character.isDigit(read));
                        pushbackInputStream.unread(read);
                        obj = new C1536b(stringBuffer6.toString());
                }
                return obj;
            }
        } else if (pushbackInputStream.read() == 62) {
            return ">>";
        } else {
            throw new IOException("Error: expected the end of a dictionary.");
        }
    }

    /* renamed from: a */
    private void m5897a(InputStream inputStream, StringBuffer stringBuffer) {
        while (true) {
            int read = inputStream.read();
            if (read != -1 && read != 13 && read != 10) {
                stringBuffer.append((char) read);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m5898a(Object obj, C1532b bVar) {
        bVar.mo7145a(mo7162a(mo7164b(((C1535a) obj).f4558b)));
    }

    /* renamed from: a */
    private void m5899a(Object obj, PushbackInputStream pushbackInputStream, C1532b bVar) {
        String str;
        C1535a aVar = (C1535a) obj;
        if ("WMode".equals(aVar.f4558b)) {
            Object a = m5896a(pushbackInputStream);
            if (a instanceof Integer) {
                bVar.mo7154c(((Integer) a).intValue());
            }
        } else if ("CMapName".equals(aVar.f4558b)) {
            Object a2 = m5896a(pushbackInputStream);
            if (a2 instanceof C1535a) {
                bVar.mo7147a(((C1535a) a2).f4558b);
            }
        } else if ("CMapVersion".equals(aVar.f4558b)) {
            Object a3 = m5896a(pushbackInputStream);
            if (a3 instanceof Number) {
                str = a3.toString();
            } else if (a3 instanceof String) {
                str = (String) a3;
            } else {
                return;
            }
            bVar.mo7151b(str);
        } else if ("CMapType".equals(aVar.f4558b)) {
            Object a4 = m5896a(pushbackInputStream);
            if (a4 instanceof Integer) {
                bVar.mo7157d(((Integer) a4).intValue());
            }
        } else if ("Registry".equals(aVar.f4558b)) {
            Object a5 = m5896a(pushbackInputStream);
            if (a5 instanceof String) {
                bVar.mo7155c((String) a5);
            }
        } else if ("Ordering".equals(aVar.f4558b)) {
            Object a6 = m5896a(pushbackInputStream);
            if (a6 instanceof String) {
                bVar.mo7158d((String) a6);
            }
        } else if ("Supplement".equals(aVar.f4558b)) {
            Object a7 = m5896a(pushbackInputStream);
            if (a7 instanceof Integer) {
                bVar.mo7160e(((Integer) a7).intValue());
            }
        }
    }

    /* renamed from: a */
    private void m5900a(byte[] bArr) {
        m5901a(bArr, bArr.length - 1);
    }

    /* renamed from: a */
    private void m5901a(byte[] bArr, int i) {
        if (i <= 0 || (bArr[i] + 256) % 256 != 255) {
            bArr[i] = (byte) (bArr[i] + 1);
            return;
        }
        bArr[i] = 0;
        m5901a(bArr, i - 1);
    }

    /* renamed from: a */
    private boolean m5902a(int i) {
        return i == -1 || i == 32 || i == 13 || i == 10;
    }

    /* renamed from: b */
    private int m5903b(byte[] bArr) {
        int i = (bArr[0] + 256) % 256;
        return bArr.length == 2 ? (i << 8) + ((bArr[1] + 256) % 256) : i;
    }

    /* renamed from: b */
    private void m5904b(Object obj, PushbackInputStream pushbackInputStream, C1532b bVar) {
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object a = m5896a(pushbackInputStream);
            if (a instanceof C1536b) {
                C1536b bVar2 = (C1536b) a;
                if (!bVar2.f4560b.equals("endcodespacerange")) {
                    throw new IOException("Error : ~codespacerange contains an unexpected operator : " + bVar2.f4560b);
                }
                return;
            }
            C1537d dVar = new C1537d();
            dVar.mo7169b((byte[]) a);
            dVar.mo7165a((byte[]) m5896a(pushbackInputStream));
            bVar.mo7146a(dVar);
        }
    }

    /* renamed from: b */
    private boolean m5905b(int i) {
        if (i == 37 || i == 47 || i == 60 || i == 62 || i == 91 || i == 93 || i == 123 || i == 125) {
            return true;
        }
        switch (i) {
            case 40:
            case 41:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: c */
    private String m5906c(byte[] bArr) {
        return bArr.length == 1 ? new String(bArr, LocalizedMessage.DEFAULT_ENCODING) : new String(bArr, "UTF-16BE");
    }

    /* renamed from: c */
    private void m5907c(Object obj, PushbackInputStream pushbackInputStream, C1532b bVar) {
        String a;
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object a2 = m5896a(pushbackInputStream);
            if (a2 instanceof C1536b) {
                C1536b bVar2 = (C1536b) a2;
                if (!bVar2.f4560b.equals("endbfchar")) {
                    throw new IOException("Error : ~bfchar contains an unexpected operator : " + bVar2.f4560b);
                }
                return;
            }
            byte[] bArr = (byte[]) a2;
            Object a3 = m5896a(pushbackInputStream);
            if (a3 instanceof byte[]) {
                a = m5906c((byte[]) a3);
            } else if (a3 instanceof C1535a) {
                a = ((C1535a) a3).f4558b;
            } else {
                throw new IOException("Error parsing CMap beginbfchar, expected{COSString or COSName} and not " + a3);
            }
            bVar.mo7148a(bArr, a);
        }
    }

    /* renamed from: d */
    private void m5908d(Object obj, PushbackInputStream pushbackInputStream, C1532b bVar) {
        int intValue = ((Integer) obj).intValue();
        for (int i = 0; i < intValue; i++) {
            Object a = m5896a(pushbackInputStream);
            if (a instanceof C1536b) {
                C1536b bVar2 = (C1536b) a;
                if (!bVar2.f4560b.equals("endcidrange")) {
                    throw new IOException("Error : ~cidrange contains an unexpected operator : " + bVar2.f4560b);
                }
                return;
            }
            byte[] bArr = (byte[]) a;
            int b = m5903b(bArr);
            byte[] bArr2 = (byte[]) m5896a(pushbackInputStream);
            int b2 = m5903b(bArr2);
            int intValue2 = ((Integer) m5896a(pushbackInputStream)).intValue();
            if (bArr.length > 2 || bArr2.length > 2) {
                int i2 = (b2 + intValue2) - b;
                while (intValue2 <= i2) {
                    bVar.mo7144a(intValue2, m5903b(bArr));
                    m5900a(bArr);
                    intValue2++;
                }
            } else {
                bVar.mo7143a((char) b, (char) b2, intValue2);
            }
        }
    }

    /* renamed from: e */
    private void m5909e(Object obj, PushbackInputStream pushbackInputStream, C1532b bVar) {
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object a = m5896a(pushbackInputStream);
            if (a instanceof C1536b) {
                C1536b bVar2 = (C1536b) a;
                if (!bVar2.f4560b.equals("endcidchar")) {
                    throw new IOException("Error : ~cidchar contains an unexpected operator : " + bVar2.f4560b);
                }
                return;
            }
            bVar.mo7144a(((Integer) m5896a(pushbackInputStream)).intValue(), m5903b((byte[]) a));
        }
    }

    /* renamed from: f */
    private void m5910f(Object obj, PushbackInputStream pushbackInputStream, C1532b bVar) {
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object a = m5896a(pushbackInputStream);
            if (a instanceof C1536b) {
                C1536b bVar2 = (C1536b) a;
                if (!bVar2.f4560b.equals("endbfrange")) {
                    throw new IOException("Error : ~bfrange contains an unexpected operator : " + bVar2.f4560b);
                }
                return;
            }
            byte[] bArr = (byte[]) a;
            byte[] bArr2 = (byte[]) m5896a(pushbackInputStream);
            Object a2 = m5896a(pushbackInputStream);
            List list = null;
            if (a2 instanceof List) {
                list = (List) a2;
                a2 = list.get(0);
            }
            byte[] bArr3 = (byte[]) a2;
            boolean z = false;
            int i2 = 0;
            while (!z) {
                if (m5895a(bArr, bArr2) >= 0) {
                    z = true;
                }
                bVar.mo7148a(bArr, m5906c(bArr3));
                m5900a(bArr);
                if (list == null) {
                    m5900a(bArr3);
                } else {
                    i2++;
                    if (i2 < list.size()) {
                        bArr3 = (byte[]) list.get(i2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public C1532b mo7162a(InputStream inputStream) {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        C1532b bVar = new C1532b();
        Object obj = null;
        while (true) {
            Object a = m5896a(pushbackInputStream);
            if (a == null) {
                break;
            }
            if (a instanceof C1536b) {
                C1536b bVar2 = (C1536b) a;
                if (bVar2.f4560b.equals("usecmap")) {
                    m5898a(obj, bVar);
                } else if (bVar2.f4560b.equals("endcmap")) {
                    break;
                } else if (bVar2.f4560b.equals("begincodespacerange")) {
                    m5904b(obj, pushbackInputStream, bVar);
                } else if (bVar2.f4560b.equals("beginbfchar")) {
                    m5907c(obj, pushbackInputStream, bVar);
                } else if (bVar2.f4560b.equals("beginbfrange")) {
                    m5910f(obj, pushbackInputStream, bVar);
                } else if (bVar2.f4560b.equals("begincidchar")) {
                    m5909e(obj, pushbackInputStream, bVar);
                } else if (bVar2.f4560b.equals("begincidrange")) {
                    m5908d(obj, pushbackInputStream, bVar);
                }
            } else if (a instanceof C1535a) {
                m5899a(a, pushbackInputStream, bVar);
            }
            obj = a;
        }
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.cyberneid.p089b.p092c.C1532b mo7163a(java.lang.String r2) {
        /*
            r1 = this;
            java.io.InputStream r2 = r1.mo7164b((java.lang.String) r2)     // Catch:{ all -> 0x0010 }
            com.cyberneid.b.c.b r0 = r1.mo7162a((java.io.InputStream) r2)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x000d
            r2.close()
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r2 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x0017
            r2.close()
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p092c.C1533c.mo7163a(java.lang.String):com.cyberneid.b.c.b");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public InputStream mo7164b(String str) {
        if (C1941e.m7995a()) {
            return C1941e.m7993a("com/cyberneid/fontbox/resources/cmap/" + str);
        }
        Class<?> cls = getClass();
        URL resource = cls.getResource("/com/cyberneid/fontbox/resources/cmap/" + str);
        if (resource != null) {
            return resource.openStream();
        }
        throw new IOException("Error: Could not find referenced cmap stream " + str);
    }
}
