package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class CreationContextFactory_Factory implements C0001b<CreationContextFactory> {
    private final C3295a<Context> applicationContextProvider;
    private final C3295a<Clock> monotonicClockProvider;
    private final C3295a<Clock> wallClockProvider;

    public CreationContextFactory_Factory(C3295a<Context> aVar, C3295a<Clock> aVar2, C3295a<Clock> aVar3) {
        this.applicationContextProvider = aVar;
        this.wallClockProvider = aVar2;
        this.monotonicClockProvider = aVar3;
    }

    public static CreationContextFactory_Factory create(C3295a<Context> aVar, C3295a<Clock> aVar2, C3295a<Clock> aVar3) {
        return new CreationContextFactory_Factory(aVar, aVar2, aVar3);
    }

    public static CreationContextFactory newInstance(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    public CreationContextFactory get() {
        return new CreationContextFactory(this.applicationContextProvider.get(), this.wallClockProvider.get(), this.monotonicClockProvider.get());
    }
}
