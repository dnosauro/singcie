package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedm;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzefc;
import java.security.GeneralSecurityException;
import java.util.Arrays;

final class zzecq implements zzegy {
    private final String zziar;
    private final int zzias;
    private zzedy zziat;
    private zzedi zziau;
    private int zziav;

    zzecq(zzefn zzefn) {
        this.zziar = zzefn.zzbdf();
        if (this.zziar.equals(zzeav.zzhzk)) {
            try {
                zzedz zzl = zzedz.zzl(zzefn.zzbdg(), zzeju.zzbhe());
                this.zziat = (zzedy) zzeap.zzb(zzefn);
                this.zzias = zzl.getKeySize();
            } catch (zzeks e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zziar.equals(zzeav.zzhzj)) {
            try {
                zzedj zzf = zzedj.zzf(zzefn.zzbdg(), zzeju.zzbhe());
                this.zziau = (zzedi) zzeap.zzb(zzefn);
                this.zziav = zzf.zzbay().getKeySize();
                this.zzias = this.zziav + zzf.zzbaz().getKeySize();
            } catch (zzeks e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(this.zziar);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zzbal() {
        return this.zzias;
    }

    public final zzdzt zzm(byte[] bArr) {
        zzels zzels;
        if (bArr.length == this.zzias) {
            if (this.zziar.equals(zzeav.zzhzk)) {
                zzels = (zzedy) ((zzekh) ((zzedy.zza) zzedy.zzbbq().zza(this.zziat)).zzw(zzeiu.zzh(bArr, 0, this.zzias)).zzbhv());
            } else if (this.zziar.equals(zzeav.zzhzj)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zziav);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zziav, this.zzias);
                zzels = (zzedi) ((zzekh) zzedi.zzbaw().zzew(this.zziau.getVersion()).zzc((zzedm) ((zzekh) ((zzedm.zza) zzedm.zzbbc().zza(this.zziau.zzbau())).zzu(zzeiu.zzt(copyOfRange)).zzbhv())).zzc((zzefc) ((zzekh) ((zzefc.zza) zzefc.zzbcx().zza(this.zziau.zzbav())).zzae(zzeiu.zzt(copyOfRange2)).zzbhv())).zzbhv());
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            return (zzdzt) zzeap.zza(this.zziar, zzels, zzdzt.class);
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }
}
