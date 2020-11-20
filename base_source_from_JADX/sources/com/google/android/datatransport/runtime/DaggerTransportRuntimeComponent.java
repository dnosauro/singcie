package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.p169a.C3295a;
import p000a.p001a.C0000a;
import p000a.p001a.C0002c;
import p000a.p001a.C0004e;

final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    private C3295a<SchedulerConfig> configProvider;
    private C3295a creationContextFactoryProvider;
    private C3295a<DefaultScheduler> defaultSchedulerProvider;
    private C3295a<Executor> executorProvider;
    private C3295a metadataBackendRegistryProvider;
    private C3295a<SQLiteEventStore> sQLiteEventStoreProvider;
    private C3295a schemaManagerProvider;
    private C3295a<Context> setApplicationContextProvider;
    private C3295a<TransportRuntime> transportRuntimeProvider;
    private C3295a<Uploader> uploaderProvider;
    private C3295a<WorkInitializer> workInitializerProvider;
    private C3295a<WorkScheduler> workSchedulerProvider;

    private static final class Builder implements TransportRuntimeComponent.Builder {
        private Context setApplicationContext;

        private Builder() {
        }

        public TransportRuntimeComponent build() {
            C0004e.m5a(this.setApplicationContext, Context.class);
            return new DaggerTransportRuntimeComponent(this.setApplicationContext);
        }

        public Builder setApplicationContext(Context context) {
            this.setApplicationContext = (Context) C0004e.m3a(context);
            return this;
        }
    }

    private DaggerTransportRuntimeComponent(Context context) {
        initialize(context);
    }

    public static TransportRuntimeComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(Context context) {
        this.executorProvider = C0000a.m1a(ExecutionModule_ExecutorFactory.create());
        this.setApplicationContextProvider = C0002c.m2a(context);
        this.creationContextFactoryProvider = CreationContextFactory_Factory.create(this.setApplicationContextProvider, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.metadataBackendRegistryProvider = C0000a.m1a(MetadataBackendRegistry_Factory.create(this.setApplicationContextProvider, this.creationContextFactoryProvider));
        this.schemaManagerProvider = SchemaManager_Factory.create(this.setApplicationContextProvider, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.sQLiteEventStoreProvider = C0000a.m1a(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.schemaManagerProvider));
        this.configProvider = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.workSchedulerProvider = SchedulingModule_WorkSchedulerFactory.create(this.setApplicationContextProvider, this.sQLiteEventStoreProvider, this.configProvider, TimeModule_UptimeClockFactory.create());
        C3295a<Executor> aVar = this.executorProvider;
        C3295a aVar2 = this.metadataBackendRegistryProvider;
        C3295a<WorkScheduler> aVar3 = this.workSchedulerProvider;
        C3295a<SQLiteEventStore> aVar4 = this.sQLiteEventStoreProvider;
        this.defaultSchedulerProvider = DefaultScheduler_Factory.create(aVar, aVar2, aVar3, aVar4, aVar4);
        C3295a<Context> aVar5 = this.setApplicationContextProvider;
        C3295a aVar6 = this.metadataBackendRegistryProvider;
        C3295a<SQLiteEventStore> aVar7 = this.sQLiteEventStoreProvider;
        this.uploaderProvider = Uploader_Factory.create(aVar5, aVar6, aVar7, this.workSchedulerProvider, this.executorProvider, aVar7, TimeModule_EventClockFactory.create());
        C3295a<Executor> aVar8 = this.executorProvider;
        C3295a<SQLiteEventStore> aVar9 = this.sQLiteEventStoreProvider;
        this.workInitializerProvider = WorkInitializer_Factory.create(aVar8, aVar9, this.workSchedulerProvider, aVar9);
        this.transportRuntimeProvider = C0000a.m1a(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.defaultSchedulerProvider, this.uploaderProvider, this.workInitializerProvider));
    }

    /* access modifiers changed from: package-private */
    public EventStore getEventStore() {
        return this.sQLiteEventStoreProvider.get();
    }

    /* access modifiers changed from: package-private */
    public TransportRuntime getTransportRuntime() {
        return this.transportRuntimeProvider.get();
    }
}
