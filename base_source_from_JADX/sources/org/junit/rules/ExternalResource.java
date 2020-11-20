package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class ExternalResource implements TestRule {
    private Statement statement(final Statement statement) {
        return new Statement() {
            public void evaluate() {
                ExternalResource.this.before();
                try {
                    statement.evaluate();
                } finally {
                    ExternalResource.this.after();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void after() {
    }

    public Statement apply(Statement statement, Description description) {
        return statement(statement);
    }

    /* access modifiers changed from: protected */
    public void before() {
    }
}
