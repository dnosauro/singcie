package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.work.impl.utils.p065b.C1311a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    private Context mAppContext;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    /* renamed from: androidx.work.ListenableWorker$a */
    public static abstract class C1178a {

        /* renamed from: androidx.work.ListenableWorker$a$a */
        public static final class C1179a extends C1178a {

            /* renamed from: a */
            private final C1192e f3701a;

            public C1179a() {
                this(C1192e.f3752a);
            }

            public C1179a(C1192e eVar) {
                this.f3701a = eVar;
            }

            /* renamed from: d */
            public C1192e mo6345d() {
                return this.f3701a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f3701a.equals(((C1179a) obj).f3701a);
            }

            public int hashCode() {
                return (C1179a.class.getName().hashCode() * 31) + this.f3701a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f3701a + '}';
            }
        }

        /* renamed from: androidx.work.ListenableWorker$a$b */
        public static final class C1180b extends C1178a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return C1180b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* renamed from: androidx.work.ListenableWorker$a$c */
        public static final class C1181c extends C1178a {

            /* renamed from: a */
            private final C1192e f3702a;

            public C1181c() {
                this(C1192e.f3752a);
            }

            public C1181c(C1192e eVar) {
                this.f3702a = eVar;
            }

            /* renamed from: d */
            public C1192e mo6352d() {
                return this.f3702a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f3702a.equals(((C1181c) obj).f3702a);
            }

            public int hashCode() {
                return (C1181c.class.getName().hashCode() * 31) + this.f3702a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f3702a + '}';
            }
        }

        C1178a() {
        }

        /* renamed from: a */
        public static C1178a m4667a() {
            return new C1181c();
        }

        /* renamed from: a */
        public static C1178a m4668a(C1192e eVar) {
            return new C1181c(eVar);
        }

        /* renamed from: b */
        public static C1178a m4669b() {
            return new C1180b();
        }

        /* renamed from: c */
        public static C1178a m4670c() {
            return new C1179a();
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.mo6365h();
    }

    public final UUID getId() {
        return this.mWorkerParams.mo6358a();
    }

    public final C1192e getInputData() {
        return this.mWorkerParams.mo6359b();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.mo6363f();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.mo6364g();
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.mo6360c();
    }

    public C1311a getTaskExecutor() {
        return this.mWorkerParams.mo6366i();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.mo6362e();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.mo6361d();
    }

    public C1340q getWorkerFactory() {
        return this.mWorkerParams.mo6367j();
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<C1178a> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
