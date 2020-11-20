package com.unboundid.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class LDAPSDKThreadFactory implements ThreadFactory {
    private final String baseName;
    private final boolean daemon;
    private final AtomicLong threadCounter;
    private final ThreadGroup threadGroup;

    public LDAPSDKThreadFactory(String str, boolean z) {
        this(str, z, (ThreadGroup) null);
    }

    public LDAPSDKThreadFactory(String str, boolean z, ThreadGroup threadGroup2) {
        this.baseName = str;
        this.daemon = z;
        this.threadGroup = threadGroup2;
        this.threadCounter = new AtomicLong(1);
    }

    public Thread newThread(Runnable runnable) {
        this.baseName + ' ' + this.threadCounter.getAndIncrement();
        Thread thread = new Thread(this.threadGroup, runnable, this.baseName);
        thread.setDaemon(this.daemon);
        return thread;
    }
}
