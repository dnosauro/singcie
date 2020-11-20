package org.spongycastle.est;

public interface ESTHijacker {
    ESTResponse hijack(ESTRequest eSTRequest, Source source);
}
