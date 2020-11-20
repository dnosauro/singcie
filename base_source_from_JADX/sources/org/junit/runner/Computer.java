package org.junit.runner;

import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

public class Computer {
    public static Computer serial() {
        return new Computer();
    }

    /* access modifiers changed from: protected */
    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> cls) {
        return runnerBuilder.runnerForClass(cls);
    }

    public Runner getSuite(final RunnerBuilder runnerBuilder, Class<?>[] clsArr) {
        return new Suite((RunnerBuilder) new RunnerBuilder() {
            public Runner runnerForClass(Class<?> cls) {
                return Computer.this.getRunner(runnerBuilder, cls);
            }
        }, clsArr);
    }
}
