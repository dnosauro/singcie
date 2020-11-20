package com.unboundid.ldap.sdk;

public interface AsyncSearchResultListener extends SearchResultListener {
    void searchResultReceived(AsyncRequestID asyncRequestID, SearchResult searchResult);
}
