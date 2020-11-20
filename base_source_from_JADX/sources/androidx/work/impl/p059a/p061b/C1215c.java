package androidx.work.impl.p059a.p061b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.C1196h;
import androidx.work.impl.utils.p065b.C1311a;

/* renamed from: androidx.work.impl.a.b.c */
public abstract class C1215c<T> extends C1217d<T> {

    /* renamed from: d */
    private static final String f3789d = C1196h.m4737a("BrdcstRcvrCnstrntTrckr");

    /* renamed from: e */
    private final BroadcastReceiver f3790e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                C1215c.this.mo6458a(context, intent);
            }
        }
    };

    public C1215c(Context context, C1311a aVar) {
        super(context, aVar);
    }

    /* renamed from: a */
    public abstract void mo6458a(Context context, Intent intent);

    /* renamed from: b */
    public abstract IntentFilter mo6459b();

    /* renamed from: d */
    public void mo6462d() {
        C1196h.m4736a().mo6418b(f3789d, String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f3794b.registerReceiver(this.f3790e, mo6459b());
    }

    /* renamed from: e */
    public void mo6463e() {
        C1196h.m4736a().mo6418b(f3789d, String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f3794b.unregisterReceiver(this.f3790e);
    }
}
