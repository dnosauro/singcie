package com.unboundid.util;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;

public final class SynchronizedSocketFactory extends SocketFactory {
    private final SocketFactory factory;

    public SynchronizedSocketFactory(SocketFactory socketFactory) {
        this.factory = socketFactory;
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

    public SocketFactory getWrappedSocketFactory() {
        return this.factory;
    }
}
