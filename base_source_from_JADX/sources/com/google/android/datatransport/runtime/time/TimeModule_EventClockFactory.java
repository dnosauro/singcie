package com.google.android.datatransport.runtime.time;

import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class TimeModule_EventClockFactory implements C0001b<Clock> {
    private static final TimeModule_EventClockFactory INSTANCE = new TimeModule_EventClockFactory();

    public static TimeModule_EventClockFactory create() {
        return INSTANCE;
    }

    public static Clock eventClock() {
        return (Clock) C0004e.m4a(TimeModule.eventClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return eventClock();
    }
}
