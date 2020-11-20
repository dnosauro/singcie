package org.junit.runner;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Result implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(SerializedForm.class).getFields();
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final AtomicInteger count;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<Failure> failures;
    /* access modifiers changed from: private */
    public final AtomicInteger ignoreCount;
    /* access modifiers changed from: private */
    public final AtomicLong runTime;
    private SerializedForm serializedForm;
    /* access modifiers changed from: private */
    public final AtomicLong startTime;

    @RunListener.ThreadSafe
    private class Listener extends RunListener {
        private Listener() {
        }

        public void testAssumptionFailure(Failure failure) {
        }

        public void testFailure(Failure failure) {
            Result.this.failures.add(failure);
        }

        public void testFinished(Description description) {
            Result.this.count.getAndIncrement();
        }

        public void testIgnored(Description description) {
            Result.this.ignoreCount.getAndIncrement();
        }

        public void testRunFinished(Result result) {
            Result.this.runTime.addAndGet(System.currentTimeMillis() - Result.this.startTime.get());
        }

        public void testRunStarted(Description description) {
            Result.this.startTime.set(System.currentTimeMillis());
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final AtomicInteger fCount;
        /* access modifiers changed from: private */
        public final List<Failure> fFailures;
        /* access modifiers changed from: private */
        public final AtomicInteger fIgnoreCount;
        /* access modifiers changed from: private */
        public final long fRunTime;
        /* access modifiers changed from: private */
        public final long fStartTime;

        private SerializedForm(ObjectInputStream.GetField getField) {
            this.fCount = (AtomicInteger) getField.get("fCount", (Object) null);
            this.fIgnoreCount = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.fFailures = (List) getField.get("fFailures", (Object) null);
            this.fRunTime = getField.get("fRunTime", 0);
            this.fStartTime = getField.get("fStartTime", 0);
        }

        public SerializedForm(Result result) {
            this.fCount = result.count;
            this.fIgnoreCount = result.ignoreCount;
            this.fFailures = Collections.synchronizedList(new ArrayList(result.failures));
            this.fRunTime = result.runTime.longValue();
            this.fStartTime = result.startTime.longValue();
        }

        public static SerializedForm deserialize(ObjectInputStream objectInputStream) {
            return new SerializedForm(objectInputStream.readFields());
        }

        public void serialize(ObjectOutputStream objectOutputStream) {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("fCount", this.fCount);
            putFields.put("fIgnoreCount", this.fIgnoreCount);
            putFields.put("fFailures", this.fFailures);
            putFields.put("fRunTime", this.fRunTime);
            putFields.put("fStartTime", this.fStartTime);
            objectOutputStream.writeFields();
        }
    }

    public Result() {
        this.count = new AtomicInteger();
        this.ignoreCount = new AtomicInteger();
        this.failures = new CopyOnWriteArrayList<>();
        this.runTime = new AtomicLong();
        this.startTime = new AtomicLong();
    }

    private Result(SerializedForm serializedForm2) {
        this.count = serializedForm2.fCount;
        this.ignoreCount = serializedForm2.fIgnoreCount;
        this.failures = new CopyOnWriteArrayList<>(serializedForm2.fFailures);
        this.runTime = new AtomicLong(serializedForm2.fRunTime);
        this.startTime = new AtomicLong(serializedForm2.fStartTime);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.serializedForm = SerializedForm.deserialize(objectInputStream);
    }

    private Object readResolve() {
        return new Result(this.serializedForm);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        new SerializedForm(this).serialize(objectOutputStream);
    }

    public RunListener createListener() {
        return new Listener();
    }

    public int getFailureCount() {
        return this.failures.size();
    }

    public List<Failure> getFailures() {
        return this.failures;
    }

    public int getIgnoreCount() {
        return this.ignoreCount.get();
    }

    public int getRunCount() {
        return this.count.get();
    }

    public long getRunTime() {
        return this.runTime.get();
    }

    public boolean wasSuccessful() {
        return getFailureCount() == 0;
    }
}
