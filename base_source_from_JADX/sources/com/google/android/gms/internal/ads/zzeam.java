package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefr;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzeam<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Class<P> zzhyj;
    private ConcurrentMap<String, List<zzeal<P>>> zzhyu = new ConcurrentHashMap();
    private zzeal<P> zzhyv;

    private zzeam(Class<P> cls) {
        this.zzhyj = cls;
    }

    public static <P> zzeam<P> zza(Class<P> cls) {
        return new zzeam<>(cls);
    }

    public final zzeal<P> zza(P p, zzefr.zza zza) {
        byte[] bArr;
        byte b;
        ByteBuffer byteBuffer;
        if (zza.zzbab() == zzefl.ENABLED) {
            switch (zzdzy.zzhyg[zza.zzbac().ordinal()]) {
                case 1:
                case 2:
                    byteBuffer = ByteBuffer.allocate(5);
                    b = 0;
                    break;
                case 3:
                    byteBuffer = ByteBuffer.allocate(5);
                    b = 1;
                    break;
                case 4:
                    bArr = zzdzv.zzhyf;
                    break;
                default:
                    throw new GeneralSecurityException("unknown output prefix type");
            }
            bArr = byteBuffer.put(b).putInt(zza.zzbdy()).array();
            zzeal zzeal = new zzeal(p, bArr, zza.zzbab(), zza.zzbac(), zza.zzbdy());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzeal);
            String str = new String(zzeal.zzbad(), UTF_8);
            List list = (List) this.zzhyu.put(str, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzeal);
                this.zzhyu.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzeal;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final void zza(zzeal<P> zzeal) {
        if (zzeal == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzeal.zzbab() == zzefl.ENABLED) {
            List list = (List) this.zzhyu.get(new String(zzeal.zzbad(), UTF_8));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzhyv = zzeal;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final Class<P> zzazr() {
        return this.zzhyj;
    }

    public final zzeal<P> zzbae() {
        return this.zzhyv;
    }
}
