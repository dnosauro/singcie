package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncRequestID implements Serializable, Future<LDAPResult> {
    private static final long serialVersionUID = 8244005138437962030L;
    private final AtomicBoolean cancelRequested = new AtomicBoolean(false);
    private final LDAPConnection connection;
    private final int messageID;
    private final AtomicReference<LDAPResult> result = new AtomicReference<>();
    private final ArrayBlockingQueue<LDAPResult> resultQueue = new ArrayBlockingQueue<>(1);
    private volatile AsyncTimeoutTimerTask timerTask = null;

    AsyncRequestID(int i, LDAPConnection lDAPConnection) {
        this.messageID = i;
        this.connection = lDAPConnection;
    }

    public boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        try {
            this.cancelRequested.set(true);
            this.result.compareAndSet((Object) null, new LDAPResult(this.messageID, ResultCode.USER_CANCELED, LDAPMessages.INFO_ASYNC_REQUEST_USER_CANCELED.get(), (String) null, StaticUtils.NO_STRINGS, StaticUtils.NO_CONTROLS));
            this.connection.abandon(this);
        } catch (Exception e) {
            Debug.debugException(e);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof AsyncRequestID) && ((AsyncRequestID) obj).messageID == this.messageID;
    }

    public LDAPResult get() {
        try {
            return get(this.connection.getConnectionOptions().getResponseTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            Debug.debugException(e);
            return new LDAPResult(this.messageID, ResultCode.TIMEOUT, e.getMessage(), (String) null, StaticUtils.NO_STRINGS, StaticUtils.NO_CONTROLS);
        }
    }

    public LDAPResult get(long j, TimeUnit timeUnit) {
        LDAPResult poll = this.resultQueue.poll();
        if (poll == null) {
            LDAPResult lDAPResult = this.result.get();
            if (lDAPResult != null) {
                return lDAPResult;
            }
            poll = this.resultQueue.poll(j, timeUnit);
            if (poll == null) {
                long millis = timeUnit.toMillis(j);
                throw new TimeoutException(LDAPMessages.WARN_ASYNC_REQUEST_GET_TIMEOUT.get(Long.valueOf(millis)));
            }
        }
        this.result.set(poll);
        return poll;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public int hashCode() {
        return this.messageID;
    }

    public boolean isCancelled() {
        return this.cancelRequested.get();
    }

    public boolean isDone() {
        if (this.cancelRequested.get() || this.result.get() != null) {
            return true;
        }
        LDAPResult poll = this.resultQueue.poll();
        if (poll == null) {
            return false;
        }
        this.result.set(poll);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setResult(LDAPResult lDAPResult) {
        this.resultQueue.offer(lDAPResult);
        AsyncTimeoutTimerTask asyncTimeoutTimerTask = this.timerTask;
        if (asyncTimeoutTimerTask != null) {
            asyncTimeoutTimerTask.cancel();
            this.connection.getTimer().purge();
            this.timerTask = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setTimerTask(AsyncTimeoutTimerTask asyncTimeoutTimerTask) {
        this.timerTask = asyncTimeoutTimerTask;
    }

    public String toString() {
        return "AsyncRequestID(messageID=" + this.messageID + ')';
    }
}
