package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;

public abstract class SchedulingModule {
    static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, @Monotonic Clock clock) {
        return Build.VERSION.SDK_INT >= 21 ? new JobInfoScheduler(context, eventStore, schedulerConfig) : new AlarmManagerScheduler(context, eventStore, clock, schedulerConfig);
    }

    /* access modifiers changed from: package-private */
    public abstract Scheduler scheduler(DefaultScheduler defaultScheduler);
}
