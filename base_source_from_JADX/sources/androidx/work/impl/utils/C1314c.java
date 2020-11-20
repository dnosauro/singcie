package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: androidx.work.impl.utils.c */
public class C1314c {

    /* renamed from: a */
    private final Context f4077a;

    /* renamed from: b */
    private SharedPreferences f4078b;

    /* renamed from: c */
    private boolean f4079c;

    public C1314c(Context context) {
        this.f4077a = context;
    }

    /* renamed from: a */
    private int m5164a(String str) {
        int i = 0;
        int i2 = this.f4078b.getInt(str, 0);
        if (i2 != Integer.MAX_VALUE) {
            i = i2 + 1;
        }
        m5165a(str, i);
        return i2;
    }

    /* renamed from: a */
    private void m5165a(String str, int i) {
        this.f4078b.edit().putInt(str, i).apply();
    }

    /* renamed from: b */
    private void m5166b() {
        if (!this.f4079c) {
            this.f4078b = this.f4077a.getSharedPreferences("androidx.work.util.id", 0);
            this.f4079c = true;
        }
    }

    /* renamed from: a */
    public int mo6653a() {
        int a;
        synchronized (C1314c.class) {
            m5166b();
            a = m5164a("next_alarm_manager_id");
        }
        return a;
    }

    /* renamed from: a */
    public int mo6654a(int i, int i2) {
        synchronized (C1314c.class) {
            m5166b();
            int a = m5164a("next_job_scheduler_id");
            if (a >= i) {
                if (a <= i2) {
                    i = a;
                }
            }
            m5165a("next_job_scheduler_id", i + 1);
        }
        return i;
    }
}
