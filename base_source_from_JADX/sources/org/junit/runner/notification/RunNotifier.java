package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class RunNotifier {
    /* access modifiers changed from: private */
    public final List<RunListener> listeners = new CopyOnWriteArrayList();
    private volatile boolean pleaseStop = false;

    private abstract class SafeNotifier {
        private final List<RunListener> currentListeners;

        SafeNotifier(RunNotifier runNotifier) {
            this(runNotifier.listeners);
        }

        SafeNotifier(List<RunListener> list) {
            this.currentListeners = list;
        }

        /* access modifiers changed from: protected */
        public abstract void notifyListener(RunListener runListener);

        /* access modifiers changed from: package-private */
        public void run() {
            int size = this.currentListeners.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener next : this.currentListeners) {
                try {
                    notifyListener(next);
                    arrayList.add(next);
                } catch (Exception e) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
                }
            }
            RunNotifier.this.fireTestFailures(arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: private */
    public void fireTestFailures(List<RunListener> list, final List<Failure> list2) {
        if (!list2.isEmpty()) {
            new SafeNotifier(list) {
                /* access modifiers changed from: protected */
                public void notifyListener(RunListener runListener) {
                    for (Failure testFailure : list2) {
                        runListener.testFailure(testFailure);
                    }
                }
            }.run();
        }
    }

    public void addFirstListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.add(0, wrapIfNotThreadSafe(runListener));
            return;
        }
        throw new NullPointerException("Cannot add a null listener");
    }

    public void addListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.add(wrapIfNotThreadSafe(runListener));
            return;
        }
        throw new NullPointerException("Cannot add a null listener");
    }

    public void fireTestAssumptionFailed(final Failure failure) {
        new SafeNotifier() {
            /* access modifiers changed from: protected */
            public void notifyListener(RunListener runListener) {
                runListener.testAssumptionFailure(failure);
            }
        }.run();
    }

    public void fireTestFailure(Failure failure) {
        fireTestFailures(this.listeners, Arrays.asList(new Failure[]{failure}));
    }

    public void fireTestFinished(final Description description) {
        new SafeNotifier() {
            /* access modifiers changed from: protected */
            public void notifyListener(RunListener runListener) {
                runListener.testFinished(description);
            }
        }.run();
    }

    public void fireTestIgnored(final Description description) {
        new SafeNotifier() {
            /* access modifiers changed from: protected */
            public void notifyListener(RunListener runListener) {
                runListener.testIgnored(description);
            }
        }.run();
    }

    public void fireTestRunFinished(final Result result) {
        new SafeNotifier() {
            /* access modifiers changed from: protected */
            public void notifyListener(RunListener runListener) {
                runListener.testRunFinished(result);
            }
        }.run();
    }

    public void fireTestRunStarted(final Description description) {
        new SafeNotifier() {
            /* access modifiers changed from: protected */
            public void notifyListener(RunListener runListener) {
                runListener.testRunStarted(description);
            }
        }.run();
    }

    public void fireTestStarted(final Description description) {
        if (!this.pleaseStop) {
            new SafeNotifier() {
                /* access modifiers changed from: protected */
                public void notifyListener(RunListener runListener) {
                    runListener.testStarted(description);
                }
            }.run();
            return;
        }
        throw new StoppedByUserException();
    }

    public void pleaseStop() {
        this.pleaseStop = true;
    }

    public void removeListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.remove(wrapIfNotThreadSafe(runListener));
            return;
        }
        throw new NullPointerException("Cannot remove a null listener");
    }

    /* access modifiers changed from: package-private */
    public RunListener wrapIfNotThreadSafe(RunListener runListener) {
        return runListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class) ? runListener : new SynchronizedRunListener(runListener, this);
    }
}
