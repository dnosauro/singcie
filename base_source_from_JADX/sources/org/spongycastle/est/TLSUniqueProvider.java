package org.spongycastle.est;

public interface TLSUniqueProvider {
    byte[] getTLSUnique();

    boolean isTLSUniqueAvailable();
}
