package org.junit.runners.parameterized;

import org.junit.runner.Runner;

public class BlockJUnit4ClassRunnerWithParametersFactory implements ParametersRunnerFactory {
    public Runner createRunnerForTestWithParameters(TestWithParameters testWithParameters) {
        return new BlockJUnit4ClassRunnerWithParameters(testWithParameters);
    }
}
