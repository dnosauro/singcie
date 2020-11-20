package com.unboundid.ldap.sdk;

public interface AsyncResultListener {
    void ldapResultReceived(AsyncRequestID asyncRequestID, LDAPResult lDAPResult);
}
