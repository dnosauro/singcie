package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.C1196h;
import java.util.HashMap;
import java.util.WeakHashMap;

/* renamed from: androidx.work.impl.utils.i */
public class C1321i {

    /* renamed from: a */
    private static final String f4095a = C1196h.m4737a("WakeLocks");

    /* renamed from: b */
    private static final WeakHashMap<PowerManager.WakeLock, String> f4096b = new WeakHashMap<>();

    /* renamed from: a */
    public static PowerManager.WakeLock m5174a(Context context, String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        synchronized (f4096b) {
            f4096b.put(newWakeLock, str2);
        }
        return newWakeLock;
    }

    /* renamed from: a */
    public static void m5175a() {
        HashMap hashMap = new HashMap();
        synchronized (f4096b) {
            hashMap.putAll(f4096b);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                C1196h.m4736a().mo6420d(f4095a, String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)}), new Throwable[0]);
            }
        }
    }
}
