package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

final class zzecf extends zzeag<zzdzx, zzeer> {
    zzecf(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) {
        zzeer zzeer = (zzeer) obj;
        zzeeq zzbcc = zzeer.zzbcj().zzbcc();
        zzeev zzbce = zzbcc.zzbce();
        zzehg zza = zzeco.zza(zzbce.zzbcr());
        byte[] byteArray = zzeer.zzbam().toByteArray();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, byteArray), zzehe.zza(zza));
        return new zzegx((ECPrivateKey) zzehh.zzihj.zzhq("EC").generatePrivate(eCPrivateKeySpec), zzbce.zzbct().toByteArray(), zzeco.zza(zzbce.zzbcs()), zzeco.zza(zzbcc.zzbcg()), new zzecq(zzbcc.zzbcf().zzbbz()));
    }
}
