package org.junit.internal;

public final class Throwables {
    private Throwables() {
    }

    private static <T extends Throwable> void rethrow(Throwable th) {
        throw th;
    }

    public static Exception rethrowAsException(Throwable th) {
        rethrow(th);
        return null;
    }
}
