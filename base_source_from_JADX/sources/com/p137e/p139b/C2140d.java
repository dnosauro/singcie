package com.p137e.p139b;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.e.b.d */
public class C2140d {
    /* renamed from: a */
    public static void m8401a(Runnable runnable) {
        new Thread(runnable).start();
    }

    /* renamed from: a */
    public static void m8402a(final Runnable runnable, int i) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                runnable.run();
            }
        }, (long) i);
    }
}
