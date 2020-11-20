package com.unboundid.util.parallel;

import com.unboundid.util.InternalUseOnly;

@InternalUseOnly
public interface Processor<I, O> {
    O process(I i);
}
