package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

@VisibleForTesting
public final class zzdsg {
    @VisibleForTesting
    private static final byte[] zzhpp = {61, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -5, 79, -74, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -12, -34, 95, -25, -62, 63, 50, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -113, -103, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST};
    @VisibleForTesting
    private static final byte[] zzhpq = {Tnaf.POW_2_WIDTH, 57, 56, -18, 69, 55, -27, -98, -114, -25, -110, -10, 84, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 79, -72, 52, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -58, -77, 70, -48, -69, -60, 65, 95, -61, 57, -4, -4, -114, -63};
    private final byte[] zzhpn = zzhpq;
    private final byte[] zzhpo = zzhpp;

    private static X509Certificate zzgx(String str) {
        try {
            X509Certificate[][] zza = zzb.zza(str);
            if (zza.length == 1) {
                return zza[0][0];
            }
            throw new GeneralSecurityException("APK has more than one signature.");
        } catch (zzh e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException | RuntimeException e2) {
            throw new GeneralSecurityException("Failed to verify signatures", e2);
        }
    }

    public final boolean zzb(File file) {
        byte[] digest = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA256).digest(zzgx(file.getAbsolutePath()).getEncoded());
        if (!Arrays.equals(this.zzhpo, digest)) {
            return !"user".equals(Build.TYPE) && Arrays.equals(this.zzhpn, digest);
        }
        return true;
    }
}
