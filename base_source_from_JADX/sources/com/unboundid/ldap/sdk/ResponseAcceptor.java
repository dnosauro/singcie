package com.unboundid.ldap.sdk;

import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.InternalUseOnly;

@InternalUseOnly
interface ResponseAcceptor {
    void responseReceived(LDAPResponse lDAPResponse);
}
