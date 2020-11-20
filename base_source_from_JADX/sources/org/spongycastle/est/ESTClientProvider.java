package org.spongycastle.est;

public interface ESTClientProvider {
    boolean isTrusted();

    ESTClient makeClient();
}
