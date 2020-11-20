package org.junit.rules;

import org.junit.runner.Description;

public class TestName extends TestWatcher {
    private String name;

    public String getMethodName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public void starting(Description description) {
        this.name = description.getMethodName();
    }
}
