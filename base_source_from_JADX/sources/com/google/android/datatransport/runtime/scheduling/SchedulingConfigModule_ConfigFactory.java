package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class SchedulingConfigModule_ConfigFactory implements C0001b<SchedulerConfig> {
    private final C3295a<Clock> clockProvider;

    public SchedulingConfigModule_ConfigFactory(C3295a<Clock> aVar) {
        this.clockProvider = aVar;
    }

    public static SchedulerConfig config(Clock clock) {
        return (SchedulerConfig) C0004e.m4a(SchedulingConfigModule.config(clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static SchedulingConfigModule_ConfigFactory create(C3295a<Clock> aVar) {
        return new SchedulingConfigModule_ConfigFactory(aVar);
    }

    public SchedulerConfig get() {
        return config(this.clockProvider.get());
    }
}
