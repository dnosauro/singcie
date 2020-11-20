package com.google.android.datatransport.runtime.scheduling.persistence;

import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class EventStoreModule_DbNameFactory implements C0001b<String> {
    private static final EventStoreModule_DbNameFactory INSTANCE = new EventStoreModule_DbNameFactory();

    public static EventStoreModule_DbNameFactory create() {
        return INSTANCE;
    }

    public static String dbName() {
        return (String) C0004e.m4a(EventStoreModule.dbName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public String get() {
        return dbName();
    }
}
