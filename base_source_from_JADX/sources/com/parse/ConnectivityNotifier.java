package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class ConnectivityNotifier extends BroadcastReceiver {
    private static final String TAG = "com.parse.ConnectivityNotifier";
    private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
    private boolean hasRegisteredReceiver = false;
    private Set<ConnectivityListener> listeners = new HashSet();
    private final Object lock = new Object();

    public interface ConnectivityListener {
        void networkConnectivityStatusChanged(Context context, Intent intent);
    }

    ConnectivityNotifier() {
    }

    public static ConnectivityNotifier getNotifier(Context context) {
        singleton.tryToRegisterForNetworkStatusNotifications(context);
        return singleton;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r1 = r1.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isConnected(android.content.Context r1) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            r0 = 0
            if (r1 != 0) goto L_0x000c
            return r0
        L_0x000c:
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x0019
            boolean r1 = r1.isConnected()
            if (r1 == 0) goto L_0x0019
            r0 = 1
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ConnectivityNotifier.isConnected(android.content.Context):boolean");
    }

    private boolean tryToRegisterForNetworkStatusNotifications(Context context) {
        synchronized (this.lock) {
            if (this.hasRegisteredReceiver) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.hasRegisteredReceiver = true;
                return true;
            } catch (ReceiverCallNotAllowedException unused) {
                PLog.m8820v(TAG, "Cannot register a broadcast receiver because the executing thread is currently in a broadcast receiver. Will try again later.");
                return false;
            }
        }
    }

    public void addListener(ConnectivityListener connectivityListener) {
        synchronized (this.lock) {
            this.listeners.add(connectivityListener);
        }
    }

    public void onReceive(Context context, Intent intent) {
        ArrayList<ConnectivityListener> arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList<>(this.listeners);
        }
        for (ConnectivityListener networkConnectivityStatusChanged : arrayList) {
            networkConnectivityStatusChanged.networkConnectivityStatusChanged(context, intent);
        }
    }

    public void removeListener(ConnectivityListener connectivityListener) {
        synchronized (this.lock) {
            this.listeners.remove(connectivityListener);
        }
    }
}
