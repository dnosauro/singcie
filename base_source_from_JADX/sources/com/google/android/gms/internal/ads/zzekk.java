package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.spongycastle.i18n.LocalizedMessage;

public final class zzekk {
    private static final Charset ISO_8859_1 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzijg;
    private static final ByteBuffer zzioc;
    private static final zzejj zziod;

    static {
        byte[] bArr = new byte[0];
        zzijg = bArr;
        zzioc = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzijg;
        zziod = zzejj.zzb(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int zzbu(boolean z) {
        return z ? 1231 : 1237;
    }

    static Object zze(Object obj, Object obj2) {
        return ((zzels) obj).zzbid().zzf((zzels) obj2).zzbhu();
    }

    public static int zzfq(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static boolean zzk(zzels zzels) {
        if (!(zzels instanceof zzeim)) {
            return false;
        }
        zzeim zzeim = (zzeim) zzels;
        return false;
    }

    public static boolean zzx(byte[] bArr) {
        return zzeno.zzx(bArr);
    }

    public static String zzy(byte[] bArr) {
        return new String(bArr, UTF_8);
    }
}
