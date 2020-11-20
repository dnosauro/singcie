package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class WorkInitializer_Factory implements C0001b<WorkInitializer> {
    private final C3295a<Executor> executorProvider;
    private final C3295a<SynchronizationGuard> guardProvider;
    private final C3295a<WorkScheduler> schedulerProvider;
    private final C3295a<EventStore> storeProvider;

    public WorkInitializer_Factory(C3295a<Executor> aVar, C3295a<EventStore> aVar2, C3295a<WorkScheduler> aVar3, C3295a<SynchronizationGuard> aVar4) {
        this.executorProvider = aVar;
        this.storeProvider = aVar2;
        this.schedulerProvider = aVar3;
        this.guardProvider = aVar4;
    }

    public static WorkInitializer_Factory create(C3295a<Executor> aVar, C3295a<EventStore> aVar2, C3295a<WorkScheduler> aVar3, C3295a<SynchronizationGuard> aVar4) {
        return new WorkInitializer_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    public WorkInitializer get() {
        return new WorkInitializer(this.executorProvider.get(), this.storeProvider.get(), this.schedulerProvider.get(), this.guardProvider.get());
    }
}
