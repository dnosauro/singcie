package org.junit.runners.parameterized;

import org.junit.runner.Runner;

public interface ParametersRunnerFactory {
    Runner createRunnerForTestWithParameters(TestWithParameters testWithParameters);
}
