package com.cyberneid.p089b.p091b;

import com.parse.ParseException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.b.b.x */
public class C1530x {

    /* renamed from: a */
    private int f4536a = 0;

    /* renamed from: b */
    private int f4537b = 0;

    /* renamed from: c */
    private List<Object> f4538c = null;

    /* renamed from: d */
    private final String f4539d;

    /* renamed from: e */
    private final String f4540e;

    public C1530x(String str, int i) {
        this.f4539d = str;
        this.f4540e = String.format("%04x", new Object[]{Integer.valueOf(i)});
    }

    public C1530x(String str, String str2) {
        this.f4539d = str;
        this.f4540e = str2;
    }

    /* renamed from: a */
    private int m5866a() {
        int i = this.f4536a + this.f4537b;
        int i2 = 1;
        while (true) {
            i -= 8;
            if (i <= 0) {
                return i2;
            }
            i2++;
        }
    }

    /* renamed from: a */
    private C1519p m5867a(int i, C1522r rVar) {
        if (i == 1 || i == 18) {
            this.f4536a += m5870b().size() / 2;
        } else if (i == 3 || i == 19 || i == 20 || i == 23) {
            this.f4537b += m5870b().size() / 2;
        }
        if (i == 12) {
            return new C1519p(i, rVar.mo7124h());
        }
        if (i != 19 && i != 20) {
            return new C1519p(i);
        }
        int[] iArr = new int[(m5866a() + 1)];
        iArr[0] = i;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            iArr[i2] = rVar.mo7124h();
        }
        return new C1519p(iArr);
    }

    /* renamed from: a */
    private List<Object> m5868a(byte[] bArr, C1524t tVar, C1524t tVar2, boolean z) {
        List<Object> list;
        Object obj;
        if (z) {
            this.f4536a = 0;
            this.f4537b = 0;
            this.f4538c = new ArrayList();
        }
        C1522r rVar = new C1522r(bArr);
        boolean z2 = tVar2 != null && tVar2.mo7128a() > 0;
        boolean z3 = tVar != null && tVar.mo7128a() > 0;
        while (rVar.mo7121e()) {
            int h = rVar.mo7124h();
            int i = 1131;
            if (h == 10 && z2) {
                List<Object> list2 = this.f4538c;
                Integer num = (Integer) list2.remove(list2.size() - 1);
                int a = tVar2.mo7128a();
                if (a < 1240) {
                    i = 107;
                } else if (a >= 33900) {
                    i = 32768;
                }
                int intValue = i + num.intValue();
                if (intValue < tVar2.mo7128a()) {
                    m5868a(tVar2.mo7130a(intValue), tVar, tVar2, false);
                    List<Object> list3 = this.f4538c;
                    Object obj2 = list3.get(list3.size() - 1);
                    if (obj2 instanceof C1519p) {
                        if (((C1519p) obj2).mo7108a().mo7112a()[0] != 11) {
                        }
                    }
                }
            } else if (h != 29 || !z3) {
                if (h < 0 || h > 27) {
                    if (h != 28) {
                        if (h < 29 || h > 31) {
                            if (h < 32 || h > 255) {
                                throw new IllegalArgumentException();
                            }
                        }
                    }
                    list = this.f4538c;
                    obj = m5869b(h, rVar);
                    list.add(obj);
                }
                list = this.f4538c;
                obj = m5867a(h, rVar);
                list.add(obj);
            } else {
                List<Object> list4 = this.f4538c;
                Integer num2 = (Integer) list4.remove(list4.size() - 1);
                int a2 = tVar.mo7128a();
                if (a2 < 1240) {
                    i = 107;
                } else if (a2 >= 33900) {
                    i = 32768;
                }
                int intValue2 = i + num2.intValue();
                if (intValue2 < tVar.mo7128a()) {
                    m5868a(tVar.mo7130a(intValue2), tVar, tVar2, false);
                    List<Object> list5 = this.f4538c;
                    Object obj3 = list5.get(list5.size() - 1);
                    if (obj3 instanceof C1519p) {
                        if (((C1519p) obj3).mo7108a().mo7112a()[0] != 11) {
                        }
                    }
                }
            }
            List<Object> list6 = this.f4538c;
            list6.remove(list6.size() - 1);
        }
        return this.f4538c;
    }

    /* renamed from: b */
    private Integer m5869b(int i, C1522r rVar) {
        int i2;
        int h;
        if (i == 28) {
            i2 = (rVar.mo7124h() << 8) | rVar.mo7124h();
        } else if (i >= 32 && i <= 246) {
            h = i - 139;
            return Integer.valueOf(h);
        } else if (i >= 247 && i <= 250) {
            h = ((i - 247) * 256) + rVar.mo7124h() + 108;
            return Integer.valueOf(h);
        } else if (i >= 251 && i <= 254) {
            h = (((-(i - ParseException.INVALID_LINKED_SESSION)) * 256) - rVar.mo7124h()) - 108;
            return Integer.valueOf(h);
        } else if (i == 255) {
            int h2 = rVar.mo7124h();
            int h3 = rVar.mo7124h();
            rVar.mo7124h();
            rVar.mo7124h();
            i2 = (h2 << 8) | h3;
        } else {
            throw new IllegalArgumentException();
        }
        h = (short) i2;
        return Integer.valueOf(h);
    }

    /* renamed from: b */
    private List<Number> m5870b() {
        ArrayList arrayList = new ArrayList();
        int size = this.f4538c.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Object obj = this.f4538c.get(size);
            if (!(obj instanceof Number)) {
                break;
            }
            arrayList.add(0, (Number) obj);
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<Object> mo7139a(byte[] bArr, C1524t tVar, C1524t tVar2) {
        return m5868a(bArr, tVar, tVar2, true);
    }
}
