package com.google.android.datatransport.runtime.time;

import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class TimeModule_UptimeClockFactory implements C0001b<Clock> {
    private static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();

    public static TimeModule_UptimeClockFactory create() {
        return INSTANCE;
    }

    public static Clock uptimeClock() {
        return (Clock) C0004e.m4a(TimeModule.uptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return uptimeClock();
    }
}
