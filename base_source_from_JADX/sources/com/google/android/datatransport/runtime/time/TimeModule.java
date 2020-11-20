package com.google.android.datatransport.runtime.time;

public abstract class TimeModule {
    @WallTime
    static Clock eventClock() {
        return new WallTimeClock();
    }

    @Monotonic
    static Clock uptimeClock() {
        return new UptimeClock();
    }
}
