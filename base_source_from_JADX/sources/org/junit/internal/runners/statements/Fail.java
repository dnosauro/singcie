package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

public class Fail extends Statement {
    private final Throwable error;

    public Fail(Throwable th) {
        this.error = th;
    }

    public void evaluate() {
        throw this.error;
    }
}
