package com.unboundid.util;

public final class Validator {
    private Validator() {
    }

    public static void ensureFalse(boolean z) {
        if (z) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_FALSE_CHECK_FAILURE.get(StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureFalse(boolean z, String str) {
        if (z) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_FAILURE_CUSTOM_MESSAGE.get(str, StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureNotNull(Object obj) {
        if (obj == null) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_NULL_CHECK_FAILURE.get(0, StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureNotNull(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_NULL_CHECK_FAILURE.get(Integer.valueOf(obj == null ? 0 : 1), StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureNotNull(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_NULL_CHECK_FAILURE.get(Integer.valueOf(obj != null ? obj2 == null ? 1 : 2 : 0), StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureNotNull(Object obj, Object obj2, Object obj3, Object obj4) {
        if (obj == null || obj2 == null || obj3 == null || obj4 == null) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_NULL_CHECK_FAILURE.get(Integer.valueOf(obj != null ? obj2 != null ? obj3 == null ? 2 : 3 : 1 : 0), StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureNotNull(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (obj == null || obj2 == null || obj3 == null || obj4 == null || obj5 == null) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_NULL_CHECK_FAILURE.get(Integer.valueOf(obj != null ? obj2 != null ? obj3 != null ? obj4 == null ? 3 : 4 : 2 : 1 : 0), StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureNotNullWithMessage(Object obj, String str) {
        if (obj == null) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_FAILURE_CUSTOM_MESSAGE.get(str, StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureTrue(boolean z) {
        if (!z) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_TRUE_CHECK_FAILURE.get(StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }

    public static void ensureTrue(boolean z, String str) {
        if (!z) {
            LDAPSDKUsageException lDAPSDKUsageException = new LDAPSDKUsageException(UtilityMessages.ERR_VALIDATOR_FAILURE_CUSTOM_MESSAGE.get(str, StaticUtils.getStackTrace(Thread.currentThread().getStackTrace())));
            Debug.debugCodingError(lDAPSDKUsageException);
            throw lDAPSDKUsageException;
        }
    }
}
