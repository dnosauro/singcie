package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class CrashlyticsController$$Lambda$1 implements FilenameFilter {
    private static final CrashlyticsController$$Lambda$1 instance = new CrashlyticsController$$Lambda$1();

    private CrashlyticsController$$Lambda$1() {
    }

    public static FilenameFilter lambdaFactory$() {
        return instance;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsController.APP_EXCEPTION_MARKER_PREFIX);
    }
}
