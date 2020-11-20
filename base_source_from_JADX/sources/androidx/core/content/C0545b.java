package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.core.app.C0503d;

/* renamed from: androidx.core.content.b */
public final class C0545b {
    /* renamed from: a */
    public static int m2165a(Context context, String str) {
        return m2166a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* renamed from: a */
    public static int m2166a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0503d.m1971a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0503d.m1970a(context, a, str2) != 0 ? -2 : 0;
    }
}
