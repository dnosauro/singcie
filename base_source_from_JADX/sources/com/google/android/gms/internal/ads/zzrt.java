package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import org.apache.commons.p172io.IOUtils;

public final class zzrt {
    private final int zzbts;
    private final int zzbtt;
    private final int zzbtu;
    private final zzrq zzbtv = new zzrx();

    public zzrt(int i) {
        this.zzbtt = i;
        this.zzbts = 6;
        this.zzbtu = 0;
    }

    @VisibleForTesting
    private final String zzbq(String str) {
        String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        if (split.length == 0) {
            return "";
        }
        zzrv zzrv = new zzrv();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbtt, new zzrs(this));
        for (String zze : split) {
            String[] zze2 = zzru.zze(zze, false);
            if (zze2.length != 0) {
                zzrz.zza(zze2, this.zzbtt, this.zzbts, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzrv.write(this.zzbtv.zzbp(((zzry) it.next()).zzbtz));
            } catch (IOException e) {
                zzd.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzrv.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            sb.append(((String) obj).toLowerCase(Locale.US));
            sb.append(10);
        }
        return zzbq(sb.toString());
    }
}
