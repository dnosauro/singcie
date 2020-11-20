package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class MetadataBackendRegistry_Factory implements C0001b<MetadataBackendRegistry> {
    private final C3295a<Context> applicationContextProvider;
    private final C3295a<CreationContextFactory> creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(C3295a<Context> aVar, C3295a<CreationContextFactory> aVar2) {
        this.applicationContextProvider = aVar;
        this.creationContextFactoryProvider = aVar2;
    }

    public static MetadataBackendRegistry_Factory create(C3295a<Context> aVar, C3295a<CreationContextFactory> aVar2) {
        return new MetadataBackendRegistry_Factory(aVar, aVar2);
    }

    public static MetadataBackendRegistry newInstance(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    public MetadataBackendRegistry get() {
        return new MetadataBackendRegistry(this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }
}
