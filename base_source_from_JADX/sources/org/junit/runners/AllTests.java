package org.junit.runners;

import org.junit.internal.runners.SuiteMethod;

public class AllTests extends SuiteMethod {
    public AllTests(Class<?> cls) {
        super(cls);
    }
}
