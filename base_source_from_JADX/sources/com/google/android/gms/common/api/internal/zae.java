package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {
    private final A zaco;

    public zae(int i, A a) {
        super(i);
        this.zaco = a;
    }

    public final void zaa(Status status) {
        this.zaco.setFailedResult(status);
    }

    public final void zaa(GoogleApiManager.zaa<?> zaa) {
        try {
            this.zaco.run(zaa.zaab());
        } catch (RuntimeException e) {
            zaa(e);
        }
    }

    public final void zaa(zaab zaab, boolean z) {
        zaab.zaa((BasePendingResult<? extends Result>) this.zaco, z);
    }

    public final void zaa(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.zaco.setFailedResult(new Status(10, sb.toString()));
    }
}
