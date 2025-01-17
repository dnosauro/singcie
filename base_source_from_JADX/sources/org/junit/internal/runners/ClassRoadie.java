package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class ClassRoadie {
    private Description description;
    private RunNotifier notifier;
    private final Runnable runnable;
    private TestClass testClass;

    public ClassRoadie(RunNotifier runNotifier, TestClass testClass2, Description description2, Runnable runnable2) {
        this.notifier = runNotifier;
        this.testClass = testClass2;
        this.description = description2;
        this.runnable = runnable2;
    }

    private void runAfters() {
        Throwable th;
        for (Method invoke : this.testClass.getAfters()) {
            try {
                invoke.invoke((Object) null, new Object[0]);
            } catch (InvocationTargetException e) {
                th = e.getTargetException();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return;
        addFailure(th);
    }

    private void runBefores() {
        try {
            for (Method invoke : this.testClass.getBefores()) {
                invoke.invoke((Object) null, new Object[0]);
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (AssumptionViolatedException unused) {
            throw new FailedBefore();
        } catch (Throwable th) {
            addFailure(th);
            throw new FailedBefore();
        }
    }

    /* access modifiers changed from: protected */
    public void addFailure(Throwable th) {
        this.notifier.fireTestFailure(new Failure(this.description, th));
    }

    public void runProtected() {
        try {
            runBefores();
            runUnprotected();
        } catch (FailedBefore unused) {
        } catch (Throwable th) {
            runAfters();
            throw th;
        }
        runAfters();
    }

    /* access modifiers changed from: protected */
    public void runUnprotected() {
        this.runnable.run();
    }
}
