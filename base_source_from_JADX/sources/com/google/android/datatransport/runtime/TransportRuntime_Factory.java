package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class TransportRuntime_Factory implements C0001b<TransportRuntime> {
    private final C3295a<Clock> eventClockProvider;
    private final C3295a<WorkInitializer> initializerProvider;
    private final C3295a<Scheduler> schedulerProvider;
    private final C3295a<Uploader> uploaderProvider;
    private final C3295a<Clock> uptimeClockProvider;

    public TransportRuntime_Factory(C3295a<Clock> aVar, C3295a<Clock> aVar2, C3295a<Scheduler> aVar3, C3295a<Uploader> aVar4, C3295a<WorkInitializer> aVar5) {
        this.eventClockProvider = aVar;
        this.uptimeClockProvider = aVar2;
        this.schedulerProvider = aVar3;
        this.uploaderProvider = aVar4;
        this.initializerProvider = aVar5;
    }

    public static TransportRuntime_Factory create(C3295a<Clock> aVar, C3295a<Clock> aVar2, C3295a<Scheduler> aVar3, C3295a<Uploader> aVar4, C3295a<WorkInitializer> aVar5) {
        return new TransportRuntime_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    public TransportRuntime get() {
        return new TransportRuntime(this.eventClockProvider.get(), this.uptimeClockProvider.get(), this.schedulerProvider.get(), this.uploaderProvider.get(), this.initializerProvider.get());
    }
}
