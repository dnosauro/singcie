package org.junit.internal.builders;

import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
import p076c.p078b.C1399e;

public class JUnit3Builder extends RunnerBuilder {
    /* access modifiers changed from: package-private */
    public boolean isPre4Test(Class<?> cls) {
        return C1399e.class.isAssignableFrom(cls);
    }

    public Runner runnerForClass(Class<?> cls) {
        if (isPre4Test(cls)) {
            return new JUnit38ClassRunner(cls);
        }
        return null;
    }
}
