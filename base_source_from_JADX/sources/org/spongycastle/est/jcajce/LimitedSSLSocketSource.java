package org.spongycastle.est.jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.spongycastle.est.LimitedSource;
import org.spongycastle.est.Source;
import org.spongycastle.est.TLSUniqueProvider;

class LimitedSSLSocketSource implements LimitedSource, Source<SSLSession>, TLSUniqueProvider {
    private final Long absoluteReadLimit;
    private final ChannelBindingProvider bindingProvider;
    protected final SSLSocket socket;

    public LimitedSSLSocketSource(SSLSocket sSLSocket, ChannelBindingProvider channelBindingProvider, Long l) {
        this.socket = sSLSocket;
        this.bindingProvider = channelBindingProvider;
        this.absoluteReadLimit = l;
    }

    public void close() {
        this.socket.close();
    }

    public Long getAbsoluteReadLimit() {
        return this.absoluteReadLimit;
    }

    public InputStream getInputStream() {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() {
        return this.socket.getOutputStream();
    }

    public SSLSession getSession() {
        return this.socket.getSession();
    }

    public byte[] getTLSUnique() {
        if (isTLSUniqueAvailable()) {
            return this.bindingProvider.getChannelBinding(this.socket, "tls-unique");
        }
        throw new IllegalStateException("No binding provider.");
    }

    public boolean isTLSUniqueAvailable() {
        return this.bindingProvider.canAccessChannelBinding(this.socket);
    }
}
