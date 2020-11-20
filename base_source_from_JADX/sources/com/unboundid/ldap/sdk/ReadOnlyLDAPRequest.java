package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.util.List;

public interface ReadOnlyLDAPRequest extends Serializable {
    LDAPRequest duplicate();

    LDAPRequest duplicate(Control[] controlArr);

    boolean followReferrals(LDAPConnection lDAPConnection);

    Control getControl(String str);

    List<Control> getControlList();

    long getResponseTimeoutMillis(LDAPConnection lDAPConnection);

    boolean hasControl();

    boolean hasControl(String str);

    String toString();

    void toString(StringBuilder sb);
}
