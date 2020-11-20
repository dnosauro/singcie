package com.unboundid.util;

public final class LDAPSDKUsageException extends LDAPSDKRuntimeException {
    private static final long serialVersionUID = 4488711069492709961L;

    public LDAPSDKUsageException(String str) {
        super(str);
    }

    public LDAPSDKUsageException(String str, Throwable th) {
        super(str, th);
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPSDKUsageException(message='");
        sb.append(getMessage());
        sb.append('\'');
        Throwable cause = getCause();
        if (cause != null) {
            sb.append(", cause=");
            sb.append(cause.toString());
        }
        sb.append(')');
    }
}
