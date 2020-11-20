package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class LDAPConnectionPoolHealthCheckThread extends Thread {
    private final AbstractConnectionPool pool;
    private final LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(1);
    private final AtomicBoolean stopRequested = new AtomicBoolean(false);
    private volatile Thread thread = null;

    LDAPConnectionPoolHealthCheckThread(AbstractConnectionPool abstractConnectionPool) {
        setName("Health Check Thread for " + abstractConnectionPool.toString());
        setDaemon(true);
        this.pool = abstractConnectionPool;
    }

    public void run() {
        this.thread = Thread.currentThread();
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.stopRequested.get()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 >= this.pool.getHealthCheckIntervalMillis()) {
                    try {
                        this.pool.doHealthCheck();
                    } catch (Exception e) {
                        Debug.debugException(e);
                    }
                } else {
                    try {
                        this.queue.poll(Math.min(this.pool.getHealthCheckIntervalMillis() - currentTimeMillis2, 30000), TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                        Debug.debugException(e2);
                    }
                }
            }
            this.thread = null;
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public void stopRunning() {
        this.stopRequested.set(true);
        wakeUp();
        Thread thread2 = this.thread;
        if (thread2 != null) {
            try {
                thread2.join();
            } catch (Exception e) {
                Debug.debugException(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void wakeUp() {
        this.queue.offer(new Object());
    }
}
