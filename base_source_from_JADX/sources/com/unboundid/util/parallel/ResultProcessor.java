package com.unboundid.util.parallel;

import com.unboundid.util.InternalUseOnly;

@InternalUseOnly
public interface ResultProcessor<I, O> {
    void processResult(Result<I, O> result);
}
