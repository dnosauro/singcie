package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzbca implements zzhg, zzih, zzmz, zzpd<zzon>, zzqg {
    @VisibleForTesting
    private static int zzems;
    @VisibleForTesting
    private static int zzemt;
    private int bytesTransferred;
    private final Context context;
    private int zzblp;
    private final String zzbvf;
    private final int zzbvg;
    private final zzbbf zzelt;
    private final zzbcb zzemu;
    private final zzhy zzemv;
    private final zzhy zzemw;
    private final zzob zzemx;
    private zzhd zzemy;
    private ByteBuffer zzemz;
    private boolean zzena;
    private final WeakReference<zzbbe> zzenb;
    private zzbck zzenc;
    private long zzend;
    private final ArrayList<zzot> zzene;
    private volatile zzbbw zzenf;
    private Set<WeakReference<zzbbu>> zzeng = new HashSet();

    public zzbca(Context context2, zzbbf zzbbf, zzbbe zzbbe) {
        this.context = context2;
        this.zzelt = zzbbf;
        this.zzenb = new WeakReference<>(zzbbe);
        this.zzemu = new zzbcb();
        this.zzemv = new zzqa(this.context, zzlx.zzbcu, 0, zzm.zzedd, this, -1);
        this.zzemw = new zzjc(zzlx.zzbcu, zzm.zzedd, this);
        this.zzemx = new zznw();
        if (zzd.zzxn()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzd.zzee(sb.toString());
        }
        zzems++;
        int i = 0;
        this.zzemy = zzhh.zza(new zzhy[]{this.zzemw, this.zzemv}, this.zzemx, this.zzemu);
        this.zzemy.zza((zzhg) this);
        this.bytesTransferred = 0;
        this.zzend = 0;
        this.zzblp = 0;
        this.zzene = new ArrayList<>();
        this.zzenf = null;
        this.zzbvf = (zzbbe == null || zzbbe.zzaal() == null) ? "" : zzbbe.zzaal();
        this.zzbvg = zzbbe != null ? zzbbe.zzaam() : i;
    }

    private final boolean zzabl() {
        return this.zzenf != null && this.zzenf.zzabl();
    }

    public static int zzabq() {
        return zzems;
    }

    public static int zzabr() {
        return zzemt;
    }

    @VisibleForTesting
    private final zzna zzb(Uri uri, String str) {
        zzbcc zzbcc;
        if (!this.zzena || this.zzemz.limit() <= 0) {
            zzom zzbcf = this.zzelt.zzekz > 0 ? new zzbcf(this, str) : new zzbce(this, str);
            zzbcg zzbch = this.zzelt.zzela ? new zzbch(this, zzbcf) : zzbcf;
            if (this.zzemz.limit() > 0) {
                byte[] bArr = new byte[this.zzemz.limit()];
                this.zzemz.get(bArr);
                zzbch = new zzbcg(zzbch, bArr);
            }
            zzbcc = zzbch;
        } else {
            byte[] bArr2 = new byte[this.zzemz.limit()];
            this.zzemz.get(bArr2);
            zzbcc = new zzbcc(bArr2);
        }
        return new zzmw(uri, zzbcc, ((Boolean) zzwq.zzqe().zzd(zzabf.zzcme)).booleanValue() ? zzbcj.zzenr : zzbci.zzenr, this.zzelt.zzelb, zzm.zzedd, this, (String) null, this.zzelt.zzekx);
    }

    private static long zzk(Map<String, List<String>> map) {
        if (map == null) {
            return 0;
        }
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                try {
                    if (!(next.getKey() == null || !zzdve.zza("content-length", (CharSequence) next.getKey()) || next.getValue() == null || ((List) next.getValue()).get(0) == null)) {
                        return Long.parseLong((String) ((List) next.getValue()).get(0));
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
        }
        return 0;
    }

    public final void finalize() {
        zzems--;
        if (zzd.zzxn()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzd.zzee(sb.toString());
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    public final long getTotalBytes() {
        if (zzabl()) {
            return this.zzenf.getContentLength();
        }
        while (!this.zzene.isEmpty()) {
            this.zzend += zzk(this.zzene.remove(0).getResponseHeaders());
        }
        return this.zzend;
    }

    public final void release() {
        zzhd zzhd = this.zzemy;
        if (zzhd != null) {
            zzhd.zzb((zzhg) this);
            this.zzemy.release();
            this.zzemy = null;
            zzemt--;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzon zza(zzom zzom) {
        return new zzbbw(this.context, zzom.zzip(), this.zzbvf, this.zzbvg, this, new zzbcl(this));
    }

    public final void zza(int i, int i2, int i3, float f) {
        zzbck zzbck = this.zzenc;
        if (zzbck != null) {
            zzbck.zzn(i, i2);
        }
    }

    public final void zza(int i, long j, long j2) {
    }

    public final void zza(Surface surface) {
    }

    /* access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        if (this.zzemy != null) {
            zzhi zzhi = new zzhi(this.zzemv, 1, surface);
            if (z) {
                this.zzemy.zzb(zzhi);
                return;
            }
            this.zzemy.zza(zzhi);
        }
    }

    public final void zza(zzbck zzbck) {
        this.zzenc = zzbck;
    }

    public final void zza(zzhe zzhe) {
        zzbck zzbck = this.zzenc;
        if (zzbck != null) {
            zzbck.zza("onPlayerError", zzhe);
        }
    }

    public final void zza(zzhv zzhv) {
    }

    public final void zza(zzhz zzhz, Object obj) {
    }

    public final void zza(zzjm zzjm) {
    }

    public final void zza(zznq zznq, zzoe zzoe) {
    }

    public final /* synthetic */ void zza(Object obj, zzoo zzoo) {
        zzon zzon = (zzon) obj;
        if (zzon instanceof zzot) {
            this.zzene.add((zzot) zzon);
        } else if (zzon instanceof zzbbw) {
            this.zzenf = (zzbbw) zzon;
            zzbbe zzbbe = (zzbbe) this.zzenb.get();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && zzbbe != null && this.zzenf.zzmy()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzenf.zznb()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzenf.zzabm()));
                zzm.zzedd.post(new zzbcd(zzbbe, hashMap));
            }
        }
    }

    public final void zza(String str, long j, long j2) {
    }

    public final void zza(boolean z, int i) {
        zzbck zzbck = this.zzenc;
        if (zzbck != null) {
            zzbck.zzdr(i);
        }
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzna zzna;
        if (this.zzemy != null) {
            this.zzemz = byteBuffer;
            this.zzena = z;
            if (uriArr.length == 1) {
                zzna = zzb(uriArr[0], str);
            } else {
                zzna[] zznaArr = new zzna[uriArr.length];
                for (int i = 0; i < uriArr.length; i++) {
                    zznaArr[i] = zzb(uriArr[i], str);
                }
                zzna = new zznf(zznaArr);
            }
            this.zzemy.zza(zzna);
            zzemt++;
        }
    }

    public final zzhd zzabp() {
        return this.zzemy;
    }

    public final zzbcb zzabs() {
        return this.zzemu;
    }

    /* access modifiers changed from: package-private */
    public final void zzav(boolean z) {
        if (this.zzemy != null) {
            for (int i = 0; i < this.zzemy.zzel(); i++) {
                this.zzemx.zzf(i, !z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(float f, boolean z) {
        if (this.zzemy != null) {
            zzhi zzhi = new zzhi(this.zzemw, 2, Float.valueOf(f));
            if (z) {
                this.zzemy.zzb(zzhi);
                return;
            }
            this.zzemy.zza(zzhi);
        }
    }

    public final void zzb(zzhp zzhp) {
        zzbbe zzbbe = (zzbbe) this.zzenb.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && zzbbe != null && zzhp != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzhp.zzagz);
            hashMap.put("audioCodec", zzhp.zzagx);
            zzbbe.zza("onMetadataEvent", hashMap);
        }
    }

    public final void zzb(zzjm zzjm) {
    }

    public final void zzb(IOException iOException) {
        zzbck zzbck = this.zzenc;
        if (zzbck != null) {
            zzbck.zza("onLoadError", iOException);
        }
    }

    public final /* synthetic */ void zzc(Object obj, int i) {
        this.bytesTransferred += i;
    }

    public final void zzd(String str, long j, long j2) {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbck zzbck = this.zzenc;
        if (zzbck != null) {
            zzbck.zzb(z, j);
        }
    }

    public final void zzdp(int i) {
        for (WeakReference<zzbbu> weakReference : this.zzeng) {
            zzbbu zzbbu = (zzbbu) weakReference.get();
            if (zzbbu != null) {
                zzbbu.setReceiveBufferSize(i);
            }
        }
    }

    public final void zze(zzjm zzjm) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final void zzen() {
    }

    public final void zzf(int i, long j) {
        this.zzblp += i;
    }

    public final void zzf(zzjm zzjm) {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzfh(String str) {
        return new zzoq(str, (zzpp<String>) null, this.zzelt.zzela ? null : this, this.zzelt.zzeku, this.zzelt.zzekw, true, (zzox) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzfi(String str) {
        zzbbu zzbbu = new zzbbu(str, this.zzelt.zzela ? null : this, this.zzelt.zzeku, this.zzelt.zzekw, this.zzelt.zzekz);
        this.zzeng.add(new WeakReference(zzbbu));
        return zzbbu;
    }

    public final void zzg(boolean z) {
    }

    public final void zzk(zzhp zzhp) {
        zzbbe zzbbe = (zzbbe) this.zzenb.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && zzbbe != null && zzhp != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzhp.zzahe));
            hashMap.put("bitRate", String.valueOf(zzhp.zzagw));
            int i = zzhp.width;
            int i2 = zzhp.height;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            hashMap.put("resolution", sb.toString());
            hashMap.put("videoMime", zzhp.zzagz);
            hashMap.put("videoCodec", zzhp.zzagx);
            zzbbe.zza("onMetadataEvent", hashMap);
        }
    }

    public final long zzna() {
        if (zzabl() && this.zzenf.zznb()) {
            return Math.min((long) this.bytesTransferred, this.zzenf.zzna());
        }
        return 0;
    }

    public final void zzw(int i) {
    }

    public final long zzzo() {
        if (!zzabl()) {
            return (long) this.bytesTransferred;
        }
        return 0;
    }

    public final int zzzp() {
        return this.zzblp;
    }
}
