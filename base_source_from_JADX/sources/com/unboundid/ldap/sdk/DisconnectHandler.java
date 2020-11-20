package com.unboundid.ldap.sdk;

public interface DisconnectHandler {
    void handleDisconnect(LDAPConnection lDAPConnection, String str, int i, DisconnectType disconnectType, String str2, Throwable th);
}
