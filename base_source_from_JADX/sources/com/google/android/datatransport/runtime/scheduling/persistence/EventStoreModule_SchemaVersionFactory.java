package com.google.android.datatransport.runtime.scheduling.persistence;

import p000a.p001a.C0001b;

public final class EventStoreModule_SchemaVersionFactory implements C0001b<Integer> {
    private static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();

    public static EventStoreModule_SchemaVersionFactory create() {
        return INSTANCE;
    }

    public static int schemaVersion() {
        return EventStoreModule.schemaVersion();
    }

    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }
}
