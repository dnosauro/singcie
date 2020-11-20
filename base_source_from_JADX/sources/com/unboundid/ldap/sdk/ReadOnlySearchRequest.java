package com.unboundid.ldap.sdk;

import java.util.List;

public interface ReadOnlySearchRequest extends ReadOnlyLDAPRequest {
    SearchRequest duplicate();

    SearchRequest duplicate(Control[] controlArr);

    List<String> getAttributeList();

    String getBaseDN();

    DereferencePolicy getDereferencePolicy();

    Filter getFilter();

    SearchScope getScope();

    int getSizeLimit();

    int getTimeLimitSeconds();

    boolean typesOnly();
}
