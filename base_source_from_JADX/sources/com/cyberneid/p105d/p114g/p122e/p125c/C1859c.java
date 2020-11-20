package com.cyberneid.p105d.p114g.p122e.p125c;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.cyberneid.p099c.p102b.p103a.p104a.C1600f;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p109c.C1648j;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import com.cyberneid.p105d.p114g.p122e.p123a.C1845m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.cyberneid.d.g.e.c.c */
public final class C1859c {
    /* renamed from: a */
    public static C1861e m7705a(C1783c cVar, Bitmap bitmap) {
        C1841i iVar;
        byte[] bArr;
        int i;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i2 = 0;
        if (bitmap.getConfig() == Bitmap.Config.ALPHA_8) {
            C1841i iVar2 = C1841i.f5963a;
            int i3 = width * 8;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((i3 / 8) + ((i3 % 8 != 0 ? 1 : 0) * height));
            C1600f fVar = new C1600f(byteArrayOutputStream);
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            while (i2 < height) {
                int i4 = width * i2;
                while (true) {
                    i = i2 + 1;
                    if (i4 >= i * width) {
                        break;
                    }
                    fVar.mo7451a((long) (iArr[i4] & 255), 8);
                    i4++;
                }
                int f = fVar.mo7430f();
                if (f != 0) {
                    fVar.mo7451a(0, 8 - f);
                }
                i2 = i;
            }
            fVar.mo7434i();
            fVar.mo7420a();
            bArr = byteArrayOutputStream.toByteArray();
            iVar = iVar2;
        } else {
            C1845m mVar = C1845m.f5975a;
            int i5 = width * height;
            byte[] bArr2 = new byte[(i5 * 3)];
            int[] iArr2 = new int[i5];
            bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
            int length = iArr2.length;
            int i6 = 0;
            while (i2 < length) {
                int i7 = iArr2[i2];
                int i8 = i6 + 1;
                bArr2[i6] = (byte) ((i7 >> 16) & 255);
                int i9 = i8 + 1;
                bArr2[i8] = (byte) ((i7 >> 8) & 255);
                bArr2[i9] = (byte) (i7 & 255);
                i2++;
                i6 = i9 + 1;
            }
            iVar = mVar;
            bArr = bArr2;
        }
        C1861e a = m7706a(cVar, bArr, bitmap.getWidth(), bitmap.getHeight(), 8, iVar);
        C1861e b = m7707b(cVar, bitmap);
        if (b != null) {
            a.mo8251b().mo7522a(C1613i.f5238gB, (C1760c) b);
        }
        return a;
    }

    /* renamed from: a */
    public static C1861e m7706a(C1783c cVar, byte[] bArr, int i, int i2, int i3, C1838f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length / 2);
        C1648j.f5455a.mo7694a(C1613i.f5028cD).mo7693b(new ByteArrayInputStream(bArr), byteArrayOutputStream, new C1607d(), 0);
        return new C1861e(cVar, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), C1613i.f5028cD, i, i2, i3, fVar);
    }

    /* renamed from: b */
    private static C1861e m7707b(C1783c cVar, Bitmap bitmap) {
        if (!bitmap.hasAlpha()) {
            return null;
        }
        int[] iArr = new int[(bitmap.getHeight() * bitmap.getWidth())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int alpha : iArr) {
            byteArrayOutputStream.write(Color.alpha(alpha));
        }
        return m7706a(cVar, byteArrayOutputStream.toByteArray(), bitmap.getWidth(), bitmap.getHeight(), 8, C1841i.f5963a);
    }
}
