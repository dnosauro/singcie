package org.slf4j.impl;

import com.p084c.p085a.p086a.C1432c;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public class AndroidLoggerAdapter extends MarkerIgnoringBase {
    private final C1432c logger;

    public AndroidLoggerAdapter(C1432c cVar) {
        this.logger = cVar;
    }

    private boolean isEnabled(C1432c.C1433a aVar) {
        return this.logger.mo6902a(aVar);
    }

    private void log(C1432c.C1433a aVar, String str) {
        this.logger.mo6900a(aVar, str, (Throwable) null);
    }

    private void log(C1432c.C1433a aVar, String str, Object obj) {
        this.logger.mo6900a(aVar, MessageFormatter.format(str, obj).getMessage(), (Throwable) null);
    }

    private void log(C1432c.C1433a aVar, String str, Object obj, Object obj2) {
        this.logger.mo6900a(aVar, MessageFormatter.format(str, obj, obj2).getMessage(), (Throwable) null);
    }

    private void log(C1432c.C1433a aVar, String str, Throwable th) {
        this.logger.mo6900a(aVar, str, th);
    }

    private void log(C1432c.C1433a aVar, String str, Object... objArr) {
        this.logger.mo6900a(aVar, MessageFormatter.arrayFormat(str, objArr).getMessage(), (Throwable) null);
    }

    public void debug(String str) {
        log(C1432c.C1433a.DEBUG, str);
    }

    public void debug(String str, Object obj) {
        log(C1432c.C1433a.DEBUG, str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        log(C1432c.C1433a.DEBUG, str, obj, obj2);
    }

    public void debug(String str, Throwable th) {
        log(C1432c.C1433a.DEBUG, str, th);
    }

    public void debug(String str, Object... objArr) {
        log(C1432c.C1433a.DEBUG, str, objArr);
    }

    public void error(String str) {
        log(C1432c.C1433a.ERROR, str);
    }

    public void error(String str, Object obj) {
        log(C1432c.C1433a.ERROR, str, obj);
    }

    public void error(String str, Object obj, Object obj2) {
        log(C1432c.C1433a.ERROR, str, obj, obj2);
    }

    public void error(String str, Throwable th) {
        log(C1432c.C1433a.ERROR, str, th);
    }

    public void error(String str, Object... objArr) {
        log(C1432c.C1433a.ERROR, str, objArr);
    }

    public void info(String str) {
        log(C1432c.C1433a.INFO, str);
    }

    public void info(String str, Object obj) {
        log(C1432c.C1433a.INFO, str, obj);
    }

    public void info(String str, Object obj, Object obj2) {
        log(C1432c.C1433a.INFO, str, obj, obj2);
    }

    public void info(String str, Throwable th) {
        log(C1432c.C1433a.INFO, str, th);
    }

    public void info(String str, Object... objArr) {
        log(C1432c.C1433a.INFO, str, objArr);
    }

    public boolean isDebugEnabled() {
        return isEnabled(C1432c.C1433a.DEBUG);
    }

    public boolean isErrorEnabled() {
        return isEnabled(C1432c.C1433a.ERROR);
    }

    public boolean isInfoEnabled() {
        return isEnabled(C1432c.C1433a.INFO);
    }

    public boolean isTraceEnabled() {
        return isEnabled(C1432c.C1433a.VERBOSE);
    }

    public boolean isWarnEnabled() {
        return isEnabled(C1432c.C1433a.WARN);
    }

    public void trace(String str) {
        log(C1432c.C1433a.VERBOSE, str);
    }

    public void trace(String str, Object obj) {
        log(C1432c.C1433a.VERBOSE, str, obj);
    }

    public void trace(String str, Object obj, Object obj2) {
        log(C1432c.C1433a.VERBOSE, str, obj, obj2);
    }

    public void trace(String str, Throwable th) {
        log(C1432c.C1433a.VERBOSE, str, th);
    }

    public void trace(String str, Object... objArr) {
        log(C1432c.C1433a.VERBOSE, str, objArr);
    }

    public void warn(String str) {
        log(C1432c.C1433a.WARN, str);
    }

    public void warn(String str, Object obj) {
        log(C1432c.C1433a.WARN, str, obj);
    }

    public void warn(String str, Object obj, Object obj2) {
        log(C1432c.C1433a.WARN, str, obj, obj2);
    }

    public void warn(String str, Throwable th) {
        log(C1432c.C1433a.WARN, str, th);
    }

    public void warn(String str, Object... objArr) {
        log(C1432c.C1433a.WARN, str, objArr);
    }
}
