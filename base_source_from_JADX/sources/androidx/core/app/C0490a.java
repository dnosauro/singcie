package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.C0521n;
import androidx.core.content.C0529a;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.app.a */
public class C0490a extends C0529a {

    /* renamed from: a */
    private static C0493b f1924a;

    /* renamed from: androidx.core.app.a$a */
    public interface C0492a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: androidx.core.app.a$b */
    public interface C0493b {
        /* renamed from: a */
        boolean mo3409a(Activity activity, int i, int i2, Intent intent);

        /* renamed from: a */
        boolean mo3410a(Activity activity, String[] strArr, int i);
    }

    /* renamed from: androidx.core.app.a$c */
    public interface C0494c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: androidx.core.app.a$d */
    private static class C0495d extends SharedElementCallback {

        /* renamed from: a */
        private final C0521n f1928a;

        C0495d(C0521n nVar) {
            this.f1928a = nVar;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f1928a.mo3495a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f1928a.mo3496a(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f1928a.mo3500a(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f1928a.mo3497a(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f1928a.mo3501b(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f1928a.mo3499a(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f1928a.mo3498a(list, list2, (C0521n.C0522a) new C0521n.C0522a() {
                /* renamed from: a */
                public void mo3419a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    /* renamed from: a */
    public static C0493b m1945a() {
        return f1924a;
    }

    /* renamed from: a */
    public static void m1946a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m1947a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m1948a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m1949a(Activity activity, C0521n nVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(nVar != null ? new C0495d(nVar) : null);
        }
    }

    /* renamed from: a */
    public static void m1950a(final Activity activity, final String[] strArr, final int i) {
        C0493b bVar = f1924a;
        if (bVar != null && bVar.mo3410a(activity, strArr, i)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof C0494c) {
                ((C0494c) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0492a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0492a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m1951a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    /* renamed from: b */
    public static void m1952b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: b */
    public static void m1953b(Activity activity, C0521n nVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(nVar != null ? new C0495d(nVar) : null);
        }
    }

    /* renamed from: c */
    public static void m1954c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: d */
    public static void m1955d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: e */
    public static void m1956e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28 || !C0498c.m1963a(activity)) {
            activity.recreate();
        }
    }
}
