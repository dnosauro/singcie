package com.parse;

import android.util.SparseArray;
import bolts.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ParseEventuallyQueue {
    private boolean isConnected;
    private TestHelper testHelper;

    public static class TestHelper {
        public static final int COMMAND_ENQUEUED = 3;
        public static final int COMMAND_FAILED = 2;
        public static final int COMMAND_NOT_ENQUEUED = 4;
        public static final int COMMAND_OLD_FORMAT_DISCARDED = 8;
        public static final int COMMAND_SUCCESSFUL = 1;
        private static final int MAX_EVENTS = 1000;
        public static final int NETWORK_DOWN = 7;
        public static final int OBJECT_REMOVED = 6;
        public static final int OBJECT_UPDATED = 5;
        private SparseArray<Semaphore> events;

        private TestHelper() {
            this.events = new SparseArray<>();
            clear();
        }

        public static String getEventString(int i) {
            switch (i) {
                case 1:
                    return "COMMAND_SUCCESSFUL";
                case 2:
                    return "COMMAND_FAILED";
                case 3:
                    return "COMMAND_ENQUEUED";
                case 4:
                    return "COMMAND_NOT_ENQUEUED";
                case 5:
                    return "OBJECT_UPDATED";
                case 6:
                    return "OBJECT_REMOVED";
                case 7:
                    return "NETWORK_DOWN";
                case 8:
                    return "COMMAND_OLD_FORMAT_DISCARDED";
                default:
                    throw new IllegalStateException("Encountered unknown event: " + i);
            }
        }

        public void clear() {
            this.events.clear();
            this.events.put(1, new Semaphore(1000));
            this.events.put(2, new Semaphore(1000));
            this.events.put(3, new Semaphore(1000));
            this.events.put(4, new Semaphore(1000));
            this.events.put(5, new Semaphore(1000));
            this.events.put(6, new Semaphore(1000));
            this.events.put(7, new Semaphore(1000));
            this.events.put(8, new Semaphore(1000));
            for (int i = 0; i < this.events.size(); i++) {
                this.events.get(this.events.keyAt(i)).acquireUninterruptibly(1000);
            }
        }

        public List<String> getUnexpectedEvents() {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.events.size(); i++) {
                int keyAt = this.events.keyAt(i);
                if (this.events.get(keyAt).availablePermits() > 0) {
                    arrayList.add(getEventString(keyAt));
                }
            }
            return arrayList;
        }

        public void notify(int i) {
            notify(i, (Throwable) null);
        }

        public void notify(int i, Throwable th) {
            this.events.get(i).release();
        }

        public int unexpectedEvents() {
            int i = 0;
            for (int i2 = 0; i2 < this.events.size(); i2++) {
                i += this.events.get(this.events.keyAt(i2)).availablePermits();
            }
            return i;
        }

        public boolean waitFor(int i) {
            return waitFor(i, 1);
        }

        public boolean waitFor(int i, int i2) {
            try {
                return this.events.get(i).tryAcquire(i2, 10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    ParseEventuallyQueue() {
    }

    public abstract void clear();

    /* access modifiers changed from: protected */
    public ParseRESTCommand commandFromJSON(JSONObject jSONObject) {
        if (ParseRESTCommand.isValidCommandJSONObject(jSONObject)) {
            return ParseRESTCommand.fromJSONObject(jSONObject);
        }
        if (ParseRESTCommand.isValidOldFormatCommandJSONObject(jSONObject)) {
            return null;
        }
        throw new JSONException("Failed to load command from JSON.");
    }

    public abstract Task<JSONObject> enqueueEventuallyAsync(ParseRESTCommand parseRESTCommand, ParseObject parseObject);

    /* access modifiers changed from: package-private */
    public void fakeObjectUpdate() {
        TestHelper testHelper2 = this.testHelper;
        if (testHelper2 != null) {
            testHelper2.notify(3);
            this.testHelper.notify(1);
            this.testHelper.notify(5);
        }
    }

    public TestHelper getTestHelper() {
        if (this.testHelper == null) {
            this.testHelper = new TestHelper();
        }
        return this.testHelper;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    /* access modifiers changed from: protected */
    public void notifyTestHelper(int i) {
        notifyTestHelper(i, (Throwable) null);
    }

    /* access modifiers changed from: protected */
    public void notifyTestHelper(int i, Throwable th) {
        TestHelper testHelper2 = this.testHelper;
        if (testHelper2 != null) {
            testHelper2.notify(i, th);
        }
    }

    public abstract void onDestroy();

    public abstract void pause();

    public abstract int pendingCount();

    public abstract void resume();

    public void setConnected(boolean z) {
        this.isConnected = z;
    }

    public void setMaxCacheSizeBytes(int i) {
    }

    public void setTimeoutRetryWaitSeconds(double d) {
    }

    /* access modifiers changed from: package-private */
    public abstract void simulateReboot();

    /* access modifiers changed from: package-private */
    public Task<JSONObject> waitForOperationSetAndEventuallyPin(ParseOperationSet parseOperationSet, EventuallyPin eventuallyPin) {
        return Task.forResult(null);
    }
}
