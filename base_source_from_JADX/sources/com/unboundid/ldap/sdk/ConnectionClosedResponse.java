package com.unboundid.ldap.sdk;

import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.InternalUseOnly;
import java.io.Serializable;

@InternalUseOnly
final class ConnectionClosedResponse implements LDAPResponse, Serializable {
    private static final long serialVersionUID = -3931112652935496193L;
    private final String message;
    private final ResultCode resultCode;

    ConnectionClosedResponse(ResultCode resultCode2, String str) {
        this.resultCode = resultCode2;
        this.message = str;
    }

    /* access modifiers changed from: package-private */
    public String getMessage() {
        return this.message;
    }

    public int getMessageID() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ConnectionClosedResponse(resultCode='");
        sb.append(this.resultCode);
        sb.append('\'');
        if (this.message != null) {
            sb.append(", message='");
            sb.append(this.message);
            sb.append('\'');
        }
        sb.append(')');
    }
}
