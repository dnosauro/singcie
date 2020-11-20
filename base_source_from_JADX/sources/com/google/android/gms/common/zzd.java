package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.spongycastle.i18n.LocalizedMessage;

abstract class zzd extends zzn {
    private int zza;

    protected zzd(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    protected static byte[] zza(String str) {
        try {
            return str.getBytes(LocalizedMessage.DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        IObjectWrapper zzb;
        if (obj != null && (obj instanceof zzl)) {
            try {
                zzl zzl = (zzl) obj;
                if (zzl.zzc() != hashCode() || (zzb = zzl.zzb()) == null) {
                    return false;
                }
                return Arrays.equals(zza(), (byte[]) ObjectWrapper.unwrap(zzb));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zza();

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(zza());
    }

    public final int zzc() {
        return hashCode();
    }
}
