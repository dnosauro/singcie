package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

class zzecx implements zzeao<zzeak> {
    private static final Logger logger = Logger.getLogger(zzecx.class.getName());

    static class zza implements zzeak {
        private final zzeam<zzeak> zzian;
        private final byte[] zziay;

        private zza(zzeam<zzeak> zzeam) {
            this.zziay = new byte[]{0};
            this.zzian = zzeam;
        }

        public final byte[] zzl(byte[] bArr) {
            byte[][] bArr2;
            if (this.zzian.zzbae().zzbac().equals(zzegd.LEGACY)) {
                bArr2 = new byte[][]{this.zzian.zzbae().zzbad(), this.zzian.zzbae().zzbaa().zzl(zzegr.zza(bArr, this.zziay))};
            } else {
                bArr2 = new byte[][]{this.zzian.zzbae().zzbad(), this.zzian.zzbae().zzbaa().zzl(bArr)};
            }
            return zzegr.zza(bArr2);
        }
    }

    zzecx() {
    }

    public final /* synthetic */ Object zza(zzeam zzeam) {
        return new zza(zzeam);
    }

    public final Class<zzeak> zzazr() {
        return zzeak.class;
    }
}
