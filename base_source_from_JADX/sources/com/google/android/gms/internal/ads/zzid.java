package com.google.android.gms.internal.ads;

import com.parse.ParseException;
import com.unboundid.asn1.ASN1Constants;
import java.nio.ByteBuffer;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

public final class zzid {
    private static final int[] zzaii = {1, 2, 3, 6};
    private static final int[] zzaij = {48000, 44100, 32000};
    private static final int[] zzaik = {24000, 22050, 16000};
    private static final int[] zzail = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzaim = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzain = {69, 87, 104, 121, 139, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, ParseException.ACCOUNT_ALREADY_LINKED, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzhp zza(zzpn zzpn, String str, String str2, zzjo zzjo) {
        int i = zzaij[(zzpn.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpn.readUnsignedByte();
        int i2 = zzail[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzhp.zza(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzjo, 0, str2);
    }

    public static zzhp zzb(zzpn zzpn, String str, String str2, zzjo zzjo) {
        zzpn zzpn2 = zzpn;
        zzpn.zzbm(2);
        int i = zzaij[(zzpn.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpn.readUnsignedByte();
        int i2 = zzail[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzhp.zza(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzjo, 0, str2);
    }

    public static int zzfi() {
        return 1536;
    }

    public static int zzm(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzaii[(byteBuffer.get(byteBuffer.position() + 4) & ASN1Constants.UNIVERSAL_SEQUENCE_TYPE) >> 4];
        }
        return i * 256;
    }
}
