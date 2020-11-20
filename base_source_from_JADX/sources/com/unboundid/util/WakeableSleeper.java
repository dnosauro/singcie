package com.unboundid.util;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class WakeableSleeper implements Serializable {
    private static final long serialVersionUID = 755656862953269760L;
    private final AtomicBoolean sleeping = new AtomicBoolean(false);
    private final AtomicLong wakeupCount = new AtomicLong(0);

    public boolean sleep(long j) {
        boolean z;
        synchronized (this.wakeupCount) {
            z = true;
            Validator.ensureTrue(this.sleeping.compareAndSet(false, true), "WakeableSleeper.sleep() must not be invoked concurrently by multiple threads against the same instance.");
            try {
                long j2 = this.wakeupCount.get();
                this.wakeupCount.wait(j);
                if (j2 != this.wakeupCount.get()) {
                    z = false;
                }
                this.sleeping.set(false);
            } catch (InterruptedException e) {
                try {
                    Debug.debugException(e);
                    return false;
                } finally {
                    this.sleeping.set(false);
                }
            }
        }
        return z;
    }

    public void wakeup() {
        synchronized (this.wakeupCount) {
            this.wakeupCount.incrementAndGet();
            this.wakeupCount.notifyAll();
        }
    }
}
