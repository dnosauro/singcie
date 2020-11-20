package com.unboundid.ldap.sdk;

public interface ReferralConnector {
    LDAPConnection getReferralConnection(LDAPURL ldapurl, LDAPConnection lDAPConnection);
}
