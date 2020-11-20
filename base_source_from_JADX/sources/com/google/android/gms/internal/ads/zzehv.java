package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

final class zzehv extends ThreadLocal<Mac> {
    private final /* synthetic */ zzehw zzihs;

    zzehv(zzehw zzehw) {
        this.zzihs = zzehw;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbfb */
    public final Mac initialValue() {
        try {
            Mac zzhq = zzehh.zzihe.zzhq(this.zzihs.zzihu);
            zzhq.init(this.zzihs.zzihv);
            return zzhq;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
