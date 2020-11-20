package androidx.browser.p017a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

/* renamed from: androidx.browser.a.b */
public class C0388b {

    /* renamed from: a */
    private final ICustomTabsService f1327a;

    /* renamed from: b */
    private final ComponentName f1328b;

    C0388b(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.f1327a = iCustomTabsService;
        this.f1328b = componentName;
    }

    /* renamed from: a */
    public static boolean m1457a(Context context, String str, C0397d dVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    /* renamed from: a */
    public C0399e mo2797a(final C0387a aVar) {
        C03891 r0 = new ICustomTabsCallback.Stub() {

            /* renamed from: c */
            private Handler f1331c = new Handler(Looper.getMainLooper());

            public void extraCallback(final String str, final Bundle bundle) {
                if (aVar != null) {
                    this.f1331c.post(new Runnable() {
                        public void run() {
                            aVar.mo2795a(str, bundle);
                        }
                    });
                }
            }

            public void onMessageChannelReady(final Bundle bundle) {
                if (aVar != null) {
                    this.f1331c.post(new Runnable() {
                        public void run() {
                            aVar.mo2794a(bundle);
                        }
                    });
                }
            }

            public void onNavigationEvent(final int i, final Bundle bundle) {
                if (aVar != null) {
                    this.f1331c.post(new Runnable() {
                        public void run() {
                            aVar.mo2793a(i, bundle);
                        }
                    });
                }
            }

            public void onPostMessage(final String str, final Bundle bundle) {
                if (aVar != null) {
                    this.f1331c.post(new Runnable() {
                        public void run() {
                            aVar.mo2796b(str, bundle);
                        }
                    });
                }
            }

            public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
                if (aVar != null) {
                    final int i2 = i;
                    final Uri uri2 = uri;
                    final boolean z2 = z;
                    final Bundle bundle2 = bundle;
                    this.f1331c.post(new Runnable() {
                        public void run() {
                            aVar.mo2792a(i2, uri2, z2, bundle2);
                        }
                    });
                }
            }
        };
        try {
            if (!this.f1327a.newSession(r0)) {
                return null;
            }
            return new C0399e(this.f1327a, r0, this.f1328b);
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo2798a(long j) {
        try {
            return this.f1327a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
