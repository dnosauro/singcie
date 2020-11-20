package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zzqb {
    public final List<byte[]> zzahc;
    public final int zzasp;

    private zzqb(List<byte[]> list, int i) {
        this.zzahc = list;
        this.zzasp = i;
    }

    public static zzqb zzi(zzpn zzpn) {
        try {
            zzpn.zzbm(21);
            int readUnsignedByte = zzpn.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzpn.readUnsignedByte();
            int position = zzpn.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                zzpn.zzbm(1);
                int readUnsignedShort = zzpn.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzpn.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    zzpn.zzbm(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzpn.zzbl(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                zzpn.zzbm(1);
                int readUnsignedShort3 = zzpn.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = zzpn.readUnsignedShort();
                    System.arraycopy(zzpi.zzbjq, 0, bArr, i7, zzpi.zzbjq.length);
                    int length = i7 + zzpi.zzbjq.length;
                    System.arraycopy(zzpn.data, zzpn.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    zzpn.zzbm(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new zzqb(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhw("Error parsing HEVC config", e);
        }
    }
}
