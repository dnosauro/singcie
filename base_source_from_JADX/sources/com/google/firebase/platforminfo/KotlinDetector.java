package com.google.firebase.platforminfo;

import p157d.C3211b;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return C3211b.f7282a.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
