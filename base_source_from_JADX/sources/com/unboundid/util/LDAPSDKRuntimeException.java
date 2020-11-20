package com.unboundid.util;

public abstract class LDAPSDKRuntimeException extends RuntimeException {
    protected LDAPSDKRuntimeException(String str) {
        super(str);
    }

    protected LDAPSDKRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public String getExceptionMessage() {
        String message = getMessage();
        return message == null ? toString() : message;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append(super.toString());
    }
}
