package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class Uploader_Factory implements C0001b<Uploader> {
    private final C3295a<BackendRegistry> backendRegistryProvider;
    private final C3295a<Clock> clockProvider;
    private final C3295a<Context> contextProvider;
    private final C3295a<EventStore> eventStoreProvider;
    private final C3295a<Executor> executorProvider;
    private final C3295a<SynchronizationGuard> guardProvider;
    private final C3295a<WorkScheduler> workSchedulerProvider;

    public Uploader_Factory(C3295a<Context> aVar, C3295a<BackendRegistry> aVar2, C3295a<EventStore> aVar3, C3295a<WorkScheduler> aVar4, C3295a<Executor> aVar5, C3295a<SynchronizationGuard> aVar6, C3295a<Clock> aVar7) {
        this.contextProvider = aVar;
        this.backendRegistryProvider = aVar2;
        this.eventStoreProvider = aVar3;
        this.workSchedulerProvider = aVar4;
        this.executorProvider = aVar5;
        this.guardProvider = aVar6;
        this.clockProvider = aVar7;
    }

    public static Uploader_Factory create(C3295a<Context> aVar, C3295a<BackendRegistry> aVar2, C3295a<EventStore> aVar3, C3295a<WorkScheduler> aVar4, C3295a<Executor> aVar5, C3295a<SynchronizationGuard> aVar6, C3295a<Clock> aVar7) {
        return new Uploader_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock);
    }

    public Uploader get() {
        return new Uploader(this.contextProvider.get(), this.backendRegistryProvider.get(), this.eventStoreProvider.get(), this.workSchedulerProvider.get(), this.executorProvider.get(), this.guardProvider.get(), this.clockProvider.get());
    }
}
