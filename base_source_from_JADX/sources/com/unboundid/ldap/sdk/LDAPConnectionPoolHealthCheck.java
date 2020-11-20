package com.unboundid.ldap.sdk;

import com.unboundid.util.StaticUtils;

public class LDAPConnectionPoolHealthCheck {
    public void ensureConnectionValidAfterException(LDAPConnection lDAPConnection, LDAPException lDAPException) {
        if (!ResultCode.isConnectionUsable(lDAPException.getResultCode())) {
            throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_POOL_HEALTH_CHECK_CONN_INVALID_AFTER_EXCEPTION.get(StaticUtils.getExceptionMessage(lDAPException)), lDAPException);
        }
    }

    public void ensureConnectionValidForCheckout(LDAPConnection lDAPConnection) {
    }

    public void ensureConnectionValidForContinuedUse(LDAPConnection lDAPConnection) {
    }

    public void ensureConnectionValidForRelease(LDAPConnection lDAPConnection) {
    }

    public void ensureNewConnectionValid(LDAPConnection lDAPConnection) {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPConnectionPoolHealthCheck()");
    }
}
