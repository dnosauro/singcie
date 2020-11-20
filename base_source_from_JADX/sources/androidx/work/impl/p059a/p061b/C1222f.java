package androidx.work.impl.p059a.p061b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.C1196h;
import androidx.work.impl.utils.p065b.C1311a;

/* renamed from: androidx.work.impl.a.b.f */
public class C1222f extends C1215c<Boolean> {

    /* renamed from: d */
    private static final String f3806d = C1196h.m4737a("StorageNotLowTracker");

    public C1222f(Context context, C1311a aVar) {
        super(context, aVar);
    }

    /* renamed from: a */
    public Boolean mo6460c() {
        Intent registerReceiver = this.f3794b.registerReceiver((BroadcastReceiver) null, mo6459b());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return true;
        }
        String action = registerReceiver.getAction();
        char c = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c = 0;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c = 1;
        }
        switch (c) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void mo6458a(Context context, Intent intent) {
        boolean z;
        if (intent.getAction() != null) {
            C1196h.m4736a().mo6418b(f3806d, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1181163412) {
                if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                    c = 0;
                }
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    z = true;
                    break;
                case 1:
                    z = false;
                    break;
                default:
                    return;
            }
            mo6466a(z);
        }
    }

    /* renamed from: b */
    public IntentFilter mo6459b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }
}
