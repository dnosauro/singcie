package com.cyberneid.p089b.p092c;

import java.util.List;

/* renamed from: com.cyberneid.b.c.d */
public class C1537d {

    /* renamed from: a */
    private byte[] f4561a;

    /* renamed from: b */
    private byte[] f4562b;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7165a(byte[] bArr) {
        this.f4562b = bArr;
    }

    /* renamed from: a */
    public boolean mo7166a(byte b, int i) {
        byte b2 = b & 255;
        return b2 <= (this.f4562b[i] & 255) && b2 >= (this.f4561a[i] & 255);
    }

    /* renamed from: a */
    public boolean mo7167a(List<Byte> list) {
        if (list.size() < this.f4561a.length || list.size() > this.f4562b.length) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            byte b = this.f4561a[i] & 255;
            byte b2 = this.f4562b[i] & 255;
            byte byteValue = list.get(i).byteValue() & 255;
            if (byteValue > b2 || byteValue < b) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public byte[] mo7168a() {
        return this.f4561a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7169b(byte[] bArr) {
        this.f4561a = bArr;
    }
}
