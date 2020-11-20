package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

public final class zzayp {
    @GuardedBy("this")
    private String zzdsu = "0";
    @GuardedBy("this")
    private BigInteger zzebw = BigInteger.ONE;

    public final synchronized String zzxj() {
        String bigInteger;
        bigInteger = this.zzebw.toString();
        this.zzebw = this.zzebw.add(BigInteger.ONE);
        this.zzdsu = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzxk() {
        return this.zzdsu;
    }
}
