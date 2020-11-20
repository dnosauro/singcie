package com.parse;

import android.annotation.SuppressLint;
import android.util.Log;

public class PLog {
    public static final int LOG_LEVEL_NONE = Integer.MAX_VALUE;
    private static int logLevel = Integer.MAX_VALUE;

    /* renamed from: d */
    public static void m8814d(String str, String str2) {
        m8815d(str, str2, (Throwable) null);
    }

    /* renamed from: d */
    public static void m8815d(String str, String str2, Throwable th) {
        log(3, str, str2, th);
    }

    /* renamed from: e */
    public static void m8816e(String str, String str2) {
        m8817e(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public static void m8817e(String str, String str2, Throwable th) {
        log(6, str, str2, th);
    }

    public static int getLogLevel() {
        return logLevel;
    }

    /* renamed from: i */
    public static void m8818i(String str, String str2) {
        m8819i(str, str2, (Throwable) null);
    }

    /* renamed from: i */
    public static void m8819i(String str, String str2, Throwable th) {
        log(4, str, str2, th);
    }

    @SuppressLint({"WrongConstant"})
    private static void log(int i, String str, String str2, Throwable th) {
        int i2 = logLevel;
        if (i < i2) {
            return;
        }
        if (th == null) {
            Log.println(i2, str, str2);
            return;
        }
        Log.println(i2, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    /* renamed from: v */
    public static void m8820v(String str, String str2) {
        m8821v(str, str2, (Throwable) null);
    }

    /* renamed from: v */
    public static void m8821v(String str, String str2, Throwable th) {
        log(2, str, str2, th);
    }

    /* renamed from: w */
    public static void m8822w(String str, String str2) {
        m8823w(str, str2, (Throwable) null);
    }

    /* renamed from: w */
    public static void m8823w(String str, String str2, Throwable th) {
        log(5, str, str2, th);
    }
}
