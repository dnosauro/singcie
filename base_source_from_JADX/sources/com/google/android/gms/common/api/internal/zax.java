package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.p018c.C0400a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zax implements zabs {
    private final Looper zabj;
    private final GoogleApiManager zabm;
    /* access modifiers changed from: private */
    public final Lock zaeo;
    private final ClientSettings zaet;
    /* access modifiers changed from: private */
    public final Map<Api.AnyClientKey<?>, zaw<?>> zaeu = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Api.AnyClientKey<?>, zaw<?>> zaev = new HashMap();
    private final Map<Api<?>, Boolean> zaew;
    /* access modifiers changed from: private */
    public final zaaw zaex;
    private final GoogleApiAvailabilityLight zaey;
    /* access modifiers changed from: private */
    public final Condition zaez;
    private final boolean zafa;
    /* access modifiers changed from: private */
    public final boolean zafb;
    private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafc = new LinkedList();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public boolean zafd;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public Map<zai<?>, ConnectionResult> zafe;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public Map<zai<?>, ConnectionResult> zaff;
    @GuardedBy("mLock")
    private zaaa zafg;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public ConnectionResult zafh;

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zaaw zaaw, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.zaeo = lock;
        this.zabj = looper;
        this.zaez = lock.newCondition();
        this.zaey = googleApiAvailabilityLight;
        this.zaex = zaaw;
        this.zaew = map2;
        this.zaet = clientSettings;
        this.zafa = z;
        HashMap hashMap = new HashMap();
        for (Api next : map2.keySet()) {
            hashMap.put(next.getClientKey(), next);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zaq zaq = (zaq) obj;
            hashMap2.put(zaq.mApi, zaq);
        }
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        for (Map.Entry next2 : map.entrySet()) {
            Api api = (Api) hashMap.get(next2.getKey());
            Api.Client client = (Api.Client) next2.getValue();
            if (client.requiresGooglePlayServices()) {
                if (!this.zaew.get(api).booleanValue()) {
                    z3 = z7;
                    z4 = true;
                } else {
                    z3 = z7;
                    z4 = z8;
                }
                z2 = true;
            } else {
                z2 = z6;
                z4 = z8;
                z3 = false;
            }
            zaw zaw = r1;
            zaw zaw2 = new zaw(context, api, looper, client, (zaq) hashMap2.get(api), clientSettings, abstractClientBuilder);
            this.zaeu.put((Api.AnyClientKey) next2.getKey(), zaw);
            if (client.requiresSignIn()) {
                this.zaev.put((Api.AnyClientKey) next2.getKey(), zaw);
            }
            z8 = z4;
            z7 = z3;
            z6 = z2;
        }
        this.zafb = (!z6 || z7 || z8) ? false : z5;
        this.zabm = GoogleApiManager.zabc();
    }

    private final ConnectionResult zaa(Api.AnyClientKey<?> anyClientKey) {
        this.zaeo.lock();
        try {
            zaw zaw = this.zaeu.get(anyClientKey);
            if (this.zafe != null && zaw != null) {
                return this.zafe.get(zaw.zak());
            }
            this.zaeo.unlock();
            return null;
        } finally {
            this.zaeo.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final boolean zaa(zaw<?> zaw, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && this.zaew.get(zaw.getApi()).booleanValue() && zaw.zaab().requiresGooglePlayServices() && this.zaey.isUserResolvableError(connectionResult.getErrorCode());
    }

    private final boolean zaac() {
        this.zaeo.lock();
        try {
            if (this.zafd) {
                if (this.zafa) {
                    for (Api.AnyClientKey<?> zaa : this.zaev.keySet()) {
                        ConnectionResult zaa2 = zaa(zaa);
                        if (zaa2 != null) {
                            if (!zaa2.isSuccess()) {
                            }
                        }
                    }
                    this.zaeo.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.zaeo.unlock();
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaad() {
        Set<Scope> hashSet;
        zaaw zaaw;
        ClientSettings clientSettings = this.zaet;
        if (clientSettings == null) {
            zaaw = this.zaex;
            hashSet = Collections.emptySet();
        } else {
            hashSet = new HashSet<>(clientSettings.getRequiredScopes());
            Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zaet.getOptionalApiSettings();
            for (Api next : optionalApiSettings.keySet()) {
                ConnectionResult connectionResult = getConnectionResult(next);
                if (connectionResult != null && connectionResult.isSuccess()) {
                    hashSet.addAll(optionalApiSettings.get(next).mScopes);
                }
            }
            zaaw = this.zaex;
        }
        zaaw.zaha = hashSet;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaae() {
        while (!this.zafc.isEmpty()) {
            execute(this.zafc.remove());
        }
        this.zaex.zab((Bundle) null);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final ConnectionResult zaaf() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i = 0;
        int i2 = 0;
        for (zaw next : this.zaeu.values()) {
            Api api = next.getApi();
            ConnectionResult connectionResult3 = this.zafe.get(next.zak());
            if (!connectionResult3.isSuccess() && (!this.zaew.get(api).booleanValue() || connectionResult3.hasResolution() || this.zaey.isUserResolvableError(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() != 4 || !this.zafa) {
                    int priority = api.zah().getPriority();
                    if (connectionResult == null || i > priority) {
                        connectionResult = connectionResult3;
                        i = priority;
                    }
                } else {
                    int priority2 = api.zah().getPriority();
                    if (connectionResult2 == null || i2 > priority2) {
                        connectionResult2 = connectionResult3;
                        i2 = priority2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zab(T t) {
        Api.AnyClientKey clientKey = t.getClientKey();
        ConnectionResult zaa = zaa((Api.AnyClientKey<?>) clientKey);
        if (zaa == null || zaa.getErrorCode() != 4) {
            return false;
        }
        t.setFailedResult(new Status(4, (String) null, this.zabm.zaa((zai<?>) this.zaeu.get(clientKey).zak(), System.identityHashCode(this.zaex))));
        return true;
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zaez.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zafh;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zaez.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zafh;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    public final void connect() {
        this.zaeo.lock();
        try {
            if (!this.zafd) {
                this.zafd = true;
                this.zafe = null;
                this.zaff = null;
                this.zafg = null;
                this.zafh = null;
                this.zabm.zao();
                this.zabm.zaa((Iterable<? extends GoogleApi<?>>) this.zaeu.values()).addOnCompleteListener((Executor) new HandlerExecutor(this.zabj), new zaz(this));
            }
        } finally {
            this.zaeo.unlock();
        }
    }

    public final void disconnect() {
        this.zaeo.lock();
        try {
            this.zafd = false;
            this.zafe = null;
            this.zaff = null;
            if (this.zafg != null) {
                this.zafg.cancel();
                this.zafg = null;
            }
            this.zafh = null;
            while (!this.zafc.isEmpty()) {
                BaseImplementation.ApiMethodImpl remove = this.zafc.remove();
                remove.zaa((zacs) null);
                remove.cancel();
            }
            this.zaez.signalAll();
        } finally {
            this.zaeo.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (this.zafa && zab(t)) {
            return t;
        }
        if (!isConnected()) {
            this.zafc.add(t);
            return t;
        }
        this.zaex.zahf.zab(t);
        return this.zaeu.get(t.getClientKey()).doRead(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        Api.AnyClientKey clientKey = t.getClientKey();
        if (this.zafa && zab(t)) {
            return t;
        }
        this.zaex.zahf.zab(t);
        return this.zaeu.get(clientKey).doWrite(t);
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        return zaa(api.getClientKey());
    }

    public final boolean isConnected() {
        this.zaeo.lock();
        try {
            return this.zafe != null && this.zafh == null;
        } finally {
            this.zaeo.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zaeo.lock();
        try {
            return this.zafe == null && this.zafd;
        } finally {
            this.zaeo.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zaeo.lock();
        try {
            if (!this.zafd || zaac()) {
                this.zaeo.unlock();
                return false;
            }
            this.zabm.zao();
            this.zafg = new zaaa(this, signInConnectionListener);
            this.zabm.zaa((Iterable<? extends GoogleApi<?>>) this.zaev.values()).addOnCompleteListener((Executor) new HandlerExecutor(this.zabj), this.zafg);
            this.zaeo.unlock();
            return true;
        } catch (Throwable th) {
            this.zaeo.unlock();
            throw th;
        }
    }

    public final void maybeSignOut() {
        this.zaeo.lock();
        try {
            this.zabm.maybeSignOut();
            if (this.zafg != null) {
                this.zafg.cancel();
                this.zafg = null;
            }
            if (this.zaff == null) {
                this.zaff = new C0400a(this.zaev.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zaw<?> zak : this.zaev.values()) {
                this.zaff.put(zak.zak(), connectionResult);
            }
            if (this.zafe != null) {
                this.zafe.putAll(this.zaff);
            }
        } finally {
            this.zaeo.unlock();
        }
    }

    public final void zaw() {
    }
}
