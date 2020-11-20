package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdvq {
    private final String className;
    private final zzdvp zzhta;
    private zzdvp zzhtb;
    private boolean zzhtc;

    private zzdvq(String str) {
        this.zzhta = new zzdvp();
        this.zzhtb = this.zzhta;
        this.zzhtc = false;
        this.className = (String) zzdvv.checkNotNull(str);
    }

    public final String toString() {
        String str = "";
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdvp zzdvp = this.zzhta;
        while (true) {
            zzdvp = zzdvp.zzhsz;
            if (zzdvp != null) {
                Object obj = zzdvp.value;
                sb.append(str);
                str = ", ";
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append(deepToString, 1, deepToString.length() - 1);
                }
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }

    public final zzdvq zzz(@NullableDecl Object obj) {
        zzdvp zzdvp = new zzdvp();
        this.zzhtb.zzhsz = zzdvp;
        this.zzhtb = zzdvp;
        zzdvp.value = obj;
        return this;
    }
}
