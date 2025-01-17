package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.C0744e;
import androidx.p018c.C0400a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient {
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    /* access modifiers changed from: private */
    @GuardedBy("sAllClients")
    public static final Set<GoogleApiClient> zabq = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static final class Builder {
        private final Context mContext;
        private Looper zabj;
        private final Set<Scope> zabr;
        private final Set<Scope> zabs;
        private int zabt;
        private View zabu;
        private String zabv;
        private String zabw;
        private final Map<Api<?>, ClientSettings.OptionalApiSettings> zabx;
        private boolean zaby;
        private final Map<Api<?>, Api.ApiOptions> zabz;
        private LifecycleActivity zaca;
        private int zacb;
        private OnConnectionFailedListener zacc;
        private GoogleApiAvailability zacd;
        private Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
        private final ArrayList<ConnectionCallbacks> zacf;
        private final ArrayList<OnConnectionFailedListener> zacg;
        private boolean zach;
        private Account zax;

        @KeepForSdk
        public Builder(Context context) {
            this.zabr = new HashSet();
            this.zabs = new HashSet();
            this.zabx = new C0400a();
            this.zaby = false;
            this.zabz = new C0400a();
            this.zacb = -1;
            this.zacd = GoogleApiAvailability.getInstance();
            this.zace = zaa.zaph;
            this.zacf = new ArrayList<>();
            this.zacg = new ArrayList<>();
            this.zach = false;
            this.mContext = context;
            this.zabj = context.getMainLooper();
            this.zabv = context.getPackageName();
            this.zabw = context.getClass().getName();
        }

        @KeepForSdk
        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            Preconditions.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.zacf.add(connectionCallbacks);
            Preconditions.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zacg.add(onConnectionFailedListener);
        }

        private final <O extends Api.ApiOptions> void zaa(Api<O> api, O o, Scope... scopeArr) {
            HashSet hashSet = new HashSet(api.zah().getImpliedScopes(o));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.zabx.put(api, new ClientSettings.OptionalApiSettings(hashSet));
        }

        public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zabz.put(api, (Object) null);
            List<Scope> impliedScopes = api.zah().getImpliedScopes(null);
            this.zabs.addAll(impliedScopes);
            this.zabr.addAll(impliedScopes);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zabz.put(api, o);
            List<Scope> impliedScopes = api.zah().getImpliedScopes(o);
            this.zabs.addAll(impliedScopes);
            this.zabr.addAll(impliedScopes);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zabz.put(api, o);
            zaa(api, o, scopeArr);
            return this;
        }

        public final Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zabz.put(api, (Object) null);
            zaa(api, (Api.ApiOptions) null, scopeArr);
            return this;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            Preconditions.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.zacf.add(connectionCallbacks);
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.zacg.add(onConnectionFailedListener);
            return this;
        }

        public final Builder addScope(Scope scope) {
            Preconditions.checkNotNull(scope, "Scope must not be null");
            this.zabr.add(scope);
            return this;
        }

        @KeepForSdk
        public final Builder addScopeNames(String[] strArr) {
            for (String scope : strArr) {
                this.zabr.add(new Scope(scope));
            }
            return this;
        }

        public final GoogleApiClient build() {
            Preconditions.checkArgument(!this.zabz.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings buildClientSettings = buildClientSettings();
            Api api = null;
            Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = buildClientSettings.getOptionalApiSettings();
            C0400a aVar = new C0400a();
            C0400a aVar2 = new C0400a();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api next : this.zabz.keySet()) {
                Api.ApiOptions apiOptions = this.zabz.get(next);
                boolean z2 = optionalApiSettings.get(next) != null;
                aVar.put(next, Boolean.valueOf(z2));
                zaq zaq = new zaq(next, z2);
                arrayList.add(zaq);
                Api.AbstractClientBuilder zai = next.zai();
                Api api2 = next;
                Api.Client buildClient = zai.buildClient(this.mContext, this.zabj, buildClientSettings, apiOptions, zaq, zaq);
                aVar2.put(api2.getClientKey(), buildClient);
                if (zai.getPriority() == 1) {
                    z = apiOptions != null;
                }
                if (buildClient.providesSignIn()) {
                    if (api == null) {
                        api = api2;
                    } else {
                        String name = api2.getName();
                        String name2 = api.getName();
                        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21 + String.valueOf(name2).length());
                        sb.append(name);
                        sb.append(" cannot be used with ");
                        sb.append(name2);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            if (api != null) {
                if (!z) {
                    Preconditions.checkState(this.zax == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                    Preconditions.checkState(this.zabr.equals(this.zabs), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
                } else {
                    String name3 = api.getName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(name3).length() + 82);
                    sb2.append("With using ");
                    sb2.append(name3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            zaaw zaaw = new zaaw(this.mContext, new ReentrantLock(), this.zabj, buildClientSettings, this.zacd, this.zace, aVar, this.zacf, this.zacg, aVar2, this.zacb, zaaw.zaa(aVar2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.zabq) {
                GoogleApiClient.zabq.add(zaaw);
            }
            if (this.zacb >= 0) {
                zaj.zaa(this.zaca).zaa(this.zacb, zaaw, this.zacc);
            }
            return zaaw;
        }

        @KeepForSdk
        @VisibleForTesting
        public final ClientSettings buildClientSettings() {
            SignInOptions signInOptions = SignInOptions.DEFAULT;
            if (this.zabz.containsKey(zaa.API)) {
                signInOptions = (SignInOptions) this.zabz.get(zaa.API);
            }
            return new ClientSettings(this.zax, this.zabr, this.zabx, this.zabt, this.zabu, this.zabv, this.zabw, signInOptions, false);
        }

        public final Builder enableAutoManage(C0744e eVar, int i, OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) eVar);
            Preconditions.checkArgument(i >= 0, "clientId must be non-negative");
            this.zacb = i;
            this.zacc = onConnectionFailedListener;
            this.zaca = lifecycleActivity;
            return this;
        }

        public final Builder enableAutoManage(C0744e eVar, OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(eVar, 0, onConnectionFailedListener);
        }

        public final Builder setAccountName(String str) {
            this.zax = str == null ? null : new Account(str, AccountType.GOOGLE);
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.zabt = i;
            return this;
        }

        public final Builder setHandler(Handler handler) {
            Preconditions.checkNotNull(handler, "Handler must not be null");
            this.zabj = handler.getLooper();
            return this;
        }

        public final Builder setViewForPopups(View view) {
            Preconditions.checkNotNull(view, "View must not be null");
            this.zabu = view;
            return this;
        }

        public final Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (zabq) {
            int i = 0;
            String concat = String.valueOf(str).concat("  ");
            for (GoogleApiClient dump : zabq) {
                printWriter.append(str).append("GoogleApiClient#").println(i);
                dump.dump(concat, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set;
        synchronized (zabq) {
            set = zabq;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean hasApi(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(C0744e eVar);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public void zaa(zacm zacm) {
        throw new UnsupportedOperationException();
    }

    public void zab(zacm zacm) {
        throw new UnsupportedOperationException();
    }
}
