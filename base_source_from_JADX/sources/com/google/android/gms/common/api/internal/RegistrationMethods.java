package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
    public final RegisterListenerMethod<A, L> zajz;
    public final UnregisterListenerMethod<A, L> zaka;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {
        private boolean zajw;
        /* access modifiers changed from: private */
        public RemoteCall<A, TaskCompletionSource<Void>> zakb;
        /* access modifiers changed from: private */
        public RemoteCall<A, TaskCompletionSource<Boolean>> zakc;
        private ListenerHolder<L> zakd;
        private Feature[] zake;

        private Builder() {
            this.zajw = true;
        }

        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z = true;
            Preconditions.checkArgument(this.zakb != null, "Must set register function");
            Preconditions.checkArgument(this.zakc != null, "Must set unregister function");
            if (this.zakd == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Must set holder");
            return new RegistrationMethods<>(new zaca(this, this.zakd, this.zake, this.zajw), new zacb(this, this.zakd.getListenerKey()));
        }

        @KeepForSdk
        public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.zakb = remoteCall;
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> biConsumer) {
            this.zakb = new zaby(biConsumer);
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z) {
            this.zajw = z;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setFeatures(Feature[] featureArr) {
            this.zake = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.zakc = remoteCall;
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> biConsumer) {
            this.zakb = new zabz(this);
            return this;
        }

        @KeepForSdk
        public Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
            this.zakd = listenerHolder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void zaa(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
            this.zakb.accept(anyClient, taskCompletionSource);
        }
    }

    private RegistrationMethods(RegisterListenerMethod<A, L> registerListenerMethod, UnregisterListenerMethod<A, L> unregisterListenerMethod) {
        this.zajz = registerListenerMethod;
        this.zaka = unregisterListenerMethod;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>();
    }
}
