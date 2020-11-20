package org.spongycastle.est;

public interface ESTClient {
    ESTResponse doRequest(ESTRequest eSTRequest);
}
