package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Timeout implements TestRule {
    private final boolean lookForStuckThread;
    private final TimeUnit timeUnit;
    private final long timeout;

    public static class Builder {
        private boolean lookForStuckThread = false;
        private TimeUnit timeUnit = TimeUnit.SECONDS;
        private long timeout = 0;

        protected Builder() {
        }

        public Timeout build() {
            return new Timeout(this);
        }

        /* access modifiers changed from: protected */
        public boolean getLookingForStuckThread() {
            return this.lookForStuckThread;
        }

        /* access modifiers changed from: protected */
        public TimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        /* access modifiers changed from: protected */
        public long getTimeout() {
            return this.timeout;
        }

        public Builder withLookingForStuckThread(boolean z) {
            this.lookForStuckThread = z;
            return this;
        }

        public Builder withTimeout(long j, TimeUnit timeUnit2) {
            this.timeout = j;
            this.timeUnit = timeUnit2;
            return this;
        }
    }

    @Deprecated
    public Timeout(int i) {
        this((long) i, TimeUnit.MILLISECONDS);
    }

    public Timeout(long j, TimeUnit timeUnit2) {
        this.timeout = j;
        this.timeUnit = timeUnit2;
        this.lookForStuckThread = false;
    }

    protected Timeout(Builder builder) {
        this.timeout = builder.getTimeout();
        this.timeUnit = builder.getTimeUnit();
        this.lookForStuckThread = builder.getLookingForStuckThread();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Timeout millis(long j) {
        return new Timeout(j, TimeUnit.MILLISECONDS);
    }

    public static Timeout seconds(long j) {
        return new Timeout(j, TimeUnit.SECONDS);
    }

    public Statement apply(Statement statement, Description description) {
        try {
            return createFailOnTimeoutStatement(statement);
        } catch (Exception e) {
            return new Statement() {
                public void evaluate() {
                    throw new RuntimeException("Invalid parameters for Timeout", e);
                }
            };
        }
    }

    /* access modifiers changed from: protected */
    public Statement createFailOnTimeoutStatement(Statement statement) {
        return FailOnTimeout.builder().withTimeout(this.timeout, this.timeUnit).withLookingForStuckThread(this.lookForStuckThread).build(statement);
    }

    /* access modifiers changed from: protected */
    public final boolean getLookingForStuckThread() {
        return this.lookForStuckThread;
    }

    /* access modifiers changed from: protected */
    public final long getTimeout(TimeUnit timeUnit2) {
        return timeUnit2.convert(this.timeout, this.timeUnit);
    }
}
