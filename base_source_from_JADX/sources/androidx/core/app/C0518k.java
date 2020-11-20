package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.C0510i;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: androidx.core.app.k */
class C0518k {

    /* renamed from: a */
    private static final Object f2029a = new Object();

    /* renamed from: b */
    private static Field f2030b;

    /* renamed from: c */
    private static boolean f2031c;

    /* renamed from: d */
    private static final Object f2032d = new Object();

    /* renamed from: a */
    public static Bundle m2046a(Notification.Builder builder, C0510i.C0511a aVar) {
        builder.addAction(aVar.mo3434a(), aVar.mo3436c(), aVar.mo3437d());
        Bundle bundle = new Bundle(aVar.mo3438e());
        if (aVar.mo3440g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m2051a(aVar.mo3440g()));
        }
        if (aVar.mo3443j() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m2051a(aVar.mo3443j()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3439f());
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m2047a(Notification notification) {
        String str;
        String str2;
        synchronized (f2029a) {
            if (f2031c) {
                return null;
            }
            try {
                if (f2030b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2031c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2030b = declaredField;
                }
                Bundle bundle = (Bundle) f2030b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2030b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                e = e;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2031c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2031c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    static Bundle m2048a(C0510i.C0511a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", aVar.mo3434a());
        bundle.putCharSequence("title", aVar.mo3436c());
        bundle.putParcelable("actionIntent", aVar.mo3437d());
        Bundle bundle2 = aVar.mo3438e() != null ? new Bundle(aVar.mo3438e()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.mo3439f());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", m2051a(aVar.mo3440g()));
        bundle.putBoolean("showsUserInterface", aVar.mo3444k());
        bundle.putInt("semanticAction", aVar.mo3441h());
        return bundle;
    }

    /* renamed from: a */
    private static Bundle m2049a(C0520m mVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", mVar.mo3488a());
        bundle.putCharSequence("label", mVar.mo3489b());
        bundle.putCharSequenceArray("choices", mVar.mo3490c());
        bundle.putBoolean("allowFreeFormInput", mVar.mo3492e());
        bundle.putBundle("extras", mVar.mo3494g());
        Set<String> d = mVar.mo3491d();
        if (d != null && !d.isEmpty()) {
            ArrayList arrayList = new ArrayList(d.size());
            for (String add : d) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: a */
    public static SparseArray<Bundle> m2050a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    private static Bundle[] m2051a(C0520m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        for (int i = 0; i < mVarArr.length; i++) {
            bundleArr[i] = m2049a(mVarArr[i]);
        }
        return bundleArr;
    }
}
