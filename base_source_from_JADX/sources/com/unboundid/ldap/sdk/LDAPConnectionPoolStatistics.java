package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public final class LDAPConnectionPoolStatistics implements Serializable {
    private static final long serialVersionUID = 1493039391352814874L;
    private final AtomicLong numConnectionsClosedDefunct = new AtomicLong(0);
    private final AtomicLong numConnectionsClosedExpired = new AtomicLong(0);
    private final AtomicLong numConnectionsClosedUnneeded = new AtomicLong(0);
    private final AtomicLong numFailedCheckouts = new AtomicLong(0);
    private final AtomicLong numFailedConnectionAttempts = new AtomicLong(0);
    private final AtomicLong numReleasedValid = new AtomicLong(0);
    private final AtomicLong numSuccessfulCheckouts = new AtomicLong(0);
    private final AtomicLong numSuccessfulCheckoutsAfterWait = new AtomicLong(0);
    private final AtomicLong numSuccessfulCheckoutsNewConnection = new AtomicLong(0);
    private final AtomicLong numSuccessfulCheckoutsWithoutWait = new AtomicLong(0);
    private final AtomicLong numSuccessfulConnectionAttempts = new AtomicLong(0);
    private final AbstractConnectionPool pool;

    public LDAPConnectionPoolStatistics(AbstractConnectionPool abstractConnectionPool) {
        this.pool = abstractConnectionPool;
    }

    public int getMaximumAvailableConnections() {
        return this.pool.getMaximumAvailableConnections();
    }

    public int getNumAvailableConnections() {
        return this.pool.getCurrentAvailableConnections();
    }

    public long getNumConnectionsClosedDefunct() {
        return this.numConnectionsClosedDefunct.get();
    }

    public long getNumConnectionsClosedExpired() {
        return this.numConnectionsClosedExpired.get();
    }

    public long getNumConnectionsClosedUnneeded() {
        return this.numConnectionsClosedUnneeded.get();
    }

    public long getNumFailedCheckouts() {
        return this.numFailedCheckouts.get();
    }

    public long getNumFailedConnectionAttempts() {
        return this.numFailedConnectionAttempts.get();
    }

    public long getNumReleasedValid() {
        return this.numReleasedValid.get();
    }

    public long getNumSuccessfulCheckouts() {
        return this.numSuccessfulCheckouts.get();
    }

    public long getNumSuccessfulCheckoutsAfterWaiting() {
        return this.numSuccessfulCheckoutsAfterWait.get();
    }

    public long getNumSuccessfulCheckoutsNewConnection() {
        return this.numSuccessfulCheckoutsNewConnection.get();
    }

    public long getNumSuccessfulCheckoutsWithoutWaiting() {
        return this.numSuccessfulCheckoutsWithoutWait.get();
    }

    public long getNumSuccessfulConnectionAttempts() {
        return this.numSuccessfulConnectionAttempts.get();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumConnectionsClosedDefunct() {
        this.numConnectionsClosedDefunct.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumConnectionsClosedExpired() {
        this.numConnectionsClosedExpired.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumConnectionsClosedUnneeded() {
        this.numConnectionsClosedUnneeded.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumFailedCheckouts() {
        this.numFailedCheckouts.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumFailedConnectionAttempts() {
        this.numFailedConnectionAttempts.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumReleasedValid() {
        this.numReleasedValid.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumSuccessfulCheckoutsAfterWaiting() {
        this.numSuccessfulCheckouts.incrementAndGet();
        this.numSuccessfulCheckoutsAfterWait.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumSuccessfulCheckoutsNewConnection() {
        this.numSuccessfulCheckouts.incrementAndGet();
        this.numSuccessfulCheckoutsNewConnection.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumSuccessfulCheckoutsWithoutWaiting() {
        this.numSuccessfulCheckouts.incrementAndGet();
        this.numSuccessfulCheckoutsWithoutWait.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumSuccessfulConnectionAttempts() {
        this.numSuccessfulConnectionAttempts.incrementAndGet();
    }

    public void reset() {
        this.numSuccessfulConnectionAttempts.set(0);
        this.numFailedConnectionAttempts.set(0);
        this.numConnectionsClosedDefunct.set(0);
        this.numConnectionsClosedExpired.set(0);
        this.numConnectionsClosedUnneeded.set(0);
        this.numSuccessfulCheckouts.set(0);
        this.numSuccessfulCheckoutsAfterWait.set(0);
        this.numSuccessfulCheckoutsNewConnection.set(0);
        this.numSuccessfulCheckoutsWithoutWait.set(0);
        this.numFailedCheckouts.set(0);
        this.numReleasedValid.set(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        StringBuilder sb2 = sb;
        long j = this.numSuccessfulConnectionAttempts.get();
        long j2 = this.numFailedConnectionAttempts.get();
        long j3 = this.numConnectionsClosedDefunct.get();
        long j4 = this.numConnectionsClosedExpired.get();
        long j5 = this.numConnectionsClosedUnneeded.get();
        long j6 = this.numSuccessfulCheckouts.get();
        long j7 = this.numFailedCheckouts.get();
        long j8 = this.numReleasedValid.get();
        sb2.append("LDAPConnectionPoolStatistics(numAvailableConnections=");
        sb2.append((long) this.pool.getCurrentAvailableConnections());
        sb2.append(", maxAvailableConnections=");
        sb2.append((long) this.pool.getMaximumAvailableConnections());
        sb2.append(", numSuccessfulConnectionAttempts=");
        sb2.append(j);
        sb2.append(", numFailedConnectionAttempts=");
        sb2.append(j2);
        sb2.append(", numConnectionsClosedDefunct=");
        sb2.append(j3);
        sb2.append(", numConnectionsClosedExpired=");
        sb2.append(j4);
        sb2.append(", numConnectionsClosedUnneeded=");
        sb2.append(j5);
        sb2.append(", numSuccessfulCheckouts=");
        sb2.append(j6);
        sb2.append(", numFailedCheckouts=");
        sb2.append(j7);
        sb2.append(", numReleasedValid=");
        sb2.append(j8);
        sb2.append(')');
    }
}
