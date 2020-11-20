package androidx.core.p027e;

import android.util.Base64;
import androidx.core.p029g.C0588f;
import java.util.List;

/* renamed from: androidx.core.e.a */
public final class C0549a {

    /* renamed from: a */
    private final String f2081a;

    /* renamed from: b */
    private final String f2082b;

    /* renamed from: c */
    private final String f2083c;

    /* renamed from: d */
    private final List<List<byte[]>> f2084d;

    /* renamed from: e */
    private final int f2085e = 0;

    /* renamed from: f */
    private final String f2086f = (this.f2081a + "-" + this.f2082b + "-" + this.f2083c);

    public C0549a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2081a = (String) C0588f.m2266a(str);
        this.f2082b = (String) C0588f.m2266a(str2);
        this.f2083c = (String) C0588f.m2266a(str3);
        this.f2084d = (List) C0588f.m2266a(list);
    }

    /* renamed from: a */
    public String mo3540a() {
        return this.f2081a;
    }

    /* renamed from: b */
    public String mo3541b() {
        return this.f2082b;
    }

    /* renamed from: c */
    public String mo3542c() {
        return this.f2083c;
    }

    /* renamed from: d */
    public List<List<byte[]>> mo3543d() {
        return this.f2084d;
    }

    /* renamed from: e */
    public int mo3544e() {
        return this.f2085e;
    }

    /* renamed from: f */
    public String mo3545f() {
        return this.f2086f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2081a + ", mProviderPackage: " + this.f2082b + ", mQuery: " + this.f2083c + ", mCertificates:");
        for (int i = 0; i < this.f2084d.size(); i++) {
            sb.append(" [");
            List list = this.f2084d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2085e);
        return sb.toString();
    }
}
