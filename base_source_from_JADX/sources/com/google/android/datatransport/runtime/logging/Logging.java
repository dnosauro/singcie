package com.google.android.datatransport.runtime.logging;

import android.util.Log;

public final class Logging {
    private Logging() {
    }

    /* renamed from: d */
    public static void m8673d(String str, String str2) {
        Log.d(getTag(str), str2);
    }

    /* renamed from: d */
    public static void m8674d(String str, String str2, Object obj) {
        Log.d(getTag(str), String.format(str2, new Object[]{obj}));
    }

    /* renamed from: d */
    public static void m8675d(String str, String str2, Object obj, Object obj2) {
        Log.d(getTag(str), String.format(str2, new Object[]{obj, obj2}));
    }

    /* renamed from: d */
    public static void m8676d(String str, String str2, Object... objArr) {
        Log.d(getTag(str), String.format(str2, objArr));
    }

    /* renamed from: e */
    public static void m8677e(String str, String str2, Throwable th) {
        Log.e(getTag(str), str2, th);
    }

    private static String getTag(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: i */
    public static void m8678i(String str, String str2) {
        Log.i(getTag(str), str2);
    }

    /* renamed from: w */
    public static void m8679w(String str, String str2, Object obj) {
        Log.w(getTag(str), String.format(str2, new Object[]{obj}));
    }
}
