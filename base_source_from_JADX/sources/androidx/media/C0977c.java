package androidx.media;

import java.util.Arrays;

/* renamed from: androidx.media.c */
class C0977c implements C0973a {

    /* renamed from: a */
    int f3124a = 0;

    /* renamed from: b */
    int f3125b = 0;

    /* renamed from: c */
    int f3126c = 0;

    /* renamed from: d */
    int f3127d = -1;

    C0977c() {
    }

    /* renamed from: a */
    public int mo5156a() {
        int i = this.f3127d;
        return i != -1 ? i : AudioAttributesCompat.m3774a(false, this.f3126c, this.f3124a);
    }

    /* renamed from: b */
    public int mo5157b() {
        return this.f3125b;
    }

    /* renamed from: c */
    public int mo5158c() {
        return this.f3124a;
    }

    /* renamed from: d */
    public int mo5159d() {
        int i = this.f3126c;
        int a = mo5156a();
        if (a == 6) {
            i |= 4;
        } else if (a == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0977c)) {
            return false;
        }
        C0977c cVar = (C0977c) obj;
        return this.f3125b == cVar.mo5157b() && this.f3126c == cVar.mo5159d() && this.f3124a == cVar.mo5158c() && this.f3127d == cVar.f3127d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3125b), Integer.valueOf(this.f3126c), Integer.valueOf(this.f3124a), Integer.valueOf(this.f3127d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3127d != -1) {
            sb.append(" stream=");
            sb.append(this.f3127d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m3775a(this.f3124a));
        sb.append(" content=");
        sb.append(this.f3125b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3126c).toUpperCase());
        return sb.toString();
    }
}
