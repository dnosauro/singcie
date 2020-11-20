package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public abstract class zzeiu implements Serializable, Iterable<Byte> {
    public static final zzeiu zziiy = new zzeje(zzekk.zzijg);
    private static final zzeja zziiz = (zzeir.zzbfn() ? new zzejg((zzeix) null) : new zzeiy((zzeix) null));
    private static final Comparator<zzeiu> zzija = new zzeiw();
    private int zziii = 0;

    zzeiu() {
    }

    private static zzeiu zza(Iterator<zzeiu> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            zzeiu zza = zza(it, i2);
            zzeiu zza2 = zza(it, i - i2);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return zzemk.zza(zza, zza2);
            }
            int size = zza.size();
            int size2 = zza2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static void zzab(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public static zzejh zzbft() {
        return new zzejh(128);
    }

    public static zzeiu zzg(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            zzeiu zzh = i2 == 0 ? null : zzh(bArr, 0, i2);
            if (zzh == null) {
                return zzl(arrayList);
            }
            arrayList.add(zzh);
            i = Math.min(i << 1, PKIFailureInfo.certRevoked);
        }
    }

    static zzejc zzga(int i) {
        return new zzejc(i, (zzeix) null);
    }

    public static zzeiu zzh(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        return new zzeje(zziiz.zzj(bArr, i, i2));
    }

    public static zzeiu zzhs(String str) {
        return new zzeje(str.getBytes(zzekk.UTF_8));
    }

    static int zzi(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public static zzeiu zzl(Iterable<zzeiu> iterable) {
        int i;
        if (!(iterable instanceof Collection)) {
            i = 0;
            Iterator<zzeiu> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
            }
        } else {
            i = ((Collection) iterable).size();
        }
        return i == 0 ? zziiy : zza(iterable.iterator(), i);
    }

    public static zzeiu zzt(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    static zzeiu zzu(byte[] bArr) {
        return new zzeje(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zziii;
        if (i == 0) {
            int size = size();
            i = zzh(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zziii = i;
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzekk.zzijg;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzenb.zzan(this) : String.valueOf(zzenb.zzan(zzaa(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzeiv zzeiv);

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzi(i, i + i3, size());
        zzi(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }

    public abstract zzeiu zzaa(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    /* renamed from: zzbfp */
    public zzejd iterator() {
        return new zzeix(this);
    }

    public final String zzbfq() {
        return size() == 0 ? "" : zza(zzekk.UTF_8);
    }

    public abstract boolean zzbfr();

    public abstract zzejj zzbfs();

    /* access modifiers changed from: protected */
    public abstract int zzbfu();

    /* access modifiers changed from: protected */
    public abstract boolean zzbfv();

    /* access modifiers changed from: protected */
    public final int zzbfw() {
        return this.zziii;
    }

    public abstract byte zzfy(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzfz(int i);

    /* access modifiers changed from: protected */
    public abstract int zzg(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzh(int i, int i2, int i3);
}
