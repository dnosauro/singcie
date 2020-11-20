package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

public class zzapu {
    public static zzapo zzdp(String str) {
        try {
            return new zzapx((RtbAdapter) Class.forName(str, false, zzapu.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }
}
