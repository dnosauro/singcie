package com.unboundid.ldap.protocol;

import com.unboundid.ldap.sdk.Control;
import com.unboundid.util.InternalUseOnly;

@InternalUseOnly
public interface LDAPResponse {
    public static final Control[] NO_CONTROLS = new Control[0];

    int getMessageID();

    void toString(StringBuilder sb);
}
