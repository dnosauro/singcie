package com.unboundid.util;

public abstract class LDAPSDKException extends Exception {
    protected LDAPSDKException(String str) {
        super(str);
    }

    protected LDAPSDKException(String str, Throwable th) {
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
