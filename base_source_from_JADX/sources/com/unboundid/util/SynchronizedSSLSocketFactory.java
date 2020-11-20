package com.unboundid.util;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

public final class SynchronizedSSLSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory factory;

    public SynchronizedSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.factory = sSLSocketFactory;
    }

    public Socket createSocket(String str, int i) {
        Socket createSocket;
        synchronized (this.factory) {
            createSocket = this.factory.createSocket(str, i);
        }
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Socket createSocket;
        synchronized (this.factory) {
            createSocket = this.factory.createSocket(str, i, inetAddress, i2);
        }
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        Socket createSocket;
        synchronized (this.factory) {
            createSocket = this.factory.createSocket(inetAddress, i);
        }
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        Socket createSocket;
        synchronized (this.factory) {
            createSocket = this.factory.createSocket(inetAddress, i, inetAddress2, i2);
        }
        return createSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        Socket createSocket;
        synchronized (this.factory) {
            createSocket = this.factory.createSocket(socket, str, i, z);
        }
        return createSocket;
    }

    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites;
        synchronized (this.factory) {
            defaultCipherSuites = this.factory.getDefaultCipherSuites();
        }
        return defaultCipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites;
        synchronized (this.factory) {
            supportedCipherSuites = this.factory.getSupportedCipherSuites();
        }
        return supportedCipherSuites;
    }

    public SSLSocketFactory getWrappedSocketFactory() {
        return this.factory;
    }
}
