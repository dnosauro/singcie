package org.spongycastle.est.jcajce;

import java.util.Set;
import org.spongycastle.est.ESTClient;
import org.spongycastle.est.ESTClientProvider;
import org.spongycastle.est.ESTException;

class DefaultESTHttpClientProvider implements ESTClientProvider {
    private final Long absoluteLimit;
    private final ChannelBindingProvider bindingProvider;
    private final Set<String> cipherSuites;
    private final boolean filterCipherSuites;
    private final JsseHostnameAuthorizer hostNameAuthorizer;
    private final SSLSocketFactoryCreator socketFactoryCreator;
    private final int timeout;

    public DefaultESTHttpClientProvider(JsseHostnameAuthorizer jsseHostnameAuthorizer, SSLSocketFactoryCreator sSLSocketFactoryCreator, int i, ChannelBindingProvider channelBindingProvider, Set<String> set, Long l, boolean z) {
        this.hostNameAuthorizer = jsseHostnameAuthorizer;
        this.socketFactoryCreator = sSLSocketFactoryCreator;
        this.timeout = i;
        this.bindingProvider = channelBindingProvider;
        this.cipherSuites = set;
        this.absoluteLimit = l;
        this.filterCipherSuites = z;
    }

    public boolean isTrusted() {
        return this.socketFactoryCreator.isTrusted();
    }

    public ESTClient makeClient() {
        try {
            return new DefaultESTClient(new DefaultESTClientSourceProvider(this.socketFactoryCreator.createFactory(), this.hostNameAuthorizer, this.timeout, this.bindingProvider, this.cipherSuites, this.absoluteLimit, this.filterCipherSuites));
        } catch (Exception e) {
            throw new ESTException(e.getMessage(), e.getCause());
        }
    }
}
