package org.slf4j.impl;

import com.p084c.p085a.p086a.C1434d;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class AndroidLoggerFactory implements ILoggerFactory {
    public Logger getLogger(String str) {
        return new AndroidLoggerAdapter(C1434d.m5431a(str));
    }
}
