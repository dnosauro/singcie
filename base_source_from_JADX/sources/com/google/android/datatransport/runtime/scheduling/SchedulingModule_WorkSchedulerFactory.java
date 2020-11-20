package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class SchedulingModule_WorkSchedulerFactory implements C0001b<WorkScheduler> {
    private final C3295a<Clock> clockProvider;
    private final C3295a<SchedulerConfig> configProvider;
    private final C3295a<Context> contextProvider;
    private final C3295a<EventStore> eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(C3295a<Context> aVar, C3295a<EventStore> aVar2, C3295a<SchedulerConfig> aVar3, C3295a<Clock> aVar4) {
        this.contextProvider = aVar;
        this.eventStoreProvider = aVar2;
        this.configProvider = aVar3;
        this.clockProvider = aVar4;
    }

    public static SchedulingModule_WorkSchedulerFactory create(C3295a<Context> aVar, C3295a<EventStore> aVar2, C3295a<SchedulerConfig> aVar3, C3295a<Clock> aVar4) {
        return new SchedulingModule_WorkSchedulerFactory(aVar, aVar2, aVar3, aVar4);
    }

    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) C0004e.m4a(SchedulingModule.workScheduler(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public WorkScheduler get() {
        return workScheduler(this.contextProvider.get(), this.eventStoreProvider.get(), this.configProvider.get(), this.clockProvider.get());
    }
}
