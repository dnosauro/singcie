package com.google.android.gms.internal.ads;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

final class zzbbx extends SSLSocketFactory {
    private SSLSocketFactory zzemp = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    private final /* synthetic */ zzbbu zzemq;

    zzbbx(zzbbu zzbbu) {
        this.zzemq = zzbbu;
    }

    private final Socket zzb(Socket socket) {
        if (this.zzemq.zzemc > 0) {
            socket.setReceiveBufferSize(this.zzemq.zzemc);
        }
        this.zzemq.zza(socket);
        return socket;
    }

    public final Socket createSocket(String str, int i) {
        return zzb(this.zzemp.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return zzb(this.zzemp.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return zzb(this.zzemp.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return zzb(this.zzemp.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return zzb(this.zzemp.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.zzemp.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzemp.getSupportedCipherSuites();
    }
}
