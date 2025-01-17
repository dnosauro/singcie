package com.google.android.gms.common.api.internal;

import androidx.p018c.C0400a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zak {
    private final C0400a<zai<?>, ConnectionResult> zaay = new C0400a<>();
    private final C0400a<zai<?>, String> zadb = new C0400a<>();
    private final TaskCompletionSource<Map<zai<?>, String>> zadc = new TaskCompletionSource<>();
    private int zadd;
    private boolean zade = false;

    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        for (GoogleApi zak : iterable) {
            this.zaay.put(zak.zak(), null);
        }
        this.zadd = this.zaay.keySet().size();
    }

    public final Task<Map<zai<?>, String>> getTask() {
        return this.zadc.getTask();
    }

    public final void zaa(zai<?> zai, ConnectionResult connectionResult, String str) {
        this.zaay.put(zai, connectionResult);
        this.zadb.put(zai, str);
        this.zadd--;
        if (!connectionResult.isSuccess()) {
            this.zade = true;
        }
        if (this.zadd != 0) {
            return;
        }
        if (this.zade) {
            this.zadc.setException(new AvailabilityException(this.zaay));
            return;
        }
        this.zadc.setResult(this.zadb);
    }

    public final Set<zai<?>> zap() {
        return this.zaay.keySet();
    }
}
