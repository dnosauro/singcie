package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbm implements zzbo {
    private static Logger zzcx = Logger.getLogger(zzbm.class.getName());
    private ThreadLocal<ByteBuffer> zzcy = new zzbl(this);

    public final zzbp zza(zzeor zzeor, zzbs zzbs) {
        int read;
        long j;
        zzeor zzeor2 = zzeor;
        zzbs zzbs2 = zzbs;
        long position = zzeor.position();
        this.zzcy.get().rewind().limit(8);
        do {
            read = zzeor2.read(this.zzcy.get());
            if (read == 8) {
                this.zzcy.get().rewind();
                long zzf = zzbq.zzf(this.zzcy.get());
                byte[] bArr = null;
                if (zzf >= 8 || zzf <= 1) {
                    String zzk = zzbq.zzk(this.zzcy.get());
                    if (zzf == 1) {
                        this.zzcy.get().limit(16);
                        zzeor2.read(this.zzcy.get());
                        this.zzcy.get().position(8);
                        j = zzbq.zzh(this.zzcy.get()) - 16;
                    } else {
                        j = zzf == 0 ? zzeor.size() - zzeor.position() : zzf - 8;
                    }
                    if ("uuid".equals(zzk)) {
                        this.zzcy.get().limit(this.zzcy.get().limit() + 16);
                        zzeor2.read(this.zzcy.get());
                        bArr = new byte[16];
                        for (int position2 = this.zzcy.get().position() - 16; position2 < this.zzcy.get().position(); position2++) {
                            bArr[position2 - (this.zzcy.get().position() - 16)] = this.zzcy.get().get(position2);
                        }
                        j -= 16;
                    }
                    long j2 = j;
                    zzbp zza = zza(zzk, bArr, zzbs2 instanceof zzbp ? ((zzbp) zzbs2).getType() : "");
                    zza.zza(zzbs2);
                    this.zzcy.get().rewind();
                    zza.zza(zzeor, this.zzcy.get(), j2, this);
                    return zza;
                }
                Logger logger = zzcx;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zzf);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzeor2.zzfc(position);
        throw new EOFException();
    }

    public abstract zzbp zza(String str, byte[] bArr, String str2);
}
