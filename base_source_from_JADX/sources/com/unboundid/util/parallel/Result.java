package com.unboundid.util.parallel;

import com.unboundid.util.InternalUseOnly;

@InternalUseOnly
public interface Result<I, O> {
    Throwable getFailureCause();

    I getInput();

    O getOutput();
}
