package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.p172io.FilenameUtils;

@ParametersAreNonnullByDefault
public final class zzabs {
    private final Object lock = new Object();
    @VisibleForTesting
    final boolean zzczu = true;
    private final List<zzabq> zzczv = new LinkedList();
    private final Map<String, String> zzczw = new LinkedHashMap();
    private zzabs zzczx;

    public zzabs(boolean z, String str, String str2) {
        this.zzczw.put("action", str);
        this.zzczw.put("ad_format", str2);
    }

    public final boolean zza(zzabq zzabq, long j, String... strArr) {
        synchronized (this.lock) {
            for (String zzabq2 : strArr) {
                this.zzczv.add(new zzabq(j, zzabq2, zzabq));
            }
        }
        return true;
    }

    public final void zzc(zzabs zzabs) {
        synchronized (this.lock) {
            this.zzczx = zzabs;
        }
    }

    public final zzabq zzex(long j) {
        if (!this.zzczu) {
            return null;
        }
        return new zzabq(j, (String) null, (zzabq) null);
    }

    public final void zzh(String str, String str2) {
        zzabi zzwt;
        if (this.zzczu && !TextUtils.isEmpty(str2) && (zzwt = zzp.zzku().zzwt()) != null) {
            synchronized (this.lock) {
                zzabm zzcq = zzwt.zzcq(str);
                Map<String, String> map = this.zzczw;
                map.put(str, zzcq.zzg(map.get(str), str2));
            }
        }
    }

    public final zzabv zzrw() {
        zzabv zzabv;
        boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.lock) {
            for (zzabq next : this.zzczv) {
                long time = next.getTime();
                String zzru = next.zzru();
                zzabq zzrv = next.zzrv();
                if (zzrv != null && time > 0) {
                    sb.append(zzru);
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    sb.append(time - zzrv.getTime());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzrv.getTime()))) {
                            hashMap.put(Long.valueOf(zzrv.getTime()), new StringBuilder(zzru));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzrv.getTime()));
                            sb2.append('+');
                            sb2.append(zzru);
                        }
                    }
                }
            }
            this.zzczv.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append(FilenameUtils.EXTENSION_SEPARATOR);
                    sb3.append(zzp.zzkx().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzp.zzkx().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzabv = new zzabv(sb.toString(), str);
        }
        return zzabv;
    }

    @VisibleForTesting
    public final Map<String, String> zzrx() {
        synchronized (this.lock) {
            zzabi zzwt = zzp.zzku().zzwt();
            if (zzwt != null) {
                if (this.zzczx != null) {
                    Map<String, String> zza = zzwt.zza(this.zzczw, this.zzczx.zzrx());
                    return zza;
                }
            }
            Map<String, String> map = this.zzczw;
            return map;
        }
    }
}
