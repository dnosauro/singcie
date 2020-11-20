package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import java.io.IOException;
import java.util.StringTokenizer;

/* renamed from: com.cyberneid.d.g.e.a.o */
public final class C1847o extends C1833a {

    /* renamed from: h */
    private static final boolean f5978h;

    /* renamed from: a */
    private final C1764g f5979a;

    /* renamed from: b */
    private int f5980b = -1;

    /* renamed from: c */
    private C1838f f5981c;

    /* renamed from: d */
    private C1837e f5982d;

    /* renamed from: f */
    private boolean f5983f;

    /* renamed from: g */
    private boolean f5984g;

    static {
        String property = System.getProperty("sun.java2d.cmm");
        boolean z = true;
        if (m7640g()) {
            if ("sun.java2d.cmm.kcms.KcmsServiceProvider".equals(property)) {
                try {
                    Class.forName("sun.java2d.cmm.kcms.KcmsServiceProvider");
                } catch (ClassNotFoundException unused) {
                }
            }
            z = false;
        }
        f5978h = z;
    }

    @Deprecated
    public C1847o(C1604a aVar) {
        boolean z = false;
        this.f5983f = false;
        this.f5984g = false;
        m7637a(aVar);
        this.f5984g = System.getProperty("com.cyberneid.pdfbox.rendering.UseAlternateInsteadOfICCColorSpace") != null ? true : z;
        this.f5960e = aVar;
        this.f5979a = new C1764g((C1619o) aVar.mo7485a(1));
        m7639f();
    }

    /* renamed from: a */
    public static C1847o m7636a(C1604a aVar, C1931h hVar) {
        C1838f b;
        m7637a(aVar);
        C1605b b2 = aVar.mo7495b(1);
        C1616l lVar = b2 instanceof C1616l ? (C1616l) b2 : null;
        if (lVar != null && hVar != null && hVar.mo8471b() != null && (b = hVar.mo8471b().mo7853b(lVar)) != null && (b instanceof C1847o)) {
            return (C1847o) b;
        }
        C1847o oVar = new C1847o(aVar);
        if (!(lVar == null || hVar == null || hVar.mo8471b() == null)) {
            hVar.mo8471b().mo7852a(lVar, (C1838f) oVar);
        }
        return oVar;
    }

    /* renamed from: a */
    private static void m7637a(C1604a aVar) {
        if (aVar.mo7494b() < 2) {
            throw new IOException("ICCBased colorspace array must have two elements");
        } else if (!(aVar.mo7485a(1) instanceof C1619o)) {
            throw new IOException("ICCBased colorspace array must have a stream as second element");
        }
    }

    /* renamed from: a */
    private void m7638a(Exception exc) {
        this.f5981c = mo8281a();
        if (this.f5981c.equals(C1845m.f5975a)) {
            this.f5983f = true;
        }
        if (exc != null) {
            Log.w("PDICCBased", "Can't read embedded ICC profile (" + exc.getLocalizedMessage() + "), using alternate color space: " + this.f5981c.mo8258b());
        }
        this.f5982d = this.f5981c.mo8260e();
    }

    /* renamed from: f */
    private void m7639f() {
        try {
            m7638a((Exception) null);
        } catch (IOException e) {
            Log.w("PDICCBased", "Error initializing alternate color space: " + e.getLocalizedMessage());
        }
    }

    /* renamed from: g */
    private static boolean m7640g() {
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.specification.version"), ".");
        try {
            int parseInt = Integer.parseInt(stringTokenizer.nextToken());
            int parseInt2 = stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0;
            if (parseInt <= 1) {
                return parseInt == 1 && parseInt2 >= 8;
            }
            return true;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        return this.f5981c.mo8253a(bitmap);
    }

    /* renamed from: a */
    public C1838f mo8281a() {
        C1604a aVar;
        C1613i iVar;
        C1605b c = this.f5979a.mo7505d().mo7539c(C1613i.f5352n);
        if (c == null) {
            aVar = new C1604a();
            int c2 = mo8259c();
            if (c2 != 1) {
                switch (c2) {
                    case 3:
                        iVar = C1613i.f5017bt;
                        break;
                    case 4:
                        iVar = C1613i.f5014bq;
                        break;
                    default:
                        throw new IOException("Unknown color space number of components:" + c2);
                }
            } else {
                iVar = C1613i.f5015br;
            }
            aVar.mo7490a((C1605b) iVar);
        } else if (c instanceof C1604a) {
            aVar = (C1604a) c;
        } else if (c instanceof C1613i) {
            C1604a aVar2 = new C1604a();
            aVar2.mo7490a(c);
            aVar = aVar2;
        } else {
            throw new IOException("Error: expected COSArray or COSName and not " + c.getClass().getName());
        }
        return C1838f.m7589a((C1605b) aVar);
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        return this.f5983f ? fArr : this.f5981c.mo8257a(fArr);
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5113dj.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        if (this.f5980b < 0) {
            this.f5980b = this.f5979a.mo7505d().mo7547g(C1613i.f5180ex);
        }
        return this.f5980b;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5982d;
    }

    public String toString() {
        return mo8258b() + "{numberOfComponents: " + mo8259c() + "}";
    }
}
