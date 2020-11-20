package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzeco {
    public static zzehf zza(zzeek zzeek) {
        switch (zzecn.zziaq[zzeek.ordinal()]) {
            case 1:
                return zzehf.UNCOMPRESSED;
            case 2:
                return zzehf.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            case 3:
                return zzehf.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzeek);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static zzehg zza(zzeey zzeey) {
        switch (zzecn.zziap[zzeey.ordinal()]) {
            case 1:
                return zzehg.NIST_P256;
            case 2:
                return zzehg.NIST_P384;
            case 3:
                return zzehg.NIST_P521;
            default:
                String valueOf = String.valueOf(zzeey);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static String zza(zzefa zzefa) {
        switch (zzecn.zziao[zzefa.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzefa);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
        }
    }

    public static void zza(zzeeq zzeeq) {
        zzehe.zza(zza(zzeeq.zzbce().zzbcr()));
        zza(zzeeq.zzbce().zzbcs());
        if (zzeeq.zzbcg() != zzeek.UNKNOWN_FORMAT) {
            zzeap.zza(zzeeq.zzbcf().zzbbz());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
