package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.p064a.C1309c;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    C1309c<ListenableWorker.C1178a> mFuture;

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.C1178a doWork();

    public final ListenableFuture<ListenableWorker.C1178a> startWork() {
        this.mFuture = C1309c.m5145d();
        getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                try {
                    Worker.this.mFuture.mo6622a(Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.mFuture.mo6623a(th);
                }
            }
        });
        return this.mFuture;
    }
}
