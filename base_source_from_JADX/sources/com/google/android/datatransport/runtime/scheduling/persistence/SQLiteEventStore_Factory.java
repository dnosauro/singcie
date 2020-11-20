package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.time.Clock;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class SQLiteEventStore_Factory implements C0001b<SQLiteEventStore> {
    private final C3295a<Clock> clockProvider;
    private final C3295a<EventStoreConfig> configProvider;
    private final C3295a<SchemaManager> schemaManagerProvider;
    private final C3295a<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(C3295a<Clock> aVar, C3295a<Clock> aVar2, C3295a<EventStoreConfig> aVar3, C3295a<SchemaManager> aVar4) {
        this.wallClockProvider = aVar;
        this.clockProvider = aVar2;
        this.configProvider = aVar3;
        this.schemaManagerProvider = aVar4;
    }

    public static SQLiteEventStore_Factory create(C3295a<Clock> aVar, C3295a<Clock> aVar2, C3295a<EventStoreConfig> aVar3, C3295a<SchemaManager> aVar4) {
        return new SQLiteEventStore_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2);
    }

    public SQLiteEventStore get() {
        return new SQLiteEventStore(this.wallClockProvider.get(), this.clockProvider.get(), this.configProvider.get(), this.schemaManagerProvider.get());
    }
}
