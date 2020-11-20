package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;

public abstract class ServerSet {
    protected ServerSet() {
    }

    public abstract LDAPConnection getConnection();

    public LDAPConnection getConnection(LDAPConnectionPoolHealthCheck lDAPConnectionPoolHealthCheck) {
        LDAPConnection connection = getConnection();
        if (lDAPConnectionPoolHealthCheck != null) {
            try {
                lDAPConnectionPoolHealthCheck.ensureNewConnectionValid(connection);
            } catch (LDAPException e) {
                Debug.debugException(e);
                connection.close();
                throw e;
            }
        }
        return connection;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ServerSet(className=");
        sb.append(getClass().getName());
        sb.append(')');
    }
}
