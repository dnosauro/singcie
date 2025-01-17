package org.spongycastle.jcajce;

import java.security.cert.CRL;
import java.util.Collection;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;

public interface PKIXCRLStore<T extends CRL> extends Store<T> {
    Collection<T> getMatches(Selector<T> selector);
}
