package com.google.android.gms.internal.ads;

import java.util.Stack;

final class zzkj implements zzkk {
    private final byte[] zzaoz = new byte[8];
    private final Stack<zzkl> zzapa = new Stack<>();
    private final zzkt zzapb = new zzkt();
    private zzkn zzapc;
    private int zzapd;
    private int zzape;
    private long zzapf;

    zzkj() {
    }

    private final long zza(zzjz zzjz, int i) {
        zzjz.readFully(this.zzaoz, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzaoz[i2] & 255));
        }
        return j;
    }

    public final void reset() {
        this.zzapd = 0;
        this.zzapa.clear();
        this.zzapb.reset();
    }

    public final void zza(zzkn zzkn) {
        this.zzapc = zzkn;
    }

    public final boolean zzb(zzjz zzjz) {
        String str;
        zzpc.checkState(this.zzapc != null);
        while (true) {
            if (this.zzapa.isEmpty() || zzjz.getPosition() < this.zzapa.peek().zzapg) {
                if (this.zzapd == 0) {
                    long zza = this.zzapb.zza(zzjz, true, false, 4);
                    if (zza == -2) {
                        zzjz.zzgq();
                        while (true) {
                            zzjz.zza(this.zzaoz, 0, 4);
                            int zzar = zzkt.zzar(this.zzaoz[0]);
                            if (zzar != -1 && zzar <= 4) {
                                int zza2 = (int) zzkt.zza(this.zzaoz, zzar, false);
                                if (this.zzapc.zzam(zza2)) {
                                    zzjz.zzag(zzar);
                                    zza = (long) zza2;
                                }
                            }
                            zzjz.zzag(1);
                        }
                    }
                    if (zza == -1) {
                        return false;
                    }
                    this.zzape = (int) zza;
                    this.zzapd = 1;
                }
                if (this.zzapd == 1) {
                    this.zzapf = this.zzapb.zza(zzjz, false, true, 8);
                    this.zzapd = 2;
                }
                int zzal = this.zzapc.zzal(this.zzape);
                switch (zzal) {
                    case 0:
                        zzjz.zzag((int) this.zzapf);
                        this.zzapd = 0;
                    case 1:
                        long position = zzjz.getPosition();
                        this.zzapa.add(new zzkl(this.zzape, this.zzapf + position));
                        this.zzapc.zzd(this.zzape, position, this.zzapf);
                        this.zzapd = 0;
                        return true;
                    case 2:
                        long j = this.zzapf;
                        if (j <= 8) {
                            this.zzapc.zzd(this.zzape, zza(zzjz, (int) j));
                            this.zzapd = 0;
                            return true;
                        }
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j);
                        throw new zzhw(sb.toString());
                    case 3:
                        long j2 = this.zzapf;
                        if (j2 <= 2147483647L) {
                            zzkn zzkn = this.zzapc;
                            int i = this.zzape;
                            int i2 = (int) j2;
                            if (i2 == 0) {
                                str = "";
                            } else {
                                byte[] bArr = new byte[i2];
                                zzjz.readFully(bArr, 0, i2);
                                str = new String(bArr);
                            }
                            zzkn.zza(i, str);
                            this.zzapd = 0;
                            return true;
                        }
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j2);
                        throw new zzhw(sb2.toString());
                    case 4:
                        this.zzapc.zza(this.zzape, (int) this.zzapf, zzjz);
                        this.zzapd = 0;
                        return true;
                    case 5:
                        long j3 = this.zzapf;
                        if (j3 == 4 || j3 == 8) {
                            zzkn zzkn2 = this.zzapc;
                            int i3 = this.zzape;
                            int i4 = (int) this.zzapf;
                            long zza3 = zza(zzjz, i4);
                            zzkn2.zza(i3, i4 == 4 ? (double) Float.intBitsToFloat((int) zza3) : Double.longBitsToDouble(zza3));
                            this.zzapd = 0;
                            return true;
                        }
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j3);
                        throw new zzhw(sb3.toString());
                    default:
                        StringBuilder sb4 = new StringBuilder(32);
                        sb4.append("Invalid element type ");
                        sb4.append(zzal);
                        throw new zzhw(sb4.toString());
                }
            } else {
                this.zzapc.zzan(this.zzapa.pop().zzape);
                return true;
            }
        }
    }
}
