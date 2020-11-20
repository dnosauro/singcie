package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

public final class zzdvl {
    private final String separator;

    private zzdvl(String str) {
        this.separator = (String) zzdvv.checkNotNull(str);
    }

    public static zzdvl zzhe(String str) {
        return new zzdvl(str);
    }

    private static CharSequence zzx(Object obj) {
        zzdvv.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterator<?> it) {
        try {
            zzdvv.checkNotNull(sb);
            if (it.hasNext()) {
                CharSequence zzx = zzx(it.next());
                while (true) {
                    sb.append(zzx);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(this.separator);
                    zzx = zzx(it.next());
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
