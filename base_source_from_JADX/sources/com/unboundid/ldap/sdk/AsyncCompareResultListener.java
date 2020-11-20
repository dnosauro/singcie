package com.unboundid.ldap.sdk;

public interface AsyncCompareResultListener {
    void compareResultReceived(AsyncRequestID asyncRequestID, CompareResult compareResult);
}
