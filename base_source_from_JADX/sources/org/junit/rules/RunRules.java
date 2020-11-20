package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunRules extends Statement {
    private final Statement statement;

    public RunRules(Statement statement2, Iterable<TestRule> iterable, Description description) {
        this.statement = applyAll(statement2, iterable, description);
    }

    private static Statement applyAll(Statement statement2, Iterable<TestRule> iterable, Description description) {
        for (TestRule apply : iterable) {
            statement2 = apply.apply(statement2, description);
        }
        return statement2;
    }

    public void evaluate() {
        this.statement.evaluate();
    }
}
