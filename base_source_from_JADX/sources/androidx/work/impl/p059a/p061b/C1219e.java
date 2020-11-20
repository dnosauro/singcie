package androidx.work.impl.p059a.p061b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.p024c.C0526a;
import androidx.work.C1196h;
import androidx.work.impl.p059a.C1212b;
import androidx.work.impl.utils.p065b.C1311a;

/* renamed from: androidx.work.impl.a.b.e */
public class C1219e extends C1217d<C1212b> {

    /* renamed from: d */
    static final String f3800d = C1196h.m4737a("NetworkStateTracker");

    /* renamed from: e */
    private final ConnectivityManager f3801e = ((ConnectivityManager) this.f3794b.getSystemService("connectivity"));

    /* renamed from: f */
    private C1221b f3802f;

    /* renamed from: g */
    private C1220a f3803g;

    /* renamed from: androidx.work.impl.a.b.e$a */
    private class C1220a extends BroadcastReceiver {
        C1220a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                C1196h.m4736a().mo6418b(C1219e.f3800d, "Network broadcast received", new Throwable[0]);
                C1219e eVar = C1219e.this;
                eVar.mo6466a(eVar.mo6470b());
            }
        }
    }

    /* renamed from: androidx.work.impl.a.b.e$b */
    private class C1221b extends ConnectivityManager.NetworkCallback {
        C1221b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            C1196h.m4736a().mo6418b(C1219e.f3800d, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            C1219e eVar = C1219e.this;
            eVar.mo6466a(eVar.mo6470b());
        }

        public void onLost(Network network) {
            C1196h.m4736a().mo6418b(C1219e.f3800d, "Network connection lost", new Throwable[0]);
            C1219e eVar = C1219e.this;
            eVar.mo6466a(eVar.mo6470b());
        }
    }

    public C1219e(Context context, C1311a aVar) {
        super(context, aVar);
        if (m4837f()) {
            this.f3802f = new C1221b();
        } else {
            this.f3803g = new C1220a();
        }
    }

    /* renamed from: f */
    private static boolean m4837f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r3.f3801e.getNetworkCapabilities(r3.f3801e.getActiveNetwork());
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4838g() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 23
            if (r0 >= r2) goto L_0x0008
            return r1
        L_0x0008:
            android.net.ConnectivityManager r0 = r3.f3801e
            android.net.Network r0 = r0.getActiveNetwork()
            android.net.ConnectivityManager r2 = r3.f3801e
            android.net.NetworkCapabilities r0 = r2.getNetworkCapabilities(r0)
            if (r0 == 0) goto L_0x001f
            r2 = 16
            boolean r0 = r0.hasCapability(r2)
            if (r0 == 0) goto L_0x001f
            r1 = 1
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.p059a.p061b.C1219e.m4838g():boolean");
    }

    /* renamed from: a */
    public C1212b mo6460c() {
        return mo6470b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1212b mo6470b() {
        NetworkInfo activeNetworkInfo = this.f3801e.getActiveNetworkInfo();
        boolean z = true;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean g = m4838g();
        boolean a = C0526a.m2080a(this.f3801e);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z = false;
        }
        return new C1212b(z2, g, a, z);
    }

    /* renamed from: d */
    public void mo6462d() {
        if (m4837f()) {
            C1196h.m4736a().mo6418b(f3800d, "Registering network callback", new Throwable[0]);
            this.f3801e.registerDefaultNetworkCallback(this.f3802f);
            return;
        }
        C1196h.m4736a().mo6418b(f3800d, "Registering broadcast receiver", new Throwable[0]);
        this.f3794b.registerReceiver(this.f3803g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: e */
    public void mo6463e() {
        if (m4837f()) {
            try {
                C1196h.m4736a().mo6418b(f3800d, "Unregistering network callback", new Throwable[0]);
                this.f3801e.unregisterNetworkCallback(this.f3802f);
            } catch (IllegalArgumentException e) {
                C1196h.m4736a().mo6421e(f3800d, "Received exception while unregistering network callback", e);
            }
        } else {
            C1196h.m4736a().mo6418b(f3800d, "Unregistering broadcast receiver", new Throwable[0]);
            this.f3794b.unregisterReceiver(this.f3803g);
        }
    }
}
