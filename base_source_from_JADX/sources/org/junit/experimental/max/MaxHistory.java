package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, Long> fDurations = new HashMap();
    private final Map<String, Long> fFailureTimestamps = new HashMap();
    private final File fHistoryStore;

    private final class RememberingListener extends RunListener {
        private long overallStart;
        private Map<Description, Long> starts;

        private RememberingListener() {
            this.overallStart = System.currentTimeMillis();
            this.starts = new HashMap();
        }

        public void testFailure(Failure failure) {
            MaxHistory.this.putTestFailureTimestamp(failure.getDescription(), this.overallStart);
        }

        public void testFinished(Description description) {
            MaxHistory.this.putTestDuration(description, System.nanoTime() - this.starts.get(description).longValue());
        }

        public void testRunFinished(Result result) {
            MaxHistory.this.save();
        }

        public void testStarted(Description description) {
            this.starts.put(description, Long.valueOf(System.nanoTime()));
        }
    }

    private class TestComparator implements Comparator<Description> {
        private TestComparator() {
        }

        private Long getFailure(Description description) {
            Long failureTimestamp = MaxHistory.this.getFailureTimestamp(description);
            if (failureTimestamp == null) {
                return 0L;
            }
            return failureTimestamp;
        }

        public int compare(Description description, Description description2) {
            if (MaxHistory.this.isNewTest(description)) {
                return -1;
            }
            if (MaxHistory.this.isNewTest(description2)) {
                return 1;
            }
            int compareTo = getFailure(description2).compareTo(getFailure(description));
            return compareTo != 0 ? compareTo : MaxHistory.this.getTestDuration(description).compareTo(MaxHistory.this.getTestDuration(description2));
        }
    }

    private MaxHistory(File file) {
        this.fHistoryStore = file;
    }

    public static MaxHistory forFolder(File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (CouldNotReadCoreException e) {
                e.printStackTrace();
                file.delete();
            }
        }
        return new MaxHistory(file);
    }

    private static MaxHistory readHistory(File file) {
        ObjectInputStream objectInputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                MaxHistory maxHistory = (MaxHistory) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                return maxHistory;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (Exception e) {
            throw new CouldNotReadCoreException(e);
        }
    }

    /* access modifiers changed from: private */
    public void save() {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public Long getFailureTimestamp(Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    /* access modifiers changed from: package-private */
    public Long getTestDuration(Description description) {
        return this.fDurations.get(description.toString());
    }

    /* access modifiers changed from: package-private */
    public boolean isNewTest(Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    public RunListener listener() {
        return new RememberingListener();
    }

    /* access modifiers changed from: package-private */
    public void putTestDuration(Description description, long j) {
        this.fDurations.put(description.toString(), Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void putTestFailureTimestamp(Description description, long j) {
        this.fFailureTimestamps.put(description.toString(), Long.valueOf(j));
    }

    public Comparator<Description> testComparator() {
        return new TestComparator();
    }
}
