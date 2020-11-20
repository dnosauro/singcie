package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
import p000a.p001a.C0001b;
import p000a.p001a.C0004e;

public final class ExecutionModule_ExecutorFactory implements C0001b<Executor> {
    private static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();

    public static ExecutionModule_ExecutorFactory create() {
        return INSTANCE;
    }

    public static Executor executor() {
        return (Executor) C0004e.m4a(ExecutionModule.executor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Executor get() {
        return executor();
    }
}
