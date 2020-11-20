package androidx.work.impl.utils.p064a;

import java.util.concurrent.Executor;

/* renamed from: androidx.work.impl.utils.a.b */
enum C1308b implements Executor {
    INSTANCE;

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
