package com.cyberneid.p105d.p108b;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.d.b.f */
public class C1609f extends C1615k {

    /* renamed from: a */
    private BigDecimal f4882a;

    /* renamed from: b */
    private String f4883b;

    public C1609f(float f) {
        this.f4882a = new BigDecimal(String.valueOf(f));
        this.f4883b = m6448b(this.f4882a.toPlainString());
    }

    public C1609f(String str) {
        try {
            this.f4883b = str;
            this.f4882a = new BigDecimal(this.f4883b);
        } catch (NumberFormatException e) {
            throw new IOException("Error expected floating point number actual='" + str + "'", e);
        }
    }

    /* renamed from: b */
    private String m6448b(String str) {
        if (str.indexOf(46) > -1 && !str.endsWith(".0")) {
            while (str.endsWith("0") && !str.endsWith(".0")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    /* renamed from: a */
    public float mo7583a() {
        return this.f4882a.floatValue();
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7651a(this);
    }

    /* renamed from: a */
    public void mo7584a(OutputStream outputStream) {
        outputStream.write(this.f4883b.getBytes(LocalizedMessage.DEFAULT_ENCODING));
    }

    /* renamed from: b */
    public long mo7585b() {
        return this.f4882a.longValue();
    }

    /* renamed from: c */
    public int mo7586c() {
        return this.f4882a.intValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1609f) && Float.floatToIntBits(((C1609f) obj).f4882a.floatValue()) == Float.floatToIntBits(this.f4882a.floatValue());
    }

    public int hashCode() {
        return this.f4882a.hashCode();
    }

    public String toString() {
        return "COSFloat{" + this.f4883b + "}";
    }
}
