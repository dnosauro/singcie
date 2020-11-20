package org.spongycastle.cert.dane;

public class DANEEntryStoreBuilder {
    private final DANEEntryFetcherFactory daneEntryFetcher;

    public DANEEntryStoreBuilder(DANEEntryFetcherFactory dANEEntryFetcherFactory) {
        this.daneEntryFetcher = dANEEntryFetcherFactory;
    }

    public DANEEntryStore build(String str) {
        return new DANEEntryStore(this.daneEntryFetcher.build(str).getEntries());
    }
}
