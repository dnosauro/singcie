package com.parse;

import java.lang.Throwable;

interface ParseCallback2<T1, T2 extends Throwable> {
    void done(T1 t1, T2 t2);
}
