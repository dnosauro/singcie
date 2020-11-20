package com.google.android.datatransport.runtime.scheduling.persistence;

import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class EventStoreModule_StoreConfigFactory implements C0001b<EventStoreConfig> {
    private static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();

    public static EventStoreModule_StoreConfigFactory create() {
        return INSTANCE;
    }

    public static EventStoreConfig storeConfig() {
        return (EventStoreConfig) C0004e.m4a(EventStoreModule.storeConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public EventStoreConfig get() {
        return storeConfig();
    }
}
