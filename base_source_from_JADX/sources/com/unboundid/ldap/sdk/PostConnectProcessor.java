package com.unboundid.ldap.sdk;

public interface PostConnectProcessor {
    void processPostAuthenticatedConnection(LDAPConnection lDAPConnection);

    void processPreAuthenticatedConnection(LDAPConnection lDAPConnection);
}
