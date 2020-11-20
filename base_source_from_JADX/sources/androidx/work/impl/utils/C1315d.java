package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.C1196h;

/* renamed from: androidx.work.impl.utils.d */
public class C1315d {

    /* renamed from: a */
    private static final String f4080a = C1196h.m4737a("PackageManagerHelper");

    /* renamed from: a */
    public static void m5169a(Context context, Class<?> cls, boolean z) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            C1196h a = C1196h.m4736a();
            String str = f4080a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z ? "enabled" : "disabled";
            a.mo6418b(str, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e) {
            C1196h a2 = C1196h.m4736a();
            String str2 = f4080a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            objArr2[1] = z ? "enabled" : "disabled";
            a2.mo6418b(str2, String.format("%s could not be %s", objArr2), e);
        }
    }
}
