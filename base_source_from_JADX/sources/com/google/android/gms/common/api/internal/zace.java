package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace extends zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static Api.AbstractClientBuilder<? extends zad, SignInOptions> zaki = zaa.zaph;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> mScopes;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zaau;
    private ClientSettings zaet;
    private zad zagb;
    /* access modifiers changed from: private */
    public zach zakj;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, zaki);
    }

    public zace(Context context, Handler handler, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.mContext = context;
        this.mHandler = handler;
        this.zaet = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zaau = abstractClientBuilder;
    }

    /* access modifiers changed from: private */
    public final void zac(zaj zaj) {
        ConnectionResult connectionResult = zaj.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacx = zaj.zacx();
            connectionResult = zacx.getConnectionResult();
            if (!connectionResult.isSuccess()) {
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
            } else {
                this.zakj.zaa(zacx.getAccountAccessor(), this.mScopes);
                this.zagb.disconnect();
            }
        }
        this.zakj.zag(connectionResult);
        this.zagb.disconnect();
    }

    public final void onConnected(Bundle bundle) {
        this.zagb.zaa(this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zakj.zag(connectionResult);
    }

    public final void onConnectionSuspended(int i) {
        this.zagb.disconnect();
    }

    public final void zaa(zach zach) {
        zad zad = this.zagb;
        if (zad != null) {
            zad.disconnect();
        }
        this.zaet.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zaau;
        Context context = this.mContext;
        Looper looper = this.mHandler.getLooper();
        ClientSettings clientSettings = this.zaet;
        this.zagb = (zad) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), this, this);
        this.zakj = zach;
        Set<Scope> set = this.mScopes;
        if (set == null || set.isEmpty()) {
            this.mHandler.post(new zacf(this));
        } else {
            this.zagb.connect();
        }
    }

    public final void zab(zaj zaj) {
        this.mHandler.post(new zacg(this, zaj));
    }

    public final zad zabq() {
        return this.zagb;
    }

    public final void zabs() {
        zad zad = this.zagb;
        if (zad != null) {
            zad.disconnect();
        }
    }
}
