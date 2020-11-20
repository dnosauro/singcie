package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: androidx.work.impl.utils.e */
public class C1316e {

    /* renamed from: a */
    private Context f4081a;

    /* renamed from: b */
    private SharedPreferences f4082b;

    public C1316e(Context context) {
        this.f4081a = context;
    }

    /* renamed from: b */
    private SharedPreferences m5170b() {
        SharedPreferences sharedPreferences;
        synchronized (C1316e.class) {
            if (this.f4082b == null) {
                this.f4082b = this.f4081a.getSharedPreferences("androidx.work.util.preferences", 0);
            }
            sharedPreferences = this.f4082b;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public void mo6655a(boolean z) {
        m5170b().edit().putBoolean("reschedule_needed", z).apply();
    }

    /* renamed from: a */
    public boolean mo6656a() {
        return m5170b().getBoolean("reschedule_needed", false);
    }
}
