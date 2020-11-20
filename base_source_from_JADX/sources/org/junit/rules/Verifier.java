package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class Verifier implements TestRule {
    public Statement apply(final Statement statement, Description description) {
        return new Statement() {
            public void evaluate() {
                statement.evaluate();
                Verifier.this.verify();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void verify() {
    }
}
