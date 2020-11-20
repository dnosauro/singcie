package com.cyberneid.p105d.p108b;

import android.util.Log;
import com.cyberneid.p105d.p131h.C1933a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.cyberneid.d.b.p */
public final class C1622p extends C1605b {

    /* renamed from: a */
    public static final boolean f5385a = Boolean.getBoolean("com.cyberneid.pdfbox.forceParsing");

    /* renamed from: b */
    private byte[] f5386b;

    /* renamed from: c */
    private boolean f5387c;

    public C1622p(String str) {
        byte[] byteArray;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            } else if (!C1625s.m6520a(charArray[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            byteArray = C1625s.m6521a(str);
        } else {
            byte[] bytes = str.getBytes(C1933a.f6109b);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length + 2);
            byteArrayOutputStream.write(254);
            byteArrayOutputStream.write(255);
            try {
                byteArrayOutputStream.write(bytes);
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.f5386b = byteArray;
    }

    public C1622p(byte[] bArr) {
        mo7639a(bArr);
    }

    /* renamed from: a */
    public static C1622p m6500a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder(str.trim());
        if (sb.length() % 2 != 0) {
            sb.append('0');
        }
        int length = sb.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            try {
                byteArrayOutputStream.write(Integer.parseInt(sb.substring(i, i2), 16));
            } catch (NumberFormatException e) {
                if (f5385a) {
                    Log.w("PdfBox-Android", "Encountered a malformed hex string");
                    byteArrayOutputStream.write(63);
                } else {
                    throw new IOException("Invalid hex string: " + str, e);
                }
            }
            i = i2;
        }
        return new C1622p(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7656a(this);
    }

    /* renamed from: a */
    public void mo7639a(byte[] bArr) {
        this.f5386b = (byte[]) bArr.clone();
    }

    /* renamed from: a */
    public boolean mo7640a() {
        return this.f5387c;
    }

    /* renamed from: b */
    public String mo7641b() {
        byte[] bArr = this.f5386b;
        if (bArr.length > 2) {
            if ((bArr[0] & 255) == 254 && (bArr[1] & 255) == 255) {
                return new String(bArr, 2, bArr.length - 2, C1933a.f6109b);
            }
            byte[] bArr2 = this.f5386b;
            if ((bArr2[0] & 255) == 255 && (bArr2[1] & 255) == 254) {
                return new String(bArr2, 2, bArr2.length - 2, C1933a.f6110c);
            }
        }
        return C1625s.m6518a(this.f5386b);
    }

    /* renamed from: b */
    public void mo7642b(boolean z) {
        this.f5387c = z;
    }

    /* renamed from: c */
    public byte[] mo7643c() {
        return this.f5386b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1622p)) {
            return false;
        }
        C1622p pVar = (C1622p) obj;
        return mo7641b().equals(pVar.mo7641b()) && this.f5387c == pVar.f5387c;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5386b) + (this.f5387c ? 17 : 0);
    }

    public String toString() {
        return "COSString{" + mo7641b() + "}";
    }
}
