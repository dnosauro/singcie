package com.unboundid.ldap.sdk;

public interface UnsolicitedNotificationHandler {
    void handleUnsolicitedNotification(LDAPConnection lDAPConnection, ExtendedResult extendedResult);
}
