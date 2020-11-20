package androidx.browser.p017a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

/* renamed from: androidx.browser.a.d */
public abstract class C0397d implements ServiceConnection {
    public abstract void onCustomTabsServiceConnected(ComponentName componentName, C0388b bVar);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onCustomTabsServiceConnected(componentName, new C0388b(ICustomTabsService.Stub.asInterface(iBinder), componentName) {
        });
    }
}
