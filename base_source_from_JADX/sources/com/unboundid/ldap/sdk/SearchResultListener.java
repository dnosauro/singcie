package com.unboundid.ldap.sdk;

import java.io.Serializable;

public interface SearchResultListener extends Serializable {
    void searchEntryReturned(SearchResultEntry searchResultEntry);

    void searchReferenceReturned(SearchResultReference searchResultReference);
}
