package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.p169a.C3295a;
import p000a.p001a.C0001b;

public final class SchemaManager_Factory implements C0001b<SchemaManager> {
    private final C3295a<Context> contextProvider;
    private final C3295a<String> dbNameProvider;
    private final C3295a<Integer> schemaVersionProvider;

    public SchemaManager_Factory(C3295a<Context> aVar, C3295a<String> aVar2, C3295a<Integer> aVar3) {
        this.contextProvider = aVar;
        this.dbNameProvider = aVar2;
        this.schemaVersionProvider = aVar3;
    }

    public static SchemaManager_Factory create(C3295a<Context> aVar, C3295a<String> aVar2, C3295a<Integer> aVar3) {
        return new SchemaManager_Factory(aVar, aVar2, aVar3);
    }

    public static SchemaManager newInstance(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    public SchemaManager get() {
        return new SchemaManager(this.contextProvider.get(), this.dbNameProvider.get(), this.schemaVersionProvider.get().intValue());
    }
}
