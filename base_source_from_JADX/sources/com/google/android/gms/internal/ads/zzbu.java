package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;
import org.spongycastle.crypto.tls.CipherSuite;

public final class zzbu extends zzeoq {
    private Date zzdb;
    private Date zzdc;
    private long zzdd;
    private long zzde;
    private double zzdf = 1.0d;
    private float zzdg = 1.0f;
    private zzepa zzdh = zzepa.zziyq;
    private long zzdi;
    private int zzdj;
    private int zzdk;
    private int zzdl;
    private int zzdm;
    private int zzdn;
    private int zzdo;

    public zzbu() {
        super("mvhd");
    }

    public final long getDuration() {
        return this.zzde;
    }

    public final String toString() {
        return "MovieHeaderBox[" + "creationTime=" + this.zzdb + ";" + "modificationTime=" + this.zzdc + ";" + "timescale=" + this.zzdd + ";" + "duration=" + this.zzde + ";" + "rate=" + this.zzdf + ";" + "volume=" + this.zzdg + ";" + "matrix=" + this.zzdh + ";" + "nextTrackId=" + this.zzdi + "]";
    }

    public final void zzl(ByteBuffer byteBuffer) {
        long j;
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.zzdb = zzeot.zzfu(zzbq.zzh(byteBuffer));
            this.zzdc = zzeot.zzfu(zzbq.zzh(byteBuffer));
            this.zzdd = zzbq.zzf(byteBuffer);
            j = zzbq.zzh(byteBuffer);
        } else {
            this.zzdb = zzeot.zzfu(zzbq.zzf(byteBuffer));
            this.zzdc = zzeot.zzfu(zzbq.zzf(byteBuffer));
            this.zzdd = zzbq.zzf(byteBuffer);
            j = zzbq.zzf(byteBuffer);
        }
        this.zzde = j;
        this.zzdf = zzbq.zzi(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzdg = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB)))))) / 256.0f;
        zzbq.zzg(byteBuffer);
        zzbq.zzf(byteBuffer);
        zzbq.zzf(byteBuffer);
        this.zzdh = zzepa.zzs(byteBuffer);
        this.zzdj = byteBuffer.getInt();
        this.zzdk = byteBuffer.getInt();
        this.zzdl = byteBuffer.getInt();
        this.zzdm = byteBuffer.getInt();
        this.zzdn = byteBuffer.getInt();
        this.zzdo = byteBuffer.getInt();
        this.zzdi = zzbq.zzf(byteBuffer);
    }

    public final long zzr() {
        return this.zzdd;
    }
}
