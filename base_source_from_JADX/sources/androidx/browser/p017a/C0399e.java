package androidx.browser.p017a;

import android.content.ComponentName;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;

/* renamed from: androidx.browser.a.e */
public final class C0399e {

    /* renamed from: a */
    private final Object f1356a = new Object();

    /* renamed from: b */
    private final ICustomTabsService f1357b;

    /* renamed from: c */
    private final ICustomTabsCallback f1358c;

    /* renamed from: d */
    private final ComponentName f1359d;

    C0399e(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.f1357b = iCustomTabsService;
        this.f1358c = iCustomTabsCallback;
        this.f1359d = componentName;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IBinder mo2808a() {
        return this.f1358c.asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ComponentName mo2809b() {
        return this.f1359d;
    }
}
