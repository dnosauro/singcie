package org.junit.runner.notification;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

@RunListener.ThreadSafe
final class SynchronizedRunListener extends RunListener {
    private final RunListener listener;
    private final Object monitor;

    SynchronizedRunListener(RunListener runListener, Object obj) {
        this.listener = runListener;
        this.monitor = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SynchronizedRunListener)) {
            return false;
        }
        return this.listener.equals(((SynchronizedRunListener) obj).listener);
    }

    public int hashCode() {
        return this.listener.hashCode();
    }

    public void testAssumptionFailure(Failure failure) {
        synchronized (this.monitor) {
            this.listener.testAssumptionFailure(failure);
        }
    }

    public void testFailure(Failure failure) {
        synchronized (this.monitor) {
            this.listener.testFailure(failure);
        }
    }

    public void testFinished(Description description) {
        synchronized (this.monitor) {
            this.listener.testFinished(description);
        }
    }

    public void testIgnored(Description description) {
        synchronized (this.monitor) {
            this.listener.testIgnored(description);
        }
    }

    public void testRunFinished(Result result) {
        synchronized (this.monitor) {
            this.listener.testRunFinished(result);
        }
    }

    public void testRunStarted(Description description) {
        synchronized (this.monitor) {
            this.listener.testRunStarted(description);
        }
    }

    public void testStarted(Description description) {
        synchronized (this.monitor) {
            this.listener.testStarted(description);
        }
    }

    public String toString() {
        return this.listener.toString() + " (with synchronization wrapper)";
    }
}
