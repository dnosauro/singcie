package com.unboundid.ldap.sdk;

import java.io.Serializable;

public interface IntermediateResponseListener extends Serializable {
    void intermediateResponseReturned(IntermediateResponse intermediateResponse);
}
