package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.SocketFactory;

final class ConnectThread extends Thread {
    private final String address;
    private final AtomicBoolean connected = new AtomicBoolean(false);
    private final AtomicReference<Throwable> exception = new AtomicReference<>();
    private final int port;
    private final AtomicReference<Socket> socket = new AtomicReference<>();
    private final SocketFactory socketFactory;
    private final AtomicBoolean started = new AtomicBoolean(false);
    private final AtomicReference<Thread> thread = new AtomicReference<>();

    ConnectThread(SocketFactory socketFactory2, String str, int i) {
        super("Background connect thread for " + str + ':' + i);
        setDaemon(true);
        this.socketFactory = socketFactory2;
        this.address = str;
        this.port = i;
    }

    /* access modifiers changed from: package-private */
    public Socket getConnectedSocket(long j) {
        while (!this.started.get()) {
            Thread.yield();
        }
        Thread thread2 = this.thread.get();
        if (thread2 != null) {
            try {
                thread2.join(j);
            } catch (Exception e) {
                Debug.debugException(e);
            }
        }
        if (this.connected.get()) {
            return this.socket.get();
        }
        if (thread2 != null) {
            try {
                thread2.interrupt();
            } catch (Exception e2) {
                Debug.debugException(e2);
            }
        }
        try {
            Socket socket2 = this.socket.get();
            if (socket2 != null) {
                socket2.close();
            }
        } catch (Exception e3) {
            Debug.debugException(e3);
        }
        Throwable th = this.exception.get();
        if (th == null) {
            throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_CONNECT_THREAD_TIMEOUT.get(this.address, Integer.valueOf(this.port), Long.valueOf(j)));
        }
        throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_CONNECT_THREAD_EXCEPTION.get(this.address, Integer.valueOf(this.port), StaticUtils.getExceptionMessage(th)), th);
    }

    public void run() {
        this.thread.set(Thread.currentThread());
        this.started.set(true);
        try {
            this.socket.set(this.socketFactory.createSocket(this.address, this.port));
            this.connected.set(true);
        } catch (Throwable th) {
            this.thread.set((Object) null);
            throw th;
        }
        this.thread.set((Object) null);
    }
}
