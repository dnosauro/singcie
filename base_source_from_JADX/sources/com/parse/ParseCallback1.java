package com.parse;

import java.lang.Throwable;

interface ParseCallback1<T extends Throwable> {
    void done(T t);
}
