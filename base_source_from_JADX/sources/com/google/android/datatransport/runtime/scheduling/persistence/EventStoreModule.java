package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public abstract class EventStoreModule {
    static String dbName() {
        return "com.google.android.datatransport.events";
    }

    static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    public abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);
}
