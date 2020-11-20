package androidx.room;

import androidx.p046i.p047a.C0819d;
import androidx.p046i.p047a.C0820e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: androidx.room.l */
public class C1146l implements C0819d, C0820e {

    /* renamed from: g */
    static final TreeMap<Integer, C1146l> f3600g = new TreeMap<>();

    /* renamed from: a */
    final long[] f3601a;

    /* renamed from: b */
    final double[] f3602b;

    /* renamed from: c */
    final String[] f3603c;

    /* renamed from: d */
    final byte[][] f3604d;

    /* renamed from: e */
    final int f3605e;

    /* renamed from: f */
    int f3606f;

    /* renamed from: h */
    private volatile String f3607h;

    /* renamed from: i */
    private final int[] f3608i;

    private C1146l(int i) {
        this.f3605e = i;
        int i2 = i + 1;
        this.f3608i = new int[i2];
        this.f3601a = new long[i2];
        this.f3602b = new double[i2];
        this.f3603c = new String[i2];
        this.f3604d = new byte[i2][];
    }

    /* renamed from: a */
    public static C1146l m4507a(String str, int i) {
        synchronized (f3600g) {
            Map.Entry<Integer, C1146l> ceilingEntry = f3600g.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                f3600g.remove(ceilingEntry.getKey());
                C1146l value = ceilingEntry.getValue();
                value.mo6190b(str, i);
                return value;
            }
            C1146l lVar = new C1146l(i);
            lVar.mo6190b(str, i);
            return lVar;
        }
    }

    /* renamed from: c */
    private static void m4508c() {
        if (f3600g.size() > 15) {
            int size = f3600g.size() - 10;
            Iterator<Integer> it = f3600g.descendingKeySet().iterator();
            while (true) {
                int i = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo6189a() {
        synchronized (f3600g) {
            f3600g.put(Integer.valueOf(this.f3605e), this);
            m4508c();
        }
    }

    /* renamed from: a */
    public void mo4637a(int i) {
        this.f3608i[i] = 1;
    }

    /* renamed from: a */
    public void mo4638a(int i, double d) {
        this.f3608i[i] = 3;
        this.f3602b[i] = d;
    }

    /* renamed from: a */
    public void mo4639a(int i, long j) {
        this.f3608i[i] = 2;
        this.f3601a[i] = j;
    }

    /* renamed from: a */
    public void mo4640a(int i, String str) {
        this.f3608i[i] = 4;
        this.f3603c[i] = str;
    }

    /* renamed from: a */
    public void mo4641a(int i, byte[] bArr) {
        this.f3608i[i] = 5;
        this.f3604d[i] = bArr;
    }

    /* renamed from: a */
    public void mo4609a(C0819d dVar) {
        for (int i = 1; i <= this.f3606f; i++) {
            switch (this.f3608i[i]) {
                case 1:
                    dVar.mo4637a(i);
                    break;
                case 2:
                    dVar.mo4639a(i, this.f3601a[i]);
                    break;
                case 3:
                    dVar.mo4638a(i, this.f3602b[i]);
                    break;
                case 4:
                    dVar.mo4640a(i, this.f3603c[i]);
                    break;
                case 5:
                    dVar.mo4641a(i, this.f3604d[i]);
                    break;
            }
        }
    }

    /* renamed from: b */
    public String mo4610b() {
        return this.f3607h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6190b(String str, int i) {
        this.f3607h = str;
        this.f3606f = i;
    }

    public void close() {
    }
}
