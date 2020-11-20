package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class DefaultScheduler_Factory implements C0001b<DefaultScheduler> {
    private final C3295a<BackendRegistry> backendRegistryProvider;
    private final C3295a<EventStore> eventStoreProvider;
    private final C3295a<Executor> executorProvider;
    private final C3295a<SynchronizationGuard> guardProvider;
    private final C3295a<WorkScheduler> workSchedulerProvider;

    public DefaultScheduler_Factory(C3295a<Executor> aVar, C3295a<BackendRegistry> aVar2, C3295a<WorkScheduler> aVar3, C3295a<EventStore> aVar4, C3295a<SynchronizationGuard> aVar5) {
        this.executorProvider = aVar;
        this.backendRegistryProvider = aVar2;
        this.workSchedulerProvider = aVar3;
        this.eventStoreProvider = aVar4;
        this.guardProvider = aVar5;
    }

    public static DefaultScheduler_Factory create(C3295a<Executor> aVar, C3295a<BackendRegistry> aVar2, C3295a<WorkScheduler> aVar3, C3295a<EventStore> aVar4, C3295a<SynchronizationGuard> aVar5) {
        return new DefaultScheduler_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    public DefaultScheduler get() {
        return new DefaultScheduler(this.executorProvider.get(), this.backendRegistryProvider.get(), this.workSchedulerProvider.get(), this.eventStoreProvider.get(), this.guardProvider.get());
    }
}
