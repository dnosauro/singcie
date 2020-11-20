package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzcx {
    private static boolean zzno = false;
    /* access modifiers changed from: private */
    public static MessageDigest zznp;
    private static final Object zznq = new Object();
    private static final Object zznr = new Object();
    static CountDownLatch zzns = new CountDownLatch(1);

    private static zzcf.zza zza(zzcf.zza.zzd zzd) {
        zzcf.zza.C3704zza zzaq = zzcf.zza.zzaq();
        zzaq.zzn((long) zzd.zzv());
        return (zzcf.zza) ((zzekh) zzaq.zzbhv());
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) {
        ByteBuffer byteBuffer;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            byteBuffer = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            byteBuffer = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        byte[] array = byteBuffer.array();
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzde zza : new zzdc().zzvl) {
            zza.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeil(str.getBytes("UTF-8")).zzs(bArr3);
        }
        return bArr3;
    }

    public static byte[] zzb(byte[] bArr) {
        byte[] digest;
        synchronized (zznq) {
            MessageDigest zzbp = zzbp();
            if (zzbp != null) {
                zzbp.reset();
                zzbp.update(bArr);
                digest = zznp.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static void zzbo() {
        synchronized (zznr) {
            if (!zzno) {
                zzno = true;
                new Thread(new zzcz()).start();
            }
        }
    }

    private static MessageDigest zzbp() {
        boolean z;
        MessageDigest messageDigest;
        zzbo();
        try {
            z = zzns.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zznp) != null) {
            return messageDigest;
        }
        return null;
    }

    static String zzj(zzcf.zza zza, String str) {
        byte[] bArr;
        zzels zzbhv;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrg)).booleanValue()) {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                bArr = zza(zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
                return zzcv.zza(bArr, true);
            }
            zzcf.zzf.zza zzbl = zzcf.zzf.zzbl();
            Iterator<byte[]> it = zza2.iterator();
            while (it.hasNext()) {
                zzbl.zzj(zzeiu.zzt(zza(it.next(), str, false)));
            }
            zzbl.zzk(zzeiu.zzt(zzb(byteArray)));
            zzbhv = zzbl.zzbhv();
        } else if (zzfd.zzzm != null) {
            zzbhv = zzcf.zzf.zzbl().zzj(zzeiu.zzt(zzfd.zzzm.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzcm.TINK_HYBRID).zzbhv();
        } else {
            throw new GeneralSecurityException();
        }
        bArr = ((zzcf.zzf) ((zzekh) zzbhv)).toByteArray();
        return zzcv.zza(bArr, true);
    }
}
